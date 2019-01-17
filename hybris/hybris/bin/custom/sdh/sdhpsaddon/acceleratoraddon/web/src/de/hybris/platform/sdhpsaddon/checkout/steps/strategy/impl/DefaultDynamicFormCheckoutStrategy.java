/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.sdhpsaddon.checkout.steps.strategy.impl;

import de.hybris.platform.acceleratorfacades.order.AcceleratorCheckoutFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.enums.CustomerType;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.sdhpsaddon.checkout.steps.CheckoutStep;
import de.hybris.platform.sdhpsaddon.checkout.steps.FormCheckoutStep;
import de.hybris.platform.sdhpsaddon.checkout.steps.strategy.DynamicFormCheckoutStrategy;
import de.hybris.platform.sdhpsaddon.constants.PublicsectoracceleratoraddonWebConstants;
import de.hybris.platform.sdhpsaddon.controllers.pages.checkout.steps.AbstractCheckoutStepController;
import de.hybris.platform.sdhpsaddon.controllers.pages.checkout.steps.AbstractCheckoutStepController.CheckoutSteps;
import de.hybris.platform.publicsectorfacades.product.PSProductFacade;
import de.hybris.platform.publicsectorfacades.strategies.PSYFormsStrategy;
import de.hybris.platform.relationshipfacades.permission.PSPermissionFacade;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.xyformscommercefacades.form.XYFormFacade;
import de.hybris.platform.xyformscommercefacades.form.data.FormDetailData;
import de.hybris.platform.xyformscommercefacades.strategies.YFormsStrategy;
import de.hybris.platform.xyformscommercefacades.strategies.impl.DefaultYFormDataPreprocessorStrategy;
import de.hybris.platform.xyformscommercefacades.util.YFormsHelper;
import de.hybris.platform.xyformscommerceservices.helpers.YFormXmlParser;
import de.hybris.platform.xyformscommerceservices.strategies.YFormUserStrategy;
import de.hybris.platform.xyformsfacades.data.YFormDataData;
import de.hybris.platform.xyformsfacades.data.YFormDefinitionData;
import de.hybris.platform.xyformsfacades.form.YFormFacade;
import de.hybris.platform.xyformsfacades.strategy.preprocessor.EmptyYFormPreprocessorStrategy;
import de.hybris.platform.xyformsfacades.strategy.preprocessor.ReferenceIdTransformerYFormPreprocessorStrategy;
import de.hybris.platform.xyformsfacades.strategy.preprocessor.YFormPreprocessorStrategy;
import de.hybris.platform.xyformsservices.enums.YFormDataActionEnum;
import de.hybris.platform.xyformsservices.exception.YFormServiceException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;


/**
 * DefaultDynamicFormCheckoutStrategy. <br/>
 * This is use to define the checkout progress bar for all checkout steps, forms for display for the form page and also
 * the dynamic form pages for the given cart.
 */
public class DefaultDynamicFormCheckoutStrategy implements DynamicFormCheckoutStrategy
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultDynamicFormCheckoutStrategy.class);
	protected static final String REGEX_PATTERN_PREFIX = ".*/";
	protected static final String PERMISSIBLE_ITEM_TYPE_ADDRESS = "Address";

	private String baseFormUrl;
	private AcceleratorCheckoutFacade checkoutFacade;
	private YFormFacade yFormFacade;
	private EmptyYFormPreprocessorStrategy emptyYFormPreprocessorStrategy;
	private DefaultYFormDataPreprocessorStrategy referenceIdTransformerYFormPreprocessorStrategy;
	private YFormsStrategy yFormsStrategy;
	private PSYFormsStrategy psYFormsStrategy;
	private YFormsHelper yFormsHelper;
	private PSProductFacade psProductFacade;
	private YFormXmlParser yFormXmlParser;
	private UserService userService;
	private CustomerAccountService customerAccountService;
	private ConfigurationService configurationService;
	private YFormUserStrategy userStrategy;
	private XYFormFacade xyFormFacade;
	private PSRelationshipFacade psRelationshipFacade;
	private PSPermissionFacade psPermissionFacade;

	/**
	 * Create dynamic form progress checkout steps based on the cart entries. <br/>
	 * Depends on the content of the cart, dynamically create the form steps and defined the navigation between the
	 * forms. <br/>
	 * Number of the form pages to display for checkout is defined by the DynamicFormCheckoutStrategy, where the
	 * formPageId is also representing the progressBarId. The corresponding labels should be created base on them.
	 *
	 * @param formCheckoutStepPlaceholder
	 */
	@Override
	public List<CheckoutStep> createDynamicFormSteps(final CheckoutStep formCheckoutStepPlaceholder)
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		List<CheckoutStep> newSteps = new ArrayList<>();
		final CheckoutStep previous = null;
		final List<ProductData> serviceProducts = new ArrayList<>();
		final List<ProductData> serviceAddOns = new ArrayList<>();
		final Map<ProductData, List<YFormDefinitionData>> formPageIdMap = getFormPageIdList(cartData);

		for (final Map.Entry<ProductData, List<YFormDefinitionData>> entry : formPageIdMap.entrySet())
		{
			final ProductData productData = entry.getKey();

			if (getPsProductFacade().isServiceProduct(productData.getCode()))
			{
				serviceProducts.add(productData);
			}
			else
			{
				serviceAddOns.add(productData);
			}
		}

		//create new steps for service product first
		newSteps = createNewSteps(serviceProducts, newSteps, formPageIdMap, formCheckoutStepPlaceholder, previous);

		// add steps for service addons
		if (!CollectionUtils.isEmpty(newSteps))
		{
			newSteps = createNewSteps(serviceAddOns, newSteps, formPageIdMap, formCheckoutStepPlaceholder,
					newSteps.get(newSteps.size() - 1));

			final CheckoutStep firstStep = newSteps.get(0);
			final CheckoutStep lastStep = newSteps.get(newSteps.size() - 1);
			firstStep.getTransitions().put(CheckoutStep.PREVIOUS, formCheckoutStepPlaceholder.previousStep());
			lastStep.getTransitions().put(CheckoutStep.NEXT, formCheckoutStepPlaceholder.nextStep());
		}
		return newSteps;
	}

	/**
	 * Creates new steps for products.
	 *
	 * @param products
	 * @param newSteps
	 * @param formPageIdMap
	 * @param formCheckoutStepPlaceholder
	 * @param previous
	 * @return
	 */
	protected List<CheckoutStep> createNewSteps(final List<ProductData> products, final List<CheckoutStep> newSteps,
			final Map<ProductData, List<YFormDefinitionData>> formPageIdMap, final CheckoutStep formCheckoutStepPlaceholder,
			final CheckoutStep previous)
	{
		CheckoutStep previousStep = previous;
		for (final ProductData productData : products)
		{
			int formPageId = 1;
			for (final YFormDefinitionData yFormDefinitionData : formPageIdMap.get(productData))
			{
				final String checkoutStepTitle = getCheckoutStepTitle(yFormDefinitionData);
				final FormCheckoutStep newStep = createNewCheckoutStep(formCheckoutStepPlaceholder, previousStep,
						Integer.toString(formPageId), checkoutStepTitle, productData.getCode());
				previousStep = newStep;
				newSteps.add(newStep);
				formPageId++;
			}
		}
		return newSteps;
	}

	protected FormCheckoutStep createNewCheckoutStep(final CheckoutStep formCheckoutStepPlaceholder, final CheckoutStep previous,
			final String formPageId, final String progressBarId, final String productCode)
	{
		final FormCheckoutStep newStep = new FormCheckoutStep();
		newStep.setProgressBarId(progressBarId);
		newStep.setFormPageId(formPageId);
		newStep.setProductCode(productCode);
		newStep.setCheckoutGroup(formCheckoutStepPlaceholder.getCheckoutGroup());
		newStep.setCheckoutStepValidator(formCheckoutStepPlaceholder.getCheckoutStepValidator());

		final Map<String, String> transactions = new HashMap<>();
		transactions.put(CheckoutStep.CURRENT, getBaseFormUrl() + "/" + productCode + "/" + formPageId);

		newStep.setTransitions(transactions);
		if (previous != null)
		{
			transactions.put(CheckoutStep.PREVIOUS, previous.currentStep());
			previous.getTransitions().put(CheckoutStep.NEXT, newStep.currentStep());
		}
		return newStep;
	}

	/**
	 * Combine the Form Checkout Steps to the original Checkout steps for display at the progress bar.
	 *
	 * @param formCheckoutStepPlaceholder
	 * @param originalCheckoutSteps
	 */
	@Override
	public List<AbstractCheckoutStepController.CheckoutSteps> combineFormCheckoutStepProgressBar(
			final CheckoutStep formCheckoutStepPlaceholder,
			final List<AbstractCheckoutStepController.CheckoutSteps> originalCheckoutSteps)
	{
		final List<AbstractCheckoutStepController.CheckoutSteps> combinedCheckoutSteps = new ArrayList<>();

		final List<CheckoutStep> formCheckoutSteps = createDynamicFormSteps(formCheckoutStepPlaceholder);
		int progressKey = 0;
		for (final AbstractCheckoutStepController.CheckoutSteps checkoutStep : originalCheckoutSteps)
		{
			if (formCheckoutStepPlaceholder.getProgressBarId().equals(checkoutStep.getProgressBarId()))
			{
				for (final CheckoutStep formCheckoutStep : formCheckoutSteps)
				{

					combinedCheckoutSteps.add(new CheckoutSteps(formCheckoutStep.getProgressBarId(),
							StringUtils.remove(formCheckoutStep.currentStep(), "redirect:"), Integer.valueOf(progressKey),
							Boolean.TRUE));
					progressKey++;
				}
			}
			else
			{
				combinedCheckoutSteps
						.add(new CheckoutSteps(checkoutStep.getProgressBarId(), checkoutStep.getUrl(), Integer.valueOf(progressKey)));
				progressKey++;
			}
		}
		return combinedCheckoutSteps;
	}

	/**
	 * Get all the Form HTMLs to display on the given formPageId
	 *
	 * @param formPageId
	 */
	@Override
	public List<String> getFormsInlineHtmlByFormPageId(final String formPageId, final String productCode)
	{
		final List<String> formsHtml = new ArrayList<>();
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		final List<FormDetailData> forms = getFormDetailDataByProductCodeAndFormPageId(cartData, formPageId, productCode);
		for (final FormDetailData data : forms)
		{
			String embeddedFormHtml;

			// This strategy does not apply any execute any extra code.
			YFormPreprocessorStrategy strategy;
			YFormDataActionEnum action = YFormDataActionEnum.EDIT;
			String formDataId = null;
			final Map<String, Object> params = new HashMap<>();

			YFormDataData yFormData = null;
			try
			{
				yFormData = getyFormFacade().getYFormData(data.getApplicationId(), data.getFormId(), data.getRefId());
				formDataId = yFormData.getId();
			}
			catch (final YFormServiceException e)
			{
				if (LOG.isDebugEnabled())
				{
					LOG.debug(String.format("YFormException while getting the YFormData for applicationId: %s and refId: %s",
							data.getApplicationId(), data.getRefId()), e);
				}
				action = YFormDataActionEnum.NEW;
				formDataId = getyFormFacade().getNewFormDataId();
			}

			try
			{
				populateAddressComponentFields(params, data.getApplicationId(), data.getFormId());
				strategy = getReferenceIdTransformerYFormPreprocessorStrategy();
				params.put(DefaultYFormDataPreprocessorStrategy.FORM_DETAIL_DATA, data);
				params.put(ReferenceIdTransformerYFormPreprocessorStrategy.REFERENCE_ID, data.getRefId());
				embeddedFormHtml = getyFormFacade().getInlineFormHtml(data.getApplicationId(), data.getFormId(), action, formDataId,
						strategy, params);
			}
			catch (final YFormServiceException | RelationshipDoesNotExistException e)
			{
				embeddedFormHtml = "";
				LOG.error(e.getMessage(), e);
			}
			formsHtml.add(embeddedFormHtml);
		}
		return formsHtml;
	}

	/**
	 * Simulation of different cases of dynamic checkout form pages depends on the entries in the cart.<br/>
	 * If one item then display no forms; Else display a number of form pages up to the defined Maximum.
	 *
	 * @param cartData
	 * @return Map<FormPageId, ProgressBarId> where the FormPageId defines the navigation of the FormPages, i.e. UniqueId
	 *         separating different FormPages, FormPageId will also be used for retrieve the forms. Whereas the
	 *         ProgressBarId is used as OOTB for linking the labels to display for each of the Checkout Pages, i.e. Form
	 *         Page and OOTB checkout pages.
	 */
	@Override
	public Map<ProductData, List<YFormDefinitionData>> getFormPageIdList(final CartData cartData)
	{
		final Map<ProductData, List<YFormDefinitionData>> formPageIds = new LinkedHashMap<>();
		if (cartData != null && CollectionUtils.isNotEmpty(cartData.getEntries()))
		{
			for (final OrderEntryData orderEntryData : cartData.getEntries())
			{
				final List<YFormDefinitionData> yFormDefinitions = getyFormsStrategy()
						.getFormDefinitionsForOrderEntry(orderEntryData);
				if (CollectionUtils.isNotEmpty(yFormDefinitions))
				{
					formPageIds.put(orderEntryData.getProduct(), yFormDefinitions);
				}
			}
		}
		return formPageIds;
	}

	@Override
	public List<FormDetailData> getFormDetailDataByProductCodeAndFormPageId(final CartData cartData, final String formPageId,
			final String productCode)
	{
		final OrderEntryData orderEntryData = getPsYFormsStrategy().getYFormOrderEntryByProduct(cartData, productCode);

		final List<YFormDefinitionData> yFormDefinitions = getyFormsStrategy().getFormDefinitionsForOrderEntry(orderEntryData);

		return getyFormsHelper().createFormDetailData(Arrays.asList(yFormDefinitions.get(Integer.parseInt(formPageId) - 1)),
				cartData.getCode(), orderEntryData.getEntryNumber());
	}

	/**
	 * Getting checkout step title from yForm definitions.
	 *
	 * @param yFormDefinitionData
	 * @return
	 */
	protected String getCheckoutStepTitle(final YFormDefinitionData yFormDefinitionData)
	{
		return StringUtils.isNotEmpty(yFormDefinitionData.getCheckoutStepTitle()) ? yFormDefinitionData.getCheckoutStepTitle()
				: yFormDefinitionData.getFormId();
	}

	/*
	 * Populate address component fields in the yform for current uesr or context user.
	 *
	 * @param params
	 *
	 * @param applicationId
	 *
	 * @param formId
	 *
	 * @throws RelationshipDoesNotExistException
	 */
	protected void populateAddressComponentFields(final Map<String, Object> params, final String applicationId,
			final String formId) throws RelationshipDoesNotExistException
	{
		final CustomerModel customerModel = getUserStrategy().getCurrentUserForCheckout();
		final String currentCustomerUID = getUserService().getCurrentUser().getUid();
		boolean isPermitted = true;

		if (!getUserService().isAnonymousUser(customerModel) && customerModel.getType().equals(CustomerType.REGISTERED)
				&& !currentCustomerUID.equals(customerModel.getUid()))
		{
			isPermitted = getPsPermissionFacade().isPermitted(currentCustomerUID, customerModel.getUid(),
					PERMISSIBLE_ITEM_TYPE_ADDRESS);
		}

		if (!getUserService().isAnonymousUser(customerModel) && customerModel.getType().equals(CustomerType.REGISTERED)
				&& isPermitted)
		{
			final Set<String> xPaths = getyFormXmlParser().getXPathsForYFormDefinition(applicationId, formId);
			setAddressComponentValues(params, customerModel, xPaths);
		}
	}

	private void setAddressComponentValues(final Map<String, Object> params, final CustomerModel customerModel,
			final Set<String> xPaths)
	{
		for (final String xPath : xPaths)
		{
			if (xPath.matches(REGEX_PATTERN_PREFIX + getConfigurationService().getConfiguration()
					.getString(PublicsectoracceleratoraddonWebConstants.IS_ANONYMOUS_USER, "primary-address-is-anonymous-user")))
			{
				params.put(xPath, Boolean.FALSE);
			}
			else if (xPath.matches(REGEX_PATTERN_PREFIX + getConfigurationService().getConfiguration()
					.getString(PublicsectoracceleratoraddonWebConstants.LOGGED_IN_USER, "primary-address-logged-in-user")))
			{
				params.put(xPath, customerModel.getUid());
			}
			else if (xPath.matches(REGEX_PATTERN_PREFIX + getConfigurationService().getConfiguration()
					.getString(PublicsectoracceleratoraddonWebConstants.USE_PRIMARY_ADDRESS, "use-primary-address")))
			{
				params.put(xPath, Boolean.valueOf(getXyFormFacade().getDefaultAddressForUser(customerModel) != null));
			}
			else if (xPath
					.matches(REGEX_PATTERN_PREFIX + getConfigurationService().getConfiguration().getString(
							PublicsectoracceleratoraddonWebConstants.IS_ADDRESS_BOOK_NOT_EMPTY,
							"primary-address-is-address-book-not-empty"))
					&& CollectionUtils.isNotEmpty(getCustomerAccountService().getAddressBookEntries(customerModel)))
			{
				params.put(xPath, Boolean.TRUE);
			}
		}
	}

	protected AcceleratorCheckoutFacade getCheckoutFacade()
	{
		return checkoutFacade;
	}

	@Required
	public void setCheckoutFacade(final AcceleratorCheckoutFacade checkoutFacade)
	{
		this.checkoutFacade = checkoutFacade;
	}

	protected String getBaseFormUrl()
	{
		return baseFormUrl;
	}

	@Required
	public void setBaseFormUrl(final String baseFormUrl)
	{
		this.baseFormUrl = baseFormUrl;
	}

	protected EmptyYFormPreprocessorStrategy getEmptyYFormPreprocessorStrategy()
	{
		return emptyYFormPreprocessorStrategy;
	}

	@Required
	public void setEmptyYFormPreprocessorStrategy(final EmptyYFormPreprocessorStrategy emptyYFormPreprocessorStrategy)
	{
		this.emptyYFormPreprocessorStrategy = emptyYFormPreprocessorStrategy;
	}

	protected DefaultYFormDataPreprocessorStrategy getReferenceIdTransformerYFormPreprocessorStrategy()
	{
		return referenceIdTransformerYFormPreprocessorStrategy;
	}

	@Required
	public void setReferenceIdTransformerYFormPreprocessorStrategy(
			final DefaultYFormDataPreprocessorStrategy referenceIdTransformerYFormPreprocessorStrategy)
	{
		this.referenceIdTransformerYFormPreprocessorStrategy = referenceIdTransformerYFormPreprocessorStrategy;
	}

	protected YFormFacade getyFormFacade()
	{
		return yFormFacade;
	}

	@Required
	public void setyFormFacade(final YFormFacade yFormFacade) // NOSONAR
	{
		this.yFormFacade = yFormFacade;
	}

	protected YFormsStrategy getyFormsStrategy()
	{
		return yFormsStrategy;
	}

	@Required
	public void setyFormsStrategy(final YFormsStrategy yFormsStrategy) // NOSONAR
	{
		this.yFormsStrategy = yFormsStrategy;
	}

	protected YFormsHelper getyFormsHelper()
	{
		return yFormsHelper;
	}

	@Required
	public void setyFormsHelper(final YFormsHelper yFormsHelper) // NOSONAR
	{
		this.yFormsHelper = yFormsHelper;
	}

	protected PSYFormsStrategy getPsYFormsStrategy()
	{
		return psYFormsStrategy;
	}

	@Required
	public void setPsYFormsStrategy(final PSYFormsStrategy psYFormsStrategy)
	{
		this.psYFormsStrategy = psYFormsStrategy;
	}

	protected PSProductFacade getPsProductFacade()
	{
		return psProductFacade;
	}

	@Required
	public void setPsProductFacade(final PSProductFacade psProductFacade)
	{
		this.psProductFacade = psProductFacade;
	}

	protected YFormXmlParser getyFormXmlParser()
	{
		return yFormXmlParser;
	}

	@Required
	public void setyFormXmlParser(final YFormXmlParser yFormXmlParser) // NOSONAR
	{
		this.yFormXmlParser = yFormXmlParser;
	}

	protected UserService getUserService()
	{
		return userService;
	}

	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	protected CustomerAccountService getCustomerAccountService()
	{
		return customerAccountService;
	}

	@Required
	public void setCustomerAccountService(final CustomerAccountService customerAccountService)
	{
		this.customerAccountService = customerAccountService;
	}

	protected ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	@Required
	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	protected YFormUserStrategy getUserStrategy()
	{
		return userStrategy;
	}

	@Required
	public void setUserStrategy(final YFormUserStrategy userStrategy)
	{
		this.userStrategy = userStrategy;
	}

	protected XYFormFacade getXyFormFacade()
	{
		return xyFormFacade;
	}

	@Required
	public void setXyFormFacade(final XYFormFacade xyFormFacade)
	{
		this.xyFormFacade = xyFormFacade;
	}

	protected PSRelationshipFacade getPsRelationshipFacade()
	{
		return psRelationshipFacade;
	}

	@Required
	public void setPsRelationshipFacade(final PSRelationshipFacade psRelationshipFacade)
	{
		this.psRelationshipFacade = psRelationshipFacade;
	}

	protected PSPermissionFacade getPsPermissionFacade()
	{
		return psPermissionFacade;
	}

	@Required
	public void setPsPermissionFacade(final PSPermissionFacade psPermissionFacade)
	{
		this.psPermissionFacade = psPermissionFacade;
	}

}

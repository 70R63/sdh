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
package de.hybris.platform.sdhpsaddon.controllers.pages.checkout.steps;

import de.hybris.platform.acceleratorservices.enums.CheckoutPciOptionEnum;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessage;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.PlaceOrderForm;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.order.InvalidCartException;
import de.hybris.platform.sdhpsaddon.annotations.PreValidateCheckoutStep;
import de.hybris.platform.sdhpsaddon.checkout.steps.CheckoutStep;
import de.hybris.platform.sdhpsaddon.checkout.steps.FormCheckoutStep;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.sdhpsaddon.security.PSOpenRedirectValidator;
import de.hybris.platform.publicsectorfacades.customer.PSCustomerFacade;
import de.hybris.platform.publicsectorfacades.order.PSCheckoutFacade;
import de.hybris.platform.publicsectorfacades.product.PSProductFacade;
import de.hybris.platform.relationshipfacades.permission.PSPermissionFacade;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;
import de.hybris.platform.xyformscommercefacades.form.XYFormFacade;
import de.hybris.platform.xyformscommerceservices.strategies.YFormUserStrategy;
import de.hybris.platform.xyformsservices.enums.YFormDataActionEnum;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * FormCheckoutStepController for capture the information required by xform.
 */

@Controller
@RequestMapping(value = "/checkout/multi/form")
public class FormCheckoutStepController extends AbstractCheckoutStepController
{
	private static final Logger LOG = LoggerFactory.getLogger(FormCheckoutStepController.class);
	private static final String FORM = "form";
	private static final String DRAFT_CONFIRMATION_PAGE = "draftConfirmationPage";

	protected static final String EMBEDDED_FORM_HTMLS = "embeddedFormHtmls";
	protected static final String PERMISSIBLE_ITEM_TYPE_ADDRESS = "Address";
	protected static final YFormDataActionEnum YFORM_ACTION = YFormDataActionEnum.EDIT;

	@Resource(name = "psProductFacade")
	private PSProductFacade psProductFacade;

	@Resource(name = "psCustomerFacade")
	private PSCustomerFacade psCustomerFacade;

	@Resource(name = "psCheckoutFacade")
	private PSCheckoutFacade psCheckoutFacade;

	@Resource(name = "yFormUserStrategy")
	private YFormUserStrategy userStrategy;

	@Resource(name = "psRelationshipfacade")
	private PSRelationshipFacade psRelationshipFacade;

	@Resource(name = "xyFormFacade")
	private XYFormFacade xyFormFacade;

	@Resource(name = "psPermissionFacade")
	private PSPermissionFacade psPermissionFacade;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/b2c")
	public String enterStep(final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		initialSetup(model);
		return ControllerConstants.Views.Pages.MultiStepCheckout.GetFormPage;
	}

	@RequestMapping(method = RequestMethod.GET)
	@PreValidateCheckoutStep(checkoutStep = FORM)
	public String enterStep(final Model model, final RedirectAttributes redirectAttributes, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		populateGlobalMessages(model, redirectAttributes);

		initialSetup(model);
		psCheckoutFacade.removePaymentInfoIfNotNeeded();
		psCheckoutFacade.removeDeliveryInfoIfNotNeeded();
		psCheckoutFacade.recalculateCart();
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		model.addAttribute("cartData", cartData);

		return setupNavigation(request);
	}

	/**
	 * Enter step of the form with defined form title.
	 */
	@RequestMapping(value = "/{productCode}/{formPageId}", method = RequestMethod.GET)
	public String enterStepForForm(final Model model, @PathVariable final String formPageId,
			@PathVariable final String productCode, final RedirectAttributes redirectAttributes, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		if (!getCheckoutFlowFacade().hasValidCart())
		{
			LOG.info("Missing, empty or unsupported cart");
			return REDIRECT_URL_CART;
		}

		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		final OrderEntryData serviceProductOrderEntry = getPsYFormsStrategy().getYFormOrderEntryByProduct(cartData, productCode);
		if (serviceProductOrderEntry != null)
		{
			final ProductData productData = serviceProductOrderEntry.getProduct();
			model.addAttribute("productName", productData.getName());

			if (getSessionService().getAttribute("redirectionParam") == null && getUserFacade().isAnonymousUser()
					&& !getPsProductFacade().isUnidentifiedUserInService(productData.getCode()))
			{
				return REDIRECT_PREFIX + "/login/checkout";
			}

			// Added this just to set up proper user in the checkout as the anonymous was not allowed.
			if (getUserFacade().isAnonymousUser() && getPsProductFacade().isUnidentifiedUserInService(productData.getCode()))
			{
				processUnidentifiedCheckoutUserRequest(model);
			}

			initialSetup(model);

			final List<CheckoutStep> formCheckoutSteps = getDynamicFormCheckoutStrategy()
					.createDynamicFormSteps(getFormPlaceholder());
			setCurrentCheckoutStepToModel(model, formPageId, formCheckoutSteps, productCode);

			final List<CheckoutSteps> steps = getCheckoutSteps();
			if (CollectionUtils.size(steps) > formCheckoutSteps.size())
			{
				return ControllerConstants.Views.Pages.MultiStepCheckout.GetMultiStepFormPage;
			}
			else
			{
				// Only request the security code if the SubscriptionPciOption is set to Default.
				final boolean requestSecurityCode = CheckoutPciOptionEnum.DEFAULT
						.equals(getCheckoutFlowFacade().getSubscriptionPciOption());
				model.addAttribute("requestSecurityCode", Boolean.valueOf(requestSecurityCode));
				model.addAttribute(new PlaceOrderForm());
			}
			return ControllerConstants.Views.Pages.MultiStepCheckout.GetFormPage;
		}
		GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
				"something.went.wrong.error.message", null);
		return REDIRECT_PREFIX + "/";
	}


	@RequestMapping(value = "/usePrimaryAddress", method = RequestMethod.GET)
	public String getPrimaryAddressJson(final Model model) throws RelationshipDoesNotExistException
	{
		final CustomerModel customerModel = userStrategy.getCurrentUserForCheckout();
		final String currentCustomerUID = getUser().getUid();
		boolean isPermitted = true;

		if (!currentCustomerUID.equals(customerModel.getUid()))
		{
			isPermitted = psPermissionFacade.isPermitted(currentCustomerUID, customerModel.getUid(), PERMISSIBLE_ITEM_TYPE_ADDRESS);
		}

		if (!getCheckoutCustomerStrategy().isAnonymousCheckout() && isPermitted)
		{
			final AddressData address = xyFormFacade.getDefaultAddressForUser(customerModel);
			model.addAttribute("isPrimaryAddressAvailable", Boolean.valueOf(address != null));
			if (address != null)
			{
				model.addAttribute("primaryAddress", address);
			}
		}
		else
		{
			model.addAttribute("isPrimaryAddressAvailable", Boolean.FALSE);
		}
		return ControllerConstants.Views.Fragments.Checkout.PrimaryAddress;
	}

	@RequestMapping(value = "/getAddressBook", method = RequestMethod.GET)
	public String getAddressBook(final Model model) throws RelationshipDoesNotExistException
	{
		final CustomerModel customerModel = userStrategy.getCurrentUserForCheckout();
		final String currentCustomerUID = getUser().getUid();
		boolean isPermitted = true;

		if (!currentCustomerUID.equals(customerModel.getUid()))
		{
			isPermitted = psPermissionFacade.isPermitted(currentCustomerUID, customerModel.getUid(), PERMISSIBLE_ITEM_TYPE_ADDRESS);
		}

		if (!getCheckoutCustomerStrategy().isAnonymousCheckout() && isPermitted)
		{
			final List<AddressData> address = psRelationshipFacade.getRelationshipAddressBookByUser(customerModel.getUid());
			model.addAttribute("addresses", address);
		}
		return ControllerConstants.Views.Fragments.Checkout.AddressBook;
	}

	/**
	 * Get current form checkout step from the List<CheckoutStep> and set it's detail to the model.
	 *
	 * @param model
	 * @param formPageId
	 * @param formCheckoutSteps
	 */
	private void setCurrentCheckoutStepToModel(final Model model, final String formPageId,
			final List<CheckoutStep> formCheckoutSteps, final String productCode)
	{
		CheckoutStep currentStep = null;
		for (final CheckoutStep step : formCheckoutSteps)
		{
			if (step instanceof FormCheckoutStep && ((FormCheckoutStep) step).getFormPageId().equals(formPageId)
					&& ((FormCheckoutStep) step).getProductCode().equalsIgnoreCase(productCode))
			{
				currentStep = step;
				break;
			}
		}

		if (currentStep != null)
		{
			model.addAttribute(WebConstants.BREADCRUMBS_KEY,
					getResourceBreadcrumbBuilder().getBreadcrumbs(currentStep.getProgressBarId()));
			setupFormsToModel(model, formPageId, productCode);
			setCheckoutStepLinksForModel(model, currentStep);

			// The cartData must be added into model after the formCheckout steps setup.
			// This is important the formData for the cart entry data populated correctly.
			getCheckoutFacade().getCheckoutCart();
			model.addAttribute("cartData", getCheckoutFacade().getCheckoutCart());
		}
	}

	/**
	 * The original FormCheckoutStep is the placeholder for placing in dynamic form steps. <br/>
	 * If there are no forms in the current cart content, the form step will be skipped by redirect to defined PREVIOUS
	 * step if it is accessed from the NEXT step; and it will skipped to NEXT step if it is access from any other pages.
	 * If there are forms, the first and the last form will be setup with correct navigation checkout steps; And it will
	 * navigate to the first step or the last step of the form depends on the entering page.
	 */
	protected String setupNavigation(final HttpServletRequest request)
	{
		final List<CheckoutStep> dynamicFormProgressSteps = getDynamicFormCheckoutStrategy()
				.createDynamicFormSteps(getFormPlaceholder());

		String refererURL = "";
		if (PSOpenRedirectValidator.isValidDomain(request))
		{
			refererURL = request.getHeader("referer");
		}
		if (refererURL.contains(StringUtils.remove(getCheckoutStep().nextStep(), "redirect:")))
		{
			// If the entrance of the page is from the NEXT checkout step - Display the last page or redirect to PREVIOUS
			if (CollectionUtils.isNotEmpty(dynamicFormProgressSteps))
			{
				final CheckoutStep lastStep = dynamicFormProgressSteps.get(dynamicFormProgressSteps.size() - 1);
				return lastStep.currentStep();
			}
			return getCheckoutStep().previousStep();
		}
		else
		{
			// If the entrance of the page is from the Other step - Display the first page or redirect to NEXT
			if (CollectionUtils.isNotEmpty(dynamicFormProgressSteps))
			{
				final CheckoutStep firstStep = dynamicFormProgressSteps.get(0);
				firstStep.getTransitions().put(CheckoutStep.PREVIOUS, getCheckoutStep().previousStep());
				return firstStep.currentStep();
			}
			else
			{
				return getCheckoutStep().nextStep();
			}
		}
	}

	protected void populateGlobalMessages(final Model model, final RedirectAttributes redirectAttributes)
	{
		populateGlobalMessage(model, redirectAttributes, GlobalMessages.INFO_MESSAGES_HOLDER);
		populateGlobalMessage(model, redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER);
		populateGlobalMessage(model, redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER);
	}

	protected void populateGlobalMessage(final Model model, final RedirectAttributes redirectAttributes,
			final String messageHolderType)
	{
		if (model != null && redirectAttributes != null && model.containsAttribute(messageHolderType))
		{
			final Object obj = model.asMap().get(messageHolderType);
			if (obj instanceof List && CollectionUtils.isNotEmpty((List) obj))
			{
				final Object o = ((List) obj).get(0);
				if (o instanceof GlobalMessage && ((GlobalMessage) o).getCode() != null)
				{
					final Collection attributes = ((GlobalMessage) o).getAttributes();
					GlobalMessages.addFlashMessage(redirectAttributes, messageHolderType, ((GlobalMessage) o).getCode(),
							attributes != null ? attributes.toArray() : Collections.emptyList().toArray());
				}
			}
		}
	}

	protected void initialSetup(final Model model) throws CMSItemNotFoundException
	{
		this.prepareDataForPage(model);
		storeCmsPageInModel(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		model.addAttribute("metaRobots", "noindex,nofollow");
	}

	/**
	 * Setup form onto the view model from the information extracted from the product.
	 */
	protected void setupFormsToModel(final Model model, final String formPageId, final String productCode)
	{
		final List<String> formsHtml = getDynamicFormCheckoutStrategy().getFormsInlineHtmlByFormPageId(formPageId, productCode);
		model.addAttribute(EMBEDDED_FORM_HTMLS, formsHtml);
	}

	@RequestMapping(value = "/submit-form", method = RequestMethod.GET)
	@RequireHardLogIn
	public String doSubmitForm()
	{
		return getCheckoutStep().nextStep();
	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	public String back(final RedirectAttributes redirectAttributes)
	{
		return getCheckoutStep().previousStep();
	}

	@RequestMapping(value = "/next", method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	public String next(final RedirectAttributes redirectAttributes)
	{
		return getCheckoutStep().nextStep();
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	@RequireHardLogIn
	public String saveDraft(final Model model, final RedirectAttributes redirectAttributes, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		String redirectUrl = "";
		final String refererURL = request.getHeader("referer");
		final String contextPath = request.getContextPath();
		if (PSOpenRedirectValidator.isValidDomain(request))
		{
			redirectUrl = REDIRECT_PREFIX + StringUtils.substringAfter(refererURL, contextPath);
		}
		getPsCartFacade().setDraftCartDetails(redirectUrl);

		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		final CustomerData currentCustomer = getUser();
		final CustomerData userInContext = getCheckoutFacade().getCheckoutCart().getUserInContext();
		final Boolean isCurrentCustomerSameAsUserInContext = userInContext == null
				|| currentCustomer.getUid().equals(userInContext.getUid());

		model.addAttribute("draftCode", cartData.getCode());
		model.addAttribute("product", getPsYFormsStrategy().getYFormOrderEntry(cartData).getProduct());
		model.addAttribute("userInContext", getCheckoutFacade().getCheckoutCart().getUserInContext());
		model.addAttribute("isCurrentCustomerSameAsUserInContext", isCurrentCustomerSameAsUserInContext);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DRAFT_CONFIRMATION_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DRAFT_CONFIRMATION_PAGE));
		return getViewForPage(model);
	}

	protected CheckoutStep getCheckoutStep()
	{
		return getCheckoutStep(FORM);
	}

	@RequestMapping(value = "/placeOrder")
	public String placeOrder(@ModelAttribute("placeOrderForm") final PlaceOrderForm placeOrderForm, final Model model,
			final HttpServletRequest request, final RedirectAttributes redirectModel)
			throws InvalidCartException, CommerceCartModificationException
	{
		if (validateOrderForm(placeOrderForm, redirectModel))
		{
			return REDIRECT_URL_FORM_PAGE;
		}

		final OrderData orderData;
		try
		{
			orderData = getCheckoutFacade().placeOrder();
		}
		catch (final InvalidCartException e)
		{
			LOG.error("Failed to place Order", e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER, "checkout.placeOrder.failed");
			return REDIRECT_URL_FORM_PAGE;
		}

		return redirectToOrderConfirmationPage(orderData);
	}

	@Override
	protected String redirectToOrderConfirmationPage(final OrderData orderData)
	{
		return REDIRECT_URL_ORDER_CONFIRMATION + (getCheckoutCustomerStrategy().isAnonymousCheckout()
				? urlEncode(orderData.getGuid()) : urlEncode(orderData.getCode()));
	}

	/**
	 * Validates the order form before to filter out invalid order states
	 *
	 * @param placeOrderForm
	 *           The spring form of the order being submitted
	 * @param redirectModel
	 *           RedirectAttributes
	 * @return True if the order form is invalid and false if everything is valid.
	 */
	protected boolean validateOrderForm(final PlaceOrderForm placeOrderForm, final RedirectAttributes redirectModel)
	{
		final String securityCode = placeOrderForm.getSecurityCode();
		boolean invalid = false;

		if (CheckoutPciOptionEnum.DEFAULT.equals(getCheckoutFlowFacade().getSubscriptionPciOption())
				&& StringUtils.isBlank(securityCode))
		{
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER,
					"checkout.paymentMethod.noSecurityCode");
			invalid = true;
		}

		final CartData cartData = getCheckoutFacade().getCheckoutCart();

		if (!getCheckoutFacade().containsTaxValues())
		{
			LOG.error(String.format(
					"Cart %s does not have any tax values, which means the tax cacluation was not properly done, placement of order can't continue",
					cartData.getCode()));
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER, "checkout.error.tax.missing");
			invalid = true;
		}

		if (!cartData.isCalculated())
		{
			LOG.error(
					String.format("Cart %s has a calculated flag of FALSE, placement of order can't continue", cartData.getCode()));
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER, "checkout.error.cart.notcalculated");
			invalid = true;
		}
		return invalid;
	}

	/**
	 * Unidentified checkout process.
	 *
	 * Creates a new unidentified customer and updates the session cart with this user.
	 *
	 * @throws de.hybris.platform.cms2.exceptions.CMSItemNotFoundException
	 */
	protected void processUnidentifiedCheckoutUserRequest(final Model model) throws CMSItemNotFoundException
	{
		try
		{
			getPsCustomerFacade().createUnidentifiedUserForAnonymousCheckout(
					getMessageSource().getMessage("text.unidentified.customer", null, getI18nService().getCurrentLocale()));
			getSessionService().setAttribute(WebConstants.ANONYMOUS_CHECKOUT, Boolean.TRUE);
		}
		catch (final DuplicateUidException e)
		{
			LOG.warn("unidentified user registration failed: {}", e);
			GlobalMessages.addErrorMessage(model, "form.global.error");
		}
	}

	@Override
	protected PSProductFacade getPsProductFacade()
	{
		return psProductFacade;
	}

	protected PSCustomerFacade getPsCustomerFacade()
	{
		return psCustomerFacade;
	}
}

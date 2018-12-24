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
package de.hybris.platform.publicsectoracceleratoraddon.controllers.pages.checkout.steps;

import de.hybris.platform.acceleratorfacades.payment.PaymentFacade;
import de.hybris.platform.acceleratorservices.customer.CustomerLocationService;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.impl.ContentPageBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractCheckoutController;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.AddressValidator;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.PaymentDetailsValidator;
import de.hybris.platform.acceleratorstorefrontcommons.forms.verification.AddressVerificationResultHandler;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.TitleData;
import de.hybris.platform.configurablebundlefacades.data.BundleTemplateData;
import de.hybris.platform.configurablebundleservices.bundle.BundleTemplateService;
import de.hybris.platform.order.CartService;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.CheckoutGroup;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.CheckoutStep;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.strategy.DynamicFormCheckoutStrategy;
import de.hybris.platform.publicsectorfacades.bundle.selection.BundleSelectionFacade;
import de.hybris.platform.publicsectorfacades.order.PSCartFacade;
import de.hybris.platform.publicsectorfacades.product.PSProductFacade;
import de.hybris.platform.publicsectorfacades.strategies.PSYFormsStrategy;
import de.hybris.platform.publicsectorservices.model.PSServiceProductModel;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


public abstract class AbstractCheckoutStepController extends AbstractCheckoutController implements CheckoutStepController
{
	protected static final String MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL = "multiStepCheckoutSummary";
	protected static final String REDIRECT_URL_ADD_DELIVERY_ADDRESS = REDIRECT_PREFIX + "/checkout/multi/delivery-address/add";
	protected static final String REDIRECT_URL_CHOOSE_DELIVERY_METHOD = REDIRECT_PREFIX + "/checkout/multi/delivery-method/choose";
	protected static final String REDIRECT_URL_ADD_PAYMENT_METHOD = REDIRECT_PREFIX + "/checkout/multi/payment-method/add";
	protected static final String REDIRECT_URL_FORM_PAGE = REDIRECT_PREFIX + "/checkout/multi/form";
	protected static final String REDIRECT_URL_BUNDLE_SELECTION_PAGE = REDIRECT_PREFIX + "/checkout/multi/bundle";
	protected static final String REDIRECT_URL_SUMMARY = REDIRECT_PREFIX + "/checkout/multi/summary/view";
	protected static final String REDIRECT_URL_CART = REDIRECT_PREFIX + "/cart";
	protected static final String REDIRECT_URL_ERROR = REDIRECT_PREFIX + "/checkout/multi/hop/error";

	private static final String DEFAULT_COUNTRY = "publicsector.address.default.country";
	private List<CheckoutSteps> checkoutSteps = null;

	@Resource(name = "paymentDetailsValidator")
	private PaymentDetailsValidator paymentDetailsValidator;

	@Resource(name = "accProductFacade")
	private ProductFacade productFacade;

	@Resource(name = "multiStepCheckoutBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder resourceBreadcrumbBuilder;

	@Resource(name = "paymentFacade")
	private PaymentFacade paymentFacade;

	@Resource(name = "addressValidator")
	private AddressValidator addressValidator;

	@Resource(name = "customerLocationService")
	private CustomerLocationService customerLocationService;

	@Resource(name = "psCartFacade")
	private PSCartFacade psCartFacade;

	@Resource(name = "cartFacade")
	private CartFacade cartFacade;

	@Resource(name = "addressVerificationResultHandler")
	private AddressVerificationResultHandler addressVerificationResultHandler;

	@Resource(name = "contentPageBreadcrumbBuilder")
	private ContentPageBreadcrumbBuilder contentPageBreadcrumbBuilder;

	@Resource(name = "publicSectorCheckoutFlowGroupMap")
	private Map<String, CheckoutGroup> checkoutFlowGroupMap;

	@Resource(name = "bundleSelectionFacade")
	private BundleSelectionFacade bundleSelectionFacade;

	@Resource(name = "FORMS_CHECKOUT_STEP_PLACEHOLDER")
	private CheckoutStep formPlaceholder;

	@Resource(name = "dynamicFormCheckoutStrategy")
	private DynamicFormCheckoutStrategy dynamicFormCheckoutStrategy;

	@Resource(name = "productService")
	private ProductService productService;

	@Resource(name = "cartService")
	private CartService cartService;

	@Resource(name = "bundleTemplateService")
	private BundleTemplateService bundleTemplateService;

	@Resource(name = "psYFormsStrategy")
	private PSYFormsStrategy psYFormsStrategy;

	@Resource(name = "psProductFacade")
	private PSProductFacade psProductFacade;

	@Resource(name = "psRelationshipfacade")
	private PSRelationshipFacade psRelationshipFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@ModelAttribute("defaultCountry")
	public String getDefaultCountry()
	{
		return configurationService.getConfiguration().getString(DEFAULT_COUNTRY);
	}

	@ModelAttribute("titles")
	public Collection<TitleData> getTitles()
	{
		return getUserFacade().getTitles();
	}

	@ModelAttribute("countries")
	public Collection<CountryData> getCountries()
	{
		return getCheckoutFacade().getDeliveryCountries();
	}

	@ModelAttribute("productPageURL")
	public String getServiceRequestUrl()
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		if (CollectionUtils.isNotEmpty(cartData.getEntries()))
		{
			final ProductData productData = cartData.getEntries().get(0).getProduct();
			return productData.getUrl();
		}
		return "/";
	}

	@ModelAttribute("countryDataMap")
	public Map<String, CountryData> getCountryDataMap()
	{
		final Map<String, CountryData> countryDataMap = new HashMap<>();
		for (final CountryData countryData : getCountries())
		{
			countryDataMap.put(countryData.getIsocode(), countryData);
		}
		return countryDataMap;
	}

	/**
	 * returns current user in context
	 *
	 * @return CustomerData
	 */
	@ModelAttribute("userInContext")
	public CustomerData getUserInContext()
	{
		return getRelationshipFacade().getUserInContextForCurrentCart();
	}

	/**
	 * returns whether the user in context is same as current user
	 *
	 * @return boolean
	 */
	@ModelAttribute("isContextUserCurrentUser")
	public boolean isContextUserCurrentUser()
	{
		return getRelationshipFacade().getUserInContextForCurrentCart() == null;
	}

	/**
	 * adds the attribute whether the current user has relation with request access
	 *
	 * @return List<PSRelationshipData
	 */
	@ModelAttribute("hasRelationWithRequestAccess")
	public boolean getRelationWithRequestAccess()
	{
		return CollectionUtils.isNotEmpty(getRelationshipFacade().getRelationsForUserAndPermissibleItemType(getUser().getUid(),
				PSServiceProductModel._TYPECODE));
	}

	/**
	 * Create the checkout progress bar to include dynamic form steps.
	 */
	@ModelAttribute("checkoutSteps")
	public List<CheckoutSteps> addCheckoutStepsToModel()
	{
		checkoutSteps = addDynamicSteps(Boolean.TRUE);
		return checkoutSteps;
	}

	/**
	 * Setup the checkout progress bar with flag to specify if to include dynamic steps
	 */
	protected List<CheckoutSteps> addDynamicSteps(final Boolean includeDynamicSteps)
	{
		final CheckoutGroup checkoutGroup = getCheckoutFlowGroupMap().get(getCheckoutFacade().getCheckoutFlowGroupForCheckout());
		final Map<String, CheckoutStep> progressBarMap = checkoutGroup.getCheckoutProgressBar();
		final List<CheckoutSteps> originalCheckoutSteps = new ArrayList<>(progressBarMap.size());

		for (final Map.Entry<String, CheckoutStep> entry : progressBarMap.entrySet())
		{
			final CheckoutStep checkoutStep = entry.getValue();
			if (checkoutStep.isEnabled())
			{
				originalCheckoutSteps.add(new CheckoutSteps(checkoutStep.getProgressBarId(),
						StringUtils.remove(checkoutStep.currentStep(), "redirect:"), Integer.valueOf(entry.getKey())));
			}
		}

		final List<CheckoutSteps> combinedCheckoutSteps = new ArrayList<>();

		if (includeDynamicSteps.booleanValue())
		{
			combinedCheckoutSteps.addAll(
					getDynamicFormCheckoutStrategy().combineFormCheckoutStepProgressBar(getFormPlaceholder(), originalCheckoutSteps));
			return combinedCheckoutSteps;
		}
		return originalCheckoutSteps;
	}

	protected void prepareDataForPage(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("isOmsEnabled", Boolean.valueOf(getSiteConfigService().getBoolean("oms.enabled", false)));
		model.addAttribute("supportedCountries", getCartFacade().getDeliveryCountries());
		model.addAttribute("expressCheckoutAllowed", Boolean.valueOf(getCheckoutFacade().isExpressCheckoutAllowedForCart()));
		model.addAttribute("taxEstimationEnabled", Boolean.valueOf(getCheckoutFacade().isTaxEstimationEnabledForCart()));
	}

	protected CheckoutStep getCheckoutStep(final String currentController)
	{
		final CheckoutGroup checkoutGroup = getCheckoutFlowGroupMap().get(getCheckoutFacade().getCheckoutFlowGroupForCheckout());
		return checkoutGroup.getCheckoutStepMap().get(currentController);
	}

	protected void setCheckoutStepLinksForModel(final Model model, final CheckoutStep checkoutStep)
	{
		model.addAttribute("previousStepUrl", StringUtils.remove(checkoutStep.previousStep(), REDIRECT_PREFIX));
		model.addAttribute("nextStepUrl", StringUtils.remove(checkoutStep.nextStep(), REDIRECT_PREFIX));
		model.addAttribute("currentStepUrl", StringUtils.remove(checkoutStep.currentStep(), REDIRECT_PREFIX));
		model.addAttribute("progressBarId", checkoutStep.getProgressBarId());
		final ProductData serviceProduct = getPsProductFacade().getServiceProductFromSessionCart();
		BundleTemplateData bundleData = null;

		if (serviceProduct != null && StringUtils.isNotEmpty(serviceProduct.getCode()))
		{
			bundleData = getBundleSelectionFacade().getBundleTemplateByProductCode(serviceProduct.getCode());
		}

		if (bundleData != null)
		{
			model.addAttribute("bundleCheckoutLabel", bundleData.getCheckoutStepLabel());
		}
	}


	protected Map<String, String> getRequestParameterMap(final HttpServletRequest request)
	{
		final Map<String, String> map = new HashMap<>();

		final Enumeration myEnum = request.getParameterNames();
		while (myEnum.hasMoreElements())
		{
			final String paramName = (String) myEnum.nextElement();
			final String paramValue = request.getParameter(paramName);
			map.put(paramName, paramValue);
		}
		return map;
	}

	public static class CheckoutSteps
	{
		private final String progressBarId;
		private final String url;
		private final Integer stepNumber;
		private final Boolean isDynamic;

		public CheckoutSteps(final String progressBarId, final String url, final Integer stepNumber)
		{
			this.progressBarId = progressBarId;
			this.url = url;
			this.stepNumber = stepNumber;
			this.isDynamic = Boolean.FALSE;
		}

		public CheckoutSteps(final String progressBarId, final String url, final Integer stepNumber, final Boolean isDynamic)
		{
			this.progressBarId = progressBarId;
			this.url = url;
			this.stepNumber = stepNumber;
			this.isDynamic = isDynamic;
		}

		public String getProgressBarId()
		{
			return progressBarId;
		}

		public String getUrl()
		{
			return url;
		}

		public Integer getStepNumber()
		{
			return stepNumber;
		}

		public Boolean getIsDynamic()
		{
			return isDynamic;
		}
	}

	@Override
	protected CartFacade getCartFacade()
	{
		return cartFacade;
	}

	protected PSCartFacade getPsCartFacade()
	{
		return psCartFacade;
	}

	protected ProductFacade getProductFacade()
	{
		return productFacade;
	}

	protected PaymentDetailsValidator getPaymentDetailsValidator()
	{
		return paymentDetailsValidator;
	}

	protected ResourceBreadcrumbBuilder getResourceBreadcrumbBuilder()
	{
		return resourceBreadcrumbBuilder;
	}

	protected PaymentFacade getPaymentFacade()
	{
		return paymentFacade;
	}

	protected AddressValidator getAddressValidator()
	{
		return addressValidator;
	}

	protected CustomerLocationService getCustomerLocationService()
	{
		return customerLocationService;
	}

	protected AddressVerificationResultHandler getAddressVerificationResultHandler()
	{
		return addressVerificationResultHandler;
	}

	public ContentPageBreadcrumbBuilder getContentPageBreadcrumbBuilder()
	{
		return contentPageBreadcrumbBuilder;
	}

	public Map<String, CheckoutGroup> getCheckoutFlowGroupMap()
	{
		return checkoutFlowGroupMap;
	}

	public BundleSelectionFacade getBundleSelectionFacade()
	{
		return bundleSelectionFacade;
	}

	protected CheckoutStep getFormPlaceholder()
	{
		return formPlaceholder;
	}

	public void setFormPlaceholder(final CheckoutStep formPlaceholder)
	{
		this.formPlaceholder = formPlaceholder;
	}

	protected DynamicFormCheckoutStrategy getDynamicFormCheckoutStrategy()
	{
		return dynamicFormCheckoutStrategy;
	}

	public void setDynamicFormCheckoutStrategy(final DynamicFormCheckoutStrategy dynamicFormCheckoutStrategy)
	{
		this.dynamicFormCheckoutStrategy = dynamicFormCheckoutStrategy;
	}

	protected List<CheckoutSteps> getCheckoutSteps()
	{
		return checkoutSteps;
	}

	protected ProductService getProductService()
	{
		return productService;
	}

	protected CartService getCartService()
	{
		return cartService;
	}

	protected BundleTemplateService getBundleTemplateService()
	{
		return bundleTemplateService;
	}

	protected PSYFormsStrategy getPsYFormsStrategy()
	{
		return psYFormsStrategy;
	}

	protected PSProductFacade getPsProductFacade()
	{
		return psProductFacade;
	}

	protected PSRelationshipFacade getRelationshipFacade()
	{
		return psRelationshipFacade;
	}
}

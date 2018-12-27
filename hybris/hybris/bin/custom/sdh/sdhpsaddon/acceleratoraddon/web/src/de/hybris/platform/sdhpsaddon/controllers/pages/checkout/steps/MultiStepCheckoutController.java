/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
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

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.CartRestorationData;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.order.CommerceSaveCartException;
import de.hybris.platform.sdhpsaddon.annotations.PreValidateCheckoutStep;
import de.hybris.platform.sdhpsaddon.checkout.steps.CheckoutStep;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorfacades.order.PSCartFacade;
import de.hybris.platform.relationshipfacades.permission.PSPermissionFacade;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * MultiStepCheckoutController
 */
@Controller
@RequestMapping(value = "/checkout/multi")
public class MultiStepCheckoutController extends AbstractCheckoutStepController
{
	private static final Logger LOG = LoggerFactory.getLogger(MultiStepCheckoutController.class);
	private static final String MULTI = "multi";
	private static final String FORM_PAGE_URL = "/checkout/multi/form";

	protected static final String PS_SERVICE_PRODUCT_TYPECODE = "PSServiceProduct";

	@Resource(name = "productVariantFacade")
	private ProductFacade productFacade;

	@Resource(name = "psCartFacade")
	private PSCartFacade cartFacade;

	@Resource(name = "psPermissionFacade")
	private PSPermissionFacade psPermissionFacade;

	@Override
	@RequestMapping(method = RequestMethod.GET)
	@PreValidateCheckoutStep(checkoutStep = MULTI)
	public String enterStep(final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		return getCheckoutStep().nextStep();
	}

	@RequestMapping(value = "/draft", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@RequireHardLogIn
	public String retrieveDraftToSessionCart(@RequestParam(value = "draftCode", required = true) final String draftCode,
			final RedirectAttributes redirectModel)
	{
		try
		{
			final CartData cartData = cartFacade.restoreCart(draftCode);

			return updateCartAndLockOnDraft(draftCode, redirectModel, cartData);
		}
		catch (final CommerceSaveCartException e)
		{
			LOG.error(e.getMessage(), e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"save.cart.failed.exception.message");
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/relationship/draft", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@RequireHardLogIn
	public String retrieveRelationshipDraftToSessionCart(
			@RequestParam(value = "draftCode", required = true) final String draftCode,
			@RequestParam(value = "customerEmail", required = true) final String customerEmail,
			final RedirectAttributes redirectModel)
	{
		CartData cartData;
		try
		{
			if (customerEmail != null && psPermissionFacade.isPermitted(getCustomerFacade().getCurrentCustomerUid(), customerEmail,
					PS_SERVICE_PRODUCT_TYPECODE))
			{
				cartData = cartFacade.getCartForCodeAndUser(draftCode, customerEmail);
				if (cartData != null)
				{
					cartData = cartFacade.setCurrentUserOwnerForRelationshipCart();
					return updateCartAndLockOnDraft(draftCode, redirectModel, cartData);
				}
				return getCheckoutStep().nextStep();
			}
			else
			{
				LOG.error("Failed to retrieve draft " + draftCode + ". " + getCustomerFacade().getCurrentCustomerUid()
						+ " does not have drafts permission for " + customerEmail);
			}
		}
		catch (final CommerceSaveCartException e)
		{
			LOG.error(e.getMessage(), e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"save.cart.failed.exception.message");
		}
		catch (final RelationshipDoesNotExistException e)
		{
			LOG.error("Failed to retrieve draft " + draftCode + ". " + getCustomerFacade().getCurrentCustomerUid()
					+ " does not have drafts permission for " + customerEmail, e);
		}
		return REDIRECT_PREFIX + "/";
	}

	/**
	 * Updates the cart with return url and update the lock on the given draft code
	 *
	 * @param draftCode
	 * @param redirectModel
	 * @param cartData
	 * @return String
	 */
	private String updateCartAndLockOnDraft(final String draftCode, final RedirectAttributes redirectModel,
			final CartData cartData)
	{
		if (cartData.getReturnURL() != null)
		{
			final String redirectURL = getRedirectURLForDraft(cartData.getReturnURL());
			if (cartFacade.isYFormVersionUpdatedForCart())
			{
				cartFacade.updateCartOnYFormVersionUpdate();
				cartFacade.setLockOnDraft();
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER,
						"checkout.multi.yform.version.changed.info");
			}
			else if (cartFacade.isCustomerProfileUpdatedAfterDraftSaved() && StringUtils.isNotBlank(redirectURL))
			{
				cartFacade.updateReturnURLAndLastAccessTimeInCartForCurrentUser(draftCode, redirectURL);
				cartFacade.setLockOnDraft();
				return redirectURL;
			}
			else
			{
				cartFacade.updateLastAccessTimeInCartForCurrentUser(draftCode);
				cartFacade.setLockOnDraft();
				return cartData.getReturnURL();
			}
		}
		return getCheckoutStep().nextStep();
	}

	/**
	 * Returns redirect URL if draft return URL has passed the first yform checkout step else NULL.
	 *
	 * @param draftReturnURL
	 * @return String
	 */
	private String getRedirectURLForDraft(final String draftReturnURL)
	{
		final List<CheckoutSteps> steps = getCheckoutSteps();
		int returnURLIndex = 0;
		int formURLIndex = 0;
		String redirectURL = null;
		final String modifiedDraftReturnURL = StringUtils.remove(draftReturnURL, REDIRECT_PREFIX);
		for (final CheckoutSteps step : steps)
		{
			if (formURLIndex == 0 && step.getUrl().matches(FORM_PAGE_URL + "/\\d"))
			{
				redirectURL = REDIRECT_PREFIX + step.getUrl();
				formURLIndex = step.getStepNumber().intValue() + 1;
			}
			if (step.getUrl().equals(modifiedDraftReturnURL))
			{
				returnURLIndex = step.getStepNumber().intValue() + 1;
			}
		}
		return returnURLIndex > formURLIndex ? redirectURL : null;
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	@RequireHardLogIn
	public String cancelService()
	{
		final String serviceProductUrl = getPsYFormsStrategy().getYFormOrderEntry(getCheckoutFacade().getCheckoutCart())
				.getProduct().getUrl();
		if (!getPsCartFacade().isCurrentCartSavedDraft())
		{
			getCartService().removeSessionCart();
		}
		return "redirect:/" + serviceProductUrl;
	}

	@RequestMapping(value = "/termsAndConditions")
	@RequireHardLogIn
	public String getTermsAndConditions(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel pageForRequest = getCmsPageService().getPageForLabel("/termsAndConditions");
		storeCmsPageInModel(model, pageForRequest);
		setUpMetaDataForContentPage(model, pageForRequest);
		model.addAttribute(WebConstants.BREADCRUMBS_KEY, getContentPageBreadcrumbBuilder().getBreadcrumbs(pageForRequest));
		return ControllerConstants.Views.Fragments.Checkout.TermsAndConditionsPopup;
	}

	@RequestMapping(value = "/express", method = RequestMethod.GET)
	@RequireHardLogIn
	public String performExpressCheckout(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		if (getSessionService().getAttribute(WebConstants.CART_RESTORATION) != null && CollectionUtils.isNotEmpty(
				((CartRestorationData) getSessionService().getAttribute(WebConstants.CART_RESTORATION)).getModifications()))
		{
			return REDIRECT_URL_CART;
		}

		if (getCheckoutFlowFacade().hasValidCart())
		{
			switch (getCheckoutFacade().performExpressCheckout())
			{
				case SUCCESS:
					return REDIRECT_URL_SUMMARY;

				case ERROR_DELIVERY_ADDRESS:
					GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"checkout.express.error.deliveryAddress");
					return REDIRECT_URL_ADD_DELIVERY_ADDRESS;

				case ERROR_DELIVERY_MODE:
				case ERROR_CHEAPEST_DELIVERY_MODE:
					GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"checkout.express.error.deliveryMode");
					return REDIRECT_URL_CHOOSE_DELIVERY_METHOD;

				case ERROR_PAYMENT_INFO:
					GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"checkout.express.error.paymentInfo");
					return REDIRECT_URL_ADD_PAYMENT_METHOD;

				default:
					GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"checkout.express.error.notAvailable");
			}
		}
		return enterStep(model, redirectModel);
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

	@RequestMapping(value = "/getProductVariantMatrix", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getProductVariantMatrix(@RequestParam("productCode") final String productCode, final Model model)
	{
		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode,
				Arrays.asList(ProductOption.BASIC, ProductOption.CATEGORIES, ProductOption.VARIANT_MATRIX_BASE,
						ProductOption.VARIANT_MATRIX_PRICE, ProductOption.VARIANT_MATRIX_MEDIA, ProductOption.VARIANT_MATRIX_STOCK));

		model.addAttribute("product", productData);

		return ControllerConstants.Views.Fragments.Checkout.ReadOnlyExpandedOrderForm;
	}

	protected CheckoutStep getCheckoutStep()
	{
		return getCheckoutStep(MULTI);
	}
}

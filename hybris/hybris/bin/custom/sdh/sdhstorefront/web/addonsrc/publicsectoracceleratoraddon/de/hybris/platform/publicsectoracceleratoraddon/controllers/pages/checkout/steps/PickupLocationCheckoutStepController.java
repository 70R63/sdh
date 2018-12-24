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
package de.hybris.platform.publicsectoracceleratoraddon.controllers.pages.checkout.steps;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.publicsectoracceleratoraddon.annotations.PreValidateCheckoutStep;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.CheckoutStep;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.validation.ValidationResults;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/checkout/multi/pickup-location")
public class PickupLocationCheckoutStepController extends AbstractCheckoutStepController
{
	private static final String PICKUP_LOCATION = "pickup-location";
	private static final Logger LOG = LoggerFactory.getLogger(PickupLocationCheckoutStepController.class);
	private static final String CART_MODIFICATION_ERROR_MSG = "Error checking cart modification";

	@RequestMapping(value = "/choose", method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	@PreValidateCheckoutStep(checkoutStep = PICKUP_LOCATION)
	public String enterStep(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		// Try to set default delivery mode
		getCheckoutFacade().setDeliveryModeIfAvailable();

		model.addAttribute("cartData", getCheckoutFacade().getCheckoutCart());
		model.addAttribute("pickupConsolidationOptions", getCheckoutFacade().getConsolidatedPickupOptions());
		model.addAttribute("userLocation", getCustomerLocationService().getUserLocation());
		storeCmsPageInModel(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		model.addAttribute(WebConstants.BREADCRUMBS_KEY,
				getResourceBreadcrumbBuilder().getBreadcrumbs("checkout.multi.deliveryMethod.breadcrumb"));
		model.addAttribute("metaRobots", "noindex,nofollow");
		setCheckoutStepLinksForModel(model, getCheckoutStep());

		return ControllerConstants.Views.Pages.MultiStepCheckout.ChoosePickupLocationPage;
	}

	@RequestMapping(value = "/choose", method = RequestMethod.POST)
	@RequireHardLogIn
	public String doSelectDeliveryLocation(@RequestParam(value = "posName") final String posName, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		final ValidationResults validationResults = getCheckoutStep().validate(redirectAttributes);
		if (getCheckoutStep().checkIfValidationErrors(validationResults))
		{
			return getCheckoutStep().onValidation(validationResults);
		}

		//Consolidate the cart and add unsuccessful modifications to page
		List cartModificationList = Collections.emptyList();
		try
		{
			cartModificationList = getCheckoutFacade().consolidateCheckoutCart(posName);
		}
		catch (final CommerceCartModificationException e)
		{
			LOG.error(CART_MODIFICATION_ERROR_MSG, e);
		}
		model.addAttribute("validationData", cartModificationList);
		model.addAttribute("cartData", getCheckoutFacade().getCheckoutCart());
		model.addAttribute("userLocation", getCustomerLocationService().getUserLocation());
		storeCmsPageInModel(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		model.addAttribute(WebConstants.BREADCRUMBS_KEY,
				getResourceBreadcrumbBuilder().getBreadcrumbs("checkout.multi.deliveryMethod.breadcrumb"));
		model.addAttribute("metaRobots", "noindex,nofollow");
		setCheckoutStepLinksForModel(model, getCheckoutStep());

		return ControllerConstants.Views.Pages.MultiStepCheckout.ChoosePickupLocationPage;
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

	protected CheckoutStep getCheckoutStep()
	{
		return getCheckoutStep(PICKUP_LOCATION);
	}

}

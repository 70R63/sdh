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
package de.hybris.platform.sdhpsaddon.controllers.misc;

import de.hybris.platform.acceleratorfacades.flow.impl.SessionOverrideCheckoutFlowFacade;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.AbstractController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.AddToCartForm;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.data.CartModificationData;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.sdhpsaddon.security.PSOpenRedirectValidator;
import de.hybris.platform.publicsectorfacades.order.PSCartFacade;
import de.hybris.platform.publicsectorfacades.product.PSProductFacade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for Add to Cart functionality which is not specific to a certain page.
 */
@Controller("PublicSectorAddToCartController")
public class AddToCartController extends AbstractController
{
	private static final Logger LOG = LoggerFactory.getLogger(AddToCartController.class);
	private static final String TYPE_MISMATCH_ERROR_CODE = "typeMismatch";
	private static final String ERROR_MSG_TYPE = "errorMsg";
	private static final String QUANTITY_INVALID_BINDING_MESSAGE_KEY = "basket.error.quantity.invalid.binding";

	@Resource(name = "psCartFacade")
	private PSCartFacade psCartFacade;

	@Resource(name = "cartFacade")
	private CartFacade cartFacade;

	@Resource(name = "userFacade")
	private UserFacade userFacade;

	@Resource(name = "psProductFacade")
	private PSProductFacade psProductFacade;

	@RequestMapping(value = "/cart/add", method = RequestMethod.POST)
	public String addToCart(@RequestParam("productCodePost") final String code, final Model model, @Valid final AddToCartForm form,
			final BindingResult bindingErrors, final RedirectAttributes redirectModel, final HttpServletRequest request)
	{
		if (bindingErrors.hasErrors())
		{
			return getViewWithBindingErrorMessages(request, redirectModel, bindingErrors);
		}

		try
		{
			psCartFacade.removeExistingSessionCart();
			if (StringUtils.isNotBlank(code))
			{
				final CartModificationData cartModification = cartFacade.addToCart(code, 1);
				model.addAttribute("quantity", Long.valueOf(cartModification.getQuantityAdded()));
				model.addAttribute("entry", cartModification.getEntry());
				model.addAttribute("cartCode", cartModification.getCartCode());
			}
		}
		catch (final CommerceCartModificationException ex)
		{
			model.addAttribute(ERROR_MSG_TYPE, "basket.error.occurred");
			model.addAttribute("quantity", Long.valueOf(0L));
			LOG.error("Error occurred while adding product to the cart. ", ex);
		}
		SessionOverrideCheckoutFlowFacade.resetSessionOverrides();
		return setupNavigation(code);
	}

	/**
	 * @param code
	 */
	private String setupNavigation(final String code)
	{
		//if a Service Request supports the Unidentified user checkout or user is signed in, then redirect to form page
		if (getPsProductFacade().isUnidentifiedUserInService(code) || !getUserFacade().isAnonymousUser())
		{
			return REDIRECT_PREFIX + "/checkout/multi";
		}
		// If a Service Request supports Guest user checkout, Unidentified user checkout is not supported
		if (getUserFacade().isAnonymousUser() && getPsProductFacade().isGuestUserInService(code))
		{
			return REDIRECT_PREFIX + "/login/checkout";
		}
		return REDIRECT_PREFIX + "/login/registeredcheckout";
	}

	protected String getViewWithBindingErrorMessages(final HttpServletRequest request, final RedirectAttributes redirectModel,
			final BindingResult bindingErrors)
	{
		for (final ObjectError error : bindingErrors.getAllErrors())
		{
			if (isTypeMismatchError(error))
			{
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,
						QUANTITY_INVALID_BINDING_MESSAGE_KEY);
			}
			else
			{
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, error.getDefaultMessage());
			}
		}
		String redirectUrl = "/";
		if (PSOpenRedirectValidator.isValidDomain(request))
		{
			redirectUrl = request.getHeader("referer");
		}
		return REDIRECT_PREFIX + redirectUrl;
	}

	protected boolean isTypeMismatchError(final ObjectError error)
	{
		return error.getCode().equals(TYPE_MISMATCH_ERROR_CODE);
	}

	protected PSProductFacade getPsProductFacade()
	{
		return psProductFacade;
	}

	public UserFacade getUserFacade()
	{
		return userFacade;
	}
}

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
package de.hybris.platform.sdhpsaddon.security.impl;

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.commerceservices.strategies.CheckoutCustomerStrategy;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.sdhpsaddon.constants.PublicsectoracceleratoraddonWebConstants;
import de.hybris.platform.sdhpsaddon.security.PSGuestCheckoutCartCleanStrategy;
import de.hybris.platform.publicsectorservices.order.PSCartService;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;


/**
 * This is the implementation class of {@link PSGuestCheckoutCartCleanStrategy}
 */
public class DefaultPSGuestCheckoutCartCleanStrategy implements PSGuestCheckoutCartCleanStrategy
{
	public static final String AJAX_REQUEST_HEADER_NAME = "X-Requested-With";

	private PSCartService psCartService;
	private CheckoutCustomerStrategy checkoutCustomerStrategy;
	private CartService cartService;
	private SessionService sessionService;
	private UserService userService;
	private ConfigurationService configurationService;

	/**
	 * Method to not to change the user as anonymous for saved draft
	 */
	@Override
	public void cleanGuestCart(final HttpServletRequest request)
	{
		if (isHttpRequestValidForGuestCartCleanup(request) && isAnonymousCheckout() && getCartService().hasSessionCart() && isCartNotSavedDraft())
		{
			final CartModel cartModel = getCartService().getSessionCart();
			cartModel.setDeliveryAddress(null);
			cartModel.setDeliveryMode(null);
			cartModel.setPaymentInfo(null);
			cartModel.setUser(getUserService().getAnonymousUser());
			getCartService().saveOrder(cartModel);
			getSessionService().removeAttribute(WebConstants.ANONYMOUS_CHECKOUT);
			getSessionService().removeAttribute(WebConstants.ANONYMOUS_CHECKOUT_GUID);
		}
	}

	protected boolean isHttpRequestValidForGuestCartCleanup(final HttpServletRequest request)
	{
		return isGetMethod(request) && StringUtils.isBlank(request.getHeader(AJAX_REQUEST_HEADER_NAME))
				&& !checkWhetherURLContainsCheckoutPattern(request);
	}

	protected boolean isAnonymousCheckout()
	{
		return Boolean.TRUE.equals(getSessionService().getAttribute(WebConstants.ANONYMOUS_CHECKOUT))
				&& getCheckoutCustomerStrategy().isAnonymousCheckout();
	}

	protected boolean isGetMethod(final HttpServletRequest httpRequest)
	{
		return "GET".equalsIgnoreCase(httpRequest.getMethod());
	}

	protected boolean isCartNotSavedDraft()
	{
		return !getPsCartService().isCartSavedDraft(getCartService().getSessionCart());
	}

	@Override
	public boolean checkWhetherURLContainsCheckoutPattern(final HttpServletRequest request)
	{
		return getCheckoutURLPattern().matcher(request.getRequestURL().toString()).matches();
	}

	@Override
	public Pattern getCheckoutURLPattern()
	{
		final String storefrontExtension = getConfigurationService().getConfiguration()
				.getString(PublicsectoracceleratoraddonWebConstants.ADDON_STOREFRONT);
		return Pattern.compile(getConfigurationService().getConfiguration()
				.getString(storefrontExtension + "." + PublicsectoracceleratoraddonWebConstants.CHECKOUT_URL_PATTERN));
	}

	protected PSCartService getPsCartService()
	{
		return psCartService;
	}

	@Required
	public void setPsCartService(final PSCartService psCartService)
	{
		this.psCartService = psCartService;
	}

	protected CheckoutCustomerStrategy getCheckoutCustomerStrategy()
	{
		return checkoutCustomerStrategy;
	}

	@Required
	public void setCheckoutCustomerStrategy(final CheckoutCustomerStrategy checkoutCustomerStrategy)
	{
		this.checkoutCustomerStrategy = checkoutCustomerStrategy;
	}

	protected CartService getCartService()
	{
		return cartService;
	}

	@Required
	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}

	protected SessionService getSessionService()
	{
		return sessionService;
	}

	@Required
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	protected UserService getUserService()
	{
		return userService;
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
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

}

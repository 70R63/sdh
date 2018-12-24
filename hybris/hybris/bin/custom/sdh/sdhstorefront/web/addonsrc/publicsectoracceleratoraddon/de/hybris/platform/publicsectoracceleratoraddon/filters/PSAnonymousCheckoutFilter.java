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
package de.hybris.platform.publicsectoracceleratoraddon.filters;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.publicsectoracceleratoraddon.security.PSGuestCheckoutCartCleanStrategy;
import de.hybris.platform.publicsectorservices.order.PSCartService;
import de.hybris.platform.xyformscommerceservices.strategies.YFormUserStrategy;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.filter.OncePerRequestFilter;


/**
 * PSAnonymousCheckoutFilter class
 */
public class PSAnonymousCheckoutFilter extends OncePerRequestFilter
{

	private PSGuestCheckoutCartCleanStrategy psGuestCheckoutCartCleanStrategy;
	private PSCartService psCartService;
	private CartService cartService;
	private YFormUserStrategy userStrategy;

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException
	{
		checkAndUpdateCartDetails(request);
		getPsGuestCheckoutCartCleanStrategy().cleanGuestCart(request);
		filterChain.doFilter(request, response);
	}

	private void checkAndUpdateCartDetails(final HttpServletRequest request)
	{
		if (StringUtils.isBlank(request.getHeader("X-Requested-With")) && checkWhetherUserLeavingCheckout(request)
				&& getCartService().hasSessionCart())
		{
			final CartModel cartModel = getCartService().getSessionCart();
			if (getPsCartService().isCartSavedDraft(cartModel))
			{
				cartModel.setUser(getUserStrategy().getCurrentUserForCheckout());
				getCartService().saveOrder(cartModel);
			}
		}
	}

	public boolean checkWhetherUserLeavingCheckout(final HttpServletRequest request)
	{
		return "GET".equalsIgnoreCase(request.getMethod())
				&& !getPsGuestCheckoutCartCleanStrategy().checkWhetherURLContainsCheckoutPattern(request)
				&& request.getHeader("referer") != null
				&& getPsGuestCheckoutCartCleanStrategy().getCheckoutURLPattern().matcher(request.getHeader("referer")).matches();
	}

	protected PSGuestCheckoutCartCleanStrategy getPsGuestCheckoutCartCleanStrategy()
	{
		return psGuestCheckoutCartCleanStrategy;
	}

	@Required
	public void setPsGuestCheckoutCartCleanStrategy(final PSGuestCheckoutCartCleanStrategy psGuestCheckoutCartCleanStrategy)
	{
		this.psGuestCheckoutCartCleanStrategy = psGuestCheckoutCartCleanStrategy;
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

	protected CartService getCartService()
	{
		return cartService;
	}

	@Required
	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
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
}

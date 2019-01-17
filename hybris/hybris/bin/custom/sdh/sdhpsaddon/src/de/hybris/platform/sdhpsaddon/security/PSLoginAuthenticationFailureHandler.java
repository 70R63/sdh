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
package de.hybris.platform.sdhpsaddon.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;


/**
 * The class PSLoginAuthenticationFailureHandler.
 */
public class PSLoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler
{
	private BruteForceAttackCounter bruteForceAttackCounter;
	private String registeredCheckoutDefaultFailureUrl;
	private String checkoutDefaultFailureUrl;

	@Override
	public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException exception) throws IOException, ServletException
	{
		// Register brute attacks

		final String userName = request.getParameter("j_username");
		if (StringUtils.isNotBlank(userName))
		{
			bruteForceAttackCounter.registerLoginFailure(userName);
			request.getSession().setAttribute("SPRING_SECURITY_LAST_USERNAME", userName);
		}
		// Store the j_username in the session

		if (isRequestFromRegisteredCheckoutPage(request))
		{
			setDefaultFailureUrl(getRegisteredCheckoutDefaultFailureUrl());
		}
		super.onAuthenticationFailure(request, response, exception);
		setDefaultFailureUrl(getCheckoutDefaultFailureUrl());
	}

	/**
	 * Method to check uif request is coming from registered checkout page
	 *
	 * @param request
	 * @return boolean
	 */
	private boolean isRequestFromRegisteredCheckoutPage(final HttpServletRequest request)
	{
		final Boolean isRequestFromRegisteredCheckout = Boolean.valueOf(request.getParameter("registeredCheckout"));
		return BooleanUtils.isTrue(isRequestFromRegisteredCheckout);
	}

	protected BruteForceAttackCounter getBruteForceAttackCounter()
	{
		return bruteForceAttackCounter;
	}

	@Required
	public void setBruteForceAttackCounter(final BruteForceAttackCounter bruteForceAttackCounter)
	{
		this.bruteForceAttackCounter = bruteForceAttackCounter;
	}

	protected String getRegisteredCheckoutDefaultFailureUrl()
	{
		return registeredCheckoutDefaultFailureUrl;
	}

	@Required
	public void setRegisteredCheckoutDefaultFailureUrl(final String registeredCheckoutDefaultFailureUrl)
	{
		this.registeredCheckoutDefaultFailureUrl = registeredCheckoutDefaultFailureUrl;
	}

	protected String getCheckoutDefaultFailureUrl()
	{
		return checkoutDefaultFailureUrl;
	}

	@Required
	public void setCheckoutDefaultFailureUrl(final String checkoutDefaultFailureUrl)
	{
		this.checkoutDefaultFailureUrl = checkoutDefaultFailureUrl;
	}

}

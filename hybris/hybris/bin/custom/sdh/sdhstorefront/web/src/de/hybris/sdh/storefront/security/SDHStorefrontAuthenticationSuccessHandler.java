/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.storefront.security;

import de.hybris.platform.acceleratorstorefrontcommons.security.StorefrontAuthenticationSuccessHandler;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.facades.SDHCustomerFacade;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;


/**
 * Success handler initializing user settings, restoring or merging the cart and ensuring the cart is handled correctly.
 * Cart restoration is stored in the session since the request coming in is that to j_spring_security_check and will be
 * redirected.
 */
public class SDHStorefrontAuthenticationSuccessHandler extends StorefrontAuthenticationSuccessHandler
{
	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;


	private static final Logger LOG = Logger.getLogger(SDHStorefrontAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
										final Authentication authentication) throws IOException, ServletException
	{
		Cookie cookie = new Cookie("sessionActived", "true");
		cookie.setMaxAge(60 * 60 * 24);
		cookie.setPath("/");
		cookie.setSecure(false);
		response.addCookie(cookie);

		super.onAuthenticationSuccess(request, response, authentication);

		sdhCustomerFacade.updateMiRitInfo();
		sdhCustomerFacade.updateCustomerTaxRestrictions();


	}
}

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
package de.hybris.sdh.storefront.interceptors.beforecontroller;

import de.hybris.platform.acceleratorcms.services.CMSPageContextService;
import de.hybris.platform.acceleratorstorefrontcommons.interceptors.BeforeControllerHandler;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.time.TimeService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.method.HandlerMethod;


/**
 * Spring MVC interceptor that validates that the spring security user and the hybris session user are in sync. If the
 * spring security user and the hybris session user are not in sync then the session is invalidated and the visitor is
 * redirect to the homepage.
 */
public class SecurityUserCheckBeforeControllerHandler implements BeforeControllerHandler
{
	private static final Logger LOG = Logger.getLogger(SecurityUserCheckBeforeControllerHandler.class);

	private static final String LOGOUT_TRUE_CLOSE_ACC_TRUE = "/?logout=true&closeAcc=true";
	private static final String REDIRECT_PATH = "/";

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "cmsPageContextService")
	private CMSPageContextService cmsPageContextService;

	@Resource(name = "timeService")
	private TimeService timeService;

	@Resource(name = "excludeRedirectUrlRequestMatcher")
	RequestMatcher excludeRedirectUrlRequestMatcher;

	@Override
	public boolean beforeController(final HttpServletRequest request, final HttpServletResponse response,
			final HandlerMethod handler) throws IOException
	{
		//Added to udpate dataForm from session

		if ("POST".equalsIgnoreCase(request.getMethod())
				&& request.getRequestURI().contains("/contribuyentes/sobretasa-gasolina/declaracion-gasolina"))
		{
			final Object dataForm = request.getSession().getAttribute("dataForm");

			if (dataForm instanceof SobreTasaGasolinaForm)
			{
				// remove current rows in session in order to be able to receive the new ones captured by customer
				((SobreTasaGasolinaForm) dataForm).getDataForm().setInfoDeclara(null);
			}
		}



		// Skip this security check when run from within the WCMS Cockpit
		if (isPreviewDataModelValid(request))
		{
			return true;
		}

		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null)
		{
			final Object principal = authentication.getPrincipal();
			if (principal instanceof String)
			{
				final String springSecurityUserId = (String) principal;
				final UserModel currentUser = userService.getCurrentUser();
				final String hybrisUserId = currentUser.getUid();

				if ("anonymous".equalsIgnoreCase(hybrisUserId))
				{
					if (excludeRedirectUrlRequestMatcher.matches(request))
					{

						invalidateSessionAndRedirect(request, response, "/login");
						return false;

					}
				}

				// check if the user is deactivated
				if (isUserDeactivated(currentUser))
				{
					LOG.error("User account [" + hybrisUserId + "] has already bean closed. Invalidating session.");

					invalidateSessionAndRedirect(request, response, LOGOUT_TRUE_CLOSE_ACC_TRUE);
					return false;
				}

				// check if spring uid is the same as hybris uid
				if (!springSecurityUserId.equals(hybrisUserId))
				{
					LOG.error("User miss-match springSecurityUserId [" + springSecurityUserId + "] hybris session user ["
							+ hybrisUserId + "]. Invalidating session.");

					invalidateSessionAndRedirect(request, response, REDIRECT_PATH);
					return false;
				}
			}
		}
		return true;
	}

	protected void invalidateSessionAndRedirect(final HttpServletRequest request, final HttpServletResponse response,
			final String redirectPath) throws IOException
	{
		// Invalidate session and redirect
		request.getSession().invalidate();
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + redirectPath));
	}

	protected boolean isUserDeactivated(final UserModel userModel)
	{
		if (userModel.getDeactivationDate() == null)
		{
			return false;
		}
		return !timeService.getCurrentTime().before(userModel.getDeactivationDate());
	}

	/**
	 * Checks whether there is a preview data setup for the current request
	 *
	 * @param httpRequest
	 *           current request
	 * @return true whether is valid otherwise false
	 */
	protected boolean isPreviewDataModelValid(final HttpServletRequest httpRequest)
	{
		return cmsPageContextService.getCmsPageRequestContextData(httpRequest).getPreviewData() != null;
	}
}

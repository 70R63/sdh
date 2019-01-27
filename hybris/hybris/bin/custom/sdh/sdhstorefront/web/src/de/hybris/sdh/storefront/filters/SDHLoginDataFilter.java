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
package de.hybris.sdh.storefront.filters;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.exceptions.NotARobotException;
import de.hybris.sdh.core.exceptions.NotAValidEmailException;
import de.hybris.sdh.storefront.checkout.steps.validation.impl.SDHRegistrationValidator;
import de.hybris.sdh.storefront.security.LoginAuthenticationFailureHandler;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



public class SDHLoginDataFilter extends AbstractAuthenticationProcessingFilter
{
	public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "j_username";
	private final String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
	private static final Logger LOG = Logger.getLogger(SDHLoginDataFilter.class);
	@Resource(name = "loginAuthenticationFailureHandler")
	LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;

	@Resource(name = "rememberMeServices")
	RememberMeServices rememberMeServices;

	@Resource(name = "sdhRegistrationValidator")
	SDHRegistrationValidator sdhRegistrationValidator;

	@Resource(name="userService")
	UserService userService;

	@Resource(name = "modelService")
	ModelService modelService;

	/**
	 * @param defaultFilterProcessesUrl
	 */
	public SDHLoginDataFilter()
	{
		super(new AntPathRequestMatcher("/j_spring_security_check", "POST"));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#attemptAuthentication(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException
	{
		final String notARobotString = request.getParameter("notARobot");

		final Boolean notARobot = Boolean.parseBoolean(notARobotString);

		if (!Boolean.TRUE.equals(notARobot))
		{
			throw new NotARobotException("A Robot");
		}


		final String username = obtainUsername(request);
		if (!Boolean.TRUE.equals(sdhRegistrationValidator.validateEmailAddress(username)))
		{
			throw new NotAValidEmailException("Not A Valid Email");
		}

		if(StringUtils.isNotBlank(username))
		{
			try
			{
				final UserModel userModel = userService.getUserForUID(username);

				if (userModel.isLoginDisabled() && userModel.getBlockedSince() != null)
				{
					final Date nowDate = new Date();
					final LocalDateTime noewLocalDateTime = LocalDateTime.ofInstant(nowDate.toInstant(), ZoneId.systemDefault());

					final Date userBlockedSince = userModel.getBlockedSince();
					final LocalDateTime userBlockedSinceDateTime = LocalDateTime.ofInstant(userBlockedSince.toInstant(),
							ZoneId.systemDefault());

					final Duration duration = Duration.between(userBlockedSinceDateTime, noewLocalDateTime);

					LOG.info("user blocked during: " + duration.toMinutes() + " minutes");

					if (duration.toMinutes() > 15)
					{
						userModel.setLoginDisabled(false);
						userModel.setBlockedSince(null);
						modelService.save(userModel);
					}

				}

			}catch(final UnknownIdentifierException ex)
			{
				LOG.warn("User: " + username + " not found");
			}
		}


		return null;
	}

	protected String obtainUsername(final HttpServletRequest request)
	{
		return request.getParameter(usernameParameter);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#doFilter(javax.servlet.
	 * ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException
	{

		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;

		if (!requiresAuthentication(request, response))
		{
			chain.doFilter(request, response);

			return;
		}

		if (logger.isDebugEnabled())
		{
			logger.debug("Request is to process authentication");
		}

		Authentication authResult;

		try
		{
			authResult = attemptAuthentication(request, response);
		}

		catch (final NotARobotException failed)
		{
			// Authentication failed
			unsuccessfulAuthentication(request, response, failed);

			return;
		}
		catch (final NotAValidEmailException failed)
		{
			// Authentication failed
			unsuccessfulAuthentication(request, response, failed);

			return;
		}


		chain.doFilter(request, response);
	}

	@Override
	protected void unsuccessfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException failed) throws IOException, ServletException
	{
		SecurityContextHolder.clearContext();

		if (logger.isDebugEnabled())
		{
			logger.debug("Authentication request failed: " + failed.toString(), failed);
			logger.debug("Updated SecurityContextHolder to contain null Authentication");
			logger.debug("Delegating to authentication failure handler " + loginAuthenticationFailureHandler);
		}

		rememberMeServices.loginFail(request, response);

		loginAuthenticationFailureHandler.onAuthenticationFailure(request, response, failed);
	}


	//	@Override
	//	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
	//			final FilterChain filterChain) throws ServletException, IOException
	//	{
	//
	//
	//			final String notARobotString = request.getParameter("notARobot");
	//
	//			final Boolean notARobot = Boolean.parseBoolean(notARobotString);
	//
	//			if (!Boolean.TRUE.equals(notARobot))
	//			{
	//				throw new BadCredentialsException("A Robot");
	//			}
	//
	//		filterChain.doFilter(request, response);
	//	}



}
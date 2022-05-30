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

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.security.GUIDCookieStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.model.SDHAddressModel;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;


public class StorefrontLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler
{
	public static final String CLOSE_ACCOUNT_PARAM = "&closeAcc=true";

	private GUIDCookieStrategy guidCookieStrategy;
	private List<String> restrictedPages;
	private SessionService sessionService;
	private UserService userService;
	private ModelService modelService;

	protected GUIDCookieStrategy getGuidCookieStrategy()
	{
		return guidCookieStrategy;
	}

	@Required
	public void setGuidCookieStrategy(final GUIDCookieStrategy guidCookieStrategy)
	{
		this.guidCookieStrategy = guidCookieStrategy;
	}

	protected List<String> getRestrictedPages()
	{
		return restrictedPages;
	}

	public void setRestrictedPages(final List<String> restrictedPages)
	{
		this.restrictedPages = restrictedPages;
	}

	@Override
	public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response,
								final Authentication authentication) throws IOException, ServletException
	{
		Optional<String> esFuncionarioOpt = Lists.newArrayList(request.getCookies()).stream()
				.filter(cookie -> cookie.getName()
						.equals("esFuncionario")).findFirst().map(Cookie::getValue);

		Optional<String> currentCustomerUidOpt = Lists.newArrayList(request.getCookies()).stream()
				.filter(cookie -> cookie.getName()
						.equals("currentCustomerUid")).findFirst().map(Cookie::getValue);

		if (esFuncionarioOpt.isPresent() && esFuncionarioOpt.get().equals("true")){
			if (currentCustomerUidOpt.isPresent()){
				CustomerModel currentCustomerModel = (CustomerModel) getUserService()
						.getUserForUID(currentCustomerUidOpt.get());

				currentCustomerModel.setNumBP("");
				currentCustomerModel.setDocumentType("");
				currentCustomerModel.setDocumentNumber("");
				currentCustomerModel.setDocumentExpeditionDate(null);
				currentCustomerModel.setFirstName("");
				currentCustomerModel.setLastName("");
				currentCustomerModel.setMiddleName("");
				currentCustomerModel.setSecondLastName("");
				currentCustomerModel.setTitle(null);
				currentCustomerModel.setNameOrg1("");
				currentCustomerModel.setAddressList(new ArrayList<>());
				currentCustomerModel.setAgentList(new ArrayList<>());
				currentCustomerModel.setRolList(new ArrayList<>());
				getModelService().save(currentCustomerModel);
			}

		}

		getGuidCookieStrategy().deleteCookie(request, response);
		getSessionService().removeAttribute(WebConstants.USER_CONSENTS);


		Cookie cookie = new Cookie("sessionActived", "false");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);

		// Delegate to default redirect behaviour
		super.onLogoutSuccess(request, response, authentication);
	}

	@Override
	protected String determineTargetUrl(final HttpServletRequest request, final HttpServletResponse response)
	{
		String targetUrl = super.determineTargetUrl(request, response);

		for (final String restrictedPage : getRestrictedPages())
		{
			// When logging out from a restricted page, return user to homepage.
			if (targetUrl.contains(restrictedPage))
			{
				targetUrl = super.getDefaultTargetUrl();
			}
		}

		// For closing an account, we need to append the closeAcc query string to the target url to display the close account message in the homepage.
		if (StringUtils.isNotBlank(request.getParameter(WebConstants.CLOSE_ACCOUNT)))
		{
			targetUrl = targetUrl + CLOSE_ACCOUNT_PARAM;
		}

		String[] sessionExpiredArray = request.getParameterMap().get("sessionExpired");
		if(Objects.nonNull(sessionExpiredArray)){
			if(sessionExpiredArray.length > 0){
				String isSessionExpired = sessionExpiredArray[0];
				if("true".equals(isSessionExpired)){
					targetUrl =  "/login?sessionExpired=true";
				}
			}
		}

		return targetUrl;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ModelService getModelService() {
		return modelService;
	}

	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}
}

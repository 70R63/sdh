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
package de.hybris.platform.sdhpsaddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractLoginPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.GuestForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.sdhpsaddon.forms.SDHLoginForm;
import de.hybris.sdh.core.exceptions.NotARobotException;
import de.hybris.sdh.core.exceptions.NotAValidEmailException;
import de.hybris.sdh.core.exceptions.UserNotExistsException;

import java.util.Collections;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Login Controller. Handles login and register for the account flow.
 */

@RequestMapping(value = "/login")
public class LoginPageController extends AbstractLoginPageController
{
	private HttpSessionRequestCache httpSessionRequestCache;
	private static final String SHOW_REGISTER_BODY = "showRegisterBody";
	private static final String URL_LOGIN_CHECKOUT = "/login/checkout";
	private static final String URL_LOGIN_REGISTERED_CHECKOUT = "/login/registeredCheckout";
	private static final String URL_CHECKOUT_MULTI = "/checkout/multi";

	@Override
	protected String getView()
	{
		return ControllerConstants.Views.Pages.Account.AccountLoginPage;
	}

	@Override
	protected String getSuccessRedirect(final HttpServletRequest request, final HttpServletResponse response)
	{
		if (httpSessionRequestCache.getRequest(request, response) != null
				&& (StringUtils.endsWith(httpSessionRequestCache.getRequest(request, response).getRedirectUrl(), URL_LOGIN_CHECKOUT)
						|| StringUtils.endsWith(httpSessionRequestCache.getRequest(request, response).getRedirectUrl(),
								URL_LOGIN_REGISTERED_CHECKOUT)))
		{
			return URL_CHECKOUT_MULTI;
		}
		return "/";
	}

	@Override
	protected AbstractPageModel getCmsPage() throws CMSItemNotFoundException
	{
		return getContentPageForLabelOrId("login");
	}

	@Resource(name = "httpSessionRequestCache")
	public void setHttpSessionRequestCache(final HttpSessionRequestCache accHttpSessionRequestCache)
	{
		this.httpSessionRequestCache = accHttpSessionRequestCache;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String doLogin(@RequestHeader(value = "referer", required = false) final String referer,
			@RequestParam(value = "error", defaultValue = "false") final boolean loginError, final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final HttpSession session)
			throws CMSItemNotFoundException
	{
		if (!loginError)
		{
			storeReferer(referer, request, response);
		}
		model.addAttribute(SHOW_REGISTER_BODY, Boolean.TRUE);
		if (request.getParameter(SHOW_REGISTER_BODY) != null)
		{
			model.addAttribute("showloginBody", Boolean.FALSE);
		}
		return getDefaultLoginPage(loginError, session, model);
	}



	@Override
	protected String getDefaultLoginPage(final boolean loginError, final HttpSession session, final Model model)
			throws CMSItemNotFoundException
	{
		final SDHLoginForm loginForm = new SDHLoginForm();
		model.addAttribute("loginForm", loginForm);
		model.addAttribute(new RegisterForm());
		model.addAttribute(new GuestForm());

		final String username = (String) session.getAttribute(SPRING_SECURITY_LAST_USERNAME);
		if (username != null)
		{
			session.removeAttribute(SPRING_SECURITY_LAST_USERNAME);
		}

		loginForm.setJ_username(username);
		storeCmsPageInModel(model, getCmsPage());
		setUpMetaDataForContentPage(model, (ContentPageModel) getCmsPage());
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.INDEX_NOFOLLOW);

		addRegistrationConsentDataToModel(model);

		final Breadcrumb loginBreadcrumbEntry = new Breadcrumb("#",
				getMessageSource().getMessage("header.link.login", null, "header.link.login", getI18nService().getCurrentLocale()),
				null);
		model.addAttribute("breadcrumbs", Collections.singletonList(loginBreadcrumbEntry));

		if (loginError)
		{
			final Object authenticationException = session.getAttribute("authenticationException");

			if (authenticationException != null && authenticationException instanceof NotARobotException)
			{
				model.addAttribute("loginError", Boolean.valueOf(loginError));
				GlobalMessages.addErrorMessage(model, "login.not.a.robot.exception");
			}
			else if (authenticationException != null && authenticationException instanceof NotAValidEmailException)
			{
				model.addAttribute("loginError", Boolean.valueOf(loginError));
				GlobalMessages.addErrorMessage(model, "login.not.a.validEmail.exception");
			}
			else if (authenticationException != null && authenticationException instanceof NotAValidEmailException)
			{
				model.addAttribute("loginError", Boolean.valueOf(loginError));
				GlobalMessages.addErrorMessage(model, "login.not.a.validEmail.exception");
			}
			else if (authenticationException != null && authenticationException instanceof DisabledException)
			{
				model.addAttribute("loginError", Boolean.valueOf(loginError));
				GlobalMessages.addErrorMessage(model, "login.user.disabled.exception");
			}
			else if (authenticationException != null && authenticationException instanceof UserNotExistsException)
			{
				model.addAttribute("loginError", Boolean.valueOf(loginError));
				GlobalMessages.addErrorMessage(model, "login.user.not.exists");
			}
			else
			{

				model.addAttribute("loginError", Boolean.valueOf(loginError));
				GlobalMessages.addErrorMessage(model, "login.error.account.not.found.title");
			}
		}

		return getView();
	}

	protected void storeReferer(final String referer, final HttpServletRequest request, final HttpServletResponse response)
	{
		if (StringUtils.isNotBlank(referer) && !StringUtils.endsWith(referer, "/login")
				&& StringUtils.contains(referer, request.getServerName()))
		{
			httpSessionRequestCache.saveRequest(request, response);
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@RequestHeader(value = "referer", required = false) final String referer, final RegisterForm form,
			final BindingResult bindingResult, final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		model.addAttribute(SHOW_REGISTER_BODY, Boolean.TRUE);
		model.addAttribute("showloginBody", Boolean.FALSE);
		getRegistrationValidator().validate(form, bindingResult);
		return processRegisterUserRequest(referer, form, bindingResult, model, request, response, redirectModel);
	}

	@RequestMapping(value = "/register/termsandconditions")
	public String getTermsAndConditions(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel pageForRequest = getCmsPageService().getPageForLabel("/termsAndConditions");
		storeCmsPageInModel(model, pageForRequest);
		setUpMetaDataForContentPage(model, pageForRequest);
		return ControllerConstants.Views.Fragments.Checkout.TermsAndConditionsPopup;
	}
}

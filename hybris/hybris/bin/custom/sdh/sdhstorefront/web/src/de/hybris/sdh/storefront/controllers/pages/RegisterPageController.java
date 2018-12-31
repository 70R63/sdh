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
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.facades.SDHValidaContribuyenteFacade;
import de.hybris.sdh.storefront.checkout.steps.validation.impl.SDHRegistrationValidator;
import de.hybris.sdh.storefront.controllers.ControllerConstants;
import de.hybris.sdh.storefront.forms.SDHRegisterForm;
import de.hybris.sdh.storefront.forms.SearchUserForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Register Controller for mobile. Handles login and register for the account flow.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterPageController extends SDHAbstractRegisterPageController
{
	private HttpSessionRequestCache httpSessionRequestCache;

	@Resource(name = "sdhValidaContribuyenteFacade")
	SDHValidaContribuyenteFacade sdhValidaContribuyenteFacade;

	@Resource(name = "sdhRegistrationValidator")
	SDHRegistrationValidator sdhRegistrationValidator;

	@Override
	protected AbstractPageModel getCmsPage() throws CMSItemNotFoundException
	{
		return getContentPageForLabelOrId("register");
	}

	@Override
	protected String getSuccessRedirect(final HttpServletRequest request, final HttpServletResponse response)
	{
		if (httpSessionRequestCache.getRequest(request, response) != null)
		{
			return httpSessionRequestCache.getRequest(request, response).getRedirectUrl();
		}
		return "/";
	}

	@Override
	protected String getView()
	{
		return ControllerConstants.Views.Pages.Account.AccountRegisterPage;
	}

	@Resource(name = "httpSessionRequestCache")
	public void setHttpSessionRequestCache(final HttpSessionRequestCache accHttpSessionRequestCache)
	{
		this.httpSessionRequestCache = accHttpSessionRequestCache;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String doRegister(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("currentSection", "searchUserSection");

		return getDefaultRegistrationPage(model);
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public String searchUserGET(final Model model) throws CMSItemNotFoundException
	{

		//Start registration
		model.addAttribute("currentSection", "searchUserSection");

		model.addAttribute(new SearchUserForm());

		return getDefaultRegistrationPage(model);
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	public String searchUser(final Model model, final SearchUserForm searchUserForm) throws CMSItemNotFoundException
	{
		final ValidaContribuyenteRequest request = new ValidaContribuyenteRequest();

		request.setNumid(searchUserForm.getDocumentNumber());
		request.setTipoid(searchUserForm.getDocumentType());

		boolean userFound = false;

		userFound = sdhValidaContribuyenteFacade.existeContribuyente(request);



		if (userFound)
		{
			//Start registration
			model.addAttribute("currentSection", "startSection");
		}
		else
		{

			model.addAttribute("currentSection", "searchUserSection");

			model.addAttribute(searchUserForm);

			model.addAttribute("userFound", false);

			return getDefaultRegistrationPage(model);

		}

		return getDefaultRegistrationPage(model);
	}

	@RequestMapping(value = "/personalData", method = RequestMethod.GET)
	public String personalData(final Model model) throws CMSItemNotFoundException
	{
		final boolean userFound = false;


		//Start registration
		model.addAttribute("currentSection", "personalDataSection");

		return getDefaultRegistrationPage(model);
	}

	@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
	public String confirmation(final Model model) throws CMSItemNotFoundException
	{
		final boolean userFound = false;


		//Start registration
		model.addAttribute("currentSection", "confirmationSection");

		return getDefaultRegistrationPage(model);
	}

	@RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
	public String getQuestions(final Model model, @RequestParam(value = "currentQuestion", defaultValue = "0")
	final int currentQuestion) throws CMSItemNotFoundException
	{
		model.addAttribute("currentSection", "questionsSection");
		if (currentQuestion == 0)
		{
			//getQuestions from service and put it on session
			model.addAttribute("currentQuestion", currentQuestion + 1);
			model.addAttribute("currentQuestionDescription", "Pregunta " + (currentQuestion + 1));
		}
		else if (currentQuestion == 5)
		{
			//Evaluate answers and redirect to proper page
			model.addAttribute("currentQuestion", currentQuestion + 1);
			model.addAttribute("currentQuestionDescription", "Pregunta " + (currentQuestion + 1));
			model.addAttribute("isFinalQuestion", true);

			return "redirect:/register/personalData";
		}
		else
		{
			//getQuestions from session
			model.addAttribute("currentQuestion", currentQuestion + 1);
			model.addAttribute("currentQuestionDescription", "Pregunta " + (currentQuestion + 1));
		}

		return getDefaultRegistrationPage(model);
	}

	@RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
	public String doRegister(final SDHRegisterForm form, final BindingResult bindingResult, final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		sdhRegistrationValidator.validate(form, bindingResult);

		return processRegisterUserRequest(null, form, bindingResult, model, request, response, redirectModel);

	}
}

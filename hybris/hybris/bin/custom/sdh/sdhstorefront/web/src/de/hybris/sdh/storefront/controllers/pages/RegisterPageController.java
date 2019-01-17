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
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.AnswerFormReply;
import de.hybris.sdh.core.pojos.responses.QuestionForRegistrationResponse;
import de.hybris.sdh.core.services.SDHGetQuestionsForRegistration;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.SDHValidaContribuyenteFacade;
import de.hybris.sdh.storefront.checkout.steps.validation.impl.SDHRegistrationValidator;
import de.hybris.sdh.storefront.controllers.ControllerConstants;
import de.hybris.sdh.storefront.forms.SDHRegisterForm;
import de.hybris.sdh.storefront.forms.SearchUserForm;
import de.hybris.sdh.storefront.forms.SecretAnswerForm;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@Resource(name = "sdhCustomerFacade")
	private SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "SDHGetQuestionsForRegistration")
	private SDHGetQuestionsForRegistration sdhGetQuestionsForRegistration;

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

	@ModelAttribute("idTypes")
	public List<String> getIdTipes()
	{

		final List<String> idTypes = Arrays.asList("CC", "CE", "NIT", "PA", "TI", "TIE", "NITE", "NUIP");

		return idTypes;
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
		request.setExpeditionDate(searchUserForm.getExpeditionDate());


		if (StringUtils.isNotBlank(request.getNumid()) && StringUtils.isNotBlank(request.getTipoid()))
		{
			final boolean userRegistered = sdhCustomerFacade.isUserRegistered(request.getNumid(), request.getTipoid());

			if (userRegistered == true)
			{
				model.addAttribute("currentSection", "searchUserSection");

				model.addAttribute(searchUserForm);

				model.addAttribute("userRegistered", true);

				return getDefaultRegistrationPage(model);
			}


		}

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
	final int currentQuestion, @ModelAttribute("SpringWeb") AnswerFormReply bundleOptionsForm) throws CMSItemNotFoundException
	{
		ConsultaContribuyenteBPRequest bp = new ConsultaContribuyenteBPRequest();
		bp.setNumBP(getSessionService().getAttribute("numBP"));

		System.out.println(getSessionService().getAttribute("numBP"));

		QuestionForRegistrationResponse response = sdhGetQuestionsForRegistration.getQuestionForRegistration(bp);

		model.addAttribute("questionAndOptions", response.getQuestionAndOptions());
		model.addAttribute("questionCatalog", response.getMapQuestionsCatalog());
		model.addAttribute("currentSection", "questionsSection");
		model.addAttribute("SecretAnswerForm", new SecretAnswerForm());

		return getDefaultRegistrationPage(model);
	}

	@RequestMapping(value = "/validateAnswers", method = RequestMethod.POST)
	public String validateAnswer(final SecretAnswerForm form, final BindingResult bindingResult, final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		System.out.println("----------+------------");
		System.out.println(form.getAGE());
		System.out.println(form.getDIR());
		System.out.println(form.getFNAM());
		System.out.println(form.getREDS());
		System.out.println(form.getTELM());


		ConsultaContribuyenteBPRequest bp = new ConsultaContribuyenteBPRequest();

		bp.setNumBP(getSessionService().getAttribute("numBP"));
		System.out.println(getSessionService().getAttribute("numBP"));

		QuestionForRegistrationResponse responseWS = sdhGetQuestionsForRegistration.getQuestionForRegistration(bp);

		System.out.println("----------------------");
		System.out.println(responseWS.getCorrectAnswer("AGE"));
		System.out.println(responseWS.getCorrectAnswer("DIR"));
		System.out.println(responseWS.getCorrectAnswer("FNAM"));
		System.out.println(responseWS.getCorrectAnswer("REDS"));
		System.out.println(responseWS.getCorrectAnswer("TELM"));

		int i = 0;
		
		if(form.getAGE() != null) {
			if (form.getAGE().equals(responseWS.getCorrectAnswer("AGE")))
			{
				i++;
			}
		}
		
		if(form.getDIR() != null) {
			if (form.getDIR().equals(responseWS.getCorrectAnswer("DIR")))
			{
				i++;
			}
		}
		
		if(form.getFNAM() != null) {
			if (form.getFNAM().equals(responseWS.getCorrectAnswer("FNAM")))
			{
				i++;
			}
		}

		if(form.getREDS() != null) {
			if (form.getREDS().equals(responseWS.getCorrectAnswer("REDS")))
			{
				i++;
			}
		}	

		if(form.getTELM() != null) {
			if (form.getTELM().equals(responseWS.getCorrectAnswer("TELM")))
			{
				i++;
			}
		}		

		if (i < 3)
		{
			return "redirect:/login";
		}

		return "redirect:/register/personalData";

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

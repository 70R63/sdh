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

import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.QuestionForRegistrationResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.pojos.responses.TramitesCreacionCasoInfo;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHGetQuestionsForRegistration;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.SDHValidaContribuyenteFacade;
import de.hybris.sdh.storefront.checkout.steps.validation.impl.SDHRegistrationValidator;
import de.hybris.sdh.storefront.controllers.ControllerConstants;
import de.hybris.sdh.storefront.forms.SDHRegisterForm;
import de.hybris.sdh.storefront.forms.SearchUserForm;
import de.hybris.sdh.storefront.forms.SecretAnswerForm;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
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

	private static final Logger LOG = Logger.getLogger(RegisterPageController.class);

	@Resource(name = "sdhValidaContribuyenteFacade")
	SDHValidaContribuyenteFacade sdhValidaContribuyenteFacade;

	@Resource(name = "sdhRegistrationValidator")
	SDHRegistrationValidator sdhRegistrationValidator;

	@Resource(name = "sdhCustomerFacade")
	private SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "SDHGetQuestionsForRegistration")
	private SDHGetQuestionsForRegistration sdhGetQuestionsForRegistration;

	@Resource(name = "sdhCustomerAccountService")
	private SDHCustomerAccountService sdhCustomerAccountService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

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
	public String personalData(final Model model, @RequestParam(value = "token", defaultValue = "null")
	final String token, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final boolean userFound = false;


		//System.out.println("Token["+token+"]");
		//System.out.println("UidUser["+uidUser+"]");
		//System.out.println("isValidToke["+sdhCustomerAccountService.validateToken(token,uidUser)+"]");
		//Start registration


		final String msg = "No puedes acceder a este sitio";

		if(token.equals("null")) {
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,msg);
			return "redirect:/login";
		}

		final String uidUser = getSessionService().getAttribute("SMTP_ADDR");
		final String bpNumbre = getSessionService().getAttribute("numBP");


		sdhCustomerAccountService.validateToken(token,bpNumbre);
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


	@RequestMapping(value = "/postRol", method = RequestMethod.POST)
	public String postRol(final Model model, final TramitesCreacionCasoInfo tramitesCreacionCasoInfo)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------En POST creacion rol------------------------");

		/*
		 * System.out.println("------------------En POST creacion caso------------------------"); final CustomerModel
		 * customerModel = (CustomerModel) userService.getCurrentUser(); final SobreTasaGasolinaService gasolinaService =
		 * new SobreTasaGasolinaService(configurationService); final TramitesSeleccionInfo tramitesSeleccionInfo = new
		 * TramitesSeleccionInfo(); final List<ItemSelectOption> elementosResponse = new ArrayList<ItemSelectOption>();
		 * final List<TramiteOpcion> elementos = new ArrayList<TramiteOpcion>(); TramiteOpcion elementoSeleccionado =
		 * null; String busquedaSubKey = ""; final CreaCasosRequest creaCasosRequest = new CreaCasosRequest();
		 * CreaCasosResponse creaCasosResponse = new CreaCasosResponse(); final List<CreaCasosAtribRequest> atributos =
		 * new ArrayList<CreaCasosAtribRequest>(); final List<CreaCasosArchiRequest> archivos = new
		 * ArrayList<CreaCasosArchiRequest>(); final List<CreaCasoArchVista> inputInfoArchivos = new
		 * ArrayList<CreaCasoArchVista>(); CreaCasoArchVista inputInfoArchivo_tmp = null; CreaCasosArchiRequest
		 * archivoCarga = null; CreaCasosArchiInfoRequest archivosInfo = null; CreaCasosAtribRequest atributo = null;
		 * String processType = ""; String categoriza = ""; String descripcion = ""; String canal = ""; String bp = "";
		 * String mensaje = "";
		 * 
		 * 
		 * llenarElementosTramites(elementos);
		 * tramitesSeleccionInfo.setNivelSeleccion(tramitesCreacionCasoInfo.getNivelSeleccion());
		 * tramitesSeleccionInfo.setValorN0(tramitesCreacionCasoInfo.getValorN0());
		 * tramitesSeleccionInfo.setValorN1(tramitesCreacionCasoInfo.getValorN1());
		 * tramitesSeleccionInfo.setValorN2(tramitesCreacionCasoInfo.getValorN2());
		 * tramitesSeleccionInfo.setValorN3(tramitesCreacionCasoInfo.getValorN3());
		 * 
		 * if (tramitesCreacionCasoInfo.getDesA0() != null) { if (!tramitesCreacionCasoInfo.getDesA0().equals("")) {
		 * inputInfoArchivo_tmp = new CreaCasoArchVista();
		 * inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA0());
		 * inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA0());
		 * inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri0());
		 * inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser0());
		 * inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe0());
		 * inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd0());
		 * inputInfoArchivos.add(inputInfoArchivo_tmp); } }
		 * 
		 * busquedaSubKey = obtenerKeyCrearTramite(tramitesSeleccionInfo);
		 * 
		 * for (final TramiteOpcion elemento : elementos) { if (elemento.getKey().equals(busquedaSubKey)) {
		 * elementoSeleccionado = elemento; } }
		 * 
		 * if (elementoSeleccionado != null) { if (elementoSeleccionado.getProcessID() != null &&
		 * elementoSeleccionado.getCategorizacion() != null) { processType = elementoSeleccionado.getProcessID();
		 * categoriza = elementoSeleccionado.getCategorizacion(); descripcion =
		 * elementoSeleccionado.getTramiteOpcion().getLabel(); bp = customerModel.getNumBP(); canal = "03"; mensaje =
		 * tramitesCreacionCasoInfo.getMensaje();
		 * 
		 * 
		 * atributo = new CreaCasosAtribRequest("String 1", "PROCESS_TYPE", processType); atributos.add(atributo);
		 * atributo = new CreaCasosAtribRequest("String 1", "DESCRIPCION", descripcion); atributos.add(atributo); atributo
		 * = new CreaCasosAtribRequest("String 1", "ID_DESCRIPCION", categoriza); atributos.add(atributo); atributo = new
		 * CreaCasosAtribRequest("String 1", "CONTRIBUYENTE", bp); atributos.add(atributo); atributo = new
		 * CreaCasosAtribRequest("String 1", "CANAL", canal); atributos.add(atributo); atributo = new
		 * CreaCasosAtribRequest("String 1", "COMENTARIO", mensaje); atributos.add(atributo);
		 * 
		 * // if (tramitesCreacionCasoInfo.getInfoArchivos() != null) if (inputInfoArchivos.size() > 0) { // final
		 * CreaCasoArchVista elemento = tramitesCreacionCasoInfo.getInfoArchivos(); // for (final CreaCasoArchVista
		 * elemento : tramitesCreacionCasoInfo.getInfoArchivos()) for (final CreaCasoArchVista elemento :
		 * inputInfoArchivos) { archivoCarga = new CreaCasosArchiRequest();
		 * archivoCarga.setZZWCC_DEPEND_ID(elemento.getDepend_id());
		 * archivoCarga.setZZWCC_SERIE_ID(elemento.getSerie_id());
		 * archivoCarga.setZZWCC_SSERIE_ID(elemento.getSserie_id());
		 * archivoCarga.setZZWCC_TIPODOC_ID(elemento.getTipoDoc_id());
		 * archivoCarga.setZZWCC_DESC_TIPODOC(elemento.getDescArchivo());
		 * archivoCarga.setZZWCC_ARCIVO(elemento.getContenidoArchivo()); archivos.add(archivoCarga); } archivosInfo = new
		 * CreaCasosArchiInfoRequest(); // archivosInfo.setLinea("String 1"); //
		 * archivosInfo.setIdentificador("PROCESS_TYPE"); // archivosInfo.setValor(elementoSeleccionado.getProcessID());
		 * archivosInfo.setArchivos(archivos); }
		 * 
		 * creaCasosRequest.setAtributos(atributos); creaCasosRequest.setArchivosInfo(archivosInfo);
		 * 
		 * System.out.println("Request para crm/creaCasos: " + creaCasosRequest); creaCasosResponse =
		 * gasolinaService.creacionCaso(creaCasosRequest, sdhDetalleGasolinaWS, LOG);
		 * System.out.println("Response de crm/creaCasos: " + creaCasosResponse); if
		 * (gasolinaService.ocurrioErrorCreacionCaso(creaCasosResponse) != true) { } else { } } }
		 */

		return "redirect:/login";
	}

	@RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
	public String getQuestions(final Model model, @RequestParam(value = "currentQuestion", defaultValue = "0")
	final int currentQuestion, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final ConsultaContribuyenteBPRequest bp = new ConsultaContribuyenteBPRequest();
		bp.setNumBP(getSessionService().getAttribute("numBP"));

		LOG.info(getSessionService().getAttribute("numBP"));

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse;
		try
		{
			sdhConsultaContribuyenteBPResponse = mapper.readValue(sdhConsultaContribuyenteBPService.consultaContribuyenteBP(bp),
					SDHValidaMailRolResponse.class);

			if (sdhConsultaContribuyenteBPResponse != null && (sdhConsultaContribuyenteBPResponse.getRoles() == null
					|| sdhConsultaContribuyenteBPResponse.getRoles().isEmpty()))
			{
				model.addAttribute("currentSection", "requestRols");
				model.addAttribute("tramitesCreacionCasoInfo", new TramitesCreacionCasoInfo());
				return getDefaultRegistrationPage(model);
			}
		}
		catch (final IOException e)
		{
			LOG.info(e.getMessage());
		}




		final QuestionForRegistrationResponse response = sdhGetQuestionsForRegistration.getQuestionForRegistration(bp);

		final String msg = "Estimado contribuyente, no cuentas con información suficiente para poder autenticarte, por favor dirígete a un punto de atención para generar tu información";

		if(response != null) {
			if(response.getIdmsj() != null) {
				if(!response.getIdmsj().equals("")) {
					final int noQuestions = new Integer(response.getIdmsj().replaceAll(" ",""));
					if(noQuestions < 3) {
						model.addAttribute("currentSection", "requestRols");
						return getDefaultRegistrationPage(model);
					}
				}
			}
		}

		model.addAttribute("questionAndOptions", response.getQuestionAndOptions());
		model.addAttribute("questionCatalog", response.getMapQuestionsCatalog());
		model.addAttribute("currentSection", "questionsSection");
		model.addAttribute("SecretAnswerForm", new SecretAnswerForm());

		return Objects.nonNull(response.getQuestionAndOptions())
				? response.getQuestionAndOptions().size() < 3 ? "redirect:/login" : getDefaultRegistrationPage(model)
				: getDefaultRegistrationPage(model);
	}

	@RequestMapping(value = "/validateAnswers", method = RequestMethod.POST)
	public String validateAnswer(final SecretAnswerForm form, final BindingResult bindingResult, final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		final ConsultaContribuyenteBPRequest bp = new ConsultaContribuyenteBPRequest();
		final String bpNumbre = getSessionService().getAttribute("numBP");
		final String uidUser = getSessionService().getAttribute("SMTP_ADDR");

		bp.setNumBP(bpNumbre);
		System.out.println("bpNumbre ------>"+bpNumbre);
		System.out.println("uidUser ------>"+uidUser);

		final QuestionForRegistrationResponse responseWS = sdhGetQuestionsForRegistration.getQuestionForRegistration(bp);

		final String msg = "La información que proporcionaste no fue correcta por lo cual no podemos confirmar tu identidad, por favor vuelve a intentarlo";

		int i = 0;

		if (form.getAGE() != null)
		{
			if (form.getAGE().equals(responseWS.getCorrectAnswer("AGE")))
			{
				i++;
			}
		}

		if (form.getDIR() != null)
		{
			if (form.getDIR().equals(responseWS.getCorrectAnswer("DIR")))
			{
				i++;
			}
		}

		if (form.getDIR2() != null)
		{
			if (form.getDIR2().equals(responseWS.getCorrectAnswer("DIR2")))
			{
				i++;
			}
		}

		if (form.getFNAM() != null)
		{
			if (form.getFNAM().equals(responseWS.getCorrectAnswer("FNAM")))
			{
				i++;
			}
		}

		if (form.getREDS() != null)
		{
			if (form.getREDS().equals(responseWS.getCorrectAnswer("REDS")))
			{
				i++;
			}
		}

		if (form.getTELM() != null)
		{
			if (form.getTELM().equals(responseWS.getCorrectAnswer("TELM")))
			{
				i++;
			}
		}

		if (form.getIMP() != null)
		{
			if (form.getIMP().equals(responseWS.getCorrectAnswer("IMP")))
			{
				i++;
			}
		}

		if (form.getPLA() != null)
		{
			if (form.getPLA().equals(responseWS.getCorrectAnswer("PLA")))
			{
				i++;
			}
		}

		if (form.getMAT() != null)
		{
			if (form.getMAT().equals(responseWS.getCorrectAnswer("MAT")))
			{
				i++;
			}
		}

		if (form.getBAN() != null)
		{
			if (form.getBAN().equals(responseWS.getCorrectAnswer("BAN")))
			{
				i++;
			}
		}

		if (form.getREL01() != null)
		{
			if (form.getREL01().equals(responseWS.getCorrectAnswer("REL01")))
			{
				i++;
			}
		}

		if (form.getREL02() != null)
		{
			if (form.getREL02().equals(responseWS.getCorrectAnswer("REL02")))
			{
				i++;
			}
		}

		if (form.getREL03() != null)
		{
			if (form.getREL03().equals(responseWS.getCorrectAnswer("REL03")))
			{
				i++;
			}
		}

		if (form.getREL04() != null)
		{
			if (form.getREL04().equals(responseWS.getCorrectAnswer("REL04")))
			{
				i++;
			}
		}

		if (form.getREL05() != null)
		{
			if (form.getREL05().equals(responseWS.getCorrectAnswer("REL05")))
			{
				i++;
			}
		}


		if (i < 3)
		{
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,msg);
			return "redirect:/login";
		}

		final String token = sdhCustomerAccountService.generateCustomerSessionToken(bpNumbre);
		System.out.println("generated token: " + token);

		return "redirect:/register/personalData?token=" +token;
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

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
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribBPRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.ItemSelectOption;
import de.hybris.sdh.core.pojos.responses.QuestionForRegistrationResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.pojos.responses.TramitesCreacionCasoInfo;
import de.hybris.sdh.core.pojos.responses.TramitesSeleccionInfo;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
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
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Register Controller for mobile. Handles login and register for the account flow.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterPageController extends SDHAbstractRegisterPageController
{
	public int valorBuzon = 5;
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

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

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

		final int valorBuzonData = valorBuzon;

		System.out.println(valorBuzonData);

		if(token.equals("null")) {
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,msg);
			return "redirect:/login";
		}

		final String uidUser = getSessionService().getAttribute("SMTP_ADDR");
		final String bpNumbre = getSessionService().getAttribute("numBP");


		sdhCustomerAccountService.validateToken(token,bpNumbre);
		model.addAttribute("valorBuzon", valorBuzon);
		model.addAttribute("currentSection", "personalDataSection");
		model.addAttribute("numBP", bpNumbre);
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

		//		//customerModel = (CustomerModel) userService.getCurrentUser();
		//		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		//		final TramitesSeleccionInfo tramitesSeleccionInfo = new TramitesSeleccionInfo();
		//		//final List<ItemSelectOption> elementosResponse = new ArrayList<ItemSelectOption>();
		//		final List<TramiteOpcion> elementos = new ArrayList<TramiteOpcion>();
		//		TramiteOpcion elementoSeleccionado = null;
		//		String busquedaSubKey = "";
		//		final CreaCasosRequest creaCasosRequest = new CreaCasosRequest();
		//		CreaCasosResponse creaCasosResponse = new CreaCasosResponse();
		//		final List<CreaCasosAtribRequest> atributos = new ArrayList<CreaCasosAtribRequest>();
		//		final List<CreaCasosArchiRequest> archivos = new ArrayList<CreaCasosArchiRequest>();
		//		final List<CreaCasoArchVista> inputInfoArchivos = new ArrayList<CreaCasoArchVista>();
		//		CreaCasoArchVista inputInfoArchivo_tmp = null;
		//		CreaCasosArchiRequest archivoCarga = null;
		//		CreaCasosArchiInfoRequest archivosInfo = null;
		//		CreaCasosAtribRequest atributo = null;
		//		String processType = "";
		//		String categoriza = "";
		//		String descripcion = "";
		//		String canal = "";
		//		String bp = "";
		//		String mensaje = "";
		//
		//
		//
		//		//01010101
		//		agregarElementoTramites(elementos, "01010101", "01", "Persona Natural", "ZT02", "A1ZTRT0004Z065");
		//		agregarElementoTramites(elementos, "01010102", "02", "Persona Jurídica", "ZT02", "A1ZTRT0004Z065");
		//
		//
		//		tramitesSeleccionInfo.setNivelSeleccion(tramitesCreacionCasoInfo.getNivelSeleccion());
		//		tramitesSeleccionInfo.setValorN0(tramitesCreacionCasoInfo.getValorN0());
		//		tramitesSeleccionInfo.setValorN1(tramitesCreacionCasoInfo.getValorN1());
		//		tramitesSeleccionInfo.setValorN2(tramitesCreacionCasoInfo.getValorN2());
		//		tramitesSeleccionInfo.setValorN3(tramitesCreacionCasoInfo.getValorN3());
		//
		//		if (tramitesCreacionCasoInfo.getDesA0() != null)
		//		{
		//			if (!tramitesCreacionCasoInfo.getDesA0().equals(""))
		//			{
		//				inputInfoArchivo_tmp = new CreaCasoArchVista();
		//				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA0());
		//				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA0());
		//				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri0());
		//				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser0());
		//				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe0());
		//				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd0());
		//				inputInfoArchivos.add(inputInfoArchivo_tmp);
		//			}
		//		}
		//
		//		busquedaSubKey = obtenerKeyCrearTramite(tramitesSeleccionInfo);
		//
		//		for (final TramiteOpcion elemento : elementos)
		//		{
		//			if (elemento.getKey().equals(busquedaSubKey))
		//			{
		//				elementoSeleccionado = elemento;
		//			}
		//		}
		//
		//		if (elementoSeleccionado != null)
		//		{
		//			if (elementoSeleccionado.getProcessID() != null && elementoSeleccionado.getCategorizacion() != null)
		//			{
		//				processType = elementoSeleccionado.getProcessID();
		//				categoriza = elementoSeleccionado.getCategorizacion();
		//				descripcion = elementoSeleccionado.getTramiteOpcion().getLabel();
		//				bp = getSessionService().getAttribute("numBP");
		//				canal = "03";
		//				mensaje = tramitesCreacionCasoInfo.getMensaje();
		//
		//
		//				atributo = new CreaCasosAtribRequest("String 1", "PROCESS_TYPE", processType);
		//				atributos.add(atributo);
		//				atributo = new CreaCasosAtribRequest("String 1", "DESCRIPCION", descripcion);
		//				atributos.add(atributo);
		//				atributo = new CreaCasosAtribRequest("String 1", "ID_DESCRIPCION", categoriza);
		//				atributos.add(atributo);
		//				atributo = new CreaCasosAtribRequest("String 1", "CONTRIBUYENTE", bp);
		//				atributos.add(atributo);
		//				atributo = new CreaCasosAtribRequest("String 1", "CANAL", canal);
		//				atributos.add(atributo);
		//				atributo = new CreaCasosAtribRequest("String 1", "COMENTARIO", mensaje);
		//				atributos.add(atributo);
		//
		//				if (inputInfoArchivos.size() > 0)
		//				{
		//					for (final CreaCasoArchVista elemento : inputInfoArchivos)
		//					{
		//            		archivoCarga = new CreaCasosArchiRequest();
		//            		archivoCarga.setZZWCC_DEPEND_ID(elemento.getDepend_id());
		//            		archivoCarga.setZZWCC_SERIE_ID(elemento.getSerie_id());
		//            		archivoCarga.setZZWCC_SSERIE_ID(elemento.getSserie_id());
		//            		archivoCarga.setZZWCC_TIPODOC_ID(elemento.getTipoDoc_id());
		//            		archivoCarga.setZZWCC_DESC_TIPODOC(elemento.getDescArchivo());
		//            		archivoCarga.setZZWCC_ARCIVO(elemento.getContenidoArchivo());
		//            		archivos.add(archivoCarga);
		//					}
		//					archivosInfo = new CreaCasosArchiInfoRequest();
		//					archivosInfo.setArchivos(archivos);
		//				}
		//
		//				creaCasosRequest.setAtributos(atributos);
		//				creaCasosRequest.setArchivosInfo(archivosInfo);
		//
		//				System.out.println("Request para crm/creaCasos: " + creaCasosRequest);
		//				creaCasosResponse = gasolinaService.creacionCaso(creaCasosRequest, sdhDetalleGasolinaWS, LOG);
		//				System.out.println("Response de crm/creaCasos: " + creaCasosResponse);
		//				//				if (gasolinaService.ocurrioErrorCreacionCaso(creaCasosResponse) != true)
		//				//				{
		//				//				}
		//				//				else
		//				//				{
		//				//				}
		//			}
		//		}


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
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse;
		try
		{
			final ConsultaContribBPRequest validaContribRequest = new ConsultaContribBPRequest();
			validaContribRequest.setNumBP(getSessionService().getAttribute("numBP"));
			validaContribRequest.setIndicador("01,02");
			sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP_simplificado_string(validaContribRequest),
					SDHValidaMailRolResponse.class);

			valorBuzon = sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOBUZONE();

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

		String returnValue = null;
		if (response != null)
		{
			model.addAttribute("questionAndOptions", response.getQuestionAndOptions());
			model.addAttribute("questionCatalog", response.getMapQuestionsCatalog());
			if (Objects.nonNull(response.getQuestionAndOptions()))
			{
				returnValue = response.getQuestionAndOptions().size() < 3 ? "redirect:/login" : getDefaultRegistrationPage(model);
			}
			else
			{
				returnValue = getDefaultRegistrationPage(model);
			}
		}
		model.addAttribute("currentSection", "questionsSection");
		model.addAttribute("SecretAnswerForm", new SecretAnswerForm());


		return returnValue;
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


		if (form.getREL06() != null)
		{
			if (form.getREL06().equals(responseWS.getCorrectAnswer("REL06")))
			{
				i++;
			}
		}

		if (form.getREL07() != null)
		{
			if (form.getREL07().equals(responseWS.getCorrectAnswer("REL07")))
			{
				i++;
			}
		}

		if (form.getREL08() != null)
		{
			if (form.getREL08().equals(responseWS.getCorrectAnswer("REL08")))
			{
				i++;
			}
		}

		if (form.getREL09() != null)
		{
			if (form.getREL09().equals(responseWS.getCorrectAnswer("REL09")))
			{
				i++;
			}
		}

		if (form.getREL10() != null)
		{
			if (form.getREL10().equals(responseWS.getCorrectAnswer("REL10")))
			{
				i++;
			}
		}


		if (form.getDIR2_0001() != null)
		{
			if (form.getDIR2_0001().equals(responseWS.getCorrectAnswer("DIR2_0001")))
			{
				i++;
			}
		}

		if (form.getDIR2_0002() != null)
		{
			if (form.getDIR2_0002().equals(responseWS.getCorrectAnswer("DIR2_0002")))
			{
				i++;
			}
		}

		if (form.getDIR2_0003() != null)
		{
			if (form.getDIR2_0003().equals(responseWS.getCorrectAnswer("DIR2_0003")))
			{
				i++;
			}
		}

		if (form.getDIR2_0004() != null)
		{
			if (form.getDIR2_0004().equals(responseWS.getCorrectAnswer("DIR2_0004")))
			{
				i++;
			}
		}

		if (form.getDIR2_0005() != null)
		{
			if (form.getDIR2_0005().equals(responseWS.getCorrectAnswer("DIR2_0005")))
			{
				i++;
			}
		}

		if (form.getDIR2_0006() != null)
		{
			if (form.getDIR2_0006().equals(responseWS.getCorrectAnswer("DIR2_0006")))
			{
				i++;
			}
		}

		if (form.getDIR2_0007() != null)
		{
			if (form.getDIR2_0007().equals(responseWS.getCorrectAnswer("DIR2_0007")))
			{
				i++;
			}
		}

		if (form.getDIR2_0008() != null)
		{
			if (form.getDIR2_0008().equals(responseWS.getCorrectAnswer("DIR2_0008")))
			{
				i++;
			}
		}

		if (form.getDIR2_0009() != null)
		{
			if (form.getDIR2_0009().equals(responseWS.getCorrectAnswer("DIR2_0009")))
			{
				i++;
			}
		}

		if (form.getDIR2_0010() != null)
		{
			if (form.getDIR2_0010().equals(responseWS.getCorrectAnswer("DIR2_0010")))
			{
				i++;
			}
		}

		if (form.getDIR2_0011() != null)
		{
			if (form.getDIR2_0011().equals(responseWS.getCorrectAnswer("DIR2_0011")))
			{
				i++;
			}
		}

		if (form.getDIR2_0012() != null)
		{
			if (form.getDIR2_0012().equals(responseWS.getCorrectAnswer("DIR2_0012")))
			{
				i++;
			}
		}

		if (form.getDIR2_0013() != null)
		{
			if (form.getDIR2_0013().equals(responseWS.getCorrectAnswer("DIR2_0013")))
			{
				i++;
			}
		}

		if (form.getDIR2_0014() != null)
		{
			if (form.getDIR2_0014().equals(responseWS.getCorrectAnswer("DIR2_0014")))
			{
				i++;
			}
		}

		if (form.getDIR2_0015() != null)
		{
			if (form.getDIR2_0015().equals(responseWS.getCorrectAnswer("DIR2_0015")))
			{
				i++;
			}
		}

		if (form.getDIR2_0016() != null)
		{
			if (form.getDIR2_0016().equals(responseWS.getCorrectAnswer("DIR2_0016")))
			{
				i++;
			}
		}

		if (form.getDIR2_0017() != null)
		{
			if (form.getDIR2_0017().equals(responseWS.getCorrectAnswer("DIR2_0017")))
			{
				i++;
			}
		}

		if (form.getDIR2_0018() != null)
		{
			if (form.getDIR2_0018().equals(responseWS.getCorrectAnswer("DIR2_0018")))
			{
				i++;
			}
		}

		if (form.getDIR2_0019() != null)
		{
			if (form.getDIR2_0019().equals(responseWS.getCorrectAnswer("DIR2_0019")))
			{
				i++;
			}
		}

		if (form.getDIR2_0020() != null)
		{
			if (form.getDIR2_0020().equals(responseWS.getCorrectAnswer("DIR2_0020")))
			{
				i++;
			}
		}

		if (form.getDIR2_0021() != null)
		{
			if (form.getDIR2_0021().equals(responseWS.getCorrectAnswer("DIR2_0021")))
			{
				i++;
			}
		}

		if (form.getDIR2_0022() != null)
		{
			if (form.getDIR2_0022().equals(responseWS.getCorrectAnswer("DIR2_0022")))
			{
				i++;
			}
		}

		if (form.getDIR2_0023() != null)
		{
			if (form.getDIR2_0023().equals(responseWS.getCorrectAnswer("DIR2_0023")))
			{
				i++;
			}
		}

		if (form.getDIR2_0024() != null)
		{
			if (form.getDIR2_0024().equals(responseWS.getCorrectAnswer("DIR2_0024")))
			{
				i++;
			}
		}

		if (form.getDIR2_0025() != null)
		{
			if (form.getDIR2_0025().equals(responseWS.getCorrectAnswer("DIR2_0025")))
			{
				i++;
			}
		}

		if (form.getDIR2_0026() != null)
		{
			if (form.getDIR2_0026().equals(responseWS.getCorrectAnswer("DIR2_0026")))
			{
				i++;
			}
		}

		if (form.getDIR2_0027() != null)
		{
			if (form.getDIR2_0027().equals(responseWS.getCorrectAnswer("DIR2_0027")))
			{
				i++;
			}
		}

		if (form.getDIR2_0028() != null)
		{
			if (form.getDIR2_0028().equals(responseWS.getCorrectAnswer("DIR2_0028")))
			{
				i++;
			}
		}

		if (form.getDIR2_0029() != null)
		{
			if (form.getDIR2_0029().equals(responseWS.getCorrectAnswer("DIR2_0029")))
			{
				i++;
			}
		}

		if (form.getDIR2_0030() != null)
		{
			if (form.getDIR2_0030().equals(responseWS.getCorrectAnswer("DIR2_0030")))
			{
				i++;
			}
		}






		if (form.getDIR_0001() != null)
		{
			if (form.getDIR_0001().equals(responseWS.getCorrectAnswer("DIR_0001")))
			{
				i++;
			}
		}

		if (form.getDIR_0002() != null)
		{
			if (form.getDIR_0002().equals(responseWS.getCorrectAnswer("DIR_0002")))
			{
				i++;
			}
		}

		if (form.getDIR_0003() != null)
		{
			if (form.getDIR_0003().equals(responseWS.getCorrectAnswer("DIR_0003")))
			{
				i++;
			}
		}

		if (form.getDIR_0004() != null)
		{
			if (form.getDIR_0004().equals(responseWS.getCorrectAnswer("DIR_0004")))
			{
				i++;
			}
		}

		if (form.getDIR_0005() != null)
		{
			if (form.getDIR_0005().equals(responseWS.getCorrectAnswer("DIR_0005")))
			{
				i++;
			}
		}

		if (form.getDIR_0006() != null)
		{
			if (form.getDIR_0006().equals(responseWS.getCorrectAnswer("DIR_0006")))
			{
				i++;
			}
		}

		if (form.getDIR_0007() != null)
		{
			if (form.getDIR_0007().equals(responseWS.getCorrectAnswer("DIR_0007")))
			{
				i++;
			}
		}

		if (form.getDIR_0008() != null)
		{
			if (form.getDIR_0008().equals(responseWS.getCorrectAnswer("DIR_0008")))
			{
				i++;
			}
		}

		if (form.getDIR_0009() != null)
		{
			if (form.getDIR_0009().equals(responseWS.getCorrectAnswer("DIR_0009")))
			{
				i++;
			}
		}

		if (form.getDIR_0010() != null)
		{
			if (form.getDIR_0010().equals(responseWS.getCorrectAnswer("DIR_0010")))
			{
				i++;
			}
		}



		if (form.getPLA_0001() != null)
		{
			if (form.getPLA_0001().equals(responseWS.getCorrectAnswer("PLA_0001")))
			{
				i++;
			}
		}

        if (form.getPLA_0002() != null)
        {
            if (form.getPLA_0002().equals(responseWS.getCorrectAnswer("PLA_0002")))
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
		form.setNumBP(getSessionService().getAttribute("numBP"));
		sdhRegistrationValidator.validate(form, bindingResult);

		return processRegisterUserRequest(null, form, bindingResult, model, request, response, redirectModel);

	}

	private void agregarElementoTramites(final List<TramiteOpcion> elementos, final String claveBusqueda,
			final String idTramiteOpcion, final String descripcionTramiteOpcion, final String processID,
			final String idCategorizacion)
	{
		elementos.add(new TramiteOpcion(claveBusqueda, new ItemSelectOption(idTramiteOpcion, descripcionTramiteOpcion), processID,
				idCategorizacion, "02"));

	}

	private String obtenerKeyCrearTramite(final TramitesSeleccionInfo infoSeleccion)
	{
		final StringBuffer sb = new StringBuffer();


		if (infoSeleccion.getValorN0() != null && !infoSeleccion.getValorN0().isEmpty())
		{
			sb.append(infoSeleccion.getValorN0());
			if (infoSeleccion.getValorN1() != null && !infoSeleccion.getValorN1().isEmpty())
			{
				sb.append(infoSeleccion.getValorN1());
				if (infoSeleccion.getValorN2() != null && !infoSeleccion.getValorN2().isEmpty())
				{
					sb.append(infoSeleccion.getValorN2());
					if (infoSeleccion.getValorN3() != null && !infoSeleccion.getValorN3().isEmpty())
					{
						sb.append(infoSeleccion.getValorN3());
					}
					else
					{
						sb.append("__");
					}
				}
				else
				{
					sb.append("____");
				}
			}
			else
			{
				sb.append("______");
			}
		}

		return sb.toString();
	}
}

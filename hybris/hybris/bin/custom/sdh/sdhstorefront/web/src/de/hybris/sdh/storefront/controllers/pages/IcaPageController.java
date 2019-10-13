/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.dao.impl.DefaultSDHICACityDao;
import de.hybris.sdh.core.dao.impl.DefaultSDHICAEconomicActivityDao;
import de.hybris.sdh.core.model.SDHICACityModel;
import de.hybris.sdh.core.model.SDHICAEconomicActivityModel;
import de.hybris.sdh.core.pojos.requests.CalcICA2Request;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.EnviaFirmasRequest;
import de.hybris.sdh.core.pojos.requests.FirmanteRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.ICACalculoImpRequest;
import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.responses.CalcICA2Response;
import de.hybris.sdh.core.pojos.responses.DetalleActivEconomicas;
import de.hybris.sdh.core.pojos.responses.EnviaFirmasResponse;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.ICACalculoImpResponse;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.ICAInfoDeclara;
import de.hybris.sdh.core.pojos.responses.ICAInfoIngFueraBog;
import de.hybris.sdh.core.pojos.responses.ICAInfoIngNetosGrava;
import de.hybris.sdh.core.pojos.responses.ICAInfoIngPorCiiu;
import de.hybris.sdh.core.pojos.responses.ICAInfoValorRetenido;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.core.services.SDHICACalculoImpService;
import de.hybris.sdh.core.services.SDHICAInfObjetoService;
import de.hybris.sdh.facades.SDHCalculaICA2Facade;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.SDHEnviaFirmasFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.EnviaFirmasForm;
import de.hybris.sdh.storefront.forms.FirmantesForm;
import de.hybris.sdh.storefront.forms.GeneraDeclaracionForm;
import de.hybris.sdh.storefront.forms.ICACalculaDeclaracionForm;
import de.hybris.sdh.storefront.forms.ICAInfObjetoForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller

public class IcaPageController extends SDHAbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);


	private static final String VACIO = "";

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.ica";
	private static final String DECLARACION_ACCOUNT_PROFILE = "Declaracion ICA";

	// CMS Pages
	private static final String ICA_CMS_PAGE = "icaPage";
	private static final String ICA_DOS_CMS_PAGE = "icaDosPage";
	private static final String ICA_DECLARACION_CMS_PAGE = "icaDeclaracionPage";

	private static final String REDIRECT_TO_ICA_PAGE = REDIRECT_PREFIX + "/contribuyentes/ica";
	private static final String REDIRECT_TO_ICA_DOS_PAGE = REDIRECT_PREFIX + "/contribuyentes/icados";
	private static final String REDIRECT_TO_ICA_DECLARACION_PAGE = REDIRECT_PREFIX + "/contribuyentes/ica/declaracion";

	@Resource(name = "sdhEnviaFirmasFacade")
	SDHEnviaFirmasFacade sdhEnviaFirmasFacade;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "modelService")
	ModelService modelService;

	@Resource(name = "mediaService")
	MediaService mediaService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhICAInfObjetoService")
	SDHICAInfObjetoService sdhICAInfObjetoService;

	@Resource(name = "sdhICACalculoImpService")
	SDHICACalculoImpService sdhICACalculoImpService;

	@Resource(name = "sdhGeneraDeclaracionService")
	SDHGeneraDeclaracionService sdhGeneraDeclaracionService;

	@Resource(name = "sdhICACityDao")
	DefaultSDHICACityDao sdhICACityDao;

	@Resource(name = "sdhICAEconomicAcitivityDao")
	DefaultSDHICAEconomicActivityDao sdhICAEconomicAcitivityDao;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "sdhCalculaICA2Facade")
	SDHCalculaICA2Facade sdhCalculaICA2Facade;

	@ModelAttribute("cities")
	public List<SDHICACityModel> getCities()
	{

		final List<SDHICACityModel> cities = sdhICACityDao.find();

		return cities;
	}

	@ModelAttribute("idTypes")
	public List<String> getIdTipes()
	{

		final List<String> idTypes = Arrays.asList("CC", "CE", "NIT", "PA", "TI", "TIE", "NITE", "NUIP");

		return idTypes;
	}

	@ModelAttribute("tarifasValorRetenido")
	public List<String> getTarifaValorRetenido()
	{

		final List<String> tarifasValorRetenido = Arrays.asList("4.14", "6.90", "7.00", "8.00", "9.66", "11.04", "13.80");

		return tarifasValorRetenido;
	}

	@ModelAttribute("econActivities")
	public List<SDHICAEconomicActivityModel> getEconActivities()
	{

		final List<SDHICAEconomicActivityModel> econActivities = sdhICAEconomicAcitivityDao.find();

		return econActivities;
	}

	@RequestMapping(value = "/contribuyentes/ica", method = RequestMethod.GET)
	@RequireHardLogIn
	public String icainicial(final Model model, final RedirectAttributes redirectModel, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET ICA --------------------------");



		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();

		if (customerModel.getNumBP() != null)
		{
			icaInfObjetoRequest.setNumBP(customerModel.getNumBP());
		}
		else
		{
			icaInfObjetoRequest.setNumBP(VACIO);
		}

		if (customerModel.getIcaTaxList().getObjectNumber() != null)
		{
			icaInfObjetoRequest.setNumObjeto(customerModel.getIcaTaxList().getObjectNumber());
		}
		else
		{
			icaInfObjetoRequest.setNumBP(VACIO);
		}

		final String anoGravable = request.getParameter("anoGravable");

		if (StringUtils.isBlank(anoGravable))
		{

			icaInfObjetoRequest.setAnoGravable("");
		}
		else
		{
			icaInfObjetoRequest.setAnoGravable(anoGravable);
		}

		final String periodo = request.getParameter("periodo");

		if (!StringUtils.isBlank(periodo))
		{
			icaInfObjetoRequest.setPeriodo(periodo);
		}
		else
		{
			icaInfObjetoRequest.setPeriodo("");
		}

		try
		{
			final ICAInfObjetoForm icaInfObjetoFormResp = new ICAInfObjetoForm();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final String response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);

			final ICAInfObjetoResponse icaInfObjetoResponse = mapper.readValue(response, ICAInfObjetoResponse.class);

			icaInfObjetoFormResp.setDocumentType(customerModel.getDocumentType());
			icaInfObjetoFormResp.setDocumentNumber(customerModel.getDocumentNumber());
			icaInfObjetoFormResp.setCompleteName(customerModel.getFirstName() + " " + customerModel.getLastName());
			icaInfObjetoFormResp.setIcaInfObjetoResponse(icaInfObjetoResponse);

			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
			model.addAttribute("numObjeto", icaInfObjetoRequest.getNumObjeto());
			model.addAttribute("anoGravable", icaInfObjetoResponse.getAnoGravable());
			model.addAttribute("periodo", icaInfObjetoResponse.getPeriodo());
		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/ica", method = RequestMethod.POST)
	@RequireHardLogIn
	public String icapost(final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de ICA------------------------");

		return REDIRECT_TO_ICA_PAGE;
	}


	@RequestMapping(value = "/contribuyentes/ica/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String ica2post(final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de ICA------------------------");

		return REDIRECT_TO_ICA_DOS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/ica/declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String icadeclarainicial(final Model model, @RequestParam(required = false, value = "anoGravable")
	final String panoGravable, @RequestParam(required = false, value = "numObjeto")
	final String pnumObjeto, @ModelAttribute("dataFormResponseICA")
	final SobreTasaGasolinaForm dataFormResponseICA, @ModelAttribute("periodoSeleccionado")
	final String periodoSeleccionado) throws CMSItemNotFoundException
	{
		String numObjeto;
		String anoGravable;

		final CustomerData customerData2 = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData2);
		addAgentsToModel(model, customerData2, null);
		model.addAttribute("redirectURL", "/contribuyentes/ica");

		ICAInfObjetoForm icaInfObjetoFormResp = new ICAInfObjetoForm();
		ICAInfObjetoResponse icaInfObjetoResponse = new ICAInfObjetoResponse();

		if (StringUtils.isAllBlank(pnumObjeto, panoGravable))
		{
			numObjeto = dataFormResponseICA.getNumObjeto();
			anoGravable = dataFormResponseICA.getAnoGravable();
		}
		else
		{
			numObjeto = pnumObjeto;
			anoGravable = panoGravable;
		}
		if (StringUtils.isAllBlank(numObjeto, anoGravable))
		{
			return REDIRECT_TO_ICA_PAGE;
		}

		addAgentsToModel(model, customerFacade.getCurrentCustomer());
		model.addAttribute("customerData", customerFacade.getCurrentCustomer());
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();

		icaInfObjetoRequest.setNumBP(customerModel.getNumBP());
		icaInfObjetoRequest.setNumObjeto(numObjeto);
		icaInfObjetoRequest.setAnoGravable(anoGravable);

		if (!StringUtils.isBlank(periodoSeleccionado))
		{
			icaInfObjetoRequest.setPeriodo(periodoSeleccionado);
		}
		else
		{
			icaInfObjetoRequest.setPeriodo("");
		}

		try
		{
			icaInfObjetoFormResp = new ICAInfObjetoForm();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final String response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);

			icaInfObjetoResponse = mapper.readValue(response, ICAInfObjetoResponse.class);

			icaInfObjetoFormResp.setDocumentType(customerModel.getDocumentType());
			icaInfObjetoFormResp.setDocumentNumber(customerModel.getDocumentNumber());
			icaInfObjetoFormResp.setCompleteName(customerModel.getFirstName() + " " + customerModel.getLastName());
			icaInfObjetoFormResp.setIcaInfObjetoResponse(icaInfObjetoResponse);

			final List<ICAInfoIngPorCiiu> IngPorCIIUList = icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara()
					.getIngPorCIIU();

			for (int i = 0; i < IngPorCIIUList.size(); i++)
			{
				if (IngPorCIIUList.get(i).getNumID() == null)
				{
					IngPorCIIUList.remove(i);
				}
			}
			icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara().setIngPorCIIU(IngPorCIIUList);


			final List<ICAInfoValorRetenido> ICAInfoValorRetenidoList = icaInfObjetoFormResp.getIcaInfObjetoResponse()
					.getInfoDeclara().getValorRetenido();

			for (int i = 0; i < ICAInfoValorRetenidoList.size(); i++)
			{
				if (ICAInfoValorRetenidoList.get(i).getNumID() == null)
				{
					ICAInfoValorRetenidoList.remove(i);
				}
			}
			icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara().setValorRetenido(ICAInfoValorRetenidoList);

			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
			model.addAttribute("numObjeto", icaInfObjetoRequest.getNumObjeto());
			model.addAttribute("anoGravable", icaInfObjetoResponse.getAnoGravable());
			model.addAttribute("periodo", icaInfObjetoResponse.getPeriodo());
			//redirectModel.addFlashAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);


		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());

			final ICAInfoDeclara infoDeclara = new ICAInfoDeclara();
			final List<ICAInfoIngFueraBog> listInfFueraBog = new ArrayList<ICAInfoIngFueraBog>();
			final List<ICAInfoValorRetenido> listvalorRetenido = new ArrayList<ICAInfoValorRetenido>();
			final List<ICAInfoIngNetosGrava> listIngNetosGrava = new ArrayList<ICAInfoIngNetosGrava>();
			final List<ICAInfoIngPorCiiu> listIngPorCIIU = new ArrayList<ICAInfoIngPorCiiu>();


			listInfFueraBog.add(new ICAInfoIngFueraBog());
			listvalorRetenido.add(new ICAInfoValorRetenido());
			listIngNetosGrava.add(new ICAInfoIngNetosGrava());
			listIngPorCIIU.add(new ICAInfoIngPorCiiu());

			infoDeclara.setIngFueraBog(listInfFueraBog);
			infoDeclara.setValorRetenido(listvalorRetenido);
			infoDeclara.setIngNetosGrava(listIngNetosGrava);
			infoDeclara.setIngPorCIIU(listIngPorCIIU);

			icaInfObjetoResponse.setInfoDeclara(infoDeclara);
			icaInfObjetoFormResp.setIcaInfObjetoResponse(icaInfObjetoResponse);
			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
		}

		//informacion para PSE
		final CustomerModel customerData = (CustomerModel) userService.getCurrentUser();
		final String numBP = customerData.getNumBP();

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();
		//		final String mensajeError = "";
		String[] mensajesError;


		contribuyenteRequest.setNumBP(numBP);

		System.out.println("Request de validaCont: " + contribuyenteRequest);
		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		System.out.println("Response de validaCont: " + detalleContribuyente);
		if (gasolinaService.ocurrioErrorValcont(detalleContribuyente) != true)
		{
			if (icaInfObjetoResponse.getAnoGravable() != null)
			{
				infoPreviaPSE.setAnoGravable(icaInfObjetoResponse.getAnoGravable().trim());
			}
			infoPreviaPSE.setTipoDoc(customerData.getDocumentType());
			infoPreviaPSE.setNumDoc(customerData.getDocumentNumber());
			infoPreviaPSE.setNumBP(numBP);
			try
			{
				infoPreviaPSE.setClavePeriodo(gasolinaService.prepararClavePeriodoICA(icaInfObjetoResponse));
			}
			catch (final Exception e)
			{
				infoPreviaPSE.setClavePeriodo(icaInfObjetoResponse.getPeriodo());
			}
			infoPreviaPSE.setNumObjeto(gasolinaService.prepararNumObjetoICA(detalleContribuyente));
			infoPreviaPSE.setDv(gasolinaService.prepararDV(detalleContribuyente));
			infoPreviaPSE.setTipoImpuesto(new ControllerPseConstants().getICA());
		}
		else
		{
			LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(
					gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
		}
		model.addAttribute("infoPreviaPSE", infoPreviaPSE);

		model.addAttribute("gravableNetIncomes",
				this.getGravableNetIncomes(numBP, numObjeto, anoGravable, icaInfObjetoRequest.getPeriodo()));
		//informacion para PSE

		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(DECLARACION_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/ica/declaracion/show", method = RequestMethod.GET)
	@RequireHardLogIn
	public String icadeclarainicial_aa(final Model model, @RequestParam(required = false, value = "anoGravable")
	final String panoGravable, @ModelAttribute("dataFormResponseICA")
	final SobreTasaGasolinaForm dataFormResponseICA, @ModelAttribute("periodoSeleccionado")
	final String periodoSeleccionado, @RequestParam(required = true, value = "numForm")
	final String numForm, @RequestParam(required = true, value = "representado")
	final String representado) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Declaracion ICA Agente Autorizado GET --------------------------");

		final CustomerData currentUserData = this.getCustomerFacade().getCurrentCustomer();
		final CustomerData contribuyenteData = sdhCustomerFacade.getRepresentadoDataFromSAP(representado);
		final SDHValidaMailRolResponse contribuyenteData2 = sdhCustomerFacade.getRepresentadoFromSAP(representado);

		model.addAttribute("contribuyenteData", contribuyenteData);
		model.addAttribute("currentUserData", currentUserData);
		model.addAttribute("redirectURL", "/autorizados/contribuyente/representando?representado=" + contribuyenteData.getNumBP());
		final CalcICA2Request calcula2ImpuestoRequest = new CalcICA2Request();
		calcula2ImpuestoRequest.setPartner(representado);
		calcula2ImpuestoRequest.setFormulario(numForm);
		final CalcICA2Response calcula2ImpuestoResponse = sdhCalculaICA2Facade.calcula(calcula2ImpuestoRequest);

		if (calcula2ImpuestoResponse != null)
		{
			super.addFirmantes_impuesto(model, calcula2ImpuestoResponse.getFirmantes(), currentUserData);
		}

		final String pnumObjeto = contribuyenteData2.getIca().getNumObjeto();

		String numObjeto;
		String anoGravable;

		//		final CustomerData customerData2 = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", currentUserData);
		addAgentsToModel(model, currentUserData, null);
		model.addAttribute("redirectURL", "/contribuyentes/ica");

		ICAInfObjetoForm icaInfObjetoFormResp = new ICAInfObjetoForm();
		ICAInfObjetoResponse icaInfObjetoResponse = new ICAInfObjetoResponse();

		if (StringUtils.isAllBlank(pnumObjeto, panoGravable))
		{
			numObjeto = dataFormResponseICA.getNumObjeto();
			anoGravable = dataFormResponseICA.getAnoGravable();
		}
		else
		{
			numObjeto = pnumObjeto;
			anoGravable = panoGravable;
		}
		if (StringUtils.isAllBlank(numObjeto, anoGravable))
		{
			return REDIRECT_TO_ICA_PAGE;
		}

		//		addAgentsToModel(model, customerFacade.getCurrentCustomer());
		//		model.addAttribute("customerData", customerFacade.getCurrentCustomer());
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();

		icaInfObjetoRequest.setNumBP(representado);
		icaInfObjetoRequest.setNumObjeto(numObjeto);
		icaInfObjetoRequest.setAnoGravable(anoGravable);

		if (!StringUtils.isBlank(periodoSeleccionado))
		{
			icaInfObjetoRequest.setPeriodo(periodoSeleccionado);
		}
		else
		{
			icaInfObjetoRequest.setPeriodo("");
		}

		try
		{
			icaInfObjetoFormResp = new ICAInfObjetoForm();

			//			final ObjectMapper mapper = new ObjectMapper();
			//			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			//			final String response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);
			//
			//						icaInfObjetoResponse = mapper.readValue(response, ICAInfObjetoResponse.class);
			//			Remapeo INICIO
			icaInfObjetoResponse = new ICAInfObjetoResponse();
			List<ICAInfoValorRetenido> valorRetenido = new ArrayList<ICAInfoValorRetenido>();

			final ICAInfoDeclara infoDeclara = new ICAInfoDeclara();
			infoDeclara.setIngPorCIIU(calcula2ImpuestoResponse.getIngPorCIIU());
			infoDeclara.setTotalIngrPeriodo(calcula2ImpuestoResponse.getTotalIngrPeriodo());
			infoDeclara.setTotalingFueraBog(calcula2ImpuestoResponse.getTotalingFueraBog());
			infoDeclara.setTotalingBrutos(calcula2ImpuestoResponse.getTotalingBrutos());
			infoDeclara.setDevolDescuentos(calcula2ImpuestoResponse.getDevolDescuentos());

			valorRetenido.add(calcula2ImpuestoResponse.getValorRetenido());
			infoDeclara.setValorRetenido(valorRetenido);
			infoDeclara.setIngNetosGrava(calcula2ImpuestoResponse.getIngNetosGrava());
			infoDeclara.setIngFueraBog(calcula2ImpuestoResponse.getIngFueraBog());
			infoDeclara.setDeducciones(calcula2ImpuestoResponse.getDeducciones());
			infoDeclara.setIngPorCIIU(calcula2ImpuestoResponse.getIngPorCIIU());

			infoDeclara.setTotalDeduccion(calcula2ImpuestoResponse.getTotalDeduccion());
			infoDeclara.setTotalingNetos(calcula2ImpuestoResponse.getTotalingNetos());
			infoDeclara.setImpIndusComer(calcula2ImpuestoResponse.getImpIndusComer());
			infoDeclara.setImpuestoAviso(calcula2ImpuestoResponse.getImpuestoAviso());
			infoDeclara.setTotalUnidadAdic(calcula2ImpuestoResponse.getTotalUnidadAdic());
			infoDeclara.setImpuestoCargo(calcula2ImpuestoResponse.getImpuestoCargo());
			infoDeclara.setValorReteIndus(calcula2ImpuestoResponse.getValorReteIndus());
			infoDeclara.setSaldoCargo(calcula2ImpuestoResponse.getSaldoCargo());
			infoDeclara.setValorPagar(calcula2ImpuestoResponse.getValorPagar());
			infoDeclara.setSanciones(calcula2ImpuestoResponse.getSanciones());
			infoDeclara.setInteresMora(calcula2ImpuestoResponse.getInteresMora());
			infoDeclara.setTotalPagar(calcula2ImpuestoResponse.getTotalPagar());
			infoDeclara.setCheckAporte(calcula2ImpuestoResponse.getCheckAporte());
			infoDeclara.setProyectoAporte(calcula2ImpuestoResponse.getProyectoAporte());
			infoDeclara.setTarifaAporte(calcula2ImpuestoResponse.getTarifaAporte());
			infoDeclara.setTotalAporteVolun(calcula2ImpuestoResponse.getTotalAporteVolun());

			//			private String valorImpAviso;
			icaInfObjetoResponse.setInfoDeclara(infoDeclara);

			icaInfObjetoResponse.setAnoGravable(calcula2ImpuestoResponse.getAnio_gravable());
			icaInfObjetoResponse.setPeriodo(calcula2ImpuestoResponse.getPeriodo());
			icaInfObjetoResponse.setCantEstablec(calcula2ImpuestoResponse.getCantEstablec());
			icaInfObjetoResponse.setRegimen(calcula2ImpuestoResponse.getRegimen());
			icaInfObjetoResponse.setOpcionUso(calcula2ImpuestoResponse.getOpcionUso());
			//			Remapeo FIN

			icaInfObjetoFormResp.setDocumentType(customerModel.getDocumentType());
			icaInfObjetoFormResp.setDocumentNumber(customerModel.getDocumentNumber());
			icaInfObjetoFormResp.setCompleteName(customerModel.getFirstName() + " " + customerModel.getLastName());
			icaInfObjetoFormResp.setIcaInfObjetoResponse(icaInfObjetoResponse);

			final List<ICAInfoIngPorCiiu> IngPorCIIUList = icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara()
					.getIngPorCIIU();

			if (IngPorCIIUList != null)
			{
				for (int i = 0; i < IngPorCIIUList.size(); i++)
				{
					if (IngPorCIIUList.get(i).getNumID() == null)
					{
						IngPorCIIUList.remove(i);
					}
				}
			}
			icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara().setIngPorCIIU(IngPorCIIUList);


			final List<ICAInfoValorRetenido> ICAInfoValorRetenidoList = icaInfObjetoFormResp.getIcaInfObjetoResponse()
					.getInfoDeclara().getValorRetenido();

			if (ICAInfoValorRetenidoList != null)
			{
				for (int i = 0; i < ICAInfoValorRetenidoList.size(); i++)
				{
					if (ICAInfoValorRetenidoList.get(i).getNumID() == null)
					{
						ICAInfoValorRetenidoList.remove(i);
					}
				}
			}
			icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara().setValorRetenido(ICAInfoValorRetenidoList);

			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
			model.addAttribute("numObjeto", icaInfObjetoRequest.getNumObjeto());
			model.addAttribute("anoGravable", icaInfObjetoResponse.getAnoGravable());
			model.addAttribute("periodo", icaInfObjetoResponse.getPeriodo());
			//			redirectModel.addFlashAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);


		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());

			final ICAInfoDeclara infoDeclara = new ICAInfoDeclara();
			final List<ICAInfoIngFueraBog> listInfFueraBog = new ArrayList<ICAInfoIngFueraBog>();
			final List<ICAInfoValorRetenido> listvalorRetenido = new ArrayList<ICAInfoValorRetenido>();
			final List<ICAInfoIngNetosGrava> listIngNetosGrava = new ArrayList<ICAInfoIngNetosGrava>();
			final List<ICAInfoIngPorCiiu> listIngPorCIIU = new ArrayList<ICAInfoIngPorCiiu>();


			listInfFueraBog.add(new ICAInfoIngFueraBog());
			listvalorRetenido.add(new ICAInfoValorRetenido());
			listIngNetosGrava.add(new ICAInfoIngNetosGrava());
			listIngPorCIIU.add(new ICAInfoIngPorCiiu());

			infoDeclara.setIngFueraBog(listInfFueraBog);
			infoDeclara.setValorRetenido(listvalorRetenido);
			infoDeclara.setIngNetosGrava(listIngNetosGrava);
			infoDeclara.setIngPorCIIU(listIngPorCIIU);

			icaInfObjetoResponse.setInfoDeclara(infoDeclara);
			icaInfObjetoFormResp.setIcaInfObjetoResponse(icaInfObjetoResponse);
			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
		}

		//informacion para PSE
		final CustomerModel customerData = (CustomerModel) userService.getCurrentUser();
		final String numBP = customerData.getNumBP();

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();
		//		final String mensajeError = "";
		String[] mensajesError;


		contribuyenteRequest.setNumBP(numBP);

		System.out.println("Request de validaCont: " + contribuyenteRequest);
		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		System.out.println("Response de validaCont: " + detalleContribuyente);
		if (gasolinaService.ocurrioErrorValcont(detalleContribuyente) != true)
		{
			if (icaInfObjetoResponse.getAnoGravable() != null)
			{
				infoPreviaPSE.setAnoGravable(icaInfObjetoResponse.getAnoGravable().trim());
			}
			infoPreviaPSE.setTipoDoc(customerData.getDocumentType());
			infoPreviaPSE.setNumDoc(customerData.getDocumentNumber());
			infoPreviaPSE.setNumBP(numBP);
			try
			{
				infoPreviaPSE.setClavePeriodo(gasolinaService.prepararClavePeriodoICA(icaInfObjetoResponse));
			}
			catch (final Exception e)
			{
				infoPreviaPSE.setClavePeriodo(icaInfObjetoResponse.getPeriodo());
			}
			infoPreviaPSE.setNumObjeto(gasolinaService.prepararNumObjetoICA(detalleContribuyente));
			infoPreviaPSE.setDv(gasolinaService.prepararDV(detalleContribuyente));
			infoPreviaPSE.setTipoImpuesto(new ControllerPseConstants().getICA());
		}
		else
		{
			LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(
					gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
		}
		model.addAttribute("infoPreviaPSE", infoPreviaPSE);

		model.addAttribute("gravableNetIncomes",
				this.getGravableNetIncomes(numBP, numObjeto, anoGravable, icaInfObjetoRequest.getPeriodo()));
		//informacion para PSE

		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(DECLARACION_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/ica/declaracion/calculo", method = RequestMethod.POST)
	@ResponseBody
	public ICACalculoImpResponse calculo(@RequestBody
	final ICACalculaDeclaracionForm icaCalculaDeclaracionForm) throws CMSItemNotFoundException
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		ICACalculoImpResponse icaCalculoImpResponse = new ICACalculoImpResponse();
		final ICACalculoImpRequest icaCalculoImpRequest = new ICACalculoImpRequest();

		icaCalculoImpRequest.setNumObjeto(icaCalculaDeclaracionForm.getNumObjeto());
		icaCalculoImpRequest.setNumForm(icaCalculaDeclaracionForm.getNumForm());
		icaCalculoImpRequest.setAnoGravable(icaCalculaDeclaracionForm.getAnoGravable());
		icaCalculoImpRequest.setPeriodo(icaCalculaDeclaracionForm.getPeriodo());
		icaCalculoImpRequest.setNumBP(customerModel.getNumBP());
		icaCalculoImpRequest.setCantEstablec(icaCalculaDeclaracionForm.getCantEstablec());
		icaCalculoImpRequest.setEntFinanciera(icaCalculaDeclaracionForm.getEntFinanciera());
		icaCalculoImpRequest.setImpuestoAviso(icaCalculaDeclaracionForm.getImpuestoAviso());
		icaCalculoImpRequest.setValorImpAviso(icaCalculaDeclaracionForm.getValorImpAviso());
		icaCalculoImpRequest.setTotalIngrPeriodo(icaCalculaDeclaracionForm.getTotalIngrPeriodo());
		icaCalculoImpRequest.setValorPagar(icaCalculaDeclaracionForm.getValorPagar());
		icaCalculoImpRequest.setCheckAporte(icaCalculaDeclaracionForm.getCheckAporte());
		icaCalculoImpRequest.setProyectoAporte(icaCalculaDeclaracionForm.getProyectoAporte());
		icaCalculoImpRequest.setTarifaAporte(icaCalculaDeclaracionForm.getTarifaAporte());
		icaCalculoImpRequest.setIngFueraBog(icaCalculaDeclaracionForm.getIngFueraBog());
		icaCalculoImpRequest.setDeducciones(icaCalculaDeclaracionForm.getDeducciones());
		icaCalculoImpRequest.setIngNetosGrava(icaCalculaDeclaracionForm.getIngNetosGrava());
		icaCalculoImpRequest.setIngPorCIIU(icaCalculaDeclaracionForm.getIngPorCIIU());
		icaCalculoImpRequest.setValorRetenido(icaCalculaDeclaracionForm.getValorRetenido());
		icaCalculoImpRequest.setRelaciones(icaCalculaDeclaracionForm.getRelaciones());

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			icaCalculoImpResponse = mapper.readValue(sdhICACalculoImpService.consultaICACalculoImp(icaCalculoImpRequest),
					ICACalculoImpResponse.class);


		}


		catch (final Exception e)
		{
			LOG.error("error calculating ica declaration: " + e.getMessage());

			final ErrorEnWS error = new ErrorEnWS();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error al realizar el cálculo, por favor intentalo más tarde");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();

			errores.add(error);

			icaCalculoImpResponse.setErrores(errores);

		}


		return icaCalculoImpResponse;

	}

	@RequestMapping(value = "/contribuyentes/ica/firmar", method = RequestMethod.POST)
	@ResponseBody
	public EnviaFirmasResponse enviaFirmas(final Model model, @RequestBody
	final EnviaFirmasForm dataForm, final HttpServletResponse response, final HttpServletRequest request)
	{
		final EnviaFirmasRequest enviaFirmasRequest = new EnviaFirmasRequest();

		enviaFirmasRequest.setNumForm(dataForm.getNumForm());


		if (CollectionUtils.isNotEmpty(dataForm.getFirmantes()))
		{
			final List<FirmanteRequest> firmantesList = new ArrayList<FirmanteRequest>();
			for (final FirmantesForm eachFirmante : dataForm.getFirmantes())
			{
				final FirmanteRequest firmante = new FirmanteRequest();

				firmante.setConfirmacion(eachFirmante.getConfirmacion());
				firmante.setFirmante(eachFirmante.getFirmante());
				firmante.setNumIdentif(eachFirmante.getNumIdentif());
				firmante.setTipoIdent(eachFirmante.getTipoIdent());


				firmantesList.add(firmante);
			}
			enviaFirmasRequest.setTablFirmante(firmantesList);
		}

		return sdhEnviaFirmasFacade.enviaFirmas(enviaFirmasRequest);
	}

	@RequestMapping(value = "/generar", method = RequestMethod.POST)
	@ResponseBody
	public GeneraDeclaracionResponse generar(final GeneraDeclaracionForm dataForm, final HttpServletResponse response,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		GeneraDeclaracionResponse generaDeclaracionResponse = new GeneraDeclaracionResponse();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String numForm = request.getParameter("numForm");

		if (StringUtils.isBlank(numForm))
		{
			numForm = dataForm.getNumForm();
		}

		final GeneraDeclaracionRequest generaDeclaracionRequest = new GeneraDeclaracionRequest();


		generaDeclaracionRequest.setNumForm(numForm);
		generaDeclaracionRequest.setTipo_id(customerModel.getDocumentType());
		generaDeclaracionRequest.setNum_id(customerModel.getDocumentNumber());

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			generaDeclaracionResponse = mapper.readValue(sdhGeneraDeclaracionService.generaDeclaracion(generaDeclaracionRequest),
					GeneraDeclaracionResponse.class);

			if (generaDeclaracionResponse != null && generaDeclaracionResponse.getStringPDF() != null)
			{
				final String encodedBytes = generaDeclaracionResponse.getStringPDF();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = numForm + "-" + customerModel.getNumBP() + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE.booleanValue());
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				generaDeclaracionResponse.setUrlDownload(mediaModel.getDownloadURL());


			}

		}
		catch (final Exception e)
		{
			LOG.error("error generating declaration : " + e.getMessage());

			final ErrorPubli error = new ErrorPubli();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error al generar la declaración, por favor intentalo más tarde");

			final List<ErrorPubli> errores = new ArrayList<ErrorPubli>();

			errores.add(error);

			generaDeclaracionResponse.setErrores(errores);

		}

		return generaDeclaracionResponse;

	}

	private List<DetalleActivEconomicas> getGravableNetIncomes(final String numBp, final String numObjeto,
			final String anioGravable, final String periodo)
	{
		final ICAInfObjetoRequest ica = new ICAInfObjetoRequest();
		ica.setNumBP(numBp);
		ica.setNumObjeto(numObjeto);
		ica.setAnoGravable(anioGravable);
		ica.setPeriodo(periodo);

		final ICAInfObjetoResponse responseICA = sdhICAInfObjetoService.consultaICAInfObjetoReturningObject(ica);

		return Objects.nonNull(responseICA.getActivEconomicas()) ? responseICA.getActivEconomicas()
				: new ArrayList<DetalleActivEconomicas>();
	}


	//	@RequestMapping(value = "/contribuyentes/ica/declaracion/show", method = RequestMethod.GET)
	//	@RequireHardLogIn
	//	public String show(final Model model, @RequestParam(required = false, value = "numForm")
	//	final String numForm, @RequestParam(required = false, value = "partner")
	//	final String partner) throws CMSItemNotFoundException
	//	{
	//		CalcICA2Request request = new CalcICA2Request();
	//
	//		request.setFormulario(numForm);
	//		request.setPartner(partner);
	//
	//
	//		ICAInfObjetoForm icaInfObjetoFormResp = new ICAInfObjetoForm();
	//		ICAInfObjetoResponse icaInfObjetoResponse = new ICAInfObjetoResponse();
	//
	//		if (StringUtils.isAllBlank(pnumObjeto, panoGravable))
	//		{
	//			numObjeto = dataFormResponseICA.getNumObjeto();
	//			anoGravable = dataFormResponseICA.getAnoGravable();
	//		}
	//		else
	//		{
	//			numObjeto = pnumObjeto;
	//			anoGravable = panoGravable;
	//		}
	//		if (StringUtils.isAllBlank(numObjeto, anoGravable))
	//		{
	//			return REDIRECT_TO_ICA_PAGE;
	//		}
	//
	//		addAgentsToModel(model, customerFacade.getCurrentCustomer());
	//		model.addAttribute("customerData",customerFacade.getCurrentCustomer());
	//		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
	//		final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();
	//
	//		icaInfObjetoRequest.setNumBP(customerModel.getNumBP());
	//		icaInfObjetoRequest.setNumObjeto(numObjeto);
	//		icaInfObjetoRequest.setAnoGravable(anoGravable);
	//
	//		if (!StringUtils.isBlank(periodoSeleccionado))
	//		{
	//			icaInfObjetoRequest.setPeriodo(periodoSeleccionado);
	//		}
	//		else
	//		{
	//			icaInfObjetoRequest.setPeriodo("");
	//		}
	//
	//		try
	//		{
	//			icaInfObjetoFormResp = new ICAInfObjetoForm();
	//
	//			final ObjectMapper mapper = new ObjectMapper();
	//			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	//
	//
	//			final String response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);
	//
	//			icaInfObjetoResponse = mapper.readValue(response, ICAInfObjetoResponse.class);
	//
	//			icaInfObjetoFormResp.setDocumentType(customerModel.getDocumentType());
	//			icaInfObjetoFormResp.setDocumentNumber(customerModel.getDocumentNumber());
	//			icaInfObjetoFormResp.setCompleteName(customerModel.getFirstName() + " " + customerModel.getLastName());
	//			icaInfObjetoFormResp.setIcaInfObjetoResponse(icaInfObjetoResponse);
	//
	//			final List<ICAInfoIngPorCiiu> IngPorCIIUList = icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara()
	//					.getIngPorCIIU();
	//
	//			for (int i = 0; i < IngPorCIIUList.size(); i++)
	//			{
	//				if (IngPorCIIUList.get(i).getNumID() == null)
	//				{
	//					IngPorCIIUList.remove(i);
	//				}
	//			}
	//			icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara().setIngPorCIIU(IngPorCIIUList);
	//
	//
	//			final List<ICAInfoValorRetenido> ICAInfoValorRetenidoList = icaInfObjetoFormResp.getIcaInfObjetoResponse()
	//					.getInfoDeclara().getValorRetenido();
	//
	//			for (int i = 0; i < ICAInfoValorRetenidoList.size(); i++)
	//			{
	//				if (ICAInfoValorRetenidoList.get(i).getNumID() == null)
	//				{
	//					ICAInfoValorRetenidoList.remove(i);
	//				}
	//			}
	//			icaInfObjetoFormResp.getIcaInfObjetoResponse().getInfoDeclara().setValorRetenido(ICAInfoValorRetenidoList);
	//
	//			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
	//			model.addAttribute("numObjeto", icaInfObjetoRequest.getNumObjeto());
	//			model.addAttribute("anoGravable", icaInfObjetoResponse.getAnoGravable());
	//			model.addAttribute("periodo", icaInfObjetoResponse.getPeriodo());
	//			//redirectModel.addFlashAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
	//
	//
	//		}
	//		catch (final Exception e)
	//		{
	//			LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());
	//
	//			final ICAInfoDeclara infoDeclara = new ICAInfoDeclara();
	//			final List<ICAInfoIngFueraBog> listInfFueraBog = new ArrayList<ICAInfoIngFueraBog>();
	//			final List<ICAInfoValorRetenido> listvalorRetenido = new ArrayList<ICAInfoValorRetenido>();
	//			final List<ICAInfoIngNetosGrava> listIngNetosGrava = new ArrayList<ICAInfoIngNetosGrava>();
	//			final List<ICAInfoIngPorCiiu> listIngPorCIIU = new ArrayList<ICAInfoIngPorCiiu>();
	//
	//
	//			listInfFueraBog.add(new ICAInfoIngFueraBog());
	//			listvalorRetenido.add(new ICAInfoValorRetenido());
	//			listIngNetosGrava.add(new ICAInfoIngNetosGrava());
	//			listIngPorCIIU.add(new ICAInfoIngPorCiiu());
	//
	//			infoDeclara.setIngFueraBog(listInfFueraBog);
	//			infoDeclara.setValorRetenido(listvalorRetenido);
	//			infoDeclara.setIngNetosGrava(listIngNetosGrava);
	//			infoDeclara.setIngPorCIIU(listIngPorCIIU);
	//
	//			icaInfObjetoResponse.setInfoDeclara(infoDeclara);
	//			icaInfObjetoFormResp.setIcaInfObjetoResponse(icaInfObjetoResponse);
	//			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
	//		}
	//
	//		//informacion para PSE
	//		final CustomerModel customerData = (CustomerModel) userService.getCurrentUser();
	//		final String numBP = customerData.getNumBP();
	//
	//		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
	//		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();
	//		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
	//		SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();
	//		//		final String mensajeError = "";
	//		String[] mensajesError;
	//
	//
	//		contribuyenteRequest.setNumBP(numBP);
	//
	//		System.out.println("Request de validaCont: " + contribuyenteRequest);
	//		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
	//		System.out.println("Response de validaCont: " + detalleContribuyente);
	//		if (gasolinaService.ocurrioErrorValcont(detalleContribuyente) != true)
	//		{
	//			if (icaInfObjetoResponse.getAnoGravable() != null)
	//			{
	//				infoPreviaPSE.setAnoGravable(icaInfObjetoResponse.getAnoGravable().trim());
	//			}
	//			infoPreviaPSE.setTipoDoc(customerData.getDocumentType());
	//			infoPreviaPSE.setNumDoc(customerData.getDocumentNumber());
	//			infoPreviaPSE.setNumBP(numBP);
	//			try
	//			{
	//				infoPreviaPSE.setClavePeriodo(gasolinaService.prepararClavePeriodoICA(icaInfObjetoResponse));
	//			}
	//			catch (final Exception e)
	//			{
	//				infoPreviaPSE.setClavePeriodo(icaInfObjetoResponse.getPeriodo());
	//			}
	//			infoPreviaPSE.setNumObjeto(gasolinaService.prepararNumObjetoICA(detalleContribuyente));
	//			infoPreviaPSE.setDv(gasolinaService.prepararDV(detalleContribuyente));
	//			infoPreviaPSE.setTipoImpuesto(new ControllerPseConstants().getICA());
	//		}
	//		else
	//		{
	//			LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
	//			mensajesError = gasolinaService.prepararMensajesError(
	//					gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
	//		}
	//		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
	//
	//		model.addAttribute("gravableNetIncomes",
	//				this.getGravableNetIncomes(numBP, numObjeto, anoGravable, icaInfObjetoRequest.getPeriodo()));
	//		//informacion para PSE
	//
	//		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_DECLARACION_CMS_PAGE));
	//		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_DECLARACION_CMS_PAGE));
	//		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(DECLARACION_ACCOUNT_PROFILE));
	//		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
	//
	//		return getViewForPage(model);
	//	}


}

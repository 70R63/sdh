/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.dao.impl.DefaultSDHICACityDao;
import de.hybris.sdh.core.dao.impl.DefaultSDHICAEconomicActivityDao;
import de.hybris.sdh.core.model.SDHICACityModel;
import de.hybris.sdh.core.model.SDHICAEconomicActivityModel;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.ICACalculoImpRequest;
import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.ICACalculoImpResponse;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.ICAInfoDeclara;
import de.hybris.sdh.core.pojos.responses.ICAInfoIngFueraBog;
import de.hybris.sdh.core.pojos.responses.ICAInfoValorRetenido;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.core.services.SDHICACalculoImpService;
import de.hybris.sdh.core.services.SDHICAInfObjetoService;
import de.hybris.sdh.storefront.controllers.ControllerPseConstants;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.GeneraDeclaracionForm;
import de.hybris.sdh.storefront.forms.ICACalculaDeclaracionForm;
import de.hybris.sdh.storefront.forms.ICAInfObjetoForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class IcaPageController extends AbstractPageController
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

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "modelService")
	ModelService modelService;

	@Resource(name = "mediaService")
	MediaService mediaService;

	@Resource(name = "accountBreadcrumbBuilder")
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

	@ModelAttribute("econActivities")
	public List<SDHICAEconomicActivityModel> getEconActivities()
	{

		final List<SDHICAEconomicActivityModel> econActivities = sdhICAEconomicAcitivityDao.find();

		return econActivities;
	}

	@RequestMapping(value = "/contribuyentes/ica", method = RequestMethod.GET)
	@RequireHardLogIn
	public String icainicial(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
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


		final Calendar now = Calendar.getInstance();
		final int year = now.get(Calendar.YEAR);
		icaInfObjetoRequest.setAnoGravable(String.valueOf(year));

		try
		{
			final ICAInfObjetoForm icaInfObjetoFormResp = new ICAInfObjetoForm();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final String response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);

			final ICAInfObjetoResponse icaInfObjetoResponse = mapper
					.readValue(response, ICAInfObjetoResponse.class);

			icaInfObjetoFormResp.setDocumentType(customerModel.getDocumentType());
			icaInfObjetoFormResp.setDocumentNumber(customerModel.getDocumentNumber());
			icaInfObjetoFormResp.setCompleteName(customerModel.getFirstName() + " " + customerModel.getLastName());
			icaInfObjetoFormResp.setIcaInfObjetoResponse(icaInfObjetoResponse);

			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
			model.addAttribute("numObjeto", icaInfObjetoRequest.getNumObjeto());


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


		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();

		icaInfObjetoRequest.setNumBP(customerModel.getNumBP());
		icaInfObjetoRequest.setNumObjeto(numObjeto);
		icaInfObjetoRequest.setAnoGravable(anoGravable);

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

			model.addAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);
			model.addAttribute("numObjeto", icaInfObjetoRequest.getNumObjeto());
			model.addAttribute("anoGravable", anoGravable);

			//redirectModel.addFlashAttribute("icaInfObjetoFormResp", icaInfObjetoFormResp);


		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());

			final ICAInfoDeclara infoDeclara = new ICAInfoDeclara();
			final List<ICAInfoIngFueraBog> listInfFueraBog = new ArrayList<ICAInfoIngFueraBog>();
			final List<ICAInfoValorRetenido> listvalorRetenido = new ArrayList<ICAInfoValorRetenido>();


			listInfFueraBog.add(new ICAInfoIngFueraBog());
			listvalorRetenido.add(new ICAInfoValorRetenido());


			infoDeclara.setIngFueraBog(listInfFueraBog);
			infoDeclara.setValorRetenido(listvalorRetenido);

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
			infoPreviaPSE.setAnoGravable(anoGravable);
			infoPreviaPSE.setTipoDoc(customerData.getDocumentType());
			infoPreviaPSE.setNumDoc(customerData.getDocumentNumber());
			infoPreviaPSE.setNumBP(numBP);
			infoPreviaPSE.setClavePeriodo(gasolinaService.prepararClavePeriodoICA(icaInfObjetoResponse));
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


}

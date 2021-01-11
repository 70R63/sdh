/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.CalculoPredialRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePredial2Request;
import de.hybris.sdh.core.pojos.requests.DetallePredialBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePredialRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.responses.CalPredialErrores;
import de.hybris.sdh.core.pojos.responses.CalculoPredialResponse;
import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.DetallePredial2Response;
import de.hybris.sdh.core.pojos.responses.DetallePredial2Response_marcas;
import de.hybris.sdh.core.pojos.responses.DetallePredialBPResponse;
import de.hybris.sdh.core.pojos.responses.DetallePredialResponse;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.FirmanteResponse;
import de.hybris.sdh.core.pojos.responses.FirmanteResponsePredial2;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.PredialDatosEconomicos;
import de.hybris.sdh.core.pojos.responses.PredialDatosFisicos;
import de.hybris.sdh.core.pojos.responses.PredialDatosJuridicos;
import de.hybris.sdh.core.pojos.responses.PredialEstDatosGenerales;
import de.hybris.sdh.core.pojos.responses.PredialEstLiquidacion;
import de.hybris.sdh.core.pojos.responses.PredialMarcas;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCalculoPredialService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHDetallePredialService;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.GeneraDeclaracionForm;
import de.hybris.sdh.storefront.forms.PredialCatalogos;
import de.hybris.sdh.storefront.forms.PredialControlCamposDec;
import de.hybris.sdh.storefront.forms.PredialForm;
import de.hybris.sdh.storefront.forms.RelContribuyenteAgenteAutorizado;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller
@SessionAttributes(
{ "dataForm" })
public class PredialUnificadoController extends SDHAbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Predial";
	private static final String TEXT_BASES_PROFILE = "Predial Bases Presuntivas";
	private static final String TEXT_ACCOUNT_DECLARACION_PROFILE = "text.declaracion.predial";

	// CMS Pages
	private static final String PREDIAL_INICIAL_CMS_PAGE = "predialInicialPage";
	private static final String PREDIAL_UNO_CMS_PAGE = "predialUnoPage";
	private static final String PREDIAL_DOS_CMS_PAGE = "predialDosPage";
	private static final String PREDIAL_TRES_CMS_PAGE = "predialTresPage";
	private static final String PREDIAL_CUATRO_CMS_PAGE = "predialCuatroPage";
	private static final String PREDIAL_CINCO_CMS_PAGE = "predialCincoPage";
	private static final String PREDIAL_SEIS_CMS_PAGE = "predialSeisPage";
	private static final String PREDIAL_SIETE_CMS_PAGE = "predialSietePage";
	private static final String PREDIAL_OCHO_CMS_PAGE = "predialOchoPage";
	private static final String PREDIAL_BASES_PRESUNTIVAS_CMS_PAGE = "predialBasesPresuntivasPage";

	private static final String REDIRECT_TO_PREDIAL_INICIAL_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_inicio";
	private static final String REDIRECT_TO_PREDIAL_UNO_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_1";
	private static final String REDIRECT_TO_PREDIAL_DOS_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_2";
	private static final String REDIRECT_TO_PREDIAL_TRES_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_3";
	private static final String REDIRECT_TO_PREDIAL_CUATRO_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_4";
	private static final String REDIRECT_TO_PREDIAL_CINCO_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_5";
	private static final String REDIRECT_TO_PREDIAL_SEIS_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_6";
	private static final String REDIRECT_TO_PREDIAL_SIETE_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_7";
	private static final String REDIRECT_TO_PREDIAL_OCHO_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado_8";
	private static final String REDIRECT_TO_PREDIAL_BASES_PRESUNTIVAS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/predialunificado/basespresuntivas";


	@Resource(name = "customBreadcrumbBuilder")
	ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhDetallePredialService")
	SDHDetallePredialService sdhDetallePredialService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhDetalleGasolina")
	private SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "sdhCalculoPredialService")
	private SDHCalculoPredialService sdhCalculoPredialService;

	@Resource(name = "sdhGeneraDeclaracionService")
	SDHGeneraDeclaracionService sdhGeneraDeclaracionService;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	private static final Logger LOG = Logger.getLogger(PredialUnificadoController.class);

	@RequestMapping(value = "/contribuyentes/predialunificado_inicio", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialinicio(@ModelAttribute("predialFormIni")
	final PredialForm predialInfor, final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificadoINICIO --------------------------");


		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;

		final PredialForm predialFormIni = new PredialForm();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		consultaContribuyenteBPRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try
		{
			sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);
			predialFormIni.setPredial(sdhConsultaContribuyenteBPResponse.getPredial());
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("predial", predialFormIni);
		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("infoContrib", sdhConsultaContribuyenteBPResponse.getInfoContrib());

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/predialunificado_inicio/detalle", method = RequestMethod.GET)
	@ResponseBody
	public PredialForm vehiculosDetail(@ModelAttribute("predialInfo")
	final PredialForm predialInfo, final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificadoINICIO POST --------------------------");

		final PredialForm predialForm = new PredialForm();
		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialForm.setTipDoc(customerData.getDocumentType());
		predialForm.setNumDoc(customerData.getDocumentNumber());
		predialForm.setCompleName(customerData.getCompleteName());

		final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

		detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
		detallePredialRequest.setAnioGravable(predialInfo.getAnioGravable());
		detallePredialRequest.setCHIP(predialInfo.getCHIP());
		detallePredialRequest.setMatrInmobiliaria(predialInfo.getMatrInmobiliaria());


		//		detallePredialRequest.setNumBP("1000010203");
		//		detallePredialRequest.setAnioGravable("2019");
		//		detallePredialRequest.setCHIP("AAA0080KECZ");
		//		detallePredialRequest.setMatrInmobiliaria("050N1178178");


		try
		{


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);
			predialForm.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialForm.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialForm.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialForm.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialForm.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialForm.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialForm.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialForm.setNumBP(detallePredialRequest.getNumBP());
			predialForm.setCHIP(detallePredialRequest.getCHIP());
			predialForm.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialForm.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialForm.setMarcas(detallePredialResponse.getMarcas());
			predialForm.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialForm.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
			predialForm.setTblErrores(detallePredialResponse.getTblErrores());
			predialForm.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
			predialForm.setIndicadorDesc1(detallePredialResponse.getIndicadorDesc1());

			model.addAttribute("predialForm", predialForm);

		}
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}
		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return predialForm;
	}


	@RequestMapping(value = "/contribuyentes/predialunificado/URL", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialurl(@ModelAttribute("predialInfoIniURL")
	final PredialForm predialInfoIniURL, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado uno POST--------------------------");
		final PredialForm predialFormurl = new PredialForm();
		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormurl.setTipDoc(customerData.getDocumentType());
		predialFormurl.setNumDoc(customerData.getDocumentNumber());
		predialFormurl.setCompleName(customerData.getCompleteName());
		predialFormurl.setNumBP(customerData.getNumBP());
		predialFormurl.setCHIP(predialInfoIniURL.getCHIP());
		predialFormurl.setMatrInmobiliaria(predialInfoIniURL.getMatrInmobiliaria());
		predialFormurl.setAnioGravable(predialInfoIniURL.getAnioGravable());
		predialFormurl.setObjetocontrato(predialInfoIniURL.getObjetocontrato());


		String tipreg = "";

		tipreg = predialInfoIniURL.getRetipDeclaracion();

		if (tipreg.equals("1") || tipreg.equals("1 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_1";
		}
		else if (tipreg.equals("2") || tipreg.equals("2 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_2";
		}
		else if (tipreg.equals("3") || tipreg.equals("3 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_3";
		}
		else if (tipreg.equals("4") || tipreg.equals("4 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_4";
		}
		else if (tipreg.equals("5") || tipreg.equals("5 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_5";
		}
		else if (tipreg.equals("6") || tipreg.equals("6 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_6";
		}
		else if (tipreg.equals("7") || tipreg.equals("7 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_7";
		}
		else if (tipreg.equals("8") || tipreg.equals("8 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_8";
		}
		else if (tipreg.equals("9") || tipreg.equals("9 "))
		{
			model.addAttribute("dataForm", new PredialForm());
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado/basespresuntivas";
		}
		else
		{
			final String Error = "Su predio no cuenta con Tipo de declaración, por lo que no se puede detrminar la declaración a realizar";
			redirectAttributes.addFlashAttribute("Error", Error);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_inicio";
		}
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_1", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialuno(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado uno GET--------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "1", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();

		final PredialForm predialFormuno = new PredialForm();
		PredialForm predialInfoIniUno = new PredialForm();

		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		try
		{
			if (anioGravable != null)
			{
				predialInfoIniUno.setAnioGravable(anioGravable);
				predialInfoIniUno.setNumBP(numBP);
				predialInfoIniUno.setCHIP(chip);
				predialInfoIniUno.setMatrInmobiliaria(matricula);
				predialInfoIniUno.setTipDoc(customerData.getDocumentType());
				predialInfoIniUno.setNumDoc(customerData.getDocumentNumber());
				predialInfoIniUno.setCompleName(customerData.getCompleteName());
				predialInfoIniUno.setNumBP(customerData.getNumBP());
			}
			else
			{
				predialInfoIniUno = (PredialForm) model.asMap().get("predialFormurl");
			}
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

			detallePredialRequest.setNumBP(predialInfoIniUno.getNumBP());
			detallePredialRequest.setAnioGravable(predialInfoIniUno.getAnioGravable());
			detallePredialRequest.setCHIP(predialInfoIniUno.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialInfoIniUno.getMatrInmobiliaria());

			final DetallePredialResponse detallePredialResponse = determinaResponse(infoReemplazo, predialInfo,
					detallePredialRequest);

			if (detallePredialResponse != null)
			{
				predialFormuno.setCheckAporte_flag(detallePredialResponse.getCheckAporte());
				predialFormuno.setObjetocontrato(predialInfoIniUno.getObjetocontrato());
				predialFormuno.setNumDoc(predialInfoIniUno.getNumDoc());
				predialFormuno.setCompleName(predialInfoIniUno.getCompleName());
				predialFormuno.setTipDoc(predialInfoIniUno.getTipDoc());
				predialFormuno.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
				predialFormuno.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
				predialFormuno.setOpcionuso(detallePredialResponse.getOpcionuso());
				predialFormuno.setIndicadorspac(detallePredialResponse.getIndicadorspac());
				predialFormuno.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
				predialFormuno.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
				predialFormuno.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
				predialFormuno.setDatosFisicos(detallePredialResponse.getDatosFisicos());
				predialFormuno.setMarcas(detallePredialResponse.getMarcas());
				predialFormuno.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
				predialFormuno.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
				predialFormuno.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
				predialFormuno.setTblErrores(detallePredialResponse.getTblErrores());
				predialFormuno.setAnioGravable(detallePredialRequest.getAnioGravable());
				predialFormuno.setNumBP(detallePredialRequest.getNumBP());
				predialFormuno.setCHIP(detallePredialRequest.getCHIP());
				predialFormuno.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
				predialFormuno.setDireccionPredio(detallePredialResponse.getDireccionPredio());
				predialFormuno
						.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

				final String idDestino = predialFormuno.getEstrLiquidacionPredial().getDestinoHacendario();
				predialFormuno.setDesDestino(destinoHacendario(idDestino));

				final String idCalidad = predialFormuno.getDatosJuridicos().getCalidadSujecion();

				if (idCalidad == "1" || idCalidad.equals("1"))
				{
					predialFormuno.setDesCalidad("Propietario");
				}
				else if (idCalidad == "2" || idCalidad.equals("2"))
				{
					predialFormuno.setDesCalidad("Fideicometente");
				}
				else if (idCalidad == "3" || idCalidad.equals("3"))
				{
					predialFormuno.setDesCalidad("Poseedor");
				}
				else if (idCalidad == "4" || idCalidad.equals("4"))
				{
					predialFormuno.setDesCalidad("Beneficiario");
				}
				else if (idCalidad == "5" || idCalidad.equals("5"))
				{
					predialFormuno.setDesCalidad("Usufructuario");
				}
				else if (idCalidad == "6" || idCalidad.equals("6"))
				{
					predialFormuno.setDesCalidad("Arrendatario");
				}
				else
				{
					predialFormuno.setDesCalidad("-");
				}


				for (final PredialMarcas eachMarca : predialFormuno.getMarcas())
				{
					if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
					{
						String exMarca = "";
						exMarca = eachMarca.getTipoMarca();
						if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
						{
							predialFormuno.setDecExclusion(eachMarca.getPorcMarca());
						}
						if (exMarca == "2" || exMarca.equals("2"))
						{
							predialFormuno.setDecExencion(eachMarca.getPorcMarca());
						}

					}
				}

			}
			else
			{
				return "redirect:/contribuyentes/predialunificado_inicio";
			}

		}
		catch (final Exception e)
		{

			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

			return "redirect:/contribuyentes/predialunificado_inicio";


		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(
				contribuyenteData.getPredial().stream().filter(d -> predialFormuno.getCHIP().equals(d.getCHIP()))
						.collect(Collectors.toList()));
		predialFormuno.setContribuyenteData(contribuyenteData);
		predialFormuno.setControlCampos(
				establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormuno.setNumFrom(numForm);


		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoIniUno.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormuno.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormuno.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormuno.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormuno.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormuno.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormuno.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormuno.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}




		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("predialForm", predialFormuno);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));

		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/predialunificado_2", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialdos(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado DOS --------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "2", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();


		final PredialForm predialFormdos = new PredialForm();
		PredialForm predialInfoInidos = new PredialForm();
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		//final PredialForm predialInfoInidos = (PredialForm) model.asMap().get("predialFormurl");

		try
		{

			if (anioGravable != null)
			{
				predialInfoInidos.setAnioGravable(anioGravable);
				predialInfoInidos.setNumBP(numBP);
				predialInfoInidos.setCHIP(chip);
				predialInfoInidos.setMatrInmobiliaria(matricula);
				predialInfoInidos.setTipDoc(customerData.getDocumentType());
				predialInfoInidos.setNumDoc(customerData.getDocumentNumber());
				predialInfoInidos.setCompleName(customerData.getCompleteName());
				predialInfoInidos.setNumBP(customerData.getNumBP());
			}
			else
			{
				predialInfoInidos = (PredialForm) model.asMap().get("predialFormurl");
			}

			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			detallePredialRequest.setNumBP(predialInfoInidos.getNumBP());
			detallePredialRequest.setAnioGravable(predialInfoInidos.getAnioGravable());
			detallePredialRequest.setCHIP(predialInfoInidos.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialInfoInidos.getMatrInmobiliaria());

			final DetallePredialResponse detallePredialResponse = determinaResponse(infoReemplazo, predialInfo,
					detallePredialRequest);

			if (detallePredialResponse != null)
			{
				predialFormdos.setCheckAporte_flag(detallePredialResponse.getCheckAporte());
				predialFormdos.setObjetocontrato(predialInfoInidos.getObjetocontrato());
				predialFormdos.setNumDoc(predialInfoInidos.getNumDoc());
				predialFormdos.setCompleName(predialInfoInidos.getCompleName());
				predialFormdos.setTipDoc(predialInfoInidos.getTipDoc());
				predialFormdos.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
				predialFormdos.setOpcionuso(detallePredialResponse.getOpcionuso());
				predialFormdos.setIndicadorspac(detallePredialResponse.getIndicadorspac());
				predialFormdos.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
				predialFormdos.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
				predialFormdos.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
				predialFormdos.setDatosFisicos(detallePredialResponse.getDatosFisicos());
				predialFormdos.setMarcas(detallePredialResponse.getMarcas());
				predialFormdos.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
				predialFormdos.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
				predialFormdos.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
				predialFormdos.setTblErrores(detallePredialResponse.getTblErrores());
				predialFormdos.setAnioGravable(detallePredialRequest.getAnioGravable());
				predialFormdos.setNumBP(detallePredialRequest.getNumBP());
				predialFormdos.setCHIP(detallePredialRequest.getCHIP());
				predialFormdos.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
				predialFormdos.setDireccionPredio(detallePredialResponse.getDireccionPredio());
				predialFormdos
						.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

			final String idDestino = predialFormdos.getEstrLiquidacionPredial().getDestinoHacendario();
			predialFormdos.setDesDestino(destinoHacendario(idDestino));

			final String idCalidad = predialFormdos.getDatosJuridicos().getCalidadSujecion();


			if (idCalidad == "1" || idCalidad.equals("1"))
			{
				predialFormdos.setDesCalidad("Propietario");
			}
			else if (idCalidad == "2" || idCalidad.equals("2"))
			{
				predialFormdos.setDesCalidad("Fideicometente");
			}
			else if (idCalidad == "3" || idCalidad.equals("3"))
			{
				predialFormdos.setDesCalidad("Poseedor");
			}
			else if (idCalidad == "4" || idCalidad.equals("4"))
			{
				predialFormdos.setDesCalidad("Beneficiario");
			}
			else if (idCalidad == "5" || idCalidad.equals("5"))
			{
				predialFormdos.setDesCalidad("Usufructuario");
			}
			else if (idCalidad == "6" || idCalidad.equals("6"))
			{
				predialFormdos.setDesCalidad("Arrendatario");
			}
			else
			{
				predialFormdos.setDesCalidad("-");
			}

			for (final PredialMarcas eachMarca : predialFormdos.getMarcas())
			{
				if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
				{
					String exMarca = "";
					exMarca = eachMarca.getTipoMarca();
					if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
					{
						predialFormdos.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2" || exMarca.equals("2"))
					{
						predialFormdos.setDecExencion(eachMarca.getPorcMarca());
					}

				}
			}
			}
			else
			{
				return "redirect:/contribuyentes/predialunificado_inicio";
			}

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");


			return "redirect:/contribuyentes/predialunificado_inicio";


		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormdos.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormdos.setContribuyenteData(contribuyenteData);
		predialFormdos
				.setControlCampos(
						establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormdos.setNumFrom(numForm);






		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoInidos.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormdos.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormdos.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormdos.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormdos.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormdos.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormdos.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormdos.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}




		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("predialFormdos", predialFormdos);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_DOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_DOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/predialunificado_3", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialtres(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado TRES --------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "3", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();

		final PredialForm predialFormtres = new PredialForm();

		PredialForm predialInfoInitres = new PredialForm();
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		try
		{

			if (anioGravable != null)
			{
				predialInfoInitres.setAnioGravable(anioGravable);
				predialInfoInitres.setNumBP(numBP);
				predialInfoInitres.setCHIP(chip);
				predialInfoInitres.setMatrInmobiliaria(matricula);
				predialInfoInitres.setTipDoc(customerData.getDocumentType());
				predialInfoInitres.setNumDoc(customerData.getDocumentNumber());
				predialInfoInitres.setCompleName(customerData.getCompleteName());
				predialInfoInitres.setNumBP(customerData.getNumBP());
			}
			else
			{
				predialInfoInitres = (PredialForm) model.asMap().get("predialFormurl");
			}
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

			detallePredialRequest.setNumBP(predialInfoInitres.getNumBP());
			detallePredialRequest.setAnioGravable(predialInfoInitres.getAnioGravable());
			detallePredialRequest.setCHIP(predialInfoInitres.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialInfoInitres.getMatrInmobiliaria());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);

			predialFormtres.setCheckAporte_flag(detallePredialResponse.getCheckAporte());
			predialFormtres.setObjetocontrato(predialInfoInitres.getObjetocontrato());
			predialFormtres.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialFormtres.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialFormtres.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialFormtres.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialFormtres.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialFormtres.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialFormtres.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialFormtres.setMarcas(detallePredialResponse.getMarcas());
			predialFormtres.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialFormtres.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
			predialFormtres.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
			predialFormtres.setTblErrores(detallePredialResponse.getTblErrores());
			predialFormtres.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialFormtres.setNumBP(detallePredialRequest.getNumBP());
			predialFormtres.setCHIP(detallePredialRequest.getCHIP());
			predialFormtres.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialFormtres.setDireccionPredio(detallePredialResponse.getDireccionPredio());
			predialFormtres.setNumDoc(predialInfoInitres.getNumDoc());
			predialFormtres.setCompleName(predialInfoInitres.getCompleName());
			predialFormtres.setTipDoc(predialInfoInitres.getTipDoc());
			predialFormtres
					.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

			final String idDestino = predialFormtres.getEstrLiquidacionPredial().getDestinoHacendario();
			predialFormtres.setDesDestino(destinoHacendario(idDestino));

			final String idCalidad = predialFormtres.getDatosJuridicos().getCalidadSujecion();

			if (idCalidad == "1" || idCalidad.equals("1"))
			{
				predialFormtres.setDesCalidad("Propietario");
			}
			else if (idCalidad == "2" || idCalidad.equals("2"))
			{
				predialFormtres.setDesCalidad("Fideicometente");
			}
			else if (idCalidad == "3" || idCalidad.equals("3"))
			{
				predialFormtres.setDesCalidad("Poseedor");
			}
			else if (idCalidad == "4" || idCalidad.equals("4"))
			{
				predialFormtres.setDesCalidad("Beneficiario");
			}
			else if (idCalidad == "5" || idCalidad.equals("5"))
			{
				predialFormtres.setDesCalidad("Usufructuario");
			}
			else if (idCalidad == "6" || idCalidad.equals("6"))
			{
				predialFormtres.setDesCalidad("Arrendatario");
			}
			else
			{
				predialFormtres.setDesCalidad("-");
			}

			for (final PredialMarcas eachMarca : predialFormtres.getMarcas())
			{
				if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
				{
					String exMarca = "";
					exMarca = eachMarca.getTipoMarca();
					if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
					{
						predialFormtres.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2" || exMarca.equals("2"))
					{
						predialFormtres.setDecExencion(eachMarca.getPorcMarca());
					}

				}
			}

		}
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormtres.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormtres.setContribuyenteData(contribuyenteData);
		predialFormtres.setControlCampos(
				establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormtres.setNumFrom(numForm);

		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoInitres.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();

		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormtres.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormtres.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormtres.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormtres.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormtres.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormtres.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormtres.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}




		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("predialFormtres", predialFormtres);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_TRES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_TRES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_4", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialcuatro(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado CUATRO --------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "4", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();

		final PredialForm predialFormcua = new PredialForm();
		//	final PredialForm predialInfoInicuatro = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoInicuatro = new PredialForm();
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		try
		{

			if (anioGravable != null)
			{
				predialInfoInicuatro.setAnioGravable(anioGravable);
				predialInfoInicuatro.setNumBP(numBP);
				predialInfoInicuatro.setCHIP(chip);
				predialInfoInicuatro.setMatrInmobiliaria(matricula);
				predialInfoInicuatro.setTipDoc(customerData.getDocumentType());
				predialInfoInicuatro.setNumDoc(customerData.getDocumentNumber());
				predialInfoInicuatro.setCompleName(customerData.getCompleteName());
				predialInfoInicuatro.setNumBP(customerData.getNumBP());
			}
			else
			{
				predialInfoInicuatro = (PredialForm) model.asMap().get("predialFormurl");
			}
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

			detallePredialRequest.setNumBP(predialInfoInicuatro.getNumBP());
			detallePredialRequest.setAnioGravable(predialInfoInicuatro.getAnioGravable());
			detallePredialRequest.setCHIP(predialInfoInicuatro.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialInfoInicuatro.getMatrInmobiliaria());


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);

			predialFormcua.setCheckAporte_flag(detallePredialResponse.getCheckAporte());
			predialFormcua.setObjetocontrato(predialInfoInicuatro.getObjetocontrato());
			predialFormcua.setTipDoc(predialInfoInicuatro.getTipDoc());
			predialFormcua.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialFormcua.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialFormcua.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialFormcua.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialFormcua.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialFormcua.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialFormcua.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialFormcua.setMarcas(detallePredialResponse.getMarcas());
			predialFormcua.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialFormcua.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
			predialFormcua.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
			predialFormcua.setTblErrores(detallePredialResponse.getTblErrores());
			predialFormcua.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialFormcua.setNumBP(detallePredialRequest.getNumBP());
			predialFormcua.setCHIP(detallePredialRequest.getCHIP());
			predialFormcua.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialFormcua.setDireccionPredio(detallePredialResponse.getDireccionPredio());
			predialFormcua.setNumDoc(customerData.getDocumentNumber());
			predialFormcua.setCompleName(customerData.getCompleteName());
			predialFormcua.setNumBP(customerData.getNumBP());
			predialFormcua.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

			final String idDestino = predialFormcua.getEstrLiquidacionPredial().getDestinoHacendario();
			predialFormcua.setDesDestino(destinoHacendario(idDestino));

			final String idCalidad = predialFormcua.getDatosJuridicos().getCalidadSujecion();

			if (idCalidad == "1" || idCalidad.equals("1"))
			{
				predialFormcua.setDesCalidad("Propietario");
			}
			else if (idCalidad == "2" || idCalidad.equals("2"))
			{
				predialFormcua.setDesCalidad("Fideicometente");
			}
			else if (idCalidad == "3" || idCalidad.equals("3"))
			{
				predialFormcua.setDesCalidad("Poseedor");
			}
			else if (idCalidad == "4" || idCalidad.equals("4"))
			{
				predialFormcua.setDesCalidad("Beneficiario");
			}
			else if (idCalidad == "5" || idCalidad.equals("5"))
			{
				predialFormcua.setDesCalidad("Usufructuario");
			}
			else if (idCalidad == "6" || idCalidad.equals("6"))
			{
				predialFormcua.setDesCalidad("Arrendatario");
			}
			else
			{
				predialFormcua.setDesCalidad("-");
			}

			for (final PredialMarcas eachMarca : predialFormcua.getMarcas())
			{
				if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
				{
					String exMarca = "";
					exMarca = eachMarca.getTipoMarca();
					if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
					{
						predialFormcua.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2" || exMarca.equals("2"))
					{
						predialFormcua.setDecExencion(eachMarca.getPorcMarca());
					}

				}
			}

		}
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormcua.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormcua.setContribuyenteData(contribuyenteData);
		predialFormcua
				.setControlCampos(establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormcua.setNumFrom(numForm);



		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoInicuatro.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormcua.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormcua.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormcua.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormcua.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormcua.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormcua.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormcua.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}




		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("predialFormcua", predialFormcua);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_CUATRO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_CUATRO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_5", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialcinco(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado CINCO --------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "5", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();

		final PredialForm predialFormcinco = new PredialForm();

		//		final PredialForm predialInfoInicinco = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoInicinco = new PredialForm();
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		try
		{

			if (anioGravable != null)
			{
				predialInfoInicinco.setAnioGravable(anioGravable);
				predialInfoInicinco.setNumBP(numBP);
				predialInfoInicinco.setCHIP(chip);
				predialInfoInicinco.setMatrInmobiliaria(matricula);
				predialInfoInicinco.setTipDoc(customerData.getDocumentType());
				predialInfoInicinco.setNumDoc(customerData.getDocumentNumber());
				predialInfoInicinco.setCompleName(customerData.getCompleteName());
				predialInfoInicinco.setNumBP(customerData.getNumBP());
			}
			else
			{
				predialInfoInicinco = (PredialForm) model.asMap().get("predialFormurl");
			}
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

			detallePredialRequest.setNumBP(predialInfoInicinco.getNumBP());
			detallePredialRequest.setAnioGravable(predialInfoInicinco.getAnioGravable());
			detallePredialRequest.setCHIP(predialInfoInicinco.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialInfoInicinco.getMatrInmobiliaria());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);

			predialFormcinco.setCheckAporte_flag(detallePredialResponse.getCheckAporte());
			predialFormcinco.setObjetocontrato(predialInfoInicinco.getObjetocontrato());
			predialFormcinco.setNumDoc(customerData.getDocumentNumber());
			predialFormcinco.setCompleName(customerData.getCompleteName());
			predialFormcinco.setNumBP(customerData.getNumBP());
			predialFormcinco.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialFormcinco.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialFormcinco.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialFormcinco.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialFormcinco.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialFormcinco.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialFormcinco.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialFormcinco.setMarcas(detallePredialResponse.getMarcas());
			predialFormcinco.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialFormcinco.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
			predialFormcinco.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
			predialFormcinco.setTblErrores(detallePredialResponse.getTblErrores());
			predialFormcinco.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialFormcinco.setNumBP(detallePredialRequest.getNumBP());
			predialFormcinco.setCHIP(detallePredialRequest.getCHIP());
			predialFormcinco.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialFormcinco.setDireccionPredio(detallePredialResponse.getDireccionPredio());
			predialFormcinco
					.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

			final String idDestino = predialFormcinco.getEstrLiquidacionPredial().getDestinoHacendario();
			predialFormcinco.setDesDestino(destinoHacendario(idDestino));

			final String idCalidad = predialFormcinco.getDatosJuridicos().getCalidadSujecion();

			if (idCalidad == "1" || idCalidad.equals("1"))
			{
				predialFormcinco.setDesCalidad("Propietario");
			}
			else if (idCalidad == "2" || idCalidad.equals("2"))
			{
				predialFormcinco.setDesCalidad("Fideicometente");
			}
			else if (idCalidad == "3" || idCalidad.equals("3"))
			{
				predialFormcinco.setDesCalidad("Poseedor");
			}
			else if (idCalidad == "4" || idCalidad.equals("4"))
			{
				predialFormcinco.setDesCalidad("Beneficiario");
			}
			else if (idCalidad == "5" || idCalidad.equals("5"))
			{
				predialFormcinco.setDesCalidad("Usufructuario");
			}
			else if (idCalidad == "6" || idCalidad.equals("6"))
			{
				predialFormcinco.setDesCalidad("Arrendatario");
			}
			else
			{
				predialFormcinco.setDesCalidad("-");
			}

			for (final PredialMarcas eachMarca : predialFormcinco.getMarcas())
			{
				if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
				{
					String exMarca = "";
					exMarca = eachMarca.getTipoMarca();
					if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
					{
						predialFormcinco.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2" || exMarca.equals("2"))
					{
						predialFormcinco.setDecExencion(eachMarca.getPorcMarca());
					}

				}
			}
		}
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormcinco.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormcinco.setContribuyenteData(contribuyenteData);
		predialFormcinco
				.setControlCampos(establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormcinco.setNumFrom(numForm);


		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoInicinco.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormcinco.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormcinco.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormcinco.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormcinco.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormcinco.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormcinco.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormcinco.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}

		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("predialFormcinco", predialFormcinco);



		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_CINCO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_CINCO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_6", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialseis(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado SEIS --------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "6", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();

		final PredialForm predialFormseis = new PredialForm();

		//final PredialForm predialInfoIniseis = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoIniseis = new PredialForm();
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		try
		{

			if (anioGravable != null)
			{
				predialInfoIniseis.setAnioGravable(anioGravable);
				predialInfoIniseis.setNumBP(numBP);
				predialInfoIniseis.setCHIP(chip);
				predialInfoIniseis.setMatrInmobiliaria(matricula);
				predialInfoIniseis.setTipDoc(customerData.getDocumentType());
				predialInfoIniseis.setNumDoc(customerData.getDocumentNumber());
				predialInfoIniseis.setCompleName(customerData.getCompleteName());
				predialInfoIniseis.setNumBP(customerData.getNumBP());
			}
			else
			{
				predialInfoIniseis = (PredialForm) model.asMap().get("predialFormurl");
			}
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

			detallePredialRequest.setNumBP(predialInfoIniseis.getNumBP());
			detallePredialRequest.setAnioGravable(predialInfoIniseis.getAnioGravable());
			detallePredialRequest.setCHIP(predialInfoIniseis.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialInfoIniseis.getMatrInmobiliaria());

			final DetallePredialResponse detallePredialResponse = determinaResponse(infoReemplazo, predialInfo,
					detallePredialRequest);

			if (detallePredialResponse != null)
			{
				predialFormseis.setCheckAporte_flag(detallePredialResponse.getCheckAporte());
				predialFormseis.setObjetocontrato(predialInfoIniseis.getObjetocontrato());
				predialFormseis.setNumDoc(customerData.getDocumentNumber());
				predialFormseis.setTipDoc(customerData.getDocumentType());
				predialFormseis.setCompleName(customerData.getCompleteName());
				predialFormseis.setNumBP(customerData.getNumBP());
				predialFormseis.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
				predialFormseis.setOpcionuso(detallePredialResponse.getOpcionuso());
				predialFormseis.setIndicadorspac(detallePredialResponse.getIndicadorspac());
				predialFormseis.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
				predialFormseis.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
				predialFormseis.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
				predialFormseis.setDatosFisicos(detallePredialResponse.getDatosFisicos());
				predialFormseis.setMarcas(detallePredialResponse.getMarcas());
				predialFormseis.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
				predialFormseis.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
				predialFormseis.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
				predialFormseis.setTblErrores(detallePredialResponse.getTblErrores());
				predialFormseis.setAnioGravable(detallePredialRequest.getAnioGravable());
				predialFormseis.setNumBP(detallePredialRequest.getNumBP());
				predialFormseis.setCHIP(detallePredialRequest.getCHIP());
				predialFormseis.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
				predialFormseis.setDireccionPredio(detallePredialResponse.getDireccionPredio());
				predialFormseis
						.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

				final String idDestino = predialFormseis.getEstrLiquidacionPredial().getDestinoHacendario();
				predialFormseis.setDesDestino(destinoHacendario(idDestino));

				final String idCalidad = predialFormseis.getDatosJuridicos().getCalidadSujecion();

				if (idCalidad == "1" || idCalidad.equals("1"))
				{
					predialFormseis.setDesCalidad("Propietario");
				}
				else if (idCalidad == "2" || idCalidad.equals("2"))
				{
					predialFormseis.setDesCalidad("Fideicometente");
				}
				else if (idCalidad == "3" || idCalidad.equals("3"))
				{
					predialFormseis.setDesCalidad("Poseedor");
				}
				else if (idCalidad == "4" || idCalidad.equals("4"))
				{
					predialFormseis.setDesCalidad("Beneficiario");
				}
				else if (idCalidad == "5" || idCalidad.equals("5"))
				{
					predialFormseis.setDesCalidad("Usufructuario");
				}
				else if (idCalidad == "6" || idCalidad.equals("6"))
				{
					predialFormseis.setDesCalidad("Arrendatario");
				}
				else
				{
					predialFormseis.setDesCalidad("-");
				}

				for (final PredialMarcas eachMarca : predialFormseis.getMarcas())
				{
					if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
					{

						final String exMarca = eachMarca.getTipoMarca();
						if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
						{
							predialFormseis.setDecExclusion(eachMarca.getPorcMarca());
						}
						if (exMarca == "2" || exMarca.equals("2"))
						{
							predialFormseis.setDecExencion(eachMarca.getPorcMarca());
						}


					}
				}
			}
			else
			{
				return "redirect:/contribuyentes/predialunificado_inicio";
			}
		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormseis.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormseis.setContribuyenteData(contribuyenteData);
		predialFormseis
				.setControlCampos(establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormseis.setNumFrom(numForm);

		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoIniseis.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormseis.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormseis.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormseis.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormseis.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormseis.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormseis.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormseis.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}

		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("predialFormseis", predialFormseis);


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_SEIS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_SEIS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_7", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialsiete(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado Siete --------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "7", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();

		final PredialForm predialFormsiete = new PredialForm();

		//final PredialForm predialInfoInisiete = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoInisiete = new PredialForm();
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		try
		{

			if (anioGravable != null)
			{
				predialInfoInisiete.setAnioGravable(anioGravable);
				predialInfoInisiete.setNumBP(numBP);
				predialInfoInisiete.setCHIP(chip);
				predialInfoInisiete.setMatrInmobiliaria(matricula);
				predialInfoInisiete.setTipDoc(customerData.getDocumentType());
				predialInfoInisiete.setNumDoc(customerData.getDocumentNumber());
				predialInfoInisiete.setCompleName(customerData.getCompleteName());
				predialInfoInisiete.setNumBP(customerData.getNumBP());
			}
			else
			{
				predialInfoInisiete = (PredialForm) model.asMap().get("predialFormurl");
			}
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

			detallePredialRequest.setNumBP(predialFormsiete.getNumBP());
			detallePredialRequest.setAnioGravable(predialFormsiete.getAnioGravable());
			detallePredialRequest.setCHIP(predialFormsiete.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialFormsiete.getMatrInmobiliaria());


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);

			predialFormsiete.setNumDoc(customerData.getDocumentNumber());
			predialFormsiete.setCompleName(customerData.getCompleteName());
			predialFormsiete.setNumBP(customerData.getNumBP());

			predialFormsiete.setObjetocontrato(predialInfoInisiete.getObjetocontrato());
			predialFormsiete.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialFormsiete.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialFormsiete.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialFormsiete.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialFormsiete.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialFormsiete.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialFormsiete.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialFormsiete.setMarcas(detallePredialResponse.getMarcas());
			predialFormsiete.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialFormsiete.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
			predialFormsiete.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
			predialFormsiete.setTblErrores(detallePredialResponse.getTblErrores());
			predialFormsiete.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialFormsiete.setNumBP(detallePredialRequest.getNumBP());
			predialFormsiete.setCHIP(detallePredialRequest.getCHIP());
			predialFormsiete.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialFormsiete.setDireccionPredio(detallePredialResponse.getDireccionPredio());
			predialFormsiete
					.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

			final String idDestino = predialFormsiete.getEstrLiquidacionPredial().getDestinoHacendario();
			predialFormsiete.setDesDestino(destinoHacendario(idDestino));

			final String idCalidad = predialFormsiete.getDatosJuridicos().getCalidadSujecion();

			if (idCalidad == "1" || idCalidad.equals("1"))
			{
				predialFormsiete.setDesCalidad("Propietario");
			}
			else if (idCalidad == "2" || idCalidad.equals("2"))
			{
				predialFormsiete.setDesCalidad("Fideicometente");
			}
			else if (idCalidad == "3" || idCalidad.equals("3"))
			{
				predialFormsiete.setDesCalidad("Poseedor");
			}
			else if (idCalidad == "4" || idCalidad.equals("4"))
			{
				predialFormsiete.setDesCalidad("Beneficiario");
			}
			else if (idCalidad == "5" || idCalidad.equals("5"))
			{
				predialFormsiete.setDesCalidad("Usufructuario");
			}
			else if (idCalidad == "6" || idCalidad.equals("6"))
			{
				predialFormsiete.setDesCalidad("Arrendatario");
			}
			else
			{
				predialFormsiete.setDesCalidad("-");
			}

			for (final PredialMarcas eachMarca : predialFormsiete.getMarcas())
			{
				if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
				{
					String exMarca = "";
					exMarca = eachMarca.getTipoMarca();
					if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
					{
						predialFormsiete.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2" || exMarca.equals("2"))
					{
						predialFormsiete.setDecExencion(eachMarca.getPorcMarca());
					}

				}
			}
		}
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormsiete.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormsiete.setContribuyenteData(contribuyenteData);
		predialFormsiete
				.setControlCampos(establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormsiete.setNumFrom(numForm);




		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoInisiete.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormsiete.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormsiete.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormsiete.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormsiete.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormsiete.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormsiete.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormsiete.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}

		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("predialFormsiete", predialFormsiete);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_SIETE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_SIETE_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_8", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialocho(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado OCHO --------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "8", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();

		final PredialForm predialFormocho = new PredialForm();

		//		final PredialForm predialInfoIniocho = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoIniocho = new PredialForm();
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		try
		{

			if (anioGravable != null)
			{
				predialInfoIniocho.setAnioGravable(anioGravable);
				predialInfoIniocho.setNumBP(numBP);
				predialInfoIniocho.setCHIP(chip);
				predialInfoIniocho.setMatrInmobiliaria(matricula);
				predialInfoIniocho.setTipDoc(customerData.getDocumentType());
				predialInfoIniocho.setNumDoc(customerData.getDocumentNumber());
				predialInfoIniocho.setCompleName(customerData.getCompleteName());
				predialInfoIniocho.setNumBP(customerData.getNumBP());
			}
			else
			{
				predialInfoIniocho = (PredialForm) model.asMap().get("predialFormurl");
			}
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

			detallePredialRequest.setNumBP(predialInfoIniocho.getNumBP());
			detallePredialRequest.setAnioGravable(predialInfoIniocho.getAnioGravable());
			detallePredialRequest.setCHIP(predialInfoIniocho.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialInfoIniocho.getMatrInmobiliaria());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);

			predialFormocho.setObjetocontrato(predialInfoIniocho.getObjetocontrato());
			predialFormocho.setNumDoc(customerData.getDocumentNumber());
			predialFormocho.setCompleName(customerData.getCompleteName());
			predialFormocho.setNumBP(customerData.getNumBP());
			predialFormocho.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialFormocho.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialFormocho.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialFormocho.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialFormocho.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialFormocho.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialFormocho.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialFormocho.setMarcas(detallePredialResponse.getMarcas());
			predialFormocho.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialFormocho.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
			predialFormocho.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
			predialFormocho.setTblErrores(detallePredialResponse.getTblErrores());
			predialFormocho.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialFormocho.setNumBP(detallePredialRequest.getNumBP());
			predialFormocho.setCHIP(detallePredialRequest.getCHIP());
			predialFormocho.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialFormocho.setDireccionPredio(detallePredialResponse.getDireccionPredio());
			predialFormocho
					.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

			final String idDestino = predialFormocho.getEstrLiquidacionPredial().getDestinoHacendario();
			predialFormocho.setDesDestino(destinoHacendario(idDestino));

			final String idCalidad = predialFormocho.getDatosJuridicos().getCalidadSujecion();

			if (idCalidad == "1" || idCalidad.equals("1"))
			{
				predialFormocho.setDesCalidad("Propietario");
			}
			else if (idCalidad == "2" || idCalidad.equals("2"))
			{
				predialFormocho.setDesCalidad("Fideicometente");
			}
			else if (idCalidad == "3" || idCalidad.equals("3"))
			{
				predialFormocho.setDesCalidad("Poseedor");
			}
			else if (idCalidad == "4" || idCalidad.equals("4"))
			{
				predialFormocho.setDesCalidad("Beneficiario");
			}
			else if (idCalidad == "5" || idCalidad.equals("5"))
			{
				predialFormocho.setDesCalidad("Usufructuario");
			}
			else if (idCalidad == "6" || idCalidad.equals("6"))
			{
				predialFormocho.setDesCalidad("Arrendatario");
			}
			else
			{
				predialFormocho.setDesCalidad("-");
			}

			for (final PredialMarcas eachMarca : predialFormocho.getMarcas())
			{
				if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
				{
					String exMarca = "";
					exMarca = eachMarca.getTipoMarca();
					if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
					{
						predialFormocho.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2" || exMarca.equals("2"))
					{
						predialFormocho.setDecExencion(eachMarca.getPorcMarca());
					}
				}
			}
		}
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormocho.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormocho.setContribuyenteData(contribuyenteData);
		predialFormocho
				.setControlCampos(establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormocho.setNumFrom(numForm);

		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoIniocho.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormocho.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormocho.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormocho.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormocho.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormocho.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormocho.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormocho.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}

		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("predialFormocho", predialFormocho);



		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_OCHO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_OCHO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado/basespresuntivas", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialbases(final Model model, @RequestParam(required = false, value = "anioGravable") String anioGravable,
			@RequestParam(required = false, value = "chip") String chip,
			@RequestParam(required = false, value = "matricula") String matricula,
			@RequestParam(required = false, value = "numBP") String numBP, @ModelAttribute("dataForm")
			final PredialForm predialInfo, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado BASES PRESUNTIVAS --------------------------");

		CustomerData customerData = null;
		RelContribuyenteAgenteAutorizado infoRelacion = null;
		final PredialForm infoReemplazo = new PredialForm();
		infoRelacion = prepararInfoAgenteAutorizado(model, predialInfo, "9", infoReemplazo);
		String numForm = null;
		if (infoReemplazo.getRepresentado() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
			numForm = infoReemplazo.getNumFrom();
		}
		customerData = infoRelacion.getContribuyente();

		final PredialForm predialFormbases = new PredialForm();

		PredialForm predialInfoInibases = new PredialForm();
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();


		if (anioGravable != null)
		{
			predialInfoInibases.setAnioGravable(anioGravable);
			predialInfoInibases.setNumBP(numBP);
			predialInfoInibases.setCHIP(chip);
			predialInfoInibases.setMatrInmobiliaria(matricula);
			predialInfoInibases.setTipDoc(customerData.getDocumentType());
			predialInfoInibases.setNumDoc(customerData.getDocumentNumber());
			predialInfoInibases.setCompleName(customerData.getCompleteName());
			predialInfoInibases.setNumBP(customerData.getNumBP());
		}
		else
		{
			predialInfoInibases = (PredialForm) model.asMap().get("predialFormurl");
		}
		final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

		detallePredialRequest.setNumBP(predialInfoInibases.getNumBP());
		detallePredialRequest.setAnioGravable(predialInfoInibases.getAnioGravable());
		detallePredialRequest.setCHIP(predialInfoInibases.getCHIP());
		detallePredialRequest.setMatrInmobiliaria(predialInfoInibases.getMatrInmobiliaria());

		final DetallePredialResponse detallePredialResponse = determinaResponse(infoReemplazo, predialInfo, detallePredialRequest);

		if (detallePredialResponse != null)
		{
			predialFormbases.setCheckAporte_flag(detallePredialResponse.getCheckAporte());
			predialFormbases.setObjetocontrato(predialInfoInibases.getObjetocontrato());
			predialFormbases.setNumDoc(customerData.getDocumentNumber());
			predialFormbases.setTipDoc(customerData.getDocumentType());
			predialFormbases.setCompleName(customerData.getCompleteName());
			predialFormbases.setNumBP(customerData.getNumBP());
			predialFormbases.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialFormbases.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialFormbases.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialFormbases.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialFormbases.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialFormbases.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialFormbases.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialFormbases.setMarcas(detallePredialResponse.getMarcas());
			predialFormbases.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialFormbases.setEstrDatosGenerales(detallePredialResponse.getEstrDatosGenerales());
			predialFormbases.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());
			predialFormbases.setTblErrores(detallePredialResponse.getTblErrores());
			predialFormbases.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialFormbases.setNumBP(detallePredialRequest.getNumBP());
			predialFormbases.setCHIP(detallePredialRequest.getCHIP());
			predialFormbases.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialFormbases.setDireccionPredio(detallePredialResponse.getDireccionPredio());
			predialFormbases
					.setMostrarAporteVoluntario(isBefore3erViernesJunio(new Integer(detallePredialRequest.getAnioGravable())));

			final String idDestino = predialFormbases.getEstrLiquidacionPredial().getDestinoHacendario();
			predialFormbases.setDesDestino(destinoHacendario(idDestino));

			final String idCalidad = predialFormbases.getDatosJuridicos().getCalidadSujecion();

			if (idCalidad == "1" || idCalidad.equals("1"))
			{
				predialFormbases.setDesCalidad("Propietario");
			}
			else if (idCalidad == "2" || idCalidad.equals("2"))
			{
				predialFormbases.setDesCalidad("Fideicometente");
			}
			else if (idCalidad == "3" || idCalidad.equals("3"))
			{
				predialFormbases.setDesCalidad("Poseedor");
			}
			else if (idCalidad == "4" || idCalidad.equals("4"))
			{
				predialFormbases.setDesCalidad("Beneficiario");
			}
			else if (idCalidad == "5" || idCalidad.equals("5"))
			{
				predialFormbases.setDesCalidad("Usufructuario");
			}
			else if (idCalidad == "6" || idCalidad.equals("6"))
			{
				predialFormbases.setDesCalidad("Arrendatario");
			}
			else
			{
				predialFormbases.setDesCalidad("-");
			}

			for (final PredialMarcas eachMarca : predialFormbases.getMarcas())
			{
				if (StringUtils.isNotBlank(eachMarca.getTipoMarca()))
				{
					String exMarca = "";
					exMarca = eachMarca.getTipoMarca();
					if (exMarca == "1" || exMarca.equals("1") || exMarca == "4" || exMarca.equals("4"))
					{
						predialFormbases.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2" || exMarca.equals("2"))
					{
						predialFormbases.setDecExencion(eachMarca.getPorcMarca());
					}

				}
			}
		}
		else
		{
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormbases.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormbases.setContribuyenteData(contribuyenteData);
		predialFormbases
				.setControlCampos(establecerCamposImpuestoDec("sdh_02", contribuyenteData, infoRelacion.getAgenteAutorizado()));
		predialFormbases.setNumFrom(numForm);
		predialFormbases.setCatalogos(obtenerCatalogos());


		final String tipoImpuesto = new ControllerPseConstants().getPREDIAL();
		final String clavePeriodo = predialInfoInibases.getAnioGravable().substring(2, 4) + "A1";
		final String dv = contribuyenteData.getInfoContrib().getAdicionales().getDIGVERIF();
		final List<PredialResponse> predialList = new ArrayList<PredialResponse>();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(predialFormbases.getNumBP());
		infoPreviaPSE.setNumDoc(predialFormbases.getNumDoc());
		infoPreviaPSE.setTipoDoc(predialFormbases.getTipDoc());
		infoPreviaPSE.setAnoGravable(predialFormbases.getAnioGravable());
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setChip(predialFormbases.getCHIP());


		for (final PredialResponse predialItem : contribuyenteData.getPredial())
		{
			if (predialItem.getAnioGravable().equals(predialFormbases.getAnioGravable())
					&& predialItem.getCHIP().equals(predialFormbases.getCHIP()))
			{
				infoPreviaPSE.setNumObjeto(predialItem.getNumObjeto());
			}
		}

		model.addAttribute("infoPreviaPSE", infoPreviaPSE);


		model.addAttribute("predialFormbases", predialFormbases);


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_BASES_PRESUNTIVAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_BASES_PRESUNTIVAS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/predialunificado_inicio/presentarDec", method = RequestMethod.GET)
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
		generaDeclaracionRequest.setNum_id(customerModel.getNumBP());

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

	@RequestMapping(value = "/contribuyentes/predialunificado/calculo", method = RequestMethod.POST)
	@ResponseBody
	public PredialForm calculoPredial(@RequestBody
	final PredialForm dataForm, final HttpServletResponse response, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Predial Calculo--------------------------");
		final CalculoPredialRequest calculoPredialRequest = new CalculoPredialRequest();
		CalculoPredialResponse calculoPredialResponse = null;
		final PredialForm prediaFormcal = new PredialForm();


		calculoPredialRequest.setNumBP(dataForm.getNumBP());
		calculoPredialRequest.setCHIP(dataForm.getChipcalculo());
		calculoPredialRequest.setMatrInmobiliaria(dataForm.getMatrInmobiliaria());
		calculoPredialRequest.setAnioGravable(dataForm.getAnioGravable());
		calculoPredialRequest.setOpcionUso(dataForm.getOpcionuso());
		calculoPredialRequest.setDatosLiquidacion(dataForm.getNewDatosLiquidacion());
		//	calculoPredialRequest.setLiquidacionPrivada(dataForm.getCalcLiquidacionPrivada());
		//calculoPredialRequest.setLiquidacionPrivada(dataForm.getLiquidacionPrivada());
		calculoPredialRequest.setLiquidacionPrivada(dataForm.getNewLiquidacionRequ());


		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final String responseCalculo = sdhCalculoPredialService.calculoPredial(calculoPredialRequest);
			calculoPredialResponse = mapper.readValue(responseCalculo, CalculoPredialResponse.class);

			prediaFormcal.setNumFrom(calculoPredialResponse.getNumFrom());
			prediaFormcal.setLiquidacionPrivada(calculoPredialResponse.getLiquidacionPrivada());
			prediaFormcal.setErrores(calculoPredialResponse.getErrores());


		}
		catch (final Exception e)
		{
			LOG.error("error calculo declaration : " + e.getMessage());
			final CalPredialErrores error = new CalPredialErrores();

			error.setIdError("0");
			error.setDescError("Hubo un error al realizar el cálculo, por favor intentalo más tarde");


			final List<CalPredialErrores> errores = new ArrayList<CalPredialErrores>();

			errores.add(error);

			prediaFormcal.setErrores(errores);

		}

		return prediaFormcal;
	}

	@RequestMapping(value = "/contribuyentes/predialunificado/URL/declara", method = RequestMethod.GET)
	@RequireHardLogIn
	@ResponseBody
	public PredialForm predialurldeclara(@ModelAttribute("predialInfoIniURL")
	final PredialForm predialInfoIniURL, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial declaraciones --------------------------");

		final DetallePredialRequest detallePredialRequestcalc = new DetallePredialRequest();

		final PredialForm prediaFormcaldec = new PredialForm();
		detallePredialRequestcalc.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
		detallePredialRequestcalc.setAnioGravable(predialInfoIniURL.getAnioGravable());
		detallePredialRequestcalc.setCHIP(predialInfoIniURL.getCHIP());
		detallePredialRequestcalc.setMatrInmobiliaria(predialInfoIniURL.getMatrInmobiliaria());


		//		detallePredialRequestcalc.setNumBP("1000010203");
		//		detallePredialRequestcalc.setAnioGravable("2019");
		//		detallePredialRequestcalc.setCHIP("AAA0080KECZ");
		//		detallePredialRequestcalc.setMatrInmobiliaria("050N1178178");


		try
		{


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequestcalc), DetallePredialResponse.class);

			prediaFormcaldec.setRetipRegistro(detallePredialResponse.getEstrLiquidacionPrivada().getTipoRegistro());
			prediaFormcaldec.setRetipDeclaracion(detallePredialResponse.getEstrDatosGenerales().getTipoDeclaracion());

			final CustomerData customerData = customerFacade.getCurrentCustomer();

			prediaFormcaldec.setTblErrores(detallePredialResponse.getTblErrores());
			prediaFormcaldec.setTipDoc(customerData.getDocumentType());
			prediaFormcaldec.setNumDoc(customerData.getDocumentNumber());
			prediaFormcaldec.setCompleName(customerData.getCompleteName());
			prediaFormcaldec.setNumBP(customerData.getNumBP());
			prediaFormcaldec.setCHIP(predialInfoIniURL.getCHIP());
			prediaFormcaldec.setMatrInmobiliaria(predialInfoIniURL.getMatrInmobiliaria());
			prediaFormcaldec.setAnioGravable(predialInfoIniURL.getAnioGravable());
			prediaFormcaldec.setOpcionuso(Objects.isNull(detallePredialResponse.getOpcionuso()) ? "" :
					detallePredialResponse.getOpcionuso().replace(" ", "").split("-")[0]);

			String tipreg = "";

			tipreg = prediaFormcaldec.getRetipDeclaracion();
			final String numbp = prediaFormcaldec.getNumBP();
			final String chip = prediaFormcaldec.getCHIP();
			final String matricula = prediaFormcaldec.getMatrInmobiliaria();
			final String anio = prediaFormcaldec.getAnioGravable();

			String url = "";

			if (tipreg.equals("1") || tipreg.equals("1 "))
			{
				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "1";
				prediaFormcaldec.setUrl(url);
				return prediaFormcaldec;
			}
			else if (tipreg.equals("2") || tipreg.equals("2 "))
			{
				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "2";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("3") || tipreg.equals("3 "))
			{
				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "3";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("4") || tipreg.equals("4 "))
			{
				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "4";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("5") || tipreg.equals("5 "))
			{
				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "5";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("6") || tipreg.equals("6 "))
			{

				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "6";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("7") || tipreg.equals("7 "))
			{
				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "7";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("8") || tipreg.equals("8 "))
			{
				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "8";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("9") || tipreg.equals("9 "))
			{
				model.addAttribute("dataForm", new PredialForm());
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "9";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else
			{
				final String Error = "Su predio no cuenta con Tipo de registro, por lo que no se puede detrminar la declaración a realizar";
				redirectAttributes.addFlashAttribute("Error", Error);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "10";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
		}
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}

		return prediaFormcaldec;
	}

	private String destinoHacendario(final String idDestino)
	{
		String idDestinos = idDestino;
		if (idDestino.equals("00"))
		{
			return idDestinos = "-";
		}
		else if (idDestino.equals("61"))
		{
			return idDestinos = "RESIDENCIALES URBANOS Y RURALES";
		}
		else if (idDestino.equals("62"))
		{
			return idDestinos = "COMERCIALES URBANOS Y RURALES";
		}
		else if (idDestino.equals("63"))
		{
			return idDestinos = "FINANCIERO";
		}
		else if (idDestino.equals("64"))
		{
			return idDestinos = "INDUSTRIALES URBANOS Y RURALES";
		}
		else if (idDestino.equals("65"))
		{
			return idDestinos = "DEPOSITOS Y PARQUEADEROS";
		}
		else if (idDestino.equals("66"))
		{
			return idDestinos = "DOTACIONALES";
		}
		else if (idDestino.equals("67"))
		{
			return idDestinos = "LOTE/URBANIZABLES NO URBANIZADOS/URBANIZADOS NO EDIFICADOS";
		}
		else if (idDestino.equals("69"))
		{
			return idDestinos = "PEQUEÑA PROPIEDAD RURAL PARA PRODUCCIÓN AGORPECUARIA";
		}
		else if (idDestino.equals("70"))
		{
			return idDestinos = "NO URBANIZABLES";
		}
		else if (idDestino.equals("71"))
		{
			return idDestinos = "RURALES";
		}
		else if (idDestino.equals("72"))
		{
			return idDestinos = "SISTEMA DE AREAS PROTEGIDAS";
		}
		else
		{
			return idDestinos = "-";
		}
	}

	@RequestMapping(value = "/contribuyentes/predialunificado/show", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialurl_aa(@ModelAttribute("predialInfoIniURL")
	final PredialForm predialInfoIniURL, final Model model, final RedirectAttributes redirectAttributes,
			final BindingResult bindingResult, @RequestParam(required = true, value = "numForm")
			final String numForm, @RequestParam(required = true, value = "representado")
			final String representado) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial vista agente autorizado--------------------------");
		final PredialForm predialFormurl = new PredialForm();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		String tipreg = "";
		String urlReturn = "";

		final DetallePredial2Request detallePredial2Request = new DetallePredial2Request();
		DetallePredial2Response detallePredial2Response = null;

		detallePredial2Request.setPartner(representado);
		detallePredial2Request.setFormulario(numForm);
		System.out.println("Request para calculoImp/Predial2: " + detallePredial2Request);
		detallePredial2Response = gasolinaService.consultaPredial2(detallePredial2Request, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de calculoImp/Predial2: " + detallePredial2Response);

		if (detallePredial2Response != null)
		{
			tipreg = detallePredial2Response.getInfopredio().getDatosgenerales().getTipoDeclaracion().trim();
			predialFormurl.setRepresentado(representado);
			predialFormurl.setNumFrom(numForm);
			predialFormurl.setCHIP(detallePredial2Response.getInfopredio().getDatosgenerales().getChip());
			predialFormurl
					.setMatrInmobiliaria(detallePredial2Response.getInfopredio().getDatosgenerales().getMatrInmobiliaria());
			predialFormurl.setAnioGravable(detallePredial2Response.getInfopredio().getDatosgenerales().getAnioAgravable());
			predialFormurl.setDetallePredial2Response(detallePredial2Response);
		}


		switch (tipreg)
		{
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
				model.addAttribute("predialFormurl", predialFormurl);
				model.addAttribute("dataForm", predialFormurl);
				urlReturn = "redirect:/contribuyentes/predialunificado_" + tipreg;
				break;

			case "9":
				redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
				model.addAttribute("predialFormurl", predialFormurl);
				model.addAttribute("dataForm", predialFormurl);
				urlReturn = "redirect:/contribuyentes/predialunificado/basespresuntivas";
				break;
			default:
				final String Error = "Su predio no cuenta con Tipo de declaración, por lo que no se puede detrminar la declaración a realizar";
				redirectAttributes.addFlashAttribute("Error", Error);
				model.addAttribute("predialFormurl", predialFormurl);
				urlReturn = "redirect:/contribuyentes/predialunificado_inicio";
				break;
		}


		return urlReturn;
	}


	private RelContribuyenteAgenteAutorizado prepararInfoAgenteAutorizado(final Model model, final PredialForm predialInfo,
			final String tiporeg,
			final PredialForm infoReemplazo)
	{
		CustomerData customerData;
		CustomerData agenteAutorizadoData = null;
		final RelContribuyenteAgenteAutorizado infoRelacion = new RelContribuyenteAgenteAutorizado();
		List<FirmanteResponse> firmantes = null;
		String tipoUsuario = "C";

		if (predialInfo != null && predialInfo.getRepresentado() != null)
			{
			System.out.println("---------- En predial unificado " + tiporeg + " GET Agente Autorizado ----------");
			tipoUsuario = "A";
			customerData = sdhCustomerFacade.getRepresentadoDataFromSAP(predialInfo.getRepresentado());
			agenteAutorizadoData = customerFacade.getCurrentCustomer();

			infoReemplazo.setNumBP(predialInfo.getRepresentado());
			infoReemplazo.setCHIP(predialInfo.getCHIP());
			infoReemplazo.setAnioGravable(predialInfo.getAnioGravable());
			infoReemplazo.setMatrInmobiliaria(predialInfo.getMatrInmobiliaria());
			infoReemplazo.setNumFrom(predialInfo.getNumFrom());
			infoReemplazo.setRepresentado(predialInfo.getRepresentado());
			firmantes = rempaeoFirmantes(predialInfo.getDetallePredial2Response().getFirmantes());
		}
		else
		{
			customerData = customerFacade.getCurrentCustomer();
		}
		establecerInfoFirmas(model, customerData, agenteAutorizadoData, firmantes, tipoUsuario,
				"contribuyentes/predialunificado_" + tiporeg);

		infoRelacion.setContribuyente(customerData);
		infoRelacion.setAgenteAutorizado(agenteAutorizadoData);

		return infoRelacion;
	}


	/**
	 * @param firmantes
	 * @return
	 */
	private List<FirmanteResponse> rempaeoFirmantes(final List<FirmanteResponsePredial2> firmantesOrigen)
	{
		List<FirmanteResponse> firmantesDestino = null;
		FirmanteResponse firmaDestinoActual = null;

		if (firmantesOrigen != null)
		{
			firmantesDestino = new ArrayList<FirmanteResponse>();
			for (final FirmanteResponsePredial2 firmaOrigenActual : firmantesOrigen)
			{
				if (firmaOrigenActual.getTipoIdent() != null && !firmaOrigenActual.getTipoIdent().isEmpty())
				{
					firmaDestinoActual = new FirmanteResponse();
					firmaDestinoActual.setTipoIdent(firmaOrigenActual.getTipoIdent());
					firmaDestinoActual.setNumIdent(firmaOrigenActual.getNumIdent());
					firmaDestinoActual.setNombre(firmaOrigenActual.getNombre());
					firmaDestinoActual.setTarjetaProd(firmaOrigenActual.getTarjetaProd());
					firmantesDestino.add(firmaDestinoActual);
				}
			}
		}

		return firmantesDestino;
	}


	private void establecerInfoFirmas(final Model model, final CustomerData contribuyenteData,
			final CustomerData agenteAutorizadoData, final List<FirmanteResponse> firmantes, final String tipoUsuario,
			final String url)
	{
		switch (tipoUsuario)
		{
			case "C": //contribuyente
				model.addAttribute("customerData", contribuyenteData);

				addAgentsToModel(model, contribuyenteData, null);

				model.addAttribute("redirectURL", url);
				super.addFirmantes_impuesto(model, null, contribuyenteData);

				break;

			case "A": //agente autorizado
				model.addAttribute("contribuyenteData", contribuyenteData);
				model.addAttribute("currentUserData", agenteAutorizadoData);
				model.addAttribute("customerData", agenteAutorizadoData);
				model.addAttribute("currentUser", agenteAutorizadoData);

				addAgentsToModel(model, contribuyenteData, agenteAutorizadoData);

				model.addAttribute("redirectURL",
						"/autorizados/contribuyente/representando?representado=" + contribuyenteData.getNumBP());

				if (firmantes != null)
				{
					super.addFirmantes_impuesto(model, firmantes, agenteAutorizadoData);
				}
				break;


			default:
				break;
		}


	}

	private PredialControlCamposDec establecerCamposImpuestoDec(final String rol, final SDHValidaMailRolResponse contribuyenteData,
			final CustomerData currentUserData)
	{
		final PredialControlCamposDec controlCampos = new PredialControlCamposDec();
		final String strRepresentanteLegalPrincipal = "Repres. Legal Principal";
		final String strContador = "Contador";
		String funcionInterlocultorValida = null;

		if (contribuyenteData.getInfoContrib().getTipoDoc().equals("NIT") || currentUserData != null)
		{
			controlCampos.setBtnPresentarDec(true);
			controlCampos.setBtnPagarDec(true);
		}

		switch (contribuyenteData.getInfoContrib().getTipoDoc())
		{
			case "NIT":
				funcionInterlocultorValida = strRepresentanteLegalPrincipal;
				break;
			default:
				funcionInterlocultorValida = strContador;
				break;
		}

		switch (rol)
		{
			case "sdh_02":
				if (contribuyenteData.getAgentes() != null && currentUserData != null){
					controlCampos.setLiquidacionPrivada(true);
					controlCampos.setLiquidacion(true);
					controlCampos.setDatosPredio(true);

					for (final ContribAgente infoAgente : contribuyenteData.getAgentes())
					{
						if (infoAgente != null)
						{
							if (!StringUtils.isEmpty(infoAgente.getBp()) && !StringUtils.isEmpty(infoAgente.getFuncionInterl())
									&& infoAgente.getFuncionInterl() != null && infoAgente.getBp() != null
									&& infoAgente.getBp().equals(currentUserData.getNumBP())
									&& infoAgente.getFuncionInterl().equals(funcionInterlocultorValida))
							{
								controlCampos.setBtnPresentarDec(false);
								controlCampos.setBtnPagarDec(false);
								break;
							}
						}
					}
				}

				break;

			default:
				break;
		}

		return controlCampos;
	}

	/**
	 * @param predialInfo
	 * @return
	 */
	private DetallePredialResponse remapeoDesdePedial2(final PredialForm predialInfo)
	{
		DetallePredialResponse responseRemapeo = null;

		if (predialInfo.getDetallePredial2Response() != null)
		{
			responseRemapeo = new DetallePredialResponse();

			responseRemapeo.setCheckAporte(predialInfo.getCheckAporte_flag());
			responseRemapeo
					.setOpcionuso(predialInfo.getDetallePredial2Response().getInfopredio().getDatosgenerales().getOpcionuso());
			responseRemapeo.setDireccionPredio(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatosgenerales().getDireccionPredio());

			final PredialDatosJuridicos datosJuridicos = new PredialDatosJuridicos();
			datosJuridicos.setCalidadSujecion(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatosgenerales().getCalidadSujecion());
			datosJuridicos
					.setPorcentajePropiedad(predialInfo.getDetallePredial2Response().getLiquidacion().getPorcentajePropiedad());
			responseRemapeo.setDatosJuridicos(datosJuridicos);


			final PredialDatosEconomicos datosEconomicos = new PredialDatosEconomicos();
			datosEconomicos.setBaseGravable(predialInfo.getDetallePredial2Response().getLiquidacion().getBaseGravable());
			responseRemapeo.setDatosEconomicos(datosEconomicos);

			final PredialDatosFisicos datosFisicos = new PredialDatosFisicos();
			datosFisicos
					.setAreaConstruida(predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getAreaConstruida());
			datosFisicos.setAreaTerrenoCatastro(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getAreaTerrenoCatastro());
			datosFisicos.setAreaTerrenoMejora(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getAreaTerrenoMejora());
			responseRemapeo.setDatosFisicos(datosFisicos);

			final List<PredialMarcas> marcas = new ArrayList<PredialMarcas>();
			for (final DetallePredial2Response_marcas marcaOrigen : predialInfo.getDetallePredial2Response().getMarcas())
			{
				if (!StringUtils.isEmpty(marcaOrigen.getMarca()))
				{
					final PredialMarcas marcaDestino = new PredialMarcas();
					marcaDestino.setMarca(marcaOrigen.getMarca());
					marcaDestino.setTipoMarca(marcaOrigen.getTipoMarca());
					marcaDestino.setPorcMarca(marcaOrigen.getPorcMarca());
					marcas.add(marcaDestino);
				}
			}
			responseRemapeo.setMarcas(marcas);

			final PredialEstLiquidacion estrLiquidacionPredial = new PredialEstLiquidacion();
			estrLiquidacionPredial.setBaseGravable(predialInfo.getDetallePredial2Response().getLiquidacion().getBaseGravable());
			estrLiquidacionPredial
					.setDestinoHacendario(predialInfo.getDetallePredial2Response().getLiquidacion().getDestinoHacendario());
			estrLiquidacionPredial
					.setTarifaLiquidacion(predialInfo.getDetallePredial2Response().getLiquidacion().getTarifaLiquidacion());
			responseRemapeo.setEstrLiquidacionPredial(estrLiquidacionPredial);

			final PredialEstDatosGenerales estrDatosGenerales = new PredialEstDatosGenerales();
			estrDatosGenerales.setCedulaCatastral(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatosgenerales().getCedulaCatastral());
			estrDatosGenerales.setTipoDeclaracion(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatosgenerales().getTipoDeclaracion());
			estrDatosGenerales.setCanonArrendamiento(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getCanonArrendamiento());
			estrDatosGenerales.setAvaluoMatrizMejora(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getAvaluoMatrizMejora());
			estrDatosGenerales.setAvaluoProrrateado(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getAvaluoProrrateado());
			estrDatosGenerales.setAvaluoIndiceEdificabilidad(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getAvaluoIndiceEdificabilidad());
			estrDatosGenerales.setExclusionParcial(predialInfo.getDetallePredial2Response().getLiquidacion().getExclusionParcial());
			estrDatosGenerales.setCaracterizacionPredio(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getCaracterizacionPredio());
			estrDatosGenerales.setPropiedadHorizontal(
					predialInfo.getDetallePredial2Response().getInfopredio().getDatospredio().getPropiedadHorizontal());
			responseRemapeo.setEstrDatosGenerales(estrDatosGenerales);

			responseRemapeo.setEstrLiquidacionPrivada(predialInfo.getDetallePredial2Response().getLiquidacionprivada());


		}

		return responseRemapeo;
	}

	private boolean isBefore3erViernesJunio(final Integer anioGravable)
	{
		final LocalDate tercerViernesJunio = LocalDate.of(anioGravable.intValue(), 6, 21);
		final LocalDate hoy = LocalDate.now();
		//d = d.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY));

		if (hoy.isBefore(tercerViernesJunio))
		{
			return true;
		}

		return false;
	}


	/**
	 * @param infoReemplazo
	 * @param predialInfo
	 * @param detallePredialRequest
	 * @return
	 */
	private DetallePredialResponse determinaResponse(final PredialForm infoReemplazo, final PredialForm predialInfo,
			final DetallePredialRequest detallePredialRequest)
	{
		DetallePredialResponse detallePredialResponse = null;

		if (infoReemplazo.getRepresentado() != null)
		{
			if (predialInfo != null && predialInfo.getDetallePredial2Response() != null
					&& predialInfo.getDetallePredial2Response().getInfopredio() != null
					&& predialInfo.getDetallePredial2Response().getInfopredio().getDatosgenerales() != null
					&& predialInfo.getDetallePredial2Response().getInfopredio().getDatosgenerales().getTipoDeclaracion() != null)
			{
				switch (predialInfo.getDetallePredial2Response().getInfopredio().getDatosgenerales().getTipoDeclaracion().trim())
				{
					case "1":
					case "2":
					case "3":
					case "4":
					case "5":
					case "6":
					case "7":
					case "8":
					case "9":
						detallePredialResponse = remapeoDesdePedial2(predialInfo);
						break;
					default:
						break;
				}

			}

		}
		else
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			try
			{
				detallePredialResponse = mapper.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest),
						DetallePredialResponse.class);
			}
			catch (final Exception e)
			{
				LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			}
		}

		return detallePredialResponse;
	}


	/**
	 * @param predialBPinfo
	 * @return
	 */
	private DetallePredialResponse remapeoDesdePedialBP(final DetallePredialBPResponse predialBPinfo)
	{
		DetallePredialResponse responseRemapeo = new DetallePredialResponse();

		if (predialBPinfo != null)
		{
			responseRemapeo = new DetallePredialResponse();
		}



		return responseRemapeo;
	}


	/**
	 * @param predialInfo
	 * @return
	 */
	@RequestMapping(value = "/contribuyentes/predialunificado_inicio/precalculoPredialBP", method = RequestMethod.GET)
	@ResponseBody
	public DetallePredialBPResponse llamarWSpredialBP(@ModelAttribute("predialInfo")
	final PredialForm predialInfo, final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		System.out.println("---------- En predial bases presuntivas ----------");
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		DetallePredialBPResponse detallePredialBPResponse = null;
		final DetallePredialBPRequest detallePredialBPRequest = new DetallePredialBPRequest();


		detallePredialBPRequest.setNumBP(predialInfo.getNumBP());
		detallePredialBPRequest.setChip(predialInfo.getCHIP());
		detallePredialBPRequest.setAnioGravable(predialInfo.getAnioGravable());
		detallePredialBPRequest.setAreaConstruida(predialInfo.getAreaConstruida());
		detallePredialBPRequest.setAreaTerrenoCatastro(predialInfo.getAreaTerrenoCatastro());
		detallePredialBPRequest.setCaracterizacionPredio(predialInfo.getCaracterizacionPredio());
		detallePredialBPRequest.setPropiedadHorizontal(predialInfo.getPropiedadHorizontal());
		detallePredialBPRequest.setDestinoHacendario(predialInfo.getDestinoHacendario());

		System.out.println("Request para basespresuntivas: " + detallePredialBPRequest);
		detallePredialBPResponse = gasolinaService.consultaPredialBP(detallePredialBPRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de basespresuntivas: " + detallePredialBPResponse);


		return detallePredialBPResponse;
	}


	/**
	 * @return
	 */
	private PredialCatalogos obtenerCatalogos()
	{
		final PredialCatalogos catalogos = new PredialCatalogos();

		Map<String, String> elementos = null;

		//Caracterización del predio
		elementos = new LinkedHashMap<String, String>();
		elementos.put("", "Seleccionar");

		catalogos.setCaracterizacionPredio(elementos);


		//Propiedad horizontal
		elementos = new LinkedHashMap<String, String>();
		elementos.put("", "Seleccionar");
		elementos.put("1", "SI");
		elementos.put("2", "NO");

		catalogos.setPropiedadHorizontal(elementos);


		//Destino hacendario
		elementos = new LinkedHashMap<String, String>();
		elementos.put("", "Seleccionar");
		elementos.put("61", "RESIDENCIAL");
		elementos.put("62", "COMERCIAL");
		elementos.put("66", "DOTACIONAL");
		elementos.put("64", "INDUSTRIAL");
		elementos.put("65", "DEPOSITO Y PARQUEADERO");
		elementos.put("67", "URBANIZABLE NO URBANIZADO Y URBANIZADO NO EDIFICADO");

		catalogos.setDestinoHacendario(elementos);


		return catalogos;
	}

	@RequestMapping(value = "/setComplete4", method = RequestMethod.POST)
	public String setComplete(final SessionStatus status)
	{
		status.setComplete();

		return null;
	}



}

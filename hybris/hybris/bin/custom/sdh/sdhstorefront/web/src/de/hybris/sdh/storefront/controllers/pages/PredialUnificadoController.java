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
import de.hybris.platform.core.GenericSearchConstants.LOG;
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
import de.hybris.sdh.core.pojos.requests.DetallePredialRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.responses.CalPredialErrores;
import de.hybris.sdh.core.pojos.responses.CalculoPredialResponse;
import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.DetallePredial2Response;
import de.hybris.sdh.core.pojos.responses.DetallePredialResponse;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.FirmanteResponse;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
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
import de.hybris.sdh.storefront.forms.PredialControlCamposDec;
import de.hybris.sdh.storefront.forms.PredialForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_4";
		}
		else if (tipreg.equals("5") || tipreg.equals("5 "))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_5";
		}
		else if (tipreg.equals("6") || tipreg.equals("6 "))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_6";
		}
		else if (tipreg.equals("7") || tipreg.equals("7 "))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_7";
		}
		else if (tipreg.equals("8") || tipreg.equals("8 "))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_8";
		}
		else if (tipreg.equals("9") || tipreg.equals("9 "))
		{
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

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final PredialForm infoReemplazo = new PredialForm();
		prepararInfoAgenteAutorizado(model, customerData, predialInfo, "1", infoReemplazo);
		if (infoReemplazo.getNumBP() != null && infoReemplazo.getCHIP() != null && infoReemplazo.getAnioGravable() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
		}

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

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);

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
		catch (final IOException e)
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
				establecerCamposImpuestoDec("sdh_02", contribuyenteData, customerFacade.getCurrentCustomer()));


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

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final PredialForm infoReemplazo = new PredialForm();
		prepararInfoAgenteAutorizado(model, customerData, predialInfo, "2", infoReemplazo);
		if (infoReemplazo.getNumBP() != null && infoReemplazo.getCHIP() != null && infoReemplazo.getAnioGravable() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
		}


		final PredialForm predialFormdos = new PredialForm();
		PredialForm predialInfoInidos = new PredialForm();

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

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);

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
		catch (final IOException e)
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
						establecerCamposImpuestoDec("sdh_02", contribuyenteData, customerFacade.getCurrentCustomer()));

		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
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

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final PredialForm infoReemplazo = new PredialForm();
		prepararInfoAgenteAutorizado(model, customerData, predialInfo, "3", infoReemplazo);
		if (infoReemplazo.getNumBP() != null && infoReemplazo.getCHIP() != null && infoReemplazo.getAnioGravable() != null)
		{
			numBP = infoReemplazo.getNumBP();
			chip = infoReemplazo.getCHIP();
			anioGravable = infoReemplazo.getAnioGravable();
			matricula = infoReemplazo.getMatrInmobiliaria();
		}

		final PredialForm predialFormtres = new PredialForm();

		PredialForm predialInfoInitres = new PredialForm();
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
				establecerCamposImpuestoDec("sdh_02", contribuyenteData, customerFacade.getCurrentCustomer()));

		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("predialFormtres", predialFormtres);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_TRES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_TRES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_4", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialcuatro(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado CUATRO --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "contribuyentes/predialunificado_4");
		super.addFirmantes_impuesto(model, null, customerData);

		final PredialForm predialFormcua = new PredialForm();
		//	final PredialForm predialInfoInicuatro = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoInicuatro = new PredialForm();
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

		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("predialFormcua", predialFormcua);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_CUATRO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_CUATRO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_5", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialcinco(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado CINCO --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "contribuyentes/predialunificado_5");
		super.addFirmantes_impuesto(model, null, customerData);

		final PredialForm predialFormcinco = new PredialForm();

		//		final PredialForm predialInfoInicinco = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoInicinco = new PredialForm();
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

		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("predialFormcinco", predialFormcinco);



		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_CINCO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_CINCO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_6", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialseis(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado SEIS --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "contribuyentes/predialunificado_6");
		super.addFirmantes_impuesto(model, null, customerData);

		final PredialForm predialFormseis = new PredialForm();

		//final PredialForm predialInfoIniseis = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoIniseis = new PredialForm();
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

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);


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
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}
		final SDHValidaMailRolResponse contribuyenteData = sdhCustomerFacade.getRepresentadoFromSAP(customerData.getNumBP());
		contribuyenteData.setPredial(contribuyenteData.getPredial().stream()
				.filter(d -> predialFormseis.getCHIP().equals(d.getCHIP())).collect(Collectors.toList()));
		predialFormseis.setContribuyenteData(contribuyenteData);

		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("predialFormseis", predialFormseis);


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_SEIS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_SEIS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_7", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialsiete(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado Siete --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "contribuyentes/predialunificado_7");
		super.addFirmantes_impuesto(model, null, customerData);

		final PredialForm predialFormsiete = new PredialForm();

		//final PredialForm predialInfoInisiete = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoInisiete = new PredialForm();
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

		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("predialFormsiete", predialFormsiete);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_SIETE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_SIETE_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_8", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialocho(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado OCHO --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "contribuyentes/predialunificado_8");
		super.addFirmantes_impuesto(model, null, customerData);

		final PredialForm predialFormocho = new PredialForm();

		//		final PredialForm predialInfoIniocho = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoIniocho = new PredialForm();
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

		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("predialFormocho", predialFormocho);



		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_OCHO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_OCHO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado/basespresuntivas", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialbases(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado BASES PRESUNTIVAS --------------------------");
		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final PredialForm predialFormbases = new PredialForm();

		//		final PredialForm predialInfoInibases = (PredialForm) model.asMap().get("predialFormurl");
		PredialForm predialInfoInibases = new PredialForm();
		try
		{

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

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);


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
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}

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
		calculoPredialRequest.setLiquidacionPrivada(dataForm.getCalcLiquidacionPrivada());


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
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "1";
				prediaFormcaldec.setUrl(url);
				return prediaFormcaldec;
			}
			else if (tipreg.equals("2") || tipreg.equals("2 "))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "2";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("3") || tipreg.equals("3 "))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "3";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("4") || tipreg.equals("4 "))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "4";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("5") || tipreg.equals("5 "))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "5";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("6") || tipreg.equals("6 "))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "6";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("7") || tipreg.equals("7 "))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "7";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("8") || tipreg.equals("8 "))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "8";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("9") || tipreg.equals("9 "))
			{
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
		String tipreg = "1";
		String urlReturn = "";


		final DetallePredial2Request detallePredial2Request = new DetallePredial2Request();
		DetallePredial2Response detallePredial2Response = null;

		detallePredial2Request.setPartner(representado);
		detallePredial2Request.setFormulario(numForm);
		System.out.println("Request para validaCont: " + detallePredial2Request);
		detallePredial2Response = gasolinaService.consultaPredial2(detallePredial2Request, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de validaCont: " + detallePredial2Response);

		if (detallePredial2Response != null)
		{
			tipreg = detallePredial2Response.getInfopredio().getDatosgenerales().getTipoDeclaracion().trim();
			predialFormurl.setRepresentado(representado);
			predialFormurl.setNumFrom(numForm);
			predialFormurl.setCHIP(detallePredial2Response.getInfopredio().getDatosgenerales().getChip());
			predialFormurl.setMatrInmobiliaria(detallePredial2Response.getInfopredio().getDatosgenerales().getMatrInmobiliaria());
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
				urlReturn = "redirect:/contribuyentes/basespresuntivas";
			default:
				final String Error = "Su predio no cuenta con Tipo de declaración, por lo que no se puede detrminar la declaración a realizar";
				redirectAttributes.addFlashAttribute("Error", Error);
				model.addAttribute("predialFormurl", predialFormurl);
				urlReturn = "redirect:/contribuyentes/predialunificado_inicio";
				break;
		}


		return urlReturn;
	}


	private void prepararInfoAgenteAutorizado(final Model model, final CustomerData customerData, final PredialForm predialInfo,
			final String tiporeg, final PredialForm infoReemplazo)
	{
		CustomerData agenteAutorizadoData = null;
		CustomerData customerData2 = null;
		CustomerData customerData_tmp = customerData;
		List<FirmanteResponse> firmantes = null;
		String tipoUsuario = "C";

		if (predialInfo != null)
		{
			if (predialInfo.getRepresentado() != null)
			{
				System.out
						.println("---------------- Hola entro predial unificado uno GET Agente Autorizado--------------------------");
				tipoUsuario = "A";
				infoReemplazo.setNumBP(predialInfo.getRepresentado());
				infoReemplazo.setCHIP(predialInfo.getCHIP());
				agenteAutorizadoData = customerData;
				customerData2 = sdhCustomerFacade.getRepresentadoDataFromSAP(infoReemplazo.getNumBP());
				customerData_tmp = customerData2;
				infoReemplazo.setAnioGravable(predialInfo.getAnioGravable());
				infoReemplazo.setMatrInmobiliaria(predialInfo.getMatrInmobiliaria());
				firmantes = predialInfo.getDetallePredial2Response().getFirmantes();
			}
		}
		establecerInfoFirmas(model, customerData_tmp, agenteAutorizadoData, firmantes, tipoUsuario,
				"contribuyentes/predialunificado_" + tiporeg);

		if (customerData2 != null)
		{
			customerData.setNumBP(customerData2.getNumBP());
			customerData.setDocumentType(customerData2.getDocumentType());
			customerData.setDocumentNumber(customerData2.getDocumentNumber());
			customerData.setCompleteName(customerData2.getCompleteName());
		}
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
		PredialControlCamposDec controlCampos = null;
		final String strRepresentanteLegalPrincipal = "Repres. Legal Principal";

		switch (rol)
		{
			case "sdh_02":
				controlCampos = new PredialControlCamposDec();
				controlCampos.setBtnPresentarDec(true);
				controlCampos.setBtnPagarDec(true);

				if (contribuyenteData.getAgentes() != null)
				{
					for (final ContribAgente infoAgente : contribuyenteData.getAgentes())
					{
						if (infoAgente != null)
						{
							if (infoAgente.getFuncionInterl() != null && infoAgente.getBp() != null
									&& infoAgente.getBp().equals(currentUserData.getNumBP())
									&& infoAgente.getFuncionInterl().equals(strRepresentanteLegalPrincipal))
							{
								controlCampos.setBtnPresentarDec(false);
								controlCampos.setBtnPagarDec(false);
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

}

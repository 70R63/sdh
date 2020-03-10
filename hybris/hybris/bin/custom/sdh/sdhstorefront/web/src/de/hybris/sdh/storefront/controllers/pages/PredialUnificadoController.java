/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
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
import de.hybris.sdh.core.pojos.requests.CalculoPredialRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePredialRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.PredialPresentarDecRequest;
import de.hybris.sdh.core.pojos.responses.CalPredialErrores;
import de.hybris.sdh.core.pojos.responses.CalculoPredialResponse;
import de.hybris.sdh.core.pojos.responses.DetallePredialResponse;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.PredialMarcas;
import de.hybris.sdh.core.pojos.responses.PredialPresentarDecResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCalculoPredialService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHDetallePredialService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.PredialForm;
import de.hybris.sdh.storefront.forms.PredialPresentarDecForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class PredialUnificadoController extends SDHAbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Predial";
	private static final String TEXT_BASES_PROFILE = "Predial Bases Presuntivas";

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



	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

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
		System.out.println("---------------- Hola entro predial unificado uno --------------------------");
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

		tipreg = predialInfoIniURL.getRetipRegistro();

		if (tipreg.equals("1"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_1";
		}
		else if (tipreg.equals("2"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_2";
		}
		else if (tipreg.equals("3"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_3";
		}
		else if (tipreg.equals("4"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_4";
		}
		else if (tipreg.equals("5"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_5";
		}
		else if (tipreg.equals("6"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_6";
		}
		else if (tipreg.equals("7"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_7";
		}
		else if (tipreg.equals("8"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_8";
		}
		else if (tipreg.equals("9"))
		{
			redirectAttributes.addFlashAttribute("predialFormurl", predialFormurl);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado/basespresuntivas";
		}
		else
		{
			final String Error = "Su predio no cuenta con Tipo de registro, por lo que no se puede detrminar la declaración a realizar";
			redirectAttributes.addFlashAttribute("Error", Error);
			model.addAttribute("predialFormurl", predialFormurl);
			return "redirect:/contribuyentes/predialunificado_inicio";
		}




		//model.addAttribute("predialFormurl", predialFormurl);

		//		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNO_CMS_PAGE));
		//		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNO_CMS_PAGE));
		//		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		//		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		//
		//		return "redirect:/contribuyentes/predialunificado_1";
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_1", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialuno(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado uno --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "contribuyentes/predialunificado_1");
		super.addFirmantes_impuesto(model, null, customerData);

		final PredialForm predialFormuno = new PredialForm();
		PredialForm predialInfoIniUno = new PredialForm();

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



			String idCalidad = predialFormuno.getDatosJuridicos().getCalidadSujecion();

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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormuno.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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

		model.addAttribute("predialForm", predialFormuno);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_2", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialdos(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado DOS --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "contribuyentes/predialunificado_2");
		super.addFirmantes_impuesto(model, null, customerData);

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

			String idCalidad = predialFormdos.getDatosJuridicos().getCalidadSujecion();


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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormdos.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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


		model.addAttribute("predialFormdos", predialFormdos);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_DOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_DOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_3", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialtres(final Model model, @RequestParam(required = false, value = "anioGravable")
	final String anioGravable, @RequestParam(required = false, value = "chip")
	final String chip, @RequestParam(required = false, value = "matricula")
	final String matricula, @RequestParam(required = false, value = "numBP")
	final String numBP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado TRES --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "contribuyentes/predialunificado_3");
		super.addFirmantes_impuesto(model, null, customerData);

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

			String idCalidad = predialFormtres.getDatosJuridicos().getCalidadSujecion();

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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormtres.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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

		model.addAttribute("predialFormtres", predialFormtres);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_TRES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_TRES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
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

			final String idCalidad = "";

			if (predialFormcua.getDatosJuridicos().getCalidadSujecion() == "1")
			{
				predialFormcua.setDesCalidad("Propietario");
			}
			else if (predialFormcua.getDatosJuridicos().getCalidadSujecion() == "2")
			{
				predialFormcua.setDesCalidad("Fideicometente");
			}
			else if (predialFormcua.getDatosJuridicos().getCalidadSujecion() == "3")
			{
				predialFormcua.setDesCalidad("Poseedor");
			}
			else if (predialFormcua.getDatosJuridicos().getCalidadSujecion() == "4")
			{
				predialFormcua.setDesCalidad("Beneficiario");
			}
			else if (predialFormcua.getDatosJuridicos().getCalidadSujecion() == "5")
			{
				predialFormcua.setDesCalidad("Usufructuario");
			}
			else if (predialFormcua.getDatosJuridicos().getCalidadSujecion() == "6")
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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormcua.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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

			final String idCalidad = "";

			if (predialFormcinco.getDatosJuridicos().getCalidadSujecion() == "1")
			{
				predialFormcinco.setDesCalidad("Propietario");
			}
			else if (predialFormcinco.getDatosJuridicos().getCalidadSujecion() == "2")
			{
				predialFormcinco.setDesCalidad("Fideicometente");
			}
			else if (predialFormcinco.getDatosJuridicos().getCalidadSujecion() == "3")
			{
				predialFormcinco.setDesCalidad("Poseedor");
			}
			else if (predialFormcinco.getDatosJuridicos().getCalidadSujecion() == "4")
			{
				predialFormcinco.setDesCalidad("Beneficiario");
			}
			else if (predialFormcinco.getDatosJuridicos().getCalidadSujecion() == "5")
			{
				predialFormcinco.setDesCalidad("Usufructuario");
			}
			else if (predialFormcinco.getDatosJuridicos().getCalidadSujecion() == "6")
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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormcinco.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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

		model.addAttribute("predialFormcinco", predialFormcinco);



		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_CINCO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_CINCO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
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


			final String idCalidad = "";

			if (predialFormseis.getDatosJuridicos().getCalidadSujecion() == "1")
			{
				predialFormseis.setDesCalidad("Propietario");
			}
			else if (predialFormseis.getDatosJuridicos().getCalidadSujecion() == "2")
			{
				predialFormseis.setDesCalidad("Fideicometente");
			}
			else if (predialFormseis.getDatosJuridicos().getCalidadSujecion() == "3")
			{
				predialFormseis.setDesCalidad("Poseedor");
			}
			else if (predialFormseis.getDatosJuridicos().getCalidadSujecion() == "4")
			{
				predialFormseis.setDesCalidad("Beneficiario");
			}
			else if (predialFormseis.getDatosJuridicos().getCalidadSujecion() == "5")
			{
				predialFormseis.setDesCalidad("Usufructuario");
			}
			else if (predialFormseis.getDatosJuridicos().getCalidadSujecion() == "6")
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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormseis.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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

		model.addAttribute("predialFormseis", predialFormseis);


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_SEIS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_SEIS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
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

			final String idCalidad = "";

			if (predialFormsiete.getDatosJuridicos().getCalidadSujecion() == "1")
			{
				predialFormsiete.setDesCalidad("Propietario");
			}
			else if (predialFormsiete.getDatosJuridicos().getCalidadSujecion() == "2")
			{
				predialFormsiete.setDesCalidad("Fideicometente");
			}
			else if (predialFormsiete.getDatosJuridicos().getCalidadSujecion() == "3")
			{
				predialFormsiete.setDesCalidad("Poseedor");
			}
			else if (predialFormsiete.getDatosJuridicos().getCalidadSujecion() == "4")
			{
				predialFormsiete.setDesCalidad("Beneficiario");
			}
			else if (predialFormsiete.getDatosJuridicos().getCalidadSujecion() == "5")
			{
				predialFormsiete.setDesCalidad("Usufructuario");
			}
			else if (predialFormsiete.getDatosJuridicos().getCalidadSujecion() == "6")
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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormsiete.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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

		model.addAttribute("predialFormsiete", predialFormsiete);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_SIETE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_SIETE_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
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

			final String idCalidad = "";

			if (predialFormocho.getDatosJuridicos().getCalidadSujecion() == "1")
			{
				predialFormocho.setDesCalidad("Propietario");
			}
			else if (predialFormocho.getDatosJuridicos().getCalidadSujecion() == "2")
			{
				predialFormocho.setDesCalidad("Fideicometente");
			}
			else if (predialFormocho.getDatosJuridicos().getCalidadSujecion() == "3")
			{
				predialFormocho.setDesCalidad("Poseedor");
			}
			else if (predialFormocho.getDatosJuridicos().getCalidadSujecion() == "4")
			{
				predialFormocho.setDesCalidad("Beneficiario");
			}
			else if (predialFormocho.getDatosJuridicos().getCalidadSujecion() == "5")
			{
				predialFormocho.setDesCalidad("Usufructuario");
			}
			else if (predialFormocho.getDatosJuridicos().getCalidadSujecion() == "6")
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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormocho.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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

		model.addAttribute("predialFormocho", predialFormocho);



		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_OCHO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_OCHO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
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

			final String idCalidad = "";

			if (predialFormbases.getDatosJuridicos().getCalidadSujecion() == "1")
			{
				predialFormbases.setDesCalidad("Propietario");
			}
			else if (predialFormbases.getDatosJuridicos().getCalidadSujecion() == "2")
			{
				predialFormbases.setDesCalidad("Fideicometente");
			}
			else if (predialFormbases.getDatosJuridicos().getCalidadSujecion() == "3")
			{
				predialFormbases.setDesCalidad("Poseedor");
			}
			else if (predialFormbases.getDatosJuridicos().getCalidadSujecion() == "4")
			{
				predialFormbases.setDesCalidad("Beneficiario");
			}
			else if (predialFormbases.getDatosJuridicos().getCalidadSujecion() == "5")
			{
				predialFormbases.setDesCalidad("Usufructuario");
			}
			else if (predialFormbases.getDatosJuridicos().getCalidadSujecion() == "6")
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
					final String exMarca = "";
					if (exMarca == "1" || exMarca == "4")
					{
						predialFormbases.setDecExclusion(eachMarca.getPorcMarca());
					}
					if (exMarca == "2")
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
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_BASES_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/predialunificado_inicio/presentarDec", method = RequestMethod.GET)
	@ResponseBody
	public PredialPresentarDecResponse presentarDec(final PredialPresentarDecForm dataForm, final HttpServletResponse response,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Predial Presentar Declaracion --------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final PredialPresentarDecRequest presentaDecRequest = new PredialPresentarDecRequest();
		PredialPresentarDecResponse presentaDecResponse = null;
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);


		presentaDecRequest.setBp(customerModel.getNumBP());
		presentaDecRequest.setChip(dataForm.getChip());
		presentaDecRequest.setAnioGravable(dataForm.getAnioGravable());

		try
		{
			System.out.println("Request de calculoimpuesto/TEST: " + presentaDecRequest);
			presentaDecResponse = gasolinaService.predialPresentarDec(presentaDecRequest, sdhDetalleGasolinaWS, LOG);
			System.out.println("Response de calculoimpuesto/TEST: " + presentaDecResponse);



			if (presentaDecResponse != null && presentaDecResponse.getStringPDF() != null)
			{
				final String encodedBytes = presentaDecResponse.getStringPDF();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = "Predial-" + customerModel.getNumBP() + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE.booleanValue());
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				presentaDecResponse.setUrlDownload(mediaModel.getDownloadURL());


			}

		}
		catch (final Exception e)
		{
			LOG.error("error generating declaration : " + e.getMessage());

			final ErrorEnWS error = new ErrorEnWS();

			error.setId("0");
			error.setMensaje("Hubo un error al generar la declaración, por favor intentalo más tarde");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();

			errores.add(error);

			presentaDecResponse.setErrores(errores);

		}
		return presentaDecResponse;


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

			calculoPredialResponse = mapper.readValue(sdhCalculoPredialService.calculoPredial(calculoPredialRequest),
					CalculoPredialResponse.class);

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

			final CustomerData customerData = customerFacade.getCurrentCustomer();

			prediaFormcaldec.setTipDoc(customerData.getDocumentType());
			prediaFormcaldec.setNumDoc(customerData.getDocumentNumber());
			prediaFormcaldec.setCompleName(customerData.getCompleteName());
			prediaFormcaldec.setNumBP(customerData.getNumBP());
			prediaFormcaldec.setCHIP(predialInfoIniURL.getCHIP());
			prediaFormcaldec.setMatrInmobiliaria(predialInfoIniURL.getMatrInmobiliaria());
			prediaFormcaldec.setAnioGravable(predialInfoIniURL.getAnioGravable());

			String tipreg = "";

			tipreg = prediaFormcaldec.getRetipRegistro();
			final String numbp = prediaFormcaldec.getNumBP();
			final String chip = prediaFormcaldec.getCHIP();
			final String matricula = prediaFormcaldec.getMatrInmobiliaria();
			final String anio = prediaFormcaldec.getAnioGravable();

			String url = "";

			if (tipreg.equals("1"))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "1";
				prediaFormcaldec.setUrl(url);
				return prediaFormcaldec;
			}
			else if (tipreg.equals("2"))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "2";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("3"))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "3";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("4"))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "4";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("5"))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "5";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("6"))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "6";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("7"))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "7";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("8"))
			{
				redirectAttributes.addFlashAttribute("predialFormurl", prediaFormcaldec);
				model.addAttribute("predialFormurl", prediaFormcaldec);
				url = "8";

				prediaFormcaldec.setUrl(url);

				return prediaFormcaldec;
			}
			else if (tipreg.equals("9"))
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


}

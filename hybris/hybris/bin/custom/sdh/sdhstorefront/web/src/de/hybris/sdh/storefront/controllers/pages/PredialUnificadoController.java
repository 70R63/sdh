/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePredialRequest;
import de.hybris.sdh.core.pojos.responses.DetallePredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetallePredialService;
import de.hybris.sdh.storefront.forms.PredialForm;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 * @author Maria Luisa
 *
 */
@Controller
public class PredialUnificadoController extends AbstractPageController
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

	@RequestMapping(value = "/contribuyentes/predialunificado_inicio", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialinicio(@ModelAttribute("predialFormIni")
	final PredialForm predialInfor, final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificadoINICIO --------------------------");		;

		System.out.println("---------------- Hola entro predial unificadoINICIO --------------------------");
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;

		final PredialForm predialFormIni = new PredialForm();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		consultaContribuyenteBPRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);
			predialFormIni.setPredial(sdhConsultaContribuyenteBPResponse.getPredial());
		} catch (final IOException e) {
			e.printStackTrace();
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("predial", predialFormIni);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/predialunificado_inicio/detalle", method = RequestMethod.GET)
	@ResponseBody
	public PredialForm vehiculosDetail(@ModelAttribute("predialInfo")
	final PredialForm predialInfo, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
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
			predialForm.setTblErrores(detallePredialResponse.getTblErrores());

			model.addAttribute("predialForm", predialForm);

		}
		catch (final IOException e)
		{

		}
		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return predialForm;
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_1", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialuno(@ModelAttribute("predialInfoIniUno")
	final PredialForm predialInfoIniUno, final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado uno --------------------------");
		final PredialForm predialFormuno = new PredialForm();
		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormuno.setTipDoc(customerData.getDocumentType());
		predialFormuno.setNumDoc(customerData.getDocumentNumber());
		predialFormuno.setCompleName(customerData.getCompleteName());

		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();

			detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			detallePredialRequest.setAnioGravable(predialInfoIniUno.getAnioGravable());
			detallePredialRequest.setCHIP(predialInfoIniUno.getCHIP());
			detallePredialRequest.setMatrInmobiliaria(predialInfoIniUno.getMatrInmobiliaria());


			//			detallePredialRequest.setNumBP("1000010203");
			//			detallePredialRequest.setAnioGravable("2019");
			//			detallePredialRequest.setCHIP("AAA0080KECZ");
			//			detallePredialRequest.setMatrInmobiliaria("050N1178178");

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);
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

		}
		catch (final IOException e)
		{

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
	public String predialdos(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado DOS --------------------------");

		final PredialForm predialFormdos = new PredialForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormdos.setTipDoc(customerData.getDocumentType());
		predialFormdos.setNumDoc(customerData.getDocumentNumber());
		predialFormdos.setCompleName(customerData.getCompleteName());
		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			/*
			 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
			 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
			 */

			detallePredialRequest.setNumBP("1000010203");
			detallePredialRequest.setAnioGravable("2019");
			detallePredialRequest.setCHIP("AAA0080KECZ");
			detallePredialRequest.setMatrInmobiliaria("050N1178178");

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePredialResponse detallePredialResponse = mapper
					.readValue(sdhDetallePredialService.detallePredial(detallePredialRequest), DetallePredialResponse.class);


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

		}
		catch (final IOException e)
		{

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
	public String predialtres(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado TRES --------------------------");
		final PredialForm predialFormtres = new PredialForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormtres.setTipDoc(customerData.getDocumentType());
		predialFormtres.setNumDoc(customerData.getDocumentNumber());
		predialFormtres.setCompleName(customerData.getCompleteName());
		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			/*
			 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
			 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
			 */

			detallePredialRequest.setNumBP("1000010203");
			detallePredialRequest.setAnioGravable("2019");
			detallePredialRequest.setCHIP("AAA0080KECZ");
			detallePredialRequest.setMatrInmobiliaria("050N1178178");

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

		}
		catch (final IOException e)
		{

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
	public String predialcuatro(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado CUATRO --------------------------");
		final PredialForm predialFormcua = new PredialForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormcua.setTipDoc(customerData.getDocumentType());
		predialFormcua.setNumDoc(customerData.getDocumentNumber());
		predialFormcua.setCompleName(customerData.getCompleteName());
		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			/*
			 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
			 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
			 */

			detallePredialRequest.setNumBP("1000010203");
			detallePredialRequest.setAnioGravable("2019");
			detallePredialRequest.setCHIP("AAA0080KECZ");
			detallePredialRequest.setMatrInmobiliaria("050N1178178");

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

		}
		catch (final IOException e)
		{

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
	public String predialcinco(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado CINCO --------------------------");
		final PredialForm predialFormcinco = new PredialForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormcinco.setTipDoc(customerData.getDocumentType());
		predialFormcinco.setNumDoc(customerData.getDocumentNumber());
		predialFormcinco.setCompleName(customerData.getCompleteName());
		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			/*
			 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
			 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
			 */

			detallePredialRequest.setNumBP("1000010203");
			detallePredialRequest.setAnioGravable("2019");
			detallePredialRequest.setCHIP("AAA0080KECZ");
			detallePredialRequest.setMatrInmobiliaria("050N1178178");

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

		}
		catch (final IOException e)
		{

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
	public String predialseis(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado SEIS --------------------------");
		final PredialForm predialFormseis = new PredialForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormseis.setTipDoc(customerData.getDocumentType());
		predialFormseis.setNumDoc(customerData.getDocumentNumber());
		predialFormseis.setCompleName(customerData.getCompleteName());
		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			/*
			 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
			 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
			 */

			detallePredialRequest.setNumBP("1000010203");
			detallePredialRequest.setAnioGravable("2019");
			detallePredialRequest.setCHIP("AAA0080KECZ");
			detallePredialRequest.setMatrInmobiliaria("050N1178178");

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

		}
		catch (final IOException e)
		{

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
	public String predialsiete(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado Siete --------------------------");

		final PredialForm predialFormsiete = new PredialForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormsiete.setTipDoc(customerData.getDocumentType());
		predialFormsiete.setNumDoc(customerData.getDocumentNumber());
		predialFormsiete.setCompleName(customerData.getCompleteName());
		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			/*
			 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
			 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
			 */

			detallePredialRequest.setNumBP("1000010203");
			detallePredialRequest.setAnioGravable("2019");
			detallePredialRequest.setCHIP("AAA0080KECZ");
			detallePredialRequest.setMatrInmobiliaria("050N1178178");

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

		}
		catch (final IOException e)
		{

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
	public String predialocho(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado OCHO --------------------------");
		final PredialForm predialFormocho = new PredialForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormocho.setTipDoc(customerData.getDocumentType());
		predialFormocho.setNumDoc(customerData.getDocumentNumber());
		predialFormocho.setCompleName(customerData.getCompleteName());
		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			/*
			 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
			 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
			 */

			detallePredialRequest.setNumBP("1000010203");
			detallePredialRequest.setAnioGravable("2019");
			detallePredialRequest.setCHIP("AAA0080KECZ");
			detallePredialRequest.setMatrInmobiliaria("050N1178178");

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

		}
		catch (final IOException e)
		{

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
	public String predialbases(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado BASES PRESUNTIVAS --------------------------");
		final PredialForm predialFormbases = new PredialForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		predialFormbases.setTipDoc(customerData.getDocumentType());
		predialFormbases.setNumDoc(customerData.getDocumentNumber());
		predialFormbases.setCompleName(customerData.getCompleteName());
		try
		{
			final DetallePredialRequest detallePredialRequest = new DetallePredialRequest();
			/*
			 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
			 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
			 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
			 */

			detallePredialRequest.setNumBP("1000010203");
			detallePredialRequest.setAnioGravable("2019");
			detallePredialRequest.setCHIP("AAA0080KECZ");
			detallePredialRequest.setMatrInmobiliaria("050N1178178");

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

		}
		catch (final IOException e)
		{

		}

		model.addAttribute("predialFormbases", predialFormbases);


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_BASES_PRESUNTIVAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_BASES_PRESUNTIVAS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_BASES_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	//	@RequestMapping(value = "/contribuyentes/predialunificado_1", method = RequestMethod.POST)
	//	@RequireHardLogIn
	//	public String predialunopost(final BindingResult bindingResult, final Model model,
	//			final RedirectAttributes redirectAttributes)
	//			throws CMSItemNotFoundException
	//	{
	//		System.out.println("------------------entro al post de predial unificado uno------------------------");
	//
	//		return REDIRECT_TO_PREDIAL_UNO_PAGE;
	//	}

	@RequestMapping(value = "/contribuyentes/predialunificado_2", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialdospost(final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de predial unificado uno------------------------");

		return REDIRECT_TO_PREDIAL_DOS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_3", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialtrespost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de predial unificado uno------------------------");

		return REDIRECT_TO_PREDIAL_TRES_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_4", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialcuatropost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de predial unificado uno------------------------");

		return REDIRECT_TO_PREDIAL_CUATRO_PAGE;
	}




}

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
	public String predialinicio(final Model model) throws CMSItemNotFoundException
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
		//	model.addAttribute("predial", sdhConsultaContribuyenteBPResponse.getPredial() );
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
		/*
		 * detallePredialRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
		 * detallePredialRequest.setAnioGravable(anioGravable); detallePredialRequest.setCHIP(chip);
		 * detallePredialRequest.setMatrInmobiliaria(matrInmobiliaria);
		 */

		detallePredialRequest.setNumBP("1000010203");
		detallePredialRequest.setAnioGravable("2019");
		detallePredialRequest.setCHIP("AAA0080KECZ");
		detallePredialRequest.setMatrInmobiliaria("050N1178178");


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

	@RequestMapping(value = "/contribuyentes/predialunificado_1", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialuno(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado uno --------------------------");
		final PredialForm predialFormuno = new PredialForm();


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
			predialFormuno.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialFormuno.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialFormuno.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialFormuno.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialFormuno.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialFormuno.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialFormuno.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialFormuno.setNumBP(detallePredialRequest.getNumBP());
			predialFormuno.setCHIP(detallePredialRequest.getCHIP());
			predialFormuno.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialFormuno.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialFormuno.setMarcas(detallePredialResponse.getMarcas());
			predialFormuno.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialFormuno.setTblErrores(detallePredialResponse.getTblErrores());



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
			predialFormdos.setDatosEconomicos(detallePredialResponse.getDatosEconomicos());
			predialFormdos.setDatosJuridicos(detallePredialResponse.getDatosJuridicos());
			predialFormdos.setFechaInactivacion(detallePredialResponse.getFechaInactivacion());
			predialFormdos.setOpcionuso(detallePredialResponse.getOpcionuso());
			predialFormdos.setIndicadorspac(detallePredialResponse.getIndicadorspac());
			predialFormdos.setIndicadorbasegravable(detallePredialResponse.getIndicadorbasegravable());
			predialFormdos.setAnioGravable(detallePredialRequest.getAnioGravable());
			predialFormdos.setNumBP(detallePredialRequest.getNumBP());
			predialFormdos.setCHIP(detallePredialRequest.getCHIP());
			predialFormdos.setMatrInmobiliaria(detallePredialRequest.getMatrInmobiliaria());
			predialFormdos.setDatosFisicos(detallePredialResponse.getDatosFisicos());
			predialFormdos.setMarcas(detallePredialResponse.getMarcas());
			predialFormdos.setEstrLiquidacionPredial(detallePredialResponse.getEstrLiquidacionPredial());
			predialFormdos.setTblErrores(detallePredialResponse.getTblErrores());
			predialFormdos.setEstrLiquidacionPrivada(detallePredialResponse.getEstrLiquidacionPrivada());


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
	public String predialtres(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado TRES --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_TRES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_TRES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_4", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialcuatro(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado CUATRO --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_CUATRO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_CUATRO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_5", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialcinco(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado CINCO --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_CINCO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_CINCO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_6", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialseis(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado SEIS --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_SEIS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_SEIS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_7", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialsiete(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado Siete --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_SIETE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_SIETE_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_8", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialocho(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado OCHO --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_OCHO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_OCHO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado/basespresuntivas", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialbases(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado BASES PRESUNTIVAS --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_BASES_PRESUNTIVAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_BASES_PRESUNTIVAS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_BASES_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/predialunificado_1", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialunopost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de predial unificado uno------------------------");

		return REDIRECT_TO_PREDIAL_UNO_PAGE;
	}

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

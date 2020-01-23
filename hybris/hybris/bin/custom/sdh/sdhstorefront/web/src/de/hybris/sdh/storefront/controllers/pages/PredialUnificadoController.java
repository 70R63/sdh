/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import javax.annotation.Resource;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;


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

	@RequestMapping(value = "/contribuyentes/predialunificado_inicio", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialinicio(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificadoINICIO --------------------------");		;

		System.out.println("---------------- Hola entro predial unificadoINICIO --------------------------");
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;

		ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		consultaContribuyenteBPRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_INICIAL_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("predial", sdhConsultaContribuyenteBPResponse.getPredial() );

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_1", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialuno(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado uno --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado_2", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialdos(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado DOS --------------------------");


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

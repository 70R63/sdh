/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
public class EscuelaVirtualController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(EscuelaVirtualController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Escuela Virtual";
	private static final String TEXT_ACCOUNT_FOROS_PROFILE = "escuela.menu.foros";
	private static final String TEXT_ACCOUNT_ENCUESTAS_PROFILE = "escuela.menu.encuesta";
	private static final String TEXT_ACCOUNT_PORTAL_PROFILE = "escuela.menu.ninos";
	private static final String TEXT_ACCOUNT_ACTIVIDADES_PROFILE = "escuela.menu.actividades";

	// CMS Pages
	private static final String ESCUELA_CMS_PAGE = "escuelaVirtualPage";
	private static final String ESCUELA_FOROS_CMS_PAGE = "escuelaVirtualForosPage";
	private static final String ESCUELA_ENCUESTAS_CMS_PAGE = "escuelaVirtualEncuestasPage";
	private static final String ESCUELA_PORTAL_CMS_PAGE = "escuelaVirtualPortalPage";
	private static final String ESCUELA_ACTIVIDADES_CMS_PAGE = "escuelaVirtualActiPage";

	private static final String REDIRECT_TO_ESCUELA_PAGE = REDIRECT_PREFIX + "/escuelavirtual";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@RequestMapping(value = "/escuelavirtual", method = RequestMethod.GET)
	public String escuelainicial(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET escuela virtual --------------------------");



		storeCmsPageInModel(model, getContentPageForLabelOrId(ESCUELA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESCUELA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/escuelavirtual/foros", method = RequestMethod.GET)
	public String escuelaforos(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET escuela virtual --------------------------");



		storeCmsPageInModel(model, getContentPageForLabelOrId(ESCUELA_FOROS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESCUELA_FOROS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_FOROS_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/escuelavirtual/encuestasdeservicio", method = RequestMethod.GET)
	public String escuelaEncuestas(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET escuela virtual --------------------------");



		storeCmsPageInModel(model, getContentPageForLabelOrId(ESCUELA_ENCUESTAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESCUELA_ENCUESTAS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_ENCUESTAS_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/escuelavirtual/portalninos", method = RequestMethod.GET)
	public String escuelaPortal(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET escuela virtual --------------------------");



		storeCmsPageInModel(model, getContentPageForLabelOrId(ESCUELA_PORTAL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESCUELA_PORTAL_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PORTAL_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/escuelavirtual/actividades", method = RequestMethod.GET)
	public String escuelaActividades(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET escuela virtual --------------------------");



		storeCmsPageInModel(model, getContentPageForLabelOrId(ESCUELA_ACTIVIDADES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESCUELA_ACTIVIDADES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_ACTIVIDADES_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/escuelavirtual", method = RequestMethod.POST)
	public String escuelapost(final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de escuela virtual-----------------------");

		return REDIRECT_TO_ESCUELA_PAGE;
	}

}

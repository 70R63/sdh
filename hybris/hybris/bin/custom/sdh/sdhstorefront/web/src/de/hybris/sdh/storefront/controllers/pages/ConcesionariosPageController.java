/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.dao.SdhReferenceStatusDao;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * @author Maria Luisa
 *
 */
@Controller
public class ConcesionariosPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(ConcesionariosPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.concesionarios";
	private static final String BREADCRUMB_CONCESIONARIOS = "breadcrumb.concesionarios";


	// CMS Pages
	private static final String CONCESIONARIOS_CMS_PAGE = "concesionariosPage";

	private static final String REDIRECT_TO_MI_BUZON_PAGE = REDIRECT_PREFIX + "/contribuyentes/mibuzon_tributario";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

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

	@Resource(name = "sdhReferenceStatusDao")
	SdhReferenceStatusDao sdhReferenceStatusDao;

	@ModelAttribute("referenceStatus")
	public List<de.hybris.sdh.core.form.SelectAtomValue> getReferenceStatus()
	{
		return sdhReferenceStatusDao.getAllReferenceStatus();
	}


	@RequestMapping(value =
	{ "/concesionarios" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String buzoninicizl(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("----------------Initial Controller Concesionarios --------------------------");

		storeCmsPageInModel(model, getContentPageForLabelOrId(CONCESIONARIOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONCESIONARIOS_CMS_PAGE));


		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMB_CONCESIONARIOS));


		return getViewForPage(model);
	}
}

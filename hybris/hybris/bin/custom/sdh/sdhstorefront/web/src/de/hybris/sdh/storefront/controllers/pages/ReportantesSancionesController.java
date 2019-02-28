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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Maria Luisa
 *
 */
@Controller
@RequestMapping("/reportantes/sanciones")
public class ReportantesSancionesController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	// CMS Pages
	private static final String REPORTANTES_INFORMACION_SANCIONES_CMS_PAGE = "reportantesSancionesPage";

	private static final String REDIRECT_TO_MI_BUZON_PAGE = REDIRECT_PREFIX + "/reportantes/sanciones";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value = "/reportantes/sanciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String reportantessancionesinicial(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET REPORTANTES HISTORICO--------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(REPORTANTES_INFORMACION_SANCIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REPORTANTES_INFORMACION_SANCIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}



}

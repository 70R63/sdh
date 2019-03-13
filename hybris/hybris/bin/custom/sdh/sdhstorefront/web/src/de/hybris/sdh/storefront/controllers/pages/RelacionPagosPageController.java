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
/* @RequestMapping("/contribuyentes/certipagos") */
public class RelacionPagosPageController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.relapagos";

	// CMS Pages
	private static final String RELACION_PAGOS_CMS_PAGE = "relacionPagosPage";

	private static final String REDIRECT_TO_RELACION_PAGOS_PAGE = REDIRECT_PREFIX + "/contribuyentes/consultas/relacionpagos";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value = "/contribuyentes/consultas/relacionpagos", method = RequestMethod.GET)
	@RequireHardLogIn
	public String relapag(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Relaciones de Pago--------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(RELACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RELACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}



}

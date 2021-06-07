/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.services.SDHAnioTaxCatalogService;
import de.hybris.sdh.facades.anio.data.SDHAnioGravableData;
import de.hybris.sdh.facades.impl.DefaultSDHAnioTaxFacade;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	private static final String BREADCRUMBS_VALUE_RETE = "text.account.profile.arRelapagos";

	// CMS Pages
	private static final String RELACION_PAGOS_CMS_PAGE = "relacionPagosPage";

	private static final String REDIRECT_TO_RELACION_PAGOS_PAGE = REDIRECT_PREFIX + "/contribuyentes/consultas/relacionpagos";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhSDHAnioTaxCatalogService")
	private SDHAnioTaxCatalogService sdhSDHAnioTaxCatalogService;

	@Resource(name = "defaultSDHAnioTaxFacade")
	private DefaultSDHAnioTaxFacade defaultSDHAnioTaxFacade;


	@RequestMapping(value =
	{ "/contribuyentes/consultas/relacionpagos", "/agenteRetenedor/consultas/relacionpagos" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String relapag(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Relaciones de Pago--------------------------");
		final StringBuffer requestURL = request.getRequestURL();
		final String url2 = String.valueOf(requestURL);




		final List<SDHAnioGravableData> listAnioData = defaultSDHAnioTaxFacade.getAnioGravable();

		storeCmsPageInModel(model, getContentPageForLabelOrId(RELACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RELACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		if (url2.contains("contribuyentes"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}
		else if (url2.contains("agenteRetenedor"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_RETE));
			model.addAttribute("Retenedor", "Retenedor");
		}


		return getViewForPage(model);
	}



}

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
public class PredialUnificadoController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	// CMS Pages
	private static final String PREDIAL_UNIFICADO_CMS_PAGE = "predialUnificadoPage";

	private static final String REDIRECT_TO_PREDIAL_UNIFICADO_PAGE = REDIRECT_PREFIX + "/contribuyentes/predialunificado/detalle";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value = "/contribuyentes/predialunificado/detalle", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialunificadodetalle(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro predial unificado detalle --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado/detalle", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialunificadodetallepost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de predial unificado------------------------");

		return REDIRECT_TO_PREDIAL_UNIFICADO_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/predialunificado/declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialunificadodeclaracion(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro declaracion sobrevehiculos --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predialunificado/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialunificadopost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de declaracion sobrevehiculos------------------------");

		return REDIRECT_TO_PREDIAL_UNIFICADO_PAGE;
	}


}

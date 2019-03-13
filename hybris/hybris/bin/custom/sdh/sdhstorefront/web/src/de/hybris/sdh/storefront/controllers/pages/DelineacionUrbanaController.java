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
 * @author Maria Luisa/Federico Flores Dimas
 *
 */
@Controller
public class DelineacionUrbanaController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.delineacion";

	// CMS Pages
	private static final String DELINEACION_URBANA_CMS_PAGE = "delineacionUrbanaPage";
	private static final String DELINEACION_URBANA_DECLARACIONES_CMS_PAGE = "delineacionUrbanaDeclaracionesPage";
	private static final String REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE = REDIRECT_PREFIX + "/contribuyentes/delineacion-urbana";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;


	@RequestMapping(value = "/contribuyentes/delineacion-urbana", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbana(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Delineacion urbana GET --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}




	@RequestMapping(value = "/contribuyentes/delineacionurbana/detalle", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbanadetalle(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a delineacion detalle --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/detalle", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updateEmail(final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post------------------------");

		return REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbanadeclaracion(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a updateExampleForm --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String delineacionurbanadeclaracionpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post------------------------");

		return REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE;
	}


}

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
public class SobreVehiculosController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.vehiculos";

	// CMS Pages
	private static final String SOBRE_VEHICULOS_CMS_PAGE = "sobreVehiculosAutomotoresPage";

	private static final String REDIRECT_TO_SOBRE_VEHICULOS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/sobrevehiculosautomotores/detalle";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/detalle", method = RequestMethod.GET)
	@RequireHardLogIn
	public String sobrevehiculosdetalle(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro Sobre Vehiculos detalle --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/detalle", method = RequestMethod.POST)
	@RequireHardLogIn
	public String sobrevehiculosdetallepost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de sobre vehiculos------------------------");

		return REDIRECT_TO_SOBRE_VEHICULOS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String sobrevehiculosdeclaracion(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro declaracion sobrevehiculos --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String sobrevehiculospost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de declaracion sobrevehiculos------------------------");

		return REDIRECT_TO_SOBRE_VEHICULOS_PAGE;
	}


}

/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.sdh.storefront.forms.DeclaPublicidadController;

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
@RequestMapping("/contribuyentes/publicidadexterior/declaracion")
public class DeclaraPublicidadController extends AbstractPageController
{

	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	//CMS PAGES
	private static final String DECLARACION_PUBLICIDAD_CMS_PAGE = "DeclaraPublicidadPage";
	private static final String REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/publicidadexterior/declaracion";

	@RequestMapping(value = "/contribuyentes/publicidadexterior/declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String declaraPublicidadpage(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final DeclaPublicidadController dataForm = new DeclaPublicidadController();
		model.addAttribute("dataForm", dataForm);
		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		/* updatePageTitle(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE)); */

		return getViewForPage(model);

	}



	@RequestMapping(value = "/contribuyentes/publicidadexterior/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updateEmail(final DeclaPublicidadController dataForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a Publicidad POST --------------------------");

		return REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE;
	}
}

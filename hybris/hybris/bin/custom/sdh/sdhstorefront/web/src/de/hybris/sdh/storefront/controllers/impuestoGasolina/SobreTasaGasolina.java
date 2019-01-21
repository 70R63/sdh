
/**
 *
 */

package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author fede
 *
 */

@Controller
//@RequestMapping("/sobretasa-gasolina")
public class SobreTasaGasolina extends AbstractSearchPageController
{
	//Example Controller
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	// CMS Pages
	private static final String DECLARACIONES_GASOLINA_CMS_PAGE = "sobretasa-gasolina";

	private static final String REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE = REDIRECT_PREFIX + "/contribuyentes/sobretasa-gasolina";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET(final Model model, @ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm

	) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Menu sobretasa gasolina GET --------------------------");
		final SobreTasaGasolinaCatalogos dataFormCatalogos = new SobreTasaGasolinaService().prepararCatalogos();
		final List<SobreTasaGasolinaTabla> dataFormTabla = new SobreTasaGasolinaService().prepararTablaDeclaracion();

		model.addAttribute("dataFormCatalogos", dataFormCatalogos);
		model.addAttribute("listaDocumentos", dataFormTabla);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST(final DeclaracionGasolinaForm dataForm1, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Menu sobretasa gasolina POST --------------------------");
		final SobreTasaGasolinaCatalogos dataFormCatalogos = new SobreTasaGasolinaService().prepararCatalogos();
		final List<SobreTasaGasolinaTabla> dataFormTabla = new SobreTasaGasolinaService().prepararTablaDeclaracion();

		//obtener el registro marcado
		//obtener la informacion del registro marcado
		final String bpMarcado = "537";
		//establecer la informacion del registro marcado		
		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaService().prepararInfoBP(bpMarcado, "Info");
		System.out.println(dataForm);

		model.addAttribute("dataFormCatalogos", dataFormCatalogos);
		model.addAttribute("dataForm", dataForm);
		model.addAttribute("listaDocumentos", dataFormTabla);


		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

}


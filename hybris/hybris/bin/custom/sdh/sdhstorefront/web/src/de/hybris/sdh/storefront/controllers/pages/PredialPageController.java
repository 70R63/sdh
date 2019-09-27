/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

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
public class PredialPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Predial";

	// CMS Pages
	private static final String PREDIAL_CMS_PAGE = "predialOnePage";

	private static final String REDIRECT_TO_PREDIAL_PAGE = REDIRECT_PREFIX + "/contribuyentes/predial/pageone";



	@RequestMapping(value = "/contribuyentes/predial/pageone", method = RequestMethod.GET)
	@RequireHardLogIn
	public String predialinicial(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET de predial onepage --------------------------");




		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_CMS_PAGE));
		//		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/predial/pageone", method = RequestMethod.POST)
	@RequireHardLogIn
	public String predialpost(final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de PREDIAL ONE PAGE------------------------");

		return REDIRECT_TO_PREDIAL_PAGE;
	}

}

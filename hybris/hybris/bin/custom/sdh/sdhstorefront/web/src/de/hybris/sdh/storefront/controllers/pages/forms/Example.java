/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages.forms;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/example")
public class Example extends AbstractSearchPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	// CMS Pages
	private static final String YFORM_CMS_PAGE = "update-example-form";


	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value = "/update-example-form", method = RequestMethod.GET)
	@RequireHardLogIn
	public String updateExampleForm(final Model model) throws CMSItemNotFoundException
	{
		//System.out.println("---------------- Hola entro a updateExampleForm --------------------------");

		//model.addAttribute("dataPage", "hola como estas esta es una prueba");

		storeCmsPageInModel(model, getContentPageForLabelOrId(YFORM_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(YFORM_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/update-example-form", method = RequestMethod.POST)
	@RequireHardLogIn
	public void postUpdateExampleForm()
	{
		System.out.print("hola como estas");
	}

}

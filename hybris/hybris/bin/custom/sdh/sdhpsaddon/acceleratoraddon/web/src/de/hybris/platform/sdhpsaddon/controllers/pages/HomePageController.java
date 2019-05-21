/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.sdhpsaddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.facades.SDHCustomerFacade;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */

@RequestMapping("/")
public class HomePageController extends AbstractPageController
{
	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "sdhCustomerAccountService")
	private SDHCustomerAccountService sdhCustomerAccountService;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String home(@RequestParam(value = "logout", defaultValue = "false") final boolean logout, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		if (logout)
		{
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER, "account.confirmation.signout.title");
			return REDIRECT_PREFIX + ROOT;
		}

		sdhCustomerAccountService.cleanSessionAutorities();

		model.addAttribute("hideMenuBar", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(null));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(null));
		updatePageTitle(model, getContentPageForLabelOrId(null));

		return getViewForPage(model);
	}

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveContentPageTitle(cmsPage.getTitle()));
	}


	@RequestMapping(method = RequestMethod.GET, value = "/setRole")
	@RequireHardLogIn
	public String setRole(@RequestParam(value = "role", required = true) final String role, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		sdhCustomerAccountService.cleanSessionAutorities();

		final boolean isValidRoleForCustomer = sdhCustomerFacade.isValidRoleForCurrentCustomer(role);

		if (!isValidRoleForCustomer)
		{
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER, "account.no.valid.role");
			return REDIRECT_PREFIX + ROOT;
		}

		sdhCustomerAccountService.setAutorityOnSession(role);

		if ("sdh_01".equals(role))
		{
			return REDIRECT_PREFIX + "/contribuyentes";
		}
		else if ("sdh_02".equals(role))
		{
			//			return REDIRECT_PREFIX + "/contribueyentes";
		}
		else if ("sdh_03".equals(role))
		{
			return REDIRECT_PREFIX + "/terceros/reportar";
		}
		else if ("sdh_04".equals(role))
		{
			return REDIRECT_PREFIX + "/retenedores/registroretenciones";
		}
		else if ("sdh_05".equals(role))
		{
			return REDIRECT_PREFIX + "/reportantes";
		}

		model.addAttribute("hideMenuBar", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(null));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(null));
		updatePageTitle(model, getContentPageForLabelOrId(null));

		return getViewForPage(model);
	}


}

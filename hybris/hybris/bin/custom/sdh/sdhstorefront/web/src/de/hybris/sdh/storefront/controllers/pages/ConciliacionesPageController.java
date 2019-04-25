/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.facades.SDHConciliacionesFacade;
import de.hybris.sdh.storefront.controllers.pages.forms.ImportConciliacionForm;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/conciliaciones")
public class ConciliacionesPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(ConciliacionesPageController.class);

	private static final String CONCILIACIONES_CMS_PAGE = "ConciliacionesPage";

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhConciliacionesFacade")
	private SDHConciliacionesFacade sdhConciliacionesFacade;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String showView(final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		storeCmsPageInModel(model, getContentPageForLabelOrId(CONCILIACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONCILIACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(CONCILIACIONES_CMS_PAGE));

		return getViewForPage(model);
	}


	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@RequireHardLogIn
	public String upload(@ModelAttribute("importConciliacionForm")
	final ImportConciliacionForm importConciliacionForm, final RedirectAttributes redirectAttributes) throws IOException
	{
		redirectAttributes.addFlashAttribute("importConciliacionForm", importConciliacionForm);
		GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
				"conciliaciones.upload.messages.success", new Object[]
				{ importConciliacionForm.getConciliacionFile().getOriginalFilename() });

		sdhConciliacionesFacade.processConciliacionesFile(importConciliacionForm.getConciliacionFile());


		return "redirect:/conciliaciones";
	}


	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}
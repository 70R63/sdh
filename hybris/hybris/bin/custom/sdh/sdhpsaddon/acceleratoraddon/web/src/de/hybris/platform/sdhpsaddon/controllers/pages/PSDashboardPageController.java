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
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Extended Controller for functionality related to Dashboard
 */
//@Controller
//@RequestMapping("/my-account")
public class PSDashboardPageController extends AbstractSearchPageController
{
	private static final String DASHBOARD_CMS_PAGE = "dashboardPage";

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String displayDashboard(final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(DASHBOARD_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DASHBOARD_CMS_PAGE));
		return getViewForPage(model);
	}
}

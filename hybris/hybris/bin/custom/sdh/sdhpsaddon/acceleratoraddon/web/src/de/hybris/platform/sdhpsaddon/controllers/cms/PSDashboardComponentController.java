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
package de.hybris.platform.sdhpsaddon.controllers.cms;

import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSDashboardComponentModel;
import de.hybris.platform.servicelayer.session.SessionService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("PSDashboardComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSDashboardComponent)
public class PSDashboardComponentController<C extends PSDashboardComponentModel>
		extends SubstitutingCMSAddOnComponentController<C>
{
	private static final String SESSION_USER_IN_CONTEXT = "userInContext";

	@Resource(name = "sessionService")
	private SessionService sessionService;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final C component)
	{
		sessionService.removeAttribute(SESSION_USER_IN_CONTEXT);
		model.addAttribute("dashlets", component.getDashlets());
	}
}
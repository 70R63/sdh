/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
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
import de.hybris.platform.publicsectorservices.model.PSFooterComponentModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The class of PSFooterComponentController.
 */
@Controller("PSFooterComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSFooterComponent)
public class PSFooterComponentController<C extends PSFooterComponentModel> extends SubstitutingCMSAddOnComponentController<C>
{

	/**
	 * Fills the model with required attributes for displaying service featured links content
	 *
	 * @param request
	 * @param model
	 * @param component
	 */

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final C component)
	{
		model.addAttribute("footerComponent", component);
	}
}

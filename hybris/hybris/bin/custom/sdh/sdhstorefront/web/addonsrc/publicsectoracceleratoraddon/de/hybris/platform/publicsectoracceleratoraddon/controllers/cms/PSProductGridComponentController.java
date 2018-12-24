/*
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 *
 */
package de.hybris.platform.publicsectoracceleratoraddon.controllers.cms;

import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSProductGridComponentModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This is PSProductGridComponentController for the cms component PSProductGridComponent
 */
@Controller("PSProductGridComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSProductGridComponent)
public class PSProductGridComponentController extends SubstitutingCMSAddOnComponentController<PSProductGridComponentModel>
{

	/**
	 * Fills the model with required attributes for displaying product as grid
	 *
	 * @param request
	 * @param model
	 * @param component
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSProductGridComponentModel component)
	{
		model.addAttribute("actions", component.getActions());
	}
}

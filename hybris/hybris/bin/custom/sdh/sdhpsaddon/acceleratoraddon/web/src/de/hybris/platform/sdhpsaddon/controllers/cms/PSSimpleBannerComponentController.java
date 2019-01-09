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

import de.hybris.platform.publicsectorservices.model.PSSimpleBannerComponentModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The class of PSSimpleBannerComponentController.
 */
@Controller("PSSimpleBannerComponentController")
@RequestMapping(value = "/view/" + PSSimpleBannerComponentModel._TYPECODE + "Controller")
public class PSSimpleBannerComponentController<C extends PSSimpleBannerComponentModel>
		extends SubstitutingCMSAddOnComponentController<C>
{

	/**
	 * Fills the model with required attributes for displaying add to cart action
	 *
	 * @param request
	 * @param model
	 * @param component
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final C component)
	{

		model.addAttribute("media", component.getMedia());
		model.addAttribute("urlLink", component.getUrlLink());
		model.addAttribute("title", component.getTitle());
	}
}

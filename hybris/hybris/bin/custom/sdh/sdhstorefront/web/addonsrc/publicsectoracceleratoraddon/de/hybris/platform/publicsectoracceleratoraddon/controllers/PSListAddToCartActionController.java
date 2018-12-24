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
package de.hybris.platform.publicsectoracceleratoraddon.controllers;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.publicsectoracceleratoraddon.model.PSListAddToCartActionModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This is PSListAddToCartActionController for the Action PSListAddToCartAction
 */
@Controller("PSListAddToCartActionController")
@RequestMapping(value = "/view/" + PSListAddToCartActionModel._TYPECODE + "Controller")
public class PSListAddToCartActionController extends AbstractCMSAddOnComponentController<PSListAddToCartActionModel>
{

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSListAddToCartActionModel component)
	{
		model.addAttribute("url", component.getUrl());

	}

}

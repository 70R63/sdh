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

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Controller for MyCart functionality.
 */
//@Controller
//@RequestMapping(value = "/my-cart")
public class MyCartPageController extends AbstractPageController
{
	private static final String FORWARD_LOGIN_URL = FORWARD_PREFIX + "/login";
	private static final String REDIRECT_CART_URL = REDIRECT_PREFIX + "/cart";

	@RequestMapping(method = RequestMethod.GET)
	public String getLoginCart()
	{
		return this.getUserFacade().isAnonymousUser() ? FORWARD_LOGIN_URL : REDIRECT_CART_URL;
	}
}

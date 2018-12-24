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
package de.hybris.platform.publicsectoracceleratoraddon.security;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


/**
 * A strategy for clearing unwanted saved data from the cart for guest checkout in public sector accelerator.
 *
 */
public interface PSGuestCheckoutCartCleanStrategy
{

	/**
	 * Checks whether the request's page is checkout URL.
	 *
	 * @param request
	 *
	 * @return boolean
	 */
	boolean checkWhetherURLContainsCheckoutPattern(final HttpServletRequest request);

	/**
	 * Removes the delivery address, delivery mode, payment info from the session cart, if the guest user moves away from
	 * checkout pages.
	 *
	 * @param request
	 */
	void cleanGuestCart(final HttpServletRequest request);

	/**
	 * Returns checkout url pattern
	 *
	 * @return Pattern
	 */
	Pattern getCheckoutURLPattern();
}

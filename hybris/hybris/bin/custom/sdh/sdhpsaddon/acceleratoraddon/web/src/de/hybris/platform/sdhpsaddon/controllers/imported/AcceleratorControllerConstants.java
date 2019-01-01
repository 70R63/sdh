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
package de.hybris.platform.sdhpsaddon.controllers.imported;

/**
 * AcceleratorControllerConstants
 */
public interface AcceleratorControllerConstants
{

	final String ADDON_PREFIX = "addon:/sdhpsaddon/";

	/**
	 * Class with view name constants
	 */
	interface Views
	{
		interface Cms // NOSONAR
		{
			String ComponentPrefix = "cms/"; // NOSONAR
		}

		interface Pages // NOSONAR
		{

			interface Checkout // NOSONAR
			{
				String CheckoutRegisterPage = "pages/checkout/checkoutRegisterPage"; // NOSONAR
				String CheckoutConfirmationPage = ADDON_PREFIX + "pages/checkout/checkoutConfirmationPage"; // NOSONAR
				String CheckoutLoginPage = ADDON_PREFIX + "pages/checkout/checkoutLoginPage"; // NOSONAR
			}

		}

	}

}

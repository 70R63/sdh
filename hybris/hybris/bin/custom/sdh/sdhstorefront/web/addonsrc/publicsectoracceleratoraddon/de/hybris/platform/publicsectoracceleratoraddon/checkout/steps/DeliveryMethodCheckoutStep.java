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
package de.hybris.platform.publicsectoracceleratoraddon.checkout.steps;

/**
 * This class will check if that step has to be visible or not for the service . It checks if the delivery method is
 * needed or not.
 *
 */
public class DeliveryMethodCheckoutStep extends CheckoutStep
{

	@Override
	public boolean isEnabled()
	{
		return getPsCheckoutFacade().isServiceRequestApplicableForDelivery(getCartService().getSessionCart());
	}
}

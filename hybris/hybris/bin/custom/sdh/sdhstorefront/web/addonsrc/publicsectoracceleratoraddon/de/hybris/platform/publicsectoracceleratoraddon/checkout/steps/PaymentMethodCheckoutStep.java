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


import de.hybris.platform.publicsectorfacades.order.PSCheckoutFacade;

import org.springframework.beans.factory.annotation.Required;


/**
 * This class will check if that step has to be visible or not for the service . It checks if the payment info needed or
 * not.
 *
 */
public class PaymentMethodCheckoutStep extends CheckoutStep
{

	private PSCheckoutFacade psCheckoutFacade;

	@Override
	public boolean isEnabled()
	{
		return getPsCheckoutFacade().isPaymentNeeded();
	}

	protected PSCheckoutFacade getPsCheckoutFacade()
	{
		return psCheckoutFacade;
	}

	@Required
	public void setPsCheckoutFacade(final PSCheckoutFacade psCheckoutFacade)
	{
		this.psCheckoutFacade = psCheckoutFacade;
	}
}

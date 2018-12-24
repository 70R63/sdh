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


import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.publicsectorfacades.product.PSProductFacade;
import de.hybris.platform.publicsectorfacades.strategies.PSYFormsStrategy;

import org.springframework.beans.factory.annotation.Required;


/**
 * This class will check if the summary step has to be visible or not for the service.
 *
 */
public class SummaryCheckoutStep extends CheckoutStep
{

	private PSYFormsStrategy psYFormsStrategy;
	private CheckoutFacade checkoutFacade;
	private String progressBarIdWithConsent;
	private PSProductFacade psProductFacade;

	@Override
	public boolean isEnabled()
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		final OrderEntryData orderEntry = getPsYFormsStrategy().getYFormOrderEntry(cartData);
		if (orderEntry != null)
		{
			final ProductData product = orderEntry.getProduct();

			if (getPsProductFacade().isUnidentifiedUserInService(product.getCode()))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public String getProgressBarId()
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		final OrderEntryData orderEntry = getPsYFormsStrategy().getYFormOrderEntry(cartData);
		if (orderEntry != null)
		{
			final ProductData product = orderEntry.getProduct();
			if (!product.getConsentDeclarations().isEmpty())
			{
				return progressBarIdWithConsent;
			}
		}
		return super.getProgressBarId();
	}

	protected PSYFormsStrategy getPsYFormsStrategy()
	{
		return psYFormsStrategy;
	}

	@Required
	public void setPsYFormsStrategy(final PSYFormsStrategy psYFormsStrategy)
	{
		this.psYFormsStrategy = psYFormsStrategy;
	}

	protected CheckoutFacade getCheckoutFacade()
	{
		return checkoutFacade;
	}

	@Required
	public void setCheckoutFacade(final CheckoutFacade checkoutFacade)
	{
		this.checkoutFacade = checkoutFacade;
	}

	protected String getProgressBarIdWithConsent()
	{
		return progressBarIdWithConsent;
	}

	@Required
	public void setProgressBarIdWithConsent(final String progressBarIdWithConsent)
	{
		this.progressBarIdWithConsent = progressBarIdWithConsent;
	}

	protected PSProductFacade getPsProductFacade()
	{
		return psProductFacade;
	}

	@Required
	public void setPsProductFacade(final PSProductFacade psProductFacade)
	{
		this.psProductFacade = psProductFacade;
	}
}

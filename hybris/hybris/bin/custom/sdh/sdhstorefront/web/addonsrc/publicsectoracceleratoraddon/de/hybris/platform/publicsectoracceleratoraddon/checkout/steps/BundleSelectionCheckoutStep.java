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

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.publicsectorfacades.bundle.selection.BundleSelectionFacade;
import de.hybris.platform.publicsectorfacades.product.PSProductFacade;

import org.springframework.beans.factory.annotation.Required;


/**
 * This class will check if that step has to be visible or not for the service . It checks if the bundle selection page
 * is needed or not.
 *
 */
public class BundleSelectionCheckoutStep extends CheckoutStep
{
	private BundleSelectionFacade bundleSelectionFacade;
	private PSProductFacade psProductFacade;

	@Override
	public boolean isEnabled()
	{
		final ProductData productData = getPsProductFacade().getServiceProductFromSessionCart();
		if (productData != null)
		{
			return getBundleSelectionFacade().hasBundleAddons(productData.getCode()).booleanValue();
		}
		return false;
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

	protected BundleSelectionFacade getBundleSelectionFacade()
	{
		return bundleSelectionFacade;
	}

	@Required
	public void setBundleSelectionFacade(final BundleSelectionFacade bundleSelectionFacade)
	{
		this.bundleSelectionFacade = bundleSelectionFacade;
	}

}

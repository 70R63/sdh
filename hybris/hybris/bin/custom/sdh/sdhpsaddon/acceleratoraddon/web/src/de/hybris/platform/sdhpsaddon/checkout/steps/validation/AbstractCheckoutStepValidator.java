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
package de.hybris.platform.sdhpsaddon.checkout.steps.validation;

import de.hybris.platform.acceleratorfacades.flow.CheckoutFlowFacade;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.order.CartService;
import de.hybris.platform.publicsectorfacades.order.PSCheckoutFacade;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Extending AbstractCheckoutStepValidator to add a check on the steps required for the checkout flow.
 */
public abstract class AbstractCheckoutStepValidator implements CheckoutStepValidator
{
	private CheckoutFacade checkoutFacade;
	private CheckoutFlowFacade checkoutFlowFacade;
	private PSCheckoutFacade psCheckoutFacade;
	private CartService cartService;

	@Override
	public abstract ValidationResults validateOnEnter(final RedirectAttributes redirectAttributes);

	@Override
	public ValidationResults validateOnExit()
	{
		return ValidationResults.SUCCESS;
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

	protected CheckoutFlowFacade getCheckoutFlowFacade()
	{
		return checkoutFlowFacade;
	}

	@Required
	public void setCheckoutFlowFacade(final CheckoutFlowFacade checkoutFlowFacade)
	{
		this.checkoutFlowFacade = checkoutFlowFacade;
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

	protected CartService getCartService()
	{
		return cartService;
	}

	@Required
	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}
}

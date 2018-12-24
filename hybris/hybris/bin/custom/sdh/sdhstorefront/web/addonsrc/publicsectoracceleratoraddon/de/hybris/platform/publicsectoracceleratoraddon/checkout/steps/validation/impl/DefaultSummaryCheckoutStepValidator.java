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
package de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.validation.impl;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.validation.AbstractCheckoutStepValidator;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.validation.ValidationResults;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public class DefaultSummaryCheckoutStepValidator extends AbstractCheckoutStepValidator
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultPaymentCheckoutStepValidator.class);

	@Override
	public ValidationResults validateOnEnter(final RedirectAttributes redirectAttributes)
	{
		if (!getCheckoutFlowFacade().hasValidCart())
		{
			LOG.info("Missing, empty or unsupported cart");
			return ValidationResults.REDIRECT_TO_HOME;
		}

		if (getPsCheckoutFacade().isServiceRequestApplicableForDelivery(getCartService().getSessionCart()))
		{
			if (getCheckoutFlowFacade().hasNoDeliveryAddress())
			{
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.INFO_MESSAGES_HOLDER,
						"checkout.multi.deliveryAddress.notprovided");
				return ValidationResults.REDIRECT_TO_DELIVERY_ADDRESS;
			}

			if (getCheckoutFlowFacade().hasNoDeliveryMode())
			{
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.INFO_MESSAGES_HOLDER,
						"checkout.multi.deliveryMethod.notprovided");
				return ValidationResults.REDIRECT_TO_DELIVERY_METHOD;
			}
		}

		if (getPsCheckoutFacade().isPaymentNeeded() && getCheckoutFlowFacade().hasNoPaymentInfo())
		{
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.INFO_MESSAGES_HOLDER,
					"checkout.multi.paymentDetails.notprovided");
			return ValidationResults.REDIRECT_TO_PAYMENT_METHOD;
		}
		return ValidationResults.SUCCESS;
	}
}
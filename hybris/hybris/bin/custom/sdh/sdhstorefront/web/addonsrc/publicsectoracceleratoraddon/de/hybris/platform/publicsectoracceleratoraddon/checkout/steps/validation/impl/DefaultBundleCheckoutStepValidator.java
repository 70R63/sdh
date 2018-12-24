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

import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.validation.AbstractCheckoutStepValidator;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.validation.ValidationResults;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * This is the Validator class for the bundle checkout step and extends {@link AbstractCheckoutStepValidator}
 */
public class DefaultBundleCheckoutStepValidator extends AbstractCheckoutStepValidator
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultBundleCheckoutStepValidator.class.getName());

	@Override
	public ValidationResults validateOnEnter(final RedirectAttributes redirectAttributes)
	{
		if (!getCheckoutFlowFacade().hasValidCart())
		{
			LOG.warn("Missing, empty or unsupported cart");
			return ValidationResults.REDIRECT_TO_HOME;
		}
		return ValidationResults.SUCCESS;
	}
}

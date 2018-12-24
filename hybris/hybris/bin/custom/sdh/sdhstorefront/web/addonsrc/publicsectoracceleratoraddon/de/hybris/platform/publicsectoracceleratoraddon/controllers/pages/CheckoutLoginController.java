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
package de.hybris.platform.publicsectoracceleratoraddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.imported.AcceleratorCheckoutLoginController;
import de.hybris.platform.publicsectorfacades.customer.PSCustomerFacade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class CheckoutLoginController extends AcceleratorCheckoutLoginController
{
	private static final Logger LOG = LoggerFactory.getLogger(CheckoutLoginController.class);

	@Resource(name = "psCustomerFacade")
	private PSCustomerFacade psCustomerFacade;

	@RequestMapping(value = "/unidentified", method = RequestMethod.POST)
	public String doUnidentifiedCheckout(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws CMSItemNotFoundException
	{
		return processUnidentifiedCheckoutUserRequest(model, request, response);
	}

	/**
	 * Unidentified checkout process.
	 *
	 * Creates a new unidentified customer and updates the session cart with this user.
	 *
	 * @throws de.hybris.platform.cms2.exceptions.CMSItemNotFoundException
	 */
	protected String processUnidentifiedCheckoutUserRequest(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws CMSItemNotFoundException
	{
		try
		{
			getPsCustomerFacade().createUnidentifiedUserForAnonymousCheckout(
					getMessageSource().getMessage("text.unidentified.customer", null, getI18nService().getCurrentLocale()));
			getGuidCookieStrategy().setCookie(request, response);
			getSessionService().setAttribute(WebConstants.ANONYMOUS_CHECKOUT, Boolean.TRUE);
		}
		catch (final DuplicateUidException e)
		{
			LOG.warn("unidentified user registration failed: " + e);
			GlobalMessages.addErrorMessage(model, "form.global.error");
			return handleRegistrationError(model);
		}

		return REDIRECT_PREFIX + getSuccessRedirect(request, response);
	}

	protected PSCustomerFacade getPsCustomerFacade()
	{
		return psCustomerFacade;
	}
}

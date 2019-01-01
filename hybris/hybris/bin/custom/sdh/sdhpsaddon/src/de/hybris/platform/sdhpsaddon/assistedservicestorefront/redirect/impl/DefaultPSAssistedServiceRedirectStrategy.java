/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 *
 */
package de.hybris.platform.sdhpsaddon.assistedservicestorefront.redirect.impl;

import de.hybris.platform.assistedservicestorefront.redirect.impl.DefaultAssistedServiceRedirectStrategy;
import de.hybris.platform.sdhpsaddon.constants.PublicsectoracceleratoraddonConstants;
import de.hybris.platform.util.Config;

import org.apache.commons.lang3.StringUtils;


/**
 * Override Implementation of {@link DefaultAssistedServiceRedirectStrategy}for updating url's in order to Load Cart &
 * Order of any user as an Asagent
 */
public class DefaultPSAssistedServiceRedirectStrategy extends DefaultAssistedServiceRedirectStrategy
{
	private final static String DEFAULT_APPLICATION_DRAFT_REDIRECT = "/checkout/multi/draft?draftCode=%s";
	private final static String DEFAULT_APPLICATION_CART_REDIRECT = "/checkout/multi";
	private final static String DEFAULT_CUSTOMER_REDIRECT = "/my-account";
	private final static String DEFAULT_APPLICATION_ORDER_REDIRECT = "/my-account/application/%s";



	@Override
	protected String getPathWithCart()
	{
		if (StringUtils.isNotEmpty(getCartService().getSessionCart().getReturnURL()))
		{
			return String.format(
					Config.getString(PublicsectoracceleratoraddonConstants.REDIRECT_WITH_DRAFT, DEFAULT_APPLICATION_DRAFT_REDIRECT),
					getCartService().getSessionCart().getCode());
		}
		else
		{
			return String.format(
					Config.getString(PublicsectoracceleratoraddonConstants.REDIRECT_WITH_CART, DEFAULT_APPLICATION_CART_REDIRECT),
					getCartService().getSessionCart().getCode());
		}
	}

	@Override
	protected String getPathCustomerOnly()
	{
		return Config.getString(PublicsectoracceleratoraddonConstants.REDIRECT_CUSTOMER_ONLY, DEFAULT_CUSTOMER_REDIRECT);
	}

	@Override
	protected String getPathWithOrder(final String redirectOrderId)
	{
		return String.format(
				Config.getString(PublicsectoracceleratoraddonConstants.REDIRECT_WITH_ORDER, DEFAULT_APPLICATION_ORDER_REDIRECT),
				redirectOrderId);
	}

}
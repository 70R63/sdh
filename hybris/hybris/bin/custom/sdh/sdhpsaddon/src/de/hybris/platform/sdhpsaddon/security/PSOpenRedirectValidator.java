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
package de.hybris.platform.sdhpsaddon.security;

import de.hybris.platform.util.Config;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;


/**
 * Utility class to secure URL redirects.
 */
public class PSOpenRedirectValidator
{
	private static final String PROPERTY_DOMAIN_WHITELIST = "publicsector.application.domain.whitelist";
	private static final String PROPERTY_URL_WHITELIST = "publicsector.url.whitelist";

	private PSOpenRedirectValidator()
	{
		throw new IllegalStateException("Utility class");
	}

	public static boolean isValidDomain(final HttpServletRequest request)
	{
		final Set<String> domainWhitelist = StringUtils.commaDelimitedListToSet(Config.getParameter(PROPERTY_DOMAIN_WHITELIST));

		final String appDomain = request.getServerName();
		return domainWhitelist.stream().anyMatch(appDomain::equals);
	}

	public static boolean isValidUrl(final HttpServletRequest request, final String url)
	{
		final Set<String> urlWhitelist = StringUtils.commaDelimitedListToSet(Config.getParameter(PROPERTY_URL_WHITELIST));

		final String contextPath = request.getContextPath();
		final int pos = url.indexOf(contextPath);
		if (pos != -1)
		{
			return urlWhitelist.stream().anyMatch(url.substring(pos + contextPath.length())::equals);
		}
		return false;
	}
}

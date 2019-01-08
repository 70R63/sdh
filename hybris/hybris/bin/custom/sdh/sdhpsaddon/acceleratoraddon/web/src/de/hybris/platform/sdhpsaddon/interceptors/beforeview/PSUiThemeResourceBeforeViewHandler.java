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
package de.hybris.platform.sdhpsaddon.interceptors.beforeview;

import de.hybris.platform.acceleratorstorefrontcommons.interceptors.BeforeViewHandler;
import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.cms2.servicelayer.services.CMSSiteService;
import de.hybris.platform.commerceservices.enums.SiteTheme;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.ModelAndView;


/**
 * Public Sector UI Theme Resource Handler
 *
 */
public class PSUiThemeResourceBeforeViewHandler implements BeforeViewHandler
{
	private Map<String, String> psThemes;
	private String defaultThemeName;

	@Resource(name = "cmsSiteService")
	private CMSSiteService cmsSiteService;

	@Override
	public void beforeView(final HttpServletRequest request, final HttpServletResponse response, final ModelAndView modelAndView)
			throws Exception
	{

		final CMSSiteModel currentSite = cmsSiteService.getCurrentSite();
		final String themeName = getThemeNameForSite(currentSite);

		if (psThemes.containsKey(themeName))
		{
			final String modifiedThemePath = psThemes.get(themeName);

			final String themeResourcePath = (String) modelAndView.getModel().get("themeResourcePath");

			final String psThemeResourcePath = themeResourcePath.replace("_ui", modifiedThemePath);

			modelAndView.addObject("themeResourcePath", psThemeResourcePath);
		}

	}

	protected String getThemeNameForSite(final CMSSiteModel site)
	{
		final SiteTheme theme = site.getTheme();
		if (theme != null)
		{
			final String themeCode = theme.getCode();
			if (themeCode != null && !themeCode.isEmpty())
			{
				return themeCode;
			}
		}
		return getDefaultThemeName();
	}

	protected String getDefaultThemeName()
	{
		return defaultThemeName;
	}

	@Required
	public void setDefaultThemeName(final String defaultThemeName)
	{
		this.defaultThemeName = defaultThemeName;
	}

	/**
	 * @return the psThemes
	 */
	public Map<String, String> getPsThemes()
	{
		return psThemes;
	}

	/**
	 * @param psThemes
	 *           the psThemes to set
	 */
	public void setPsThemes(final Map<String, String> psThemes)
	{
		this.psThemes = psThemes;
	}
}

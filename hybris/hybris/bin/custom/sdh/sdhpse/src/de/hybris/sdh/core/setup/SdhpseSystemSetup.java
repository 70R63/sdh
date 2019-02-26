/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.core.setup;

import static de.hybris.sdh.core.constants.SdhpseConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.sdh.core.constants.SdhpseConstants;
import de.hybris.sdh.core.service.SdhpseService;


@SystemSetup(extension = SdhpseConstants.EXTENSIONNAME)
public class SdhpseSystemSetup
{
	private final SdhpseService sdhpseService;

	public SdhpseSystemSetup(final SdhpseService sdhpseService)
	{
		this.sdhpseService = sdhpseService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		sdhpseService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return SdhpseSystemSetup.class.getResourceAsStream("/sdhpse/sap-hybris-platform.png");
	}
}

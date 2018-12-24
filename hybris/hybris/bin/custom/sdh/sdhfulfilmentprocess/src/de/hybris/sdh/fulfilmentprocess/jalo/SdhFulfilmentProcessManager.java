/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.sdh.fulfilmentprocess.constants.SdhFulfilmentProcessConstants;

public class SdhFulfilmentProcessManager extends GeneratedSdhFulfilmentProcessManager
{
	public static final SdhFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (SdhFulfilmentProcessManager) em.getExtension(SdhFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}

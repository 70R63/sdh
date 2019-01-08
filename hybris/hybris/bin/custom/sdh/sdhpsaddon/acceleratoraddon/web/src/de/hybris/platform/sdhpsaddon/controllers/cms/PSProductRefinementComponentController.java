/*
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 *
 */
package de.hybris.platform.sdhpsaddon.controllers.cms;

import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSProductRefinementComponentModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This is PSProductRefinementComponentController controller.
 */
@Controller("PSProductRefinementComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSProductRefinementComponent)
public class PSProductRefinementComponentController
		extends SubstitutingCMSAddOnComponentController<PSProductRefinementComponentModel>
{

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model,
			final PSProductRefinementComponentModel component)
	{
		// YTODO Auto-generated method stub
	}

}

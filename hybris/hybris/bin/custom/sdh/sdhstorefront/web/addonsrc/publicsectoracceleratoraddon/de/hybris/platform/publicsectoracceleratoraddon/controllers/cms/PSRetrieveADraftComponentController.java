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
package de.hybris.platform.publicsectoracceleratoraddon.controllers.cms;

import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSRetrieveADraftComponentModel;
import de.hybris.platform.servicelayer.exceptions.AttributeNotSupportedException;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This is PSRetrieveADraftComponent controller.
 */
@Controller("PSRetrieveADraftComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSRetrieveADraftComponent)
public class PSRetrieveADraftComponentController<C extends PSRetrieveADraftComponentModel>
		extends SubstitutingCMSAddOnComponentController<C>
{

	private static final Logger LOG = LoggerFactory.getLogger(PSRetrieveADraftComponentController.class);

	@Resource
	private ModelService modelService;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final C component)
	{
		for (final String property : getCmsComponentService().getEditorProperties(component))
		{
			try
			{
				final Object value = modelService.getAttributeValue(component, property);
				model.addAttribute(property, value);
			}
			catch (final AttributeNotSupportedException exception)
			{
				LOG.debug("Exception while retrieving attribute value for property: " + property + " \n", exception);
			}
		}
	}
}

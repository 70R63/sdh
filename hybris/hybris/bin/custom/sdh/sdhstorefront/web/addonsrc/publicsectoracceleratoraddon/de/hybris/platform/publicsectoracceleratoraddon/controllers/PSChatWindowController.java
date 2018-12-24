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
package de.hybris.platform.publicsectoracceleratoraddon.controllers;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.AbstractController;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * This is ChatBoxController for the mobile chat window
 */
@Controller
public class PSChatWindowController extends AbstractController
{
	private static final String ORIGINAL_REFERER = "originalReferer";

	@RequestMapping(value = "chat/chatWindow", method = RequestMethod.GET)
	protected String getChat(@RequestHeader(value = "referer", required = false) final String referer,
			final HttpServletRequest request)
	{
		// Update the original referer to fix the OOTB issue with language change .
		if (StringUtils.isNotBlank(referer))
		{
			request.getSession().setAttribute(ORIGINAL_REFERER, referer);
		}
		return ControllerConstants.Views.Chat.chatWindow;
	}
}

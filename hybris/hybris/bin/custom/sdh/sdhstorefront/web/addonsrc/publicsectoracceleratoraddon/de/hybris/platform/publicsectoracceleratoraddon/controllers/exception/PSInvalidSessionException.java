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
package de.hybris.platform.publicsectoracceleratoraddon.controllers.exception;

/**
 * Exception to indicate the session is invalid.
 */
public class PSInvalidSessionException extends Exception
{
	public PSInvalidSessionException(final String message)
	{
		super(message);
	}

	public PSInvalidSessionException(final Throwable cause)
	{
		super(cause);
	}

	public PSInvalidSessionException(final String message, final Throwable cause)
	{
		super(message, cause);
	}
}

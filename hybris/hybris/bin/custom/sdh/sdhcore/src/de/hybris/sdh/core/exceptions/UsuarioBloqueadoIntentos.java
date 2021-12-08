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
package de.hybris.sdh.core.exceptions;


import org.springframework.security.core.AuthenticationException;


/**
 * UnkownResource validation exception used to throw validation errors. <br/>
 */

public class UsuarioBloqueadoIntentos extends AuthenticationException
{

	/**
	 * @param msg
	 */
	public UsuarioBloqueadoIntentos(final String msg)
	{
		super(msg);
		// XXX Auto-generated constructor stub
	}

	/**
	 * @param msg
	 * @param t
	 */
	public UsuarioBloqueadoIntentos(final String msg, final Throwable t)
	{
		super(msg, t);
		// XXX Auto-generated constructor stub
	}

}
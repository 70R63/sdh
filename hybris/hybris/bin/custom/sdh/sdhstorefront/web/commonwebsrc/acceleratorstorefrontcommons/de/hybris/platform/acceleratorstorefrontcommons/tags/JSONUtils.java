/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.acceleratorstorefrontcommons.tags;

import com.fasterxml.jackson.core.io.JsonStringEncoder;


/**
 * JSON util class.
 */
public class JSONUtils
{
	private JSONUtils()
	{
		// private constructor to avoid instantiation
	}

	/**
	 * Encode of JSON String values using Jackson JsonStringEncoder.
	 *
	 * @param unencodedString
	 *           the not encoded JSON string
	 * @return encoded JSON string
	 */
	public static String encode(final String unencodedString)
	{
		final JsonStringEncoder encoder = new JsonStringEncoder();
		return String.valueOf(encoder.quoteAsString(unencodedString));
	}
}

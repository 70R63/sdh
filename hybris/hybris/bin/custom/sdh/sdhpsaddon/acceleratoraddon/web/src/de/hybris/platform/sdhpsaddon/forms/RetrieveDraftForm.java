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
package de.hybris.platform.sdhpsaddon.forms;

import javax.validation.constraints.NotNull;


/**
 * Retrieve Draft Form
 *
 */
public class RetrieveDraftForm
{
	@NotNull(message = "{general.required}")
	private String _email; // NOSONAR
	@NotNull(message = "{general.required}")
	private String _draftNumber; // NOSONAR

	/**
	 * @return the _email
	 */
	public String getEmail()
	{
		return _email;
	}

	/**
	 * @param _email
	 *           the _email to set
	 */
	public void setEmail(final String _email) // NOSONAR
	{
		this._email = _email;
	}

	/**
	 * @return the _draftNumber
	 */
	public String getDraftNumber()
	{
		return _draftNumber;
	}

	/**
	 * @param _draftNumber
	 *           the _draftNumber to set
	 */
	public void setDraftNumber(final String _draftNumber) // NOSONAR
	{
		this._draftNumber = _draftNumber;
	}

}

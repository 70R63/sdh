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
package de.hybris.platform.relationshipaddon.forms;

/**
 * RelationshipForm for add relationship form
 *
 */
public class RelationshipForm
{
	private String title;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String confirmEmailAddress;

	public String getTitle()
	{
		return title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmailAddress()
	{
		if (emailAddress != null)
		{
			return emailAddress.toLowerCase();

		}
		return null;
	}

	public void setEmailAddress(final String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getConfirmEmailAddress()
	{
		if (confirmEmailAddress != null)
		{
			return confirmEmailAddress.toLowerCase();
		}
		return null;
	}

	public void setConfirmEmailAddress(final String confirmEmailAddress)
	{
		this.confirmEmailAddress = confirmEmailAddress;
	}
}

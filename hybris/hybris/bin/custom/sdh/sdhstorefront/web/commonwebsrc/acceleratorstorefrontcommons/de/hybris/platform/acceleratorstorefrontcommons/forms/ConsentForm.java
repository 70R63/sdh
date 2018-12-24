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
package de.hybris.platform.acceleratorstorefrontcommons.forms;

/**
 * Form object for consent
 */
public class ConsentForm
{
	private String consentTemplateId;
	private Integer consentTemplateVersion;
	private boolean consentGiven;
	private String consentCode;

	public boolean getConsentGiven()
	{
		return consentGiven;
	}

	public void setConsentGiven(final boolean isConsentGiven)
	{
		this.consentGiven = isConsentGiven;
	}

	public String getConsentTemplateId()
	{
		return consentTemplateId;
	}

	public void setConsentTemplateId(final String consentTemplateId)
	{
		this.consentTemplateId = consentTemplateId;
	}

	public Integer getConsentTemplateVersion()
	{
		return consentTemplateVersion;
	}

	public void setConsentTemplateVersion(final Integer consentTemplateVersion)
	{
		this.consentTemplateVersion = consentTemplateVersion;
	}

	public String getConsentCode()
	{
		return consentCode;
	}

	public void setConsentCode(final String consentCode)
	{
		this.consentCode = consentCode;
	}
	
}

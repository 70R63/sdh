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

public class PlaceOrderForm
{

	private String securityCode;
	private boolean termsCheck;
	private String[] consentDeclarations;

	public String getSecurityCode()
	{
		return securityCode;
	}

	public void setSecurityCode(final String securityCode)
	{
		this.securityCode = securityCode;
	}

	/**
	 * @return the termsCheck
	 */
	public boolean isTermsCheck()
	{
		return termsCheck;
	}

	/**
	 * @param termsCheck
	 *           the termsCheck to set
	 */
	public void setTermsCheck(final boolean termsCheck)
	{
		this.termsCheck = termsCheck;
	}

	/**
	 * @return the consentDeclarations
	 */
	public String[] getConsentDeclarations()
	{
		return consentDeclarations;
	}

	/**
	 * @param consentDeclarations
	 *           the consentDeclarations to set
	 */
	public void setConsentDeclarations(final String[] consentDeclarations)
	{
		this.consentDeclarations = consentDeclarations;
	}





}

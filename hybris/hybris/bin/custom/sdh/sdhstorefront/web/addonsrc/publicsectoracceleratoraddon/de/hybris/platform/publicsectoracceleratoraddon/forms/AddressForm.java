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
package de.hybris.platform.publicsectoracceleratoraddon.forms;

/**
 * This is a class for the Address Form.
 */
public class AddressForm extends de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm
{
	private Boolean usePrimaryAddress;

	/**
	 * @return the usePrimaryAddress
	 */
	public Boolean getUsePrimaryAddress()
	{
		return usePrimaryAddress;
	}

	/**
	 * @param usePrimaryAddress
	 *           the usePrimaryAddress to set
	 */
	public void setUsePrimaryAddress(final Boolean usePrimaryAddress)
	{
		this.usePrimaryAddress = usePrimaryAddress;
	}
}

/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.publicsectoracceleratoraddon.checkout.steps;

public class FormCheckoutStep extends CheckoutStep
{
	private String formPageId;
	private String productCode;

	public String getFormPageId()
	{
		return formPageId;
	}

	public void setFormPageId(final String formPageId)
	{
		this.formPageId = formPageId;
	}

	public String getProductCode()
	{
		return productCode;
	}

	public void setProductCode(String productCode)
	{
		this.productCode = productCode;
	}
}

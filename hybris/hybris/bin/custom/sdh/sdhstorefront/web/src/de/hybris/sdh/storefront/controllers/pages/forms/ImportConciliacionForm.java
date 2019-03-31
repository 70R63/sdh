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
package de.hybris.sdh.storefront.controllers.pages.forms;

import org.springframework.web.multipart.MultipartFile;


public class ImportConciliacionForm
{
	private MultipartFile conciliacionFile;

	/**
	 * @return the conciliacionFile
	 */
	public MultipartFile getConciliacionFile()
	{
		return conciliacionFile;
	}

	/**
	 * @param conciliacionFile
	 *           the conciliacionFile to set
	 */
	public void setConciliacionFile(final MultipartFile conciliacionFile)
	{
		this.conciliacionFile = conciliacionFile;
	}

}

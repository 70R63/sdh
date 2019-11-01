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
	private String tipoArchivo;
	private String entidadBancaria;

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

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public String getEntidadBancaria() {
		return entidadBancaria;
	}

	public void setEntidadBancaria(String entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
	}
}

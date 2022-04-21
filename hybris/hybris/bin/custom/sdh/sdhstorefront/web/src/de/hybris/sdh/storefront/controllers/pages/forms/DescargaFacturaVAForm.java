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

public class DescargaFacturaVAForm
{
	private String claveImpuesto;
	private String numDoc;
	private String tipoDoc;
	private String fechaExp;
	private String claveObjeto;
	private String nombreContribuyente;
	private String numBP;
	private String urlDownload;
	
	
	/**
	 * @return the claveImpuesto
	 */
	public String getClaveImpuesto()
	{
		return claveImpuesto;
	}
	/**
	 * @param claveImpuesto the claveImpuesto to set
	 */
	public void setClaveImpuesto(String claveImpuesto)
	{
		this.claveImpuesto = claveImpuesto;
	}
	/**
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}
	/**
	 * @param numDoc the numDoc to set
	 */
	public void setNumDoc(String numDoc)
	{
		this.numDoc = numDoc;
	}
	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc()
	{
		return tipoDoc;
	}
	/**
	 * @param tipoDoc the tipoDoc to set
	 */
	public void setTipoDoc(String tipoDoc)
	{
		this.tipoDoc = tipoDoc;
	}
	/**
	 * @return the fechaExp
	 */
	public String getFechaExp()
	{
		return fechaExp;
	}
	/**
	 * @param fechaExp the fechaExp to set
	 */
	public void setFechaExp(String fechaExp)
	{
		this.fechaExp = fechaExp;
	}
	/**
	 * @return the claveObjeto
	 */
	public String getClaveObjeto()
	{
		return claveObjeto;
	}
	/**
	 * @param claveObjeto the claveObjeto to set
	 */
	public void setClaveObjeto(String claveObjeto)
	{
		this.claveObjeto = claveObjeto;
	}
	/**
	 * @return the nombreContribuyente
	 */
	public String getNombreContribuyente()
	{
		return nombreContribuyente;
	}
	/**
	 * @param nombreContribuyente the nombreContribuyente to set
	 */
	public void setNombreContribuyente(String nombreContribuyente)
	{
		this.nombreContribuyente = nombreContribuyente;
	}
	
	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}
	/**
	 * @param numBP the numBP to set
	 */
	public void setNumBP(String numBP)
	{
		this.numBP = numBP;
	}
	/**
	 * @return the urlDownload
	 */
	public String getUrlDownload()
	{
		return urlDownload;
	}
	/**
	 * @param urlDownload the urlDownload to set
	 */
	public void setUrlDownload(String urlDownload)
	{
		this.urlDownload = urlDownload;
	}
	
	@Override
	public String toString()
	{
		return "DescargaFacturaVAForm [claveImpuesto=" + claveImpuesto + ", numDoc=" + numDoc + ", tipoDoc=" + tipoDoc
				+ ", claveObjeto=" + claveObjeto + ", nombreContribuyente=" + nombreContribuyente + ", urlDownload=" + urlDownload
				+ "]";
	}


}

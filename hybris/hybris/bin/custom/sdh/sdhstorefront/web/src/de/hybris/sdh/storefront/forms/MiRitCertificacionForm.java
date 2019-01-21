package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.CertificacionRIT;

public class MiRitCertificacionForm
{


	private String idmsj;
	private String txtmsj;
	private CertificacionRIT rit;

	/**
	 * @return the idmsj
	 */
	public String getIdmsj()
	{
		return idmsj;
	}

	/**
	 * @param idmsj
	 *           the idmsj to set
	 */
	public void setIdmsj(final String idmsj)
	{
		this.idmsj = idmsj;
	}

	/**
	 * @return the txtmsj
	 */
	public String getTxtmsj()
	{
		return txtmsj;
	}

	/**
	 * @param txtmsj
	 *           the txtmsj to set
	 */
	public void setTxtmsj(final String txtmsj)
	{
		this.txtmsj = txtmsj;
	}

	/**
	 * @return the rit
	 */
	public CertificacionRIT getRit()
	{
		return rit;
	}

	/**
	 * @param rit
	 *           the rit to set
	 */
	public void setRit(final CertificacionRIT rit)
	{
		this.rit = rit;
	}



}
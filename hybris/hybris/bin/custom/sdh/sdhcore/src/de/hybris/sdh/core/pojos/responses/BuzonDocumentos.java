/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author hybris
 *
 */
public class BuzonDocumentos
{
	@JsonProperty("ID_Documento")
	private String idDocumento;
	private String nombreDocumento;
	private String pdf;

	/**
	 * @return the nombreDocumento
	 */
	public String getNombreDocumento()
	{
		return nombreDocumento;
	}

	/**
	 * @param nombreDocumento
	 *           the nombreDocumento to set
	 */
	public void setNombreDocumento(final String nombreDocumento)
	{
		this.nombreDocumento = nombreDocumento;
	}
	/**
	 * @return the pdf
	 */
	public String getPdf()
	{
		return pdf;
	}

	/**
	 * @param pdf
	 *           the pdf to set
	 */
	public void setPdf(final String pdf)
	{
		this.pdf = pdf;
	}

	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento()
	{
		return idDocumento;
	}

	/**
	 * @param idDocumento
	 *           the idDocumento to set
	 */
	public void setIdDocumento(final String idDocumento)
	{
		this.idDocumento = idDocumento;
	}
}

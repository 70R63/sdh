/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class BuzonDocumentos
{
	private String nombredocumento;
	private String pdf;

	/**
	 * @return the nombredocumento
	 */
	public String getNombredocumento()
	{
		return nombredocumento;
	}

	/**
	 * @param nombredocumento
	 *           the nombredocumento to set
	 */
	@JsonProperty("nombreDocumento")
	public void setNombredocumento(final String nombredocumento)
	{
		this.nombredocumento = nombredocumento;
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
}

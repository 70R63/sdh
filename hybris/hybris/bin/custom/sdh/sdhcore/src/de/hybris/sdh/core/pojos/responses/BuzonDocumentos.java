/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class BuzonDocumentos
{
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


}

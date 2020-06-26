/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class SpacPDFResponse
{
	//	@JsonProperty("Proyecto")


	public String pdf;
	public List<SpacErrores> errores;
	
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
	@JsonProperty("PDF")
	public void setPdf(final String pdf)
	{
		this.pdf = pdf;
	}
	/**
	 * @return the errores
	 */
	public List<SpacErrores> getErrores()
	{
		return errores;
	}
	
	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<SpacErrores> errores)
	{
		this.errores = errores;
	}




}

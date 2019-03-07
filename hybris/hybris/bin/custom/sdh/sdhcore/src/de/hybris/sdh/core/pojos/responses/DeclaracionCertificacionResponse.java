/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class DeclaracionCertificacionResponse
{

	private String stringPDF;
	private List<ErrorEnWS> errores;
	
	/**
	 * @return the stringPDF
	 */
	public String getStringPDF()
	{
		return stringPDF;
	}
	
	/**
	 * @param stringPDF
	 *           the stringPDF to set
	 */
	public void setStringPDF(final String stringPDF)
	{
		this.stringPDF = stringPDF;
	}
	/**
	 * @return the errores
	 */
	public List<ErrorEnWS> getErrores()
	{
		return errores;
	}
	
	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}




}

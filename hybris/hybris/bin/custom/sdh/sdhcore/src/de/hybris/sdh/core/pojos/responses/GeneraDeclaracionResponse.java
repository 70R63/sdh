/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class GeneraDeclaracionResponse
{


	private List<ErrorPubli> errores;
	private String stringPDF;

	/**
	 * @return the errores
	 */
	public List<ErrorPubli> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorPubli> errores)
	{
		this.errores = errores;
	}

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


}

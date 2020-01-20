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
	private String urlDownload;
	private String mensajeErrorVeh;

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

	/**
	 * @return the urlDownload
	 */
	public String getUrlDownload()
	{
		return urlDownload;
	}

	/**
	 * @param urlDownload
	 *           the urlDownload to set
	 */
	public void setUrlDownload(final String urlDownload)
	{
		this.urlDownload = urlDownload;
	}

	/**
	 * @return the mensajeErrorVeh
	 */
	public String getMensajeErrorVeh()
	{
		return mensajeErrorVeh;
	}

	/**
	 * @param mensajeErrorVeh
	 *           the mensajeErrorVeh to set
	 */
	public void setMensajeErrorVeh(final String mensajeErrorVeh)
	{
		this.mensajeErrorVeh = mensajeErrorVeh;
	}

}

/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author MTorres
 *
 */
public class RetencionesPracticadasReporteResponse
{
	private String pdf;
	private List<UpdateRitErrorResponse> errores;



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
	@JsonSetter("PDF")
	public void setPdf(final String pdf)
	{
		this.pdf = pdf;
	}

	/**
	 * @return the errores
	 */
	public List<UpdateRitErrorResponse> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	@JsonSetter("Errores")
	public void setErrores(final List<UpdateRitErrorResponse> errores)
	{
		this.errores = errores;
	}
}

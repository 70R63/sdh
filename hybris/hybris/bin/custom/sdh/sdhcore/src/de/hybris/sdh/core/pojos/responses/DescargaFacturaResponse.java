/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;



/**
 * @author Federico Flores Dimas
 *
 */
public class DescargaFacturaResponse
{
	private String pdf;
	private List<ErrorEnWS> errores;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DescargaFacturaResponse [pdf=" + pdf + ", errores=" + errores + "]";
	}


}

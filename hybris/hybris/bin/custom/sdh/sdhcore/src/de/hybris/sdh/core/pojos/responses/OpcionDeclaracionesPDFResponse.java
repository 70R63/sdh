/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class OpcionDeclaracionesPDFResponse
{
	private String pdf;
	private ErrorEnWSDeclaracionesPDF errores;

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
	 * @return the errores
	 */
	public ErrorEnWSDeclaracionesPDF getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final ErrorEnWSDeclaracionesPDF errores)
	{
		this.errores = errores;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "OpcionDeclaracionesPDFResponse [pdf=" + pdf + ", errores=" + errores + "]";
	}



}

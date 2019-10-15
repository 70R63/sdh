/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class OpcionCertiDecImprimeResponse
{
	private String pdf;
	private ErrorEnWS errores;

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
	public ErrorEnWS getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final ErrorEnWS errores)
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
		return "OpcionCertiPagosImprimeResponse [pdf=" + pdf + ", errores=" + errores + "]";
	}


}

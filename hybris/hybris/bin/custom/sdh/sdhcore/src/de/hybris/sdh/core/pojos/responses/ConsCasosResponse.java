/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class ConsCasosResponse
{

	private String txtmsj;
	private List<ConsCasosResultadoResponse> resultado;

	/**
	 * @return the txtmsj
	 */
	public String getTxtmsj()
	{
		return txtmsj;
	}

	/**
	 * @param txtmsj
	 *           the txtmsj to set
	 */
	public void setTxtmsj(final String txtmsj)
	{
		this.txtmsj = txtmsj;
	}

	/**
	 * @return the resultado
	 */
	public List<ConsCasosResultadoResponse> getResultado()
	{
		return resultado;
	}

	/**
	 * @param resultado
	 *           the resultado to set
	 */
	public void setResultado(final List<ConsCasosResultadoResponse> resultado)
	{
		this.resultado = resultado;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ConsCasosResponse [txtmsj=" + txtmsj + ", resultado=" + resultado + "]";
	}




}

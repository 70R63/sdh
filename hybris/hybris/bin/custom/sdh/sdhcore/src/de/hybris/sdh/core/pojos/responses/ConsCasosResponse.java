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
	private List<ConsCasosArchiResponse> archivos;

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



	/**
	 * @return the archivos
	 */
	public List<ConsCasosArchiResponse> getArchivos()
	{
		return archivos;
	}

	/**
	 * @param archivos
	 *           the archivos to set
	 */
	public void setArchivos(final List<ConsCasosArchiResponse> archivos)
	{
		this.archivos = archivos;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ConsCasosResponse [txtmsj=" + txtmsj + ", resultado=" + resultado + ", archivos=" + archivos + "]";
	}



}

/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class CreaCasosArchiInfoRequest
{

	private String linea;
	private String identificador;
	private String valor;
	private List<CreaCasosArchiRequest> archivos;

	/**
	 * @return the linea
	 */
	public String getLinea()
	{
		return linea;
	}

	/**
	 * @param linea
	 *           the linea to set
	 */
	public void setLinea(final String linea)
	{
		this.linea = linea;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador()
	{
		return identificador;
	}

	/**
	 * @param identificador
	 *           the identificador to set
	 */
	public void setIdentificador(final String identificador)
	{
		this.identificador = identificador;
	}

	/**
	 * @return the valor
	 */
	public String getValor()
	{
		return valor;
	}

	/**
	 * @param valor
	 *           the valor to set
	 */
	public void setValor(final String valor)
	{
		this.valor = valor;
	}

	/**
	 * @return the archivos
	 */
	public List<CreaCasosArchiRequest> getArchivos()
	{
		return archivos;
	}

	/**
	 * @param archivos
	 *           the archivos to set
	 */
	public void setArchivos(final List<CreaCasosArchiRequest> archivos)
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
		return "CreaCasosArchiInfoRequest [linea=" + linea + ", identificador=" + identificador + ", valor=" + valor + ", archivos="
				+ archivos + "]";
	}


}

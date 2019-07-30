/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class CreaCasosRespuestaResponse
{
	private String cod_retorno;
	private String descripcion;
	private String num_caso;

	/**
	 * @return the cod_retorno
	 */
	public String getCod_retorno()
	{
		return cod_retorno;
	}

	/**
	 * @param cod_retorno
	 *           the cod_retorno to set
	 */
	public void setCod_retorno(final String cod_retorno)
	{
		this.cod_retorno = cod_retorno;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion()
	{
		return descripcion;
	}

	/**
	 * @param descripcion
	 *           the descripcion to set
	 */
	public void setDescripcion(final String descripcion)
	{
		this.descripcion = descripcion;
	}

	/**
	 * @return the num_caso
	 */
	public String getNum_caso()
	{
		return num_caso;
	}

	/**
	 * @param num_caso
	 *           the num_caso to set
	 */
	public void setNum_caso(final String num_caso)
	{
		this.num_caso = num_caso;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CreaCasosRespuestaResponse [cod_retorno=" + cod_retorno + ", descripcion=" + descripcion + ", num_caso=" + num_caso
				+ "]";
	}


}

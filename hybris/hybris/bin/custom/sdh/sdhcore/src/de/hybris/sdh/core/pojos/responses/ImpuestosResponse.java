package de.hybris.sdh.core.pojos.responses;

public class ImpuestosResponse {
	private String claseObjeto;
	private String descripcion;
	private String cantObjetos;

	/**
	 * @return the claseObjeto
	 */
	public String getClaseObjeto()
	{
		return claseObjeto;
	}

	/**
	 * @param claseObjeto
	 *           the claseObjeto to set
	 */
	public void setClaseObjeto(final String claseObjeto)
	{
		this.claseObjeto = claseObjeto;
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
	 * @return the cantObjetos
	 */
	public String getCantObjetos()
	{
		return cantObjetos;
	}

	/**
	 * @param cantObjetos
	 *           the cantObjetos to set
	 */
	public void setCantObjetos(final String cantObjetos)
	{
		this.cantObjetos = cantObjetos;
	}

	@Override
    public String toString() {
		return "ImpuestosResponse{" + " claseObjeto='" + claseObjeto + '\'' + ", descripcion='" + descripcion + '\''
				+ ", cantObjetos='" + cantObjetos + '\'' +
                '}';
    }
}

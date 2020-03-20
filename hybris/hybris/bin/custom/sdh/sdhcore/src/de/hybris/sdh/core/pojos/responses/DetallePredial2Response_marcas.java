/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class DetallePredial2Response_marcas
{
	private String marca;
	private String tipoMarca;
	private String porcMarca;

	/**
	 * @return the marca
	 */
	public String getMarca()
	{
		return marca;
	}

	/**
	 * @param marca
	 *           the marca to set
	 */
	public void setMarca(final String marca)
	{
		this.marca = marca;
	}

	/**
	 * @return the tipoMarca
	 */
	public String getTipoMarca()
	{
		return tipoMarca;
	}

	/**
	 * @param tipoMarca
	 *           the tipoMarca to set
	 */
	public void setTipoMarca(final String tipoMarca)
	{
		this.tipoMarca = tipoMarca;
	}

	/**
	 * @return the porcMarca
	 */
	public String getPorcMarca()
	{
		return porcMarca;
	}

	/**
	 * @param porcMarca
	 *           the porcMarca to set
	 */
	public void setPorcMarca(final String porcMarca)
	{
		this.porcMarca = porcMarca;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetallePredial2Response_marcas [marca=" + marca + ", tipoMarca=" + tipoMarca + ", porcMarca=" + porcMarca + "]";
	}


}

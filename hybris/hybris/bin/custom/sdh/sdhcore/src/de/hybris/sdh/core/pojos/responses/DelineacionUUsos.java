/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class DelineacionUUsos
{

	private String codUso;
	private String numUnidad;
	private String uso;
	private String usoCatalogo;
	private String areaNeta;

	/**
	 * @return the uso
	 */
	public String getUso()
	{
		return uso;
	}

	/**
	 * @param uso
	 *           the uso to set
	 */
	public void setUso(final String uso)
	{
		this.uso = uso;
	}

	/**
	 * @return the usoCatalogo
	 */
	public String getUsoCatalogo()
	{
		return usoCatalogo;
	}

	/**
	 * @param usoCatalogo
	 *           the usoCatalogo to set
	 */
	public void setUsoCatalogo(final String usoCatalogo)
	{
		this.usoCatalogo = usoCatalogo;
	}

	/**
	 * @return the codUso
	 */
	public String getCodUso()
	{
		return codUso;
	}

	/**
	 * @param codUso
	 *           the codUso to set
	 */
	public void setCodUso(final String codUso)
	{
		this.codUso = codUso;
	}

	/**
	 * @return the numUnidad
	 */
	public String getNumUnidad()
	{
		return numUnidad;
	}

	/**
	 * @param numUnidad
	 *           the numUnidad to set
	 */
	public void setNumUnidad(final String numUnidad)
	{
		this.numUnidad = numUnidad;
	}

	/**
	 * @return the areaNeta
	 */
	public String getAreaNeta()
	{
		return areaNeta;
	}

	/**
	 * @param areaNeta
	 *           the areaNeta to set
	 */
	public void setAreaNeta(final String areaNeta)
	{
		this.areaNeta = areaNeta;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DelineacionUUsos [codUso=" + codUso + ", numUnidad=" + numUnidad + ", uso=" + uso + ", usoCatalogo=" + usoCatalogo
				+ ", areaNeta=" + areaNeta + "]";
	}



}

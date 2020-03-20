/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class DetallePredial2Response_liquidacion
{
	private String porcentajePropiedad;
	private String tarifaLiquidacion;
	private String destinoHacendario;
	private String baseGravable;
	private String exclusionParcial;

	/**
	 * @return the porcentajePropiedad
	 */
	public String getPorcentajePropiedad()
	{
		return porcentajePropiedad;
	}

	/**
	 * @param porcentajePropiedad
	 *           the porcentajePropiedad to set
	 */
	public void setPorcentajePropiedad(final String porcentajePropiedad)
	{
		this.porcentajePropiedad = porcentajePropiedad;
	}

	/**
	 * @return the tarifaLiquidacion
	 */
	public String getTarifaLiquidacion()
	{
		return tarifaLiquidacion;
	}

	/**
	 * @param tarifaLiquidacion
	 *           the tarifaLiquidacion to set
	 */
	public void setTarifaLiquidacion(final String tarifaLiquidacion)
	{
		this.tarifaLiquidacion = tarifaLiquidacion;
	}

	/**
	 * @return the destinoHacendario
	 */
	public String getDestinoHacendario()
	{
		return destinoHacendario;
	}

	/**
	 * @param destinoHacendario
	 *           the destinoHacendario to set
	 */
	public void setDestinoHacendario(final String destinoHacendario)
	{
		this.destinoHacendario = destinoHacendario;
	}

	/**
	 * @return the baseGravable
	 */
	public String getBaseGravable()
	{
		return baseGravable;
	}

	/**
	 * @param baseGravable
	 *           the baseGravable to set
	 */
	public void setBaseGravable(final String baseGravable)
	{
		this.baseGravable = baseGravable;
	}

	/**
	 * @return the exclusionParcial
	 */
	public String getExclusionParcial()
	{
		return exclusionParcial;
	}

	/**
	 * @param exclusionParcial
	 *           the exclusionParcial to set
	 */
	public void setExclusionParcial(final String exclusionParcial)
	{
		this.exclusionParcial = exclusionParcial;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetallePredial2Response_liquidacion [porcentajePropiedad=" + porcentajePropiedad + ", tarifaLiquidacion="
				+ tarifaLiquidacion + ", destinoHacendario=" + destinoHacendario + ", baseGravable=" + baseGravable
				+ ", exclusionParcial=" + exclusionParcial + "]";
	}

}

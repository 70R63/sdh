/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class DetalleMarcasVehiculos
{
	private String codigoMarca;
	private String descripcion;
	private String porcExencion;
	private String valorExencion;
	private String fechaDesde;
	private String fechaHasta;

	/**
	 * @return the codigoMarca
	 */
	public String getCodigoMarca()
	{
		return codigoMarca;
	}

	/**
	 * @param codigoMarca
	 *           the codigoMarca to set
	 */
	public void setCodigoMarca(final String codigoMarca)
	{
		this.codigoMarca = codigoMarca;
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
	 * @return the porcExencion
	 */
	public String getPorcExencion()
	{
		return porcExencion;
	}

	/**
	 * @param porcExencion
	 *           the porcExencion to set
	 */
	public void setPorcExencion(final String porcExencion)
	{
		this.porcExencion = porcExencion;
	}

	/**
	 * @return the valorExencion
	 */
	public String getValorExencion()
	{
		return valorExencion;
	}

	/**
	 * @param valorExencion
	 *           the valorExencion to set
	 */
	public void setValorExencion(final String valorExencion)
	{
		this.valorExencion = valorExencion;
	}

	/**
	 * @return the fechaDesde
	 */
	public String getFechaDesde()
	{
		return fechaDesde;
	}

	/**
	 * @param fechaDesde
	 *           the fechaDesde to set
	 */
	public void setFechaDesde(final String fechaDesde)
	{
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @return the fechaHasta
	 */
	public String getFechaHasta()
	{
		return fechaHasta;
	}

	/**
	 * @param fechaHasta
	 *           the fechaHasta to set
	 */
	public void setFechaHasta(final String fechaHasta)
	{
		this.fechaHasta = fechaHasta;
	}



}

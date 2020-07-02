package de.hybris.sdh.core.pojos.responses;

public class ObligacionesVehicular {
	private String anoGravable;
	private String placa;
	private String modelo;
	private String marca;
	private String linea;
	private String estadoObligacion;

	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}
	/**
	 * @param anoGravable the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
	}
	
	/**
	 * @return the placa
	 */
	public String getPlaca()
	{
		return placa;
	}

	/**
	 * @param placa
	 *           the placa to set
	 */
	public void setPlaca(final String placa)
	{
		this.placa = placa;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo()
	{
		return modelo;
	}

	/**
	 * @param modelo
	 *           the modelo to set
	 */
	public void setModelo(final String modelo)
	{
		this.modelo = modelo;
	}

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
	 * @return the estadoObligacion
	 */
	public String getEstadoObligacion()
	{
		return estadoObligacion;
	}
	/**
	 * @param estadoObligacion the estadoObligacion to set
	 */
	public void setEstadoObligacion(final String estadoObligacion)
	{
		this.estadoObligacion = estadoObligacion;
	}

}

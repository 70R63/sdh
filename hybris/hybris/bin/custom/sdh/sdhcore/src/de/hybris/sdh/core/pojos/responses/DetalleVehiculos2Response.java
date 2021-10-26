/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;



/**
 * @author Federico Flores Dimas
 *
 */
public class DetalleVehiculos2Response
{

	private DetalleVehiculos2Response_info info_vehiculo;
	private DetalleVehiculos2Response_liquidacion liquidacion;
	private List<FirmanteResponse> firmantes;


	/**
	 * @return the info_vehiculo
	 */
	public DetalleVehiculos2Response_info getInfo_vehiculo()
	{
		return info_vehiculo;
	}

	/**
	 * @param info_vehiculo
	 *           the info_vehiculo to set
	 */
	public void setInfo_vehiculo(final DetalleVehiculos2Response_info info_vehiculo)
	{
		this.info_vehiculo = info_vehiculo;
	}

	/**
	 * @return the liquidacion
	 */
	public DetalleVehiculos2Response_liquidacion getLiquidacion()
	{
		return liquidacion;
	}

	/**
	 * @param liquidacion
	 *           the liquidacion to set
	 */
	@JsonSetter("Liquidacion")
	public void setLiquidacion(final DetalleVehiculos2Response_liquidacion liquidacion)
	{
		this.liquidacion = liquidacion;
	}

	/**
	 * @return the firmantes
	 */
	public List<FirmanteResponse> getFirmantes()
	{
		return firmantes;
	}

	/**
	 * @param firmantes
	 *           the firmantes to set
	 */
	@JsonSetter("Firmantes")
	public void setFirmantes(final List<FirmanteResponse> firmantes)
	{
		this.firmantes = firmantes;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetalleVehiculos2Response [info_vehiculo=" + info_vehiculo + ", liquidacion=" + liquidacion + ", firmantes="
				+ firmantes + "]";
	}



}

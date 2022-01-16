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
	private String descuentoadicional;
	private String descuentoconbustible;


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

	/**
	 * @return the descuentoadicional
	 */
	public String getDescuentoadicional()
	{
		return descuentoadicional;
	}

	/**
	 * @param descuentoadicional
	 *           the descuentoadicional to set
	 */
	public void setDescuentoadicional(final String descuentoadicional)
	{
		this.descuentoadicional = descuentoadicional;
	}

	/**
	 * @return the descuentoconbustible
	 */
	public String getDescuentoconbustible()
	{
		return descuentoconbustible;
	}

	/**
	 * @param descuentoconbustible
	 *           the descuentoconbustible to set
	 */
	public void setDescuentoconbustible(final String descuentoconbustible)
	{
		this.descuentoconbustible = descuentoconbustible;
	}

	@Override
	public String toString()
	{
		return "DetalleVehiculos2Response [info_vehiculo=" + info_vehiculo + ", liquidacion=" + liquidacion + ", firmantes="
				+ firmantes + ", descuentoadicional=" + descuentoadicional + ", descuentoconbustible=" + descuentoconbustible + "]";
	}




}

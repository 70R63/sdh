/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class DetalleVehiculosResponse
{
	private DetalleVehiculos detalle;
	private DetalleJuridicosVehiculos datosJuridicos;
	private List<DetalleMarcas> marcas;
	private List<DetalleLiquidacionVehiculos> liquidacion;
	private DetalleInfoDeclaraVehiculos info_declara;

	/**
	 * @return the detalle
	 */
	public DetalleVehiculos getDetalle()
	{
		return detalle;
	}

	/**
	 * @param detalle
	 *           the detalle to set
	 */
	public void setDetalle(final DetalleVehiculos detalle)
	{
		this.detalle = detalle;
	}

	/**
	 * @return the datosJuridicos
	 */
	public DetalleJuridicosVehiculos getDatosJuridicos()
	{
		return datosJuridicos;
	}

	/**
	 * @param datosJuridicos
	 *           the datosJuridicos to set
	 */
	public void setDatosJuridicos(final DetalleJuridicosVehiculos datosJuridicos)
	{
		this.datosJuridicos = datosJuridicos;
	}


	/**
	 * @return the liquidacion
	 */
	public List<DetalleLiquidacionVehiculos> getLiquidacion()
	{
		return liquidacion;
	}

	/**
	 * @param liquidacion
	 *           the liquidacion to set
	 */
	public void setLiquidacion(final List<DetalleLiquidacionVehiculos> liquidacion)
	{
		this.liquidacion = liquidacion;
	}
	/**
	 * @return the info_declara
	 */
	public DetalleInfoDeclaraVehiculos getInfo_declara()
	{
		return info_declara;
	}

	/**
	 * @param info_declara
	 *           the info_declara to set
	 */
	public void setInfo_declara(final DetalleInfoDeclaraVehiculos info_declara)
	{
		this.info_declara = info_declara;
	}

	/**
	 * @return the marcas
	 */
	public List<DetalleMarcas> getMarcas()
	{
		return marcas;
	}

	/**
	 * @param marcas
	 *           the marcas to set
	 */
	public void setMarcas(final List<DetalleMarcas> marcas)
	{
		this.marcas = marcas;
	}






}

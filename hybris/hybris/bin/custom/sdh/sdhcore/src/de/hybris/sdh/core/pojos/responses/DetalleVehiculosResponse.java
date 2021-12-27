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
	private List<JuridicosVehiculos> datosJuridicos;
	private List<DetalleMarcasVehiculos> marcas;
	private List<DetalleLiquidacionVehiculos> liquidacion;
	private DetalleInfoDeclaraVehiculos info_declara;
	private String checkAporte;
	private String fechaNotif;

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
	public List<JuridicosVehiculos> getDatosJuridicos()
	{
		return datosJuridicos;
	}

	/**
	 * @param datosJuridicos
	 *           the datosJuridicos to set
	 */
	public void setDatosJuridicos(final List<JuridicosVehiculos> datosJuridicos)
	{
		this.datosJuridicos = datosJuridicos;
	}

	/**
	 * @return the marcas
	 */
	public List<DetalleMarcasVehiculos> getMarcas()
	{
		return marcas;
	}

	/**
	 * @param marcas
	 *           the marcas to set
	 */
	public void setMarcas(final List<DetalleMarcasVehiculos> marcas)
	{
		this.marcas = marcas;
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
	 * @return the checkAporte
	 */
	public String getCheckAporte()
	{
		return checkAporte;
	}

	/**
	 * @param checkAporte
	 *           the checkAporte to set
	 */
	public void setCheckAporte(final String checkAporte)
	{
		this.checkAporte = checkAporte;
	}

	/**
	 * @return the fechaNotif
	 */
	public String getFechaNotif()
	{
		return fechaNotif;
	}

	/**
	 * @param fechaNotif
	 *           the fechaNotif to set
	 */
	public void setFechaNotif(final String fechaNotif)
	{
		this.fechaNotif = fechaNotif;
	}


}

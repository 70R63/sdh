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
	private String idServicio;
	private String idEstado;
	private String watts;
	private String clasicoAntig;
	private String tipoVeh;
	private String capacidadPas;
	private String capacidadTon;
	private String fechaCambio;
	private DetalleJuridicosVehiculos datosJuridicos;
	private List<DetalleMarcasVehiculos> marcas;
	private List<DetalleLiquidacionVehiculos> liquidacion;
	private DetalleInfoDeclaraVehiculos info_declara;

	/**
	 * @return the idServicio
	 */
	public String getIdServicio()
	{
		return idServicio;
	}

	/**
	 * @return the idEstado
	 */
	public String getIdEstado()
	{
		return idEstado;
	}

	/**
	 * @return the watts
	 */
	public String getWatts()
	{
		return watts;
	}

	/**
	 * @return the clasicoAntig
	 */
	public String getClasicoAntig()
	{
		return clasicoAntig;
	}

	/**
	 * @return the tipoVeh
	 */
	public String getTipoVeh()
	{
		return tipoVeh;
	}

	/**
	 * @return the capacidadPas
	 */
	public String getCapacidadPas()
	{
		return capacidadPas;
	}

	/**
	 * @return the capacidadTon
	 */
	public String getCapacidadTon()
	{
		return capacidadTon;
	}

	/**
	 * @return the fechaCambio
	 */
	public String getFechaCambio()
	{
		return fechaCambio;
	}

	/**
	 * @return the datosJuridicos
	 */
	public DetalleJuridicosVehiculos getDatosJuridicos()
	{
		return datosJuridicos;
	}

	/**
	 * @return the marcas
	 */
	public List<DetalleMarcasVehiculos> getMarcas()
	{
		return marcas;
	}

	/**
	 * @return the liquidacion
	 */
	public List<DetalleLiquidacionVehiculos> getLiquidacion()
	{
		return liquidacion;
	}

	/**
	 * @return the info_declara
	 */
	public DetalleInfoDeclaraVehiculos getInfo_declara()
	{
		return info_declara;
	}

	/**
	 * @param idServicio
	 *           the idServicio to set
	 */
	public void setIdServicio(final String idServicio)
	{
		this.idServicio = idServicio;
	}

	/**
	 * @param idEstado
	 *           the idEstado to set
	 */
	public void setIdEstado(final String idEstado)
	{
		this.idEstado = idEstado;
	}

	/**
	 * @param watts
	 *           the watts to set
	 */
	public void setWatts(final String watts)
	{
		this.watts = watts;
	}

	/**
	 * @param clasicoAntig
	 *           the clasicoAntig to set
	 */
	public void setClasicoAntig(final String clasicoAntig)
	{
		this.clasicoAntig = clasicoAntig;
	}

	/**
	 * @param tipoVeh
	 *           the tipoVeh to set
	 */
	public void setTipoVeh(final String tipoVeh)
	{
		this.tipoVeh = tipoVeh;
	}

	/**
	 * @param capacidadPas
	 *           the capacidadPas to set
	 */
	public void setCapacidadPas(final String capacidadPas)
	{
		this.capacidadPas = capacidadPas;
	}

	/**
	 * @param capacidadTon
	 *           the capacidadTon to set
	 */
	public void setCapacidadTon(final String capacidadTon)
	{
		this.capacidadTon = capacidadTon;
	}

	/**
	 * @param fechaCambio
	 *           the fechaCambio to set
	 */
	public void setFechaCambio(final String fechaCambio)
	{
		this.fechaCambio = fechaCambio;
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
	 * @param marcas
	 *           the marcas to set
	 */
	public void setMarcas(final List<DetalleMarcasVehiculos> marcas)
	{
		this.marcas = marcas;
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
	 * @param info_declara
	 *           the info_declara to set
	 */
	public void setInfo_declara(final DetalleInfoDeclaraVehiculos info_declara)
	{
		this.info_declara = info_declara;
	}




}

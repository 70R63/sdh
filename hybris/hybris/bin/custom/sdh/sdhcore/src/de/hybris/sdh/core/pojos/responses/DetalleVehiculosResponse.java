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
	//	private List<JuridicosVehiculos> datosJuridicos;
	//	private List<DetalleMarcasVehiculos> marcas;
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



	//	/*
	//	 * (non-Javadoc)
	//	 *
	//	 * @see java.lang.Object#toString()
	//	 */
	//	@Override
	//	public String toString()
	//	{
	//		return "ConsCasosResponse [det=" + detalle + ", datjur=" + datosJuridicos + ", marca=" + marcas + ", liq=" + liquidacion
	//				+ ", indec=" + info_declara + "]";
	//	}



}

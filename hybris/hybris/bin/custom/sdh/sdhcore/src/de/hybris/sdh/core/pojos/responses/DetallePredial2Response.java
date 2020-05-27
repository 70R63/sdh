/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class DetallePredial2Response
{
	private DetallePredial2Response_infopredio infopredio;
	private DetallePredial2Response_liquidacion liquidacion;
	private PredialEstLiquidacionPrivada liquidacionprivada;
	private List<DetallePredial2Response_marcas> marcas;
	private List<FirmanteResponsePredial2> firmantes;
	/**
	 * @return the infopredio
	 */
	public DetallePredial2Response_infopredio getInfopredio()
	{
		return infopredio;
	}
	/**
	 * @param infopredio the infopredio to set
	 */
	public void setInfopredio(final DetallePredial2Response_infopredio infopredio)
	{
		this.infopredio = infopredio;
	}
	/**
	 * @return the liquidacion
	 */
	public DetallePredial2Response_liquidacion getLiquidacion()
	{
		return liquidacion;
	}
	/**
	 * @param liquidacion the liquidacion to set
	 */
	public void setLiquidacion(final DetallePredial2Response_liquidacion liquidacion)
	{
		this.liquidacion = liquidacion;
	}
	/**
	 * @return the liquidacionprivada
	 */
	public PredialEstLiquidacionPrivada getLiquidacionprivada()
	{
		return liquidacionprivada;
	}
	/**
	 * @param liquidacionprivada the liquidacionprivada to set
	 */
	public void setLiquidacionprivada(final PredialEstLiquidacionPrivada liquidacionprivada)
	{
		this.liquidacionprivada = liquidacionprivada;
	}
	/**
	 * @return the marcas
	 */
	public List<DetallePredial2Response_marcas> getMarcas()
	{
		return marcas;
	}
	/**
	 * @param marcas the marcas to set
	 */
	public void setMarcas(final List<DetallePredial2Response_marcas> marcas)
	{
		this.marcas = marcas;
	}

	/**
	 * @return the firmantes
	 */
	public List<FirmanteResponsePredial2> getFirmantes()
	{
		return firmantes;
	}
	/**
	 * @param firmantes the firmantes to set
	 */
	public void setFirmantes(final List<FirmanteResponsePredial2> firmantes)
	{
		this.firmantes = firmantes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetallePredial2Response [infopredio=" + infopredio + ", liquidacion=" + liquidacion + ", liquidacionprivada="
				+ liquidacionprivada + ", marcas=" + marcas + ", firmantes=" + firmantes + "]";
	}


}

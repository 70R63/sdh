/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;



/**
 * @author hybris
 *
 */
public class CalculoPredialResponse
{
	private String numFrom;
	private CalculoPredialLiqPriv liquidacionPrivada;
	private List<CalPredialErrores> Errores;

	/**
	 * @return the numFrom
	 */
	public String getNumFrom()
	{
		return numFrom;
	}

	/**
	 * @param numFrom
	 *           the numFrom to set
	 */
	@JsonSetter("NumFrom")
	public void setNumFrom(final String numFrom)
	{
		this.numFrom = numFrom;
	}


	/**
	 * @return the liquidacionPrivada
	 */
	public CalculoPredialLiqPriv getLiquidacionPrivada()
	{
		return liquidacionPrivada;
	}

	/**
	 * @param liquidacionPrivada
	 *           the liquidacionPrivada to set
	 */
	@JsonSetter("LiquidacionPrivada")
	public void setLiquidacionPrivada(final CalculoPredialLiqPriv liquidacionPrivada)
	{
		this.liquidacionPrivada = liquidacionPrivada;
	}

	/**
	 * @return the errores
	 */
	public List<CalPredialErrores> getErrores()
	{
		return Errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	@JsonSetter("Errores")
	public void setErrores(final List<CalPredialErrores> errores)
	{
		Errores = errores;
	}



}

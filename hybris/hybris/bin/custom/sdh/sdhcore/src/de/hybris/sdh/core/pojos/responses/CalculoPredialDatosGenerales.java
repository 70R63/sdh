/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author Federico Flores Dimas
 *
 */
public class CalculoPredialDatosGenerales
{
	private String numFrom;
	private CalculoPredialLiqPriv liquidacionPrivada;
	private CalculoPredialDatosGenerales estrDatosGenerales;
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
	@JsonProperty("NumFrom")
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
	@JsonProperty("LiquidacionPrivada")
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
	@JsonProperty("Errores")
	public void setErrores(final List<CalPredialErrores> errores)
	{
		Errores = errores;
	}



}

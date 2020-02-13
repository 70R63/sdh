/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class DetalleLiquidacionVehiculos
{
	private String anio;
	private String avaluo;
	private String tarifa;
	private String claseSDH;

	/**
	 * @return the anio
	 */
	public String getAnio()
	{
		return anio;
	}

	/**
	 * @return the avaluo
	 */
	public String getAvaluo()
	{
		return avaluo;
	}

	/**
	 * @return the tarifa
	 */
	public String getTarifa()
	{
		return tarifa;
	}

	/**
	 * @param anio
	 *           the anio to set
	 */
	public void setAnio(final String anio)
	{
		this.anio = anio;
	}

	/**
	 * @param avaluo
	 *           the avaluo to set
	 */
	public void setAvaluo(final String avaluo)
	{
		this.avaluo = avaluo;
	}

	/**
	 * @param tarifa
	 *           the tarifa to set
	 */
	public void setTarifa(final String tarifa)
	{
		this.tarifa = tarifa;
	}


	public String getClaseSDH() {
		return claseSDH;
	}

	public void setClaseSDH(String claseSDH) {
		this.claseSDH = claseSDH;
	}
}

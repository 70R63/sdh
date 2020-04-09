/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class CalPredialLiqPriv
{
	private String aporteVoluntario;
	private String proyecto;
	private String autoavaluo;



	/**
	 * @return the aporteVoluntario
	 */
	public String getAporteVoluntario()
	{
		return aporteVoluntario;
	}



	/**
	 * @param aporteVoluntario
	 *           the aporteVoluntario to set
	 */
	@JsonProperty("AporteVoluntario")
	public void setAporteVoluntario(final String aporteVoluntario)
	{
		this.aporteVoluntario = aporteVoluntario;
	}



	/**
	 * @return the proyecto
	 */
	public String getProyecto()
	{
		return proyecto;
	}



	/**
	 * @param proyecto
	 *           the proyecto to set
	 */
	@JsonProperty("Proyecto")
	public void setProyecto(final String proyecto)
	{
		this.proyecto = proyecto;
	}



	/**
	 * @return the autoavaluo
	 */

	public String getAutoavaluo()
	{
		return autoavaluo;
	}



	/**
	 * @param autoavaluo
	 *           the autoavaluo to set
	 */
	@JsonProperty("Autoavaluo")
	public void setAutoavaluo(final String autoavaluo)
	{
		this.autoavaluo = autoavaluo;
	}



	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();


		stringBuilder.append("{");
		stringBuilder
				.append("\"AporteVoluntario\":\"" + (this.getAporteVoluntario() != null ? this.getAporteVoluntario() : "") + "\",");
		stringBuilder.append("\"Proyecto\":\"" + (this.getProyecto() != null ? this.getProyecto() : "") + "\",");
		stringBuilder.append("\"Autoavaluo\":\"" + (this.getAutoavaluo() != null ? this.getAutoavaluo() : "") + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}


}

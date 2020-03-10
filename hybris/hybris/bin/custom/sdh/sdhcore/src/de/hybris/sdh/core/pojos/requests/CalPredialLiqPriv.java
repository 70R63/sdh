/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class CalPredialLiqPriv
{
	private String AporteVoluntario;
	private String Proyecto;
	private String Autoavaluo;

	/**
	 * @return the aporteVoluntario
	 */
	public String getAporteVoluntario()
	{
		return AporteVoluntario;
	}

	/**
	 * @param aporteVoluntario
	 *           the aporteVoluntario to set
	 */
	public void setAporteVoluntario(final String aporteVoluntario)
	{
		AporteVoluntario = aporteVoluntario;
	}

	/**
	 * @return the proyecto
	 */
	public String getProyecto()
	{
		return Proyecto;
	}

	/**
	 * @param proyecto
	 *           the proyecto to set
	 */
	public void setProyecto(final String proyecto)
	{
		Proyecto = proyecto;
	}

	/**
	 * @return the autoavaluo
	 */
	public String getAutoavaluo()
	{
		return Autoavaluo;
	}

	/**
	 * @param autoavaluo
	 *           the autoavaluo to set
	 */
	public void setAutoavaluo(final String autoavaluo)
	{
		Autoavaluo = autoavaluo;
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

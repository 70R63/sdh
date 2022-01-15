/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Praxis
 *
 */
public class CalBasesPresuntas
{
	private String usoSuelo;
	private String destinoHacendario;
	private String actividadEconomica;
	private String predioHorizontal;
	private String baseGravableCalc;
	private String caracteristica;
	private String areaConstruida;
	private String areaTerreno;
	private String confirmaBGFinal;

	/**
	 * @return the usoSuelo
	 */
	public String getUsoSuelo()
	{
		return usoSuelo;
	}

	/**
	 * @param usoSuelo
	 *           the usoSuelo to set
	 */
	@JsonSetter("UsoSuelo")
	public void setUsoSuelo(final String usoSuelo)
	{
		this.usoSuelo = usoSuelo;
	}

	/**
	 * @return the destinoHacendario
	 */
	public String getDestinoHacendario()
	{
		return destinoHacendario;
	}

	/**
	 * @param destinoHacendario
	 *           the destinoHacendario to set
	 */
	@JsonSetter("DestinoHacendario")
	public void setDestinoHacendario(final String destinoHacendario)
	{
		this.destinoHacendario = destinoHacendario;
	}

	/**
	 * @return the actividadEconomica
	 */
	public String getActividadEconomica()
	{
		return actividadEconomica;
	}

	/**
	 * @param actividadEconomica
	 *           the actividadEconomica to set
	 */
	@JsonSetter("ActividadEconomica")
	public void setActividadEconomica(final String actividadEconomica)
	{
		this.actividadEconomica = actividadEconomica;
	}

	/**
	 * @return the predioHorizontal
	 */
	public String getPredioHorizontal()
	{
		return predioHorizontal;
	}

	/**
	 * @param predioHorizontal
	 *           the predioHorizontal to set
	 */
	@JsonSetter("PredioHorizontal")
	public void setPredioHorizontal(final String predioHorizontal)
	{
		this.predioHorizontal = predioHorizontal;
	}

	/**
	 * @return the baseGravableCalc
	 */
	public String getBaseGravableCalc()
	{
		return baseGravableCalc;
	}

	/**
	 * @param baseGravableCalc
	 *           the baseGravableCalc to set
	 */
	@JsonSetter("BaseGravableCalc")
	public void setBaseGravableCalc(final String baseGravableCalc)
	{
		this.baseGravableCalc = baseGravableCalc;
	}

	/**
	 * @return the caracteristica
	 */
	public String getCaracteristica()
	{
		return caracteristica;
	}

	/**
	 * @param caracteristica
	 *           the caracteristica to set
	 */
	@JsonSetter("Caracteristica")
	public void setCaracteristica(final String caracteristica)
	{
		this.caracteristica = caracteristica;
	}

	/**
	 * @return the areaConstruida
	 */
	public String getAreaConstruida()
	{
		return areaConstruida;
	}

	/**
	 * @param areaConstruida
	 *           the areaConstruida to set
	 */
	@JsonSetter("AreaConstruida")
	public void setAreaConstruida(final String areaConstruida)
	{
		this.areaConstruida = areaConstruida;
	}

	/**
	 * @return the areaTerreno
	 */
	public String getAreaTerreno()
	{
		return areaTerreno;
	}

	/**
	 * @param areaTerreno
	 *           the areaTerreno to set
	 */
	@JsonSetter("AreaTerreno")
	public void setAreaTerreno(final String areaTerreno)
	{
		this.areaTerreno = areaTerreno;
	}

	/**
	 * @return the confirmaBGFinal
	 */
	public String getConfirmaBGFinal()
	{
		return confirmaBGFinal;
	}

	/**
	 * @param confirmaBGFinal
	 *           the confirmaBGFinal to set
	 */
	@JsonSetter("ConfirmaBGFinal")
	public void setConfirmaBGFinal(final String confirmaBGFinal)
	{
		this.confirmaBGFinal = confirmaBGFinal;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"UsoSuelo\":\"" + (this.getUsoSuelo() != null ? this.getUsoSuelo() : "") + "\",");
		stringBuilder.append(
				"\"DestinoHacendario\":\"" + (this.getDestinoHacendario() != null ? this.getDestinoHacendario() : "") + "\",");
		stringBuilder.append(
				"\"ActividadEconomica\":\"" + (this.getActividadEconomica() != null ? this.getActividadEconomica() : "") + "\",");
		stringBuilder
				.append("\"PredioHorizontal\":\"" + (this.getPredioHorizontal() != null ? this.getPredioHorizontal() : "") + "\",");
		stringBuilder
				.append("\"BaseGravableCalc\":\"" + (this.getBaseGravableCalc() != null ? this.getBaseGravableCalc() : "") + "\",");
		stringBuilder.append("\"Caracteristica\":\"" + (this.getCaracteristica() != null ? this.getCaracteristica() : "") + "\",");
		stringBuilder.append("\"AreaConstruida\":\"" + (this.getAreaConstruida() != null ? this.getAreaConstruida() : "") + "\",");
		stringBuilder.append("\"AreaTerreno\":\"" + (this.getAreaTerreno() != null ? this.getAreaTerreno() : "") + "\",");
		stringBuilder
				.append("\"ConfirmaBGFinal\":\"" + (this.getConfirmaBGFinal() != null ? this.getConfirmaBGFinal() : "") + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();

	}




}

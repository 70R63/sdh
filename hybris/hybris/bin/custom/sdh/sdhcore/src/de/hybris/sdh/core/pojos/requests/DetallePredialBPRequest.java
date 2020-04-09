/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class DetallePredialBPRequest
{
	private String numBP;
	private String chip;
	private String anioGravable;
	private String areaConstruida;
	private String areaTerrenoCatastro;
	private String caracterizacionPredio;
	private String propiedadHorizontal;
	private String destinoHacendario;

	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the chip
	 */
	public String getChip()
	{
		return chip;
	}

	/**
	 * @param chip
	 *           the chip to set
	 */
	public void setChip(final String chip)
	{
		this.chip = chip;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		this.anioGravable = anioGravable;
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
	public void setAreaConstruida(final String areaConstruida)
	{
		this.areaConstruida = areaConstruida;
	}

	/**
	 * @return the areaTerrenoCatastro
	 */
	public String getAreaTerrenoCatastro()
	{
		return areaTerrenoCatastro;
	}

	/**
	 * @param areaTerrenoCatastro
	 *           the areaTerrenoCatastro to set
	 */
	public void setAreaTerrenoCatastro(final String areaTerrenoCatastro)
	{
		this.areaTerrenoCatastro = areaTerrenoCatastro;
	}

	/**
	 * @return the caracterizacionPredio
	 */
	public String getCaracterizacionPredio()
	{
		return caracterizacionPredio;
	}

	/**
	 * @param caracterizacionPredio
	 *           the caracterizacionPredio to set
	 */
	public void setCaracterizacionPredio(final String caracterizacionPredio)
	{
		this.caracterizacionPredio = caracterizacionPredio;
	}

	/**
	 * @return the propiedadHorizontal
	 */
	public String getPropiedadHorizontal()
	{
		return propiedadHorizontal;
	}

	/**
	 * @param propiedadHorizontal
	 *           the propiedadHorizontal to set
	 */
	public void setPropiedadHorizontal(final String propiedadHorizontal)
	{
		this.propiedadHorizontal = propiedadHorizontal;
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
	public void setDestinoHacendario(final String destinoHacendario)
	{
		this.destinoHacendario = destinoHacendario;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"numBP\":\"", this.getNumBP(), "\","));
		stringBuilder.append(obtenerValorJson("\"chip\":\"", this.getChip(), "\","));
		stringBuilder.append(obtenerValorJson("\"anioGravable\":\"", this.getAnioGravable(), "\","));
		stringBuilder.append(obtenerValorJson("\"areaConstruida\":\"", this.getAreaConstruida(), "\","));
		stringBuilder.append(obtenerValorJson("\"areaTerrenoCatastro\":\"", this.getAreaTerrenoCatastro(), "\","));
		stringBuilder.append(obtenerValorJson("\"caracterizacionPredio\":\"", this.getCaracterizacionPredio(), "\","));
		stringBuilder.append(obtenerValorJson("\"propiedadHorizontal\":\"", this.getPropiedadHorizontal(), "\","));
		stringBuilder.append(obtenerValorJson("\"destinoHacendario\":\"", this.getDestinoHacendario(), "\""));
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}



}

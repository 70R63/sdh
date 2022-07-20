/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author MTorres
 *
 */
public class RetencionesPracticadasConsRequest
{
	private String numBP;
	private String anogavable;

	/**
	 * @return the numBP
	 */
	@JsonGetter("NumBP")
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	@JsonSetter("NumBP")
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the anogavable
	 */
	@JsonGetter("Anogavable")
	public String getAnogavable()
	{
		return anogavable;
	}

	/**
	 * @param anogavable
	 *           the anogavable to set
	 */
	@JsonSetter("Anogavable")
	public void setAnogavable(final String anogavable)
	{
		this.anogavable = anogavable;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"NumBP\":\"", this.getNumBP(), "\","));
		stringBuilder.append(obtenerValorJson("\"Anogavable\":\"", this.getAnogavable(), "\""));
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

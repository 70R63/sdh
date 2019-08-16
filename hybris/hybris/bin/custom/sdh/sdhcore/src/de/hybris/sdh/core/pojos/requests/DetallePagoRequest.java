/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class DetallePagoRequest
{
	private String numBP;
	private String clavePeriodo;
	private String numObjeto;
	private String anticipo;



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
	 * @return the clavePeriodo
	 */
	public String getClavePeriodo()
	{
		return clavePeriodo;
	}

	/**
	 * @param clavePeriodo
	 *           the clavePeriodo to set
	 */
	public void setClavePeriodo(final String clavePeriodo)
	{
		this.clavePeriodo = clavePeriodo;
	}

	/**
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
	}

	/**
	 * @return the anticipo
	 */
	public String getAnticipo()
	{
		return anticipo;
	}

	/**
	 * @param anticipo
	 *           the anticipo to set
	 */
	public void setAnticipo(final String anticipo)
	{
		this.anticipo = anticipo;
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
		stringBuilder.append(obtenerValorJson("\"clavePeriodo\":\"", this.getClavePeriodo(), "\","));
		stringBuilder.append(obtenerValorJson("\"numObjeto\":\"", this.getNumObjeto(), "\","));
		stringBuilder.append(obtenerValorJson("\"anticipo\":\"", this.getAnticipo(), "\""));
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

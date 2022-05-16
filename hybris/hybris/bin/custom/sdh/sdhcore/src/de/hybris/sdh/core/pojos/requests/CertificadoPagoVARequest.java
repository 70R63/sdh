/**
 *
 */
package de.hybris.sdh.core.pojos.requests;


/**
 * @author Praxis
 *
 */
public class CertificadoPagoVARequest
{
	private String numBP;
	private String referencia;
	private String numObjeto;





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
	 * @return the referencia
	 */
	public String getReferencia()
	{
		return referencia;
	}





	/**
	 * @param referencia
	 *           the referencia to set
	 */
	public void setReferencia(final String referencia)
	{
		this.referencia = referencia;
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





	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"NumBP\":\"", numBP, "\","));
		stringBuilder.append(obtenerValorJson("\"Referencia\":\"", referencia, "\","));
		stringBuilder.append(obtenerValorJson("\"numObjeto\":\"", numObjeto, "\""));
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

/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class DescargaFacturaRequest
{
	private String numBP;
	private String anoGravable;
	private String numObjeto;
	private String tipoOperacion;


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
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}

	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
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
	 * @return the tipoOperacion
	 */
	public String getTipoOperacion()
	{
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion
	 *           the tipoOperacion to set
	 */
	public void setTipoOperacion(final String tipoOperacion)
	{
		this.tipoOperacion = tipoOperacion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"numBP\":\"", this.getNumBP(), "\","));
		stringBuilder.append(obtenerValorJson("\"anoGravable\":\"", this.getAnoGravable(), "\","));
		stringBuilder.append(obtenerValorJson("\"numObjeto\":\"", this.getNumObjeto(), "\","));
		stringBuilder.append(obtenerValorJson("\"tipoOperacion\":\"", this.getTipoOperacion(), "\""));
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

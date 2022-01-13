/**
 *
 */
package de.hybris.sdh.core.pojos.requests;


import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Praxis
 *
 */
public class FacturacionPagosRequest
{
	private String numbp;
	private String clavePeriodo;
	private String numObjeto;

	/**
	 * @return the numbp
	 */
	public String getNumbp()
	{
		return numbp;
	}

	/**
	 * @param numbp
	 *           the numbp to set
	 */
	@JsonSetter("numBP")
	public void setNumbp(final String numbp)
	{
		this.numbp = numbp;
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


	@Override
	public String toString()
	{

		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumbp() + "\",");
		stringBuilder.append("\"clavePeriodo\":\"" + this.getClavePeriodo() + "\",");
		stringBuilder.append("\"numObjeto\":\"" + this.getNumObjeto() + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}





}

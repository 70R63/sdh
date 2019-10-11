/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hybris
 *
 */
public class GeneraDeclaracionRequest
{

	private String numForm;
	private String tipo_id;
	private String num_id;

	/**
	 * @return the numForm
	 */
	public String getNumForm()
	{
		return numForm;
	}

	/**
	 * @param numForm
	 *           the numForm to set
	 */
	public void setNumForm(final String numForm)
	{
		this.numForm = numForm;
	}

	/**
	 * @return the tipo_id
	 */
	public String getTipo_id()
	{
		return tipo_id;
	}

	/**
	 * @param tipo_id
	 *           the tipo_id to set
	 */
	public void setTipo_id(final String tipo_id)
	{
		this.tipo_id = tipo_id;
	}

	/**
	 * @return the num_id
	 */
	public String getNum_id()
	{
		return num_id;
	}

	/**
	 * @param num_id
	 *           the num_id to set
	 */
	public void setNum_id(final String num_id)
	{
		this.num_id = num_id;
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
		stringBuilder.append("\"numForm\":\"" + ((StringUtils.isBlank(this.getNumForm())) ? "" : this.getNumForm()) + "\",");
		stringBuilder.append("\"tipo_id\":\"" + ((StringUtils.isBlank(this.getTipo_id())) ? "" : this.getTipo_id()) + "\",");
		stringBuilder.append("\"num_id\":\"" + ((StringUtils.isBlank(this.getNum_id())) ? "" : this.getNum_id()) + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
}

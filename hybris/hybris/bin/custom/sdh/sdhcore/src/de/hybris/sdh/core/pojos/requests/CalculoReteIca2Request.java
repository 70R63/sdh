/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;


/**
 * @author Federico Flores Dimas
 *
 */
public class CalculoReteIca2Request
{

	private String partner;
	private String formulario;


	public String getPartner()
	{
		return partner;
	}

	public void setPartner(final String partner)
	{
		this.partner = partner;
	}

	public String getFormulario()
	{
		return formulario;
	}

	public void setFormulario(final String formulario)
	{
		this.formulario = formulario;
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
		stringBuilder.append("\"partner\":\"" + ((StringUtils.isBlank(this.getPartner())) ? "" : this.getPartner()) + "\",");
		stringBuilder
				.append("\"formulario\":\"" + ((StringUtils.isBlank(this.getFormulario())) ? "" : this.getFormulario()) + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}

}

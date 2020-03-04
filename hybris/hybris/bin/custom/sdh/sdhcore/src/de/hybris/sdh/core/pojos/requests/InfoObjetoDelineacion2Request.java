/**
 *
 */
package de.hybris.sdh.core.pojos.requests;


/**
 * @author Federico Flores Dimas
 *
 */
public class InfoObjetoDelineacion2Request
{
	private String partner;
	private String formulario;

	/**
	 * @return the partner
	 */
	public String getPartner()
	{
		return partner;
	}

	/**
	 * @param partner
	 *           the partner to set
	 */
	public void setPartner(final String partner)
	{
		this.partner = partner;
	}

	/**
	 * @return the formulario
	 */
	public String getFormulario()
	{
		return formulario;
	}

	/**
	 * @param formulario
	 *           the formulario to set
	 */
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
		stringBuilder.append("\"partner\":\"" + this.getPartner() + "\",");
		stringBuilder.append("\"formulario\":\"" + this.getFormulario() + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

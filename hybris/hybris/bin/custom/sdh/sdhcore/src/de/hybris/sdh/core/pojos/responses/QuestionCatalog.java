/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class QuestionCatalog
{
	private String idPreg;
	private String textoPreg;

	/**
	 * @return the idPreg
	 */
	public String getIdPreg()
	{
		return idPreg;
	}

	/**
	 * @param idPreg
	 *           the idPreg to set
	 */
	public void setIdPreg(final String idPreg)
	{
		this.idPreg = idPreg;
	}

	/**
	 * @return the textoPreg
	 */
	public String getTextoPreg()
	{
		return textoPreg;
	}

	/**
	 * @param textoPreg
	 *           the textoPreg to set
	 */
	public void setTextoPreg(final String textoPreg)
	{
		this.textoPreg = textoPreg;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"idPreg\":\"" + this.getIdPreg() + "\",");
		stringBuilder.append("\"textoPreg\":\"" + this.getTextoPreg() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
}

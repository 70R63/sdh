/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Praxis
 *
 */
public class RelacionPagosRequest
{
	private String obKey;

	/**
	 * @return the obKey
	 */
	public String getObKey()
	{
		return obKey;
	}

	/**
	 * @param obKey
	 *           the obKey to set
	 */
	public void setObKey(final String obKey)
	{
		this.obKey = obKey;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"ip_psobkey\":\"" + this.getObKey() + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

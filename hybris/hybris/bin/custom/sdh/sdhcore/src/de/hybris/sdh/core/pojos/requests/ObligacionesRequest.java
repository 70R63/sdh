/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class ObligacionesRequest
{
	private String bp;





	/**
	 * @return the bp
	 */
	public String getBp()
	{
		return bp;
	}





	/**
	 * @param bp
	 *           the bp to set
	 */
	public void setBp(final String bp)
	{
		this.bp = bp;
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
		stringBuilder.append("\"bp\":\"" + this.getBp() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
}

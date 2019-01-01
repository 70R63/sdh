/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class ValidaContribuyenteRequest
{
	private String numid;
	private String tipoid;

	/**
	 * @return the numid
	 */
	public String getNumid()
	{
		return numid;
	}

	/**
	 * @param numid
	 *           the numid to set
	 */
	public void setNumid(final String numid)
	{
		this.numid = numid;
	}

	/**
	 * @return the tipoid
	 */
	public String getTipoid()
	{
		return tipoid;
	}

	/**
	 * @param tipoid
	 *           the tipoid to set
	 */
	public void setTipoid(final String tipoid)
	{
		this.tipoid = tipoid;
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
		stringBuilder.append("\"documentos\":{");
		stringBuilder.append("\"numid\":\"" + this.getNumid() + "\",");
		stringBuilder.append("\"tipoid\":\"" + this.getTipoid() + "\"");
		stringBuilder.append("}");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}



}

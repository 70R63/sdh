/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hybris
 *
 */
public class ValidaContribuyenteRequest
{
	private String numid;
	private String tipoid;
	private String expeditionDate;
	private String fechExp;

	/**
	 * @return the expeditionDate
	 */
	public String getExpeditionDate()
	{
		return expeditionDate;
	}

	/**
	 * @param expeditionDate
	 *           the expeditionDate to set
	 */
	public void setExpeditionDate(final String expeditionDate)
	{
		this.expeditionDate = expeditionDate;
	}

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

	public String getFechExp() { return fechExp; }

	public void setFechExp(String fechExp) { this.fechExp = fechExp; }

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
		stringBuilder.append("\"tipoid\":\"" + this.getTipoid() + "\",");
		stringBuilder.append("\"fechExp\":\"" + (StringUtils.isBlank(this.getExpeditionDate())?"":this.getExpeditionDate()) + "\"");
		stringBuilder.append("}");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}



}

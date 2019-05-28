/**
 *
 */
package de.hybris.sdh.core.credibanco;

/**
 * @author edson.roa
 *
 */
public class Payload
{
	private String jti;
	private String iss;
	private String iat;
	private String sub;

	/**
	 *
	 */
	public Payload()
	{
	}

	/**
	 * @param jti
	 * @param iss
	 * @param iat
	 * @param sub
	 */
	public Payload(final String jti, final String iss, final String iat, final String sub)
	{
		this.jti = jti;
		this.iss = iss;
		this.iat = iat;
		this.sub = sub;
	}

	/**
	 * @return the jti
	 */
	public String getJti()
	{
		return jti;
	}

	/**
	 * @param jti
	 *           the jti to set
	 */
	public void setJti(final String jti)
	{
		this.jti = jti;
	}

	/**
	 * @return the iss
	 */
	public String getIss()
	{
		return iss;
	}

	/**
	 * @param iss
	 *           the iss to set
	 */
	public void setIss(final String iss)
	{
		this.iss = iss;
	}

	/**
	 * @return the iat
	 */
	public String getIat()
	{
		return iat;
	}

	/**
	 * @param iat
	 *           the iat to set
	 */
	public void setIat(final String iat)
	{
		this.iat = iat;
	}

	/**
	 * @return the sub
	 */
	public String getSub()
	{
		return sub;
	}

	/**
	 * @param sub
	 *           the sub to set
	 */
	public void setSub(final String sub)
	{
		this.sub = sub;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Payload [jti=" + jti + ", iss=" + iss + ", iat=" + iat + ", sub=" + sub + "]";
	}


}

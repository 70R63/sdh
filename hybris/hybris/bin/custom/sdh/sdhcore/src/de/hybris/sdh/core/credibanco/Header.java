/**
 *
 */
package de.hybris.sdh.core.credibanco;

/**
 * @author edson.roa
 *
 */
public class Header
{
	private String typ;
	private String alg;

	/**
	 *
	 */
	public Header()
	{
	}

	/**
	 * @param typ
	 * @param alg
	 */
	public Header(final String typ, final String alg)
	{
		this.typ = typ;
		this.alg = alg;
	}

	/**
	 * @return the typ
	 */
	public String getTyp()
	{
		return typ;
	}

	/**
	 * @param typ
	 *           the typ to set
	 */
	public void setTyp(final String typ)
	{
		this.typ = typ;
	}

	/**
	 * @return the alg
	 */
	public String getAlg()
	{
		return alg;
	}

	/**
	 * @param alg
	 *           the alg to set
	 */
	public void setAlg(final String alg)
	{
		this.alg = alg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Header [typ=" + typ + ", alg=" + alg + "]";
	}



}

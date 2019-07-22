/**
 *
 */
package de.hybris.sdh.core.credibanco;

/**
 * @author edson.roa
 *
 */
public class ResultTransactionRequest
{
	private String nus;
	private String internalCode;


	/**
	 * @param nus
	 * @param internalCode
	 */
	public ResultTransactionRequest(final String nus)
	{
		this.nus = nus;
	}

	/**
	 * @param nus
	 * @param internalCode
	 */
	public ResultTransactionRequest(final String nus, final String internalCode)
	{
		this.nus = nus;
		this.internalCode = internalCode;
	}

	/**
	 * @return the nus
	 */
	public String getNus()
	{
		return nus;
	}

	/**
	 * @param nus
	 *           the nus to set
	 */
	public void setNus(final String nus)
	{
		this.nus = nus;
	}

	/**
	 * @return the internalCode
	 */
	public String getInternalCode()
	{
		return internalCode;
	}

	/**
	 * @param internalCode
	 *           the internalCode to set
	 */
	public void setInternalCode(final String internalCode)
	{
		this.internalCode = internalCode;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ResultTransactionRequest [nus=" + nus + ", internalCode=" + internalCode + ", getNus()=" + getNus()
				+ ", getInternalCode()=" + getInternalCode() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



}

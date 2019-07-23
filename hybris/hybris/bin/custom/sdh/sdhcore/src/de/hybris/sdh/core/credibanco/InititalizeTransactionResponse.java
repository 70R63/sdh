/**
 *
 */
package de.hybris.sdh.core.credibanco;

/**
 * @author edson.roa
 *
 */
public class InititalizeTransactionResponse
{
	private String returnCode;
	private String paymentRoute;
	private String internalCode;
	private String description;

	/**
	 * @return the returnCode
	 */
	public String getReturnCode()
	{
		return returnCode;
	}

	/**
	 * @param returnCode
	 *           the returnCode to set
	 */
	public void setReturnCode(final String returnCode)
	{
		this.returnCode = returnCode;
	}

	/**
	 * @return the paymentRoute
	 */
	public String getPaymentRoute()
	{
		return paymentRoute;
	}

	/**
	 * @param paymentRoute
	 *           the paymentRoute to set
	 */
	public void setPaymentRoute(final String paymentRoute)
	{
		this.paymentRoute = paymentRoute;
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

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *           the description to set
	 */
	public void setDescription(final String description)
	{
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CredibancoInititalizeTransactionResponse [returnCode=" + returnCode + ", paymentRoute=" + paymentRoute
				+ ", internalCode="
				+ internalCode + ", description=" + description + "]";
	}



}

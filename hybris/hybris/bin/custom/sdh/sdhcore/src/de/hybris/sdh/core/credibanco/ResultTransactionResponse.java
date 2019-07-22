/**
 *
 */
package de.hybris.sdh.core.credibanco;

/**
 * @author edson.roa
 *
 */
public class ResultTransactionResponse
{
	private String nus;
	private String status;
	private String description;
	private String value;
	private String transactionDate;
	private String transactionHour;
	private String approvalNumber;
	private String paymentMethod;

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
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *           the status to set
	 */
	public void setStatus(final String status)
	{
		this.status = status;
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

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *           the value to set
	 */
	public void setValue(final String value)
	{
		this.value = value;
	}

	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate()
	{
		return transactionDate;
	}

	/**
	 * @param transactionDate
	 *           the transactionDate to set
	 */
	public void setTransactionDate(final String transactionDate)
	{
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the transactionHour
	 */
	public String getTransactionHour()
	{
		return transactionHour;
	}

	/**
	 * @param transactionHour
	 *           the transactionHour to set
	 */
	public void setTransactionHour(final String transactionHour)
	{
		this.transactionHour = transactionHour;
	}

	/**
	 * @return the approvalNumber
	 */
	public String getApprovalNumber()
	{
		return approvalNumber;
	}

	/**
	 * @param approvalNumber
	 *           the approvalNumber to set
	 */
	public void setApprovalNumber(final String approvalNumber)
	{
		this.approvalNumber = approvalNumber;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod()
	{
		return paymentMethod;
	}

	/**
	 * @param paymentMethod
	 *           the paymentMethod to set
	 */
	public void setPaymentMethod(final String paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ResultTransactionResponse [nus=" + nus + ", status=" + status + ", description=" + description + ", value=" + value
				+ ", transactionDate=" + transactionDate + ", transactionHour=" + transactionHour + ", approvalNumber="
				+ approvalNumber + ", paymentMethod=" + paymentMethod + "]";
	}



}

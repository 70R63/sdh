/**
 *
 */
package de.hybris.sdh.core.pojos.requests.pse;

/**
 * @author edson.roa
 *
 */
public class ConstantConnectionData
{
	private String pseurl;
	private String ppeCode;
	private String bankCode;
	private String serviceCode;
	private String authCode;
	private String creditServiceCode;
	private String creditCompanyCode;
	private String companyAuthCode;

	/**
	 * @return the pseurl
	 */
	public String getPseurl()
	{
		return pseurl;
	}

	/**
	 * @param pseurl
	 *           the pseurl to set
	 */
	public void setPseurl(final String pseurl)
	{
		this.pseurl = pseurl;
	}

	/**
	 * @return the ppeCode
	 */
	public String getPpeCode()
	{
		return ppeCode;
	}

	/**
	 * @param ppeCode
	 *           the ppeCode to set
	 */
	public void setPpeCode(final String ppeCode)
	{
		this.ppeCode = ppeCode;
	}

	/**
	 * @return the bankCode
	 */
	public String getBankCode()
	{
		return bankCode;
	}

	/**
	 * @param bankCode
	 *           the bankCode to set
	 */
	public void setBankCode(final String bankCode)
	{
		this.bankCode = bankCode;
	}

	/**
	 * @return the serviceCode
	 */
	public String getServiceCode()
	{
		return serviceCode;
	}

	/**
	 * @param serviceCode
	 *           the serviceCode to set
	 */
	public void setServiceCode(final String serviceCode)
	{
		this.serviceCode = serviceCode;
	}

	/**
	 * @return the authCode
	 */
	public String getAuthCode()
	{
		return authCode;
	}

	/**
	 * @param authCode
	 *           the authCode to set
	 */
	public void setAuthCode(final String authCode)
	{
		this.authCode = authCode;
	}

	/**
	 * @return the creditServiceCode
	 */
	public String getCreditServiceCode()
	{
		return creditServiceCode;
	}

	/**
	 * @param creditServiceCode
	 *           the creditServiceCode to set
	 */
	public void setCreditServiceCode(final String creditServiceCode)
	{
		this.creditServiceCode = creditServiceCode;
	}

	/**
	 * @return the creditCompanyCode
	 */
	public String getCreditCompanyCode()
	{
		return creditCompanyCode;
	}

	/**
	 * @param creditCompanyCode
	 *           the creditCompanyCode to set
	 */
	public void setCreditCompanyCode(final String creditCompanyCode)
	{
		this.creditCompanyCode = creditCompanyCode;
	}

	/**
	 * @return the companyAuthCode
	 */
	public String getCompanyAuthCode()
	{
		return companyAuthCode;
	}

	/**
	 * @param companyAuthCode
	 *           the companyAuthCode to set
	 */
	public void setCompanyAuthCode(final String companyAuthCode)
	{
		this.companyAuthCode = companyAuthCode;
	}


}

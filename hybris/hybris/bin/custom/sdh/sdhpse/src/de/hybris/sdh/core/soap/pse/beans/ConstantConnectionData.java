package de.hybris.sdh.core.soap.pse.beans;

public class ConstantConnectionData {

	private String pseurl;
	private String ppeCode;
	private String bankCode;
	private String serviceCode;
	private String authCode;
	private String creditServiceCode;
	private String creditCompanyCode;
	private String companyAuthCode;
	private String entityUrl;

	public String getPseurl() {
		return pseurl;
	}
	public void setPseurl(final String pseurl) {
		this.pseurl = pseurl;
	}
	public String getPpeCode() {
		return ppeCode;
	}
	public void setPpeCode(final String ppeCode) {
		this.ppeCode = ppeCode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(final String bankCode) {
		this.bankCode = bankCode;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(final String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(final String authCode) {
		this.authCode = authCode;
	}
	public String getCreditServiceCode() {
		return creditServiceCode;
	}
	public void setCreditServiceCode(final String creditServiceCode) {
		this.creditServiceCode = creditServiceCode;
	}
	public String getCreditCompanyCode() {
		return creditCompanyCode;
	}
	public void setCreditCompanyCode(final String creditCompanyCode) {
		this.creditCompanyCode = creditCompanyCode;
	}
	public String getCompanyAuthCode() {
		return companyAuthCode;
	}
	public void setCompanyAuthCode(final String companyAuthCode) {
		this.companyAuthCode = companyAuthCode;
	}
	public String getEntityUrl()
	{
		return entityUrl;
	}
	public void setEntityUrl(final String entityUrl)
	{
		this.entityUrl = entityUrl;
	}

	@Override
	public String toString()
	{
		return "ConstantConnectionData [pseurl=" + pseurl + ", ppeCode=" + ppeCode + ", bankCode=" + bankCode + ", serviceCode="
				+ serviceCode + ", authCode=" + authCode + ", creditServiceCode=" + creditServiceCode + ", creditCompanyCode="
				+ creditCompanyCode + ", companyAuthCode=" + companyAuthCode + ", entityUrl=" + entityUrl + "]";
	}





}

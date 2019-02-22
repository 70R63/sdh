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
	
	public String getPseurl() {
		return pseurl;
	}
	public void setPseurl(String pseurl) {
		this.pseurl = pseurl;
	}
	public String getPpeCode() {
		return ppeCode;
	}
	public void setPpeCode(String ppeCode) {
		this.ppeCode = ppeCode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getCreditServiceCode() {
		return creditServiceCode;
	}
	public void setCreditServiceCode(String creditServiceCode) {
		this.creditServiceCode = creditServiceCode;
	}
	public String getCreditCompanyCode() {
		return creditCompanyCode;
	}
	public void setCreditCompanyCode(String creditCompanyCode) {
		this.creditCompanyCode = creditCompanyCode;
	}
	public String getCompanyAuthCode() {
		return companyAuthCode;
	}
	public void setCompanyAuthCode(String companyAuthCode) {
		this.companyAuthCode = companyAuthCode;
	}
	@Override
	public String toString() {
		return "ConstantConnectionData [pseurl=" + pseurl + ", ppeCode=" + ppeCode + ", bankCode=" + bankCode
				+ ", serviceCode=" + serviceCode + ", authCode=" + authCode + ", creditServiceCode=" + creditServiceCode
				+ ", creditCompanyCode=" + creditCompanyCode + ", companyAuthCode=" + companyAuthCode + "]";
	}
	
	

	
	
}

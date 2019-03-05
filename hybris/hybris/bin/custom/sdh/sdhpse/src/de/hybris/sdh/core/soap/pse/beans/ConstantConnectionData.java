package de.hybris.sdh.core.soap.pse.beans;

public class ConstantConnectionData {
<<<<<<< HEAD
	
=======

>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
	private String pseurl;
	private String ppeCode;
	private String bankCode;
	private String serviceCode;
	private String authCode;
	private String creditServiceCode;
	private String creditCompanyCode;
	private String companyAuthCode;
<<<<<<< HEAD
	
	public String getPseurl() {
		return pseurl;
	}
	public void setPseurl(String pseurl) {
=======
	private String entityUrl;

	public String getPseurl() {
		return pseurl;
	}
	public void setPseurl(final String pseurl) {
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
		this.pseurl = pseurl;
	}
	public String getPpeCode() {
		return ppeCode;
	}
<<<<<<< HEAD
	public void setPpeCode(String ppeCode) {
=======
	public void setPpeCode(final String ppeCode) {
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
		this.ppeCode = ppeCode;
	}
	public String getBankCode() {
		return bankCode;
	}
<<<<<<< HEAD
	public void setBankCode(String bankCode) {
=======
	public void setBankCode(final String bankCode) {
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
		this.bankCode = bankCode;
	}
	public String getServiceCode() {
		return serviceCode;
	}
<<<<<<< HEAD
	public void setServiceCode(String serviceCode) {
=======
	public void setServiceCode(final String serviceCode) {
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
		this.serviceCode = serviceCode;
	}
	public String getAuthCode() {
		return authCode;
	}
<<<<<<< HEAD
	public void setAuthCode(String authCode) {
=======
	public void setAuthCode(final String authCode) {
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
		this.authCode = authCode;
	}
	public String getCreditServiceCode() {
		return creditServiceCode;
	}
<<<<<<< HEAD
	public void setCreditServiceCode(String creditServiceCode) {
=======
	public void setCreditServiceCode(final String creditServiceCode) {
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
		this.creditServiceCode = creditServiceCode;
	}
	public String getCreditCompanyCode() {
		return creditCompanyCode;
	}
<<<<<<< HEAD
	public void setCreditCompanyCode(String creditCompanyCode) {
=======
	public void setCreditCompanyCode(final String creditCompanyCode) {
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
		this.creditCompanyCode = creditCompanyCode;
	}
	public String getCompanyAuthCode() {
		return companyAuthCode;
	}
<<<<<<< HEAD
	public void setCompanyAuthCode(String companyAuthCode) {
		this.companyAuthCode = companyAuthCode;
	}
	@Override
	public String toString() {
		return "ConstantConnectionData [pseurl=" + pseurl + ", ppeCode=" + ppeCode + ", bankCode=" + bankCode
				+ ", serviceCode=" + serviceCode + ", authCode=" + authCode + ", creditServiceCode=" + creditServiceCode
				+ ", creditCompanyCode=" + creditCompanyCode + ", companyAuthCode=" + companyAuthCode + "]";
	}
	
	

	
	
=======
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





>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
}

/**
 *
 */
package de.hybris.sdh.core.credibanco;

/**
 * @author edson.roa
 *
 */
public class InititalizeTransactionRequest
{
	private String nus;
	private String concept;
	private String description;
	private String personType;
	private String returnRoute;
	private String value;
	private String bankCode;
	private String tax;
	private String ref1;
	private String ref2;
	private String ref3;

	/**
	 *
	 */
	public InititalizeTransactionRequest()
	{
	}

	/**
	 * @param nus
	 * @param concept
	 * @param description
	 * @param personType
	 * @param returnRoute
	 * @param value
	 * @param tax
	 * @param ref1
	 * @param ref2
	 * @param ref3
	 */
	public InititalizeTransactionRequest(final String nus, final String concept, final String description, final String personType,
			final String returnRoute, final String value, final String tax, final String ref1, final String ref2, final String ref3,
			final String bankCode)
	{
		this.nus = nus;
		this.concept = concept;
		this.description = description;
		this.personType = personType;
		this.returnRoute = returnRoute;
		this.value = value;
		this.tax = tax;
		this.ref1 = ref1;
		this.ref2 = ref2;
		this.ref3 = ref3;
		this.bankCode = bankCode;

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
	 * @return the concept
	 */
	public String getConcept()
	{
		return concept;
	}

	/**
	 * @param concept
	 *           the concept to set
	 */
	public void setConcept(final String concept)
	{
		this.concept = concept;
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
	 * @return the personType
	 */
	public String getPersonType()
	{
		return personType;
	}

	/**
	 * @param personType
	 *           the personType to set
	 */
	public void setPersonType(final String personType)
	{
		this.personType = personType;
	}

	/**
	 * @return the returnRoute
	 */
	public String getReturnRoute()
	{
		return returnRoute;
	}

	/**
	 * @param returnRoute
	 *           the returnRoute to set
	 */
	public void setReturnRoute(final String returnRoute)
	{
		this.returnRoute = returnRoute;
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
	 * @return the tax
	 */
	public String getTax()
	{
		return tax;
	}

	/**
	 * @param tax
	 *           the tax to set
	 */
	public void setTax(final String tax)
	{
		this.tax = tax;
	}

	/**
	 * @return the ref1
	 */
	public String getRef1()
	{
		return ref1;
	}

	/**
	 * @param ref1
	 *           the ref1 to set
	 */
	public void setRef1(final String ref1)
	{
		this.ref1 = ref1;
	}

	/**
	 * @return the ref2
	 */
	public String getRef2()
	{
		return ref2;
	}

	/**
	 * @param ref2
	 *           the ref2 to set
	 */
	public void setRef2(final String ref2)
	{
		this.ref2 = ref2;
	}

	/**
	 * @return the ref3
	 */
	public String getRef3()
	{
		return ref3;
	}

	/**
	 * @param ref3
	 *           the ref3 to set
	 */
	public void setRef3(final String ref3)
	{
		this.ref3 = ref3;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "InititalizeTransactionRequest [nus=" + nus + ", concept=" + concept + ", description=" + description
				+ ", personType=" + personType + ", returnRoute=" + returnRoute + ", value=" + value + ", tax=" + tax + ", ref1="
				+ ref1 + ", ref2=" + ref2 + ", ref3=" + ref3 + "bankCode=" + bankCode + "]";
	}



}

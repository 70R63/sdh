/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author hybris
 *
 */
public class SendEmailResponse
{
	private String code;
	private String messgae;

	/**
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * @param code
	 *           the code to set
	 */
	@JsonSetter("EP_CODE")
	public void setCode(final String code)
	{
		this.code = code;
	}

	/**
	 * @return the messgae
	 */
	public String getMessgae()
	{
		return messgae;
	}

	/**
	 * @param messgae
	 *           the messgae to set
	 */
	@JsonSetter("EP_MESSAGE")
	public void setMessgae(final String messgae)
	{
		this.messgae = messgae;
	}





}

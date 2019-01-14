/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class ContribDireccion
{
	private String ADR_KIND;
	private String HOUSE_NUM1;
	private String STREET;
	private int POST_CODE;
	private String CITY1;
	private String COUNTRY;
	private int REGION;
	/**
	 *
	 */
	public ContribDireccion()
	{
		// XXX Auto-generated constructor stub
	}

	/**
	 * @return the sTREET
	 */
	public String getSTREET()
	{
		return STREET;
	}

	/**
	 * @param sTREET
	 *           the sTREET to set
	 */
	@JsonProperty("STREET")
	public void setSTREET(final String sTREET)
	{
		STREET = sTREET;
	}

	/**
	 * @return the pOST_CODE
	 */
	public int getPOST_CODE()
	{
		return POST_CODE;
	}

	/**
	 * @param pOST_CODE
	 *           the pOST_CODE to set
	 */
	@JsonProperty("POST_CODE")
	public void setPOST_CODE(final int pOST_CODE)
	{
		POST_CODE = pOST_CODE;
	}

	/**
	 * @return the cITY1
	 */
	public String getCITY1()
	{
		return CITY1;
	}

	/**
	 * @param cITY1
	 *           the cITY1 to set
	 */
	@JsonProperty("CITY1")
	public void setCITY1(final String cITY1)
	{
		CITY1 = cITY1;
	}

	/**
	 * @return the cOUNTRY
	 */
	public String getCOUNTRY()
	{
		return COUNTRY;
	}

	/**
	 * @param cOUNTRY
	 *           the cOUNTRY to set
	 */
	@JsonProperty("COUNTRY")
	public void setCOUNTRY(final String cOUNTRY)
	{
		COUNTRY = cOUNTRY;
	}

	/**
	 * @return the rEGION
	 */
	public int getREGION()
	{
		return REGION;
	}

	/**
	 * @param rEGION
	 *           the rEGION to set
	 */
	@JsonProperty("REGION")
	public void setREGION(final int rEGION)
	{
		REGION = rEGION;
	}

	/**
	 * @return the aDR_KIND
	 */
	public String getADR_KIND()
	{
		return ADR_KIND;
	}

	/**
	 * @param aDR_KIND
	 *           the aDR_KIND to set
	 */
	@JsonProperty("ADR_KIND")
	public void setADR_KIND(final String aDR_KIND)
	{
		ADR_KIND = aDR_KIND;
	}

	/**
	 * @return the hOUSE_NUM1
	 */
	public String getHOUSE_NUM1()
	{
		return HOUSE_NUM1;
	}

	/**
	 * @param hOUSE_NUM1
	 *           the hOUSE_NUM1 to set
	 */
	@JsonProperty("HOUSE_NUM1")
	public void setHOUSE_NUM1(final String hOUSE_NUM1)
	{
		HOUSE_NUM1 = hOUSE_NUM1;
	}



}

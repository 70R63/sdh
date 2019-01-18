/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class ContribRedSocial
{
	private String RED_SOCIAL;
	private String USUARIORED;

	/**
	 * @return the rED_SOCIAL
	 */
	public String getRED_SOCIAL()
	{
		return RED_SOCIAL;
	}

	/**
	 * @param rED_SOCIAL
	 *           the rED_SOCIAL to set
	 */
	@JsonProperty("RED_SOCIAL")
	public void setRED_SOCIAL(final String rED_SOCIAL)
	{
		RED_SOCIAL = rED_SOCIAL;
	}

	/**
	 * @return the uSUARIORED
	 */
	public String getUSUARIORED()
	{
		return USUARIORED;
	}

	/**
	 * @param uSUARIORED
	 *           the uSUARIORED to set
	 */
	@JsonProperty("USUARIORED")
	public void setUSUARIORED(final String uSUARIORED)
	{
		USUARIORED = uSUARIORED;
	}


}

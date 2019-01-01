/**
 *
 */
package de.hybris.sdh.core.event;

import de.hybris.platform.commerceservices.event.RegisterEvent;

/**
 * @author hybris
 *
 */
public class SDHRegistrationEvent extends RegisterEvent
{
	private String token;

	/**
	 * @return the token
	 */
	public String getToken()
	{
		return token;
	}

	/**
	 * @param token
	 *           the token to set
	 */
	public void setToken(final String token)
	{
		this.token = token;
	}



}

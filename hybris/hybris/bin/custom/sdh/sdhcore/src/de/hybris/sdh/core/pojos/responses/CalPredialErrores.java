/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class CalPredialErrores
{
	private String idError;
	private String descError;
	
	/**
	 * @return the idError
	 */
	public String getIdError()
	{
		return idError;
	}
	
	/**
	 * @param idError
	 *           the idError to set
	 */

	@JsonProperty("IdError")
	public void setIdError(final String idError)
	{
		this.idError = idError;
	}
	
	/**
	 * @return the descError
	 */
	public String getDescError()
	{
		return descError;
	}
	
	/**
	 * @param descError
	 *           the descError to set
	 */

	@JsonProperty("DescError")
	public void setDescError(final String descError)
	{
		this.descError = descError;
	}




}

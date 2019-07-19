/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class RopResponse
{

	private String stringFact;
	private List<ErrorEnWS> errores;
	
	/**
	 * @return the stringFact
	 */
	public String getStringFact()
	{
		return stringFact;
	}
	
	/**
	 * @param stringFact
	 *           the stringFact to set
	 */
	public void setStringFact(final String stringFact)
	{
		this.stringFact = stringFact;
	}
	/**
	 * @return the errores
	 */
	public List<ErrorEnWS> getErrores()
	{
		return errores;
	}
	
	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}




}

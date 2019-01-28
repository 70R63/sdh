/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class UpdateRitResponse
{
	private Boolean ritUpdated;
	private List<UpdateRitErrorResponse> errores;
	private String numBP;

	/**
	 * @return the ritUpdated
	 */
	public Boolean getRitUpdated()
	{
		return ritUpdated;
	}

	/**
	 * @param ritUpdated
	 *           the ritUpdated to set
	 */
	public void setRitUpdated(final Boolean ritUpdated)
	{
		this.ritUpdated = ritUpdated;
	}

	/**
	 * @return the errores
	 */
	public List<UpdateRitErrorResponse> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<UpdateRitErrorResponse> errores)
	{
		this.errores = errores;
	}

	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}



}

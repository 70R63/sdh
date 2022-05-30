/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author MTorres
 *
 */
public class RetencionesPracticadasConsRequest
{
	private String numBP;
	private String anogavable;
	
	/**
	 * @return the numBP
	 */
	@JsonGetter("NumBP")
	public String getNumBP()
	{
		return numBP;
	}
	
	/**
	 * @param numBP
	 *           the numBP to set
	 */
	@JsonSetter("NumBP")
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}
	
	/**
	 * @return the anogavable
	 */
	@JsonGetter("Anogavable")
	public String getAnogavable()
	{
		return anogavable;
	}
	
	/**
	 * @param anogavable
	 *           the anogavable to set
	 */
	@JsonSetter("Anogavable")
	public void setAnogavable(final String anogavable)
	{
		this.anogavable = anogavable;
	}




}

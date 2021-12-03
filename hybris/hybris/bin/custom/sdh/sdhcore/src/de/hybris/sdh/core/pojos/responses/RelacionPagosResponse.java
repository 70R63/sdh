/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;


public class RelacionPagosResponse
{

	private Relacionpagosrespons relacionpagosrespons;

	/**
	 * @return the relacionpagosrespons
	 */
	public Relacionpagosrespons getRelacionpagosrespons()
	{
		return relacionpagosrespons;
	}

	/**
	 * @param relacionpagosrespons
	 *           the relacionpagosrespons to set
	 */
	@JsonSetter("Relacionpagosrespons")
	public void setRelacionpagosrespons(final Relacionpagosrespons relacionpagosrespons)
	{
		this.relacionpagosrespons = relacionpagosrespons;
	}









}

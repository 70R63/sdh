/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class ObligacionesResponse
{
	private List<ObligacionesCabeceraPublicidad> header;

	/**
	 * @return the header
	 */
	public List<ObligacionesCabeceraPublicidad> getHeader()
	{
		return header;
	}

	/**
	 * @param header
	 *           the header to set
	 */
	public void setHeader(final List<ObligacionesCabeceraPublicidad> header)
	{
		this.header = header;
	}



}

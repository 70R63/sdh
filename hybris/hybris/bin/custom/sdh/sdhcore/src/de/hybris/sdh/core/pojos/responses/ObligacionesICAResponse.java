/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class ObligacionesICAResponse
{
	private List<ObligacionesCabeceraICA> header;

	/**
	 * @return the header
	 */
	public List<ObligacionesCabeceraICA> getHeader()
	{
		return header;
	}

	/**
	 * @param header
	 *           the header to set
	 */
	public void setHeader(final List<ObligacionesCabeceraICA> header)
	{
		this.header = header;
	}



}
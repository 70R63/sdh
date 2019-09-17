/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class ObligacionesDeliResponse
{

	private List<ObligacionesCabeceraDeli> header;

	/**
	 * @return the header
	 */
	public List<ObligacionesCabeceraDeli> getHeader()
	{
		return header;
	}

	/**
	 * @param header
	 *           the header to set
	 */
	public void setHeader(final List<ObligacionesCabeceraDeli> header)
	{
		this.header = header;
	}



}

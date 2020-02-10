/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class ObligacionesPredialResponse
{

	private List<ObligacionesCabeceraPredial> header;

	/**
	 * @return the header
	 */
	public List<ObligacionesCabeceraPredial> getHeader()
	{
		return header;
	}

	/**
	 * @param header
	 *           the header to set
	 */
	public void setHeader(final List<ObligacionesCabeceraPredial> header)
	{
		this.header = header;
	}


}

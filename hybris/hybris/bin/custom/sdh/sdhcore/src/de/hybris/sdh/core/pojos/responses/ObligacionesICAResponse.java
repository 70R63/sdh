/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class ObligacionesICAResponse
{

	private ObligacionesCabeceraICA header;
	private ObligacionesDetallePublicidad details;
	/**
	 * @return the header
	 */
	public ObligacionesCabeceraICA getHeader()
	{
		return header;
	}
	
	/**
	 * @return the details
	 */
	public ObligacionesDetallePublicidad getDetails()
	{
		return details;
	}

	/**
	 * @param header
	 *           the header to set
	 */
	public void setHeader(final ObligacionesCabeceraICA header)
	{
		this.header = header;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final ObligacionesDetallePublicidad details)
	{
		this.details = details;
	}





}

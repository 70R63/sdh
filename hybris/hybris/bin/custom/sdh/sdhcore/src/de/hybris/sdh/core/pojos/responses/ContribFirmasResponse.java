/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class ContribFirmasResponse
{
	private List<DetalleDeclaraciones> declaraciones;

	/**
	 * @return the declaraciones
	 */
	public List<DetalleDeclaraciones> getDeclaraciones()
	{
		return declaraciones;
	}

	/**
	 * @param declaraciones
	 *           the declaraciones to set
	 */
	public void setDeclaraciones(final List<DetalleDeclaraciones> declaraciones)
	{
		this.declaraciones = declaraciones;
	}



}

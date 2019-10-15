/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.DetalleDeclaraciones;

import java.util.List;


/**
 * @author hybris
 *
 */
public class ContribuyenteForm
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

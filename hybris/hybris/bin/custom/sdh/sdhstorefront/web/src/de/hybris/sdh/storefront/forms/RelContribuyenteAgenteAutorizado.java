/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.platform.commercefacades.user.data.CustomerData;


/**
 * @author Federico Flores Dimas
 *
 */
public class RelContribuyenteAgenteAutorizado
{

	private CustomerData contribuyente;
	private CustomerData agenteAutorizado;
	
	/**
	 * @return the contribuyente
	 */
	public CustomerData getContribuyente()
	{
		return contribuyente;
	}
	
	/**
	 * @param contribuyente
	 *           the contribuyente to set
	 */
	public void setContribuyente(final CustomerData contribuyente)
	{
		this.contribuyente = contribuyente;
	}
	
	/**
	 * @return the agenteAutorizado
	 */
	public CustomerData getAgenteAutorizado()
	{
		return agenteAutorizado;
	}
	
	/**
	 * @param agenteAutorizado
	 *           the agenteAutorizado to set
	 */
	public void setAgenteAutorizado(final CustomerData agenteAutorizado)
	{
		this.agenteAutorizado = agenteAutorizado;
	}


}

/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.sdh.storefront.controllers.impuestoGasolina.ItemSelectOption;


/**
 * @author fede
 *
 */
public class TramiteOpcion
{
	private String key;
	private ItemSelectOption tramiteOpcion;

	/**
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *           the key to set
	 */
	public void setKey(final String key)
	{
		this.key = key;
	}

	/**
	 * @return the tramiteOpcion
	 */
	public ItemSelectOption getTramiteOpcion()
	{
		return tramiteOpcion;
	}

	/**
	 * @param tramiteOpcion
	 *           the tramiteOpcion to set
	 */
	public void setTramiteOpcion(final ItemSelectOption tramiteOpcion)
	{
		this.tramiteOpcion = tramiteOpcion;
	}


	/**
	 * @param key
	 * @param tramiteOpcion
	 */
	public TramiteOpcion(final String key, final ItemSelectOption tramiteOpcion)
	{
		super();
		this.key = key;
		this.tramiteOpcion = tramiteOpcion;
	}




}

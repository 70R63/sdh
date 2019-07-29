/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.sdh.core.pojos.responses.ItemSelectOption;


/**
 * @author fede
 *
 */
public class TramiteOpcion
{
	private String key;
	private ItemSelectOption tramiteOpcion;
	private String processID;
	private String categorizacion;
	private String canal;

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
	 * @return the processID
	 */
	public String getProcessID()
	{
		return processID;
	}

	/**
	 * @param processID
	 *           the processID to set
	 */
	public void setProcessID(final String processID)
	{
		this.processID = processID;
	}

	/**
	 * @return the categorizacion
	 */
	public String getCategorizacion()
	{
		return categorizacion;
	}

	/**
	 * @param categorizacion
	 *           the categorizacion to set
	 */
	public void setCategorizacion(final String categorizacion)
	{
		this.categorizacion = categorizacion;
	}

	/**
	 * @param key
	 * @param tramiteOpcion
	 */
	public TramiteOpcion(final String key, final ItemSelectOption tramiteOpcion)
	{
		//super();
		this.key = key;
		this.tramiteOpcion = tramiteOpcion;
	}


	/**
	 * @param key
	 * @param tramiteOpcion
	 * @param processID
	 * @param categorizacion
	 * @param canal
	 */
	public TramiteOpcion(final String key, final ItemSelectOption tramiteOpcion, final String processID,
			final String categorizacion, final String canal)
	{
		super();
		this.key = key;
		this.tramiteOpcion = tramiteOpcion;
		this.processID = processID;
		this.categorizacion = categorizacion;
		this.canal = canal;
	}


}

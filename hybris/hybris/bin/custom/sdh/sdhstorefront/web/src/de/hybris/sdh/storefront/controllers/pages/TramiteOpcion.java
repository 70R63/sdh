/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.sdh.core.pojos.responses.ItemSelectOption;


/**
 * @author Federico Flores Dimas
 *
 */
public class TramiteOpcion
{
	private String key;
	private ItemSelectOption tramiteOpcion;
	private String processID;
	private String categorizacion;
	private String canal;
	private String urlAccion;
	private TramiteRolAccion rolAccion;
	private String notas;



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
	 * @return the canal
	 */
	public String getCanal()
	{
		return canal;
	}

	/**
	 * @param canal
	 *           the canal to set
	 */
	public void setCanal(final String canal)
	{
		this.canal = canal;
	}

	/**
	 * @return the urlAccion
	 */
	public String getUrlAccion()
	{
		return urlAccion;
	}

	/**
	 * @param urlAccion
	 *           the urlAccion to set
	 */
	public void setUrlAccion(final String urlAccion)
	{
		this.urlAccion = urlAccion;
	}

	/**
	 * @return the rolAccion
	 */
	public TramiteRolAccion getRolAccion()
	{
		return rolAccion;
	}

	/**
	 * @param rolAccion
	 *           the rolAccion to set
	 */
	public void setRolAccion(final TramiteRolAccion rolAccion)
	{
		this.rolAccion = rolAccion;
	}

	/**
	 * @return the notas
	 */
	public String getNotas()
	{
		return notas;
	}

	/**
	 * @param notas
	 *           the notas to set
	 */
	public void setNotas(final String notas)
	{
		this.notas = notas;
	}

	/**
	 * @param key
	 * @param tramiteOpcion
	 */
	public TramiteOpcion(final String key, final ItemSelectOption tramiteSelectOpcion)
	{
		//super();
		this.key = key;
		this.tramiteOpcion = tramiteSelectOpcion;
	}


	/**
	 * @param key
	 * @param tramiteOpcion
	 * @param processID
	 * @param categorizacion
	 * @param canal
	 */
	public TramiteOpcion(final String key, final ItemSelectOption tramiteSelectOpcion, final String processID,
			final String categorizacion, final String canal)
	{
		super();
		this.key = key;
		this.tramiteOpcion = tramiteSelectOpcion;
		this.processID = processID;
		this.categorizacion = categorizacion;
		this.canal = canal;
	}

	public TramiteOpcion(final String key, final ItemSelectOption tramiteSelectOpcion, final String url)
	{
		super();
		this.key = key;
		this.tramiteOpcion = tramiteSelectOpcion;
		this.urlAccion = url;
	}

	public TramiteOpcion(final String key, final ItemSelectOption tramiteSelectOpcion, final String processID,
			final String categorizacion, final String canal, final TramiteRolAccion rolAccion)
	{
		super();
		this.key = key;
		this.tramiteOpcion = tramiteSelectOpcion;
		this.processID = processID;
		this.categorizacion = categorizacion;
		this.canal = canal;
		this.rolAccion = rolAccion;
	}


}

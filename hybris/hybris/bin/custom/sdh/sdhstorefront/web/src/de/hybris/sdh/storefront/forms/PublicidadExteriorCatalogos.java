/**
 *
 */
package de.hybris.sdh.storefront.forms;

import java.util.Map;


/**
 * @author usuario
 *
 */
//dev-federico crear clase con atributos, setters y getters
public class PublicidadExteriorCatalogos
{

	private Map<String, String> opcionesUso;
	private Map<String, String> luginst;
	private Map<String, String> orientacionValla;
	private Map<String, String> basegrav;
	/**
	 * @return the opcionesUso
	 */
	public Map<String, String> getOpcionesUso()
	{
		return opcionesUso;
	}

	/**
	 * @param opcionesUso
	 *           the opcionesUso to set
	 */
	public void setOpcionesUso(final Map<String, String> opcionesUso)
	{
		this.opcionesUso = opcionesUso;
	}
	/**
	 * @return the luginst
	 */
	public Map<String, String> getLuginst()
	{
		return luginst;
	}

	/**
	 * @param luginst
	 *           the luginst to set
	 */
	public void setLuginst(final Map<String, String> luginst)
	{
		this.luginst = luginst;
	}

	/**
	 * @return the orientacionValla
	 */
	public Map<String, String> getOrientacionValla()
	{
		return orientacionValla;
	}

	/**
	 * @param orientacionValla
	 *           the orientacionValla to set
	 */
	public void setOrientacionValla(final Map<String, String> orientaValla)
	{
		orientacionValla = orientaValla;
	}
	/**
	 * @return the basegrav
	 */
	public Map<String, String> getBasegrav()
	{
		return basegrav;
	}

	/**
	 * @param basegrav
	 *           the basegrav to set
	 */
	public void setBasegrav(final Map<String, String> basegrav)
	{
		this.basegrav = basegrav;
	}




}

/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

/**
 * @author fede
 *
 */
public class SobreTasaGasolinaForm
{
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private boolean seleccionar;

	/**
	 * @return the nombre
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * @param nombre
	 *           the nombre to set
	 */
	public void setNombre(final String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno()
	{
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *           the apellidoPaterno to set
	 */
	public void setApellidoPaterno(final String apellidoPaterno)
	{
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno()
	{
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *           the apellidoMaterno to set
	 */
	public void setApellidoMaterno(final String apellidoMaterno)
	{
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the seleccionar
	 */
	public boolean isSeleccionar()
	{
		return seleccionar;
	}

	/**
	 * @param seleccionar
	 *           the seleccionar to set
	 */
	public void setSeleccionar(final boolean seleccionar)
	{
		this.seleccionar = seleccionar;
	}


}

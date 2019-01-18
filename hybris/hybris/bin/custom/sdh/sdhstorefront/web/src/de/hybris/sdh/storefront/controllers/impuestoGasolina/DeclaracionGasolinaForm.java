/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

/**
 * @author fede
 *
 */
public class DeclaracionGasolinaForm
{
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private boolean acuerdo;

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
	 * @return the acuerdo
	 */
	public boolean isAcuerdo()
	{
		return acuerdo;
	}

	/**
	 * @param acuerdo
	 *           the acuerdo to set
	 */
	public void setAcuerdo(final boolean acuerdo)
	{
		this.acuerdo = acuerdo;
	}

	/**
	 * @param apellidoMaterno
	 *           the apellidoMaterno to set
	 */
	public void setApellidoMaterno(final String apellidoMaterno)
	{
		this.apellidoMaterno = apellidoMaterno;
	}
}

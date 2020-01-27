/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

/**
 * @author Federico Flores Dimas
 *
 */
public class TramiteRolAccion
{

	private String rolAccion;
	private String rolIndicador;
	/**
	 * @return the rolAccion
	 */
	public String getRolAccion()
	{
		return rolAccion;
	}

	/**
	 * @param rolAccion
	 *           the rolAccion to set
	 */
	public void setRolAccion(final String rolAccion)
	{
		this.rolAccion = rolAccion;
	}

	/**
	 * @return the rolIndicador
	 */
	public String getRolIndicador()
	{
		return rolIndicador;
	}

	/**
	 * @param rolIndicador
	 *           the rolIndicador to set
	 */
	public void setRolIndicador(final String rolIndicador)
	{
		this.rolIndicador = rolIndicador;
	}



	/**
	 * @param rolAccion
	 * @param rolIndicador
	 */
	public TramiteRolAccion(final String rolAccion, final String rolIndicador)
	{
		super();
		this.rolAccion = rolAccion;
		this.rolIndicador = rolIndicador;
	}



}

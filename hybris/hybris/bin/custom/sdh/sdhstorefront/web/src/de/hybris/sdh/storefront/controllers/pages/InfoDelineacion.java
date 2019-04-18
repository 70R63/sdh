/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.sdh.core.pojos.responses.RadicaDelinResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;


/**
 * @author Federico Flores Dimas
 *
 */
public class InfoDelineacion
{

	private SDHValidaMailRolResponse valCont;
	private RadicaDelinResponse radicaDelin;

	/**
	 * @return the valCont
	 */
	public SDHValidaMailRolResponse getValCont()
	{
		return valCont;
	}

	/**
	 * @param valCont
	 *           the valCont to set
	 */
	public void setValCont(final SDHValidaMailRolResponse valCont)
	{
		this.valCont = valCont;
	}

	/**
	 * @return the radicaDelin
	 */
	public RadicaDelinResponse getRadicaDelin()
	{
		return radicaDelin;
	}

	/**
	 * @param radicaDelin
	 *           the radicaDelin to set
	 */
	public void setRadicaDelin(final RadicaDelinResponse radicaDelin)
	{
		this.radicaDelin = radicaDelin;
	}




}

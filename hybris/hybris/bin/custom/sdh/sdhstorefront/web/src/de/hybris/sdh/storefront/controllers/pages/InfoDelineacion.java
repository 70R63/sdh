/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacionResponse;
import de.hybris.sdh.core.pojos.responses.RadicaDelinResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaCatalogos;
import de.hybris.sdh.storefront.forms.DelineacionUrbanaControlCamposDec;


/**
 * @author Federico Flores Dimas
 *
 */
public class InfoDelineacion
{

	private SDHValidaMailRolResponse valCont;
	private RadicaDelinResponse radicaDelin;
	private InfoDelineacionInput input;
	private InfoObjetoDelineacionResponse infObjetoDelineacion;
	private InfoObjetoDelineacionResponse calculoImpDelineacion;
	private InfoObjetoDelineacionExtras infObjetoDelineacionExtras;
	private SobreTasaGasolinaCatalogos catalogos;
	private DelineacionUrbanaControlCamposDec controlCampos;

	/**
	 * @return the calculoImpDelineacion
	 */
	public InfoObjetoDelineacionResponse getCalculoImpDelineacion()
	{
		return calculoImpDelineacion;
	}

	/**
	 * @param calculoImpDelineacion
	 *           the calculoImpDelineacion to set
	 */
	public void setCalculoImpDelineacion(final InfoObjetoDelineacionResponse calculoImpDelineacion)
	{
		this.calculoImpDelineacion = calculoImpDelineacion;
	}

	/**
	 * @return the catalogos
	 */
	public SobreTasaGasolinaCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final SobreTasaGasolinaCatalogos catalogos)
	{
		this.catalogos = catalogos;
	}

	/**
	 * @return the infObjetoDelineacionExtras
	 */
	public InfoObjetoDelineacionExtras getInfObjetoDelineacionExtras()
	{
		return infObjetoDelineacionExtras;
	}

	/**
	 * @param infObjetoDelineacionExtras
	 *           the infObjetoDelineacionExtras to set
	 */
	public void setInfObjetoDelineacionExtras(final InfoObjetoDelineacionExtras infObjetoDelineacionExtras)
	{
		this.infObjetoDelineacionExtras = infObjetoDelineacionExtras;
	}

	/**
	 * @return the infObjetoDelineacion
	 */
	public InfoObjetoDelineacionResponse getInfObjetoDelineacion()
	{
		return infObjetoDelineacion;
	}

	/**
	 * @param infObjetoDelineacion
	 *           the infObjetoDelineacion to set
	 */
	public void setInfObjetoDelineacion(final InfoObjetoDelineacionResponse infObjetoDelineacion)
	{
		this.infObjetoDelineacion = infObjetoDelineacion;
	}

	/**
	 * @return the input
	 */
	public InfoDelineacionInput getInput()
	{
		return input;
	}

	/**
	 * @param input
	 *           the input to set
	 */
	public void setInput(final InfoDelineacionInput input)
	{
		this.input = input;
	}

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

	/**
	 * @return the controlCampos
	 */
	public DelineacionUrbanaControlCamposDec getControlCampos()
	{
		return controlCampos;
	}

	/**
	 * @param controlCampos
	 *           the controlCampos to set
	 */
	public void setControlCampos(final DelineacionUrbanaControlCamposDec controlCampos)
	{
		this.controlCampos = controlCampos;
	}






}

/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraDeli;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraGasolina;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraICA;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraPublicidad;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class ObligacionesForm

{
	private List<ObligacionesCabeceraPublicidad> header;
	private String variableres;
	private List<ObligacionesCabeceraGasolina> headergas;
	private ObligacionesCabeceraICA headerica;
	private List<ObligacionesCabeceraDeli> headerdeli;

	/**
	 * @return the header
	 */
	public List<ObligacionesCabeceraPublicidad> getHeader()
	{
		return header;
	}

	/**
	 * @param header
	 *           the header to set
	 */
	public void setHeader(final List<ObligacionesCabeceraPublicidad> header)
	{
		this.header = header;
	}

	/**
	 * @return the variableres
	 */
	public String getVariableres()
	{
		return variableres;
	}

	/**
	 * @param variableres
	 *           the variableres to set
	 */
	public void setVariableres(final String variableres)
	{
		this.variableres = variableres;
	}

	/**
	 * @return the headergas
	 */
	public List<ObligacionesCabeceraGasolina> getHeadergas()
	{
		return headergas;
	}

	/**
	 * @param headergas
	 *           the headergas to set
	 */
	public void setHeadergas(final List<ObligacionesCabeceraGasolina> headergas)
	{
		this.headergas = headergas;
	}

	/**
	 * @return the headerica
	 */
	public ObligacionesCabeceraICA getHeaderica()
	{
		return headerica;
	}

	/**
	 * @param headerica
	 *           the headerica to set
	 */
	public void setHeaderica(final ObligacionesCabeceraICA headerica)
	{
		this.headerica = headerica;
	}

	/**
	 * @return the headerdeli
	 */
	public List<ObligacionesCabeceraDeli> getHeaderdeli()
	{
		return headerdeli;
	}

	/**
	 * @param headerdeli
	 *           the headerdeli to set
	 */
	public void setHeaderdeli(final List<ObligacionesCabeceraDeli> headerdeli)
	{
		this.headerdeli = headerdeli;
	}



}

/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraDeli;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraGasolina;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraICA;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraPredial;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraPublicidad;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraVehiculos;
import de.hybris.sdh.core.pojos.responses.ObligacionesDeliResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesPredialResponse;
import de.hybris.sdh.core.pojos.responses.ReteicaObligacionesHeader;

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
	private List<ObligacionesCabeceraICA> headerica;
	private List<ObligacionesCabeceraDeli> headerdeli;
	private List<ObligacionesPredialResponse> headerPredial;
	private List<ObligacionesDeliResponse> headerDelienacion;

	private List<ObligacionesCabeceraPredial> headerPred;
	private List<ObligacionesCabeceraVehiculos> headerVehiculos;

	private List<ReteicaObligacionesHeader> headerreteica;
	private String claveImpuesto;

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
	public List<ObligacionesCabeceraICA> getHeaderica()
	{
		return headerica;
	}

	/**
	 * @param headerica
	 *           the headerica to set
	 */
	public void setHeaderica(final List<ObligacionesCabeceraICA> headerica)
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
	/**
	 * @return the headerPredial
	 */
	public List<ObligacionesPredialResponse> getHeaderPredial()
	{
		return headerPredial;
	}

	/**
	 * @param headerPredial
	 *           the headerPredial to set
	 */
	public void setHeaderPredial(final List<ObligacionesPredialResponse> headerPredial)
	{
		this.headerPredial = headerPredial;
	}
	/**
	 * @return the headerDelienacion
	 */
	public List<ObligacionesDeliResponse> getHeaderDelienacion()
	{
		return headerDelienacion;
	}

	/**
	 * @param headerDelienacion
	 *           the headerDelienacion to set
	 */
	public void setHeaderDelienacion(final List<ObligacionesDeliResponse> headerDelienacion)
	{
		this.headerDelienacion = headerDelienacion;
	}

	/**
	 * @return the headerPred
	 */
	public List<ObligacionesCabeceraPredial> getHeaderPred()
	{
		return headerPred;
	}

	/**
	 * @param headerPred
	 *           the headerPred to set
	 */
	public void setHeaderPred(final List<ObligacionesCabeceraPredial> headerPred)
	{
		this.headerPred = headerPred;
	}

	/**
	 * @return the headerVehiculos
	 */
	public List<ObligacionesCabeceraVehiculos> getHeaderVehiculos()
	{
		return headerVehiculos;
	}

	/**
	 * @param headerVehiculos
	 *           the headerVehiculos to set
	 */
	public void setHeaderVehiculos(final List<ObligacionesCabeceraVehiculos> headerVehiculos)
	{
		this.headerVehiculos = headerVehiculos;
	}

	/**
	 * @return the headerreteica
	 */
	public List<ReteicaObligacionesHeader> getHeaderreteica()
	{
		return headerreteica;
	}

	/**
	 * @param headerreteica
	 *           the headerreteica to set
	 */
	public void setHeaderreteica(final List<ReteicaObligacionesHeader> headerreteica)
	{
		this.headerreteica = headerreteica;
	}

	/**
	 * @return the claveImpuesto
	 */
	public String getClaveImpuesto()
	{
		return claveImpuesto;
	}

	/**
	 * @param claveImpuesto
	 *           the claveImpuesto to set
	 */
	public void setClaveImpuesto(final String claveImpuesto)
	{
		this.claveImpuesto = claveImpuesto;
	}


}

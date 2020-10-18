/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraPublicidad
{

	private String anioGravable;
	private String numResolucion;
	private String orientacionValla;
	private String facilidad;
	private String montoFacilidad;
	private String refActiva;
	private List<ObligacionesDetallePublicidad> details;



	/**
	 * @return the refActiva
	 */
	public String getRefActiva()
	{
		return refActiva;
	}

	/**
	 * @param refActiva
	 *           the refActiva to set
	 */
	public void setRefActiva(final String refActiva)
	{
		this.refActiva = refActiva;
	}

	/**
	 * @return the facilidad
	 */
	public String getFacilidad()
	{
		return facilidad;
	}

	/**
	 * @param facilidad
	 *           the facilidad to set
	 */
	public void setFacilidad(final String facilidad)
	{
		this.facilidad = facilidad;
	}

	/**
	 * @return the montoFacilidad
	 */
	public String getMontoFacilidad()
	{
		return montoFacilidad;
	}

	/**
	 * @param montoFacilidad
	 *           the montoFacilidad to set
	 */
	public void setMontoFacilidad(final String montoFacilidad)
	{
		this.montoFacilidad = montoFacilidad;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @return the numResolucion
	 */
	public String getNumResolucion()
	{
		return numResolucion;
	}

	/**
	 * @return the orientacionValla
	 */
	public String getOrientacionValla()
	{
		return orientacionValla;
	}


	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		this.anioGravable = anioGravable;
	}

	/**
	 * @param numResolucion
	 *           the numResolucion to set
	 */
	public void setNumResolucion(final String numResolucion)
	{
		this.numResolucion = numResolucion;
	}

	/**
	 * @param orientacionValla
	 *           the orientacionValla to set
	 */
	public void setOrientacionValla(final String orientacionValla)
	{
		this.orientacionValla = orientacionValla;
	}

	/**
	 * @return the details
	 */
	public List<ObligacionesDetallePublicidad> getDetails()
	{
		return details;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final List<ObligacionesDetallePublicidad> details)
	{
		this.details = details;
	}



}

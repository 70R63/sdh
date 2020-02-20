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
	private List<ObligacionesDetallePublicidad> details;

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

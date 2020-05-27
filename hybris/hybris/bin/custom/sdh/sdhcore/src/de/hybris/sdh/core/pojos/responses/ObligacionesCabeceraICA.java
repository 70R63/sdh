/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraICA
{

	private String tipoIdentificacion;
	private String noIdentificacion;
	private String anioGravable;
	private String periodo;
	private List<ObligacionesDetalleIca> details;

	/**
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion()
	{
		return tipoIdentificacion;
	}

	/**
	 * @param tipoIdentificacion
	 *           the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(final String tipoIdentificacion)
	{
		this.tipoIdentificacion = tipoIdentificacion;
	}

	/**
	 * @return the noIdentificacion
	 */
	public String getNoIdentificacion()
	{
		return noIdentificacion;
	}

	/**
	 * @param noIdentificacion
	 *           the noIdentificacion to set
	 */
	public void setNoIdentificacion(final String noIdentificacion)
	{
		this.noIdentificacion = noIdentificacion;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
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
	 * @return the periodo
	 */
	public String getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
	}

	/**
	 * @return the details
	 */
	public List<ObligacionesDetalleIca> getDetails()
	{
		return details;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final List<ObligacionesDetalleIca> details)
	{
		this.details = details;
	}
}

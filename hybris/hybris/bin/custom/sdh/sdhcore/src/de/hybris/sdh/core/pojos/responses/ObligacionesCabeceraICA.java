/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraICA
{

	private String anioGravable;
	private String periodo;
	private String tipoIdentificacion;
	private String noIdentificacion;
	private ObligacionesDetallePublicidad details;
	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}
	/**
	 * @return the periodo
	 */
	public String getPeriodo()
	{
		return periodo;
	}
	
	/**
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion()
	{
		return tipoIdentificacion;
	}

	/**
	 * @return the noIdentificacion
	 */
	public String getNoIdentificacion()
	{
		return noIdentificacion;
	}

	/**
	 * @return the details
	 */
	public ObligacionesDetallePublicidad getDetails()
	{
		return details;
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
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
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
	 * @param noIdentificacion
	 *           the noIdentificacion to set
	 */
	public void setNoIdentificacion(final String noIdentificacion)
	{
		this.noIdentificacion = noIdentificacion;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final ObligacionesDetallePublicidad details)
	{
		this.details = details;
	}


}

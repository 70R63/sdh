/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraGasolina
{

	private String anioGravable;
	private String periodo;
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
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final ObligacionesDetallePublicidad details)
	{
		this.details = details;
	}




}

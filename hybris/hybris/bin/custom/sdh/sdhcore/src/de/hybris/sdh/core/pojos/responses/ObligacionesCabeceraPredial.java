/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraPredial
{

	private String aniogravable;
	private String objetoContrato;
	private ObligacionesDetallePredial details;

	/**
	 * @return the aniogravable
	 */
	public String getAniogravable()
	{
		return aniogravable;
	}

	/**
	 * @param aniogravable
	 *           the aniogravable to set
	 */
	public void setAniogravable(final String aniogravable)
	{
		this.aniogravable = aniogravable;
	}

	/**
	 * @return the objetoContrato
	 */
	public String getObjetoContrato()
	{
		return objetoContrato;
	}

	/**
	 * @param objetoContrato
	 *           the objetoContrato to set
	 */
	public void setObjetoContrato(final String objetoContrato)
	{
		this.objetoContrato = objetoContrato;
	}

	/**
	 * @return the details
	 */
	public ObligacionesDetallePredial getDetails()
	{
		return details;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final ObligacionesDetallePredial details)
	{
		this.details = details;
	}



}

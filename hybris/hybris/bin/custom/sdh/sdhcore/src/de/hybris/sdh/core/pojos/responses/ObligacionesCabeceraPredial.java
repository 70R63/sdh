/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraPredial
{

	private String aniogravable;
	private String objetoContrato;
	private List<ObligacionesDetallePredial> details;

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
	public List<ObligacionesDetallePredial> getDetails()
	{
		return details;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final List<ObligacionesDetallePredial> details)
	{
		this.details = details;
	}





}

/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.DetalleActivEconomicas;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */

public class UpdateICAActEcoRitForm
{

	private String numBP;
	private List<DetalleActivEconomicas> activEconomicas;



	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the activEconomicas
	 */
	public List<DetalleActivEconomicas> getActivEconomicas()
	{
		return activEconomicas;
	}

	/**
	 * @param activEconomicas
	 *           the activEconomicas to set
	 */
	public void setActivEconomicas(final List<DetalleActivEconomicas> activEconomicas)
	{
		this.activEconomicas = activEconomicas;
	}



}

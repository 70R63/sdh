/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class VehiculosInfObjetoForm
{
	private String numBP;
	private String tipiden;
	private String numide;
	private String name;

	private SDHValidaMailRolResponse vehiculos;

	private List<ImpuestoVehiculos> impvehicular;

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
	 * @return the tipiden
	 */
	public String getTipiden()
	{
		return tipiden;
	}

	/**
	 * @param tipiden
	 *           the tipiden to set
	 */
	public void setTipiden(final String tipiden)
	{
		this.tipiden = tipiden;
	}

	/**
	 * @return the numide
	 */
	public String getNumide()
	{
		return numide;
	}

	/**
	 * @param numide
	 *           the numide to set
	 */
	public void setNumide(final String numide)
	{
		this.numide = numide;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the vehiculos
	 */
	public SDHValidaMailRolResponse getVehiculos()
	{
		return vehiculos;
	}

	/**
	 * @param vehiculos
	 *           the vehiculos to set
	 */
	public void setVehiculos(final SDHValidaMailRolResponse vehiculos)
	{
		this.vehiculos = vehiculos;
	}

	/**
	 * @return the impvehicular
	 */
	public List<ImpuestoVehiculos> getImpvehicular()
	{
		return impvehicular;
	}

	/**
	 * @param impvehicular
	 *           the impvehicular to set
	 */
	public void setImpvehicular(final List<ImpuestoVehiculos> impvehicular)
	{
		this.impvehicular = impvehicular;
	}



}

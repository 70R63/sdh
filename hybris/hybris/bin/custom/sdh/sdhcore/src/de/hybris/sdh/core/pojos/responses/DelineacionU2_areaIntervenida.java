/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Federico Flores Dimas
 *
 */
public class DelineacionU2_areaIntervenida
{

	private String areaInter;
	private String aream2;

	/**
	 * @return the areaInter
	 */
	public String getAreaInter()
	{
		return areaInter;
	}

	/**
	 * @param areaInter
	 *           the areaInter to set
	 */
	@JsonProperty("Area_inter")
	public void setAreaInter(final String areaInter)
	{
		this.areaInter = areaInter;
	}

	/**
	 * @return the aream2
	 */
	public String getAream2()
	{
		return aream2;
	}

	/**
	 * @param aream2
	 *           the aream2 to set
	 */
	@JsonProperty("Aream2")
	public void setAream2(final String aream2)
	{
		this.aream2 = aream2;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DelineacionU2_areaIntervenida [areaInter=" + areaInter + ", aream2=" + aream2 + "]";
	}



}

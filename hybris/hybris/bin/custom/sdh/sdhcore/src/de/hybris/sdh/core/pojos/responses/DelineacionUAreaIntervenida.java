/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class DelineacionUAreaIntervenida
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DelineacionUAreaIntervenida [areaInter=" + areaInter + ", aream2=" + aream2 + "]";
	}

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
	public void setAream2(final String aream2)
	{
		this.aream2 = aream2;
	}



}

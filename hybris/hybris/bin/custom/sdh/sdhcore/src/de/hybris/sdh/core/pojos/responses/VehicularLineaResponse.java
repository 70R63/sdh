/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class VehicularLineaResponse
{

	private String linea;
	private String desc_linea;

	/**
	 * @return the linea
	 */
	public String getLinea()
	{
		return linea;
	}

	/**
	 * @param linea
	 *           the linea to set
	 */
	public void setLinea(final String linea)
	{
		this.linea = linea;
	}

	/**
	 * @return the desc_linea
	 */
	public String getDesc_linea()
	{
		return desc_linea;
	}

	/**
	 * @param desc_linea
	 *           the desc_linea to set
	 */
	public void setDesc_linea(final String desc_linea)
	{
		this.desc_linea = desc_linea;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "VehicularLineaResponse [linea=" + linea + ", desc_linea=" + desc_linea + "]";
	}


}

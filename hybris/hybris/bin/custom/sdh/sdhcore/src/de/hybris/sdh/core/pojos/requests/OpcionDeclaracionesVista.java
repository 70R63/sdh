/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class OpcionDeclaracionesVista
{
	private String claveImpuesto;
	private String anoGravable;
	private String periodo;


	/**
	 * @return the claveImpuesto
	 */
	public String getClaveImpuesto()
	{
		return claveImpuesto;
	}
	
	/**
	 * @param claveImpuesto
	 *           the claveImpuesto to set
	 */
	public void setClaveImpuesto(final String claveImpuesto)
	{
		this.claveImpuesto = claveImpuesto;
	}
	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}
	
	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
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


}

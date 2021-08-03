/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class ReteICACortoResponse
{
	private ReteICA reteICA;
	private String tpmsj;
	private String idmsj;
	private String txtmsj;

	/**
	 * @return the reteICA
	 */
	public ReteICA getReteICA()
	{
		return reteICA;
	}

	/**
	 * @param reteICA
	 *           the reteICA to set
	 */
	public void setReteICA(final ReteICA reteICA)
	{
		this.reteICA = reteICA;
	}
	
	/**
	 * @return the tpmsj
	 */
	public String getTpmsj()
	{
		return tpmsj;
	}
	
	/**
	 * @param tpmsj
	 *           the tpmsj to set
	 */
	public void setTpmsj(final String tpmsj)
	{
		this.tpmsj = tpmsj;
	}
	
	/**
	 * @return the idmsj
	 */
	public String getIdmsj()
	{
		return idmsj;
	}
	
	/**
	 * @param idmsj
	 *           the idmsj to set
	 */
	public void setIdmsj(final String idmsj)
	{
		this.idmsj = idmsj;
	}
	
	/**
	 * @return the txtmsj
	 */
	public String getTxtmsj()
	{
		return txtmsj;
	}
	
	/**
	 * @param txtmsj
	 *           the txtmsj to set
	 */
	public void setTxtmsj(final String txtmsj)
	{
		this.txtmsj = txtmsj;
	}

	@Override
	public String toString()
	{
		return "ReteICACortoResponse [reteICA=" + reteICA + ", tpmsj=" + tpmsj + ", idmsj=" + idmsj + ", txtmsj=" + txtmsj + "]";
	}


}

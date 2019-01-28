/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class CertifNombResponse
{
	private String numBP;
	private String idmsj;
	private Double minPercentage;


	/**
	 * @return the minPercentage
	 */
	public Double getMinPercentage()
	{
		return minPercentage;
	}

	/**
	 * @param minPercentage
	 *           the minPercentage to set
	 */
	public void setMinPercentage(final Double minPercentage)
	{
		this.minPercentage = minPercentage;
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

	private String txtmsj;
	private Double porcentaje;
	private Boolean success;
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

	/**
	 * @return the success
	 */
	public Boolean getSuccess()
	{
		return success;
	}

	/**
	 * @param success
	 *           the success to set
	 */
	public void setSuccess(final Boolean success)
	{
		this.success = success;
	}

	/**
	 * @return the porcentaje
	 */
	public Double getPorcentaje()
	{
		return porcentaje;
	}

	/**
	 * @param porcentaje
	 *           the porcentaje to set
	 */
	public void setPorcentaje(final Double porcentaje)
	{
		this.porcentaje = porcentaje;
	}




}

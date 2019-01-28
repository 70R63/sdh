/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class UpdateRitErrorResponse
{
	private String idmsj;
	private String txtmsj;




	/**
	 *
	 */
	public UpdateRitErrorResponse()
	{
	}

	/**
	 * @param idmsj
	 * @param txtmsj
	 */
	public UpdateRitErrorResponse(final String idmsj, final String txtmsj)
	{
		super();
		this.idmsj = idmsj;
		this.txtmsj = txtmsj;
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





}

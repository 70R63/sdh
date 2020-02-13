/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class ErrorEnWS
{
	private String idmsj;
	private String txtmsj;
	private String id_msj;
	private String txt_msj;

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

	public String getId_msj() {
		return id_msj;
	}

	public void setId_msj(String id_msj) {
		this.id_msj = id_msj;
	}

	public String getTxt_msj() {
		return txt_msj;
	}

	public void setTxt_msj(String txt_msj) {
		this.txt_msj = txt_msj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "ErrorEnWS{" +
				"idmsj='" + idmsj + '\'' +
				", txtmsj='" + txtmsj + '\'' +
				", id_msj='" + id_msj + '\'' +
				", txt_msj='" + txt_msj + '\'' +
				'}';
	}
}

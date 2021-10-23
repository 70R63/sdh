/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;


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
	private String id;
	private String mensaje;
	private String idMsj;
	private String txtMsj;

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

	@JsonSetter("id_msj")
	public void setId_msj(final String id_msj) {
		this.id_msj = id_msj;
	}

	public String getTxt_msj() {
		return txt_msj;
	}

	@JsonSetter("txt_msj")
	public void setTxt_msj(final String txt_msj) {
		this.txt_msj = txt_msj;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param id
	 *           the id to set
	 */
	@JsonSetter("ID")
	public void setId(final String id)
	{
		this.id = id;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje()
	{
		return mensaje;
	}

	/**
	 * @param mensaje
	 *           the mensaje to set
	 */
	@JsonSetter("MENSAJE")
	public void setMensaje(final String mensaje)
	{
		this.mensaje = mensaje;
	}

	/**
	 * @return the idMsj
	 */
	public String getIdMsj()
	{
		return idMsj;
	}

	/**
	 * @param idMsj
	 *           the idMsj to set
	 */
	public void setIdMsj(final String idMsj)
	{
		this.idMsj = idMsj;
	}

	/**
	 * @return the txtMsj
	 */
	public String getTxtMsj()
	{
		return txtMsj;
	}

	/**
	 * @param txtMsj
	 *           the txtMsj to set
	 */
	public void setTxtMsj(final String txtMsj)
	{
		this.txtMsj = txtMsj;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ErrorEnWS [idmsj=" + idmsj + ", txtmsj=" + txtmsj + ", id_msj=" + id_msj + ", txt_msj=" + txt_msj + ", id=" + id
				+ ", mensaje=" + mensaje + ", idMsj=" + idMsj + ", txtMsj=" + txtMsj + "]";
	}




}

/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Praxis
 *
 */
public class ConsultarBPResponse
{

	private String numBP;
	private String smtp_addr;
	private String idmsg;
	private String txtmsj;

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
	 * @return the smtp_addr
	 */
	public String getSmtp_addr()
	{
		return smtp_addr;
	}

	/**
	 * @param smtp_addr
	 *           the smtp_addr to set
	 */

	@JsonSetter("SMTP_ADDR")
	public void setSmtp_addr(final String smtp_addr)
	{
		this.smtp_addr = smtp_addr;
	}

	/**
	 * @return the idmsg
	 */
	public String getIdmsg()
	{
		return idmsg;
	}

	/**
	 * @param idmsg
	 *           the idmsg to set
	 */
	public void setIdmsg(final String idmsg)
	{
		this.idmsg = idmsg;
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
		return "ConsultarBPResponse [numBP=" + numBP + ", smtp_addr=" + smtp_addr + ", idmsg=" + idmsg + ", txtmsj=" + txtmsj + "]";
	}



}

/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class SpacRequest
{
	private String numBP;
	private String anoGravable;
	private String objetoContrato;
	private String num_form;
	private String reimpresion;




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
	 * @return the objetoContrato
	 */
	public String getObjetoContrato()
	{
		return objetoContrato;
	}




	/**
	 * @param objetoContrato
	 *           the objetoContrato to set
	 */
	public void setObjetoContrato(final String objetoContrato)
	{
		this.objetoContrato = objetoContrato;
	}




	/**
	 * @return the num_form
	 */
	public String getNum_form()
	{
		return num_form;
	}




	/**
	 * @param num_form
	 *           the num_form to set
	 */
	public void setNum_form(final String num_form)
	{
		this.num_form = num_form;
	}




	/**
	 * @return the reimpresion
	 */
	public String getReimpresion()
	{
		return reimpresion;
	}




	/**
	 * @param reimpresion
	 *           the reimpresion to set
	 */
	public void setReimpresion(final String reimpresion)
	{
		this.reimpresion = reimpresion;
	}




	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"anoGravable\":\"" + this.getAnoGravable() + "\",");
		stringBuilder.append("\"objetoContrato\":\"" + this.getObjetoContrato() + "\",");
		stringBuilder.append("\"num_form\":\"" + this.getNum_form() + "\",");
		stringBuilder.append("\"reimpresion\":\"" + this.getReimpresion() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}



}

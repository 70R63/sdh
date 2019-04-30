/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Consultor
 *
 */
public class ICAInfObjetoRequest
{
	private String numObjeto;
	private String numBP;
	private String anoGravable;
	private String periodo;

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

	/**
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
	}

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

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"numObjeto\":\"" + this.getNumObjeto() + "\",");
		stringBuilder.append("\"periodo\":\"" + (StringUtils.isBlank(this.getPeriodo())?"":this.getPeriodo()) + "\",");
		stringBuilder.append("\"anoGravable\":\"" + (StringUtils.isBlank(this.getAnoGravable())?"":this.getAnoGravable()) + "\"");
		stringBuilder.append("}");
//		(StringUtils.isBlank(this.getPeriodo())?"":this.getPeriodo())
		return stringBuilder.toString();
	}



}

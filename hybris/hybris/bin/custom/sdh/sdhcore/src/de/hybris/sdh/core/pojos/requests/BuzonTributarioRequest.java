/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Maria Torres
 *
 */
public class BuzonTributarioRequest
{
	private String numBP;
	private String vigencia;
	private String checkLectura;

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
	 * @return the vigencia
	 */
	public String getVigencia()
	{
		return vigencia;
	}

	/**
	 * @param vigencia
	 *           the vigencia to set
	 */
	public void setVigencia(final String vigencia)
	{
		this.vigencia = vigencia;
	}

	/**
	 * @return the checkLectura
	 */
	public String getCheckLectura()
	{
		return checkLectura;
	}

	/**
	 * @param checkLectura
	 *           the checkLectura to set
	 */
	public void setCheckLectura(final String checkLectura)
	{
		this.checkLectura = checkLectura;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"NumBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"Vigencia\":\"" + this.getVigencia() + "\",");
		stringBuilder.append("\"Checklectura\":\"" + this.getCheckLectura() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}

	}

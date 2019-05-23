/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;


/**
 * @author hybris
 *
 */
public class LogReteIcaRequest
{
	private String numBP;

	private String anoGravable;

	private String periodo;

	private String numObjeto;

	private String nomArchivo;

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
	 * @return the nomArchivo
	 */
	public String getNomArchivo()
	{
		return nomArchivo;
	}

	/**
	 * @param nomArchivo
	 *           the nomArchivo to set
	 */
	public void setNomArchivo(final String nomArchivo)
	{
		this.nomArchivo = nomArchivo;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + ((StringUtils.isBlank(this.numBP)) ? "" : this.numBP) + "\",");
		stringBuilder.append("\"anoGravable\":\"" + ((StringUtils.isBlank(this.anoGravable)) ? "" : this.anoGravable) + "\",");
		stringBuilder.append("\"periodo\":\"" + ((StringUtils.isBlank(this.periodo)) ? "" : this.periodo) + "\",");
		stringBuilder.append("\"numObjeto\":\"" + ((StringUtils.isBlank(this.numObjeto)) ? "" : this.numObjeto) + "\",");
		stringBuilder.append("\"nomArchivo\":\"" + ((StringUtils.isBlank(this.nomArchivo)) ? "" : this.nomArchivo) + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}



}
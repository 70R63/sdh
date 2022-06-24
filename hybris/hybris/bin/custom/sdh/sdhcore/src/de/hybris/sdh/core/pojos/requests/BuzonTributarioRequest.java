/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Maria Torres
 *
 */
public class BuzonTributarioRequest
{
	private String numBP;
	private String vigencia;
	private String checkLectura;
	@JsonProperty("ID_Documento")
	private String idDocumento;
	@JsonProperty("ID_Radicado")
	private String idRadicado;

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




	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento()
	{
		return idDocumento;
	}

	/**
	 * @param idDocumento
	 *           the idDocumento to set
	 */
	@JsonSetter("ID_Documento")
	public void setIdDocumento(final String idDocumento)
	{
		this.idDocumento = idDocumento;
	}

	/**
	 * @return the idRadicado
	 */
	public String getIdRadicado()
	{
		return idRadicado;
	}

	/**
	 * @param idRadicado
	 *           the idRadicado to set
	 */
	@JsonSetter("ID_Radicado")
	public void setIdRadicado(final String idRadicado)
	{
		this.idRadicado = idRadicado;
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
		stringBuilder.append("\"vigencia\":\"" + this.getVigencia() + "\",");
		stringBuilder.append("\"checkLectura\":\"" + this.getCheckLectura() + "\",");
		stringBuilder.append("\"ID_Documento\":\"" + this.getIdDocumento() + "\",");
		stringBuilder.append("\"ID_Radicado\":\"" + this.getIdRadicado() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
	}

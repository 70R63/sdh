/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


/**
 * @author hybris
 *
 */
public class ReteIcaAvisoArchivoRequest
{
	private String numBP;

	private String numObjeto;

	private List<String> archivos;

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
	 * @return the archivos
	 */
	public List<String> getArchivos()
	{
		return archivos;
	}

	/**
	 * @param archivos
	 *           the archivos to set
	 */
	public void setArchivos(final List<String> archivos)
	{
		this.archivos = archivos;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + ((StringUtils.isBlank(this.numBP)) ? "" : this.numBP) + "\",");
		stringBuilder.append("\"numObjeto\":\"" + ((StringUtils.isBlank(this.numObjeto)) ? "" : this.numObjeto) + "\",");

		stringBuilder.append("\"archivos\":");
		stringBuilder.append("[");
		stringBuilder.append("{");

		//for reteICA is expected only one file
		stringBuilder.append("\"nomArchivo\":\"" + this.getArchivos().get(0) + "\"");

		stringBuilder.append("}");
		stringBuilder.append("]");


		stringBuilder.append("}");

		return stringBuilder.toString();
	}



}

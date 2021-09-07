/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;


/**
 * @author hybris
 *
 */
public class UpdateTelefonoRitRequest
{
	private String numBP;

	private String telfonoPrincipal;
	private String extension;
	private String tel_tipo;


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


	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");

		stringBuilder.append("\"telefonos\": [");

		final String tel = this.getTelfonoPrincipal();
		final String ext = this.getExtension();
		final String tel_tipo = this.getTel_tipo();

		stringBuilder.append("{");
		stringBuilder.append("\"TEL_TIPO\": \"" + ((StringUtils.isBlank(tel_tipo)) ? "" : tel_tipo) + "\",");
		stringBuilder.append("\"TEL_NUMBER\": \"" + ((StringUtils.isBlank(tel)) ? "" : tel) + "\",");
		stringBuilder.append("\"TEL_EXTENS\": \"" + ((StringUtils.isBlank(ext)) ? "" : ext) + "\",");
		stringBuilder.append("\"MOB_NUMBER\": \"\"");
		stringBuilder.append("}");

		stringBuilder.append("]");


		stringBuilder.append("}");
		return stringBuilder.toString();
	}


	/**
	 * @return the telfonoPrincipal
	 */
	public String getTelfonoPrincipal()
	{
		return telfonoPrincipal;
	}

	/**
	 * @param telfonoPrincipal
	 *           the telfonoPrincipal to set
	 */
	public void setTelfonoPrincipal(final String telfonoPrincipal)
	{
		this.telfonoPrincipal = telfonoPrincipal;
	}

	/**
	 * @return the extension
	 */
	public String getExtension()
	{
		return extension;
	}

	/**
	 * @param extension
	 *           the extension to set
	 */
	public void setExtension(final String extension)
	{
		this.extension = extension;
	}

	/**
	 * @return the tel_tipo
	 */
	public String getTel_tipo()
	{
		return tel_tipo;
	}

	/**
	 * @param tel_tipo
	 *           the tel_tipo to set
	 */
	public void setTel_tipo(final String tel_tipo)
	{
		this.tel_tipo = tel_tipo;
	}

}

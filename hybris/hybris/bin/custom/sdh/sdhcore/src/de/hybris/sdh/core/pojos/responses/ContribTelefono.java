/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author hybris
 *
 */
public class ContribTelefono
{
	private String TEL_TIPO;
	private String TEL_NUMBER;
	private String TEL_EXTENS;

	/**
	 *
	 */
	public ContribTelefono()
	{
		// XXX Auto-generated constructor stub
	}

	public ContribTelefono(final String cadenaTexto)
	{
		// XXX Auto-generated constructor stub
	}

	/**
	 * @return the tEL_TIPO
	 */
	public String getTEL_TIPO()
	{
		return TEL_TIPO;
	}

	/**
	 * @param tEL_TIPO
	 *           the tEL_TIPO to set
	 */
	@JsonSetter("TEL_TIPO")
	public void setTEL_TIPO(final String tEL_TIPO)
	{
		TEL_TIPO = tEL_TIPO;
	}

	/**
	 * @return the tEL_NUMBER
	 */
	public String getTEL_NUMBER()
	{
		return TEL_NUMBER;
	}

	/**
	 * @param tEL_NUMBER
	 *           the tEL_NUMBER to set
	 */
	@JsonSetter("TEL_NUMBER")
	public void setTEL_NUMBER(final String tEL_NUMBER)
	{
		TEL_NUMBER = tEL_NUMBER;
	}

	/**
	 * @return the tEL_EXTENS
	 */
	public String getTEL_EXTENS()
	{
		return TEL_EXTENS;
	}

	/**
	 * @param tEL_EXTENS
	 *           the tEL_EXTENS to set
	 */
	@JsonSetter("TEL_EXTENS")
	public void setTEL_EXTENS(final String tEL_EXTENS)
	{
		TEL_EXTENS = tEL_EXTENS;
	}



}

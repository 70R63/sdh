/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class ErrorEnWSDeclaracionesPDF
{
	private String idMensaje;
	private String textoMensaje;

	/**
	 * @return the idMensaje
	 */
	public String getIdMensaje()
	{
		return idMensaje;
	}

	/**
	 * @param idMensaje
	 *           the idMensaje to set
	 */
	public void setIdMensaje(final String idMensaje)
	{
		this.idMensaje = idMensaje;
	}

	/**
	 * @return the textoMensaje
	 */
	public String getTextoMensaje()
	{
		return textoMensaje;
	}

	/**
	 * @param textoMensaje
	 *           the textoMensaje to set
	 */
	public void setTextoMensaje(final String textoMensaje)
	{
		this.textoMensaje = textoMensaje;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ErrorEnWS [idMensaje=" + idMensaje + ", textoMensaje=" + textoMensaje + "]";
	}


}

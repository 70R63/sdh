/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class BuzonTributarioResponse
{
	//	@JsonProperty("Proyecto")
	private BuzonMensajes mensajes;

	/**
	 * @return the mensajes
	 */
	public BuzonMensajes getMensajes()
	{
		return mensajes;
	}

	/**
	 * @param mensajes
	 *           the mensajes to set
	 */
	public void setMensajes(final BuzonMensajes mensajes)
	{
		this.mensajes = mensajes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BuzonTributarioResponse [mensajes=" + mensajes + "]";
	}




}

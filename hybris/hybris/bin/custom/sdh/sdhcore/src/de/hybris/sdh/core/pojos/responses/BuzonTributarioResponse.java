/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class BuzonTributarioResponse
{
	//	@JsonProperty("Proyecto")
	public List<BuzonMensajes> mensajes;

	/**
	 * @return the mensajes
	 */
	public List<BuzonMensajes> getMensajes()
	{
		return mensajes;
	}

	/**
	 * @param mensajes
	 *           the mensajes to set
	 */
	public void setMensajes(final List<BuzonMensajes> mensajes)
	{
		this.mensajes = mensajes;
	}





}

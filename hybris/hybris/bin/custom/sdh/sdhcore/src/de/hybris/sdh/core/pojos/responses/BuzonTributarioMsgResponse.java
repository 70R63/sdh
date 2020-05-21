/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class BuzonTributarioMsgResponse
{
	//	@JsonProperty("Proyecto")
	public List<BuzonMensajes2> mensajes;

	/**
	 * @return the mensajes
	 */
	public List<BuzonMensajes2> getMensajes()
	{
		return mensajes;
	}

	/**
	 * @param mensajes
	 *           the mensajes to set
	 */
	public void setMensajes(final List<BuzonMensajes2> mensajes)
	{
		this.mensajes = mensajes;
	}




}

/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author MTorres
 *
 */
public class AnularFormularioResponse
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

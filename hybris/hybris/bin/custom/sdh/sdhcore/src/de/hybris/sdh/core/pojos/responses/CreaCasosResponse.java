/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class CreaCasosResponse
{
	private CreaCasosRespuestaResponse respuesta;

	/**
	 * @return the respuesta
	 */
	public CreaCasosRespuestaResponse getRespuesta()
	{
		return respuesta;
	}

	/**
	 * @param respuesta
	 *           the respuesta to set
	 */
	public void setRespuesta(final CreaCasosRespuestaResponse respuesta)
	{
		this.respuesta = respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CreaCasosResponse [respuesta=" + respuesta + "]";
	}



}

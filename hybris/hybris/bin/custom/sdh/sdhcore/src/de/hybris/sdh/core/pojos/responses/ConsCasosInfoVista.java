/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class ConsCasosInfoVista
{
	private List<ConsCasosInfo> infoCasos;
	private String mensaje;
	
	/**
	 * @return the infoCasos
	 */
	public List<ConsCasosInfo> getInfoCasos()
	{
		return infoCasos;
	}
	
	/**
	 * @param infoCasos
	 *           the infoCasos to set
	 */
	public void setInfoCasos(final List<ConsCasosInfo> infoCasos)
	{
		this.infoCasos = infoCasos;
	}
	
	/**
	 * @return the mensaje
	 */
	public String getMensaje()
	{
		return mensaje;
	}
	
	/**
	 * @param mensaje
	 *           the mensaje to set
	 */
	public void setMensaje(final String mensaje)
	{
		this.mensaje = mensaje;
	}



}

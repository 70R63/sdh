/**
 *
 */
package de.hybris.sdh.storefront.forms;

import java.util.Date;


/**
 * @author Consultor
 *
 */
public class PreguntasFrecuentesForm
{

	private String fecha;
	private Date fechaactual;
	
	/**
	 * @return the fecha
	 */
	public String getFecha()
	{
		return fecha;
	}
	
	/**
	 * @param fecha
	 *           the fecha to set
	 */
	public void setFecha(final String fecha)
	{
		this.fecha = fecha;
	}
	
	/**
	 * @return the fechaactual
	 */
	public Date getFechaactual()
	{
		return fechaactual;
	}
	
	/**
	 * @param fechaactual
	 *           the fechaactual to set
	 */
	public void setFechaactual(final Date fechaactual)
	{
		this.fechaactual = fechaactual;
	}



}

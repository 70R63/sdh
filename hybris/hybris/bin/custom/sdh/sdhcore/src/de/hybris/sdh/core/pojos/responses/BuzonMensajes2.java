/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class BuzonMensajes2
{
	//	@JsonProperty("Proyecto")


	public String id_radicado;
	public String autoridadEmisora;
	public String tipoMensaje;
	public String fechaNotificacion;
	public String asunto;
	public String checkLectura;
	public BuzonDocumentos documentos;
	public BuzonErrores errores;
	/**
	 * @return the id_radicado
	 */
	public String getId_radicado()
	{
		return id_radicado;
	}

	/**
	 * @param id_radicado
	 *           the id_radicado to set
	 */
	public void setId_radicado(final String id_radicado)
	{
		this.id_radicado = id_radicado;
	}
	/**
	 * @return the autoridadEmisora
	 */
	public String getAutoridadEmisora()
	{
		return autoridadEmisora;
	}

	/**
	 * @param autoridadEmisora
	 *           the autoridadEmisora to set
	 */
	public void setAutoridadEmisora(final String autoridadEmisora)
	{
		this.autoridadEmisora = autoridadEmisora;
	}
	/**
	 * @return the tipoMensaje
	 */
	public String getTipoMensaje()
	{
		return tipoMensaje;
	}

	/**
	 * @param tipoMensaje
	 *           the tipoMensaje to set
	 */
	public void setTipoMensaje(final String tipoMensaje)
	{
		this.tipoMensaje = tipoMensaje;
	}
	/**
	 * @return the fechaNotificacion
	 */
	public String getFechaNotificacion()
	{
		return fechaNotificacion;
	}

	/**
	 * @param fechaNotificacion
	 *           the fechaNotificacion to set
	 */
	public void setFechaNotificacion(final String fechaNotificacion)
	{
		this.fechaNotificacion = fechaNotificacion;
	}
	/**
	 * @return the asunto
	 */
	public String getAsunto()
	{
		return asunto;
	}

	/**
	 * @param asunto
	 *           the asunto to set
	 */
	public void setAsunto(final String asunto)
	{
		this.asunto = asunto;
	}
	/**
	 * @return the checkLectura
	 */
	public String getCheckLectura()
	{
		return checkLectura;
	}

	/**
	 * @param checkLectura
	 *           the checkLectura to set
	 */
	public void setCheckLectura(final String checkLectura)
	{
		this.checkLectura = checkLectura;
	}
	/**
	 * @return the errores
	 */
	public BuzonErrores getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final BuzonErrores errores)
	{
		this.errores = errores;
	}

	/**
	 * @return the documentos
	 */
	public BuzonDocumentos getDocumentos()
	{
		return documentos;
	}

	/**
	 * @param documentos
	 *           the documentos to set
	 */
	public void setDocumentos(final BuzonDocumentos documentos)
	{
		this.documentos = documentos;
	}


}

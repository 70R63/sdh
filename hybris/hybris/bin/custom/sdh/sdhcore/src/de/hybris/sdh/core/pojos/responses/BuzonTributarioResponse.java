/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class BuzonTributarioResponse
{
	//	@JsonProperty("Proyecto")


	private String idRadicado;
	private String autoridadEmisora;
	private String tipoMensaje;
	private String fechaNotificacion;
	private String asunto;
	private String checkBoxLectura;
	private List<BuzonDocumentos> documentos;
	private List<BuzonErrores> errores;

	/**
	 * @return the idRadicado
	 */
	public String getIdRadicado()
	{
		return idRadicado;
	}

	/**
	 * @param idRadicado
	 *           the idRadicado to set
	 */
	@JsonProperty("id_radicado")
	public void setIdRadicado(final String idRadicado)
	{
		this.idRadicado = idRadicado;
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
	 * @return the checkBoxLectura
	 */
	public String getCheckBoxLectura()
	{
		return checkBoxLectura;
	}

	/**
	 * @param checkBoxLectura
	 *           the checkBoxLectura to set
	 */
	@JsonProperty("checkLectura")
	public void setCheckBoxLectura(final String checkBoxLectura)
	{
		this.checkBoxLectura = checkBoxLectura;
	}

	/**
	 * @return the documentos
	 */
	public List<BuzonDocumentos> getDocumentos()
	{
		return documentos;
	}

	/**
	 * @param documentos
	 *           the documentos to set
	 */
	public void setDocumentos(final List<BuzonDocumentos> documentos)
	{
		this.documentos = documentos;
	}

	/**
	 * @return the errores
	 */
	public List<BuzonErrores> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<BuzonErrores> errores)
	{
		this.errores = errores;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BuzonTributarioResponse [idRadicado=" + idRadicado + ", autoridadEmisora=" + autoridadEmisora + ", tipoMensaje="
				+ tipoMensaje + ", fechaNotificacion=" + fechaNotificacion + ", asunto=" + asunto + ", checkBoxLectura="
				+ checkBoxLectura + ", documentos=" + documentos + ", errores=" + errores + "]";
	}

}

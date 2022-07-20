/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author MTorres
 *
 */
public class RetencionesPracticadasConsResponse
{

	private Cabecera cabecera;
	private List<DetalleRetenciones> detalle;
	private List<UpdateRitErrorResponse> errores;


	/**
	 * @return the cabecera
	 */
	public Cabecera getCabecera()
	{
		return cabecera;
	}

	/**
	 * @param cabecera
	 *           the cabecera to set
	 */
	@JsonSetter("Cabecera")
	public void setCabecera(final Cabecera cabecera)
	{
		this.cabecera = cabecera;
	}

	/**
	 * @return the detalle
	 */
	public List<DetalleRetenciones> getDetalle()
	{
		return detalle;
	}

	/**
	 * @param detalle
	 *           the detalle to set
	 */
	@JsonSetter("Detalle")
	public void setDetalle(final List<DetalleRetenciones> detalle)
	{
		this.detalle = detalle;
	}

	/**
	 * @return the errores
	 */
	public List<UpdateRitErrorResponse> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	@JsonSetter("Errores")
	public void setErrores(final List<UpdateRitErrorResponse> errores)
	{
		this.errores = errores;
	}





}

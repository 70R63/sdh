/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class EdoCtaPublicidad
{
	private EdoCtaPubliCabecera cabecera;
	private List<EdoCtaPubliDetail> detallePublicidad;

	/**
	 * @return the cabecera
	 */
	public EdoCtaPubliCabecera getCabecera()
	{
		return cabecera;
	}

	/**
	 * @param cabecera
	 *           the cabecera to set
	 */
	public void setCabecera(final EdoCtaPubliCabecera cabecera)
	{
		this.cabecera = cabecera;
	}

	/**
	 * @return the detallePublicidad
	 */
	public List<EdoCtaPubliDetail> getDetallePublicidad()
	{
		return detallePublicidad;
	}

	/**
	 * @param detallePublicidad
	 *           the detallePublicidad to set
	 */
	public void setDetallePublicidad(final List<EdoCtaPubliDetail> detallePublicidad)
	{
		this.detallePublicidad = detallePublicidad;
	}



}

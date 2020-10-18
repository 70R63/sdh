/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraDeli
{

	private String anioGravable;
	private String cdu;
	private String chip;
	private String direccion;
	private String facilidad;
	private String montoFacilidad;
	private String refActiva;
	private List<ObligacionesDetallePublicidad> details;




	/**
	 * @return the refActiva
	 */
	public String getRefActiva()
	{
		return refActiva;
	}

	/**
	 * @param refActiva
	 *           the refActiva to set
	 */
	public void setRefActiva(final String refActiva)
	{
		this.refActiva = refActiva;
	}

	/**
	 * @return the facilidad
	 */
	public String getFacilidad()
	{
		return facilidad;
	}

	/**
	 * @param facilidad
	 *           the facilidad to set
	 */
	public void setFacilidad(final String facilidad)
	{
		this.facilidad = facilidad;
	}

	/**
	 * @return the montoFacilidad
	 */
	public String getMontoFacilidad()
	{
		return montoFacilidad;
	}

	/**
	 * @param montoFacilidad
	 *           the montoFacilidad to set
	 */
	public void setMontoFacilidad(final String montoFacilidad)
	{
		this.montoFacilidad = montoFacilidad;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @return the cdu
	 */
	public String getCdu()
	{
		return cdu;
	}

	/**
	 * @return the chip
	 */
	public String getChip()
	{
		return chip;
	}



	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		this.anioGravable = anioGravable;
	}

	/**
	 * @param cdu
	 *           the cdu to set
	 */
	public void setCdu(final String cdu)
	{
		this.cdu = cdu;
	}

	/**
	 * @param chip
	 *           the chip to set
	 */
	public void setChip(final String chip)
	{
		this.chip = chip;
	}


	/**
	 * @return the direccion
	 */
	public String getDireccion()
	{
		return direccion;
	}

	/**
	 * @param direccion
	 *           the direccion to set
	 */
	public void setDireccion(final String direccion)
	{
		this.direccion = direccion;
	}

	/**
	 * @return the details
	 */
	public List<ObligacionesDetallePublicidad> getDetails()
	{
		return details;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final List<ObligacionesDetallePublicidad> details)
	{
		this.details = details;
	}




}

/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraVehiculos
{

	private String anioGravable;
   private String placa;
   private String modelo;
   private String marca;
   private String linea;
	private String facilidad;
	private String montoFacilidad;
	private String refActiva;
	private List<ObligacionesDetalleVehiculos> details;





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
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		this.anioGravable = anioGravable;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca()
	{
		return placa;
	}

	/**
	 * @param placa
	 *           the placa to set
	 */
	public void setPlaca(final String placa)
	{
		this.placa = placa;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo()
	{
		return modelo;
	}

	/**
	 * @param modelo
	 *           the modelo to set
	 */
	public void setModelo(final String modelo)
	{
		this.modelo = modelo;
	}

	/**
	 * @return the marca
	 */
	public String getMarca()
	{
		return marca;
	}

	/**
	 * @param marca
	 *           the marca to set
	 */
	public void setMarca(final String marca)
	{
		this.marca = marca;
	}

	/**
	 * @return the linea
	 */
	public String getLinea()
	{
		return linea;
	}

	/**
	 * @param linea
	 *           the linea to set
	 */
	public void setLinea(final String linea)
	{
		this.linea = linea;
	}

	/**
	 * @return the details
	 */
	public List<ObligacionesDetalleVehiculos> getDetails()
	{
		return details;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final List<ObligacionesDetalleVehiculos> details)
	{
		this.details = details;
	}




}

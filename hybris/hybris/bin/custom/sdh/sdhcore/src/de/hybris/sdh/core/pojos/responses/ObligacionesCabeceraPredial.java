/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraPredial
{

	private String anioGravable;
	private String objetoContrato;
	private String matrInmobiliaria;
	private String direccion;
	private String obligacion;
	private String facilidad;
	private String montoFacilidad;
	private String refActiva;
	private String totalReg;
	private List<ObligacionesDetallePredial> details;





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
	 * @return the objetoContrato
	 */
	public String getObjetoContrato()
	{
		return objetoContrato;
	}

	/**
	 * @param objetoContrato
	 *           the objetoContrato to set
	 */
	public void setObjetoContrato(final String objetoContrato)
	{
		this.objetoContrato = objetoContrato;
	}

	/**
	 * @return the details
	 */
	public List<ObligacionesDetallePredial> getDetails()
	{
		return details;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final List<ObligacionesDetallePredial> details)
	{
		this.details = details;
	}

	/**
	 * @return the matrInmobiliaria
	 */
	public String getMatrInmobiliaria()
	{
		return matrInmobiliaria;
	}

	/**
	 * @param matrInmobiliaria
	 *           the matrInmobiliaria to set
	 */
	public void setMatrInmobiliaria(final String matrInmobiliaria)
	{
		this.matrInmobiliaria = matrInmobiliaria;
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
	 * @return the obligacion
	 */
	public String getObligacion()
	{
		return obligacion;
	}

	/**
	 * @param obligacion
	 *           the obligacion to set
	 */
	public void setObligacion(final String obligacion)
	{
		this.obligacion = obligacion;
	}

	/**
	 * @return the totalReg
	 */
	public String getTotalReg()
	{
		return totalReg;
	}

	/**
	 * @param totalReg
	 *           the totalReg to set
	 */
	public void setTotalReg(final String totalReg)
	{
		this.totalReg = totalReg;
	}





}

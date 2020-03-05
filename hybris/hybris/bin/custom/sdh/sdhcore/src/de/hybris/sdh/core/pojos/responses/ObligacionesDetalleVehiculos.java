/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesDetalleVehiculos
{

	private String estadoObligacion;
	private String obligacion;
	private String numFormulario;
	private String numReferencia;
	private String objetoContrato;
	private String fechaVencimiento;




	/**
	 * @return the fechaVencimiento
	 */
	public String getFechaVencimiento()
	{
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento
	 *           the fechaVencimiento to set
	 */
	public void setFechaVencimiento(final String fechaVencimiento)
	{
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * @return the estadoObligacion
	 */
	public String getEstadoObligacion()
	{
		return estadoObligacion;
	}

	/**
	 * @param estadoObligacion
	 *           the estadoObligacion to set
	 */
	public void setEstadoObligacion(final String estadoObligacion)
	{
		this.estadoObligacion = estadoObligacion;
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
	 * @return the numFormulario
	 */
	public String getNumFormulario()
	{
		return numFormulario;
	}

	/**
	 * @param numFormulario
	 *           the numFormulario to set
	 */
	public void setNumFormulario(final String numFormulario)
	{
		this.numFormulario = numFormulario;
	}
	/**
	 * @return the numReferencia
	 */
	public String getNumReferencia()
	{
		return numReferencia;
	}

	/**
	 * @param numReferencia
	 *           the numReferencia to set
	 */
	public void setNumReferencia(final String numReferencia)
	{
		this.numReferencia = numReferencia;
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


}

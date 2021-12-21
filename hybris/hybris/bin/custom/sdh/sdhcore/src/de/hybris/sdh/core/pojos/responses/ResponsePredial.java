/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Praxis
 *
 */
public class ResponsePredial
{

	private String chip;
	private String matriculaInmobiliaria;
	private String anoGravable;
	private String direccion;
	private String pagoVoluntario;
	private String totalPagar;
	private String totalConVoluntario;
	private String numReferencia;
	private String fechaVencimiento;
	private String numFormulario;
	private String objetoContrato;

	/**
	 * @return the chip
	 */
	public String getChip()
	{
		return chip;
	}

	/**
	 * @param chip
	 *           the chip to set
	 */
	@JsonSetter("CHIP")
	public void setChip(final String chip)
	{
		this.chip = chip;
	}

	/**
	 * @return the matriculaInmobiliaria
	 */
	public String getMatriculaInmobiliaria()
	{
		return matriculaInmobiliaria;
	}

	/**
	 * @param matriculaInmobiliaria
	 *           the matriculaInmobiliaria to set
	 */
	public void setMatriculaInmobiliaria(final String matriculaInmobiliaria)
	{
		this.matriculaInmobiliaria = matriculaInmobiliaria;
	}

	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}

	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
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
	 * @return the pagoVoluntario
	 */
	public String getPagoVoluntario()
	{
		return pagoVoluntario;
	}

	/**
	 * @param pagoVoluntario
	 *           the pagoVoluntario to set
	 */
	public void setPagoVoluntario(final String pagoVoluntario)
	{
		this.pagoVoluntario = pagoVoluntario;
	}

	/**
	 * @return the totalPagar
	 */
	public String getTotalPagar()
	{
		return totalPagar;
	}

	/**
	 * @param totalPagar
	 *           the totalPagar to set
	 */
	public void setTotalPagar(final String totalPagar)
	{
		this.totalPagar = totalPagar;
	}

	/**
	 * @return the totalConVoluntario
	 */
	public String getTotalConVoluntario()
	{
		return totalConVoluntario;
	}

	/**
	 * @param totalConVoluntario
	 *           the totalConVoluntario to set
	 */
	public void setTotalConVoluntario(final String totalConVoluntario)
	{
		this.totalConVoluntario = totalConVoluntario;
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

	@Override
	public String toString()
	{
		return "ResponsePredial [chip=" + chip + ", matriculaInmobiliaria=" + matriculaInmobiliaria + ", anoGravable=" + anoGravable
				+ ", direccion=" + direccion + ", pagoVoluntario=" + pagoVoluntario + ", totalPagar=" + totalPagar
				+ ", totalConVoluntario=" + totalConVoluntario + ", numReferencia=" + numReferencia + ", fechaVencimiento="
				+ fechaVencimiento + ", numFormulario=" + numFormulario + ", objetoContrato=" + objetoContrato + "]";
	}




}

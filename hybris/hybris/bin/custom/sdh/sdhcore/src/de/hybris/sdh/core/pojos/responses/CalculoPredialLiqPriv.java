/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author hybris
 *
 */
public class CalculoPredialLiqPriv
{
	private String aporteVoluntario;
	private String proyecto;
	private String valorImpuestoACargo;
	private String descuentoPorIncrementoDiferencias;
	private String valorImpuestoAjustadoActual;
	private String sancion;
	private String totalSaldoACargo;
	private String valorAPagar;
	private String descuentoPorProntoPago;
	private String descuendoAdicional1;
	private String intereses;
	private String totalAPagar;
	private String valorAporteVoluntario;
	private String totalConPagoVoluntario;
	private String tarifaLiquidacion;

	/**
	 * @return the aporteVoluntario
	 */
	public String getAporteVoluntario()
	{
		return aporteVoluntario;
	}

	/**
	 * @param aporteVoluntario
	 *           the aporteVoluntario to set
	 */
	@JsonSetter("AporteVoluntario")
	public void setAporteVoluntario(final String aporteVoluntario)
	{
		this.aporteVoluntario = aporteVoluntario;
	}

	/**
	 * @return the proyecto
	 */
	public String getProyecto()
	{
		return proyecto;
	}

	/**
	 * @param proyecto
	 *           the proyecto to set
	 */
	@JsonSetter("Proyecto")
	public void setProyecto(final String proyecto)
	{
		this.proyecto = proyecto;
	}

	/**
	 * @return the valorImpuestoACargo
	 */
	public String getValorImpuestoACargo()
	{
		return valorImpuestoACargo;
	}

	/**
	 * @param valorImpuestoACargo
	 *           the valorImpuestoACargo to set
	 */
	@JsonSetter("ValorImpuestoACargo")
	public void setValorImpuestoACargo(final String valorImpuestoACargo)
	{
		this.valorImpuestoACargo = valorImpuestoACargo;
	}

	/**
	 * @return the descuentoPorIncrementoDiferencias
	 */
	public String getDescuentoPorIncrementoDiferencias()
	{
		return descuentoPorIncrementoDiferencias;
	}

	/**
	 * @param descuentoPorIncrementoDiferencias
	 *           the descuentoPorIncrementoDiferencias to set
	 */
	@JsonSetter("DescuentoPorIncrementoDiferencias")
	public void setDescuentoPorIncrementoDiferencias(final String descuentoPorIncrementoDiferencias)
	{
		this.descuentoPorIncrementoDiferencias = descuentoPorIncrementoDiferencias;
	}

	/**
	 * @return the valorImpuestoAjustadoActual
	 */
	public String getValorImpuestoAjustadoActual()
	{
		return valorImpuestoAjustadoActual;
	}

	/**
	 * @param valorImpuestoAjustadoActual
	 *           the valorImpuestoAjustadoActual to set
	 */
	@JsonSetter("ValorImpuestoAjustadoActual")
	public void setValorImpuestoAjustadoActual(final String valorImpuestoAjustadoActual)
	{
		this.valorImpuestoAjustadoActual = valorImpuestoAjustadoActual;
	}

	/**
	 * @return the sancion
	 */
	public String getSancion()
	{
		return sancion;
	}

	/**
	 * @param sancion
	 *           the sancion to set
	 */
	@JsonSetter("Sancion")
	public void setSancion(final String sancion)
	{
		this.sancion = sancion;
	}

	/**
	 * @return the totalSaldoACargo
	 */
	public String getTotalSaldoACargo()
	{
		return totalSaldoACargo;
	}

	/**
	 * @param totalSaldoACargo
	 *           the totalSaldoACargo to set
	 */
	@JsonSetter("TotalSaldoACargo")
	public void setTotalSaldoACargo(final String totalSaldoACargo)
	{
		this.totalSaldoACargo = totalSaldoACargo;
	}

	/**
	 * @return the valorAPagar
	 */
	public String getValorAPagar()
	{
		return valorAPagar;
	}

	/**
	 * @param valorAPagar
	 *           the valorAPagar to set
	 */
	@JsonSetter("ValorAPagar")
	public void setValorAPagar(final String valorAPagar)
	{
		this.valorAPagar = valorAPagar;
	}

	/**
	 * @return the descuentoPorProntoPago
	 */
	public String getDescuentoPorProntoPago()
	{
		return descuentoPorProntoPago;
	}

	/**
	 * @param descuentoPorProntoPago
	 *           the descuentoPorProntoPago to set
	 */
	@JsonSetter("DescuentoPorProntoPago")
	public void setDescuentoPorProntoPago(final String descuentoPorProntoPago)
	{
		this.descuentoPorProntoPago = descuentoPorProntoPago;
	}

	/**
	 * @return the descuendoAdicional1
	 */
	public String getDescuendoAdicional1()
	{
		return descuendoAdicional1;
	}

	/**
	 * @param descuendoAdicional1
	 *           the descuendoAdicional1 to set
	 */
	@JsonSetter("DescuendoAdicional1")
	public void setDescuendoAdicional1(final String descuendoAdicional1)
	{
		this.descuendoAdicional1 = descuendoAdicional1;
	}

	/**
	 * @return the intereses
	 */
	public String getIntereses()
	{
		return intereses;
	}

	/**
	 * @param intereses
	 *           the intereses to set
	 */
	@JsonSetter("Intereses")
	public void setIntereses(final String intereses)
	{
		this.intereses = intereses;
	}

	/**
	 * @return the totalAPagar
	 */
	public String getTotalAPagar()
	{
		return totalAPagar;
	}

	/**
	 * @param totalAPagar
	 *           the totalAPagar to set
	 */
	@JsonSetter("TotalAPagar")
	public void setTotalAPagar(final String totalAPagar)
	{
		this.totalAPagar = totalAPagar;
	}

	/**
	 * @return the valorAporteVoluntario
	 */
	public String getValorAporteVoluntario()
	{
		return valorAporteVoluntario;
	}

	/**
	 * @param valorAporteVoluntario
	 *           the valorAporteVoluntario to set
	 */
	@JsonSetter("ValorAporteVoluntario")
	public void setValorAporteVoluntario(final String valorAporteVoluntario)
	{
		this.valorAporteVoluntario = valorAporteVoluntario;
	}

	/**
	 * @return the totalConPagoVoluntario
	 */
	public String getTotalConPagoVoluntario()
	{
		return totalConPagoVoluntario;
	}

	/**
	 * @param totalConPagoVoluntario
	 *           the totalConPagoVoluntario to set
	 */
	@JsonSetter("TotalConPagoVoluntario")
	public void setTotalConPagoVoluntario(final String totalConPagoVoluntario)
	{
		this.totalConPagoVoluntario = totalConPagoVoluntario;
	}

	/**
	 * @return the tarifa_liquidacion
	 */
	public String getTarifaLiquidacion()
	{
		return tarifaLiquidacion;
	}

	/**
	 * @param tarifa_liquidacion
	 *           the tarifa_liquidacion to set
	 */
	@JsonSetter("TarifaLiquidacion")
	public void setTarifaLiquidacion(final String tarifaLiquidacion)
	{
		this.tarifaLiquidacion = tarifaLiquidacion;
	}




}

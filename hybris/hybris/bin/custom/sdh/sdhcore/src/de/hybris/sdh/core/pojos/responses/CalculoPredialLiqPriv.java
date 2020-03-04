/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;


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
	@JsonProperty("AporteVoluntario")
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
	@JsonProperty("Proyecto")
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
	@JsonProperty("ValorImpuestoACargo")
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
	@JsonProperty("DescuentoPorIncrementoDiferencias")
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
	@JsonProperty("ValorImpuestoAjustadoActual")
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
	@JsonProperty("Sancion")
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
	@JsonProperty("TotalSaldoACargo")
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
	@JsonProperty("ValorAPagar")
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
	@JsonProperty("DescuentoPorProntoPago")
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
	@JsonProperty("DescuendoAdicional1")
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
	@JsonProperty("Intereses")
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
	@JsonProperty("TotalAPagar")
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
	@JsonProperty("ValorAporteVoluntario")
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
	@JsonProperty("TotalConPagoVoluntario")
	public void setTotalConPagoVoluntario(final String totalConPagoVoluntario)
	{
		this.totalConPagoVoluntario = totalConPagoVoluntario;
	}




}

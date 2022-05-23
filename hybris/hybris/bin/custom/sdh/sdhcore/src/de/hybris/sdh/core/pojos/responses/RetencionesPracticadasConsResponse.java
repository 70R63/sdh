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
	private String periodoReportado;
	private String numbbpretenedor;
	private String retenedor;
	private String tipodedocumento;
	private String identificacionRetenedor;
	private String basederetencion;
	private String tarifaAplicada;
	private String valoresRetenidos;
	private String totalRetenciones;
	private List<UpdateRitErrorResponse> errores;

	/**
	 * @return the periodoReportado
	 */
	public String getPeriodoReportado()
	{
		return periodoReportado;
	}

	/**
	 * @param periodoReportado
	 *           the periodoReportado to set
	 */
	@JsonSetter("PeriodoReportado")
	public void setPeriodoReportado(final String periodoReportado)
	{
		this.periodoReportado = periodoReportado;
	}

	/**
	 * @return the numbbpretenedor
	 */
	public String getNumbbpretenedor()
	{
		return numbbpretenedor;
	}

	/**
	 * @param numbbpretenedor
	 *           the numbbpretenedor to set
	 */
	@JsonSetter("Numbbpretenedor")
	public void setNumbbpretenedor(final String numbbpretenedor)
	{
		this.numbbpretenedor = numbbpretenedor;
	}

	/**
	 * @return the retenedor
	 */
	public String getRetenedor()
	{
		return retenedor;
	}

	/**
	 * @param retenedor
	 *           the retenedor to set
	 */
	@JsonSetter("Retenedor")
	public void setRetenedor(final String retenedor)
	{
		this.retenedor = retenedor;
	}

	/**
	 * @return the tipodedocumento
	 */
	public String getTipodedocumento()
	{
		return tipodedocumento;
	}

	/**
	 * @param tipodedocumento
	 *           the tipodedocumento to set
	 */
	@JsonSetter("Tipodedocumento")
	public void setTipodedocumento(final String tipodedocumento)
	{
		this.tipodedocumento = tipodedocumento;
	}

	/**
	 * @return the identificacionRetenedor
	 */
	public String getIdentificacionRetenedor()
	{
		return identificacionRetenedor;
	}

	/**
	 * @param identificacionRetenedor
	 *           the identificacionRetenedor to set
	 */
	@JsonSetter("IdentificacionRetenedor")
	public void setIdentificacionRetenedor(final String identificacionRetenedor)
	{
		this.identificacionRetenedor = identificacionRetenedor;
	}

	/**
	 * @return the basederetencion
	 */
	public String getBasederetencion()
	{
		return basederetencion;
	}

	/**
	 * @param basederetencion
	 *           the basederetencion to set
	 */
	@JsonSetter("Basederetencion")
	public void setBasederetencion(final String basederetencion)
	{
		this.basederetencion = basederetencion;
	}

	/**
	 * @return the tarifaAplicada
	 */
	public String getTarifaAplicada()
	{
		return tarifaAplicada;
	}

	/**
	 * @param tarifaAplicada
	 *           the tarifaAplicada to set
	 */
	@JsonSetter("TarifaAplicada")
	public void setTarifaAplicada(final String tarifaAplicada)
	{
		this.tarifaAplicada = tarifaAplicada;
	}

	/**
	 * @return the valoresRetenidos
	 */
	public String getValoresRetenidos()
	{
		return valoresRetenidos;
	}

	/**
	 * @param valoresRetenidos
	 *           the valoresRetenidos to set
	 */
	@JsonSetter("ValoresRetenidos")
	public void setValoresRetenidos(final String valoresRetenidos)
	{
		this.valoresRetenidos = valoresRetenidos;
	}

	/**
	 * @return the totalRetenciones
	 */
	public String getTotalRetenciones()
	{
		return totalRetenciones;
	}

	/**
	 * @param totalRetenciones
	 *           the totalRetenciones to set
	 */
	@JsonSetter("TotalRetenciones")
	public void setTotalRetenciones(final String totalRetenciones)
	{
		this.totalRetenciones = totalRetenciones;
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

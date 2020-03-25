/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author Federico Flores Dimas
 *
 */
public class InfoObjetoDelineacion2Response
{

	private String anoGravable;
	private String periodo;
	private String cdu;
	private String numRadicado;
	private String retencion;
	private String opcionUso;
	private String tipoLicencia;
	private String objetoLicen;
	private String modalidad;
	private String presupuestoObra;
	private String causalExcep;

	private List<FirmanteResponse> firmantes;

	private DelineacionUInfoDeclara infoDeclara;
	private List<DelineacionU2_usos> usos;
	private List<DelineacionU2_areaIntervenida> areaIntervenida;
	private List<DelineacionU2_areaProyecto> areaProyecto;
	private List<DelineacionURelaciones> relaciones;
	private List<ErrorEnWS> errores;

	private String numForm;
	private String fechaEjecutaria;
	private String fechaFinalObra;
	private String fechaUltAbono;
	private String totalPresupuesto;
	private String valorExen;
	private String valorEjecutado;
	private String impuestoCargo;
	private String valorSancion;
	private String totalRetencion;
	private String saldoImpCargo;
	private String saldoFavor;
	private String valorPagar;
	private String interesMora;
	private String totalPagar;



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
	@JsonProperty("Anio_gravable")
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	@JsonProperty("Periodo")
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
	}

	/**
	 * @return the cdu
	 */
	public String getCdu()
	{
		return cdu;
	}

	/**
	 * @param cdu
	 *           the cdu to set
	 */
	@JsonProperty("CDU")
	public void setCdu(final String cdu)
	{
		this.cdu = cdu;
	}

	/**
	 * @return the numRadicado
	 */
	public String getNumRadicado()
	{
		return numRadicado;
	}

	/**
	 * @param numRadicado
	 *           the numRadicado to set
	 */
	@JsonProperty("Radicado")
	public void setNumRadicado(final String numRadicado)
	{
		this.numRadicado = numRadicado;
	}

	/**
	 * @return the retencion
	 */
	public String getRetencion()
	{
		return retencion;
	}

	/**
	 * @param retencion
	 *           the retencion to set
	 */
	@JsonProperty("Retencion")
	public void setRetencion(final String retencion)
	{
		this.retencion = retencion;
	}

	/**
	 * @return the opcionUso
	 */
	public String getOpcionUso()
	{
		return opcionUso;
	}

	/**
	 * @param opcionUso
	 *           the opcionUso to set
	 */
	@JsonProperty("Opcion_uso")
	public void setOpcionUso(final String opcionUso)
	{
		this.opcionUso = opcionUso;
	}

	/**
	 * @return the tipoLicencia
	 */
	public String getTipoLicencia()
	{
		return tipoLicencia;
	}

	/**
	 * @param tipoLicencia
	 *           the tipoLicencia to set
	 */
	@JsonProperty("Tipo_licencia")
	public void setTipoLicencia(final String tipoLicencia)
	{
		this.tipoLicencia = tipoLicencia;
	}

	/**
	 * @return the objetoLicen
	 */
	public String getObjetoLicen()
	{
		return objetoLicen;
	}

	/**
	 * @param objetoLicen
	 *           the objetoLicen to set
	 */
	@JsonProperty("Objeto_licen")
	public void setObjetoLicen(final String objetoLicen)
	{
		this.objetoLicen = objetoLicen;
	}

	/**
	 * @return the modalidad
	 */
	public String getModalidad()
	{
		return modalidad;
	}

	/**
	 * @param modalidad
	 *           the modalidad to set
	 */
	@JsonProperty("Modalidad")
	public void setModalidad(final String modalidad)
	{
		this.modalidad = modalidad;
	}

	/**
	 * @return the presupuestoObra
	 */
	public String getPresupuestoObra()
	{
		return presupuestoObra;
	}

	/**
	 * @param presupuestoObra
	 *           the presupuestoObra to set
	 */
	@JsonProperty("Presupuesto_obra")
	public void setPresupuestoObra(final String presupuestoObra)
	{
		this.presupuestoObra = presupuestoObra;
	}

	/**
	 * @return the causalExcep
	 */
	public String getCausalExcep()
	{
		return causalExcep;
	}

	/**
	 * @param causalExcep
	 *           the causalExcep to set
	 */
	@JsonProperty("Causal_exep")
	public void setCausalExcep(final String causalExcep)
	{
		this.causalExcep = causalExcep;
	}

	/**
	 * @return the firmantes
	 */
	public List<FirmanteResponse> getFirmantes()
	{
		return firmantes;
	}

	/**
	 * @param firmantes
	 *           the firmantes to set
	 */
	@JsonProperty("Firmantes")
	public void setFirmantes(final List<FirmanteResponse> firmantes)
	{
		this.firmantes = firmantes;
	}

	/**
	 * @return the totalPresupuesto
	 */
	public String getTotalPresupuesto()
	{
		return totalPresupuesto;
	}

	/**
	 * @param totalPresupuesto
	 *           the totalPresupuesto to set
	 */
	@JsonProperty("Total_presupuesto")
	public void setTotalPresupuesto(final String totalPresupuesto)
	{
		this.totalPresupuesto = totalPresupuesto;
	}

	/**
	 * @return the totalRetencion
	 */
	public String getTotalRetencion()
	{
		return totalRetencion;
	}

	/**
	 * @param totalRetencion
	 *           the totalRetencion to set
	 */
	@JsonProperty("Total_retencion")
	public void setTotalRetencion(final String totalRetencion)
	{
		this.totalRetencion = totalRetencion;
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
	@JsonProperty("Total_pagar")
	public void setTotalPagar(final String totalPagar)
	{
		this.totalPagar = totalPagar;
	}

	/**
	 * @return the numForm
	 */
	public String getNumForm()
	{
		return numForm;
	}

	/**
	 * @param numForm
	 *           the numForm to set
	 */
	public void setNumForm(final String numForm)
	{
		this.numForm = numForm;
	}

	/**
	 * @return the infoDeclara
	 */
	public DelineacionUInfoDeclara getInfoDeclara()
	{
		return infoDeclara;
	}

	/**
	 * @param infoDeclara
	 *           the infoDeclara to set
	 */
	public void setInfoDeclara(final DelineacionUInfoDeclara infoDeclara)
	{
		this.infoDeclara = infoDeclara;
	}
	/**
	 * @return the usos
	 */
	public List<DelineacionU2_usos> getUsos()
	{
		return usos;
	}

	/**
	 * @param usos
	 *           the usos to set
	 */
	@JsonProperty("Usos")
	public void setUsos(final List<DelineacionU2_usos> usos)
	{
		this.usos = usos;
	}
	/**
	 * @return the areaIntervenida
	 */
	public List<DelineacionU2_areaIntervenida> getAreaIntervenida()
	{
		return areaIntervenida;
	}

	/**
	 * @param areaIntervenida
	 *           the areaIntervenida to set
	 */
	@JsonProperty("Area_intervenida")
	public void setAreaIntervenida(final List<DelineacionU2_areaIntervenida> areaIntervenida)
	{
		this.areaIntervenida = areaIntervenida;
	}
	/**
	 * @return the areaProyecto
	 */
	public List<DelineacionU2_areaProyecto> getAreaProyecto()
	{
		return areaProyecto;
	}

	/**
	 * @param areaProyecto
	 *           the areaProyecto to set
	 */
	@JsonProperty("Area_proyecto")
	public void setAreaProyecto(final List<DelineacionU2_areaProyecto> areaProyecto)
	{
		this.areaProyecto = areaProyecto;
	}
	/**
	 * @return the relaciones
	 */
	public List<DelineacionURelaciones> getRelaciones()
	{
		return relaciones;
	}

	/**
	 * @param relaciones
	 *           the relaciones to set
	 */
	public void setRelaciones(final List<DelineacionURelaciones> relaciones)
	{
		this.relaciones = relaciones;
	}
	/**
	 * @return the errores
	 */
	public List<ErrorEnWS> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}

	/**
	 * @return the fechaEjecutaria
	 */
	public String getFechaEjecutaria()
	{
		return fechaEjecutaria;
	}

	/**
	 * @param fechaEjecutaria
	 *           the fechaEjecutaria to set
	 */
	@JsonProperty("Fecha_ejecutoria")
	public void setFechaEjecutaria(final String fechaEjecutaria)
	{
		this.fechaEjecutaria = fechaEjecutaria;
	}

	/**
	 * @return the fechaFinalObra
	 */
	public String getFechaFinalObra()
	{
		return fechaFinalObra;
	}

	/**
	 * @param fechaFinalObra
	 *           the fechaFinalObra to set
	 */
	@JsonProperty("Fecha_fin_obra")
	public void setFechaFinalObra(final String fechaFinalObra)
	{
		this.fechaFinalObra = fechaFinalObra;
	}

	/**
	 * @return the fechaUltAbono
	 */
	public String getFechaUltAbono()
	{
		return fechaUltAbono;
	}

	/**
	 * @param fechaUltAbono
	 *           the fechaUltAbono to set
	 */
	@JsonProperty("Fecha_ult_abono")
	public void setFechaUltAbono(final String fechaUltAbono)
	{
		this.fechaUltAbono = fechaUltAbono;
	}

	/**
	 * @return the valorExen
	 */
	public String getValorExen()
	{
		return valorExen;
	}

	/**
	 * @param valorExen
	 *           the valorExen to set
	 */
	@JsonProperty("Valor_exen")
	public void setValorExen(final String valorExen)
	{
		this.valorExen = valorExen;
	}

	/**
	 * @return the valorEjecutado
	 */
	public String getValorEjecutado()
	{
		return valorEjecutado;
	}

	/**
	 * @param valorEjecutado
	 *           the valorEjecutado to set
	 */
	@JsonProperty("Valor_ejecutado")
	public void setValorEjecutado(final String valorEjecutado)
	{
		this.valorEjecutado = valorEjecutado;
	}

	/**
	 * @return the impuestoCargo
	 */
	public String getImpuestoCargo()
	{
		return impuestoCargo;
	}

	/**
	 * @param impuestoCargo
	 *           the impuestoCargo to set
	 */
	@JsonProperty("Impuesto_cargo")
	public void setImpuestoCargo(final String impuestoCargo)
	{
		this.impuestoCargo = impuestoCargo;
	}

	/**
	 * @return the valorSancion
	 */
	public String getValorSancion()
	{
		return valorSancion;
	}

	/**
	 * @param valorSancion
	 *           the valorSancion to set
	 */
	@JsonProperty("Valor_sancion")
	public void setValorSancion(final String valorSancion)
	{
		this.valorSancion = valorSancion;
	}

	/**
	 * @return the saldoImpCargo
	 */
	public String getSaldoImpCargo()
	{
		return saldoImpCargo;
	}

	/**
	 * @param saldoImpCargo
	 *           the saldoImpCargo to set
	 */
	@JsonProperty("Saldo_imp_cargo")
	public void setSaldoImpCargo(final String saldoImpCargo)
	{
		this.saldoImpCargo = saldoImpCargo;
	}

	/**
	 * @return the saldoFavor
	 */
	public String getSaldoFavor()
	{
		return saldoFavor;
	}

	/**
	 * @param saldoFavor
	 *           the saldoFavor to set
	 */
	@JsonProperty("Saldo_favor")
	public void setSaldoFavor(final String saldoFavor)
	{
		this.saldoFavor = saldoFavor;
	}

	/**
	 * @return the valorPagar
	 */
	public String getValorPagar()
	{
		return valorPagar;
	}

	/**
	 * @param valorPagar
	 *           the valorPagar to set
	 */
	@JsonProperty("Valor_pagar")
	public void setValorPagar(final String valorPagar)
	{
		this.valorPagar = valorPagar;
	}

	/**
	 * @return the interesMora
	 */
	public String getInteresMora()
	{
		return interesMora;
	}

	/**
	 * @param interesMora
	 *           the interesMora to set
	 */
	@JsonProperty("Interes_mora")
	public void setInteresMora(final String interesMora)
	{
		this.interesMora = interesMora;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "InfoObjetoDelineacion2Response [anoGravable=" + anoGravable + ", periodo=" + periodo + ", cdu=" + cdu
				+ ", numRadicado=" + numRadicado + ", retencion=" + retencion + ", opcionUso=" + opcionUso + ", tipoLicencia="
				+ tipoLicencia + ", objetoLicen=" + objetoLicen + ", modalidad=" + modalidad + ", presupuestoObra=" + presupuestoObra
				+ ", causalExcep=" + causalExcep + ", firmantes=" + firmantes + ", infoDeclara=" + infoDeclara + ", usos=" + usos
				+ ", areaIntervenida=" + areaIntervenida + ", areaProyecto=" + areaProyecto + ", relaciones=" + relaciones
				+ ", errores=" + errores + ", numForm=" + numForm + ", fechaEjecutaria=" + fechaEjecutaria + ", fechaFinalObra="
				+ fechaFinalObra + ", fechaUltAbono=" + fechaUltAbono + ", totalPresupuesto=" + totalPresupuesto + ", valorExen="
				+ valorExen + ", valorEjecutado=" + valorEjecutado + ", impuestoCargo=" + impuestoCargo + ", valorSancion="
				+ valorSancion + ", totalRetencion=" + totalRetencion + ", saldoImpCargo=" + saldoImpCargo + ", saldoFavor="
				+ saldoFavor + ", valorPagar=" + valorPagar + ", interesMora=" + interesMora + ", totalPagar=" + totalPagar + "]";
	}


}

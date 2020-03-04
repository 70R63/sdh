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
	private String numRadicado;
	private String retencion;
	private String opcionUso;
	private List<FirmanteResponse> firmantes;

	private String totalPresupuesto;
	private String totalRetencion;
	private String totalPagar;


	private String numForm;
	private DelineacionUInfoDeclara infoDeclara;
	private List<DelineacionUUsos> usos;
	private List<DelineacionUAreaIntervenida> areaIntervenida;
	private List<DelineacionUAreaProyecto> areaProyecto;
	private List<DelineacionURelaciones> relaciones;
	private List<ErrorEnWS> errores;

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
	public List<DelineacionUUsos> getUsos()
	{
		return usos;
	}

	/**
	 * @param usos
	 *           the usos to set
	 */
	public void setUsos(final List<DelineacionUUsos> usos)
	{
		this.usos = usos;
	}
	/**
	 * @return the areaIntervenida
	 */
	public List<DelineacionUAreaIntervenida> getAreaIntervenida()
	{
		return areaIntervenida;
	}

	/**
	 * @param areaIntervenida
	 *           the areaIntervenida to set
	 */
	public void setAreaIntervenida(final List<DelineacionUAreaIntervenida> areaIntervenida)
	{
		this.areaIntervenida = areaIntervenida;
	}
	/**
	 * @return the areaProyecto
	 */
	public List<DelineacionUAreaProyecto> getAreaProyecto()
	{
		return areaProyecto;
	}

	/**
	 * @param areaProyecto
	 *           the areaProyecto to set
	 */
	public void setAreaProyecto(final List<DelineacionUAreaProyecto> areaProyecto)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "InfoObjetoDelineacion2Response [anoGravable=" + anoGravable + ", numRadicado=" + numRadicado + ", retencion="
				+ retencion + ", opcionUso=" + opcionUso + ", firmantes=" + firmantes + ", totalPresupuesto=" + totalPresupuesto
				+ ", totalRetencion=" + totalRetencion + ", totalPagar=" + totalPagar + ", numForm=" + numForm + ", infoDeclara="
				+ infoDeclara + ", usos=" + usos + ", areaIntervenida=" + areaIntervenida + ", areaProyecto=" + areaProyecto
				+ ", relaciones=" + relaciones + ", errores=" + errores + "]";
	}


}

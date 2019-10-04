/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class CalcICA2Response
{

	private String anio_gravable;
	private String periodo;
	private String opcion_uso;
	private String cant_establec;
	private String total_ingr_periodo;
	private String deducciones;

	private String totaling_fuera_bog;
	private String totaling_brutos;
	private String Devol_descuentos;
	private String total_deduccion;
	private String totaling_netos;
	private String imp_indus_comer;
	private String impuesto_aviso;
	private String total_unidad_adic;
	private String impuesto_cargo;
	private String valor_rete_indus_comer;
	private String saldo_cargo;
	private String valor_pagar;
	private String sanciones;
	private String interes_mora;
	private String total_pagar;
	private String total_aporte_volun;
	private String proyecto_aporte;
	private String tarifa_aporte;
	private String check_aporte;

	private List<CalcICA2ing_fuera_bogResponse> ing_fuera_bog;
	private List<CalcICA2ing_netos_gravaResponse> ing_netos_grava;
	private List<CalcICA2ing_por_CIIUResponse> ing_por_CIIU;
	private List<FirmanteResponse> firmantes;

	/**
	 * @return the anio_gravable
	 */
	public String getAnio_gravable()
	{
		return anio_gravable;
	}

	/**
	 * @param anio_gravable
	 *           the anio_gravable to set
	 */
	public void setAnio_gravable(final String anio_gravable)
	{
		this.anio_gravable = anio_gravable;
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
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
	}

	/**
	 * @return the opcion_uso
	 */
	public String getOpcion_uso()
	{
		return opcion_uso;
	}

	/**
	 * @param opcion_uso
	 *           the opcion_uso to set
	 */
	public void setOpcion_uso(final String opcion_uso)
	{
		this.opcion_uso = opcion_uso;
	}

	/**
	 * @return the cant_establec
	 */
	public String getCant_establec()
	{
		return cant_establec;
	}

	/**
	 * @param cant_establec
	 *           the cant_establec to set
	 */
	public void setCant_establec(final String cant_establec)
	{
		this.cant_establec = cant_establec;
	}

	/**
	 * @return the total_ingr_periodo
	 */
	public String getTotal_ingr_periodo()
	{
		return total_ingr_periodo;
	}

	/**
	 * @param total_ingr_periodo
	 *           the total_ingr_periodo to set
	 */
	public void setTotal_ingr_periodo(final String total_ingr_periodo)
	{
		this.total_ingr_periodo = total_ingr_periodo;
	}

	/**
	 * @return the deducciones
	 */
	public String getDeducciones()
	{
		return deducciones;
	}

	/**
	 * @param deducciones
	 *           the deducciones to set
	 */
	public void setDeducciones(final String deducciones)
	{
		this.deducciones = deducciones;
	}

	/**
	 * @return the totaling_fuera_bog
	 */
	public String getTotaling_fuera_bog()
	{
		return totaling_fuera_bog;
	}

	/**
	 * @param totaling_fuera_bog
	 *           the totaling_fuera_bog to set
	 */
	public void setTotaling_fuera_bog(final String totaling_fuera_bog)
	{
		this.totaling_fuera_bog = totaling_fuera_bog;
	}

	/**
	 * @return the totaling_brutos
	 */
	public String getTotaling_brutos()
	{
		return totaling_brutos;
	}

	/**
	 * @param totaling_brutos
	 *           the totaling_brutos to set
	 */
	public void setTotaling_brutos(final String totaling_brutos)
	{
		this.totaling_brutos = totaling_brutos;
	}

	/**
	 * @return the devol_descuentos
	 */
	public String getDevol_descuentos()
	{
		return Devol_descuentos;
	}

	/**
	 * @param devol_descuentos
	 *           the devol_descuentos to set
	 */
	public void setDevol_descuentos(final String devol_descuentos)
	{
		Devol_descuentos = devol_descuentos;
	}

	/**
	 * @return the total_deduccion
	 */
	public String getTotal_deduccion()
	{
		return total_deduccion;
	}

	/**
	 * @param total_deduccion
	 *           the total_deduccion to set
	 */
	public void setTotal_deduccion(final String total_deduccion)
	{
		this.total_deduccion = total_deduccion;
	}

	/**
	 * @return the totaling_netos
	 */
	public String getTotaling_netos()
	{
		return totaling_netos;
	}

	/**
	 * @param totaling_netos
	 *           the totaling_netos to set
	 */
	public void setTotaling_netos(final String totaling_netos)
	{
		this.totaling_netos = totaling_netos;
	}

	/**
	 * @return the imp_indus_comer
	 */
	public String getImp_indus_comer()
	{
		return imp_indus_comer;
	}

	/**
	 * @param imp_indus_comer
	 *           the imp_indus_comer to set
	 */
	public void setImp_indus_comer(final String imp_indus_comer)
	{
		this.imp_indus_comer = imp_indus_comer;
	}

	/**
	 * @return the impuesto_aviso
	 */
	public String getImpuesto_aviso()
	{
		return impuesto_aviso;
	}

	/**
	 * @param impuesto_aviso
	 *           the impuesto_aviso to set
	 */
	public void setImpuesto_aviso(final String impuesto_aviso)
	{
		this.impuesto_aviso = impuesto_aviso;
	}

	/**
	 * @return the total_unidad_adic
	 */
	public String getTotal_unidad_adic()
	{
		return total_unidad_adic;
	}

	/**
	 * @param total_unidad_adic
	 *           the total_unidad_adic to set
	 */
	public void setTotal_unidad_adic(final String total_unidad_adic)
	{
		this.total_unidad_adic = total_unidad_adic;
	}

	/**
	 * @return the impuesto_cargo
	 */
	public String getImpuesto_cargo()
	{
		return impuesto_cargo;
	}

	/**
	 * @param impuesto_cargo
	 *           the impuesto_cargo to set
	 */
	public void setImpuesto_cargo(final String impuesto_cargo)
	{
		this.impuesto_cargo = impuesto_cargo;
	}

	/**
	 * @return the valor_rete_indus_comer
	 */
	public String getValor_rete_indus_comer()
	{
		return valor_rete_indus_comer;
	}

	/**
	 * @param valor_rete_indus_comer
	 *           the valor_rete_indus_comer to set
	 */
	public void setValor_rete_indus_comer(final String valor_rete_indus_comer)
	{
		this.valor_rete_indus_comer = valor_rete_indus_comer;
	}

	/**
	 * @return the saldo_cargo
	 */
	public String getSaldo_cargo()
	{
		return saldo_cargo;
	}

	/**
	 * @param saldo_cargo
	 *           the saldo_cargo to set
	 */
	public void setSaldo_cargo(final String saldo_cargo)
	{
		this.saldo_cargo = saldo_cargo;
	}

	/**
	 * @return the valor_pagar
	 */
	public String getValor_pagar()
	{
		return valor_pagar;
	}

	/**
	 * @param valor_pagar
	 *           the valor_pagar to set
	 */
	public void setValor_pagar(final String valor_pagar)
	{
		this.valor_pagar = valor_pagar;
	}

	/**
	 * @return the sanciones
	 */
	public String getSanciones()
	{
		return sanciones;
	}

	/**
	 * @param sanciones
	 *           the sanciones to set
	 */
	public void setSanciones(final String sanciones)
	{
		this.sanciones = sanciones;
	}

	/**
	 * @return the interes_mora
	 */
	public String getInteres_mora()
	{
		return interes_mora;
	}

	/**
	 * @param interes_mora
	 *           the interes_mora to set
	 */
	public void setInteres_mora(final String interes_mora)
	{
		this.interes_mora = interes_mora;
	}

	/**
	 * @return the total_pagar
	 */
	public String getTotal_pagar()
	{
		return total_pagar;
	}

	/**
	 * @param total_pagar
	 *           the total_pagar to set
	 */
	public void setTotal_pagar(final String total_pagar)
	{
		this.total_pagar = total_pagar;
	}

	/**
	 * @return the total_aporte_volun
	 */
	public String getTotal_aporte_volun()
	{
		return total_aporte_volun;
	}

	/**
	 * @param total_aporte_volun
	 *           the total_aporte_volun to set
	 */
	public void setTotal_aporte_volun(final String total_aporte_volun)
	{
		this.total_aporte_volun = total_aporte_volun;
	}

	/**
	 * @return the proyecto_aporte
	 */
	public String getProyecto_aporte()
	{
		return proyecto_aporte;
	}

	/**
	 * @param proyecto_aporte
	 *           the proyecto_aporte to set
	 */
	public void setProyecto_aporte(final String proyecto_aporte)
	{
		this.proyecto_aporte = proyecto_aporte;
	}

	/**
	 * @return the tarifa_aporte
	 */
	public String getTarifa_aporte()
	{
		return tarifa_aporte;
	}

	/**
	 * @param tarifa_aporte
	 *           the tarifa_aporte to set
	 */
	public void setTarifa_aporte(final String tarifa_aporte)
	{
		this.tarifa_aporte = tarifa_aporte;
	}

	/**
	 * @return the check_aporte
	 */
	public String getCheck_aporte()
	{
		return check_aporte;
	}

	/**
	 * @param check_aporte
	 *           the check_aporte to set
	 */
	public void setCheck_aporte(final String check_aporte)
	{
		this.check_aporte = check_aporte;
	}

	/**
	 * @return the ing_netos_grava
	 */
	public List<CalcICA2ing_netos_gravaResponse> getIng_netos_grava()
	{
		return ing_netos_grava;
	}

	/**
	 * @param ing_netos_grava
	 *           the ing_netos_grava to set
	 */
	public void setIng_netos_grava(final List<CalcICA2ing_netos_gravaResponse> ing_netos_grava)
	{
		this.ing_netos_grava = ing_netos_grava;
	}

	/**
	 * @return the ing_por_CIIU
	 */
	public List<CalcICA2ing_por_CIIUResponse> getIng_por_CIIU()
	{
		return ing_por_CIIU;
	}

	/**
	 * @param ing_por_CIIU
	 *           the ing_por_CIIU to set
	 */
	public void setIng_por_CIIU(final List<CalcICA2ing_por_CIIUResponse> ing_por_CIIU)
	{
		this.ing_por_CIIU = ing_por_CIIU;
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
	public void setFirmantes(final List<FirmanteResponse> firmantes)
	{
		this.firmantes = firmantes;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CalcICA2Response [anio_gravable=" + anio_gravable + ", periodo=" + periodo + ", opcion_uso=" + opcion_uso
				+ ", cant_establec=" + cant_establec + ", total_ingr_periodo=" + total_ingr_periodo + ", ing_fuera_bog="
				+ ing_fuera_bog + ", deducciones=" + deducciones + ", totaling_fuera_bog=" + totaling_fuera_bog + ", totaling_brutos="
				+ totaling_brutos + ", Devol_descuentos=" + Devol_descuentos + ", total_deduccion=" + total_deduccion
				+ ", totaling_netos=" + totaling_netos + ", imp_indus_comer=" + imp_indus_comer + ", impuesto_aviso=" + impuesto_aviso
				+ ", total_unidad_adic=" + total_unidad_adic + ", impuesto_cargo=" + impuesto_cargo + ", valor_rete_indus_comer="
				+ valor_rete_indus_comer + ", saldo_cargo=" + saldo_cargo + ", valor_pagar=" + valor_pagar + ", sanciones="
				+ sanciones + ", interes_mora=" + interes_mora + ", total_pagar=" + total_pagar + ", total_aporte_volun="
				+ total_aporte_volun + ", proyecto_aporte=" + proyecto_aporte + ", tarifa_aporte=" + tarifa_aporte + ", check_aporte="
				+ check_aporte + ", ing_netos_grava=" + ing_netos_grava + ", ing_por_CIIU=" + ing_por_CIIU + ", firmantes="
				+ firmantes + "]";
	}

}

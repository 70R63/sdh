/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author Maria Luisa
 *
 */
public class CalcGasolina2Response
{

	private String anio_gravable;
	private String periodo;
	private String opcion_uso;
	private String total_sobretasa;
	private String vlr_sanc_totales;
	private String total_cargo;
	private String vlr_sobrestasa;
	private String vlr_sanc_pagos;
	private String interes_mora;

	private List<DetGasInfoDeclaraResponse> info_declara;

	private List<FirmanteResponse> firmantes;

	public String getAnio_gravable() {
		return anio_gravable;
	}

	public void setAnio_gravable(final String anio_gravable) {
		this.anio_gravable = anio_gravable;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(final String periodo) {
		this.periodo = periodo;
	}

	public String getOpcion_uso() {
		return opcion_uso;
	}

	public void setOpcion_uso(final String opcion_uso) {
		this.opcion_uso = opcion_uso;
	}

	public String getTotal_sobretasa() {
		return total_sobretasa;
	}

	public void setTotal_sobretasa(final String total_sobretasa) {
		this.total_sobretasa = total_sobretasa;
	}

	public String getVlr_sanc_totales() {
		return vlr_sanc_totales;
	}

	public void setVlr_sanc_totales(final String vlr_sanc_totales) {
		this.vlr_sanc_totales = vlr_sanc_totales;
	}

	public String getTotal_cargo() {
		return total_cargo;
	}

	public void setTotal_cargo(final String total_cargo) {
		this.total_cargo = total_cargo;
	}

	public String getVlr_sobrestasa() {
		return vlr_sobrestasa;
	}

	public void setVlr_sobrestasa(final String vlr_sobrestasa) {
		this.vlr_sobrestasa = vlr_sobrestasa;
	}

	public String getVlr_sanc_pagos() {
		return vlr_sanc_pagos;
	}

	public void setVlr_sanc_pagos(final String vlr_sanc_pagos) {
		this.vlr_sanc_pagos = vlr_sanc_pagos;
	}

	public String getInteres_mora() {
		return interes_mora;
	}

	public void setInteres_mora(final String interes_mora) {
		this.interes_mora = interes_mora;
	}

	/**
	 * @return the info_declara
	 */
	public List<DetGasInfoDeclaraResponse> getInfo_declara()
	{
		return info_declara;
	}

	/**
	 * @param info_declara
	 *           the info_declara to set
	 */
	public void setInfo_declara(final List<DetGasInfoDeclaraResponse> info_declara)
	{
		this.info_declara = info_declara;
	}

	public List<FirmanteResponse> getFirmantes() {
		return firmantes;
	}

	@JsonProperty("firmantes")
	public void setFirmantes(final List<FirmanteResponse> firmantes) {
		this.firmantes = firmantes;
	}
}

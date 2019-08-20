/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class CalcPublicidad2Response
{


	private String Anio_gravable;
	private String Opcion_uso;
	private String Num_resolu;
	private String Fech_notif;
	private String Lugar_instala;
	private String Orientacion_valla;
	private String Tamanio_valla;
	private String Imp_cargo;
	private String Vlr_sancion;
	private String Vlr_pagar;
	private String Interes_mora;
	private String Total_pagar;
	private String tipoValla;
	private List<FirmanteResponse> Firmantes;

	public String getTipoValla() {
		return tipoValla;
	}

	public void setTipoValla(String tipoValla) {
		this.tipoValla = tipoValla;
	}

	public String getAnio_gravable() {
		return Anio_gravable;
	}

	@JsonProperty("Anio_gravable")
	public void setAnio_gravable(String anio_gravable) {
		Anio_gravable = anio_gravable;
	}

	public String getOpcion_uso() {
		return Opcion_uso;
	}

	@JsonProperty("Opcion_uso")
	public void setOpcion_uso(String opcion_uso) {
		Opcion_uso = opcion_uso;
	}

	public String getNum_resolu() {
		return Num_resolu;
	}

	@JsonProperty("Num_resolu")
	public void setNum_resolu(String num_resolu) {
		Num_resolu = num_resolu;
	}

	public String getFech_notif() {
		return Fech_notif;
	}

	@JsonProperty("Fech_notif")
	public void setFech_notif(String fech_notif) {
		Fech_notif = fech_notif;
	}

	public String getLugar_instala() {
		return Lugar_instala;
	}

	@JsonProperty("Lugar_instala")
	public void setLugar_instala(String lugar_instala) {
		Lugar_instala = lugar_instala;
	}

	public String getOrientacion_valla() {
		return Orientacion_valla;
	}

	@JsonProperty("Orientacion_valla")
	public void setOrientacion_valla(String orientacion_valla) {
		Orientacion_valla = orientacion_valla;
	}

	public String getTamanio_valla() {
		return Tamanio_valla;
	}

	@JsonProperty("Tamanio_valla")
	public void setTamanio_valla(String tamanio_valla) {
		Tamanio_valla = tamanio_valla;
	}

	public String getImp_cargo() {
		return Imp_cargo;
	}

	@JsonProperty("Imp_cargo")
	public void setImp_cargo(String imp_cargo) {
		Imp_cargo = imp_cargo;
	}

	public String getVlr_sancion() {
		return Vlr_sancion;
	}

	@JsonProperty("Vlr_sancion")
	public void setVlr_sancion(String vlr_sancion) {
		Vlr_sancion = vlr_sancion;
	}

	public String getVlr_pagar() {
		return Vlr_pagar;
	}

	@JsonProperty("Vlr_pagar")
	public void setVlr_pagar(String vlr_pagar) {
		Vlr_pagar = vlr_pagar;
	}

	public String getInteres_mora() {
		return Interes_mora;
	}

	@JsonProperty("Interes_mora")
	public void setInteres_mora(String interes_mora) {
		Interes_mora = interes_mora;
	}

	public String getTotal_pagar() {
		return Total_pagar;
	}

	@JsonProperty("Total_pagar")
	public void setTotal_pagar(String total_pagar) {
		Total_pagar = total_pagar;
	}

	public List<FirmanteResponse> getFirmantes() {
		return Firmantes;
	}

	@JsonProperty("Firmantes")
	public void setFirmantes(List<FirmanteResponse> firmantes) {
		Firmantes = firmantes;
	}
}

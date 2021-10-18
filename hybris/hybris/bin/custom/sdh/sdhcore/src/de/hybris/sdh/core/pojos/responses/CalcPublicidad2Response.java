/**
 *
 */
package de.hybris.sdh.core.pojos.responses;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;


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

	public String getTipoValla()
	{
		return tipoValla;
	}

	public void setTipoValla(final String tipoValla)
	{
		this.tipoValla = tipoValla;
	}

	public String getAnio_gravable()
	{
		return Anio_gravable;
	}

	@JsonSetter("Anio_gravable")
	public void setAnio_gravable(final String anio_gravable)
	{
		Anio_gravable = anio_gravable;
	}

	public String getOpcion_uso()
	{
		return Opcion_uso;
	}

	@JsonSetter("Opcion_uso")
	public void setOpcion_uso(final String opcion_uso)
	{
		Opcion_uso = opcion_uso;
	}

	public String getNum_resolu()
	{
		return Num_resolu;
	}

	@JsonSetter("Num_resolu")
	public void setNum_resolu(final String num_resolu)
	{
		Num_resolu = num_resolu;
	}

	public String getFech_notif()
	{
		return Fech_notif;
	}

	@JsonSetter("Fech_notif")
	public void setFech_notif(final String fech_notif)
	{
		Fech_notif = fech_notif;
	}

	public String getLugar_instala()
	{
		return Lugar_instala;
	}

	@JsonSetter("Lugar_instala")
	public void setLugar_instala(final String lugar_instala)
	{
		Lugar_instala = lugar_instala;
	}

	public String getOrientacion_valla()
	{
		return Orientacion_valla;
	}

	@JsonSetter("Orientacion_valla")
	public void setOrientacion_valla(final String orientacion_valla)
	{
		Orientacion_valla = orientacion_valla;
	}

	public String getTamanio_valla()
	{
		return Tamanio_valla;
	}

	@JsonSetter("Tamanio_valla")
	public void setTamanio_valla(final String tamanio_valla)
	{
		Tamanio_valla = tamanio_valla;
	}

	public String getImp_cargo()
	{
		return Imp_cargo;
	}

	@JsonSetter("Imp_cargo")
	public void setImp_cargo(final String imp_cargo)
	{
		Imp_cargo = imp_cargo;
	}

	public String getVlr_sancion()
	{
		return Vlr_sancion;
	}

	@JsonSetter("Vlr_sancion")
	public void setVlr_sancion(final String vlr_sancion)
	{
		Vlr_sancion = vlr_sancion;
	}

	public String getVlr_pagar()
	{
		return Vlr_pagar;
	}

	@JsonSetter("Vlr_pagar")
	public void setVlr_pagar(final String vlr_pagar)
	{
		Vlr_pagar = vlr_pagar;
	}

	public String getInteres_mora()
	{
		return Interes_mora;
	}

	@JsonSetter("Interes_mora")
	public void setInteres_mora(final String interes_mora)
	{
		Interes_mora = interes_mora;
	}

	public String getTotal_pagar()
	{
		return Total_pagar;
	}

	@JsonSetter("Total_pagar")
	public void setTotal_pagar(final String total_pagar)
	{
		Total_pagar = total_pagar;
	}

	public List<FirmanteResponse> getFirmantes()
	{
		return Firmantes;
	}

	@JsonSetter("Firmantes")
	public void setFirmantes(final List<FirmanteResponse> firmantes)
	{
		Firmantes = firmantes;
	}
}

package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;


public class FirmanteResponse
{

	private String tipoIdent;
	private String numIdent;
	private String nombre;
	private String tarjetaProd;


	public String getTipoIdent()
	{
		return tipoIdent;
	}

	@JsonSetter("Tipo_ident")
	public void setTipoIdent(final String tipoIdent)
	{
		this.tipoIdent = tipoIdent;
	}

	public String getNumIdent()
	{
		return numIdent;
	}

	@JsonSetter("Num_identif")
	public void setNumIdent(final String numIdent)
	{
		this.numIdent = numIdent;
	}

	public String getNombre()
	{
		return nombre;
	}

	@JsonSetter("Nombre")
	public void setNombre(final String nombre)
	{
		this.nombre = nombre;
	}

	public String getTarjetaProd()
	{
		return tarjetaProd;
	}

	@JsonSetter("Tarjeta_prof")
	public void setTarjetaProd(final String tarjetaProd)
	{
		this.tarjetaProd = tarjetaProd;
	}
}

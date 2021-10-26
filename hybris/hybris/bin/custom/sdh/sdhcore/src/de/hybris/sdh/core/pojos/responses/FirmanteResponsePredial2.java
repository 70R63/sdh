package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;

public class FirmanteResponsePredial2 {

	private String tipoIdent;
	private String numIdent;
	private String nombre;
	private String tarjetaProd;


	public String getTipoIdent()
	{
		return tipoIdent;
	}

	@JsonSetter("tipoIdent")
	public void setTipoIdent(final String tipoIdent)
	{
		this.tipoIdent = tipoIdent;
	}

	public String getNumIdent()
	{
		return numIdent;
	}

	@JsonSetter("numIdentif")
	public void setNumIdent(final String numIdent)
	{
		this.numIdent = numIdent;
	}

	public String getNombre()
	{
		return nombre;
	}

	@JsonSetter("nombre")
	public void setNombre(final String nombre)
	{
		this.nombre = nombre;
	}

	public String getTarjetaProd()
	{
		return tarjetaProd;
	}

	@JsonSetter("tarjetaProf")
	public void setTarjetaProd(final String tarjetaProd)
	{
		this.tarjetaProd = tarjetaProd;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "FirmanteResponsePredial2 [tipoIdent=" + tipoIdent + ", numIdent=" + numIdent + ", nombre=" + nombre
				+ ", tarjetaProd=" + tarjetaProd + "]";
	}


}

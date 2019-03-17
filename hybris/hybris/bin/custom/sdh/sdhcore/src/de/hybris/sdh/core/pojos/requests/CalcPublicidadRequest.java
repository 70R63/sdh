/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hybris
 *
 */
public class CalcPublicidadRequest
{
	private String numBP;
	private String numResolu;
	private String numForm;
	private String anoGravable;
	private String opcionUso;
	private String fechNotif;
	private String lugarInstala;
	private String direccion;
	private String placa;
	private String orientacionValla;
	private String tamanoValla;
	private String tipoIDcontrib;
	private String IDcontrib;
	private String municipioContrib;
	private String tipoIDdeclara;
	private String IDdeclarante;




	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}




	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}




	/**
	 * @return the numResolu
	 */
	public String getNumResolu()
	{
		return numResolu;
	}




	/**
	 * @param numResolu
	 *           the numResolu to set
	 */
	public void setNumResolu(final String numResolu)
	{
		this.numResolu = numResolu;
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
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
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
	public void setOpcionUso(final String opcionUso)
	{
		this.opcionUso = opcionUso;
	}




	/**
	 * @return the fechNotif
	 */
	public String getFechNotif()
	{
		return fechNotif;
	}




	/**
	 * @param fechNotif
	 *           the fechNotif to set
	 */
	public void setFechNotif(final String fechNotif)
	{
		this.fechNotif = fechNotif;
	}




	/**
	 * @return the lugarInstala
	 */
	public String getLugarInstala()
	{
		return lugarInstala;
	}




	/**
	 * @param lugarInstala
	 *           the lugarInstala to set
	 */
	public void setLugarInstala(final String lugarInstala)
	{
		this.lugarInstala = lugarInstala;
	}




	/**
	 * @return the direccion
	 */
	public String getDireccion()
	{
		return direccion;
	}




	/**
	 * @param direccion
	 *           the direccion to set
	 */
	public void setDireccion(final String direccion)
	{
		this.direccion = direccion;
	}




	/**
	 * @return the placa
	 */
	public String getPlaca()
	{
		return placa;
	}




	/**
	 * @param placa
	 *           the placa to set
	 */
	public void setPlaca(final String placa)
	{
		this.placa = placa;
	}




	/**
	 * @return the orientacionValla
	 */
	public String getOrientacionValla()
	{
		return orientacionValla;
	}




	/**
	 * @param orientacionValla
	 *           the orientacionValla to set
	 */
	public void setOrientacionValla(final String orientacionValla)
	{
		this.orientacionValla = orientacionValla;
	}




	/**
	 * @return the tamanoValla
	 */
	public String getTamanoValla()
	{
		return tamanoValla;
	}




	/**
	 * @param tamanoValla
	 *           the tamanoValla to set
	 */
	public void setTamanoValla(final String tamanoValla)
	{
		this.tamanoValla = tamanoValla;
	}




	/**
	 * @return the tipoIDcontrib
	 */
	public String getTipoIDcontrib()
	{
		return tipoIDcontrib;
	}




	/**
	 * @param tipoIDcontrib
	 *           the tipoIDcontrib to set
	 */
	public void setTipoIDcontrib(final String tipoIDcontrib)
	{
		this.tipoIDcontrib = tipoIDcontrib;
	}




	/**
	 * @return the iDcontrib
	 */
	public String getIDcontrib()
	{
		return IDcontrib;
	}




	/**
	 * @param iDcontrib
	 *           the iDcontrib to set
	 */
	public void setIDcontrib(final String iDcontrib)
	{
		IDcontrib = iDcontrib;
	}




	/**
	 * @return the municipioContrib
	 */
	public String getMunicipioContrib()
	{
		return municipioContrib;
	}




	/**
	 * @param municipioContrib
	 *           the municipioContrib to set
	 */
	public void setMunicipioContrib(final String municipioContrib)
	{
		this.municipioContrib = municipioContrib;
	}




	/**
	 * @return the tipoIDdeclara
	 */
	public String getTipoIDdeclara()
	{
		return tipoIDdeclara;
	}




	/**
	 * @param tipoIDdeclara
	 *           the tipoIDdeclara to set
	 */
	public void setTipoIDdeclara(final String tipoIDdeclara)
	{
		this.tipoIDdeclara = tipoIDdeclara;
	}




	/**
	 * @return the iDdeclarante
	 */
	public String getIDdeclarante()
	{
		return IDdeclarante;
	}




	/**
	 * @param iDdeclarante
	 *           the iDdeclarante to set
	 */
	public void setIDdeclarante(final String iDdeclarante)
	{
		IDdeclarante = iDdeclarante;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" +((StringUtils.isBlank( this.getNumBP())) ? "" :  this.getNumBP()) + "\",");
		stringBuilder.append("\"numResolu\":\"" +((StringUtils.isBlank( this.getNumResolu())) ? "" :  this.getNumResolu()) + "\",");
		stringBuilder.append("\"anoGravable\":\"" +((StringUtils.isBlank(this.getAnoGravable())) ? "" : this.getAnoGravable())  + "\",");
		stringBuilder.append("\"opcionUso\":\"" +((StringUtils.isBlank(this.getOpcionUso())) ? "" : this.getOpcionUso() ) + "\",");
		stringBuilder.append("\"fechNotif\":\"" +((StringUtils.isBlank(this.getFechNotif())) ? "" :this.getFechNotif())  + "\",");
		stringBuilder.append("\"lugarInstala\":\"" +((StringUtils.isBlank(this.getLugarInstala())) ? "" : this.getLugarInstala())  + "\",");
		stringBuilder.append("\"direccion\":\"" + ((StringUtils.isBlank( this.getDireccion())) ? "" :  this.getDireccion()) + "\",");
		stringBuilder.append("\"placa\":\"" +((StringUtils.isBlank(this.getPlaca())) ? "" : this.getPlaca())  + "\",");
		stringBuilder.append("\"orientacionValla\":\"" +((StringUtils.isBlank(this.getOrientacionValla())) ? "" : this.getOrientacionValla())  + "\",");
		stringBuilder.append("\"tamanoValla\":\"" +((StringUtils.isBlank(this.getTamanoValla())) ? "" : this.getTamanoValla())  + "\",");
		stringBuilder.append("\"tipoIDcontrib\":\"" +((StringUtils.isBlank(this.getTipoIDcontrib())) ? "" : this.getTipoIDcontrib())  + "\",");
		stringBuilder.append("\"IDcontrib\":\"" +((StringUtils.isBlank(this.getIDcontrib())) ? "" : this.getIDcontrib())  + "\",");
		stringBuilder.append("\"municipioContrib\":\"" +((StringUtils.isBlank(this.getMunicipioContrib())) ? "" : this.getMunicipioContrib())  + "\",");
		stringBuilder.append("\"tipoIDdeclara\":\"" +((StringUtils.isBlank(this.getTipoIDdeclara())) ? "" : this.getTipoIDdeclara())  + "\",");
		stringBuilder.append(
				"\"IDdeclarante\":\"" + ((StringUtils.isBlank(this.getIDdeclarante())) ? "" : this.getIDdeclarante()) + "\",");
		stringBuilder.append("\"numForm\":\"" + ((StringUtils.isBlank(this.getNumForm())) ? "" : this.getNumForm()) + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
}

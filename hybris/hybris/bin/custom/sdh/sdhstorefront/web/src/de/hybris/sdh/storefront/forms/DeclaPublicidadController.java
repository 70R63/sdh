/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.DetallePubli;
import de.hybris.sdh.core.pojos.responses.InfoDeclaraPubli;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class DeclaPublicidadController
{
	private String numBP;
	private String numform;
	private String anograv;
	private String numresol;
	private String fecresol;
	private String fechnotif;
	private String orValla;
	private String luginst;
	private String basegrav;
	private String opuso;
	private String impCar;
	private String valsan;
	private String valpag;
	private String intmora;
	private String totpag;
	private String tipiden;
	private String numide;
	private String name;
	private String refe;
	private String placa;
	private String direccion;
	private String tamValla;
	private String municipioContrib;
	private String tipoIDdeclara;
	private String idDeclarante;

	private String vigenDesde;
	private String vigenHasta;

	private InfoDeclaraPubli infoDeclara;
	private List<DetallePubli> detalle;
	private PublicidadExteriorCatalogos catalogos;

	private String idNumber;
	private String idType;

	/**
	 * @return the catalogos
	 */
	public PublicidadExteriorCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final PublicidadExteriorCatalogos catalogos)
	{
		this.catalogos = catalogos;
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
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}


	/**
	 * @return the numform
	 */
	public String getNumform()
	{
		return numform;
	}

	/**
	 * @param numform
	 *           the numform to set
	 */
	public void setNumform(final String numform)
	{
		this.numform = numform;
	}

	/**
	 * @return the anograv
	 */
	public String getAnograv()
	{
		return anograv;
	}

	/**
	 * @param anograv
	 *           the anograv to set
	 */
	public void setAnograv(final String anograv)
	{
		this.anograv = anograv;
	}

	/**
	 * @return the numresol
	 */
	public String getNumresol()
	{
		return numresol;
	}

	/**
	 * @param numresol
	 *           the numresol to set
	 */
	public void setNumresol(final String numresol)
	{
		this.numresol = numresol;
	}



	/**
	 * @return the fecresol
	 */
	public String getFecresol()
	{
		return fecresol;
	}

	/**
	 * @param fecresol
	 *           the fecresol to set
	 */
	public void setFecresol(final String fecresol)
	{
		this.fecresol = fecresol;
	}

	/**
	 * @return the fechnotif
	 */
	public String getFechnotif()
	{
		return fechnotif;
	}

	/**
	 * @param fechnotif
	 *           the fechnotif to set
	 */
	public void setFechnotif(final String fechnotif)
	{
		this.fechnotif = fechnotif;
	}



	/**
	 * @return the orValla
	 */
	public String getOrValla()
	{
		return orValla;
	}

	/**
	 * @param orValla
	 *           the orValla to set
	 */
	public void setOrValla(final String orValla)
	{
		this.orValla = orValla;
	}

	/**
	 * @return the luginst
	 */
	public String getLuginst()
	{
		return luginst;
	}

	/**
	 * @param luginst
	 *           the luginst to set
	 */
	public void setLuginst(final String luginst)
	{
		this.luginst = luginst;
	}

	/**
	 * @return the basegrav
	 */
	public String getBasegrav()
	{
		return basegrav;
	}

	/**
	 * @param basegrav
	 *           the basegrav to set
	 */
	public void setBasegrav(final String basegrav)
	{
		this.basegrav = basegrav;
	}

	/**
	 * @return the opuso
	 */
	public String getOpuso()
	{
		return opuso;
	}

	/**
	 * @param opuso
	 *           the opuso to set
	 */
	public void setOpuso(final String opuso)
	{
		this.opuso = opuso;
	}

	/**
	 * @return the impCar
	 */
	public String getImpCar()
	{
		return impCar;
	}

	/**
	 * @param impCar
	 *           the impCar to set
	 */
	public void setImpCar(final String impCar)
	{
		this.impCar = impCar;
	}

	/**
	 * @return the valsan
	 */
	public String getValsan()
	{
		return valsan;
	}

	/**
	 * @param valsan
	 *           the valsan to set
	 */
	public void setValsan(final String valsan)
	{
		this.valsan = valsan;
	}

	/**
	 * @return the valpag
	 */
	public String getValpag()
	{
		return valpag;
	}

	/**
	 * @param valpag
	 *           the valpag to set
	 */
	public void setValpag(final String valpag)
	{
		this.valpag = valpag;
	}

	/**
	 * @return the intmora
	 */
	public String getIntmora()
	{
		return intmora;
	}

	/**
	 * @param intmora
	 *           the intmora to set
	 */
	public void setIntmora(final String intmora)
	{
		this.intmora = intmora;
	}

	/**
	 * @return the totpag
	 */
	public String getTotpag()
	{
		return totpag;
	}

	/**
	 * @param totpag
	 *           the totpag to set
	 */
	public void setTotpag(final String totpag)
	{
		this.totpag = totpag;
	}

	/**
	 * @return the tipiden
	 */
	public String getTipiden()
	{
		return tipiden;
	}

	/**
	 * @param tipiden
	 *           the tipiden to set
	 */
	public void setTipiden(final String tipiden)
	{
		this.tipiden = tipiden;
	}

	/**
	 * @return the numide
	 */
	public String getNumide()
	{
		return numide;
	}

	/**
	 * @param numide
	 *           the numide to set
	 */
	public void setNumide(final String numide)
	{
		this.numide = numide;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the refe
	 */
	public String getRefe()
	{
		return refe;
	}

	/**
	 * @param refe
	 *           the refe to set
	 */
	public void setRefe(final String refe)
	{
		this.refe = refe;
	}

	/**
	 * @return the vigenDesde
	 */
	public String getVigenDesde()
	{
		return vigenDesde;
	}

	/**
	 * @param vigenDesde
	 *           the vigenDesde to set
	 */
	public void setVigenDesde(final String vigenDesde)
	{
		this.vigenDesde = vigenDesde;
	}

	/**
	 * @return the vigenHasta
	 */
	public String getVigenHasta()
	{
		return vigenHasta;
	}

	/**
	 * @param vigenHasta
	 *           the vigenHasta to set
	 */
	public void setVigenHasta(final String vigenHasta)
	{
		this.vigenHasta = vigenHasta;
	}





	/**
	 * @return the infoDeclara
	 */
	public InfoDeclaraPubli getInfoDeclara()
	{
		return infoDeclara;
	}

	/**
	 * @param infoDeclara
	 *           the infoDeclara to set
	 */
	public void setInfoDeclara(final InfoDeclaraPubli infoDeclara)
	{
		this.infoDeclara = infoDeclara;
	}

	/**
	 * @return the detalle
	 */
	public List<DetallePubli> getDetalle()
	{
		return detalle;
	}

	/**
	 * @param detalle
	 *           the detalle to set
	 */
	public void setDetalle(final List<DetallePubli> detalle)
	{
		this.detalle = detalle;
	}

	/**
	 * @return the idNumber
	 */
	public String getIdNumber()
	{
		return idNumber;
	}

	/**
	 * @param idNumber
	 *           the idNumber to set
	 */
	public void setIdNumber(final String idNumber)
	{
		this.idNumber = idNumber;
	}

	/**
	 * @return the idType
	 */
	public String getIdType()
	{
		return idType;
	}

	/**
	 * @param idType
	 *           the idType to set
	 */
	public void setIdType(final String idType)
	{
		this.idType = idType;
	}

	/**
	 * @return the tamValla
	 */
	public String getTamValla()
	{
		return tamValla;
	}

	/**
	 * @param tamValla
	 *           the tamValla to set
	 */
	public void setTamValla(final String tamValla)
	{
		this.tamValla = tamValla;
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
	 * @return the idDeclarante
	 */
	public String getIdDeclarante()
	{
		return idDeclarante;
	}

	/**
	 * @param idDeclarante
	 *           the idDeclarante to set
	 */
	public void setIdDeclarante(final String idDeclarante)
	{
		this.idDeclarante = idDeclarante;
	}



}

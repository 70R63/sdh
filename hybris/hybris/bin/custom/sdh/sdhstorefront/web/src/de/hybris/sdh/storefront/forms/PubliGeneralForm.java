/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.CalcPublicidadResponse;
import de.hybris.sdh.core.pojos.responses.DetallePubli;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.InfoDeclaraPubli;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class PubliGeneralForm
{
	private String numBP;
	private String numResolu;
	private String fechResolu;
	private String fechNotif;
	private String vigenDesde;
	private String vigenHasta;
	private String tipoSolicitud;
	private String tamanoValla;
	private String tipoIDdeclara;
	private String iddeclarante;
	private String numForm;
	private String tipoElemento;
	private String avisoLumino;
	private String ubicacion;
	private String chip;
	private String matricula;
	private String direccion;
	private String localidad;
	private String codPostal;
	private String areaElemento;
	private String areaFachada;
	private String numFracciones;
	private String tipoPublici;
	private String numCaras;
	private String periodicidad;
	private String modelo;
	private String placa;
	private String numLicenciaTrans;
	private String tipoServicio;
	private String contratoObra;
	private String fiducia;
	private String licenciaUrb;
	private String licenciaConstruc;
	private String areaTotal;
	private String orientacion;
	private String vigLicenConstruc;
	private String tipoVia;
	private String tipoValla;
	private String anograv;
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
	private List<DetallePubli> detalle;
	private PublicidadExteriorCatalogos catalogos;
	private List<ImpuestoPublicidadExterior> publicidadExt;
	private InfoDeclaraPubli infodeclara;
	private DetallePublicidadResponse detalleResponse;
	private CalcPublicidadResponse calculoResponse;
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
	 * @return the fechResolu
	 */
	public String getFechResolu()
	{
		return fechResolu;
	}
	
	/**
	 * @param fechResolu
	 *           the fechResolu to set
	 */
	public void setFechResolu(final String fechResolu)
	{
		this.fechResolu = fechResolu;
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
	 * @return the tipoSolicitud
	 */
	public String getTipoSolicitud()
	{
		return tipoSolicitud;
	}
	
	/**
	 * @param tipoSolicitud
	 *           the tipoSolicitud to set
	 */
	public void setTipoSolicitud(final String tipoSolicitud)
	{
		this.tipoSolicitud = tipoSolicitud;
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
	 * @return the iddeclarante
	 */
	public String getIddeclarante()
	{
		return iddeclarante;
	}
	
	/**
	 * @param iddeclarante
	 *           the iddeclarante to set
	 */
	public void setIddeclarante(final String iddeclarante)
	{
		this.iddeclarante = iddeclarante;
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
	 * @return the tipoElemento
	 */
	public String getTipoElemento()
	{
		return tipoElemento;
	}
	
	/**
	 * @param tipoElemento
	 *           the tipoElemento to set
	 */
	public void setTipoElemento(final String tipoElemento)
	{
		this.tipoElemento = tipoElemento;
	}
	/**
	 * @return the avisoLumino
	 */
	public String getAvisoLumino()
	{
		return avisoLumino;
	}
	
	/**
	 * @param avisoLumino
	 *           the avisoLumino to set
	 */
	public void setAvisoLumino(final String avisoLumino)
	{
		this.avisoLumino = avisoLumino;
	}
	/**
	 * @return the ubicacion
	 */
	public String getUbicacion()
	{
		return ubicacion;
	}
	
	/**
	 * @param ubicacion
	 *           the ubicacion to set
	 */
	public void setUbicacion(final String ubicacion)
	{
		this.ubicacion = ubicacion;
	}
	/**
	 * @return the chip
	 */
	public String getChip()
	{
		return chip;
	}
	
	/**
	 * @param chip
	 *           the chip to set
	 */
	public void setChip(final String chip)
	{
		this.chip = chip;
	}
	/**
	 * @return the matricula
	 */
	public String getMatricula()
	{
		return matricula;
	}
	
	/**
	 * @param matricula
	 *           the matricula to set
	 */
	public void setMatricula(final String matricula)
	{
		this.matricula = matricula;
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
	 * @return the localidad
	 */
	public String getLocalidad()
	{
		return localidad;
	}
	
	/**
	 * @param localidad
	 *           the localidad to set
	 */
	public void setLocalidad(final String localidad)
	{
		this.localidad = localidad;
	}
	/**
	 * @return the codPostal
	 */
	public String getCodPostal()
	{
		return codPostal;
	}
	
	/**
	 * @param codPostal
	 *           the codPostal to set
	 */
	public void setCodPostal(final String codPostal)
	{
		this.codPostal = codPostal;
	}
	/**
	 * @return the areaElemento
	 */
	public String getAreaElemento()
	{
		return areaElemento;
	}
	
	/**
	 * @param areaElemento
	 *           the areaElemento to set
	 */
	public void setAreaElemento(final String areaElemento)
	{
		this.areaElemento = areaElemento;
	}
	/**
	 * @return the areaFachada
	 */
	public String getAreaFachada()
	{
		return areaFachada;
	}
	
	/**
	 * @param areaFachada
	 *           the areaFachada to set
	 */
	public void setAreaFachada(final String areaFachada)
	{
		this.areaFachada = areaFachada;
	}
	/**
	 * @return the numFracciones
	 */
	public String getNumFracciones()
	{
		return numFracciones;
	}
	
	/**
	 * @param numFracciones
	 *           the numFracciones to set
	 */
	public void setNumFracciones(final String numFracciones)
	{
		this.numFracciones = numFracciones;
	}
	/**
	 * @return the tipoPublici
	 */
	public String getTipoPublici()
	{
		return tipoPublici;
	}
	
	/**
	 * @param tipoPublici
	 *           the tipoPublici to set
	 */
	public void setTipoPublici(final String tipoPublici)
	{
		this.tipoPublici = tipoPublici;
	}
	/**
	 * @return the numCaras
	 */
	public String getNumCaras()
	{
		return numCaras;
	}
	
	/**
	 * @param numCaras
	 *           the numCaras to set
	 */
	public void setNumCaras(final String numCaras)
	{
		this.numCaras = numCaras;
	}
	/**
	 * @return the periodicidad
	 */
	public String getPeriodicidad()
	{
		return periodicidad;
	}
	
	/**
	 * @param periodicidad
	 *           the periodicidad to set
	 */
	public void setPeriodicidad(final String periodicidad)
	{
		this.periodicidad = periodicidad;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo()
	{
		return modelo;
	}
	
	/**
	 * @param modelo
	 *           the modelo to set
	 */
	public void setModelo(final String modelo)
	{
		this.modelo = modelo;
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
	 * @return the numLicenciaTrans
	 */
	public String getNumLicenciaTrans()
	{
		return numLicenciaTrans;
	}
	
	/**
	 * @param numLicenciaTrans
	 *           the numLicenciaTrans to set
	 */
	public void setNumLicenciaTrans(final String numLicenciaTrans)
	{
		this.numLicenciaTrans = numLicenciaTrans;
	}
	/**
	 * @return the tipoServicio
	 */
	public String getTipoServicio()
	{
		return tipoServicio;
	}
	
	/**
	 * @param tipoServicio
	 *           the tipoServicio to set
	 */
	public void setTipoServicio(final String tipoServicio)
	{
		this.tipoServicio = tipoServicio;
	}
	/**
	 * @return the contratoObra
	 */
	public String getContratoObra()
	{
		return contratoObra;
	}
	
	/**
	 * @param contratoObra
	 *           the contratoObra to set
	 */
	public void setContratoObra(final String contratoObra)
	{
		this.contratoObra = contratoObra;
	}
	/**
	 * @return the fiducia
	 */
	public String getFiducia()
	{
		return fiducia;
	}
	
	/**
	 * @param fiducia
	 *           the fiducia to set
	 */
	public void setFiducia(final String fiducia)
	{
		this.fiducia = fiducia;
	}
	/**
	 * @return the licenciaUrb
	 */
	public String getLicenciaUrb()
	{
		return licenciaUrb;
	}
	
	/**
	 * @param licenciaUrb
	 *           the licenciaUrb to set
	 */
	public void setLicenciaUrb(final String licenciaUrb)
	{
		this.licenciaUrb = licenciaUrb;
	}
	/**
	 * @return the licenciaConstruc
	 */
	public String getLicenciaConstruc()
	{
		return licenciaConstruc;
	}
	
	/**
	 * @param licenciaConstruc
	 *           the licenciaConstruc to set
	 */
	public void setLicenciaConstruc(final String licenciaConstruc)
	{
		this.licenciaConstruc = licenciaConstruc;
	}
	/**
	 * @return the areaTotal
	 */
	public String getAreaTotal()
	{
		return areaTotal;
	}
	
	/**
	 * @param areaTotal
	 *           the areaTotal to set
	 */
	public void setAreaTotal(final String areaTotal)
	{
		this.areaTotal = areaTotal;
	}
	/**
	 * @return the orientacion
	 */
	public String getOrientacion()
	{
		return orientacion;
	}
	
	/**
	 * @param orientacion
	 *           the orientacion to set
	 */
	public void setOrientacion(final String orientacion)
	{
		this.orientacion = orientacion;
	}
	/**
	 * @return the vigLicenConstruc
	 */
	public String getVigLicenConstruc()
	{
		return vigLicenConstruc;
	}
	
	/**
	 * @param vigLicenConstruc
	 *           the vigLicenConstruc to set
	 */
	public void setVigLicenConstruc(final String vigLicenConstruc)
	{
		this.vigLicenConstruc = vigLicenConstruc;
	}
	/**
	 * @return the tipoVia
	 */
	public String getTipoVia()
	{
		return tipoVia;
	}
	
	/**
	 * @param tipoVia
	 *           the tipoVia to set
	 */
	public void setTipoVia(final String tipoVia)
	{
		this.tipoVia = tipoVia;
	}
	/**
	 * @return the tipoValla
	 */
	public String getTipoValla()
	{
		return tipoValla;
	}
	
	/**
	 * @param tipoValla
	 *           the tipoValla to set
	 */
	public void setTipoValla(final String tipoValla)
	{
		this.tipoValla = tipoValla;
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
	 * @return the publicidadExt
	 */
	public List<ImpuestoPublicidadExterior> getPublicidadExt()
	{
		return publicidadExt;
	}
	
	/**
	 * @param publicidadExt
	 *           the publicidadExt to set
	 */
	public void setPublicidadExt(final List<ImpuestoPublicidadExterior> publicidadExt)
	{
		this.publicidadExt = publicidadExt;
	}
	/**
	 * @return the infodeclara
	 */
	public InfoDeclaraPubli getInfodeclara()
	{
		return infodeclara;
	}
	
	/**
	 * @param infodeclara
	 *           the infodeclara to set
	 */
	public void setInfodeclara(final InfoDeclaraPubli infodeclara)
	{
		this.infodeclara = infodeclara;
	}
	/**
	 * @return the detalleResponse
	 */
	public DetallePublicidadResponse getDetalleResponse()
	{
		return detalleResponse;
	}
	
	/**
	 * @param detalleResponse
	 *           the detalleResponse to set
	 */
	public void setDetalleResponse(final DetallePublicidadResponse detalleResponse)
	{
		this.detalleResponse = detalleResponse;
	}
	/**
	 * @return the calculoResponse
	 */
	public CalcPublicidadResponse getCalculoResponse()
	{
		return calculoResponse;
	}
	
	/**
	 * @param calculoResponse
	 *           the calculoResponse to set
	 */
	public void setCalculoResponse(final CalcPublicidadResponse calculoResponse)
	{
		this.calculoResponse = calculoResponse;
	}





}

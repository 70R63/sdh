/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.DetallePubli;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.InfoDeclaraPubli;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class PublicidadForm
{

	private String numBP;
	private String numResolu;
	private String anoGravable;
	private String fechResolu;
	private String fechNotif;
	private String vigenDesde;
	private String vigenHasta;
	private String tipoSolicitud;
	private String opcionUso;
	private String lugarInstala;
	private String orientacionValla;
	private String tamanoValla;
	private String tipoIDdeclara;
	private String IDdeclarante;
	private String numForm;
	private String impCargo;
	private String vlrSancion;
	private String vlrPagar;
	private String interesMora;
	private String totalPagar;
	private String referencia;
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





	private List<ImpuestoPublicidadExterior> publicidadExt;
	private InfoDeclaraPubli infodeclara;
	private List<DetallePubli> detalle;

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
	 * @return the fechResolu
	 */
	public String getFechResolu()
	{
		return fechResolu;
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
	 * @param fechResolu
	 *           the fechResolu to set
	 */
	public void setFechResolu(final String fechResolu)
	{
		this.fechResolu = fechResolu;
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
	 * @return the impCargo
	 */
	public String getImpCargo()
	{
		return impCargo;
	}

	/**
	 * @param impCargo
	 *           the impCargo to set
	 */
	public void setImpCargo(final String impCargo)
	{
		this.impCargo = impCargo;
	}

	/**
	 * @return the vlrSancion
	 */
	public String getVlrSancion()
	{
		return vlrSancion;
	}

	/**
	 * @param vlrSancion
	 *           the vlrSancion to set
	 */
	public void setVlrSancion(final String vlrSancion)
	{
		this.vlrSancion = vlrSancion;
	}

	/**
	 * @return the vlrPagar
	 */
	public String getVlrPagar()
	{
		return vlrPagar;
	}

	/**
	 * @param vlrPagar
	 *           the vlrPagar to set
	 */
	public void setVlrPagar(final String vlrPagar)
	{
		this.vlrPagar = vlrPagar;
	}

	/**
	 * @return the interesMora
	 */
	public String getInteresMora()
	{
		return interesMora;
	}

	/**
	 * @param interesMora
	 *           the interesMora to set
	 */
	public void setInteresMora(final String interesMora)
	{
		this.interesMora = interesMora;
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
	public void setTotalPagar(final String totalPagar)
	{
		this.totalPagar = totalPagar;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia()
	{
		return referencia;
	}

	/**
	 * @param referencia
	 *           the referencia to set
	 */
	public void setReferencia(final String referencia)
	{
		this.referencia = referencia;
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



}

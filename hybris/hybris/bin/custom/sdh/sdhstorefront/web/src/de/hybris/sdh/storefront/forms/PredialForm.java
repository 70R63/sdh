/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.requests.CalBasesPresuntas;
import de.hybris.sdh.core.pojos.requests.CalPredialDatLiq;
import de.hybris.sdh.core.pojos.requests.CalPredialLiqPriv;
import de.hybris.sdh.core.pojos.responses.CalPredialErrores;
import de.hybris.sdh.core.pojos.responses.CalculoPredialLiqPriv;
import de.hybris.sdh.core.pojos.responses.DetallePredial2Response;
import de.hybris.sdh.core.pojos.responses.DetallePredialResponse;
import de.hybris.sdh.core.pojos.responses.PredialDatosEconomicos;
import de.hybris.sdh.core.pojos.responses.PredialDatosFisicos;
import de.hybris.sdh.core.pojos.responses.PredialDatosJuridicos;
import de.hybris.sdh.core.pojos.responses.PredialEstDatosGenerales;
import de.hybris.sdh.core.pojos.responses.PredialEstLiquidacion;
import de.hybris.sdh.core.pojos.responses.PredialEstLiquidacionPrivada;
import de.hybris.sdh.core.pojos.responses.PredialMarcas;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.PredialTblErrores;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class PredialForm
{

	private List<PredialResponse> predial;

	private String numBP;
	private String CHIP;
	private String matrInmobiliaria;
	private String anioGravable;
	private String objetocontrato;
	private String checkAporte_flag;
	private String indicadorDesc1;

	private String fechaInactivacion;
	private String opcionuso;
	private String indicadorspac;
	private String indicadorbasegravable;

	private PredialDatosJuridicos datosJuridicos;
	private PredialDatosEconomicos datosEconomicos;
	private PredialDatosFisicos datosFisicos;
	private List<PredialMarcas> marcas;
	private PredialEstLiquidacion estrLiquidacionPredial;
	private PredialEstDatosGenerales estrDatosGenerales;
	private PredialEstLiquidacionPrivada estrLiquidacionPrivada;
	private List<PredialTblErrores> tblErrores;

	private DetallePredialResponse detallePredio;

	private String tipDoc;
	private String compleName;
	private String numDoc;
	private String retipRegistro;
	private String decExencion;
	private String decExclusion;
	private String desCalidad;
	private String desDestino;
	private String retipDeclaracion;
	//campos para calculo
	private String numFrom;
	private CalculoPredialLiqPriv liquidacionPrivada;
	private List<CalPredialErrores> Errores;
	private CalPredialDatLiq DatosLiquidacion;
	private CalPredialDatLiq newDatosLiquidacion;
	private CalPredialLiqPriv calcLiquidacionPrivada;
	private CalPredialLiqPriv newLiquidacionRequ;
	private CalBasesPresuntas newBasesPresuntasRequ;

	//campos para request de calculo

	private String tipoDeclaracion;
	private String porcentajePropiedad;
	private String tarifaLiquidacion;
	private String destinoHacendario;
	private String baseGravable;
	private String canonArrendamiento;
	private String calidadSujecion;
	private String avaluoMatrizMejora;
	private String areaTerrenoMejoraContrib;
	private String avaluoProrrateado;
	private String avaluoIndiceEdificabilidad;
	private String exclusionParcial;
	private String aporteVoluntario;
	private String proyecto;
	private String chipcalculo;

	private String url;
	private String caso;

	private String autoavaluo;
	private String direccionPredio;

	private PredialControlCamposDec controlCampos;
	private SDHValidaMailRolResponse contribuyenteData;
	private String representado;
	private DetallePredial2Response detallePredial2Response;
	private PredialCatalogos catalogos;

	//bandera para aporte voluntario
	private boolean mostrarAporteVoluntario;
	private String caracterizacionPredio;
	private String propiedadHorizontal;

	//campos para precalculo
	private String areaConstruida;
	private String areaTerrenoCatastro;
	private String actividadEconomica;

	private String aporte_activo;




	/**
	 * @return the newBasesPresuntasRequ
	 */
	public CalBasesPresuntas getNewBasesPresuntasRequ()
	{
		return newBasesPresuntasRequ;
	}

	/**
	 * @param newBasesPresuntasRequ
	 *           the newBasesPresuntasRequ to set
	 */
	public void setNewBasesPresuntasRequ(final CalBasesPresuntas newBasesPresuntasRequ)
	{
		this.newBasesPresuntasRequ = newBasesPresuntasRequ;
	}

	/**
	 * @return the objetocontrato
	 */
	public String getObjetocontrato()
	{
		return objetocontrato;
	}

	/**
	 * @param objetocontrato
	 *           the objetocontrato to set
	 */
	public void setObjetocontrato(final String objetocontrato)
	{
		this.objetocontrato = objetocontrato;
	}

	/**
	 * @return the mostrarAporteVoluntario
	 */
	public boolean isMostrarAporteVoluntario()
	{
		return mostrarAporteVoluntario;
	}

	/**
	 * @param mostrarAporteVoluntario
	 *           the mostrarAporteVoluntario to set
	 */
	public void setMostrarAporteVoluntario(final boolean mostrarAporteVoluntario)
	{
		this.mostrarAporteVoluntario = mostrarAporteVoluntario;
	}

	/**
	 * @return the caso
	 */
	public String getCaso()
	{
		return caso;
	}

	/**
	 * @param caso
	 *           the caso to set
	 */
	public void setCaso(final String caso)
	{
		this.caso = caso;
	}

	/**
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * @param url
	 *           the url to set
	 */
	public void setUrl(final String url)
	{
		this.url = url;
	}

	/**
	 * @return the detallePredio
	 */
	public DetallePredialResponse getDetallePredio()
	{
		return detallePredio;
	}

	/**
	 * @param detallePredio
	 *           the detallePredio to set
	 */
	public void setDetallePredio(final DetallePredialResponse detallePredio)
	{
		this.detallePredio = detallePredio;
	}

	/**
	 * @return the fechaInactivacion
	 */
	public String getFechaInactivacion()
	{
		return fechaInactivacion;
	}

	/**
	 * @param fechaInactivacion
	 *           the fechaInactivacion to set
	 */
	public void setFechaInactivacion(final String fechaInactivacion)
	{
		this.fechaInactivacion = fechaInactivacion;
	}

	/**
	 * @return the opcionuso
	 */
	public String getOpcionuso()
	{
		return opcionuso;
	}

	/**
	 * @param opcionuso
	 *           the opcionuso to set
	 */
	public void setOpcionuso(final String opcionuso)
	{
		this.opcionuso = opcionuso;
	}

	/**
	 * @return the indicadorspac
	 */
	public String getIndicadorspac()
	{
		return indicadorspac;
	}

	/**
	 * @param indicadorspac
	 *           the indicadorspac to set
	 */
	public void setIndicadorspac(final String indicadorspac)
	{
		this.indicadorspac = indicadorspac;
	}

	/**
	 * @return the indicadorbasegravable
	 */
	public String getIndicadorbasegravable()
	{
		return indicadorbasegravable;
	}

	/**
	 * @param indicadorbasegravable
	 *           the indicadorbasegravable to set
	 */
	public void setIndicadorbasegravable(final String indicadorbasegravable)
	{
		this.indicadorbasegravable = indicadorbasegravable;
	}

	/**
	 * @return the datosJuridicos
	 */
	public PredialDatosJuridicos getDatosJuridicos()
	{
		return datosJuridicos;
	}

	/**
	 * @param datosJuridicos
	 *           the datosJuridicos to set
	 */
	public void setDatosJuridicos(final PredialDatosJuridicos datosJuridicos)
	{
		this.datosJuridicos = datosJuridicos;
	}

	/**
	 * @return the datosEconomicos
	 */
	public PredialDatosEconomicos getDatosEconomicos()
	{
		return datosEconomicos;
	}

	/**
	 * @param datosEconomicos
	 *           the datosEconomicos to set
	 */
	public void setDatosEconomicos(final PredialDatosEconomicos datosEconomicos)
	{
		this.datosEconomicos = datosEconomicos;
	}

	/**
	 * @return the datosFisicos
	 */
	public PredialDatosFisicos getDatosFisicos()
	{
		return datosFisicos;
	}

	/**
	 * @param datosFisicos
	 *           the datosFisicos to set
	 */
	public void setDatosFisicos(final PredialDatosFisicos datosFisicos)
	{
		this.datosFisicos = datosFisicos;
	}

	/**
	 * @return the marcas
	 */
	public List<PredialMarcas> getMarcas()
	{
		return marcas;
	}

	/**
	 * @param marcas
	 *           the marcas to set
	 */
	public void setMarcas(final List<PredialMarcas> marcas)
	{
		this.marcas = marcas;
	}

	/**
	 * @return the estrLiquidacionPredial
	 */
	public PredialEstLiquidacion getEstrLiquidacionPredial()
	{
		return estrLiquidacionPredial;
	}

	/**
	 * @param estrLiquidacionPredial
	 *           the estrLiquidacionPredial to set
	 */
	public void setEstrLiquidacionPredial(final PredialEstLiquidacion estrLiquidacionPredial)
	{
		this.estrLiquidacionPredial = estrLiquidacionPredial;
	}

	/**
	 * @return the estrDatosGenerales
	 */
	public PredialEstDatosGenerales getEstrDatosGenerales()
	{
		return estrDatosGenerales;
	}

	/**
	 * @param estrDatosGenerales
	 *           the estrDatosGenerales to set
	 */
	public void setEstrDatosGenerales(final PredialEstDatosGenerales estrDatosGenerales)
	{
		this.estrDatosGenerales = estrDatosGenerales;
	}

	/**
	 * @return the estrLiquidacionPrivada
	 */
	public PredialEstLiquidacionPrivada getEstrLiquidacionPrivada()
	{
		return estrLiquidacionPrivada;
	}

	/**
	 * @param estrLiquidacionPrivada
	 *           the estrLiquidacionPrivada to set
	 */
	public void setEstrLiquidacionPrivada(final PredialEstLiquidacionPrivada estrLiquidacionPrivada)
	{
		this.estrLiquidacionPrivada = estrLiquidacionPrivada;
	}

	/**
	 * @return the tblErrores
	 */
	public List<PredialTblErrores> getTblErrores()
	{
		return tblErrores;
	}

	/**
	 * @param tblErrores
	 *           the tblErrores to set
	 */
	public void setTblErrores(final List<PredialTblErrores> tblErrores)
	{
		this.tblErrores = tblErrores;
	}

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
	 * @return the cHIP
	 */
	public String getCHIP()
	{
		return CHIP;
	}

	/**
	 * @param cHIP
	 *           the cHIP to set
	 */
	public void setCHIP(final String cHIP)
	{
		CHIP = cHIP;
	}

	/**
	 * @return the matrInmobiliaria
	 */
	public String getMatrInmobiliaria()
	{
		return matrInmobiliaria;
	}

	/**
	 * @param matrInmobiliaria
	 *           the matrInmobiliaria to set
	 */
	public void setMatrInmobiliaria(final String matrInmobiliaria)
	{
		this.matrInmobiliaria = matrInmobiliaria;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		this.anioGravable = anioGravable;
	}

	/**
	 * @return the predial
	 */
	public List<PredialResponse> getPredial()
	{
		return predial;
	}

	/**
	 * @param predial
	 *           the predial to set
	 */
	public void setPredial(final List<PredialResponse> predial)
	{
		this.predial = predial;
	}

	/**
	 * @return the tipDoc
	 */
	public String getTipDoc()
	{
		return tipDoc;
	}

	/**
	 * @param tipDoc
	 *           the tipDoc to set
	 */
	public void setTipDoc(final String tipDoc)
	{
		this.tipDoc = tipDoc;
	}

	/**
	 * @return the compleName
	 */
	public String getCompleName()
	{
		return compleName;
	}

	/**
	 * @param compleName
	 *           the compleName to set
	 */
	public void setCompleName(final String compleName)
	{
		this.compleName = compleName;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}

	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}

	/**
	 * @return the retipRegistro
	 */
	public String getRetipRegistro()
	{
		return retipRegistro;
	}

	/**
	 * @param retipRegistro
	 *           the retipRegistro to set
	 */
	public void setRetipRegistro(final String retipRegistro)
	{
		this.retipRegistro = retipRegistro;
	}

	/**
	 * @return the decExencion
	 */
	public String getDecExencion()
	{
		return decExencion;
	}

	/**
	 * @param decExencion
	 *           the decExencion to set
	 */
	public void setDecExencion(final String decExencion)
	{
		this.decExencion = decExencion;
	}

	/**
	 * @return the decExclusion
	 */
	public String getDecExclusion()
	{
		return decExclusion;
	}

	/**
	 * @param decExclusion
	 *           the decExclusion to set
	 */
	public void setDecExclusion(final String decExclusion)
	{
		this.decExclusion = decExclusion;
	}

	/**
	 * @return the desCalidad
	 */
	public String getDesCalidad()
	{
		return desCalidad;
	}

	/**
	 * @param desCalidad
	 *           the desCalidad to set
	 */
	public void setDesCalidad(final String desCalidad)
	{
		this.desCalidad = desCalidad;
	}

	/**
	 * @return the numFrom
	 */
	public String getNumFrom()
	{
		return numFrom;
	}

	/**
	 * @param numFrom
	 *           the numFrom to set
	 */
	public void setNumFrom(final String numFrom)
	{
		this.numFrom = numFrom;
	}

	/**
	 * @return the liquidacionPrivada
	 */
	public CalculoPredialLiqPriv getLiquidacionPrivada()
	{
		return liquidacionPrivada;
	}

	/**
	 * @param liquidacionPrivada
	 *           the liquidacionPrivada to set
	 */
	public void setLiquidacionPrivada(final CalculoPredialLiqPriv liquidacionPrivada)
	{
		this.liquidacionPrivada = liquidacionPrivada;
	}

	/**
	 * @return the errores
	 */
	public List<CalPredialErrores> getErrores()
	{
		return Errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<CalPredialErrores> errores)
	{
		Errores = errores;
	}

	/**
	 * @return the datosLiquidacion
	 */
	public CalPredialDatLiq getDatosLiquidacion()
	{
		return DatosLiquidacion;
	}

	/**
	 * @param datosLiquidacion
	 *           the datosLiquidacion to set
	 */
	public void setDatosLiquidacion(final CalPredialDatLiq datosLiquidacion)
	{
		DatosLiquidacion = datosLiquidacion;
	}

	/**
	 * @return the calcLiquidacionPrivada
	 */
	public CalPredialLiqPriv getCalcLiquidacionPrivada()
	{
		return calcLiquidacionPrivada;
	}

	/**
	 * @param calcLiquidacionPrivada
	 *           the calcLiquidacionPrivada to set
	 */
	public void setCalcLiquidacionPrivada(final CalPredialLiqPriv calcLiquidacionPrivada)
	{
		this.calcLiquidacionPrivada = calcLiquidacionPrivada;
	}

	/**
	 * @return the tipoDeclaracion
	 */
	public String getTipoDeclaracion()
	{
		return tipoDeclaracion;
	}

	/**
	 * @param tipoDeclaracion
	 *           the tipoDeclaracion to set
	 */
	public void setTipoDeclaracion(final String tipoDeclaracion)
	{
		this.tipoDeclaracion = tipoDeclaracion;
	}

	/**
	 * @return the porcentajePropiedad
	 */
	public String getPorcentajePropiedad()
	{
		return porcentajePropiedad;
	}

	/**
	 * @param porcentajePropiedad
	 *           the porcentajePropiedad to set
	 */
	public void setPorcentajePropiedad(final String porcentajePropiedad)
	{
		this.porcentajePropiedad = porcentajePropiedad;
	}

	/**
	 * @return the tarifaLiquidacion
	 */
	public String getTarifaLiquidacion()
	{
		return tarifaLiquidacion;
	}

	/**
	 * @param tarifaLiquidacion
	 *           the tarifaLiquidacion to set
	 */
	public void setTarifaLiquidacion(final String tarifaLiquidacion)
	{
		this.tarifaLiquidacion = tarifaLiquidacion;
	}

	/**
	 * @return the destinoHacendario
	 */
	public String getDestinoHacendario()
	{
		return destinoHacendario;
	}

	/**
	 * @param destinoHacendario
	 *           the destinoHacendario to set
	 */
	public void setDestinoHacendario(final String destinoHacendario)
	{
		this.destinoHacendario = destinoHacendario;
	}

	/**
	 * @return the baseGravable
	 */
	public String getBaseGravable()
	{
		return baseGravable;
	}

	/**
	 * @param baseGravable
	 *           the baseGravable to set
	 */
	public void setBaseGravable(final String baseGravable)
	{
		this.baseGravable = baseGravable;
	}

	/**
	 * @return the canonArrendamiento
	 */
	public String getCanonArrendamiento()
	{
		return canonArrendamiento;
	}

	/**
	 * @param canonArrendamiento
	 *           the canonArrendamiento to set
	 */
	public void setCanonArrendamiento(final String canonArrendamiento)
	{
		this.canonArrendamiento = canonArrendamiento;
	}

	/**
	 * @return the calidadSujecion
	 */
	public String getCalidadSujecion()
	{
		return calidadSujecion;
	}

	/**
	 * @param calidadSujecion
	 *           the calidadSujecion to set
	 */
	public void setCalidadSujecion(final String calidadSujecion)
	{
		this.calidadSujecion = calidadSujecion;
	}

	/**
	 * @return the avaluoMatrizMejora
	 */
	public String getAvaluoMatrizMejora()
	{
		return avaluoMatrizMejora;
	}

	/**
	 * @param avaluoMatrizMejora
	 *           the avaluoMatrizMejora to set
	 */
	public void setAvaluoMatrizMejora(final String avaluoMatrizMejora)
	{
		this.avaluoMatrizMejora = avaluoMatrizMejora;
	}

	/**
	 * @return the areaTerrenoMejoraContrib
	 */
	public String getAreaTerrenoMejoraContrib()
	{
		return areaTerrenoMejoraContrib;
	}

	/**
	 * @param areaTerrenoMejoraContrib
	 *           the areaTerrenoMejoraContrib to set
	 */
	public void setAreaTerrenoMejoraContrib(final String areaTerrenoMejoraContrib)
	{
		this.areaTerrenoMejoraContrib = areaTerrenoMejoraContrib;
	}

	/**
	 * @return the avaluoProrrateado
	 */
	public String getAvaluoProrrateado()
	{
		return avaluoProrrateado;
	}

	/**
	 * @param avaluoProrrateado
	 *           the avaluoProrrateado to set
	 */
	public void setAvaluoProrrateado(final String avaluoProrrateado)
	{
		this.avaluoProrrateado = avaluoProrrateado;
	}

	/**
	 * @return the avaluoIndiceEdificabilidad
	 */
	public String getAvaluoIndiceEdificabilidad()
	{
		return avaluoIndiceEdificabilidad;
	}

	/**
	 * @param avaluoIndiceEdificabilidad
	 *           the avaluoIndiceEdificabilidad to set
	 */
	public void setAvaluoIndiceEdificabilidad(final String avaluoIndiceEdificabilidad)
	{
		this.avaluoIndiceEdificabilidad = avaluoIndiceEdificabilidad;
	}

	/**
	 * @return the exclusionParcial
	 */
	public String getExclusionParcial()
	{
		return exclusionParcial;
	}

	/**
	 * @param exclusionParcial
	 *           the exclusionParcial to set
	 */
	public void setExclusionParcial(final String exclusionParcial)
	{
		this.exclusionParcial = exclusionParcial;
	}

	/**
	 * @return the aporteVoluntario
	 */
	public String getAporteVoluntario()
	{
		return aporteVoluntario;
	}

	/**
	 * @param aporteVoluntario
	 *           the aporteVoluntario to set
	 */
	public void setAporteVoluntario(final String aporteVoluntario)
	{
		this.aporteVoluntario = aporteVoluntario;
	}

	/**
	 * @return the proyecto
	 */
	public String getProyecto()
	{
		return proyecto;
	}

	/**
	 * @param proyecto
	 *           the proyecto to set
	 */
	public void setProyecto(final String proyecto)
	{
		this.proyecto = proyecto;
	}

	/**
	 * @return the newDatosLiquidacion
	 */
	public CalPredialDatLiq getNewDatosLiquidacion()
	{
		return newDatosLiquidacion;
	}

	/**
	 * @param newDatosLiquidacion
	 *           the newDatosLiquidacion to set
	 */
	public void setNewDatosLiquidacion(final CalPredialDatLiq newDatosLiquidacion)
	{
		this.newDatosLiquidacion = newDatosLiquidacion;
	}

	/**
	 * @return the chipcalculo
	 */
	public String getChipcalculo()
	{
		return chipcalculo;
	}

	/**
	 * @param chipcalculo
	 *           the chipcalculo to set
	 */
	public void setChipcalculo(final String chipcalculo)
	{
		this.chipcalculo = chipcalculo;
	}

	/**
	 * @return the autoavaluo
	 */
	public String getAutoavaluo()
	{
		return autoavaluo;
	}

	/**
	 * @param autoavaluo
	 *           the autoavaluo to set
	 */
	public void setAutoavaluo(final String autoavaluo)
	{
		this.autoavaluo = autoavaluo;
	}

	/**
	 * @return the direccionPredio
	 */
	public String getDireccionPredio()
	{
		return direccionPredio;
	}

	/**
	 * @param direccionPredio
	 *           the direccionPredio to set
	 */
	public void setDireccionPredio(final String direccionPredio)
	{
		this.direccionPredio = direccionPredio;
	}

	/**
	 * @return the desDestino
	 */
	public String getDesDestino()
	{
		return desDestino;
	}

	/**
	 * @param desDestino
	 *           the desDestino to set
	 */
	public void setDesDestino(final String desDestino)
	{
		this.desDestino = desDestino;
	}

	/**
	 * @return the retipDeclaracion
	 */
	public String getRetipDeclaracion()
	{
		return retipDeclaracion;
	}

	/**
	 * @param retipDeclaracion
	 *           the retipDeclaracion to set
	 */
	public void setRetipDeclaracion(final String retipDeclaracion)
	{
		this.retipDeclaracion = retipDeclaracion;
	}

	/**
	 * @return the newLiquidacionRequ
	 */
	public CalPredialLiqPriv getNewLiquidacionRequ()
	{
		return newLiquidacionRequ;
	}

	/**
	 * @param newLiquidacionRequ
	 *           the newLiquidacionRequ to set
	 */
	public void setNewLiquidacionRequ(final CalPredialLiqPriv newLiquidacionRequ)
	{
		this.newLiquidacionRequ = newLiquidacionRequ;
	}

	/**
	 * @return the controlCampos
	 */
	public PredialControlCamposDec getControlCampos()
	{
		return controlCampos;
	}

	/**
	 * @param controlCampos
	 *           the controlCampos to set
	 */
	public void setControlCampos(final PredialControlCamposDec controlCampos)
	{
		this.controlCampos = controlCampos;
	}

	/**
	 * @return the contribuyenteData
	 */
	public SDHValidaMailRolResponse getContribuyenteData()
	{
		return contribuyenteData;
	}

	/**
	 * @param contribuyenteData
	 *           the contribuyenteData to set
	 */
	public void setContribuyenteData(final SDHValidaMailRolResponse contribuyenteData)
	{
		this.contribuyenteData = contribuyenteData;
	}

	/**
	 * @return the representado
	 */
	public String getRepresentado()
	{
		return representado;
	}

	/**
	 * @param representado
	 *           the representado to set
	 */
	public void setRepresentado(final String representado)
	{
		this.representado = representado;
	}

	/**
	 * @return the detallePredial2Response
	 */
	public DetallePredial2Response getDetallePredial2Response()
	{
		return detallePredial2Response;
	}

	/**
	 * @param detallePredial2Response
	 *           the detallePredial2Response to set
	 */
	public void setDetallePredial2Response(final DetallePredial2Response detallePredial2Response)
	{
		this.detallePredial2Response = detallePredial2Response;
	}

	/**
	 * @return the catalogos
	 */
	public PredialCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final PredialCatalogos catalogos)
	{
		this.catalogos = catalogos;
	}

	/**
	 * @return the caracterizacionPredio
	 */
	public String getCaracterizacionPredio()
	{
		return caracterizacionPredio;
	}

	/**
	 * @param caracterizacionPredio
	 *           the caracterizacionPredio to set
	 */
	public void setCaracterizacionPredio(final String caracterizacionPredio)
	{
		this.caracterizacionPredio = caracterizacionPredio;
	}

	/**
	 * @return the propiedadHorizontal
	 */
	public String getPropiedadHorizontal()
	{
		return propiedadHorizontal;
	}

	/**
	 * @param propiedadHorizontal
	 *           the propiedadHorizontal to set
	 */
	public void setPropiedadHorizontal(final String propiedadHorizontal)
	{
		this.propiedadHorizontal = propiedadHorizontal;
	}

	/**
	 * @return the areaConstruida
	 */
	public String getAreaConstruida()
	{
		return areaConstruida;
	}

	/**
	 * @param areaConstruida
	 *           the areaConstruida to set
	 */
	public void setAreaConstruida(final String areaConstruida)
	{
		this.areaConstruida = areaConstruida;
	}

	/**
	 * @return the areaTerrenoCatastro
	 */
	public String getAreaTerrenoCatastro()
	{
		return areaTerrenoCatastro;
	}

	/**
	 * @param areaTerrenoCatastro
	 *           the areaTerrenoCatastro to set
	 */
	public void setAreaTerrenoCatastro(final String areaTerrenoCatastro)
	{
		this.areaTerrenoCatastro = areaTerrenoCatastro;
	}

	/**
	 * @return the checkAporte_flag
	 */
	public String getCheckAporte_flag()
	{
		return checkAporte_flag;
	}

	/**
	 * @param checkAporte_flag
	 *           the checkAporte_flag to set
	 */
	public void setCheckAporte_flag(final String checkAporte_flag)
	{
		this.checkAporte_flag = checkAporte_flag;
	}

	/**
	 * @return the indicadorDesc1
	 */
	public String getIndicadorDesc1()
	{
		return indicadorDesc1;
	}

	/**
	 * @param indicadorDesc1
	 *           the indicadorDesc1 to set
	 */
	public void setIndicadorDesc1(final String indicadorDesc1)
	{
		this.indicadorDesc1 = indicadorDesc1;
	}

	/**
	 * @return the actividadEconomica
	 */
	public String getActividadEconomica()
	{
		return actividadEconomica;
	}

	/**
	 * @param actividadEconomica the actividadEconomica to set
	 */
	public void setActividadEconomica(final String actividadEconomica)
	{
		this.actividadEconomica = actividadEconomica;
	}

	/**
	 * @return the aporte_activo
	 */
	public String getAporte_activo()
	{
		return aporte_activo;
	}

	/**
	 * @param aporte_activo the aporte_activo to set
	 */
	public void setAporte_activo(final String aporte_activo)
	{
		this.aporte_activo = aporte_activo;
	}










}

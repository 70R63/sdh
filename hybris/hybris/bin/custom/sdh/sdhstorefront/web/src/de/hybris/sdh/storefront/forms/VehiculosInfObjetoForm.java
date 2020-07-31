/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.requests.DetalleVehiculosRequest;
import de.hybris.sdh.core.pojos.responses.CatalogoVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.DetalleInfoDeclaraVehiculos;
import de.hybris.sdh.core.pojos.responses.DetalleJuridicosVehiculos;
import de.hybris.sdh.core.pojos.responses.DetalleLiquidacionVehiculos;
import de.hybris.sdh.core.pojos.responses.DetalleMarcas;
import de.hybris.sdh.core.pojos.responses.DetalleMarcasVehiculos;
import de.hybris.sdh.core.pojos.responses.DetalleVehiculos;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.Infovehic;
import de.hybris.sdh.core.pojos.responses.JuridicosVehiculos;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class VehiculosInfObjetoForm
{
	private String numBP;
	private String tipiden;
	private String numide;
	private String name;
	private String bpNum;
	private String placa;
	private String anioGravable;

	private SDHValidaMailRolResponse vehiculos;

	private List<ImpuestoVehiculos> impvehicular;
	private DetalleVehiculosRequest detallerequest;

	private DetalleVehiculos detalle;
	private String idServicio;
	private String idEstado;
	private String watts;
	private String clasicoAntig;
	private String tipoVeh;
	private String capacidadPas;
	private String capacidadTon;
	private String fechaCambio;



	private List<DetalleJuridicosVehiculos> datosJuridicosForm;
	private String tipoID;
	private String nombre;
	private String numID;
	private String calidad;
	private String procProp;
	private String fechaDesde;
	private String fechaHasta;

	private List<DetalleMarcas> marcasForm;
	private String tipoMarca;
	private String codMarca;
	private String valorExcencion;
	private String ciiu;
	private String descripMarca;
	private String fechaDesdemarca;
	private String fechaHastamarca;

	private List<DetalleLiquidacionVehiculos> liquidacion;
	private String anio;
	private String avaluo;
	private String tarifa;

	private DetalleInfoDeclaraVehiculos info_declara;
	private Infovehic infoVeh;
	private String liquidaciondeclara;
	private String opcionUso;



	private List<JuridicosVehiculos> datosJuridicos;
	private List<DetalleMarcasVehiculos> marcas;

	private String marca;
	private String linea;
	private String modelo;
	private String clase;
	private String carroceria;
	private String numPuertas;
	private String blindado;
	private String cilindraje;
	private String numObjeto;

	private String numForm;

	private String clasicoAntiguo;
	private String checkAporte;
	private String proyectoAporte;
	private String claseSdh;
	private String tipoVehSdh;
	private String lineaHomologa;
	private String fuenteHomologa;

	private String impuestoCargo;
	private String tarifaActual;
	private String sancion;
	private String intereses;
	private String valorSemafor;
	private String descuentoProntop;
	private String totalPagar;
	private String valorPagar;
	private String totalPagoVol;

	private List<ErrorPubli> errores;

	private String mensajeErrorVeh;
	private String mensajeVehiculos;
	private String campo_catalogo;
	private CatalogoVehiculosResponse catalogo;
	private String checkAporte_flag;

	private VehiculosControlCamposDec controlCampos;
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
	 * @return the bpNum
	 */
	public String getBpNum()
	{
		return bpNum;
	}

	/**
	 * @param bpNum
	 *           the bpNum to set
	 */
	public void setBpNum(final String bpNum)
	{
		this.bpNum = bpNum;
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
	 * @return the vehiculos
	 */
	public SDHValidaMailRolResponse getVehiculos()
	{
		return vehiculos;
	}

	/**
	 * @param vehiculos
	 *           the vehiculos to set
	 */
	public void setVehiculos(final SDHValidaMailRolResponse vehiculos)
	{
		this.vehiculos = vehiculos;
	}
	/**
	 * @return the impvehicular
	 */
	public List<ImpuestoVehiculos> getImpvehicular()
	{
		return impvehicular;
	}

	/**
	 * @param impvehicular
	 *           the impvehicular to set
	 */
	public void setImpvehicular(final List<ImpuestoVehiculos> impvehicular)
	{
		this.impvehicular = impvehicular;
	}
	/**
	 * @return the detallerequest
	 */
	public DetalleVehiculosRequest getDetallerequest()
	{
		return detallerequest;
	}

	/**
	 * @param detallerequest
	 *           the detallerequest to set
	 */
	public void setDetallerequest(final DetalleVehiculosRequest detallerequest)
	{
		this.detallerequest = detallerequest;
	}
	/**
	 * @return the detalle
	 */
	public DetalleVehiculos getDetalle()
	{
		return detalle;
	}

	/**
	 * @param detalle
	 *           the detalle to set
	 */
	public void setDetalle(final DetalleVehiculos detalle)
	{
		this.detalle = detalle;
	}
	/**
	 * @return the idServicio
	 */
	public String getIdServicio()
	{
		return idServicio;
	}

	/**
	 * @param idServicio
	 *           the idServicio to set
	 */
	public void setIdServicio(final String idServicio)
	{
		this.idServicio = idServicio;
	}
	/**
	 * @return the idEstado
	 */
	public String getIdEstado()
	{
		return idEstado;
	}

	/**
	 * @param idEstado
	 *           the idEstado to set
	 */
	public void setIdEstado(final String idEstado)
	{
		this.idEstado = idEstado;
	}
	/**
	 * @return the watts
	 */
	public String getWatts()
	{
		return watts;
	}

	/**
	 * @param watts
	 *           the watts to set
	 */
	public void setWatts(final String watts)
	{
		this.watts = watts;
	}
	/**
	 * @return the clasicoAntig
	 */
	public String getClasicoAntig()
	{
		return clasicoAntig;
	}

	/**
	 * @param clasicoAntig
	 *           the clasicoAntig to set
	 */
	public void setClasicoAntig(final String clasicoAntig)
	{
		this.clasicoAntig = clasicoAntig;
	}
	/**
	 * @return the tipoVeh
	 */
	public String getTipoVeh()
	{
		return tipoVeh;
	}

	/**
	 * @param tipoVeh
	 *           the tipoVeh to set
	 */
	public void setTipoVeh(final String tipoVeh)
	{
		this.tipoVeh = tipoVeh;
	}
	/**
	 * @return the capacidadPas
	 */
	public String getCapacidadPas()
	{
		return capacidadPas;
	}

	/**
	 * @param capacidadPas
	 *           the capacidadPas to set
	 */
	public void setCapacidadPas(final String capacidadPas)
	{
		this.capacidadPas = capacidadPas;
	}
	/**
	 * @return the capacidadTon
	 */
	public String getCapacidadTon()
	{
		return capacidadTon;
	}

	/**
	 * @param capacidadTon
	 *           the capacidadTon to set
	 */
	public void setCapacidadTon(final String capacidadTon)
	{
		this.capacidadTon = capacidadTon;
	}
	/**
	 * @return the fechaCambio
	 */
	public String getFechaCambio()
	{
		return fechaCambio;
	}

	/**
	 * @param fechaCambio
	 *           the fechaCambio to set
	 */
	public void setFechaCambio(final String fechaCambio)
	{
		this.fechaCambio = fechaCambio;
	}
	/**
	 * @return the datosJuridicosForm
	 */
	public List<DetalleJuridicosVehiculos> getDatosJuridicosForm()
	{
		return datosJuridicosForm;
	}

	/**
	 * @param datosJuridicosForm
	 *           the datosJuridicosForm to set
	 */
	public void setDatosJuridicosForm(final List<DetalleJuridicosVehiculos> datosJuridicosForm)
	{
		this.datosJuridicosForm = datosJuridicosForm;
	}
	/**
	 * @return the tipoID
	 */
	public String getTipoID()
	{
		return tipoID;
	}

	/**
	 * @param tipoID
	 *           the tipoID to set
	 */
	public void setTipoID(final String tipoID)
	{
		this.tipoID = tipoID;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * @param nombre
	 *           the nombre to set
	 */
	public void setNombre(final String nombre)
	{
		this.nombre = nombre;
	}
	/**
	 * @return the numID
	 */
	public String getNumID()
	{
		return numID;
	}

	/**
	 * @param numID
	 *           the numID to set
	 */
	public void setNumID(final String numID)
	{
		this.numID = numID;
	}
	/**
	 * @return the calidad
	 */
	public String getCalidad()
	{
		return calidad;
	}

	/**
	 * @param calidad
	 *           the calidad to set
	 */
	public void setCalidad(final String calidad)
	{
		this.calidad = calidad;
	}
	/**
	 * @return the procProp
	 */
	public String getProcProp()
	{
		return procProp;
	}

	/**
	 * @param procProp
	 *           the procProp to set
	 */
	public void setProcProp(final String procProp)
	{
		this.procProp = procProp;
	}
	/**
	 * @return the fechaDesde
	 */
	public String getFechaDesde()
	{
		return fechaDesde;
	}

	/**
	 * @param fechaDesde
	 *           the fechaDesde to set
	 */
	public void setFechaDesde(final String fechaDesde)
	{
		this.fechaDesde = fechaDesde;
	}
	/**
	 * @return the fechaHasta
	 */
	public String getFechaHasta()
	{
		return fechaHasta;
	}

	/**
	 * @param fechaHasta
	 *           the fechaHasta to set
	 */
	public void setFechaHasta(final String fechaHasta)
	{
		this.fechaHasta = fechaHasta;
	}
	/**
	 * @return the marcasForm
	 */
	public List<DetalleMarcas> getMarcasForm()
	{
		return marcasForm;
	}

	/**
	 * @param marcasForm
	 *           the marcasForm to set
	 */
	public void setMarcasForm(final List<DetalleMarcas> marcasForm)
	{
		this.marcasForm = marcasForm;
	}
	/**
	 * @return the tipoMarca
	 */
	public String getTipoMarca()
	{
		return tipoMarca;
	}

	/**
	 * @param tipoMarca
	 *           the tipoMarca to set
	 */
	public void setTipoMarca(final String tipoMarca)
	{
		this.tipoMarca = tipoMarca;
	}
	/**
	 * @return the codMarca
	 */
	public String getCodMarca()
	{
		return codMarca;
	}

	/**
	 * @param codMarca
	 *           the codMarca to set
	 */
	public void setCodMarca(final String codMarca)
	{
		this.codMarca = codMarca;
	}
	/**
	 * @return the valorExcencion
	 */
	public String getValorExcencion()
	{
		return valorExcencion;
	}

	/**
	 * @param valorExcencion
	 *           the valorExcencion to set
	 */
	public void setValorExcencion(final String valorExcencion)
	{
		this.valorExcencion = valorExcencion;
	}
	/**
	 * @return the ciiu
	 */
	public String getCiiu()
	{
		return ciiu;
	}

	/**
	 * @param ciiu
	 *           the ciiu to set
	 */
	public void setCiiu(final String ciiu)
	{
		this.ciiu = ciiu;
	}
	/**
	 * @return the descripMarca
	 */
	public String getDescripMarca()
	{
		return descripMarca;
	}

	/**
	 * @param descripMarca
	 *           the descripMarca to set
	 */
	public void setDescripMarca(final String descripMarca)
	{
		this.descripMarca = descripMarca;
	}
	/**
	 * @return the fechaDesdemarca
	 */
	public String getFechaDesdemarca()
	{
		return fechaDesdemarca;
	}

	/**
	 * @param fechaDesdemarca
	 *           the fechaDesdemarca to set
	 */
	public void setFechaDesdemarca(final String fechaDesdemarca)
	{
		this.fechaDesdemarca = fechaDesdemarca;
	}
	/**
	 * @return the fechaHastamarca
	 */
	public String getFechaHastamarca()
	{
		return fechaHastamarca;
	}

	/**
	 * @param fechaHastamarca
	 *           the fechaHastamarca to set
	 */
	public void setFechaHastamarca(final String fechaHastamarca)
	{
		this.fechaHastamarca = fechaHastamarca;
	}
	/**
	 * @return the liquidacion
	 */
	public List<DetalleLiquidacionVehiculos> getLiquidacion()
	{
		return liquidacion;
	}

	/**
	 * @param liquidacion
	 *           the liquidacion to set
	 */
	public void setLiquidacion(final List<DetalleLiquidacionVehiculos> liquidacion)
	{
		this.liquidacion = liquidacion;
	}
	/**
	 * @return the anio
	 */
	public String getAnio()
	{
		return anio;
	}

	/**
	 * @param anio
	 *           the anio to set
	 */
	public void setAnio(final String anio)
	{
		this.anio = anio;
	}
	/**
	 * @return the avaluo
	 */
	public String getAvaluo()
	{
		return avaluo;
	}

	/**
	 * @param avaluo
	 *           the avaluo to set
	 */
	public void setAvaluo(final String avaluo)
	{
		this.avaluo = avaluo;
	}
	/**
	 * @return the tarifa
	 */
	public String getTarifa()
	{
		return tarifa;
	}

	/**
	 * @param tarifa
	 *           the tarifa to set
	 */
	public void setTarifa(final String tarifa)
	{
		this.tarifa = tarifa;
	}
	/**
	 * @return the info_declara
	 */
	public DetalleInfoDeclaraVehiculos getInfo_declara()
	{
		return info_declara;
	}

	/**
	 * @param info_declara
	 *           the info_declara to set
	 */
	public void setInfo_declara(final DetalleInfoDeclaraVehiculos info_declara)
	{
		this.info_declara = info_declara;
	}
	/**
	 * @return the infoVeh
	 */
	public Infovehic getInfoVeh()
	{
		return infoVeh;
	}

	/**
	 * @param infoVeh
	 *           the infoVeh to set
	 */
	public void setInfoVeh(final Infovehic infoVeh)
	{
		this.infoVeh = infoVeh;
	}
	/**
	 * @return the liquidaciondeclara
	 */
	public String getLiquidaciondeclara()
	{
		return liquidaciondeclara;
	}

	/**
	 * @param liquidaciondeclara
	 *           the liquidaciondeclara to set
	 */
	public void setLiquidaciondeclara(final String liquidaciondeclara)
	{
		this.liquidaciondeclara = liquidaciondeclara;
	}

	/**
	 * @return the datosJuridicos
	 */
	public List<JuridicosVehiculos> getDatosJuridicos()
	{
		return datosJuridicos;
	}

	/**
	 * @param datosJuridicos
	 *           the datosJuridicos to set
	 */
	public void setDatosJuridicos(final List<JuridicosVehiculos> datosJuridicos)
	{
		this.datosJuridicos = datosJuridicos;
	}

	/**
	 * @return the marcas
	 */
	public List<DetalleMarcasVehiculos> getMarcas()
	{
		return marcas;
	}

	/**
	 * @param marcas
	 *           the marcas to set
	 */
	public void setMarcas(final List<DetalleMarcasVehiculos> marcas)
	{
		this.marcas = marcas;
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
	 * @return the marca
	 */
	public String getMarca()
	{
		return marca;
	}

	/**
	 * @param marca
	 *           the marca to set
	 */
	public void setMarca(final String marca)
	{
		this.marca = marca;
	}

	/**
	 * @return the linea
	 */
	public String getLinea()
	{
		return linea;
	}

	/**
	 * @param linea
	 *           the linea to set
	 */
	public void setLinea(final String linea)
	{
		this.linea = linea;
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
	 * @return the clase
	 */
	public String getClase()
	{
		return clase;
	}

	/**
	 * @param clase
	 *           the clase to set
	 */
	public void setClase(final String clase)
	{
		this.clase = clase;
	}

	/**
	 * @return the carroceria
	 */
	public String getCarroceria()
	{
		return carroceria;
	}

	/**
	 * @param carroceria
	 *           the carroceria to set
	 */
	public void setCarroceria(final String carroceria)
	{
		this.carroceria = carroceria;
	}

	/**
	 * @return the numPuertas
	 */
	public String getNumPuertas()
	{
		return numPuertas;
	}

	/**
	 * @param numPuertas
	 *           the numPuertas to set
	 */
	public void setNumPuertas(final String numPuertas)
	{
		this.numPuertas = numPuertas;
	}

	/**
	 * @return the blindado
	 */
	public String getBlindado()
	{
		return blindado;
	}

	/**
	 * @param blindado
	 *           the blindado to set
	 */
	public void setBlindado(final String blindado)
	{
		this.blindado = blindado;
	}

	/**
	 * @return the cilindraje
	 */
	public String getCilindraje()
	{
		return cilindraje;
	}

	/**
	 * @param cilindraje
	 *           the cilindraje to set
	 */
	public void setCilindraje(final String cilindraje)
	{
		this.cilindraje = cilindraje;
	}

	/**
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
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
	 * @return the clasicoAntiguo
	 */
	public String getClasicoAntiguo()
	{
		return clasicoAntiguo;
	}

	/**
	 * @param clasicoAntiguo
	 *           the clasicoAntiguo to set
	 */
	public void setClasicoAntiguo(final String clasicoAntiguo)
	{
		this.clasicoAntiguo = clasicoAntiguo;
	}

	/**
	 * @return the checkAporte
	 */
	public String getCheckAporte()
	{
		return checkAporte;
	}

	/**
	 * @param checkAporte
	 *           the checkAporte to set
	 */
	public void setCheckAporte(final String checkAporte)
	{
		this.checkAporte = checkAporte;
	}

	/**
	 * @return the proyectoAporte
	 */
	public String getProyectoAporte()
	{
		return proyectoAporte;
	}

	/**
	 * @param proyectoAporte
	 *           the proyectoAporte to set
	 */
	public void setProyectoAporte(final String proyectoAporte)
	{
		this.proyectoAporte = proyectoAporte;
	}

	/**
	 * @return the claseSdh
	 */
	public String getClaseSdh()
	{
		return claseSdh;
	}

	/**
	 * @param claseSdh
	 *           the claseSdh to set
	 */
	public void setClaseSdh(final String claseSdh)
	{
		this.claseSdh = claseSdh;
	}

	/**
	 * @return the tipoVehSdh
	 */
	public String getTipoVehSdh()
	{
		return tipoVehSdh;
	}

	/**
	 * @param tipoVehSdh
	 *           the tipoVehSdh to set
	 */
	public void setTipoVehSdh(final String tipoVehSdh)
	{
		this.tipoVehSdh = tipoVehSdh;
	}

	/**
	 * @return the lineaHomologa
	 */
	public String getLineaHomologa()
	{
		return lineaHomologa;
	}

	/**
	 * @param lineaHomologa
	 *           the lineaHomologa to set
	 */
	public void setLineaHomologa(final String lineaHomologa)
	{
		this.lineaHomologa = lineaHomologa;
	}

	/**
	 * @return the fuenteHomologa
	 */
	public String getFuenteHomologa()
	{
		return fuenteHomologa;
	}

	/**
	 * @param fuenteHomologa
	 *           the fuenteHomologa to set
	 */
	public void setFuenteHomologa(final String fuenteHomologa)
	{
		this.fuenteHomologa = fuenteHomologa;
	}

	/**
	 * @return the impuestoCargo
	 */
	public String getImpuestoCargo()
	{
		return impuestoCargo;
	}

	/**
	 * @param impuestoCargo
	 *           the impuestoCargo to set
	 */
	public void setImpuestoCargo(final String impuestoCargo)
	{
		this.impuestoCargo = impuestoCargo;
	}

	/**
	 * @return the tarifaActual
	 */
	public String getTarifaActual()
	{
		return tarifaActual;
	}

	/**
	 * @param tarifaActual
	 *           the tarifaActual to set
	 */
	public void setTarifaActual(final String tarifaActual)
	{
		this.tarifaActual = tarifaActual;
	}

	/**
	 * @return the sancion
	 */
	public String getSancion()
	{
		return sancion;
	}

	/**
	 * @param sancion
	 *           the sancion to set
	 */
	public void setSancion(final String sancion)
	{
		this.sancion = sancion;
	}

	/**
	 * @return the intereses
	 */
	public String getIntereses()
	{
		return intereses;
	}

	/**
	 * @param intereses
	 *           the intereses to set
	 */
	public void setIntereses(final String intereses)
	{
		this.intereses = intereses;
	}

	/**
	 * @return the valorSemafor
	 */
	public String getValorSemafor()
	{
		return valorSemafor;
	}

	/**
	 * @param valorSemafor
	 *           the valorSemafor to set
	 */
	public void setValorSemafor(final String valorSemafor)
	{
		this.valorSemafor = valorSemafor;
	}

	/**
	 * @return the descuentoProntop
	 */
	public String getDescuentoProntop()
	{
		return descuentoProntop;
	}

	/**
	 * @param descuentoProntop
	 *           the descuentoProntop to set
	 */
	public void setDescuentoProntop(final String descuentoProntop)
	{
		this.descuentoProntop = descuentoProntop;
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
	 * @return the valorPagar
	 */
	public String getValorPagar()
	{
		return valorPagar;
	}

	/**
	 * @param valorPagar
	 *           the valorPagar to set
	 */
	public void setValorPagar(final String valorPagar)
	{
		this.valorPagar = valorPagar;
	}

	/**
	 * @return the totalPagoVol
	 */
	public String getTotalPagoVol()
	{
		return totalPagoVol;
	}

	/**
	 * @param totalPagoVol
	 *           the totalPagoVol to set
	 */
	public void setTotalPagoVol(final String totalPagoVol)
	{
		this.totalPagoVol = totalPagoVol;
	}

	/**
	 * @return the errores
	 */
	public List<ErrorPubli> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorPubli> errores)
	{
		this.errores = errores;
	}

	/**
	 * @return the mensajeErrorVeh
	 */
	public String getMensajeErrorVeh()
	{
		return mensajeErrorVeh;
	}

	/**
	 * @param mensajeErrorVeh
	 *           the mensajeErrorVeh to set
	 */
	public void setMensajeErrorVeh(final String mensajeErrorVeh)
	{
		this.mensajeErrorVeh = mensajeErrorVeh;
	}

	/**
	 * @return the mensajeVehiculos
	 */
	public String getMensajeVehiculos()
	{
		return mensajeVehiculos;
	}

	/**
	 * @param mensajeVehiculos
	 *           the mensajeVehiculos to set
	 */
	public void setMensajeVehiculos(final String mensajeVehiculos)
	{
		this.mensajeVehiculos = mensajeVehiculos;
	}

	/**
	 * @return the campo_catalogo
	 */
	public String getCampo_catalogo()
	{
		return campo_catalogo;
	}

	/**
	 * @param campo_catalogo
	 *           the campo_catalogo to set
	 */
	public void setCampo_catalogo(final String campo_catalogo)
	{
		this.campo_catalogo = campo_catalogo;
	}

	/**
	 * @return the catalogo
	 */
	public CatalogoVehiculosResponse getCatalogo()
	{
		return catalogo;
	}

	/**
	 * @param catalogo
	 *           the catalogo to set
	 */
	public void setCatalogo(final CatalogoVehiculosResponse catalogo)
	{
		this.catalogo = catalogo;
	}

	/**
	 * @return the controlCampos
	 */
	public VehiculosControlCamposDec getControlCampos()
	{
		return controlCampos;
	}

	/**
	 * @param controlCampos
	 *           the controlCampos to set
	 */
	public void setControlCampos(final VehiculosControlCamposDec controlCampos)
	{
		this.controlCampos = controlCampos;
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






}

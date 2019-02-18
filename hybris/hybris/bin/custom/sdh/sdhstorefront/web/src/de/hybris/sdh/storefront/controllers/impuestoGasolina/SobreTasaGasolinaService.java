/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.AbstractController;
import de.hybris.sdh.core.pojos.requests.CalculaGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.responses.CalculaGasolinaResponse;
import de.hybris.sdh.core.pojos.responses.DetGasInfoDeclaraResponse;
import de.hybris.sdh.core.pojos.responses.DetGasRepResponse;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * @author fede
 *
 */



public class SobreTasaGasolinaService
{
	private static final String REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE = AbstractController.REDIRECT_PREFIX
			+ "/contribuyentes/sobretasa-gasolina/declaracion-gasolina";

	public SobreTasaGasolinaCatalogos prepararCatalogos()
	{

		final SobreTasaGasolinaCatalogos catalogosForm = new SobreTasaGasolinaCatalogos();

		//Sobretasa a gasolina
		catalogosForm.setOpcionesCantidadMostrar(obtenerListaOpcionesCantidadMostrar());
		catalogosForm.setAnioGravable(obtenerListaAnioGravable(2019, 6));
		catalogosForm.setPeriodo(obtenerListaPeriodo());
		catalogosForm.setCalidadResponsable(obtenerListaCalidadResponsable());
		catalogosForm.setCodigoPostal(obtenerListaCodigoPostal());
		catalogosForm.setLocalidad(obtenerListaLocalidades());
		catalogosForm.setTipoId(obtenerListaTipoId());

		//Liquidador gasolina
		catalogosForm.setOpcionesUso(obtenerListaOpcionesUso());
		catalogosForm.setClaseProd(obtenerListaClaseProd());
		catalogosForm.setAlcoholCarbu(obtenerListaAlcoholCarbu());
		catalogosForm.setTipoIdRev(obtenerListaTipoId());
		catalogosForm.setTipoIdDec(obtenerListaTipoId());

		//Presentar declaracion
		catalogosForm.setImpuesto(obtenerListaImpuesto());

		//Consulta estado de cuenta
		catalogosForm.setTipoConsulta(obtenerListaTipoConsulta());


		return catalogosForm;
	}


	private Map<String, String> obtenerListaImpuesto()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("0", "Seleccionar");
		elementos.put("1", "Predial Unificado");
		elementos.put("2", "Vehículos");
		elementos.put("3", "ICA");
		elementos.put("4", "Publicidad Exterior");
		elementos.put("5", "Sobretasa Gasolina");
		elementos.put("6", "Delineación Urbana");

		return elementos;
	}

	private Map<String, String> obtenerListaTipoConsulta()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("0", "Seleccionar");
		elementos.put("1", "Impuesto");
		elementos.put("2", "Sujeto");

		return elementos;
	}


	/**
	 * @param i
	 * @param j
	 * @return
	 */
	private Map<String, String> obtenerListaAnioGravable(final int anioBase, final int cantidadAnios)
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		for (int i = 0; i < cantidadAnios; i++)
		{
			elementos.put(Integer.toString(anioBase - i), Integer.toString(anioBase - i));
		}

		return elementos;
	}

	public DetGasCatalogos prepararCatalogosDeclaracion()
	{

		final DetGasCatalogos catalogosForm = new DetGasCatalogos();

		catalogosForm.setOpcionesUso(obtenerListaOpcionesUso());
		catalogosForm.setClaseProd(obtenerListaClaseProd());
		catalogosForm.setAlcoholCarbu(obtenerListaAlcoholCarbu());
		catalogosForm.setTipoIdRev(obtenerListaTipoId());
		catalogosForm.setTipoIdDec(obtenerListaTipoId());

		return catalogosForm;
	}

	/**
	 * @return
	 */
	private Map<String, String> obtenerListaAlcoholCarbu()
	{

		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("0.00", "0");
		elementos.put("1.00", "1");
		elementos.put("2.00", "2");
		elementos.put("3.00", "3");
		elementos.put("4.00", "4");
		elementos.put("5.00", "5");
		elementos.put("6.00", "6");
		elementos.put("7.00", "7");
		elementos.put("8.00", "8");
		elementos.put("9.00", "9");
		elementos.put("10.00", "10");
		elementos.put("11.00", "11");
		elementos.put("12.00", "12");
		elementos.put("13.00", "13");
		elementos.put("14.00", "14");
		elementos.put("15.00", "15");
		elementos.put("16.00", "16");
		elementos.put("17.00", "17");
		elementos.put("18.00", "18");
		elementos.put("19.00", "19");
		elementos.put("20.00", "20");


		return elementos;
	}

	/**
	 * @return
	 */
	private Map<String, String> obtenerListaClaseProd()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "");
		elementos.put("01", "Gasolina Corriente Básica");
		elementos.put("02", "Gasolina Corriente Oxigenada");
		elementos.put("03", "Gasolina Extra Básica");
		elementos.put("04", "Gasolina Extra Oxigenada");

		return elementos;
	}

	/**
	 * @return
	 */
	private Map<String, String> obtenerListaOpcionesUso()
	{

		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("01", "Declaración");
		elementos.put("02", "Corrección");

		return elementos;
	}

	private List<ItemSelectOption> obtenerListaOpcionesCantidadMostrar()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();

		elementos.add(new ItemSelectOption("10", Integer.toString(10)));
		elementos.add(new ItemSelectOption("20", Integer.toString(20)));
		elementos.add(new ItemSelectOption("50", Integer.toString(50)));

		return elementos;
	}

	private Map<String, String> obtenerListaPeriodo()
	{

		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("01", "Enero");
		elementos.put("02", "Febrero");
		elementos.put("03", "Marzo");
		elementos.put("04", "Abril");
		elementos.put("05", "Mayo");
		elementos.put("06", "Junio");
		elementos.put("07", "Julio");
		elementos.put("08", "Agosto");
		elementos.put("09", "Septiembre");
		elementos.put("10", "Octubre");
		elementos.put("11", "Noviembre");
		elementos.put("12", "Diciembre");

		return elementos;
	}

	private List<ItemSelectOption> obtenerListaCalidadResponsable()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		//		elementos.add(new ItemSelectOption("1", "Productor"));


		return elementos;
	}

	private List<ItemSelectOption> obtenerListaCodigoPostal()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		//		elementos.add(new ItemSelectOption(1, "110111"));

		return elementos;
	}

	private List<ItemSelectOption> obtenerListaLocalidades()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		//		elementos.add(new ItemSelectOption(1, "Antonio Nariño"));

		return elementos;
	}

	private Map<String, String> obtenerListaTipoId()
	{

		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("CC", "Cédula de Ciudadanía");
		elementos.put("CD", "Carnet Diplomático");
		elementos.put("CE", "Cédula de Extranjería");
		elementos.put("NUIP", "Número Único de Identificación Personal");
		elementos.put("PA", "Pasaporte");
		elementos.put("RC", "Registro Civil");
		elementos.put("TI", "Tarjeta de Identidad");
		elementos.put("TIE", "Tarjeta de Identidad de Extranjero");
		elementos.put("TPA", "Tarjeta Profesional de Abogacía");
		elementos.put("TPC", "Tarjeta Profesional de Contador Público");
		elementos.put("NIT", "Número de Identificacion Tributaria");

		return elementos;
	}

	//	private List<ItemSelectOption> obtenerListaTipoRelacion()
	//	{
	//
	//		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();
	//
	//		elementos.add(new ItemSelectOption(1, "tipo 1"));
	//
	//
	//		return elementos;
	//	}

	//	private List<ItemSelectOption> obtenerListaFuenteDato()
	//	{
	//
	//		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();
	//
	//		elementos.add(new ItemSelectOption(1, "tipo 1"));
	//
	//
	//		return elementos;
	//	}

	/**
	 * @return
	 */
	//	public List<SobreTasaGasolinaTabla> prepararTablaDeclaracion()
	//	{
	//
	//		final List<SobreTasaGasolinaTabla> gasolinaTabla = new ArrayList<SobreTasaGasolinaTabla>();
	//
	//		for (int i = 1; i < 20; i++)
	//		{
	//			gasolinaTabla.add(new SobreTasaGasolinaTabla("NIT" + Integer.toString(i), Integer.toString(i)));
	//		}
	//
	//
	//		return gasolinaTabla;
	//
	//	}

	public List<SobreTasaGasolinaTabla> prepararTablaDeclaracion(final List<ImpuestoGasolina> origen)
	{
		final List<SobreTasaGasolinaTabla> destino = new ArrayList<SobreTasaGasolinaTabla>();
		SobreTasaGasolinaTabla item;

		for (int i = 0; i < origen.size(); i++)
		{
			if ((origen.get(i).getTipoDoc() != null && origen.get(i).getTipoDoc().isEmpty() != true)
					&& (origen.get(i).getNumDoc() != null && origen.get(i).getNumDoc().isEmpty() != true))
			{

				item = new SobreTasaGasolinaTabla(origen.get(i).getTipoDoc(), origen.get(i).getNumDoc());
				destino.add(item);
			}
		}

		return destino;
	}

	/**
	 * @param bpMarcado
	 * @return
	 */
	public DetGasResponse prepararInfoBP(final String bpMarcado, final String info)
	{

		final DetGasResponse dataForm = new DetGasResponse();

		//datos en el formulario
		String calidResp;
		String numTanques;
		String almacProd;
		String almacTanque;
		String ubicaPlanta;
		String codPostal;
		String localidad;
		String tipoDoc;
		String numDoc;
		String nombre;
		String tipoRelacion;
		String fechaDesde;
		final String fechaHasta;
		String fuente;
		final DetGasRepResponse representante = new DetGasRepResponse();
		final List<DetGasRepResponse> listaRepresentantes = new ArrayList<DetGasRepResponse>();


		//Obtener los valores
		calidResp = "Productor";
		numTanques = "10";
		almacProd = "100";
		almacTanque = "1000";
		ubicaPlanta = "10000";
		codPostal = "110111";
		localidad = "Antonio Nariño";
		tipoDoc = "Cédula de Ciudadania";
		numDoc = "12345";
		nombre = "usuario";
		tipoRelacion = "relacion1";
		fechaDesde = "01/01/2019";
		fechaHasta = "31/12/2019";
		fuente = "fuenteDato1";
		representante.setTipoDoc(tipoDoc);
		representante.setNumDoc(numDoc);
		representante.setNombre(nombre);
		representante.setTipoRelacion(tipoRelacion);
		representante.setFechDesde(fechaDesde);
		representante.setFechHasta(fechaHasta);
		representante.setFuente(fuente);
		listaRepresentantes.add(representante);


		//Setear los valores
		dataForm.setCalidResp(calidResp);
		dataForm.setNumTanques(numTanques);
		dataForm.setAlmacProd(almacProd);
		dataForm.setAlmacTanque(almacTanque);
		dataForm.setUbicaPlanta(ubicaPlanta);
		dataForm.setCodPostal(codPostal);
		dataForm.setLocalidad(localidad);
		dataForm.setRepresentantes(listaRepresentantes);


		// XXX Auto-generated method stub
		return dataForm;
	}

	public DetGasResponse consultaDetGasolina(final DetalleGasolinaRequest requestInfo, final SDHDetalleGasolina sdhConsultaWS,
			final Logger LOG)
	{

		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		DetGasResponse detalleGasolinaResponse = new DetGasResponse();
		final String confUrl = "sdh.detalleGasolina.url";
		final String confUser = "sdh.detalleGasolina.user";
		final String confPass = "sdh.detalleGasolina.password";
		final String wsNombre = "Detalle_Gasolina";
		final String wsReqMet = "POST";

		detalleGasolinaRequest.setNumBP(requestInfo.getNumBP());
		detalleGasolinaRequest.setNumDoc(requestInfo.getNumDoc());
		detalleGasolinaRequest.setTipoDoc(requestInfo.getTipoDoc());
		detalleGasolinaRequest.setAnoGravable(requestInfo.getAnoGravable());
		detalleGasolinaRequest.setPeriodo(requestInfo.getPeriodo());

		detalleGasolinaResponse = llamarWSDetGasolina(detalleGasolinaRequest, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG);


		//		final DetalleGasolinaResponse dataForm = new DetalleGasolinaResponse();
		//
		//		//datos en el formulario
		//		String calidResp;
		//		String numTanques;
		//		String almacProd;
		//		String almacTanque;
		//		String ubicaPlanta;
		//		String codPostal;
		//		String localidad;
		//		String tipoDoc;
		//		String numDoc;
		//		String nombre;
		//		String tipoRelacion;
		//		String fechaDesde;
		//		final String fechaHasta;
		//		String fuente;
		//		final DetalleGasolinaRepResponse representante = new DetalleGasolinaRepResponse();
		//		final List<DetalleGasolinaRepResponse> listaRepresentantes = new ArrayList<DetalleGasolinaRepResponse>();
		//
		//
		//		//Obtener los valores
		//		calidResp = "Productor";
		//		numTanques = "10";
		//		almacProd = "100";
		//		almacTanque = "1000";
		//		ubicaPlanta = "10000";
		//		codPostal = "110111";
		//		localidad = "Antonio Nariño";
		//		tipoDoc = "Cédula de Ciudadania";
		//		numDoc = "12345";
		//		nombre = "usuario";
		//		tipoRelacion = "relacion1";
		//		fechaDesde = "01/01/2019";
		//		fechaHasta = "31/12/2019";
		//		fuente = "fuenteDato1";
		//		representante.setTipoDoc(tipoDoc);
		//		representante.setNumDoc(numDoc);
		//		representante.setNombre(nombre);
		//		representante.setTipoRelacion(tipoRelacion);
		//		representante.setFechDesde(fechaDesde);
		//		representante.setFechHasta(fechaHasta);
		//		representante.setFuente(fuente);
		//		listaRepresentantes.add(representante);
		//
		//
		//		//Setear los valores
		//		dataForm.setCalidResp(calidResp);
		//		dataForm.setNumTanques(numTanques);
		//		dataForm.setAlmacProd(almacProd);
		//		dataForm.setAlmacTanque(almacTanque);
		//		dataForm.setUbicaPlanta(ubicaPlanta);
		//		dataForm.setCodPostal(codPostal);
		//		dataForm.setLocalidad(localidad);
		//		dataForm.setRepresentantes(listaRepresentantes);

		return detalleGasolinaResponse;
	}

	public CalculaGasolinaResponse consultaCalGasolina(final CalculaGasolinaRequest requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{

		CalculaGasolinaResponse responseInfo = new CalculaGasolinaResponse();
		final String confUrl = "sdh.calculoGasolina.url";
		final String confUser = "sdh.calculoGasolina.user";
		final String confPass = "sdh.calculoGasolina.password";
		final String wsNombre = "Calculo_Gasolina";
		final String wsReqMet = "POST";

		responseInfo = llamarWSCalGasolina(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre, wsReqMet,
				LOG);

		return responseInfo;
	}


	public SDHValidaMailRolResponse consultaContribuyente(final ConsultaContribuyenteBPRequest requestInfo,
			final SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService, final Logger LOG)
	{

		final List<ImpuestoGasolina> docsGasolina = new ArrayList<ImpuestoGasolina>();
		final String confUrl = "sdh.validacontribuyente.url";
		final String confUser = "sdh.validacontribuyente.user";
		final String confPass = "sdh.validacontribuyente.password";
		final String wsNombre = "Valida_contribuyente";
		final String wsReqMet = "POST";
		SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			detalleContribuyente = mapper.readValue(sdhConsultaContribuyenteBPService.consultaContribuyenteBP(requestInfo),
					SDHValidaMailRolResponse.class);
		}
		catch (final Exception e)
		{
			LOG.error("Error al llamar el WebService de valCont: " + e.getMessage());
		}

		return detalleContribuyente;
	}



	/**
	 * @param detalleGasolinaRequest
	 * @param sdhConsultaWS
	 * @param confUrl
	 * @param confUser
	 * @param confPass
	 * @param wsNombre
	 * @param wsReqMet
	 * @param LOG
	 * @return
	 */
	private DetGasResponse llamarWSDetGasolina(final DetalleGasolinaRequest detalleGasolinaRequest,
			final SDHDetalleGasolina sdhConsultaWS, final String confUrl, final String confUser, final String confPass,
			final String wsNombre, final String wsReqMet, final Logger LOG)
	{
		DetGasResponse detalleGasolinaResponse = new DetGasResponse();

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			detalleGasolinaResponse = mapper.readValue(
					sdhConsultaWS.consultaWS(detalleGasolinaRequest, confUrl, confUser, confPass, wsNombre, wsReqMet),
					DetGasResponse.class);
		}
		catch (final Exception e)
		{
			LOG.error("Error al llamar WebService: " + wsNombre + "Detalle:" + e.getMessage());
		}

		return detalleGasolinaResponse;
	}

	private CalculaGasolinaResponse llamarWSCalGasolina(final CalculaGasolinaRequest consultaGasolinaRequest,
			final SDHDetalleGasolina sdhConsultaWS, final String confUrl, final String confUser, final String confPass,
			final String wsNombre, final String wsReqMet, final Logger LOG)
	{
		CalculaGasolinaResponse consultaGasolinaResponse = new CalculaGasolinaResponse();

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			consultaGasolinaResponse = mapper.readValue(
					sdhConsultaWS.consultaWS(consultaGasolinaRequest, confUrl, confUser, confPass, wsNombre, wsReqMet),
					CalculaGasolinaResponse.class);
		}
		catch (final Exception e)
		{
			LOG.error("Error al llamar WebService: " + wsNombre + "Detalle:" + e.getMessage());
		}

		return consultaGasolinaResponse;
	}

	public String obtenerURL(final String origen, final String accion, final String destino)
	{
		String returnURL = "";

		if (origen.equals("presentar-declaracion"))
		{
			if (accion.equals("impuesto"))
			{
				if (destino.equals("sobretasa-gasolina"))
				{
					returnURL = REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
				}
			}
		}

		return returnURL;
	}


	/**
	 * @param errores
	 * @return
	 */
	public String[] prepararMensajesError(final List<ErrorEnWS> errores)
	{
		final List<String> mensajes = new ArrayList<String>();
		String[] listaMensajes;
		String mensajeError;

		for (int i = 0; i < errores.size(); i++)
		{
			mensajeError = "ID= " + errores.get(i).getIdmsj() + " Mensaje = " + errores.get(i).getTxtmsj();
			mensajes.add(mensajeError);
		}
		listaMensajes = new String[mensajes.size()];
		listaMensajes = mensajes.toArray(listaMensajes);

		return listaMensajes;
	}


	/**
	 * @param idmsj
	 * @param txtmsj
	 * @return
	 */
	public List<ErrorEnWS> convertirListaError(final int idmsj, final String txtmsj)
	{
		final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
		final ErrorEnWS errorConsulta = new ErrorEnWS();

		errorConsulta.setIdmsj(Integer.toString(idmsj));
		errorConsulta.setTxtmsj(txtmsj);
		errores.add(errorConsulta);

		return errores;
	}

	/**
	 * @return
	 */
	public String obtenerAnoGravableActual()
	{
		final Calendar c = Calendar.getInstance();
		final int year = c.get(Calendar.YEAR);
		final String yearSTR = Integer.toString(year);

		return yearSTR;
	}


	/**
	 * @return
	 */
	public String obtenerPeriodoActual()
	{
		final Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		final String monthSTR;

		month++;
		monthSTR = month < 10 ? "0" + Integer.toString(month) : Integer.toString(month);

		return monthSTR;
	}


	/**
	 * @param listaDocumentos
	 * @return
	 */
	public String obtenerTipoDoc(final List<SobreTasaGasolinaTabla> listaDocumentos)
	{
		String tipoDoc = "";

		if (listaDocumentos != null)
		{
			for (int i = 0; i < listaDocumentos.size(); i++)
			{
				if (!listaDocumentos.get(i).toString().isEmpty())
				{
					tipoDoc = listaDocumentos.get(i).getTipoDocumento();
					break;
				}
			}
		}

		return tipoDoc;
	}


	/**
	 * @param listaDocumentos
	 * @return
	 */
	public String obtenerNumDoc(final List<SobreTasaGasolinaTabla> listaDocumentos)
	{
		String numDoc = "";


		if (listaDocumentos != null)
		{
			for (int i = 0; i < listaDocumentos.size(); i++)
			{
				if (!listaDocumentos.get(i).toString().isEmpty())
				{
					numDoc = listaDocumentos.get(i).getNumeroDocumento();
					break;
				}
			}
		}


		return numDoc;
	}


	/**
	 * @param i
	 * @return
	 */
	public List<DetGasInfoDeclaraResponse> prepararInfoDeclaraDefault(final int cantidadRegistros)
	{
		final List<DetGasInfoDeclaraResponse> infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();

		for (int i = 0; i < cantidadRegistros; i++)
		{
			infoDeclaraDefault.add(new DetGasInfoDeclaraResponse());
		}

		return infoDeclaraDefault;
	}


	/**
	 * @param infoDeclara
	 * @return
	 */
	public List<DetGasInfoDeclaraResponse> prepararInfoDeclara(final List<DetGasInfoDeclaraResponse> infoDeclaraOriginal)
	{
		final List infoDeclara = new ArrayList<DetGasInfoDeclaraResponse>();

		if (infoDeclaraOriginal != null)
		{
			for (int i = 0; i < infoDeclaraOriginal.size(); i++)
			{
				if (infoDeclaraOriginal.get(i).getClaseProd() != null && infoDeclaraOriginal.get(i).getClaseProd().equals("") != true)
				{
					infoDeclara.add(infoDeclaraOriginal.get(i));
				}
			}
		}

		return infoDeclara;
	}


	public String getDescripcion(final String clave, final Map<String, String> catalogo)
	{
		String descripcion = "";


		descripcion = catalogo.get(clave);

		return descripcion;
	}


}

/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.AbstractController;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.pojos.requests.CalculaGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.CalculoImpDelineacionRequest;
import de.hybris.sdh.core.pojos.requests.CalculoReteIca2Request;
import de.hybris.sdh.core.pojos.requests.ConsCasosRequest;
import de.hybris.sdh.core.pojos.requests.ConsulPagosRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.CreaCasosRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.DetallePagoRequest;
import de.hybris.sdh.core.pojos.requests.DetalleVehiculos2Request;
import de.hybris.sdh.core.pojos.requests.DocTramitesRequest;
import de.hybris.sdh.core.pojos.requests.InfoObjetoDelineacionRequest;
import de.hybris.sdh.core.pojos.requests.ListaDeclaracionesRequest;
import de.hybris.sdh.core.pojos.requests.OpcionCertiDecImprimeRequest;
import de.hybris.sdh.core.pojos.requests.OpcionCertiPagosImprimeRequest;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesCatalogos;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesPDFRequest;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesVista;
import de.hybris.sdh.core.pojos.requests.RadicaDelinRequest;
import de.hybris.sdh.core.pojos.responses.CalculaGasolinaResponse;
import de.hybris.sdh.core.pojos.responses.CalculoReteIca2Response;
import de.hybris.sdh.core.pojos.responses.ConsCasosResponse;
import de.hybris.sdh.core.pojos.responses.CreaCasosResponse;
import de.hybris.sdh.core.pojos.responses.DelineacionUUsos;
import de.hybris.sdh.core.pojos.responses.DetGasInfoDeclaraResponse;
import de.hybris.sdh.core.pojos.responses.DetGasRepResponse;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.DetRadicadosResponse;
import de.hybris.sdh.core.pojos.responses.DetallePagoResponse;
import de.hybris.sdh.core.pojos.responses.DetalleVehiculos2Response;
import de.hybris.sdh.core.pojos.responses.DocTramitesResponse;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbanaWithRadicados;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoICA;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacionResponse;
import de.hybris.sdh.core.pojos.responses.ItemListaDeclaraciones;
import de.hybris.sdh.core.pojos.responses.ItemSelectOption;
import de.hybris.sdh.core.pojos.responses.ListaDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.OpcionCertiDecImprimeResponse;
import de.hybris.sdh.core.pojos.responses.OpcionCertiPagosImprimeResponse;
import de.hybris.sdh.core.pojos.responses.OpcionDeclaracionesPDFResponse;
import de.hybris.sdh.core.pojos.responses.RadicaDelinResponse;
import de.hybris.sdh.core.pojos.responses.ReteICA;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.pojos.responses.TramiteCatalogos;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.storefront.controllers.pages.InfoDelineacion;
import de.hybris.sdh.storefront.controllers.pages.InfoDelineacionInput;
import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * @author fede
 *
 */



public class SobreTasaGasolinaService
{
	private final ConfigurationService configurationService;

	private static final String REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE = AbstractController.REDIRECT_PREFIX
			+ "/contribuyentes/sobretasa-gasolina/declaracion-gasolina";

	private final String confCantidadAnioGravableBusqueda = "sdh.sobretasaGasolina.cantidadAnioGravableBusqueda";





	/**
	 * @param configurationService
	 */
	public SobreTasaGasolinaService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	public SobreTasaGasolinaService()
	{
		configurationService = null;

	}

	public SobreTasaGasolinaCatalogos prepararCatalogos()
	{

		final SobreTasaGasolinaCatalogos catalogosForm = new SobreTasaGasolinaCatalogos();

		//Sobretasa a gasolina
		catalogosForm.setOpcionesCantidadMostrar(obtenerListaOpcionesCantidadMostrar());
		catalogosForm.setAnioGravable(obtenerListaAnioGravable(obtenerAnoGravableActual(),
				Integer.parseInt(configurationService.getConfiguration().getString(confCantidadAnioGravableBusqueda))));
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

	public SobreTasaGasolinaCatalogos prepararCatalogosDelineacionU()
	{

		final SobreTasaGasolinaCatalogos catalogosForm = new SobreTasaGasolinaCatalogos();

		//Sobretasa a gasolina
		catalogosForm.setAnioGravable(obtenerListaAnioGravable(obtenerAnoGravableActual(),
				Integer.parseInt(configurationService.getConfiguration().getString(confCantidadAnioGravableBusqueda))));
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

		//Delineacion Urbana
		catalogosForm.setAnoGravable(obtenerListaAnioGravable(obtenerAnoGravableActual(),
				Integer.parseInt(configurationService.getConfiguration().getString(confCantidadAnioGravableBusqueda))));
		catalogosForm.setTipoDeLicencia(obtenerListaTipoDeLicencia());
		catalogosForm.setObjetoLicencia(obtenerListaObjetoDeLicencia());
		catalogosForm.setModalidadLicencia(obtenerListaModalidadLicencia());
		catalogosForm.setPresupuestoObra(obtenerListaPresupuestoObra());
		catalogosForm.setCausalExencion(obtenerListaCausalExencion());
		catalogosForm.setUso(obtenerListaUso());
		catalogosForm.setCodUso(obtenerListaCodUso());
		catalogosForm.setAreaInter(obtenerListaAreaInter());
		catalogosForm.setAreaProy(obtenerListaAreaProy());


		return catalogosForm;
	}


	public TramiteCatalogos prepararCatalogosConsCaso()
	{

		final TramiteCatalogos catalogosForm = new TramiteCatalogos();


		catalogosForm.setTipoId(obtenerListaTipoIdConsCaso());


		return catalogosForm;
	}

	/**
	 * @return
	 */
	private Map<String, String> obtenerListaAreaProy()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "LOTE");
		elementos.put("02", "SÓTANOS");
		elementos.put("03", "SEMI SÓTANOS");
		elementos.put("04", "PRIMER PISO");
		elementos.put("05", "PISOS RESTANTES");
		elementos.put("06", "LIBRE PRIMER PISO");


		return elementos;
	}


	/**
	 * @return
	 */
	private Map<String, String> obtenerListaAreaInter()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "Obra nueva");
		elementos.put("02", "Ampliación");
		elementos.put("03", "Modificación");
		elementos.put("04", "Adecuación");
		elementos.put("05", "Reforzamiento");
		elementos.put("06", "Restauración/conservación");
		elementos.put("07", "Demolición");
		elementos.put("08", "Cerramiento");
		elementos.put("09", "Reconocimiento");

		return elementos;
	}


	/**
	 * @return
	 */
	private Map<String, String> obtenerListaUso()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "Comercio");
		elementos.put("02", "Servicios");
		elementos.put("03", "Dotacional");
		elementos.put("04", "Industrial");
		elementos.put("05", "Vivienda");


		return elementos;
	}


	/**
	 * @return
	 */
	private Map<String, String> obtenerListaCodUso()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();


		elementos.put("00", "Seleccionar");
		//		if (uso.equals("Comercio"))
		//		{
		elementos.put("07", "Comercio vecinal o local");
		elementos.put("08", "Comercio zonal");
		elementos.put("09", "Comercio urbano");
		elementos.put("10", "Comercio metropolitano");
		//		}
		//		if (uso.equals("Servicios"))
		//		{
		elementos.put("11", "Servicios vecinal o local");
		elementos.put("12", "Servicios zonal");
		elementos.put("13", "Servicios urbana");
		elementos.put("14", "Servicios metropolitana");
		elementos.put("15", "Dotacional vecinal o local");
		elementos.put("16", "Dotacional zonal");
		elementos.put("17", "Dotacional urbana");
		elementos.put("18", "Dotacional metropolitana");
		//		}
		//		if (uso.equals("Industrial"))
		//		{
		elementos.put("19", "Industrial");
		//		}
		//		if (uso.equals("Vivienda"))
		//		{
		elementos.put("E1", "Estrato 1");
		elementos.put("E2", "Estrato 2");
		elementos.put("E3", "Estrato 3");
		elementos.put("E4", "Estrato 4");
		elementos.put("E5", "Estrato 5");
		elementos.put("E6", "Estrato 6");
		elementos.put("V1", "Vis Estrato 1");
		elementos.put("V2", "Vis Estrato 2");
		elementos.put("V3", "Vis Estrato 3");
		//		}


		return elementos;
	}


	/**
	 * @return
	 */
	private Map<String, String> obtenerListaCausalExencion()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "Vis obras nuevas estrato 1,2,3");
		elementos.put("02", "Obras de autoconstrucción de vivienda estrato 1 y 2");
		elementos.put("03", "Ampliaciones, modificaciones, adecuaciones y/o reparaciones en estrato 1,2,3");
		elementos.put("04", "Obras para reconstruir predios afectados por actos terroristas o catástrofes naturales");
		elementos.put("05", "Obras que se realicen para restaurar o conservar los edificios declarados de conservación histórica");

		return elementos;
	}


	/**
	 * @return
	 */
	private Map<String, String> obtenerListaPresupuestoObra()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "Calcular con base en la resolución SDP");
		elementos.put("02", "Incorporar el valor de su presupuesto");

		return elementos;
	}


	/**
	 * @return
	 */
	private Map<String, String> obtenerListaModalidadLicencia()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "01 - OBRA NUEVA");
		elementos.put("02", "02 - AMPLIACIÓN");
		elementos.put("03", "03 - MODIFICACIÓN");
		elementos.put("04", "04 - ADECUACIÓN");
		elementos.put("05", "05 - REFORZAMIENTO");
		elementos.put("06", "06 - RESTAURACIÓN/CONSERVACIÓN");
		elementos.put("07", "07 - DEMOLICIÓN");
		elementos.put("08", "08 - CERRAMIENTO");
		elementos.put("09", "09 - RECONOCIMIENTO");

		return elementos;
	}


	/**
	 * @return
	 */
	private Map<String, String> obtenerListaTipoDeLicencia()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "Licencia");
		elementos.put("02", "Reconocimiento");

		return elementos;
	}

	private Map<String, String> obtenerListaObjetoDeLicencia()
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "INICIAL");
		elementos.put("02", "MODIFICACIÓN DE LICENCIA");
		elementos.put("03", "REVALIDACIÓN");

		return elementos;
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

		elementos.put("", "SELECCIONAR");
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
		elementos.put("10.00", "10");//correccion de etiqueta
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

		elementos.put("00", "SELECCIONAR");
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

	private Map<String, String> obtenerListaTipoIdConsCaso()
	{

		final Map<String, String> elementos = new LinkedHashMap<String, String>();


		elementos.put("", "Seleccionar");
		elementos.put("CC", "Cédula de Ciudadanía");
		elementos.put("CD", "Carnet Diplomático");
		elementos.put("CE", "Cédula de Extranjería");
		elementos.put("HCM001", "ID de empleado");
		elementos.put("NIT", "Número de Identificacion Tributaria");
		elementos.put("NITC", "NIT Compuesto (Utilización Múltiple)");
		elementos.put("NITE", "NIT Extranjero");
		elementos.put("NITUT", "NIT Unión Temporal o Consorcio");
		elementos.put("NUIP", "Número Único de Identificación Personal");
		elementos.put("PA", "Pasaporte");
		elementos.put("RC", "Registro Civil");
		elementos.put("SDP", "Sin Determinar - Predial");
		elementos.put("SDV", "Sin Determinar - Vehículos");
		elementos.put("TI", "Tarjeta de Identidad");
		elementos.put("TIE", "Tarjeta de Identidad de Extranjero");
		elementos.put("TPA", "Tarjeta Profesional de Abogacía");
		elementos.put("TPC", "Tarjeta Profesional de Contador Público");

		return elementos;
	}


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

		responseInfo = llamarWSCalGasolina(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre, wsReqMet, LOG);

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

	private DetallePagoResponse llamarWSDetPago(final DetallePagoRequest infoRequest, final SDHDetalleGasolina sdhConsultaWS,
			final String confUrl, final String confUser, final String confPass, final String wsNombre, final String wsReqMet,
			final Logger LOG)
	{
		DetallePagoResponse responseInfo = new DetallePagoResponse();

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			responseInfo = mapper.readValue(sdhConsultaWS.consultaWS(infoRequest, confUrl, confUser, confPass, wsNombre, wsReqMet),
					DetallePagoResponse.class);
		}
		catch (final Exception e)
		{
			LOG.error("Error al llamar WebService: " + wsNombre + "Detalle:" + e.getMessage());
		}

		return responseInfo;
	}

	private Object llamarWS(final Object infoRequest, final SDHDetalleGasolina sdhConsultaWS, final String confUrl,
			final String confUser, final String confPass, final String wsNombre, final String wsReqMet, final Logger LOG,
			final String nombreClase)
	{
		Object responseInfo = new Object();

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			String wsresponse = sdhConsultaWS.consultaWS(infoRequest, confUrl, confUser, confPass, wsNombre, wsReqMet);
			wsresponse = wsresponse.replaceAll("\"ARCHIVOS\":\\{([\"])(.*)(\"\\})", "\"ARCHIVOS\":[{\"$2\"}]");
			//			System.out.println("Response de crm/consCasos: " + wsresponse);



			if (nombreClase.equals("de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacionResponse"))
			{
				wsresponse = wsresponse.replace("\"Uso\"", "\"uso\"");
			}
			if (nombreClase.equals("de.hybris.sdh.core.pojos.responses.ConsCasosResponse"))
			{
				wsresponse = wsresponse.replace("\"PROCESS_TYPE\":", "\"process_type\":");
				wsresponse = wsresponse.replace("\"ESTRUCTURA\":", "\"esctructura\":");
				wsresponse = wsresponse.replace("\"CAMPO\":", "\"campo\":");
				wsresponse = wsresponse.replace("\"FACTOR\":", "\"factor\":");
				wsresponse = wsresponse.replace("\"ARCHIVOS\":", "\"archivos\":");
				wsresponse = wsresponse.replace("\"ZZWCC_OBJECT_ID\":", "\"zzwcc_object_id\":");
				wsresponse = wsresponse.replace("\"ZZWCC_DEPEND_ID\":", "\"zzwcc_depend_id\":");
				wsresponse = wsresponse.replace("\"ZZWCC_SERIE_ID\":", "\"zzwcc_serie_id\":");
				wsresponse = wsresponse.replace("\"ZZWCC_SSERIE_ID\":", "\"zzwcc_sserie_id\":");
				wsresponse = wsresponse.replace("\"ZZWCC_TIPODOC_ID\":", "\"zzwcc_tipodoc_id\":");
				wsresponse = wsresponse.replace("\"ZZWCC_DESC_TIPODOC\":", "\"zzwcc_desc_tipodoc\":");
				wsresponse = wsresponse.replace("\"ZZWCC_ARCIVO\":", "\"zzwcc_arcivo\":");
			}
			if (nombreClase.equals("de.hybris.sdh.core.pojos.responses.OpcionDeclaracionesPDFResponse"))
			{
				wsresponse = wsresponse.replace(",\"errores\":\"\"", "");
			}
			if (nombreClase.equals("de.hybris.sdh.core.pojos.responses.OpcionCertiDecImprimeResponse"))
			{
				wsresponse = wsresponse.replace("\"stringPDF\":", "\"pdf\":");
			}
			if (nombreClase.equals("de.hybris.sdh.core.pojos.responses.OpcionCertiPagosImprimeResponse"))
			{
				wsresponse = wsresponse.replace("\"stringPDF\":", "\"pdf\":");
			}

			responseInfo = mapper.readValue(wsresponse, Class.forName(nombreClase));
		}
		catch (final Exception e)
		{
			LOG.error("Error al llamar WebService: " + wsNombre + "Detalle:" + e.getMessage());
		}

		return responseInfo;
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

		if (errores != null)
		{
			for (int i = 0; i < errores.size(); i++)
			{
				if (!errores.get(i).getIdmsj().isEmpty() && !errores.get(i).getIdmsj().equals("0"))
				{
					mensajeError = "ID= " + errores.get(i).getIdmsj() + " Mensaje = " + errores.get(i).getTxtmsj();
					mensajes.add(mensajeError);
				}
			}
		}
		listaMensajes = new String[mensajes.size()];
		listaMensajes = mensajes.toArray(listaMensajes);

		return listaMensajes;
	}

	public String prepararMensajeError(final List<ErrorEnWS> errores)
	{
		final List<String> mensajes = new ArrayList<String>();
		final String[] listaMensajes;
		String mensajeError = "";
		final StringBuffer sb = new StringBuffer();

		if (errores != null)
		{
			for (int i = 0; i < errores.size(); i++)
			{
				if (!errores.get(i).getIdmsj().isEmpty() && errores.get(i).getIdmsj().equals("0"))
				{
					sb.append("ID= " + errores.get(i).getIdmsj() + " Mensaje = " + errores.get(i).getTxtmsj());
				}
			}
		}
		mensajeError = sb.toString();

		return mensajeError;
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
	public int obtenerAnoGravableActual()
	{
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		final boolean esCambioAnio = false;

		year = ocurrioCambioAnio() ? --year : year;

		return year;
	}


	/**
	 * @return
	 */
	private boolean ocurrioCambioAnio()
	{

		final Calendar c = Calendar.getInstance();
		final int month = c.get(Calendar.MONTH);
		boolean esCambioAnio = false;

		esCambioAnio = month == 0 ? true : false;


		return esCambioAnio;
	}


	/**
	 * @return
	 */
	public String obtenerPeriodoActual()
	{
		final Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		String monthSTR = null;

		month = month == 0 ? 12 : month;
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


	public String obtenerNumDocDeclaraciones(final SDHValidaMailRolResponse customerData, final String claveImpuesto)
	{
		String numDoc = "";
		List<ImpuestoGasolina> listaDocumentos_0005 = null;
		ReteICA listaDocumentos_0004 = null;

		switch (claveImpuesto)
		{
			case "0004": //Reteica
				listaDocumentos_0004 = customerData.getReteIca();
				if (listaDocumentos_0004 != null)
				{
					numDoc = listaDocumentos_0004.getNumObjeto();
					break;
				}
				break;
			case "0005": //Sobretasa Motor
				listaDocumentos_0005 = customerData.getGasolina();
				if (listaDocumentos_0005 != null)
				{
					for (int i = 0; i < listaDocumentos_0005.size(); i++)
					{
						if (!listaDocumentos_0005.get(i).toString().isEmpty())
						{
							numDoc = listaDocumentos_0005.get(i).getNumObjeto();
							break;
						}
					}
				}
				break;

			default:
				break;
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


	/**
	 * @param representantes
	 * @return
	 */
	public List<DetGasRepResponse> prepararTablaRepresentantes(final List<DetGasRepResponse> origen)
	{
		final List<DetGasRepResponse> destino = new ArrayList<DetGasRepResponse>();

		if (origen != null)
		{
			for (int i = 0; i < origen.size(); i++)
			{
				if (origen.get(i).getTipoDoc() != null && origen.get(i).getTipoDoc().trim().length() > 0)
				{
					destino.add(origen.get(i));
				}
			}
		}

		return destino;
	}


	/**
	 * @param periodo
	 * @return
	 */
	public String prepararPeriodoMensualPago(final String anoGravable, final String periodo)
	{
		String periodoConvertidoPagar = "";

		if (anoGravable != null)
		{
			periodoConvertidoPagar = anoGravable.substring(2).trim() + periodo;
		}


		return periodoConvertidoPagar;
	}

	public String prepararPeriodoBimestralPago(final String anoGravable, final String periodo)
	{
		String periodoConvertidoPagar = "";

		if (anoGravable != null)
		{
			periodoConvertidoPagar = anoGravable.substring(2).trim() + "B" + periodo.substring(1).trim();
		}


		return periodoConvertidoPagar;
	}



	/**
	 * @param detallePagoRequest
	 * @param sdhDetalleGasolinaWS
	 * @param log
	 * @return
	 */
	public DetallePagoResponse consultaDetallePago(final DetallePagoRequest requestInfo, final SDHDetalleGasolina sdhConsultaWS,
			final Logger LOG)
	{
		DetallePagoResponse responseInfo = new DetallePagoResponse();
		final String confUrl = "sdh.detallePago.url";
		final String confUser = "sdh.detallePago.user";
		final String confPass = "sdh.detallePago.password";
		final String wsNombre = "Detalle_Pago";
		final String wsReqMet = "POST";


		responseInfo = llamarWSDetPago(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre, wsReqMet, LOG);


		return responseInfo;
	}


	/**
	 * @param declarante
	 * @return
	 */
	public String prepararNumObjetoGasolina(final SDHValidaMailRolResponse detalleContribuyente)
	{
		String numObjeto = "";

		if (detalleContribuyente != null && detalleContribuyente.getGasolina() != null
				&& detalleContribuyente.getGasolina().get(0) != null)
		{
			numObjeto = detalleContribuyente.getGasolina().get(0).getNumObjeto();
		}


		return numObjeto;
	}

	public String prepararNumObjetoPublicidad(final SDHValidaMailRolResponse detalleContribuyente, final String numResolu)
	{
		String numObjeto = "";
		List<ImpuestoPublicidadExterior> infoPublicidad;


		infoPublicidad = detalleContribuyente.getPublicidadExt();
		if (detalleContribuyente != null && infoPublicidad != null)
		{
			for (int i = 0; i < infoPublicidad.size(); i++)
			{
				if (infoPublicidad.get(i) != null)
				{
					if (infoPublicidad.get(i).getNumResolu() != null)
					{
						if (infoPublicidad.get(i).getNumResolu().equals(numResolu))
						{
							numObjeto = infoPublicidad.get(i).getNumObjeto();
						}
					}
				}
			}
		}


		return numObjeto;
	}


	public String prepararNumObjetoICA(final SDHValidaMailRolResponse detalleContribuyente)
	{
		String numObjeto = "";
		ImpuestoICA infoImpuesto;


		infoImpuesto = detalleContribuyente.getIca();
		if (infoImpuesto != null)
		{
			numObjeto = infoImpuesto.getNumObjeto().trim();
		}


		return numObjeto;
	}

	public String prepararNumObjetoReteICA(final SDHValidaMailRolResponse detalleContribuyente)
	{
		String numObjeto = null;


		if (detalleContribuyente != null)
		{
			if (detalleContribuyente.getReteIca() != null)
			{
				if (detalleContribuyente.getReteIca().getNumObjeto() != null)
				{
					numObjeto = detalleContribuyente.getReteIca().getNumObjeto().trim();
				}
			}
		}

		return numObjeto;
	}


	/**
	 * @param detalleContribuyente
	 * @return
	 */
	public String prepararDV(final SDHValidaMailRolResponse detalleContribuyente)
	{
		String dv = "";

		if (detalleContribuyente != null && detalleContribuyente.getInfoContrib() != null
				&& detalleContribuyente.getInfoContrib().getAdicionales() != null)
		{
			dv = detalleContribuyente.getInfoContrib().getAdicionales().getDIGVERIF();
		}


		return dv;
	}


	/**
	 * @param gasolina
	 * @return
	 */
	public List<SelectAtomValue> prepararCatalogoPeriodoPSE(final String tipoImpuesto)
	{
		final List<SelectAtomValue> periodo = new ArrayList<SelectAtomValue>();
		final int limite = Integer.parseInt(configurationService.getConfiguration().getString(confCantidadAnioGravableBusqueda));
		final int anioActual = obtenerAnoGravableActual();

		if (tipoImpuesto.equals(new ControllerPseConstants().getGASOLINA()))
		{
			for (int i = 0; i < limite; i++)
			{
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "01"), "Enero"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "02"), "Febrero"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "03"), "Marzo"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "04"), "Abril"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "05"), "Mayo"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "06"), "Junio"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "07"), "Julio"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "08"), "Agosto"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "09"), "Septiembre"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "10"), "Octubre"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "11"), "Noviembre"));
				periodo.add(new SelectAtomValue(prepararPeriodoMensualPago(Integer.toString(anioActual - i), "12"), "Diciembre"));
			}
		}
		if (tipoImpuesto.equals(new ControllerPseConstants().getPUBLICIDAD())
				|| tipoImpuesto.equals(new ControllerPseConstants().getDELINEACION()))
		{
			for (int i = 0; i < limite; i++)
			{
				periodo.add(new SelectAtomValue(prepararPeriodoAnualPago(Integer.toString(anioActual - i)),
						"Año " + Integer.toString(anioActual - i)));
			}
		}

		return periodo;
	}


	/**
	 * @param almacProd
	 * @return
	 */
	public String prepararValNumerico(final String valorNumString)
	{
		String valorConvertido = "";

		if (valorNumString != null)
		{
			valorConvertido = valorNumString.replaceFirst("^0+(?!$)", "");
		}

		return valorConvertido;
	}


	/**
	 * @param detalleGasolinaResponse
	 * @return
	 */
	public boolean ocurrioErrorDetalle(final DetGasResponse detalleGasolinaResponse)
	{
		boolean ocurrioError = false;

		if (detalleGasolinaResponse.getAlmacProd() == null && detalleGasolinaResponse.getAlmacTanque() == null
				&& detalleGasolinaResponse.getCalidResp() == null && detalleGasolinaResponse.getCodPostal() == null
				&& detalleGasolinaResponse.getErrores() == null && detalleGasolinaResponse.getInfoDeclara() == null
				&& detalleGasolinaResponse.getLocalidad() == null && detalleGasolinaResponse.getNumForm() == null
				&& detalleGasolinaResponse.getNumTanques() == null && detalleGasolinaResponse.getOpcionUso() == null
				&& detalleGasolinaResponse.getRepresentantes() == null && detalleGasolinaResponse.getRevisorDeclarante() == null
				&& detalleGasolinaResponse.getUbicaPlanta() == null && detalleGasolinaResponse.getValoresDeclara() == null)
		{
			ocurrioError = true;
		}
		else if (detalleGasolinaResponse.getErrores() != null)
		{
			if (detalleGasolinaResponse.getErrores().get(0) != null)
			{
				if (detalleGasolinaResponse.getErrores().get(0).getTxtmsj() != null)
				{
					ocurrioError = true;
				}
			}
		}

		return ocurrioError;
	}


	/**
	 * @param detalleContribuyente
	 * @return
	 */
	public boolean ocurrioErrorValcont(final SDHValidaMailRolResponse detalleContribuyente)
	{
		boolean ocurrioError = false;

		if (detalleContribuyente.getInfoContrib() == null && detalleContribuyente.getRoles() == null
				&& detalleContribuyente.getAgentes() == null && detalleContribuyente.getPublicidadExt() == null
				&& detalleContribuyente.getGasolina() == null && detalleContribuyente.getIca() == null)
		{
			ocurrioError = true;
		}
		else if (detalleContribuyente.getIdmsj() != 0)
		{
			ocurrioError = true;
		}

		return ocurrioError;
	}


	/**
	 * @param detalleContribuyente
	 * @param dataForm
	 */
	public void ajustarMenus(final SDHValidaMailRolResponse detalleContribuyente, final SobreTasaGasolinaForm dataForm)
	{

		if (detalleContribuyente.getGasolina() != null)
		{
			if (!detalleContribuyente.getGasolina().isEmpty())
			{
				dataForm.setbSobreGasolina("X");
			}
			else
			{
				dataForm.setbSobreGasolina("");
			}
		}
		else
		{
			dataForm.setbSobreGasolina("");
		}

		if (detalleContribuyente.getPublicidadExt() != null)
		{
			if (!detalleContribuyente.getPublicidadExt().isEmpty())
			{
				dataForm.setbPublicidadExt("X");
			}
			else
			{
				dataForm.setbPublicidadExt("");
			}
		}
		else
		{
			dataForm.setbPublicidadExt("");
		}

	}


	/**
	 * @param detallePagoResponse
	 * @return
	 */
	public boolean ocurrioErrorPSE(final DetallePagoResponse detallePagoResponse)
	{

		boolean ocurrioError = false;
		if (detallePagoResponse == null)
		{
			ocurrioError = true;
		}
		else
		{
			if (detallePagoResponse.getFechVenc() == null && detallePagoResponse.getNumBP() == null
					&& detallePagoResponse.getNumRef() == null && detallePagoResponse.getTotalPagar() == null)
			{
				ocurrioError = true;
			}
			//		else if (detallePagoResponse.getErrores() != null)
			//		{
			//			if (detallePagoResponse.getErrores().get(0) != null)
			//			{
			//				if (detallePagoResponse.getErrores().get(0).getIdmsj().equals("0") != true)
			//				{
			//					ocurrioError = true;
			//				}
			//			}
			//		}
		}

		return ocurrioError;
	}


	/**
	 * @param calculaGasolinaResponse
	 * @return
	 */
	public boolean ocurrioErrorCalcular(final CalculaGasolinaResponse calculaGasolinaResponse)
	{
		boolean ocurrioError = false;

		if (calculaGasolinaResponse.getInfoDeclara() == null && calculaGasolinaResponse.getNumForm() == null
				&& calculaGasolinaResponse.getRevisorDeclarante() == null && calculaGasolinaResponse.getValoresDeclara() == null)
		{
			ocurrioError = true;
		}
		else if (calculaGasolinaResponse.getErrores() != null)
		{
			if (calculaGasolinaResponse.getErrores().get(0) != null)
			{
				if (calculaGasolinaResponse.getErrores().get(0).getTxtmsj() != null)
				{
					ocurrioError = true;
				}
			}
		}

		return ocurrioError;
	}


	/**
	 * @param list
	 * @param i
	 * @return
	 */
	public String obtenerMensajeError(final List<ErrorEnWS> list, final int i)
	{
		String mensajeError = "";

		if (list != null)
		{
			try
			{
				if (list.get(i) != null)
				{
					mensajeError = list.get(i).getTxtmsj();
				}
			}
			catch (final Exception e)
			{
			}
		}

		return mensajeError;
	}


	/**
	 * @param anograv
	 * @return
	 */
	public String prepararPeriodoAnualPago(final String anoGravable)
	{
		String periodoConvertidoPagar = "";

		if (anoGravable != null)
		{
			periodoConvertidoPagar = anoGravable.substring(2).trim() + "A1";
		}


		return periodoConvertidoPagar;
	}


	/**
	 * @param wsRadicaDelinRequest
	 * @param sdhConsultaContribuyenteBPService
	 * @param log
	 * @return
	 */
	public RadicaDelinResponse consultaRadicaDelin(final RadicaDelinRequest requestInfo, final SDHDetalleGasolina sdhConsultaWS,
			final Logger LOG)
	{
		RadicaDelinResponse responseInfo = new RadicaDelinResponse();
		final String confUrl = "sdh.radicaDelin.url";
		final String confUser = "sdh.radicaDelin.user";
		final String confPass = "sdh.radicaDelin.password";
		final String wsNombre = "Info_Radicado";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.RadicaDelinResponse";

		responseInfo = (RadicaDelinResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre, wsReqMet,
				LOG, nombreClase);

		return responseInfo;
	}


	public boolean ocurrioErrorRadicaDelin(final RadicaDelinResponse radicaDelinResponse)
	{
		final boolean ocurrioError = false;


		return ocurrioError;
	}


	/**
	 * @param list
	 * @param string
	 * @return
	 */
	public String getAnoGravableDU(final List<ImpuestoDelineacionUrbana> list, final InfoDelineacionInput infoDelineacionInput)
	{
		String anoGravable = "";

		if (infoDelineacionInput.getSelectedAnoPresDeclaracion() != null)
		{
			anoGravable = infoDelineacionInput.getSelectedAnoPresDeclaracion();
		}
		else
		{
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i).getCdu().equals(infoDelineacionInput.getSelectedCDU()))
				{
					anoGravable = list.get(i).getFechaExp().substring(6);
				}
			}
		}

		return anoGravable;
	}

	public InfoObjetoDelineacionResponse consultaInfoDelineacion(final InfoObjetoDelineacionRequest requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		InfoObjetoDelineacionResponse responseInfo = new InfoObjetoDelineacionResponse();
		final String confUrl = "sdh.infObjetoDelineacion.url";
		final String confUser = "sdh.infObjetoDelineacion.user";
		final String confPass = "sdh.infObjetoDelineacion.password";
		final String wsNombre = "infObjeto_Delineacion";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacionResponse";

		responseInfo = (InfoObjetoDelineacionResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}

	public InfoObjetoDelineacionResponse calcularImpuestoDelineacion(final CalculoImpDelineacionRequest requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		InfoObjetoDelineacionResponse responseInfo = new InfoObjetoDelineacionResponse();
		final String confUrl = "sdh.calculoImpDelineacion.url";
		final String confUser = "sdh.calculoImpDelineacion.user";
		final String confPass = "sdh.calculoImpDelineacion.password";
		final String wsNombre = "calculoImp_Delineacion";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacionResponse";

		responseInfo = (InfoObjetoDelineacionResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}


	/**
	 * @param infoDelineacionResponse
	 * @return
	 */
	public boolean ocurrioErrorInfoDelineacion(final InfoObjetoDelineacionResponse infoDelineacionResponse)
	{
		boolean ocurrioError = false;
		final List<ErrorEnWS> errores;

		if (infoDelineacionResponse.getErrores() != null)
		{
			for (int i = 0; i < infoDelineacionResponse.getErrores().size(); i++)
			{
				if (!infoDelineacionResponse.getErrores().get(i).getIdmsj().isEmpty()
					&& !infoDelineacionResponse.getErrores().get(i).getIdmsj().equals("0")
					&& !infoDelineacionResponse.getErrores().get(i).getIdmsj().equals("99"))
				{
					ocurrioError = true;
					break;
				}
			}
		}


		return ocurrioError;
	}


	/**
	 * @param infoDelineacion
	 */
	public String obtenerNumeroObjetoDU(final InfoDelineacion infoDelineacion)
	{
		String numObjeto = "";
		final List<ImpuestoDelineacionUrbana> dealineaciones = infoDelineacion.getValCont().getDelineacion();
		final String cduSeleccionado = infoDelineacion.getInput().getSelectedCDU();

		for (int i = 0; i < dealineaciones.size(); i++)
		{
			if (dealineaciones.get(i).getCdu().equals(cduSeleccionado))
			{
				numObjeto = dealineaciones.get(i).getNumObjeto();
			}
		}

		return numObjeto;
	}


	/**
	 * @param infoDelineacionResponse
	 */
	public void prepararValorUsoDU(final InfoObjetoDelineacionResponse infoDelineacionResponse)
	{

		final Map<String, String> elementos = new LinkedHashMap<String, String>();


		elementos.put("07", "01");
		elementos.put("08", "01");
		elementos.put("09", "01");
		elementos.put("10", "01");
		elementos.put("11", "02");
		elementos.put("12", "02");
		elementos.put("13", "02");
		elementos.put("14", "02");
		elementos.put("15", "02");
		elementos.put("16", "02");
		elementos.put("17", "02");
		elementos.put("18", "02");
		elementos.put("19", "04");
		elementos.put("E1", "05");
		elementos.put("E2", "05");
		elementos.put("E3", "05");
		elementos.put("E4", "05");
		elementos.put("E5", "05");
		elementos.put("E6", "05");
		elementos.put("V1", "05");
		elementos.put("V2", "05");
		elementos.put("V3", "05");

		final List<DelineacionUUsos> usos = infoDelineacionResponse.getUsos();
		if (usos != null)
		{
			for (int i = 0; i < usos.size(); i++)
			{
				usos.get(i).setUsoCatalogo(elementos.get(usos.get(i).getCodUso()));
			}
		}


	}


	/**
	 * @param infoDelineacionResponse
	 */
	public void prepararValorcausalExcepDESCRIPCIONDU(final InfoObjetoDelineacionResponse fuente)
	{

		String campoDESCRIPCION = "";
		final String separador = " ";

		if (fuente.getInfoDeclara().getCausalExcep() != null)
		{
			campoDESCRIPCION = fuente.getInfoDeclara().getCausalExcep() + separador
					+ obtenerListaCausalExencion().get(fuente.getInfoDeclara().getCausalExcep());
		}

		fuente.getInfoDeclara().setCausalExcepDESCRIPCION(campoDESCRIPCION);

	}

	/**
	 * @param InfoDelineacion
	 */
	public void prepararValorcausalExcepDESCRIPCIONDUR(final InfoDelineacion fuente)
	{

		String campoDESCRIPCION = "";
		final String separador = " ";

		if (fuente.getInfObjetoDelineacion().getInfoDeclara().getCausalExcep() != null)
		{
			campoDESCRIPCION = fuente.getInfObjetoDelineacion().getInfoDeclara().getCausalExcep() + separador
					+ obtenerListaCausalExencion().get(fuente.getInfObjetoDelineacion().getInfoDeclara().getCausalExcep());
		}

		fuente.getInfObjetoDelineacion().getInfoDeclara().setCausalExcepDESCRIPCION(campoDESCRIPCION);

	}
	public void prepararValortipoDocDESCRIPCIONDU(final SDHValidaMailRolResponse fuente)
	{

		String campoDESCRIPCION = "";

		if (fuente.getInfoContrib().getTipoDoc() != null)
		{
			campoDESCRIPCION = obtenerListaTipoId().get(fuente.getInfoContrib().getTipoDoc());
		}

		fuente.getInfoContrib().setTipoDocDESCRIPCION(campoDESCRIPCION);

	}

	public static String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}


	/**
	 * @param icaInfObjetoResponse
	 * @return
	 */
	public String prepararClavePeriodoICA(final ICAInfObjetoResponse icaInfObjetoResponse)
	{
		final String anoGravable = icaInfObjetoResponse.getAnoGravable();
		final String periodo = icaInfObjetoResponse.getPeriodo();
		String periodoConvertidoPagar = "";


		if (periodo != null && !StringUtils.isBlank(periodo))
		{
			//			if (periodo.substring(2, 3).equals(" "))
			//			{
			//				periodoConvertidoPagar = prepararPeriodoAnualPago(icaInfObjetoResponse.getAnoGravable());
			//			}
			//			else
			//			{
			periodoConvertidoPagar = prepararPeriodoBimestralPago(anoGravable, periodo.substring(0, 2));
			//			}
		}
		else
		{
			periodoConvertidoPagar = prepararPeriodoAnualPago(icaInfObjetoResponse.getAnoGravable());
		}


		return periodoConvertidoPagar;
	}


	/**
	 * @param docTramitesResponse
	 * @return
	 */
	public boolean ocurrioErrorDocTramites(final DocTramitesResponse docTramitesResponse)
	{
		// XXX Auto-generated method stub
		return false;
	}

	/**
	 * @param docTramitesRequest
	 * @param sdhDetalleGasolinaWS
	 * @param log
	 * @return
	 */
	public DocTramitesResponse consultaDocTramites(final DocTramitesRequest requestInfo, final SDHDetalleGasolina sdhConsultaWS,
			final Logger LOG)
	{
		DocTramitesResponse responseInfo = new DocTramitesResponse();
		final String confUrl = "sdh.docTramites.url";
		final String confUser = "sdh.docTramites.user";
		final String confPass = "sdh.docTramites.password";
		final String wsNombre = "crm_docTramites";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.DocTramitesResponse";

		responseInfo = (DocTramitesResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre, wsReqMet,
				LOG, nombreClase);

		return responseInfo;
	}

	public CreaCasosResponse creacionCaso(final CreaCasosRequest requestInfo, final SDHDetalleGasolina sdhConsultaWS,
			final Logger LOG)
	{
		CreaCasosResponse responseInfo = new CreaCasosResponse();
		final String confUrl = "sdh.creaCasos.url";
		final String confUser = "sdh.creaCasos.user";
		final String confPass = "sdh.creaCasos.password";
		final String wsNombre = "crm_creaCasos";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.CreaCasosResponse";

		responseInfo = (CreaCasosResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre, wsReqMet,
				LOG, nombreClase);

		return responseInfo;
	}

	/**
	 * @param creaCasosResponse
	 * @return
	 */
	public boolean ocurrioErrorCreacionCaso(final CreaCasosResponse response)
	{
		// XXX Auto-generated method stub
		return false;
	}

	public boolean ocurrioErrorDeclaraPDF(final OpcionDeclaracionesPDFResponse response)
	{
		// XXX Auto-generated method stub
		return false;
	}


	public boolean ocurrioErrorListaDeclara(final ListaDeclaracionesResponse response)
	{
		// XXX Auto-generated method stub
		return false;
	}

	public boolean ocurrioErrorImprimePago(final OpcionCertiPagosImprimeResponse response)
	{
		// XXX Auto-generated method stub
		return false;
	}


	public boolean ocurrioErrorDecImprime(final OpcionCertiDecImprimeResponse response)
	{
		// XXX Auto-generated method stub
		return false;
	}


	/**
	 * @param consCasosResponse
	 * @return
	 */
	public boolean ocurrioErrorCreacionCaso(final ConsCasosResponse consCasosResponse)
	{
		// XXX Auto-generated method stub
		return false;
	}

	/**
	 * @param consultaCasosRequest
	 * @param sdhDetalleGasolinaWS
	 * @param log
	 * @return
	 */
	public ConsCasosResponse consultCaso(final ConsCasosRequest requestInfo, final SDHDetalleGasolina sdhConsultaWS,
			final Logger LOG)
	{
		ConsCasosResponse responseInfo = new ConsCasosResponse();
		final String confUrl = "sdh.consCasos.url";
		final String confUser = "sdh.consCasos.user";
		final String confPass = "sdh.consCasos.password";
		final String wsNombre = "crm_consCasos";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.ConsCasosResponse";

		responseInfo = (ConsCasosResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre, wsReqMet,
				LOG, nombreClase);

		return responseInfo;
	}

	/**
	 * @param consultaCasosRequest
	 * @param sdhDetalleGasolinaWS
	 * @param log
	 * @return
	 */
	public OpcionDeclaracionesPDFResponse consultaDeclaraPDF(final OpcionDeclaracionesPDFRequest requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		OpcionDeclaracionesPDFResponse responseInfo = new OpcionDeclaracionesPDFResponse();
		final String confUrl = "sdh.declaraPDF.url";
		final String confUser = "sdh.declaraPDF.user";
		final String confPass = "sdh.declaraPDF.password";
		final String wsNombre = "declaraPDF";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.OpcionDeclaracionesPDFResponse";

		responseInfo = (OpcionDeclaracionesPDFResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}

	public OpcionCertiPagosImprimeResponse certiPagosImprimir(final OpcionCertiPagosImprimeRequest requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		OpcionCertiPagosImprimeResponse responseInfo = new OpcionCertiPagosImprimeResponse();
		final String confUrl = "sdh.imprimePago.url";
		final String confUser = "sdh.imprimePago.user";
		final String confPass = "sdh.imprimePago.password";
		final String wsNombre = "docs/imprimePago";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.OpcionCertiPagosImprimeResponse";

		responseInfo = (OpcionCertiPagosImprimeResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}

	public OpcionCertiDecImprimeResponse certiDecImprimir(final OpcionCertiDecImprimeRequest requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		OpcionCertiDecImprimeResponse responseInfo = new OpcionCertiDecImprimeResponse();
		final String confUrl = "sdh.imprimeCertDeclara.url";
		final String confUser = "sdh.imprimeCertDeclara.user";
		final String confPass = "sdh.imprimeCertDeclara.password";
		final String wsNombre = "docs/imprimeCertif";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.OpcionCertiDecImprimeResponse";

		responseInfo = (OpcionCertiDecImprimeResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}

	public ListaDeclaracionesResponse consultaListaDeclaraciones(final ListaDeclaracionesRequest requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		ListaDeclaracionesResponse responseInfo = new ListaDeclaracionesResponse();
		final String confUrl = "sdh.consulCertif.url";
		final String confUser = "sdh.consulCertif.user";
		final String confPass = "sdh.consulCertif.password";
		final String wsNombre = "docs/consulCertif";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.ListaDeclaracionesResponse";

		responseInfo = (ListaDeclaracionesResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}


	public ListaDeclaracionesResponse consultaListaDeclaraciones_consulPagos(final ConsulPagosRequest requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		ListaDeclaracionesResponse responseInfo = new ListaDeclaracionesResponse();
		final String confUrl = "sdh.consulPagos.url";
		final String confUser = "sdh.consulPagos.user";
		final String confPass = "sdh.consulPagos.password";
		final String wsNombre = "docs/consulPagos";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.ListaDeclaracionesResponse";

		responseInfo = (ListaDeclaracionesResponse) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}


	public CalculoReteIca2Response consultaReteIca2(final CalculoReteIca2Request requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		CalculoReteIca2Response responseInfo = null;
		final String confUrl = "sdh.ReteIca2.url";
		final String confUser = "sdh.ReteIca2.user";
		final String confPass = "sdh.ReteIca2.password";
		final String wsNombre = "calculoImp/ReteIca2";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.CalculoReteIca2Response";

		responseInfo = (CalculoReteIca2Response) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}


	public DetalleVehiculos2Response consultaVehicular2(final DetalleVehiculos2Request requestInfo,
			final SDHDetalleGasolina sdhConsultaWS, final Logger LOG)
	{
		DetalleVehiculos2Response responseInfo = null;
		final String confUrl = "sdh.detalle.vehiculo2.url";
		final String confUser = "sdh.detalle.vehiculo2.user";
		final String confPass = "sdh.detalle.vehiculo2.password";
		final String wsNombre = "calculoImp/Vehicular2";
		final String wsReqMet = "POST";
		final String nombreClase = "de.hybris.sdh.core.pojos.responses.DetalleVehiculos2Response";

		responseInfo = (DetalleVehiculos2Response) llamarWS(requestInfo, sdhConsultaWS, confUrl, confUser, confPass, wsNombre,
				wsReqMet, LOG, nombreClase);

		return responseInfo;
	}


	/**
	 * @param customerData
	 * @return
	 */
	public OpcionDeclaracionesCatalogos prepararCatalogosOpcionDeclaraciones(final SDHValidaMailRolResponse customerData)
	{
		final OpcionDeclaracionesCatalogos catalogosForm = new OpcionDeclaracionesCatalogos();
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put("00", "Seleccionar");

		if (customerData.getVehicular() != null) //vehicular
		{
			if (customerData.getVehicular().size() > 0)
			{
				elementos.put("0002", "Vehículos");
			}
		}
		if (customerData.getIca() != null) // ica
		{
			if (!customerData.getIca().getNumObjeto().isEmpty())
			{
				elementos.put("0003", "Industria y Comercio");
			}
		}
		if (customerData.getReteIca() != null) // reteICA
		{
			if (!customerData.getReteIca().getNumObjeto().isEmpty())
			{
				elementos.put("0004", "Retención ICA");
			}
		}
		if (customerData.getGasolina() != null) //gasolina
		{
			if (customerData.getGasolina().size() > 0)
			{
				elementos.put("0005", "Sobretasa Motor");
			}
		}
		if (customerData.getDelineacion() != null) //delineacion
		{
			if (customerData.getDelineacion().size() > 0)
			{
				elementos.put("0006", "Delineación Urbana");
			}
		}
		if (customerData.getPublicidadExt() != null) //publicidad
		{
			if (customerData.getPublicidadExt().size() > 0)
			{
				elementos.put("0007", "Publicidad Exterior Visual");
			}
		}

		elementos.put("0001", "Predial");

		catalogosForm.setImpuesto(elementos);
		return catalogosForm;
	}

	/**
	 * @param infoVista
	 * @param listaDeclaracionesResponse
	 */
	public void determinarRegistrosDeclaraciones(final OpcionDeclaracionesVista infoVista,
			final ListaDeclaracionesResponse listaDeclaracionesResponse)
	{

		List<ImpuestoPublicidadExterior> publicidadExt = null;
		List<ImpuestoGasolina> gasolina = null;
		ImpuestoICA ica = null;
		ReteICA reteica = null;
		List<ImpuestoVehiculos> vehiculos = null;
		List<ImpuestoDelineacionUrbanaWithRadicados> delineacion = null;
		ImpuestoDelineacionUrbanaWithRadicados delineacion_customer_extendido = null;
		List<DetRadicadosResponse> radicados = null;
		DetRadicadosResponse infoRadicados = null;


		switch (infoVista.getClaveImpuesto())
		{
			case "0002": //Vehiculos
				vehiculos = new ArrayList<ImpuestoVehiculos>();
				if (listaDeclaracionesResponse.getDeclaraciones() != null)
				{
					for (final ItemListaDeclaraciones itemDeclaracion : listaDeclaracionesResponse.getDeclaraciones())
					{
						for (final ImpuestoVehiculos vehiculos_customer : infoVista.getCustomerData().getVehicular())
						{
							if (vehiculos_customer.getNumObjeto() != null && itemDeclaracion.getNumObjeto() != null)
							{
								if (vehiculos_customer.getNumObjeto().equals(itemDeclaracion.getNumObjeto()))
								{
									vehiculos.add(vehiculos_customer);
								}
							}
						}
					}

					if (vehiculos.size() > 0)
					{
						infoVista.setVehicular(vehiculos);
					}
				}
				break;
			case "0003": //ICA
				ica = new ImpuestoICA();
				if (listaDeclaracionesResponse.getDeclaraciones() != null)
				{
					for (final ItemListaDeclaraciones itemDeclaracion : listaDeclaracionesResponse.getDeclaraciones())
					{
						if (infoVista.getCustomerData().getIca().getNumObjeto().equals(itemDeclaracion.getNumObjeto()))
						{
							ica = infoVista.getCustomerData().getIca();
						}
					}

					if (ica != null)
					{
						infoVista.setIca(ica);
					}
				}
				break;


			case "0004": //RETEICA
				reteica = new ReteICA();
				if (listaDeclaracionesResponse.getDeclaraciones() != null)
				{
					for (final ItemListaDeclaraciones itemDeclaracion : listaDeclaracionesResponse.getDeclaraciones())
					{
						if (infoVista.getCustomerData().getReteIca().getNumObjeto().equals(itemDeclaracion.getNumObjeto()))
						{
							reteica = infoVista.getCustomerData().getReteIca();
						}
					}

					if (reteica != null)
					{
						infoVista.setReteIca(reteica);
					}
				}
				break;


			case "0005": //sobretasa gasolina
				gasolina = new ArrayList<ImpuestoGasolina>();
				if (listaDeclaracionesResponse.getDeclaraciones() != null)
				{
					for (final ItemListaDeclaraciones itemDeclaracion : listaDeclaracionesResponse.getDeclaraciones())
					{
						for (final ImpuestoGasolina gasolina_customer : infoVista.getCustomerData().getGasolina())
						{
							if (gasolina_customer.getNumObjeto().equals(itemDeclaracion.getNumObjeto()))
							{
								gasolina.add(gasolina_customer);
							}
						}
					}

					if (gasolina.size() > 0)
					{
						infoVista.setGasolina(gasolina);
					}
				}
				break;


			case "0006": //delineacion urbana
				delineacion = new ArrayList<ImpuestoDelineacionUrbanaWithRadicados>();
				if (listaDeclaracionesResponse.getDeclaraciones() != null)
				{
					for (final ItemListaDeclaraciones itemDeclaracion : listaDeclaracionesResponse.getDeclaraciones())
					{
						for (final ImpuestoDelineacionUrbana delineacion_customer : infoVista.getCustomerData().getDelineacion())
						{
							if (delineacion_customer.getNumObjeto().equals(itemDeclaracion.getNumObjeto()))
							{
								delineacion_customer_extendido = new ImpuestoDelineacionUrbanaWithRadicados();
								delineacion_customer_extendido.setCdu(delineacion_customer.getCdu());
								delineacion_customer_extendido.setLicenConst(delineacion_customer.getLicenConst());
								delineacion_customer_extendido.setNumObjeto(delineacion_customer.getNumObjeto());

								radicados = null;
								if (itemDeclaracion.getNumRadicado() != null)
								{
									radicados = new ArrayList<DetRadicadosResponse>();
									infoRadicados = new DetRadicadosResponse();

									infoRadicados.setNumRadicado(itemDeclaracion.getNumRadicado());
									radicados.add(infoRadicados);
								}
								delineacion_customer_extendido.setRadicados(radicados);

								delineacion.add(delineacion_customer_extendido);
							}
						}
					}

					if (delineacion.size() > 0)
					{
						infoVista.setDelineacion(delineacion);
					}
				}
				break;


			case "0007": //publicidad exterior
				publicidadExt = new ArrayList<ImpuestoPublicidadExterior>();
				if (listaDeclaracionesResponse.getDeclaraciones() != null)
				{
					for (final ItemListaDeclaraciones itemDeclaracion : listaDeclaracionesResponse.getDeclaraciones())
					{
						for (final ImpuestoPublicidadExterior publicidadExt_customer : infoVista.getCustomerData().getPublicidadExt())
						{
							if (publicidadExt_customer.getNumObjeto().equals(itemDeclaracion.getNumObjeto())
									&& publicidadExt_customer.getAnoGravable().equals(infoVista.getAnoGravable()))
							{
								publicidadExt.add(publicidadExt_customer);
							}
						}
					}

					if (publicidadExt.size() > 0)
					{
						infoVista.setPublicidadExt(publicidadExt);
					}
				}
				break;


			default:
				break;
		}

	}


	public List<ItemListaDeclaraciones> determinarRegistrosDeclaraciones_certipagos(final OpcionDeclaracionesVista infoVista,
			final ListaDeclaracionesResponse listaDeclaracionesResponse, final SobreTasaGasolinaService gasolinaService)
	{

		List<ItemListaDeclaraciones> declaraciones_selected = null;


		switch (infoVista.getClaveImpuesto())
		{
			//implementar la logica para cada impuesto

			case "0002":
				declaraciones_selected = new ArrayList<ItemListaDeclaraciones>();
				declaraciones_selected.addAll(listaDeclaracionesResponse.getDeclaraciones());

				break;

			case "0003": //ICA
				declaraciones_selected = new ArrayList<ItemListaDeclaraciones>();
				declaraciones_selected.addAll(listaDeclaracionesResponse.getDeclaraciones());
				break;

			case "0004": //RETEICA
				declaraciones_selected = new ArrayList<ItemListaDeclaraciones>();
				declaraciones_selected.addAll(listaDeclaracionesResponse.getDeclaraciones());
				break;



			case "0005": //sobretasa gasolina
				declaraciones_selected = new ArrayList<ItemListaDeclaraciones>();
				String periodo = null;
				for (final ItemListaDeclaraciones declaracionRow : listaDeclaracionesResponse.getDeclaraciones())
				{

					if (infoVista.getPeriodo().equals("00"))
					{
						periodo = gasolinaService.prepararPeriodoAnualPago(infoVista.getAnoGravable());
					}
					else
					{
						periodo = infoVista.getAnoGravable().substring(2) + infoVista.getPeriodo();
					}

					if (declaracionRow.getClavePeriodo() != null && declaracionRow.getClavePeriodo().equals(periodo))
					{
						declaraciones_selected.add(declaracionRow);
					}
				}
				break;

			//				case "0006": //Delineacion Urbana
			//					break;
			//
			//				case "0007": //Publicidad Exterior
			//					break;

			default:
				declaraciones_selected = new ArrayList<ItemListaDeclaraciones>();
				declaraciones_selected.addAll(listaDeclaracionesResponse.getDeclaraciones());
				break;
		}

		return declaraciones_selected;
	}

	/**
	 * @param claveImpuesto
	 * @param customerData
	 * @return
	 */
	public String prepararNumObjeto_certipagos(final OpcionDeclaracionesVista infoVista,
			final SDHValidaMailRolResponse customerData)
	{
		String numObjeto = null;

		switch (infoVista.getClaveImpuesto())
		{

			//implementar la logica para cada impuesto
			case "0002": //vehiculos
				if (customerData != null)
				{
					if (customerData.getVehicular() != null)
					{
						if (customerData.getVehicular().get(0) != null)
						{
							numObjeto = customerData.getVehicular().get(0).getNumObjeto();
						}
					}
				}

				break;

			case "0003": //ICA
				if (customerData != null)
				{
					if (customerData.getIca() != null)
					{
						numObjeto = customerData.getIca().getNumObjeto();
					}
				}

				break;


			//implementar la logica para cada impuesto
			case "0004": //RETEICA
				if (customerData != null)
				{
					if (customerData.getReteIca() != null)
					{
						numObjeto = customerData.getReteIca().getNumObjeto();
					}
				}

				break;


			case "0005": //sobretasa gasolina
				if (customerData != null)
				{
					if (customerData.getGasolina() != null)
					{
						if (customerData.getGasolina().get(0) != null)
						{
							numObjeto = customerData.getGasolina().get(0).getNumObjeto();
						}
					}
				}

				break;

			//			case "0006": //delineacion urbana
			//
			//				break;
			//
			//
			//			case "0007": //publicidad exterior
			//
			//				break;
			default:

				break;
		}

		return numObjeto;
	}

	/**
	 * @param detalleContribuyente
	 * @param placa
	 * @return
	 */
	public String prepararNumObjetoVehicular(final SDHValidaMailRolResponse detalleContribuyente, final String placa)
	{
		String numObjeto = "";
		List<ImpuestoVehiculos> detalleImpuesto = null;


		detalleImpuesto = detalleContribuyente.getVehicular();
		if (detalleContribuyente != null && detalleImpuesto != null)
		{
			for (int i = 0; i < detalleImpuesto.size(); i++)
			{
				if (detalleImpuesto.get(i) != null)
				{
					if (detalleImpuesto.get(i).getPlaca() != null)
					{
						if (detalleImpuesto.get(i).getPlaca().equals(placa))
						{
							numObjeto = detalleImpuesto.get(i).getNumObjeto();
						}
					}
				}
			}
		}


		return numObjeto;
	}

	/**
	 * @param calculoResponse
	 * @return
	 */
	public boolean ocurrioErrorCalc2Reteica(final CalculoReteIca2Response calculoResponse)
	{
		// XXX Auto-generated method stub
		return false;
	}

	/**
	 * @param periodo
	 * @return
	 */
	public String prepararDescPeriodoBimestral_ICA(String periodo)
	{
		String descripcion = "";

		if (periodo != null)
		{
			periodo = StringUtils.trim(periodo);
			if (!StringUtils.isAllEmpty(periodo))
			{
				switch (periodo)
				{
					case "01":
						descripcion = "01 - Ene / Feb";
						break;
					case "02":
						descripcion = "02 - Mar / Abr";
						break;
					case "03":
						descripcion = "03 - May / Jun";
						break;
					case "04":
						descripcion = "04 - Jul / Ago";
						break;
					case "05":
						descripcion = "05 - Sep / Oct";
						break;
					case "06":
						descripcion = "06 - Nov / Dic";
						break;

					default:
						break;
				}
			}
		}

		return descripcion;
	}


}

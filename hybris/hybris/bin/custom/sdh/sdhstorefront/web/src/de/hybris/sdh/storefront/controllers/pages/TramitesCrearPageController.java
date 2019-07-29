/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.customBreadcrumbs.Breadcrumb;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.DocTramitesRequest;
import de.hybris.sdh.core.pojos.responses.DocTramitesResponse;
import de.hybris.sdh.core.pojos.responses.ItemSelectOption;
import de.hybris.sdh.core.pojos.responses.TramitesSeleccionInfo;
import de.hybris.sdh.core.pojos.responses.TramitesSeleccionInfoVista;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class TramitesCrearPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Crear Tramites";

	// CMS Pages
	private static final String TRAMITES_CREAR_CMS_PAGE = "tramitesCrearPage";

	private static final String REDIRECT_TO_TRAMITES_CREAR_PAGE = REDIRECT_PREFIX + "/contibuyentes/tramites/crear";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;



	@RequestMapping(value = "/contibuyentes/tramites/crear", method = RequestMethod.GET)
	@RequireHardLogIn
	public String tramitescreaar(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET TRAMITES crear --------------------------");

		final TramitesSeleccionInfo dataForm = new TramitesSeleccionInfo();

		model.addAttribute("dataForm", dataForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE);

		model.addAttribute(BREADCRUMBS_ATTR, breadcrumbs);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}





	@RequestMapping(value = "/contibuyentes/tramites/crear", method = RequestMethod.POST)
	@RequireHardLogIn
	public String tramitescrearpost(@ModelAttribute("dataForm")
	final TramitesSeleccionInfo dataForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de TRAMITES CREAR------------------------");

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final List<ItemSelectOption> elementosResponse = new ArrayList<ItemSelectOption>();
		final List<TramiteOpcion> elementos = new ArrayList<TramiteOpcion>();
		TramiteOpcion elementoSeleccionado = null;
		String busquedaSubKey = "";
		final StringBuffer sb = new StringBuffer();


		llenarElementosTramites(elementos);

		busquedaSubKey = obtenerKeyCrearTramite(dataForm);
		for (final TramiteOpcion elemento : elementos)
		{
			if (elemento.getKey().equals(busquedaSubKey))
			{
				elementoSeleccionado = elemento;
				break;
			}
		}

		if (elementoSeleccionado != null)
		{



		}


		return REDIRECT_TO_TRAMITES_CREAR_PAGE;
	}




	@RequestMapping(value = "/contribuyentes/tramites/seleccionNivel", method = RequestMethod.GET)
	@ResponseBody
	public TramitesSeleccionInfoVista tramitesSeleccionNivelGET(@ModelAttribute("tramitesSeleccionInfo")
	final TramitesSeleccionInfo tramitesSeleccionInfo, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET SeleccionNivel------------------------");
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final List<ItemSelectOption> elementosResponse = new ArrayList<ItemSelectOption>();
		final List<TramiteOpcion> elementos = new ArrayList<TramiteOpcion>();
		final TramitesSeleccionInfoVista infoVista = new TramitesSeleccionInfoVista();
		String busquedaSubKeyOpciones = "";
		String busquedaSubKeyDocs = "";
		TramiteOpcion elementoSeleccionado = null;
		String processType = "";
		String categoriza = "";
		final DocTramitesRequest docTramitesRequest = new DocTramitesRequest();
		DocTramitesResponse docTramitesResponse = null;


		llenarElementosTramites(elementos);
		busquedaSubKeyOpciones = obtenerKeySelNivel(tramitesSeleccionInfo);
		busquedaSubKeyDocs = obtenerKeyCrearTramite(tramitesSeleccionInfo);

		for (final TramiteOpcion elemento : elementos)
		{
			if (elemento.getKey().matches(busquedaSubKeyOpciones))
			{
				elementosResponse
						.add(new ItemSelectOption(elemento.getTramiteOpcion().getKey(), elemento.getTramiteOpcion().getLabel()));
			}
			if (elemento.getKey().equals(busquedaSubKeyDocs))
			{
				elementoSeleccionado = elemento;
			}
		}

		if (elementoSeleccionado != null)
		{
			if (elementoSeleccionado.getProcessID() != null && elementoSeleccionado.getCategorizacion() != null)
			{
				processType = elementoSeleccionado.getProcessID();
				categoriza = elementoSeleccionado.getCategorizacion();

				docTramitesRequest.setProcessType(processType);
				docTramitesRequest.setCategoriza(categoriza);

				System.out.println("Request para crm/docTramites: " + docTramitesRequest);
				docTramitesResponse = gasolinaService.consultaDocTramites(docTramitesRequest, sdhDetalleGasolinaWS, LOG);
				System.out.println("Response de crm/docTramites: " + docTramitesResponse);
				if (gasolinaService.ocurrioErrorDocTramites(docTramitesResponse) != true)
				{
				}
				else
				{
				}
			}
		}

		infoVista.setOpciones(elementosResponse);
		infoVista.setDocTramitesResponse(docTramitesResponse);

		//		storeCmsPageInModel(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));
		//		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));


		return infoVista;
	}


	@RequestMapping(value = "/contribuyentes/tramites/consulDocTramite", method = RequestMethod.GET)
	@ResponseBody
	public DocTramitesResponse consulDocTramiteGET(@ModelAttribute("tramitesSeleccionInfo")
	final TramitesSeleccionInfo tramitesSeleccionInfo, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET consulta Doc Tramites------------------------");
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final List<ItemSelectOption> elementosResponse = new ArrayList<ItemSelectOption>();
		final List<TramiteOpcion> elementos = new ArrayList<TramiteOpcion>();
		TramiteOpcion elementoSeleccionado = null;
		String busquedaSubKey = "";
		final DocTramitesRequest docTramitesRequest = new DocTramitesRequest();
		final DocTramitesResponse docTramitesResponse = new DocTramitesResponse();
		final String processType = "";
		final String categoriza = "";


		llenarElementosTramites(elementos);
		busquedaSubKey = obtenerKeySelNivel(tramitesSeleccionInfo);

		for (final TramiteOpcion elemento : elementos)
		{
			if (elemento.getKey().matches(busquedaSubKey))
			{
				elementoSeleccionado = elemento;
				break;
			}
		}




		storeCmsPageInModel(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));


		return docTramitesResponse;
	}


	/**
	 * @param tramitesSeleccionInfo
	 * @return
	 */
	private String obtenerKeySelNivel(final TramitesSeleccionInfo infoSeleccion)
	{
		final StringBuffer sb = new StringBuffer();


		if (infoSeleccion.getValorN0() != null && !infoSeleccion.getValorN0().isEmpty())
		{
			sb.append(infoSeleccion.getValorN0());
			if (infoSeleccion.getValorN1() != null && !infoSeleccion.getValorN1().isEmpty())
			{
				sb.append(infoSeleccion.getValorN1());
				if (infoSeleccion.getValorN2() != null && !infoSeleccion.getValorN2().isEmpty())
				{
					sb.append(infoSeleccion.getValorN2());
					if (infoSeleccion.getValorN3() != null && !infoSeleccion.getValorN3().isEmpty())
					{
						sb.append(infoSeleccion.getValorN3());
					}
					else
					{
						sb.append("\\d\\d");
					}
				}
				else
				{
					sb.append("\\d\\d__");
				}
			}
			else
			{
				sb.append("\\d\\d____");
			}
		}

		return sb.toString();
	}


	private String obtenerKeyCrearTramite(final TramitesSeleccionInfo infoSeleccion)
	{
		final StringBuffer sb = new StringBuffer();


		if (infoSeleccion.getValorN0() != null && !infoSeleccion.getValorN0().isEmpty())
		{
			sb.append(infoSeleccion.getValorN0());
			if (infoSeleccion.getValorN1() != null && !infoSeleccion.getValorN1().isEmpty())
			{
				sb.append(infoSeleccion.getValorN1());
				if (infoSeleccion.getValorN2() != null && !infoSeleccion.getValorN2().isEmpty())
				{
					sb.append(infoSeleccion.getValorN2());
					if (infoSeleccion.getValorN3() != null && !infoSeleccion.getValorN3().isEmpty())
					{
						sb.append(infoSeleccion.getValorN3());
					}
					else
					{
						sb.append("__");
					}
				}
				else
				{
					sb.append("____");
				}
			}
			else
			{
				sb.append("______");
			}
		}

		return sb.toString();
	}


	/**
	 * @param elementos
	 *
	 */
	private void llenarElementosTramites(final List<TramiteOpcion> elementos)
	{

		//RIT
		agregarElementoTramites(elementos, "0100____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0101____", "01", "Creación");
		agregarElementoTramites(elementos, "0102____", "02", "Actualización");
		//RIT-Creación
		agregarElementoTramites(elementos, "010100__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "010101__", "01", "Creación de RIT");
		agregarElementoTramites(elementos, "010102__", "02", "Registro / Rol Tributario");
		agregarElementoTramites(elementos, "010103__", "03", "Creación de Calidad Sujeción Pasiva");
		//RIT-Creación-Registro / Rol Tributario
		agregarElementoTramites(elementos, "01010200", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01010201", "01", "Persona Natural", "ZT02", "A1ZTRT0004Z065");
		agregarElementoTramites(elementos, "01010202", "02", "Persona Jurídica", "ZT02", "A1ZTRT0004Z065");
		//RIT-Creación-Creación de Calidad Sujeción Pasiva
		agregarElementoTramites(elementos, "01010300", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01010301", "01", "Predial unificado/ Propietario", "ZT04", "A1ZTRT0004Z067");
		agregarElementoTramites(elementos, "01010302", "02", "Predial unificado/ Usufructuario", "ZT04", "A1ZTRT0004Z068");
		agregarElementoTramites(elementos, "01010303", "03", "Predial unificado/ Beneficio/Fideicomitente", "ZT04",
				"A1ZTRT0004Z069");
		agregarElementoTramites(elementos, "01010304", "04", "Predial unificado/ Arrendatario", "ZT04", "A1ZTRT0004Z070");
		agregarElementoTramites(elementos, "01010305", "05", "Predial unificado/ Poseedor", "ZT04", "A1ZTRT0004Z071");
		agregarElementoTramites(elementos, "01010306", "06", "Vehículos automotores / Propietario", "ZT04", "A1ZTRT0004Z072");
		agregarElementoTramites(elementos, "01010307", "07", "Vehículos automotores / Poseedor", "ZT04", "A1ZTRT0004Z073");
		agregarElementoTramites(elementos, "01010308", "08", "Vehículos / Beneficio/Fideicomitente", "ZT04", "A1ZTRT0004Z101");
		agregarElementoTramites(elementos, "01010309", "09", "Industria y comercio ICA", "ZT04", "A1ZTRT0004Z074");
		agregarElementoTramites(elementos, "01010310", "10", "Delineación urbana", "ZT04", "A1ZTRT0004Z075");
		agregarElementoTramites(elementos, "01010311", "11", "Sobretasa a la gasolina", "ZT04", "A1ZTRT0004Z076");
		agregarElementoTramites(elementos, "01010312", "12", "Publicidad exterior visual", "ZT04", "A1ZTRT0004Z077");
		//RIT-Actualización
		agregarElementoTramites(elementos, "010200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "010201__", "01", "Actualización de RIT");
		agregarElementoTramites(elementos, "010202__", "02", "Actualización de Rol tributario");
		agregarElementoTramites(elementos, "010203__", "03", "Actualización Calidad Sujeción Pasiva");
		//RIT-Actualización-Actualización de Rol tributario
		agregarElementoTramites(elementos, "01020200", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01020201", "01", "Persona Natural");
		agregarElementoTramites(elementos, "01020202", "02", "Persona Jurídica");
		//RIT-Actualización-Actualización Calidad Sujeción Pasiva
		agregarElementoTramites(elementos, "0102030", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01020301", "01", "Predial unificado/ Propietario", "ZT05", "A1ZTRT0004Z080");
		agregarElementoTramites(elementos, "01020302", "02", "Predial unificado/ Usufructuario", "ZT05", "A1ZTRT0004Z081");
		agregarElementoTramites(elementos, "01020303", "03", "Predial unificado/ Beneficio/Fideicomitente", "ZT05",
				"A1ZTRT0004Z082");
		agregarElementoTramites(elementos, "01020304", "04", "Predial unificado/ Arrendatario", "ZT05", "A1ZTRT0004Z083");
		agregarElementoTramites(elementos, "01020305", "05", "Predial unificado/ Poseedor", "ZT05", "A1ZTRT0004Z084");
		agregarElementoTramites(elementos, "01020306", "06", "Vehículos automotores / Propietario", "ZT05", "A1ZTRT0004Z085");
		agregarElementoTramites(elementos, "01020307", "07", "Vehículos automotores / Poseedor", "ZT05", "A1ZTRT0004Z086");
		agregarElementoTramites(elementos, "01020308", "08", "Vehículos / Beneficio/Fideicomitente", "ZT05", "A1ZTRT0004Z103");
		agregarElementoTramites(elementos, "01020309", "09", "Industria y comercio ICA", "ZT05", "A1ZTRT0004Z087");
		agregarElementoTramites(elementos, "01020310", "10", "Delineación urbana", "ZT05", "A1ZTRT0004Z088");
		agregarElementoTramites(elementos, "01020311", "11", "Sobretasa a la gasolina", "ZT05", "A1ZTRT0004Z089");
		agregarElementoTramites(elementos, "01020312", "12", "Publicidad exterior visual", "ZT05", "A1ZTRT0004Z090");

		//Novedades de registro
		agregarElementoTramites(elementos, "0200____", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "0201____", "01", "Exclusiones", "", "");
		agregarElementoTramites(elementos, "0202____", "02", "Excenciones", "", "");
		agregarElementoTramites(elementos, "0203____", "03", "Tratamiento Especial", "", "");
		agregarElementoTramites(elementos, "0204____", "04", "Novedades RIT", "", "");
		//Novedades de registro-Exclusiones
		agregarElementoTramites(elementos, "020100__", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "020101__", "01", "Por Predial", "", "");
		agregarElementoTramites(elementos, "020102__", "02", "Por Vehículos", "", "");
		agregarElementoTramites(elementos, "020103__", "03", "Por Delineación Urbana", "", "");
		//Novedades de registro-Exclusiones-Por Predial
		agregarElementoTramites(elementos, "02010100", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02010101", "01", "Uso Publico. Ronda-Canal-Zampa", "", "");
		agregarElementoTramites(elementos, "02010102", "02", "Uso Publico. General", "", "");
		agregarElementoTramites(elementos, "02010103", "03", "Iglesias Católicas", "", "");
		agregarElementoTramites(elementos, "02010104", "04", "Iglesias No Católicas", "", "");
		agregarElementoTramites(elementos, "02010105", "05", "Juntas de acción comunal", "", "");
		agregarElementoTramites(elementos, "02010106", "06", "Policía Nacional", "", "");
		agregarElementoTramites(elementos, "02010107", "07", "Fuerzas Militares", "", "");
		agregarElementoTramites(elementos, "02010108", "08", "Parques recreativos", "", "");
		agregarElementoTramites(elementos, "02010109", "09", "Instituto de desarrollo urbano IDU", "", "");
		agregarElementoTramites(elementos, "02010110", "10", "Avalúos inferiores a 16 SMLV", "", "");
		agregarElementoTramites(elementos, "02010111", "11", "Tumbas y bóvedas funerarias", "", "");
		agregarElementoTramites(elementos, "02010112", "12", "Victimas del despojo o Desplazamiento forzado", "", "");
		//Novedades de registro-Exclusiones-Por Vehículos
		agregarElementoTramites(elementos, "02010200", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02010201", "01", "Motocicletas 125 cm3", "", "");
		agregarElementoTramites(elementos, "02010202", "02", "Maquinaria agrícola", "", "");
		agregarElementoTramites(elementos, "02010203", "03", "Vehículos oficiales", "", "");
		//Novedades de registro-Exclusiones-Por Delineación Urbana
		agregarElementoTramites(elementos, "02010300", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02010301", "01", "Sujetos  convención Viena", "", "");
		agregarElementoTramites(elementos, "02010302", "02", "Soc. Nac. Cruz Roja Colombiana", "", "");
		agregarElementoTramites(elementos, "02010303", "03", "Distrito Capital", "", "");
		//Novedades de registro-Excenciones
		agregarElementoTramites(elementos, "020200__", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "020201__", "01", "Por Predial", "", "");
		agregarElementoTramites(elementos, "020202__", "02", "Vehículos", "", "");
		agregarElementoTramites(elementos, "020203__", "03", "Por Delineación Urbana", "", "");
		agregarElementoTramites(elementos, "020204__", "04", "Por ICA", "", "");
		//Novedades de registro-Excenciones-Por Predial
		agregarElementoTramites(elementos, "02020100", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02020101", "01", "Interes Actual", "", "");
		agregarElementoTramites(elementos, "02020102", "02", "Sindicatos", "", "");
		agregarElementoTramites(elementos, "02020103", "03", "Distrito bienes por dependencia", "", "");
		agregarElementoTramites(elementos, "02020104", "04", "Actos Terroristas", "", "");
		agregarElementoTramites(elementos, "02020105", "05", "Catástrofes Nataturales", "", "");
		agregarElementoTramites(elementos, "02020106", "06", "Secuestro/Desaparición forzada", "", "");
		agregarElementoTramites(elementos, "02020107", "07", "Banco de Suelo Distrital", "", "");
		//Novedades de registro-Excenciones-Vehículos
		agregarElementoTramites(elementos, "02020200", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02020201", "01", "Actos Terroristas", "", "");
		agregarElementoTramites(elementos, "02020202", "02", "Catástrofes Nataturales", "", "");
		agregarElementoTramites(elementos, "02020203", "03", "Secuestro/Desaparición forzada", "", "");
		//Novedades de registro-Excenciones-Por Delineación Urbana
		agregarElementoTramites(elementos, "02020300", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02020301", "01", "Actos Terroristas", "", "");
		agregarElementoTramites(elementos, "02020302", "02", "Catástrofes Nataturales", "", "");
		agregarElementoTramites(elementos, "02020303", "03", "Obras nuevas de vivienda de interés social estratos 1,2, y 3", "",
				"");
		agregarElementoTramites(elementos, "02020304", "04",
				"Obras de autoconstrucción de vivienda, de estratos 1 y 2 que no excedan de 135 SMLV", "", "");
		agregarElementoTramites(elementos, "02020305", "05",
				"Las ampliaciones, modificaciones, adecuaciones o reparación de los inmuebles de los estratos 1, 2 y 3 de uso residencial, con avalúo catastral vigente inferior a 135",
				"", "");
		agregarElementoTramites(elementos, "02020306", "06",
				"Las obras de restauración y conservación en los bienes inmuebles de interés cultural.", "", "");
		//Novedades de registro-Excenciones-Por ICA
		agregarElementoTramites(elementos, "02020400", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02020401", "01", "Actos Terroristas", "", "");
		agregarElementoTramites(elementos, "02020401", "02", "Catástrofes Nataturales", "", "");
		agregarElementoTramites(elementos, "02020403", "03", "Secuestro/Desaparición forzada", "", "");
		//Novedades de registro-Tratamiento Especial
		agregarElementoTramites(elementos, "020300__", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "020301__", "01", "Por Predial", "", "");
		//Novedades de registro-Tratamiento Especial-Por Predial
		agregarElementoTramites(elementos, "02030100", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02030101", "01", "Suelo Rural", "", "");
		agregarElementoTramites(elementos, "02030102", "02", "Desarrollo Urbanístico", "", "");
		agregarElementoTramites(elementos, "02030103", "03", "Áreas Protegidas", "", "");
		agregarElementoTramites(elementos, "02030104", "04",
				"Predios con actividades industriales de bajo y   medio impacto al medio ambiente", "", "");
		agregarElementoTramites(elementos, "02030105", "05", "Remoción de tierras y riesgo no mitigable", "", "");
		agregarElementoTramites(elementos, "02030106", "06", "Desastres naturales o atentado terrorista", "", "");
		agregarElementoTramites(elementos, "02030107", "07",
				"Entidades de asistencia pública, entidades con fines de interés social y de utilidad pública y fundaciones, sin animo de lucro, de derecho público o privado",
				"", "");
		agregarElementoTramites(elementos, "02030108", "08", "Extinción de dominio", "", "");
		agregarElementoTramites(elementos, "02030109", "09", "Predios con actividad financiera", "", "");
		agregarElementoTramites(elementos, "02030110", "10", "Zona Franca", "", "");
		//Novedades de registro-Novedades RIT
		agregarElementoTramites(elementos, "020400__", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "020401__", "01", "Por ICA", "", "");
		//Novedades de registro-Novedades RIT-Por ICA
		agregarElementoTramites(elementos, "02040100", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "02040101", "01", "Actividad Económica", "", "");
		agregarElementoTramites(elementos, "02040102", "02", "Cambio de representante legal", "", "");
		agregarElementoTramites(elementos, "02040103", "03", "Cambio de revisor Fiscal", "", "");
		agregarElementoTramites(elementos, "02040104", "04", "Cambio de Contador", "", "");
		agregarElementoTramites(elementos, "02040105", "05", "Cambio de establecimientos", "", "");

		//Facturación
		agregarElementoTramites(elementos, "0300____", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "0301____", "01", "Por Predial", "", "");
		agregarElementoTramites(elementos, "0302____", "02", "Por Vehículos", "", "");
		//Facturación-Por Predial
		agregarElementoTramites(elementos, "030100__", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "030101__", "01", "Descarga de Factura", "", "");
		agregarElementoTramites(elementos, "030102__", "02", "Descuento adicional del 1%", "", "");
		agregarElementoTramites(elementos, "030103__", "03", "Reexpedicion de facturas", "", "");
		agregarElementoTramites(elementos, "030104__", "04", "Solicitud de moficación de Factura", "", "");
		agregarElementoTramites(elementos, "030105__", "05", "Solicitud de anulacion de facturas ", "", "");
		//Facturación-Por Predial-Solicitud de moficación de Factura
		agregarElementoTramites(elementos, "03010400", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "03010401", "01", "Modificación Avaluó Catastral", "", "");
		agregarElementoTramites(elementos, "03010402", "02", "Modificación de destino hacendario", "", "");
		agregarElementoTramites(elementos, "03010403", "03", "Modificación  tarifa", "", "");
		agregarElementoTramites(elementos, "03010404", "04", "Ajuste % Participación", "", "");
		agregarElementoTramites(elementos, "03010405", "05", "Exclusiones Parciales Predial", "", "");
		agregarElementoTramites(elementos, "03010406", "06", "Exenciones Parciales Predial", "", "");
		agregarElementoTramites(elementos, "03010407", "07", "Descuentos por incremento diferencial", "", "");
		//Facturación-Por Predial-Solicitud de anulacion de facturas
		agregarElementoTramites(elementos, "03010500", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "03010501", "01", "No sujeción", "", "");
		agregarElementoTramites(elementos, "03010502", "02", "Inexistencia actual del objeto", "", "");
		agregarElementoTramites(elementos, "03010503", "03", "Exencion total del  objeto", "", "");
		agregarElementoTramites(elementos, "03010504", "04", "Exclusión total del  objeto", "", "");
		//Facturación-Por Vehículos
		agregarElementoTramites(elementos, "030200__", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "030201__", "01", "Descarga de Factura", "", "");
		agregarElementoTramites(elementos, "030202__", "02", "Reexpedición de Factura", "", "");
		agregarElementoTramites(elementos, "030203__", "03", "Moficación de Factura", "", "");
		agregarElementoTramites(elementos, "030204__", "04", "Anulación de Factura", "", "");
		//Facturación-Por Vehículos-Moficación de Factura
		agregarElementoTramites(elementos, "03020300", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "03020301", "01", "Modificación Avaluó", "", "");
		agregarElementoTramites(elementos, "03020302", "02",
				"Modificación de placa, marca, línea, modelo, capacidad(cilindraje),  uso y grupo", "", "");
		//Facturación-Por Vehículos-Anulación de Factura
		agregarElementoTramites(elementos, "03020400", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "03020401", "01", "No sujeción", "", "");
		agregarElementoTramites(elementos, "03020402", "02", "Inexistencia objeto", "", "");
		agregarElementoTramites(elementos, "03020403", "03", "Exención total del  objeto", "", "");
		agregarElementoTramites(elementos, "03020404", "04", "Exclusión total  del  objeto", "", "");

		//Analisis de la cuenta
		agregarElementoTramites(elementos, "0400____", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "0401____", "01", "Certificación de deuda", "", "");
		agregarElementoTramites(elementos, "0402____", "02",
				"Diferencia en la imputación de pagos efectuados a través de declaraciones y/o ROP", "", "");
		agregarElementoTramites(elementos, "0403____", "03", "Ajuste por situaciones administrativas", "", "");
		agregarElementoTramites(elementos, "0404____", "04", "Revisión de datos SAP", "", "");

		//Boletín de deudores Morosos del Estado
		agregarElementoTramites(elementos, "0500____", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "0501____", "01", "Deuda Cancelada", "", "");
		agregarElementoTramites(elementos, "0502____", "02", "Saneamiento de información", "", "");
		agregarElementoTramites(elementos, "0503____", "03", "Existe acuerdo de pago vigente", "", "");
		agregarElementoTramites(elementos, "0504____", "04", "Otra cual", "", "");

		//Declaración
		agregarElementoTramites(elementos, "0800____", "00", "Seleccionar", "", "");
		agregarElementoTramites(elementos, "0801____", "01", "Autorización por declaración valores inferiores al sugerido", "", "");
		agregarElementoTramites(elementos, "0802____", "02", "Porcentaje de copropiedad", "", "");
		agregarElementoTramites(elementos, "0803____", "03", "Doble sujeción pasiva (Propietario, Poseedor)", "", "");
		agregarElementoTramites(elementos, "0804____", "04", "Pago Equivocado", "", "");


	}

	/**
	 * @param elementos
	 * @param string
	 * @param string2
	 * @param string3
	 */
	private void agregarElementoTramites(final List<TramiteOpcion> elementos, final String claveBusqueda,
			final String idTramiteOpcion, final String descripcionTramiteOpcion, final String processID,
			final String idCategorizacion)
	{
		elementos.add(new TramiteOpcion(claveBusqueda, new ItemSelectOption(idTramiteOpcion, descripcionTramiteOpcion), processID,
				idCategorizacion, "02"));

	}

	private void agregarElementoTramites(final List<TramiteOpcion> elementos, final String claveBusqueda,
			final String idTramiteOpcion, final String descripcionTramiteOpcion)
	{
		elementos.add(new TramiteOpcion(claveBusqueda, new ItemSelectOption(idTramiteOpcion, descripcionTramiteOpcion)));

	}

}

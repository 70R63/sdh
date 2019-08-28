/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.Breadcrumb;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.CreaCasosArchiInfoRequest;
import de.hybris.sdh.core.pojos.requests.CreaCasosArchiRequest;
import de.hybris.sdh.core.pojos.requests.CreaCasosAtribRequest;
import de.hybris.sdh.core.pojos.requests.CreaCasosRequest;
import de.hybris.sdh.core.pojos.requests.DocTramitesRequest;
import de.hybris.sdh.core.pojos.responses.CreaCasoArchVista;
import de.hybris.sdh.core.pojos.responses.CreaCasosResponse;
import de.hybris.sdh.core.pojos.responses.DocTramitesResponse;
import de.hybris.sdh.core.pojos.responses.ItemSelectOption;
import de.hybris.sdh.core.pojos.responses.TramitesCreacionCasoInfo;
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

	@Resource(name = "userService")
	UserService userService;


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
		String urlAccion = null;


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
			if (elementoSeleccionado.getUrlAccion() != null)
			{
				urlAccion = elementoSeleccionado.getUrlAccion();
			}

		}

		infoVista.setOpciones(elementosResponse);
		infoVista.setDocTramitesResponse(docTramitesResponse);
		infoVista.setUrlAccion(urlAccion);


		return infoVista;
	}


	@RequestMapping(value = "/contribuyentes/tramites/creacionCaso", method = RequestMethod.POST)
	@ResponseBody
	public CreaCasosResponse creacionCasoGET(@ModelAttribute("tramitesCreacionCasoInfo")
	final TramitesCreacionCasoInfo tramitesCreacionCasoInfo, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		System.out.println("------------------En POST creacion caso------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final TramitesSeleccionInfo tramitesSeleccionInfo = new TramitesSeleccionInfo();
		final List<ItemSelectOption> elementosResponse = new ArrayList<ItemSelectOption>();
		final List<TramiteOpcion> elementos = new ArrayList<TramiteOpcion>();
		TramiteOpcion elementoSeleccionado = null;
		String busquedaSubKey = "";
		final CreaCasosRequest creaCasosRequest = new CreaCasosRequest();
		CreaCasosResponse creaCasosResponse = new CreaCasosResponse();
		final List<CreaCasosAtribRequest> atributos = new ArrayList<CreaCasosAtribRequest>();
		final List<CreaCasosArchiRequest> archivos = new ArrayList<CreaCasosArchiRequest>();
		final List<CreaCasoArchVista> inputInfoArchivos = new ArrayList<CreaCasoArchVista>();
		CreaCasoArchVista inputInfoArchivo_tmp = null;
		CreaCasosArchiRequest archivoCarga = null;
		CreaCasosArchiInfoRequest archivosInfo = null;
		CreaCasosAtribRequest atributo = null;
		String processType = "";
		String categoriza = "";
		String descripcion = "";
		String canal = "";
		String bp = "";
		String mensaje = "";


		llenarElementosTramites(elementos);
		tramitesSeleccionInfo.setNivelSeleccion(tramitesCreacionCasoInfo.getNivelSeleccion());
		tramitesSeleccionInfo.setValorN0(tramitesCreacionCasoInfo.getValorN0());
		tramitesSeleccionInfo.setValorN1(tramitesCreacionCasoInfo.getValorN1());
		tramitesSeleccionInfo.setValorN2(tramitesCreacionCasoInfo.getValorN2());
		tramitesSeleccionInfo.setValorN3(tramitesCreacionCasoInfo.getValorN3());

		if (tramitesCreacionCasoInfo.getDesA0() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA0().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA0());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA0());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri0());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser0());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe0());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd0());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA1() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA1().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA1());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA1());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri1());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser1());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe1());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd1());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA2() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA2().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA2());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA2());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri2());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser2());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe2());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd2());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA3() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA3().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA3());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA3());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri3());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser3());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe3());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd3());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA4() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA4().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA4());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA4());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri4());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser4());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe4());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd4());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA5() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA5().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA5());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA5());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri5());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser5());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe5());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd5());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA6() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA6().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA6());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA6());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri6());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser6());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe6());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd6());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA7() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA7().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA7());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA7());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri7());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser7());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe7());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd7());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA8() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA8().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA8());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA8());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri8());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser8());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe8());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd8());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}
		if (tramitesCreacionCasoInfo.getDesA9() != null)
		{
			if (!tramitesCreacionCasoInfo.getDesA9().equals(""))
			{
				inputInfoArchivo_tmp = new CreaCasoArchVista();
				inputInfoArchivo_tmp.setDescArchivo(tramitesCreacionCasoInfo.getDesA9());
				inputInfoArchivo_tmp.setContenidoArchivo(tramitesCreacionCasoInfo.getConA9());
				inputInfoArchivo_tmp.setSerie_id(tramitesCreacionCasoInfo.getSeri9());
				inputInfoArchivo_tmp.setSserie_id(tramitesCreacionCasoInfo.getSser9());
				inputInfoArchivo_tmp.setDepend_id(tramitesCreacionCasoInfo.getDepe9());
				inputInfoArchivo_tmp.setTipoDoc_id(tramitesCreacionCasoInfo.getTipd9());
				inputInfoArchivos.add(inputInfoArchivo_tmp);
			}
		}

		busquedaSubKey = obtenerKeyCrearTramite(tramitesSeleccionInfo);

		for (final TramiteOpcion elemento : elementos)
		{
			if (elemento.getKey().equals(busquedaSubKey))
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
				descripcion = elementoSeleccionado.getTramiteOpcion().getLabel();
				bp = customerModel.getNumBP();
				canal = "03";
				mensaje = tramitesCreacionCasoInfo.getMensaje();


				atributo = new CreaCasosAtribRequest("String 1", "PROCESS_TYPE", processType);
				atributos.add(atributo);
				atributo = new CreaCasosAtribRequest("String 1", "DESCRIPCION", descripcion);
				atributos.add(atributo);
				atributo = new CreaCasosAtribRequest("String 1", "ID_DESCRIPCION", categoriza);
				atributos.add(atributo);
				atributo = new CreaCasosAtribRequest("String 1", "CONTRIBUYENTE", bp);
				atributos.add(atributo);
				atributo = new CreaCasosAtribRequest("String 1", "CANAL", canal);
				atributos.add(atributo);
				atributo = new CreaCasosAtribRequest("String 1", "COMENTARIO", mensaje);
				atributos.add(atributo);

				//								if (tramitesCreacionCasoInfo.getInfoArchivos() != null)
				if (inputInfoArchivos.size() > 0)
				{
					//					final CreaCasoArchVista elemento = tramitesCreacionCasoInfo.getInfoArchivos();
					//					for (final CreaCasoArchVista elemento : tramitesCreacionCasoInfo.getInfoArchivos())
					for (final CreaCasoArchVista elemento : inputInfoArchivos)
					{
						archivoCarga = new CreaCasosArchiRequest();
						archivoCarga.setZZWCC_DEPEND_ID(elemento.getDepend_id());
						archivoCarga.setZZWCC_SERIE_ID(elemento.getSerie_id());
						archivoCarga.setZZWCC_SSERIE_ID(elemento.getSserie_id());
						archivoCarga.setZZWCC_TIPODOC_ID(elemento.getTipoDoc_id());
						archivoCarga.setZZWCC_DESC_TIPODOC(elemento.getDescArchivo());
						archivoCarga.setZZWCC_ARCIVO(elemento.getContenidoArchivo());
						archivos.add(archivoCarga);
					}
					archivosInfo = new CreaCasosArchiInfoRequest();
					archivosInfo.setLinea("String 1");
					archivosInfo.setIdentificador("PROCESS_TYPE");
					archivosInfo.setValor(elementoSeleccionado.getProcessID());
					archivosInfo.setArchivos(archivos);
				}

				creaCasosRequest.setAtributos(atributos);
				creaCasosRequest.setArchivosInfo(archivosInfo);

				System.out.println("Request para crm/creaCasos: " + creaCasosRequest);
				creaCasosResponse = gasolinaService.creacionCaso(creaCasosRequest, sdhDetalleGasolinaWS, LOG);
				System.out.println("Response de crm/creaCasos: " + creaCasosResponse);
				if (gasolinaService.ocurrioErrorCreacionCaso(creaCasosResponse) != true)
				{
				}
				else
				{
				}
			}
		}


		return creaCasosResponse;
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
		//		agregarElementoTramites(elementos, "010101__", "01", "Creación de RIT");
		agregarElementoTramites(elementos, "010101__", "01", "Registro / Rol Tributario");
		agregarElementoTramites(elementos, "010102__", "02", "Creación de Calidad Sujeción Pasiva");
		//RIT-Creación-Registro / Rol Tributario
		agregarElementoTramites(elementos, "01010100", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01010101", "01", "Persona Natural", "ZT02", "A1ZTRT0004Z065");
		agregarElementoTramites(elementos, "01010102", "02", "Persona Jurídica", "ZT02", "A1ZTRT0004Z065");
		//RIT-Creación-Creación de Calidad Sujeción Pasiva
		agregarElementoTramites(elementos, "01010200", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01010201", "01", "Predial unificado/ Propietario", "ZT04", "A1ZTRT0004Z067");
		agregarElementoTramites(elementos, "01010202", "02", "Predial unificado/ Usufructuario", "ZT04", "A1ZTRT0004Z068");
		agregarElementoTramites(elementos, "01010203", "03", "Predial unificado/ Beneficio/Fideicomitente", "ZT04",
				"A1ZTRT0004Z069");
		agregarElementoTramites(elementos, "01010204", "04", "Predial unificado/ Arrendatario", "ZT04", "A1ZTRT0004Z070");
		agregarElementoTramites(elementos, "01010205", "05", "Predial unificado/ Poseedor", "ZT04", "A1ZTRT0004Z071");
		agregarElementoTramites(elementos, "01010206", "06", "Vehículos automotores / Propietario", "ZT04", "A1ZTRT0004Z072");
		agregarElementoTramites(elementos, "01010207", "07", "Vehículos automotores / Poseedor", "ZT04", "A1ZTRT0004Z073");
		agregarElementoTramites(elementos, "01010208", "08", "Vehículos / Beneficio/Fideicomitente", "ZT04", "A1ZTRT0004Z101");
		agregarElementoTramites(elementos, "01010209", "09", "Industria y comercio ICA", "ZT04", "A1ZTRT0004Z074");
		agregarElementoTramites(elementos, "01010210", "10", "Delineación urbana", "ZT04", "A1ZTRT0004Z075");
		agregarElementoTramites(elementos, "01010211", "11", "Sobretasa a la gasolina", "ZT04", "A1ZTRT0004Z076");
		agregarElementoTramites(elementos, "01010212", "12", "Publicidad exterior visual", "ZT04", "A1ZTRT0004Z077");
		//RIT-Actualización
		agregarElementoTramites(elementos, "010200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "010201__", "01", "Actualización de RIT");
		agregarElementoTramites(elementos, "010202__", "02", "Actualización de Rol tributario");
		agregarElementoTramites(elementos, "010203__", "03", "Actualización Calidad Sujeción Pasiva");
		//RIT-Actualización-Actualización de Rol tributario
		agregarElementoTramites(elementos, "01020200", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01020201", "01", "Persona Natural", "ZT02", "A1ZTRT0004Z078");
		agregarElementoTramites(elementos, "01020202", "02", "Persona Jurídica", "ZT02", "A1ZTRT0004Z079");
		//RIT-Actualización-Actualización Calidad Sujeción Pasiva
		agregarElementoTramites(elementos, "01020300", "00", "Seleccionar");
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
		agregarElementoTramites(elementos, "0200____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0201____", "01", "Exclusiones");
		agregarElementoTramites(elementos, "0202____", "02", "Excenciones");
		agregarElementoTramites(elementos, "0203____", "03", "Tratamiento Especial");
		agregarElementoTramites(elementos, "0204____", "04", "Novedades ICA");
		//Novedades de registro-Exclusiones
		agregarElementoTramites(elementos, "020100__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "020101__", "01", "Predial");
		agregarElementoTramites(elementos, "020102__", "02", "Vehículos");
		agregarElementoTramites(elementos, "020103__", "03", "Delineación Urbana");
		//Novedades de registro-Exclusiones-Predial
		agregarElementoTramites(elementos, "02010100", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02010101", "01", "Uso Publico. Ronda-Canal-Zampa", "ZT13", "A1ZTRT0004Z001");
		agregarElementoTramites(elementos, "02010102", "02", "Uso Publico. General", "ZT13", "A1ZTRT0004Z002");
		agregarElementoTramites(elementos, "02010103", "03", "Iglesias Católicas", "ZT13", "A1ZTRT0004Z003");
		agregarElementoTramites(elementos, "02010104", "04", "Iglesias No Católicas", "ZT13", "A1ZTRT0004Z092");
		agregarElementoTramites(elementos, "02010105", "05", "Juntas de acción comunal", "ZT13", "A1ZTRT0004Z004");
		agregarElementoTramites(elementos, "02010106", "06", "Policía Nacional", "ZT13", "A1ZTRT0004Z005");
		agregarElementoTramites(elementos, "02010107", "07", "Fuerzas Militares", "ZT13", "A1ZTRT0004Z006");
		agregarElementoTramites(elementos, "02010108", "08", "Parques recreativos", "ZT13", "A1ZTRT0004Z007");
		agregarElementoTramites(elementos, "02010109", "09", "Instituto de desarrollo urbano IDU", "ZT13", "A1ZTRT0004Z008");
		agregarElementoTramites(elementos, "02010110", "10", "Avalúos inferiores a 16 SMLV", "ZT13", "A1ZTRT0004Z009");
		agregarElementoTramites(elementos, "02010111", "11", "Tumbas y bóvedas funerarias", "ZT13", "A1ZTRT0004Z010");
		agregarElementoTramites(elementos, "02010112", "12", "Victimas del despojo o Desplazamiento forzado", "ZT13",
				"A1ZTRT0004Z105");
		//Novedades de registro-Exclusiones-Vehículos
		agregarElementoTramites(elementos, "02010200", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02010201", "01", "Motocicletas 125 cm3", "ZT13", "A1ZTRT0004Z011");
		agregarElementoTramites(elementos, "02010202", "02", "Maquinaria agrícola", "ZT13", "A1ZTRT0004Z012");
		agregarElementoTramites(elementos, "02010203", "03", "Vehículos oficiales", "ZT13", "A1ZTRT0004Z013");
		//Novedades de registro-Exclusiones-Delineación Urbana
		agregarElementoTramites(elementos, "02010300", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02010301", "01", "Sujetos  convención Viena", "ZT13", "A1ZTRT0004Z014");
		agregarElementoTramites(elementos, "02010302", "02", "Soc. Nac. Cruz Roja Colombiana", "ZT13", "A1ZTRT0004Z015");
		agregarElementoTramites(elementos, "02010303", "03", "Distrito Capital", "ZT13", "A1ZTRT0004Z016");
		//Novedades de registro-Excenciones
		agregarElementoTramites(elementos, "020200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "020201__", "01", "Predial");
		agregarElementoTramites(elementos, "020202__", "02", "Vehículos");
		agregarElementoTramites(elementos, "020203__", "03", "Delineación Urbana");
		agregarElementoTramites(elementos, "020204__", "04", "ICA");
		//Novedades de registro-Excenciones-Predial
		agregarElementoTramites(elementos, "02020100", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02020101", "01", "Interés Cultural", "ZT13", "A1ZTRT0004Z017");
		agregarElementoTramites(elementos, "02020102", "02", "Sindicatos", "ZT13", "A1ZTRT0004Z018");
		agregarElementoTramites(elementos, "02020103", "03", "Distrito bienes por dependencia", "ZT13", "A1ZTRT0004Z019");
		agregarElementoTramites(elementos, "02020104", "04", "Actos Terroristas", "ZT13", "A1ZTRT0004Z020");
		agregarElementoTramites(elementos, "02020105", "05", "Catástrofes Nataturales", "ZT13", "A1ZTRT0004Z094");
		agregarElementoTramites(elementos, "02020106", "06", "Secuestro/Desaparición forzada", "ZT13", "A1ZTRT0004Z021");
		agregarElementoTramites(elementos, "02020107", "07", "Banco de Suelo Distrital", "ZT13", "A1ZTRT0004Z022");
		agregarElementoTramites(elementos, "02020108", "08", "Victimas del despojo/Desplazamiento forzado", "ZT13",
				"A1ZTRT0004Z022");
		//Novedades de registro-Excenciones-Vehículos
		agregarElementoTramites(elementos, "02020200", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02020201", "01", "Actos Terroristas", "ZT13", "A1ZTRT0004Z023");
		agregarElementoTramites(elementos, "02020202", "02", "Catástrofes Nataturales", "ZT13", "A1ZTRT0004Z096");
		agregarElementoTramites(elementos, "02020203", "03", "Secuestro/Desaparición forzada", "ZT13", "A1ZTRT0004Z024");
		//Novedades de registro-Excenciones-Delineación Urbana
		agregarElementoTramites(elementos, "02020300", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02020301", "01", "Actos Terroristas", "ZT13", "A1ZTRT0004Z025");
		agregarElementoTramites(elementos, "02020302", "02", "Catástrofes Nataturales", "ZT13", "A1ZTRT0004Z098");
		agregarElementoTramites(elementos, "02020303", "03", "Obras nuevas de vivienda de interés social estratos 1,2, y 3",
				"A1ZTRT0004Z026", "");
		agregarElementoTramites(elementos, "02020304", "04",
				"Obras de autoconstrucción de vivienda, de estratos 1 y 2 que no excedan de 135 SMLV", "ZT13", "A1ZTRT0004Z027");
		agregarElementoTramites(elementos, "02020305", "05",
				"Las ampliaciones, modificaciones, adecuaciones o reparación de los inmuebles de los estratos 1, 2 y 3 de uso residencial, con avalúo catastral vigente inferior a 135",
				"ZT13", "A1ZTRT0004Z028");
		agregarElementoTramites(elementos, "02020306", "06",
				"Las obras de restauración y conservación en los bienes inmuebles de interés cultural.", "ZT13", "A1ZTRT0004Z029");
		//Novedades de registro-Excenciones-ICA
		agregarElementoTramites(elementos, "02020400", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02020401", "01", "Actos Terroristas", "ZT13", "A1ZTRT0004Z030");
		agregarElementoTramites(elementos, "02020401", "02", "Catástrofes Nataturales", "ZT13", "A1ZTRT0004Z100");
		agregarElementoTramites(elementos, "02020403", "03", "Secuestro/Desaparición forzada", "ZT13", "A1ZTRT0004Z031");
		//Novedades de registro-Tratamiento Especial
		agregarElementoTramites(elementos, "020300__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "020301__", "01", "Por Predial");
		//Novedades de registro-Tratamiento Especial-Por Predial
		agregarElementoTramites(elementos, "02030100", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02030101", "01", "Suelo Rural", "ZT13", "A1ZTRT0004Z032");
		agregarElementoTramites(elementos, "02030102", "02", "Desarrollo Urbanístico", "ZT13", "A1ZTRT0004Z033");
		agregarElementoTramites(elementos, "02030103", "03", "Áreas Protegidas", "ZT13", "A1ZTRT0004Z034");
		agregarElementoTramites(elementos, "02030104", "04",
				"Predios con actividades industriales de bajo y   medio impacto al medio ambiente", "ZT13", "A1ZTRT0004Z035");
		agregarElementoTramites(elementos, "02030105", "05", "Remoción de tierras y riesgo no mitigable", "ZT13", "A1ZTRT0004Z036");
		agregarElementoTramites(elementos, "02030106", "06", "Desastres naturales o atentado terrorista", "ZT13", "A1ZTRT0004Z037");
		agregarElementoTramites(elementos, "02030107", "07",
				"Entidades de asistencia pública, entidades con fines de interés social y de utilidad pública y fundaciones, sin animo de lucro, de derecho público o privado",
				"ZT13", "A1ZTRT0004Z038");
		agregarElementoTramites(elementos, "02030108", "08", "Extinción de dominio", "ZT13", "A1ZTRT0004Z039");
		agregarElementoTramites(elementos, "02030109", "09", "Predios con actividad financiera", "ZT13", "A1ZTRT0004Z040");
		agregarElementoTramites(elementos, "02030110", "10", "Zona Franca", "ZT13", "A1ZTRT0004Z041");
		//Novedades de registro-Novedades ICA
		agregarElementoTramites(elementos, "020400__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "020401__", "01", "Actividad Económica", "ZT13", "A1ZTRT0003Z025");
		agregarElementoTramites(elementos, "020402__", "02", "Cambio de representante legal", "ZT13", "A1ZTRT0003Z026");
		agregarElementoTramites(elementos, "020403__", "03", "Cambio de revisor Fiscal", "ZT13", "A1ZTRT0003Z027");
		agregarElementoTramites(elementos, "020404__", "04", "Cambio de Contador", "ZT13", "A1ZTRT0003Z028");
		agregarElementoTramites(elementos, "020405__", "05", "Cambio de establecimientos", "ZT13", "A1ZTRT0003Z029");

		//Facturación
		agregarElementoTramites(elementos, "0300____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0301____", "01", "Por Predial");
		agregarElementoTramites(elementos, "0302____", "02", "Por Vehículos");
		//Facturación-Por Predial
		agregarElementoTramites(elementos, "030100__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "030101__", "01", "Descarga de Factura", "ZT06", "A1ZTRT0003Z016");
		agregarElementoTramites(elementos, "030102__", "02", "Descuento adicional del 1%", "ZT06", "A1ZTRT0003Z017");
		agregarElementoTramites(elementos, "030103__", "03", "Reexpedicion de facturas", "ZT06", "A1ZTRT0003Z018");
		agregarElementoTramites(elementos, "030104__", "04", "Solicitud de moficación de Factura");
		agregarElementoTramites(elementos, "030105__", "05", "Solicitud de anulacion de facturas ");
		//Facturación-Por Predial-Solicitud de moficación de Factura
		agregarElementoTramites(elementos, "03010400", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03010401", "01", "Modificación Avaluó Catastral", "ZT07", "A1ZTRT0004Z047");
		agregarElementoTramites(elementos, "03010402", "02", "Modificación de destino hacendario", "ZT07", "A1ZTRT0004Z048");
		agregarElementoTramites(elementos, "03010403", "03", "Modificación  tarifa", "ZT07", "A1ZTRT0004Z049");
		agregarElementoTramites(elementos, "03010404", "04", "Ajuste % Participación", "ZT07", "A1ZTRT0004Z050");
		agregarElementoTramites(elementos, "03010405", "05", "Exclusiones Parciales Predial", "ZT07", "A1ZTRT0004Z051");
		agregarElementoTramites(elementos, "03010406", "06", "Exenciones Parciales Predial", "ZT07", "A1ZTRT0004Z052");
		agregarElementoTramites(elementos, "03010407", "07", "Descuentos por incremento diferencial", "ZT07", "A1ZTRT0004Z053");
		//Facturación-Por Predial-Solicitud de anulacion de facturas
		agregarElementoTramites(elementos, "03010500", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03010501", "01", "No sujeción", "ZT07", "A1ZTRT0004Z054");
		agregarElementoTramites(elementos, "03010502", "02", "Inexistencia actual del objeto", "ZT07", "A1ZTRT0004Z055");
		agregarElementoTramites(elementos, "03010503", "03", "Exencion total del  objeto", "ZT07", "A1ZTRT0004Z056");
		agregarElementoTramites(elementos, "03010504", "04", "Exclusión total del  objeto", "ZT07", "A1ZTRT0004Z057");
		//Facturación-Por Vehículos
		agregarElementoTramites(elementos, "030200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "030201__", "01", "Descarga de Factura", "ZT06", "A1ZTRT0003Z021");
		agregarElementoTramites(elementos, "030202__", "02", "Reexpedición de Factura", "ZT06", "A1ZTRT0003Z022");
		agregarElementoTramites(elementos, "030203__", "03", "Moficación de Factura");
		agregarElementoTramites(elementos, "030204__", "04", "Anulación de Factura");
		//Facturación-Por Vehículos-Moficación de Factura
		agregarElementoTramites(elementos, "03020300", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03020301", "01", "Modificación Avaluó", "ZT07", "A1ZTRT0004Z058");
		agregarElementoTramites(elementos, "03020302", "02",
				"Modificación de placa, marca, línea, modelo, capacidad(cilindraje),  uso y grupo", "ZT07", "A1ZTRT0004Z059");
		//Facturación-Por Vehículos-Anulación de Factura
		agregarElementoTramites(elementos, "03020400", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03020401", "01", "No sujeción", "ZT07", "A1ZTRT0004Z060");
		agregarElementoTramites(elementos, "03020402", "02", "Inexistencia objeto", "ZT07", "A1ZTRT0004Z061");
		agregarElementoTramites(elementos, "03020403", "03", "Exención total del  objeto", "ZT07", "A1ZTRT0004Z062");
		agregarElementoTramites(elementos, "03020404", "04", "Exclusión total  del  objeto", "ZT07", "A1ZTRT0004Z063");

		//Analisis de la cuenta
		agregarElementoTramites(elementos, "0400____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0401____", "01", "Certificación de deuda", "ZT08", "A1ZTRT0002Z009");
		agregarElementoTramites(elementos, "0402____", "02",
				"Diferencia en la imputación de pagos efectuados a través de declaraciones y/o ROP", "ZT08", "A1ZTRT0002Z010");
		agregarElementoTramites(elementos, "0403____", "03", "Ajuste por situaciones administrativas", "ZT08", "A1ZTRT0002Z011");
		agregarElementoTramites(elementos, "0404____", "04", "Revisión de datos SAP", "ZT08", "A1ZTRT0002Z012");

		//Boletín de deudores Morosos del Estado
		agregarElementoTramites(elementos, "0500____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0501____", "01", "Deuda Cancelada", "ZT09", "A1ZTRT0002Z013");
		agregarElementoTramites(elementos, "0502____", "02", "Saneamiento de información", "ZT09", "A1ZTRT0002Z014");
		agregarElementoTramites(elementos, "0503____", "03", "Existe acuerdo de pago vigente", "ZT09", "A1ZTRT0002Z015");
		agregarElementoTramites(elementos, "0504____", "04", "Otra cual", "ZT09", "A1ZTRT0002Z016");


		//Corrección de la información causada contablemente
		agregarElementoTramites(elementos, "0700____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0701____", "01", "Solicitud Interna", "ZT11", "A1ZTRT0002Z017");
		agregarElementoTramites(elementos, "0702____", "02", "Solicitud Externa", "ZT11", "A1ZTRT0002Z018");

		//Declaración
		agregarElementoTramites(elementos, "0800____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0801____", "01", "Autorización por declaración valores inferiores al sugerido", "ZT12",
				"A1ZTRT0002Z019");
		agregarElementoTramites(elementos, "0802____", "02", "Porcentaje de copropiedad", "ZT12", "A1ZTRT0002Z020");
		agregarElementoTramites(elementos, "0803____", "03", "Doble sujeción pasiva (Propietario, Poseedor)", "ZT12",
				"A1ZTRT0002Z021");
		agregarElementoTramites(elementos, "0804____", "04", "Pago Equivocado", "ZT12", "A1ZTRT0002Z022");

		//Agente Autorizado
		agregarElementoTramites(elementos, "0900____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0901____", "01", "Crear Agente Autorizado", "contribuyentes/crearagente");
		agregarElementoTramites(elementos, "0902____", "02", "Asignarse como Agente Autorizado",
				"contribuyentes/asignarsecomoagente");



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

	private void agregarElementoTramites(final List<TramiteOpcion> elementos, final String claveBusqueda,
			final String idTramiteOpcion, final String descripcionTramiteOpcion, final String urlAccion)
	{
		elementos.add(new TramiteOpcion(claveBusqueda, new ItemSelectOption(idTramiteOpcion, descripcionTramiteOpcion), urlAccion));

	}


}

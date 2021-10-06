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
import de.hybris.platform.servicelayer.i18n.I18NService;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
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
	private static final Logger LOG = Logger.getLogger(TramitesCrearPageController.class);

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

	@Resource(name = "messageSource")
	MessageSource messageSource;

	@Resource(name = "i18nService")
	I18NService i18nService;


	@RequestMapping(value = "/contibuyentes/tramites/crear", method = RequestMethod.GET)
	@RequireHardLogIn
	public String tramitescreaar(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET TRAMITES crear --------------------------");
		final Map<String,String> elementosResponse = new LinkedHashMap<String, String>();
		final List<TramiteOpcion> elementos = new ArrayList<TramiteOpcion>();
		final TramitesSeleccionInfoVista infoVista = new TramitesSeleccionInfoVista();
		String busquedaSubKeyOpciones = "";


		llenarElementosTramites(elementos);

		final String referrer = request.getServletPath();
		if (!referrer.contains("seleccionNivelRol"))
		{
			elementos.removeIf(obj -> obj.getKey() == "0101010101");
			elementos.removeIf(obj -> obj.getKey() == "0101010104");
			elementos.removeIf(obj -> obj.getKey() == "0101010201");
		}

		busquedaSubKeyOpciones = obtenerKeySelNivel(new TramitesSeleccionInfo());

		for (final TramiteOpcion elemento : elementos)
		{
			if (elemento.getKey().matches(busquedaSubKeyOpciones))
			{
				elementosResponse
						.put(elemento.getTramiteOpcion().getKey(), elemento.getTramiteOpcion().getLabel());
			}
		}
		model.addAttribute("opcionesN0", elementosResponse);

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




	@RequestMapping(value =
	{ "/contribuyentes/tramites/seleccionNivel",
			"/register/contribuyentes/tramites/seleccionNivelRol" }, method = RequestMethod.GET)
	@ResponseBody
	public TramitesSeleccionInfoVista tramitesSeleccionNivelGET(@ModelAttribute("tramitesSeleccionInfo")
	final TramitesSeleccionInfo tramitesSeleccionInfo, final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request)
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
		String notas = null;



		llenarElementosTramites(elementos);

		final String referrer = request.getServletPath();
		if (!referrer.contains("seleccionNivelRol"))
		{
			elementos.removeIf(obj -> obj.getKey() == "0101010101");
			elementos.removeIf(obj -> obj.getKey() == "0101010104");
			elementos.removeIf(obj -> obj.getKey() == "0101010201");
		}

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
				//				if (gasolinaService.ocurrioErrorDocTramites(docTramitesResponse) != true)
				//				{
				//				}
				//				else
				//				{
				//				}
			}
			if (elementoSeleccionado.getUrlAccion() != null)
			{
				urlAccion = elementoSeleccionado.getUrlAccion();
			}
			if (elementoSeleccionado.getNotas() != null)
			{
				notas = messageSource.getMessage(elementoSeleccionado.getNotas(), null, i18nService.getCurrentLocale());
			}

		}

		infoVista.setOpciones(elementosResponse);
		infoVista.setDocTramitesResponse(docTramitesResponse);
		infoVista.setUrlAccion(urlAccion);
		infoVista.setNotas(notas);


		return infoVista;
	}


	@RequestMapping(value =
	{ "/contribuyentes/tramites/creacionCaso", "/register/contribuyentes/tramites/creacionCaso" }, method = RequestMethod.POST)
	@ResponseBody
	public CreaCasosResponse creacionCasoGET(@ModelAttribute("tramitesCreacionCasoInfo")
	final TramitesCreacionCasoInfo tramitesCreacionCasoInfo, final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request)
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
		List<CreaCasosAtribRequest> atributos = null;
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
		String rolAccion = "";
		String rolIndicador = "";


		llenarElementosTramites(elementos);

		final String referrer = request.getServletPath();
		if (!referrer.contains("seleccionNivelRol"))
		{
			elementos.removeIf(obj -> obj.getKey() == "0101010101");
			elementos.removeIf(obj -> obj.getKey() == "0101010104");
			elementos.removeIf(obj -> obj.getKey() == "0101010201");
		}

		tramitesSeleccionInfo.setNivelSeleccion(tramitesCreacionCasoInfo.getNivelSeleccion());
		tramitesSeleccionInfo.setValorN0(tramitesCreacionCasoInfo.getValorN0());
		tramitesSeleccionInfo.setValorN1(tramitesCreacionCasoInfo.getValorN1());
		tramitesSeleccionInfo.setValorN2(tramitesCreacionCasoInfo.getValorN2());
		tramitesSeleccionInfo.setValorN3(tramitesCreacionCasoInfo.getValorN3());
		tramitesSeleccionInfo.setValorN4(tramitesCreacionCasoInfo.getValorN4());

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
				break;
			}
		}

		if (elementoSeleccionado != null)
		{
			if ((elementoSeleccionado.getProcessID() != null && elementoSeleccionado.getCategorizacion() != null) || elementoSeleccionado.getRolAccion()!=null)
			{
				atributos = new ArrayList<CreaCasosAtribRequest>();
				processType = elementoSeleccionado.getProcessID();
				categoriza = elementoSeleccionado.getCategorizacion();
				descripcion = elementoSeleccionado.getTramiteOpcion().getLabel();
				bp = customerModel.getNumBP();

				if (bp == null)
				{
					bp = getSessionService().getAttribute("numBP");
				}

				canal = "03";
				mensaje = tramitesCreacionCasoInfo.getMensaje();
				if (elementoSeleccionado.getRolAccion() != null)
				{
					rolAccion = elementoSeleccionado.getRolAccion().getRolAccion();
					rolIndicador = elementoSeleccionado.getRolAccion().getRolIndicador();
				}

				if (elementoSeleccionado.getProcessID() != null && elementoSeleccionado.getCategorizacion() != null)
				{
					atributo = new CreaCasosAtribRequest("String 1", "PROCESS_TYPE", processType);
					atributos.add(atributo);
					atributo = new CreaCasosAtribRequest("String 1", "DESCRIPCION", descripcion);
					atributos.add(atributo);
					atributo = new CreaCasosAtribRequest("String 1", "ID_DESCRIPCION", categoriza);
					atributos.add(atributo);
				}
				atributo = new CreaCasosAtribRequest("String 1", "CONTRIBUYENTE", bp);
				atributos.add(atributo);
				atributo = new CreaCasosAtribRequest("String 1", "CANAL", canal);
				atributos.add(atributo);
				atributo = new CreaCasosAtribRequest("String 1", "COMENTARIO", mensaje);
				atributos.add(atributo);
				if (elementoSeleccionado.getRolAccion() != null)
				{
					atributo = new CreaCasosAtribRequest("String 1", rolAccion, rolIndicador);
					atributos.add(atributo);
				}

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
					//					archivosInfo.setLinea("String 1");
					//					archivosInfo.setIdentificador("PROCESS_TYPE");
					//					archivosInfo.setValor(elementoSeleccionado.getProcessID());
					archivosInfo.setArchivos(archivos);
				}
			}



			if (atributos != null)
			{
				creaCasosRequest.setAtributos(atributos);
				creaCasosRequest.setArchivosInfo(archivosInfo);

				System.out.println("Request para crm/creaCasos: " + creaCasosRequest);
				creaCasosResponse = gasolinaService.creacionCaso(creaCasosRequest, sdhDetalleGasolinaWS, LOG);
				System.out.println("Response de crm/creaCasos: " + creaCasosResponse);
				//				if (gasolinaService.ocurrioErrorCreacionCaso(creaCasosResponse) != true)
				//				{
				//				}
				//				else
				//				{
				//				}
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
						if (infoSeleccion.getValorN4() != null && !infoSeleccion.getValorN4().isEmpty())
						{
							sb.append(infoSeleccion.getValorN4());
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
			else
			{
				sb.append("\\d\\d______");
			}
		}
		else
		{
			sb.append("\\d\\d________");
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
						if (infoSeleccion.getValorN4() != null && !infoSeleccion.getValorN4().isEmpty())
						{
							sb.append(infoSeleccion.getValorN4());
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
			else
			{
				sb.append("________");
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


		//Nivel 0
		agregarElementoTramites(elementos, "00________", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01________", "01", "RIT");
		agregarElementoTramites(elementos, "02________", "02", "Novedades de registro");
		//agregarElementoTramites(elementos, "03________", "03", "Facturación");
		//	agregarElementoTramites(elementos, "04________", "04", "Analisis de la cuenta");
		//agregarElementoTramites(elementos, "05________", "05", "Boletín de deudores Morosos"); //se modifica etiqueta, valor anterior = Boletín de deudores Morosos del Estado 14-01-2020 Maria Torres
		agregarElementoTramites(elementos, "06________", "06", "Verificación de pagos", "ZT10", "A1ZTRT0001Z006",
				"tramites.crear.categorizacion.notas.01");
		//  agregarElementoTramites(elementos, "07________", "07", "Corrección de la información causada contablemente");
		//	agregarElementoTramites(elementos, "08________", "08", "Declaración");
		agregarElementoTramites(elementos, "09________", "09", "Agente Autorizado");

		//RIT
		agregarElementoTramites(elementos, "0100______", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0101______", "01", "Creación");
		agregarElementoTramites(elementos, "0102______", "02", "Actualización");
		//RIT-Creación
		agregarElementoTramites(elementos, "010100____", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "010101__", "01", "Creación de RIT");
		agregarElementoTramites(elementos, "010101____", "01", "Registro / Rol Tributario");
		agregarElementoTramites(elementos, "010102____", "02", "Creación de Calidad Sujeción Pasiva");
		//RIT-Creación-Registro / Rol Tributario
		agregarElementoTramites(elementos, "01010100__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01010101__", "01", "Persona Natural");
		agregarElementoTramites(elementos, "01010102__", "02", "Persona Jurídica");
		//RIT-Creación-Registro / Rol Tributario - Persona Natural
		agregarElementoTramites(elementos, "0101010100", "00", "Seleccionar");
		//agregarElementoTramites(elementos, "0101010101", "01", "Contribuyente");
		agregarElementoTramites_rol(elementos, "0101010102", "02", "Agente Retenedor", "ZT02", "A1ZTRT0004Z065", "ZZAGENTE", "X");
		agregarElementoTramites_rol(elementos, "0101010103", "03", "Reportante de la Información", "ZT02", "A1ZTRT0004Z065",
				"ZZREPORTANTE", "X");
		//agregarElementoTramites(elementos, "0101010104", "04", "Terceros Autorizados");
		//RIT-Actualizacion-Registro / Rol Tributario - Persona Jurídica
		agregarElementoTramites(elementos, "0101010200", "00", "Seleccionar");
		//agregarElementoTramites(elementos, "0101010201", "01", "Contribuyente");
		agregarElementoTramites_rol(elementos, "0101010202", "02", "Agente Retenedor", "ZT02", "A1ZTRT0004Z066", "ZZAGENTE", "");
		agregarElementoTramites_rol(elementos, "0101010203", "03", "Reportante de la Información", "ZT02", "A1ZTRT0004Z066",
				"ZZREPORTANTE", "");
		//		agregarElementoTramites(elementos, "0101010204", "04", "Terceros Autorizados");
		//RIT-Creación-Creación de Calidad Sujeción Pasiva
		agregarElementoTramites(elementos, "01010200__", "00", "Seleccionar");
		//agregarElementoTramites(elementos, "01010201__", "01", "Predial unificado/ Propietario", "ZT04", "A1ZTRT0004Z067");
		//agregarElementoTramites(elementos, "01010202__", "02", "Predial unificado/ Usufructuario", "ZT04", "A1ZTRT0004Z068");
		//		agregarElementoTramites(elementos, "01010203__", "03", "Predial unificado/ Beneficio/Fideicomitente", "ZT04",
		//				"A1ZTRT0004Z069");
		//	agregarElementoTramites(elementos, "01010204__", "04", "Predial unificado/ Arrendatario", "ZT04", "A1ZTRT0004Z070");
		//	agregarElementoTramites(elementos, "01010205__", "05", "Predial unificado/ Poseedor", "ZT04", "A1ZTRT0004Z071");
		//	agregarElementoTramites(elementos, "01010206__", "06", "Vehículos automotores / Propietario", "ZT04", "A1ZTRT0004Z072");
		//	agregarElementoTramites(elementos, "01010207__", "07", "Vehículos automotores / Poseedor", "ZT04", "A1ZTRT0004Z073");
		//	agregarElementoTramites(elementos, "01010208__", "08", "Vehículos / Beneficio/Fideicomitente", "ZT04", "A1ZTRT0004Z101");
		//	agregarElementoTramites(elementos, "01010209__", "09", "Industria y comercio ICA", "ZT04", "A1ZTRT0004Z074");
		//		agregarElementoTramites(elementos, "01010210__", "10", "Delineación urbana", "ZT04", "A1ZTRT0004Z075");
		agregarElementoTramites(elementos, "01010211__", "11", "Sobretasa a la gasolina", "ZT04", "A1ZTRT0004Z076");
		agregarElementoTramites(elementos, "01010212__", "12", "Publicidad exterior visual", "ZT04", "A1ZTRT0004Z077");
		//RIT-Actualización
		agregarElementoTramites(elementos, "010200____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "010201____", "01", "Actualización de RIT", "ZT02", "A1ZTRT0003Z004");
		agregarElementoTramites(elementos, "010204____", "04", "Actualización Identificación Sujeto", "ZT02", "A1ZTRT0003Z061");
		agregarElementoTramites(elementos, "010202____", "02", "Actualización de Rol tributario");
		agregarElementoTramites(elementos, "010203____", "03", "Actualización Calidad Sujeción Pasiva");
		//RIT-Actualización-Actualización de Rol tributario
		agregarElementoTramites(elementos, "01020200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "01020201__", "01", "Persona Natural", "ZT02", "A1ZTRT0004Z078");
		agregarElementoTramites(elementos, "01020202__", "02", "Persona Jurídica", "ZT02", "A1ZTRT0004Z079");
		//RIT-Actualización-Actualización Calidad Sujeción Pasiva
		agregarElementoTramites(elementos, "01020300__", "00", "Seleccionar");
		//	agregarElementoTramites(elementos, "01020301__", "01", "Predial unificado/ Propietario", "ZT05", "A1ZTRT0004Z080");
		//	agregarElementoTramites(elementos, "01020302__", "02", "Predial unificado/ Usufructuario", "ZT05", "A1ZTRT0004Z081");
		//		agregarElementoTramites(elementos, "01020303__", "03", "Predial unificado/ Beneficio/Fideicomitente", "ZT05",
		//				"A1ZTRT0004Z082");
		//	agregarElementoTramites(elementos, "01020304__", "04", "Predial unificado/ Arrendatario", "ZT05", "A1ZTRT0004Z083");
		//	agregarElementoTramites(elementos, "01020305__", "05", "Predial unificado/ Poseedor", "ZT05", "A1ZTRT0004Z084");
		//	agregarElementoTramites(elementos, "01020306__", "06", "Vehículos automotores / Propietario", "ZT05", "A1ZTRT0004Z085");
		//	agregarElementoTramites(elementos, "01020307__", "07", "Vehículos automotores / Poseedor", "ZT05", "A1ZTRT0004Z086");
		//	agregarElementoTramites(elementos, "01020308__", "08", "Vehículos / Beneficio/Fideicomitente", "ZT05", "A1ZTRT0004Z103");
		//	agregarElementoTramites(elementos, "01020309__", "09", "Industria y comercio ICA", "ZT05", "A1ZTRT0004Z087");
		agregarElementoTramites(elementos, "01020310__", "10", "Delineación urbana", "ZT05", "A1ZTRT0004Z088");
		agregarElementoTramites(elementos, "01020311__", "11", "Sobretasa a la gasolina", "ZT05", "A1ZTRT0004Z089");
		agregarElementoTramites(elementos, "01020312__", "12", "Publicidad exterior visual", "ZT05", "A1ZTRT0004Z090");

		//Novedades de registro
		agregarElementoTramites(elementos, "0200______", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0201______", "01", "Exclusiones");
		agregarElementoTramites(elementos, "0202______", "02", "Exenciones");
		agregarElementoTramites(elementos, "0203______", "03", "No Sujeción");
		agregarElementoTramites(elementos, "0204______", "04", "Tratamiento especial de tarifas y/o cambio de destino hacendario");
		//	agregarElementoTramites(elementos, "0205______", "05", "ICA (contribuyentes no obligados a inscribirse a CCB)");
		//	agregarElementoTramites(elementos, "0206______", "06", "Novedades Predial");
		//	agregarElementoTramites(elementos, "0207______", "07", "Novedades Vehículos");
		//Novedades de registro-Exclusiones
		agregarElementoTramites(elementos, "020100____", "00", "Seleccionar");
		//	agregarElementoTramites(elementos, "020101____", "01", "Predial");
		//	agregarElementoTramites(elementos, "020102____", "02", "Vehículos");
		//		agregarElementoTramites(elementos, "020103__", "03", "Delineación Urbana");
		//Novedades de registro-Exclusiones-Predial
		agregarElementoTramites(elementos, "02010100__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02010101__", "01", "Uso Publico. Ronda-Canal-Zampa", "ZT13", "A1ZTRT0004Z001");
		agregarElementoTramites(elementos, "02010102__", "02", "Uso Publico. General", "ZT13", "A1ZTRT0004Z002");
		agregarElementoTramites(elementos, "02010103__", "03", "Iglesias Católicas", "ZT13", "A1ZTRT0004Z003");
		agregarElementoTramites(elementos, "02010104__", "04", "Iglesias No Católicas", "ZT13", "A1ZTRT0004Z092");
		agregarElementoTramites(elementos, "02010105__", "05", "Juntas de acción comunal", "ZT13", "A1ZTRT0004Z004");
		agregarElementoTramites(elementos, "02010106__", "06", "Policía Nacional", "ZT13", "A1ZTRT0004Z005");
		agregarElementoTramites(elementos, "02010107__", "07", "Fuerzas Militares", "ZT13", "A1ZTRT0004Z006");
		//		agregarElementoTramites(elementos, "02010108", "08", "Parques recreativos", "ZT13", "A1ZTRT0004Z007");
		agregarElementoTramites(elementos, "02010109__", "09", "Entidades del DISTRITO ( IDU , CVP, SDMA, IDIGER, etc.)", "ZT13",
				"A1ZTRT0004Z008");
		agregarElementoTramites(elementos, "02010110__", "10", "Avalúos inferiores a 16 SMLV", "ZT13", "A1ZTRT0004Z009");
		agregarElementoTramites(elementos, "02010111__", "11", "Tumbas y bóvedas funerarias", "ZT13", "A1ZTRT0004Z010");
		//		agregarElementoTramites(elementos, "02010112__", "12", "Victimas del despojo o Desplazamiento forzado", "ZT13",
		//				"A1ZTRT0004Z105");
		agregarElementoTramites(elementos, "02010113__", "13", " Defensa Civil Colombiana", "ZT13", "A1ZTRT0004Z133");
		agregarElementoTramites(elementos, "02010114__", "14", " Rama Judicial - Consejo Superior de la Adjudicatura", "ZT13",
				"A1ZTRT0004Z134");
		//Novedades de registro-Exclusiones-Vehículos
		agregarElementoTramites(elementos, "02010200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02010201__", "01", "Motocicletas 125 cm3", "ZT13", "A1ZTRT0004Z011");
		agregarElementoTramites(elementos, "02010202__", "02", "Maquinaria agrícola", "ZT13", "A1ZTRT0004Z012");
		agregarElementoTramites(elementos, "02010203__", "03", "Vehículos oficiales", "ZT13", "A1ZTRT0004Z013");
		//Novedades de registro-Exclusiones-Delineación Urbana
		//		agregarElementoTramites(elementos, "02010300", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "02010301", "01", "Sujetos  convención Viena", "ZT13", "A1ZTRT0004Z014");
		//		agregarElementoTramites(elementos, "02010302", "02", "Soc. Nac. Cruz Roja Colombiana", "ZT13", "A1ZTRT0004Z015");
		//		agregarElementoTramites(elementos, "02010303", "03", "Distrito Capital", "ZT13", "A1ZTRT0004Z016");
		//Novedades de registro-Excenciones
		//		agregarElementoTramites(elementos, "020200____", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "020201____", "01", "Predial");
		//		agregarElementoTramites(elementos, "020202____", "02", "Vehículos");
		//		agregarElementoTramites(elementos, "020203____", "03", "Delineación Urbana");
		//		agregarElementoTramites(elementos, "020204____", "04", "ICA");
		//Novedades de registro-Excenciones-Predial
		agregarElementoTramites(elementos, "02020100__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02020101__", "01", "Bienes de Interés Cultural", "ZT13", "A1ZTRT0004Z017");
		//		agregarElementoTramites(elementos, "02020102", "02", "Sindicatos", "ZT13", "A1ZTRT0004Z018");
		//		agregarElementoTramites(elementos, "02020103", "03", "Distrito bienes por dependencia", "ZT13", "A1ZTRT0004Z019");
		agregarElementoTramites(elementos, "02020104__", "04", "Actos Terroristas", "ZT13", "A1ZTRT0004Z020");
		agregarElementoTramites(elementos, "02020105__", "05", "Catástrofes Nataturales", "ZT13", "A1ZTRT0004Z094");
		agregarElementoTramites(elementos, "02020106__", "06", "Secuestro/Desaparición forzada", "ZT13", "A1ZTRT0004Z021");
		agregarElementoTramites(elementos, "02020107__", "07", "Banco de Suelo Distrital", "ZT13", "A1ZTRT0004Z022");
		agregarElementoTramites(elementos, "02020108__", "08", "Victimas del despojo/Desplazamiento forzado", "ZT13",
				"A1ZTRT0004Z107");
		agregarElementoTramites(elementos, "02020109__", "09", "Predios Metro Bogotá", "ZT13", "A1ZTRT0004Z018");
		agregarElementoTramites(elementos, "02020110__", "10", "Museos", "ZT13", "A1ZTRT0004Z019");
		//Novedades de registro-Excenciones-Vehículos
		agregarElementoTramites(elementos, "02020200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02020201__", "01", "Actos Terroristas", "ZT13", "A1ZTRT0004Z023");
		agregarElementoTramites(elementos, "02020202__", "02", "Catástrofes Nataturales", "ZT13", "A1ZTRT0004Z096");
		agregarElementoTramites(elementos, "02020203__", "03", "Secuestro/Desaparición forzada", "ZT13", "A1ZTRT0004Z024");
		//Novedades de registro-Excenciones-Delineación Urbana
		agregarElementoTramites(elementos, "02020300__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02020301__", "01", "Actos Terroristas", "ZT13", "A1ZTRT0004Z025");
		agregarElementoTramites(elementos, "02020302__", "02", "Catástrofes Nataturales", "ZT13", "A1ZTRT0004Z098");
		agregarElementoTramites(elementos, "02020303__", "03", "Obras nuevas de vivienda de interés social estratos 1,2, y 3",
				"A1ZTRT0004Z026", "");
		agregarElementoTramites(elementos, "02020304__", "04",
				"Obras de autoconstrucción de vivienda, de estratos 1 y 2 que no excedan de 135 SMLV", "ZT13", "A1ZTRT0004Z027");
		agregarElementoTramites(elementos, "02020305__", "05",
				"Las ampliaciones, modificaciones, adecuaciones o reparación de los inmuebles de los estratos 1, 2 y 3 de uso residencial, con avalúo catastral vigente inferior a 135",
				"ZT13", "A1ZTRT0004Z028");
		agregarElementoTramites(elementos, "02020306__", "06",
				"Las obras de restauración y conservación en los bienes inmuebles de interés cultural.", "ZT13", "A1ZTRT0004Z029");
		//Novedades de registro-Excenciones-ICA
		agregarElementoTramites(elementos, "02020400__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02020401__", "01", "Actos Terroristas", "ZT13", "A1ZTRT0004Z030");
		agregarElementoTramites(elementos, "02020401__", "02", "Catástrofes Nataturales", "ZT13", "A1ZTRT0004Z100");
		agregarElementoTramites(elementos, "02020403__", "03", "Secuestro/Desaparición forzada", "ZT13", "A1ZTRT0004Z031");
		//Novedades de registro-No Sujeción
		//agregarElementoTramites(elementos, "020300____", "00", "Seleccionar");
		//agregarElementoTramites(elementos, "020301____", "01", "Predial", "ZT13", "A1ZTRT0003Z030");
		//agregarElementoTramites(elementos, "020302____", "02", "Vehículos", "ZT13", "A1ZTRT0003Z031");
		//agregarElementoTramites(elementos, "020303____", "03", "Delineación", "ZT13", "A1ZTRT0003Z032");
		//Novedades de registro-No Sujeción-Predial
		agregarElementoTramites(elementos, "02030100__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02030101__", "01", "Cruz Roja Colombiana", "ZT13", "A1ZTRT0004Z108");
		agregarElementoTramites(elementos, "02030102__", "02", "Juzgados", "ZT13", "A1ZTRT0004Z109");
		agregarElementoTramites(elementos, "02030103__", "03", "Misiones Diplomáticas", "ZT13", "A1ZTRT0004Z110");
		agregarElementoTramites(elementos, "02030104__", "04",
				"Organismos internacionales adscritos y/o entidades que hayan firmado tratados internacionales con Colombia", "ZT13",
				"A1ZTRT0004Z111");
		//Novedades de registro-No Sujeción-Vehículos
		agregarElementoTramites(elementos, "02030200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02030201__", "01", "Cruz Roja Colombiana", "ZT13", "A1ZTRT0004Z112");
		agregarElementoTramites(elementos, "02030202__", "02", "Misiones Diplomáticas", "ZT13", "A1ZTRT0004Z113");
		agregarElementoTramites(elementos, "02030203__", "03",
				"Organismos internacionales adscritos y/o entidades que hayan firmado tratados internacionales con Colombia", "ZT13",
				"A1ZTRT0004Z114");
		//Novedades de registro-No Sujeción-Delineación ---Se cambia clave de 02030200 a 02030300 para corregir incidente del día 14-01-2020 Maria Torres
		agregarElementoTramites(elementos, "02030300__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02030301__", "01", "Cruz Roja Colombiana", "ZT13", "A1ZTRT0004Z115");
		agregarElementoTramites(elementos, "02030302__", "02", "Misiones Diplomáticas", "ZT13", "A1ZTRT0004Z116");
		agregarElementoTramites(elementos, "02030303__", "03",
				"Organismos internacionales adscritos y/o entidades que hayan firmado tratados internacionales con Colombia", "ZT13",
				"A1ZTRT0004Z117");
		//Novedades de registro-Tratamiento especial de tarifas y/o cambio de destino hacendario
		//agregarElementoTramites(elementos, "020400____", "00", "Seleccionar");
		//agregarElementoTramites(elementos, "020401____", "01", "Predial");
		//Novedades de registro-Tratamiento especial de tarifas y/o cambio de destino hacendario-Predial
		agregarElementoTramites(elementos, "02040100__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "02040101__", "01", "Predios en pequeñas propiedad rural (UAF)", "ZT13",
				"A1ZTRT0004Z032");
		agregarElementoTramites(elementos, "02040102__", "02", "Desarrollo Urbanístico", "ZT13", "A1ZTRT0004Z033");
		agregarElementoTramites(elementos, "02040103__", "03", "Áreas Protegidas", "ZT13", "A1ZTRT0004Z034");
		agregarElementoTramites(elementos, "02040104__", "04",
				"Predios con actividades industriales de bajo y   medio impacto al medio ambiente", "ZT13", "A1ZTRT0004Z035");
		agregarElementoTramites(elementos, "02040105__", "05", "Remoción de tierras y riesgo no mitigable", "ZT13",
				"A1ZTRT0004Z036");
		//		agregarElementoTramites(elementos, "02040106", "06", "Desastres naturales o atentado terrorista", "ZT13", "A1ZTRT0004Z037");
		agregarElementoTramites(elementos, "02040107__", "07",
				"Entidades de asistencia pública, entidades con fines de interés social y de utilidad pública y fundaciones, sin animo de lucro, de derecho público o privado",
				"ZT13", "A1ZTRT0004Z038");
		agregarElementoTramites(elementos, "02040108__", "08", "Extinción de dominio", "ZT13", "A1ZTRT0004Z039");
		agregarElementoTramites(elementos, "02040109__", "09", "Predios con actividad financiera", "ZT13", "A1ZTRT0004Z040");
		agregarElementoTramites(elementos, "02040110__", "10", "Zona Franca", "ZT13", "A1ZTRT0004Z041");
		//Novedades de registro-ICA (contribuyentes no obligados a inscribirse a CCB)
		//		agregarElementoTramites(elementos, "020500____", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "020501____", "01", "Actividad Económica", "ZT13", "A1ZTRT0003Z025");
		//		agregarElementoTramites(elementos, "020502____", "02", "Cambio de representante legal", "ZT13", "A1ZTRT0003Z026");
		//		agregarElementoTramites(elementos, "020503____", "03", "Cambio de revisor Fiscal", "ZT13", "A1ZTRT0003Z027");
		//		agregarElementoTramites(elementos, "020504____", "04", "Cambio de Contador", "ZT13", "A1ZTRT0003Z028");
		//		agregarElementoTramites(elementos, "020505____", "05", "Cambio de establecimientos", "ZT13", "A1ZTRT0003Z029");
		//Novedades de registro-Novedades Predial
		//		agregarElementoTramites(elementos, "020600____", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "020601____", "01", "Matricula Inmobiliaria", "ZT13", "A1ZTRT0003Z033");
		//		agregarElementoTramites(elementos, "020602____", "02", "Estrato", "ZT13", "A1ZTRT0003Z034");
		//		agregarElementoTramites(elementos, "020603____", "03", "Estado del Predio", "ZT13", "A1ZTRT0003Z035");
		//		agregarElementoTramites(elementos, "020604____", "04", "Uso del Suelo", "ZT13", "A1ZTRT0003Z036");
		//		agregarElementoTramites(elementos, "020605____", "05", "Destino Catastral", "ZT13", "A1ZTRT0003Z037");
		//		agregarElementoTramites(elementos, "020606____", "06", "Usos Catastrales", "ZT13", "A1ZTRT0003Z038");
		//		agregarElementoTramites(elementos, "020607____", "07", "Área de Usos", "ZT13", "A1ZTRT0003Z039");
		//		agregarElementoTramites(elementos, "020608____", "08", "Área Terreno", "ZT13", "A1ZTRT0003Z040");
		//		agregarElementoTramites(elementos, "020609____", "09", "Área construcción", "ZT13", "A1ZTRT0003Z041");
		//		agregarElementoTramites(elementos, "020610____", "10", "Avaluó Actual", "ZT13", "A1ZTRT0003Z042");
		//		agregarElementoTramites(elementos, "020611____", "11", "Canon de Arrendamiento", "ZT13", "A1ZTRT0003Z043");
		//		agregarElementoTramites(elementos, "020612____", "12", "Numero de Pisos", "ZT13", "A1ZTRT0003Z044");
		//		agregarElementoTramites(elementos, "020613____", "13", "Tipo de Propiedad", "ZT13", "A1ZTRT0003Z045");
		//		agregarElementoTramites(elementos, "020614____", "14", "Fecha de Inscripción", "ZT13", "A1ZTRT0003Z046");
		//		agregarElementoTramites(elementos, "020615____", "15", "Fecha del Borre", "ZT13", "A1ZTRT0003Z047");
		//		agregarElementoTramites(elementos, "020616____", "16", "Restricciones - Marcas", "ZT13", "A1ZTRT0003Z048");
		//Novedades de registro-Novedades Vehículos
		//		agregarElementoTramites(elementos, "020700____", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "020701____", "01", "Estado del Vehículo", "ZT13", "A1ZTRT0003Z049");
		//		agregarElementoTramites(elementos, "020702____", "02", "Clase", "ZT13", "A1ZTRT0003Z050");
		//		agregarElementoTramites(elementos, "020703____", "03", "Marca", "ZT13", "A1ZTRT0003Z051");
		//		agregarElementoTramites(elementos, "020704____", "04", "Línea", "ZT13", "A1ZTRT0003Z052");
		//		agregarElementoTramites(elementos, "020705____", "05", "Capacidad cilindraje, toneladas, pasajeros, wats", "ZT13",
		//				"A1ZTRT0003Z053");
		//		agregarElementoTramites(elementos, "020706____", "06", "Modelo", "ZT13", "A1ZTRT0003Z054");
		//		agregarElementoTramites(elementos, "020707____", "07", "Carrocería", "ZT13", "A1ZTRT0003Z055");
		//		agregarElementoTramites(elementos, "020708____", "08", "Blindado", "ZT13", "A1ZTRT0003Z056");
		//		agregarElementoTramites(elementos, "020709____", "09", "Antiguo o Clásico", "ZT13", "A1ZTRT0003Z057");
		//		agregarElementoTramites(elementos, "020710____", "10", "Fecha de Matricula", "ZT13", "A1ZTRT0003Z058");
		//		agregarElementoTramites(elementos, "020711____", "11", "Fecha de Cancelación", "ZT13", "A1ZTRT0003Z059");
		//		agregarElementoTramites(elementos, "020712____", "12", "Uso", "ZT13", "A1ZTRT0003Z060");
		//Facturación
		//	agregarElementoTramites(elementos, "0300______", "00", "Seleccionar");
		//	agregarElementoTramites(elementos, "0301______", "01", "Por Predial");
		//	agregarElementoTramites(elementos, "0302______", "02", "Por Vehículos");
		//Facturación-Por Predial
		//		agregarElementoTramites(elementos, "030100____", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "030101____", "01", "Descarga de Factura", "ZT06", "A1ZTRT0003Z016");
		//		agregarElementoTramites(elementos, "030102____", "02", "Descuento adicional del 1%", "ZT06", "A1ZTRT0003Z017");
		//		agregarElementoTramites(elementos, "030103____", "03", "Reexpedicion de facturas", "ZT06", "A1ZTRT0003Z018");
		//		agregarElementoTramites(elementos, "030104____", "04", "Solicitud de moficación de Factura");
		//		agregarElementoTramites(elementos, "030105____", "05", "Solicitud de anulacion de facturas ");
		//Facturación-Por Predial-Reexpedicion de facturas
		//		agregarElementoTramites(elementos, "03010300__", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "03010301__", "01", "Cambio de Nombre", "ZT06", "A1ZTRT0004Z118");
		//		agregarElementoTramites(elementos, "03010302__", "02", "Tipo de Documento", "ZT06", "A1ZTRT0004Z119");
		//		agregarElementoTramites(elementos, "03010303__", "03", "Número de Documento", "ZT06", "A1ZTRT0004Z120");
		//		agregarElementoTramites(elementos, "03010304__", "04", "Dirección de Notificación", "ZT06", "A1ZTRT0004Z121");
		//		agregarElementoTramites(elementos, "03010305__", "05", "Teléfono fijo, Celular, Correo electrónico", "ZT06",
		//				"A1ZTRT0004Z122");
		//Facturación-Por Predial-Solicitud de moficación de Factura
		agregarElementoTramites(elementos, "03010400__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03010401__", "01", "Modificación Avaluó Catastral", "ZT07", "A1ZTRT0004Z047");
		agregarElementoTramites(elementos, "03010402__", "02", "Modificación de destino hacendario", "ZT07", "A1ZTRT0004Z048");
		agregarElementoTramites(elementos, "03010403__", "03", "Modificación  tarifa", "ZT07", "A1ZTRT0004Z049");
		agregarElementoTramites(elementos, "03010404__", "04", "Ajuste % Participación", "ZT07", "A1ZTRT0004Z050");
		agregarElementoTramites(elementos, "03010405__", "05", "Exclusiones Parciales Predial", "ZT07", "A1ZTRT0004Z051");
		//		agregarElementoTramites(elementos, "03010406", "06", "Exenciones Parciales Predial", "ZT07", "A1ZTRT0004Z052");
		//		agregarElementoTramites(elementos, "03010407", "07", "Descuentos por incremento diferencial", "ZT07", "A1ZTRT0004Z053");
		//Facturación-Por Predial-Solicitud de anulacion de facturas
		agregarElementoTramites(elementos, "03010500__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03010501__", "01", "No sujeción", "ZT07", "A1ZTRT0004Z054");
		agregarElementoTramites(elementos, "03010502__", "02", "Inexistencia actual del objeto", "ZT07", "A1ZTRT0004Z055");
		agregarElementoTramites(elementos, "03010503__", "03", "Exencion total del  objeto", "ZT07", "A1ZTRT0004Z056");
		agregarElementoTramites(elementos, "03010504__", "04", "Exclusión total del  objeto", "ZT07", "A1ZTRT0004Z057");
		//Facturación-Por Vehículos
		agregarElementoTramites(elementos, "030200____", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "030201____", "01", "Descarga de Factura", "ZT06", "A1ZTRT0003Z021");
		agregarElementoTramites(elementos, "030202____", "02", "Reexpedición de Factura", "ZT06", "A1ZTRT0003Z022");
		agregarElementoTramites(elementos, "030203____", "03", "Moficación de Factura");
		agregarElementoTramites(elementos, "030204____", "04", "Anulación de Factura");
		//Facturación-Por Vehículos-Reexpedición de Factura
		agregarElementoTramites(elementos, "03020200__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03020201__", "01", "Cambio de Nombre", "ZT07", "A1ZTRT0004Z123");
		agregarElementoTramites(elementos, "03020202__", "02", "Tipo de Documento", "ZT07", "A1ZTRT0004Z124");
		agregarElementoTramites(elementos, "03020203__", "03", "Número de Documento", "ZT07", "A1ZTRT0004Z125");
		agregarElementoTramites(elementos, "03020204__", "04", "Dirección de Notificación", "ZT07", "A1ZTRT0004Z126");
		agregarElementoTramites(elementos, "03020204__", "04", "Teléfono fijo, Celular, Correo electrónico", "ZT07",
				"A1ZTRT0004Z127");
		//Facturación-Por Vehículos-Moficación de Factura
		agregarElementoTramites(elementos, "03020300__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03020301__", "01", "Modificación Avaluó", "ZT07", "A1ZTRT0004Z058");
		agregarElementoTramites(elementos, "03020302__", "02", "Marca", "ZT07", "A1ZTRT0004Z059");
		agregarElementoTramites(elementos, "03020303__", "03", "Línea", "ZT07", "A1ZTRT0004Z128");
		agregarElementoTramites(elementos, "03020304__", "04", "Modelo", "ZT07", "A1ZTRT0004Z129");
		agregarElementoTramites(elementos, "03020305__", "05", "Capacidad (cilindraje)", "ZT07", "A1ZTRT0004Z130");
		agregarElementoTramites(elementos, "03020306__", "06", "Uso", "ZT07", "A1ZTRT0004Z131");
		agregarElementoTramites(elementos, "03020307__", "07", "Grupo", "ZT07", "A1ZTRT0004Z132");
		//Facturación-Por Vehículos-Anulación de Factura
		agregarElementoTramites(elementos, "03020400__", "00", "Seleccionar");
		agregarElementoTramites(elementos, "03020401__", "01", "No sujeción", "ZT07", "A1ZTRT0004Z060");
		agregarElementoTramites(elementos, "03020402__", "02", "Inexistencia objeto", "ZT07", "A1ZTRT0004Z061");
		agregarElementoTramites(elementos, "03020403__", "03", "Exención total del  objeto", "ZT07", "A1ZTRT0004Z062");
		agregarElementoTramites(elementos, "03020404__", "04", "Exclusión total  del  objeto", "ZT07", "A1ZTRT0004Z063");

		//Analisis de la cuenta
		//		agregarElementoTramites(elementos, "0400______", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "0401______", "01", "Predial", "ZT08", "A1ZTRT0002Z009");
		//		agregarElementoTramites(elementos, "0402______", "02", "Vehículos", "ZT08", "A1ZTRT0002Z010");
		//		agregarElementoTramites(elementos, "0403______", "03", "ICA", "ZT08", "A1ZTRT0002Z011");
		//		agregarElementoTramites(elementos, "0404____", "04", "Revisión de datos SAP", "ZT08", "A1ZTRT0002Z012");
		//		agregarElementoTramites(elementos, "0404______", "04", "ReteICA", "ZT08", "A1ZTRT0002Z012");
		//		agregarElementoTramites(elementos, "0405______", "05", "Delineación Urbana", "ZT08", "A1ZTRT0002Z026");
		//		agregarElementoTramites(elementos, "0406______", "06", "Publicidad", "ZT08", "A1ZTRT0002Z027");
		//		agregarElementoTramites(elementos, "0407______", "07", "Sobretasa a la Gasolina", "ZT08", "A1ZTRT0002Z028");

		//Boletín de deudores Morosos
		//		agregarElementoTramites(elementos, "0500______", "00", "Seleccionar");
		//		agregarElementoTramites(elementos, "0501______", "01", "Deuda Cancelada", "ZT09", "A1ZTRT0002Z013");
		//		agregarElementoTramites(elementos, "0502______", "02", "Saneamiento de información", "ZT09", "A1ZTRT0002Z014");
		//		agregarElementoTramites(elementos, "0503______", "03", "Existe acuerdo de pago vigente", "ZT09", "A1ZTRT0002Z015");
		//		agregarElementoTramites(elementos, "0504______", "04", "NO Obligado", "ZT09", "A1ZTRT0002Z016");

		//Verificacion de pagos

		//Corrección de la información causada contablemente
		agregarElementoTramites(elementos, "0700______", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0701______", "01", "Predial", "ZT11", "A1ZTRT0002Z017");
		agregarElementoTramites(elementos, "0702______", "02", "Vehículos", "ZT11", "A1ZTRT0002Z018");
		agregarElementoTramites(elementos, "0703______", "03", "Delineación Urbana", "ZT11", "A1ZTRT0002Z029");
		agregarElementoTramites(elementos, "0704______", "04", "Publicidad", "ZT11", "A1ZTRT0002Z030");
		agregarElementoTramites(elementos, "0705______", "05", "ICA", "ZT11", "A1ZTRT0002Z031");
		agregarElementoTramites(elementos, "0706______", "06", "Rete Ica", "ZT11", "A1ZTRT0002Z032");
		agregarElementoTramites(elementos, "0707______", "07", "Sobre tasa", "ZT11", "A1ZTRT0002Z033");

		//Corrección de la información causada contablemente-Predial
		agregarElementoTramites(elementos, "070100____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "070101____", "01", "Tipo Identificación", "ZT11", "A1ZTRT0003Z062");
		agregarElementoTramites(elementos, "070102____", "02", "No. Identificación", "ZT11", "A1ZTRT0003Z063");
		agregarElementoTramites(elementos, "070103____", "03", "Año Gravable", "ZT11", "A1ZTRT0003Z064");
		agregarElementoTramites(elementos, "070104____", "04", "Objeto", "ZT11", "A1ZTRT0003Z065");
		agregarElementoTramites(elementos, "070105____", "05", "Errores de Magnitud", "ZT11", "A1ZTRT0003Z066");
		agregarElementoTramites(elementos, "070106____", "06", "Errores Aritméticos", "ZT11", "A1ZTRT0003Z067");

		//Corrección de la información causada contablemente-Vehículos
		agregarElementoTramites(elementos, "070200____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "070201____", "01", "Tipo Identificación", "ZT11", "A1ZTRT0003Z068");
		agregarElementoTramites(elementos, "070202____", "02", "No. Identificación", "ZT11", "A1ZTRT0003Z069");
		agregarElementoTramites(elementos, "070203____", "03", "Año Gravable", "ZT11", "A1ZTRT0003Z070");
		agregarElementoTramites(elementos, "070204____", "04", "Objeto", "ZT11", "A1ZTRT0003Z071");
		agregarElementoTramites(elementos, "070205____", "05", "Errores de Magnitud", "ZT11", "A1ZTRT0003Z072");
		agregarElementoTramites(elementos, "070206____", "06", "Errores Aritméticos", "ZT11", "A1ZTRT0003Z073");

		//Corrección de la información causada contablemente-Delineación Urbana
		agregarElementoTramites(elementos, "070300____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "070301____", "01", "Tipo Identificación", "ZT11", "A1ZTRT0003Z074");
		agregarElementoTramites(elementos, "070302____", "02", "No. Identificación", "ZT11", "A1ZTRT0003Z075");
		agregarElementoTramites(elementos, "070303____", "03", "Año Gravable", "ZT11", "A1ZTRT0003Z076");
		agregarElementoTramites(elementos, "070304____", "04", "Objeto", "ZT11", "A1ZTRT0003Z077");
		agregarElementoTramites(elementos, "070305____", "05", "Errores de Magnitud", "ZT11", "A1ZTRT0003Z078");
		agregarElementoTramites(elementos, "070306____", "06", "Errores Aritméticos", "ZT11", "A1ZTRT0003Z079");

		//Corrección de la información causada contablemente-ICA
		agregarElementoTramites(elementos, "070500____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "070501____", "01", "Tipo Identificación", "ZT11", "A1ZTRT0003Z080");
		agregarElementoTramites(elementos, "070502____", "02", "No. Identificación", "ZT11", "A1ZTRT0003Z081");
		agregarElementoTramites(elementos, "070503____", "03", "Año Gravable", "ZT11", "A1ZTRT0003Z082");
		agregarElementoTramites(elementos, "070504____", "04", "Periodo Gravable", "ZT11", "A1ZTRT0003Z083");
		agregarElementoTramites(elementos, "070505____", "05", "Objeto", "ZT11", "A1ZTRT0003Z084");
		agregarElementoTramites(elementos, "070506____", "06", "Errores de Magnitud", "ZT11", "A1ZTRT0003Z085");
		agregarElementoTramites(elementos, "070507____", "07", "Errores Aritméticos", "ZT11", "A1ZTRT0003Z086");

		//Corrección de la información causada contablemente-Rete Ica
		agregarElementoTramites(elementos, "070600____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "070601____", "01", "Tipo Identificación", "ZT11", "A1ZTRT0003Z087");
		agregarElementoTramites(elementos, "070602____", "02", "No. Identificación", "ZT11", "A1ZTRT0003Z088");
		agregarElementoTramites(elementos, "070603____", "03", "Año Gravable", "ZT11", "A1ZTRT0003Z089");
		agregarElementoTramites(elementos, "070604____", "04", "Periodo Gravable", "ZT11", "A1ZTRT0003Z090");
		agregarElementoTramites(elementos, "070605____", "05", "Objeto", "ZT11", "A1ZTRT0003Z091");
		agregarElementoTramites(elementos, "070606____", "06", "Errores de Magnitud", "ZT11", "A1ZTRT0003Z092");
		agregarElementoTramites(elementos, "070607____", "07", "Errores Aritméticos", "ZT11", "A1ZTRT0003Z093");

		//Corrección de la información causada contablemente-Sobre tasa
		agregarElementoTramites(elementos, "070700____", "00", "Seleccionar");
		agregarElementoTramites(elementos, "070701____", "01", "Tipo Identificación", "ZT11", "A1ZTRT0003Z094");
		agregarElementoTramites(elementos, "070702____", "02", "No. Identificación", "ZT11", "A1ZTRT0003Z095");
		agregarElementoTramites(elementos, "070703____", "03", "Año Gravable", "ZT11", "A1ZTRT0003Z096");
		agregarElementoTramites(elementos, "070704____", "04", "Periodo Gravable", "ZT11", "A1ZTRT0003Z097");
		agregarElementoTramites(elementos, "070705____", "05", "Objeto", "ZT11", "A1ZTRT0003Z098");
		agregarElementoTramites(elementos, "070706____", "06", "Errores de Magnitud", "ZT11", "A1ZTRT0003Z099");
		agregarElementoTramites(elementos, "070707____", "07", "Errores Aritméticos", "ZT11", "A1ZTRT0003Z100");

		//Declaración
		agregarElementoTramites(elementos, "0800______", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0801______", "01", "Declaración valores inferiores al sugerido", "ZT12",
				"A1ZTRT0002Z019");
		agregarElementoTramites(elementos, "0802______", "02", "Porcentaje de copropiedad", "ZT12", "A1ZTRT0002Z020");
		agregarElementoTramites(elementos, "0803______", "03", "Doble sujeción pasiva (Propietario, Poseedor)", "ZT12",
				"A1ZTRT0002Z021");
		agregarElementoTramites(elementos, "0804______", "04", "Pago Equivocado", "ZT12", "A1ZTRT0002Z022");
		agregarElementoTramites(elementos, "0805______", "05", "Declaracion Inicial", "ZT12", "A1ZTRT0002Z034");
		agregarElementoTramites(elementos, "0806______", "06", "Correccion", "ZT12", "A1ZTRT0002Z035");
		agregarElementoTramites(elementos, "0807______", "07", "sin pago ", "ZT12", "A1ZTRT0002Z036");
		agregarElementoTramites(elementos, "0808______", "08", "Presuntiva", "ZT12", "A1ZTRT0002Z037");

		//Agente Autorizado
		agregarElementoTramites(elementos, "0900______", "00", "Seleccionar");
		agregarElementoTramites(elementos, "0901______", "01", "Crear Agente Autorizado", "contribuyentes/crearagente");
		agregarElementoTramites(elementos, "0902______", "02", "Asignarse como Agente Autorizado",
				"contribuyentes/asignarsecomoagente");
		agregarElementoTramites(elementos, "0903______", "03", "Crear Agente Autorizado Entidad Bancaria", "ZT17",
				"A1ZTRT0002Z038");
		agregarElementoTramites(elementos, "0904______", "04", "Baja de Agente Autorizado", "ZT17", "A1ZTRT0002Z038");



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

	private void agregarElementoTramites_rol(final List<TramiteOpcion> elementos, final String claveBusqueda,
			final String idTramiteOpcion, final String descripcionTramiteOpcion, final String processID,
			final String idCategorizacion, final String rolAccion, final String rolIndicador)
	{
		elementos.add(new TramiteOpcion(claveBusqueda, new ItemSelectOption(idTramiteOpcion, descripcionTramiteOpcion), processID,
				idCategorizacion, "02", new TramiteRolAccion(rolAccion, rolIndicador)));

	}


	private void agregarElementoTramites(final List<TramiteOpcion> elementos, final String claveBusqueda,
			final String idTramiteOpcion, final String descripcionTramiteOpcion, final String processID,
			final String idCategorizacion, final String notas)
	{
		final TramiteOpcion tramiteOpcion = new TramiteOpcion(claveBusqueda,
				new ItemSelectOption(idTramiteOpcion, descripcionTramiteOpcion), processID, idCategorizacion, "02");

		tramiteOpcion.setNotas(notas);
		elementos.add(tramiteOpcion);
	}


}

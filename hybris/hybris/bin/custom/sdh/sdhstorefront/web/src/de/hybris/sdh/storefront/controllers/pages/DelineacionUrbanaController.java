/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.CalculoImpDelineacionRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.InfoObjetoDelineacion2Request;
import de.hybris.sdh.core.pojos.requests.InfoObjetoDelineacionRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.RadicaDelinRequest;
import de.hybris.sdh.core.pojos.responses.DelineacionU2_areaIntervenida;
import de.hybris.sdh.core.pojos.responses.DelineacionU2_areaProyecto;
import de.hybris.sdh.core.pojos.responses.DelineacionU2_usos;
import de.hybris.sdh.core.pojos.responses.DelineacionUAreaIntervenida;
import de.hybris.sdh.core.pojos.responses.DelineacionUAreaProyecto;
import de.hybris.sdh.core.pojos.responses.DelineacionUInfoDeclara;
import de.hybris.sdh.core.pojos.responses.DelineacionUUsos;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacion2Response;
import de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacionResponse;
import de.hybris.sdh.core.pojos.responses.RadicaDelinResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.questions.data.SDHAgentData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.DelineacionUrbanaControlCamposDec;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Maria Luisa/Federico Flores Dimas
 *
 */
@Controller
@SessionAttributes("dataForm")

public class DelineacionUrbanaController extends SDHAbstractPageController
{
	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.delineacion";
	private static final String TEXT_ACCOUNT_PROFILE_DECLARACION = "Declaración Delineación Urbana";
	private static final String TEXT_ACCOUNT_PROFILE_RETENCION = "Retencion Delineación Urbana";

	// CMS Pages
	private static final String DELINEACION_URBANA_CMS_PAGE = "delineacionUrbanaPage";
	private static final String DELINEACION_URBANA_DECLARACIONES_CMS_PAGE = "delineacionUrbanaDeclaracionesPage";
	private static final String DELINEACION_URBANA_RETENCION_CMS_PAGE = "delineacionUrbanaRadicados";
	private static final String REDIRECT_TO_DELINEACION_URBANA_RETENCION_CMS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/delineacionurbana/retencion";
	private static final String REDIRECT_TO_DELINEACION_URBANA_DECLARACION_CMS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/delineacionurbana/declaracion";
	private static final String REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE = REDIRECT_PREFIX + "/contribuyentes/delineacion-urbana";

	private static final String REDIRECT_TO_PRESENTAR_DECLARACION_CMS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/presentar-declaracion";

	private static final String REDIRECT_TO_DELINEACION_INICIAL = REDIRECT_PREFIX + "/contribuyentes/delineacion-urbana";

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhGeneraDeclaracionService")
	SDHGeneraDeclaracionService sdhGeneraDeclaracionService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sessionService")
	SessionService sessionService;
	//
	//	@Resource(name = "sdhDetallePublicidadService")
	//	SDHDetallePublicidadService sdhDetallePublicidadService;



	@RequestMapping(value = "/contribuyentes/delineacion-urbana", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbanaGET(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Delineacion urbana GET --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		SDHValidaMailRolResponse detalleContribuyente;
		String mensajeError = "";
		final InfoDelineacion infoDelineacion = new InfoDelineacion();


		contribuyenteRequest.setNumBP(customerModel.getNumBP());

		System.out.println("Request para validaCont: " + contribuyenteRequest);
		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		System.out.println("Response de validaCont: " + detalleContribuyente);
		if (gasolinaService.ocurrioErrorValcont(detalleContribuyente) != true)
		{
			gasolinaService.prepararValortipoDocDESCRIPCIONDU(detalleContribuyente);
			infoDelineacion.setValCont(detalleContribuyente);
		}
		else
		{
			mensajeError = detalleContribuyente.getTxtmsj();
			LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
		}

		model.addAttribute("dataForm", infoDelineacion);


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}



	@RequestMapping(value = "/contribuyentes/delineacion-urbana", method = RequestMethod.POST)
	@RequireHardLogIn
	public String delineacionUrbanaPOST(@ModelAttribute("dataForm")
	final InfoDelineacion infoDelineacion, @RequestParam(value = "action")
	final String action, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Delineacion urbana POST --------------------------");


		final InfoObjetoDelineacionRequest infoDelineacionRequest = new InfoObjetoDelineacionRequest();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		InfoObjetoDelineacionResponse infoDelineacionResponse = new InfoObjetoDelineacionResponse();
		final String mensajeError = "";
		String paginaDestino = "";
		String mensajeErrorDel = "";
		final InfoObjetoDelineacionExtras infObjetoDelineacionExtras = new InfoObjetoDelineacionExtras();


		infObjetoDelineacionExtras.setAnoGravable(
				gasolinaService.getAnoGravableDU(infoDelineacion.getValCont().getDelineacion(), infoDelineacion.getInput()));
		infoDelineacion.setInfObjetoDelineacionExtras(infObjetoDelineacionExtras);


		infoDelineacionRequest.setNumBP(infoDelineacion.getValCont().getInfoContrib().getNumBP());
		infoDelineacionRequest.setCdu(infoDelineacion.getInput().getSelectedCDU());
		infoDelineacionRequest.setNumRadicado(infoDelineacion.getInput().getSelectedRadicado());
		infoDelineacionRequest.setAnoGravable(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		infoDelineacionRequest.setTipoLicencia(infoDelineacion.getInput().getSelectedTipoLicencia());
		//		infoDelineacionRequest.setOpcionUso(opcionUso);//pendiente de definir que iria

		if (action.equals("retencion"))
		{
			paginaDestino = REDIRECT_TO_DELINEACION_URBANA_RETENCION_CMS_PAGE;
			infoDelineacion.getInput().setTipoFlujo("R");
			infoDelineacionRequest.setRetencion("X"); //Se indico que para retencion va una X
		}
		if (action.equals("declaracion"))
		{
			paginaDestino = REDIRECT_TO_DELINEACION_URBANA_DECLARACION_CMS_PAGE;
			infoDelineacion.getInput().setTipoFlujo("D");
			infoDelineacionRequest.setNumRadicado("");
			infoDelineacionRequest.setRetencion(""); //Se indico que para retencion va una X
		}


		System.out.println("Request para infObjeto/Delineacion: " + infoDelineacionRequest);
		infoDelineacionResponse = gasolinaService.consultaInfoDelineacion(infoDelineacionRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de infObjeto/Delineacion: " + infoDelineacionResponse);

		if (infoDelineacionResponse.getErrores() != null)
		{
			final String paginaDestinoInicial = paginaDestino;

			for (final ErrorEnWS eachError : infoDelineacionResponse.getErrores())
			{

				if (eachError.getTxtmsj() == null || eachError.getTxtmsj() == "" || eachError.getTxtmsj().isEmpty())
				{
					if (gasolinaService.ocurrioErrorInfoDelineacion(infoDelineacionResponse) != true)
					{

						gasolinaService.prepararValorUsoDU(infoDelineacionResponse);
						gasolinaService.prepararValorcausalExcepDESCRIPCIONDU(infoDelineacionResponse);
						gasolinaService.prepararValortipoDocDESCRIPCIONDU(infoDelineacion.getValCont());
						infoDelineacion.setCatalogos(gasolinaService.prepararCatalogosDelineacionU());
						infoDelineacion.setInfObjetoDelineacion(infoDelineacionResponse);
						paginaDestino = paginaDestinoInicial;
					}
				}
				else
				{
					mensajeErrorDel = eachError.getTxtmsj();
					System.out.println(eachError.getTxtmsj());
					redirectAttributes.addFlashAttribute("mensajeDelinea", mensajeErrorDel);
					paginaDestino = REDIRECT_TO_DELINEACION_INICIAL;
					break;
				}

			}



		}
		/*
		 * if (gasolinaService.ocurrioErrorInfoDelineacion(infoDelineacionResponse) != true) {
		 *
		 *
		 * gasolinaService.prepararValorUsoDU(infoDelineacionResponse);
		 * gasolinaService.prepararValorcausalExcepDESCRIPCIONDU(infoDelineacionResponse);
		 *
		 * infoDelineacion.setCatalogos(gasolinaService.prepararCatalogosDelineacionU());
		 *
		 * infoDelineacion.setInfObjetoDelineacion(infoDelineacionResponse); } else { // mensajeError =
		 * detalleContribuyente.getTxtmsj(); // LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
		 * // GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2"); }
		 */



		model.addAttribute("dataForm", infoDelineacion);

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return paginaDestino;
	}

	@RequestMapping(value = "/contribuyentes/delineacion-urbana/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String delineacionUrbanaDeclaracionPOST(@ModelAttribute("inputDelineacion")
	final InfoDelineacionInput input, @RequestParam(value = "action")
	final String action, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{



		final InfoObjetoDelineacionRequest infoDelineacionRequest = new InfoObjetoDelineacionRequest();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		InfoObjetoDelineacionResponse infoDelineacionResponse = new InfoObjetoDelineacionResponse();
		String mensajeError = "";
		String paginaDestino = "";
		String mensajeErrorDel = "";
		final InfoObjetoDelineacionExtras infObjetoDelineacionExtras = new InfoObjetoDelineacionExtras();

		final InfoDelineacion infoDelineacion = new InfoDelineacion();
		infoDelineacion.setInput(input);
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		SDHValidaMailRolResponse detalleContribuyente;
		contribuyenteRequest.setNumBP(customerModel.getNumBP());
		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		if (gasolinaService.ocurrioErrorValcont(detalleContribuyente) != true)
		{
			infoDelineacion.setValCont(detalleContribuyente);
		}
		else
		{
			mensajeError = detalleContribuyente.getTxtmsj();
			LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");

		}

		System.out.println("---------------- En Delineacion urbana POST --------------------------");
		System.out.println(infoDelineacion);
		System.out.println(infoDelineacion.getValCont());
		System.out.println(infoDelineacion.getValCont().getDelineacion());
		System.out.println(infoDelineacion);
		System.out.println(infoDelineacion.getInput());
		System.out.println(infoDelineacion.getInput().getSelectedCDU());
		System.out.println("---------------- En Delineacion urbana POST --------------------------");

		if (infoDelineacion.getInput().getSelectedAnoPresDeclaracion() != null)
		{
			infObjetoDelineacionExtras.setAnoGravable(infoDelineacion.getInput().getSelectedAnoPresDeclaracion());
		}
		else
		{
			infObjetoDelineacionExtras.setAnoGravable(Integer.toString(gasolinaService.obtenerAnoGravableActual()));
		}
		infoDelineacion.setInfObjetoDelineacionExtras(infObjetoDelineacionExtras);


		infoDelineacionRequest.setNumBP(infoDelineacion.getValCont().getInfoContrib().getNumBP());
		infoDelineacionRequest.setCdu(infoDelineacion.getInput().getSelectedCDU());
		infoDelineacionRequest.setNumRadicado(infoDelineacion.getInput().getSelectedRadicado());
		infoDelineacionRequest.setAnoGravable(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		infoDelineacionRequest.setTipoLicencia(infoDelineacion.getInput().getSelectedTipoLicencia());
		//		infoDelineacionRequest.setRetencion(retencion);//pendiente de definir que iria
		//		infoDelineacionRequest.setOpcionUso(opcionUso);//pendiente de definir que iria

		if (action.equals("retencion"))
		{
			paginaDestino = REDIRECT_TO_DELINEACION_URBANA_RETENCION_CMS_PAGE + "?declaracion=true";
			infoDelineacion.getInput().setTipoFlujo("R");
			infoDelineacionRequest.setRetencion("X"); //Se indico que para retencion va una X
		}
		if (action.equals("declaracion"))
		{
			paginaDestino = REDIRECT_TO_DELINEACION_URBANA_DECLARACION_CMS_PAGE + "?declaracion=true";
			infoDelineacion.getInput().setTipoFlujo("D");
			infoDelineacionRequest.setNumRadicado("");
			infoDelineacionRequest.setRetencion(""); //Se indico que para retencion va una X
		}

		System.out.println("Request para infObjeto/Delineacion: " + infoDelineacionRequest);
		infoDelineacionResponse = gasolinaService.consultaInfoDelineacion(infoDelineacionRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de infObjeto/Delineacion: " + infoDelineacionResponse);

		if (infoDelineacionResponse.getErrores() != null)
		{
			final String paginaDestinoInicial = paginaDestino;

			for (final ErrorEnWS eachError : infoDelineacionResponse.getErrores())
			{

				if (eachError.getTxtmsj() == null || eachError.getTxtmsj() == "" || eachError.getTxtmsj().isEmpty())
				{
					if (gasolinaService.ocurrioErrorInfoDelineacion(infoDelineacionResponse) != true)
					{

						gasolinaService.prepararValorUsoDU(infoDelineacionResponse);
						gasolinaService.prepararValorcausalExcepDESCRIPCIONDU(infoDelineacionResponse);
						gasolinaService.prepararValortipoDocDESCRIPCIONDU(infoDelineacion.getValCont());
						infoDelineacion.setCatalogos(gasolinaService.prepararCatalogosDelineacionU());
						infoDelineacion.setInfObjetoDelineacion(infoDelineacionResponse);
						paginaDestino = paginaDestinoInicial;
					}
				}
				else
				{
					mensajeErrorDel = eachError.getTxtmsj();
					System.out.println(eachError.getTxtmsj());
					redirectAttributes.addFlashAttribute("mensajeDelinea", mensajeErrorDel);
					paginaDestino = REDIRECT_TO_PRESENTAR_DECLARACION_CMS_PAGE;
					break;
				}

			}



		}
		/*
		 * if (gasolinaService.ocurrioErrorInfoDelineacion(infoDelineacionResponse) != true) {
		 * gasolinaService.prepararValorUsoDU(infoDelineacionResponse);
		 * gasolinaService.prepararValorcausalExcepDESCRIPCIONDU(infoDelineacionResponse);
		 * gasolinaService.prepararValortipoDocDESCRIPCIONDU(infoDelineacion.getValCont());
		 *
		 * infoDelineacion.setCatalogos(gasolinaService.prepararCatalogosDelineacionU());
		 * infoDelineacion.setInfObjetoDelineacion(infoDelineacionResponse); } else { // mensajeError =
		 * detalleContribuyente.getTxtmsj(); // LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
		 * // GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2"); }
		 */


		model.addAttribute("dataForm", infoDelineacion);
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return paginaDestino;
	}



	@RequestMapping(value = "/contribuyentes/delineacionurbana/detalle", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbanadetalle(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a delineacion detalle --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/detalle", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updateEmail(final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post------------------------");

		return REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbanadeclaracionGET(@ModelAttribute("dataForm")
	final InfoDelineacion infoDelineacion, final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a declaracion delineacion --------------------------");
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "/contribuyentes/delineacion-urbana");
		super.addFirmantes_impuesto(model, null, customerData);

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		//final String tipoImpuesto = new ControllerPseConstants().getDELINEACION();
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anoGravable = "";
		String periodo = "";
		String clavePeriodo = "";
		String dv = "";
		String numObjeto = "";
		String CDU = "";
		String cauex = "";
		String radicado = "";

		final String tipoImpuesto = infoDelineacion.getInput().getTipoFlujo().equals("R")
				? new ControllerPseConstants().getRETENCIONDU()
				: new ControllerPseConstants().getDELINEACION();
		final String anticipo = infoDelineacion.getInput().getTipoFlujo().equals("R") ? "X" : "";
		numBP = infoDelineacion.getValCont().getInfoContrib().getNumBP();
		numDoc = infoDelineacion.getValCont().getInfoContrib().getNumDoc();
		tipoDoc = infoDelineacion.getValCont().getInfoContrib().getTipoDoc();
		if (infoDelineacion.getInput().getSelectedAnoPresDeclaracion() == null)
		{
			infoDelineacion.getInfObjetoDelineacionExtras()
					.setAnoGravable(Integer.toString(gasolinaService.obtenerAnoGravableActual()));
		}
		else
		{
			infoDelineacion.getInfObjetoDelineacionExtras()
					.setAnoGravable(infoDelineacion.getInput().getSelectedAnoPresDeclaracion());
		}

		anoGravable = infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable();
		periodo = "01";
		clavePeriodo = gasolinaService.prepararPeriodoAnualPago(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		dv = infoDelineacion.getValCont().getInfoContrib().getAdicionales().getDIGVERIF();
		numObjeto = gasolinaService.obtenerNumeroObjetoDU(infoDelineacion);
		CDU = infoDelineacion.getInput().getSelectedCDU();

		cauex = infoDelineacion.getInfObjetoDelineacion().getInfoDeclara().getCausalExcepDESCRIPCION();
		if (cauex == null)
		{
			gasolinaService.prepararValorcausalExcepDESCRIPCIONDUR(infoDelineacion);
		}

		radicado = infoDelineacion.getInput().getSelectedRadicado();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(numBP);
		infoPreviaPSE.setNumDoc(numDoc);
		infoPreviaPSE.setTipoDoc(tipoDoc);
		infoPreviaPSE.setAnoGravable(anoGravable);
		infoPreviaPSE.setAnoGravable(anoGravable);
		infoPreviaPSE.setPeriodo(periodo);
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setNumObjeto(numObjeto);
		infoPreviaPSE.setCDU(CDU);
		infoPreviaPSE.setAnticipo(anticipo);
		infoPreviaPSE.setRadicado(radicado);



		String tipoMarca = "";

		for (int i = 0; i < infoDelineacion.getValCont().getDelineacion().size(); i++)
		{
			if (infoDelineacion.getValCont().getDelineacion().get(i).getCdu().equals(infoDelineacion.getInput().getSelectedCDU()))
			{
				tipoMarca = infoDelineacion.getValCont().getDelineacion().get(i).getTipoMarca();
			}
		}
		//Cuando se establecio el tipo de licencia desde la pantalla presentar declaracion
		if (infoDelineacion.getInput().getSelectedTipoLicencia() != null)
		{
			infoDelineacion.getInfObjetoDelineacion().getInfoDeclara()
					.setTipoLicencia(infoDelineacion.getInput().getSelectedTipoLicencia());
		}

		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("dataForm", infoDelineacion);
		model.addAttribute("tipoMarca", tipoMarca);


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String delineacionurbanadeclaracionPOST(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post------------------------");

		return REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/retencion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbanaretencionGET(@ModelAttribute("dataForm")
	final InfoDelineacion infoDelineacion, final Model model) throws CMSItemNotFoundException
	{
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);

		System.out.println("---------------- Hola entro a retencion delineacion --------------------------");
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "/contribuyentes/delineacion-urbana");
		super.addFirmantes_impuesto(model, null, customerData);


		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		//final String tipoImpuesto = new ControllerPseConstants().getDELINEACION();
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anoGravable = "";
		String periodo = "";
		String clavePeriodo = "";
		String dv = "";
		String numObjeto = "";
		String CDU = "";
		String radicado = "";

		final String tipoImpuesto = infoDelineacion.getInput().getTipoFlujo().equals("R")
				? new ControllerPseConstants().getRETENCIONDU()
				: new ControllerPseConstants().getDELINEACION();
		final String anticipo = infoDelineacion.getInput().getTipoFlujo().equals("R") ? "X" : "";

		if (infoDelineacion.getInput().getSelectedAnoPresDeclaracion() != null)
		{

			infoDelineacion.getInfObjetoDelineacionExtras()
					.setAnoGravable(infoDelineacion.getInput().getSelectedAnoPresDeclaracion());
		}
		else
		{
			infoDelineacion.getInfObjetoDelineacionExtras()
					.setAnoGravable(Integer.toString(gasolinaService.obtenerAnoGravableActual()));
		}

		numBP = infoDelineacion.getValCont().getInfoContrib().getNumBP();
		numDoc = infoDelineacion.getValCont().getInfoContrib().getNumDoc();
		tipoDoc = infoDelineacion.getValCont().getInfoContrib().getTipoDoc();

		anoGravable = infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable();
		periodo = "01";
		clavePeriodo = gasolinaService.prepararPeriodoAnualPago(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		dv = infoDelineacion.getValCont().getInfoContrib().getAdicionales().getDIGVERIF();
		numObjeto = gasolinaService.obtenerNumeroObjetoDU(infoDelineacion);
		CDU = infoDelineacion.getInput().getSelectedCDU();
		radicado = infoDelineacion.getInput().getSelectedRadicado();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(numBP);
		infoPreviaPSE.setNumDoc(numDoc);
		infoPreviaPSE.setTipoDoc(tipoDoc);
		infoPreviaPSE.setAnoGravable(anoGravable);
		infoPreviaPSE.setPeriodo(periodo);
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setNumObjeto(numObjeto);
		infoPreviaPSE.setCDU(CDU);
		infoPreviaPSE.setAnticipo(anticipo);
		infoPreviaPSE.setRadicado(radicado);

		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("dataForm", infoDelineacion);


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_RETENCION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_RETENCION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_RETENCION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/retencion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String delineacionurbanaretencionPOST(@ModelAttribute("dataForm")
	final InfoDelineacion infoDelineacion, @RequestParam(value = "action")
	final String action, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de retencion------------------------");

		final CalculoImpDelineacionRequest infoDelineacionRequest = new CalculoImpDelineacionRequest();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		InfoObjetoDelineacionResponse infoDelineacionResponse = new InfoObjetoDelineacionResponse();
		String mensajeError = "";
		String paginaDestino = "";
		String[] mensajesError;
		//		final InfoObjetoDelineacionExtras infObjetoDelineacionExtras = new InfoObjetoDelineacionExtras();

		String numeroBP = sessionService.getCurrentSession().getAttribute("representado");
		if (numeroBP == null)
		{
			numeroBP = customerModel.getNumBP();
		}
		infoDelineacion.getValCont().getInfoContrib().setNumBP(numeroBP);


		infoDelineacionRequest.setNumBP(infoDelineacion.getValCont().getInfoContrib().getNumBP());
		infoDelineacionRequest.setCdu(infoDelineacion.getInput().getSelectedCDU());
		infoDelineacionRequest.setNumRadicado(infoDelineacion.getInput().getSelectedRadicado());
		infoDelineacionRequest.setAnoGravable(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		//		infoDelineacionRequest.setRetencion(retencion); //pendiente de definir que iria
		infoDelineacionRequest.setNumForm(infoDelineacion.getInfObjetoDelineacion().getNumForm());
		infoDelineacionRequest.setInfoDeclara(infoDelineacion.getInfObjetoDelineacion().getInfoDeclara());
		infoDelineacionRequest.setUsos(infoDelineacion.getInfObjetoDelineacion().getUsos());
		infoDelineacionRequest.setAreaIntervenida(infoDelineacion.getInfObjetoDelineacion().getAreaIntervenida());
		infoDelineacionRequest.setAreaProyecto(infoDelineacion.getInfObjetoDelineacion().getAreaProyecto());



		if (infoDelineacion.getInput().getTipoFlujo().equals("R"))
		{
			paginaDestino = REDIRECT_TO_DELINEACION_URBANA_RETENCION_CMS_PAGE;
			infoDelineacionRequest.setRetencion("X"); //Se indico que para retencion va una X
		}
		if (infoDelineacion.getInput().getTipoFlujo().equals("D"))
		{
			paginaDestino = REDIRECT_TO_DELINEACION_URBANA_DECLARACION_CMS_PAGE;
			infoDelineacionRequest.setNumRadicado("");
			infoDelineacionRequest.setRetencion(""); //Se indico que para retencion va una X
		}

		System.out.println("Request para calculoImp/Delineacion: " + infoDelineacionRequest);
		try
		{
			infoDelineacionResponse = gasolinaService.calcularImpuestoDelineacion(infoDelineacionRequest, sdhDetalleGasolinaWS, LOG);
		}
		catch (final Exception e)
		{
			mensajeError = gasolinaService.prepararMensajeError(infoDelineacionResponse.getErrores());
			LOG.error("Error al leer informacion de calculo de Delineacion: " + mensajeError);
			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
		}
		System.out.println("Response de calculoImp/Delineacion: " + infoDelineacionResponse);
		if (gasolinaService.ocurrioErrorInfoDelineacion(infoDelineacionResponse) != true)
		{

			if (infoDelineacionResponse.getErrores().get(0).getIdmsj().equals("99"))
			{
				mensajesError = gasolinaService.prepararMensajesError(infoDelineacionResponse.getErrores());
				LOG.info("Alerta al leer informacion del calculo: " + mensajeError);
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.INFO_MESSAGES_HOLDER,
						"error.impuestoDelineacion.calculoImpuesto.error1.attrib1", mensajesError);
			}

			gasolinaService.prepararValorUsoDU(infoDelineacionResponse);

			//			infoDelineacion.setCatalogos(gasolinaService.prepararCatalogosDelineacionU());
			//			infoDelineacion.setInfObjetoDelineacionExtras(infObjetoDelineacionExtras);
			infoDelineacion.setInfObjetoDelineacion(infoDelineacionResponse);
		}
		else
		{
			mensajesError = gasolinaService.prepararMensajesError(infoDelineacionResponse.getErrores());
			LOG.error("Error al leer informacion del calculo: " + mensajeError);
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoDelineacion.calculoImpuesto.error1.attrib1", mensajesError);
		}


		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		final String tipoImpuesto = new ControllerPseConstants().getDELINEACION();
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anoGravable = "";
		String periodo = "";
		String clavePeriodo = "";
		String dv = "";
		String numObjeto = "";
		String CDU = "";
		String radicado = "";

		//		tipoImpuesto = infoDelineacion.getInput().getTipoFlujo().equals("R") ? new ControllerPseConstants().getRETENCIONDU() : new ControllerPseConstants().getDELINEACION();
		final String anticipo = infoDelineacion.getInput().getTipoFlujo().equals("R") ? "X" : "";
		numBP = infoDelineacion.getValCont().getInfoContrib().getNumBP();
		numDoc = infoDelineacion.getValCont().getInfoContrib().getNumDoc();
		tipoDoc = infoDelineacion.getValCont().getInfoContrib().getTipoDoc();
		anoGravable = infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable();
		periodo = "01";
		clavePeriodo = gasolinaService.prepararPeriodoAnualPago(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		dv = infoDelineacion.getValCont().getInfoContrib().getAdicionales().getDIGVERIF();
		numObjeto = gasolinaService.obtenerNumeroObjetoDU(infoDelineacion);
		CDU = infoDelineacion.getInput().getSelectedCDU();

		radicado = infoDelineacion.getInput().getSelectedRadicado();


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(numBP);
		infoPreviaPSE.setNumDoc(numDoc);
		infoPreviaPSE.setTipoDoc(tipoDoc);
		infoPreviaPSE.setAnoGravable(anoGravable);
		infoPreviaPSE.setPeriodo(periodo);
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setNumObjeto(numObjeto);
		infoPreviaPSE.setCDU(CDU);
		infoPreviaPSE.setAnticipo(anticipo);
		infoPreviaPSE.setRadicado(radicado);


		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("dataForm", infoDelineacion);
		//		model.addAttribute("infoPreviaPSE", infoPreviaPSE);




		return paginaDestino;
	}



	@RequestMapping(value = "/contribuyentes/delineacion-urbana/detalle", method = RequestMethod.GET)
	@ResponseBody
	public RadicaDelinResponse delineacionUrbanaCDUDetalleGET(@ModelAttribute("radicadoInfoRequest")
	final RadicaDelinRequest radicaDelinRequest, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		RadicaDelinResponse wsRadicaDelinResponse = new RadicaDelinResponse();
		final RadicaDelinRequest wsRadicaDelinRequest = new RadicaDelinRequest();
		final String[] mensajesError;


		wsRadicaDelinRequest.setNumBP(customerModel.getNumBP());
		wsRadicaDelinRequest.setCdu(radicaDelinRequest.getCdu());

		try
		{
			System.out.println("Request para radicaDelin: " + wsRadicaDelinRequest);
			wsRadicaDelinResponse = gasolinaService.consultaRadicaDelin(wsRadicaDelinRequest, sdhDetalleGasolinaWS, LOG);
			System.out.println("Response de radicaDelin: " + wsRadicaDelinResponse);
		}
		catch (final Exception ex)
		{
			LOG.error("Error al leer radicaDelin: ");
			GlobalMessages.addErrorMessage(model, "error.impuestoDelineacion.radicaDelin.error1");
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));


		return wsRadicaDelinResponse;
	}


	@RequestMapping(value = "/contribuyentes/delineacion-urbana/generar", method = RequestMethod.GET)
	@ResponseBody
	public GeneraDeclaracionResponse generar(@ModelAttribute("dataForm")
	final InfoDelineacion dataForm, final HttpServletResponse response, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		GeneraDeclaracionResponse generaDeclaracionResponse = new GeneraDeclaracionResponse();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String numForm = request.getParameter("numForm");

		if (StringUtils.isBlank(numForm))
		{
			numForm = dataForm.getInfObjetoDelineacion().getNumForm();
		}

		final GeneraDeclaracionRequest generaDeclaracionRequest = new GeneraDeclaracionRequest();


		generaDeclaracionRequest.setNumForm(numForm);

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			System.out.println("Request para generaDeclaracion : " + generaDeclaracionRequest);
			generaDeclaracionResponse = mapper.readValue(sdhGeneraDeclaracionService.generaDeclaracion(generaDeclaracionRequest),
					GeneraDeclaracionResponse.class);
			System.out.println("Response para generaDeclaracion : " + generaDeclaracionResponse);

			if (generaDeclaracionResponse != null && generaDeclaracionResponse.getStringPDF() != null)
			{
				final String encodedBytes = generaDeclaracionResponse.getStringPDF();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = numForm + "-" + customerModel.getNumBP() + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE.booleanValue());
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				generaDeclaracionResponse.setUrlDownload(mediaModel.getDownloadURL());


			}

		}
		catch (final Exception e)
		{
			LOG.error("error generating declaration : " + e.getMessage());

			final ErrorPubli error = new ErrorPubli();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error en el proceso de generación, por favor intentalo más tarde");

			final List<ErrorPubli> errores = new ArrayList<ErrorPubli>();

			errores.add(error);

			generaDeclaracionResponse.setErrores(errores);

		}
		return generaDeclaracionResponse;


	}


	@RequestMapping(value = "/contribuyentes/delineacionurbana/declaracion/show", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbanadeclaracionShowGET(final Model model,
			@RequestParam(required = true, value = "numForm")
			final String numForm, @RequestParam(required = true, value = "representado")
			final String representado) throws CMSItemNotFoundException
	{
		System.out
				.println("---------------- Hola entro a declaracion delineacion vista Agente Autorizado--------------------------");

		final InfoDelineacion infoDelineacion = new InfoDelineacion();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final CustomerData currentUserData = customerFacade.getCurrentCustomer();
		final CustomerData contribuyenteData = sdhCustomerFacade.getRepresentadoDataFromSAP(representado);
		final SDHValidaMailRolResponse valCont = sdhCustomerFacade.getRepresentadoFromSAP(representado);
		String paginaDestino = "";
		String breadcrumbs = "";

		model.addAttribute("customerData", currentUserData);
		model.addAttribute("currentUserData", currentUserData);
		model.addAttribute("contribuyenteData", contribuyenteData);
		model.addAttribute("redirectURL", "/autorizados/contribuyente/representando?representado=" + contribuyenteData.getNumBP());

		final InfoObjetoDelineacion2Request infoImpuesto2Request = new InfoObjetoDelineacion2Request();
		infoImpuesto2Request.setPartner(representado);
		infoImpuesto2Request.setFormulario(numForm);
		System.out.println("Request de liquidador2/calculoDelineacion: " + infoImpuesto2Request);
		final InfoObjetoDelineacion2Response infoImpuesto2Response = gasolinaService.consultaInfoDelineacionAA(infoImpuesto2Request,
				sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de liquidador2/calculoDelineacion: " + infoImpuesto2Response);


		addAgentsToModel(model, contribuyenteData, currentUserData);
		if (infoImpuesto2Response != null)
		{
			super.addFirmantes_impuesto(model, infoImpuesto2Response.getFirmantes(), currentUserData);
		}

		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();

		String tipoImpuesto = "";
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anoGravable = "";
		String periodo = "";
		String clavePeriodo = "";
		String dv = "";
		String numObjeto = "";
		String CDU = "";
		String cauex = "";
		String radicado = "";


		final String anticipo = infoImpuesto2Response.getRetencion().equals("X") ? "X" : "";
		tipoImpuesto = anticipo.equals("X")
				? new ControllerPseConstants().getRETENCIONDU()
				: new ControllerPseConstants().getDELINEACION();
		numBP = contribuyenteData.getNumBP();
		numDoc = contribuyenteData.getDocumentNumber();
		tipoDoc = contribuyenteData.getDocumentType();

		final InfoObjetoDelineacionResponse infObjetoDelineacion = new InfoObjetoDelineacionResponse();
		remapeoDesdeDelineacion2(infObjetoDelineacion, infoImpuesto2Response);
		remapeoDesdeParametros(infObjetoDelineacion, numForm);

		final InfoObjetoDelineacionExtras infObjetoDelineacionExtras = new InfoObjetoDelineacionExtras();
		if (infoImpuesto2Response.getAnoGravable() == null)
		{
			infObjetoDelineacionExtras.setAnoGravable(Integer.toString(gasolinaService.obtenerAnoGravableActual()));
		}
		else
		{
			infObjetoDelineacionExtras.setAnoGravable(infoImpuesto2Response.getAnoGravable());
		}

		final InfoDelineacionInput input = new InfoDelineacionInput();
		input.setSelectedAnoPresDeclaracion(infObjetoDelineacionExtras.getAnoGravable());
		input.setSelectedCDU(infoImpuesto2Response.getCdu());
		input.setSelectedRadicado(infoImpuesto2Response.getNumRadicado());
		input.setSelectedTipoLicencia(infoImpuesto2Response.getTipoLicencia());
		if(infoImpuesto2Response.getRetencion().equals("X")) {
			input.setTipoFlujo("R");
		}
		else {
			input.setTipoFlujo("D");
		}


		infoDelineacion.setInfObjetoDelineacionExtras(infObjetoDelineacionExtras);
		infoDelineacion.setInfObjetoDelineacion(infObjetoDelineacion);
		infoDelineacion.setInput(input);
		infoDelineacion.setCatalogos(gasolinaService.prepararCatalogosDelineacionU());
		infoDelineacion.setValCont(valCont);


		anoGravable = infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable();
		periodo = "01";
		clavePeriodo = gasolinaService.prepararPeriodoAnualPago(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		dv = contribuyenteData.getDigVer();
		numObjeto = gasolinaService.obtenerNumeroObjetoDU(infoDelineacion);
		CDU = infoImpuesto2Response.getCdu();

		cauex = infoDelineacion.getInfObjetoDelineacion().getInfoDeclara().getCausalExcepDESCRIPCION();
		if (cauex == null)
		{
			gasolinaService.prepararValorcausalExcepDESCRIPCIONDUR(infoDelineacion);
		}

		radicado = infoDelineacion.getInput().getSelectedRadicado();

		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(numBP);
		infoPreviaPSE.setNumDoc(numDoc);
		infoPreviaPSE.setTipoDoc(tipoDoc);
		infoPreviaPSE.setAnoGravable(anoGravable);
		infoPreviaPSE.setPeriodo(periodo);
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setNumObjeto(numObjeto);
		infoPreviaPSE.setCDU(CDU);
		infoPreviaPSE.setAnticipo(anticipo);
		infoPreviaPSE.setRadicado(radicado);



		final String tipoMarca = "";

		//		for (int i = 0; i < infoDelineacion.getValCont().getDelineacion().size(); i++)
		//		{
		//			if (infoDelineacion.getValCont().getDelineacion().get(i).getCdu().equals(infoDelineacion.getInput().getSelectedCDU()))
		//			{
		//				tipoMarca = infoDelineacion.getValCont().getDelineacion().get(i).getTipoMarca();
		//			}
		//		}
		//Cuando se establecio el tipo de licencia desde la pantalla presentar declaracion
		//		if (infoDelineacion.getInput().getSelectedTipoLicencia() != null)
		//		{
		//			infoDelineacion.getInfObjetoDelineacion().getInfoDeclara()
		//					.setTipoLicencia(infoDelineacion.getInput().getSelectedTipoLicencia());
		//		}
		infoDelineacion.setControlCampos(establecerCamposImpuestoDec("sdh_02", contribuyenteData, currentUserData));

		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		model.addAttribute("dataForm", infoDelineacion);
		model.addAttribute("tipoMarca", tipoMarca);


		if (infoDelineacion.getInput().getTipoFlujo().equals("R"))
		{
			paginaDestino = DELINEACION_URBANA_RETENCION_CMS_PAGE;
			breadcrumbs = TEXT_ACCOUNT_PROFILE_RETENCION;
		}
		if (infoDelineacion.getInput().getTipoFlujo().equals("D"))
		{
			paginaDestino = DELINEACION_URBANA_DECLARACIONES_CMS_PAGE;
			breadcrumbs = TEXT_ACCOUNT_PROFILE_DECLARACION;
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(paginaDestino));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(paginaDestino));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(breadcrumbs));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	/**
	 * @param infObjetoDelineacion
	 * @param numForm
	 */
	private void remapeoDesdeParametros(final InfoObjetoDelineacionResponse responseRemapeo, final String numForm)
	{
		if (responseRemapeo != null)
		{
			responseRemapeo.setNumForm(numForm);
		}

	}



	/**
	 * @param infoImpuesto2Response
	 * @return
	 */
	private void remapeoDesdeDelineacion2(final InfoObjetoDelineacionResponse responseRemapeo,
			final InfoObjetoDelineacion2Response infoImpuesto2Response)
	{

		if (responseRemapeo != null)
		{
			final DelineacionUInfoDeclara infoDeclara = new DelineacionUInfoDeclara();
			infoDeclara.setCdu(infoImpuesto2Response.getCdu());
			infoDeclara.setNumRadicado(infoImpuesto2Response.getNumRadicado());
			infoDeclara.setOpcionUso(infoImpuesto2Response.getOpcionUso());
			infoDeclara.setTipoLicencia(infoImpuesto2Response.getTipoLicencia());
			infoDeclara.setObjetoLicen(infoImpuesto2Response.getObjetoLicen());
			infoDeclara.setModalidad(infoImpuesto2Response.getModalidad());
			infoDeclara.setPresupuestoObra(infoImpuesto2Response.getPresupuestoObra());
			infoDeclara.setFechaEjecutaria(infoImpuesto2Response.getFechaEjecutaria());
			infoDeclara.setFechaFinalObra(infoImpuesto2Response.getFechaFinalObra());
			infoDeclara.setFechaUltAbono(infoImpuesto2Response.getFechaUltAbono());
			infoDeclara.setTotalPresupuesto(infoImpuesto2Response.getTotalPresupuesto());
			infoDeclara.setValorExen(infoImpuesto2Response.getValorExen());
			infoDeclara.setValorEjecutado(infoImpuesto2Response.getValorEjecutado());
			infoDeclara.setImpuestoCargo(infoImpuesto2Response.getImpuestoCargo());
			infoDeclara.setValorSancion(infoImpuesto2Response.getValorSancion());
			infoDeclara.setTotalRetencion(infoImpuesto2Response.getTotalRetencion());
			infoDeclara.setSaldoImpCargo(infoImpuesto2Response.getSaldoImpCargo());
			infoDeclara.setSaldoFavor(infoImpuesto2Response.getSaldoFavor());
			infoDeclara.setValorPagar(infoImpuesto2Response.getValorPagar());
			infoDeclara.setInteresesMora(infoImpuesto2Response.getInteresMora());
			infoDeclara.setTotalPagar(infoImpuesto2Response.getTotalPagar());
			infoDeclara.setCausalExcep(infoImpuesto2Response.getCausalExcep());
			infoDeclara.setTotalUsos(infoImpuesto2Response.getTotalUsos());
			infoDeclara.setTotalAreap(infoImpuesto2Response.getTotalAreap());
			infoDeclara.setTotalAreai(infoImpuesto2Response.getTotalAreai());


			responseRemapeo.setInfoDeclara(infoDeclara);

			if (infoImpuesto2Response.getUsos() != null && !infoImpuesto2Response.getUsos().isEmpty())
			{

				final List<DelineacionUUsos> usos = new ArrayList<DelineacionUUsos>();
				for (final DelineacionU2_usos datoOrigen : infoImpuesto2Response.getUsos())
				{
					final DelineacionUUsos datoDestino = new DelineacionUUsos();
					datoDestino.setAreaNeta(datoOrigen.getAreaNeta());
					datoDestino.setCodUso(datoOrigen.getCodUso());
					datoDestino.setNumUnidad(datoOrigen.getNumUnidad());
					datoDestino.setUso(datoOrigen.getUso());
					datoDestino.setUsoCatalogo(datoOrigen.getUsoCatalogo());

					usos.add(datoDestino);
				}


				responseRemapeo.setUsos(usos);
			}

			if (infoImpuesto2Response.getAreaIntervenida() != null && !infoImpuesto2Response.getAreaIntervenida().isEmpty())
			{

				final List<DelineacionUAreaIntervenida> areaIntervenida = new ArrayList<DelineacionUAreaIntervenida>();
				for (final DelineacionU2_areaIntervenida datoOrigen : infoImpuesto2Response.getAreaIntervenida())
				{
					final DelineacionUAreaIntervenida datoDestino = new DelineacionUAreaIntervenida();
					datoDestino.setAreaInter(datoOrigen.getAreaInter());
					datoDestino.setAream2(datoOrigen.getAream2());

					areaIntervenida.add(datoDestino);
				}

				responseRemapeo.setAreaIntervenida(areaIntervenida);
			}

			if (infoImpuesto2Response.getAreaProyecto() != null && !infoImpuesto2Response.getAreaProyecto().isEmpty())
			{

				final List<DelineacionUAreaProyecto> areaProyecto = new ArrayList<DelineacionUAreaProyecto>();

				for (final DelineacionU2_areaProyecto datoOrigen : infoImpuesto2Response.getAreaProyecto())
				{
					final DelineacionUAreaProyecto datoDestino = new DelineacionUAreaProyecto();
					datoDestino.setAreaProy(datoOrigen.getAreaProy());
					datoDestino.setAream2(datoOrigen.getAream2());

					areaProyecto.add(datoDestino);
				}

				responseRemapeo.setAreaProyecto(areaProyecto);
			}
		}

	}


	private DelineacionUrbanaControlCamposDec establecerCamposImpuestoDec(final String rol, final CustomerData contribuyenteData,
			final CustomerData currentUserData)
	{
		final DelineacionUrbanaControlCamposDec controlCampos = new DelineacionUrbanaControlCamposDec();
		final String strRepresentanteLegalPrincipal = "Repres. Legal Principal";
		final String strContador = "Contador";
		String funcionInterlocultorValida = null;

		if (contribuyenteData.getDocumentType().equals("NIT") || currentUserData != null)
		{
			controlCampos.setBtnPresentarDec(true);
			controlCampos.setBtnPagarDec(true);
		}

		switch (contribuyenteData.getDocumentType())
		{
			case "NIT":
				funcionInterlocultorValida = strRepresentanteLegalPrincipal;
				break;
			default:
				funcionInterlocultorValida = strContador;
				break;
		}

		switch (rol)
		{
			case "sdh_02":
				if (contribuyenteData.getAgentList() != null && currentUserData != null)
				{
					controlCampos.setDatosGenerales(true);
					controlCampos.setInformacionAreaUso(true);
					controlCampos.setLiquidacion(true);

					for (final SDHAgentData infoAgente : contribuyenteData.getAgentList())
					{
						if (infoAgente != null)
						{
							if (!StringUtils.isEmpty(infoAgente.getBp()) && !StringUtils.isEmpty(infoAgente.getInternalFunction())
									&& infoAgente.getInternalFunction() != null && infoAgente.getBp() != null
									&& infoAgente.getBp().equals(currentUserData.getNumBP())
									&& infoAgente.getInternalFunction().equals(funcionInterlocultorValida))
							{
								controlCampos.setBtnPresentarDec(false);
								controlCampos.setBtnPagarDec(false);
								break;
							}
						}
					}
				}

				break;

			default:
				break;
		}

		return controlCampos;
	}


}

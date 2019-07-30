/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.CalculoImpDelineacionRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.InfoObjetoDelineacionRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.RadicaDelinRequest;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacionResponse;
import de.hybris.sdh.core.pojos.responses.RadicaDelinResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;

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

public class DelineacionUrbanaController extends AbstractPageController
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

	//	@Resource(name = "customerFacade")
	//	CustomerFacade customerFacade;
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
		if (gasolinaService.ocurrioErrorInfoDelineacion(infoDelineacionResponse) != true)
		{


			gasolinaService.prepararValorUsoDU(infoDelineacionResponse);
			gasolinaService.prepararValorcausalExcepDESCRIPCIONDU(infoDelineacionResponse);

			infoDelineacion.setCatalogos(gasolinaService.prepararCatalogosDelineacionU());

			infoDelineacion.setInfObjetoDelineacion(infoDelineacionResponse);
		}
		else
		{
			//			mensajeError = detalleContribuyente.getTxtmsj();
			//			LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
			//			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
		}


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


		//		infObjetoDelineacionExtras.setAnoGravable(
		//				gasolinaService.getAnoGravableDU(infoDelineacion.getValCont().getDelineacion(), infoDelineacion.getInput()));
		infObjetoDelineacionExtras.setAnoGravable(Integer.toString(gasolinaService.obtenerAnoGravableActual()));
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
		if (gasolinaService.ocurrioErrorInfoDelineacion(infoDelineacionResponse) != true)
		{
			gasolinaService.prepararValorUsoDU(infoDelineacionResponse);
			gasolinaService.prepararValorcausalExcepDESCRIPCIONDU(infoDelineacionResponse);
			gasolinaService.prepararValortipoDocDESCRIPCIONDU(infoDelineacion.getValCont());

			infoDelineacion.setCatalogos(gasolinaService.prepararCatalogosDelineacionU());
			infoDelineacion.setInfObjetoDelineacion(infoDelineacionResponse);
		}
		else
		{
			//			mensajeError = detalleContribuyente.getTxtmsj();
			//			LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
			//			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
		}


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

		final String tipoImpuesto = infoDelineacion.getInput().getTipoFlujo().equals("R")
				? new ControllerPseConstants().getRETENCIONDU()
				: new ControllerPseConstants().getDELINEACION();
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



		String tipoMarca = "";

		for (int i = 0; i < infoDelineacion.getValCont().getDelineacion().size(); i++)
		{
			if (infoDelineacion.getValCont().getDelineacion().get(i).getCdu().equals(infoDelineacion.getInput().getSelectedCDU()))
			{
				tipoMarca = infoDelineacion.getValCont().getDelineacion().get(i).getTipoMarca();
			}
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

		final String tipoImpuesto = infoDelineacion.getInput().getTipoFlujo().equals("R")
				? new ControllerPseConstants().getRETENCIONDU()
				: new ControllerPseConstants().getDELINEACION();
		numBP = infoDelineacion.getValCont().getInfoContrib().getNumBP();
		numDoc = infoDelineacion.getValCont().getInfoContrib().getNumDoc();
		tipoDoc = infoDelineacion.getValCont().getInfoContrib().getTipoDoc();
		infoDelineacion.getInfObjetoDelineacionExtras()
				.setAnoGravable(Integer.toString(gasolinaService.obtenerAnoGravableActual()));
		anoGravable = infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable();
		periodo = "01";
		clavePeriodo = gasolinaService.prepararPeriodoAnualPago(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		dv = infoDelineacion.getValCont().getInfoContrib().getAdicionales().getDIGVERIF();
		numObjeto = gasolinaService.obtenerNumeroObjetoDU(infoDelineacion);
		CDU = infoDelineacion.getInput().getSelectedCDU();


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
		InfoObjetoDelineacionResponse infoDelineacionResponse = new InfoObjetoDelineacionResponse();
		String mensajeError = "";
		String paginaDestino = "";
		String[] mensajesError;
		//		final InfoObjetoDelineacionExtras infObjetoDelineacionExtras = new InfoObjetoDelineacionExtras();



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

		System.out.println("Request para calculo	/Delineacion: " + infoDelineacionRequest);
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

		//		tipoImpuesto = infoDelineacion.getInput().getTipoFlujo().equals("R") ? new ControllerPseConstants().getRETENCIONDU() : new ControllerPseConstants().getDELINEACION();
		numBP = infoDelineacion.getValCont().getInfoContrib().getNumBP();
		numDoc = infoDelineacion.getValCont().getInfoContrib().getNumDoc();
		tipoDoc = infoDelineacion.getValCont().getInfoContrib().getTipoDoc();
		anoGravable = infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable();
		periodo = "01";
		clavePeriodo = gasolinaService.prepararPeriodoAnualPago(infoDelineacion.getInfObjetoDelineacionExtras().getAnoGravable());
		dv = infoDelineacion.getValCont().getInfoContrib().getAdicionales().getDIGVERIF();
		numObjeto = gasolinaService.obtenerNumeroObjetoDU(infoDelineacion);
		CDU = infoDelineacion.getInput().getSelectedCDU();


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


}

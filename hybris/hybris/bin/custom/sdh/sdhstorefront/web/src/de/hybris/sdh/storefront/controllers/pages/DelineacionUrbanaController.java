/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.RadicaDelinRequest;
import de.hybris.sdh.core.pojos.responses.RadicaDelinResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHDetallePublicidadService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;

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
 * @author Maria Luisa/Federico Flores Dimas
 *
 */
@Controller
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
	private static final String REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE = REDIRECT_PREFIX + "/contribuyentes/delineacion-urbana";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;



	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;
	@Resource(name = "sdhDetallePublicidadService")
	SDHDetallePublicidadService sdhDetallePublicidadService;


	@RequestMapping(value = "/contribuyentes/delineacion-urbana", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbana(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Delineacion urbana GET --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		SDHValidaMailRolResponse detalleContribuyente;
		String mensajeError = "";
		final InfoDelineacion infoDelineacion = new InfoDelineacion();


		//		RadicaDelinRequest delinRequest = new RadicaDelinRequest();
		//
		//		delinRequest.setBP()


		contribuyenteRequest.setNumBP(customerModel.getNumBP());

		System.out.println("Request para validaCont: " + contribuyenteRequest);
		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		System.out.println("Response de validaCont: " + detalleContribuyente);
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


		model.addAttribute("dataForm", infoDelineacion);


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
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
	public String delineacionUrbanadeclaracion(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a declaracion delineacion --------------------------");

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

		tipoImpuesto = "5041";
		numBP = "766";
		numDoc = "802007086";
		tipoDoc = "NIT";
		anoGravable = "2019";
		periodo = "01";
		clavePeriodo = "19A1";
		dv = "4";
		numObjeto = "00060000000000000157";


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(numBP);
		infoPreviaPSE.setNumDoc(numDoc);
		infoPreviaPSE.setTipoDoc(tipoDoc);
		infoPreviaPSE.setAnoGravable(anoGravable);
		infoPreviaPSE.setPeriodo(periodo);
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setNumObjeto(numObjeto);


		model.addAttribute("infoPreviaPSE", infoPreviaPSE);



		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String delineacionurbanadeclaracionpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post------------------------");

		return REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/retencion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String delineacionUrbanaretencion(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a retencion delineacion --------------------------");


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

		tipoImpuesto = "5041";
		numBP = "766";
		numDoc = "802007086";
		tipoDoc = "NIT";
		anoGravable = "2019";
		periodo = "01";
		clavePeriodo = "19A1";
		dv = "4";
		numObjeto = "00060000000000000157";


		infoPreviaPSE.setTipoImpuesto(tipoImpuesto);
		infoPreviaPSE.setNumBP(numBP);
		infoPreviaPSE.setNumDoc(numDoc);
		infoPreviaPSE.setTipoDoc(tipoDoc);
		infoPreviaPSE.setAnoGravable(anoGravable);
		infoPreviaPSE.setPeriodo(periodo);
		infoPreviaPSE.setClavePeriodo(clavePeriodo);
		infoPreviaPSE.setDv(dv);
		infoPreviaPSE.setNumObjeto(numObjeto);


		model.addAttribute("infoPreviaPSE", infoPreviaPSE);


		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_RETENCION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_RETENCION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_RETENCION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/delineacionurbana/retencion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String delineacionurbanaretencionpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de retencion------------------------");

		return REDIRECT_TO_DELINEACION_URBANA_CMS_PAGE;
	}



	@RequestMapping(value = "/contribuyentes/delineacion-urbana/detalle", method = RequestMethod.GET)
	@ResponseBody
	public RadicaDelinResponse publicidadExternaDetail(@ModelAttribute("radicadoInfoRequest")
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


}

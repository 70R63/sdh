/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesPDFRequest;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesVista;
import de.hybris.sdh.core.pojos.responses.OpcionDeclaracionesPDFResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.facades.SDHCustomerFacade;
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
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class DeclaracionesPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Declaraciones";

	// CMS Pages
	private static final String DECLARACIONES_CMS_PAGE = "declaracionesPage";

	private static final String REDIRECT_TO_DECLARACIONES_PAGE = REDIRECT_PREFIX + "/contribuyentes/consultas/declaraciones";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@RequestMapping(value = "/contribuyentes/consultas/declaraciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String declaracionesget(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Agentes Declaraciones --------------------------");

		final OpcionDeclaracionesVista infoVista = new OpcionDeclaracionesVista();

		model.addAttribute("dataForm", infoVista);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/consultas/declaraciones", method = RequestMethod.POST)
	@RequireHardLogIn
	public String declaracionespost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de Agentes Declaraciones------------------------");

		return REDIRECT_TO_DECLARACIONES_PAGE;
	}


	@RequestMapping(value = "/contribuyentes/consultas/declaraciones/declaracionPDF", method = RequestMethod.GET)
	@ResponseBody
	public OpcionDeclaracionesPDFResponse tramitescrearpost(@ModelAttribute("dataForm")
	final OpcionDeclaracionesVista infoVista, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET declaracion PDF------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final OpcionDeclaracionesPDFRequest declaraPDFRequest = new OpcionDeclaracionesPDFRequest();
		OpcionDeclaracionesPDFResponse declaraPDFResponse = null;
		CustomerData customerData = null;

		String bp = "";
		String objContrato = "";
		String claseObjeto = "";
		String anioGravable = "";
		String periodo = "";
		String radicado = "";


		bp = customerModel.getNumBP();
		customerData = sdhCustomerFacade.getRepresentadoDataFromSAP(bp);
		final SDHValidaMailRolResponse customerData2 = sdhCustomerFacade.getRepresentadoFromSAP(bp);

		claseObjeto = infoVista.getClaveImpuesto();
		objContrato = gasolinaService.obtenerNumDocDeclaraciones(customerData2, claseObjeto);
		anioGravable = infoVista.getAnoGravable();
		periodo = infoVista.getPeriodo();
		radicado = "";



		declaraPDFRequest.setBp(bp);
		declaraPDFRequest.setObjContrato(objContrato);
		declaraPDFRequest.setClaseObjeto(claseObjeto);
		declaraPDFRequest.setAnioGravable(anioGravable);
		declaraPDFRequest.setPeriodo(periodo);
		declaraPDFRequest.setRadicado(radicado);

		System.out.println("Request para declaraPDF: " + declaraPDFRequest);
		declaraPDFResponse = gasolinaService.consultaDeclaraPDF(declaraPDFRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de declaraPDF: " + declaraPDFResponse);
		if (gasolinaService.ocurrioErrorDeclaraPDF(declaraPDFResponse) != true)
		{

		}
		else
		{
			//				declaraPDFResponse.setErrores(("Ocurrio un error. No se genero el PDF");
		}

		//		infoVista.setResponse(declaraPDFResponse);



		return declaraPDFResponse;
	}



}

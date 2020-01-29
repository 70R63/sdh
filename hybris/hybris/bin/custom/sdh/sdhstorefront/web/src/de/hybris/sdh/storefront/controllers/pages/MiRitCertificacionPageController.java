/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;




import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.CertificaRITRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.CertificacionRITResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.MiRitCertificacionForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MiRitCertificacionPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String BREADCRUMBS_VALUE = "breadcrumb.certificacion";
	private static final String BREADCRUMBS_VALUE_RETE = "breadcrumb.certificacionRETE";
	private static final String BREADCRUMBS_VALUE_REPO = "breadcrumb.certificacionREPO";


	private static final String VACIO = "";

	//CMS PAGES
	private static final String MI_RIT_CERTIFICACION_CMS_PAGE = "miRITCertificacionPage";
	private static final String MI_RIT_CERTIFICACION_DATOS_CMS_PAGE = "certificacion-datos";

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value =
	{ "/contribuyentes/mirit/certificacion-datos", "/agenteRetenedor/mirit/certificacion-datos" }, method = RequestMethod.POST)
	public String showView(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("miRitCertificacionForm")
	final MiRitCertificacionForm miRitCertificacionFormDatos) throws CMSItemNotFoundException
	{

		String returnURL = "/";
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CertificaRITRequest certificaRITRequest = new CertificaRITRequest();

		if (customerModel.getNumBP() != null)
		{
			certificaRITRequest.setNumBP(customerModel.getNumBP());
		}
		else
		{
			certificaRITRequest.setNumBP(VACIO);
		}


		if (miRitCertificacionFormDatos.getTipoCert() != null)
		{
			certificaRITRequest.setTipoCert(miRitCertificacionFormDatos.getTipoCert());
		}
		else
		{
			certificaRITRequest.setTipoCert(VACIO);
		}

		if (miRitCertificacionFormDatos.getTipoImp() != null)
		{
			certificaRITRequest.setTipoImp(miRitCertificacionFormDatos.getTipoImp());
		}
		else
		{
			certificaRITRequest.setTipoImp(VACIO);
		}


		try
		{
			final MiRitCertificacionForm miRitCertificacionFormResp = new MiRitCertificacionForm();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final CertificacionRITResponse certificaRITResponse = mapper.readValue(
					sdhCertificaRITService.consultaCertificacionRIT(certificaRITRequest),
					CertificacionRITResponse.class);


			miRitCertificacionFormResp.setIdmsj(certificaRITResponse.getIdmsj());
			miRitCertificacionFormResp.setTxtmsj(certificaRITResponse.getTxtmsj());
			if (certificaRITResponse.getRit() != null)
			{
				miRitCertificacionFormResp.setRit(certificaRITResponse.getRit());
				//model.addAttribute("miRitCertificacionFormResp", miRitCertificacionFormResp);
				redirectModel.addFlashAttribute("miRitCertificacionFormResp", miRitCertificacionFormResp);
			}
			else
			{
				redirectModel.addFlashAttribute("error", "sinPdf");
				return "redirect:/contribuyentes/mirit/certificacion-datos";
			}
		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			return "redirect:/contribuyentes/mirit/certificacion-datos";

		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE));

		returnURL = getViewForPage(model);

		return "redirect:/contribuyentes/mirit/certificacion-datos";
	}





	@RequestMapping(value =
	{ "/contribuyentes/mirit/certificacion-datos", "/agenteRetenedor/mirit/certificacion-datos" })
	public String showCertificacionDatos(final Model model, HttpServletRequest request, @ModelAttribute("error")
	final String error, @ModelAttribute("miRitCertificacionFormResp")
	final MiRitCertificacionForm miRitCertificacionFormResp)
			throws CMSItemNotFoundException
	{
		String returnURL = "/";
		String referrer = request.getHeader("referer");

		final MiRitCertificacionForm miRitCertificacionForm = new MiRitCertificacionForm();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CertificaRITRequest certificaRITRequest = new CertificaRITRequest();


		if (error == "sinPdf")
		{
			GlobalMessages.addErrorMessage(model, "mirit.certificacion..error.pdfVacio");
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		model.addAttribute("miRitCertificacionForm", miRitCertificacionForm);
		model.addAttribute("miRitCertificacionFormResp", miRitCertificacionFormResp);

		if (referrer.contains("contribuyentes"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE));
		}
		else if (referrer.contains("retenedor") || referrer.contains("agenteRetenedor"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_RETE));
		}
		else
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_REPO));
		}


		returnURL = getViewForPage(model);

		return returnURL;
	}





	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

}

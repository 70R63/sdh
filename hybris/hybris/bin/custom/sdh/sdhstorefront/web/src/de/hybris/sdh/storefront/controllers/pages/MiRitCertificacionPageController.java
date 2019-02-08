/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.CertificaRITRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.CertificacionRITResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.MiRitCertificacionForm;

import javax.annotation.Resource;

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
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	private static final String TIPO_CERTIFICACION = "";

	//CMS PAGES
	private static final String MI_RIT_CERTIFICACION_CMS_PAGE = "miRITCertificacionPage";
	private static final String MI_RIT_CERTIFICACION_DATOS_CMS_PAGE = "miRITCertificacionDatosPage";

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;





	@RequestMapping(value = "/contribuyentes/mirit/certificacion", method = RequestMethod.POST)
	public String showView(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("miRitCertificacionForm")
	final MiRitCertificacionForm miRitCertificacionFormDatos) throws CMSItemNotFoundException
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CertificaRITRequest certificaRITRequest = new CertificaRITRequest();


		certificaRITRequest.setNumBP(customerModel.getNumBP());

		certificaRITRequest.setTipoCert(miRitCertificacionFormDatos.getTipoCert());
		certificaRITRequest.setTipoImp(miRitCertificacionFormDatos.getTipoImp());

		try
		{
			final MiRitCertificacionForm miRitCertificacionForm = new MiRitCertificacionForm();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final CertificacionRITResponse certificaRITResponse = mapper.readValue(
					sdhCertificaRITService.consultaCertificacionRIT(certificaRITRequest),
					CertificacionRITResponse.class);


			miRitCertificacionForm.setIdmsj(certificaRITResponse.getIdmsj());
			miRitCertificacionForm.setTxtmsj(certificaRITResponse.getTxtmsj());
			if (certificaRITResponse.getRit() != null)
			{
				miRitCertificacionForm.setRit(certificaRITResponse.getRit());
				model.addAttribute("miRitCertificacionForm", miRitCertificacionForm);
			}
			else
			{
				redirectModel.addFlashAttribute("error", "sinPdf");
				return "redirect:/contribuyentes/mirit/certificacion/datos";
			}
		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			return "redirect:/contribuyentes/mirit/certificacion/datos";

		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_CMS_PAGE));

		return getViewForPage(model);
	}





	@RequestMapping(value = "/contribuyentes/mirit/certificacion/datos")
	public String showCertificacionDatos(final Model model, @ModelAttribute("error")
	final String error)
			throws CMSItemNotFoundException
	{

		final MiRitCertificacionForm miRitCertificacionForm = new MiRitCertificacionForm();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CertificaRITRequest certificaRITRequest = new CertificaRITRequest();

		if (error == "sinPdf")
		{
			GlobalMessages.addErrorMessage(model, "mirit.certificacion..error.pdfVacio");
		}

		try
		{
			certificaRITRequest.setNumBP(customerModel.getNumBP());
			consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			//private String bPredial;
			//private String bVehicular;
			//private String bIca;
			if (!sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
			{
				miRitCertificacionForm.setbSobreGasolina("X");
			}
			else
			{
				miRitCertificacionForm.setbSobreGasolina("");
			}

			if (!sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				miRitCertificacionForm.setbPublicidadExt("X");
			}
			else
			{
				miRitCertificacionForm.setbPublicidadExt("");
			}

		}

		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));

		model.addAttribute("miRitCertificacionForm", miRitCertificacionForm);

		return getViewForPage(model);
	}





	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

}

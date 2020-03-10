/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.form.SelectAtomValue;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRitRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.pojos.responses.UpdateRitResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHGestionBancaria;
import de.hybris.sdh.core.services.SDHUpdateRitService;
import de.hybris.sdh.core.services.SDHValidateBankFiles;
import de.hybris.sdh.storefront.controllers.pages.forms.ImportConciliacionForm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class AgentesAutorizadosReportarInfoPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Reportar Información";

	// CMS Pages
	private static final String AUTORIZADOS_REPORTAR_CMS_PAGE = "autorizadosReportarInfoPage";

	private static final String REDIRECT_TO_AUTORIZADOS_REPORTAR_PAGE = REDIRECT_PREFIX + "/autorizados/entidades/reportarinfo";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhUpdateRitService")
	SDHUpdateRitService sdhUpdateRitService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhGestionBancaria")
	private SDHGestionBancaria sdhGestionBancaria;

	@Resource(name = "sdhValidateBankFiles")
	private SDHValidateBankFiles sdhValidateBankFiles;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@ModelAttribute("entidadBancaria")
	public String getEntidadBancaria()
	{
		final String bp = customerFacade.getCurrentCustomer().getNumBP();
		return  sdhConsultaContribuyenteBPService.getEntidadBancaria(bp);
	}

	@ModelAttribute("tipoDeArchivo")
	public List<SelectAtomValue> getTipoDeArchivo()
	{
		final String bp = customerFacade.getCurrentCustomer().getNumBP();
		final String entidadBancaria = sdhConsultaContribuyenteBPService.getEntidadBancaria(bp);
		LOG.info("AgentesAutorizadosReportarInfoPageController BP:" + bp);
		LOG.info("AgentesAutorizadosReportarInfoPageController entidad bancaria:" + entidadBancaria);

		return sdhValidateBankFiles.getTypeFileBank(entidadBancaria);
	}

		@RequestMapping(value = "/autorizados/entidades/reportarinfo", method = RequestMethod.GET)
	@RequireHardLogIn
	public String autorizados(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Agentes Autorizados reportar --------------------------");

		storeCmsPageInModel(model, getContentPageForLabelOrId(AUTORIZADOS_REPORTAR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AUTORIZADOS_REPORTAR_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/autorizados/entidades", method = RequestMethod.POST)
	@RequireHardLogIn
	public String autorizadosreportarpost(@ModelAttribute("importConciliacionForm") final ImportConciliacionForm importConciliacionForm,
										  final RedirectAttributes redirectAttributes )throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de Agentes Autorizados reportar------------------------");
		final String verifiedOk = sdhGestionBancaria.validade7ZipCertificates(importConciliacionForm.getConciliacionFile());

		if (verifiedOk == null || verifiedOk.isEmpty())
		{

			final UpdateRitRequest request = new UpdateRitRequest();
			UpdateRitResponse response = new UpdateRitResponse();
			response.setRitUpdated(false);
			final String strinResponse = sdhUpdateRitService.updateRit(request);

			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				response = mapper.readValue(strinResponse, UpdateRitResponse.class);
				response.setRitUpdated(true);


				final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
				final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
						sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
						SDHValidaMailRolResponse.class);

			}
			catch (final Exception e)
			{
				LOG.error("Error en la carga de archivos : " + e.getMessage());
			}

			if (verifiedOk == null)
			{
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
						"conciliaciones.upload.messages.success", new Object[]
						{ importConciliacionForm.getConciliacionFile().getOriginalFilename() });
			}
			else
			{
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
						"conciliaciones.upload.messages.error.firma", new Object[]
						{ importConciliacionForm.getConciliacionFile().getOriginalFilename(), verifiedOk });
			}
		}


		return "redirect:/autorizados/entidades/reportarinfo";
	}

}

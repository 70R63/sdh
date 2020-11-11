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
import de.hybris.sdh.core.form.FileConsultaForm;
import de.hybris.sdh.core.form.SelectAtomValue;
import de.hybris.sdh.core.pojos.requests.FileConsultaRequest;
import de.hybris.sdh.core.pojos.responses.FileConsultaResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHFileConsultaService;
import de.hybris.sdh.core.services.SDHValidateBankFiles;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
public class AgentesAutorizadosConsultasPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Consultas";

	// CMS Pages
	private static final String AUTORIZADOS_CONSULTAS_CMS_PAGE = "autorizadosConsultasPage";

	private static final String REDIRECT_TO_AUTORIZADOS_CONSULTAS_PAGE = REDIRECT_PREFIX + "/autorizados/entidades/consultas";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhValidateBankFiles")
	private SDHValidateBankFiles sdhValidateBankFiles;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "sdhFileConsultaService")
	private SDHFileConsultaService sdhFileConsultaService;

	@ModelAttribute("tipoDeArchivo")
	public List<SelectAtomValue> getTipoDeArchivo()
	{
		String bp = customerFacade.getCurrentCustomer().getNumBP();
		String entidadBancaria = sdhConsultaContribuyenteBPService.getEntidadBancaria(bp);
		LOG.info("AgentesAutorizadosReportarInfoPageController BP:" + bp);
		LOG.info("AgentesAutorizadosReportarInfoPageController entidad bancaria:" + entidadBancaria);

		return sdhValidateBankFiles.getTypeFileBank(entidadBancaria);
	}

	@RequestMapping(value = "/autorizados/entidades/consultas", method = RequestMethod.GET)
	@RequireHardLogIn
	public String autorizadosconsultas(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Agentes Autorizados consultas --------------------------");
		model.addAttribute("aaEntidadBancaria", true);
		storeCmsPageInModel(model, getContentPageForLabelOrId(AUTORIZADOS_CONSULTAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AUTORIZADOS_CONSULTAS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("fileConsultaForm",new FileConsultaForm());

		return getViewForPage(model);
	}

	@RequestMapping(value = "/autorizados/entidades/consultas", method = RequestMethod.POST)
	@RequireHardLogIn
	public String autorizadosconsultaspost(final Model model, @ModelAttribute("fileConsultaForm") final FileConsultaForm fileConsultaForm,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de Agentes Autorizados consultas------------------------");

		String bp = customerFacade.getCurrentCustomer().getNumBP();
		String entidadBancaria = sdhConsultaContribuyenteBPService.getEntidadBancaria(bp);
		FileConsultaRequest fileConsultaRequest = new FileConsultaRequest(
				entidadBancaria,
				//"13",
				fileConsultaForm.getIdenvio(),
				fileConsultaForm.getTiparchivo(),
				fileConsultaForm.getNosecuencia(),
				fileConsultaForm.getTipresultado(),
				fileConsultaForm.getFecenvio());
		FileConsultaResponse fileConsultaResponse =  sdhFileConsultaService.consultar(fileConsultaRequest);

		if(!fileConsultaResponse.getIdmsj().equals("00")){
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"conciliaciones.download.file.messages.error", new Object[]
							{ fileConsultaResponse.getTxtmsj()});
		}else{
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
					"conciliaciones.download.file.messages.success", new Object[]
							{ fileConsultaResponse.getTxtmsj() });
		}

		redirectAttributes.addFlashAttribute("fileConsultaForm",fileConsultaForm);
		redirectAttributes.addFlashAttribute("fileConsultaResponse",fileConsultaResponse);

		LOG.info(fileConsultaForm);
		LOG.info(fileConsultaRequest);
		LOG.info(fileConsultaResponse);

		return REDIRECT_TO_AUTORIZADOS_CONSULTAS_PAGE;
	}

}

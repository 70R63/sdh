/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class AgentesAutorizadosPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(AgentesAutorizadosPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Agentes Autorizados";

	// CMS Pages
	private static final String AGENTES_AUTORIZADOS_CMS_PAGE = "agentesAutorizadosMenuPage";

	private static final String REDIRECT_TO_AGENTES_AUTORIZADOS_PAGE = REDIRECT_PREFIX + "/autorizados";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sessionService")
	private SessionService sessionService;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@ModelAttribute("entidadBancaria")
	public String getEntidadBancaria()
	{
		String bp = customerFacade.getCurrentCustomer().getNumBP();
		String entidadBancaria = sdhConsultaContribuyenteBPService.getEntidadBancaria(bp);
		LOG.info("AgentesAutorizadosPageController BP:" + bp);
		LOG.info("AgentesAutorizadosPageController entidad bancaria:" + entidadBancaria);

		return entidadBancaria;
	}

	@RequestMapping(value = "/autorizados", method = RequestMethod.GET)
	@RequireHardLogIn
	public String retenedores(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Agentes Autorizados --------------------------");

		sessionService.setAttribute("representado",null);

		storeCmsPageInModel(model, getContentPageForLabelOrId(AGENTES_AUTORIZADOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AGENTES_AUTORIZADOS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/autorizados", method = RequestMethod.POST)
	@RequireHardLogIn
	public String retenedorespost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de Agentes Autorizados------------------------");

		return REDIRECT_TO_AGENTES_AUTORIZADOS_PAGE;
	}

}

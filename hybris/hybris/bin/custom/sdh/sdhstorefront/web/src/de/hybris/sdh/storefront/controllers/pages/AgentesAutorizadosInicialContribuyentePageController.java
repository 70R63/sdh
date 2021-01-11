/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.ConsulFirmasRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.facades.SDHConsultaFirmasFacade;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */

@SessionAttributes(
{ "dataForm" })

@Controller
public class AgentesAutorizadosInicialContribuyentePageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Representando";

	// CMS Pages
	private static final String AUTORIZADOS_REPRE_CMS_PAGE = "autorizadosInicialContribuyentePage";

	private static final String REDIRECT_TO_AUTORIZADOS_REPRE_PAGE = REDIRECT_PREFIX + "/autorizados/contribuyente/respresentando";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name="sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name="sessionService")
    SessionService sessionService;

	@Resource(name="sdhConsultaFirmasFacade")
	SDHConsultaFirmasFacade sdhConsultaFirmasFacade;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@RequestMapping(value = "/autorizados/contribuyente/representando", method = RequestMethod.GET)
	@RequireHardLogIn
	public String autorizadoscontrib(final Model model, @RequestParam final String representado) throws CMSItemNotFoundException
	{
		final CustomerData currentUser = customerFacade.getCurrentCustomer();

		final SDHValidaMailRolResponse representadoData = sdhCustomerFacade.getRepresentadoFromSAP(representado);

		sessionService.getCurrentSession().setAttribute("representado",representado);

		model.addAttribute("representado", representadoData);


		final ConsulFirmasRequest request = new ConsulFirmasRequest();
		request.setAgente(currentUser.getNumBP());
		request.setContribuyente(representado);

		model.addAttribute("firmas",sdhConsultaFirmasFacade.getDeclaraciones(request));
		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		model.addAttribute("dataForm", dataForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(AUTORIZADOS_REPRE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AUTORIZADOS_REPRE_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/autorizados/contribuyente/representando", method = RequestMethod.POST)
	@RequireHardLogIn
	public String autorizadoscontribpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de Agentes Autorizados Repese------------------------");

		return REDIRECT_TO_AUTORIZADOS_REPRE_PAGE;
	}

	@RequestMapping(value = "/setComplete9", method = RequestMethod.POST)
	public String setComplete(final SessionStatus status)
	{
		status.setComplete();

		return null;
	}

}

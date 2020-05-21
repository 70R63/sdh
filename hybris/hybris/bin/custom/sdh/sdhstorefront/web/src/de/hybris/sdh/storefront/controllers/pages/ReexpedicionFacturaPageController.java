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
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.DefaultResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.FacturacionForm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class ReexpedicionFacturaPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.reexpedicionFac";

	// CMS Pages
	private static final String REEXPEDICION_FACTURA_CMS_PAGE = "reexpedicionFacturaPage";

	private static final String REDIRECT_TO_REEXPEDICION_FACTURA_PAGE = REDIRECT_PREFIX + "/contribuyentes/reexpedicionfactura";

	@Resource(name = "customBreadcrumbBuilder")
	private DefaultResourceBreadcrumbBuilder accountBreadcrumbBuilder;


	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "eventService")
	private EventService eventService;

	@RequestMapping(value = "/contribuyentes/reexpedicionfactura", method = RequestMethod.GET)
	@RequireHardLogIn
	public String reexpfact(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET REEXPEDICION Factura --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

		final FacturacionForm facturacionForm = new FacturacionForm();


		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			facturacionForm.setPredial(sdhConsultaContribuyenteBPResponse.getPredial());
			facturacionForm.setVehicular(sdhConsultaContribuyenteBPResponse.getVehicular());

			model.addAttribute("facturacionForm", facturacionForm);
		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(REEXPEDICION_FACTURA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REEXPEDICION_FACTURA_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/reexpedicionfactura", method = RequestMethod.POST)
	@RequireHardLogIn
	public String reexpfactpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de REEXPEDICION Factura------------------------");

		return REDIRECT_TO_REEXPEDICION_FACTURA_PAGE;
	}

}

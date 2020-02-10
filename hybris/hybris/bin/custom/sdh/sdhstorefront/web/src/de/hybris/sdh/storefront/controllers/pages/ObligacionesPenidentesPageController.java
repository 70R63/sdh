/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ObligacionesRequest;
import de.hybris.sdh.core.pojos.responses.ObligacionesDeliResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesGasolinaResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesICAResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesPredialResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesVehiculosResponse;
import de.hybris.sdh.core.services.SDHObligacionesDeliService;
import de.hybris.sdh.core.services.SDHObligacionesGasolinaService;
import de.hybris.sdh.core.services.SDHObligacionesICAService;
import de.hybris.sdh.core.services.SDHObligacionesPredialService;
import de.hybris.sdh.core.services.SDHObligacionesPublicidadService;
import de.hybris.sdh.core.services.SDHObligacionesVehiculosService;
import de.hybris.sdh.storefront.forms.ObligacionesForm;

import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
/* @RequestMapping("/contribuyentes/certipagos") */
public class ObligacionesPenidentesPageController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.oblipendienetes";

	// CMS Pages
	private static final String OBLIGACIONES_PENDIENTES_CMS_PAGE = "obligacionesPendientesPage";

	private static final String REDIRECT_TO_OBLIGACIONES_PENDIENTES_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/consultas/obligaciones";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhObligacionesPublicidadService")
	SDHObligacionesPublicidadService sdhObligacionesPublicidadService;


	@Resource(name = "sdhObligacionesGasolinaService")
	SDHObligacionesGasolinaService sdhObligacionesGasolinaService;

	@Resource(name = "sdhObligacionesICAService")
	SDHObligacionesICAService sdhObligacionesICAService;

	@Resource(name = "sdhObligacionesDeliService")
	SDHObligacionesDeliService sdhObligacionesDeliService;

	@Resource(name = "sdhObligacionesPredialService")
	SDHObligacionesPredialService sdhObligacionesPredialService;

	@Resource(name = "sdhObligacionesVehiculosService")
	SDHObligacionesVehiculosService sdhObligacionesVehiculosService;


	@RequestMapping(value = "/contribuyentes/consultas/obligaciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String oblipendi(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("obligacionesForm")
	final ObligacionesForm obligacionesForm) throws CMSItemNotFoundException
	{

		System.out.println("Se encuentra dentro del get de OBLIGACIONES PENDIENTES");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final ObligacionesRequest obligacionesRequest = new ObligacionesRequest();
		obligacionesRequest.setBp(customerModel.getNumBP());
		final ObligacionesForm obligacionesFormuno = new ObligacionesForm();
		try
		{


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final ObligacionesResponse obligacionesResponse = mapper
					.readValue(sdhObligacionesPublicidadService.obligacionesRequest(obligacionesRequest), ObligacionesResponse.class);

			obligacionesFormuno.setHeader(obligacionesResponse.getHeader().stream()
					.filter(d -> StringUtils.isNotBlank(d.getNumResolucion())).collect(Collectors.toList()));

			final ObligacionesGasolinaResponse obligacionesGasolinaResponse = mapper.readValue(
					sdhObligacionesGasolinaService.obligacionesRequest(obligacionesRequest), ObligacionesGasolinaResponse.class);

			obligacionesFormuno.setHeadergas(obligacionesGasolinaResponse.getHeader().stream()
					.filter(d -> StringUtils.isNotBlank(d.getAnioGravable())).collect(Collectors.toList()));

			final ObligacionesICAResponse obligacionesICAResponse = mapper
					.readValue(sdhObligacionesICAService.obligacionesRequest(obligacionesRequest), ObligacionesICAResponse.class);

			obligacionesFormuno.setHeaderica(obligacionesICAResponse.getHeader());

			final ObligacionesDeliResponse obligacionesDeliResponse = mapper
					.readValue(sdhObligacionesDeliService.obligacionesRequest(obligacionesRequest), ObligacionesDeliResponse.class);

			obligacionesFormuno.setHeaderdeli(obligacionesDeliResponse.getHeader().stream()
					.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));

			final ObligacionesPredialResponse obligacionesPredResponse = mapper
					.readValue(sdhObligacionesPredialService.obligacionesRequest(obligacionesRequest),
							ObligacionesPredialResponse.class);

			obligacionesFormuno.setHeaderPred(obligacionesPredResponse.getHeader().stream()
					.filter(d -> StringUtils.isNotBlank(d.getAniogravable())).collect(Collectors.toList()));

			final ObligacionesVehiculosResponse obligacionesVehiResponse = mapper.readValue(
					sdhObligacionesVehiculosService.obligacionesRequest(obligacionesRequest), ObligacionesVehiculosResponse.class);

			obligacionesFormuno.setHeaderVehiculos(obligacionesVehiResponse.getHeader().stream()
					.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
		}
		catch (final Exception e)
		{
			//LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			//	GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		model.addAttribute("obligacionesFormuno", obligacionesFormuno);
		model.addAttribute("customerData", customerData);


		storeCmsPageInModel(model, getContentPageForLabelOrId(OBLIGACIONES_PENDIENTES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(OBLIGACIONES_PENDIENTES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}



}

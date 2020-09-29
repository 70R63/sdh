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
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.ObligacionesRequest;
import de.hybris.sdh.core.pojos.requests.ReteicaObligacionesRequest;
import de.hybris.sdh.core.pojos.responses.ObligacionesDeliResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesGasolinaResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesICAResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesPredialResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.ReteicaObligacionesResponse;
import de.hybris.sdh.core.services.SDHObligacionesDeliService;
import de.hybris.sdh.core.services.SDHObligacionesGasolinaService;
import de.hybris.sdh.core.services.SDHObligacionesICAService;
import de.hybris.sdh.core.services.SDHObligacionesPredialService;
import de.hybris.sdh.core.services.SDHObligacionesPublicidadService;
import de.hybris.sdh.core.services.SDHObligacionesVehiculosService;
import de.hybris.sdh.core.services.SDHReteIcaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.forms.ObligacionesForm;

import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
/* @RequestMapping("/contribuyentes/certipagos") */
public class ObligacionesPenidentesPageController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.oblipendienetes";
	private static final String TEXT_ACCOUNT_PROFILE_RETE = "text.account.profile.obligaRETE";

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

	@Resource(name = "sdhReteIcaService")
	SDHReteIcaService sdhReteICAInfObjetoService;

	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);


	@RequestMapping(value =
	{ "/contribuyentes/consultas/obligaciones", "/agenteRetenedor/consultas/obligaciones" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String oblipendi(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("obligacionesForm")
	final ObligacionesForm obligacionesForm, final HttpServletRequest request) throws CMSItemNotFoundException
	{

		final String referrer = request.getHeader("referer");
		System.out.println("Se encuentra dentro del get de OBLIGACIONES PENDIENTES");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		String wsResponse = null;
		String wsResponseReteica = null;

		final ObligacionesRequest obligacionesRequest = new ObligacionesRequest();
		obligacionesRequest.setBp(customerModel.getNumBP());
		final ObligacionesForm obligacionesFormuno = new ObligacionesForm();

		try
		{


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			wsResponse = sdhObligacionesGasolinaService.obligacionesRequest(obligacionesRequest);
			if (wsResponse != null)
			{
				final ObligacionesGasolinaResponse obligacionesGasolinaResponse = mapper.readValue(wsResponse,
						ObligacionesGasolinaResponse.class);
				obligacionesFormuno.setHeadergas(obligacionesGasolinaResponse.getHeader().stream()
						.filter(d -> StringUtils.isNotBlank(d.getAnioGravable())).collect(Collectors.toList()));
			}

			wsResponse = sdhObligacionesICAService.obligacionesRequest(obligacionesRequest);
			if (wsResponse != null)
			{
				final ObligacionesICAResponse obligacionesICAResponse = mapper.readValue(wsResponse, ObligacionesICAResponse.class);
				obligacionesFormuno.setHeaderica(obligacionesICAResponse.getHeader());

			}

			wsResponse = sdhObligacionesDeliService.obligacionesRequest(obligacionesRequest);
			if (wsResponse != null)
			{
				final ObligacionesDeliResponse obligacionesDeliResponse = mapper.readValue(wsResponse,
						ObligacionesDeliResponse.class);
				obligacionesFormuno.setHeaderdeli(obligacionesDeliResponse.getHeader().stream()
						.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));
			}

			wsResponse = sdhObligacionesPredialService.obligacionesRequest(obligacionesRequest);
			if (wsResponse != null)
			{
				final ObligacionesPredialResponse obligacionesPredResponse = mapper.readValue(wsResponse,
						ObligacionesPredialResponse.class);
				obligacionesFormuno.setHeaderPred(obligacionesPredResponse.getHeader().stream()
						.filter(d -> StringUtils.isNotBlank(d.getAnioGravable())).collect(Collectors.toList()));
			}

			wsResponse = sdhObligacionesVehiculosService.obligacionesRequest(obligacionesRequest);
			if (wsResponse != null)
			{
				final ObligacionesVehiculosResponse obligacionesVehiResponse = mapper.readValue(wsResponse,
						ObligacionesVehiculosResponse.class);
				obligacionesFormuno.setHeaderVehiculos(obligacionesVehiResponse.getHeader().stream()
						.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
			}

			wsResponse = sdhObligacionesPublicidadService.obligacionesRequest(obligacionesRequest);
			if (wsResponse != null)
			{
				final ObligacionesResponse obligacionesResponse = mapper.readValue(wsResponse, ObligacionesResponse.class);

				obligacionesFormuno.setHeader(obligacionesResponse.getHeader().stream()
						.filter(d -> StringUtils.isNotBlank(d.getNumResolucion())).collect(Collectors.toList()));
			}

		}
		catch (final Exception e)
		{
			LOG.error("error generating declaration : " + e.getMessage());
		}

		if (referrer.contains("contribuyentes"))
		{

			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}
		else if (referrer.contains("retenedor") || referrer.contains("agenteRetenedor"))
		{

			final ReteicaObligacionesRequest reteicaRequest = new ReteicaObligacionesRequest();
			reteicaRequest.setBp(customerModel.getNumBP());

			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				wsResponseReteica = sdhReteICAInfObjetoService.reteIcaObligaciones(reteicaRequest);
				if (wsResponseReteica != null)
				{
					final ReteicaObligacionesResponse reteicaObligacionesResponse = mapper.readValue(wsResponse,
							ReteicaObligacionesResponse.class);

					obligacionesFormuno.setHeaderreteica(reteicaObligacionesResponse.getHeader());
				}


			}
			catch (final Exception e)
			{
				LOG.error("error generating declaration : " + e.getMessage());
			}

			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_RETE));
		}
		else
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}


		model.addAttribute("obligacionesFormuno", obligacionesFormuno);
		model.addAttribute("customerData", customerData);
		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());


		storeCmsPageInModel(model, getContentPageForLabelOrId(OBLIGACIONES_PENDIENTES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(OBLIGACIONES_PENDIENTES_CMS_PAGE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	private String obtenerPeriodo(final String sCadena)
	{
		String idDestinos = sCadena;
		if (sCadena.equals("A1"))
		{
			return idDestinos = "Enero-Febrero";
		}
		else if (sCadena.equals("A2"))
		{
				return idDestinos = "Marzo-Abril";
		}
		else if (sCadena.equals("A3"))
		{
				return idDestinos = "Mayo-Junio";
		}
		else if (sCadena.equals("A4"))
		{
				return idDestinos = "Julio-Agosto";
		}
		else if (sCadena.equals("A5"))
		{
				return idDestinos = "Septiembre-Octubre";
		}
		else if (sCadena.equals("A6"))
		{
				return idDestinos = "Noviembre-Diciembre";
			}else {
				return idDestinos = "-";
			}
		}



}

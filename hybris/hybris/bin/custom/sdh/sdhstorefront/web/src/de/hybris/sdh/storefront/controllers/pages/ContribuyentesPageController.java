/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsulFirmasRequest;
import de.hybris.sdh.core.pojos.responses.ContribFirmasResponse;
import de.hybris.sdh.core.pojos.responses.DetalleDeclaraciones;
import de.hybris.sdh.core.proxySelector.SDHProxySelector;
import de.hybris.sdh.core.services.SDHConsulFirmasService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.ContribuyenteForm;

import java.net.ProxySelector;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/contribuyentes")
public class ContribuyentesPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String CONTRIBUYENTES_CMS_PAGE = "ContribuyentesPage";

	private static final String DELINEACION_URBANA_CMS_PAGE = "DelineacionUrbanaPage";

	private static final String DELINEACION_URBANA_CORRECIONES_CMS_PAGE = "DelineacionUrbanaCorrecionesPage";

	private static final String DELINEACION_URBANA_DECLARACIONES_CMS_PAGE = "DelineacionUrbanaDeclaracionesPage";

	private static final String DELINEACION_URBANA_PAGOS_PSE_CMS_PAGE = "DelineacionUrbanaPagosPSEPage";

	private static final String SOBRETASA_GASOLINA_CMS_PAGE = "SobretasaGasolinaPage";

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhConsulFirmasService")
	SDHConsulFirmasService sdhConsulFirmasService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	//	@Resource(name = "sdhCreaModContribuyenteFacade")
	//	SDHCreaModContribuyenteFacade sdhCreaModContribuyenteFacade;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String showView(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{


		System.out.println("---------------- INI Seleccion Proxy --------------------------");
		final SDHProxySelector sdhps = new SDHProxySelector(ProxySelector.getDefault());
		ProxySelector.setDefault(sdhps);
		System.out.println("---------------- FIN Seleccion Proxy --------------------------");


		System.out.println("---------------- Hola entro al GET Contribuyentes --------------------------");

		/*
		 * LOG.info("--------- INI: Set up Proxy parameters ---------");
		 *
		 * final String httpProxyHost = configurationService.getConfiguration().getString("sdh.pse.http.proxyHost_1"); if
		 * (httpProxyHost.equals("null") || httpProxyHost.equals("")) { System.clearProperty("http.proxyHost"); } else {
		 * System.setProperty("http.proxyHost", httpProxyHost); } LOG.info("http.proxyHost_1:" +
		 * System.getProperty("http.proxyHost"));
		 *
		 *
		 * final String httpProxyPort = configurationService.getConfiguration().getString("sdh.pse.http.proxyPort_1"); if
		 * (httpProxyPort.equals("null") || httpProxyPort.equals("")) { System.clearProperty("http.proxyPort"); } else {
		 * System.setProperty("http.proxyPort", httpProxyPort); } LOG.info("http.proxyPort_1:" +
		 * System.getProperty("http.proxyPort"));
		 *
		 *
		 * final String httpsProxyHost = configurationService.getConfiguration().getString("sdh.pse.https.proxyHost_1");
		 * if (httpsProxyHost.equals("null") || httpsProxyHost.equals("")) { System.clearProperty("https.proxyHost"); }
		 * else { System.setProperty("https.proxyHost", httpsProxyHost); } LOG.info("https.proxyHost_1:" +
		 * System.getProperty("https.proxyHost"));
		 *
		 *
		 * final String httpsProxyPort = configurationService.getConfiguration().getString("sdh.pse.https.proxyPort_1");
		 * if (httpsProxyPort.equals("null") || httpsProxyPort.equals("")) { System.clearProperty("https.proxyPort"); }
		 * else { System.setProperty("https.proxyPort", httpsProxyPort); } LOG.info("https.proxyPort_1:" +
		 * System.getProperty("https.proxyPort"));
		 *
		 *
		 * final String httpNonProxyHosts =
		 * configurationService.getConfiguration().getString("sdh.pse.http.nonProxyHosts_1"); if
		 * (httpNonProxyHosts.equals("null") || httpNonProxyHosts.equals("")) {
		 * System.clearProperty("http.nonProxyHosts"); } else { System.setProperty("http.nonProxyHosts",
		 * httpNonProxyHosts); } LOG.info("http.nonProxyHosts_1:" + System.getProperty("http.nonProxyHosts"));
		 *
		 * LOG.info("---------END: Set up Proxy parameters ---------");
		 */



		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final ConsulFirmasRequest consulFirmasRequest = new ConsulFirmasRequest();
		final ContribuyenteForm contibForm = new ContribuyenteForm();

		if (customerModel.getNumBP() != null)
		{
			consulFirmasRequest.setContribuyente(customerModel.getNumBP());
			consulFirmasRequest.setAgente("");

			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				String response = sdhConsulFirmasService.getDeclaraciones(consulFirmasRequest);
				response = response.replaceAll("\"declaraciones\":\\s*\\{([\"])(.*)(\"\\})", "\"declaraciones\":[{\"$2$3]");

				final ContribFirmasResponse contribFirmasResponse = mapper
						.readValue(response, ContribFirmasResponse.class);


				for (final DetalleDeclaraciones eachPeriodo : contribFirmasResponse.getDeclaraciones())
				{
					String anoGravable = "";
					String perRepor = "";

					if ("0004".equals(eachPeriodo.getImpuesto()))
					{
						anoGravable = eachPeriodo.getAnioGravable();
						perRepor = eachPeriodo.getPeriodo();

						eachPeriodo.setPeriodo("B" + perRepor);

					}


				}

					contibForm.setDeclaraciones(contribFirmasResponse.getDeclaraciones().stream()
						.filter(eachDetDecla -> StringUtils.isNotBlank(eachDetDecla.getIdDeclaracion())).collect(Collectors.toList()));


			}
			catch (final Exception e)
			{
				// XXX Auto-generated catch block
				LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
				GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			}

		}
		else
		{
			//			vehiculosForm.setNumBP("vacio");
		}

		//		model.addAttribute("actualCustomer", customerData);
		model.addAttribute("contibForm", contibForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/delineacion-urbana/declaraciones", method = RequestMethod.GET)
	public String delineacionUrbanaDeclaraciones(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}


	@RequestMapping(value = "/delineacion-urbana/pagos/pse", method = RequestMethod.GET)
	public String delineacionUrbanaPagosPSE(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_PAGOS_PSE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_PAGOS_PSE_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_PAGOS_PSE_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/sobretasa-gasolina/detail", method = RequestMethod.GET)
	public String sobretasaGasolinaDetail(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/delineacion-urbana/detail", method = RequestMethod.GET)
	public String delineacionUrbanaDetail(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));

		return getViewForPage(model);
	}


	@RequestMapping(value = "/delineacion-urbana/correcciones", method = RequestMethod.GET)
	public String delineacionUrbanaCorreciones(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CORRECIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CORRECIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_CORRECIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}
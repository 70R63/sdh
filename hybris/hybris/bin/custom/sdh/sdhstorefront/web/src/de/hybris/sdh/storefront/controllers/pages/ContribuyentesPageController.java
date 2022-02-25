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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/contribuyentes")
public class ContribuyentesPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(ContribuyentesPageController.class);

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
	public String showView(final Model model, final RedirectAttributes redirectModel,
			@RequestParam(required = false, defaultValue = "", value = "error")
			final String errorSITIICancelar, @RequestParam(name = "errorSITII", required = false, value = "") String errorSITII)
			throws CMSItemNotFoundException
	{




		final String pconfig = configurationService.getConfiguration().getString("sdh.pse.http.configuracion");
		final String pconfigLog = configurationService.getConfiguration().getString("sdh.pse.http.configuracion.log");

		if (pconfig.equals("3") || pconfig.equals("4"))
		{
			if (pconfigLog.equals("true"))
			{
				System.out.println("---------------- INI Seleccion Proxy --------------------------");
			}

   		final String phttpProxyHostACH = configurationService.getConfiguration().getString("sdh.pse.http.proxyHostACH");
   		final String phttpProxyPortACH = configurationService.getConfiguration().getString("sdh.pse.http.proxyPortACH");
   		final String phttpProxyHostInternet = configurationService.getConfiguration().getString("sdh.pse.http.proxyHostInternet");
   		final String phttpProxyPortInternet = configurationService.getConfiguration().getString("sdh.pse.http.proxyPortInternet");
   		final String pproxyType = configurationService.getConfiguration().getString("sdh.pse.http.proxy.type");

   		final SDHProxySelector sdhps = new SDHProxySelector(ProxySelector.getDefault(), pconfig, pconfigLog, phttpProxyHostACH,
   				phttpProxyPortACH, phttpProxyHostInternet, phttpProxyPortInternet, pproxyType);
   		ProxySelector.setDefault(sdhps);

			if (pconfigLog.equals("true"))
			{
				System.out.println("---------------- FIN Seleccion Proxy --------------------------");
			}
		}



		System.out.println("---------------- Hola entro al GET Contribuyentes --------------------------");


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
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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
				
				//*->Carga de representantes
                final ConsultaContribBPRequest consultaContribBPRequest = new ConsultaContribBPRequest();
                consultaContribBPRequest.setNumBP(customerModel.getNumBP());
                consultaContribBPRequest.setIndicador("01,02");

                final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = sdhConsultaContribuyenteBPService
                        .consultaContribuyenteBP_simplificado(consultaContribBPRequest);

                contibForm.setRepresentados(sdhConsultaContribuyenteBPResponse.getAgentes().stream().filter(
                        eachAgente -> StringUtils.isNotBlank(eachAgente.getTipoDoc()) && "-".equalsIgnoreCase(eachAgente.getAgente()))
                        .collect(Collectors.toList()));
		


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

		if (errorSITIICancelar.contains("1"))
		{
			errorSITII = getMessageSource().getMessage("contribuyentes.Cancelar", null, getI18nService().getCurrentLocale());
			model.addAttribute("errorSITII", errorSITII);
			final String urlRetorno = configurationService.getConfiguration().getString("sdh.payment.service.retorno.url");
			LOG.error("Retorno de  SIT II  opcion CANCELAR: " + urlRetorno + "?error=1");
		}

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
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
import de.hybris.sdh.core.services.SDHConsulFirmasService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.ContribuyenteForm;

import java.util.stream.Collectors;

import javax.annotation.Resource;

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
public class ARListaDeclaracionesPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String AR_LISTA_CMS_PAGE = "arListaDeclaracionesPage";


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

	@RequestMapping(value = "/agenteRetenedor/lista-declaraciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String listadeclaraciones(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Contribuyentes --------------------------");



		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

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

				final ContribFirmasResponse contribFirmasResponse = mapper
						.readValue(sdhConsulFirmasService.getDeclaraciones(consulFirmasRequest), ContribFirmasResponse.class);

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

		storeCmsPageInModel(model, getContentPageForLabelOrId(AR_LISTA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AR_LISTA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(AR_LISTA_CMS_PAGE));

		return getViewForPage(model);
	}



	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}
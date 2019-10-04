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
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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

	//	@Resource(name = "sdhCreaModContribuyenteFacade")
	//	SDHCreaModContribuyenteFacade sdhCreaModContribuyenteFacade;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String showView(final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Contribuyentes --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		model.addAttribute("actualCustomer", customerData);

		storeCmsPageInModel(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/delineacion-urbana/declaraciones", method = RequestMethod.GET)
	public String delineacionUrbanaDeclaraciones(final Model model, final RedirectAttributes redirectModel,final HttpServletRequest request)
			throws CMSItemNotFoundException
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
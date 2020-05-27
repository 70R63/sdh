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


import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.UIMenuForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
public class ReportantesCargaController extends AbstractPageController
{
	//log
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	//breadcrumb
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String BREADCRUMBS_REPORTANTES_VALUE = "breadcrumb.reportante";
	private static final String BREADCRUMBS_CARGA_VALUE = "breadcrumb.reportante.carga";
	private static final String BREADCRUMBS_HISTORICO_VALUE = "breadcrumb.reportante.historico";
	private static final String BREADCRUMBS_SANCIONES_VALUE = "breadcrumb.reportante.sanciones";
	private static final String BREADCRUMBS_RETENEDOR_CARGA_VALUE = "breadcrumb.retenedor.carga";



	private static final String REPORTANTES_CMS_PAGE = "reportantesPage";
	private static final String REPORTANTES_CARGA_CMS_PAGE = "reportantesInfoPage";
	private static final String REPORTANTES_HISTORICO_CMS_PAGE = "reportantesHistoricoPage";
	private static final String REPORTANTES_SANCIONES_CMS_PAGE = "reportantesSancionesPage";

	//Servicios
	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;




	//----------------------------------------------------------------------------------------------------------------------
	//->Carga de documentos
	//----------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value =
	{ "/reportantes/cargadocumentos", "/retenedores/cargadocumentos" }, method = RequestMethod.GET)
	public String showView(final Model model, final RedirectAttributes redirectModel, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final UIMenuForm uiMenuForm = new UIMenuForm();
		final String referrer = request.getHeader("referer");

		try
		{
			consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			uiMenuForm.fillForm(sdhConsultaContribuyenteBPResponse);
			model.addAttribute("uiMenuForm", uiMenuForm);

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}


		if (referrer.contains("reportantes"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_CARGA_VALUE));
		}
		else
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_RETENEDOR_CARGA_VALUE));
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(REPORTANTES_CARGA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REPORTANTES_CARGA_CMS_PAGE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);

	}


}
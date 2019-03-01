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

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.UIContribuyenteForm;

import javax.annotation.Resource;

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
public class ReportantesPageController extends AbstractPageController
{
	//log
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	//breadcrumb
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String BREADCRUMBS_REPORTANTES_VALUE = "breadcrumb.reportante";
	private static final String BREADCRUMBS_CARGA_VALUE = "breadcrumb.reportante.carga";
	private static final String BREADCRUMBS_HISTORICO_VALUE = "breadcrumb.reportante.historico";
	private static final String BREADCRUMBS_SANCIONES_VALUE = "breadcrumb.reportante.sanciones";



	private static final String REPORTANTES_CMS_PAGE = "reportantesPage";
	private static final String REPORTANTES_CARGA_CMS_PAGE = "reportantesInfoPage";
	private static final String REPORTANTES_HISTORICO_CMS_PAGE = "reportantesHistoricoPage";
	private static final String REPORTANTES_SANCIONES_CMS_PAGE = "reportantesSancionesPage";

	//Servicios
	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;


	//----------------------------------------------------------------------------------------------------------------------
	//->Pagina inicial
	//----------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/reportantes", method = RequestMethod.GET)
	public String showReportantes(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final UIContribuyenteForm uiContribuyenteForm = new UIContribuyenteForm();

		try
		{
			consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			if (sdhConsultaContribuyenteBPResponse.getRoles() != null && !sdhConsultaContribuyenteBPResponse.getRoles().isEmpty())
			{
				uiContribuyenteForm.setRoles(sdhConsultaContribuyenteBPResponse.getRoles());
			}

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(REPORTANTES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REPORTANTES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_REPORTANTES_VALUE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("uiContribuyenteForm", uiContribuyenteForm);

		return getViewForPage(model);

	}



	//----------------------------------------------------------------------------------------------------------------------
	//->Carga de documentos
	//----------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/reportantes/cargadocumentos", method = RequestMethod.GET)
	public String showView(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final UIContribuyenteForm uiContribuyenteForm = new UIContribuyenteForm();

		try
		{
			consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			if (sdhConsultaContribuyenteBPResponse.getRoles() != null && !sdhConsultaContribuyenteBPResponse.getRoles().isEmpty())
			{
				uiContribuyenteForm.setRoles(sdhConsultaContribuyenteBPResponse.getRoles());
			}

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(REPORTANTES_CARGA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REPORTANTES_CARGA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_CARGA_VALUE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("uiContribuyenteForm", uiContribuyenteForm);

		return getViewForPage(model);

	}



	//----------------------------------------------------------------------------------------------------------------------
	//->Historico
	//----------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/reportantes/historico", method = RequestMethod.GET)
	public String showReportantesHistorico(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final UIContribuyenteForm uiContribuyenteForm = new UIContribuyenteForm();

		try
		{
			consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			if (sdhConsultaContribuyenteBPResponse.getRoles() != null && !sdhConsultaContribuyenteBPResponse.getRoles().isEmpty())
			{
				uiContribuyenteForm.setRoles(sdhConsultaContribuyenteBPResponse.getRoles());
			}

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(REPORTANTES_HISTORICO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REPORTANTES_HISTORICO_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_HISTORICO_VALUE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("uiContribuyenteForm", uiContribuyenteForm);

		return getViewForPage(model);

	}


	//----------------------------------------------------------------------------------------------------------------------
	//->Sanciones
	//----------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/reportantes/sanciones", method = RequestMethod.GET)
	public String showReportantesSanciones(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final UIContribuyenteForm uiContribuyenteForm = new UIContribuyenteForm();

		try
		{
			consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			if (sdhConsultaContribuyenteBPResponse.getRoles() != null && !sdhConsultaContribuyenteBPResponse.getRoles().isEmpty())
			{
				uiContribuyenteForm.setRoles(sdhConsultaContribuyenteBPResponse.getRoles());
			}

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(REPORTANTES_SANCIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REPORTANTES_SANCIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_SANCIONES_VALUE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("uiContribuyenteForm", uiContribuyenteForm);

		return getViewForPage(model);

	}



}
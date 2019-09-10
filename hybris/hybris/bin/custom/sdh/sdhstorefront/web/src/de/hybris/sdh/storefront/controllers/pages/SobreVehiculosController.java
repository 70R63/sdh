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
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.facades.SDHEnviaFirmasFacade;
import de.hybris.sdh.storefront.forms.VehiculosInfObjetoForm;

import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */
@Controller
public class SobreVehiculosController extends AbstractPageController
{

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.vehiculos";
	private static final String DECLARACION_VEHICULOS_PROFILE = "Sobre Vehículos Declaración";
	private static final String DECLARACION_MOTOS_PROFILE = "Sobre Vehículos Declaración Motos";

	// CMS Pages
	private static final String SOBRE_VEHICULOS_CMS_PAGE = "sobreVehiculosAutomotoresPage";
	private static final String DECLRACION_VEHICULOS_CMS_PAGE = "sobreVehiculosDeclaracionPage";
	private static final String DECLARCION_MOTOS_CMS_PAGE = "sobreVehiculosMotosDeclaracionPage";

	private static final String REDIRECT_TO_SOBRE_VEHICULOS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/sobrevehiculosautomotores/detalle";
	private static final String REDIRECT_TO_DECLARACION_VEHICULOS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/sobrevehiculosautomotores/declaracion";
	private static final String REDIRECT_TO_DECLARACION_MOTOS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/sobrevehiculosautomotores/declaracion/motos";


	@Resource(name = "sdhEnviaFirmasFacade")
	SDHEnviaFirmasFacade sdhEnviaFirmasFacade;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "modelService")
	ModelService modelService;

	@Resource(name = "mediaService")
	MediaService mediaService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/detalle", method = RequestMethod.GET)
	@RequireHardLogIn
	public String sobrevehiculosdetalle(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro Sobre Vehiculos detalle --------------------------");

		//		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();



		final VehiculosInfObjetoForm vehiculosForm = new VehiculosInfObjetoForm();
		if (customerModel.getNumBP() != null)
		{
			consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());
			vehiculosForm.setNumBP(customerModel.getNumBP());
			vehiculosForm.setTipiden(customerModel.getDocumentType());
			vehiculosForm.setNumide(customerModel.getDocumentNumber());
			vehiculosForm.setName(customerModel.getFirstName() + " " + customerModel.getLastName());

			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
						sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
						SDHValidaMailRolResponse.class);

				if (sdhConsultaContribuyenteBPResponse.getVehicular() != null
						&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getVehicular()))
				{
					vehiculosForm.setImpvehicular(sdhConsultaContribuyenteBPResponse.getVehicular().stream()
							.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
				}

			}
			catch (final Exception e)
			{
				// XXX Auto-generated catch block
				//				LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
				//				GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			}

		}
		else
		{
			vehiculosForm.setNumBP("vacio");
		}


		model.addAttribute("vehiculosForm", vehiculosForm);


		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/detalle", method = RequestMethod.POST)
	@RequireHardLogIn
	public String sobrevehiculosdetallepost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de sobre vehiculos------------------------");

		return REDIRECT_TO_SOBRE_VEHICULOS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String sobrevehiculosdeclaracion(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro declaracion sobrevehiculos --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLRACION_VEHICULOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLRACION_VEHICULOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(DECLARACION_VEHICULOS_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String sobrevehiculosdeclaracionpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de declaracion sobrevehiculos------------------------");

		return REDIRECT_TO_DECLARACION_VEHICULOS_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/declaracion/motos", method = RequestMethod.GET)
	@RequireHardLogIn
	public String sobrevehiculosdeclaracionmotos(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro declaracion sobrevehiculos --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARCION_MOTOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARCION_MOTOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(DECLARACION_MOTOS_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/sobrevehiculosautomotores/declaracion/motos", method = RequestMethod.POST)
	@RequireHardLogIn
	public String sobrevehiculosdeclaracionpostmotos(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------entro al post de declaracion sobrevehiculos------------------------");

		return REDIRECT_TO_DECLARACION_MOTOS_PAGE;
	}

}
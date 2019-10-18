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
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleVehiculosRequest;
import de.hybris.sdh.core.pojos.responses.DetalleVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleVehiculosService;
import de.hybris.sdh.facades.SDHEnviaFirmasFacade;
import de.hybris.sdh.storefront.forms.VehiculosInfObjetoForm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/contribuyentes/sobrevehiculosautomotores/declaracion")
public class SobreVehiculosDeclaracionController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(SobreVehiculosDeclaracionController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String DECLARACION_VEHICULOS_PROFILE = "Sobre Vehículos Declaración";
	private static final String DECLARACION_MOTOS_PROFILE = "Sobre Vehículos Declaración Motos";

	// CMS Pages
	private static final String DECLRACION_VEHICULOS_CMS_PAGE = "sobreVehiculosDeclaracionPage";
	private static final String DECLARCION_MOTOS_CMS_PAGE = "sobreVehiculosMotosDeclaracionPage";


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

	@Resource(name = "sdhDetalleVehiculosService")
	SDHDetalleVehiculosService sdhDetalleVehiculosService;

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

	@RequireHardLogIn
	@RequestMapping(method = RequestMethod.GET)
	public String sobrevehiculosdecla(final Model model, @RequestParam(required = true, value = "anioGravable")
	final String anioGravable, @RequestParam(required = true, value = "placa")
	final String placa, @RequestParam(required = true, value = "numBPP")
	final String numBPP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro Sobre Vehiculos declaracion --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		//        addAgentsToModel(model, customerData,null);
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		consultaContribuyenteBPRequest.setNumBP(numBPP);
		final VehiculosInfObjetoForm vehiculosFormDeclaracion = new VehiculosInfObjetoForm();
		final DetalleVehiculosRequest detalleVehiculosRequest = new DetalleVehiculosRequest();
		detalleVehiculosRequest.setBpNum(numBPP);
		detalleVehiculosRequest.setPlaca(placa);
		detalleVehiculosRequest.setAnioGravable(anioGravable);


		try
		{

			vehiculosFormDeclaracion.setNumBP(numBPP);
			vehiculosFormDeclaracion.setAnioGravable(anioGravable);
			vehiculosFormDeclaracion.setPlaca(placa);

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetalleVehiculosResponse detalleVehiculosResponse = mapper
					.readValue(sdhDetalleVehiculosService.detalleVehiculos(detalleVehiculosRequest), DetalleVehiculosResponse.class);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			vehiculosFormDeclaracion.setOpcionUso(detalleVehiculosResponse.getInfo_declara().getInfoVeh().getOpcionUso());
			vehiculosFormDeclaracion.setCapacidadTon(detalleVehiculosResponse.getDetalle().getCapacidadTon());
			vehiculosFormDeclaracion.setTipoVeh(detalleVehiculosResponse.getDetalle().getTipoVeh());
			vehiculosFormDeclaracion.setCapacidadPas(detalleVehiculosResponse.getDetalle().getCapacidadPas());
			vehiculosFormDeclaracion.setIdServicio(detalleVehiculosResponse.getDetalle().getIdServicio());
			vehiculosFormDeclaracion.setWatts(detalleVehiculosResponse.getDetalle().getWatts());
			vehiculosFormDeclaracion.setClasicoAntig(detalleVehiculosResponse.getDetalle().getClasicoAntig());

			if (sdhConsultaContribuyenteBPResponse.getVehicular() != null
					&& !sdhConsultaContribuyenteBPResponse.getVehicular().isEmpty())
			{

				for (final ImpuestoVehiculos eachVehResponse : sdhConsultaContribuyenteBPResponse.getVehicular())
				{

					if (placa.equals(eachVehResponse.getPlaca()))
					{
						vehiculosFormDeclaracion.setClase(eachVehResponse.getClase());
						vehiculosFormDeclaracion.setCarroceria(eachVehResponse.getCarroceria());
						vehiculosFormDeclaracion.setMarca(eachVehResponse.getMarca());
						vehiculosFormDeclaracion.setCilindraje(eachVehResponse.getCilindraje());
						vehiculosFormDeclaracion.setLinea(eachVehResponse.getLinea());
						vehiculosFormDeclaracion.setModelo(eachVehResponse.getModelo());
						vehiculosFormDeclaracion.setBlindado(eachVehResponse.getBlindado());
						break;
					}
					else
					{
						vehiculosFormDeclaracion.setClase("no exisye clase");
					}
					break;
				}
			}



		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("Error en la respuesta del servicio detalle de Vehiculos " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}


		model.addAttribute("vehiculosFormDeclaracion", vehiculosFormDeclaracion);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLRACION_VEHICULOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLRACION_VEHICULOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(DECLARACION_VEHICULOS_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


}
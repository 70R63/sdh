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
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleVehiculosRequest;
import de.hybris.sdh.core.pojos.responses.DetalleVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.JuridicosVehiculos;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleVehiculosService;
import de.hybris.sdh.facades.SDHEnviaFirmasFacade;
import de.hybris.sdh.storefront.forms.VehiculosInfObjetoForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/contribuyentes/sobrevehiculosautomotores/detalle")
public class SobreVehiculosController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(SobreVehiculosController.class);

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

	@Resource(name = "sdhDetalleVehiculosService")
	SDHDetalleVehiculosService sdhDetalleVehiculosService;

	@RequestMapping(method = RequestMethod.GET)
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

	@RequestMapping(value = "/vehiculo", method = RequestMethod.GET)
	@ResponseBody
	public VehiculosInfObjetoForm vehiculosDetail(@ModelAttribute("vehiculoInfo")
	final VehiculosInfObjetoForm vehiculoInfo, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		System.out.println("---------------- Hola entro Sobre Vehiculos detalle del vehiculo --------------------------");

		final VehiculosInfObjetoForm vehiculosForm = new VehiculosInfObjetoForm();


		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final DetalleVehiculosRequest detalleVehiculosRequest = new DetalleVehiculosRequest();
		detalleVehiculosRequest.setBpNum(vehiculoInfo.getBpNum());
		detalleVehiculosRequest.setPlaca(vehiculoInfo.getPlaca());
		detalleVehiculosRequest.setAnioGravable(vehiculoInfo.getAnioGravable());


		try
		{
			vehiculosForm.setPlaca(vehiculoInfo.getPlaca());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetalleVehiculosResponse detalleVehiculosResponse = mapper
					.readValue(sdhDetalleVehiculosService.detalleVehiculos(detalleVehiculosRequest), DetalleVehiculosResponse.class);

			vehiculosForm.setDetalle(detalleVehiculosResponse.getDetalle());

			vehiculosForm.setIdServicio(detalleVehiculosResponse.getDetalle().getIdServicio());
			vehiculosForm.setIdEstado(detalleVehiculosResponse.getDetalle().getIdEstado());
			vehiculosForm.setWatts(detalleVehiculosResponse.getDetalle().getWatts());
			vehiculosForm.setClasicoAntig(detalleVehiculosResponse.getDetalle().getClasicoAntig());
			vehiculosForm.setTipoVeh(detalleVehiculosResponse.getDetalle().getTipoVeh());
			vehiculosForm.setCapacidadPas(detalleVehiculosResponse.getDetalle().getCapacidadPas());
			vehiculosForm.setCapacidadTon(detalleVehiculosResponse.getDetalle().getCapacidadTon());

			//			vehiculosForm.setFechaCambio(detalleVehiculosResponse.getDetalle().getFechaCambio());
			final String FechaCambio = detalleVehiculosResponse.getDetalle().getFechaCambio();
			if (StringUtils.isNotBlank(FechaCambio) && !"00000000".equals(FechaCambio))
			{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(FechaCambio, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				vehiculosForm.setFechaCambio(localDate.format(formatter2));
			}

			if (detalleVehiculosResponse.getDatosJuridicos() != null && !detalleVehiculosResponse.getDatosJuridicos().isEmpty())
			{

				for (final JuridicosVehiculos eachDetalleJur : detalleVehiculosResponse.getDatosJuridicos())
				{
					vehiculosForm.setTipoID(eachDetalleJur.getTipoID());
					vehiculosForm.setNombre(eachDetalleJur.getNombre());
					vehiculosForm.setNumID(eachDetalleJur.getNumID());
					vehiculosForm.setCalidad(eachDetalleJur.getCalidad());
					vehiculosForm.setProcProp(eachDetalleJur.getProcProp());

					//								vehiculosForm.setFechaDesde(eachDetalleJur.getFechaDesde());
					final String FechaDesde = eachDetalleJur.getFechaDesde();
					if (StringUtils.isNotBlank(FechaDesde) && !"00000000".equals(FechaDesde))
					{
						final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

						final LocalDate localDate = LocalDate.parse(FechaDesde, formatter);

						final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

						vehiculosForm.setFechaDesde(localDate.format(formatter2));
					}

					//					vehiculosForm.setFechaHasta(eachDetalleJur.getFechaHasta());
					final String FechaHasta = eachDetalleJur.getFechaHasta();
					if (StringUtils.isNotBlank(FechaHasta) && !"00000000".equals(FechaHasta))
					{
						final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

						final LocalDate localDate = LocalDate.parse(FechaHasta, formatter);

						final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

						vehiculosForm.setFechaHasta(localDate.format(formatter2));
					}

					break;
				}

			}

			vehiculosForm.setDatosJuridicos(detalleVehiculosResponse.getDatosJuridicos().stream()
					.filter(eachDetJur -> StringUtils.isNotBlank(eachDetJur.getCalidad())).collect(Collectors.toList()));

			vehiculosForm.setMarcas(detalleVehiculosResponse.getMarcas().stream()
					.filter(eachDetMarcas -> StringUtils.isNotBlank(eachDetMarcas.getCodigoMarca())).collect(Collectors.toList()));

			vehiculosForm.setLiquidacion(detalleVehiculosResponse.getLiquidacion().stream()
					.filter(eachDetLiq -> StringUtils.isNotBlank(eachDetLiq.getAnio())).collect(Collectors.toList()));
		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("Error en la respuesta del servicio detalle de Vehiculos " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}
		model.addAttribute("vehiculosForm", vehiculosForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CMS_PAGE));

		return vehiculosForm;
	}

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}


}
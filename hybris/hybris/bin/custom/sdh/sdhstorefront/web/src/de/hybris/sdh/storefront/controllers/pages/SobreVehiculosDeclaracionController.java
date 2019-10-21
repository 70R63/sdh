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
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.pojos.requests.CalcVehiculosRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleVehiculosRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.responses.CalcVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.DetalleVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCalVehiculosService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleVehiculosService;
import de.hybris.sdh.facades.SDHEnviaFirmasFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.VehiculosInfObjetoForm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/contribuyentes/sobrevehiculosautomotores/declaracion")
public class SobreVehiculosDeclaracionController extends SDHAbstractPageController
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

	@Resource(name = "sdhCalcVehiculosService")
	SDHCalVehiculosService sdhCalcVehiculosService;

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

	@RequireHardLogIn
	@RequestMapping(method = RequestMethod.GET)
	public String sobrevehiculosdecla(final Model model, @RequestParam(required = true, value = "anioGravable")
	final String anioGravable, @RequestParam(required = true, value = "placa")
	final String placa, @RequestParam(required = false, value = "numForma")
	final String numForma, @RequestParam(required = true, value = "numBPP")
	final String numBPP, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro Sobre Vehiculos declaracion --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
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
			vehiculosFormDeclaracion.setNumForm(numForma);

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
						if (vehiculosFormDeclaracion.getNumForm() != null && !vehiculosFormDeclaracion.getNumForm().isEmpty())
						{

								String formas = "";
							formas = detalleVehiculosResponse.getInfo_declara().getInfoVeh().getNumForm();
							vehiculosFormDeclaracion
									.setImpuestoCargo(detalleVehiculosResponse.getInfo_declara().getInfoVeh().getNumForm());
								if (formas.equals(numForma))
								{
									vehiculosFormDeclaracion.setInfoVeh(detalleVehiculosResponse.getInfo_declara().getInfoVeh());
									//									vehiculosFormDeclaracion
									//											.setLiquidaciondeclara(detalleVehiculosResponse.getInfo_declara().getLiquidacion());
									vehiculosFormDeclaracion.setNumForm(formas);
									vehiculosFormDeclaracion.setImpuestoCargo(
											detalleVehiculosResponse.getInfo_declara().getLiquidacion().getImpuestoCargo());
									vehiculosFormDeclaracion
											.setTarifaActual(detalleVehiculosResponse.getInfo_declara().getLiquidacion().getTarifaActual());
									vehiculosFormDeclaracion
											.setSancion(detalleVehiculosResponse.getInfo_declara().getLiquidacion().getSancion());
									vehiculosFormDeclaracion
											.setIntereses(detalleVehiculosResponse.getInfo_declara().getLiquidacion().getIntereses());
									vehiculosFormDeclaracion
											.setValorSemafor(detalleVehiculosResponse.getInfo_declara().getLiquidacion().getValorSemafo());
									vehiculosFormDeclaracion.setDescuentoProntop(
											detalleVehiculosResponse.getInfo_declara().getLiquidacion().getDescProntoPago());
									vehiculosFormDeclaracion
											.setTotalPagar(detalleVehiculosResponse.getInfo_declara().getLiquidacion().getTotalPagar());
									vehiculosFormDeclaracion
											.setValorPagar(detalleVehiculosResponse.getInfo_declara().getLiquidacion().getValorPagar());
									vehiculosFormDeclaracion.setTotalPagoVol(
											detalleVehiculosResponse.getInfo_declara().getLiquidacion().getTotalPagoVolunt());

								}
						}
						else
						{
							break;
						}

						break;
					}
					else
					{
						vehiculosFormDeclaracion.setClase("No existe Placa");
					}

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

		//informacion para PSE
		final String numBP = numBPP;
		final String anoParaPSE = anioGravable;
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();
		final String mensajeError = "";
		String[] mensajesError;


		contribuyenteRequest.setNumBP(numBP);

		System.out.println("Request de validaCont: " + contribuyenteRequest);
		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		System.out.println("Response de validaCont: " + detalleContribuyente);
		if (gasolinaService.ocurrioErrorValcont(detalleContribuyente) != true)
		{
			infoPreviaPSE.setAnoGravable(anoParaPSE);
			infoPreviaPSE.setTipoDoc(customerData.getDocumentType());
			infoPreviaPSE.setNumDoc(customerData.getDocumentNumber());
			infoPreviaPSE.setNumBP(numBP);
			infoPreviaPSE.setClavePeriodo(gasolinaService.prepararPeriodoAnualPago(anoParaPSE));
			infoPreviaPSE.setNumObjeto(gasolinaService.prepararNumObjetoVehicular(detalleContribuyente, placa));
			infoPreviaPSE.setDv(gasolinaService.prepararDV(detalleContribuyente));
			infoPreviaPSE.setTipoImpuesto(new ControllerPseConstants().getVEHICULAR());
		}
		else
		{
			LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(
					gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error2", mensajesError);
		}
		model.addAttribute("infoPreviaPSE", infoPreviaPSE);
		//informacion para PSE


		return getViewForPage(model);
	}

	@RequestMapping(value = "/calculo", method = RequestMethod.POST)
	@ResponseBody
	public CalcVehiculosResponse calculo(@ModelAttribute("vehiculosFormDeclaracion")
	final VehiculosInfObjetoForm dataForm) throws CMSItemNotFoundException
	{
		CalcVehiculosResponse calcVehiculosResponse = new CalcVehiculosResponse();

		//		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final CalcVehiculosRequest calcVehiculosRequest = new CalcVehiculosRequest();

		//		calcVehiculosRequest.setBpNum("0000062009");
		//		calcVehiculosRequest.setPlaca("BDM080");
		//		calcVehiculosRequest.setNumForm("020000000613");
		//		calcVehiculosRequest.setAnioGravable("2016");
		//		calcVehiculosRequest.setOpcionUso("01");
		//		calcVehiculosRequest.setClase("001");
		//		calcVehiculosRequest.setIdServicio("01");
		//		calcVehiculosRequest.setCilindraje("2587");
		//		calcVehiculosRequest.setMarca("000025");
		//		calcVehiculosRequest.setLinea("3928");
		//		calcVehiculosRequest.setModelo("1992");
		//		calcVehiculosRequest.setClasicoAntiguo("1");
		//		calcVehiculosRequest.setCheckAporte("X");
		//		calcVehiculosRequest.setProyectoAporte("PROYECTO");
		//		calcVehiculosRequest.setBlindado("X");
		//		calcVehiculosRequest.setCapacidadTon("0.00");
		//		calcVehiculosRequest.setCapacidadPas("5");
		//		calcVehiculosRequest.setAvaluo("");
		//		calcVehiculosRequest.setClaseSdh("");
		//		calcVehiculosRequest.setTipoVehSdh("");
		//		calcVehiculosRequest.setLineaHomologa("");
		//		calcVehiculosRequest.setFuenteHomologa("");

		calcVehiculosRequest.setBpNum(dataForm.getBpNum());
		calcVehiculosRequest.setPlaca(dataForm.getPlaca());
		calcVehiculosRequest.setNumForm(dataForm.getNumForm());
		calcVehiculosRequest.setAnioGravable(dataForm.getAnioGravable());
		calcVehiculosRequest.setOpcionUso(dataForm.getOpcionUso());
		calcVehiculosRequest.setClase(dataForm.getClase());
		calcVehiculosRequest.setIdServicio(dataForm.getIdServicio());
		calcVehiculosRequest.setCilindraje(dataForm.getCilindraje());
		calcVehiculosRequest.setMarca(dataForm.getMarca());
		calcVehiculosRequest.setLinea(dataForm.getLinea());
		calcVehiculosRequest.setModelo(dataForm.getModelo());
		calcVehiculosRequest.setClasicoAntiguo(dataForm.getClasicoAntiguo());
		calcVehiculosRequest.setCheckAporte(dataForm.getCheckAporte());
		calcVehiculosRequest.setProyectoAporte(dataForm.getProyectoAporte());
		calcVehiculosRequest.setBlindado(dataForm.getBlindado());
		calcVehiculosRequest.setCapacidadTon(dataForm.getCapacidadTon());
		calcVehiculosRequest.setCapacidadPas(dataForm.getCapacidadPas());
		calcVehiculosRequest.setAvaluo(dataForm.getAvaluo());
		calcVehiculosRequest.setClaseSdh(dataForm.getClaseSdh());
		calcVehiculosRequest.setTipoVehSdh(dataForm.getTipoVehSdh());
		calcVehiculosRequest.setLineaHomologa(dataForm.getLineaHomologa());
		calcVehiculosRequest.setFuenteHomologa(dataForm.getFuenteHomologa());

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			calcVehiculosResponse = mapper.readValue(sdhCalcVehiculosService.calcVehiculos(calcVehiculosRequest),
					CalcVehiculosResponse.class);

			final VehiculosInfObjetoForm vehiculosFormDeclaracion = new VehiculosInfObjetoForm();

			vehiculosFormDeclaracion.setNumForm(calcVehiculosResponse.getNumForm());
			vehiculosFormDeclaracion.setImpuestoCargo(calcVehiculosResponse.getImpuestoCargo());
			vehiculosFormDeclaracion.setTarifaActual(calcVehiculosResponse.getTarifaActual());
			vehiculosFormDeclaracion.setSancion(calcVehiculosResponse.getSancion());
			vehiculosFormDeclaracion.setIntereses(calcVehiculosResponse.getIntereses());
			vehiculosFormDeclaracion.setValorSemafor(calcVehiculosResponse.getValorSemafor());
			vehiculosFormDeclaracion.setDescuentoProntop(calcVehiculosResponse.getDescuentoProntop());
			vehiculosFormDeclaracion.setTotalPagar(calcVehiculosResponse.getTotalPagar());
			vehiculosFormDeclaracion.setValorPagar(calcVehiculosResponse.getValorPagar());
			vehiculosFormDeclaracion.setTotalPagoVol(calcVehiculosResponse.getTotalPagoVol());
		}




		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());

			final ErrorPubli error = new ErrorPubli();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error al realizar el cálculo, por favor intentalo más tarde");

			final List<ErrorPubli> errores = new ArrayList<ErrorPubli>();

			errores.add(error);

			calcVehiculosResponse.setErrores(errores);

		}


		return calcVehiculosResponse;

	}


}
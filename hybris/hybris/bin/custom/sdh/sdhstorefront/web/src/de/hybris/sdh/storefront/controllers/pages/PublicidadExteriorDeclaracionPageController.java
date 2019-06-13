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
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.pojos.requests.CalcPublicidadRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePublicidadRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.responses.CalcPublicidadResponse;
import de.hybris.sdh.core.pojos.responses.DetallePubli;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCalPublicidadService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHDetallePublicidadService;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.DeclaPublicidadController;
import de.hybris.sdh.storefront.forms.GeneraDeclaracionForm;
import de.hybris.sdh.storefront.forms.PublicidadForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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

import sun.misc.BASE64Decoder;


/**
 * Controller for home page 2
 */
@Controller
@RequestMapping("/contribuyentes/publicidadexterior/declaracion")
public class PublicidadExteriorDeclaracionPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(PublicidadExteriorPageController.class);


	private static final String PUBLICIDAD_EXTERIOR_CMS_PAGE = "PublicidadExteriorPage";
	private static final String REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/publicidadexterior/declaracion";
	private static final String REDIRECT_TO_DETALLE_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes2/publicidadexterior/detalle";
	private static final String DECLARACIONES_PAGAR_CMS_PAGE = "preparacion-PagarPSE";
	private static final String REDIRECT_TO_DECLARACIONES_PAGAR_PAGE = REDIRECT_PREFIX + "/impuestos/preparacion-PagarPSE";

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhDetallePublicidadService")
	SDHDetallePublicidadService sdhDetallePublicidadService;

	@Resource(name = "sdhCalPublicidadService")
	SDHCalPublicidadService sdhCalPublicidadService;

	@Resource(name = "sdhGeneraDeclaracionService")
	SDHGeneraDeclaracionService sdhGeneraDeclaracionService;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;


	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.declarapublicidad";

	//CMS PAGES
	private static final String DECLARACION_PUBLICIDAD_CMS_PAGE = "DeclaraPublicidadPage";


	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showView(final Model model, @RequestParam(required = true, value = "numResolu")
	final String numResolu, @RequestParam(required = true, value = "anoGravable")
	final String anoGravable, @RequestParam(required = true, value = "tipoValla")
	final String tipoValla, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		String anoParaPSE = "";
		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();
		final String numBP = customerData.getNumBP();
		detallePublicidadRequest.setNumBP(numBP);
		detallePublicidadRequest.setNumResolu(numResolu);
		detallePublicidadRequest.setAnoGravable(anoGravable);
		detallePublicidadRequest.setTipoValla(tipoValla);

		try
		{
			final PublicidadForm publicidadForm = new PublicidadForm();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePublicidadResponse detallePublicidadResponse = mapper.readValue(
					sdhDetallePublicidadService.detallePublicidad(detallePublicidadRequest), DetallePublicidadResponse.class);

			anoParaPSE = detallePublicidadResponse.getAnoGravable();
			final DeclaPublicidadController declaPublicidadForm = new DeclaPublicidadController();
			declaPublicidadForm.setTipoValla(tipoValla);
			declaPublicidadForm.setIdNumber(customerData.getDocumentNumber());
			declaPublicidadForm.setIdType(customerData.getDocumentType());
			declaPublicidadForm.setName(customerData.getCompleteName());
			declaPublicidadForm.setCatalogos(new PublicidadExteriorServicios().prepararCatalogos());
			declaPublicidadForm.setNumBP(customerData.getNumBP());
			declaPublicidadForm.setAnograv(detallePublicidadResponse.getAnoGravable());
			declaPublicidadForm.setNumform(detallePublicidadResponse.getInfoDeclara().getNumForm());
			declaPublicidadForm.setNumresol(detallePublicidadResponse.getNumResolu());
			declaPublicidadForm.setFecresol(detallePublicidadResponse.getFechResolu());
			final String fechnotif = detallePublicidadResponse.getFechNotif();
			if (StringUtils.isNotBlank(fechnotif) && !"00000000".equals(fechnotif))
			{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(fechnotif, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				declaPublicidadForm.setFechnotif(localDate.format(formatter2));
			}


			declaPublicidadForm.setOrValla(detallePublicidadResponse.getInfoDeclara().getOrientacionValla());

			declaPublicidadForm.setLuginst(detallePublicidadResponse.getInfoDeclara().getLugarInstala());
			declaPublicidadForm.setBasegrav(detallePublicidadResponse.getInfoDeclara().getTamanoValla());
			declaPublicidadForm.setOpuso(detallePublicidadResponse.getInfoDeclara().getOpcionUso());
			declaPublicidadForm.setImpCar(detallePublicidadResponse.getInfoDeclara().getImpCargo());
			declaPublicidadForm.setValsan(detallePublicidadResponse.getInfoDeclara().getVlrSancion());
			declaPublicidadForm.setValpag(detallePublicidadResponse.getInfoDeclara().getVlrPagar());
			declaPublicidadForm.setIntmora(detallePublicidadResponse.getInfoDeclara().getInteresMora());
			declaPublicidadForm.setTotpag(detallePublicidadResponse.getInfoDeclara().getTotalPagar());
			declaPublicidadForm.setRefe(detallePublicidadResponse.getInfoDeclara().getReferencia());
			declaPublicidadForm.setVigenDesde(detallePublicidadResponse.getVigenDesde());
			declaPublicidadForm.setVigenHasta(detallePublicidadResponse.getVigenHasta());
			declaPublicidadForm.setDetalle(detallePublicidadResponse.getDetalle());

			//TODO: this has to change once we have logic for agents.
			declaPublicidadForm.setIdDeclarante(customerData.getDocumentNumber());
			declaPublicidadForm.setTipoIDdeclara(customerData.getDocumentType());
			if (detallePublicidadResponse.getDetalle() != null && !detallePublicidadResponse.getDetalle().isEmpty())
			{

				for (final DetallePubli eachDetalle : detallePublicidadResponse.getDetalle())
				{
					declaPublicidadForm.setPlaca(eachDetalle.getPlaca());
					declaPublicidadForm.setDireccion(eachDetalle.getDireccion());
					break;
				}

			}
			declaPublicidadForm.setCatalogos(new PublicidadExteriorServicios().prepararCatalogos());
			model.addAttribute("declaPublicidadForm", declaPublicidadForm);

		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		//informacion para PSE

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
			infoPreviaPSE.setNumObjeto(gasolinaService.prepararNumObjetoPublicidad(detalleContribuyente, numResolu));
			infoPreviaPSE.setDv(gasolinaService.prepararDV(detalleContribuyente));
			infoPreviaPSE.setTipoImpuesto(new ControllerPseConstants().getPUBLICIDAD());
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


		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		//updatePageTitle(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE)); */

		return getViewForPage(model);

	}


	@RequestMapping(value = "/calculo", method = RequestMethod.POST)
	@ResponseBody
	public CalcPublicidadResponse calculo(@ModelAttribute("declaPublicidadForm")
	final DeclaPublicidadController dataForm) throws CMSItemNotFoundException
	{
		CalcPublicidadResponse calcPublicidadResponse = new CalcPublicidadResponse();

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final CalcPublicidadRequest calcPublicidadRequest = new CalcPublicidadRequest();


		calcPublicidadRequest.setNumBP(customerData.getNumBP());
		calcPublicidadRequest.setNumResolu(dataForm.getNumresol());
		calcPublicidadRequest.setNumForm(dataForm.getNumform());
		calcPublicidadRequest.setAnoGravable(dataForm.getAnograv());
		calcPublicidadRequest.setOpcionUso(dataForm.getOpuso());

		if (dataForm.getFechnotif() != null)
		{
			final DateTimeFormatter clientFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			final LocalDate localDate = LocalDate.parse(dataForm.getFechnotif(), clientFormat);

			final DateTimeFormatter sapFormat = DateTimeFormatter.ofPattern("yyyyMMdd");

			calcPublicidadRequest.setFechNotif(localDate.format(sapFormat));

		}



		calcPublicidadRequest.setLugarInstala(dataForm.getLuginst());
		calcPublicidadRequest.setDireccion(dataForm.getDireccion());
		calcPublicidadRequest.setPlaca(dataForm.getPlaca());
		calcPublicidadRequest.setOrientacionValla(dataForm.getOrValla());
		calcPublicidadRequest.setTamanoValla(dataForm.getTamValla());
		calcPublicidadRequest.setTipoIDcontrib(customerData.getDocumentType());
		calcPublicidadRequest.setIDcontrib(customerData.getDocumentNumber());
		calcPublicidadRequest.setMunicipioContrib(dataForm.getMunicipioContrib());
		calcPublicidadRequest.setTipoIDdeclara(dataForm.getTipoIDdeclara());
		calcPublicidadRequest.setIDdeclarante(dataForm.getIdDeclarante());
		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			calcPublicidadResponse = mapper.readValue(sdhCalPublicidadService.calcPublicidad(calcPublicidadRequest),
					CalcPublicidadResponse.class);

			final DeclaPublicidadController declaPublicidadForm = new DeclaPublicidadController();

			declaPublicidadForm.setNumform(calcPublicidadResponse.getNumForm());
			declaPublicidadForm.setImpCar(calcPublicidadResponse.getImpCargo());
			declaPublicidadForm.setValsan(calcPublicidadResponse.getVlrSancion());
			declaPublicidadForm.setValpag(calcPublicidadResponse.getVlrPagar());
			declaPublicidadForm.setIntmora(calcPublicidadResponse.getInteresMora());
			declaPublicidadForm.setTotpag(calcPublicidadResponse.getTotalPagar());

		}


		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());

			final ErrorPubli error = new ErrorPubli();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error al realizar el cálculo, por favor intentalo más tarde");

			final List<ErrorPubli> errores = new ArrayList<ErrorPubli>();

			errores.add(error);

			calcPublicidadResponse.setErrores(errores);

		}


		return calcPublicidadResponse;

	}

	@RequestMapping(value = "/generar", method = RequestMethod.POST)
	@ResponseBody
	public GeneraDeclaracionResponse generar(final GeneraDeclaracionForm dataForm, final HttpServletResponse response,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		GeneraDeclaracionResponse generaDeclaracionResponse = new GeneraDeclaracionResponse();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		String numForm = request.getParameter("numForm");

		if (StringUtils.isBlank(numForm))
		{
			numForm = dataForm.getNumForm();
		}

		final GeneraDeclaracionRequest generaDeclaracionRequest = new GeneraDeclaracionRequest();


		generaDeclaracionRequest.setNumForm(numForm);

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			generaDeclaracionResponse = mapper.readValue(sdhGeneraDeclaracionService.generaDeclaracion(generaDeclaracionRequest),
					GeneraDeclaracionResponse.class);

			if (generaDeclaracionResponse != null && generaDeclaracionResponse.getStringPDF() != null)
			{
				final String encodedBytes = generaDeclaracionResponse.getStringPDF();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = numForm + "-" + customerData.getNumBP() + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE.booleanValue());
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				generaDeclaracionResponse.setUrlDownload(mediaModel.getDownloadURL());


			}

		}
		catch (final Exception e)
		{
			LOG.error("error generating declaration : " + e.getMessage());

			final ErrorPubli error = new ErrorPubli();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error al generar la declaración, por favor intentalo más tarde");

			final List<ErrorPubli> errores = new ArrayList<ErrorPubli>();

			errores.add(error);

			generaDeclaracionResponse.setErrores(errores);

		}

		return generaDeclaracionResponse;

	}

}
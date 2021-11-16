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
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePublicidadRequest;
import de.hybris.sdh.core.pojos.responses.DetallePubli;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCalPublicidadService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHDetallePublicidadService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.PublicidadForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Controller for home page 2
 */
@Controller
@RequestMapping("/contribuyentes/publicidadexterior")
public class PublicidadExteriorPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(PublicidadExteriorPageController.class);


	private static final String PUBLICIDAD_EXTERIOR_CMS_PAGE = "PublicidadExteriorPage";
	private static final String REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/publicidadexterior/declaracion";
	private static final String REDIRECT_TO_DETALLE_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes2/publicidadexterior/detalle";


	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String BREADCRUMBS_VALUE = "breadcrumb.publicidad";

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "sdhDetallePublicidadService")
	SDHDetallePublicidadService sdhDetallePublicidadService;

	@Resource(name = "sdhCalPublicidadService")
	SDHCalPublicidadService sdhCalPublicidadService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCustomerAccountService")
	SDHCustomerAccountService sdhCustomerAccountService;

	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;



	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	//CMS PAGES
	private static final String DECLARACION_PUBLICIDAD_CMS_PAGE = "DeclaraPublicidadPage";


	@RequestMapping(method = RequestMethod.GET)
	public String showView(final Model model) throws CMSItemNotFoundException
	{
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final PublicidadForm publicidadForm = new PublicidadForm();
		//TODO: this call should be replace for code getting data from model
		model.addAttribute("name", customerData.getCompleteName());

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();

		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		contribuyenteRequest.setNumBP(customerData.getNumBP());

		detalleContribuyente.setPublicidadExt(sdhConsultaImpuesto_simplificado.consulta_impPublicidad(contribuyenteRequest));
//		detalleContribuyente = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "07");


		//if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
		if (detalleContribuyente.getPublicidadExt() != null && !detalleContribuyente.getPublicidadExt().isEmpty())
		{
			//final List<SDHExteriorPublicityTaxData> exteriorPublicityList = ;

			final List<ImpuestoPublicidadExterior> listImpuestoPublicdadExterior = new ArrayList<ImpuestoPublicidadExterior>();

			//for (final SDHExteriorPublicityTaxData eachPublicityTax : exteriorPublicityList)
			for (final ImpuestoPublicidadExterior eachPublicityTax : detalleContribuyente.getPublicidadExt())

			{
				final ImpuestoPublicidadExterior eachImpuestoPE = new ImpuestoPublicidadExterior();

				//eachImpuestoPE.setNumObjeto(eachPublicityTax.getObjectNumber());
				//eachImpuestoPE.setNumResolu(eachPublicityTax.getResolutionNumber());
				//eachImpuestoPE.setTipoValla(eachPublicityTax.getFenceType());
				//eachImpuestoPE.setAnoGravable(eachPublicityTax.getAnoGravable());

				eachImpuestoPE.setNumObjeto(eachPublicityTax.getNumObjeto());
				eachImpuestoPE.setNumResolu(eachPublicityTax.getNumResolu());
				eachImpuestoPE.setTipoValla(eachPublicityTax.getTipoValla());
				eachImpuestoPE.setAnoGravable(eachPublicityTax.getAnoGravable());


				if ("VALLA VEHICULOS".equalsIgnoreCase(eachPublicityTax.getNumResolu())
						|| "VALLA VEHíCULOS".equalsIgnoreCase(eachPublicityTax.getNumResolu()))
				{
					eachImpuestoPE.setTipoVallaCode("02");
				}
				else if ("Valla Tubular de Obra".equalsIgnoreCase(eachPublicityTax.getNumResolu()))
				{
					eachImpuestoPE.setTipoVallaCode("03");
				}
				else if ("Valla de Obra Convencional".equalsIgnoreCase(eachPublicityTax.getNumResolu()))
				{
					eachImpuestoPE.setTipoVallaCode("04");
				}
				else if ("Valla Tubular Comercial".equalsIgnoreCase(eachPublicityTax.getNumResolu()))
				{
					eachImpuestoPE.setTipoVallaCode("01");
				}
				else if ("Pantalla LED".equalsIgnoreCase(eachPublicityTax.getNumResolu()))
				{
					eachImpuestoPE.setTipoVallaCode("05");
				}
				listImpuestoPublicdadExterior.add(eachImpuestoPE);
			}

			publicidadForm.setPublicidadExt(listImpuestoPublicdadExterior);

		}
		else
		{
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}


		model.addAttribute("publicidadForm", publicidadForm);


		storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE));

		return getViewForPage(model);
	}


	@ModelAttribute("years")
	public List<String> getYears()
	{
		return Arrays.asList("2019", "2018", "2017", "2016");
	}




	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

	//Se anexa el mapeo de la pagina publicidadexterior
	//GRD
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	@ResponseBody
	public PublicidadForm publicidadExternaDetail(@ModelAttribute("publicidadInfo")
	final PublicidadForm publicidadInfo, final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final PublicidadForm publicidadForm = new PublicidadForm();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();
		final String numBP = customerData.getNumBP();

		//resetYearPublicidadInfo(numBP, publicidadInfo);

		detallePublicidadRequest.setNumBP(numBP);
		detallePublicidadRequest.setNumResolu(publicidadInfo.getNumResolu());
		detallePublicidadRequest.setAnoGravable(publicidadInfo.getAnoGravable());
		detallePublicidadRequest.setTipoValla(publicidadInfo.getTipoValla());
		try
		{
			final String tipovalla = publicidadInfo.getTipoValla();

			//final PublicidadForm publicidadForm = new PublicidadForm();
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String wsResponse = sdhDetallePublicidadService.detallePublicidad(detallePublicidadRequest);
			wsResponse = wsResponse.replace("\"},\"\"", "\"}");
			final DetallePublicidadResponse detallePublicidadResponse = mapper.readValue(wsResponse , DetallePublicidadResponse.class);

			//final PublicidadForm publicidadForm = new PublicidadForm();

			//publicidadForm.setTipoElemento(detallePublicidadResponse.getTipoElemento());

			//Datos Basicos

			if(detallePublicidadResponse != null) {
				publicidadForm.setErrores(detallePublicidadResponse.getErrores());
   			final String fechResolu = detallePublicidadResponse.getFechResolu();
   			publicidadForm.setOpcionUso(detallePublicidadResponse.getInfoDeclara().getOpcionUso());
   			LOG.info("setOpcionUso -> " + detallePublicidadResponse.getInfoDeclara().getOpcionUso());


   			if (StringUtils.isNotBlank(fechResolu) && !"00000000".equals(fechResolu))
   			{
   				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

   				final LocalDate localDate = LocalDate.parse(fechResolu, formatter);

   				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   				publicidadForm.setFechResolu(localDate.format(formatter2));
   			}


   			final String fechNotif = detallePublicidadResponse.getFechNotif();
   			if (StringUtils.isNotBlank(fechNotif) && !"00000000".equals(fechNotif))
   			{
   				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

   				final LocalDate localDate = LocalDate.parse(fechNotif, formatter);

   				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   				publicidadForm.setFechNotif(localDate.format(formatter2));
   			}

   			final String vigenDesde = detallePublicidadResponse.getVigenDesde();
   			if (StringUtils.isNotBlank(vigenDesde) && !"00000000".equals(vigenDesde))
   			{
   				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

   				final LocalDate localDate = LocalDate.parse(vigenDesde, formatter);

   				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   				publicidadForm.setVigenDesde(localDate.format(formatter2));
   			}
   			publicidadForm.setVigenHasta(detallePublicidadResponse.getVigenHasta());
   			final String vigenHasta = detallePublicidadResponse.getVigenDesde();
   			if (StringUtils.isNotBlank(vigenHasta) && !"00000000".equals(vigenHasta))
   			{
   				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

   				final LocalDate localDate = LocalDate.parse(vigenHasta, formatter);

   				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   				publicidadForm.setVigenHasta(localDate.format(formatter2));
   			}




   			if (detallePublicidadResponse.getDetalle() != null && !detallePublicidadResponse.getDetalle().isEmpty())
   			{

   				for (final DetallePubli eachDetalle : detallePublicidadResponse.getDetalle())
   				{

   					if ("02".equalsIgnoreCase(tipovalla) || "VALLA VEHICULOS".equalsIgnoreCase(tipovalla)
   							|| "VALLA VEHíCULOS".equalsIgnoreCase(tipovalla))
   					{

   						this.fillVallaVehiculos(publicidadForm, eachDetalle, detallePublicidadResponse);

   					}
   					else if ("03".equalsIgnoreCase(tipovalla) || "Valla Tubular de Obra".equalsIgnoreCase(tipovalla))
   					{

   						this.fillVallaTubularObra(publicidadForm, eachDetalle, detallePublicidadResponse);


   					}
   					else if ("04".equalsIgnoreCase(tipovalla) || "Valla de Obra Convencional".equalsIgnoreCase(tipovalla))
   					{

   						this.fillVallaObraConvencional(publicidadForm, eachDetalle, detallePublicidadResponse);

   					}
   					else if ("01".equalsIgnoreCase(tipovalla) || "Valla Tubular Comercial".equalsIgnoreCase(tipovalla))
   					{


   						this.fillVallaTubularComercial(publicidadForm, eachDetalle, detallePublicidadResponse);

   					}
   					else if ("05".equalsIgnoreCase(tipovalla) || "Pantalla LED".equalsIgnoreCase(tipovalla))
   					{
   						this.fillVallaLED(publicidadForm, eachDetalle, detallePublicidadResponse);


   					}
   					else
   					{
   						System.out.println("------------Algo salio mal con el mapeo------------------");
   					}

   					if (publicidadForm.getTipoServicio() == null || "-".equals(publicidadForm.getTipoServicio()))
   					{
   						publicidadForm.setTipoServicio(getMessageSource().getMessage(
   								"publicidad.exterior.vehicles.tipoServicio." + eachDetalle.getTipoServicio(), null,
   								getI18nService().getCurrentLocale()));
   					}

   					break;
   				}

   			}

			}

			model.addAttribute("publicidadForm", publicidadForm);


		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		//model.addAttribute("showDetail", true);
		//	model.addAttribute("action", request.getParameter("action"));
		//System.out.println("action: " + request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		//		return REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE;
		return publicidadForm;
	}

	/**
	 * @param numBP
	 * @param publicidadInfo
	 */
	private void resetYearPublicidadInfo(final String numBP, final PublicidadForm publicidadInfo)
	{

		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		SDHValidaMailRolResponse detalleContribuyente;
		String mensajeError = "";

		contribuyenteRequest.setNumBP(numBP);

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		System.out.println("Request para validaCont_simplificado: " + contribuyenteRequest);
		detalleContribuyente = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "07");
		//detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);

		System.out.println("Response de validaCont_simplificado: " + detalleContribuyente);
		if (gasolinaService.ocurrioErrorValcont(detalleContribuyente) != true)
		{
			for (final ImpuestoPublicidadExterior infoPublicidadWS : detalleContribuyente.getPublicidadExt())
			{
				if (infoPublicidadWS.getNumResolu().equals(publicidadInfo.getNumResolu()))
				{
					publicidadInfo.setAnoGravable(infoPublicidadWS.getAnoGravable());
					break;
				}
			}

		}
		else
		{
			mensajeError = detalleContribuyente.getTxtmsj();
			LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
		}

	}


	private void fillVallaLED(final PublicidadForm publicidadForm, final DetallePubli eachDetalle,
			final DetallePublicidadResponse detallePublicidadResponse)
	{
		publicidadForm.setDireccion(eachDetalle.getDireccion());
		publicidadForm.setLocalidad(eachDetalle.getLocalidad());
		publicidadForm.setCodPostal(eachDetalle.getCodPostal());
		publicidadForm.setChip(eachDetalle.getChip());
		publicidadForm.setAreaTotal(eachDetalle.getAreaTotal());
		publicidadForm.setMatricula(eachDetalle.getMatricula());
		publicidadForm.setAreaElemento(eachDetalle.getAreaElemento());
		publicidadForm.setTipoVallaCode("05");
		if ("01".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Edificio privado");
		}
		else if ("02".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Lote privado");
		}
		else if ("03".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Espacio público");
		}
		else
		{
			publicidadForm.setUbicacion("-");
		}

		if ("01".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Comercial");
		}
		else if ("02".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Institucional");
		}
		else if ("03".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Cultural");
		}
		else if ("04".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Política");
		}
		else if ("05".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Deportiva");
		}
		else if ("06".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Otra");
		}
		else
		{
			publicidadForm.setTipoPublici("-");
		}

		if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Oriente-Occidente");
		}
		else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Occidente-Oriente");
		}
		else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Norte-Sur");
		}
		else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Sur-Norte");
		}
		else if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Derecha");
		}
		else if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Izquierda");
		}
		else if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Ambos sentidos");
		}
		else
		{
			publicidadForm.setOrientacion("-");
		}

		if ("01".equals(detallePublicidadResponse.getTipoSolicitud()) || "1".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Registro Nuevo");
		}
		else if ("02".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "2".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Actualizacion");
		}
		else if ("03".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "3".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Prorroga");
		}
		else if ("04".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "4".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Traslado");
		}
		else
		{
			publicidadForm.setTipoSolicitud("-");
		}
	}

	private void fillVallaTubularComercial(final PublicidadForm publicidadForm, final DetallePubli eachDetalle,
			final DetallePublicidadResponse detallePublicidadResponse)
	{
		publicidadForm.setDireccion(eachDetalle.getDireccion());
		publicidadForm.setLocalidad(eachDetalle.getLocalidad());
		publicidadForm.setCodPostal(eachDetalle.getCodPostal());
		publicidadForm.setChip(eachDetalle.getChip());
		publicidadForm.setMatricula(eachDetalle.getMatricula());
		publicidadForm.setAreaElemento(eachDetalle.getAreaElemento());
		publicidadForm.setTipoVallaCode("01");
		if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Oriente-Occidente");
		}
		else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Occidente-Oriente");
		}
		else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Norte-Sur");
		}
		else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Sur-Norte");
		}
		else if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Derecha");
		}
		else if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Izquierda");
		}
		else if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Ambos sentidos");
		}
		else
		{
			publicidadForm.setOrientacion("-");
		}

		if ("01".equals(eachDetalle.getAvisoLumino()))
		{
			publicidadForm.setAvisoLumino("Si");
		}
		else if ("02".equals(eachDetalle.getAvisoLumino()))
		{
			publicidadForm.setAvisoLumino("No");
		}
		else
		{
			publicidadForm.setAvisoLumino("-");
		}


		if ("01".equals(detallePublicidadResponse.getTipoSolicitud()) || "1".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Registro Nuevo");
		}
		else if ("02".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "2".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Actualizacion");
		}
		else if ("03".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "3".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Prorroga");
		}
		else if ("04".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "4".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Traslado");
		}
		else
		{
			publicidadForm.setTipoSolicitud("-");
		}


		if ("01".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Edificio privado");
		}
		else if ("02".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Lote privado");
		}
		else if ("03".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Espacio público");
		}
		else
		{
			publicidadForm.setUbicacion("-");
		}
	}

	private void fillVallaObraConvencional(final PublicidadForm publicidadForm, final DetallePubli eachDetalle,
			final DetallePublicidadResponse detallePublicidadResponse)
	{
		publicidadForm.setAreaTotal(eachDetalle.getAreaTotal());
		publicidadForm.setDireccion(eachDetalle.getDireccion());//repetido
		publicidadForm.setLocalidad(eachDetalle.getLocalidad());//repetido
		publicidadForm.setCodPostal(eachDetalle.getCodPostal());//repetido
		publicidadForm.setChip(eachDetalle.getChip());//repetido
		publicidadForm.setMatricula(eachDetalle.getMatricula());//repetido
		publicidadForm.setAreaElemento(eachDetalle.getAreaElemento());
		publicidadForm.setTipoVallaCode("04");
		if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Oriente-Occidente");
		}
		else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Occidente-Oriente");
		}
		else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Norte-Sur");
		}
		else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Sur-Norte");
		}
		else if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Derecha");
		}
		else if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Izquierda");
		}
		else if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Ambos sentidos");
		}
		else
		{
			publicidadForm.setOrientacion("-");
		}

		if ("01".equals(eachDetalle.getAvisoLumino()))
		{
			publicidadForm.setAvisoLumino("Si");
		}
		else if ("02".equals(eachDetalle.getAvisoLumino()))
		{
			publicidadForm.setAvisoLumino("No");
		}
		else
		{
			publicidadForm.setAvisoLumino("-");
		}

		if ("01".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Edificio privado");
		}
		else if ("02".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Lote privado");
		}
		else if ("03".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Espacio público");
		}
		else
		{
			publicidadForm.setUbicacion("-");
		}

		if ("01".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Comercial");
		}
		else if ("02".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Institucional");
		}
		else
		{
			publicidadForm.setTipoPublici("-");
		}

		if ("01".equals(detallePublicidadResponse.getTipoSolicitud()) || "1".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Registro Nuevo");
		}
		else if ("02".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "2".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Actualizacion");
		}
		else if ("03".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "3".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Prorroga");
		}
		else if ("04".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "4".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Traslado");
		}
		else
		{
			publicidadForm.setTipoSolicitud("-");
		}
	}

	private void fillVallaTubularObra(final PublicidadForm publicidadForm, final DetallePubli eachDetalle,
			final DetallePublicidadResponse detallePublicidadResponse)
	{
		publicidadForm.setDireccion(eachDetalle.getDireccion());
		publicidadForm.setLocalidad(eachDetalle.getLocalidad());
		publicidadForm.setCodPostal(eachDetalle.getCodPostal());
		publicidadForm.setChip(eachDetalle.getChip());
		publicidadForm.setMatricula(eachDetalle.getMatricula());
		publicidadForm.setTipoVallaCode("03");

		if ("01".equals(detallePublicidadResponse.getTipoSolicitud()) || "1".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Registro Nuevo");
		}
		else if ("02".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "2".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Actualizacion");
		}
		else if ("03".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "3".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Prorroga");
		}
		else if ("04".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "4".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Traslado");
		}
		else
		{
			publicidadForm.setTipoSolicitud("-");
		}


		if ("01".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Edificio Privado");
		}
		else if ("02".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Lote Privado");
		}
		else if ("03".equals(eachDetalle.getUbicacion()))
		{
			publicidadForm.setUbicacion("Espacio Público");
		}
		else
		{
			publicidadForm.setUbicacion("-");
		}

		if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Oriente-Occidente");
		}
		else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Occidente-Oriente");
		}
		else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Norte-Sur");
		}
		else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Sur-Norte");
		}
		else if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Derecha");
		}
		else if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Izquierda");
		}
		else if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Ambos sentidos");
		}
		else
		{
			publicidadForm.setOrientacion("-");
		}
		publicidadForm.setLicenciaUrb(eachDetalle.getLicenciaUrb());
		publicidadForm.setContratoObra(eachDetalle.getContratoObra());
		publicidadForm.setLicenciaConstruc(eachDetalle.getLicenciaConstruc());
		publicidadForm.setVigLicenConstruc(eachDetalle.getVigLicenConstruc());
		publicidadForm.setAreaTotal(eachDetalle.getAreaTotal());
		publicidadForm.setPeriodicidad(eachDetalle.getPeriodicidad());
		publicidadForm.setNumCaras(eachDetalle.getNumCaras());
		publicidadForm.setAreaElemento(eachDetalle.getAreaElemento());

	}

	private void fillVallaVehiculos(final PublicidadForm publicidadForm, final DetallePubli eachDetalle,
			final DetallePublicidadResponse detallePublicidadResponse)
	{
		publicidadForm.setModelo(eachDetalle.getModelo());
		publicidadForm.setPlaca(eachDetalle.getPlaca());
		publicidadForm.setNumLicenciaTrans(eachDetalle.getNumLicenciaTrans());
		publicidadForm.setTipoVallaCode("02");
		if ("01".equals(eachDetalle.getTipoServicio()))
		{
			publicidadForm.setTipoServicio("Publico");
		}
		else if ("02".equals(eachDetalle.getTipoServicio()))
		{
			publicidadForm.setTipoServicio("Particular");
		}
		else if ("03".equals(eachDetalle.getTipoServicio()))
		{
			publicidadForm.setTipoServicio("Publico colectivo");
		}
		else if ("04".equals(eachDetalle.getTipoServicio()))
		{
			publicidadForm.setTipoServicio("Publico individual");
		}
		else
		{
			publicidadForm.setTipoServicio("-");
		}

		//publicidadForm.setTipoPublici(eachDetalle.getTipoPublici());
		if ("01".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Politica");
		}
		else if ("02".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Comercial");
		}
		else if ("03".equals(eachDetalle.getTipoPublici()))
		{
			publicidadForm.setTipoPublici("Institucional");
		}
		else
		{
			publicidadForm.setTipoPublici("-");
		}

		if ("01".equals(eachDetalle.getTipoElemento()))
		{
			publicidadForm.setTipoElemento("Vehiculo");
		}
		else if ("02".equals(eachDetalle.getTipoElemento()))
		{
			publicidadForm.setTipoElemento("Taxi");
		}
		else if ("03".equals(eachDetalle.getTipoElemento()))
		{
			publicidadForm.setTipoElemento("Disel");
		}
		else if ("04".equals(eachDetalle.getTipoElemento()))
		{
			publicidadForm.setTipoElemento("Bus");
		}
		else if ("05".equals(eachDetalle.getTipoElemento()))
		{
			publicidadForm.setTipoElemento("Buseta");
		}
		else if ("06".equals(eachDetalle.getTipoElemento()))
		{
			publicidadForm.setTipoElemento("Colectivo Disel");
		}
		else if ("07".equals(eachDetalle.getTipoElemento()))
		{
			publicidadForm.setTipoElemento("Hibrido");
		}
		else
		{
			publicidadForm.setTipoElemento("-");
		}

		if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Oriente-Occidente");
		}
		else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Occidente-Oriente");
		}
		else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Norte-Sur");
		}
		else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Sur-Norte");
		}
		else if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Derecha");
		}
		else if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Izquierda");
		}
		else if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
		{
			publicidadForm.setOrientacion("Ambos sentidos");
		}
		else
		{
			publicidadForm.setOrientacion("-");
		}


		if ("01".equals(detallePublicidadResponse.getTipoSolicitud()) || "1".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Registro Nuevo");
		}
		else if ("02".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "2".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Actualizacion");
		}
		else if ("03".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "3".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Prorroga");
		}
		else if ("04".equals(detallePublicidadResponse.getTipoSolicitud())
				|| "4".equals(detallePublicidadResponse.getTipoSolicitud()))
		{
			publicidadForm.setTipoSolicitud("Traslado");
		}
		else
		{
			publicidadForm.setTipoSolicitud("-");
		}
	}

}
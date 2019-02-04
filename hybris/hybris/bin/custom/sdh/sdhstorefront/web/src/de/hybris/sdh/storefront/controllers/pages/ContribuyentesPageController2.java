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
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePublicidadRequest;
import de.hybris.sdh.core.pojos.responses.DetallePubli;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetallePublicidadService;
import de.hybris.sdh.storefront.forms.PublicidadForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page 2
 */
@Controller
//@RequestMapping("/contribuyentes2")
public class ContribuyentesPageController2 extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(ContribuyentesPageController2.class);

	private static final String PREDIAL_UNIFICADO_CMS_PAGE = "PredialUnificadoPage";

	private static final String PREDIAL_UNIFICADO_DESCUENTO_CMS_PAGE = "PredialUnificadoDescuetoPage";

	private static final String PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE = "PredialUnificadoDeclaracionesPage";

	private static final String PREDIAL_UNIFICADO_CORRECIONES_CMS_PAGE = "PredialUnificadoCorrecionesPage";

	private static final String SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE = "SobreVehiculosAutomotoresPage";

	private static final String SOBRE_VEHICULOS_DECLARACIONES_CMS_PAGE = "SobreVehiculosDeclaracionesPage";

	private static final String SOBRE_VEHICULOS_CORRECIONES_CMS_PAGE = "SobreVehiculosCorrecionesPage";

	private static final String ICA_Y_RETEICA_CMS_PAGE = "IcaReteIcaPage";

	private static final String ICA_Y_RETEICA_DECLARACIONES_CMS_PAGE = "IcaReteIcaDeclaracionesPage";

	private static final String ICA_Y_RETEICA_CORRECIONES_CMS_PAGE = "IcaReteIcaCorrecionesPage";

	private static final String PUBLICIDAD_EXTERIOR_CMS_PAGE = "PublicidadExteriorPage";
	private static final String REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes2/publicidadexterior";


	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhDetallePublicidadService")
	SDHDetallePublicidadService sdhDetallePublicidadService;




	//Se anexa el mapeo de la pagina predialunificado
	//GRD
	@RequestMapping(value = "/predialunificado", method = RequestMethod.GET)
	public String predialUnidicado(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/predialunificado/detail", method = RequestMethod.GET)
	public String predialUnidicadoDetail(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));

		return getViewForPage(model);
	}


	@RequestMapping(value = "/predialunificado/descuento", method = RequestMethod.GET)
	public String predialUnidicadoDescuento(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/predialunificado/declaraciones", method = RequestMethod.GET)
	public String predialUnidicadoDeclaraciones(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/predialunificado/correcciones", method = RequestMethod.GET)
	public String predialUnidicadoCorreciones(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CORRECIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CORRECIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CORRECIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	//Se anexa el mapeo de la pagina sobrevehiculosautomotores
	//GRD
	@RequestMapping(value = "/sobrevehiculosautomotores", method = RequestMethod.GET)
	public String sobreVehiculosAutomotores(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));

		return getViewForPage(model);
	}

	//Sobre Vehiculos

	@RequestMapping(value = "/sobrevehiculosautomotores/declaraciones", method = RequestMethod.GET)
	public String sobreVehiculosDeclaraciones(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/sobrevehiculosautomotores/detail", method = RequestMethod.GET)
	public String sobreVehiculosDetail(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/sobrevehiculosautomotores/correcciones", method = RequestMethod.GET)
	public String sobreVehiculosCorreciones(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CORRECIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CORRECIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CORRECIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	//Se anexa el mapeo de la pagina ica y reteica
	//GRD
	@RequestMapping(value = "/icareteica", method = RequestMethod.GET)
	public String icaReteIca(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		return getViewForPage(model);
	}

	//Ica y ReteIca
	@RequestMapping(value = "/icareteica/declaraciones", method = RequestMethod.GET)
	public String icaReteIcaDeclaraciones(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_Y_RETEICA_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(ICA_Y_RETEICA_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/icareteica/detail", method = RequestMethod.GET)
	public String icaReteIcaDetail(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/icareteica/correcciones", method = RequestMethod.GET)
	public String icaReteIcaCorreciones(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CORRECIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CORRECIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CORRECIONES_CMS_PAGE));

		return getViewForPage(model);
	}
	//Se anexa el mapeo de la pagina publicidadexterior
	//GRD
	@RequestMapping(value = "/contribuyentes2/publicidadexterior/detalle", method = RequestMethod.POST)
	//@RequireHardLogIn
	public String publicidadExternaDetail(@ModelAttribute("publicidadFormReq")
	final PublicidadForm publicidadForm, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{


		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();

		detallePublicidadRequest.setNumBP("0000000546");
		detallePublicidadRequest.setNumResolu(publicidadForm.getNumResolu());
		detallePublicidadRequest.setAnoGravable(publicidadForm.getAnoGravable());

		//detallePublicidadRequest.setNumBP("0000000546");
		//detallePublicidadRequest.setNumResolu("RES 096");
		//detallePublicidadRequest.setAnoGravable("2018");
		try
		{
			String tipovalla = publicidadForm.getTipoValla();

			//final PublicidadForm publicidadForm = new PublicidadForm();
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePublicidadResponse detallePublicidadResponse = mapper.readValue(
					sdhDetallePublicidadService.detallePublicidad(detallePublicidadRequest), DetallePublicidadResponse.class);

			//final PublicidadForm publicidadForm = new PublicidadForm();

			//publicidadForm.setTipoElemento(detallePublicidadResponse.getTipoElemento());

			//Datos Basicos

			final String fechResolu = detallePublicidadResponse.getFechResolu();
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

					if (" VALLA VEHICULOS".equalsIgnoreCase(tipovalla) || "VALLA VEHICULOS".equalsIgnoreCase(tipovalla)
							|| "VALLA VEHíCULOS".equalsIgnoreCase(tipovalla) || " VALLA VEHíCULOS".equalsIgnoreCase(tipovalla))
					{
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
							publicidadForm.setTipoPublici(" ");
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
							publicidadForm.setTipoElemento(" ");
						}
						publicidadForm.setNumCaras(eachDetalle.getNumCaras());

						if ("01".equals(eachDetalle.getPeriodicidad()))
						{
							publicidadForm.setPeriodicidad("Permanente");
						}
						else if ("02".equals(eachDetalle.getPeriodicidad()))
						{
							publicidadForm.setPeriodicidad("Temporal");
						}
						else
						{
							publicidadForm.setPeriodicidad(" ");
						}
						publicidadForm.setModelo(eachDetalle.getModelo());
						publicidadForm.setPlaca(eachDetalle.getPlaca());
						publicidadForm.setNumLicenciaTrans(eachDetalle.getNumLicenciaTrans());
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
							publicidadForm.setTipoServicio(" ");
						}
						if ("01".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Costado del Vehiculo");
						}
						else if ("02".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Capota del Vehiculo");
						}
						else
						{
							publicidadForm.setUbicacion(" ");
						}

					}
					else if ("VALLA AVISOS".equals(tipovalla))
					{
						if ("01".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Registro Nuevo");
						}
						else if ("02".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Actualizacion");
						}
						else if ("03".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Prorroga");
						}
						else if ("04".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Traslado");
						}
						else
						{
							publicidadForm.setTipoSolicitud(" ");
						}


						if ("01".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Avisos en fachada");
						}
						else if ("02".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Aviso separado de fachada tipo valla convencional");
						}
						else if ("03".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Zancudo");
						}
						else if ("04".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Aviso divisible");
						}
						else
						{
							publicidadForm.setTipoElemento(" ");
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
							publicidadForm.setAvisoLumino(" ");
						}

						if ("01".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Primer Piso");
						}
						else if ("02".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Parqueadero");
						}
						else if ("03".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Antepecho del segundo piso");
						}
						else if ("04".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Canopy porte superior del edificio(de 5 mas pisos)");
						}
						else
						{
							publicidadForm.setUbicacion(" ");
						}
						publicidadForm.setChip(eachDetalle.getChip());
						publicidadForm.setMatricula(eachDetalle.getMatricula());
						publicidadForm.setDireccion(eachDetalle.getDireccion());
						publicidadForm.setLocalidad(eachDetalle.getLocalidad());
						publicidadForm.setCodPostal(eachDetalle.getCodPostal());
						publicidadForm.setAreaElemento(eachDetalle.getAreaElemento());
						publicidadForm.setAreaFachada(eachDetalle.getAreaFachada());
						publicidadForm.setNumFracciones(eachDetalle.getNumFracciones());

					}
					else if (tipovalla.equals("VALLA CONVENCIONAL"))
					{

						if("01".equals(eachDetalle.getTipoElemento())) {
							publicidadForm.setTipoElemento("Valla convencional de obra comercial");
						}else if("02".equals(eachDetalle.getTipoElemento())) {
							publicidadForm.setTipoElemento("Valla convencional de obra institucional");
						}else {
							publicidadForm.setTipoElemento("");
						}

						publicidadForm.setLicenciaConstruc(eachDetalle.getLicenciaConstruc());
						publicidadForm.setDireccion(eachDetalle.getDireccion());//repetido
						publicidadForm.setAreaTotal(eachDetalle.getAreaTotal());
						publicidadForm.setContratoObra(eachDetalle.getContratoObra());
						publicidadForm.setOrientacion(eachDetalle.getOrientacion());
						publicidadForm.setFiducia(eachDetalle.getFiducia());
						publicidadForm.setLocalidad(eachDetalle.getLocalidad());//repetido
						publicidadForm.setCodPostal(eachDetalle.getCodPostal());//repetido
						publicidadForm.setLicenciaUrb(eachDetalle.getLicenciaUrb());
						publicidadForm.setCodPostal(eachDetalle.getCodPostal());//repetido
						publicidadForm.setChip(eachDetalle.getChip());//repetido

						if("01".equals(eachDetalle.getUbicacion())){
							publicidadForm.setUbicacion("Edificio privado");
						}else if("02".equals(eachDetalle.getUbicacion())){
							publicidadForm.setUbicacion("Lote Privado");
						}else if("03".equals(eachDetalle.getUbicacion())){
							publicidadForm.setUbicacion("Espacio Publico");
						}else {
							publicidadForm.setUbicacion(" ");
						}
						publicidadForm.setMatricula(eachDetalle.getMatricula());//repetido

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
							publicidadForm.setTipoPublici(" ");
						}

						publicidadForm.setNumCaras(eachDetalle.getNumCaras());//repetido
						publicidadForm.setVigLicenConstruc(eachDetalle.getVigLicenConstruc());
						publicidadForm.setPeriodicidad(eachDetalle.getPeriodicidad());//repetido

					}
					else if (tipovalla.equals("VALLA TUBULAR"))
					{

						publicidadForm.setTipoElemento(eachDetalle.getTipoElemento());//repetido
						publicidadForm.setDireccion(eachDetalle.getDireccion());//repetido
						publicidadForm.setLocalidad(eachDetalle.getLocalidad());//repetido
						publicidadForm.setCodPostal(eachDetalle.getCodPostal());//repetido
						publicidadForm.setLicenciaConstruc(eachDetalle.getLicenciaConstruc());//repetido
						publicidadForm.setVigLicenConstruc(eachDetalle.getVigLicenConstruc());//repetido
						if ("01".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Patio privado");
						}
						else if ("02".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Espacio publico");
						}
						else if ("03".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Edificacion Privada");
						}
						else if ("04".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Cubierta");
						}
						else if ("05".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Lote");
						}
						else if ("06".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Obra de construccion");
						}
						else if ("07".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Herramienta de lote sin urbanizar");
						}
						else if ("08".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Parqueadero");
						}
						else
						{
							publicidadForm.setUbicacion(" ");
						}
						publicidadForm.setTipoVia(eachDetalle.getTipoVia());
						publicidadForm.setOrientacion(eachDetalle.getOrientacion());//repetido
						publicidadForm.setChip(eachDetalle.getChip());//repetido
						publicidadForm.setMatricula(eachDetalle.getMatricula());//repetido
						publicidadForm.setNumCaras(eachDetalle.getNumCaras());//repetido
					}
					else
					{
						System.out.println("------------Algo salio mal con el mapeo------------------");
					}
					break;
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
		//storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		//setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		//updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		return REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE;
		//return getViewForPage(model);
	}




	@RequestMapping(value = "/contribuyentes2/publicidadexterior")
	public String publicidadExterna(@ModelAttribute("publicidadFormReq")
	final PublicidadForm dataform1, final Model model) throws CMSItemNotFoundException
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		//final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();
		final PublicidadForm publicidadForm = new PublicidadForm();
		consultaContribuyenteBPRequest.setNumBP("0000000546");


		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);
			//	final DetallePublicidadResponse detallePublicidadResponse = mapper.readValue(
			//		sdhDetallePublicidadService.detallePublicidad(detallePublicidadRequest), DetallePublicidadResponse.class);

			//final PublicidadForm publicidadForm = new PublicidadForm();

			//publicidadForm.setNumBP(sdhConsultaContribuyenteBPResponse.getInfoContrib.getNumBP());

			if (sdhConsultaContribuyenteBPResponse.getPublicidadExt() != null
					&& !sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				publicidadForm.setPublicidadExt(sdhConsultaContribuyenteBPResponse.getPublicidadExt().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumResolu())).collect(Collectors.toList()));


				model.addAttribute("publicidadForm", publicidadForm);
			}
			else
			{
				GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			}


		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));

		return getViewForPage(model);
	}

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

	}
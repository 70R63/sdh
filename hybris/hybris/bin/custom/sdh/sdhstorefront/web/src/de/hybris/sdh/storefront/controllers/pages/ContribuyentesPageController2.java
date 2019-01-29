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
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePublicidadRequest;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetallePublicidadService;
import de.hybris.sdh.storefront.forms.PublicidadForm;

import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
	public String publicidadExternaDetail(final Model model, final RedirectAttributes redirectModel,
			@ModelAttribute("publicidadForm")
			final PublicidadForm miRitCertificacionFormDatos) throws CMSItemNotFoundException
	{


		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();

		detallePublicidadRequest.setNumBP("0000000546");
		detallePublicidadRequest.setNumResolu(miRitCertificacionFormDatos.getNumResolu());
		detallePublicidadRequest.setAnoGravable(miRitCertificacionFormDatos.getAnoGravable());

		//detallePublicidadRequest.setNumBP("0000000546");
		//detallePublicidadRequest.setNumResolu("RES 096");
		//detallePublicidadRequest.setAnoGravable("2018");



		try
		{
			final PublicidadForm publicidadForm = new PublicidadForm();
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePublicidadResponse detallePublicidadResponse = mapper.readValue(
					sdhDetallePublicidadService.detallePublicidad(detallePublicidadRequest), DetallePublicidadResponse.class);

			//final PublicidadForm publicidadForm = new PublicidadForm();



			//publicidadForm.setTipoElemento(detallePublicidadResponse.getTipoElemento());

			//Datos Basicos
			publicidadForm.setFechResolu(detallePublicidadResponse.getFechResolu());
			publicidadForm.setFechNotif(detallePublicidadResponse.getFechNotif());
			publicidadForm.setVigenDesde(detallePublicidadResponse.getVigenDesde());
			publicidadForm.setVigenHasta(detallePublicidadResponse.getVigenHasta());
			publicidadForm.setTipoSolicitud(detallePublicidadResponse.getTipoSolicitud());
			//Datos Avisos
			publicidadForm.setTipoElemento(detallePublicidadResponse.getDetalle().getTipoElemento());
			publicidadForm.setAvisoLumino(detallePublicidadResponse.getDetalle().getAvisoLumino());
			publicidadForm.setUbicacion(detallePublicidadResponse.getDetalle().getUbicacion());
			publicidadForm.setChip(detallePublicidadResponse.getDetalle().getChip());
			publicidadForm.setMatricula(detallePublicidadResponse.getDetalle().getMatricula());
			publicidadForm.setDireccion(detallePublicidadResponse.getDetalle().getDireccion());
			publicidadForm.setLocalidad(detallePublicidadResponse.getDetalle().getLocalidad());
			publicidadForm.setCodPostal(detallePublicidadResponse.getDetalle().getCodPostal());
			publicidadForm.setAreaElemento(detallePublicidadResponse.getDetalle().getAreaElemento());
			publicidadForm.setAreaFachada(detallePublicidadResponse.getDetalle().getAreaFachada());
			publicidadForm.setNumFracciones(detallePublicidadResponse.getDetalle().getNumFracciones());
			//Datos Vehiculos
			publicidadForm.setTipoPublici(detallePublicidadResponse.getDetalle().getTipoPublici());
			publicidadForm.setNumCaras(detallePublicidadResponse.getDetalle().getNumCaras());
			publicidadForm.setPeriodicidad(detallePublicidadResponse.getDetalle().getPeriodicidad());
			publicidadForm.setModelo(detallePublicidadResponse.getDetalle().getModelo());
			publicidadForm.setPlaca(detallePublicidadResponse.getDetalle().getPlaca());
			publicidadForm.setNumLicenciaTrans(detallePublicidadResponse.getDetalle().getNumLicenciaTrans());
			publicidadForm.setTipoServicio(detallePublicidadResponse.getDetalle().getTipoServicio());
			//Datos Convencional
			publicidadForm.setTipoElemento(detallePublicidadResponse.getDetalle().getTipoElemento());//repetidooo
			publicidadForm.setLicenciaConstruc(detallePublicidadResponse.getDetalle().getLicenciaConstruc());
			publicidadForm.setDireccion(detallePublicidadResponse.getDetalle().getDireccion());//repetido
			publicidadForm.setAreaTotal(detallePublicidadResponse.getDetalle().getAreaTotal());
			publicidadForm.setContratoObra(detallePublicidadResponse.getDetalle().getContratoObra());
			publicidadForm.setOrientacion(detallePublicidadResponse.getDetalle().getOrientacion());
			publicidadForm.setFiducia(detallePublicidadResponse.getDetalle().getFiducia());
			publicidadForm.setLocalidad(detallePublicidadResponse.getDetalle().getLocalidad());//repetido
			publicidadForm.setCodPostal(detallePublicidadResponse.getDetalle().getCodPostal());//repetido
			publicidadForm.setLicenciaUrb(detallePublicidadResponse.getDetalle().getLicenciaUrb());
			publicidadForm.setCodPostal(detallePublicidadResponse.getDetalle().getCodPostal());//repetido
			publicidadForm.setChip(detallePublicidadResponse.getDetalle().getChip());//repetido
			publicidadForm.setUbicacion(detallePublicidadResponse.getDetalle().getUbicacion());//repetido
			publicidadForm.setMatricula(detallePublicidadResponse.getDetalle().getMatricula());//repetido
			publicidadForm.setTipoPublici(detallePublicidadResponse.getDetalle().getTipoPublici());//repetido
			publicidadForm.setNumCaras(detallePublicidadResponse.getDetalle().getNumCaras());//repetido
			publicidadForm.setVigLicenConstruc(detallePublicidadResponse.getDetalle().getVigLicenConstruc());
			publicidadForm.setPeriodicidad(detallePublicidadResponse.getDetalle().getPeriodicidad());//repetido
			//DetalleTubular
			publicidadForm.setTipoElemento(detallePublicidadResponse.getDetalle().getTipoElemento());//repetido
			publicidadForm.setDireccion(detallePublicidadResponse.getDetalle().getDireccion());//repetido
			publicidadForm.setLocalidad(detallePublicidadResponse.getDetalle().getLocalidad());//repetido
			publicidadForm.setCodPostal(detallePublicidadResponse.getDetalle().getCodPostal());//repetido
			publicidadForm.setLicenciaConstruc(detallePublicidadResponse.getDetalle().getLicenciaConstruc());//repetido
			publicidadForm.setVigLicenConstruc(detallePublicidadResponse.getDetalle().getVigLicenConstruc());//repetido
			publicidadForm.setUbicacion(detallePublicidadResponse.getDetalle().getUbicacion());//repetido
			publicidadForm.setTipoVia(detallePublicidadResponse.getDetalle().getTipoVia());
			publicidadForm.setOrientacion(detallePublicidadResponse.getDetalle().getOrientacion());//repetido
			publicidadForm.setChip(detallePublicidadResponse.getDetalle().getChip());//repetido
			publicidadForm.setMatricula(detallePublicidadResponse.getDetalle().getMatricula());//repetido
			publicidadForm.setNumCaras(detallePublicidadResponse.getDetalle().getNumCaras());//repetido

			model.addAttribute("publicidadForm", publicidadForm);


		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			//LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			//GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		//model.addAttribute("showDetail", true);
		//	model.addAttribute("action", request.getParameter("action"));
		//System.out.println("action: " + request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));

		return getViewForPage(model);
	}




	@RequestMapping(value = "/contribuyentes2/publicidadexterior", method = RequestMethod.GET)
	public String publicidadExterna(final Model model) throws CMSItemNotFoundException
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		//final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();
		final PublicidadForm publicidadForm = new PublicidadForm();
		//consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());
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


			/*
			 * /Datos Basicos publicidadForm.setFechResolu(detallePublicidadResponse.getFechResolu());
			 * publicidadForm.setFechNotif(detallePublicidadResponse.getFechNotif());
			 * publicidadForm.setVigenDesde(detallePublicidadResponse.getVigenDesde());
			 * publicidadForm.setVigenHasta(detallePublicidadResponse.getVigenHasta());
			 * publicidadForm.setTipoSolicitud(detallePublicidadResponse.getTipoSolicitud()); //Datos Avisos
			 * publicidadForm.setTipoElemento(detallePublicidadResponse.getDetalle().getTipoElemento());
			 * publicidadForm.setAvisoLumino(detallePublicidadResponse.getDetalle().getAvisoLumino());
			 * publicidadForm.setUbicacion(detallePublicidadResponse.getDetalle().getUbicacion());
			 * publicidadForm.setChip(detallePublicidadResponse.getDetalle().getChip());
			 * publicidadForm.setMatricula(detallePublicidadResponse.getDetalle().getMatricula());
			 * publicidadForm.setDireccion(detallePublicidadResponse.getDetalle().getDireccion());
			 * publicidadForm.setLocalidad(detallePublicidadResponse.getDetalle().getLocalidad());
			 * publicidadForm.setCodPostal(detallePublicidadResponse.getDetalle().getCodPostal());
			 * publicidadForm.setAreaElemento(detallePublicidadResponse.getDetalle().getAreaElemento());
			 * publicidadForm.setAreaFachada(detallePublicidadResponse.getDetalle().getAreaFachada());
			 * publicidadForm.setNumFracciones(detallePublicidadResponse.getDetalle().getNumFracciones()); //Datos
			 * Vehiculos publicidadForm.setTipoPublici(detallePublicidadResponse.getDetalle().getTipoPublici());
			 * publicidadForm.setNumCaras(detallePublicidadResponse.getDetalle().getNumCaras());
			 * publicidadForm.setPeriodicidad(detallePublicidadResponse.getDetalle().getPeriodicidad());
			 * publicidadForm.setModelo(detallePublicidadResponse.getDetalle().getModelo());
			 * publicidadForm.setPlaca(detallePublicidadResponse.getDetalle().getPlaca());
			 * publicidadForm.setNumLicenciaTrans(detallePublicidadResponse.getDetalle().getNumLicenciaTrans());
			 * publicidadForm.setTipoServicio(detallePublicidadResponse.getDetalle().getTipoServicio()); //Datos
			 * Convencional
			 * publicidadForm.setTipoElemento(detallePublicidadResponse.getDetalle().getTipoElemento());//repetidooo
			 * publicidadForm.setLicenciaConstruc(detallePublicidadResponse.getDetalle().getLicenciaConstruc());
			 * publicidadForm.setDireccion(detallePublicidadResponse.getDetalle().getDireccion());//repetido
			 * publicidadForm.setAreaTotal(detallePublicidadResponse.getDetalle().getAreaTotal());
			 * publicidadForm.setContratoObra(detallePublicidadResponse.getDetalle().getContratoObra());
			 * publicidadForm.setOrientacion(detallePublicidadResponse.getDetalle().getOrientacion());
			 * publicidadForm.setFiducia(detallePublicidadResponse.getDetalle().getFiducia());
			 * publicidadForm.setLocalidad(detallePublicidadResponse.getDetalle().getLocalidad());//repetido
			 * publicidadForm.setCodPostal(detallePublicidadResponse.getDetalle().getCodPostal());//repetido
			 * publicidadForm.setLicenciaUrb(detallePublicidadResponse.getDetalle().getLicenciaUrb());
			 * publicidadForm.setCodPostal(detallePublicidadResponse.getDetalle().getCodPostal());//repetido
			 * publicidadForm.setChip(detallePublicidadResponse.getDetalle().getChip());//repetido
			 * publicidadForm.setUbicacion(detallePublicidadResponse.getDetalle().getUbicacion());//repetido
			 * publicidadForm.setMatricula(detallePublicidadResponse.getDetalle().getMatricula());//repetido
			 * publicidadForm.setTipoPublici(detallePublicidadResponse.getDetalle().getTipoPublici());//repetido
			 * publicidadForm.setNumCaras(detallePublicidadResponse.getDetalle().getNumCaras());//repetido
			 * publicidadForm.setVigLicenConstruc(detallePublicidadResponse.getDetalle().getVigLicenConstruc());
			 * publicidadForm.setPeriodicidad(detallePublicidadResponse.getDetalle().getPeriodicidad());//repetido
			 * //DetalleTubular
			 * publicidadForm.setTipoElemento(detallePublicidadResponse.getDetalle().getTipoElemento());//repetido
			 * publicidadForm.setDireccion(detallePublicidadResponse.getDetalle().getDireccion());//repetido
			 * publicidadForm.setLocalidad(detallePublicidadResponse.getDetalle().getLocalidad());//repetido
			 * publicidadForm.setCodPostal(detallePublicidadResponse.getDetalle().getCodPostal());//repetido
			 * publicidadForm.setLicenciaConstruc(detallePublicidadResponse.getDetalle().getLicenciaConstruc());//repetido
			 * publicidadForm.setVigLicenConstruc(detallePublicidadResponse.getDetalle().getVigLicenConstruc());//repetido
			 * publicidadForm.setUbicacion(detallePublicidadResponse.getDetalle().getUbicacion());//repetido
			 * publicidadForm.setTipoVia(detallePublicidadResponse.getDetalle().getTipoVia());
			 * publicidadForm.setOrientacion(detallePublicidadResponse.getDetalle().getOrientacion());//repetido
			 * publicidadForm.setChip(detallePublicidadResponse.getDetalle().getChip());//repetido
			 * publicidadForm.setMatricula(detallePublicidadResponse.getDetalle().getMatricula());//repetido
			 * publicidadForm.setNumCaras(detallePublicidadResponse.getDetalle().getNumCaras());//repetido
			 *
			 * model.addAttribute("publicidadForm", publicidadForm);
			 */
		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			//LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			//GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		model.addAttribute("publicidadForm", publicidadForm);
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
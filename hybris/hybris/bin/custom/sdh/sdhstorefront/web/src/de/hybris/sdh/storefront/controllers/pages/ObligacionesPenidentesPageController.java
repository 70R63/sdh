/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.ObligacionesRequest;
import de.hybris.sdh.core.pojos.requests.ReteicaObligacionesRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.ObligacionesCabeceraDeli;
import de.hybris.sdh.core.pojos.responses.ObligacionesDeliResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesDetallePublicidad;
import de.hybris.sdh.core.pojos.responses.ObligacionesGasolinaResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesICAResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesPredialResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesResponse;
import de.hybris.sdh.core.pojos.responses.ObligacionesVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.ReteicaObligacionesResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHObligacionesDeliService;
import de.hybris.sdh.core.services.SDHObligacionesGasolinaService;
import de.hybris.sdh.core.services.SDHObligacionesICAService;
import de.hybris.sdh.core.services.SDHObligacionesPredialService;
import de.hybris.sdh.core.services.SDHObligacionesPublicidadService;
import de.hybris.sdh.core.services.SDHObligacionesVehiculosService;
import de.hybris.sdh.core.services.SDHReteIcaService;
import de.hybris.sdh.facades.questions.data.SDHExteriorPublicityTaxData;
import de.hybris.sdh.facades.questions.data.SDHGasTaxData;
import de.hybris.sdh.facades.questions.data.SDHICATaxData;
import de.hybris.sdh.facades.questions.data.SDHPredialTaxData;
import de.hybris.sdh.facades.questions.data.SDHUrbanDelineationsTaxData;
import de.hybris.sdh.facades.questions.data.SDHVehiculosTaxData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.ObligacionesForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Maria Luisa
 *
 */
@Controller
/* @RequestMapping("/contribuyentes/certipagos") */
public class ObligacionesPenidentesPageController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.oblipendienetes";
	private static final String TEXT_ACCOUNT_PROFILE_RETE = "text.account.profile.obligaRETE";

	// CMS Pages
	private static final String OBLIGACIONES_PENDIENTES_CMS_PAGE = "obligacionesPendientesPage";

	private static final String REDIRECT_TO_OBLIGACIONES_PENDIENTES_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/consultas/obligaciones";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhObligacionesPublicidadService")
	SDHObligacionesPublicidadService sdhObligacionesPublicidadService;


	@Resource(name = "sdhObligacionesGasolinaService")
	SDHObligacionesGasolinaService sdhObligacionesGasolinaService;

	@Resource(name = "sdhObligacionesICAService")
	SDHObligacionesICAService sdhObligacionesICAService;

	@Resource(name = "sdhObligacionesDeliService")
	SDHObligacionesDeliService sdhObligacionesDeliService;

	@Resource(name = "sdhObligacionesPredialService")
	SDHObligacionesPredialService sdhObligacionesPredialService;

	@Resource(name = "sdhObligacionesVehiculosService")
	SDHObligacionesVehiculosService sdhObligacionesVehiculosService;

	@Resource(name = "sdhReteIcaService")
	SDHReteIcaService sdhReteICAInfObjetoService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhCustomerAccountService")
	SDHCustomerAccountService sdhCustomerAccountService;


	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);


	@RequestMapping(value =
	{ "/contribuyentes/consultas/obligaciones", "/agenteRetenedor/consultas/obligaciones" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String oblipendi(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("obligacionesForm")
	final ObligacionesForm obligacionesForm, @RequestParam(name = "errorSITII", required = false, value = "") final String errorSITII,
			final HttpServletRequest request)
			throws CMSItemNotFoundException
	{

		String referrer = request.getHeader("referer");

		if (referrer == null)
		{
			referrer = request.getServletPath();
		}

		System.out.println("Se encuentra dentro del get de OBLIGACIONES PENDIENTES");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		String wsResponse = null;
		String wsResponseReteica = null;
		SDHValidaMailRolResponse contImpuestos = null;


		final ObligacionesRequest obligacionesRequest = new ObligacionesRequest();
		obligacionesRequest.setBp(customerModel.getNumBP());
		final ObligacionesForm obligacionesFormuno = new ObligacionesForm();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);

		final Set<PrincipalGroupModel> groupList = customerModel.getGroups();

		//solo para PRD inicio:
//		groupList = groupList.stream().filter(c -> (c.getUid().contains("gasolinaUsrTaxGrp") || c.getUid().contains("publicidadExtUsrTaxGrp"))).collect(Collectors.toSet());
		//solo para PRD fin

		for (final PrincipalGroupModel group : groupList)
		{
			final String groupUid = group.getUid();

			if (groupUid.contains("predialUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "01");

				if (contImpuestos != null && contImpuestos.getPredial() != null)
				{
					final List<SDHPredialTaxData> predialTaxList = new ArrayList<SDHPredialTaxData>();
					final SDHPredialTaxData predialTaxItem = new SDHPredialTaxData();

					for (final PredialResponse predialItem : contImpuestos.getPredial())
					{
						predialTaxItem.setAnioGravable(predialItem.getAnioGravable());
						predialTaxItem.setCHIP(predialItem.getCHIP());
						predialTaxItem.setContratoArrenda(predialItem.getContratoArrenda());
						predialTaxItem.setDireccionPredio(predialItem.getDireccionPredio());
						predialTaxItem.setMatrInmobiliaria(predialItem.getMatrInmobiliaria());
						predialTaxItem.setNumObjeto(predialItem.getNumObjeto());

						predialTaxList.add(predialTaxItem);
					}


					customerData.setPredialTaxList(predialTaxList);
				}
			}

			if (groupUid.contains("vehicularUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "02");

				if (contImpuestos != null && contImpuestos.getVehicular() != null)
				{
					final List<SDHVehiculosTaxData> vehiculosTaxList = new ArrayList<SDHVehiculosTaxData>();
					final SDHVehiculosTaxData vehiculosTaxItem = new SDHVehiculosTaxData();

					for (final ImpuestoVehiculos vehiculoItem : contImpuestos.getVehicular())
					{
						vehiculosTaxItem.setBlindado(vehiculoItem.getBlindado());
						vehiculosTaxItem.setCarroceria(vehiculoItem.getCarroceria());
						vehiculosTaxItem.setCilindraje(vehiculoItem.getCilindraje());
						vehiculosTaxItem.setClase(vehiculoItem.getClase());
						vehiculosTaxItem.setLinea(vehiculoItem.getLinea());
						vehiculosTaxItem.setMarca(vehiculoItem.getMarca());
						vehiculosTaxItem.setModelo(vehiculoItem.getModelo());
						vehiculosTaxItem.setNumObjeto(vehiculoItem.getNumObjeto());
						vehiculosTaxItem.setNumPuertas(vehiculoItem.getNumPuertas());
						vehiculosTaxItem.setPlaca(vehiculoItem.getPlaca());

						vehiculosTaxList.add(vehiculosTaxItem);
					}

					customerData.setVehiculosTaxList(vehiculosTaxList);
				}
			}

			if (groupUid.contains("ICAUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "03");

				if (contImpuestos != null && contImpuestos.getIca() != null)
				{
					final SDHICATaxData icaTax = new SDHICATaxData();
					icaTax.setObjectNumber(contImpuestos.getIca().getNumObjeto());
					customerData.setIcaTax(icaTax);
				}
			}

			if (groupUid.contains("gasolinaUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "05");

				if (contImpuestos != null && contImpuestos.getGasolina() != null)
				{
					final List<SDHGasTaxData> gasTaxList = new ArrayList<SDHGasTaxData>();
					final SDHGasTaxData gasTaxItem = new SDHGasTaxData();

					for (final ImpuestoGasolina gasolinaItem : contImpuestos.getGasolina())
					{
						gasTaxItem.setDocumentNumber(gasolinaItem.getNumDoc());
						gasTaxItem.setDocumentType(gasolinaItem.getTipoDoc());
						gasTaxItem.setObjectNumber(gasolinaItem.getNumObjeto());

						gasTaxList.add(gasTaxItem);
					}

					customerData.setGasTaxList(gasTaxList);
				}
			}

			if (groupUid.contains("delineacionUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "06");

				if (contImpuestos != null && contImpuestos.getDelineacion() != null)
				{
					final List<SDHUrbanDelineationsTaxData> urbanDelineationsTaxList = new ArrayList<SDHUrbanDelineationsTaxData>();
					final SDHUrbanDelineationsTaxData urbanDelineationsTaxItem = new SDHUrbanDelineationsTaxData();

					for (final ImpuestoDelineacionUrbana delineacionItem : contImpuestos.getDelineacion())
					{
						urbanDelineationsTaxItem.setCdu(delineacionItem.getCdu());
						urbanDelineationsTaxItem.setExpDate(delineacionItem.getFechaExp());
						urbanDelineationsTaxItem.setLicenConst(delineacionItem.getLicenConst());
						urbanDelineationsTaxItem.setObjectNumber(delineacionItem.getNumObjeto());

//						delineacionItem.setCdu(delineacionItem.getCdu());
//						delineacionItem.setCuraduria(delineacionItem.getCuraduria());
//						delineacionItem.setFechaEjecutoria(delineacionItem.getFechaEjecutoria());
//						delineacionItem.setFechaExp(delineacionItem.getFechaExp());
//						delineacionItem.setFechaIniObra(delineacionItem.getFechaIniObra());
//						delineacionItem.setFechaReval(delineacionItem.getFechaReval());
//						delineacionItem.setFechFinObra(delineacionItem.getFechFinObra());
//						delineacionItem.setLicenConst(delineacionItem.getLicenConst());
//						delineacionItem.setNroResolucReva(delineacionItem.getNroResolucReva());
//						delineacionItem.setNumObjeto(delineacionItem.getNumObjeto());
//						delineacionItem.setRadicados(delineacionItem.getRadicados());
//						delineacionItem.setTipoMarca(delineacionItem.getTipoMarca());
//						delineacionItem.setTotalPresup(delineacionItem.getTotalPresup());
//						delineacionItem.setValorEjecut(delineacionItem.getValorEjecut());

						urbanDelineationsTaxList.add(urbanDelineationsTaxItem);
					}


					customerData.setUrbanDelineationsTaxList(urbanDelineationsTaxList);
				}
			}

			if (groupUid.contains("publicidadExtUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "07");

				if (contImpuestos != null && contImpuestos.getPublicidadExt() != null)
				{
					final List<SDHExteriorPublicityTaxData> exteriorPublicityTaxList = new ArrayList<SDHExteriorPublicityTaxData>();
					final SDHExteriorPublicityTaxData exteriorPublicityTaxItem = new SDHExteriorPublicityTaxData();

					for (final ImpuestoPublicidadExterior publicidadItem : contImpuestos.getPublicidadExt())
					{
						exteriorPublicityTaxItem.setResolutionNumber(publicidadItem.getNumResolu());
						exteriorPublicityTaxItem.setFenceType(publicidadItem.getTipoValla());
						exteriorPublicityTaxItem.setObjectNumber(publicidadItem.getNumObjeto());
						exteriorPublicityTaxItem.setAnoGravable(publicidadItem.getAnoGravable());

						exteriorPublicityTaxList.add(exteriorPublicityTaxItem);

					}

					customerData.setExteriorPublicityTaxList(exteriorPublicityTaxList);
				}
			}

		}


		final Map listaImpuestosCustomer = gasolinaService.obtenerListaImpuestosActivos(customerData);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);



		if (referrer.contains("contribuyentes"))
		{

			try
			{



				if (listaImpuestosCustomer.get("5") != null)
				{
					wsResponse = sdhObligacionesGasolinaService.obligacionesRequest(obligacionesRequest);
					if (wsResponse != null)
					{
						final ObligacionesGasolinaResponse obligacionesGasolinaResponse = mapper.readValue(wsResponse,
								ObligacionesGasolinaResponse.class);
						obligacionesFormuno.setHeadergas(obligacionesGasolinaResponse.getHeader().stream()
								.filter(d -> StringUtils.isNotBlank(d.getAnioGravable())).collect(Collectors.toList()));
					}
				}

				if (listaImpuestosCustomer.get("3") != null)
				{
					wsResponse = sdhObligacionesICAService.obligacionesRequest(obligacionesRequest);
					if (wsResponse != null)
					{
						final ObligacionesICAResponse obligacionesICAResponse = mapper.readValue(wsResponse,
								ObligacionesICAResponse.class);
						obligacionesFormuno.setHeaderica(obligacionesICAResponse.getHeader().stream()
								.filter(d -> StringUtils.isNotBlank(d.getAnioGravable())).collect(Collectors.toList()));

					}
				}

				if (listaImpuestosCustomer.get("6") != null)
				{
					wsResponse = sdhObligacionesDeliService.obligacionesRequest(obligacionesRequest);
					if (wsResponse != null)
					{
						final ObligacionesDeliResponse obligacionesDeliResponse = mapper.readValue(wsResponse,
								ObligacionesDeliResponse.class);
						obligacionesFormuno.setHeaderdeli(obligacionesDeliResponse.getHeader().stream()
								.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));

//						if(obligacionesFormuno.getHeaderdeli() != null) {
//							for(final ObligacionesCabeceraDeli obligacionesCabeceraDeli : obligacionesFormuno.getHeaderdeli() ) {
//								for(final ObligacionesDetallePublicidad obligacionesDetallePublicidad: obligacionesCabeceraDeli.getDetails()) {
//									if (StringUtils.isBlank(obligacionesDetallePublicidad.getNumReferencia()) ) {
//										obligacionesCabeceraDeli.getDetails().remove(obligacionesDetallePublicidad);
//									}
//								}
//							}
//						}
					}
				}

				if (listaImpuestosCustomer.get("1") != null)
				{
					wsResponse = sdhObligacionesPredialService.obligacionesRequest(obligacionesRequest);
					if (wsResponse != null)
					{
						final ObligacionesPredialResponse obligacionesPredResponse = mapper.readValue(wsResponse,
								ObligacionesPredialResponse.class);
						obligacionesFormuno.setHeaderPred(obligacionesPredResponse.getHeader().stream()
								.filter(d -> StringUtils.isNotBlank(d.getAnioGravable())).collect(Collectors.toList()));
					}
				}

				if (listaImpuestosCustomer.get("2") != null)
				{
					wsResponse = sdhObligacionesVehiculosService.obligacionesRequest(obligacionesRequest);
					if (wsResponse != null)
					{
						final ObligacionesVehiculosResponse obligacionesVehiResponse = mapper.readValue(wsResponse,
								ObligacionesVehiculosResponse.class);
						obligacionesFormuno.setHeaderVehiculos(obligacionesVehiResponse.getHeader().stream()
								.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
					}
				}

				if (listaImpuestosCustomer.get("7") != null)
				{
					wsResponse = sdhObligacionesPublicidadService.obligacionesRequest(obligacionesRequest);
					if (wsResponse != null)
					{
						final ObligacionesResponse obligacionesResponse = mapper.readValue(wsResponse, ObligacionesResponse.class);

						obligacionesFormuno.setHeader(obligacionesResponse.getHeader().stream()
								.filter(d -> StringUtils.isNotBlank(d.getNumResolucion())).collect(Collectors.toList()));
					}
				}

			}
			catch (final Exception e)
			{
				LOG.error("error generating declaration : " + e.getMessage());
			}


			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
			model.addAttribute("listaImpuestosCat", gasolinaService.obtenerListaImpuestosActivosCatC(customerData));
			model.addAttribute("listaImpuestosCatStr", gasolinaService.obtenerListaImpuestosActivosCStr(customerData));
		}
		else if (referrer.contains("retenedor") || referrer.contains("agenteRetenedor"))
		{

			final ReteicaObligacionesRequest reteicaRequest = new ReteicaObligacionesRequest();
			reteicaRequest.setBp(customerModel.getNumBP());

			try
			{

				if (listaImpuestosCustomer.get("4") != null)
				{
				wsResponseReteica = sdhReteICAInfObjetoService.reteIcaObligaciones(reteicaRequest);
				if (wsResponseReteica != null)
				{
						final ReteicaObligacionesResponse reteicaObligacionesResponse = mapper.readValue(wsResponseReteica,
							ReteicaObligacionesResponse.class);

					obligacionesFormuno.setHeaderreteica(reteicaObligacionesResponse.getHeader());
				}
				}

				model.addAttribute("listaImpuestosCat", gasolinaService.obtenerListaImpuestosActivosCatAR(customerData));
				model.addAttribute("listaImpuestosCatStr", gasolinaService.obtenerListaImpuestosActivosARStr(customerData));
			}
			catch (final Exception e)
			{
				LOG.error("error generating declaration : " + e.getMessage());
			}

			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_RETE));
		}
		else
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}


		model.addAttribute("obligacionesFormuno", obligacionesFormuno);
		model.addAttribute("customerData", customerData);
		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("errorSITII", errorSITII);



		storeCmsPageInModel(model, getContentPageForLabelOrId(OBLIGACIONES_PENDIENTES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(OBLIGACIONES_PENDIENTES_CMS_PAGE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	private String obtenerPeriodo(final String sCadena)
	{
		String idDestinos = sCadena;
		if (sCadena.equals("A1"))
		{
			return idDestinos = "Enero-Febrero";
		}
		else if (sCadena.equals("A2"))
		{
				return idDestinos = "Marzo-Abril";
		}
		else if (sCadena.equals("A3"))
		{
				return idDestinos = "Mayo-Junio";
		}
		else if (sCadena.equals("A4"))
		{
				return idDestinos = "Julio-Agosto";
		}
		else if (sCadena.equals("A5"))
		{
				return idDestinos = "Septiembre-Octubre";
		}
		else if (sCadena.equals("A6"))
		{
				return idDestinos = "Noviembre-Diciembre";
			}else {
				return idDestinos = "-";
			}
		}



}

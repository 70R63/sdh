/**
 *
 */
package de.hybris.sdh.storefront.controllers.declaraciones;


import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.DetalleVehiculosRequest;
import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesVista;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.DetalleVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.JuridicosVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHDetalleVehiculosService;
import de.hybris.sdh.core.services.SDHICAInfObjetoService;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaCatalogos;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaTabla;
import de.hybris.sdh.storefront.controllers.pages.InfoDelineacion;
import de.hybris.sdh.storefront.controllers.pages.InfoDelineacionInput;
import de.hybris.sdh.storefront.forms.VehiculosInfObjetoForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Federico Flores Dimas
 *
 */

@Controller
@SessionAttributes("dataForm")

public class PresentarDeclaracion extends AbstractSearchPageController
{


	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

	//Example Controller
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.presendecla";

	// CMS Pages
	private static final String PRESENTAR_DECLARACION_CMS_PAGE = "presentar-declaracion";
	private static final String REDIRECT_TO_PRESENTAR_DECLARACION_PAGE = REDIRECT_PREFIX + "/contribuyentes/presentar-declaracion";
	private static final String DECLARACIONES_GASOLINA_CMS_PAGE = "declaracion-gasolina";

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhConsultaPagoService")
	SDHConsultaPagoService sdhConsultaPagoService;

	@Resource(name = "sdhValidaContribuyenteService")
	SDHValidaContribuyenteService sdhValidaContribuyenteService;

	@Resource(name = "sdhICAInfObjetoService")
	SDHICAInfObjetoService sdhICAInfObjetoService;

	@Resource(name = "sdhDetalleVehiculosService")
	SDHDetalleVehiculosService sdhDetalleVehiculosService;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/presentar-declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_PD(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Presentar Declaracion GET --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos());
		//dataForm.setAnoGravable("2019");
		//dataForm.setPeriodo("1");
		if (customerData.getVehiculosTaxList() != null && !customerData.getVehiculosTaxList().isEmpty())
		{
			dataForm.setOptionVehicular("2");
		}
		if (customerData.getIcaTax() != null && customerData.getIcaTax().getObjectNumber() != null)
		{
			dataForm.setOptionIca("3");
		}
		if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
		{
			dataForm.setOptionPubliExt("4");
		}
		if (customerData.getGasTaxList() != null && !customerData.getGasTaxList().isEmpty())
		{
			dataForm.setOptionGas("5");
		}
		if (customerData.getUrbanDelineationsTaxList() != null && !customerData.getUrbanDelineationsTaxList().isEmpty())
		{
			dataForm.setOptionDeli("6");
		}
		if (customerData.getPredialTaxList() != null && !customerData.getPredialTaxList().isEmpty())
		{
			dataForm.setOptionPredial("1");
		}



		model.addAttribute("dataForm", dataForm);
		model.addAttribute("tpImpuesto",
				this.getTpImpuesto(dataForm.getOptionVehicular(), dataForm.getOptionGas(), dataForm.getOptionPubliExt(),
						dataForm.getOptionIca(),
						dataForm.getOptionDeli(), dataForm.getOptionPredial()));
		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("customerData", customerData);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}





	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/presentar-declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_ST(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataFormResponse, @RequestParam(value = "action", required = false)
	final String action, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Presentar Declaracion POST --------------------------");
		System.out.println("[" + dataFormResponse.getSkipReques() + "]");

		String URLdeterminada = "";
		System.out.println("acti:" + action);
		System.out.println("imp:" + dataFormResponse.getImpuesto());
		System.out.println("anio:" + dataFormResponse.getAnoGravable());
		System.out.println("per:" + dataFormResponse.getPeriodo());

		boolean isPeriodoAnual = false;

		if (action != null && action.equals("presentarDeclaracion"))
		{
			if (dataFormResponse.getImpuesto().equals("2") && !dataFormResponse.getAnoGravable().equals("")
					&& !dataFormResponse.getPeriodo().equals("") && !dataFormResponse.getSkipReques().equals("X"))
			{
				System.out.println("---------------- En ESTAS EN VEHICULOS --------------------------");

				final CustomerModel customerModel;
				final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
				final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
				final VehiculosInfObjetoForm vehiculosForm = new VehiculosInfObjetoForm();
				String numBP = "";
				String anioGravable = "";
				String placa = "";
				final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
				final DetGasResponse detalleResponse;
				final SobreTasaGasolinaCatalogos dataFormCatalogos = gasolinaService.prepararCatalogos();
				final List<SobreTasaGasolinaTabla> tablaDocs;
				final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
				SDHValidaMailRolResponse detalleContribuyente;
				String[] mensajesError;


				customerModel = (CustomerModel) userService.getCurrentUser();

				numBP = customerModel.getNumBP();

				contribuyenteRequest.setNumBP(numBP);

				detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService,
						LOG);
				if (detalleContribuyente.getIdmsj() != 0)
				{
					LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
					//					GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
					mensajesError = gasolinaService.prepararMensajesError(
							gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
					GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"error.impuestoGasolina.sobretasa.error2", mensajesError);
				}

				anioGravable = dataFormResponse.getAnoGravable();
				placa = detalleContribuyente.getVehicular().get(0).getPlaca();

				final DetalleVehiculosRequest detalleVehiculosRequest = new DetalleVehiculosRequest();
				detalleVehiculosRequest.setBpNum(numBP);
				detalleVehiculosRequest.setPlaca(placa);
				detalleVehiculosRequest.setAnioGravable(anioGravable);


				try
				{

					final ObjectMapper mapper = new ObjectMapper();
					mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

					final DetalleVehiculosResponse detalleVehiculosResponse = mapper.readValue(
							sdhDetalleVehiculosService.detalleVehiculos(detalleVehiculosRequest), DetalleVehiculosResponse.class);

					vehiculosForm.setDetalle(detalleVehiculosResponse.getDetalle());

					vehiculosForm.setIdServicio(detalleVehiculosResponse.getDetalle().getIdServicio());
					vehiculosForm.setIdEstado(detalleVehiculosResponse.getDetalle().getIdEstado());
					vehiculosForm.setWatts(detalleVehiculosResponse.getDetalle().getWatts());
					vehiculosForm.setClasicoAntig(detalleVehiculosResponse.getDetalle().getClasicoAntig());
					vehiculosForm.setTipoVeh(detalleVehiculosResponse.getDetalle().getTipoVeh());
					vehiculosForm.setCapacidadPas(detalleVehiculosResponse.getDetalle().getCapacidadPas());
					vehiculosForm.setCapacidadTon(detalleVehiculosResponse.getDetalle().getCapacidadTon());
					vehiculosForm.setNumForm(detalleVehiculosResponse.getInfo_declara().getInfoVeh().getNumForm());

					//			vehiculosForm.setFechaCambio(detalleVehiculosResponse.getDetalle().getFechaCambio());
					final String FechaCambio = detalleVehiculosResponse.getDetalle().getFechaCambio();
					if (StringUtils.isNotBlank(FechaCambio) && !"00000000".equals(FechaCambio))
					{
						final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

						final LocalDate localDate = LocalDate.parse(FechaCambio, formatter);

						final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

						vehiculosForm.setFechaCambio(localDate.format(formatter2));
					}

					if (detalleVehiculosResponse.getDatosJuridicos() != null
							&& !detalleVehiculosResponse.getDatosJuridicos().isEmpty())
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
							.filter(eachDetMarcas -> StringUtils.isNotBlank(eachDetMarcas.getCodigoMarca()))
							.collect(Collectors.toList()));

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
			}

			if (dataFormResponse.getImpuesto().equals("5") && !dataFormResponse.getAnoGravable().equals("")
					&& !dataFormResponse.getPeriodo().equals("") && !dataFormResponse.getSkipReques().equals("X"))
			{
				final CustomerModel customerModel;
				final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
				final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
				String numBP = "";
				String numDoc = "";
				String tipoDoc = "";
				String anioGravable = "";
				String periodo = "";
				final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
				final DetGasResponse detalleResponse;
				final SobreTasaGasolinaCatalogos dataFormCatalogos = gasolinaService.prepararCatalogos();
				List<SobreTasaGasolinaTabla> tablaDocs;
				final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
				SDHValidaMailRolResponse detalleContribuyente;
				String[] mensajesError;


				customerModel = (CustomerModel) userService.getCurrentUser();

				numBP = customerModel.getNumBP();
				numDoc = customerModel.getDocumentNumber();

				contribuyenteRequest.setNumBP(numBP);

				detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService,
						LOG);
				if (detalleContribuyente.getIdmsj() != 0)
				{
					LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
					//					GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
					mensajesError = gasolinaService.prepararMensajesError(
							gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
					GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"error.impuestoGasolina.sobretasa.error2", mensajesError);
				}


				tablaDocs = gasolinaService.prepararTablaDeclaracion(detalleContribuyente.getGasolina());

				if (tablaDocs != null)
				{
					for (int i = 0; i < tablaDocs.size(); i++)
					{
						if (!tablaDocs.get(i).toString().isEmpty())
						{
							tipoDoc = tablaDocs.get(i).getTipoDocumento();
							break;
						}
					}
				}
				anioGravable = dataFormResponse.getAnoGravable();
				periodo = dataFormResponse.getPeriodo();

				detalleGasolinaRequest.setNumBP(numBP);
				detalleGasolinaRequest.setNumDoc(numDoc);
				detalleGasolinaRequest.setTipoDoc(tipoDoc);
				detalleGasolinaRequest.setAnoGravable(anioGravable);
				detalleGasolinaRequest.setPeriodo(periodo);

				detalleResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
				dataForm.setDataForm(detalleResponse);

				dataForm.setNumBP(numBP);
				dataForm.setNumDoc(numDoc);
				dataForm.setTipoDoc(tipoDoc);
				dataForm.setAnoGravable(anioGravable);
				dataForm.setPeriodo(periodo);
				dataForm.setNAME_ORG1(detalleContribuyente.getInfoContrib().getAdicionales().getNAME_ORG1());
				dataForm.setImpuesto(dataFormResponse.getImpuesto());

				model.addAttribute("dataForm", dataForm);
				URLdeterminada = gasolinaService.obtenerURL("presentar-declaracion", "impuesto", "sobretasa-gasolina");

				return URLdeterminada;
			}
			else if (dataFormResponse.getImpuesto().equals("3") && !dataFormResponse.getAnoGravable().equals("")
					&& !dataFormResponse.getSkipReques().equals("X") && dataFormResponse.getPeriodicidadImpuesto() != null)
			{
				boolean redirecciona = false;

				switch (dataFormResponse.getPeriodicidadImpuesto())
				{
					case "0": //anual
						redirecciona = true;
						break;
					case "2": //bimestral
						if (dataFormResponse.getPeriodo() != null && !dataFormResponse.getPeriodo().isEmpty())
						{
							redirecciona = true;
						}
						break;

					default:
						break;
				}

				String periodoSeleccionado = "";
				if (dataFormResponse.getPeriodo() != null)
				{
					periodoSeleccionado = dataFormResponse.getPeriodo();
				}

				if (redirecciona)
				{
					redirectAttributes.addFlashAttribute("dataFormResponseICA", dataFormResponse);
					redirectAttributes.addFlashAttribute("periodoSeleccionado", periodoSeleccionado);
					return "redirect:/contribuyentes/ica/declaracion";
				}

			}
		}
		else
		{
			if (dataFormResponse.getImpuesto().equals("6") && !dataFormResponse.getAnoGravable().equals("X")
					&& !dataFormResponse.getAnoGravable().isEmpty())
			{
				final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
				final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
				final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
				SDHValidaMailRolResponse detalleContribuyente;
				final InfoDelineacion infoDelineacion = new InfoDelineacion();
				final InfoDelineacionInput infoDelineacionInput = new InfoDelineacionInput();
				String mensajeError = "";

				model.addAttribute("delineacionWithRadicadosList", sdhValidaContribuyenteService
						.getDelineacionListByBpAndYearWithRadicados(customerModel.getNumBP(), dataFormResponse.getAnoGravable()));

				contribuyenteRequest.setNumBP(customerModel.getNumBP());
				detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService,
						LOG);
				if (gasolinaService.ocurrioErrorValcont(detalleContribuyente) != true)
				{
					infoDelineacion.setValCont(detalleContribuyente);
				}
				else
				{
					mensajeError = detalleContribuyente.getTxtmsj();
					LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
					GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
				}

				//model.addAttribute("dataFormDelineacion", infoDelineacion);
				infoDelineacionInput.setSelectedAnoPresDeclaracion(dataFormResponse.getAnoGravable());
				model.addAttribute("inputDelineacion", infoDelineacionInput);



			}
			else if (dataFormResponse.getImpuesto().equals("4") && !dataFormResponse.getAnoGravable().equals("")
					&& !dataFormResponse.getPeriodo().equals("") && !dataFormResponse.getSkipReques().equals("X"))
			{
				final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
				final List<ImpuestoPublicidadExterior> publicidadExtList = sdhValidaContribuyenteService
						.getpublicidadExtListByBpAndYear(customerModel.getNumBP(), dataFormResponse.getAnoGravable());
				model.addAttribute("publicidadExtList", publicidadExtList);
				if (publicidadExtList == null || publicidadExtList.isEmpty())
				{
					GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"error.presentarDeclaracion.publicidadExt.listaVacia");
					GlobalMessages.addErrorMessage(model, "error.presentarDeclaracion.publicidadExt.listaVacia");
				}
			}
		}

		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		if (customerData.getVehiculosTaxList() != null && !customerData.getVehiculosTaxList().isEmpty())
		{
			dataForm.setOptionVehicular("2");
		}
		if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
		{
			dataForm.setOptionPubliExt("4");
		}
		if (customerData.getGasTaxList() != null && !customerData.getGasTaxList().isEmpty())
		{
			dataForm.setOptionGas("5");
		}
		if (customerData.getIcaTax() != null && dataFormResponse.getImpuesto().equals("3")
				&& !dataFormResponse.getAnoGravable().equals(""))
		{
			dataForm.setOptionIca("3");
			dataForm.setNumObjeto(customerData.getIcaTax().getObjectNumber());


			final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();
			ICAInfObjetoResponse icaInfObjetoResponse = new ICAInfObjetoResponse();

			icaInfObjetoRequest.setNumBP(customerData.getNumBP());
			icaInfObjetoRequest.setNumObjeto(customerData.getIcaTax().getObjectNumber());
			icaInfObjetoRequest.setAnoGravable(dataFormResponse.getAnoGravable());

			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


				String response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);
				response = response.replaceAll("(\"cantEstablec\":{1})(\\w*)(,)", "$1\"$2\"$3");

				icaInfObjetoResponse = mapper.readValue(response, ICAInfObjetoResponse.class);
				dataFormResponse.setPeriodicidadImpuesto("2"); //bimestral
				if (icaInfObjetoResponse.getRegimen() != null)
				{
					if (icaInfObjetoResponse.getRegimen().charAt(0) != '3')
					{
						isPeriodoAnual = true;
						dataFormResponse.setPeriodo("");
						dataFormResponse.setPeriodicidadImpuesto("0");//anual
					}
				}


			}
			catch (final Exception e)
			{
				LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());
			}
		}

		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos());
		dataForm.setImpuesto(dataFormResponse.getImpuesto());
		dataForm.setAnoGravable(dataFormResponse.getAnoGravable());
		dataForm.setPeriodo(dataFormResponse.getPeriodo());
		dataForm.setPeriodicidadImpuesto(dataFormResponse.getPeriodicidadImpuesto());

		if (customerData.getVehiculosTaxList() != null && !customerData.getVehiculosTaxList().isEmpty())
		{
			dataForm.setOptionVehicular("2");
		}
		if (customerData.getIcaTax() != null && customerData.getIcaTax().getObjectNumber() != null)
		{
			dataForm.setOptionIca("3");
		}
		if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
		{
			dataForm.setOptionPubliExt("4");
		}
		if (customerData.getGasTaxList() != null && !customerData.getGasTaxList().isEmpty())
		{
			dataForm.setOptionGas("5");
		}
		if (customerData.getUrbanDelineationsTaxList() != null && !customerData.getUrbanDelineationsTaxList().isEmpty())
		{
			dataForm.setOptionDeli("6");
		}
		if (customerData.getPredialTaxList() != null && !customerData.getPredialTaxList().isEmpty())
		{
			dataForm.setOptionPredial("1");
		}
		model.addAttribute("tpImpuesto", this.getTpImpuesto(dataForm.getOptionVehicular(), dataForm.getOptionGas(),
				dataForm.getOptionPubliExt(), dataForm.getOptionIca(), dataForm.getOptionDeli(), dataForm.getOptionPredial()));


		model.addAttribute("dataForm", dataForm);
		model.addAttribute("icaPeriodo", this.getIcaPeriodo());
		model.addAttribute("icaAnioGravable", this.getIcaAnoGravable());
		model.addAttribute("isPeriodoAnual", isPeriodoAnual);
		model.addAttribute("tpImpuesto", this.getTpImpuesto(dataForm.getOptionGas(), dataForm.getOptionPubliExt(),
				dataForm.getOptionDeli(), dataForm.getOptionIca(), dataForm.getOptionVehicular(), dataForm.getOptionPredial()));
		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());

		storeCmsPageInModel(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return getViewForPage(model);
	}

	private Map<String, String> getTpImpuesto(final String optionVehicular, final String optionGas, final String optionPubExt,
			final String optionIca, final String optionDeli, final String predial)
	{
		final Map<String, String> map = new HashMap<String, String>();
		map.put("0", "Seleccionar");

		if (!StringUtils.isEmpty(optionGas) || !StringUtils.isEmpty(optionPubExt) || !StringUtils.isEmpty(optionIca)
				|| !StringUtils.isEmpty(optionDeli) || !StringUtils.isEmpty(optionVehicular) || !StringUtils.isEmpty(predial))
		{

			if (!StringUtils.isEmpty(optionVehicular))
			{
				map.put("2", "Impuestos de Vehículos");
			}

			if (!StringUtils.isEmpty(optionIca))
			{
				map.put("3", "ICA");
			}
			if (!StringUtils.isEmpty(optionPubExt))
			{
				map.put("4", "Publicidad Exterior");
			}
			if (!StringUtils.isEmpty(optionGas))
			{
				map.put("5", "Sobretasa Gasolina");
			}
			if (!StringUtils.isEmpty(optionDeli))
			{
				map.put("6", "Delineacion Urbana");
			}

			if (!StringUtils.isEmpty(predial))
			{
				map.put("1", "Predial");
			}

		}

		return map;
	}


	private Map<String, String> getIcaPeriodo()
	{
		final Map<String, String> map;
		map = new HashMap<String, String>();
		map.put("", "Seleccionar");
		map.put("01", "1 - Ene / Feb");
		map.put("02", "2 - Mar / Abr");
		map.put("03", "3 - May / Jun");
		map.put("04", "4 - Jul / Ago");
		map.put("05", "5 - Sep / Oct");
		map.put("06", "6 - Nov / Dic");

		return map;
	}

	private Map<String, String> getIcaAnoGravable()
	{
		final Map<String, String> map;
		map = new HashMap<String, String>();
		map.put("", "Seleccionar");
		map.put("2019", "2019");
		map.put("2018", "2018");
		map.put("2017", "2017");
		map.put("2016", "2016");

		return map;
	}


	@RequestMapping(value = "/contribuyentes/presentar-declaracion/listaDeclaraciones", method = RequestMethod.GET)
	@ResponseBody
	public OpcionDeclaracionesVista listaDeclaracionesGET(@ModelAttribute("infoVista")
	final OpcionDeclaracionesVista infoVista, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------En GET Presentar declaracion lista declaraciones------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final String periodo = "";
		final String numBP = customerModel.getNumBP();

		infoVista.setUrlDownload(null);
		infoVista.setPublicidadExt(null);
		infoVista.setGasolina(null);
		infoVista.setDelineacion(null);
		infoVista.setIca(null);
		infoVista.setReteIca(null);
		infoVista.setErrores(null);
		infoVista.setPredial(null);

		//		if (infoVista.getCustomerData() == null)
		//		{
		//
		//			infoVista.setCustomerData(sdhCustomerFacade.getRepresentadoFromSAP(customerModel.getNumBP()));
		//		}
		if (infoVista.getClaveImpuesto().equals("2"))
		{
			final List<ImpuestoVehiculos> listaInfoVehiculos = new ArrayList<ImpuestoVehiculos>();
			ImpuestoVehiculos infoVehiculos = null;
			DetalleVehiculosResponse detalleVehiculosResponse = null;

			for (final ImpuestoVehiculos impuesto_element : sdhCustomerFacade.getRepresentadoFromSAP(numBP)
					.getVehicular())
			{
				if (!impuesto_element.getPlaca().isEmpty())
				{
					infoVehiculos = new ImpuestoVehiculos();
					infoVehiculos.setPlaca(impuesto_element.getPlaca());
					infoVehiculos.setMarca(impuesto_element.getMarca());
					infoVehiculos.setLinea(impuesto_element.getLinea());
					infoVehiculos.setModelo(impuesto_element.getModelo());
					infoVehiculos.setClase(impuesto_element.getClase());
					infoVehiculos.setCarroceria(impuesto_element.getCarroceria());
					infoVehiculos.setNumPuertas(impuesto_element.getNumPuertas());
					infoVehiculos.setBlindado(impuesto_element.getBlindado());
					infoVehiculos.setCilindraje(impuesto_element.getCilindraje());
					infoVehiculos.setNumObjeto(impuesto_element.getNumObjeto());
					infoVehiculos.setAnioGravable(impuesto_element.getAnioGravable());

					final DetalleVehiculosRequest detalleVehiculosRequest = new DetalleVehiculosRequest();
					detalleVehiculosRequest.setBpNum(numBP);
					detalleVehiculosRequest.setPlaca(impuesto_element.getPlaca());
					detalleVehiculosRequest.setAnioGravable(infoVista.getAnoGravable());


					final ObjectMapper mapper = new ObjectMapper();
					mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

					try
					{
						detalleVehiculosResponse = mapper.readValue(
								sdhDetalleVehiculosService.detalleVehiculos(detalleVehiculosRequest), DetalleVehiculosResponse.class);
						if (detalleVehiculosResponse.getInfo_declara() != null
								&& detalleVehiculosResponse.getInfo_declara().getInfoVeh() != null)
						{
							infoVehiculos.setNumForm(detalleVehiculosResponse.getInfo_declara().getInfoVeh().getNumForm());
							infoVehiculos.setErrores(detalleVehiculosResponse.getInfo_declara().getErrores());
						}
					}
					catch (final Exception e)
					{
						LOG.error("Error en la respuesta del servicio detalle de Vehiculos " + e.getMessage());
					}

					listaInfoVehiculos.add(infoVehiculos);
				}
			}
			infoVista.setVehicular(listaInfoVehiculos);
			infoVista.setNumBP(numBP);
		}
		else if (infoVista.getClaveImpuesto().equals("1")) //predial
		{
			final List<PredialResponse> predial_listaInicial = sdhCustomerFacade.getRepresentadoFromSAP(numBP).getPredial();
			List<PredialResponse> predial_filtrado = null;

			//			obligacionesFormuno.setHeaderdeli(obligacionesDeliResponse.getHeader().stream()
			//					.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));

			//			predial_filtrado = predial_listaInicial.stream().filter(d -> StringUtils.isNotBlank(d.getCHIP()))
			//					.collect(Collectors.toList());

			predial_filtrado = predial_listaInicial.stream().filter(d -> infoVista.getAnoGravable().equals(d.getAnioGravable()))
					.collect(Collectors.toList());

			infoVista.setPredial(predial_filtrado);
			infoVista.setNumBP(numBP);
		}


		return infoVista;
	}



}

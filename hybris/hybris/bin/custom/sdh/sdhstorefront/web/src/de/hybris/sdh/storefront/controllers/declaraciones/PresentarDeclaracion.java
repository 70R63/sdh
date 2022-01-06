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
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribPredialRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.DetallePublicidadRequest;
import de.hybris.sdh.core.pojos.requests.DetalleVehiculosRequest;
import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesVista;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.pojos.responses.DetalleVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbanaWithRadicados;
import de.hybris.sdh.core.pojos.responses.ImpuestoICA;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.JuridicosVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConfigCatalogos;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHDetallePublicidadService;
import de.hybris.sdh.core.services.SDHDetalleVehiculosService;
import de.hybris.sdh.core.services.SDHICAInfObjetoService;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.questions.data.SDHICATaxData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaCatalogos;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaTabla;
import de.hybris.sdh.storefront.controllers.pages.InfoDelineacion;
import de.hybris.sdh.storefront.controllers.pages.InfoDelineacionInput;
import de.hybris.sdh.storefront.forms.PublicidadForm;
import de.hybris.sdh.storefront.forms.SobreTasaGasolinaControlCamposDec;
import de.hybris.sdh.storefront.forms.VehiculosInfObjetoForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


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

	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

	@Resource(name = "sdhCustomerAccountService")
	private SDHCustomerAccountService sdhCustomerAccountService;
	
	@Resource(name = "sdhDetallePublicidadService")
	SDHDetallePublicidadService sdhDetallePublicidadService;
	
	@Resource(name = "sdhConfigCatalogos")
	SDHConfigCatalogos sdhConfigCatalogos;



	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/presentar-declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_PD(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Presentar Declaracion GET --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos(sdhConfigCatalogos));
		//dataForm.setAnoGravable("2019");
		//dataForm.setPeriodo("1");
		obtenerListaImpuestosCliente(customerModel, dataForm);


		model.addAttribute("dataForm", dataForm);
		model.addAttribute("tpImpuesto", this.getTpImpuesto(dataForm.getOptionVehicular(), dataForm.getOptionGas(),
				dataForm.getOptionPubliExt(), dataForm.getOptionIca(), dataForm.getOptionDeli(), dataForm.getOptionPredial()));

		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());
		model.addAttribute("customerData", customerData);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	/**
	 * @param customerModel
	 * @param dataForm
	 */
	private void obtenerListaImpuestosCliente(final CustomerModel customerModel, final SobreTasaGasolinaForm dataForm)
	{
		Map<String, String> impuestosActivos = sdhConsultaImpuesto_simplificado.obtenerListaImpuestosActivos(sdhConsultaImpuesto_simplificado.ambito_presentarDeclaracion);
		final Set<PrincipalGroupModel> groupList = customerModel.getGroups();


		for (final PrincipalGroupModel group : groupList)
		{
			String groupUid = null;
			
			if(group != null && group.getUid() != null) {
				groupUid = group.getUid();

   			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.predial) && groupUid.contains("predialUsrTaxGrp"))
   			{
   				dataForm.setOptionPredial("1");
   				continue;
   			}
   			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.vehiculos) && groupUid.contains("vehicularUsrTaxGrp"))
   			{
   				dataForm.setOptionVehicular("2");
   				continue;
   			}
   			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.ica) && groupUid.contains("ICAUsrTaxGrp"))
   			{
   				dataForm.setOptionIca("3");
   				continue;
   			}
   			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.gasolina) && groupUid.contains("gasolinaUsrTaxGrp"))
   			{
   				dataForm.setOptionGas("5");
   				continue;
   			}
   			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.delineacion) && groupUid.contains("delineacionUsrTaxGrp"))
   			{
   				dataForm.setOptionDeli("6");
   				continue;
   			}
   			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.publicidad) && groupUid.contains("publicidadExtUsrTaxGrp"))
   			{
   				dataForm.setOptionPubliExt("4");
   				continue;
   			}
			}
		}


	}


	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/presentar-declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_ST(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataFormResponse, @RequestParam(value = "action", required = false)
	final String action, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- Presentar Declaracion POST --------------------------");
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
				final SobreTasaGasolinaCatalogos dataFormCatalogos = gasolinaService.prepararCatalogos(sdhConfigCatalogos);
				final List<SobreTasaGasolinaTabla> tablaDocs;
				final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
				final SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();
				final String[] mensajesError;


				customerModel = (CustomerModel) userService.getCurrentUser();

				numBP = customerModel.getNumBP();

				contribuyenteRequest.setNumBP(numBP);

				detalleContribuyente.setVehicular(sdhConsultaImpuesto_simplificado.consulta_impVehicular(contribuyenteRequest));
				anioGravable = dataFormResponse.getAnoGravable();
				if (detalleContribuyente != null && detalleContribuyente.getVehicular() != null
						&& detalleContribuyente.getVehicular().get(0) != null)
				{
					placa = detalleContribuyente.getVehicular().get(0).getPlaca();
				}

				final DetalleVehiculosRequest detalleVehiculosRequest = new DetalleVehiculosRequest();
				detalleVehiculosRequest.setBpNum(numBP);
				detalleVehiculosRequest.setPlaca(placa);
				detalleVehiculosRequest.setAnioGravable(anioGravable);


				try
				{

					final ObjectMapper mapper = new ObjectMapper();
					mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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
				CustomerModel customerModel = null;
				final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
				final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
				String numBP = "";
				String numDoc = "";
				String tipoDoc = "";
				String anioGravable = "";
				String periodo = "";
				final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
				DetGasResponse detalleResponse = null;
				final SobreTasaGasolinaCatalogos dataFormCatalogos = gasolinaService.prepararCatalogos(sdhConfigCatalogos);
				List<SobreTasaGasolinaTabla> tablaDocs = null;
				final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
				SDHValidaMailRolResponse detalleContribuyente = null;
				final SDHValidaMailRolResponse detalleContribuyente_temp = null;
				final String[] mensajesError = null;
				String mensajeError = null;


				customerModel = (CustomerModel) userService.getCurrentUser();

				numBP = customerModel.getNumBP();
				numDoc = customerModel.getDocumentNumber();

				contribuyenteRequest.setNumBP(numBP);

				detalleContribuyente = new SDHValidaMailRolResponse();
				detalleContribuyente.setGasolina(sdhConsultaImpuesto_simplificado.consulta_impGasolina(contribuyenteRequest));
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
				if (dataForm != null)
				{
					dataForm.setControlCampos(new SobreTasaGasolinaControlCamposDec());
					dataForm.getControlCampos().setPasarALiquidador(true);
					dataForm.setMensajeError(null);

					if (detalleResponse != null && detalleResponse.getErrores() != null)
					{
						for (final ErrorEnWS etemp : detalleResponse.getErrores())
						{
							if (etemp != null && etemp.getIdmsj() != null && etemp.getIdmsj().equals("200"))
							{
								dataForm.getControlCampos().setPasarALiquidador(false);
								dataForm.setMensajeError(etemp.getTxtmsj());
								mensajeError = etemp.getTxtmsj();
							}
						}
					}
				}

				if (mensajeError != null)
				{
					GlobalMessages.addErrorMessage(model, mensajeError);

					obtenerListaImpuestosCliente(customerModel, dataForm);
					model.addAttribute("tpImpuesto",
							this.getTpImpuesto(dataForm.getOptionVehicular(), dataForm.getOptionGas(), dataForm.getOptionPubliExt(),
									dataForm.getOptionIca(), dataForm.getOptionDeli(), dataForm.getOptionPredial()));
					model.addAttribute("dataForm", dataForm);
					model.addAttribute("icaPeriodo", this.getIcaPeriodo());
					model.addAttribute("icaAnioGravable", this.getIcaAnoGravable());
					model.addAttribute("isPeriodoAnual", isPeriodoAnual);
					model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());

					storeCmsPageInModel(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
					setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
					model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
					model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


					return getViewForPage(model);
				}
				dataForm.setDataForm(detalleResponse);

				dataForm.setNumBP(numBP);
				dataForm.setNumDoc(numDoc);
				dataForm.setTipoDoc(tipoDoc);
				dataForm.setAnoGravable(anioGravable);
				dataForm.setPeriodo(periodo);
				if (customerModel != null)
				{
					dataForm.setNAME_ORG1(customerModel.getNameOrg1());
				}
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

				final List<ImpuestoDelineacionUrbanaWithRadicados> delineacionWithRadicadosList = sdhValidaContribuyenteService
						.getDelineacionListByBpAndYearWithRadicados(customerModel.getNumBP(), dataFormResponse.getAnoGravable());
				if (delineacionWithRadicadosList == null || delineacionWithRadicadosList.isEmpty())
				{
					GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"error.presentarDeclaracion.publicidadExt.listaVacia");
					GlobalMessages.addErrorMessage(model, "error.presentarDeclaracion.publicidadExt.listaVacia");
				}
				model.addAttribute("delineacionWithRadicadosList", delineacionWithRadicadosList);

				contribuyenteRequest.setNumBP(customerModel.getNumBP());
				//detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService,
				//		LOG);

				detalleContribuyente = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "06");

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


		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		consultaContribuyenteBPRequest.setNumBP(customerData.getNumBP());

		if (dataFormResponse.getImpuesto().equals("3"))
		{
			final ImpuestoICA icaWS = sdhConsultaImpuesto_simplificado.consulta_impICA(consultaContribuyenteBPRequest);
			final SDHICATaxData icaTax = new SDHICATaxData();
			if (icaWS != null)
			{
				icaTax.setObjectNumber(icaWS.getNumObjeto());
				if (customerData != null)
				{
					customerData.setIcaTax(icaTax);
				}
			}
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
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


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

		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos(sdhConfigCatalogos));
		dataForm.setImpuesto(dataFormResponse.getImpuesto());
		dataForm.setAnoGravable(dataFormResponse.getAnoGravable());
		dataForm.setPeriodo(dataFormResponse.getPeriodo());
		dataForm.setPeriodicidadImpuesto(dataFormResponse.getPeriodicidadImpuesto());

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		obtenerListaImpuestosCliente(customerModel, dataForm);


		model.addAttribute("tpImpuesto", this.getTpImpuesto(dataForm.getOptionVehicular(), dataForm.getOptionGas(),
				dataForm.getOptionPubliExt(), dataForm.getOptionIca(), dataForm.getOptionDeli(), dataForm.getOptionPredial()));
		model.addAttribute("dataForm", dataForm);
		model.addAttribute("icaPeriodo", this.getIcaPeriodo());
		model.addAttribute("icaAnioGravable", this.getIcaAnoGravable());
		model.addAttribute("isPeriodoAnual", isPeriodoAnual);
		//		model.addAttribute("tpImpuesto", this.getTpImpuesto(dataForm.getOptionGas(), dataForm.getOptionPubliExt(),
		//				dataForm.getOptionDeli(), dataForm.getOptionIca(), dataForm.getOptionVehicular(), dataForm.getOptionPredial()));
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
				map.put("5", "Sobretasa a la gasolina motor");
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


		if (infoVista.getClaveImpuesto().equals("2"))
		{
			infoVista.setVehicular(obtenerListaVehicular(customerModel, infoVista));
			infoVista.setNumBP(numBP);
		}
		else if (infoVista.getClaveImpuesto().equals("1")) //predial
		{
			infoVista.setPredial(obtenerListaPredial(customerModel, infoVista));
			infoVista.setNumBP(numBP);
		}


		return infoVista;
	}

	public List<ImpuestoVehiculos> obtenerListaVehicular(final CustomerModel customerModel,
			final OpcionDeclaracionesVista infoVista)
	{
		List<ImpuestoVehiculos> listaInfoVehiculos = null;
		List<ImpuestoVehiculos> impuestoVehiculos = null;
		String numBP = null;
		if (customerModel != null)
		{
			numBP = customerModel.getNumBP();
			if (numBP != null)
			{
				final ConsultaContribPredialRequest consultaContribuyenteBPRequest = new ConsultaContribPredialRequest();
				consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());
				consultaContribuyenteBPRequest.setAnioGravable(infoVista.getAnoGravable());
				impuestoVehiculos = sdhConsultaImpuesto_simplificado.consulta_impVehicular2(consultaContribuyenteBPRequest);
				sdhCustomerAccountService.updateImpuestoVehicular_simplificado(customerModel, impuestoVehiculos);
				//				final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = new SDHValidaMailRolResponse();
				//				sdhConsultaContribuyenteBPResponse.setVehicular(impuestoVehiculos);
				listaInfoVehiculos = new ArrayList<ImpuestoVehiculos>();
			}
		}

		ImpuestoVehiculos infoVehiculos = null;
		//			DetalleVehiculosResponse detalleVehiculosResponse = null;
		if (impuestoVehiculos != null)
		{
			for (final ImpuestoVehiculos impuesto_element : impuestoVehiculos)
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

					//					final DetalleVehiculosRequest detalleVehiculosRequest = new DetalleVehiculosRequest();
					//					detalleVehiculosRequest.setBpNum(numBP);
					//					detalleVehiculosRequest.setPlaca(impuesto_element.getPlaca());
					//					detalleVehiculosRequest.setAnioGravable(infoVista.getAnoGravable());


					//					final ObjectMapper mapper = new ObjectMapper();
					//					mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					//
					//					try
					//					{
					//						detalleVehiculosResponse = mapper.readValue(
					//								sdhDetalleVehiculosService.detalleVehiculos(detalleVehiculosRequest), DetalleVehiculosResponse.class);
					//						if (detalleVehiculosResponse.getInfo_declara() != null
					//								&& detalleVehiculosResponse.getInfo_declara().getInfoVeh() != null)
					//						{
					//							infoVehiculos.setNumForm(detalleVehiculosResponse.getInfo_declara().getInfoVeh().getNumForm());
					//							infoVehiculos.setErrores(detalleVehiculosResponse.getInfo_declara().getErrores());
					//						}
					//					}
					//					catch (final Exception e)
					//					{
					//						LOG.error("Error en la respuesta del servicio detalle de Vehiculos " + e.getMessage());
					//					}

					listaInfoVehiculos.add(infoVehiculos);
				}
			}
		}

		return listaInfoVehiculos;
	}


	public List<PredialResponse> obtenerListaPredial(final CustomerModel customerModel, final OpcionDeclaracionesVista infoVista)
	{
		List<PredialResponse> listaInfoImpuesto = null;
		List<PredialResponse> impuestoWS = null;
		String numBP = null;
		if (customerModel != null)
		{
			numBP = customerModel.getNumBP();
			if (numBP != null)
			{
				final ConsultaContribPredialRequest consultaContribuyenteBPRequest = new ConsultaContribPredialRequest();
				consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());
				consultaContribuyenteBPRequest.setAnioGravable(infoVista.getAnoGravable());
				impuestoWS = sdhConsultaImpuesto_simplificado.consulta_impPredial2(consultaContribuyenteBPRequest);
				//				sdhCustomerAccountService.updateImpuestoP(customerModel, impuestoWS);
				listaInfoImpuesto = new ArrayList<PredialResponse>();
			}
		}

		PredialResponse infoImpuesto = null;
		if (impuestoWS != null)
		{
			for (final PredialResponse impuesto_element : impuestoWS)
			{
				if (impuesto_element != null && impuesto_element.getAnioGravable() != null
//						&& impuesto_element.getAnioGravable().equals(infoVista.getAnoGravable())
						)
				{
					infoImpuesto = new PredialResponse();
					infoImpuesto.setAnioGravable(impuesto_element.getAnioGravable());
					infoImpuesto.setCHIP(impuesto_element.getCHIP());
					infoImpuesto.setContratoArrenda(impuesto_element.getContratoArrenda());
					infoImpuesto.setDireccionPredio(impuesto_element.getDireccionPredio());
					infoImpuesto.setMatrInmobiliaria(impuesto_element.getMatrInmobiliaria());
					infoImpuesto.setNumObjeto(impuesto_element.getNumObjeto());

					listaInfoImpuesto.add(infoImpuesto);
				}
			}
		}

		return listaInfoImpuesto;
	}
	
	
	@RequestMapping(value = "/contribuyentes/presentar-declaracion/validacionPublicidad", method = RequestMethod.GET)
	@ResponseBody
	public PublicidadForm publicidadExternaDetail(@ModelAttribute("publicidadInfo")
	final PublicidadForm publicidadInfo, final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final PublicidadForm publicidadForm = new PublicidadForm();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();
		final String opcionUso = null;
		final String numBP = customerData.getNumBP();


		detallePublicidadRequest.setNumBP(numBP);
		detallePublicidadRequest.setNumResolu(publicidadInfo.getNumResolu());
		detallePublicidadRequest.setAnoGravable(publicidadInfo.getAnoGravable());
		detallePublicidadRequest.setTipoValla(publicidadInfo.getTipoValla());
		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String wsResponse = sdhDetallePublicidadService.detallePublicidad(detallePublicidadRequest);
			wsResponse = wsResponse.replace("\"},\"\"", "\"}");
			final DetallePublicidadResponse detallePublicidadResponse = mapper.readValue(wsResponse , DetallePublicidadResponse.class);

			if(detallePublicidadResponse != null) {
				publicidadForm.setErrores(detallePublicidadResponse.getErrores());
				if(detallePublicidadResponse.getInfoDeclara() != null) {
					publicidadForm.setOpcionUso(detallePublicidadResponse.getInfoDeclara().getOpcionUso());
				}
			}
		
		}
		catch (final Exception e)
		{
			LOG.error("error getting details for publicidad object : " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		return publicidadForm;
	}



	@RequestMapping(value = "/setComplete7", method = RequestMethod.POST)
	public String setComplete(final SessionStatus status)
	{
		status.setComplete();

		return null;
	}



}

/**
 *
 */
package de.hybris.sdh.storefront.controllers.consultas;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.EdoCuentaRequest;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.EdoCtaPredial;
import de.hybris.sdh.core.pojos.responses.EdoCtaPublicidad;
import de.hybris.sdh.core.pojos.responses.EdoCuentaResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConfigCatalogos;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHEdoCuentaService;
import de.hybris.sdh.facades.questions.data.SDHExteriorPublicityTaxData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaCatalogos;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaTabla;
import de.hybris.sdh.storefront.controllers.pages.InfoDelineacion;
import de.hybris.sdh.storefront.forms.EdoCuentaForm;
import de.hybris.sdh.storefront.forms.MiRitForm;
import de.hybris.sdh.storefront.forms.PredialForm;
import de.hybris.sdh.storefront.forms.PublicidadForm;
import de.hybris.sdh.storefront.forms.VehiculosInfObjetoForm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Federico Flores Dimas
 *
 */

@Controller
@SessionAttributes("dataForm")

public class ConsultaEstado extends AbstractSearchPageController
{


	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

	//Example Controller
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.estadocuenta";
	private static final String TEXT_ACCOUNT_PROFILE_RETE = "text.account.profile.edoctaRETE";

	// CMS Pages
	private static final String ESTADO_DE_CUENTA_CMS_PAGE = "estado-de-cuenta";
	private static final String REDIRECT_TO_ESTADO_DE_CUENTA_PAGE = REDIRECT_PREFIX + "/contribuyentes/estado-de-cuenta";


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

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sdhEdoCuentaService")
	SDHEdoCuentaService sdhEdoCuentaService;

	@Resource(name = "sdhCustomerAccountService")
	SDHCustomerAccountService sdhCustomerAccountService;

	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

	@Resource(name = "sdhConfigCatalogos")
	SDHConfigCatalogos sdhConfigCatalogos;


	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value =
	{ "/contribuyentes/estado-de-cuenta", "/agenteRetenedor/estado-de-cuenta" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_PD(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Estado de Cuenta GET --------------------------");
		String referrer = request.getHeader("referer");
		if (referrer == null)
		{
			referrer = request.getServletPath();
		}

		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		dataForm.setCatalogosSo(gasolinaService.prepararCatalogos(sdhConfigCatalogos));
		model.addAttribute("dataForm", dataForm);

		final EdoCuentaForm ctaForm = new EdoCuentaForm();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final EdoCuentaRequest edoCuentaRequest = new EdoCuentaRequest();

		ctaForm.setCompleName(customerData.getCompleteName());
		ctaForm.setTipoDoc(customerData.getDocumentType());
		ctaForm.setNumBP(customerModel.getNumBP());
		ctaForm.setNumDoc(customerData.getDocumentNumber());

		try
		{
			edoCuentaRequest.setBp(customerModel.getNumBP());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String responseStr = sdhEdoCuentaService.detalleEdoCta(edoCuentaRequest);
			responseStr = responseStr.replace(",\"\"]},{\"detalleReteica\":[\"\",\"\"]}", "]}");
			responseStr = responseStr.replace(",{\"detalleReteica\":[\"\",\"\"]}", "");
			responseStr = responseStr.replace("{\"detalleReteica\":[\"\",\"\"]}", "");
			responseStr = responseStr.replace("[{\"detalleReteica\":[\"\"]}],",
					"[{\"detalleReteica\":[{\"anioGravable\":\"\",\"periodo\":\"\",\"estado\":\"\",\"saldoCargo\":\"\",\"saldoFavor\":\"\"}]}],");
			responseStr = responseStr.replace(",\"detalleReteica\":[\"\"]}", "}");

			System.out.println("---------------- Despues de ajustes --------------------------");
			System.out.println(responseStr);

			final EdoCuentaResponse edoCuentaResponse = mapper.readValue(responseStr, EdoCuentaResponse.class);



			ctaForm.setCompleName(customerData.getCompleteName());
			ctaForm.setTipoDoc(customerData.getDocumentType());
			ctaForm.setNumBP(customerModel.getNumBP());
			ctaForm.setTasaInteres(edoCuentaResponse.getTasaInteres());
			ctaForm.setPredialSaldoCargo(edoCuentaResponse.getNewPredialSaldoCargo());
			ctaForm.setPredialSaldoFavor(edoCuentaResponse.getNewPredialSaldoFavor());
			ctaForm.setiCASaldoCargo(edoCuentaResponse.getNewICASaldoCargo());
			ctaForm.setiCASaldoFavor(edoCuentaResponse.getNewICASaldoFavor());
			ctaForm.setVehicularSaldoCargo(edoCuentaResponse.getNewVehicularSaldoCargo());
			ctaForm.setVehicularSaldoFavor(edoCuentaResponse.getNewVehicularSaldoFavor());
			ctaForm.setDelineacionSaldoCargo(edoCuentaResponse.getNewDelineacionSaldoCargo());
			ctaForm.setDelineacionSaldoFavor(edoCuentaResponse.getNewDelineacionSaldoFavor());
			ctaForm.setGasolinaSaldoCargo(edoCuentaResponse.getNewGasolinaSaldoCargo());
			ctaForm.setGasolinaSaldoFavor(edoCuentaResponse.getNewGasolinaSaldoFavor());
			ctaForm.setPublicidadSaldoCargo(edoCuentaResponse.getNewPublicidadSaldoCargo());
			ctaForm.setPublicidadSaldoFavor(edoCuentaResponse.getNewPublicidadSaldoFavor());


			final Map<String, String> impuestosActivos = sdhConsultaImpuesto_simplificado.obtenerListaImpuestosActivos(sdhConsultaImpuesto_simplificado.AMBITO_CONSULTAS);

			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.PREDIAL) && edoCuentaResponse.getPredial() != null && !edoCuentaResponse.getPredial().isEmpty())
			{
				ctaForm.setPredial(
						edoCuentaResponse.getPredial().stream().filter(eachTax -> (StringUtils.isNotBlank(eachTax.getNewCHIP())
								|| StringUtils.isNotBlank(eachTax.getMatrInmobiliaria()))).collect(Collectors.toList()));
			}

			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.ICA) && edoCuentaResponse.getTablaICA() != null && !edoCuentaResponse.getTablaICA().isEmpty())
			{
				ctaForm.setTablaICA(
						edoCuentaResponse.getTablaICA().stream().filter(
								eachTax -> (StringUtils.isNotBlank(eachTax.getNumDoc()) || StringUtils.isNotBlank(eachTax.getTipoDoc())))
								.collect(Collectors.toList()));
				ctaForm.setTablaICA(edoCuentaResponse.getTablaICA().stream()
						.filter(
								eachTax -> (StringUtils.isNotBlank(eachTax.getNumDoc()) || StringUtils.isNotBlank(eachTax.getTipoDoc())))
						.collect(Collectors.toList()));
			}

			//cambios para reteica
			ctaForm.setReteica(edoCuentaResponse.getReteica());
			ctaForm.setReteicaSaldoFavor(edoCuentaResponse.getNewReteicaSaldoFavor());
			ctaForm.setReteicaSaldoCargo(edoCuentaResponse.getNewReteicaSaldoCargo());
			//termina reteica

			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.VEHICULOS) && edoCuentaResponse.getTablaVehicular() != null && !edoCuentaResponse.getTablaVehicular().isEmpty())
			{
				ctaForm.setTablaVehicular(edoCuentaResponse.getTablaVehicular().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getPlaca())).collect(Collectors.toList()));
			}
			//ctaForm.setTablaVehicular(edoCuentaResponse.getTablaVehicular());
			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.DELINEACION) && edoCuentaResponse.getTablaDelineacion() != null && !edoCuentaResponse.getTablaDelineacion().isEmpty())
			{
				ctaForm.setTablaDelineacion(edoCuentaResponse.getTablaDelineacion().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNewCDU())).collect(Collectors.toList()));
			}
			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.GASOLINA) && edoCuentaResponse.getTablaGasolina() != null && !edoCuentaResponse.getTablaGasolina().isEmpty())
			{
				ctaForm.setTablaGasolina(edoCuentaResponse.getTablaGasolina().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getTipoDocumento())).collect(Collectors.toList()));
			}
			if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.PUBLICIDAD) && edoCuentaResponse.getTablaPublicidad() != null && !edoCuentaResponse.getTablaPublicidad().isEmpty())
			{
				ctaForm.setTablaPublicidad(edoCuentaResponse.getTablaPublicidad().stream().filter(eachTax ->
				(StringUtils.isNotBlank(eachTax.getCabecera().getNoResolucion())
				&& (StringUtils.isNotBlank(eachTax.getCabecera().getTipoValla()) ||
				StringUtils.isNotBlank(eachTax.getCabecera().getSaldocargo()) ||
				StringUtils.isNotBlank(eachTax.getCabecera().getSaldofavor()))
				)).collect(Collectors.toList()));
				for (final EdoCtaPublicidad iterable_element : ctaForm.getTablaPublicidad())
				{
					iterable_element.setDetallePublicidad(iterable_element.getDetallePublicidad().stream().filter(eachItem -> (
							StringUtils.isNotBlank(eachItem.getAnioGravable()) ||
							StringUtils.isNotBlank(eachItem.getDestinoHacendario()) ||
							StringUtils.isNotBlank(eachItem.getEstado()) ||
							StringUtils.isNotBlank(eachItem.getSaldoCargo()) ||
							StringUtils.isNotBlank(eachItem.getSaldoFavor())
							)).collect(Collectors.toList()));
				}
			}

			final Date date = new Date();

			//Caso 2: obtener la fecha y salida por pantalla con formato:
			final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Fecha: " + dateFormat.format(date));

			ctaForm.setFechageneracion(dateFormat.format(date));

		}
		catch (final Exception e)
		{
			LOG.error("Error en el WS estadoCuenta: " + e.getMessage());
		}

		//		Consumo de pedial
		final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = new SDHValidaMailRolResponse();
		final PredialForm predialFormIni = new PredialForm();
		final VehiculosInfObjetoForm vehiculosForm = new VehiculosInfObjetoForm();
		final InfoDelineacion infoDelineacion = new InfoDelineacion();
		final MiRitForm miRitForm = new MiRitForm();
		final PublicidadForm publicidadForm = new PublicidadForm();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		consultaContribuyenteBPRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		//		try
		//		{
		if(ctaForm != null) {
			if(ctaForm.getTablaVehicular()!= null && !ctaForm.getTablaVehicular().isEmpty()){
				sdhConsultaContribuyenteBPResponse.setVehicular(sdhConsultaImpuesto_simplificado.consulta_impVehicular(consultaContribuyenteBPRequest));
			}
			if(ctaForm.getTablaDelineacion()!= null && !ctaForm.getTablaDelineacion().isEmpty()) {
				sdhConsultaContribuyenteBPResponse
						.setDelineacion(sdhConsultaImpuesto_simplificado.consulta_impDelineacion(consultaContribuyenteBPRequest));
			}
			if(ctaForm.getTablaGasolina()!= null && !ctaForm.getTablaGasolina().isEmpty()) {
				sdhConsultaContribuyenteBPResponse.setGasolina(sdhConsultaImpuesto_simplificado.consulta_impGasolina(consultaContribuyenteBPRequest));
			}
			if(ctaForm.getTablaPublicidad() != null && !ctaForm.getTablaPublicidad().isEmpty()) {
				sdhConsultaContribuyenteBPResponse.setPublicidadExt(sdhConsultaImpuesto_simplificado.consulta_impPublicidad(consultaContribuyenteBPRequest));
			}
			if(ctaForm.getTablaICA() != null && !ctaForm.getTablaICA().isEmpty()) {
				sdhConsultaContribuyenteBPResponse.setIca(sdhConsultaImpuesto_simplificado.consulta_impICA(consultaContribuyenteBPRequest));
			}
			if(ctaForm.getPredial() != null && !ctaForm.getPredial().isEmpty()) {
				predialFormIni.setPredial(sdhConsultaImpuesto_simplificado.consulta_impPredial(consultaContribuyenteBPRequest));

				final ArrayList<PredialResponse> currentPredial = new ArrayList<PredialResponse>();

				for (final EdoCtaPredial edoCtaPredial : ctaForm.getPredial())
				{

					Optional<PredialResponse> result = null;

					result = predialFormIni.getPredial().stream()
							.filter(item -> item.getMatrInmobiliaria() != null
									&& item.getMatrInmobiliaria().equals(edoCtaPredial.getMatrInmobiliaria()))
							.findFirst();

					if (result.isEmpty())
					{
						result = predialFormIni.getPredial().stream()
								.filter(item -> item.getCHIP() != null && item.getCHIP().equals(edoCtaPredial.getNewCHIP())).findFirst();
					}

					if (result.isPresent())
					{
						final PredialResponse predialResponseItem = new PredialResponse();

						predialResponseItem.setAnioGravable(result.get().getAnioGravable());
						predialResponseItem.setCHIP(result.get().getCHIP());
						predialResponseItem.setContratoArrenda(result.get().getContratoArrenda());
						predialResponseItem.setDireccionPredio(result.get().getDireccionPredio());
						predialResponseItem.setMatrInmobiliaria(result.get().getMatrInmobiliaria());
						predialResponseItem.setNumObjeto(result.get().getNumObjeto());


						currentPredial.add(predialResponseItem);
					}

				}

				predialFormIni.setPredial(currentPredial);


			}
		}
//			sdhConsultaContribuyenteBPResponse.setReteIca(sdhConsultaImpuesto_simplificado.consulta_impRe(consultaContribuyenteBPRequest));
//			sdhConsultaContribuyenteBPResponse = mapper.readValue(
//					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
//					SDHValidaMailRolResponse.class);


			if (sdhConsultaContribuyenteBPResponse.getVehicular() != null
					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getVehicular()))
			{
				vehiculosForm.setImpvehicular(sdhConsultaContribuyenteBPResponse.getVehicular().stream()
						.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getDelineacion() != null
					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getDelineacion()))
			{
				miRitForm.setDelineacion(sdhConsultaContribuyenteBPResponse.getDelineacion().stream()
						.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));
			}

		//sdhConsultaContribuyenteBPResponse.setReteIca(sdhConsultaImpuesto_simplificado.consulta_impRe(consultaContribuyenteBPRequest));
		//sdhConsultaContribuyenteBPResponse = mapper.readValue(
		//		sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
		//		SDHValidaMailRolResponse.class);


		if (sdhConsultaContribuyenteBPResponse.getVehicular() != null
				&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getVehicular()))
		{
			vehiculosForm.setImpvehicular(sdhConsultaContribuyenteBPResponse.getVehicular().stream()
					.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
		}

		if (sdhConsultaContribuyenteBPResponse.getDelineacion() != null
				&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getDelineacion()))
		{
			miRitForm.setDelineacion(sdhConsultaContribuyenteBPResponse.getDelineacion().stream()
					.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));
		}

			if (sdhConsultaContribuyenteBPResponse.getGasolina() != null
					&& !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
			{
				miRitForm.setGasolina(sdhConsultaContribuyenteBPResponse.getGasolina().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumDoc())).collect(Collectors.toList()));
			}

			SDHExteriorPublicityTaxData cutomerPublicidadRow = null;
			final List<SDHExteriorPublicityTaxData> cutomerPublicidadList = new ArrayList<SDHExteriorPublicityTaxData>();

			if (sdhConsultaContribuyenteBPResponse.getPublicidadExt() != null
					&& !sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				for (final ImpuestoPublicidadExterior publicidadRow : sdhConsultaContribuyenteBPResponse.getPublicidadExt())
				{
					if (publicidadRow.getNumObjeto() != null && !publicidadRow.getNumObjeto().isEmpty())
					{
						cutomerPublicidadRow = new SDHExteriorPublicityTaxData();
						cutomerPublicidadRow.setAnoGravable(publicidadRow.getAnoGravable());
						cutomerPublicidadRow.setFenceType(publicidadRow.getTipoValla());
						cutomerPublicidadRow.setResolutionNumber(publicidadRow.getNumResolu());
						cutomerPublicidadRow.setObjectNumber(publicidadRow.getNumObjeto());

						cutomerPublicidadList.add(cutomerPublicidadRow);
					}

				}
			}
			customerData.setExteriorPublicityTaxList(cutomerPublicidadList);

			if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
			{
				final List<SDHExteriorPublicityTaxData> exteriorPublicityList = customerData.getExteriorPublicityTaxList();

				final List<ImpuestoPublicidadExterior> listImpuestoPublicdadExterior = new ArrayList<ImpuestoPublicidadExterior>();

				for (final SDHExteriorPublicityTaxData eachPublicityTax : exteriorPublicityList)
				{
					final ImpuestoPublicidadExterior eachImpuestoPE = new ImpuestoPublicidadExterior();

					eachImpuestoPE.setNumObjeto(eachPublicityTax.getObjectNumber());
					eachImpuestoPE.setNumResolu(eachPublicityTax.getResolutionNumber());
					eachImpuestoPE.setTipoValla(eachPublicityTax.getFenceType());
					eachImpuestoPE.setAnoGravable(eachPublicityTax.getAnoGravable());
					if ("VALLA VEHICULOS".equalsIgnoreCase(eachPublicityTax.getFenceType())
							|| "VALLA VEHíCULOS".equalsIgnoreCase(eachPublicityTax.getFenceType()))
					{
						eachImpuestoPE.setTipoVallaCode("02");
					}
					else if ("Valla Tubular de Obra".equalsIgnoreCase(eachPublicityTax.getFenceType()))
					{
						eachImpuestoPE.setTipoVallaCode("03");
					}
					else if ("Valla de Obra Convencional".equalsIgnoreCase(eachPublicityTax.getFenceType()))
					{
						eachImpuestoPE.setTipoVallaCode("04");
					}
					else if ("Valla Tubular Comercial".equalsIgnoreCase(eachPublicityTax.getFenceType()))
					{
						eachImpuestoPE.setTipoVallaCode("01");
					}
					else if ("Pantalla LED".equalsIgnoreCase(eachPublicityTax.getFenceType()))
					{
						eachImpuestoPE.setTipoVallaCode("05");
					}
					listImpuestoPublicdadExterior.add(eachImpuestoPE);
				}

				publicidadForm.setPublicidadExt(listImpuestoPublicdadExterior);

			}

			if (sdhConsultaContribuyenteBPResponse.getIca() != null
					&& StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getIca().getNumObjeto()))
			{
				miRitForm.setImpuestoICA(sdhConsultaContribuyenteBPResponse.getIca());
			}

			if (sdhConsultaContribuyenteBPResponse.getReteIca() != null
					&& StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getReteIca().getNumObjeto()))
			{
				ctaForm.setTablaReteica(sdhConsultaContribuyenteBPResponse.getReteIca());
			}

			//		}
			//		catch (final IOException e)
			//		{
			//			e.printStackTrace();
			//		}


		if (referrer.contains("contribuyentes"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}
		else if (referrer.contains("retenedor") || referrer.contains("agenteRetenedor"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_RETE));
		}
		else
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}

		model.addAttribute("dataForm", miRitForm);
		model.addAttribute("vehiculosForm", vehiculosForm);
		model.addAttribute("predial", predialFormIni);
		model.addAttribute("ctaForm", ctaForm);
		model.addAttribute("publicidadForm", publicidadForm);


		storeCmsPageInModel(model, getContentPageForLabelOrId(ESTADO_DE_CUENTA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESTADO_DE_CUENTA_CMS_PAGE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value =
	{ "/contribuyentes/estado-de-cuenta", "/agenteRetenedor/estado-de-cuenta" }, method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_ST(final Model model, @ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataFormResponse, @RequestParam(value = "action")
	final String action) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Presentar Declaracion POST --------------------------");


		String URLdeterminada = "";
		if (action.equals("presentarDeclaracion"))
		{
			if (dataFormResponse.getImpuesto().equals("5"))
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
				final SobreTasaGasolinaCatalogos dataFormCatalogos = gasolinaService.prepararCatalogos(sdhConfigCatalogos);
				List<SobreTasaGasolinaTabla> tablaDocs;
				final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
				SDHValidaMailRolResponse detalleContribuyente;

				customerModel = (CustomerModel) userService.getCurrentUser();

				numBP = customerModel.getNumBP();
				numDoc = customerModel.getDocumentNumber();

				contribuyenteRequest.setNumBP(numBP);

				detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService,
						LOG);
				if (detalleContribuyente.getIdmsj() != 0)
				{
					LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
					GlobalMessages.addErrorMessage(model, "error.consultas.estadoDeCuenta.error1");
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

				model.addAttribute("dataForm", dataForm);
				URLdeterminada = gasolinaService.obtenerURL("presentar-declaracion", "impuesto", "sobretasa-gasolina");
			}
			else
			{

				storeCmsPageInModel(model, getContentPageForLabelOrId(ESTADO_DE_CUENTA_CMS_PAGE));
				setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESTADO_DE_CUENTA_CMS_PAGE));
				model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
				model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

				URLdeterminada = getViewForPage(model);
			}
		}

		return URLdeterminada;
	}

	@RequestMapping(value = "/setComplete6", method = RequestMethod.POST)
	public String setComplete(final SessionStatus status)
	{
		status.setComplete();

		return null;
	}

}

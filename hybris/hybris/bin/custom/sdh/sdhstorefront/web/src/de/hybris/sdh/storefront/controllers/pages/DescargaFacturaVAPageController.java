/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.DefaultResourceBreadcrumbBuilder;
import de.hybris.sdh.core.dao.SdhDocumentTypeDao;
import de.hybris.sdh.core.form.SelectAtomValue;
import de.hybris.sdh.core.model.SDHTaxTypeModel;
import de.hybris.sdh.core.model.SITIITransactionsLogModel;
import de.hybris.sdh.core.pojos.requests.ConsulPagosRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribBPRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribPredialRequest;
import de.hybris.sdh.core.pojos.requests.ConsultarBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePagoRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterApplicationRequest;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterEntityRequest;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterRequest;
import de.hybris.sdh.core.pojos.responses.ConsultarBPResponse;
import de.hybris.sdh.core.pojos.responses.DetallePagoResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.ListaDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.PaymentServiceRegisterResponse;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConfigCatalogos;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHTaxTypeService;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.core.services.SdhPaymentService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.pages.forms.DescargaFacturaVAForm;
import de.hybris.sdh.storefront.controllers.pages.forms.SDHLoginForm;
import de.hybris.sdh.storefront.forms.FacturacionForm;
import de.hybris.sdh.storefront.forms.PSEPaymentForm;

import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class DescargaFacturaVAPageController extends SDHAbstractPageController
{
	private static final Logger LOG = Logger.getLogger(DescargaFacturaVAPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	//	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.descargaFac";

	// CMS Pages
	private static final String DESCARGA_FACTURA_CMS_PAGE = "descargaFacturaVAPage";

	private static final String REDIRECT_TO_DESCARGA_FACTURA_PAGE = REDIRECT_PREFIX + "/descargaFacturaVA";

	@Resource(name = "customBreadcrumbBuilder")
	private DefaultResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhDetalleGasolina")
	private SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

	@Resource(name = "sdhConfigCatalogos")
	SDHConfigCatalogos sdhConfigCatalogos;

	@Resource(name = "sdhDocumentTypeDao")
	SdhDocumentTypeDao sdhDocumentTypeDao;

	@Resource(name = "sdhValidaContribuyenteService")
	SDHValidaContribuyenteService sdhValidaContribuyenteService;

	@Resource(name = "sdhPaymentService")
	private SdhPaymentService sdhPaymentService;

	@Resource(name = "sdhTaxTypeService")
	private SDHTaxTypeService sdhTaxTypeService;



	@RequestMapping(value = "/descargaFacturaVA", method = RequestMethod.GET)
	public String descargafact(@ModelAttribute("dataForm")
	DescargaFacturaVAForm infoVista, final BindingResult bindingResult, final Model model,
	final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En GET Descarga Factura --------------------------");
		if(infoVista == null) {
			infoVista = new DescargaFacturaVAForm();
		}


		final Map<String, String> impuestosActivos = sdhConsultaImpuesto_simplificado.obtenerListaImpuestosActivos(sdhConsultaImpuesto_simplificado.AMBITO_FACTURACIONVA);

		final FacturacionForm facturacionForm = new FacturacionForm();
		if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.PREDIAL)){
			facturacionForm.setPredial(new ArrayList<PredialResponse>());
		}
		if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.VEHICULOS)){
			facturacionForm.setVehicular(new ArrayList<ImpuestoVehiculos>());
		}


		final List<SelectAtomValue> documentTypes = sdhDocumentTypeDao.getAllDocumentTypes();
		model.addAttribute("documentTypes", documentTypes);
		model.addAttribute("infoVista", infoVista);
		final SDHLoginForm loginForm = new SDHLoginForm();
		model.addAttribute("loginForm", loginForm);
		model.addAttribute("facturacionForm", facturacionForm);
		model.addAttribute("infoPreviaPSE", new InfoPreviaPSE());


		storeCmsPageInModel(model, getContentPageForLabelOrId(DESCARGA_FACTURA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DESCARGA_FACTURA_CMS_PAGE));

		//		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}


	@RequestMapping(value = "/descargaFacturaVA/buscarInfo", method = RequestMethod.GET)
	@ResponseBody
	public DescargaFacturaVAForm buscarInfo(@ModelAttribute("dataForm")
	final DescargaFacturaVAForm infoVista, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------En GET buscar informacion------------------------");
		ConsultarBPResponse consultarBPResponse = null;
		final ObjectMapper mapper = new ObjectMapper();
		String numBP = null;
      ConsultaContribBPRequest consultaContribBPRequest = null;
      SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;




		infoVista.setNombreContribuyente("");
		infoVista.setUrlDownload("");
		infoVista.setFechaExp("");
		infoVista.setNumObjeto("");


		final ConsultarBPRequest requestConsultarBP = new ConsultarBPRequest();
		requestConsultarBP.setNumid(infoVista.getNumDoc());
		requestConsultarBP.setTipoid(infoVista.getTipoDoc());

		//requestConsultarBP.setFechExp(infoVista.getFechaExp());
		requestConsultarBP.setFechaExp("");
		requestConsultarBP.setValida("X");

		final String response = sdhValidaContribuyenteService.consultarBP(requestConsultarBP);


		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			consultarBPResponse = mapper.readValue(response, ConsultarBPResponse.class);
			numBP = consultarBPResponse.getNumBP();
		}catch (final IOException e)
		{
			LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
		}

		if(numBP != null) {
			consultaContribBPRequest = new ConsultaContribBPRequest();
			consultaContribBPRequest.setNumBP(numBP);
			sdhConsultaContribuyenteBPResponse = sdhConsultaContribuyenteBPService.consultaContribuyenteBP_simplificado(consultaContribBPRequest );
		}


		if(sdhConsultaContribuyenteBPResponse != null) {
			infoVista.setNombreContribuyente(sdhConsultaContribuyenteBPResponse.getCompleteName());
			if(sdhConsultaContribuyenteBPResponse.getInfoContrib() != null) {
				infoVista.setNumBP(sdhConsultaContribuyenteBPResponse.getInfoContrib().getNumBP());
				final ConsultaContribPredialRequest requestPredial = new ConsultaContribPredialRequest();
				requestPredial.setNumBP(sdhConsultaContribuyenteBPResponse.getInfoContrib().getNumBP());
				requestPredial.setAnioGravable(infoVista.getAnioGravable());

				switch (infoVista.getClaveImpuesto())
				{
					case "0001":
						List<PredialResponse> listaPredial = sdhConsultaImpuesto_simplificado.consulta_impPredial2(requestPredial );
						if(listaPredial!= null) {
							listaPredial = listaPredial.stream()
									.filter(d -> infoVista.getClaveObjeto().equals(d.getCHIP())).collect(Collectors.toList());
							if(!listaPredial.isEmpty() && listaPredial.get(0)!=null) {
								infoVista.setNumObjeto(listaPredial.get(0).getNumObjeto());
							}


						}
						break;

					case "0002":
						List<ImpuestoVehiculos> listaVehiculos = sdhConsultaImpuesto_simplificado.consulta_impVehicular2(requestPredial );
						if(listaVehiculos!= null) {
							listaVehiculos = listaVehiculos.stream()
									.filter(d -> infoVista.getClaveObjeto().equals(d.getPlaca())).collect(Collectors.toList());
							if(!listaVehiculos.isEmpty() && listaVehiculos.get(0)!=null) {
								infoVista.setNumObjeto(listaVehiculos.get(0).getNumObjeto());
							}

						}
						break;

					default:
						infoVista.setNumObjeto("");
						break;
				}

			}
		}


		return infoVista;
	}

	@RequestMapping(value = "/descargaFacturaVA/preparaPagoPSE", method = RequestMethod.POST)
	public String handlePOST_PAG(@ModelAttribute("infoPreviaPSE")
	final InfoPreviaPSE infoPreviaPSE, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{

		System.out.println("---------------- En Preparacion Pago PSE POST --------------------------");
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		String[] mensajesError;
		String mensajeError = "";
		final DetallePagoRequest detallePagoRequest = new DetallePagoRequest();
		final DetallePagoResponse detallePagoResponse;
		final PSEPaymentForm psePaymentForm = new PSEPaymentForm();
		String errorSITII = null;


		if (infoPreviaPSE.getNumRef().contains("undefined"))
		{
			infoPreviaPSE.setNumRef("");
		}

		if (infoPreviaPSE.getNumRef() != null && !infoPreviaPSE.getNumRef().equals(""))
		{
			psePaymentForm.setTipoDeImpuesto(infoPreviaPSE.getTipoImpuesto());
			psePaymentForm.setAnoGravable(infoPreviaPSE.getAnoGravable());
			psePaymentForm.setPeriodo(infoPreviaPSE.getClavePeriodo());
			psePaymentForm.setTipoDeIdentificacion(infoPreviaPSE.getTipoDoc());
			psePaymentForm.setNoIdentificacion(infoPreviaPSE.getNumDoc());
			psePaymentForm.setDV(infoPreviaPSE.getDv());
			psePaymentForm.setObjPago(infoPreviaPSE.getNumObjeto());
			psePaymentForm.setCUD(infoPreviaPSE.getCDU());


			String valorPagar = infoPreviaPSE.getTotalPagar();
			valorPagar = valorPagar.replaceAll("\\s+", "");
			valorPagar = valorPagar.replaceAll("\\.(0{1,2})$", "");

			psePaymentForm.setValorAPagar(valorPagar);
			psePaymentForm.setNumeroDeReferencia(infoPreviaPSE.getNumRef());
			psePaymentForm.setFechaLimiteDePago(infoPreviaPSE.getFechaVenc());
			psePaymentForm.setCHIP(infoPreviaPSE.getChip());
			psePaymentForm.setCdu(infoPreviaPSE.getCdu());
			psePaymentForm.setPlaca(infoPreviaPSE.getPlaca());

		}
		else
		{
			detallePagoRequest.setNumBP(infoPreviaPSE.getNumBP());
			detallePagoRequest.setClavePeriodo(infoPreviaPSE.getClavePeriodo());
			detallePagoRequest.setNumObjeto(infoPreviaPSE.getNumObjeto());
			detallePagoRequest.setAnticipo(infoPreviaPSE.getRadicado());


			System.out.println("Request de consulPago: " + detallePagoRequest);
			detallePagoResponse = gasolinaService.consultaDetallePago(detallePagoRequest, sdhDetalleGasolinaWS, LOG);
			System.out.println("Response de consulPago: " + detallePagoResponse);

			if (gasolinaService.ocurrioErrorPSE(detallePagoResponse) != true)
			{
				psePaymentForm.setTipoDeImpuesto(infoPreviaPSE.getTipoImpuesto());
				psePaymentForm.setAnoGravable(infoPreviaPSE.getAnoGravable());
				psePaymentForm.setPeriodo(infoPreviaPSE.getClavePeriodo());
				psePaymentForm.setTipoDeIdentificacion(infoPreviaPSE.getTipoDoc());
				psePaymentForm.setNoIdentificacion(infoPreviaPSE.getNumDoc());
				psePaymentForm.setDV(infoPreviaPSE.getDv());
				psePaymentForm.setObjPago(infoPreviaPSE.getNumObjeto());
				psePaymentForm.setCUD(infoPreviaPSE.getCDU());
				psePaymentForm.setPlaca(infoPreviaPSE.getPlaca());


				psePaymentForm.setValorAPagar(detallePagoResponse.getTotalPagar());
				psePaymentForm.setNumeroDeReferencia(detallePagoResponse.getNumRef());
				psePaymentForm.setFechaLimiteDePago(detallePagoResponse.getFechVenc());
				psePaymentForm.setCHIP(infoPreviaPSE.getChip());
			}
			else
			{
				mensajeError = gasolinaService.obtenerMensajeError(detallePagoResponse.getErrores(), 0);
				LOG.error("Error al leer detalle de pago: " + mensajeError);
				mensajesError = gasolinaService.prepararMensajesError(detallePagoResponse.getErrores());
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "error.Pago.PSE.error1",
						mensajesError);


				redirectAttributes.addAttribute("errorSITII", mensajeError);
				return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
			}
		}
		//model.addAttribute("psePaymentForm", psePaymentForm);
		//return REDIRECT_TO_DECLARACIONES_PAGAR_PAGE;


		final String sitII_activado = configurationService.getConfiguration().getString("sdh.payment.service.activado");

		if (sitII_activado.contains("true"))
		{

			System.out.println("---------------- Pago Gasolina SIT_II --------------------------");

			//*->Consumo de servicio SITII para pago de impuestos
			final SDHTaxTypeModel sdhTaxTypeModel = sdhTaxTypeService.findUniqueByTaxCode(psePaymentForm.getTipoDeImpuesto());
			PaymentServiceRegisterResponse paymentServiceRegisterResponse = null;

			final PaymentServiceRegisterEntityRequest paymentServiceRegisterEntityRequest = new PaymentServiceRegisterEntityRequest(
					1, "SECRETARIA DISTRITAL DE HACIENDA");

			final PaymentServiceRegisterApplicationRequest paymentServiceRegisterApplicationRequest = new PaymentServiceRegisterApplicationRequest(
					5, "BOGDATA SAP");

			//Armado de objeto pago
			String ref;
			if (psePaymentForm.getTipoDeImpuesto().equals("5101"))
			{
				if (psePaymentForm.getCHIP() == null || StringUtils.isBlank(psePaymentForm.getCHIP()))
				{
					ref = infoPreviaPSE.getMatrInmobiliaria();
				}
				else
				{
					ref = psePaymentForm.getCHIP();
				}
			}
			else if (psePaymentForm.getTipoDeImpuesto().equals("5103"))
			{
				ref = psePaymentForm.getPlaca();
			}
			else if (psePaymentForm.getTipoDeImpuesto().equals("5132"))
			{
				if (psePaymentForm.getCUD() != null && !psePaymentForm.getCUD().equals(""))
				{
					ref = psePaymentForm.getCUD();
				}
				else
				{
					ref = psePaymentForm.getCdu();
				}
			}
			else
			{
				ref = psePaymentForm.getNoIdentificacion();
			}



			final String objPago = ref;

			psePaymentForm.setObjPago(objPago);

			//Consulta de consulpagos
			final ConsulPagosRequest listaDeclaracionesRequest = new ConsulPagosRequest();
			final ListaDeclaracionesResponse listaDeclaracionesResponse = null;

			final Map<String, String> map_impuestos = new HashMap<>();
			map_impuestos.put("5101", "0001");
			map_impuestos.put("5103", "0002");
			map_impuestos.put("5102", "0003");
			map_impuestos.put("5131", "0004");
			map_impuestos.put("0108", "0005");
			map_impuestos.put("5106", "0006");
			map_impuestos.put("5132", "0006");
			map_impuestos.put("5154", "0007");

			final String impuestoSAP = map_impuestos.get(psePaymentForm.getTipoDeImpuesto());

			listaDeclaracionesRequest.setBp(infoPreviaPSE.getNumBP());
			listaDeclaracionesRequest.setImpuesto(impuestoSAP);
			listaDeclaracionesRequest.setAnioGravable(infoPreviaPSE.getAnoGravable());


			//Obtiene la ref4 con los valores concatenados para imprimir un formulario con ws imprimePago
			final StringBuffer sb = new StringBuffer();
			String ref4 = null;

			if (infoPreviaPSE.getConcesionario() == null)
			{
				sb.append(infoPreviaPSE.getNumBP() + ";");
				sb.append(impuestoSAP + ";");
				sb.append(infoPreviaPSE.getAnoGravable() + ";");
				sb.append(infoPreviaPSE.getClavePeriodo() + ";");
				sb.append(infoPreviaPSE.getNumObjeto() + ";");
				if (infoPreviaPSE.getPagoVoluntario() != null)
				{
					sb.append(infoPreviaPSE.getPagoVoluntario() + ";");
				}
				sb.append(" ");
			}
			else
			{
				final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
				final ConsultaContribBPRequest consultaContribBPRequest = new ConsultaContribBPRequest();

				sb.append(infoPreviaPSE.getNumBP() + ";");
				sb.append(impuestoSAP + ";");
				sb.append(infoPreviaPSE.getAnoGravable() + ";");
				sb.append(infoPreviaPSE.getClavePeriodo() + ";");
				sb.append(infoPreviaPSE.getNumObjeto() + ";");


			}

			ref4 = sb.toString();

			String fechaLimPago = null;
			if (psePaymentForm.getFechaLimiteDePago().contains("/"))
			{
				fechaLimPago = psePaymentForm.getFechaLimiteDePago();
			}
			else
			{
				fechaLimPago = psePaymentForm.getFechaLimiteDePago().substring(6) + "/"
						+ psePaymentForm.getFechaLimiteDePago().substring(4, 6) + "/"
						+ psePaymentForm.getFechaLimiteDePago().substring(0, 4);
			}

			final BigInteger valorAPagar = new BigInteger(psePaymentForm.getValorAPagar());
			final String urlRetorno = configurationService.getConfiguration().getString("sdh.payment.service.retorno.url");

			String descImp = new String();
			if (psePaymentForm.getTipoDeImpuesto().contains("5103"))
			{
				descImp = "Vehiculos";
			}
			else
			{
				descImp = Objects.nonNull(sdhTaxTypeModel) ? sdhTaxTypeModel.getName() : StringUtils.EMPTY;
			}

			final PaymentServiceRegisterRequest paymentServiceRegisterRequest = new PaymentServiceRegisterRequest(
					paymentServiceRegisterEntityRequest, paymentServiceRegisterApplicationRequest,
					psePaymentForm.getTipoDeImpuesto().substring(2), descImp,
					psePaymentForm.getNumeroDeReferencia().replaceFirst("^0+(?!$)", ""),
					psePaymentForm.getNumeroDeReferencia().replaceFirst("^0+(?!$)", ""),
					psePaymentForm.getObjPago().replaceFirst("^0+(?!$)", ""), ref4, fechaLimPago, urlRetorno, valorAPagar);

			try
			{
				System.out.println(paymentServiceRegisterRequest);
				paymentServiceRegisterResponse = sdhPaymentService.register(paymentServiceRegisterRequest);
				System.out.println(paymentServiceRegisterResponse);


				if (paymentServiceRegisterResponse != null)
				{
					if (paymentServiceRegisterResponse.getNus() != null)
					{
						if (valorAPagar.compareTo(BigInteger.ZERO) == -1 || valorAPagar.compareTo(BigInteger.ZERO) == 0)
						{
							errorSITII = getMessageSource().getMessage("prepararPago.error.0", null,
									getI18nService().getCurrentLocale());
							redirectAttributes.addAttribute("errorSITII", errorSITII);
							return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
						}
						else if (paymentServiceRegisterResponse.getNus() <= 0)
						{
							errorSITII = paymentServiceRegisterResponse.getMessage();
							redirectAttributes.addAttribute("errorSITII", errorSITII);
							//redirectAttributes.addFlashAttribute("errorSITII", errorSITII);
							return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
						}
						else
						{
							final SITIITransactionsLogModel sitIITransactionsLogModel = new SITIITransactionsLogModel();
							sitIITransactionsLogModel.setTransactionBP(infoPreviaPSE.getNumBP());
							sitIITransactionsLogModel.setTransactionDate(java.time.LocalDate.now().toString());
							sitIITransactionsLogModel.setTransactionTime(java.time.LocalTime.now().toString());
							sitIITransactionsLogModel.setTransactionReference(psePaymentForm.getNumeroDeReferencia());
							sitIITransactionsLogModel.setTransactionNUS(paymentServiceRegisterResponse.getNus().toString());
							sitIITransactionsLogModel.setTransactionAmount(valorAPagar.toString());



							modelService.saveAll(sitIITransactionsLogModel);

							LOG.error("SITIITransactionsLog:[ BP" + sitIITransactionsLogModel.getTransactionBP() + " TransactionDate: "
									+ sitIITransactionsLogModel.getTransactionDate() + " TransactionTime: "
									+ sitIITransactionsLogModel.getTransactionTime() + " TransactionReference: "
									+ sitIITransactionsLogModel.getTransactionReference() + " TransactionNUS: "
									+ sitIITransactionsLogModel.getTransactionNUS() + " TransactionAmount: "
									+ sitIITransactionsLogModel.getTransactionAmount());



							return Objects.nonNull(paymentServiceRegisterResponse)
									? "redirect:" + paymentServiceRegisterResponse.getPaymentUrl()
									: "/";
						}
					}

				}
				else
				{
					errorSITII = getMessageSource().getMessage("prepararPago.error.SIT2null", null,
							getI18nService().getCurrentLocale());
					redirectAttributes.addAttribute("errorSITII", errorSITII);
					return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
				}
			}
			catch (final NoSuchAlgorithmException e)
			{
				e.printStackTrace();

				errorSITII = getMessageSource().getMessage("prepararPago.error.SIT2conexion", null,
						getI18nService().getCurrentLocale());
				redirectAttributes.addAttribute("errorSITII", errorSITII);
				return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
			}
			catch (final KeyStoreException e)
			{
				e.printStackTrace();

				errorSITII = getMessageSource().getMessage("prepararPago.error.SIT2conexion", null,
						getI18nService().getCurrentLocale());
				redirectAttributes.addAttribute("errorSITII", errorSITII);
				return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
			}
			catch (final KeyManagementException e)
			{
				e.printStackTrace();

				errorSITII = getMessageSource().getMessage("prepararPago.error.SIT2conexion", null,
						getI18nService().getCurrentLocale());
				redirectAttributes.addAttribute("errorSITII", errorSITII);
				return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
			}
			catch (final Exception e)
			{
				e.printStackTrace();

				errorSITII = getMessageSource().getMessage("prepararPago.error.SIT2conexion", null,
						getI18nService().getCurrentLocale());
				redirectAttributes.addAttribute("errorSITII", errorSITII);
				return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
			}

			return "/";

		}
		else
		{
			model.addAttribute("psePaymentForm", psePaymentForm);
			return "/";
		}

	}


}


package de.hybris.sdh.storefront.controllers.pages;


import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.model.SDHTaxTypeModel;
import de.hybris.sdh.core.model.SITIITransactionsLogModel;
import de.hybris.sdh.core.pojos.requests.ConsulPagosRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePagoRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterApplicationRequest;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterEntityRequest;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterRequest;
import de.hybris.sdh.core.pojos.responses.DetallePagoResponse;
import de.hybris.sdh.core.pojos.responses.ListaDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.PaymentServiceRegisterResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHTaxTypeService;
import de.hybris.sdh.core.services.SdhPaymentService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.PSEPaymentForm;

import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page 2
 */
@Controller
@SessionAttributes("psePaymentForm")
public class PreparacionPagoPSE extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(PublicidadExteriorPageController.class);


	private static final String DECLARACIONES_PAGAR_CMS_PAGE = "preparacionPagarPSE";
	private static final String REDIRECT_TO_DECLARACIONES_PAGAR_PAGE = REDIRECT_PREFIX + "/impuestos/preparaPagoPSE";

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

	@Resource(name = "sdhPaymentService")
	private SdhPaymentService sdhPaymentService;

    @Resource(name = "sdhTaxTypeService")
    private SDHTaxTypeService sdhTaxTypeService;

	@Resource(name = "modelService")
	private ModelService modelService;



	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.declarapublicidad";

	//CMS PAGES
	private static final String DECLARACION_PUBLICIDAD_CMS_PAGE = "DeclaraPublicidadPage";


	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}






	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/impuestos/preparaPagoPSE", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_PAG(@ModelAttribute("psePaymentForm")
	final PSEPaymentForm psePaymentForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes, final HttpServletRequest request, final HttpServletResponse response)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Preparacion Pago PSE GET --------------------------");
		model.addAttribute("psePaymentForm", psePaymentForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_PAGAR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_PAGAR_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return getViewForPage(model);
	}



	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/impuestos/preparaPagoPSE", method = RequestMethod.POST)
	@RequireHardLogIn
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
				ref = psePaymentForm.getCHIP();
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
				//ref = psePaymentForm.getTipoDeIdentificacion() + psePaymentForm.getNoIdentificacion();
				ref = psePaymentForm.getNoIdentificacion();
			}


			//final int i_ceros = 14 - ref.length();

			//String s_ceros = new String();
			//for (int i = 1; i <= i_ceros; i++)
			//{
			//	s_ceros = s_ceros + "0";
			//}

			//final String objPago = s_ceros + ref;
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

			final PaymentServiceRegisterRequest paymentServiceRegisterRequest = new PaymentServiceRegisterRequest(
					paymentServiceRegisterEntityRequest, paymentServiceRegisterApplicationRequest,
					psePaymentForm.getTipoDeImpuesto().substring(2),
					Objects.nonNull(sdhTaxTypeModel) ? sdhTaxTypeModel.getName() : StringUtils.EMPTY,
					psePaymentForm.getNumeroDeReferencia().replaceFirst("^0+(?!$)", ""),
					psePaymentForm.getNumeroDeReferencia().replaceFirst("^0+(?!$)", ""),
					psePaymentForm.getObjPago().replaceFirst("^0+(?!$)", ""), ref4,
					fechaLimPago, urlRetorno, valorAPagar);

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
							sitIITransactionsLogModel.setTransactionDate(java.time.LocalDate.now().toString());
							sitIITransactionsLogModel.setTransactionTime(java.time.LocalTime.now().toString());
							sitIITransactionsLogModel.setTransactionReference(psePaymentForm.getNumeroDeReferencia());
							sitIITransactionsLogModel.setTransactionNUS(paymentServiceRegisterResponse.getNus().toString());
							sitIITransactionsLogModel.setTransactionAmount(valorAPagar.toString());



							modelService.saveAll(sitIITransactionsLogModel);

							LOG.error("SITIITransactionsLog:[ TransactionDate: " + sitIITransactionsLogModel.getTransactionDate()
									+ " TransactionTime: " + sitIITransactionsLogModel.getTransactionTime() + " TransactionReference: "
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
			return REDIRECT_TO_DECLARACIONES_PAGAR_PAGE;
		}

	}

	@RequestMapping(value = "/setComplete5", method = RequestMethod.POST)
	public String setComplete(final SessionStatus status)
	{
		status.setComplete();

		return null;
	}


}
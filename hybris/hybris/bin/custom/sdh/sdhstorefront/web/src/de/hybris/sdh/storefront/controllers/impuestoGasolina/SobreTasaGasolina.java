

package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.model.SDHTaxTypeModel;
import de.hybris.sdh.core.model.SITIITransactionsLogModel;
import de.hybris.sdh.core.pojos.requests.CalcGasolina2Request;
import de.hybris.sdh.core.pojos.requests.CalculaGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.ConsulPagosRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.DetallePagoRequest;
import de.hybris.sdh.core.pojos.requests.EnviaFirmasRequest;
import de.hybris.sdh.core.pojos.requests.FirmanteRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterApplicationRequest;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterEntityRequest;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterRequest;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.pojos.responses.CalculaGasolinaResponse;
import de.hybris.sdh.core.pojos.responses.DetGasInfoDeclaraResponse;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.DetGasRevisorDeclaranteResponse;
import de.hybris.sdh.core.pojos.responses.DetGasValoresDeclaraResponse;
import de.hybris.sdh.core.pojos.responses.DetallePagoResponse;
import de.hybris.sdh.core.pojos.responses.EnviaFirmasResponse;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.ImpGasolinaSimpliResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ListaDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.PaymentServiceRegisterResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConfigCatalogos;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.core.services.SDHPseTransactionsLogService;
import de.hybris.sdh.core.services.SDHTaxTypeService;
import de.hybris.sdh.core.services.SdhPaymentService;
import de.hybris.sdh.facades.SDHCalculaGasolina2Facade;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.SDHEnviaFirmasFacade;
import de.hybris.sdh.facades.questions.data.SDHAgentData;
import de.hybris.sdh.storefront.controllers.pages.SDHAbstractPageController;
import de.hybris.sdh.storefront.forms.EnviaFirmasForm;
import de.hybris.sdh.storefront.forms.FirmantesForm;
import de.hybris.sdh.storefront.forms.GeneraDeclaracionForm;
import de.hybris.sdh.storefront.forms.PSEPaymentForm;
import de.hybris.sdh.storefront.forms.SobreTasaGasolinaControlCamposDec;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Decoder.BASE64Decoder;


/**
 * @author Federico Flores Dimas
 *
 */

@Controller
@SessionAttributes(
{ "dataForm", "psePaymentForm" })

public class SobreTasaGasolina extends SDHAbstractPageController
{

	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

	//Example Controller
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.gasolina";
	private static final String TEXT_ACCOUNT_PROFILE_DECLARACION = "text.account.profile.gasolina.declaracion";

	// CMS Pages
	private static final String SOBRETASA_GASOLINA_CMS_PAGE = "sobretasa-gasolina";
	private static final String REDIRECT_TO_SOBRETASA_GASOLINA_PAGE = REDIRECT_PREFIX + "/contribuyentes/sobretasa-gasolina";
	private static final String DECLARACIONES_GASOLINA_CMS_PAGE = "declaracion-gasolina";
	private static final String DECLARACIONES_PAGAR_CMS_PAGE = "preparacionPagarPSE";
	private static final String REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/sobretasa-gasolina/declaracion-gasolina";
	private static final String REDIRECT_TO_DECLARACIONES_PAGAR_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/sobretasa-gasolina/declaracion-gasolinaPagar";
	private static final String REDIRECT_CMS_SITE_PAGE_PAGO_PSE_FORM = FORWARD_PREFIX + "/impuestos/pagoEnLinea/form";

	private static final String FORWARD_CMS_SITE_PAGE_PAGO_PSE_FORM = null;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "sdhCalculaGasolina2Facade")
	SDHCalculaGasolina2Facade sdhCalculaGasolina2Facade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhGeneraDeclaracionService")
	SDHGeneraDeclaracionService sdhGeneraDeclaracionService;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sdhEnviaFirmasFacade")
	SDHEnviaFirmasFacade sdhEnviaFirmasFacade;

	@Resource(name = "pseTransactionsLogService")
	private SDHPseTransactionsLogService pseTransactionsLogService;

	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

	@Resource(name = "sdhCustomerAccountService")
	private SDHCustomerAccountService sdhCustomerAccountService;

	@Resource(name = "sdhPaymentService")
	private SdhPaymentService sdhPaymentService;

	@Resource(name = "sdhTaxTypeService")
	private SDHTaxTypeService sdhTaxTypeService;

	@Resource(name = "sdhConfigCatalogos")
	SDHConfigCatalogos sdhConfigCatalogos;


	@ModelAttribute("productClassMaximumOccurrencies")
	public Map<String, Integer> getProductClassMaximumOccurrencies()
	{
		final HashMap<String, Integer> map = new HashMap<String, Integer>();

		//Gasolina Corriente Básica
		//map.put("01", valueMaxOccurrancy);

		//Gasolina Corriente Oxigenada
		map.put("02", 3);

		//Gasolina Extra Básica
		//map.put("03", valueMaxOccurrancy);

		//Gasolina Extra Oxigenada
		map.put("04", 3);

		return map;

	}


	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/generar", method = RequestMethod.GET)
	@ResponseBody
	public GeneraDeclaracionResponse generar(final GeneraDeclaracionForm dataForm, final HttpServletResponse response,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		GeneraDeclaracionResponse generaDeclaracionResponse = new GeneraDeclaracionResponse();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String numForm = request.getParameter("numForm");

		if (StringUtils.isBlank(numForm))
		{
			numForm = dataForm.getNumForm();
		}

		final GeneraDeclaracionRequest generaDeclaracionRequest = new GeneraDeclaracionRequest();


		generaDeclaracionRequest.setNumForm(numForm);
		generaDeclaracionRequest.setTipo_id(customerModel.getDocumentType());
		generaDeclaracionRequest.setNum_id(customerModel.getNumBP());

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			generaDeclaracionResponse = mapper.readValue(sdhGeneraDeclaracionService.generaDeclaracion(generaDeclaracionRequest),
					GeneraDeclaracionResponse.class);

			if (generaDeclaracionResponse != null && generaDeclaracionResponse.getStringPDF() != null)
			{
				final String encodedBytes = generaDeclaracionResponse.getStringPDF();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = numForm + "-" + customerModel.getNumBP() + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE);
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


	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_ST(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm, @RequestParam(value = "action")
	final String action, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Menu sobretasa gasolina POST --------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String returnURL = REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anioGravable = "";
		String periodo = "";
		final int indiceSeleccionado = 0;
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetGasResponse detalleGasolinaResponse;
		final boolean l_ocurrio_error = false;
		String[] mensajesError;


		numBP = customerModel.getNumBP();
		numDoc = customerModel.getDocumentNumber();
		tipoDoc = gasolinaService.obtenerTipoDoc(dataForm.getListaDocumentos());
		numDoc = gasolinaService.obtenerNumDoc(dataForm.getListaDocumentos());
		anioGravable = dataForm.getAnoGravable();
		periodo = dataForm.getPeriodo();

		detalleGasolinaRequest.setNumBP(numBP);
		detalleGasolinaRequest.setNumDoc(numDoc);
		detalleGasolinaRequest.setTipoDoc(tipoDoc);
		detalleGasolinaRequest.setAnoGravable(anioGravable);
		detalleGasolinaRequest.setPeriodo(periodo);

		System.out.println("Request de infObjeto/Gasolina: " + detalleGasolinaRequest);
		detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de infObjeto/Gasolina: " + detalleGasolinaResponse);
		if (gasolinaService.ocurrioErrorDetalle(detalleGasolinaResponse) != true)
		{
			detalleGasolinaResponse.setAlmacProd(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getAlmacProd()));
			detalleGasolinaResponse.setNumTanques(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getNumTanques()));
			detalleGasolinaResponse.setAlmacTanque(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getAlmacTanque()));

			dataForm.setHabilitaPagarEnLinea("");
			if (detalleGasolinaResponse.getNumForm() != null)
			{
				if (!detalleGasolinaResponse.getNumForm().isEmpty())
				{
					dataForm.setHabilitaPagarEnLinea("");
				}
			}
			dataForm.setNumBP(numBP);
			dataForm.setNumDoc(numDoc);
			dataForm.setTipoDoc(tipoDoc);
			dataForm.setAnoGravable(anioGravable);
			dataForm.setPeriodo(periodo);
			dataForm.setDataForm(detalleGasolinaResponse);
			dataForm.setNumForm(detalleGasolinaResponse.getNumForm());
			model.addAttribute("dataForm", dataForm);
		}
		else
		{
			mensajesError = gasolinaService.prepararMensajesError(detalleGasolinaResponse.getErrores());
			LOG.error("Error al leer detalle de gasolina: " + mensajesError);
			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error1");
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error1", mensajesError);
		}

		if (action.equals("buscar"))
		{
			storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
			model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

			returnURL = getViewForPage(model);
		}
		else
		{
			if (action.equals("declarar"))
			{
				storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
				setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
				model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
				model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
			}
		}

		return returnURL;
	}


	@RequestMapping(value = "/contribuyentes/gasolina/declaracion/firmar", method = RequestMethod.POST)
	@ResponseBody
	public EnviaFirmasResponse enviaFirmas(final Model model, @RequestBody
	final EnviaFirmasForm dataForm, final HttpServletResponse response, final HttpServletRequest request)
	{
		final EnviaFirmasRequest enviaFirmasRequest = new EnviaFirmasRequest();

		enviaFirmasRequest.setNumForm(dataForm.getNumForm());


		if (CollectionUtils.isNotEmpty(dataForm.getFirmantes()))
		{
			final List<FirmanteRequest> firmantesList = new ArrayList<FirmanteRequest>();
			for (final FirmantesForm eachFirmante : dataForm.getFirmantes())
			{
				final FirmanteRequest firmante = new FirmanteRequest();

				firmante.setConfirmacion(eachFirmante.getConfirmacion());
				firmante.setFirmante(eachFirmante.getFirmante());
				firmante.setNumIdentif(eachFirmante.getNumIdentif());
				firmante.setTipoIdent(eachFirmante.getTipoIdent());


				firmantesList.add(firmante);
			}
			enviaFirmasRequest.setTablFirmante(firmantesList);
		}

		return sdhEnviaFirmasFacade.enviaFirmas(enviaFirmasRequest);
	}


	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_ST(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Menu sobretasa gasolina GET --------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		DetGasResponse detalleGasolinaResponse = null;
		ImpGasolinaSimpliResponse gasolinaSimpliResponse = new ImpGasolinaSimpliResponse();
		List<ImpuestoGasolina> gasolina = new ArrayList<ImpuestoGasolina>();
		final SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();


		final String[] mensajesError;
		String numBP = "";
		String tipoDoc = "";
		String numDoc = "";
		String anioGravable = "";
		String periodo = "";
		String returnURL = "/";
		final boolean l_ocurrio_error = false;
		String mensajeError = null;

		numBP = customerModel.getNumBP();

		contribuyenteRequest.setNumBP(numBP);

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			gasolinaSimpliResponse = mapper.readValue(
					sdhConsultaImpuesto_simplificado.consulta_impGasolina_string(contribuyenteRequest),
					ImpGasolinaSimpliResponse.class);

			gasolina = gasolinaSimpliResponse.getGasolina();
			detalleContribuyente.setGasolina(gasolina);
			sdhCustomerAccountService.updateImpuestoGasolina_simplificado(customerModel, gasolinaSimpliResponse);
		}
		catch (final IOException e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

		}


		//	detalleContribuyente.getInfoContrib().getAdicionales().getNAME_ORG1();
		if (gasolinaService.ocurrioErrorValcontGas(gasolinaSimpliResponse) != true)
		{
			tipoDoc = customerModel.getDocumentType();
			numDoc = customerModel.getDocumentNumber();
			periodo = gasolinaService.obtenerPeriodoActual();
			anioGravable = Integer.toString(gasolinaService.obtenerAnoGravableActual());


			detalleGasolinaRequest.setNumBP(numBP);
			detalleGasolinaRequest.setNumDoc(numDoc);
			detalleGasolinaRequest.setTipoDoc(tipoDoc);
			detalleGasolinaRequest.setAnoGravable(anioGravable);
			detalleGasolinaRequest.setPeriodo(periodo);

			System.out.println("Request de infObjeto/Gasolina: " + detalleGasolinaRequest);
			detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
			System.out.println("Response de infObjeto/Gasolina: " + detalleGasolinaResponse);
			if (gasolinaService.ocurrioErrorDetalle(detalleGasolinaResponse) != true)
			{
				detalleGasolinaResponse.setAlmacProd(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getAlmacProd()));
				detalleGasolinaResponse.setNumTanques(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getNumTanques()));
				detalleGasolinaResponse.setAlmacTanque(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getAlmacTanque()));
				detalleGasolinaResponse
						.setRepresentantes(gasolinaService.prepararTablaRepresentantes(detalleGasolinaResponse.getRepresentantes()));
				if (gasolinaService.prepararTablaDeclaracion(detalleContribuyente.getGasolina()).size() > 0)
				{
					dataForm.setListaDocumentos(gasolinaService.prepararTablaDeclaracion(detalleContribuyente.getGasolina()));
					//	dataForm.setNAME_ORG1(detalleContribuyente.getInfoContrib().getAdicionales().getNAME_ORG1());
					dataForm.setCatalogosSo(gasolinaService.prepararCatalogos(sdhConfigCatalogos));
					dataForm.setAnoGravable(Integer.toString(gasolinaService.obtenerAnoGravableActual()));
					dataForm.setPeriodo(gasolinaService.obtenerPeriodoActual());
					dataForm.setNumBP(numBP);
					dataForm.setNumDoc(numDoc);
					dataForm.setTipoDoc(tipoDoc);
					dataForm.setDataForm(detalleGasolinaResponse);
				}
				dataForm.setOpcionUso(detalleGasolinaResponse.getOpcionUso());
			}
			else
			{
				mensajeError = "error.impuestoGasolina.sobretasa.error1";
			}
		}
		else
		{
			mensajeError = "error.impuestoGasolina.sobretasa.error2";
		}

		if (dataForm != null)
		{
			dataForm.setControlCampos(new SobreTasaGasolinaControlCamposDec());
			dataForm.getControlCampos().setPasarALiquidador(true);
			dataForm.setMensajeError(null);

			if (detalleGasolinaResponse != null && detalleGasolinaResponse.getErrores() != null)
			{
				for (final ErrorEnWS etemp : detalleGasolinaResponse.getErrores())
				{
					if (etemp != null && etemp.getIdmsj() != null && etemp.getIdmsj().equals("200"))
					{
						dataForm.getControlCampos().setPasarALiquidador(false);
						dataForm.setMensajeError(etemp.getTxtmsj());
						mensajeError = null;
					}
				}
			}
		}

		if (mensajeError != null)
		{
			GlobalMessages.addErrorMessage(model, mensajeError);
		}




		gasolinaService.ajustarMenus(detalleContribuyente, dataForm);
		model.addAttribute("dataForm", dataForm);
		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		returnURL = getViewForPage(model);

		return returnURL;

	}

	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion-gasolina", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_DEC(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Declaracion gasolina GET --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final DetGasRevisorDeclaranteResponse revisor = new DetGasRevisorDeclaranteResponse();
		final DetGasRevisorDeclaranteResponse declarante = new DetGasRevisorDeclaranteResponse();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		final SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetallePagoRequest detallePagoRequest = new DetallePagoRequest();
		DetGasResponse detalleGasolinaResponse;
		final DetallePagoResponse detallePagoResponse;
		final List<DetGasInfoDeclaraResponse> infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
		final List<DetGasInfoDeclaraResponse> infoDeclaraDefaultTMP;
		final PSEPaymentForm psePaymentForm = new PSEPaymentForm();
		String clavePeriodo = "";
		String mensajeError = "";
		ImpGasolinaSimpliResponse gasolinaSimpliResponse = new ImpGasolinaSimpliResponse();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		model.addAttribute("customerData", customerData);
		addAgentsToModel(model, customerData, null);
		model.addAttribute("redirectURL", "/contribuyentes/sobretasa-gasolina");
		super.addFirmantes_impuesto(model, null, customerData);
		List<ImpuestoGasolina> gasolina = new ArrayList<ImpuestoGasolina>();

		final SobreTasaGasolinaCatalogos catalogos = gasolinaService.prepararCatalogos(sdhConfigCatalogos);

		String[] mensajesError;
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anoGravable = "";
		String periodo = "";


		numBP = customerModel.getNumBP();
		if (dataForm != null)
		{
			anoGravable = dataForm.getAnoGravable();
			periodo = dataForm.getPeriodo();
			numDoc = dataForm.getNumDoc();
			tipoDoc = dataForm.getTipoDoc();
		}


		final String tipoRevisor = "1";
		final String tipoDeclarante = "2";


		detalleGasolinaRequest.setNumBP(numBP);
		detalleGasolinaRequest.setNumDoc(numDoc);
		detalleGasolinaRequest.setTipoDoc(tipoDoc);
		detalleGasolinaRequest.setAnoGravable(anoGravable);
		detalleGasolinaRequest.setPeriodo(periodo);

		System.out.println("Request de infObjeto/Gasolina: " + detalleGasolinaRequest);
		detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de infObjeto/Gasolina: " + detalleGasolinaResponse);
		if (gasolinaService.ocurrioErrorDetalle(detalleGasolinaResponse) != true)
		{
			detalleGasolinaResponse.setAlmacProd(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getAlmacProd()));
			detalleGasolinaResponse.setNumTanques(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getNumTanques()));
			detalleGasolinaResponse.setAlmacTanque(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getAlmacTanque()));


			dataForm.setAnoGravable(anoGravable);
			dataForm.setPeriodo(periodo);
			dataForm.setNumDoc(numDoc);
			dataForm.setOpcionUso(prepararOpcionUso(detalleGasolinaResponse.getOpcionUso()));
			dataForm.setNumForm(detalleGasolinaResponse.getNumForm());
			infoDeclaraDefaultTMP = gasolinaService.prepararInfoDeclara(detalleGasolinaResponse.getInfoDeclara());
			if (infoDeclaraDefaultTMP != null && infoDeclaraDefaultTMP.size() > 0)
			{
				infoDeclaraDefault.addAll(infoDeclaraDefaultTMP);
			}
			else if (dataForm.getDataForm().getInfoDeclara() != null && dataForm.getDataForm().getInfoDeclara().size() > 0)
			{
				infoDeclaraDefault.addAll(dataForm.getDataForm().getInfoDeclara());
			}
			infoDeclaraDefault.addAll(gasolinaService.prepararInfoDeclaraDefault(1));

			dataForm.getDataForm().setInfoDeclara(infoDeclaraDefault);

			dataForm.setValoresDeclara(detalleGasolinaResponse.getValoresDeclara());
			if (detalleGasolinaResponse.getRevisorDeclarante() != null)
			{
				for (int i = 0; i < detalleGasolinaResponse.getRevisorDeclarante().size(); i++)
				{
					if (detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoInterloc().equals(tipoRevisor) == true)
					{
						revisor.setTipoDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
						revisor.setTipoDocDESC(gasolinaService.getDescripcion(revisor.getTipoDoc(), catalogos.getTipoIdRev()));
						revisor.setNumDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
						revisor.setNombres(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
						revisor.setTarjetaProf(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
						dataForm.setRevisor(revisor);
					}
					else
					{
						declarante.setTipoDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
						declarante.setTipoDocDESC(gasolinaService.getDescripcion(declarante.getTipoDoc(), catalogos.getTipoIdRev()));
						declarante.setNumDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
						declarante.setNombres(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
						declarante.setTarjetaProf(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
						dataForm.setDeclarante(declarante);
					}
				}
			}

			contribuyenteRequest.setNumBP(numBP);

			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				gasolinaSimpliResponse = mapper.readValue(
						sdhConsultaImpuesto_simplificado.consulta_impGasolina_string(contribuyenteRequest),
						ImpGasolinaSimpliResponse.class);

				gasolina = gasolinaSimpliResponse.getGasolina();

			}
			catch (final IOException e)
			{
				LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
				GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");

			}

			detalleContribuyente.setGasolina(gasolina);
			if (gasolinaService.ocurrioErrorValcontGas(gasolinaSimpliResponse) != true)
			{
				customerModel.getGasTaxList();

				declarante.setTipoDoc(customerModel.getDocumentType());
				declarante.setTipoDocDESC(gasolinaService.getDescripcion(declarante.getTipoDoc(), catalogos.getTipoIdRev()));
				declarante.setNumDoc(customerModel.getDocumentNumber());
				//	declarante.setNombres(detalleContribuyente.getInfoContrib().getAdicionales().getNAME_ORG1());
				dataForm.setDeclarante(declarante);
				dataForm.setCatalogosSo(catalogos);

				clavePeriodo = gasolinaService.prepararPeriodoMensualPago(dataForm.getAnoGravable(), dataForm.getPeriodo());
				detallePagoRequest.setNumBP(numBP);
				detallePagoRequest.setClavePeriodo(clavePeriodo);
				detallePagoRequest.setNumObjeto(gasolinaService.prepararNumObjetoGasolina(detalleContribuyente));
			}
			else
			{
				mensajeError = detalleContribuyente.getTxtmsj();
				LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
				GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
			}
		}
		else
		{
			mensajesError = gasolinaService.prepararMensajesError(detalleGasolinaResponse.getErrores());
			LOG.error("Error al leer detalle de gasolina: " + mensajesError);
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error1", mensajesError);

			final DetGasInfoDeclaraResponse infoDeclara = new DetGasInfoDeclaraResponse();
			final List listaInfoDeclara = new ArrayList<DetGasInfoDeclaraResponse>();
			listaInfoDeclara.add(new DetGasInfoDeclaraResponse());

			detalleGasolinaResponse = new DetGasResponse();

			detalleGasolinaResponse.setInfoDeclara(listaInfoDeclara);
			dataForm.setDataForm(detalleGasolinaResponse);
			dataForm.setCatalogosSo(catalogos);

		}
		model.addAttribute("dataForm", dataForm);
		model.addAttribute("detallePagoRequest", detallePagoRequest);



		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);


	}

	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion-gasolina", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_DEC(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("----------------Declaracion gasolina POST --------------------------");

		List<DetGasInfoDeclaraResponse> infoDeclaraDefault;
		List<DetGasRevisorDeclaranteResponse> revisorDeclaranteDefault;
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final CalculaGasolinaRequest consultaGasolinaRequest = new CalculaGasolinaRequest();
		final DetGasRevisorDeclaranteResponse revisor = new DetGasRevisorDeclaranteResponse();
		final DetGasRevisorDeclaranteResponse declarante = new DetGasRevisorDeclaranteResponse();
		final CalculaGasolinaResponse calculaGasolinaResponse;
		String[] mensajesError;
		int claveError;
		List infoDeclaraDefaultTMP;

		String numBP = sessionService.getCurrentSession().getAttribute("representado");
		if (numBP == null)
		{
			numBP = customerModel.getNumBP();
		}
		String numDoc = customerModel.getDocumentNumber();
		String tipoDoc = "";
		String anoGravable = "";
		String periodo = "";
		String numForm = "";
		String opcionUso = "";
		String calidResp = "";
		infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
		infoDeclaraDefault.add(new DetGasInfoDeclaraResponse());
		revisorDeclaranteDefault = new ArrayList<DetGasRevisorDeclaranteResponse>();
		revisorDeclaranteDefault.add(new DetGasRevisorDeclaranteResponse());
		final String tipoRevisor = "1";
		final String tipoDeclarante = "2";


		if (dataForm != null)
		{
			tipoDoc = gasolinaService.obtenerTipoDoc(dataForm.getListaDocumentos());
			numDoc = gasolinaService.obtenerNumDoc(dataForm.getListaDocumentos());
			anoGravable = dataForm.getAnoGravable();
			periodo = dataForm.getPeriodo();
			if (dataForm.getDataForm().getInfoDeclara() != null)
			{
				infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
				for (int i = 0; i < dataForm.getDataForm().getInfoDeclara().size(); i++)
				{
					if (dataForm.getDataForm().getInfoDeclara().get(i).getGalonesGra() != null
							&& dataForm.getDataForm().getInfoDeclara().get(i).getGalonesGra().equals("") != true)
					{
						infoDeclaraDefault.add(dataForm.getDataForm().getInfoDeclara().get(i));
					}
				}
			}
		}

		if (dataForm.getDataForm().getRevisorDeclarante() != null)
		{
			revisorDeclaranteDefault = dataForm.getDataForm().getRevisorDeclarante();
		}
		numForm = dataForm.getNumForm();
		opcionUso = dataForm.getOpcionUso();
		calidResp = dataForm.getDataForm().getCalidResp();

		consultaGasolinaRequest.setNumBP(numBP);
		consultaGasolinaRequest.setNumDoc(customerModel.getDocumentNumber());
		consultaGasolinaRequest.setTipoDoc(customerModel.getDocumentType());
		consultaGasolinaRequest.setAnoGravable(anoGravable);
		consultaGasolinaRequest.setPeriodo(periodo);
		consultaGasolinaRequest.setNumForm(numForm);
		consultaGasolinaRequest.setOpcionUso(prepararOpcionUso(opcionUso));
		consultaGasolinaRequest.setInfoDeclara(infoDeclaraDefault);
		consultaGasolinaRequest.setRevisorDeclarante(revisorDeclaranteDefault);


		System.out.println("Request de calculoImp/Gasolina: " + consultaGasolinaRequest);
		calculaGasolinaResponse = gasolinaService.consultaCalGasolina(consultaGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de calculoImp/Gasolina: " + calculaGasolinaResponse);
		if (gasolinaService.ocurrioErrorCalcular(calculaGasolinaResponse) != true)
		{
			dataForm.setNumForm(calculaGasolinaResponse.getNumForm());

			infoDeclaraDefaultTMP = gasolinaService.prepararInfoDeclara(calculaGasolinaResponse.getInfoDeclara());
			infoDeclaraDefaultTMP = infoDeclaraDefaultTMP.size() == 0 ? null : infoDeclaraDefaultTMP;
			if (infoDeclaraDefaultTMP != null && infoDeclaraDefaultTMP.size() > 0)
			{
				infoDeclaraDefault = infoDeclaraDefaultTMP;
			}
			dataForm.getDataForm().setInfoDeclara(infoDeclaraDefault);
			dataForm.getDataForm().setValoresDeclara(calculaGasolinaResponse.getValoresDeclara());
			if (calculaGasolinaResponse.getRevisorDeclarante() != null)
			{
				for (int i = 0; i < calculaGasolinaResponse.getRevisorDeclarante().size(); i++)
				{
					if (calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoInterloc().equals(tipoRevisor) == true)
					{
						revisor.setTipoDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
						revisor.setNumDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
						revisor.setNombres(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
						revisor.setTarjetaProf(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
						dataForm.setRevisor(revisor);
					}
					else
					{
						declarante.setTipoDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
						declarante.setNumDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
						declarante.setNombres(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
						declarante.setTarjetaProf(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
						dataForm.setDeclarante(declarante);
					}
				}
			}
			dataForm.setCatalogosSo(gasolinaService.prepararCatalogos(sdhConfigCatalogos));
			model.addAttribute("dataForm", dataForm);
		}
		else
		{
			LOG.error("Error al leer calculo de gasolina: " + calculaGasolinaResponse.getErrores().get(0).getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(calculaGasolinaResponse.getErrores());
			claveError = mensajesError.length <= 10 ? mensajesError.length : 10;
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error3.attrib" + Integer.toString(claveError), mensajesError);
		}



		return REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
	}





	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion-gasolinaPagar", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_PAG(@ModelAttribute("psePaymentForm")
	final PSEPaymentForm psePaymentForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes, final HttpServletRequest request, final HttpServletResponse response)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Declaracion gasolina Pagar GET --------------------------");

		model.addAttribute("psePaymentForm", psePaymentForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_PAGAR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_PAGAR_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);



		return getViewForPage(model);
	}



	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion-gasolinaPagar", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_PAG(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm, @ModelAttribute("detallePagoRequest")
	final DetallePagoRequest detallePagoRequest, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Declaracion gasolina Pagar POST --------------------------");



		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		String[] mensajesError;
		final int claveError;
		String mensajeError = "";
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		SDHValidaMailRolResponse detalleContribuyente = new SDHValidaMailRolResponse();
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetGasResponse detalleGasolinaResponse;
		final DetallePagoResponse detallePagoResponse;
		final PSEPaymentForm psePaymentForm = new PSEPaymentForm();
		String clavePeriodo = "";
		final ImpGasolinaSimpliResponse gasolinaSimpliResponse = new ImpGasolinaSimpliResponse();

		String numBP = customerModel.getNumBP();
		final String numDoc = customerModel.getDocumentNumber();
		final String tipoDoc = "";
		final String anoGravable = "";
		final String periodo = "";
		String errorSITII = null;

		numBP = detallePagoRequest.getNumBP();
		contribuyenteRequest.setNumBP(numBP);

		System.out.println("Request de validaCont_simplificado: " + contribuyenteRequest);
		//detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		detalleContribuyente = gasolinaService.consultaContribuyenteGas(customerModel);

		if (detalleContribuyente.getGasolina() == null || detalleContribuyente.getGasolina().isEmpty())
		{
			detalleContribuyente = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "05");
		}

		System.out.println("Response de validaCont_simplificado: " + detalleContribuyente);
		if (gasolinaService.ocurrioErrorValcontGas(gasolinaSimpliResponse) != true)
		{
			clavePeriodo = gasolinaService.prepararPeriodoMensualPago(dataForm.getAnoGravable(), dataForm.getPeriodo());
			detallePagoRequest.setNumBP(numBP);
			detallePagoRequest.setClavePeriodo(clavePeriodo);
			detallePagoRequest.setNumObjeto(gasolinaService.prepararNumObjetoGasolina(detalleContribuyente));
			detallePagoRequest.setNumObjeto(gasolinaService.prepararNumObjetoGasolina(detalleContribuyente));

			System.out.println("Request de consulPago: " + detallePagoRequest);
			detallePagoResponse = gasolinaService.consultaDetallePago(detallePagoRequest, sdhDetalleGasolinaWS, LOG);
			System.out.println("Response de consulPago: " + detallePagoResponse);
			if (gasolinaService.ocurrioErrorPSE(detallePagoResponse) != true)
			{
				psePaymentForm.setTipoDeImpuesto(new ControllerPseConstants().getGASOLINA());
				psePaymentForm.setAnoGravable(dataForm.getAnoGravable());
				psePaymentForm.setValorAPagar(detallePagoResponse.getTotalPagar());
				psePaymentForm.setPeriodo(clavePeriodo);
				psePaymentForm.setTipoDeIdentificacion(dataForm.getTipoDoc());
				psePaymentForm.setNoIdentificacion(dataForm.getNumDoc());
				psePaymentForm.setNumeroDeReferencia(detallePagoResponse.getNumRef());
				psePaymentForm.setFechaLimiteDePago(detallePagoResponse.getFechVenc());
				psePaymentForm.setDV(gasolinaService.prepararDV(detalleContribuyente));
				psePaymentForm.setObjPago(detalleContribuyente.getGasolina().get(0).getNumObjeto());

			}
			else
			{
				mensajeError = gasolinaService.obtenerMensajeError(detallePagoResponse.getErrores(), 0);
				LOG.error("Error al leer detalle de pago: " + mensajeError);
				mensajesError = gasolinaService.prepararMensajesError(detallePagoResponse.getErrores());
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
						"error.impuestoGasolina.sobretasa.error4", mensajesError);

				model.addAttribute("dataForm", dataForm);
				return REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
			}
		}
		else
		{
			LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(
					gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error2", mensajesError);
		}
		model.addAttribute("dataForm", dataForm);
		model.addAttribute("psePaymentForm", psePaymentForm);



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
				if (!psePaymentForm.getCUD().equals(""))
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

			listaDeclaracionesRequest.setBp(numBP);
			listaDeclaracionesRequest.setImpuesto(impuestoSAP);
			listaDeclaracionesRequest.setAnioGravable(dataForm.getAnoGravable());
			listaDeclaracionesRequest.setPeriodo(dataForm.getPeriodo());
			listaDeclaracionesRequest.setNumObjeto(detalleContribuyente.getGasolina().get(0).getNumObjeto());


			//Obtiene la ref4 con los valores concatenados para imprimir un formulario con ws imprimePago
			final StringBuffer sb = new StringBuffer();
			String ref4 = null;

			sb.append(numBP + ";");
			sb.append(impuestoSAP + ";");
			sb.append(dataForm.getAnoGravable() + ";");
			sb.append(dataForm.getPeriodo() + ";");
			sb.append(detalleContribuyente.getGasolina().get(0).getNumObjeto() + ";");
			sb.append(" ");

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

			
			String descImp = new String();
            if (psePaymentForm.getTipoDeImpuesto().contains("5103"))
            {
                descImp = "Vehiculos";
            }
            else
            {
                descImp = Objects.nonNull(sdhTaxTypeModel) ? sdhTaxTypeModel.getName() : StringUtils.EMPTY;
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
							return "redirect: /bogota/es/contribuyentes/consultas/obligaciones";
						}
						else
						{
							final SITIITransactionsLogModel sitIITransactionsLogModel = new SITIITransactionsLogModel();
							sitIITransactionsLogModel.setTransactionBP(numBP);
							sitIITransactionsLogModel.setTransactionDate(java.time.LocalDate.now().toString());
							sitIITransactionsLogModel.setTransactionTime(java.time.LocalTime.now().toString());
							sitIITransactionsLogModel.setTransactionReference(psePaymentForm.getNumeroDeReferencia());
							sitIITransactionsLogModel.setTransactionNUS(paymentServiceRegisterResponse.getNus().toString());
							sitIITransactionsLogModel.setTransactionAmount(valorAPagar.toString());



							modelService.saveAll(sitIITransactionsLogModel);

							LOG.error("SITIITransactionsLog:[ BP" + sitIITransactionsLogModel.getTransactionBP()
                                    + "TransactionDate: " + sitIITransactionsLogModel.getTransactionDate()
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
			return REDIRECT_TO_DECLARACIONES_PAGAR_PAGE;
		}


	}




	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion/show", method = RequestMethod.GET)
	@RequireHardLogIn
	public String show(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm, final BindingResult bindingResult, final Model model,
			@RequestParam(required = true, value = "numForm")
			final String numForm, @RequestParam(required = true, value = "representado")
			final String representado, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Declaracion gasolina Agente Autorizado --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final DetGasRevisorDeclaranteResponse revisor = null;
		final DetGasRevisorDeclaranteResponse declarante = new DetGasRevisorDeclaranteResponse();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		SDHValidaMailRolResponse detalleContribuyente;
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetallePagoRequest detallePagoRequest = new DetallePagoRequest();
		DetGasResponse detalleGasolinaResponse = null;
		final DetallePagoResponse detallePagoResponse;
		final List<DetGasInfoDeclaraResponse> infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
		final List<DetGasInfoDeclaraResponse> infoDeclaraDefaultTMP;
		final PSEPaymentForm psePaymentForm = new PSEPaymentForm();
		String clavePeriodo = "";
		String mensajeError = "";
		DetGasRevisorDeclaranteResponse interlocutor = null;

		final CustomerData currentUserData = this.getCustomerFacade().getCurrentCustomer();
		final CustomerData contribuyenteData = sdhCustomerFacade.getRepresentadoDataFromSession();

		model.addAttribute("contribuyenteData", contribuyenteData);
		model.addAttribute("currentUserData", currentUserData);
		model.addAttribute("redirectURL", "/autorizados/contribuyente/representando?representado=" + contribuyenteData.getNumBP());
		final CalcGasolina2Request calculaGasolina2Request = new CalcGasolina2Request();
		calculaGasolina2Request.setPartner(representado);
		calculaGasolina2Request.setFormulario(numForm);
		final CalcGasolina2Response calcGasolina2Response = sdhCalculaGasolina2Facade.calcula(calculaGasolina2Request);

		addAgentsToModel(model, contribuyenteData, currentUserData);
		if (calcGasolina2Response != null)
		{
			super.addFirmantes_impuesto(model, calcGasolina2Response.getFirmantes(), currentUserData);
		}

		final SobreTasaGasolinaCatalogos catalogos = gasolinaService.prepararCatalogos(sdhConfigCatalogos);

		final String[] mensajesError;
		String numBP = "";
		final String numDoc = "";
		final String tipoDoc = "";
		final String anoGravable = "";
		final String periodo = "";


		numBP = representado;
		//		if (dataForm != null)
		//		{
		//			anoGravable = dataForm.getAnoGravable();
		//			periodo = dataForm.getPeriodo();
		//			numDoc = dataForm.getNumDoc();
		//			tipoDoc = dataForm.getTipoDoc();
		//		}


		final String tipoRevisor = "1";
		final String tipoDeclarante = "2";


		//		detalleGasolinaRequest.setNumBP(numBP);
		//		detalleGasolinaRequest.setNumDoc(numDoc);
		//		detalleGasolinaRequest.setTipoDoc(tipoDoc);
		//		detalleGasolinaRequest.setAnoGravable(anoGravable);
		//		detalleGasolinaRequest.setPeriodo(periodo);

		//		System.out.println("Request de infObjeto/Gasolina: " + detalleGasolinaRequest);
		//		detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		//		System.out.println("Response de infObjeto/Gasolina: " + detalleGasolinaResponse);
		//		if (gasolinaService.ocurrioErrorDetalle(detalleGasolinaResponse) != true)
		final DetGasValoresDeclaraResponse valoresDeclara = new DetGasValoresDeclaraResponse();
		detalleGasolinaResponse = new DetGasResponse();
		detalleGasolinaResponse.setAlmacProd(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getAlmacProd()));
		detalleGasolinaResponse.setNumTanques(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getNumTanques()));
		detalleGasolinaResponse.setAlmacTanque(gasolinaService.prepararValNumerico(detalleGasolinaResponse.getAlmacTanque()));

		if (calcGasolina2Response != null)
		{
			valoresDeclara.setTotalSobretasa(calcGasolina2Response.getTotal_sobretasa());
			valoresDeclara.setVlrSancTotales(calcGasolina2Response.getVlr_sanc_totales());
			valoresDeclara.setTotalCargo(calcGasolina2Response.getTotal_cargo());
			valoresDeclara.setVlrSancPagos(calcGasolina2Response.getVlr_sanc_pagos());
			valoresDeclara.setInteresMora(calcGasolina2Response.getInteres_mora());
			valoresDeclara.setVlrSobretasa(calcGasolina2Response.getVlr_sobrestasa());
			valoresDeclara.setMenosCompensa(calcGasolina2Response.getMenosCompensa());
			valoresDeclara.setTotalPagar(calcGasolina2Response.getTotalPagar());

			dataForm.setAnoGravable(calcGasolina2Response.getAnio_gravable());
			dataForm.setPeriodo(calcGasolina2Response.getPeriodo());
			dataForm.setOpcionUso(prepararOpcionUso(calcGasolina2Response.getOpcion_uso()));
			detalleGasolinaResponse.setInfoDeclara(calcGasolina2Response.getInfo_declara());
		}
		dataForm.setNumForm(numForm);
		dataForm.setTipoDoc(contribuyenteData.getDocumentType());
		dataForm.setNumDoc(contribuyenteData.getDocumentNumber());

		infoDeclaraDefaultTMP = gasolinaService.prepararInfoDeclara(detalleGasolinaResponse.getInfoDeclara());
		if (infoDeclaraDefaultTMP != null && infoDeclaraDefaultTMP.size() > 0)
		{
			infoDeclaraDefault.addAll(infoDeclaraDefaultTMP);
		}
		else if (dataForm.getDataForm().getInfoDeclara() != null && dataForm.getDataForm().getInfoDeclara().size() > 0)
		{
			infoDeclaraDefault.addAll(dataForm.getDataForm().getInfoDeclara());
		}
		infoDeclaraDefault.addAll(gasolinaService.prepararInfoDeclaraDefault(1));

		detalleGasolinaResponse.setInfoDeclara(infoDeclaraDefault);
		detalleGasolinaResponse.setValoresDeclara(valoresDeclara);
		dataForm.setDataForm(detalleGasolinaResponse);

		if (calcGasolina2Response != null && calcGasolina2Response.getFirmantes() != null)
		{
			for (int i = 0; i < calcGasolina2Response.getFirmantes().size(); i++)
			{
				//					if (calcGasolina2Response.getFirmantes().get(i).getTipoInterloc().equals(tipoRevisor) == true)
				interlocutor = new DetGasRevisorDeclaranteResponse();
				interlocutor.setTipoDoc(calcGasolina2Response.getFirmantes().get(i).getTipoIdent());
				interlocutor.setTipoDocDESC(gasolinaService.getDescripcion(interlocutor.getTipoDoc(), catalogos.getTipoIdRev()));
				interlocutor.setNumDoc(calcGasolina2Response.getFirmantes().get(i).getNumIdent());
				interlocutor.setNombres(calcGasolina2Response.getFirmantes().get(i).getNombre());
				interlocutor.setTarjetaProf(""); //FALTA EN WS

				dataForm.setDeclarante(interlocutor);
			}
		}


		//			numBP = customerModel.getNumBP();
		//		contribuyenteRequest.setNumBP(representado);
		//		final ImpGasolinaSimpliResponse gasolinaSimpliResponse = new ImpGasolinaSimpliResponse();
		//		System.out.println("Request de validaCont: " + contribuyenteRequest);
		//		detalleContribuyente = gasolinaService.consultaContribuyenteGas(customerModel);
		//		System.out.println("Response de validaCont: " + detalleContribuyente);
		detalleContribuyente = sessionService.getCurrentSession().getAttribute("representadoData");
		if (detalleContribuyente != null)
		{
			declarante.setTipoDoc(detalleContribuyente.getInfoContrib().getTipoDoc());
			declarante.setTipoDocDESC(gasolinaService.getDescripcion(declarante.getTipoDoc(), catalogos.getTipoIdRev()));
			declarante.setNumDoc(detalleContribuyente.getInfoContrib().getNumDoc());
			declarante.setNombres(detalleContribuyente.getInfoContrib().getAdicionales().getNAME_ORG1());
			dataForm.setDeclarante(declarante);
			dataForm.setCatalogosSo(catalogos);

			clavePeriodo = gasolinaService.prepararPeriodoMensualPago(dataForm.getAnoGravable(), dataForm.getPeriodo());
			detallePagoRequest.setNumBP(numBP);
			detallePagoRequest.setClavePeriodo(clavePeriodo);
			detallePagoRequest.setNumObjeto(gasolinaService.prepararNumObjetoGasolina(detalleContribuyente));
		}
		else
		{
			mensajeError = detalleContribuyente.getTxtmsj();
			LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
			//				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
			//						"error.impuestoGasolina.sobretasa.error2", mensajesError);
		}
		dataForm.setControlCampos(establecerCamposImpuestoDec("sdh_02", contribuyenteData, currentUserData));
		model.addAttribute("dataForm", dataForm);
		model.addAttribute("detallePagoRequest", detallePagoRequest);



		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);


	}

	@RequestMapping(value = "/setComplete8", method = RequestMethod.POST)
	public String setComplete(final SessionStatus status)
	{
		status.setComplete();

		return null;
	}

	private String prepararOpcionUso(final String opcionUso)
	{
		String valorRetorno = null;

		if (opcionUso != null && opcionUso.length() >= 2)
		{
			valorRetorno = opcionUso.substring(0, 2);
		}


		return valorRetorno;
	}


	private SobreTasaGasolinaControlCamposDec establecerCamposImpuestoDec(final String rol, final CustomerData contribuyenteData,
			final CustomerData currentUserData)
	{
		final SobreTasaGasolinaControlCamposDec controlCampos = new SobreTasaGasolinaControlCamposDec();
		final String strRepresentanteLegalPrincipal = "Repres. Legal Principal";
		final String strContador = "Contador";
		String funcionInterlocultorValida = null;

		if (contribuyenteData.getDocumentType().equals("NIT") || currentUserData != null)
		{
			controlCampos.setBtnPresentarDec(true);
			controlCampos.setBtnPagarDec(true);
			controlCampos.setDatosGenerales(true);
			controlCampos.setInformacionDeclaracion(true);
		}

		switch (contribuyenteData.getDocumentType())
		{
			case "NIT":
				funcionInterlocultorValida = strRepresentanteLegalPrincipal;
				break;
			default:
				funcionInterlocultorValida = strContador;
				break;
		}

		switch (rol)
		{
			case "sdh_02":
				if (contribuyenteData.getAgentList() != null && currentUserData != null)
				{
					controlCampos.setDatosGenerales(true);
					controlCampos.setInformacionDeclaracion(true);

					for (final SDHAgentData infoAgente : contribuyenteData.getAgentList())
					{
						if (infoAgente != null)
						{
							if (!StringUtils.isEmpty(infoAgente.getBp()) && !StringUtils.isEmpty(infoAgente.getInternalFunction())
									&& infoAgente.getInternalFunction() != null && infoAgente.getBp() != null
									&& infoAgente.getBp().equals(currentUserData.getNumBP())
									&& infoAgente.getInternalFunction().equals(funcionInterlocultorValida))
							{
								controlCampos.setBtnPresentarDec(false);
								controlCampos.setBtnPagarDec(false);
								break;
							}
						}
					}
				}

				break;

			default:
				break;
		}

		return controlCampos;
	}


}


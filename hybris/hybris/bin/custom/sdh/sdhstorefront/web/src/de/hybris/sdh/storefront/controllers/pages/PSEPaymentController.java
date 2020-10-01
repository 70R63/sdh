package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.credibanco.InititalizeTransactionRequest;
import de.hybris.sdh.core.credibanco.InititalizeTransactionResponse;
import de.hybris.sdh.core.dao.PseBankListCatalogDao;
import de.hybris.sdh.core.dao.PseTransactionsLogDao;
import de.hybris.sdh.core.dao.SDHPaymentMethodDao;
import de.hybris.sdh.core.enums.SdhOnlinePaymentProviderEnum;
import de.hybris.sdh.core.enums.SdhTaxTypesEnum;
import de.hybris.sdh.core.model.PseBankListCatalogModel;
import de.hybris.sdh.core.model.PseTransactionsLogModel;
import de.hybris.sdh.core.model.SDHPaymentMethodModel;
import de.hybris.sdh.core.pojos.requests.ConsultaPagoRequest;
import de.hybris.sdh.core.pojos.requests.ImprimePagoRequest;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoDeclaraciones;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoResponse;
import de.hybris.sdh.core.pojos.responses.ImprimePagoResponse;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHCredibancoJwt;
import de.hybris.sdh.core.services.SDHImprimePagoService;
import de.hybris.sdh.core.services.SDHPseTransactionsLogService;
import de.hybris.sdh.core.soap.pse.PseServices;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.AmountType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseReturnCodeList;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseTransactionStateCodeList;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;
import de.hybris.sdh.facades.online.payment.impl.DefaultSDHOnlinePaymentProviderMatcherFacade;
import de.hybris.sdh.facades.questions.data.SDHGasTaxData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;
import de.hybris.sdh.storefront.forms.PSEPaymentForm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.axis.types.NonNegativeInteger;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Consultor
 *
 */
@Controller
@RequestMapping("/impuestos")
public class PSEPaymentController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(PSEPaymentController.class); //new
	private static final String CMS_SITE_PAGE_PAGO_PSE = "PagoPSEPage";
	private static final String CMS_SITE_PAGE_PAGO_EN_lINEA = "PagoEnLineaPSEPage";

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_PAGO_LINEA = "Pago en linea";
	private static final String TEXT_PSE_RESPUESTA = "Respuesta de pago";
	private static final String TEXT_PSE_FORMA = "Pague aquí";
	private static final String TEXT_REALIZAR_PAGO = "Realizar Pago";
	private static final String VACIO = "";
	private static final Map<String, String> CREDIBANCO_PERSON_TYPE_DOCUMENT_TYPE = new HashMap<String, String>()
	{
		{
			put("CC", "1");
			put("NIT","2");
			put("CE", "1");
			put("TI", "1");
			put("PP", "1");
		}
	};


	@Resource(name = "pseBankListCatalogDao")
	private PseBankListCatalogDao pseBankListCatalogDao;


	@Resource(name = "sdhPaymentMethodDao")
	private SDHPaymentMethodDao sdhPaymentMethodDao;


	@Resource(name = "defaultPseServices")
	private PseServices pseServices;


	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	@Resource(name = "pseTransactionsLogService")
	private SDHPseTransactionsLogService pseTransactionsLogService;

	@Resource(name = "pseTransactionsLogDao")
	private PseTransactionsLogDao pseTransactionsLogDao;


	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sdhConsultaPagoService")
	SDHConsultaPagoService sdhConsultaPagoService;

	@Resource(name = "sdhImprimePagoService")
	SDHImprimePagoService sdhImprimePagoService;

	@Resource(name = "sdhCredibancoJwt")
	SDHCredibancoJwt sdhCredibancoJwt;

	@Resource(name = "sdhOnlinePaymentProviderMatcherFacade")
	private DefaultSDHOnlinePaymentProviderMatcherFacade sdhOnlinePaymentProviderMatcherFacade;


	@Resource(name = "sessionService")
	SessionService sessionService;

	@ModelAttribute("tipoDeImpuesto")
	public List<SelectAtomValue> getIdTipoDeImpuesto()
	{

		final List<SelectAtomValue> tipoDeImpuesto = Arrays.asList(
				new SelectAtomValue(ControllerPseConstants.DELINEACION, "Delineacion"),
				new SelectAtomValue(ControllerPseConstants.GASOLINA, "Gasolina"),
				new SelectAtomValue(ControllerPseConstants.ICA, "ICA"),
				new SelectAtomValue(ControllerPseConstants.RETEICA, "Retencion ICA"),
				new SelectAtomValue(ControllerPseConstants.PREDIAL, "Predial"),
				new SelectAtomValue(ControllerPseConstants.PUBLICIDAD, "Publicidad"),
				new SelectAtomValue(ControllerPseConstants.VEHICULAR, "Vehicular"),
				new SelectAtomValue(ControllerPseConstants.RETENCIONDU, "Retención De La Delineación"));
		return tipoDeImpuesto;
	}

	@ModelAttribute("anoGravable")
	public List<SelectAtomValue> getIdAnoGravable()
	{

		final List<SelectAtomValue> anoGravable = Arrays.asList(
				new SelectAtomValue("2020", "2020"),
				new SelectAtomValue("2019", "2019"),
				new SelectAtomValue("2018", "2018"),
				new SelectAtomValue("2017", "2017"),
				new SelectAtomValue("2016", "2016"),
				new SelectAtomValue("2015", "2015"),
				new SelectAtomValue("2014", "2014"),
				new SelectAtomValue("2013", "2013"),
				new SelectAtomValue("2012", "2012"),
				new SelectAtomValue("2011", "2011"));

		return anoGravable;
	}

	@ModelAttribute("periodo")
	public List<SelectAtomValue> getIdPeriodo()
	{
		//Periodos para gasolina
		final List<SelectAtomValue> periodo = new SobreTasaGasolinaService(configurationService)
				.prepararCatalogoPeriodoPSE(new ControllerPseConstants().getGASOLINA());

		return periodo;
	}

	@ModelAttribute("pagoAdicional")
	public List<SelectAtomValue> getIdPagoAdicional()
	{

		final List<SelectAtomValue> pagoAdicional = Arrays.asList(
				new SelectAtomValue(ControllerPseConstants.SI, "Si"),
				new SelectAtomValue(ControllerPseConstants.NO, "No"));

		return pagoAdicional;
	}

	/*@ModelAttribute("banco")
	public List<SelectAtomValue> getIdBanco()
	{
		final List<SelectAtomValue> banco = new ArrayList<SelectAtomValue>(); //
		for (final PseBankListCatalogModel bankEntry : pseBankListCatalogDao.getAllBankEntries().getResult())
		{
			banco.add(new SelectAtomValue(bankEntry.getFinancialInstitutionCode(), bankEntry.getFinancialInstitutionName()));
		}

		return banco;
	}*/

	@ModelAttribute("tipoDeTarjeta")
	public List<SelectAtomValue> getIdTipoDeTarjeta()
	{

		final List<SelectAtomValue> tipoDeTarjeta = Arrays.asList(
				new SelectAtomValue(ControllerPseConstants.CREDITO, "Credito"),
				new SelectAtomValue(ControllerPseConstants.DEBITO, "Debito"));

		return tipoDeTarjeta;
	}

	@ModelAttribute("tipoDeIdentificacion")
	public List<SelectAtomValue> getIdTipoDeIdentificacion()
	{

		final List<SelectAtomValue> tipoDeIdentificacion = Arrays.asList(
				new SelectAtomValue(ControllerPseConstants.CC, "Cedula De Ciudadania"),
				new SelectAtomValue(ControllerPseConstants.NIT, "NIT De La Empresa"),
				new SelectAtomValue(ControllerPseConstants.CE, "Cedula De Extranjeria"),
				new SelectAtomValue(ControllerPseConstants.TI, "Tarjeta De Identificacion"),
				new SelectAtomValue(ControllerPseConstants.PP, "Pasaporte"));

		return tipoDeIdentificacion;
	}

	@ModelAttribute("onlinePaymentProvider")
	public List<SelectAtomValue> getOnlinePaymentProvider()
	{

		final List<SelectAtomValue> onlinePaymentProvider = Arrays.asList(
				new SelectAtomValue(ControllerPseConstants.ACH_PSE, "ACH/PSE"),
				new SelectAtomValue(ControllerPseConstants.CREDIBANCO, "CREDIBANCO"));

		return onlinePaymentProvider;
	}

	@RequestMapping(value = "/pagoEnLinea", method = RequestMethod.GET)
	@RequireHardLogIn
	public String pagoEnLinea(final Model model, final RedirectAttributes redirectModel,
			@RequestParam(required = false, defaultValue = "", value = "debugMode") final String debugMode,
			@RequestParam(required = false, defaultValue = "", value = "tax") final String tax,
			@RequestParam(required = false, defaultValue = "", value = "paymentMethod") final String paymentMethod,
			@RequestParam(required = false, defaultValue = "", value = "bankCode") final String bankCode
		) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_EN_lINEA));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_EN_lINEA));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_PAGO_LINEA));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		model.addAttribute("psePaymentForm", new PSEPaymentForm());
		model.addAttribute("debugMode", debugMode);
		LOG.info("debugMode[" + debugMode + "]");

		return getViewForPage(model);
	}


	@RequestMapping(value = "/pagoEnLinea/pseResponse", method = RequestMethod.GET)
	@RequireHardLogIn
	public String pseResponse(final Model model, final RedirectAttributes redirectModel,
			@RequestParam(required = false, defaultValue = "", value = "ticketId")
			final String ticketId, @ModelAttribute("error")
			final String error, @ModelAttribute("psePaymentFormResp")
			final PSEPaymentForm psePaymentFormResp, @ModelAttribute("estatus")
			final String estatus)
			throws CMSItemNotFoundException
	{
		String flagSuccessView = null;
		String flagReintetarPago = null;

		if (error == "sinPdf")
		{
			GlobalMessages.addErrorMessage(model, "psePaymentForm.error.pdfVacio");
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_PSE_RESPUESTA));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		LOG.info("------ pseResponse -------");
		LOG.info("ticketId [" + ticketId + "]");


		final String codeResponse = pseTransactionsLogService.updateTransaction(ticketId);
		final PSEPaymentForm psePaymentForm = this.getPSEPaymentForm(ticketId);


		if (psePaymentForm != null)
		{
			model.addAttribute("psePaymentForm", psePaymentForm);
			final SdhTaxTypesEnum tax = sdhOnlinePaymentProviderMatcherFacade.getTaxByCode(psePaymentForm.getTipoDeImpuesto());
			model.addAttribute("paymentMethodList", sdhOnlinePaymentProviderMatcherFacade.getPaymentMethodList(tax));

			if (psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_SERVICENOTEXISTS)
					|| psePaymentForm.getReturnCode()
							.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_ENTITYNOTEXISTSORDISABLED)
					|| psePaymentForm.getReturnCode()
							.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_BANKNOTEXISTSORDISABLED)
					|| psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_SERVICENOTEXISTS)
					|| psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_INVALIDAMOUNT)
					|| psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_INVALIDSOLICITDATE)
					|| psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_NOTCONFIRMEDBYBANK)
					|| psePaymentForm.getReturnCode()
							.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_CANNOTGETCURRENTCYCLE)
					|| psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_ACCESSDENIED)
					|| psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_TIMEOUT)
					|| psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_DESCRIPTIONNOTFOUND)
					|| psePaymentForm.getReturnCode()
							.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_TRANSACTIONNOTALLOWED)) //Transaccion con error
			{
				GlobalMessages.addErrorMessage(model, "pse.message.error.no._FAIL_EXCEPTION");
				flagSuccessView = "E";
			}
			else if (psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_BANKUNREACHEABLE)) //Transaccion exitosa
			{
				GlobalMessages.addInfoMessage(model, "pse.message.error.no._FAIL_BANKUNREACHEABLE");
				flagSuccessView = "E";
			}
			else if (psePaymentForm.getReturnCode().equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_EXCEEDEDLIMIT)) //Transaccion exitosa
			{
				GlobalMessages.addInfoMessage(model, "pse.message.error.no._FAIL_EXCEEDEDLIMIT");
				flagSuccessView = "E";
			}
			else if (psePaymentForm.getTransactionState()
					.equals(GetTransactionInformationResponseTransactionStateCodeList.OK.getValue())) //Transaccion exitosa
			{
				GlobalMessages.addInfoMessage(model, "pse.message.info.success.transaction");
				flagSuccessView = "X";
			}
			else if (psePaymentForm.getTransactionState()
					.equals(GetTransactionInformationResponseTransactionStateCodeList.PENDING.getValue())) //Transaccion pendiente
			{
				GlobalMessages.addInfoMessage(model, "pse.message.info.success.PENDING");
				flagSuccessView = "X";
			}
			else if (psePaymentForm.getTransactionState()
					.equals(GetTransactionInformationResponseTransactionStateCodeList.NOT_AUTHORIZED.getValue())) //Transaccion no autorizada
			{
				GlobalMessages.addInfoMessage(model, "pse.message.info.success.NOT_AUTHORIZED");
				flagSuccessView = "X";
			}
			else if (psePaymentForm.getTransactionState()
					.equals(GetTransactionInformationResponseTransactionStateCodeList.FAILED.getValue())) //Transaccion fallida
			{
				GlobalMessages.addInfoMessage(model, "pse.message.info.success.FAILED");
				flagSuccessView = "X";
			}
			else
			{ //Transaccion con error
				GlobalMessages.addErrorMessage(model, "pse.message.error.no._FAIL_EXCEPTION");
				flagSuccessView = "E";
				//flagReintetarPago = "E";
			}
		}else {
			//model.addAttribute("psePaymentForm", this.getPSEPaymentForm(ticketId));
			final SdhTaxTypesEnum tax = sdhOnlinePaymentProviderMatcherFacade
					.getTaxByCode(this.getPSEPaymentForm(ticketId).getTipoDeImpuesto());
			model.addAttribute("paymentMethodList", sdhOnlinePaymentProviderMatcherFacade.getPaymentMethodList(tax));
			GlobalMessages.addErrorMessage(model, "pse.message.error.no._FAIL_EXCEPTION");
			flagReintetarPago = "X";
		}

		LOG.info("estatus: " + estatus);
		if (estatus == "impreso")
		{
			//			model.addAttribute("psePaymentForm", psePaymentFormResp);
			model.addAttribute("psePaymentForm", this.getPSEPaymentForm(ticketId));
			final SdhTaxTypesEnum tax = sdhOnlinePaymentProviderMatcherFacade
					.getTaxByCode(this.getPSEPaymentForm(ticketId).getTipoDeImpuesto());
			model.addAttribute("paymentMethodList", sdhOnlinePaymentProviderMatcherFacade.getPaymentMethodList(tax));
		}

		model.addAttribute("ControllerPseConstants", new ControllerPseConstants());
		model.addAttribute("disableFields", "true");
		model.addAttribute("flagSuccessView", flagSuccessView);
		model.addAttribute("flagReintetarPago", flagReintetarPago);

		final String bpRepresentado = sessionService.getCurrentSession().getAttribute("representado");
		if (bpRepresentado != null)
		{
			model.addAttribute("representado", "true");
		}
		else
		{
			model.addAttribute("representado", "false");
		}

		return getViewForPage(model);
	}

	@RequestMapping(value = "/pagoEnLinea/credibancoResponse", method = RequestMethod.GET)
	@RequireHardLogIn
	public String credibancoResponse(final Model model, final RedirectAttributes redirectModel,
			@RequestParam(required = false, defaultValue = "", value = "ticketId")
			final String ticketId, @ModelAttribute("error")
			final String error, @ModelAttribute("psePaymentFormResp")
			final PSEPaymentForm psePaymentFormResp, @ModelAttribute("estatus")
			final String estatus) throws CMSItemNotFoundException
	{
		LOG.info("Credibanco Ticke Id: " + ticketId);

		String flagSuccessView = null;

		storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_PSE_RESPUESTA));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		final String codeResponse = pseTransactionsLogService.updateCredibancoTransaction(ticketId);
		model.addAttribute("psePaymentForm", this.getPSEPaymentForm(ticketId));
		model.addAttribute("ControllerPseConstants", new ControllerPseConstants());
		model.addAttribute("disableFields", "true");

		if (Objects.nonNull(codeResponse))
		{
			LOG.info("------ codeResponse -------" + codeResponse);
			if (codeResponse.equals(ControllerPseConstants.CREDIBANCO_RESPONSE_APROBADA))
			{
				GlobalMessages.addInfoMessage(model, "credibanco.message.info.done.transaction.with.status");
				flagSuccessView = "X";
			}
			else
			{
				GlobalMessages.addErrorMessage(model, "credibanco.message.error.response.transaction");
				flagSuccessView = "X";
			}
		}
		else
		{
			GlobalMessages.addErrorMessage(model, "credibanco.message.error.response.transaction");
		}

		model.addAttribute("flagSuccessView", flagSuccessView);


		final String bpRepresentado = sessionService.getCurrentSession().getAttribute("representado");
		if (bpRepresentado != null)
		{
			model.addAttribute("representado", "true");
		}
		else
		{
			model.addAttribute("representado", "false");
		}

		return getViewForPage(model);
	}

	//	@RequestMapping(value = "/pagoEnLinea/pseResponse", method = RequestMethod.POST)
	public String pagoPdf(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("psePaymentForm")
	final PSEPaymentForm psePaymentForm) throws CMSItemNotFoundException
	{

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final ConsultaPagoRequest consultaPagoRequest = new ConsultaPagoRequest();
		ConsultaPagoDeclaraciones declaracion = new ConsultaPagoDeclaraciones();
		final ImprimePagoRequest imprimePagoRequest = new ImprimePagoRequest();
		final ControllerPseConstants controllerPseConstants = new ControllerPseConstants();
		final String ComodinPublicidad = "PU";

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			consultaPagoRequest.setNumBP(customerData.getNumBP());
			LOG.info("NumBP: " + customerData.getNumBP());
			LOG.info("getPUBLICIDAD: " + controllerPseConstants.getPUBLICIDAD());
			LOG.info("getTipoDeImpuesto: " + psePaymentForm.getTipoDeImpuesto().toUpperCase());
			LOG.info("getImpuesto: " + psePaymentForm.getImpuesto().toUpperCase());

			if (psePaymentForm.getTipoDeImpuesto().toUpperCase().equals(controllerPseConstants.getPUBLICIDAD()))
			{
				consultaPagoRequest.setNumObjeto(ComodinPublicidad);

				final ConsultaPagoResponse consultaPagoResponse = mapper
						.readValue(sdhConsultaPagoService.consultaPago(consultaPagoRequest), ConsultaPagoResponse.class);

				final List<ConsultaPagoDeclaraciones> declaracionesList = consultaPagoResponse.getDeclaraciones();
				if (declaracionesList != null)
				{
					for (final ConsultaPagoDeclaraciones element : declaracionesList)
					{

						LOG.info("		element.getReferencia: " + element.getReferencia());
						LOG.info("		psePaymentForm.getNumeroDeReferencia: " + psePaymentForm.getNumeroDeReferencia());

						if (element.getReferencia().equals(psePaymentForm.getNumeroDeReferencia())
								&& element.getClavePeriodo().equals(psePaymentForm.getPeriodo()))
						{
							declaracion = element;
							break;
						}
					}
				}
			}

			LOG.info("getGASOLINA: " + controllerPseConstants.getGASOLINA());
			LOG.info("getTipoDeImpuesto: " + psePaymentForm.getTipoDeImpuesto().toUpperCase());
			LOG.info("getImpuesto: " + psePaymentForm.getImpuesto().toUpperCase());

			if (psePaymentForm.getTipoDeImpuesto().toUpperCase().equals(controllerPseConstants.getGASOLINA()))
			{
				final List<SDHGasTaxData> GasTaxList = customerData.getGasTaxList();

				for (final SDHGasTaxData GasTax : GasTaxList)
				{

					LOG.info("	GasTax.getObjectNumber: " + GasTax.getObjectNumber());

					consultaPagoRequest.setNumObjeto(GasTax.getObjectNumber());

					final ConsultaPagoResponse consultaPagoResponse = mapper
							.readValue(sdhConsultaPagoService.consultaPago(consultaPagoRequest), ConsultaPagoResponse.class);

					final List<ConsultaPagoDeclaraciones> declaracionesList = consultaPagoResponse.getDeclaraciones();

					for (final ConsultaPagoDeclaraciones element : declaracionesList)
					{

						LOG.info("		element.getReferencia: " + element.getReferencia());
						LOG.info("		psePaymentForm.getNumeroDeReferencia: " + psePaymentForm.getNumeroDeReferencia());

						if (element.getReferencia().equals(psePaymentForm.getNumeroDeReferencia()))
						{
							declaracion = element;
							break;
						}
					}

					if (declaracion != null)
					{
						break;
					}
				}

			}

			if (!declaracion.getNumBP().equals("") || declaracion.getNumBP() != null)
			{
				imprimePagoRequest.setNumBP(declaracion.getNumBP());
				imprimePagoRequest.setCtaContrato(declaracion.getCtaContrato());
				imprimePagoRequest.setNumObjeto(declaracion.getNumObjeto());
				imprimePagoRequest.setClavePeriodo(declaracion.getClavePeriodo());
				imprimePagoRequest.setReferencia(declaracion.getReferencia());
				imprimePagoRequest.setFechaCompensa(declaracion.getFechaCompensa());
				imprimePagoRequest.setImporte(declaracion.getImporte());
				imprimePagoRequest.setMoneda(declaracion.getMoneda());
				imprimePagoRequest.setNumfactForm(declaracion.getNumfactForm());
				imprimePagoRequest.setNumDocPago(declaracion.getNumDocPago());
				imprimePagoRequest.setRefROP(VACIO);

				final String resp = sdhImprimePagoService.imprimePago(imprimePagoRequest);
				final ImprimePagoResponse imprimePagoResponse = mapper.readValue(resp, ImprimePagoResponse.class);

				redirectModel.addFlashAttribute("imprimePagoResponse", imprimePagoResponse);
				redirectModel.addFlashAttribute("psePaymentFormResp", psePaymentForm);
				redirectModel.addFlashAttribute("estatus", "impreso");

			}
		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from Pago en linea PSE response page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
			redirectModel.addFlashAttribute("error", "sinPdf");
			return "redirect:/impuestos/pagoEnLinea/pseResponse";

		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_PSE_RESPUESTA));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return "redirect:/impuestos/pagoEnLinea/pseResponse";

	}


	@RequestMapping(value = "/pagoEnLinea/pseResponse", method = RequestMethod.POST)
	public String imprimirpagoPdf(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("psePaymentForm")
	final PSEPaymentForm psePaymentForm) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En imprimir comprobante pago POST --------------------------");
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final ImprimePagoRequest imprimePagoRequest = new ImprimePagoRequest();
		ImprimePagoResponse imprimePagoResponse = null;

		final String numBP = customerData.getNumBP();
		final String cuentaContrato = "";
		final String numObjeto = "";
		final String clavePeriodo = "";
		final String referencia = psePaymentForm.getNumeroDeReferencia();
		final String fechaCompensa = "";
		final String importe = psePaymentForm.getValorAPagar();
		final String moneda = "";
		final String numfactForm = "";
		final String numDocPago = "";
		final String refROP = "";


		try
		{
			imprimePagoRequest.setNumBP(numBP);
			imprimePagoRequest.setCtaContrato(cuentaContrato);
			imprimePagoRequest.setNumObjeto(numObjeto);
			imprimePagoRequest.setClavePeriodo(clavePeriodo);
			imprimePagoRequest.setReferencia(referencia);
			imprimePagoRequest.setFechaCompensa(fechaCompensa);
			imprimePagoRequest.setImporte(importe);
			imprimePagoRequest.setMoneda(moneda);
			imprimePagoRequest.setNumfactForm(numfactForm);
			imprimePagoRequest.setNumDocPago(numDocPago);
			imprimePagoRequest.setRefROP(refROP);

			System.out.println("Request de docs/imprimePago: " + imprimePagoRequest);
			final String resp = sdhImprimePagoService.imprimePago(imprimePagoRequest);
			System.out.println("Response de docs/imprimePago: " + resp);

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			imprimePagoResponse = mapper.readValue(resp, ImprimePagoResponse.class);

		}
		catch (final Exception e)
		{
			LOG.error("error al leer in: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
			redirectModel.addFlashAttribute("error", "sinPdf");
			return "redirect:/impuestos/pagoEnLinea/pseResponse";

		}
		redirectModel.addFlashAttribute("imprimePagoResponse", imprimePagoResponse);
		redirectModel.addFlashAttribute("psePaymentFormResp", psePaymentForm);
		redirectModel.addFlashAttribute("estatus", "impreso");

		storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_PSE_RESPUESTA));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return "redirect:/impuestos/pagoEnLinea/pseResponse";

	}





	@RequestMapping(value = "/pagoEnLinea/form", method = RequestMethod.POST)
	@RequireHardLogIn
	public String pagoEnLineaForm(final Model model, final PSEPaymentForm psePaymentForm) throws CMSItemNotFoundException
	{
		final SdhTaxTypesEnum tax = sdhOnlinePaymentProviderMatcherFacade.getTaxByCode(psePaymentForm.getTipoDeImpuesto());
		storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_PSE_FORMA));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		model.addAttribute("psePaymentForm", psePaymentForm);
		model.addAttribute("ControllerPseConstants", new ControllerPseConstants());
		model.addAttribute("debugMode", psePaymentForm.getDebugMode());
		model.addAttribute("paymentMethodList", sdhOnlinePaymentProviderMatcherFacade.getPaymentMethodList(tax));

		return getViewForPage(model);
	}



	@RequestMapping(value = "/pagoEnLinea/realizarPago", method = RequestMethod.POST)
	@RequireHardLogIn
	public String realizarPago(final Model model, final PSEPaymentForm psePaymentForm, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		String flagSuccessView = null;

		storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_PAGO_PSE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_REALIZAR_PAGO));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		String redirecUrl = getViewForPage(model);

		final SdhOnlinePaymentProviderEnum provider = sdhOnlinePaymentProviderMatcherFacade.getOnlinePaymentProvider(psePaymentForm.getTipoDeImpuesto(), psePaymentForm.getTipoDeTarjeta(), psePaymentForm.getBanco());


		if (provider.equals(SdhOnlinePaymentProviderEnum.CREDIBANCO)) //Credibanco Payment
		{
			LOG.info("--------- Calling Credibanco/Bank Web Service ---------");
			final InititalizeTransactionResponse response = this.doCredibancoPayment(psePaymentForm);
			LOG.info(response);
			if (Objects.nonNull(response))
			{
				final String returnCode = response.getReturnCode();
				if(returnCode.equals("0")) { // Return Transaction code - 0(0k)
					redirecUrl = "redirect:" + response.getPaymentRoute();
					GlobalMessages.addInfoMessage(model, "credibanco.message.info.done.transaction.with.status");
				}
				else
				{
					GlobalMessages.addErrorMessage(model, "credibanco.message.error.no.connection");
				}
				this.saveCredibancoTransaction(response, psePaymentForm);
			}
			else
			{
				GlobalMessages.addErrorMessage(model, "credibanco.message.error.no.connection");
			}
			LOG.info(response);
		}
		else if (provider.equals(SdhOnlinePaymentProviderEnum.ACH)) // ACH Payment
		{
			LOG.info("--------- Calling PSE/Bank Web Service ---------");
			final CreateTransactionPaymentResponseInformationType response = this.doPsePayment(psePaymentForm);
			if (response != null)
			{
				final String returnCode = response.getReturnCode().getValue();
				if (returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._SUCCESS))
				{
					redirecUrl = "redirect:" + response.getBankurl();
					GlobalMessages.addInfoMessage(model, "pse.message.info.done.transaction.with.status");
				}
				else if (returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_EXCEEDEDLIMIT))
				{
					GlobalMessages.addErrorMessage(model, "pse.message.error.no._FAIL_EXCEEDEDLIMIT");
					flagSuccessView = "E";
					model.addAttribute("flagSuccessView", flagSuccessView);
				}
				else if (returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_BANKUNREACHEABLE))
				{
					GlobalMessages.addErrorMessage(model, "pse.message.error.no._FAIL_BANKUNREACHEABLE");
					flagSuccessView = "E";
					model.addAttribute("flagSuccessView", flagSuccessView);
				}
				else if (returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_SERVICENOTEXISTS)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_ENTITYNOTEXISTSORDISABLED)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_BANKNOTEXISTSORDISABLED)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_SERVICENOTEXISTS)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_INVALIDAMOUNT)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_INVALIDSOLICITDATE)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_NOTCONFIRMEDBYBANK)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_CANNOTGETCURRENTCYCLE)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_ACCESSDENIED)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_TIMEOUT)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_DESCRIPTIONNOTFOUND)
						|| returnCode.equals(CreateTransactionPaymentResponseReturnCodeList._FAIL_TRANSACTIONNOTALLOWED))
				{
					GlobalMessages.addErrorMessage(model, "pse.message.error.no._FAIL_EXCEPTION");
					flagSuccessView = "E";
					model.addAttribute("flagSuccessView", flagSuccessView);
				}
				else
				{
					GlobalMessages.addErrorMessage(model, "pse.message.error.no.connection");
				}
				this.savePseTransaction(this.getConstantConnectionData(psePaymentForm.getBanco(), psePaymentForm.getTipoDeImpuesto(),
						psePaymentForm.getNumeroDeReferencia()), response, psePaymentForm);
			}
			else
			{
				GlobalMessages.addErrorMessage(model, "pse.message.error.no.connection");

			}
			LOG.info(response);
		}

		model.addAttribute("psePaymentForm", psePaymentForm);
		model.addAttribute("ControllerPseConstants", new ControllerPseConstants());

		LOG.info(psePaymentForm.getTipoDeImpuesto());
		LOG.info(psePaymentForm.getBanco());
		LOG.info(psePaymentForm.getTipoDeTarjeta());
		LOG.info(provider);




		return redirecUrl;
	}


	private CreateTransactionPaymentResponseInformationType doPsePayment(final PSEPaymentForm psePaymentForm)
	{
		final CreateTransactionPaymentInformationType createTransactionPaymentInformationType = new CreateTransactionPaymentInformationType();

		LOG.info("----------- doPsePayment --------------");
		LOG.info(psePaymentForm);
		LOG.info("----------- doPsePayment --------------");


		LOG.info("-----------INI  getBankList  --------------");

		final GetBankListResponseInformationType[] bankList = pseServices.getBankList(this.getConstantConnectionDataListBank(),
				this.getMessageHeader());

		LOG.info("-----------FIN  getBankList  --------------");



		createTransactionPaymentInformationType.setPaymentDescription(psePaymentForm.getTipoDeIdentificacion().concat("-".concat(psePaymentForm.getNumeroDeReferencia())));
		createTransactionPaymentInformationType.setTicketId(new NonNegativeInteger(psePaymentForm.getNumeroDeReferencia()));
		createTransactionPaymentInformationType.setTransactionValue(this.getAmount("COP", psePaymentForm.getValorAPagar()));
		createTransactionPaymentInformationType.setVatValue(this.getAmount("COP", psePaymentForm.getValorAPagar()));


		final int i_ceros = 14 - (psePaymentForm.getTipoDeIdentificacion().length() + psePaymentForm.getNoIdentificacion().length());

		String s_ceros = new String();
		for (int i = 1; i <= i_ceros; i++)
		{
			s_ceros = s_ceros + "0";
		}

		final String s_reference2 = s_ceros + psePaymentForm.getTipoDeIdentificacion() + psePaymentForm.getNoIdentificacion();

		createTransactionPaymentInformationType.setReferenceNumber(
				this.getReferences(new NonNegativeInteger(psePaymentForm.getNumeroDeReferencia()).toString(), s_reference2,
						new NonNegativeInteger(psePaymentForm.getNumeroDeReferencia()).toString()));


		return pseServices
				.createTransactionPayment(
						this.getConstantConnectionData(
								psePaymentForm.getBanco(),
								psePaymentForm.getTipoDeImpuesto(),
								psePaymentForm.getNumeroDeReferencia()),
						this.getMessageHeader(),
						createTransactionPaymentInformationType);
	}

	private InititalizeTransactionResponse doCredibancoPayment(final PSEPaymentForm psePaymentForm)
	{


		LOG.info("----------- doCredibancoPayment --------------");
		LOG.info(psePaymentForm);
		LOG.info("----------- doCredibancoPayment --------------");


		final int i_ceros = 14
				- (psePaymentForm.getTipoDeIdentificacion().length() + psePaymentForm.getNoIdentificacion().length());

		String s_ceros = new String();
		for (int i = 1; i <= i_ceros; i++)
		{
			s_ceros = s_ceros + "0";
		}

		final String s_reference3 = s_ceros + psePaymentForm.getTipoDeIdentificacion() + psePaymentForm.getNoIdentificacion();


		final String concept = psePaymentForm.getBanco().substring(2, 4) + psePaymentForm.getTipoDeImpuesto().substring(2, 4);
		String description = new String();

		if (psePaymentForm.getTipoDeImpuesto().equals("5101"))
		{
			description = "Predial";
		}
		else if (psePaymentForm.getTipoDeImpuesto().equals("5102"))
		{
			description = "ICA";
		}
		else if (psePaymentForm.getTipoDeImpuesto().equals("5103"))
		{
			description = "Vehicular";
		}
		else if (psePaymentForm.getTipoDeImpuesto().equals("5106"))
		{
			description = "Delineacion";
		}
		else if (psePaymentForm.getTipoDeImpuesto().equals("5131"))
		{
			description = "Retencion ICA";
		}
		else if (psePaymentForm.getTipoDeImpuesto().equals("5132"))
		{
			description = "Retencion De Delineacion Urbana";
		}
		else if (psePaymentForm.getTipoDeImpuesto().equals("5154"))
		{
			description = "Publicidad";
		}
		else if (psePaymentForm.getTipoDeImpuesto().equals("0108"))
		{
			description = "Gasolina";
		}


		final InititalizeTransactionRequest inititalizeTransactionRequest = new InititalizeTransactionRequest(
				psePaymentForm.getNumeroDeReferencia(),
				concept,
				description,
				//psePaymentForm.getTipoDeIdentificacion() + "-" + psePaymentForm.getObjPago() + "-" + psePaymentForm.getTipoDeImpuesto() + "-" + psePaymentForm.getTipoDeIdentificacion(),
				CREDIBANCO_PERSON_TYPE_DOCUMENT_TYPE.get(psePaymentForm.getTipoDeIdentificacion()),
				configurationService.getConfiguration().getString("credibanco.response.url").concat("?ticketId=").concat(psePaymentForm.getNumeroDeReferencia()),
				psePaymentForm.getValorAPagar(),
				"0", //Tax
				psePaymentForm.getNumeroDeReferencia(), //NonRef#1
				psePaymentForm.getNumeroDeReferencia(), //NonRef#2
				s_reference3, //NonRef#3
				psePaymentForm.getBanco()); //bankCode

		return sdhCredibancoJwt.inititalizeTransaction(inititalizeTransactionRequest);
	}

	private MessageHeader getMessageHeader()
	{
		final MessageHeader messageHeader = new MessageHeader();
		messageHeader.setTo(configurationService.getConfiguration().getString("sdh.pse.messageHeader.to"));
		messageHeader.setFrom(configurationService.getConfiguration().getString("sdh.pse.messageHeader.from"));
		messageHeader
				.setRepresentingParty(configurationService.getConfiguration().getString("sdh.pse.messageHeader.representingParty"));
		return messageHeader;
	}

	private ConstantConnectionData getConstantConnectionData(final String bankCode, final String serviceCode,
			final String ticketId)
	{
		final ConstantConnectionData constantConnectionData = new ConstantConnectionData();
		constantConnectionData.setPseurl(configurationService.getConfiguration().getString("sdh.pse.pseURL"));
		constantConnectionData.setPpeCode(configurationService.getConfiguration().getString("sdh.pse.ppeCode"));
		constantConnectionData.setEntityUrl(configurationService.getConfiguration().getString("sdh.pse.entityUrl") + "?ticketId=" + ticketId);
		constantConnectionData.setBankCode(bankCode);
		constantConnectionData.setServiceCode(serviceCode);
		return constantConnectionData;
	}

	private ConstantConnectionData getConstantConnectionDataListBank()
	{
		final ConstantConnectionData constantConnectionData = new ConstantConnectionData();
		constantConnectionData.setPseurl(configurationService.getConfiguration().getString("sdh.pse.pseURL"));
		constantConnectionData.setPpeCode(configurationService.getConfiguration().getString("sdh.pse.ppeCode"));
		return constantConnectionData;
	}

	private AmountType getAmount(final String currencyIso, final String value)
	{
		final AmountType amount = new AmountType();
		amount.setCurrencyISOcode(currencyIso);
		amount.setValue(new BigDecimal(value));
		return amount;
	}

	private String[] getReferences(final String r1, final String r2, final String r3)
	{
		final String[] references = new String[3];
		references[0] = r1;
		references[1] = r2;
		references[2] = r3;
		return references;
	}

	private void savePseTransaction(final ConstantConnectionData constantConnectionData,
			final CreateTransactionPaymentResponseInformationType transactionPaymentResponse, final PSEPaymentForm psePaymentForm)
	{
		pseTransactionsLogService.newLogTransactionEntry(constantConnectionData, transactionPaymentResponse,
				psePaymentForm.getNumeroDeReferencia(), psePaymentForm.getTipoDeImpuesto(), psePaymentForm.getImpuesto(),
				psePaymentForm.getAnoGravable(), psePaymentForm.getCHIP(), psePaymentForm.getPeriodo(), psePaymentForm.getCUD(),
				psePaymentForm.getTipoDeIdentificacion(), psePaymentForm.getNoIdentificacion(), psePaymentForm.getDV(),
				psePaymentForm.getFechaLimiteDePago(), psePaymentForm.getPagoAdicional(), psePaymentForm.getBanco(),
				psePaymentForm.getValorAPagar(), configurationService.getConfiguration().getString("sdh.pse.isoCodeCurrency"),
				psePaymentForm.getTipoDeTarjeta(),psePaymentForm.getObjPago());
	}

	private void saveCredibancoTransaction(final InititalizeTransactionResponse transactionPaymentResponse,
			final PSEPaymentForm psePaymentForm)
	{
		pseTransactionsLogService.newCredibancoLogTransactionEntry(transactionPaymentResponse,
				psePaymentForm.getNumeroDeReferencia(), psePaymentForm.getTipoDeImpuesto(), psePaymentForm.getImpuesto(),
				psePaymentForm.getAnoGravable(), psePaymentForm.getCHIP(), psePaymentForm.getPeriodo(), psePaymentForm.getCUD(),
				psePaymentForm.getTipoDeIdentificacion(), psePaymentForm.getNoIdentificacion(), psePaymentForm.getDV(),
				psePaymentForm.getFechaLimiteDePago(), psePaymentForm.getPagoAdicional(), psePaymentForm.getBanco(),
				psePaymentForm.getValorAPagar(), configurationService.getConfiguration().getString("credibanco.sdh.isoCodeCurrency"),
				psePaymentForm.getTipoDeTarjeta(), psePaymentForm.getObjPago());
	}

	private PSEPaymentForm getPSEPaymentForm(final String ticketId)
	{
		final PSEPaymentForm form = new PSEPaymentForm();
		final PseTransactionsLogModel modelo = pseTransactionsLogDao.getTransaction(ticketId);
		String bankProcessDate = null;

		if (modelo != null)
		{
			form.setTipoDeImpuesto(modelo.getTipoDeImpuesto());
			form.setNumeroDeReferencia(modelo.getNumeroDeReferencia());
			form.setImpuesto(modelo.getImpuesto());
			form.setAnoGravable(modelo.getAnoGravable());
			form.setCHIP(modelo.getCHIP());
			form.setPeriodo(modelo.getPeriodo());
			form.setCUD(modelo.getCUD());
			form.setNoIdentificacion(modelo.getNoIdentificacion());
			form.setDV(modelo.getDV());
			form.setTipoDeIdentificacion(modelo.getTipoDeIdentificacion());
			form.setFechaLimiteDePago(modelo.getFechaLimiteDePago());
			form.setPagoAdicional(modelo.getPagoAdicional());
			form.setBanco(modelo.getBanco());
			if (!modelo.getBanco().isEmpty())
			{
				final PseBankListCatalogModel pseBankListCatalogModel = pseBankListCatalogDao
						.getBankByFinancialInstitutionCode(modelo.getBanco());
				form.setBanco(pseBankListCatalogModel.getFinancialInstitutionName());
			}
			if (!modelo.getTipoDeTarjeta().isEmpty())
			{
				final SDHPaymentMethodModel sdhPaymentMethodModel = sdhPaymentMethodDao
						.getBySDHPaymentMethodCode(modelo.getTipoDeTarjeta());
				form.setTipoDeTarjeta(sdhPaymentMethodModel.getName());
			}
			form.setValorAPagar(modelo.getValorAPagar());
			form.setBankDateResponse(modelo.getBankProcessDate());
			form.setTrazabilityCode(modelo.getTrazabilityCode());
			form.setReturnCode(modelo.getReturnCode());
			form.setTransactionState(modelo.getTransactionState());

			bankProcessDate = modelo.getBankProcessDate();

			if (bankProcessDate != null)
			{
				if (bankProcessDate.split(" ").length == 2)
				{
					form.setBankDateResponse(bankProcessDate.split(" ")[0]);
					form.setBankTimeResponse(bankProcessDate.split(" ")[1]);
				}
			}
			form.setTrazabilityCode(modelo.getTrazabilityCode());

		}

		return form;
	}

	@RequestMapping("/pagoEnLinea/form/isPending")
	@ResponseBody
	public String isPending(@RequestParam(value = "objPago", defaultValue = "")
	final String objPago)
	{

		String transactionState = null;
		transactionState = pseTransactionsLogDao.getTransactionState(objPago);

		LOG.info("Estatus del objetiopago " + objPago + " es " + transactionState);


		return transactionState;
	}

}

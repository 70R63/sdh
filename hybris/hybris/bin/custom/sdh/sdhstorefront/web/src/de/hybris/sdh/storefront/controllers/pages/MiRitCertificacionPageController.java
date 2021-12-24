/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;




import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.CertificaRITRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.EdoCuentaRequest;
import de.hybris.sdh.core.pojos.responses.CertificacionRITResponse;
import de.hybris.sdh.core.pojos.responses.EdoCuentaResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConfigCatalogos;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHEdoCuentaService;
import de.hybris.sdh.facades.questions.data.SDHExteriorPublicityTaxData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.EdoCuentaForm;
import de.hybris.sdh.storefront.forms.EdoCuentaFormGlobal;
import de.hybris.sdh.storefront.forms.MiRitCertificacionForm;
import de.hybris.sdh.storefront.forms.MiRitForm;
import de.hybris.sdh.storefront.forms.PredialForm;
import de.hybris.sdh.storefront.forms.PublicidadForm;
import de.hybris.sdh.storefront.forms.VehiculosInfObjetoForm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MiRitCertificacionPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String BREADCRUMBS_VALUE = "breadcrumb.certificacion";
	private static final String BREADCRUMBS_VALUE_RETE = "breadcrumb.certificacionRETE";
	private static final String BREADCRUMBS_VALUE_REPO = "breadcrumb.certificacionREPO";


	private static final String VACIO = "";

	//CMS PAGES
	private static final String MI_RIT_CERTIFICACION_CMS_PAGE = "miRITCertificacionPage";
	private static final String MI_RIT_CERTIFICACION_DATOS_CMS_PAGE = "certificacion-datos";

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhEdoCuentaService")
	SDHEdoCuentaService sdhEdoCuentaService;

	@Resource(name = "sdhCustomerAccountService")
	SDHCustomerAccountService sdhCustomerAccountService;
	
	@Resource(name = "sdhConfigCatalogos")
	SDHConfigCatalogos sdhConfigCatalogos;


	@RequestMapping(value =
	{ "/contribuyentes/mirit/certificacion-datos", "/agenteRetenedor/mirit/certificacion-datos" }, method = RequestMethod.POST)
	public String showView(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("miRitCertificacionForm")
	final MiRitCertificacionForm miRitCertificacionFormDatos) throws CMSItemNotFoundException
	{

		String returnURL = "/";
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CertificaRITRequest certificaRITRequest = new CertificaRITRequest();

		if (customerModel.getNumBP() != null)
		{
			certificaRITRequest.setNumBP(customerModel.getNumBP());
		}
		else
		{
			certificaRITRequest.setNumBP(VACIO);
		}


		if (miRitCertificacionFormDatos.getTipoCert() != null)
		{
			certificaRITRequest.setTipoCert(miRitCertificacionFormDatos.getTipoCert());
		}
		else
		{
			certificaRITRequest.setTipoCert(VACIO);
		}

		if (miRitCertificacionFormDatos.getTipoImp() != null)
		{
			certificaRITRequest.setTipoImp(miRitCertificacionFormDatos.getTipoImp());
		}
		else
		{
			certificaRITRequest.setTipoImp(VACIO);
		}

		if (miRitCertificacionFormDatos.getNumObjeto() != null)
		{
			certificaRITRequest.setNumObjeto(miRitCertificacionFormDatos.getNumObjeto());
		}
		else
		{
			certificaRITRequest.setNumObjeto(VACIO);
		}


		try
		{
			final MiRitCertificacionForm miRitCertificacionFormResp = new MiRitCertificacionForm();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final CertificacionRITResponse certificaRITResponse = mapper.readValue(
					sdhCertificaRITService.consultaCertificacionRIT(certificaRITRequest),
					CertificacionRITResponse.class);


			miRitCertificacionFormResp.setIdmsj(certificaRITResponse.getIdmsj());
			miRitCertificacionFormResp.setTxtmsj(certificaRITResponse.getTxtmsj());
			if (certificaRITResponse.getRit() != null)
			{
				miRitCertificacionFormResp.setRit(certificaRITResponse.getRit());
				//model.addAttribute("miRitCertificacionFormResp", miRitCertificacionFormResp);
				redirectModel.addFlashAttribute("miRitCertificacionFormResp", miRitCertificacionFormResp);
			}
			else
			{
				redirectModel.addFlashAttribute("error", "sinPdf");
				return "redirect:/contribuyentes/mirit/certificacion-datos";
			}
		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			return "redirect:/contribuyentes/mirit/certificacion-datos";

		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE));

		returnURL = getViewForPage(model);

		return "redirect:/contribuyentes/mirit/certificacion-datos";
	}





	@RequestMapping(value =
	{ "/contribuyentes/mirit/certificacion-datos", "/agenteRetenedor/mirit/certificacion-datos" })
	public String showCertificacionDatos(final Model model, final HttpServletRequest request, @ModelAttribute("error")
	final String error, @ModelAttribute("miRitCertificacionFormResp")
	final MiRitCertificacionForm miRitCertificacionFormResp)
			throws CMSItemNotFoundException
	{
		String returnURL = "/";

		String referrer = request.getHeader("referer");
		if (referrer == null)
		{
			referrer = request.getServletPath();
		}

		final MiRitCertificacionForm miRitCertificacionForm = new MiRitCertificacionForm();
		//		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		//		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		//		final CertificaRITRequest certificaRITRequest = new CertificaRITRequest();


		if (error == "sinPdf")
		{
			GlobalMessages.addErrorMessage(model, "mirit.certificacion..error.pdfVacio");
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MI_RIT_CERTIFICACION_DATOS_CMS_PAGE));
		model.addAttribute("miRitCertificacionForm", miRitCertificacionForm);
		model.addAttribute("miRitCertificacionFormResp", miRitCertificacionFormResp);

		if (referrer.contains("contribuyentes"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE));
		}
		else if (referrer.contains("retenedor") || referrer.contains("agenteRetenedor"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_RETE));
		}
		else
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_REPO));
		}




		//		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		//		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos());
		//		model.addAttribute("dataForm", dataForm);
		//
		//		final EdoCuentaForm ctaForm = new EdoCuentaForm();
		//		final CustomerData customerData = customerFacade.getCurrentCustomer();
		//		final EdoCuentaRequest edoCuentaRequest = new EdoCuentaRequest();
		//
		//		ctaForm.setCompleName(customerData.getCompleteName());
		//		ctaForm.setTipoDoc(customerData.getDocumentType());
		//		ctaForm.setNumBP(customerModel.getNumBP());
		//		ctaForm.setNumDoc(customerData.getDocumentNumber());
		//
		//		try
		//		{
		//			edoCuentaRequest.setBp(customerModel.getNumBP());
		//
		//			final ObjectMapper mapper = new ObjectMapper();
		//			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//
		//			final EdoCuentaResponse edoCuentaResponse = mapper.readValue(sdhEdoCuentaService.detalleEdoCta(edoCuentaRequest),
		//					EdoCuentaResponse.class);
		//
		//
		//			ctaForm.setCompleName(customerData.getCompleteName());
		//			ctaForm.setTipoDoc(customerData.getDocumentType());
		//			ctaForm.setNumBP(customerModel.getNumBP());
		//			ctaForm.setTasaInteres(edoCuentaResponse.getTasaInteres());
		//			ctaForm.setPredialSaldoCargo(edoCuentaResponse.getNewPredialSaldoCargo());
		//			ctaForm.setPredialSaldoFavor(edoCuentaResponse.getNewPredialSaldoFavor());
		//			ctaForm.setiCASaldoCargo(edoCuentaResponse.getNewICASaldoCargo());
		//			ctaForm.setiCASaldoFavor(edoCuentaResponse.getNewICASaldoFavor());
		//			ctaForm.setVehicularSaldoCargo(edoCuentaResponse.getNewVehicularSaldoCargo());
		//			ctaForm.setVehicularSaldoFavor(edoCuentaResponse.getNewVehicularSaldoFavor());
		//			ctaForm.setDelineacionSaldoCargo(edoCuentaResponse.getNewDelineacionSaldoCargo());
		//			ctaForm.setDelineacionSaldoFavor(edoCuentaResponse.getNewDelineacionSaldoFavor());
		//			ctaForm.setGasolinaSaldoCargo(edoCuentaResponse.getNewGasolinaSaldoCargo());
		//			ctaForm.setGasolinaSaldoFavor(edoCuentaResponse.getNewGasolinaSaldoFavor());
		//			ctaForm.setPublicidadSaldoCargo(edoCuentaResponse.getNewPublicidadSaldoCargo());
		//			ctaForm.setPublicidadSaldoFavor(edoCuentaResponse.getNewPublicidadSaldoFavor());
		//			if (edoCuentaResponse.getPredial() != null && !edoCuentaResponse.getPredial().isEmpty())
		//			{
		//				//				ctaForm.setPredial(edoCuentaResponse.getPredial().stream()
		//				//						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNewCHIP())).collect(Collectors.toList()));
		//				ctaForm.setPredial(edoCuentaResponse.getPredial());
		//			}
		//
		//			//ctaForm.setPredial(edoCuentaResponse.getPredial());
		//			ctaForm.setTablaICA(edoCuentaResponse.getTablaICA());
		//
		//			if (edoCuentaResponse.getTablaVehicular() != null && !edoCuentaResponse.getTablaVehicular().isEmpty())
		//			{
		//				ctaForm.setTablaVehicular(edoCuentaResponse.getTablaVehicular().stream()
		//						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getPlaca())).collect(Collectors.toList()));
		//			}
		//			//ctaForm.setTablaVehicular(edoCuentaResponse.getTablaVehicular());
		//			if (edoCuentaResponse.getTablaDelineacion() != null && !edoCuentaResponse.getTablaDelineacion().isEmpty())
		//			{
		//				ctaForm.setTablaDelineacion(edoCuentaResponse.getTablaDelineacion().stream()
		//						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNewCDU())).collect(Collectors.toList()));
		//			}
		//			//ctaForm.setTablaDelineacion(edoCuentaResponse.getTablaDelineacion());
		//			ctaForm.setTablaGasolina(edoCuentaResponse.getTablaGasolina());
		//			ctaForm.setTablaPublicidad(edoCuentaResponse.getTablaPublicidad());
		//
		//			final Date date = new Date();
		//
		//			//Caso 2: obtener la fecha y salida por pantalla con formato:
		//			final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//			System.out.println("Fecha: " + dateFormat.format(date));
		//
		//			ctaForm.setFechageneracion(dateFormat.format(date));
		//
		//		}
		//		catch (final Exception e)
		//		{
		//			LOG.error("there was an error while parsing redsocial JSON");
		//			LOG.error("Error en el servicio: " + e.getMessage());
		//		}

		//		//		Consumo de pedial
		//		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;
		//		final PredialForm predialFormIni = new PredialForm();
		//		final VehiculosInfObjetoForm vehiculosForm = new VehiculosInfObjetoForm();
		//		final InfoDelineacion infoDelineacion = new InfoDelineacion();
		//		final MiRitForm miRitForm = new MiRitForm();
		//		final PublicidadForm publicidadForm = new PublicidadForm();
		//
		//		//		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		//		consultaContribuyenteBPRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());
		//
		//		final ObjectMapper mapper = new ObjectMapper();
		//		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//
		//		try
		//		{
		//			sdhConsultaContribuyenteBPResponse = mapper.readValue(
		//					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
		//					SDHValidaMailRolResponse.class);
		//			predialFormIni.setPredial(sdhConsultaContribuyenteBPResponse.getPredial());
		//
		//
		//			if (sdhConsultaContribuyenteBPResponse.getVehicular() != null
		//					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getVehicular()))
		//			{
		//				vehiculosForm.setImpvehicular(sdhConsultaContribuyenteBPResponse.getVehicular().stream()
		//						.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
		//			}
		//
		//			if (sdhConsultaContribuyenteBPResponse.getDelineacion() != null
		//					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getDelineacion()))
		//			{
		//				miRitForm.setDelineacion(sdhConsultaContribuyenteBPResponse.getDelineacion().stream()
		//						.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));
		//			}
		//
		//			if (sdhConsultaContribuyenteBPResponse.getGasolina() != null
		//					&& !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
		//			{
		//				miRitForm.setGasolina(sdhConsultaContribuyenteBPResponse.getGasolina().stream()
		//						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumDoc())).collect(Collectors.toList()));
		//			}
		//
		//
		//
		//			if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
		//			{
		//				final List<SDHExteriorPublicityTaxData> exteriorPublicityList = customerData.getExteriorPublicityTaxList();
		//
		//				final List<ImpuestoPublicidadExterior> listImpuestoPublicdadExterior = new ArrayList<ImpuestoPublicidadExterior>();
		//
		//				for (final SDHExteriorPublicityTaxData eachPublicityTax : exteriorPublicityList)
		//				{
		//					final ImpuestoPublicidadExterior eachImpuestoPE = new ImpuestoPublicidadExterior();
		//
		//					eachImpuestoPE.setNumObjeto(eachPublicityTax.getObjectNumber());
		//					eachImpuestoPE.setNumResolu(eachPublicityTax.getResolutionNumber());
		//					eachImpuestoPE.setTipoValla(eachPublicityTax.getFenceType());
		//					eachImpuestoPE.setAnoGravable(eachPublicityTax.getAnoGravable());
		//					if ("VALLA VEHICULOS".equalsIgnoreCase(eachPublicityTax.getFenceType())
		//							|| "VALLA VEHíCULOS".equalsIgnoreCase(eachPublicityTax.getFenceType()))
		//					{
		//						eachImpuestoPE.setTipoVallaCode("02");
		//					}
		//					else if ("Valla Tubular de Obra".equalsIgnoreCase(eachPublicityTax.getFenceType()))
		//					{
		//						eachImpuestoPE.setTipoVallaCode("03");
		//					}
		//					else if ("Valla de Obra Convencional".equalsIgnoreCase(eachPublicityTax.getFenceType()))
		//					{
		//						eachImpuestoPE.setTipoVallaCode("04");
		//					}
		//					else if ("Valla Tubular Comercial".equalsIgnoreCase(eachPublicityTax.getFenceType()))
		//					{
		//						eachImpuestoPE.setTipoVallaCode("01");
		//					}
		//					else if ("Pantalla LED".equalsIgnoreCase(eachPublicityTax.getFenceType()))
		//					{
		//						eachImpuestoPE.setTipoVallaCode("05");
		//					}
		//					listImpuestoPublicdadExterior.add(eachImpuestoPE);
		//				}
		//
		//				publicidadForm.setPublicidadExt(listImpuestoPublicdadExterior);
		//
		//			}
		//
		//			if (sdhConsultaContribuyenteBPResponse.getIca() != null
		//					&& StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getIca().getNumObjeto()))
		//			{
		//				miRitForm.setImpuestoICA(sdhConsultaContribuyenteBPResponse.getIca());
		//			}
		//
		//		}
		//		catch (final IOException e)
		//		{
		//			e.printStackTrace();
		//		}



		//		model.addAttribute("dataForm", miRitForm);
		//		model.addAttribute("vehiculosForm", vehiculosForm);
		//		model.addAttribute("predial", predialFormIni);
		//		model.addAttribute("ctaForm", ctaForm);
		//		model.addAttribute("publicidadForm", publicidadForm);





		returnURL = getViewForPage(model);

		return returnURL;
	}

	@RequestMapping(value = "/contribuyentes/mirit/consultaEstadoCuenta", method = RequestMethod.GET)
	@ResponseBody
	public EdoCuentaFormGlobal consultaEstadoCuenta(final HttpServletRequest request)
	{
		final EdoCuentaFormGlobal edoCuentaGlobal = new EdoCuentaFormGlobal();
		final String referrer = request.getHeader("referer");


		final MiRitCertificacionForm miRitCertificacionForm = new MiRitCertificacionForm();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CertificaRITRequest certificaRITRequest = new CertificaRITRequest();



		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos(sdhConfigCatalogos));

		final EdoCuentaForm ctaForm = new EdoCuentaForm();
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
			if (edoCuentaResponse.getPredial() != null && !edoCuentaResponse.getPredial().isEmpty())
			{
								ctaForm.setPredial(edoCuentaResponse.getPredial().stream()
										.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNewCHIP())).collect(Collectors.toList()));
				ctaForm.setPredial(edoCuentaResponse.getPredial());
			}

			ctaForm.setPredial(edoCuentaResponse.getPredial());
			ctaForm.setTablaICA(edoCuentaResponse.getTablaICA());

			if (edoCuentaResponse.getTablaVehicular() != null && !edoCuentaResponse.getTablaVehicular().isEmpty())
			{
				ctaForm.setTablaVehicular(edoCuentaResponse.getTablaVehicular().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getPlaca())).collect(Collectors.toList()));
			}
			ctaForm.setTablaVehicular(edoCuentaResponse.getTablaVehicular());
			if (edoCuentaResponse.getTablaDelineacion() != null && !edoCuentaResponse.getTablaDelineacion().isEmpty())
			{
				ctaForm.setTablaDelineacion(edoCuentaResponse.getTablaDelineacion().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNewCDU())).collect(Collectors.toList()));
			}
			ctaForm.setTablaDelineacion(edoCuentaResponse.getTablaDelineacion());
			ctaForm.setTablaGasolina(edoCuentaResponse.getTablaGasolina());
			ctaForm.setTablaPublicidad(edoCuentaResponse.getTablaPublicidad());

			final Date date = new Date();

			//			Caso 2: obtener la fecha y salida por pantalla con formato:
			final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Fecha: " + dateFormat.format(date));

			ctaForm.setFechageneracion(dateFormat.format(date));

		}
		catch (final Exception e)
		{
			LOG.error("there was an error while parsing redsocial JSON");
			LOG.error("Error en el servicio: " + e.getMessage());
		}

//				Consumo de pedial
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;
		SDHValidaMailRolResponse contImpuestos = null;
		sdhConsultaContribuyenteBPResponse = sdhCustomerAccountService.getBPDataFromCustomer(customerModel);


		final Set<PrincipalGroupModel> groupList = customerModel.getGroups();

		for (final PrincipalGroupModel group : groupList)
		{
			final String groupUid = group.getUid();

			if (groupUid.contains("predialUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "01");
				sdhConsultaContribuyenteBPResponse.setPredial(contImpuestos.getPredial());
			}

			if (groupUid.contains("vehicularUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "02");
				sdhConsultaContribuyenteBPResponse.setVehicular(contImpuestos.getVehicular());
			}

			if (groupUid.contains("ICAUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "03");
				sdhConsultaContribuyenteBPResponse.setIca(contImpuestos.getIca());
			}

			if (groupUid.contains("gasolinaUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "05");
				sdhConsultaContribuyenteBPResponse.setGasolina(contImpuestos.getGasolina());
			}

			if (groupUid.contains("delineacionUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "06");
				sdhConsultaContribuyenteBPResponse.setDelineacion(contImpuestos.getDelineacion());
			}

			if (groupUid.contains("publicidadExtUsrTaxGrp"))
			{
				contImpuestos = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "07");
				sdhConsultaContribuyenteBPResponse.setPublicidadExt(contImpuestos.getPublicidadExt());
			}

		}



		final PredialForm predialFormIni = new PredialForm();
		final VehiculosInfObjetoForm vehiculosForm = new VehiculosInfObjetoForm();
		final InfoDelineacion infoDelineacion = new InfoDelineacion();
		final MiRitForm miRitForm = new MiRitForm();
		final PublicidadForm publicidadForm = new PublicidadForm();

		consultaContribuyenteBPRequest.setNumBP(customerFacade.getCurrentCustomer().getNumBP());

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		//sdhConsultaContribuyenteBPResponse = mapper.readValue(
		//		sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
		//		SDHValidaMailRolResponse.class);
		predialFormIni.setPredial(sdhConsultaContribuyenteBPResponse.getPredial());


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

		if (sdhConsultaContribuyenteBPResponse.getGasolina() != null && !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
		{
			miRitForm.setGasolina(sdhConsultaContribuyenteBPResponse.getGasolina().stream()
					.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumDoc())).collect(Collectors.toList()));
		}


		SDHExteriorPublicityTaxData cutomerPublicidadRow = null;
		final List<SDHExteriorPublicityTaxData> cutomerPublicidadList = new ArrayList<SDHExteriorPublicityTaxData>();
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


		edoCuentaGlobal.setCtaForm(ctaForm);
		edoCuentaGlobal.setDataForm(miRitForm);
		edoCuentaGlobal.setVehiculosForm(vehiculosForm);
		edoCuentaGlobal.setPredial(predialFormIni);
		edoCuentaGlobal.setPublicidadForm(publicidadForm);

		return edoCuentaGlobal;
	}





	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

}

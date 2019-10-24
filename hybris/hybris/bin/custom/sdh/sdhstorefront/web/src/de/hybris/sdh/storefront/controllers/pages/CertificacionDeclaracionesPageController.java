/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.requests.ImprimeCertDeclaraRequest;
import de.hybris.sdh.core.pojos.requests.OpcionCertiDecImprimeRequest;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesVista;
import de.hybris.sdh.core.pojos.responses.ErrorEnWSDeclaracionesPDF;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.ImprimePagoResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbanaWithRadicados;
import de.hybris.sdh.core.pojos.responses.OpcionCertiDecImprimeResponse;
import de.hybris.sdh.core.pojos.responses.OpcionDeclaracionesPDFResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHICAInfObjetoService;
import de.hybris.sdh.core.services.SDHImprimeCertDeclaraService;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.questions.data.SDHUrbanDelineationsTaxData;
import de.hybris.sdh.storefront.controllers.ControllerConstants;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;
import de.hybris.sdh.storefront.forms.CertificacionPagoForm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller
@SessionAttributes(
{ "dataForm" })

public class CertificacionDeclaracionesPageController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_CERTIFICA_DECLARACION = "Certificaciones de Declaración";
	private static final String VACIO = "";

	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	// CMS Pages
	private static final String CERTIFICACION_DECLARACIONES_CMS_PAGE = "certiDeclaracionesPage";

	private static final String REDIRECT_TO_CERTIFICACION_DECLARACIONES_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/consultas/certideclaraciones";

	private static final String REDIRECT_TO_MI_BUZON_PAGE = REDIRECT_PREFIX + "/contribuyentes/consultas/certipagos";

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhConsultaPagoService")
	SDHConsultaPagoService sdhConsultaPagoService;

	@Resource(name = "sdhImprimeCertDeclaraService")
	SDHImprimeCertDeclaraService sdhImprimeCertDeclaraService;

	@Resource(name = "sdhValidaContribuyenteService")
	private SDHValidaContribuyenteService sdhValidaContribuyenteService;

	@Resource(name = "sdhICAInfObjetoService")
	SDHICAInfObjetoService sdhICAInfObjetoService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;


	@ModelAttribute("anoGravableGasolina")
	public List<SelectAtomValue> getIdAnoGravableGasolina()
	{
		return ControllerConstants.AnioGravable.anoGravableGasolina;
	}

	@ModelAttribute("anoGravablePublicidad")
	public List<SelectAtomValue> getIdAnoGravablePublicidad()
	{
		return ControllerConstants.AnioGravable.anoGravablePublicidad;
	}

	@ModelAttribute("tipoDeImpuesto")
	public List<SelectAtomValue> getTtipoDeImpuesto()
	{
		return ControllerConstants.AnioGravable.tipoDeImpuesto;
	}


	//	@RequestMapping(value = "/contribuyentes/consultas/certideclaraciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String oblipendi(final Model model, @ModelAttribute("error")
	final String error) throws CMSItemNotFoundException
	{
		LOG.debug("----------------  GET Obligaciones Pendientes--------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final CertificacionPagoForm certiFormPost = new CertificacionPagoForm();
		model.addAttribute("certiFormPost", certiFormPost);


		if (error == "sinPdf")
		{
			GlobalMessages.addErrorMessage(model, "mirit.certificacion..error.pdfVacio");
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_CERTIFICA_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		certiFormPost.setNumBP(customerData.getNumBP());
		model.addAttribute("certiForm", certiFormPost);

		return getViewForPage(model);
	}

	@RequestMapping(value =
	{ "/contribuyentes/consultas/certideclaraciones",
			"/agenteRetenedor/consultas/certideclaraciones" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String certideclaracionesGET(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Agentes Declaraciones --------------------------");


		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final OpcionDeclaracionesVista infoVista = new OpcionDeclaracionesVista();
		SDHValidaMailRolResponse customerData = null;


		customerData = sdhCustomerFacade.getRepresentadoFromSAP(customerModel.getNumBP());
		infoVista.setCatalogos(gasolinaService.prepararCatalogosOpcionDeclaraciones(customerData));
		infoVista.setCustomerData(customerData);

		model.addAttribute("dataForm", infoVista);

		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_CERTIFICA_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);



		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/consultas/certideclaraciones/declaracionImprimir", method = RequestMethod.GET)
	@ResponseBody
	public OpcionDeclaracionesVista imprimeCertificadoGET(@ModelAttribute("dataForm")
	final OpcionDeclaracionesVista infoVista, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET declaracion Imprimir------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final OpcionCertiDecImprimeRequest decImprimeRequest = new OpcionCertiDecImprimeRequest();
		OpcionCertiDecImprimeResponse decImprimeResponse = null;
		//		SDHValidaMailRolResponse customerData = null;
		final OpcionDeclaracionesPDFResponse declaraPDFResponse = new OpcionDeclaracionesPDFResponse();
		final ErrorEnWSDeclaracionesPDF errorEnWSDeclaracionesPDF = new ErrorEnWSDeclaracionesPDF();

		String bp = "";
		String numObjeto = "";
		String claseObjeto = "";
		String anioGravable = "";
		String periodo = "";
		String referencia = "";


		bp = customerModel.getNumBP();
		if (infoVista.getCustomerData() == null)
		{
			infoVista.setCustomerData(sdhCustomerFacade.getRepresentadoFromSAP(bp));
		}

		claseObjeto = infoVista.getClaveImpuesto();
		numObjeto = infoVista.getObjContrato(); //gasolinaService.obtenerNumDocDeclaraciones(customerData2, claseObjeto);
		anioGravable = infoVista.getAnoGravable();
		periodo = infoVista.getPeriodo();
		referencia = infoVista.getReferencia();

		infoVista.setUrlDownload(null);
		//		infoVista.setDeclaraPDFResponse(null);

		decImprimeRequest.setNumBP(bp);
		decImprimeRequest.setNumObjeto(numObjeto);
		decImprimeRequest.setRetencion(referencia);
		decImprimeRequest.setAnoGravable(anioGravable);
		decImprimeRequest.setPeriodo(periodo);

		System.out.println("Request para docs/imprimeCertif: " + decImprimeRequest);
		decImprimeResponse = gasolinaService.certiDecImprimir(decImprimeRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de docs/imprimeCertif: " + decImprimeResponse);
		if (gasolinaService.ocurrioErrorDecImprime(decImprimeResponse) != true)
		{

			//			infoVista.setDeclaraPDFResponse(declaraPDFResponse);
			byte[] decodedBytes;
			try
			{
				decodedBytes = new BASE64Decoder().decodeBuffer(decImprimeResponse.getPdf());
				final String fileName = "declaracion" + "-" + claseObjeto + "-" + bp + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE.booleanValue());
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				infoVista.setUrlDownload(mediaModel.getDownloadURL());

				if (decImprimeResponse.getErrores() != null)
				{
					errorEnWSDeclaracionesPDF.setIdMensaje(decImprimeResponse.getErrores().getIdmsj());
					errorEnWSDeclaracionesPDF.setTextoMensaje(decImprimeResponse.getErrores().getTxtmsj());
					declaraPDFResponse.setErrores(errorEnWSDeclaracionesPDF);
				}


				infoVista.setDeclaraPDFResponse(declaraPDFResponse);


				redirectAttributes.addFlashAttribute("infoResponse", infoVista);


			}
			catch (final Exception e)
			{
				LOG.error("error imprimeCertificadoGET: " + e.getMessage());
			}
		}
		else
		{
			//				declaraPDFResponse.setErrores(("Ocurrio un error. No se genero el PDF");
		}

		//		infoVista.setResponse(declaraPDFResponse);



		return infoVista;
	}



	@RequestMapping(value = "/contribuyentes/consultas/certideclaraciones", method = RequestMethod.POST)
	public String certipdf(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataFormResponse,
			final Model model, final RedirectAttributes redirectModel, @ModelAttribute("certiFormPost")
			final CertificacionPagoForm certiFormPost) throws CMSItemNotFoundException
	{
		LOG.debug("---------------- POST certificacion de pagos--------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final ImprimeCertDeclaraRequest imprimeCertDeclaraRequest = new ImprimeCertDeclaraRequest();

		if (certiFormPost.getIdimp().equals("4")) //Publicidad
		{
			if (certiFormPost.getRowFrompublicidadTable() != null)
			{
				if (certiFormPost.getRowFrompublicidadTable().equals("X"))
				{
					final ImprimeCertDeclaraRequest imprimeCertDeclaraPublicidadRequest = new ImprimeCertDeclaraRequest();
					final ObjectMapper mapperPublicidad = new ObjectMapper();

					imprimeCertDeclaraPublicidadRequest.setNumBP(certiFormPost.getNumBP());
					imprimeCertDeclaraPublicidadRequest.setNumObjeto(certiFormPost.getNumObjeto());
					imprimeCertDeclaraPublicidadRequest.setRetencion(VACIO);
					imprimeCertDeclaraPublicidadRequest.setPeriodo(certiFormPost.getAniograv());
					imprimeCertDeclaraPublicidadRequest
							.setAnoGravable(getAnioGravableFromPublicidadPeriodo(certiFormPost.getAniograv()));

					final String respPublicidad = sdhImprimeCertDeclaraService.imprimePago(imprimeCertDeclaraPublicidadRequest);
					ImprimePagoResponse imprimeCertiDeclaraPublicidadResponse;
					try
					{
						imprimeCertiDeclaraPublicidadResponse = mapperPublicidad.readValue(respPublicidad, ImprimePagoResponse.class);
						redirectModel.addFlashAttribute("imprimeCertiDeclaraResponse", imprimeCertiDeclaraPublicidadResponse);
					}
					catch (final IOException e)
					{
						LOG.error(e.getMessage());
						e.printStackTrace();
					}

				}
				final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
				certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
				certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
				certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
				redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);
				redirectModel.addFlashAttribute("publicidadMode", true);
				try
				{
					redirectModel.addFlashAttribute("consultaPagoList",
							sdhConsultaPagoService.consultaPago(certiFormPost.getNumBP(), "PU", certiFormPost.getAniograv()));
				}
				catch (final Exception e)
				{
					LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
				}

				System.out.println(certiFormPost.getAniograv());
				System.out.println(certiFormPost.getNumBP());
				System.out.println(certiFormPost.getIdimp());
				System.out.println(certiFormPost.getTipoImp());
			}
		}
		else if (certiFormPost.getIdimp().equals("5"))//Gasolina
		{
			final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
			certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
			certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
			certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
			redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);

			if (!certiFormPost.getIdimp().equals(""))
			{

				try
				{

					final ObjectMapper mapper = new ObjectMapper();
					mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

					if (certiFormPost.getIdimp().equals("4"))
					{
						imprimeCertDeclaraRequest.setNumObjeto(customerData.getExteriorPublicityTaxList().get(0).getObjectNumber());
					}

					if (certiFormPost.getIdimp().equals("5"))
					{
						imprimeCertDeclaraRequest.setNumObjeto(customerData.getGasTaxList().get(0).getObjectNumber());
					}

					final String aniograv_periodo = certiFormPost.getAniograv().substring(2) + certiFormPost.getPeriodo();

					imprimeCertDeclaraRequest.setNumBP(customerData.getNumBP());
					imprimeCertDeclaraRequest.setRetencion(VACIO);
					imprimeCertDeclaraRequest.setPeriodo(aniograv_periodo);
					imprimeCertDeclaraRequest.setAnoGravable(certiFormPost.getAniograv());

					final String resp = sdhImprimeCertDeclaraService.imprimePago(imprimeCertDeclaraRequest);
					final ImprimePagoResponse imprimeCertiDeclaraResponse = mapper.readValue(resp, ImprimePagoResponse.class);
					redirectModel.addFlashAttribute("imprimeCertiDeclaraResponse", imprimeCertiDeclaraResponse);
				}
				catch (final Exception e)
				{
					LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
					GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
					if (!certiFormPost.getRowFrompublicidadTable().replace(",", "").equals("X"))
					{
						redirectModel.addFlashAttribute("error", "sinPdf");
					}
					return "redirect:/contribuyentes/consultas/certideclaraciones";

				}
			}
		}
		else if (certiFormPost.getIdimp().equals("6")) //Delineacion Urbana
		{

			final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
			final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
			final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
			SDHValidaMailRolResponse detalleContribuyente;
			final InfoDelineacion infoDelineacion = new InfoDelineacion();
			String mensajeError = "";

			if (certiFormPost.getAniograv() != null)
			{
				final List<ImpuestoDelineacionUrbanaWithRadicados> delineacionWithRadicadosList = sdhValidaContribuyenteService
						.getDelineacionListByBpAndYearWithRadicados(customerModel.getNumBP(),
								certiFormPost.getAniograv());

				redirectModel.addFlashAttribute("delineacionWithRadicadosList", delineacionWithRadicadosList);
			}



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

			redirectModel.addFlashAttribute("inputDelineacion", new InfoDelineacionInput());


			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			if (certiFormPost.getInputDelineacion() != null)
			{

				if (certiFormPost.getInputDelineacion().getSelectedTipoLicencia().equals("retencion")
						|| certiFormPost.getInputDelineacion().getSelectedTipoLicencia().equals("declaracion"))
				{

					final ImprimeCertDeclaraRequest imprimeCertDeclaraDelineacionRequest = new ImprimeCertDeclaraRequest();
					final ObjectMapper mapperPublicidad = new ObjectMapper();


					imprimeCertDeclaraDelineacionRequest.setNumBP(customerData.getNumBP());

					String numObj = "";
					String itemCDU = "";
					String certiFormPostCDU = "";
					for (final SDHUrbanDelineationsTaxData item : customerData.getUrbanDelineationsTaxList())
					{

						itemCDU = item.getCdu();
						certiFormPostCDU = certiFormPost.getInputDelineacion().getSelectedCDU();
						if (itemCDU.equals(certiFormPostCDU))
						{
							numObj = item.getObjectNumber();
							break;
						}
					}

					imprimeCertDeclaraDelineacionRequest.setNumObjeto(numObj);


					imprimeCertDeclaraDelineacionRequest.setRetencion(certiFormPost.getInputDelineacion().getSelectedRadicado());
					imprimeCertDeclaraDelineacionRequest.setPeriodo(certiFormPost.getAniograv().substring(2) + "A1");
					imprimeCertDeclaraDelineacionRequest.setAnoGravable(certiFormPost.getAniograv());

					final String respDelineacion = sdhImprimeCertDeclaraService.imprimePago(imprimeCertDeclaraDelineacionRequest);
					ImprimePagoResponse imprimeCertiDeclaraDelineacionResponse;
					try
					{
						imprimeCertiDeclaraDelineacionResponse = mapperPublicidad.readValue(respDelineacion, ImprimePagoResponse.class);
						redirectModel.addFlashAttribute("imprimeCertiDeclaraResponse", imprimeCertiDeclaraDelineacionResponse);
					}
					catch (final IOException e)
					{
						LOG.error(e.getMessage());
						e.printStackTrace();
					}

					System.out.println(imprimeCertDeclaraDelineacionRequest);
				}
			}



			if (certiFormPost.getRowFrompublicidadTable() != null)
			{
				final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
				certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
				certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
				certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
				certiFormPostRedirect.setPeriodo(certiFormPost.getPeriodo());
				redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);


				redirectModel.addFlashAttribute("consultaPagoDelineacionList", sdhValidaContribuyenteService
						.getDelineacionListByBpAndYear(certiFormPost.getNumBP(), certiFormPost.getAniograv()));


				System.out.println(certiFormPost.getAniograv());
				System.out.println(certiFormPost.getNumBP());
				System.out.println(certiFormPost.getIdimp());
				System.out.println(certiFormPost.getTipoImp());
			}


			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}
		else if (certiFormPost.getIdimp().equals("3"))//ICA
		{
			final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
			boolean isPeriodoAnual = false;

			certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
			certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
			certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
			certiFormPostRedirect.setPeriodo(certiFormPost.getPeriodo());
			redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);

			if (customerData.getIcaTax() != null)
			{

				final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();
				ICAInfObjetoResponse icaInfObjetoResponse = new ICAInfObjetoResponse();

				icaInfObjetoRequest.setNumBP(customerData.getNumBP());
				icaInfObjetoRequest.setNumObjeto(customerData.getIcaTax().getObjectNumber());

				try
				{
					final ObjectMapper mapper = new ObjectMapper();
					mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


					final String response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);
					icaInfObjetoResponse = mapper.readValue(response, ICAInfObjetoResponse.class);

					if (icaInfObjetoResponse.getRegimen() != null)
					{
						if (icaInfObjetoResponse.getRegimen().charAt(0) == '2')
						{
							isPeriodoAnual = true;
						}
					}
				}
				catch (final Exception e)
				{
					LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());
				}
			}

			redirectModel.addFlashAttribute("isPeriodoAnual", isPeriodoAnual);





			if (certiFormPost.getIdimp() != null && certiFormPost.getAniograv() != null)
			{
				final String aniograv_periodo;
				if (certiFormPost.getPeriodo() == null)
				{
					aniograv_periodo = certiFormPost.getAniograv().substring(2) + "A1";
				}
				else
				{
					aniograv_periodo = certiFormPost.getAniograv().substring(2) + certiFormPost.getPeriodo();
				}

				try
				{

					final ObjectMapper mapper = new ObjectMapper();
					mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

					imprimeCertDeclaraRequest.setNumBP(customerData.getNumBP());
					imprimeCertDeclaraRequest.setNumObjeto(customerData.getIcaTax().getObjectNumber());
					imprimeCertDeclaraRequest.setPeriodo(aniograv_periodo);
					imprimeCertDeclaraRequest.setAnoGravable(certiFormPost.getAniograv());

					final String resp = sdhImprimeCertDeclaraService.imprimePago(imprimeCertDeclaraRequest);
					final ImprimePagoResponse imprimeCertiDeclaraResponse = mapper.readValue(resp, ImprimePagoResponse.class);
					redirectModel.addFlashAttribute("imprimeCertiDeclaraResponse", imprimeCertiDeclaraResponse);

				}
				catch (final Exception e)
				{
					LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
					GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
					if (!certiFormPost.getRowFrompublicidadTable().replace(",", "").equals("X"))
					{
						redirectModel.addFlashAttribute("error", "sinPdf");
					}
					return "redirect:/contribuyentes/consultas/certideclaraciones";

				}
			}
		}

		else if (certiFormPost.getIdimp().equals("7"))//ReteICA
		{
			final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
			final boolean isPeriodoAnual = false;

			certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
			certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
			certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
			certiFormPostRedirect.setPeriodo(certiFormPost.getPeriodo());
			redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);

			redirectModel.addFlashAttribute("isPeriodoAnual", isPeriodoAnual);


			if (certiFormPost.getIdimp() != null && certiFormPost.getAniograv() != null && certiFormPost.getPeriodo() != null)
			{
				try
				{

					final ObjectMapper mapper = new ObjectMapper();
					mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

					final String aniograv_periodo = certiFormPost.getAniograv().substring(2) + certiFormPost.getPeriodo();

					imprimeCertDeclaraRequest.setNumBP(customerData.getNumBP());
					imprimeCertDeclaraRequest.setNumObjeto(customerData.getReteIcaTax().getObjectNumber());
					imprimeCertDeclaraRequest.setPeriodo(aniograv_periodo);
					imprimeCertDeclaraRequest.setAnoGravable(certiFormPost.getAniograv());

					final String resp = sdhImprimeCertDeclaraService.imprimePago(imprimeCertDeclaraRequest);
					final ImprimePagoResponse imprimeCertiDeclaraResponse = mapper.readValue(resp, ImprimePagoResponse.class);
					redirectModel.addFlashAttribute("imprimeCertiDeclaraResponse", imprimeCertiDeclaraResponse);

				}
				catch (final Exception e)
				{
					LOG.error("error getting customer info from SAP Certificate page: " + e.getMessage());
					GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
					if (!certiFormPost.getRowFrompublicidadTable().replace(",", "").equals("X"))
					{
						redirectModel.addFlashAttribute("error", "sinPdf");
					}
					return "redirect:/contribuyentes/consultas/certideclaraciones";

				}
			}
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_CERTIFICA_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return "redirect:/contribuyentes/consultas/certideclaraciones";
	}




	private String getAnioGravableFromPublicidadPeriodo(final String perido)
	{
		String anio = "";
		for (final SelectAtomValue element : ControllerConstants.AnioGravable.anoGravablePublicidad)
		{
			if (element.getCode().equals(perido))
			{
				anio = element.getName();
			}
		}
		return anio;
	}


}

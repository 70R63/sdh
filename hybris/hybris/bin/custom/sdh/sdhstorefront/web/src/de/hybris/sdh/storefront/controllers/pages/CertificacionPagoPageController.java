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
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsulPagosRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaPagoRequest;
import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.requests.ImprimePagoRequest;
import de.hybris.sdh.core.pojos.requests.OpcionCertiPagosImprimeRequest;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesVista;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoDeclaraciones;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoResponse;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.ImprimePagoResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ItemListaDeclaraciones;
import de.hybris.sdh.core.pojos.responses.ListaDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.OpcionCertiPagosImprimeResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHICAInfObjetoService;
import de.hybris.sdh.core.services.SDHImprimePagoService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.questions.data.SDHExteriorPublicityTaxData;
import de.hybris.sdh.facades.questions.data.SDHGasTaxData;
import de.hybris.sdh.facades.questions.data.SDHUrbanDelineationsTaxData;
import de.hybris.sdh.storefront.controllers.ControllerConstants;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;
import de.hybris.sdh.storefront.forms.CertificacionPagoForm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Decoder.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller
@SessionAttributes(
{ "dataForm" })
/* @RequestMapping("/contribuyentes/certipagos") */
public class CertificacionPagoPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(CertificacionPagoPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.certipagos";

	private static final String VACIO = "";

	// CMS Pages
	private static final String CERTIFICACION_PAGOS_CMS_PAGE = "certiPagoPage";

	private static final String REDIRECT_TO_MI_BUZON_PAGE = REDIRECT_PREFIX + "/contribuyentes/consultas/certipagos";

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhConsultaPagoService")
	SDHConsultaPagoService sdhConsultaPagoService;

	@Resource(name = "sdhImprimePagoService")
	SDHImprimePagoService sdhImprimePagoService;

	@Resource(name = "sdhICAInfObjetoService")
	SDHICAInfObjetoService sdhICAInfObjetoService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "sdhCustomerAccountService")
	SDHCustomerAccountService sdhCustomerAccountService;

	@Resource(name = "mediaService")
	private MediaService mediaService;
	
	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

	
	
	
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

	@ModelAttribute("impuesto")
	public List<SelectAtomValue> getImpuesto()
	{
		return ControllerConstants.AnioGravable.impuesto;
	}



	//	@RequestMapping(value = "/contribuyentes/consultas/certipagos", method = RequestMethod.GET)
	@RequireHardLogIn
	public String certipagos(final Model model, @ModelAttribute("error")
	final String error) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET certificacion de pagos--------------------------");
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final CertificacionPagoForm certiForm = new CertificacionPagoForm();
		final CertificacionPagoForm certiFormPost = new CertificacionPagoForm();
		boolean isPeriodoAnual = false;


		if (error == "sinPdf")
		{
			GlobalMessages.addErrorMessage(model, "mirit.certificacion..error.pdfVacio");
		}

		certiForm.setNumBP(customerData.getNumBP());


		if (customerData.getIcaTax() != null)
		{

			final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();
			ICAInfObjetoResponse icaInfObjetoResponse = new ICAInfObjetoResponse();

			icaInfObjetoRequest.setNumBP(customerData.getNumBP());
			icaInfObjetoRequest.setNumObjeto(customerData.getIcaTax().getObjectNumber());

			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


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

			certiForm.setPublicidadExt(listImpuestoPublicdadExterior);

		}
		/*
		 * else { GlobalMessages.addErrorMessage(model, "mirit.error.getInfo"); }
		 */



		model.addAttribute("certiFormPost", certiFormPost);
		model.addAttribute("certiForm", certiForm);


		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/consultas/certipagos", method = RequestMethod.GET)
	@RequireHardLogIn
	public String pagosGET(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En GET certificacion de pagos --------------------------");

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final OpcionDeclaracionesVista infoVista = new OpcionDeclaracionesVista();
		SDHValidaMailRolResponse customerData = null;

		customerData = sdhCustomerAccountService.leerImpuestosActivosContribuyente(sdhConsultaImpuesto_simplificado.ambito_consultas);

		infoVista.setCatalogos(gasolinaService.prepararCatalogosOpcionDeclaraciones(customerData));
		infoVista.setCustomerData(customerData);

		model.addAttribute("dataForm", infoVista);

		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/consultas/certipagos/listaPagos", method = RequestMethod.GET)
	@ResponseBody
	public OpcionDeclaracionesVista listaPagosGET(@ModelAttribute("dataForm")
	final OpcionDeclaracionesVista infoVista, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET lista certificacion de pagos ------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final ConsulPagosRequest listaDeclaracionesRequest = new ConsulPagosRequest();
		ListaDeclaracionesResponse listaDeclaracionesResponse = null;


		String bp = "";
		String impuesto = "";
		String anioGravable = "";
		String periodo = "";


		bp = customerModel.getNumBP();
		if (infoVista.getCustomerData() == null)
		{
			infoVista.setCustomerData(sdhCustomerFacade.getRepresentadoFromSAP(bp));
		}




		impuesto = infoVista.getClaveImpuesto();


		anioGravable = infoVista.getAnoGravable();
		periodo = infoVista.getPeriodo();

		infoVista.setUrlDownload(null);
		infoVista.setPublicidadExt(null);
		infoVista.setGasolina(null);
		infoVista.setDelineacion(null);
		infoVista.setIca(null);
		infoVista.setReteIca(null);
		infoVista.setErrores(null);
		infoVista.setDeclaracionesCertiPagos(null);


		listaDeclaracionesRequest.setBp(bp);
		listaDeclaracionesRequest.setImpuesto(impuesto);
		listaDeclaracionesRequest.setAnioGravable(anioGravable);
		listaDeclaracionesRequest.setPeriodo(periodo);
		listaDeclaracionesRequest
				.setNumObjeto(gasolinaService.prepararNumObjeto_certipagos(infoVista, infoVista.getCustomerData()));

		System.out.println("Request para docs/consulPagos: " + listaDeclaracionesRequest);
		listaDeclaracionesResponse = gasolinaService.consultaListaDeclaraciones_consulPagos(listaDeclaracionesRequest,
				sdhDetalleGasolinaWS,
				LOG);
		System.out.println("Response de docs/consulPagos: " + listaDeclaracionesResponse);
		if (gasolinaService.ocurrioErrorListaDeclara(listaDeclaracionesResponse) != true)
		{
			listaDeclaracionesResponse.setDeclaraciones(gasolinaService.determinarRegistrosDeclaraciones_certipagos(infoVista,
					listaDeclaracionesResponse, gasolinaService));

			listaDeclaracionesResponse = this.ajustaListaDeclaracion(impuesto, infoVista, listaDeclaracionesResponse);
			infoVista.setDeclaracionesCertiPagos(listaDeclaracionesResponse);
			infoVista.setErrores(listaDeclaracionesResponse.getErrores());
		}

		return infoVista;
	}


	/**
	 * @param impuesto
	 * @param infoVista
	 * @param listaDeclaracionesResponse
	 * @return
	 */
	private ListaDeclaracionesResponse ajustaListaDeclaracion(final String impuesto, final OpcionDeclaracionesVista infoVista,
			final ListaDeclaracionesResponse listaDeclaracionesResponse)
	{
		//		ListaDeclaracionesResponse listaDeclaracionesResponseSorted = new ListaDeclaracionesResponse();
		final ListaDeclaracionesResponse listaDeclaracionesResponseSorted = listaDeclaracionesResponse;

		if (impuesto.equals("0006"))
		{
			final List<ImpuestoDelineacionUrbana> listImpuestoDelineacionUrbana = infoVista.getCustomerData().getDelineacion();
			for (final ItemListaDeclaraciones itemListaDeclaracionesResponse : listaDeclaracionesResponseSorted.getDeclaraciones())
			{
				final String objetoContrato = itemListaDeclaracionesResponse.getNumObjeto();
				final ImpuestoDelineacionUrbana itemImpuestoDelineacionUrbana = listImpuestoDelineacionUrbana.stream()
						.filter(x -> objetoContrato.equals(x.getNumObjeto())).findAny().orElse(null);
				if (itemImpuestoDelineacionUrbana != null)
				{
					itemListaDeclaracionesResponse.setNumRadicado(itemImpuestoDelineacionUrbana.getCdu());
				}
				else
				{
					itemListaDeclaracionesResponse.setNumRadicado("");
				}

				if (itemListaDeclaracionesResponse.getNoRadicado() == null)
				{
					itemListaDeclaracionesResponse.setNoRadicado("");
				}

			}

			listaDeclaracionesResponseSorted.setDeclaraciones(listaDeclaracionesResponseSorted.getDeclaraciones().stream().sorted(
					Comparator.comparing(ItemListaDeclaraciones::getNumRadicado).thenComparing(ItemListaDeclaraciones::getNoRadicado)
							.thenComparing(ItemListaDeclaraciones::getReferencia))
					.collect(Collectors.toList()));


			return listaDeclaracionesResponseSorted;
		}
		return listaDeclaracionesResponse;
	}

	@RequestMapping(value = "/contribuyentes/consultas/certipagos/pagoImprimir", method = RequestMethod.GET)
	@ResponseBody
	public OpcionDeclaracionesVista certiPagoImprimePOST(@ModelAttribute("dataForm")
	final OpcionDeclaracionesVista infoVista, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{

		System.out.println("------------------En POST certificacion de pago Impresion ------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final OpcionCertiPagosImprimeRequest impresionRequest = new OpcionCertiPagosImprimeRequest();
		OpcionCertiPagosImprimeResponse impresionResponse = null;

		String bp = "";
		String numObjeto = "";
		//		String claseObjeto = "";
		String anioGravable = "";
		String periodo = "";
		String radicado = "";

		String ctaContrato = "";
		String numfactForm = "";
		String clavePeriodo = "";
		String referencia = "";
		String fechaCompensa = "";
		String moneda = "";
		String numDocPago = "";
		String importe = "";
		String numDoc = "";
		String tipoDoc = "";


		bp = customerModel.getNumBP();
		if (infoVista.getCustomerData() == null)
		{
			infoVista.setCustomerData(sdhCustomerFacade.getRepresentadoFromSAP(bp));
		}

		//		claseObjeto = infoVista.getClaveImpuesto();
		numObjeto = infoVista.getObjContrato();
		anioGravable = infoVista.getAnoGravable();
		referencia = infoVista.getReferencia();
		fechaCompensa = infoVista.getFechaCompensa();
		moneda = infoVista.getMoneda();
		numDocPago = infoVista.getNumDocPago();
		periodo = infoVista.getPeriodo();
		radicado = "";
		ctaContrato = infoVista.getCtaContrato();
		numfactForm = infoVista.getNumfactForm();
		clavePeriodo = infoVista.getClavePeriodo();
		importe = infoVista.getImporte();
		numDoc = infoVista.getCustomerData().getInfoContrib().getNumDoc();
		tipoDoc = infoVista.getCustomerData().getInfoContrib().getTipoDoc();

		infoVista.setUrlDownload(null);
		infoVista.setDeclaraPDFResponse(null);

		impresionRequest.setNumBP(bp);
		impresionRequest.setNumObjeto(numObjeto);
		impresionRequest.setCtaContrato(ctaContrato);
		impresionRequest.setAnoGravable(anioGravable);
		impresionRequest.setPeriodo(periodo);
		impresionRequest.setNumDoc(numDoc);
		impresionRequest.setTipoDoc(tipoDoc);
		impresionRequest.setClavePeriodo(clavePeriodo);
		impresionRequest.setImporte(importe);
		impresionRequest.setReferencia(referencia);
		impresionRequest.setFechaCompensa(fechaCompensa);
		impresionRequest.setMoneda(moneda);
		impresionRequest.setNumDocPago(numDocPago);
		impresionRequest.setNumfactForm(numfactForm);


		System.out.println("Request para docs/imprimePago: " + impresionRequest);
		impresionResponse = gasolinaService.certiPagosImprimir(impresionRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de docs/imprimePago: " + impresionResponse);
		if (gasolinaService.ocurrioErrorImprimePago(impresionResponse) != true)
		{

			infoVista.setImpresionResponse(impresionResponse);
			byte[] decodedBytes;
			try
			{
				decodedBytes = new BASE64Decoder().decodeBuffer(impresionResponse.getPdf());
				final String fileName = "declaracion" + "-" + infoVista.getClaveImpuesto() + "-" + bp + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE);
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				infoVista.setUrlDownload(mediaModel.getDownloadURL());
			}
			catch (final Exception e)
			{
			}
		}
		else
		{
			//				declaraPDFResponse.setErrores(("Ocurrio un error. No se genero el PDF");
		}

		//				infoVista.setResponse_impresion(declaraPDFResponse);



		return infoVista;
	}


	@RequestMapping(value = "/contribuyentes/consultas/certipagos", method = RequestMethod.POST)
	public String certipdf(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("certiFormPost")
	final CertificacionPagoForm certiFormPost) throws CMSItemNotFoundException
	{


		final CustomerData customerData = customerFacade.getCurrentCustomer();
		ConsultaPagoDeclaraciones declaracion = new ConsultaPagoDeclaraciones();
		final ImprimePagoRequest imprimePagoRequest = new ImprimePagoRequest();
		final String anioGrav;
		final String idimp;
		final String tipoImp;
		final String param;

		if (certiFormPost.getIdimp().equals("5"))
		{
			final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
			certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
			certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
			certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
			redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);

			try
			{
				final ConsultaPagoRequest consultaPagoRequest = new ConsultaPagoRequest();
				consultaPagoRequest.setNumBP(certiFormPost.getNumBP());

				if (certiFormPost.getIdimp().equals("5"))
				{
					if (customerData.getGasTaxList() != null)
					{
						final List<SDHGasTaxData> gasTaxList = customerData.getGasTaxList();
						consultaPagoRequest.setNumObjeto(gasTaxList.get(0).getObjectNumber());
					}
				}

				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				String consultaPagoResp = sdhConsultaPagoService.consultaPago(consultaPagoRequest);
				consultaPagoResp = consultaPagoResp.replaceAll("(\"declaraciones\"):\\{((\"\\w*\":(\"\\w*\"|\\w*),*\\s*)*\\s*)\\}",
						"$1:\\[\\{$2\\}\\]");
				final ConsultaPagoResponse consultaPagoResponse = mapper
						.readValue(consultaPagoResp, ConsultaPagoResponse.class);


				if (consultaPagoResponse != null)
				{

					if (consultaPagoResponse.getDeclaraciones() != null)
					{
						final List<ConsultaPagoDeclaraciones> declaracionesList = consultaPagoResponse.getDeclaraciones();
						if (certiFormPost.getIdimp().equals("5"))
						{
							final String aniograv_periodo = certiFormPost.getAniograv().substring(2) + certiFormPost.getPeriodo();

							for (final ConsultaPagoDeclaraciones element : declaracionesList)
							{
								if (element.getClavePeriodo().equals(aniograv_periodo))
								{
									declaracion = element;
									break;
								}
							}
						}

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
					}
				}


			}
			catch (final Exception e)
			{
				LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
				GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
				if (!certiFormPost.getRowFrompublicidadTable().replace(",", "").equals("X"))
				{
					redirectModel.addFlashAttribute("error", "sinPdf");
				}
				return "redirect:/contribuyentes/consultas/certipagos";

			}
			redirectModel.addFlashAttribute("publicidadMode", false);
		}
		else if (certiFormPost.getIdimp().equals("4"))
		{
			if (certiFormPost.getRowFrompublicidadTable() != null)
			{
				if (certiFormPost.getRowFrompublicidadTable().equals("X"))
				{
					final ImprimePagoRequest imprimePubli = new ImprimePagoRequest();
					imprimePubli.setNumBP(certiFormPost.getNumBP());
					imprimePubli.setCtaContrato(certiFormPost.getCtaContrato());
					imprimePubli.setNumObjeto(certiFormPost.getNumObjeto());
					imprimePubli.setClavePeriodo(certiFormPost.getClavePeriodo());
					imprimePubli.setReferencia(certiFormPost.getReferencia());
					imprimePubli.setFechaCompensa(certiFormPost.getFechaCompensa());
					imprimePubli.setImporte(certiFormPost.getImporte());
					imprimePubli.setMoneda(certiFormPost.getMoneda());
					imprimePubli.setNumfactForm(certiFormPost.getNumfactForm());
					imprimePubli.setNumDocPago(certiFormPost.getNumDocPago());
					imprimePubli.setRefROP(VACIO);

					final ObjectMapper mapperPubli = new ObjectMapper();
					final String respPubli = sdhImprimePagoService.imprimePago(imprimePubli);
					ImprimePagoResponse imprimePagoPubliResponse = null;
					try
					{
						imprimePagoPubliResponse = mapperPubli.readValue(respPubli, ImprimePagoResponse.class);
						redirectModel.addFlashAttribute("imprimePagoResponse", imprimePagoPubliResponse);
					}
					catch (final IOException e)
					{
						GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
						redirectModel.addFlashAttribute("error", "sinPdf");
						LOG.error(e.getMessage());
					}
				}
				/*
				 * else {
				 */
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
				/*}*/

			}

			System.out.println(certiFormPost.getAniograv());
			System.out.println(certiFormPost.getNumBP());
			System.out.println(certiFormPost.getIdimp());
			System.out.println(certiFormPost.getTipoImp());
		}
		if (certiFormPost.getIdimp().equals("3"))//ICA
		{
			final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
			certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
			certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
			certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
			certiFormPostRedirect.setPeriodo(certiFormPost.getPeriodo());
			redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);

			try
			{
				final ConsultaPagoRequest consultaPagoRequest = new ConsultaPagoRequest();
				consultaPagoRequest.setNumBP(certiFormPost.getNumBP());

				if (customerData.getIcaTax() != null)
				{
					consultaPagoRequest.setNumObjeto(customerData.getIcaTax().getObjectNumber());
				}


				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final ConsultaPagoResponse consultaPagoResponse = mapper
						.readValue(sdhConsultaPagoService.consultaPago(consultaPagoRequest), ConsultaPagoResponse.class);


				if (consultaPagoResponse != null)
				{

					if (consultaPagoResponse.getDeclaraciones() != null)
					{
						final List<ConsultaPagoDeclaraciones> declaracionesList = consultaPagoResponse.getDeclaraciones();
						final String aniograv_periodo;
						if (certiFormPost.getPeriodo() == null)
						{
							aniograv_periodo = certiFormPost.getAniograv().substring(2) + "A1";
						}
						else
						{
							aniograv_periodo = certiFormPost.getAniograv().substring(2) + certiFormPost.getPeriodo();
						}

						for (final ConsultaPagoDeclaraciones element : declaracionesList)
						{
							if (element.getClavePeriodo().equals(aniograv_periodo))
							{
								declaracion = element;
								break;
							}
						}

						if (declaracion != null)
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
						}
					}
				}


			}
			catch (final Exception e)
			{
				LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
				GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
				if (!certiFormPost.getRowFrompublicidadTable().replace(",", "").equals("X"))
				{
					redirectModel.addFlashAttribute("error", "sinPdf");
				}
				return "redirect:/contribuyentes/consultas/certipagos";

			}
			redirectModel.addFlashAttribute("publicidadMode", false);
		}

		if (certiFormPost.getIdimp().equals("7"))//ReteICA
		{
			final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
			certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
			certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
			certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
			certiFormPostRedirect.setPeriodo(certiFormPost.getPeriodo());
			redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);

			try
			{
				final ConsultaPagoRequest consultaPagoRequest = new ConsultaPagoRequest();
				consultaPagoRequest.setNumBP(certiFormPost.getNumBP());

				if (customerData.getReteIcaTax() != null)
				{
					consultaPagoRequest.setNumObjeto(customerData.getReteIcaTax().getObjectNumber());
				}


				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final ConsultaPagoResponse consultaPagoResponse = mapper
						.readValue(sdhConsultaPagoService.consultaPago(consultaPagoRequest), ConsultaPagoResponse.class);


				if (consultaPagoResponse != null)
				{

					if (consultaPagoResponse.getDeclaraciones() != null)
					{
						final List<ConsultaPagoDeclaraciones> declaracionesList = consultaPagoResponse.getDeclaraciones();
						final String aniograv_periodo;
						if (certiFormPost.getPeriodo() == null)
						{
							aniograv_periodo = certiFormPost.getAniograv().substring(2) + "A1";
						}
						else
						{
							aniograv_periodo = certiFormPost.getAniograv().substring(2) + certiFormPost.getPeriodo();
						}

						for (final ConsultaPagoDeclaraciones element : declaracionesList)
						{
							if (element.getClavePeriodo().equals(aniograv_periodo))
							{
								declaracion = element;
								break;
							}
						}

						if (declaracion != null)
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
						}
					}
				}


			}
			catch (final Exception e)
			{
				LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
				GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
				if (!certiFormPost.getRowFrompublicidadTable().replace(",", "").equals("X"))
				{
					redirectModel.addFlashAttribute("error", "sinPdf");
				}
				return "redirect:/contribuyentes/consultas/certipagos";

			}
			redirectModel.addFlashAttribute("publicidadMode", false);
		}

		if (certiFormPost.getIdimp().equals("6") )//Delineacion
		{
			final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
			certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
			certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
			certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
			redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);

			try
			{
				final ConsultaPagoRequest consultaPagoRequest = new ConsultaPagoRequest();
				consultaPagoRequest.setNumBP(certiFormPost.getNumBP());

				if (customerData.getUrbanDelineationsTaxList() != null)
				{
					final List<SDHUrbanDelineationsTaxData> gasDelineacionList = customerData.getUrbanDelineationsTaxList();
					consultaPagoRequest.setNumObjeto(gasDelineacionList.get(0).getObjectNumber());
				}


				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final ConsultaPagoResponse consultaPagoResponse = mapper
						.readValue(sdhConsultaPagoService.consultaPago(consultaPagoRequest), ConsultaPagoResponse.class);


				if (consultaPagoResponse != null)
				{

					if (consultaPagoResponse.getDeclaraciones() != null)
					{
						final List<ConsultaPagoDeclaraciones> declaracionesList = consultaPagoResponse.getDeclaraciones();
						final String aniograv_periodo = certiFormPost.getAniograv().substring(2) + "A1";

						for (final ConsultaPagoDeclaraciones element : declaracionesList)
						{
							if (element.getClavePeriodo().equals(aniograv_periodo))
							{
								declaracion = element;
								break;
							}
						}

						if (declaracion != null)
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
						}
					}
				}


			}
			catch (final Exception e)
			{
				LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
				GlobalMessages.addErrorMessage(model, "No se encontraron datos.");
				if (!certiFormPost.getRowFrompublicidadTable().replace(",", "").equals("X"))
				{
					redirectModel.addFlashAttribute("error", "sinPdf");
				}
				return "redirect:/contribuyentes/consultas/certipagos";

			}
			redirectModel.addFlashAttribute("publicidadMode", false);
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return "redirect:/contribuyentes/consultas/certipagos";
	}

}

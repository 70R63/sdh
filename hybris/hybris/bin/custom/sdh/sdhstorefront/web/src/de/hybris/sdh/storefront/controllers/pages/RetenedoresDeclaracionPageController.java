/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.pojos.requests.CalculoReteIca2Request;
import de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.DetallePagoRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.responses.CalculoReteIca2Response;
import de.hybris.sdh.core.pojos.responses.CalculoReteIcaInfoDeclara;
import de.hybris.sdh.core.pojos.responses.CalculoReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.DetallePagoResponse;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.SDHReteIcaFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.pages.forms.ReteICACalculoForm;
import de.hybris.sdh.storefront.forms.GeneraDeclaracionForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller
public class RetenedoresDeclaracionPageController extends RetenedoresAbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String RETEICA_DECLARACION_PROFILE = "Retenedores Declaracion";
	private static final String RETEICA_DECLARACION_CMS_PAGE = "retenedoresDeclaracionPage";


	private static final String REDIRECT_TO_RETEICA_DECLARACION_PAGE = REDIRECT_PREFIX + "/retenedores/declaracion";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhReteIcaFacade")
	SDHReteIcaFacade sdhReteIcaFacade;

	@Resource(name = "sdhGeneraDeclaracionService")
	SDHGeneraDeclaracionService sdhGeneraDeclaracionService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;


	@RequestMapping(value = "/retenedores/declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String retenedoricadeclaracion(final Model model, @RequestParam(value = "numForm")
	final String numForm, @RequestParam(value = "anoGravable")
	final String anoGravable, @RequestParam(value = "objectNumber")
	final String objectNumber, @RequestParam(value = "perRepor")
	final String perRepor) throws CMSItemNotFoundException
	{
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();
		if (StringUtils.isBlank(numForm))
		{
			return "redirect:" + "/retenedores/estadocargas";
		}

		final CustomerData customerData = getCustomerFacade().getCurrentCustomer();
		final CalculoReteIcaRequest request = new CalculoReteIcaRequest();

		request.setNumBP(customerData.getNumBP());
		request.setNumForm(numForm);

		final CalculoReteIcaResponse calculoResponse = sdhReteIcaFacade.calculo(request);

		model.addAttribute("calculoResponse", calculoResponse);
		storeCmsPageInModel(model, getContentPageForLabelOrId(RETEICA_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RETEICA_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(RETEICA_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		infoPreviaPSE.setAnoGravable(anoGravable);
		infoPreviaPSE.setTipoDoc(customerData.getDocumentType());
		infoPreviaPSE.setNumDoc(customerData.getDocumentNumber());
		infoPreviaPSE.setNumBP(customerData.getNumBP());
		infoPreviaPSE.setClavePeriodo(perRepor);
		infoPreviaPSE.setNumObjeto(objectNumber);
		infoPreviaPSE.setTipoImpuesto(new ControllerPseConstants().getRETEICA());
		model.addAttribute("infoPreviaPSE", infoPreviaPSE);

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final DetallePagoRequest detallePagoRequest = new DetallePagoRequest();
		final DetallePagoResponse detallePagoResponse;

		detallePagoRequest.setNumBP(infoPreviaPSE.getNumBP());
		detallePagoRequest.setClavePeriodo(infoPreviaPSE.getClavePeriodo());
		detallePagoRequest.setNumObjeto(infoPreviaPSE.getNumObjeto());
		detallePagoResponse = gasolinaService.consultaDetallePago(detallePagoRequest, sdhDetalleGasolinaWS, LOG);

		model.addAttribute("paymentDisabled", gasolinaService.ocurrioErrorPSE(detallePagoResponse) == true ? "disabled" : "");
		System.out.println("------> detallePagoResponse");
		System.out.println(detallePagoResponse);
		System.out.println("------> detallePagoResponse");

		return getViewForPage(model);
	}

	@RequestMapping(value = "/retenedores/declaracion/calculo", method = RequestMethod.POST)
	@RequireHardLogIn
	@ResponseBody
	public CalculoReteIcaResponse postretenedoricadeclaracion(final Model model, final ReteICACalculoForm form)
			throws CMSItemNotFoundException
	{
		final CustomerData customerData = getCustomerFacade().getCurrentCustomer();


		final CalculoReteIcaRequest request = new CalculoReteIcaRequest();

		request.setNumBP(customerData.getNumBP());
		request.setNumForm(form.getNumForm());
		request.setValorPagar(form.getValorPagar());


		final CalculoReteIcaResponse calculoResponse = sdhReteIcaFacade.calculo(request);

		return calculoResponse;
	}

	@RequestMapping(value = "/retenedores/declaracion/generar", method = RequestMethod.POST)
	@ResponseBody
	public GeneraDeclaracionResponse generar(final GeneraDeclaracionForm dataForm, final HttpServletResponse response,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		GeneraDeclaracionResponse generaDeclaracionResponse = new GeneraDeclaracionResponse();
		final CustomerData customerData = getCustomerFacade().getCurrentCustomer();
		final String numForm = dataForm.getNumForm();

		final GeneraDeclaracionRequest generaDeclaracionRequest = new GeneraDeclaracionRequest();


		generaDeclaracionRequest.setNumForm(numForm);

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			generaDeclaracionResponse = mapper.readValue(sdhGeneraDeclaracionService.generaDeclaracion(generaDeclaracionRequest),
					GeneraDeclaracionResponse.class);

			if (generaDeclaracionResponse != null && generaDeclaracionResponse.getStringPDF() != null)
			{
				final String encodedBytes = generaDeclaracionResponse.getStringPDF();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = numForm + "-" + customerData.getNumBP() + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE.booleanValue());
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


	@RequestMapping(value = "/reteica/declaracion/show", method = RequestMethod.GET)
	@RequireHardLogIn
	public String retenedoricadeclaracion_show(@RequestParam(value = "representado")
	final String representado, @RequestParam(value = "numForm")
	final String numForm, @RequestParam(value = "anoGravable")
	final String anoGravable, @RequestParam(value = "perRepor")
	final String perRepor, final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En ReteIca2 Agente Autorizado GET --------------------------");
		if (StringUtils.isBlank(numForm))
		{
			return "redirect:" + "/retenedores/estadocargas";
		}


		final CustomerData currentUserData = this.getCustomerFacade().getCurrentCustomer();
		final CustomerData contribuyenteData = sdhCustomerFacade.getRepresentadoDataFromSAP(representado);
		final SDHValidaMailRolResponse contribuyenteData2 = sdhCustomerFacade.getRepresentadoFromSAP(representado);

		model.addAttribute("contribuyenteData", contribuyenteData);
		model.addAttribute("currentUserData", currentUserData);
		model.addAttribute("redirectURL",
				"https://publicsector.local:9002/sdhstorefront/es/retenedores/registroretenciones?representado="
						+ contribuyenteData.getNumBP());

		model.addAttribute("customerData", currentUserData);
		addAgentsToModel(model, currentUserData, null);


		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final InfoPreviaPSE infoPreviaPSE = new InfoPreviaPSE();
		CalculoReteIcaResponse calculoResponse = null;
		CalculoReteIca2Response calculo2Response = null;
		final CalculoReteIca2Request request = new CalculoReteIca2Request();

		request.setPartner(representado);
		request.setFormulario(numForm);


		System.out.println("Request para calculoImp/ReteIca2: " + request);
		calculo2Response = gasolinaService.consultaReteIca2(request, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de calculoImp/ReteIca2: " + calculo2Response);
		if (gasolinaService.ocurrioErrorCalc2Reteica(calculo2Response) != true)
		{

			if (calculo2Response != null)
			{
				super.addFirmantes_impuesto(model, calculo2Response.getIcaFirmantes(), currentUserData);
				calculoResponse = new CalculoReteIcaResponse();
				final CalculoReteIcaInfoDeclara infoDeclara = new CalculoReteIcaInfoDeclara();
				infoDeclara.setBaseReten(calculo2Response.getInfoDeclara().getBaseReten());
				infoDeclara.setDescDevol(calculo2Response.getInfoDeclara().getDescDevol());
				infoDeclara.setInteresMora(calculo2Response.getInfoDeclara().getInteresMora());
				infoDeclara.setSancion(calculo2Response.getInfoDeclara().getSancion());
				infoDeclara.setTotalPagar(calculo2Response.getInfoDeclara().getTotalPagar());
				infoDeclara.setTotalReteDecl(calculo2Response.getInfoDeclara().getTotalReteDecl());
				infoDeclara.setTotalRetePer(calculo2Response.getInfoDeclara().getTotalRetePer());
				infoDeclara.setTotalSaldo(calculo2Response.getInfoDeclara().getTotalSaldo());
				infoDeclara.setValorPagar(calculo2Response.getInfoDeclara().getValorPagar());
				calculoResponse.setInfoDeclara(infoDeclara);
				calculoResponse.setNumForm(calculo2Response.getNumForm());
			}


			//			final SDHValidaMailRolResponse customerData2 = sdhCustomerFacade.getRepresentadoFromSAP(representado);
			infoPreviaPSE.setAnoGravable(anoGravable);
			infoPreviaPSE.setTipoDoc(contribuyenteData2.getInfoContrib().getTipoDoc());
			infoPreviaPSE.setNumDoc(contribuyenteData2.getInfoContrib().getNumDoc());
			infoPreviaPSE.setNumBP(contribuyenteData2.getInfoContrib().getNumBP());
			infoPreviaPSE.setPeriodo(perRepor);
			infoPreviaPSE.setClavePeriodo(gasolinaService.prepararPeriodoBimestralPago(anoGravable, perRepor));
			infoPreviaPSE.setDv(gasolinaService.prepararDV(contribuyenteData2));
			infoPreviaPSE.setNumObjeto(gasolinaService.prepararNumObjetoReteICA(contribuyenteData2));
			infoPreviaPSE.setTipoImpuesto(new ControllerPseConstants().getRETEICA());
		}
		else
		{
			//			mensajeError = detalleContribuyente.getTxtmsj();
			//			LOG.error("Error al leer informacion del Contribuyente: " + mensajeError);
			//			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
		}

		model.addAttribute("calculoResponse", calculoResponse);
		model.addAttribute("infoPreviaPSE", infoPreviaPSE);


		storeCmsPageInModel(model, getContentPageForLabelOrId(RETEICA_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RETEICA_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(RETEICA_DECLARACION_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);



		return getViewForPage(model);
	}

}

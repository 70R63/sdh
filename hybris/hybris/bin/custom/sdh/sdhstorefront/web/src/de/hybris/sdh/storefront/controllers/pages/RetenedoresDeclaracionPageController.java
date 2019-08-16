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
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.DetallePagoRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.requests.InfoPreviaPSE;
import de.hybris.sdh.core.pojos.responses.CalculoReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.DetallePagoResponse;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
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

}

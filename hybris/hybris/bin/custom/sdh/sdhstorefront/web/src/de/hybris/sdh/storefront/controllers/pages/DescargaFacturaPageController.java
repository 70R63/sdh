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
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.DefaultResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DescargaFacturaRequest;
import de.hybris.sdh.core.pojos.responses.DescargaFacturaResponse;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.DescargaFacturaForm;
import de.hybris.sdh.storefront.forms.FacturacionForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class DescargaFacturaPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.descargaFac";

	// CMS Pages
	private static final String DESCARGA_FACTURA_CMS_PAGE = "descargaFacturaPage";

	private static final String REDIRECT_TO_DESCARGA_FACTURA_PAGE = REDIRECT_PREFIX + "/contribuyentes/descargafactura";

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



	@RequestMapping(value = "/contribuyentes/descargafactura", method = RequestMethod.GET)
	@RequireHardLogIn
	public String descargafact(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Descarga Factura --------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

		final FacturacionForm facturacionForm = new FacturacionForm();


		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());
		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			facturacionForm.setPredial(sdhConsultaContribuyenteBPResponse.getPredial());
			facturacionForm.setVehicular(sdhConsultaContribuyenteBPResponse.getVehicular());

			model.addAttribute("facturacionForm", facturacionForm);
		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(DESCARGA_FACTURA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DESCARGA_FACTURA_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/descargafactura", method = RequestMethod.POST)
	@RequireHardLogIn
	public String descargafactpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de Descarga Factura------------------------");

		return REDIRECT_TO_DESCARGA_FACTURA_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/descargafactura/descargarFactura", method = RequestMethod.GET)
	@ResponseBody
	public DescargaFacturaForm descaragarPDF(final DescargaFacturaForm dataForm, final HttpServletResponse response,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		DescargaFacturaResponse descargaFacturaResponse = null;
		final DescargaFacturaRequest descargaFacturaRequest = new DescargaFacturaRequest();
		final String numBP = customerFacade.getCurrentCustomer().getNumBP();


		dataForm.setErrores(null);
		dataForm.setUrlDownload(null);
		descargaFacturaRequest.setNumBP(numBP);
		//		descargaFacturaRequest.setNumBP(dataForm.getNumBP());
		descargaFacturaRequest.setAnoGravable(dataForm.getAnoGravable());
		descargaFacturaRequest.setNumObjeto(dataForm.getNumObjeto());
		descargaFacturaRequest.setTipoOperacion("1");

		try
		{
			System.out.println("Request de trm/facturacion: " + descargaFacturaRequest);
			descargaFacturaResponse = gasolinaService.descargaFactura(descargaFacturaRequest, sdhDetalleGasolinaWS, LOG);
			System.out.println("Response de trm/facturacion: " + descargaFacturaResponse);

			dataForm.setErrores(descargaFacturaResponse.getErrores());
			if (descargaFacturaResponse != null && descargaFacturaResponse.getPdf() != null
					&& !descargaFacturaResponse.getPdf().isEmpty())
			{
				final String encodedBytes = descargaFacturaResponse.getPdf();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = dataForm.getNumObjeto() + "-" + dataForm.getNumBP() + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE.booleanValue());
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				dataForm.setUrlDownload(mediaModel.getDownloadURL());


			}

		}
		catch (final Exception e)
		{
			LOG.error("error al descargar factura : " + e.getMessage());

			final ErrorEnWS error = new ErrorEnWS();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error al descargar la declaración, por favor intentalo más tarde");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();

			errores.add(error);

			dataForm.setErrores(errores);

		}
		return dataForm;

	}

}

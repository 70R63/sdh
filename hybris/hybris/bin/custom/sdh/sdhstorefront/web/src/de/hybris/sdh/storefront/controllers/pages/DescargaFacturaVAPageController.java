/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
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
import de.hybris.sdh.core.pojos.requests.ConsultaContribBPRequest;
import de.hybris.sdh.core.pojos.requests.ConsultarBPRequest;
import de.hybris.sdh.core.pojos.requests.OpcionCertiDecImprimeRequest;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesVista;
import de.hybris.sdh.core.pojos.responses.ConsultarBPResponse;
import de.hybris.sdh.core.pojos.responses.ErrorEnWSDeclaracionesPDF;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.OpcionCertiDecImprimeResponse;
import de.hybris.sdh.core.pojos.responses.OpcionDeclaracionesPDFResponse;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConfigCatalogos;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.pages.forms.DescargaFacturaVAForm;
import de.hybris.sdh.storefront.controllers.pages.forms.SDHLoginForm;
import de.hybris.sdh.storefront.forms.FacturacionForm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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

import Decoder.BASE64Decoder;


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
		
		
		List<SelectAtomValue> documentTypes = sdhDocumentTypeDao.getAllDocumentTypes();
		model.addAttribute("documentTypes", documentTypes);
		model.addAttribute("infoVista", infoVista);
		final SDHLoginForm loginForm = new SDHLoginForm();
		model.addAttribute("loginForm", loginForm);
		model.addAttribute("facturacionForm", facturacionForm);
		

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
		
		
		
		ConsultarBPRequest requestConsultarBP = new ConsultarBPRequest();
		requestConsultarBP.setNumid(infoVista.getNumDoc());
		requestConsultarBP.setTipoid(infoVista.getTipoDoc());
		requestConsultarBP.setFechExp(infoVista.getFechaExp());
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
			}
		}


		return infoVista;
	}
	
	
}


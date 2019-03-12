/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.ImprimeCertDeclaraRequest;
import de.hybris.sdh.core.pojos.responses.ImprimePagoResponse;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHImprimeCertDeclaraService;
import de.hybris.sdh.storefront.forms.CertificacionPagoForm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller

public class CertificacionDeclaracionesPageController extends AbstractPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_CERTIFICA_DECLARACION = "Certifica Declaración";
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

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhConsultaPagoService")
	SDHConsultaPagoService sdhConsultaPagoService;

	@Resource(name = "sdhImprimeCertDeclaraService")
	SDHImprimeCertDeclaraService sdhImprimeCertDeclaraService;


	@RequestMapping(value = "/contribuyentes/consultas/certideclaraciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String oblipendi(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Obligaciones Pendientes--------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final CertificacionPagoForm certiFormPost = new CertificacionPagoForm();

		model.addAttribute("certiFormPost", certiFormPost);

		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_CERTIFICA_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}



	@RequestMapping(value = "/contribuyentes/consultas/certideclaraciones", method = RequestMethod.POST)
	public String certipdf(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("certiFormPost")
	final CertificacionPagoForm certiFormPost) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al POST certificacion de pagos--------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final ImprimeCertDeclaraRequest imprimeCertDeclaraRequest = new ImprimeCertDeclaraRequest();

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
			return "redirect:/contribuyentes/consultas/certideclaraciones";

		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_DECLARACIONES_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_CERTIFICA_DECLARACION));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return "redirect:/contribuyentes/consultas/certideclaraciones";
	}



}

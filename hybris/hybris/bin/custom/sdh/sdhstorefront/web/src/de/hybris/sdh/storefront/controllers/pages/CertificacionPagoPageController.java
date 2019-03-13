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
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.ConsultaPagoRequest;
import de.hybris.sdh.core.pojos.requests.ImprimePagoRequest;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoDeclaraciones;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoResponse;
import de.hybris.sdh.core.pojos.responses.ImprimePagoResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHImprimePagoService;
import de.hybris.sdh.facades.questions.data.SDHExteriorPublicityTaxData;
import de.hybris.sdh.facades.questions.data.SDHGasTaxData;
import de.hybris.sdh.storefront.forms.CertificacionPagoForm;

import java.util.ArrayList;
import java.util.List;

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
/* @RequestMapping("/contribuyentes/certipagos") */
public class CertificacionPagoPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

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

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhConsultaPagoService")
	SDHConsultaPagoService sdhConsultaPagoService;

	@Resource(name = "sdhImprimePagoService")
	SDHImprimePagoService sdhImprimePagoService;


	@RequestMapping(value = "/contribuyentes/consultas/certipagos", method = RequestMethod.GET)
	@RequireHardLogIn
	public String certipagos(final Model model, @ModelAttribute("error")
	final String error) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET certificacion de pagos--------------------------");
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final CertificacionPagoForm certiForm = new CertificacionPagoForm();
		final CertificacionPagoForm certiFormPost = new CertificacionPagoForm();

		if (error == "sinPdf")
		{
			GlobalMessages.addErrorMessage(model, "mirit.certificacion..error.pdfVacio");
		}

		certiForm.setNumBP(customerData.getNumBP());

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

	@RequestMapping(value = "/contribuyentes/consultas/certipagos", method = RequestMethod.POST)
	public String certipdf(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("certiFormPost")
	final CertificacionPagoForm certiFormPost) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al POST certificacion de pagos--------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		ConsultaPagoDeclaraciones declaracion = new ConsultaPagoDeclaraciones();
		final ImprimePagoRequest imprimePagoRequest = new ImprimePagoRequest();

		try
		{
			final ConsultaPagoRequest consultaPagoRequest = new ConsultaPagoRequest();

			consultaPagoRequest.setNumBP(certiFormPost.getNumBP());


			if (certiFormPost.getIdimp().equals("4"))
			{
				consultaPagoRequest.setNumObjeto(certiFormPost.getNumObjetoSel());
			}



			if (certiFormPost.getIdimp().equals("5"))
			{
				if (customerData.getGasTaxList() != null)
				{
					final List<SDHGasTaxData> gasTaxList = customerData.getGasTaxList();
					consultaPagoRequest.setNumObjeto(gasTaxList.get(0).getObjectNumber());
				}
			}

		   final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final ConsultaPagoResponse consultaPagoResponse = mapper
					.readValue(sdhConsultaPagoService.consultaPago(consultaPagoRequest), ConsultaPagoResponse.class);


			if (consultaPagoResponse != null)
			{

				if (consultaPagoResponse.getDeclaraciones() != null)
				{
					final List<ConsultaPagoDeclaraciones> declaracionesList = consultaPagoResponse.getDeclaraciones();

					if (certiFormPost.getIdimp().equals("4"))
					{
						declaracion = declaracionesList.get(0);
					}

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
			redirectModel.addFlashAttribute("error", "sinPdf");
			return "redirect:/contribuyentes/consultas/certipagos";

		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return "redirect:/contribuyentes/consultas/certipagos";
	}



}

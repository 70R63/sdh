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
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.storefront.controllers.ControllerConstants;
import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;
import de.hybris.sdh.storefront.forms.CertificacionPagoForm;

import java.io.IOException;
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

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhConsultaPagoService")
	SDHConsultaPagoService sdhConsultaPagoService;

	@Resource(name = "sdhImprimeCertDeclaraService")
	SDHImprimeCertDeclaraService sdhImprimeCertDeclaraService;

	@Resource(name = "sdhValidaContribuyenteService")
	private SDHValidaContribuyenteService sdhValidaContribuyenteService;

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


	@RequestMapping(value = "/contribuyentes/consultas/certideclaraciones", method = RequestMethod.GET)
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



	@RequestMapping(value = "/contribuyentes/consultas/certideclaraciones", method = RequestMethod.POST)
	public String certipdf(final Model model, final RedirectAttributes redirectModel, @ModelAttribute("certiFormPost")
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
			if (certiFormPost.getRowFrompublicidadTable() != null)
			{
				if (certiFormPost.getRowFrompublicidadTable().equals("X"))
				{
					final ImprimeCertDeclaraRequest imprimeCertDeclaraDelineacionRequest = new ImprimeCertDeclaraRequest();
					final ObjectMapper mapperPublicidad = new ObjectMapper();

					imprimeCertDeclaraDelineacionRequest.setNumBP(customerData.getNumBP());
					imprimeCertDeclaraDelineacionRequest.setNumObjeto(certiFormPost.getNumObjeto());
					imprimeCertDeclaraDelineacionRequest.setRetencion(VACIO);
					//imprimeCertDeclaraDelineacionRequest.setPeriodo(certiFormPost.getAniograv());
					imprimeCertDeclaraDelineacionRequest.setAnoGravable(certiFormPost.getAniograv().split("/")[2]);

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
		}
		else if (certiFormPost.getIdimp().equals("3"))//ICA
		{
			final CertificacionPagoForm certiFormPostRedirect = new CertificacionPagoForm();
			certiFormPostRedirect.setTipoImp(certiFormPost.getTipoImp());
			certiFormPostRedirect.setIdimp(certiFormPost.getIdimp());
			certiFormPostRedirect.setAniograv(certiFormPost.getAniograv());
			redirectModel.addFlashAttribute("certiFormPost", certiFormPostRedirect);





			if (certiFormPost.getIdimp() != null && certiFormPost.getAniograv() != null)
			{
				final String aniograv_periodo = certiFormPost.getAniograv().substring(2) + "A1";

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

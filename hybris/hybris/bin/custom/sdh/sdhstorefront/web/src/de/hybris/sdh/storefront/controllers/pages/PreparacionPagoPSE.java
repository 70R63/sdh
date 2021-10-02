package de.hybris.sdh.storefront.controllers.pages;


import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.dao.impl.DefaultSDHTaxTypeDao;
import de.hybris.sdh.core.model.SDHTaxTypeModel;
import de.hybris.sdh.core.pojos.requests.*;
import de.hybris.sdh.core.pojos.responses.DetallePagoResponse;
import de.hybris.sdh.core.pojos.responses.PaymentServiceRegisterResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHTaxTypeService;
import de.hybris.sdh.core.services.SdhPaymentService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.PSEPaymentForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


/**
 * Controller for home page 2
 */
@Controller
@SessionAttributes("psePaymentForm")
public class PreparacionPagoPSE extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(PublicidadExteriorPageController.class);


	private static final String DECLARACIONES_PAGAR_CMS_PAGE = "preparacionPagarPSE";
	private static final String REDIRECT_TO_DECLARACIONES_PAGAR_PAGE = REDIRECT_PREFIX + "/impuestos/preparaPagoPSE";

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhPaymentService")
	private SdhPaymentService sdhPaymentService;

    @Resource(name = "sdhTaxTypeService")
    private SDHTaxTypeService sdhTaxTypeService;

	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.declarapublicidad";

	//CMS PAGES
	private static final String DECLARACION_PUBLICIDAD_CMS_PAGE = "DeclaraPublicidadPage";


	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}






	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/impuestos/preparaPagoPSE", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_PAG(@ModelAttribute("psePaymentForm")
	final PSEPaymentForm psePaymentForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes, final HttpServletRequest request, final HttpServletResponse response)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Preparacion Pago PSE GET --------------------------");
		model.addAttribute("psePaymentForm", psePaymentForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_PAGAR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_PAGAR_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return getViewForPage(model);
	}



	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/impuestos/preparaPagoPSE", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_PAG(@ModelAttribute("infoPreviaPSE")
	final InfoPreviaPSE infoPreviaPSE, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{

		System.out.println("---------------- En Preparacion Pago PSE POST --------------------------");
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		String[] mensajesError;
		String mensajeError = "";
		final DetallePagoRequest detallePagoRequest = new DetallePagoRequest();
		final DetallePagoResponse detallePagoResponse;
		final PSEPaymentForm psePaymentForm = new PSEPaymentForm();




		if (infoPreviaPSE.getNumRef() != null && !infoPreviaPSE.getNumRef().equals(""))
		{
			psePaymentForm.setTipoDeImpuesto(infoPreviaPSE.getTipoImpuesto());
			psePaymentForm.setAnoGravable(infoPreviaPSE.getAnoGravable());
			psePaymentForm.setPeriodo(infoPreviaPSE.getClavePeriodo());
			psePaymentForm.setTipoDeIdentificacion(infoPreviaPSE.getTipoDoc());
			psePaymentForm.setNoIdentificacion(infoPreviaPSE.getNumDoc());
			psePaymentForm.setDV(infoPreviaPSE.getDv());
			psePaymentForm.setObjPago(infoPreviaPSE.getNumObjeto());
			psePaymentForm.setCUD(infoPreviaPSE.getCDU());


			String valorPagar = infoPreviaPSE.getTotalPagar();
			valorPagar = valorPagar.replaceAll("\\s+", "");
			valorPagar = valorPagar.replaceAll("\\.(0{1,2})$", "");

			psePaymentForm.setValorAPagar(valorPagar);
			psePaymentForm.setNumeroDeReferencia(infoPreviaPSE.getNumRef());
			psePaymentForm.setFechaLimiteDePago(infoPreviaPSE.getFechaVenc());
			psePaymentForm.setCHIP(infoPreviaPSE.getChip());
			psePaymentForm.setCdu(infoPreviaPSE.getCdu());
			psePaymentForm.setPlaca(infoPreviaPSE.getPlaca());

		}
		else
		{
			detallePagoRequest.setNumBP(infoPreviaPSE.getNumBP());
			detallePagoRequest.setClavePeriodo(infoPreviaPSE.getClavePeriodo());
			detallePagoRequest.setNumObjeto(infoPreviaPSE.getNumObjeto());
			detallePagoRequest.setAnticipo(infoPreviaPSE.getRadicado());


			System.out.println("Request de consulPago: " + detallePagoRequest);
			detallePagoResponse = gasolinaService.consultaDetallePago(detallePagoRequest, sdhDetalleGasolinaWS, LOG);
			System.out.println("Response de consulPago: " + detallePagoResponse);

			if (gasolinaService.ocurrioErrorPSE(detallePagoResponse) != true)
			{
				psePaymentForm.setTipoDeImpuesto(infoPreviaPSE.getTipoImpuesto());
				psePaymentForm.setAnoGravable(infoPreviaPSE.getAnoGravable());
				psePaymentForm.setPeriodo(infoPreviaPSE.getClavePeriodo());
				psePaymentForm.setTipoDeIdentificacion(infoPreviaPSE.getTipoDoc());
				psePaymentForm.setNoIdentificacion(infoPreviaPSE.getNumDoc());
				psePaymentForm.setDV(infoPreviaPSE.getDv());
				psePaymentForm.setObjPago(infoPreviaPSE.getNumObjeto());
				psePaymentForm.setCUD(infoPreviaPSE.getCDU());
				psePaymentForm.setPlaca(infoPreviaPSE.getPlaca());


				psePaymentForm.setValorAPagar(detallePagoResponse.getTotalPagar());
				psePaymentForm.setNumeroDeReferencia(detallePagoResponse.getNumRef());
				psePaymentForm.setFechaLimiteDePago(detallePagoResponse.getFechVenc());
				psePaymentForm.setCHIP(infoPreviaPSE.getChip());
			}
			else
			{
				mensajeError = gasolinaService.obtenerMensajeError(detallePagoResponse.getErrores(), 0);
				LOG.error("Error al leer detalle de pago: " + mensajeError);
				mensajesError = gasolinaService.prepararMensajesError(detallePagoResponse.getErrores());
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "error.Pago.PSE.error1",
						mensajesError);
			}
		}
		//model.addAttribute("psePaymentForm", psePaymentForm);

        SDHTaxTypeModel sdhTaxTypeModel = sdhTaxTypeService.findUniqueByTaxCode(psePaymentForm.getTipoDeImpuesto());
        PaymentServiceRegisterResponse paymentServiceRegisterResponse = null;

        PaymentServiceRegisterEntityRequest paymentServiceRegisterEntityRequest =
                new PaymentServiceRegisterEntityRequest(1, "SECRETARIA DISTRITAL DE HACIENDA");

        PaymentServiceRegisterApplicationRequest paymentServiceRegisterApplicationRequest =
                new PaymentServiceRegisterApplicationRequest(5, "BOGDATA SAP");

        PaymentServiceRegisterRequest paymentServiceRegisterRequest =
                new PaymentServiceRegisterRequest(
                        paymentServiceRegisterEntityRequest,
                        paymentServiceRegisterApplicationRequest,
                        psePaymentForm.getTipoDeImpuesto(),
                        Objects.nonNull(sdhTaxTypeModel) ? sdhTaxTypeModel.getName() : StringUtils.EMPTY,
                        psePaymentForm.getNumeroDeReferencia(),
                        psePaymentForm.getObjPago(),
                        psePaymentForm.getNumeroDeReferencia(),
                        "AAA0123KLJH",
                        psePaymentForm.getFechaLimiteDePago(),
                        "http://sap.shd.gov.co/bogota",
                        Integer.parseInt(psePaymentForm.getValorAPagar()));

        try {
            paymentServiceRegisterResponse = sdhPaymentService.register(paymentServiceRegisterRequest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        System.out.println(paymentServiceRegisterRequest);
		System.out.println(paymentServiceRegisterResponse);

        return Objects.nonNull(paymentServiceRegisterResponse) ?
                "redirect:" + paymentServiceRegisterResponse.getPaymentUrl() : "/";
	}

	@RequestMapping(value = "/setComplete5", method = RequestMethod.POST)
	public String setComplete(final SessionStatus status)
	{
		status.setComplete();

		return null;
	}


}
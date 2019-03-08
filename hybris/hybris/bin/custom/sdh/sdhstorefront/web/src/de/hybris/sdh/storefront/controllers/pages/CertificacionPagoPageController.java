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
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.facades.questions.data.SDHExteriorPublicityTaxData;
import de.hybris.sdh.storefront.forms.CertificacionPagoForm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	// CMS Pages
	private static final String CERTIFICACION_PAGOS_CMS_PAGE = "certiPagoPage";

	private static final String REDIRECT_TO_MI_BUZON_PAGE = REDIRECT_PREFIX + "/contribuyentes/consultas/certipagos";

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;


	@RequestMapping(value = "/contribuyentes/consultas/certipagos", method = RequestMethod.GET)
	@RequireHardLogIn
	public String certipagos(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET certificacion de pagos--------------------------");
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final CertificacionPagoForm certiForm = new CertificacionPagoForm();

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
		else
		{
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}
		model.addAttribute("certiForm", certiForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/consultas/certipagos", method = RequestMethod.POST)
	@RequireHardLogIn
	public String certipdf(@ModelAttribute("certiForm")
	final CertificacionPagoForm certiForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al POST certificacion de pagos--------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CERTIFICACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return REDIRECT_TO_MI_BUZON_PAGE;
	}



}

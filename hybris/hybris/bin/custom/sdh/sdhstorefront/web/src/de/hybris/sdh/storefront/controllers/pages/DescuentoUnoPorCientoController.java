/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.Descuento1PCCatalogos;
import de.hybris.sdh.storefront.forms.Descuento1PCForm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Federico Flores Dimas
 *
 */
@Controller
public class DescuentoUnoPorCientoController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(DescuentoUnoPorCientoController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Facturacion";

	// CMS Pages
	private static final String DESCUENTO_UNOPORCIENTO_CMS_PAGE = "descuentoUnoPorCientoPage";

	private static final String REDIRECT_TO_DESCUENTO_UNOPORCIENTO_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/facturacion/descuentoUnoPorCiento";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	@RequestMapping(value = "/contribuyentes/facturacion/descuentoUnoPorCiento", method = RequestMethod.GET)
	@RequireHardLogIn
	public String tramitesseguimiento(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En GET Descuento 1% --------------------------");
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);


		final Descuento1PCForm dataForm = new Descuento1PCForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final Descuento1PCCatalogos catalogos = gasolinaService.prepararCatalogosDescuento1PC();


		dataForm.setCustomerData(customerData);
		model.addAttribute("dataForm", dataForm);


		storeCmsPageInModel(model, getContentPageForLabelOrId(DESCUENTO_UNOPORCIENTO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DESCUENTO_UNOPORCIENTO_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}


}

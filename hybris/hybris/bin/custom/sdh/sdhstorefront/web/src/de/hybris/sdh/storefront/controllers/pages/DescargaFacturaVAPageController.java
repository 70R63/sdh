/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.DefaultResourceBreadcrumbBuilder;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConfigCatalogos;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHDetalleGasolina;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class DescargaFacturaVAPageController extends AbstractPageController
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


	@RequestMapping(value = "/descargaFacturaVA", method = RequestMethod.GET)
	public String descargafact(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Descarga Factura --------------------------");


		storeCmsPageInModel(model, getContentPageForLabelOrId(DESCARGA_FACTURA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DESCARGA_FACTURA_CMS_PAGE));

		//		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}
}


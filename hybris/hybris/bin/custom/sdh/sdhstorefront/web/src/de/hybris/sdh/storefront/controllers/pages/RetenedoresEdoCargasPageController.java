/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.sdh.core.pojos.requests.ReteIcaRequest;
import de.hybris.sdh.core.pojos.responses.ReteIcaResponse;
import de.hybris.sdh.facades.SDHReteIcaFacade;
import de.hybris.sdh.storefront.controllers.pages.forms.EstadoCargasForm;

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
public class RetenedoresEdoCargasPageController extends RetenedoresAbstractPageController

{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Estado de Cargas";

	// CMS Pages
	private static final String AGENTES_RETENEDORES_CARGAS_CMS_PAGE = "retenedoresEdoCargasPage";

	private static final String REDIRECT_TO_AGENTES_RETENEDORES_CARGAS_PAGE = REDIRECT_PREFIX + "/retenedores/estadocargas";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhReteIcaFacade")
	SDHReteIcaFacade sdhReteIcaFacade;

	@RequestMapping(value = "/retenedores/estadocargas", method = RequestMethod.GET)
	@RequireHardLogIn
	public String retenedorescargas(final Model model) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_CARGAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_CARGAS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/retenedores/estadocargas", method = RequestMethod.POST)
	@RequireHardLogIn
	public String retenedorescargaspost(final Model model, final EstadoCargasForm form)
			throws CMSItemNotFoundException
	{

		model.addAttribute("form", form);

		final CustomerData customerData = getCustomerFacade().getCurrentCustomer();

		final ReteIcaRequest request = new ReteIcaRequest();
		request.setAnoGravable(form.getAnoGravable());
		request.setNumBP(customerData.getNumBP());
		if (customerData.getReteIcaTax() != null)
		{
			request.setNumObjeto(customerData.getReteIcaTax().getObjectNumber());
		}
		final ReteIcaResponse response = sdhReteIcaFacade.reteICAMock(request);

		model.addAttribute("archivosTRM", response.getArchivosTRM());

		storeCmsPageInModel(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_CARGAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_CARGAS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

}

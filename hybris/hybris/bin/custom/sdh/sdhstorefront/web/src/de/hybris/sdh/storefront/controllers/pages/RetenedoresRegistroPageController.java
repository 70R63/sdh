/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.sdh.facades.SDHReteIcaFacade;
import de.hybris.sdh.storefront.controllers.pages.forms.RetencionesForm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class RetenedoresRegistroPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Registro de Retenciones";

	// CMS Pages
	private static final String AGENTES_RETENEDORES_REGISTRO_CMS_PAGE = "retenedoresRegistroPage";

	private static final String REDIRECT_TO_AGENTES_RETENEDORES_REGISTRO_PAGE = REDIRECT_PREFIX
			+ "/retenedores/registroretenciones";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhReteIcaFacade")
	SDHReteIcaFacade sdhReteIcaFacade;

	@RequestMapping(value = "/retenedores/registroretenciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String retenedoresregistro(final Model model) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_REGISTRO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_REGISTRO_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/retenedores/registroretenciones", method = RequestMethod.POST)
	@ResponseBody
	@RequireHardLogIn
	public RetencionesForm retenedoresregistropost(final @RequestPart("retencionesForm") RetencionesForm retencionesForm,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes, @RequestPart("retencionesFile")
			final MultipartFile retencionesFile)
			throws CMSItemNotFoundException
	{

		sdhReteIcaFacade.sendFile(retencionesFile);

		return retencionesForm;
	}

}

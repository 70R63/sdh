/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.dao.SdhDocumentTypeDao;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.TercerosAutForm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
//@RequestMapping("")
public class TercerosSIMBuscarPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Terceros Autorizados SIM";

	// CMS Pages
	private static final String TERCEROS_AUTORIZADOS_SIM_CMS_PAGE = "tercerosSIMBuscarPage";

	private static final String REDIRECT_TO_TERCEROS_AUTORIZADOS_SIM_PAGE = REDIRECT_PREFIX + "/terceros/sim/buscar";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhDocumentTypeDao")
	SdhDocumentTypeDao sdhDocumentTypeDao;


	@ModelAttribute("documentTypes")
	public List<de.hybris.sdh.core.form.SelectAtomValue> getDocumentTypes()
	{
		return sdhDocumentTypeDao.getAllDocumentTypes();
	}


	@RequestMapping(value = "/terceros/objeto", method = RequestMethod.GET)
	@RequireHardLogIn
	public String tercerossim(@ModelAttribute("tercerosAutForm") TercerosAutForm tercerosAutForm, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET terceros Autorizados SIM--------------------------");

		if (tercerosAutForm == null)
		{
			tercerosAutForm = new TercerosAutForm();
		}

		model.addAttribute("tercerosAutForm", tercerosAutForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(TERCEROS_AUTORIZADOS_SIM_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TERCEROS_AUTORIZADOS_SIM_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/terceros/objeto", method = RequestMethod.POST)
	@RequireHardLogIn
	public String tercerossimpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de terceros Autorizados SIM------------------------");

		return REDIRECT_TO_TERCEROS_AUTORIZADOS_SIM_PAGE;
	}

}
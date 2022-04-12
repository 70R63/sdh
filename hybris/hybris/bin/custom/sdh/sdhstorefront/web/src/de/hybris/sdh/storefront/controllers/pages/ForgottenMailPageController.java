/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.dao.SdhDocumentTypeDao;
import de.hybris.sdh.core.dao.impl.DefaultSdhCustomerDao;
import de.hybris.sdh.storefront.forms.ForgottenMailForm;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
public class ForgottenMailPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(ForgottenMailPageController.class);

	// CMS Pages
	private static final String MAIL_CMS_PAGE = "forgottenMailPage";
	private static final String REDIRECT_TO_MAIL_PAGE = REDIRECT_PREFIX + "/login/recuperacorreo";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCustomerDao")
	DefaultSdhCustomerDao sdhCustomerDao;

	@Resource(name = "sdhDocumentTypeDao")
	SdhDocumentTypeDao sdhDocumentTypeDao;

	@ModelAttribute("documentTypes")
	public List<de.hybris.sdh.core.form.SelectAtomValue> getDocumentTypes()
	{
		return sdhDocumentTypeDao.getAllDocumentTypes();
	}

	@RequestMapping(value = "/login/recuperacorreo", method = RequestMethod.GET)
	public String forgotMail(final ForgottenMailForm forgottenMailForm, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- Controller Forgotten Mail--------------------------");

		model.addAttribute("forgottenMailForm", forgottenMailForm);
		storeCmsPageInModel(model, getContentPageForLabelOrId(MAIL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MAIL_CMS_PAGE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/login/recuperacorreo", method = RequestMethod.POST)
	public String forgotMailPost(final ForgottenMailForm forgottenMailForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de Forgotten Mail------------------------");

		final Optional<de.hybris.platform.core.model.user.CustomerModel> user = sdhCustomerDao
				.findByDocTypeNumDoc(forgottenMailForm.getDocype(), forgottenMailForm.getDocNumber());
		if (user.isPresent())
		{
			final de.hybris.platform.core.model.user.CustomerModel currentCustomerModel = user.get();
			forgottenMailForm.setMail(currentCustomerModel.getUid());

			final String mensaje = "¡Correo encontrado! " + currentCustomerModel.getUid();

			LOG.info(mensaje);

			redirectAttributes.addFlashAttribute("mensaje", mensaje);
		}
		else
		{
			forgottenMailForm.setMail("Correo no encontrado");
			redirectAttributes.addFlashAttribute("mensaje", "Correo no encontrado");
		}

		model.addAttribute("forgottenMailForm", forgottenMailForm);

		return REDIRECT_TO_MAIL_PAGE;
	}
}

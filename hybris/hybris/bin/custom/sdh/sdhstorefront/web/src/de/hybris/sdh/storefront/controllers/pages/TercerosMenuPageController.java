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
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.dao.SdhDocumentTypeDao;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.facades.questions.data.SDHRolData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;
import de.hybris.sdh.storefront.forms.TercerosAutForm;

import java.util.Arrays;
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
public class TercerosMenuPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(TercerosMenuPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "AgentesTerceros Autorizados";

	// CMS Pages
	private static final String TERCEROS_AUTORIZADOS_CMS_PAGE = "tercerosMenuPage";

	private static final String REDIRECT_TO_TERCEROS_AUTORIZADOS_PAGE = REDIRECT_PREFIX + "/terceros";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sdhDocumentTypeDao")
	SdhDocumentTypeDao sdhDocumentTypeDao;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@ModelAttribute("documentTypes")
	public List<de.hybris.sdh.core.form.SelectAtomValue> getDocumentTypes()
	{
		return sdhDocumentTypeDao.getAllDocumentTypes();
	}

	@ModelAttribute("impuestos")
	public List<SelectAtomValue> getImpuestos()
	{
		final List<SelectAtomValue> tipoDeImpuesto = Arrays.asList(new SelectAtomValue("0001", "Predial"),
				new SelectAtomValue("0002", "Vehiculos"), new SelectAtomValue("0003", "ICA"),
				new SelectAtomValue("0004", "Retencion ICA"), new SelectAtomValue("0005", "Sobretasa A La Gasolina"),
				new SelectAtomValue("0006", "Delineacion Urbana"), new SelectAtomValue("0007", "Publicidad Exterior"));
		return tipoDeImpuesto;
	}

	@RequestMapping(value = "/terceros", method = RequestMethod.GET)
	@RequireHardLogIn
	public String tercerosmenu(@ModelAttribute("tercerosAutForm") TercerosAutForm tercerosAutForm, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En GET terceros Autorizados --------------------------");

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		String subrol = null;
		if (tercerosAutForm == null)
		{
			tercerosAutForm = new TercerosAutForm();
		}

		for (final SDHRolData rol : customerData.getRolList())
		{
			if (rol.getRol() != null && rol.getRol().startsWith("03"))
			{
				subrol = rol.getRol();
				break;
			}
		}

		tercerosAutForm.setListaImpuestos(gasolinaService.obtenerListaImpuesto(subrol));
		tercerosAutForm.setSubrol(subrol);

		model.addAttribute("tercerosAutForm", tercerosAutForm);


		storeCmsPageInModel(model, getContentPageForLabelOrId(TERCEROS_AUTORIZADOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TERCEROS_AUTORIZADOS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/terceros", method = RequestMethod.POST)
	@RequireHardLogIn
	public String tercerosmenupost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de terceros Autorizados------------------------");

		return REDIRECT_TO_TERCEROS_AUTORIZADOS_PAGE;
	}

}

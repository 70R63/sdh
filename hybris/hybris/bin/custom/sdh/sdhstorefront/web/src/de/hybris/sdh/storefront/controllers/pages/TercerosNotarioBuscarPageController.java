/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.dao.SdhDocumentTypeDao;
import de.hybris.sdh.core.pojos.requests.TercerosAutRequest;
import de.hybris.sdh.core.pojos.responses.TercerosAutResponse;
import de.hybris.sdh.core.services.SDHTercerosAutService;
import de.hybris.sdh.facades.questions.data.SDHRolData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;
import de.hybris.sdh.storefront.forms.TercerosAutForm;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
//@RequestMapping("")
public class TercerosNotarioBuscarPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Terceros Autorizados Notario";
	private static final String TERCEROS_AUTORIZADOS_NOTARIO_CMS_PAGE = "tercerosNotarisBuscarPage";
	private static final String TERCEROS_AUTORIZADOS_REDIRECT = "/terceros/notarios/buscar";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhTercerosAutService")
	SDHTercerosAutService sdhTercerosAutService;

	@Resource(name = "sdhDocumentTypeDao")
	SdhDocumentTypeDao sdhDocumentTypeDao;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "messageSource")
	MessageSource messageSource;

	@Resource(name = "i18nService")
	I18NService i18nService;


	@ModelAttribute("documentTypes")
	public List<de.hybris.sdh.core.form.SelectAtomValue> getDocumentTypes()
	{return sdhDocumentTypeDao.getAllDocumentTypes();}

	@ModelAttribute("impuestos")
	public List<SelectAtomValue> getImpuestos()
	{
		final List<SelectAtomValue> tipoDeImpuesto = Arrays.asList(
				new SelectAtomValue("0001", "Predial"),
				new SelectAtomValue("0002", "Vehiculos"),
				new SelectAtomValue("0003", "ICA"),
				new SelectAtomValue("0004", "Retencion ICA"),
				new SelectAtomValue("0005", "Sobretasa A La Gasolina"),
				new SelectAtomValue("0006", "Delineacion Urbana"),
				new SelectAtomValue("0007", "Publicidad Exterior"));
		return tipoDeImpuesto;
	}

	@RequestMapping(value = "/terceros/sujeto", method = RequestMethod.GET)
	@RequireHardLogIn
	public String tercerosnotarios(final Model model) throws CMSItemNotFoundException
	{
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		String subrol = null;
		final TercerosAutForm tercerosAutForm = new TercerosAutForm();

		for (final SDHRolData rol : customerData.getRolList())
		{
			if (rol.getRol() != null && rol.getRol().startsWith("03"))
			{
				subrol = rol.getRol();
				break;
			}
		}
		if(subrol == null) {
			//			notaria.subrol=03_03
					subrol = messageSource.getMessage("notaria.subrol", null, i18nService.getCurrentLocale());
		}

		tercerosAutForm.setListaImpuestos(gasolinaService.obtenerListaImpuesto(subrol));

		storeCmsPageInModel(model, getContentPageForLabelOrId(TERCEROS_AUTORIZADOS_NOTARIO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TERCEROS_AUTORIZADOS_NOTARIO_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("tercerosAutForm", tercerosAutForm);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/terceros/sujeto", method = RequestMethod.POST)
	@RequireHardLogIn
	public String tercerosnotariopost(final Model model, final RedirectAttributes redirectAttributes,
			@ModelAttribute("tercerosAutForm") final TercerosAutForm tercerosAutForm) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(TERCEROS_AUTORIZADOS_NOTARIO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TERCEROS_AUTORIZADOS_NOTARIO_CMS_PAGE));
		TercerosAutResponse responseData = null;

		try {
			responseData = sdhTercerosAutService.getTercerosAut(
					new TercerosAutRequest(tercerosAutForm.getTipdoc(), tercerosAutForm.getImpuesto(),
							tercerosAutForm.getNumdoc(), "AAA0102XAUZ"));

			if(!StringUtils.isEmpty(responseData.getErrores().get(0).getId_msj())){
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"sdh.standard.global.message", new Object[]
					{responseData.getErrores().get(0).getTxt_msj()});
			}
		} catch (final Exception e) {
			LOG.error("Network connection error : " + e.getMessage());
		}

		redirectAttributes.addFlashAttribute("tercerosAutTable",responseData);
		redirectAttributes.addFlashAttribute("tercerosAutForm", tercerosAutForm);
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return REDIRECT_PREFIX + TERCEROS_AUTORIZADOS_REDIRECT;
	}

}

/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.facades.SDHFAQsFacade;
import de.hybris.sdh.facades.faqs.data.SDHFaqCategoryData;
import de.hybris.sdh.facades.faqs.data.SDHFaqData;
import de.hybris.sdh.storefront.forms.PreguntasFrecuentesForm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Maria Luisa
 *
 */
@Controller
public class PreguntasFrecuentesController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.preguntasfre";

	// CMS Pages
	private static final String PREGUNTAS_CMS_PAGE = "pregFrecuentesPage";

	private static final String REDIRECT_TO_PREGUNTAS_PAGE = REDIRECT_PREFIX + "/preguntasfrecuentes";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhFAQsFacade")
	SDHFAQsFacade sdhFAQsFacade;

	@ModelAttribute("sdhFAQsCategories")
	public List<SDHFaqCategoryData> getFaqsCategories(){
		return sdhFAQsFacade.getAllCategories();
	}

	@RequestMapping(value =
	{ "/preguntasfrecuentes" }, method = RequestMethod.GET)
	public String preguntasinicial(final Model model, final HttpServletRequest request,
			@RequestParam(required = false, value = "categoryId")
			final String categoryId, @RequestParam(required = false, value = "keyWord")
			final String keyWord) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET preguntas frecuentes --------------------------");

		final ObjectMapper mapper = new ObjectMapper();
		final PreguntasFrecuentesForm preguntasForm = new PreguntasFrecuentesForm();

		final Date date = new Date();

		//Caso 2: obtener la fecha y salida por pantalla con formato:
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Fecha: " + dateFormat.format(date));


		final String fecha = dateFormat.format(date);

		preguntasForm.setFecha(fecha);

		List<SDHFaqData> faqDataList = new ArrayList<>();

		if (categoryId != null)
		{
			faqDataList = sdhFAQsFacade.getAllFaqsByCategoryCode(categoryId);

		}

		if (keyWord != null)
		{
			faqDataList = sdhFAQsFacade.getAllFaqsByKeyWord(keyWord);
		}

		model.addAttribute("faqDataList", faqDataList);

		model.addAttribute("preguntasForm", preguntasForm);

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


		storeCmsPageInModel(model, getContentPageForLabelOrId(PREGUNTAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREGUNTAS_CMS_PAGE));

		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

}

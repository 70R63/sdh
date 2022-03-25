/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHRelacionPagosService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.RetencionesPracticadasForm;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
public class RetencionesPracticadasPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(RetencionesPracticadasPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.relapagos";
	private static final String BREADCRUMBS_VALUE_RETE = "text.account.profile.arRelapagos";

	// CMS Pages
	private static final String RETENCIONES_PRACTICADAS_CMS_PAGE = "retencionesPracticadasPage";

	private static final String REDIRECT_TO_RELACION_PAGOS_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/consultas/retencionespracticadas";

	private static Map<String, String> anios = null;
	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

	@Resource(name = "sdhRelacionPagosService")
	SDHRelacionPagosService sdhRelacionPagosService;

	@Resource(name = "sdhCustomerAccountService")
	SDHCustomerAccountService sdhCustomerAccountService;



	@RequestMapping(value =
	{ "/contribuyentes/consultas/retencionespracticadas",
			"/agenteRetenedor/consultas/retencionespracticadas" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String relapag(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Retenciones Practicadas--------------------------");
		final StringBuffer requestURL = request.getRequestURL();
		final String url2 = String.valueOf(requestURL);

		RetencionesPracticadasForm retencionesPracticadasForm = new RetencionesPracticadasForm();
		try
		{
			final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
			retencionesPracticadasForm.setAnioGravable(obtainAnios());

			model.addAttribute("retencionesPracticadasForm", retencionesPracticadasForm);
		}
		catch (final Exception e)
		{
			LOG.error("Error getting customer info from SAP for RelacionPagosPage: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(RETENCIONES_PRACTICADAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RETENCIONES_PRACTICADAS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		if (url2.contains("contribuyentes"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}
		else if (url2.contains("agenteRetenedor"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_RETE));
			model.addAttribute("Retenedor", "Retenedor");
		}
		return getViewForPage(model);
	}

	private Map<String, String> obtainAnios()
	{
		//		Date dt = new Date();
		//		int year = dt.getYear();
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		Map<String, String> elementos = null;
		elementos = new LinkedHashMap<String, String>();

		for (int i = 0; i < 5; i++)
		{
			elementos.put(Integer.toString(year), Integer.toString(year));
			year = year - 1;
			System.out.println(year);
		}

		return elementos;
	}

}


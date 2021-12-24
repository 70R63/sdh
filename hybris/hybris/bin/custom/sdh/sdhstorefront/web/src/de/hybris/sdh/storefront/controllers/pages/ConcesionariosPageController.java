/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.dao.SdhReferenceStatusDao;
import de.hybris.sdh.core.pojos.requests.ConcesionariosRequest;
import de.hybris.sdh.core.pojos.responses.Concesionarios;
import de.hybris.sdh.core.pojos.responses.ConcesionariosResponse;
import de.hybris.sdh.core.services.SDHConcesionariosService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.ConcesionariosForm;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



/**
 * @author Maria Luisa
 *
 */
//@SessionAttributes("dataForm")
@Controller
public class ConcesionariosPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(ConcesionariosPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.concesionarios";
	private static final String BREADCRUMB_CONCESIONARIOS = "breadcrumb.concesionarios";


	// CMS Pages
	private static final String CONCESIONARIOS_CMS_PAGE = "concesionariosPage";
	private static final String ANIO = "20";

	private static final String REDIRECT_TO_MI_BUZON_PAGE = REDIRECT_PREFIX + "/contribuyentes/mibuzon_tributario";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "modelService")
	ModelService modelService;

	@Resource(name = "mediaService")
	MediaService mediaService;

	@Resource(name = "sdhReferenceStatusDao")
	SdhReferenceStatusDao sdhReferenceStatusDao;

	@Resource(name = "sdhConcesionariosService")
	SDHConcesionariosService sdhConcesionariosService;
	
	@Resource(name = "sessionService")
	SessionService sessionService;


	@ModelAttribute("referenceStatus")
	public List<de.hybris.sdh.core.form.SelectAtomValue> getReferenceStatus()
	{
		return sdhReferenceStatusDao.getAllReferenceStatus();
	}


	@RequestMapping(value =
	{ "/concesionarios" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String concesionarios(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("----------------Initial Controller Concesionarios --------------------------");

		model.addAttribute("concesionarios", new ConcesionariosForm());
		storeCmsPageInModel(model, getContentPageForLabelOrId(CONCESIONARIOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONCESIONARIOS_CMS_PAGE));

		model.addAttribute("fecInio", "DD/MM/YYYY");
		model.addAttribute("concesionarios", new ConcesionariosForm());
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMB_CONCESIONARIOS));


		return getViewForPage(model);
	}

	
	@RequestMapping(value = "/concesionarios/listado", method = RequestMethod.GET)
	@RequireHardLogIn
	@ResponseBody
	public List<Concesionarios> obtenerListado(@ModelAttribute("dataForm")
	final ConcesionariosForm concesionarios, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		LOG.info("En listado de concesionarios");
		List<Concesionarios> listado = null;
		
		String ernam = sessionService.getCurrentSession().getAttribute("concesionarios_ernam");
//		ernam = "JORTIZ";

		final ConcesionariosRequest concesionariosRequest = new ConcesionariosRequest();
		concesionariosRequest.seteRNAM(ernam);
		if(concesionarios != null) {
			concesionariosRequest.setaUGUST(concesionarios.getReferenceStatus());
			if(concesionarios.getFecInio() != null ) {
   	      DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   	      DateTimeFormatter formatterO = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   	      try {
   	      concesionariosRequest.setbUDAT(LocalDate.parse(concesionarios.getFecInio(), formatterO).format(formatterD));
   	      }
   	      catch (DateTimeParseException e) {
					// XXX: handle exception
				}
			}
		}


		final ConcesionariosResponse concesionariosResponse = sdhConcesionariosService.concesionario(concesionariosRequest);

		if (concesionariosResponse != null)
		{
			listado = concesionariosResponse.getConcesionarios();
		}


		return listado;
	}

	public String obtainVigencia(final String vigencia)
	{
		String vig = vigencia.substring(0, 2);
		vig = ANIO + vig;

		return vig;
	}

	public String obtainVencimiento(final String venci) throws ParseException
	{
		final String anio = venci.substring(0, 4);
		final String mes = venci.substring(4, 6);
		final String dia = venci.substring(6, 8);
		final String fecha = dia + "/" + mes + "/" + anio;

		return fecha;
	}
}

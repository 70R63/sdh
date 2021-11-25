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




	@RequestMapping(value = "/concesionarios", method = RequestMethod.POST)
	@RequireHardLogIn
	public String delineacionUrbanaPOST(@ModelAttribute("dataForm")
	final ConcesionariosForm concesionarios, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		LOG.info("Estoy dentro de POST de concesionarios");

		final ConcesionariosRequest concesionariosRequest = new ConcesionariosRequest();
		concesionariosRequest.setaUGUST("");
		concesionariosRequest.setbUDAT("17/11/2021");
		concesionariosRequest.seteRNAM("GMERLIN");
		final List<Concesionarios> concesionariosForForm = new ArrayList<Concesionarios>();

		try
		{

			final ConcesionariosResponse concesionariosResponse = sdhConcesionariosService.concesionario(concesionariosRequest);
			LOG.info("RESPONSE: " + concesionariosResponse);

			if (concesionariosResponse != null)
			{
				for (final Concesionarios conce : concesionariosResponse.getConcesionarios())
				{
					final Concesionarios conceForm = new Concesionarios();
					conceForm.setBetrw(conce.getBetrw()); // importe a pagar
					conceForm.setPsobtxt(conce.getPsobtxt()); //placa
					conceForm.setXblnr(conce.getXblnr()); // Referencia
					conceForm.setPersl(obtainVigencia(conce.getPersl())); //Vigencia
					conceForm.setFaedn(obtainVencimiento(conce.getFaedn()));
					concesionariosForForm.add(conceForm);
				}
				concesionarios.setConcesionarios(concesionariosForForm);
			}
		}
		catch (final Exception s)
		{
			LOG.error("error on concesionarios service: " + s.getMessage());
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(CONCESIONARIOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONCESIONARIOS_CMS_PAGE));

		model.addAttribute("fecInio", concesionarios.getFecInio());
		model.addAttribute("dataForm", concesionarios);
		model.addAttribute("concesionarios", concesionarios);

		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMB_CONCESIONARIOS));


		return getViewForPage(model);
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

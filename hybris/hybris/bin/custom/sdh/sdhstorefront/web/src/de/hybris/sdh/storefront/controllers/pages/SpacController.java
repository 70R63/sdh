/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.SpacPDFRequest;
import de.hybris.sdh.core.pojos.requests.SpacRequest;
import de.hybris.sdh.core.pojos.responses.SpacPDFResponse;
import de.hybris.sdh.core.pojos.responses.SpacResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHSpacPDFService;
import de.hybris.sdh.core.services.SDHSpacService;
import de.hybris.sdh.storefront.forms.SpacForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Maria Luisa
 *
 */
@Controller
public class SpacController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(SpacController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.buzon";
	private static final String TEXT_ACCOUNT_PROFILE_RETE = "text.account.profile.buzonRETE";

	// CMS Pages
	private static final String SPAC_CMS_PAGE = "buzonPage";

	private static final String REDIRECT_TO_MI_BUZON_PAGE = REDIRECT_PREFIX + "/contribuyentes/mibuzon_tributario";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhSpacService")
	SDHSpacService sdhSpacService;

	@Resource(name = "sdhSpacPDFService")
	SDHSpacPDFService sdhSpacPDFService;

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


	@RequestMapping(value =
	{ "/contribuyentes/spac", "/agenteRetenedor/spac" }, method = RequestMethod.GET)
	@ResponseBody
	public SpacForm spac(@RequestParam(value = "reimpresion", defaultValue = "")
	final String reimpresion, @RequestParam(value = "anio", defaultValue = "")
	final String anio, @RequestParam(value = "numform", defaultValue = "")
	final String numform, @RequestParam(value = "numobj", defaultValue = "")
	final String numobj, @RequestParam(value = "numbp", defaultValue = "")
	final String numbp, @RequestParam(value = "tspac", defaultValue = "")
	final String tspac, final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET SPAC --------------------------");

		final String referrer = request.getHeader("referer");

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SpacRequest spacrequest = new SpacRequest();

		final SpacForm spacform = new SpacForm();
		if (numbp == null || numbp.isEmpty())
		{
			spacrequest.setNumBP(customerModel.getNumBP());
		}
		else
		{
			spacrequest.setNumBP(numbp);
		}

		spacrequest.setAnoGravable(anio);
		spacrequest.setObjetoContrato(numobj);
		spacrequest.setReimpresion(reimpresion);
		spacrequest.setNum_form(numform);
		spacrequest.setTspac(tspac);
		try
		{


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			String response = sdhSpacService.spacRequest(spacrequest);
			response = response.replaceAll("(\"cuotas_Spac\":)(\\{)(.*)(\"\\})", "$1[{$3\"}]");

			final SpacResponse spacresponse = mapper.readValue(response, SpacResponse.class);


			spacform.setCuotas_Spac(spacresponse.getCuotas_Spac());
			spacform.setErrores(spacresponse.getErrores());


		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());
		}

		model.addAttribute("spacform", spacform);

		return spacform;
	}

	@RequestMapping(value =
	{ "/contribuyentes/spac/PDF", "/agenteRetenedor/spac" }, method = RequestMethod.GET)
	@ResponseBody
	public SpacForm spacPDF(@RequestParam(value = "anio", defaultValue = "")
	final String anio, @RequestParam(value = "numform", defaultValue = "")
	final String numform, @RequestParam(value = "numobj", defaultValue = "")
	final String numobj, @RequestParam(value = "numbp", defaultValue = "")
	final String numbp, final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET SPAC PDF--------------------------");

		final String referrer = request.getHeader("referer");

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SpacPDFRequest spacpdfrequest = new SpacPDFRequest();

		final SpacForm spacform = new SpacForm();
		if (numbp == null || numbp.isEmpty())
		{
			spacpdfrequest.setNumBP(customerModel.getNumBP());
		}
		else
		{
			spacpdfrequest.setNumBP(numbp);
		}

		spacpdfrequest.setAnoGravable(anio);
		spacpdfrequest.setObjetoContrato(numobj);
		spacpdfrequest.setNum_form(numform);

		//		spacpdfrequest.setNumBP("1234");
		//		spacpdfrequest.setAnoGravable("2020");
		//		spacpdfrequest.setObjetoContrato("1");
		//		spacpdfrequest.setNum_form("1");
		try
		{


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final String response = sdhSpacPDFService.spacPDFRequest(spacpdfrequest);

			final SpacPDFResponse spacpdfresponse = mapper.readValue(response, SpacPDFResponse.class);


			spacform.setPdf(spacpdfresponse.getPdf());
			spacform.setErrores(spacpdfresponse.getErrores());


		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for ICA details page: " + e.getMessage());
		}

		model.addAttribute("spacform", spacform);


		return spacform;
	}

}

/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ReteIcaResponse;
import de.hybris.sdh.facades.SDHReteIcaFacade;
import de.hybris.sdh.storefront.controllers.pages.forms.RetencionesForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	private static final String RETEICA_TAX_NUMBER = "04";

	// CMS Pages
	private static final String AGENTES_RETENEDORES_REGISTRO_CMS_PAGE = "retenedoresRegistroPage";

	private static final String REDIRECT_TO_AGENTES_RETENEDORES_REGISTRO_PAGE = REDIRECT_PREFIX
			+ "/retenedores/registroretenciones";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhReteIcaFacade")
	SDHReteIcaFacade sdhReteIcaFacade;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

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

	@ModelAttribute("perdiods")
	public List<String> getPeriods()
	{
		return Arrays.asList("01", "02", "03", "04", "05", "06");
	}

	@ModelAttribute("customerNIT")
	public String getNIT()
	{
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final String customerNit = StringUtils.leftPad(customerData.getDocumentNumber(), 11, "0");
		return customerNit;
	}

	@ModelAttribute("customerName")
	public String getCustomerName()
	{
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		return customerData.getCompleteName();
	}

	@ModelAttribute("years")
	public List<String> getYears()
	{
		return Arrays.asList("2019", "2018", "2017", "2016");
	}

	@ModelAttribute("reteIcaMaxFileSize")
	public String getReteIcaMaxFileSize()
	{
		return configurationService.getConfiguration().getString("sdh.reteica.file.max.upload.size.bytes", "10485760");
	}

	@RequestMapping(value = "/retenedores/registroretenciones", method = RequestMethod.POST)
	@ResponseBody
	@RequireHardLogIn
	public ReteIcaResponse retenedoresregistropost(final @RequestPart("retencionesForm") RetencionesForm retencionesForm,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes, @RequestPart("retencionesFile")
			final MultipartFile retencionesFile)
			throws CMSItemNotFoundException
	{

		final ReteIcaResponse response = new ReteIcaResponse();

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final String customerNit = StringUtils.leftPad(customerData.getDocumentNumber(), 11, "0");

		if (StringUtils.isBlank(retencionesForm.getAnoGravable()))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("Por favor selecciona el año Gravable");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);

			return response;

		}


		if (StringUtils.isBlank(retencionesForm.getPeriodo()))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("Por favor seleccion el periodo");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);

			return response;

		}

		if (!hasValidName(retencionesFile.getOriginalFilename(), retencionesForm.getAnoGravable(), retencionesForm.getPeriodo(),
				customerNit))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("Nombre de archivo no valido");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);

			return response;
		}


		if (!retencionesFile.getOriginalFilename().contains(".csv") && !retencionesFile.getOriginalFilename().contains(".CSV"))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("El archivo seleccionado no tiene la extensión especificada.");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);

			return response;
		}

		final Boolean fileSent = sdhReteIcaFacade.writeFile(retencionesFile);

		if (!Boolean.TRUE.equals(fileSent))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("El archivo no pudo ser procesado, intentelo mas tarde");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);

			return response;
		}

		return response;
	}

	Boolean hasValidName(final String fileName, final String anoGravable, final String periodo, final String nit)
	{

		if (fileName.substring(0, fileName.length() - 4).length() != 19)
		{
			return false;
		}


		if (!RETEICA_TAX_NUMBER.equals(fileName.substring(0, 2)))
		{
			return false;
		}

		if (!anoGravable.equals(fileName.substring(2, 6)))
		{
			return false;
		}

		if (!periodo.equals(fileName.substring(6, 8)))
		{
			return false;
		}

		if (!nit.equals(fileName.substring(8, 19)))
		{
			return false;
		}

		return true;
	}

}

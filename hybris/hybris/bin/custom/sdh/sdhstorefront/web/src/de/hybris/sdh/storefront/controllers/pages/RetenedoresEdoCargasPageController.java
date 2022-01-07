/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.LogReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaRequest;
import de.hybris.sdh.core.pojos.responses.LogReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.ReteIcaResponse;
import de.hybris.sdh.facades.SDHReteIcaFacade;
import de.hybris.sdh.storefront.controllers.pages.forms.EstadoCargasForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Decoder.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class RetenedoresEdoCargasPageController extends RetenedoresAbstractPageController

{
	private static final Logger LOG = Logger.getLogger(RetenedoresEdoCargasPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Estado de Cargas";

	// CMS Pages
	private static final String AGENTES_RETENEDORES_CARGAS_CMS_PAGE = "retenedoresEdoCargasPage";

	private static final String REDIRECT_TO_AGENTES_RETENEDORES_CARGAS_PAGE = REDIRECT_PREFIX + "/retenedores/estadocargas";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhReteIcaFacade")
	SDHReteIcaFacade sdhReteIcaFacade;

	@RequestMapping(value = "/retenedores/estadocargas", method = RequestMethod.GET)
	@RequireHardLogIn
	public String retenedorescargas(final Model model) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_CARGAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_CARGAS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/retenedores/estadocargas", method = RequestMethod.POST)
	@RequireHardLogIn
	public String retenedorescargaspost(final Model model, final EstadoCargasForm form)
			throws CMSItemNotFoundException
	{
		String objectNumber = null;
		model.addAttribute("form", form);

		final CustomerData customerData = getCustomerFacade().getCurrentCustomer();

		final ReteIcaRequest request = new ReteIcaRequest();
		request.setAnoGravable(form.getAnoGravable());
		request.setNumBP(customerData.getNumBP());
		if (customerData.getReteIcaTax() != null)
		{
			objectNumber = customerData.getReteIcaTax().getObjectNumber();
			request.setNumObjeto(objectNumber);
		}
		final ReteIcaResponse response = sdhReteIcaFacade.reteICA(request);

		model.addAttribute("archivosTRM", response.getArchivosTRM());
		model.addAttribute("estadoCargasFormData", form);
		model.addAttribute("objectNumber", objectNumber);

		storeCmsPageInModel(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_CARGAS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(AGENTES_RETENEDORES_CARGAS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/retenedores/download/log", method = RequestMethod.GET)
	public void download(final HttpServletResponse response, @RequestParam(required = true, value = "nomArchivo")
	final String nomArchivo)
	{
		final CustomerData customerData = getCustomerFacade().getCurrentCustomer();
		final LogReteIcaRequest request = new LogReteIcaRequest();


		request.setNumBP(customerData.getNumBP());
		request.setNomArchivo(nomArchivo);
		try
		{

			final LogReteIcaResponse logResponse = sdhReteIcaFacade.logReteICA(request);


			if (StringUtils.isNotBlank(logResponse.getStringPDF()))
			{
				final String encodedBytes = logResponse.getStringPDF();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);

				response.setContentType("text/plain");
				response.setHeader("Content-disposition", "attachment; filename=\"log.txt\"");

				final InputStream inputStream = new ByteArrayInputStream(decodedBytes);
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();

			}


		}
		catch (final IOException e)
		{
			LOG.error("Error getting log for: ");
		}
	}

}

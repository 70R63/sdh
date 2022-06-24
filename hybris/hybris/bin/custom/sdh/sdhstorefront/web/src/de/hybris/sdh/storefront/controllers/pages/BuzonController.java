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
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.BuzonTributarioRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.BuzonDocumentos;
import de.hybris.sdh.core.pojos.responses.BuzonMensajes2;
import de.hybris.sdh.core.pojos.responses.BuzonTributarioMsgResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHBuzonTributarioService;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.MiBuzon;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * @author Maria Luisa
 *
 */
@Controller
public class BuzonController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(BuzonController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.buzon";
	private static final String TEXT_ACCOUNT_PROFILE_RETE = "text.account.profile.buzonRETE";

	// CMS Pages
	private static final String MI_BUZON_CMS_PAGE = "buzonPage";

	private static final String REDIRECT_TO_MI_BUZON_PAGE = REDIRECT_PREFIX + "/contribuyentes/mibuzon_tributario";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhBuzonTributarioService")
	SDHBuzonTributarioService sdhBuzonTributarioService;

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
	{ "/contribuyentes/mibuzon_tributario", "/agenteRetenedor/mibuzon_tributario" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String buzoninicizl(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET mi buzon inicial --------------------------");

		final String referrer = request.getHeader("referer");

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final MiBuzon miBuzon = new MiBuzon();
		final BuzonTributarioRequest buzonrequest = new BuzonTributarioRequest();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

		final Calendar fecha = new GregorianCalendar();
		final int anio = fecha.get(Calendar.YEAR);
		//	int mes = fecha.get(Calendar.MONTH);
		//	int dia = fecha.get(Calendar.DAY_OF_MONTH);
		//	int hora = fecha.get(Calendar.HOUR_OF_DAY);
		//	int minuto = fecha.get(Calendar.MINUTE);
		//	int segundo = fecha.get(Calendar.SECOND);

		final String anioact = Integer.toString(anio);
		miBuzon.setNumBP(customerModel.getNumBP());
		buzonrequest.setNumBP(customerModel.getNumBP());
		buzonrequest.setVigencia(anioact);
		buzonrequest.setCheckLectura("x");
		buzonrequest.setIdDocumento("");
		buzonrequest.setIdRadicado("");

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


		try
		{
			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = sdhConsultaContribuyenteBPService
					.consultaContribuyenteBP_simplificado(consultaContribuyenteBPRequest);

			final BuzonTributarioMsgResponse buzonTributarioMsgResponse = mapper
					.readValue(sdhBuzonTributarioService.buzonTributarioRequest(buzonrequest), BuzonTributarioMsgResponse.class);


			miBuzon.setMensajesMsg(buzonTributarioMsgResponse.getMensajes());
			final int Buzon = sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOBUZONE();

			miBuzon.setBuzActivo(Buzon);


			int Mi = 1;
			int Ni = 1;

			for (final BuzonMensajes2 eachTipMensaje : buzonTributarioMsgResponse.getMensajes())
			{
				if ("2".equals(eachTipMensaje.getTipoMensaje()))
				{
					miBuzon.setContMsj(Mi);
					Mi++;
				}
				else if ("1".equals(eachTipMensaje.getTipoMensaje()))
				{
					miBuzon.setContNot(Ni);
					Ni++;
				}
			}

			model.addAttribute("miBuzon", miBuzon);

		}
		catch (final Exception s)
		{

			LOG.error("error getting customer info from SAP for rit page: " + s.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			model.addAttribute("miBuzon", miBuzon);
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(MI_BUZON_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MI_BUZON_CMS_PAGE));


		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		if (referrer.contains("contribuyentes"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}
		else if (referrer.contains("retenedor") || referrer.contains("agenteRetenedor"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE_RETE));
		}
		else
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}


		return getViewForPage(model);
	}

	@RequestMapping(value =
	{ "/contribuyentes/mibuzon_tributario/descarga", "/agenteRetenedor/mibuzon_tributario/descarga" }, method = RequestMethod.GET)
	@RequireHardLogIn
	@ResponseBody
	public String buzonDescargaPDF(final MiBuzon miBuzon, final HttpServletResponse response, final HttpServletRequest request)
			throws CMSItemNotFoundException, JsonMappingException, JsonProcessingException
	{
		System.out.println("------------------Entro al POST de mi buzon inicial------------------------");

		final BuzonTributarioRequest buzonrequest = new BuzonTributarioRequest();

		final Calendar fecha = new GregorianCalendar();
		final int anio = fecha.get(Calendar.YEAR);

		final String anioact = Integer.toString(anio);
		String pdf = "";
		buzonrequest.setNumBP(miBuzon.getNumBP());
		buzonrequest.setVigencia(anioact);
		buzonrequest.setCheckLectura("x");
		buzonrequest.setIdRadicado(miBuzon.getIdRadicado());
		buzonrequest.setIdDocumento(miBuzon.getIdDocumento());

		LOG.info("BuzonTributarioRequest: " + buzonrequest);
		//		final ObjectMapper mapper = new ObjectMapper();
		//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		try
		{

			final BuzonTributarioMsgResponse buzonTributarioMsgResponse = mapper
					.readValue(sdhBuzonTributarioService.buzonTributarioRequest(buzonrequest), BuzonTributarioMsgResponse.class);

			for (final BuzonMensajes2 mensaje : buzonTributarioMsgResponse.getMensajes())
			{
				if (mensaje.getId_radicado().equals(miBuzon.getIdRadicado()))
				{
					for (final BuzonDocumentos documentos : mensaje.getDocumentos())
					{
						if (!documentos.getPdf().isEmpty())
						{
							pdf = documentos.getPdf();
						}
					}
				}

			}
		}
		catch (final Exception s)
		{

			LOG.error("error getting customer info from SAP for rit page: " + s.getMessage());

		}

		final String referrer = request.getHeader("referer");

		return pdf;
	}
}

/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.RopRequest;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.RopResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHRopService;
import de.hybris.sdh.storefront.forms.RopForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class RopPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Generar ROP";

	// CMS Pages
	private static final String ROP_CMS_PAGE = "ropPage";

	private static final String REDIRECT_TO_ROP_PAGE = REDIRECT_PREFIX + "/contribuyentes/rop";

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhRopService")
	SDHRopService sdhRopService;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@RequestMapping(value = "/contribuyentes/rop")
	@RequireHardLogIn
	public String rop(final Model model, @ModelAttribute("error")
	final String error, @ModelAttribute("ropFormRequest")
	final RopForm ropFormRequest, @RequestParam(value = "obligacion", required = false)
	final String obligacion, @RequestParam(value = "totalPagar", required = false)
	final String totalPagar, @RequestParam(value = "objCont", required = false)
	final String objCont, @RequestParam(value = "clvPer", required = false)
	final String clvPer, @RequestParam(value = "tpImp", required = false)
	final String tpImp) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Generar ROP -------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final String returnURL = "/";

		final RopForm ropForm = new RopForm();
		final RopRequest ropRequest = new RopRequest();

		if (error == "sinPdf")
		{
			GlobalMessages.addErrorMessage(model, "mirit.certificacion..error.pdfVacio");
		}
		ropFormRequest.setTipoImp(tpImp);
		ropFormRequest.setClavePeriodo(clvPer);
		ropFormRequest.setNumObjeto(objCont);
		ropFormRequest.setNumBP(customerModel.getNumBP());

		storeCmsPageInModel(model, getContentPageForLabelOrId(ROP_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ROP_CMS_PAGE));
		model.addAttribute("ropForm", ropForm);
		model.addAttribute("ropFormResquest", ropFormRequest);
		model.addAttribute("obligacion", obligacion);
		model.addAttribute("totalPagar", totalPagar);
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));

		return getViewForPage(model);

		//		return returnURL;
	}

	@RequestMapping(value = "/contribuyentes/rop", method = RequestMethod.POST)
	@ResponseBody
	@RequireHardLogIn
	public GeneraDeclaracionResponse roppost(final Model model, final RedirectAttributes redirectModel,
			@ModelAttribute("ropForm")
			final RopForm ropForm) throws CMSItemNotFoundException
	{

		final GeneraDeclaracionResponse generaDeclaracionResponse = new GeneraDeclaracionResponse();


		System.out.println("------------------Entro al POST de Agentes Generar ROP----------------------");
		final String returnURL = "/";
		final RopRequest ropRequest = new RopRequest();

		ropRequest.setTipoImp(ropForm.getTipoImp());
		ropRequest.setNumBP(ropForm.getNumBP());
		ropRequest.setNumObjeto(ropForm.getNumObjeto());
		ropRequest.setClavePeriodo(ropForm.getClavePeriodo());
		ropRequest.setConsulta(ropForm.getConsulta());
		ropRequest.setImporteusuario(ropForm.getImporteusuario());

		//		System.out.println("Request de infObjeto/rop: " + ropRequest);
		//		System.out.println("Request de infObjeto/rop: [" + ropForm.getNumObjeto() +"]");
		try
		{
			final RopForm ropFormRequest = new RopForm();


			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final RopResponse ropResponse = mapper.readValue(sdhRopService.rop(ropRequest), RopResponse.class);
			//			System.out.println("Request de infObjeto/rop: " + ropResponse);
			generaDeclaracionResponse.setErrores(ropResponse.getErrores());

			if (ropResponse.getStringFact() != null)
			{
				final String encodedBytes = ropResponse.getStringFact();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = "ROP" + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE);
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				generaDeclaracionResponse.setUrlDownload(mediaModel.getDownloadURL());
			}
		}
		catch (final Exception e)
		{
			LOG.error("error generating ROP : " + e.getMessage());

			final ErrorPubli error = new ErrorPubli();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error al generar ROP, por favor intentalo más tarde");

			final List<ErrorPubli> errores = new ArrayList<ErrorPubli>();

			errores.add(error);

			generaDeclaracionResponse.setErrores(errores);


		}

		return generaDeclaracionResponse;
	}



}

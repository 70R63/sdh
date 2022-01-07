/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ReteIcaFileStatusInTRMRequest;
import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.ReteIcaValidaArchivoResponse;
import de.hybris.sdh.facades.SDHReteIcaFacade;
import de.hybris.sdh.storefront.controllers.pages.forms.RetencionesForm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class ReteICARegistroContribuyentePageController extends RetenedoresAbstractPageController
{
	private static final Logger LOG = Logger.getLogger(ReteICARegistroContribuyentePageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.registroretenciones";

	private static final String RETEICA_TAX_NUMBER = "04";

	// CMS Pages
	private static final String RETEICA_REGISTRO_CMS_PAGE = "contribuyentesRegistroPage";

	private static final String REDIRECT_TO_RETEICA_CONTRIBUYENTES_REGISTRO_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/registroretenciones";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhReteIcaFacade")
	SDHReteIcaFacade sdhReteIcaFacade;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@RequestMapping(value = "/contribuyentes/registroretenciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String retenedoresregistro(final Model model) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(RETEICA_REGISTRO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RETEICA_REGISTRO_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/registroretenciones", method = RequestMethod.POST)
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


		if (!retencionesFile.getOriginalFilename().contains(".txt") && !retencionesFile.getOriginalFilename().contains(".TXT"))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("El archivo seleccionado no tiene la extensión especificada.");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);

			return response;
		}

		final ReteIcaFileStatusInTRMRequest request = new ReteIcaFileStatusInTRMRequest();
		request.setAnoGravable(retencionesForm.getAnoGravable());
		request.setPeriodo(retencionesForm.getPeriodo());
		request.setNumBP(customerData.getNumBP());
		request.setFileName(retencionesFile.getOriginalFilename());
		if (customerData.getReteIcaTax() != null)
		{
			request.setNumObjeto(customerData.getReteIcaTax().getObjectNumber());
		}


		final String fileStatusInTRM = sdhReteIcaFacade.getFileStatusInTRM(request);

		if ("01".equalsIgnoreCase(fileStatusInTRM))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("Ya existe un archivo en proceso");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);

			LOG.info("el archivo " + retencionesFile.getOriginalFilename() + " en proceso");

			return response;
		}


		final Boolean fileSent = sdhReteIcaFacade.writeFile(retencionesFile, customerData.getNumBP(),
				request.getNumObjeto() != null ? request.getNumObjeto() : "");

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

	@RequestMapping(value = "/contribuyentes/registroretenciones/validaArchivo", method = RequestMethod.POST)
	@ResponseBody
	@RequireHardLogIn
	public ReteIcaValidaArchivoResponse validaArchivo(final RetencionesForm retencionesForm, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{

		final ReteIcaValidaArchivoResponse response = new ReteIcaValidaArchivoResponse();

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
			response.setAllowFileUpload(false);

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
			response.setAllowFileUpload(false);
			return response;

		}


		final ReteIcaFileStatusInTRMRequest request = new ReteIcaFileStatusInTRMRequest();
		request.setAnoGravable(retencionesForm.getAnoGravable());
		if ("01".equalsIgnoreCase(retencionesForm.getPeriodo()))
		{
			request.setPeriodo("B1");
		}
		else if ("02".equalsIgnoreCase(retencionesForm.getPeriodo()))
		{
			request.setPeriodo("B2");
		}
		else if ("03".equalsIgnoreCase(retencionesForm.getPeriodo()))
		{
			request.setPeriodo("B3");
		}
		else if ("04".equalsIgnoreCase(retencionesForm.getPeriodo()))
		{
			request.setPeriodo("B4");
		}
		else if ("05".equalsIgnoreCase(retencionesForm.getPeriodo()))
		{
			request.setPeriodo("B5");
		}
		else if ("06".equalsIgnoreCase(retencionesForm.getPeriodo()))
		{
			request.setPeriodo("B6");
		}
		request.setNumBP(customerData.getNumBP());
		request.setFileName(retencionesForm.getFileName());
		if (customerData.getReteIcaTax() != null)
		{
			request.setNumObjeto(customerData.getReteIcaTax().getObjectNumber());
		}


		final String fileStatusInTRM = sdhReteIcaFacade.getFileStatusInTRM(request);

		if ("-1".equalsIgnoreCase(fileStatusInTRM))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("Accion no permitida");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);
			response.setAllowFileUpload(false);
			return response;
		}
		else if ("00".equalsIgnoreCase(fileStatusInTRM))
		{
			response.setAllowFileUpload(true);
			response.setRequestCofirmation(false);
			LOG.info("el archivo " + retencionesForm.getFileName() + " primera carga");

			return response;
		}
		else if ("01".equalsIgnoreCase(fileStatusInTRM))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj("Ya existe un archivo en proceso");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);
			response.setAllowFileUpload(false);
			response.setRequestCofirmation(false);
			LOG.info("el archivo " + retencionesForm.getFileName() + " fue rechazado");

			return response;
		}
		else if ("02".equalsIgnoreCase(fileStatusInTRM))
		{
			response.setAllowFileUpload(true);
			response.setRequestCofirmation(false);
			LOG.info("el archivo " + retencionesForm.getFileName() + " permitido");

			return response;
		}
		else if ("03".equalsIgnoreCase(fileStatusInTRM))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj(
					"Se realizará una nueva carga del año y periodo indicado, la carga anterior que realizaste se sobre escribirá y quedará como final la nueva que se realice.");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);
			response.setRequestCofirmation(true);
			response.setAllowFileUpload(true);
			LOG.info("el archivo " + retencionesForm.getFileName() + " terminado");
			return response;
		}
		else if ("04".equalsIgnoreCase(fileStatusInTRM))
		{
			final ErrorEnWS error = new ErrorEnWS();
			error.setIdmsj("X");
			error.setTxtmsj(
					"Se realizara una nueva carga del año y periodo indicado. Con esta carga podrás generar una declaración pero será una corrección, ya que en el sistema ya se cuenta con una declaración presentada");

			final List<ErrorEnWS> errores = new ArrayList<ErrorEnWS>();
			errores.add(error);

			response.setErrores(errores);
			response.setRequestCofirmation(true);
			response.setAllowFileUpload(true);
			LOG.info("el archivo " + retencionesForm.getFileName() + " terminado");
			return response;
		}


		return response;
	}

	Boolean hasValidName(final String fileName, final String anoGravable, final String periodo, final String nit)
	{

		if (fileName.substring(0, fileName.length() - 4).length() != 21)
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

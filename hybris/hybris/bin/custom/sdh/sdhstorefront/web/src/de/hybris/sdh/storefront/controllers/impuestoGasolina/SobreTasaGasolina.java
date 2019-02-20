

package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.CalculaGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.GeneraDeclaracionRequest;
import de.hybris.sdh.core.pojos.responses.CalculaGasolinaResponse;
import de.hybris.sdh.core.pojos.responses.DetGasInfoDeclaraResponse;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.DetGasRevisorDeclaranteResponse;
import de.hybris.sdh.core.pojos.responses.ErrorPubli;
import de.hybris.sdh.core.pojos.responses.GeneraDeclaracionResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHGeneraDeclaracionService;
import de.hybris.sdh.storefront.forms.GeneraDeclaracionForm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Federico Flores Dimas
 *
 */

@Controller
@SessionAttributes("dataForm")

public class SobreTasaGasolina extends AbstractSearchPageController
{

	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

	//Example Controller
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	// CMS Pages
	private static final String SOBRETASA_GASOLINA_CMS_PAGE = "sobretasa-gasolina";
	private static final String REDIRECT_TO_SOBRETASA_GASOLINA_PAGE = REDIRECT_PREFIX + "/contribuyentes/sobretasa-gasolina";
	private static final String DECLARACIONES_GASOLINA_CMS_PAGE = "declaracion-gasolina";
	private static final String REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/sobretasa-gasolina/declaracion-gasolina";


	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhGeneraDeclaracionService")
	SDHGeneraDeclaracionService sdhGeneraDeclaracionService;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "modelService")
	private ModelService modelService;


	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/generar", method = RequestMethod.GET)
	@ResponseBody
	public GeneraDeclaracionResponse generar(final GeneraDeclaracionForm dataForm, final HttpServletResponse response,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		GeneraDeclaracionResponse generaDeclaracionResponse = new GeneraDeclaracionResponse();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String numForm = request.getParameter("numForm");

		if (StringUtils.isBlank(numForm))
		{
			numForm = dataForm.getNumForm();
		}

		final GeneraDeclaracionRequest generaDeclaracionRequest = new GeneraDeclaracionRequest();


		generaDeclaracionRequest.setNumForm(numForm);

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			generaDeclaracionResponse = mapper.readValue(sdhGeneraDeclaracionService.generaDeclaracion(generaDeclaracionRequest),
					GeneraDeclaracionResponse.class);

			if (generaDeclaracionResponse != null && generaDeclaracionResponse.getStringPDF() != null)
			{
				final String encodedBytes = generaDeclaracionResponse.getStringPDF();

				final BASE64Decoder decoder = new BASE64Decoder();
				byte[] decodedBytes;
				final FileOutputStream fop;
				decodedBytes = new BASE64Decoder().decodeBuffer(encodedBytes);



				final String fileName = numForm + "-" + customerModel.getNumBP() + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				generaDeclaracionResponse.setUrlDownload(mediaModel.getDownloadURL());


			}

		}
		catch (final Exception e)
		{
			LOG.error("error generating declaration : " + e.getMessage());

			final ErrorPubli error = new ErrorPubli();

			error.setIdmsj("0");
			error.setTxtmsj("Hubo un error al generar la declaración, por favor intentalo más tarde");

			final List<ErrorPubli> errores = new ArrayList<ErrorPubli>();

			errores.add(error);

			generaDeclaracionResponse.setErrores(errores);

		}
		return generaDeclaracionResponse;


	}


	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_ST(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm, @RequestParam(value = "action")
	final String action, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Menu sobretasa gasolina POST --------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String returnURL = REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anioGravable = "";
		String periodo = "";
		final int indiceSeleccionado = 0;
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetGasResponse detalleGasolinaResponse;


		numBP = customerModel.getNumBP();
		numDoc = customerModel.getDocumentNumber();
		tipoDoc = gasolinaService.obtenerTipoDoc(dataForm.getListaDocumentos());
		numDoc = gasolinaService.obtenerNumDoc(dataForm.getListaDocumentos());
		anioGravable = dataForm.getAnoGravable();
		periodo = dataForm.getPeriodo();

		detalleGasolinaRequest.setNumBP(numBP);
		detalleGasolinaRequest.setNumDoc(numDoc);
		detalleGasolinaRequest.setTipoDoc(tipoDoc);
		detalleGasolinaRequest.setAnoGravable(anioGravable);
		detalleGasolinaRequest.setPeriodo(periodo);

		detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println(detalleGasolinaResponse);
		if (detalleGasolinaResponse.getErrores() != null && detalleGasolinaResponse.getErrores().get(0) != null
				&& detalleGasolinaResponse.getErrores().get(0).getTxtmsj() != null
				&& !detalleGasolinaResponse.getErrores().get(0).getTxtmsj().equals(""))
		{
			LOG.error("Error al leer detalle de gasolina: " + detalleGasolinaResponse.getErrores().get(0).getTxtmsj());
			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error1");
		}

		dataForm.setNumBP(numBP);
		dataForm.setNumDoc(numDoc);
		dataForm.setTipoDoc(tipoDoc);
		dataForm.setAnoGravable(anioGravable);
		dataForm.setPeriodo(periodo);
		dataForm.setDataForm(detalleGasolinaResponse);
		dataForm.setNumForm(detalleGasolinaResponse.getNumForm());
		model.addAttribute("dataForm", dataForm);

		if (action.equals("buscar"))
		{
			storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
			model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

			returnURL = getViewForPage(model);
		}
		else
		{
			if (action.equals("declarar"))
			{
				storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
				setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
				model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
				model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

				returnURL = REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
			}
		}

		return returnURL;
	}






	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_ST(final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Menu sobretasa gasolina GET --------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetGasResponse detalleGasolinaResponse;
		String[] mensajesError;
		String numBP = "";
		String tipoDoc = "";
		String numDoc = "";
		String anioGravable = "";
		String periodo = "";
		SDHValidaMailRolResponse detalleContribuyente;
		String returnURL = "/";


		numBP = customerModel.getNumBP();
		contribuyenteRequest.setNumBP(numBP);

		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		if (detalleContribuyente.getIdmsj() != 0)
		{
			LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(
					gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error2", mensajesError);


			//*->INI dev-eduardo ajuste de menu impuestos
			//private String bPredial;
			//private String bVehicular;
			//private String bIca;
			if (detalleContribuyente.getGasolina() != null && !detalleContribuyente.getGasolina().isEmpty())
			{
				dataForm.setbSobreGasolina("X");
			}
			else
			{
				dataForm.setbSobreGasolina("");
			}

			if (detalleContribuyente.getPublicidadExt() != null && !detalleContribuyente.getPublicidadExt().isEmpty())
			{
				dataForm.setbPublicidadExt("X");
			}
			else
			{
				dataForm.setbPublicidadExt("");
			}
			//*->FIN dev-eduardo ajuste de menu impuestos

			model.addAttribute("dataForm", dataForm);
		}
		tipoDoc = gasolinaService.obtenerTipoDoc(dataForm.getListaDocumentos());
		numDoc = gasolinaService.obtenerNumDoc(dataForm.getListaDocumentos());
		anioGravable = gasolinaService.obtenerAnoGravableActual();
		periodo = gasolinaService.obtenerPeriodoActual();

		detalleGasolinaRequest.setNumBP(numBP);
		detalleGasolinaRequest.setNumDoc(numDoc);
		detalleGasolinaRequest.setTipoDoc(tipoDoc);
		detalleGasolinaRequest.setAnoGravable(anioGravable);
		detalleGasolinaRequest.setPeriodo(periodo);

		detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println(detalleGasolinaResponse);
		if (detalleGasolinaResponse.getErrores() != null && detalleGasolinaResponse.getErrores().get(0) != null
				&& detalleGasolinaResponse.getErrores().get(0).getTxtmsj() != null
				&& !detalleGasolinaResponse.getErrores().get(0).getTxtmsj().equals(""))
		{
			LOG.error("Error al leer detalle de gasolina: " + detalleGasolinaResponse.getErrores().get(0).getTxtmsj());
			GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error1");

			//*->INI dev-eduardo ajuste de menu impuestos
			//private String bPredial;
			//private String bVehicular;
			//private String bIca;
			if (detalleContribuyente.getGasolina() != null && !detalleContribuyente.getGasolina().isEmpty())
			{
				dataForm.setbSobreGasolina("X");
			}
			else
			{
				dataForm.setbSobreGasolina("");
			}

			if (detalleContribuyente.getPublicidadExt() != null && !detalleContribuyente.getPublicidadExt().isEmpty())
			{
				dataForm.setbPublicidadExt("X");
			}
			else
			{
				dataForm.setbPublicidadExt("");
			}
			//*->FIN dev-eduardo ajuste de menu impuestos

			model.addAttribute("dataForm", dataForm);
		}
		detalleGasolinaResponse
				.setRepresentantes(gasolinaService.prepararTablaRepresentantes(detalleGasolinaResponse.getRepresentantes()));

		{
			if (gasolinaService.prepararTablaDeclaracion(detalleContribuyente.getGasolina()).size() > 0)
			{
				dataForm.setListaDocumentos(gasolinaService.prepararTablaDeclaracion(detalleContribuyente.getGasolina()));
				dataForm.setNAME_ORG1(detalleContribuyente.getInfoContrib().getAdicionales().getNAME_ORG1());
				dataForm.setCatalogosSo(gasolinaService.prepararCatalogos());
				dataForm.setAnoGravable(gasolinaService.obtenerAnoGravableActual());
				dataForm.setPeriodo(gasolinaService.obtenerPeriodoActual());
				dataForm.setNumBP(numBP);
				dataForm.setNumDoc(numDoc);
				dataForm.setTipoDoc(tipoDoc);
				dataForm.setDataForm(detalleGasolinaResponse);

				//*->INI dev-eduardo ajuste de menu impuestos
				//private String bPredial;
				//private String bVehicular;
				//private String bIca;
				if (detalleContribuyente.getGasolina() != null && !detalleContribuyente.getGasolina().isEmpty())
				{
					dataForm.setbSobreGasolina("X");
				}
				else
				{
					dataForm.setbSobreGasolina("");
				}

				if (detalleContribuyente.getPublicidadExt() != null && !detalleContribuyente.getPublicidadExt().isEmpty())
				{
					dataForm.setbPublicidadExt("X");
				}
				else
				{
					dataForm.setbPublicidadExt("");
				}
				//*->FIN dev-eduardo ajuste de menu impuestos

				model.addAttribute("dataForm", dataForm);
				storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
				setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
				model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
				model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

				returnURL = getViewForPage(model);
			}
		}


		return returnURL;

	}




	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion-gasolina", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_DEC(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Declaracion gasolina GET --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final DetGasRevisorDeclaranteResponse revisor = new DetGasRevisorDeclaranteResponse();
		final DetGasRevisorDeclaranteResponse declarante = new DetGasRevisorDeclaranteResponse();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
		SDHValidaMailRolResponse detalleContribuyente;
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetGasResponse detalleGasolinaResponse;
		final List<DetGasInfoDeclaraResponse> infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
		final List<DetGasInfoDeclaraResponse> infoDeclaraDefaultTMP;

		final SobreTasaGasolinaCatalogos catalogos = gasolinaService.prepararCatalogos();

		String[] mensajesError;
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anoGravable = "";
		String periodo = "";


		numBP = customerModel.getNumBP();
		if (dataForm != null)
		{
			anoGravable = dataForm.getAnoGravable();
			periodo = dataForm.getPeriodo();
			numDoc = dataForm.getNumDoc();
			tipoDoc = dataForm.getTipoDoc();
		}


		final String tipoRevisor = "1";
		final String tipoDeclarante = "2";


		detalleGasolinaRequest.setNumBP(numBP);
		detalleGasolinaRequest.setNumDoc(numDoc);
		detalleGasolinaRequest.setTipoDoc(tipoDoc);
		detalleGasolinaRequest.setAnoGravable(anoGravable);
		detalleGasolinaRequest.setPeriodo(periodo);

		detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println(detalleGasolinaResponse);
		if (detalleGasolinaResponse.getErrores() != null && detalleGasolinaResponse.getErrores().get(0) != null
				&& detalleGasolinaResponse.getErrores().get(0).getTxtmsj() != null
				&& !detalleGasolinaResponse.getErrores().get(0).getTxtmsj().equals(""))
		{
			LOG.error("Error al leer detalle de gasolina: " + detalleGasolinaResponse.getErrores().get(0).getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(detalleGasolinaResponse.getErrores());
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error1", mensajesError);
		}

		dataForm.setAnoGravable(anoGravable);
		dataForm.setPeriodo(periodo);
		dataForm.setNumDoc(numDoc);
		dataForm.setOpcionUso(detalleGasolinaResponse.getOpcionUso());
		dataForm.setNumForm(detalleGasolinaResponse.getNumForm());
		infoDeclaraDefaultTMP = gasolinaService.prepararInfoDeclara(detalleGasolinaResponse.getInfoDeclara());
		if (infoDeclaraDefaultTMP != null && infoDeclaraDefaultTMP.size() > 0)
		{
			infoDeclaraDefault.addAll(infoDeclaraDefaultTMP);
		}
		else if (dataForm.getDataForm().getInfoDeclara() != null && dataForm.getDataForm().getInfoDeclara().size() > 0)
		{
			infoDeclaraDefault.addAll(dataForm.getDataForm().getInfoDeclara());
		}
		infoDeclaraDefault.addAll(gasolinaService.prepararInfoDeclaraDefault(5));

		dataForm.getDataForm().setInfoDeclara(infoDeclaraDefault);

		dataForm.setValoresDeclara(detalleGasolinaResponse.getValoresDeclara());
		if (detalleGasolinaResponse.getRevisorDeclarante() != null)
		{
			for (int i = 0; i < detalleGasolinaResponse.getRevisorDeclarante().size(); i++)
			{
				if (detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoInterloc().equals(tipoRevisor) == true)
				{
					revisor.setTipoDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
					revisor.setTipoDocDESC(gasolinaService.getDescripcion(revisor.getTipoDoc(), catalogos.getTipoIdRev()));
					revisor.setNumDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
					revisor.setNombres(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
					revisor.setTarjetaProf(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
					dataForm.setRevisor(revisor);
				}
				else
				{
					declarante.setTipoDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
					declarante.setTipoDocDESC(gasolinaService.getDescripcion(declarante.getTipoDoc(), catalogos.getTipoIdRev()));
					declarante.setNumDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
					declarante.setNombres(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
					declarante.setTarjetaProf(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
					dataForm.setDeclarante(declarante);
				}
			}
		}


		numBP = customerModel.getNumBP();
		contribuyenteRequest.setNumBP(numBP);

		detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);
		if (detalleContribuyente.getIdmsj() != 0)
		{
			LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(
					gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error2", mensajesError);

		}
		declarante.setTipoDoc(detalleContribuyente.getInfoContrib().getTipoDoc());
		declarante.setTipoDocDESC(gasolinaService.getDescripcion(declarante.getTipoDoc(), catalogos.getTipoIdRev()));
		declarante.setNumDoc(detalleContribuyente.getInfoContrib().getNumDoc());
		declarante.setNombres(detalleContribuyente.getInfoContrib().getAdicionales().getNAME_ORG1());
		dataForm.setDeclarante(declarante);




		dataForm.setCatalogosSo(catalogos);
		System.out.println(dataForm);


		model.addAttribute("dataForm", dataForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}






	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion-gasolina", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_DEC(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Declaracion gasolina POST --------------------------");

		List<DetGasInfoDeclaraResponse> infoDeclaraDefault;
		List<DetGasRevisorDeclaranteResponse> revisorDeclaranteDefault;
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final CalculaGasolinaRequest consultaGasolinaRequest = new CalculaGasolinaRequest();
		final DetGasRevisorDeclaranteResponse revisor = new DetGasRevisorDeclaranteResponse();
		final DetGasRevisorDeclaranteResponse declarante = new DetGasRevisorDeclaranteResponse();
		final CalculaGasolinaResponse calculaGasolinaResponse;
		String[] mensajesError;
		int claveError;
		List infoDeclaraDefaultTMP;

		String numBP = customerModel.getNumBP();
		String numDoc = customerModel.getDocumentNumber();
		String tipoDoc = "";
		String anoGravable = "";
		String periodo = "";
		String numForm = "";
		String opcionUso = "";
		String calidResp = "";
		infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
		infoDeclaraDefault.add(new DetGasInfoDeclaraResponse());
		revisorDeclaranteDefault = new ArrayList<DetGasRevisorDeclaranteResponse>();
		revisorDeclaranteDefault.add(new DetGasRevisorDeclaranteResponse());
		final String tipoRevisor = "1";
		final String tipoDeclarante = "2";


		numBP = customerModel.getNumBP();
		if (dataForm != null)
		{
			tipoDoc = gasolinaService.obtenerTipoDoc(dataForm.getListaDocumentos());
			numDoc = gasolinaService.obtenerNumDoc(dataForm.getListaDocumentos());
			anoGravable = dataForm.getAnoGravable();
			periodo = dataForm.getPeriodo();
			if (dataForm.getDataForm().getInfoDeclara() != null)
			{
				infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
				for (int i = 0; i < dataForm.getDataForm().getInfoDeclara().size(); i++)
				{
					if (dataForm.getDataForm().getInfoDeclara().get(i).getGalonesGra().equals("") != true
							&& dataForm.getDataForm().getInfoDeclara().get(i).getGalonesGra().equals("") != true)
					{
						infoDeclaraDefault.add(dataForm.getDataForm().getInfoDeclara().get(i));
					}
				}
			}
		}

		if (dataForm.getDataForm().getRevisorDeclarante() != null)
		{
			revisorDeclaranteDefault = dataForm.getDataForm().getRevisorDeclarante();
		}
		numForm = dataForm.getNumForm();
		opcionUso = dataForm.getOpcionUso();
		calidResp = dataForm.getDataForm().getCalidResp();

		consultaGasolinaRequest.setNumBP(numBP);
		consultaGasolinaRequest.setNumDoc(numDoc);
		consultaGasolinaRequest.setTipoDoc(tipoDoc);
		consultaGasolinaRequest.setAnoGravable(anoGravable);
		consultaGasolinaRequest.setPeriodo(periodo);
		consultaGasolinaRequest.setNumForm(numForm);
		consultaGasolinaRequest.setOpcionUso(opcionUso);
		consultaGasolinaRequest.setInfoDeclara(infoDeclaraDefault);
		consultaGasolinaRequest.setRevisorDeclarante(revisorDeclaranteDefault);


		calculaGasolinaResponse = gasolinaService.consultaCalGasolina(consultaGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println(calculaGasolinaResponse);
		if (calculaGasolinaResponse.getErrores() != null && calculaGasolinaResponse.getErrores().get(0) != null
				&& calculaGasolinaResponse.getErrores().get(0).getTxtmsj() != null
				&& !calculaGasolinaResponse.getErrores().get(0).getTxtmsj().equals(""))
		{
			LOG.error("Error al leer calculo de gasolina: " + calculaGasolinaResponse.getErrores().get(0).getTxtmsj());
			mensajesError = gasolinaService.prepararMensajesError(calculaGasolinaResponse.getErrores());
			claveError = mensajesError.length <= 10 ? mensajesError.length : 10;
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"error.impuestoGasolina.sobretasa.error3.attrib" + Integer.toString(claveError), mensajesError);
		}
		dataForm.setNumForm(calculaGasolinaResponse.getNumForm());

		infoDeclaraDefaultTMP = gasolinaService.prepararInfoDeclara(calculaGasolinaResponse.getInfoDeclara());
		infoDeclaraDefaultTMP = infoDeclaraDefaultTMP.size() == 0 ? null : infoDeclaraDefaultTMP;
		if (infoDeclaraDefaultTMP != null && infoDeclaraDefaultTMP.size() > 0)
		{
			infoDeclaraDefault = infoDeclaraDefaultTMP;
		}
		dataForm.getDataForm().setInfoDeclara(infoDeclaraDefault);


		dataForm.getDataForm().setValoresDeclara(calculaGasolinaResponse.getValoresDeclara());
		if (calculaGasolinaResponse.getRevisorDeclarante() != null)
		{
			for (int i = 0; i < calculaGasolinaResponse.getRevisorDeclarante().size(); i++)
			{
				if (calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoInterloc().equals(tipoRevisor) == true)
				{
					revisor.setTipoDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
					revisor.setNumDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
					revisor.setNombres(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
					revisor.setTarjetaProf(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
					dataForm.setRevisor(revisor);
				}
				else
				{
					declarante.setTipoDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
					declarante.setNumDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
					declarante.setNombres(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
					declarante.setTarjetaProf(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
					dataForm.setDeclarante(declarante);
				}
			}
		}
		dataForm.setCatalogosSo(gasolinaService.prepararCatalogos());
		System.out.println(dataForm);
		model.addAttribute("dataForm", dataForm);


		return REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
	}



}


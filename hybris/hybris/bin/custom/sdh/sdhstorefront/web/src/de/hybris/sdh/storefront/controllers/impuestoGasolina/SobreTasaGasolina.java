

package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.CalculaGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.responses.CalculaGasolinaResponse;
import de.hybris.sdh.core.pojos.responses.DetGasInfoDeclaraResponse;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.DetGasRevisorDeclaranteResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
		}

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

		model.addAttribute("dataForm", dataForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

			returnURL = getViewForPage(model);
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


		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetGasResponse detalleGasolinaResponse;
		final String tipoRevisor = "1";
		final String tipoDeclarante = "2";
		final List<DetGasInfoDeclaraResponse> infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
		List<DetGasInfoDeclaraResponse> infoDeclaraDefaultTMP;


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

		infoDeclaraDefaultTMP = detalleGasolinaResponse.getInfoDeclara();
		if (infoDeclaraDefaultTMP != null)
		{
			for (int i = 0; i < infoDeclaraDefaultTMP.size(); i++)
			{
				infoDeclaraDefault.add(infoDeclaraDefaultTMP.get(i));
			}
		}
		for (int i = 0; i < 5; i++)
		{
			infoDeclaraDefault.add(new DetGasInfoDeclaraResponse());
		}


		dataForm.getDataForm().setInfoDeclara(infoDeclaraDefault);

		dataForm.setValoresDeclara(detalleGasolinaResponse.getValoresDeclara());
		if (detalleGasolinaResponse.getRevisorDeclarante() != null)
		{
			for (int i = 0; i < detalleGasolinaResponse.getRevisorDeclarante().size(); i++)
			{
				if (detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoInterloc().equals(tipoRevisor) == true)
				{
					dataForm.getRevisor().setTipoDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
					dataForm.getRevisor().setNumDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
					dataForm.getRevisor().setNombres(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
					dataForm.getRevisor().setTarjetaProf(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
				}
				else
				{
					dataForm.getDeclarante().setTipoDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
					dataForm.getDeclarante().setNumDoc(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
					dataForm.getDeclarante().setNombres(detalleGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
					dataForm.getDeclarante().setTarjetaProf(detalleGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
				}
			}
		}
		dataForm.setCatalogosSo(gasolinaService.prepararCatalogos());
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
		final CalculaGasolinaResponse calculaGasolinaResponse;
		String[] mensajesError;
		int claveError;

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
			numDoc = dataForm.getNumDoc();
			tipoDoc = dataForm.getTipoDoc();
			if (dataForm.getListaDocumentos() != null)
			{
				if (dataForm.getListaDocumentos().get(0) != null)
				{
					tipoDoc = dataForm.getListaDocumentos().get(0).getTipoDocumento();
					numDoc = dataForm.getListaDocumentos().get(0).getNumeroDocumento();
				}
			}
			anoGravable = dataForm.getAnoGravable();
			periodo = dataForm.getPeriodo();
		}
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


		if (calculaGasolinaResponse.getInfoDeclara() == null && dataForm.getDataForm().getInfoDeclara() == null)
		{
			infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
			infoDeclaraDefault.add(new DetGasInfoDeclaraResponse());

			dataForm.getDataForm().setInfoDeclara(infoDeclaraDefault);
		}
		else
		{
			dataForm.getDataForm().setInfoDeclara(calculaGasolinaResponse.getInfoDeclara());
		}

		dataForm.getDataForm().setValoresDeclara(calculaGasolinaResponse.getValoresDeclara());
		if (calculaGasolinaResponse.getRevisorDeclarante() != null)
		{
			for (int i = 0; i < calculaGasolinaResponse.getRevisorDeclarante().size(); i++)
			{
				if (calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoInterloc().equals(tipoRevisor) == true)
				{
					dataForm.getRevisor().setTipoDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
					dataForm.getRevisor().setNumDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
					dataForm.getRevisor().setNombres(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
					dataForm.getRevisor().setTarjetaProf(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
				}
				else
				{
					dataForm.getDeclarante().setTipoDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTipoDoc());
					dataForm.getDeclarante().setNumDoc(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNumDoc());
					dataForm.getDeclarante().setNombres(calculaGasolinaResponse.getRevisorDeclarante().get(i).getNombres());
					dataForm.getDeclarante().setTarjetaProf(calculaGasolinaResponse.getRevisorDeclarante().get(i).getTarjetaProf());
				}
			}
		}
		dataForm.setCatalogosSo(gasolinaService.prepararCatalogos());
		System.out.println(dataForm);
		model.addAttribute("dataForm", dataForm);


		return REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
	}

}


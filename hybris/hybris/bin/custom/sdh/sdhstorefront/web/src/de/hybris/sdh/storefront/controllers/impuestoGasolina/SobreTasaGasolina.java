

package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
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
 * @author fede
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

	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina", method = RequestMethod.POST)
	//	@RequireHardLogIn
	public String handlePOST_ST(@ModelAttribute("dataForm") SobreTasaGasolinaForm dataForm,
			@RequestParam(value = "action") String accept, final BindingResult bindingResult,
			final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Menu sobretasa gasolina POST --------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String numBP = "";
		String numDoc = "";
		String tipoDoc = "";
		String anioGravable = "";
		String periodo = "";
		int indiceSeleccionado = 0;
		SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetGasResponse detalleResponse;


		numBP = customerModel.getNumBP();
		numDoc = customerModel.getDocumentNumber();
		if (dataForm.getListaDocumentos() != null)
		{
			for (int i = 0; i < dataForm.getListaDocumentos().size(); i++)
			{
				if (!dataForm.getListaDocumentos().get(i).toString().isEmpty())
				{
					tipoDoc = dataForm.getListaDocumentos().get(indiceSeleccionado).getTipoDocumento();
					break;
				}
			}
		}
		anioGravable = dataForm.getAnoGravable();
		periodo = dataForm.getPeriodo();

		detalleGasolinaRequest.setNumBP(numBP);
		detalleGasolinaRequest.setNumDoc(numDoc);
		detalleGasolinaRequest.setTipoDoc(tipoDoc);
		detalleGasolinaRequest.setAnoGravable(anioGravable);
		detalleGasolinaRequest.setPeriodo(periodo);

		detalleResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println(detalleResponse);
		dataForm.setDataForm(detalleResponse);
		//		dataForm.setCatalogos(new SobreTasaGasolinaService().prepararCatalogos());


		final SobreTasaGasolinaCatalogos dataFormCatalogos = new SobreTasaGasolinaService().prepararCatalogos();


		model.addAttribute("dataFormCatalogos", dataFormCatalogos);
		model.addAttribute("dataForm", dataForm);
		//		model.addAttribute("listaDocumentos", dataFormTabla);
		//		model.addAttribute("dataForm", detalleGasolinaResponse);

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}









	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina", method = RequestMethod.GET)
	//	@RequireHardLogIn
	//	 @ModelAttribute("dataForm") SobreTasaGasolinaForm dataForm
	public String handleGET_ST(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Menu sobretasa gasolina GET --------------------------");
		//		SobreTasaGasolinaCatalogos dataFormCatalogos = new SobreTasaGasolinaService().prepararCatalogos();
		List<SobreTasaGasolinaTabla> listaDocumentos;
		CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		ConsultaContribuyenteBPRequest docsGasolinaRequest = new ConsultaContribuyenteBPRequest();
		//		SobreTasaGasolinaTabla documentoDefault = new SobreTasaGasolinaTabla();

		String numBP = customerModel.getNumBP();
		docsGasolinaRequest.setNumBP(numBP);
		listaDocumentos = gasolinaService.prepararTablaDeclaracion(
				gasolinaService.consultaDocsGasolina(docsGasolinaRequest, sdhConsultaContribuyenteBPService, LOG));

		SobreTasaGasolinaForm dataForm2 = new SobreTasaGasolinaForm();
		dataForm2.setListaDocumentos(listaDocumentos);
		dataForm2.setCatalogosSo(gasolinaService.prepararCatalogos());


		//		model.addAttribute("dataFormCatalogos", dataFormCatalogos);
		model.addAttribute("dataForm", dataForm2);
		//		model.addAttribute("documento", documentoDefault);

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}





	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion-gasolina", method = RequestMethod.GET)
	//	@RequireHardLogIn
	public String handleGET_DEC(@ModelAttribute("dataForm") SobreTasaGasolinaForm dataFormST, final Model model)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Declaracion gasolina GET --------------------------");
		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		//		final SobretasaGasolinaCatalogos dataFormCatalogos = new SobretasaGasolinaService().prepararCatalogos();
		//		List<DetGasInfoDeclaraResponse> infoDeclaraDefault;
		//		DetGasInfoDeclaraResponse valInfoDeclaraDefault;



		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String numBP = customerModel.getNumBP();
		String numDoc = customerModel.getDocumentNumber();
		String tipoDoc = "NIT";
		String anoGravable = "2019";
		String periodo = "1";
		SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
		final DetGasResponse wsResponse;
		//		SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		String tipoRevisor = "1";
		String tipoDeclarante = "2";
		List<DetGasInfoDeclaraResponse> infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
		List<DetGasInfoDeclaraResponse> infoDeclaraDefaultTMP;


		detalleGasolinaRequest.setNumBP(numBP);
		detalleGasolinaRequest.setNumDoc(numDoc);
		detalleGasolinaRequest.setTipoDoc(tipoDoc);
		detalleGasolinaRequest.setAnoGravable(anoGravable);
		detalleGasolinaRequest.setPeriodo(periodo);

		//		dataForm = new gasolinaService().prepararInfoBP("537", "Info");
		wsResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		dataForm.setAnoGravable(anoGravable);
		dataForm.setPeriodo(periodo);
		dataForm.setNumDoc(numDoc);

		infoDeclaraDefaultTMP = wsResponse.getInfoDeclara();
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


		//		dataForm.setInfoDeclara(valInfoDeclaraDefault);
		dataForm.setInfoDeclara(infoDeclaraDefault);

		dataForm.setValoresDeclara(wsResponse.getValoresDeclara());
		if (wsResponse.getRevisorDeclarante() != null)
		{
			for (int i = 0; i < wsResponse.getRevisorDeclarante().size(); i++)
			{
				if (wsResponse.getRevisorDeclarante().get(i).getTipoInterloc().equals(tipoRevisor) == true)
				{
					dataForm.getRevisor().setTipoDoc(wsResponse.getRevisorDeclarante().get(i).getTipoDoc());
					dataForm.getRevisor().setNumDoc(wsResponse.getRevisorDeclarante().get(i).getNumDoc());
					dataForm.getRevisor().setNombres(wsResponse.getRevisorDeclarante().get(i).getNombres());
					dataForm.getRevisor().setTarjetaProf(wsResponse.getRevisorDeclarante().get(i).getTarjetaProf());
				}
				else
				{
					dataForm.getDeclarante().setTipoDoc(wsResponse.getRevisorDeclarante().get(i).getTipoDoc());
					dataForm.getDeclarante().setNumDoc(wsResponse.getRevisorDeclarante().get(i).getNumDoc());
					dataForm.getDeclarante().setNombres(wsResponse.getRevisorDeclarante().get(i).getNombres());
					dataForm.getDeclarante().setTarjetaProf(wsResponse.getRevisorDeclarante().get(i).getTarjetaProf());
				}
			}
		}
		dataForm.setCatalogosDe(gasolinaService.prepararCatalogosDeclaracion());
		System.out.println(dataForm);


		model.addAttribute("dataForm", dataForm);
		//		model.addAttribute("dataFormCatalogos", dataFormCatalogos);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_GASOLINA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}







	@RequestMapping(value = "/contribuyentes/sobretasa-gasolina/declaracion-gasolina", method = RequestMethod.POST)
	//	@RequireHardLogIn
	public String handlePOST_DEC(@ModelAttribute("dataForm") SobreTasaGasolinaForm dataForm1, final BindingResult bindingResult,
			final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Declaracion gasolina POST --------------------------");

		//		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		//		final DeclaracionGasolinaCatalogos dataFormCatalogos = new DeclaracionGasolinaService().prepararCatalogos();
		List<DetGasInfoDeclaraResponse> infoDeclaraDefault;
		List<DetGasRevisorDeclaranteResponse> revisorDeclaranteDefault;

		//		DetGasInfoDeclaraResponse valInfoDeclaraDefault;



		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		String numBP = customerModel.getNumBP();
		String numDoc = customerModel.getDocumentNumber();
		String tipoDoc = "NIT";
		String anoGravable = "2019";
		String periodo = "1";
		String numForm = "";
		String opcionUso = "1";
		String calidResp = "1";
		infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
		infoDeclaraDefault.add(new DetGasInfoDeclaraResponse());
		revisorDeclaranteDefault = new ArrayList<DetGasRevisorDeclaranteResponse>();
		revisorDeclaranteDefault.add(new DetGasRevisorDeclaranteResponse());


		SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService();
		final CalculaGasolinaRequest consultaGasolinaRequest = new CalculaGasolinaRequest();
		final CalculaGasolinaResponse wsResponse;
		SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		String tipoRevisor = "1";
		String tipoDeclarante = "2";


		consultaGasolinaRequest.setNumBP(numBP);
		consultaGasolinaRequest.setNumDoc(numDoc);
		consultaGasolinaRequest.setTipoDoc(tipoDoc);
		consultaGasolinaRequest.setAnoGravable(anoGravable);
		consultaGasolinaRequest.setPeriodo(periodo);
		consultaGasolinaRequest.setNumForm(numForm);
		consultaGasolinaRequest.setOpcionUso(opcionUso);
		consultaGasolinaRequest.setInfoDeclara(infoDeclaraDefault);
		consultaGasolinaRequest.setRevisorDeclarante(revisorDeclaranteDefault);


		System.out.println(consultaGasolinaRequest);
		//		dataForm = new gasolinaService().prepararInfoBP("537", "Info");
		wsResponse = gasolinaService.consultaCalGasolina(consultaGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println(wsResponse);
		dataForm.setAnoGravable(anoGravable);
		dataForm.setPeriodo(periodo);
		dataForm.setNumDoc(numDoc);
		if (wsResponse.getInfoDeclara() == null)
		{
			//			valInfoDeclaraDefault = new DetGasInfoDeclaraResponse();
			infoDeclaraDefault = new ArrayList<DetGasInfoDeclaraResponse>();
			infoDeclaraDefault.add(new DetGasInfoDeclaraResponse());

			dataForm.setInfoDeclara(infoDeclaraDefault);
		}
		else
		{
			dataForm.setInfoDeclara(wsResponse.getInfoDeclara());
		}

		dataForm.setValoresDeclara(wsResponse.getValoresDeclara());
		if (wsResponse.getRevisorDeclarante() != null)
		{
			for (int i = 0; i < wsResponse.getRevisorDeclarante().size(); i++)
			{
				if (wsResponse.getRevisorDeclarante().get(i).getTipoInterloc().equals(tipoRevisor) == true)
				{
					dataForm.getRevisor().setTipoDoc(wsResponse.getRevisorDeclarante().get(i).getTipoDoc());
					dataForm.getRevisor().setNumDoc(wsResponse.getRevisorDeclarante().get(i).getNumDoc());
					dataForm.getRevisor().setNombres(wsResponse.getRevisorDeclarante().get(i).getNombres());
					dataForm.getRevisor().setTarjetaProf(wsResponse.getRevisorDeclarante().get(i).getTarjetaProf());
				}
				else
				{
					dataForm.getDeclarante().setTipoDoc(wsResponse.getRevisorDeclarante().get(i).getTipoDoc());
					dataForm.getDeclarante().setNumDoc(wsResponse.getRevisorDeclarante().get(i).getNumDoc());
					dataForm.getDeclarante().setNombres(wsResponse.getRevisorDeclarante().get(i).getNombres());
					dataForm.getDeclarante().setTarjetaProf(wsResponse.getRevisorDeclarante().get(i).getTarjetaProf());
				}
			}
		}
		dataForm.setCatalogosDe(gasolinaService.prepararCatalogosDeclaracion());
		System.out.println(dataForm);









		return REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE;
	}

}


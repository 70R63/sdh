/**
 *
 */
package de.hybris.sdh.storefront.controllers.declaraciones;


import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaCatalogos;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaTabla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class PresentarDeclaracion extends AbstractSearchPageController
{


	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

	//Example Controller
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.presendecla";

	// CMS Pages
	private static final String PRESENTAR_DECLARACION_CMS_PAGE = "presentar-declaracion";
	private static final String REDIRECT_TO_PRESENTAR_DECLARACION_PAGE = REDIRECT_PREFIX + "/contribuyentes/presentar-declaracion";
	private static final String DECLARACIONES_GASOLINA_CMS_PAGE = "declaracion-gasolina";

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhConsultaPagoService")
	SDHConsultaPagoService sdhConsultaPagoService;

	@Resource(name = "sdhValidaContribuyenteService")
	SDHValidaContribuyenteService sdhValidaContribuyenteService;



	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/presentar-declaracion", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_PD(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Presentar Declaracion GET --------------------------");

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos());
		//dataForm.setAnoGravable("2019");
		//dataForm.setPeriodo("1");

		if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
		{
			dataForm.setOptionPubliExt("4");
		}
		if (customerData.getGasTaxList() != null && !customerData.getGasTaxList().isEmpty())
		{
			dataForm.setOptionGas("5");
		}

		model.addAttribute("dataForm", dataForm);
		model.addAttribute("tpImpuesto", this.getTpImpuesto(dataForm.getOptionGas(), dataForm.getOptionPubliExt()));

		storeCmsPageInModel(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}





	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/presentar-declaracion", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_ST(@ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataFormResponse, @RequestParam(value = "action")
	final String action, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Presentar Declaracion POST --------------------------");
		System.out.println("[" + dataFormResponse.getSkipReques() + "]");

		String URLdeterminada = "";
		System.out.println("acti:" + action);
		System.out.println("imp:" + dataFormResponse.getImpuesto());
		System.out.println("anio:" + dataFormResponse.getAnoGravable());
		System.out.println("per:" + dataFormResponse.getPeriodo());

		if (action.equals("presentarDeclaracion"))
		{
			if (dataFormResponse.getImpuesto().equals("5") && !dataFormResponse.getAnoGravable().equals("")
					&& !dataFormResponse.getPeriodo().equals("") && !dataFormResponse.getSkipReques().equals("X"))
			{
				final CustomerModel customerModel;
				final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
				final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
				String numBP = "";
				String numDoc = "";
				String tipoDoc = "";
				String anioGravable = "";
				String periodo = "";
				final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
				final DetGasResponse detalleResponse;
				final SobreTasaGasolinaCatalogos dataFormCatalogos = gasolinaService.prepararCatalogos();
				List<SobreTasaGasolinaTabla> tablaDocs;
				final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
				SDHValidaMailRolResponse detalleContribuyente;
				String[] mensajesError;


				customerModel = (CustomerModel) userService.getCurrentUser();

				numBP = customerModel.getNumBP();
				numDoc = customerModel.getDocumentNumber();

				contribuyenteRequest.setNumBP(numBP);

				detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService,
						LOG);
				if (detalleContribuyente.getIdmsj() != 0)
				{
					LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
					//					GlobalMessages.addErrorMessage(model, "error.impuestoGasolina.sobretasa.error2");
					mensajesError = gasolinaService.prepararMensajesError(
							gasolinaService.convertirListaError(detalleContribuyente.getIdmsj(), detalleContribuyente.getTxtmsj()));
					GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"error.impuestoGasolina.sobretasa.error2", mensajesError);
				}


				tablaDocs = gasolinaService.prepararTablaDeclaracion(detalleContribuyente.getGasolina());

				if (tablaDocs != null)
				{
					for (int i = 0; i < tablaDocs.size(); i++)
					{
						if (!tablaDocs.get(i).toString().isEmpty())
						{
							tipoDoc = tablaDocs.get(i).getTipoDocumento();
							break;
						}
					}
				}
				anioGravable = dataFormResponse.getAnoGravable();
				periodo = dataFormResponse.getPeriodo();

				detalleGasolinaRequest.setNumBP(numBP);
				detalleGasolinaRequest.setNumDoc(numDoc);
				detalleGasolinaRequest.setTipoDoc(tipoDoc);
				detalleGasolinaRequest.setAnoGravable(anioGravable);
				detalleGasolinaRequest.setPeriodo(periodo);

				detalleResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
				dataForm.setDataForm(detalleResponse);

				dataForm.setNumBP(numBP);
				dataForm.setNumDoc(numDoc);
				dataForm.setTipoDoc(tipoDoc);
				dataForm.setAnoGravable(anioGravable);
				dataForm.setPeriodo(periodo);
				dataForm.setNAME_ORG1(detalleContribuyente.getInfoContrib().getAdicionales().getNAME_ORG1());
				dataForm.setImpuesto(dataFormResponse.getImpuesto());

				model.addAttribute("dataForm", dataForm);
				URLdeterminada = gasolinaService.obtenerURL("presentar-declaracion", "impuesto", "sobretasa-gasolina");

				return URLdeterminada;
			}
			else if (dataFormResponse.getImpuesto().equals("4") && !dataFormResponse.getAnoGravable().equals("")
					&& !dataFormResponse.getPeriodo().equals("") && !dataFormResponse.getSkipReques().equals("X"))
			{
				final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
				model.addAttribute("publicidadExtList", sdhValidaContribuyenteService
						.getpublicidadExtListByBpAndYear(customerModel.getNumBP(), dataFormResponse.getAnoGravable()));
				System.out.println("hola como estas");
			}
		}

		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
		{
			dataForm.setOptionPubliExt("4");
		}
		if (customerData.getGasTaxList() != null && !customerData.getGasTaxList().isEmpty())
		{
			dataForm.setOptionGas("5");
		}

		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos());
		dataForm.setImpuesto(dataFormResponse.getImpuesto());
		dataForm.setAnoGravable(dataFormResponse.getAnoGravable());
		dataForm.setPeriodo(dataFormResponse.getPeriodo());
		model.addAttribute("dataForm", dataForm);
		model.addAttribute("tpImpuesto", this.getTpImpuesto(dataForm.getOptionGas(), dataForm.getOptionPubliExt()));

		storeCmsPageInModel(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PRESENTAR_DECLARACION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);


		return getViewForPage(model);
	}

	private Map<String, String> getTpImpuesto(final String optionGas, final String optionPubExt)
	{
		final Map<String, String> map;
		if (optionGas != "" && optionPubExt != "")
		{
			map = new HashMap<String, String>();
			map.put("0", "Seleccionar");
			map.put("4", "Publicidad Exterior");
			map.put("5", "Sobretasa Gasolina");
		}
		else if (optionGas != "" && optionPubExt == "")
		{
			map = new HashMap<String, String>();
			map.put("0", "Seleccionar");
			map.put("5", "Sobretasa Gasolina");
		}
		else if (optionGas == "" && optionPubExt != "")
		{
			map = new HashMap<String, String>();
			map.put("0", "Seleccionar");
			map.put("4", "Publicidad Exterior");
		}
		else
		{
			map = null;
		}

		return map;
	}



}

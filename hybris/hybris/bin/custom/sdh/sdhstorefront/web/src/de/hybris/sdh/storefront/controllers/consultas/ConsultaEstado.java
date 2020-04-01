/**
 *
 */
package de.hybris.sdh.storefront.controllers.consultas;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.EdoCuentaRequest;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.EdoCuentaResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHEdoCuentaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaCatalogos;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaForm;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaTabla;
import de.hybris.sdh.storefront.forms.EdoCuentaForm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Federico Flores Dimas
 *
 */

@Controller
@SessionAttributes("dataForm")

public class ConsultaEstado extends AbstractSearchPageController
{


	private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

	//Example Controller
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.estadocuenta";

	// CMS Pages
	private static final String ESTADO_DE_CUENTA_CMS_PAGE = "estado-de-cuenta";
	private static final String REDIRECT_TO_ESTADO_DE_CUENTA_PAGE = REDIRECT_PREFIX + "/contribuyentes/estado-de-cuenta";


	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "sdhEdoCuentaService")
	SDHEdoCuentaService sdhEdoCuentaService;





	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/estado-de-cuenta", method = RequestMethod.GET)
	@RequireHardLogIn
	public String handleGET_PD(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Estado de Cuenta GET --------------------------");

		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();
		dataForm.setCatalogosSo(new SobreTasaGasolinaService(configurationService).prepararCatalogos());
		model.addAttribute("dataForm", dataForm);

		final EdoCuentaForm ctaForm = new EdoCuentaForm();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final EdoCuentaRequest edoCuentaRequest = new EdoCuentaRequest();

		ctaForm.setCompleName(customerData.getCompleteName());
		ctaForm.setTipoDoc(customerData.getDocumentType());
		ctaForm.setNumBP(customerModel.getNumBP());
		ctaForm.setNumDoc(customerData.getDocumentNumber());

		try
		{
			edoCuentaRequest.setBp(customerModel.getNumBP());

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final EdoCuentaResponse edoCuentaResponse = mapper.readValue(sdhEdoCuentaService.detalleEdoCta(edoCuentaRequest),
					EdoCuentaResponse.class);


			ctaForm.setCompleName(customerData.getCompleteName());
			ctaForm.setTipoDoc(customerData.getDocumentType());
			ctaForm.setNumBP(customerModel.getNumBP());
			ctaForm.setTasaInteres(edoCuentaResponse.getTasaInteres());
			ctaForm.setPredialSaldoCargo(edoCuentaResponse.getNewPredialSaldoCargo());
			ctaForm.setPredialSaldoFavor(edoCuentaResponse.getNewPredialSaldoFavor());
			ctaForm.setiCASaldoCargo(edoCuentaResponse.getNewICASaldoCargo());
			ctaForm.setiCASaldoFavor(edoCuentaResponse.getNewICASaldoFavor());
			ctaForm.setVehicularSaldoCargo(edoCuentaResponse.getNewVehicularSaldoCargo());
			ctaForm.setVehicularSaldoFavor(edoCuentaResponse.getNewVehicularSaldoFavor());
			ctaForm.setDelineacionSaldoCargo(edoCuentaResponse.getNewDelineacionSaldoCargo());
			ctaForm.setDelineacionSaldoFavor(edoCuentaResponse.getNewDelineacionSaldoFavor());
			ctaForm.setGasolinaSaldoCargo(edoCuentaResponse.getNewGasolinaSaldoCargo());
			ctaForm.setGasolinaSaldoFavor(edoCuentaResponse.getNewGasolinaSaldoFavor());
			ctaForm.setPublicidadSaldoCargo(edoCuentaResponse.getNewPublicidadSaldoCargo());
			ctaForm.setPublicidadSaldoFavor(edoCuentaResponse.getNewPublicidadSaldoFavor());
			if (edoCuentaResponse.getPredial() != null && !edoCuentaResponse.getPredial().isEmpty())
			{
				ctaForm.setPredial(edoCuentaResponse.getPredial().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNewCHIP())).collect(Collectors.toList()));
			}

			//ctaForm.setPredial(edoCuentaResponse.getPredial());
			ctaForm.setTablaICA(edoCuentaResponse.getTablaICA());

			if (edoCuentaResponse.getTablaVehicular() != null && !edoCuentaResponse.getTablaVehicular().isEmpty())
			{
				ctaForm.setTablaVehicular(edoCuentaResponse.getTablaVehicular().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getPlaca())).collect(Collectors.toList()));
			}
			//ctaForm.setTablaVehicular(edoCuentaResponse.getTablaVehicular());
			if (edoCuentaResponse.getTablaDelineacion() != null && !edoCuentaResponse.getTablaDelineacion().isEmpty())
			{
				ctaForm.setTablaDelineacion(edoCuentaResponse.getTablaDelineacion().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNewCDU())).collect(Collectors.toList()));
			}
			//ctaForm.setTablaDelineacion(edoCuentaResponse.getTablaDelineacion());
			ctaForm.setTablaGasolina(edoCuentaResponse.getTablaGasolina());
			ctaForm.setTablaPublicidad(edoCuentaResponse.getTablaPublicidad());

			Date date = new Date();

			//Caso 2: obtener la fecha y salida por pantalla con formato:
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Fecha: " + dateFormat.format(date));

			ctaForm.setFechageneracion(dateFormat.format(date));

		}
		catch (final Exception e)
		{
			LOG.error("there was an error while parsing redsocial JSON");
			LOG.error("Error en el servicio: " + e.getMessage());
		}

		model.addAttribute("ctaForm", ctaForm);


		storeCmsPageInModel(model, getContentPageForLabelOrId(ESTADO_DE_CUENTA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESTADO_DE_CUENTA_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}





	//-----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contribuyentes/estado-de-cuenta", method = RequestMethod.POST)
	@RequireHardLogIn
	public String handlePOST_ST(final Model model, @ModelAttribute("dataForm")
	final SobreTasaGasolinaForm dataFormResponse, @RequestParam(value = "action")
	final String action) throws CMSItemNotFoundException
	{
		System.out.println("---------------- En Presentar Declaracion POST --------------------------");


		String URLdeterminada = "";
		if (action.equals("presentarDeclaracion"))
		{
			if (dataFormResponse.getImpuesto().equals("5"))
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


				customerModel = (CustomerModel) userService.getCurrentUser();

				numBP = customerModel.getNumBP();
				numDoc = customerModel.getDocumentNumber();

				contribuyenteRequest.setNumBP(numBP);

				detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService,
						LOG);
				if (detalleContribuyente.getIdmsj() != 0)
				{
					LOG.error("Error al leer informacion del Contribuyente: " + detalleContribuyente.getTxtmsj());
					GlobalMessages.addErrorMessage(model, "error.consultas.estadoDeCuenta.error1");
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

				model.addAttribute("dataForm", dataForm);
				URLdeterminada = gasolinaService.obtenerURL("presentar-declaracion", "impuesto", "sobretasa-gasolina");
			}
			else
			{

				storeCmsPageInModel(model, getContentPageForLabelOrId(ESTADO_DE_CUENTA_CMS_PAGE));
				setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ESTADO_DE_CUENTA_CMS_PAGE));
				model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
				model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

				URLdeterminada = getViewForPage(model);
			}
		}

		return URLdeterminada;
	}



}

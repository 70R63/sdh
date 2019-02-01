/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.CalcPublicidadRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetallePublicidadRequest;
import de.hybris.sdh.core.pojos.responses.CalcPublicidadResponse;
import de.hybris.sdh.core.pojos.responses.DetallePubli;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.services.SDHCalPublicidadService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetallePublicidadService;
import de.hybris.sdh.storefront.forms.DeclaPublicidadController;
import de.hybris.sdh.storefront.forms.PublicidadForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("/contribuyentes/publicidadexterior/declaracion")
public class DeclaraPublicidadController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(DeclaraPublicidadController.class);

	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	//CMS PAGES
	private static final String DECLARACION_PUBLICIDAD_CMS_PAGE = "DeclaraPublicidadPage";
	private static final String REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/publicidadexterior/declaracion";


	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCalPublicidadService")
	SDHCalPublicidadService sdhCalPublicidadService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhDetallePublicidadService")
	SDHDetallePublicidadService sdhDetallePublicidadService;


	@RequestMapping(value = "/contribuyentes/publicidadexterior/declaracion", method = RequestMethod.GET)
	//@RequireHardLogIn
	public String declaraPublicidadpage(final Model model, @RequestParam("anio")
	final String anio, @RequestParam("numResolu")
	final String numResolu) throws CMSItemNotFoundException
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();

		/*
		 * detallePublicidadRequest.setNumBP(customerModel.getNumBP()); detallePublicidadRequest.setNumResolu(anio);
		 * detallePublicidadRequest.setAnoGravable(numResolu);
		 */
		detallePublicidadRequest.setNumBP("0000000546");
		detallePublicidadRequest.setNumResolu("RES 096");
		detallePublicidadRequest.setAnoGravable(anio);

		try
		{
			final PublicidadForm publicidadForm = new PublicidadForm();
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePublicidadResponse detallePublicidadResponse = mapper.readValue(
					sdhDetallePublicidadService.detallePublicidad(detallePublicidadRequest), DetallePublicidadResponse.class);

			final DeclaPublicidadController declaPublicidadForm = new DeclaPublicidadController();

			declaPublicidadForm.setCatalogos(new PublicidadExteriorServicios().prepararCatalogos());
			declaPublicidadForm.setNumBP(customerModel.getNumBP());
			declaPublicidadForm.setAnograv(detallePublicidadResponse.getAnoGravable());
			declaPublicidadForm.setNumform(detallePublicidadResponse.getInfoDeclara().getNumForm());
			declaPublicidadForm.setNumresol(detallePublicidadResponse.getNumResolu());
			declaPublicidadForm.setFecresol(detallePublicidadResponse.getFechResolu());
			final String fechnotif = detallePublicidadResponse.getFechNotif();
			if (StringUtils.isNotBlank(fechnotif) && !"00000000".equals(fechnotif))
			{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(fechnotif, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				declaPublicidadForm.setFechnotif(localDate.format(formatter2));
			}

			declaPublicidadForm.setOrValla(detallePublicidadResponse.getInfoDeclara().getOrientacionValla());
			declaPublicidadForm.setLuginst(detallePublicidadResponse.getInfoDeclara().getLugarInstala());
			declaPublicidadForm.setBasegrav(detallePublicidadResponse.getInfoDeclara().getTamanoValla());
			declaPublicidadForm.setOpuso(detallePublicidadResponse.getInfoDeclara().getOpcionUso());
			declaPublicidadForm.setImpCar(detallePublicidadResponse.getInfoDeclara().getImpCargo());
			declaPublicidadForm.setValsan(detallePublicidadResponse.getInfoDeclara().getVlrSancion());
			declaPublicidadForm.setValpag(detallePublicidadResponse.getInfoDeclara().getVlrPagar());
			declaPublicidadForm.setIntmora(detallePublicidadResponse.getInfoDeclara().getInteresMora());
			declaPublicidadForm.setTotpag(detallePublicidadResponse.getInfoDeclara().getTotalPagar());
			declaPublicidadForm.setRefe(detallePublicidadResponse.getInfoDeclara().getReferencia());
			declaPublicidadForm.setVigenDesde(detallePublicidadResponse.getVigenDesde());
			declaPublicidadForm.setVigenHasta(detallePublicidadResponse.getVigenHasta());
			declaPublicidadForm.setDetalle(detallePublicidadResponse.getDetalle());

			if (detallePublicidadResponse.getDetalle() != null && !detallePublicidadResponse.getDetalle().isEmpty())
			{

				for (final DetallePubli eachDetalle : detallePublicidadResponse.getDetalle())
				{
					declaPublicidadForm.setPlaca(eachDetalle.getPlaca());
					declaPublicidadForm.setDireccion(eachDetalle.getDireccion());
					break;
				}

			}
			model.addAttribute("declaPublicidadForm", declaPublicidadForm);
		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		//updatePageTitle(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE)); */

		return getViewForPage(model);

	}

	@RequestMapping(value = "/contribuyentes/publicidadexterior/declaracion", method = RequestMethod.POST)
	//@RequireHardLogIn
	public String declapost(@ModelAttribute("declaPublicidadForm")
	final DeclaPublicidadController dataForm,
			final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a Publicidad POST --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

		final CalcPublicidadRequest calcPublicidadRequest = new CalcPublicidadRequest();

		/*
		 * calcPublicidadRequest.setNumBP(customerModel.getNumBP());
		 * calcPublicidadRequest.setNumResolu(dataForm.getNumresol());
		 * calcPublicidadRequest.setNumForm(dataForm.getNumform());
		 * calcPublicidadRequest.setAnoGravable(dataForm.getAnograv());
		 * calcPublicidadRequest.setOpcionUso(dataForm.getOpuso());
		 * calcPublicidadRequest.setFechNotif(dataForm.getFechnotif());
		 * calcPublicidadRequest.setLugarInstala(dataForm.getLuginst());
		 * calcPublicidadRequest.setDireccion(dataForm.getDireccion());
		 * calcPublicidadRequest.setPlaca(dataForm.getPlaca());
		 * calcPublicidadRequest.setOrientacionValla(dataForm.getOrValla());
		 * calcPublicidadRequest.setTamanoValla(dataForm.getBasegrav()); calcPublicidadRequest.setTipoIDcontrib("NIT");
		 * calcPublicidadRequest.setIDcontrib("860453833"); calcPublicidadRequest.setMunicipioContrib("");
		 * calcPublicidadRequest.setTipoIDdeclara("CE"); calcPublicidadRequest.setIDdeclarante("510338");
		 */

		calcPublicidadRequest.setNumBP(customerModel.getNumBP());
		calcPublicidadRequest.setNumResolu("RES");
		calcPublicidadRequest.setNumForm("");
		calcPublicidadRequest.setAnoGravable("2018");
		calcPublicidadRequest.setOpcionUso("01");
		calcPublicidadRequest.setFechNotif("20180809");
		calcPublicidadRequest.setLugarInstala("02");
		calcPublicidadRequest.setDireccion("");
		calcPublicidadRequest.setPlaca("MVC123");
		calcPublicidadRequest.setOrientacionValla("05");
		calcPublicidadRequest.setTamanoValla("04");
		calcPublicidadRequest.setTipoIDcontrib("NIT");
		calcPublicidadRequest.setIDcontrib("860453833");
		calcPublicidadRequest.setMunicipioContrib("");
		calcPublicidadRequest.setTipoIDdeclara("CE");
		calcPublicidadRequest.setIDdeclarante("510338");

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final CalcPublicidadResponse calcPublicidadResponse = mapper
					.readValue(sdhCalPublicidadService.calcPublicidad(calcPublicidadRequest), CalcPublicidadResponse.class);

			final DeclaPublicidadController declaPublicidadForm = new DeclaPublicidadController();

			declaPublicidadForm.setNumform(calcPublicidadResponse.getNumForm());
			declaPublicidadForm.setImpCar(calcPublicidadResponse.getImpCargo());
			declaPublicidadForm.setValsan(calcPublicidadResponse.getVlrSancion());
			declaPublicidadForm.setValpag(calcPublicidadResponse.getVlrPagar());
			declaPublicidadForm.setIntmora(calcPublicidadResponse.getInteresMora());
			declaPublicidadForm.setTotpag(calcPublicidadResponse.getTotalPagar());

			// declaPublicidadForm.setReferencia(calcPublicidadResponse.getTotalPagar());


			//declaPublicidad.setNumResol(customerModel.getNumBP);
			//declaPublicidad.setNumResol(sdhCalPublicidadService.getNumResol);

			model.addAttribute("declaPublicidadForm", declaPublicidadForm);

		}


		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		//declaPublicidad.setNumResol(customerModel.getNumBP);
		//final DeclaPublicidadForm dataForm = new DeclaPublicidadController();
		//model.addAttribute("dataForm", dataForm);
		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		/* updatePageTitle(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE)); */

		return getViewForPage(model);

	}
}

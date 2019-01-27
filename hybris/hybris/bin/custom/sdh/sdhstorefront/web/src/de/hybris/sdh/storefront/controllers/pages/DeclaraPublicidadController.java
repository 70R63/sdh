/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.CalcPublicidadRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.CalcPublicidadResponse;
import de.hybris.sdh.core.services.SDHCalPublicidadService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.DeclaPublicidadController;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	@RequestMapping(value = "/contribuyentes/publicidadexterior/declaracion", method = RequestMethod.GET)
	//@RequireHardLogIn
	public String declaraPublicidadpage(final Model model, final RedirectAttributes redirectModel, @RequestParam("anio")
	final String anio) throws CMSItemNotFoundException
	{
		final DeclaPublicidadController declaPublicidadForm = new DeclaPublicidadController();

		String formato = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
		String fecha = simpleDateFormat.format(new Date());
		System.out.println(fecha);

		declaPublicidadForm.setFechnotif(fecha);
		model.addAttribute("declaPublicidadForm", declaPublicidadForm);

		//model.addAttribute("dataForm", dataForm);
		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE));
		/* updatePageTitle(model, getContentPageForLabelOrId(DECLARACION_PUBLICIDAD_CMS_PAGE)); */

		return getViewForPage(model);

	}

	@RequestMapping(value = "/contribuyentes/publicidadexterior/declaracion", method = RequestMethod.POST)
	//@RequireHardLogIn
	public String updateEmail(final DeclaPublicidadController dataForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro a Publicidad POST --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

		final CalcPublicidadRequest calcPublicidadRequest = new CalcPublicidadRequest();

		calcPublicidadRequest.setNumBP("454");
		calcPublicidadRequest.setNumResolu("RES 1162");
		calcPublicidadRequest.setNumForm("");
		calcPublicidadRequest.setAnoGravable("2019");
		calcPublicidadRequest.setOpcionUso("01");
		calcPublicidadRequest.setFechNotif("");
		calcPublicidadRequest.setLugarInstala("01");
		calcPublicidadRequest.setDireccion("");
		calcPublicidadRequest.setPlaca("");
		calcPublicidadRequest.setOrientacionValla("01");
		calcPublicidadRequest.setTamanoValla("01");
		calcPublicidadRequest.setTipoIDcontrib("");
		calcPublicidadRequest.setIDcontrib("");
		calcPublicidadRequest.setMunicipioContrib("");
		calcPublicidadRequest.setTipoIDdeclara("");
		calcPublicidadRequest.setIDdeclarante("");

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final CalcPublicidadResponse calcPublicidadResponse = mapper
					.readValue(sdhCalPublicidadService.calcPublicidad(calcPublicidadRequest), CalcPublicidadResponse.class);

			final DeclaPublicidadController declaPublicidadForm = new DeclaPublicidadController();


			model.addAttribute("declaPublicidadForm", declaPublicidadForm);

			/*
			 * declaPublicidadForm.setNumform(calcPublicidadResponse.getNumForm());
			 * declaPublicidadForm.setImpCar(calcPublicidadResponse.getImpCargo());
			 * declaPublicidadForm.setValsan(calcPublicidadResponse.getVlrSancion());
			 * declaPublicidadForm.setValpag(calcPublicidadResponse.getVlrPagar());
			 * declaPublicidadForm.setIntmora(calcPublicidadResponse.getInteresMora());
			 * declaPublicidadForm.setTotpag(calcPublicidadResponse.getTotalPagar());
			 *
			 * //declaPublicidadForm.setReferencia(calcPublicidadResponse.getTotalPagar());
			 *
			 * //model.addAttribute("declaPublicidadForm", declapublicidadForm);
			 * //declaPublicidad.setNumResol(customerModel.getNumBP);
			 * //declaPublicidad.setNumResol(sdhCalPublicidadService.getNumResol);
			 */


		}


		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			//LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			//GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
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

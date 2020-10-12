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
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.DefaultResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ContribDireccion;
import de.hybris.sdh.core.pojos.responses.ContribTelefono;
import de.hybris.sdh.core.pojos.responses.NombreRolResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.DescargaFacturaForm;
import de.hybris.sdh.storefront.forms.Descuento1PCCatalogos;
import de.hybris.sdh.storefront.forms.Descuento1PCForm;
import de.hybris.sdh.storefront.forms.FacturacionForm;
import de.hybris.sdh.storefront.forms.MiRitForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class ReexpedicionFacturaPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.reexpedicionFac";

	// CMS Pages
	private static final String REEXPEDICION_FACTURA_CMS_PAGE = "reexpedicionFacturaPage";
	private static final String REEXPEDICION_FACTURA_CMS_PAGE_ACT = "reexpedicionFacturaActPage";

	private static final String REDIRECT_TO_REEXPEDICION_FACTURA_PAGE = REDIRECT_PREFIX + "/contribuyentes/reexpedicionfactura";

	@Resource(name = "customBreadcrumbBuilder")
	private DefaultResourceBreadcrumbBuilder accountBreadcrumbBuilder;


	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "eventService")
	private EventService eventService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	@RequestMapping(value = "/contribuyentes/reexpedicionfactura", method = RequestMethod.GET)
	@RequireHardLogIn
	public String reexpfact(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET REEXPEDICION Factura --------------------------");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

		final FacturacionForm facturacionForm = new FacturacionForm();


		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			facturacionForm.setPredial(sdhConsultaContribuyenteBPResponse.getPredial());
			facturacionForm.setVehicular(sdhConsultaContribuyenteBPResponse.getVehicular());

			model.addAttribute("facturacionForm", facturacionForm);
			model.addAttribute("descargaFacturaForm", new DescargaFacturaForm());
		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(REEXPEDICION_FACTURA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REEXPEDICION_FACTURA_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/reexpedicionfactura", method = RequestMethod.POST)
	@RequireHardLogIn
	public String reexpfactpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de REEXPEDICION Factura------------------------");

		return REDIRECT_TO_REEXPEDICION_FACTURA_PAGE;
	}


	@RequestMapping(value = "/contribuyentes/reexpedicionfacturaAct", method = RequestMethod.GET)
	@RequireHardLogIn
	public String reexpfact_act(@ModelAttribute("descargaFacturaForm")
	final DescargaFacturaForm descargaFacturaForm, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException

	{
		System.out.println("---------------- En GET REEXPEDICION Factura Actualizacion --------------------------");

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);


		final Descuento1PCForm dataForm = new Descuento1PCForm();

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final Descuento1PCCatalogos catalogos = gasolinaService.prepararCatalogosDescuento1PC();


		dataForm.setCustomerData(customerData);
		dataForm.setDescargaFactura(descargaFacturaForm);
		model.addAttribute("dataForm", dataForm);




		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();


		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

		final String referrer = request.getHeader("referer");

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			final MiRitForm miRitForm = new MiRitForm();
			model.addAttribute("PNAT", true);

			if ("nit".equalsIgnoreCase(customerModel.getDocumentType()) || "nite".equalsIgnoreCase(customerModel.getDocumentType()))
			{
				model.addAttribute("PJUR", true);
				model.addAttribute("PNAT", false);
				miRitForm.setNombreRazonSocial1(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG1());
				miRitForm.setNombreRazonSocial2(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG2());
				miRitForm.setNombreRazonSocial3(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG3());
				miRitForm.setNombreRazonSocial4(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG4());

				miRitForm.setFormaJuridica(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getLEGAL_ENTY());
				miRitForm.setNumeroMatriculaMercantil(
						sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZNOMATRICUL());

				final String feachLiq = sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getLIQUIDATIONDATE();
				if (StringUtils.isNotBlank(feachLiq) && !"00000000".equals(feachLiq))
				{
					//					final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
					//
					//					final LocalDate localDate = LocalDate.parse(feachLiq, formatter);
					//
					//					final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					//
					//					miRitForm.setFechaLiquidacion(localDate.format(formatter2));

					miRitForm.setFechaLiquidacion(feachLiq);
				}

				miRitForm.setTipoRetenedor(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getLEGALORG());

			}
			else
			{
				miRitForm.setPrimNom(sdhConsultaContribuyenteBPResponse.getInfoContrib().getPrimNom());
			}

			miRitForm.setDigVer(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getDIGVERIF());
			miRitForm.setTipoDoc(sdhConsultaContribuyenteBPResponse.getInfoContrib().getTipoDoc());

			miRitForm.setEmail(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getSMTP_ADDR());

			miRitForm.setPrimApe(sdhConsultaContribuyenteBPResponse.getInfoContrib().getPrimApe());
			miRitForm.setSegNom(sdhConsultaContribuyenteBPResponse.getInfoContrib().getSegNom());
			miRitForm.setSegApe(sdhConsultaContribuyenteBPResponse.getInfoContrib().getSegApe());

			final String feachExp = sdhConsultaContribuyenteBPResponse.getInfoContrib().getFchExp();
			if (StringUtils.isNotBlank(feachExp) && !"00000000".equals(feachExp))
			{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(feachExp, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				miRitForm.setFchExp(localDate.format(formatter2));
			}


			miRitForm.setNumDoc(sdhConsultaContribuyenteBPResponse.getInfoContrib().getNumDoc());

			if (StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getTITLE()))
			{
				miRitForm.setTratamiento(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getTITLE());
			}
			if (StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getTYPE()))
			{
				miRitForm.setClaseIC(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getTYPE());
			}
			if (0 != sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getXSEXU())
			{
				miRitForm.setSexo(String.valueOf(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getXSEXU()));
			}

			if (StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNATIO()))
			{
				miRitForm.setNacionalidad(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNATIO());
			}

			miRitForm.setFechaNacimiento(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getBIRTHDT());

			miRitForm.setLugarNacimiento(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getBIRTHPL());

			if (StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getCNDSC()))
			{
				miRitForm.setPaisOrigen(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getCNDSC());
			}

			if (sdhConsultaContribuyenteBPResponse.getRoles() != null && !sdhConsultaContribuyenteBPResponse.getRoles().isEmpty())
			{

				for (final NombreRolResponse eachRolResponse : sdhConsultaContribuyenteBPResponse.getRoles())
				{
					if ("01".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasCORol(Boolean.TRUE);
					}
					else if ("02".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasAARol(Boolean.TRUE);
					}
					else if ("03".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasTARol(Boolean.TRUE);
					}
					else if ("04".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasARRol(Boolean.TRUE);
					}
					else if ("05".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasRIRol(Boolean.TRUE);
					}
				}
			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOUSOINF() == 1)
			{
				miRitForm.setUseInformationForInstitutionalPurposes(Boolean.TRUE);
			}
			else if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOUSOINF() == 2)
			{
				miRitForm.setUseInformationForInstitutionalPurposes(Boolean.FALSE);
			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOBUZONE() == 1)
			{
				miRitForm.setUseEmailForNotifications(Boolean.TRUE);
			}
			else if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOBUZONE() == 2)
			{
				miRitForm.setUseEmailForNotifications(Boolean.FALSE);
			}


			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getDireccion() != null
					&& !sdhConsultaContribuyenteBPResponse.getInfoContrib().getDireccion().isEmpty())
			{

				for (final ContribDireccion eachDireccion : sdhConsultaContribuyenteBPResponse.getInfoContrib().getDireccion())
				{

					if ("01".equalsIgnoreCase(eachDireccion.getADR_KIND()))
					{

						miRitForm.setDireccionContacto(eachDireccion);

					}
					if ("02".equalsIgnoreCase(eachDireccion.getADR_KIND()))
					{

						miRitForm.setDireccionNotificacion(eachDireccion);

					}


				}

			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono() != null
					&& !sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono().isEmpty())
			{

				for (final ContribTelefono eachTelefono : sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono())
				{
					if (StringUtils.isNotBlank(eachTelefono.getTEL_NUMBER()))
					{
						miRitForm.setTelefonoPricipal(eachTelefono.getTEL_NUMBER());
						miRitForm.setExtensionTelefono(eachTelefono.getTEL_EXTENS());
						break;
					}
				}

			}


			if (sdhConsultaContribuyenteBPResponse.getGasolina() != null
					&& !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
			{
				miRitForm.setGasolina(sdhConsultaContribuyenteBPResponse.getGasolina().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumDoc())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getPublicidadExt() != null
					&& !sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				miRitForm.setPublicidadExt(sdhConsultaContribuyenteBPResponse.getPublicidadExt().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumResolu())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getRedsocial() != null
					&& !sdhConsultaContribuyenteBPResponse.getInfoContrib().getRedsocial().isEmpty())
			{
				miRitForm.setRedsocial(sdhConsultaContribuyenteBPResponse.getInfoContrib().getRedsocial().stream()
						.filter(eachNet -> StringUtils.isNotBlank(eachNet.getRED_SOCIAL())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getAgentes() != null
					&& !sdhConsultaContribuyenteBPResponse.getAgentes().isEmpty())
			{
				miRitForm.setRepresentantes(sdhConsultaContribuyenteBPResponse.getAgentes().stream().filter(
						eachAgente -> StringUtils.isNotBlank(eachAgente.getTipoDoc()) && "X".equalsIgnoreCase(eachAgente.getAgente()))
						.collect(Collectors.toList()));

				//				miRitForm.setRepresentados(sdhConsultaContribuyenteBPResponse.getAgentes().stream().filter(
				//						eachAgente -> StringUtils.isNotBlank(eachAgente.getTipoDoc()) && StringUtils.isBlank(eachAgente.getAgente()))
				//						.collect(Collectors.toList()));

				miRitForm.setRepresentados(sdhConsultaContribuyenteBPResponse.getAgentes().stream().filter(
						eachAgente -> StringUtils.isNotBlank(eachAgente.getTipoDoc()) && "-".equalsIgnoreCase(eachAgente.getAgente()))
						.collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getIca() != null
					&& StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getIca().getNumObjeto()))
			{
				miRitForm.setImpuestoICA(sdhConsultaContribuyenteBPResponse.getIca());
			}

			if (sdhConsultaContribuyenteBPResponse.getDelineacion() != null
					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getDelineacion()))
			{
				miRitForm.setDelineacion(sdhConsultaContribuyenteBPResponse.getDelineacion().stream()
						.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getVehicular() != null
					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getVehicular()))
			{
				miRitForm.setVehicular(sdhConsultaContribuyenteBPResponse.getVehicular().stream()
						.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
			}

			model.addAttribute("miRitForm", miRitForm);

		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}



		//		storeCmsPageInModel(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));
		//		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));
		//		updatePageTitle(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));
		//
		//		if (referrer.contains("contribuyentes"))
		//		{
		//			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE));
		//		}
		//		else if (referrer.contains("retenedores"))
		//		{
		//			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_RETE));
		//		}
		//		else if (referrer.contains("reportantes"))
		//		{
		//			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_REPO));
		//		}
		//		else
		//		{
		//			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE));
		//		}
		//






		storeCmsPageInModel(model, getContentPageForLabelOrId(REEXPEDICION_FACTURA_CMS_PAGE_ACT));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REEXPEDICION_FACTURA_CMS_PAGE_ACT));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}
}

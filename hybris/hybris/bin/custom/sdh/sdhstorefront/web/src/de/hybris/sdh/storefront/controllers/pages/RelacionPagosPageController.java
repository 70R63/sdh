/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsultaContribBPRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.RelacionPagosRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestosResponse;
import de.hybris.sdh.core.pojos.responses.RelacionPagosDelineacion;
import de.hybris.sdh.core.pojos.responses.RelacionPagosGasolina;
import de.hybris.sdh.core.pojos.responses.RelacionPagosICA;
import de.hybris.sdh.core.pojos.responses.RelacionPagosPredial;
import de.hybris.sdh.core.pojos.responses.RelacionPagosPublicidad;
import de.hybris.sdh.core.pojos.responses.RelacionPagosResponse;
import de.hybris.sdh.core.pojos.responses.RelacionPagosVehicular;
import de.hybris.sdh.core.pojos.responses.Relacionpagosrespons;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHRelacionPagosService;
import de.hybris.sdh.storefront.forms.RelacionPagosForm;

import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Maria Luisa
 *
 */
@Controller
/* @RequestMapping("/contribuyentes/certipagos") */
public class RelacionPagosPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(RelacionPagosPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.relapagos";
	private static final String BREADCRUMBS_VALUE_RETE = "text.account.profile.arRelapagos";

	// CMS Pages
	private static final String RELACION_PAGOS_CMS_PAGE = "relacionPagosPage";

	private static final String REDIRECT_TO_RELACION_PAGOS_PAGE = REDIRECT_PREFIX + "/contribuyentes/consultas/relacionpagos";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

	@Resource(name = "sdhRelacionPagosService")
	SDHRelacionPagosService sdhRelacionPagosService;
	
	@Resource(name = "sdhCustomerAccountService")
	SDHCustomerAccountService sdhCustomerAccountService;



	@RequestMapping(value =
	{ "/contribuyentes/consultas/relacionpagos", "/agenteRetenedor/consultas/relacionpagos" }, method = RequestMethod.GET)
	@RequireHardLogIn
	public String relapag(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Relaciones de Pago--------------------------");
		final StringBuffer requestURL = request.getRequestURL();
		final String url2 = String.valueOf(requestURL);

		try
		{

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = sdhCustomerAccountService.leerImpuestosActivosContribuyente(sdhConsultaImpuesto_simplificado.AMBITO_CONSULTAS);

			final RelacionPagosForm relacionPagosForm = new RelacionPagosForm();

			if (sdhConsultaContribuyenteBPResponse.getGasolina() != null
					&& !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
			{
				relacionPagosForm.setGasolina(sdhConsultaContribuyenteBPResponse.getGasolina().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumDoc())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getPublicidadExt() != null
					&& !sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				relacionPagosForm.setPublicidadExt(sdhConsultaContribuyenteBPResponse.getPublicidadExt().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumResolu())).collect(Collectors.toList()));
			}


			if (sdhConsultaContribuyenteBPResponse.getIca() != null
					&& StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getIca().getNumObjeto()))
			{
				relacionPagosForm.setImpuestoICA(sdhConsultaContribuyenteBPResponse.getIca());
			}

			if (sdhConsultaContribuyenteBPResponse.getDelineacion() != null
					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getDelineacion()))
			{
				relacionPagosForm.setDelineacion(sdhConsultaContribuyenteBPResponse.getDelineacion().stream()
						.filter(d -> StringUtils.isNotBlank(d.getCdu())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getVehicular() != null
					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getVehicular()))
			{
				relacionPagosForm.setVehicular(sdhConsultaContribuyenteBPResponse.getVehicular().stream()
						.filter(d -> StringUtils.isNotBlank(d.getPlaca())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getPredial() != null
					&& CollectionUtils.isNotEmpty(sdhConsultaContribuyenteBPResponse.getPredial()))
			{
				relacionPagosForm.setPredial(sdhConsultaContribuyenteBPResponse.getPredial().stream()
						.filter(d -> StringUtils.isNotBlank(d.getCHIP())).collect(Collectors.toList()));
			}
			model.addAttribute("relacionPagosForm", relacionPagosForm);
		}
		catch (final Exception e)
		{
			LOG.error("Error getting customer info from SAP for RelacionPagosPage: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(RELACION_PAGOS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RELACION_PAGOS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		if (url2.contains("contribuyentes"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		}
		else if (url2.contains("agenteRetenedor"))
		{
			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE_RETE));
			model.addAttribute("Retenedor", "Retenedor");
		}
		return getViewForPage(model);
	}


	@RequestMapping(value = "/contribuyentes/consultas/relacionpagos/servicio", method = RequestMethod.POST)
	@ResponseBody
	public RelacionPagosResponse generar(final RelacionPagosForm dataForm, final HttpServletResponse response,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		RelacionPagosResponse relacionPagosResponse = new RelacionPagosResponse();
		final RelacionPagosRequest relacionPagosRequest = new RelacionPagosRequest();

		relacionPagosRequest.setObKey(dataForm.getObKey());

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String resp = sdhRelacionPagosService.getRelacionPagos(relacionPagosRequest);

			resp = resp.replaceAll("(\"STRPDF\":\\[)(.*)(\"\\]\\}\\})(.*)", "\"STRPDF\":$2\"\\}\\}$4");
			resp = resp.replaceAll("(.*)(,\"\"\\],)(.*)", "$1\\],$3");

			if (resp != null ) {
				relacionPagosResponse = mapper.readValue(resp, RelacionPagosResponse.class);
				obtainDate(relacionPagosResponse);
			}
			else {
				relacionPagosResponse.setRelacionpagosrespons(new Relacionpagosrespons());
			}
		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for relacion pagos page: " + e.getMessage());
		}

		return relacionPagosResponse;
	}

	public void obtainDate(final RelacionPagosResponse relacionPago)
	{
		String fecha = "";
		int i = 0;
		if (relacionPago.getRelacionpagosrespons().getPredialUnificado() != null)
		{
			for (final RelacionPagosPredial relPredial : relacionPago.getRelacionpagosrespons().getPredialUnificado())
			{
				fecha = relPredial.getBldat();
				relacionPago.getRelacionpagosrespons().getPredialUnificado().get(i).setBldat(converterDate(fecha));
				i++;
			}
		}

		if (relacionPago.getRelacionpagosrespons().getSobretasaGasolina() != null)
		{
			for (final RelacionPagosGasolina relGas : relacionPago.getRelacionpagosrespons().getSobretasaGasolina())
			{
				fecha = relGas.getBldat();
				relacionPago.getRelacionpagosrespons().getSobretasaGasolina().get(i).setBldat(converterDate(fecha));
				i++;
			}
		}

		if (relacionPago.getRelacionpagosrespons().getImpuestoICA() != null)
		{
			for (final RelacionPagosICA relIca : relacionPago.getRelacionpagosrespons().getImpuestoICA())
			{
				fecha = relIca.getBldat();
				relacionPago.getRelacionpagosrespons().getImpuestoICA().get(i).setBldat(converterDate(fecha));
				i++;
			}
		}

		if (relacionPago.getRelacionpagosrespons().getDelineacionUrbana() != null)
		{
			for (final RelacionPagosDelineacion relDeli : relacionPago.getRelacionpagosrespons().getDelineacionUrbana())
			{
				fecha = relDeli.getBldat();
				relacionPago.getRelacionpagosrespons().getDelineacionUrbana().get(i).setBldat(converterDate(fecha));
				i++;
			}
		}
		if (relacionPago.getRelacionpagosrespons().getPublicidadexterior() != null)
		{
			for (final RelacionPagosPublicidad relPubli : relacionPago.getRelacionpagosrespons().getPublicidadexterior())
			{
				fecha = relPubli.getBldat();
				relacionPago.getRelacionpagosrespons().getPublicidadexterior().get(i).setBldat(converterDate(fecha));
				i++;
			}
		}
		if (relacionPago.getRelacionpagosrespons().getVehicular() != null)
		{
			for (final RelacionPagosVehicular relVehicu : relacionPago.getRelacionpagosrespons().getVehicular())
			{
				fecha = relVehicu.getBldat();
				relacionPago.getRelacionpagosrespons().getVehicular().get(i).setBldat(converterDate(fecha));
				i++;
			}
		}
	}

	public String converterDate(final String fecha)
	{
			final String inputDate = fecha;
			final String dia = inputDate.substring(6);
			final String mes = inputDate.substring(4, 6);
			final String anio = inputDate.substring(0, 4);
			final String date = dia + "/" + mes + "/" + anio;
			LOG.info("La fecha tomo el siguiente formato: " + date);
			return date;
	}
}

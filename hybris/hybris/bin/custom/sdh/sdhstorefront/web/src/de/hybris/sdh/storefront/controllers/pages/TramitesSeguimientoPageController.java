/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ConsCasosRequest;
import de.hybris.sdh.core.pojos.requests.TramitesConsultaCasoInfo;
import de.hybris.sdh.core.pojos.responses.ConsCasosInfo;
import de.hybris.sdh.core.pojos.responses.ConsCasosInfoVista;
import de.hybris.sdh.core.pojos.responses.ConsCasosResponse;
import de.hybris.sdh.core.pojos.responses.ConsCasosResultadoResponse;
import de.hybris.sdh.core.pojos.responses.TramiteCatalogos;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class TramitesSeguimientoPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Seguimiento Trámites";

	// CMS Pages
	private static final String TRAMITES_SEGUIMIENTO_CMS_PAGE = "tramitesSeguimientoPage";

	private static final String REDIRECT_TO_TRAMITES_SEGUIMIENTO_PAGE = REDIRECT_PREFIX + "/contibuyentes/tramites/seguimiento";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "userService")
	UserService userService;


	@RequestMapping(value = "/contibuyentes/tramites/seguimiento", method = RequestMethod.GET)
	@RequireHardLogIn
	public String tramitesseguimiento(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET TRAMITES SEGUIMIENTO --------------------------");

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final TramitesConsultaCasoInfo dataForm = new TramitesConsultaCasoInfo();
		final TramiteCatalogos tramiteCatalogos = gasolinaService.prepararCatalogosConsCaso();


		model.addAttribute("dataForm", dataForm);
		model.addAttribute("catalogos", tramiteCatalogos);



		storeCmsPageInModel(model, getContentPageForLabelOrId(TRAMITES_SEGUIMIENTO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TRAMITES_SEGUIMIENTO_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contibuyentes/tramites/seguimiento", method = RequestMethod.POST)
	@RequireHardLogIn
	public String tramitesseguimientopost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de TRAMITES seguimiento------------------------");

		return REDIRECT_TO_TRAMITES_SEGUIMIENTO_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/tramites/consultaCaso", method = RequestMethod.GET)
	@ResponseBody
	public ConsCasosInfoVista consultaCasoGET(@ModelAttribute("tramitesConsultaCasoInfo")
	final TramitesConsultaCasoInfo tramitesConsultaCasoInfo, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET consulta caso------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		List<ConsCasosInfo> infoCasos = new ArrayList<ConsCasosInfo>();
		final ConsCasosInfoVista infoVista = new ConsCasosInfoVista();
		ConsCasosInfo infoConsulCasos = null;
		final ConsCasosRequest consultaCasosRequest = new ConsCasosRequest();
		ConsCasosResponse consCasosResponse = new ConsCasosResponse();
		String num_caso = "";
		String radicado = "";
		String linea = "";
		String mensaje = "";
		String bp = "";
		final Map<String, ConsCasosInfo> mapResultado = new HashMap<String, ConsCasosInfo>();


		bp = customerModel.getNumBP();

		num_caso = tramitesConsultaCasoInfo.getNum_caso();
		radicado = tramitesConsultaCasoInfo.getRadicado();
		linea = "0";

		if (num_caso.isEmpty() && radicado.isEmpty())
		{
			consultaCasosRequest.setCONTRIBUYENTE(bp);
		}
		else
		{
			consultaCasosRequest.setNUM_CASO(num_caso);
			consultaCasosRequest.setNUM_RADICADO(radicado);
		}
		consultaCasosRequest.setLINEA(linea);


		System.out.println("Request para crm/consCasos: " + consultaCasosRequest);
		consCasosResponse = gasolinaService.consultCaso(consultaCasosRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de crm/consCasos: " + consCasosResponse);
		if (gasolinaService.ocurrioErrorCreacionCaso(consCasosResponse) != true)
		{
			mensaje = consCasosResponse.getTxtmsj();
			if (consCasosResponse.getResultado() != null)
			{
				if (consCasosResponse.getResultado().size() > 0)
				{
					for (final ConsCasosResultadoResponse resultadoActual : consCasosResponse.getResultado())
					{
						infoConsulCasos = mapResultado.get(resultadoActual.getProcess_type());
						if (infoConsulCasos == null)
						{
							infoConsulCasos = new ConsCasosInfo();
						}
						else
						{
							mapResultado.remove(resultadoActual.getProcess_type());
						}
						if (resultadoActual.getCampo().equals("TRÁMITE"))
						{
							infoConsulCasos.setTramite(resultadoActual.getFactor());
						}
						if (resultadoActual.getCampo().equals("NÚMERO DE CASO"))
						{
							infoConsulCasos.setNum_caso(resultadoActual.getFactor());
						}
						if (resultadoActual.getCampo().equals("NÚMERO DE RADICADO"))
						{
							infoConsulCasos.setNum_radicado(resultadoActual.getFactor());
						}
						if (resultadoActual.getCampo().equals("ESTATUS"))
						{
							infoConsulCasos.setEstatus(resultadoActual.getFactor());
						}
						if (resultadoActual.getCampo().equals("CAT01"))
						{
							infoConsulCasos.setCat01(resultadoActual.getFactor());
						}
						if (resultadoActual.getCampo().equals("CAT02"))
						{
							infoConsulCasos.setCat02(resultadoActual.getFactor());
						}
						if (resultadoActual.getCampo().equals("CAT03"))
						{
							infoConsulCasos.setCat03(resultadoActual.getFactor());
						}
						if (resultadoActual.getCampo().equals("CAT04"))
						{
							infoConsulCasos.setCat04(resultadoActual.getFactor());
						}
						if (resultadoActual.getCampo().equals("TEXT"))
						{
							infoConsulCasos.setMensaje(resultadoActual.getFactor());
						}

						mapResultado.put(resultadoActual.getProcess_type(), infoConsulCasos);
					}

					infoCasos = new ArrayList(mapResultado.values());
				}
			}
		}
		else
		{
		}
		infoVista.setInfoCasos(infoCasos);
		infoVista.setMensaje(mensaje);


		return infoVista;
	}

}

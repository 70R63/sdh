/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.ListaDeclaracionesRequest;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesPDFRequest;
import de.hybris.sdh.core.pojos.requests.OpcionDeclaracionesVista;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ItemLlistaDeclaraciones;
import de.hybris.sdh.core.pojos.responses.ListaDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.OpcionDeclaracionesPDFResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Decoder;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class DeclaracionesPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Declaraciones";

	// CMS Pages
	private static final String DECLARACIONES_CMS_PAGE = "declaracionesPage";

	private static final String REDIRECT_TO_DECLARACIONES_PAGE = REDIRECT_PREFIX + "/contribuyentes/consultas/declaraciones";

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@RequestMapping(value = "/contribuyentes/consultas/declaraciones", method = RequestMethod.GET)
	@RequireHardLogIn
	public String declaracionesGET(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET Agentes Declaraciones --------------------------");

		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final OpcionDeclaracionesVista infoVista = new OpcionDeclaracionesVista();
		SDHValidaMailRolResponse customerData = null;


		customerData = sdhCustomerFacade.getRepresentadoFromSAP(customerModel.getNumBP());
		infoVista.setCatalogos(gasolinaService.prepararCatalogosOpcionDeclaraciones(customerData));
		model.addAttribute("dataForm", infoVista);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DECLARACIONES_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contribuyentes/consultas/declaraciones", method = RequestMethod.POST)
	@RequireHardLogIn
	public String declaracionesPOST(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de Agentes Declaraciones------------------------");

		return REDIRECT_TO_DECLARACIONES_PAGE;
	}


	@RequestMapping(value = "/contribuyentes/consultas/declaraciones/listaDeclaraciones", method = RequestMethod.GET)
	@ResponseBody
	public OpcionDeclaracionesVista listaDeclaracionesGET(@ModelAttribute("dataForm")
	final OpcionDeclaracionesVista infoVista, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET lista declaraciones------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final ListaDeclaracionesRequest listaDeclaracionesRequest = new ListaDeclaracionesRequest();
		ListaDeclaracionesResponse listaDeclaracionesResponse = null;
		SDHValidaMailRolResponse customerData = null;
		List<ImpuestoPublicidadExterior> publicidadExt = null;

		String bp = "";
		String impuesto = "";
		String anioGravable = "";
		String periodo = "";


		bp = customerModel.getNumBP();
		customerData = sdhCustomerFacade.getRepresentadoFromSAP(bp);

		impuesto = infoVista.getClaveImpuesto();
		anioGravable = infoVista.getAnoGravable();
		periodo = infoVista.getPeriodo();

		infoVista.setUrlDownload(null);
		infoVista.setPublicidadExt(null);
		infoVista.setGasolina(null);
		infoVista.setDelineacion(null);
		infoVista.setIca(null);
		infoVista.setReteIca(null);
		infoVista.setReteIca(null);


		listaDeclaracionesRequest.setBp(bp);
		listaDeclaracionesRequest.setImpuesto(impuesto);
		listaDeclaracionesRequest.setAnioGravable(anioGravable);
		listaDeclaracionesRequest.setPeriodo(periodo);

		System.out.println("Request para docs/consulCertif: " + listaDeclaracionesRequest);
		listaDeclaracionesResponse = gasolinaService.consultaListaDeclaraciones(listaDeclaracionesRequest, sdhDetalleGasolinaWS,
				LOG);
		System.out.println("Response de docs/consulCertif: " + listaDeclaracionesResponse);
		if (gasolinaService.ocurrioErrorListaDeclara(listaDeclaracionesResponse) != true)
		{
			switch (impuesto)
			{
				case "0007":
					publicidadExt = new ArrayList<ImpuestoPublicidadExterior>();
					if (listaDeclaracionesResponse.getDeclaraciones() != null)
					{
						for (final ItemLlistaDeclaraciones itemDeclaracion : listaDeclaracionesResponse.getDeclaraciones())
						{
							for (final ImpuestoPublicidadExterior publicidadExt_customer : customerData.getPublicidadExt())
							{
								if (publicidadExt_customer.getNumObjeto().equals(itemDeclaracion.getNumObjeto())
										&& publicidadExt_customer.getAnoGravable().equals(anioGravable))
								{
									publicidadExt.add(publicidadExt_customer);
								}
							}
						}

						if (publicidadExt.size() > 0)
						{
							infoVista.setPublicidadExt(publicidadExt);
						}
					}
					break;

				default:
					break;
			}

		}
		else
		{
			//				declaraPDFResponse.setErrores(("Ocurrio un error. No se genero el PDF");
		}

		//		infoVista.setResponse(declaraPDFResponse);



		return infoVista;
	}


	@RequestMapping(value = "/contribuyentes/consultas/declaraciones/declaracionPDF", method = RequestMethod.GET)
	@ResponseBody
	public OpcionDeclaracionesVista declaracionPDFGET(@ModelAttribute("dataForm")
	final OpcionDeclaracionesVista infoVista, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET declaracion PDF------------------------");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final OpcionDeclaracionesPDFRequest declaraPDFRequest = new OpcionDeclaracionesPDFRequest();
		OpcionDeclaracionesPDFResponse declaraPDFResponse = null;
		SDHValidaMailRolResponse customerData = null;

		String bp = "";
		String numObjeto = "";
		String claseObjeto = "";
		String anioGravable = "";
		String periodo = "";
		String radicado = "";


		bp = customerModel.getNumBP();
		customerData = sdhCustomerFacade.getRepresentadoFromSAP(bp);

		claseObjeto = infoVista.getClaveImpuesto();
		numObjeto = infoVista.getObjContrato(); //gasolinaService.obtenerNumDocDeclaraciones(customerData2, claseObjeto);
		anioGravable = infoVista.getAnoGravable();
		periodo = infoVista.getPeriodo();
		radicado = "";

		infoVista.setUrlDownload(null);
		infoVista.setDeclaraPDFResponse(null);

		declaraPDFRequest.setBp(bp);
		declaraPDFRequest.setNumObjeto(numObjeto);
		declaraPDFRequest.setClaseObjeto(claseObjeto);
		declaraPDFRequest.setAnioGravable(anioGravable);
		declaraPDFRequest.setPeriodo(periodo);
		declaraPDFRequest.setRadicado(radicado);

		System.out.println("Request para declaraPDF: " + declaraPDFRequest);
		declaraPDFResponse = gasolinaService.consultaDeclaraPDF(declaraPDFRequest, sdhDetalleGasolinaWS, LOG);
		System.out.println("Response de declaraPDF: " + declaraPDFResponse);
		if (gasolinaService.ocurrioErrorDeclaraPDF(declaraPDFResponse) != true)
		{

			infoVista.setDeclaraPDFResponse(declaraPDFResponse);
			byte[] decodedBytes;
			try
			{
				decodedBytes = new BASE64Decoder().decodeBuffer(declaraPDFResponse.getPdf());
				final String fileName = "declaracion" + "-" + claseObjeto + "-" + bp + ".pdf";

				final InputStream is = new ByteArrayInputStream(decodedBytes);


				final CatalogUnawareMediaModel mediaModel = modelService.create(CatalogUnawareMediaModel.class);
				mediaModel.setCode(System.currentTimeMillis() + "_" + fileName);
				mediaModel.setDeleteByCronjob(Boolean.TRUE.booleanValue());
				modelService.save(mediaModel);
				mediaService.setStreamForMedia(mediaModel, is, fileName, "application/pdf");
				modelService.refresh(mediaModel);

				infoVista.setUrlDownload(mediaModel.getDownloadURL());
			}
			catch (final Exception e)
			{
			}
		}
		else
		{
			//				declaraPDFResponse.setErrores(("Ocurrio un error. No se genero el PDF");
		}

		//		infoVista.setResponse(declaraPDFResponse);



		return infoVista;
	}



}

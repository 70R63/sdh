/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.UIContribuyenteForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/contribuyentes")
public class ContribuyentesPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String CONTRIBUYENTES_CMS_PAGE = "ContribuyentesPage";

	private static final String Mi_RIT_CMS_PAGE = "MiRitPage";

	private static final String DELINEACION_URBANA_CMS_PAGE = "DelineacionUrbanaPage";

	private static final String DELINEACION_URBANA_CORRECIONES_CMS_PAGE = "DelineacionUrbanaCorrecionesPage";

	private static final String DELINEACION_URBANA_DECLARACIONES_CMS_PAGE = "DelineacionUrbanaDeclaracionesPage";

	private static final String DELINEACION_URBANA_PAGOS_PSE_CMS_PAGE = "DelineacionUrbanaPagosPSEPage";

	private static final String SOBRETASA_GASOLINA_CMS_PAGE = "SobretasaGasolinaPage";

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	//	@Resource(name = "sdhCreaModContribuyenteFacade")
	//	SDHCreaModContribuyenteFacade sdhCreaModContribuyenteFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String showView(final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final UIContribuyenteForm uiContribuyenteForm = new UIContribuyenteForm();
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final ObjectMapper mapper = new ObjectMapper();

		try
		{
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());


			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			//private String bPredial;
			//private String bVehicular;
			//private String bIca;
			if (sdhConsultaContribuyenteBPResponse.getGasolina() != null
					&& !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
			{
				uiContribuyenteForm.setbSobreGasolina("X");
			}
			else
			{
				uiContribuyenteForm.setbSobreGasolina("");
			}

			if (sdhConsultaContribuyenteBPResponse.getPublicidadExt() != null
					&& !sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				uiContribuyenteForm.setbPublicidadExt("X");
			}
			else
			{
				uiContribuyenteForm.setbPublicidadExt("");
			}

			model.addAttribute("uiContribuyenteForm", uiContribuyenteForm);

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(CONTRIBUYENTES_CMS_PAGE));

		return getViewForPage(model);
	}

	//	@RequestMapping(value = "/mirit/updatePersonalData", method = RequestMethod.POST)
	//	public String miritUpdatePersonalData(final Model model, final MiRitForm miRitForm)
	//			throws CMSItemNotFoundException
	//	{
	//
	//		model.addAttribute("miRitForm", miRitForm);
	//
	//
	//
	//		final CreaModContribuyenteRequest request = new CreaModContribuyenteRequest();
	//
	//		request.setNumBP("0000000171");
	//		request.setTipoDoc("CC");
	//		request.setNumDoc("10284644");
	//		request.setBuzon("0");
	//
	//		final boolean userUpdated = sdhCreaModContribuyenteFacade.creaModContribuyent(request);
	//
	//		model.addAttribute("userUpdated", userUpdated);
	//
	//		storeCmsPageInModel(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));
	//		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));
	//		updatePageTitle(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));
	//
	//		return getViewForPage(model);
	//	}

	//	protected void populateFormFromValidaMailResponeInSession(final MiRitForm miRitForm)
	//	{
	//		final SDHValidaMailRolResponse sdhValidaMailRolResponse = sessionService.getAttribute("sdhValidaMailRolResponse");
	//
	//		miRitForm.setNumBP(sdhValidaMailRolResponse.getInfoContrib().getNumBP());
	//		miRitForm.setTipoDoc(sdhValidaMailRolResponse.getInfoContrib().getTipoDoc());
	//		miRitForm.setNumDoc(sdhValidaMailRolResponse.getInfoContrib().getNumDoc());
	//		miRitForm.setFchExp(sdhValidaMailRolResponse.getInfoContrib().getFchExp());
	//		miRitForm.setPrimNom(sdhValidaMailRolResponse.getInfoContrib().getPrimNom());
	//		miRitForm.setSegNom(sdhValidaMailRolResponse.getInfoContrib().getSegNom());
	//		miRitForm.setPrimApe(sdhValidaMailRolResponse.getInfoContrib().getPrimApe());
	//		miRitForm.setSegApe(sdhValidaMailRolResponse.getInfoContrib().getSegApe());
	//		miRitForm.setDepartExp(sdhValidaMailRolResponse.getInfoContrib().getDepartExp());
	//		miRitForm.setMunicipio(sdhValidaMailRolResponse.getInfoContrib().getMunicipio());
	//
	//
	//
	//
	//
	//
	//
	//	}


	//Se anexa el mapeo de la pagina predialunificado //GRD
	/*
	 * @RequestMapping(value = "/predialunificado", method = RequestMethod.GET) public String predialUnidicado(final
	 * Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException {
	 *
	 * storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
	 * setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE)); updatePageTitle(model,
	 * getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
	 *
	 * return getViewForPage(model); }
	 *
	 * //Se anexa el mapeo de la pagina sobrevehiculosautomotores //GRD
	 *
	 * @RequestMapping(value = "/sobrevehiculosautomotores", method = RequestMethod.GET) public String
	 * sobreVehiculosAutomotores(final Model model, final RedirectAttributes redirectModel) throws
	 * CMSItemNotFoundException {
	 *
	 * storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
	 * setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
	 * updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
	 *
	 * return getViewForPage(model); }
	 *
	 * //Se anexa el mapeo de la pagina ica y reteica //GRD
	 *
	 * @RequestMapping(value = "/icareteica", method = RequestMethod.GET) public String icaReteIca(final Model model,
	 * final RedirectAttributes redirectModel) throws CMSItemNotFoundException {
	 *
	 * storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE)); setUpMetaDataForContentPage(model,
	 * getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE)); updatePageTitle(model,
	 * getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
	 *
	 * return getViewForPage(model); }
	 */

	/*
	//#->INI dev-federico 17/01/2019 comentado para usar otro controller para Sobretasa Gasolina
	@RequestMapping(value = "/sobretasa-gasolina", method = RequestMethod.GET)
	public String sobretasaGasoline(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));

		return getViewForPage(model);
	}
	//#->FIN dev-federico 17/01/2019 comentado para usar otro controller para Sobretasa Gasolina
	*/

	//#->INI dev-federico 26/02/2019 comentado para usar otro controller para Delineacion urbana
	//	@RequestMapping(value = "/delineacion-urbana", method = RequestMethod.GET)
	//	public String delineacionUrbana(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	//	{
	//
	//		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
	//		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
	//		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
	//
	//		return getViewForPage(model);
	//	}
	//#->INI dev-federico 26/02/2019 comentado para usar otro controller para Delineacion urbana

	@RequestMapping(value = "/delineacion-urbana/declaraciones", method = RequestMethod.GET)
	public String delineacionUrbanaDeclaraciones(final Model model, final RedirectAttributes redirectModel,final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}


	@RequestMapping(value = "/delineacion-urbana/pagos/pse", method = RequestMethod.GET)
	public String delineacionUrbanaPagosPSE(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_PAGOS_PSE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_PAGOS_PSE_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_PAGOS_PSE_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/sobretasa-gasolina/detail", method = RequestMethod.GET)
	public String sobretasaGasolinaDetail(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRETASA_GASOLINA_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/delineacion-urbana/detail", method = RequestMethod.GET)
	public String delineacionUrbanaDetail(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_CMS_PAGE));

		return getViewForPage(model);
	}


	@RequestMapping(value = "/delineacion-urbana/correcciones", method = RequestMethod.GET)
	public String delineacionUrbanaCorreciones(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(DELINEACION_URBANA_CORRECIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DELINEACION_URBANA_CORRECIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(DELINEACION_URBANA_CORRECIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}
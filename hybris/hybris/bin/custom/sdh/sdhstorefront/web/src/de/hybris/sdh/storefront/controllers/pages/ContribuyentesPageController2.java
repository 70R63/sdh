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

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page 2
 */
@Controller
@RequestMapping("/contribuyentes2")
public class ContribuyentesPageController2 extends AbstractPageController
{

	private static final String PREDIAL_UNIFICADO_CMS_PAGE = "PredialUnificadoPage";

	private static final String PREDIAL_UNIFICADO_DESCUENTO_CMS_PAGE = "PredialUnificadoDescuetoPage";

	private static final String PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE = "PredialUnificadoDeclaracionesPage";

	private static final String PREDIAL_UNIFICADO_CORRECIONES_CMS_PAGE = "PredialUnificadoCorrecionesPage";

	private static final String SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE = "SobreVehiculosAutomotoresPage";

	private static final String SOBRE_VEHICULOS_DECLARACIONES_CMS_PAGE = "SobreVehiculosDeclaracionesPage";

	private static final String SOBRE_VEHICULOS_CORRECIONES_CMS_PAGE = "SobreVehiculosCorrecionesPage";

	private static final String ICA_Y_RETEICA_CMS_PAGE = "IcaReteIcaPage";

	private static final String ICA_Y_RETEICA_DECLARACIONES_CMS_PAGE = "IcaReteIcaDeclaracionesPage";

	private static final String ICA_Y_RETEICA_CORRECIONES_CMS_PAGE = "IcaReteIcaCorrecionesPage";

	private static final String PUBLICIDAD_EXTERIOR_CMS_PAGE = "PublicidadExteriorPage";

	//Se anexa el mapeo de la pagina predialunificado
	//GRD
	@RequestMapping(value = "/predialunificado", method = RequestMethod.GET)
	public String predialUnidicado(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/predialunificado/detail", method = RequestMethod.GET)
	public String predialUnidicadoDetail(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CMS_PAGE));

		return getViewForPage(model);
	}


	@RequestMapping(value = "/predialunificado/descuento", method = RequestMethod.GET)
	public String predialUnidicadoDescuento(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/predialunificado/declaraciones", method = RequestMethod.GET)
	public String predialUnidicadoDeclaraciones(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/predialunificado/correcciones", method = RequestMethod.GET)
	public String predialUnidicadoCorreciones(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CORRECIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CORRECIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PREDIAL_UNIFICADO_CORRECIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	//Se anexa el mapeo de la pagina sobrevehiculosautomotores
	//GRD
	@RequestMapping(value = "/sobrevehiculosautomotores", method = RequestMethod.GET)
	public String sobreVehiculosAutomotores(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));

		return getViewForPage(model);
	}

	//Sobre Vehiculos

	@RequestMapping(value = "/sobrevehiculosautomotores/declaraciones", method = RequestMethod.GET)
	public String sobreVehiculosDeclaraciones(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/sobrevehiculosautomotores/detail", method = RequestMethod.GET)
	public String sobreVehiculosDetail(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_AUTOMOTORES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/sobrevehiculosautomotores/correcciones", method = RequestMethod.GET)
	public String sobreVehiculosCorreciones(final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CORRECIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CORRECIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(SOBRE_VEHICULOS_CORRECIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	//Se anexa el mapeo de la pagina ica y reteica
	//GRD
	@RequestMapping(value = "/icareteica", method = RequestMethod.GET)
	public String icaReteIca(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		return getViewForPage(model);
	}

	//Ica y ReteIca
	@RequestMapping(value = "/icareteica/declaraciones", method = RequestMethod.GET)
	public String icaReteIcaDeclaraciones(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute("action", request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_DECLARACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_Y_RETEICA_DECLARACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(ICA_Y_RETEICA_DECLARACIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/icareteica/detail", method = RequestMethod.GET)
	public String icaReteIcaDetail(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		model.addAttribute("showDetail", true);

		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/icareteica/correcciones", method = RequestMethod.GET)
	public String icaReteIcaCorreciones(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CORRECIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CORRECIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(ICA_Y_RETEICA_CORRECIONES_CMS_PAGE));

		return getViewForPage(model);
	}

	//Se anexa el mapeo de la pagina publicidadexterior
	//GRD
	@RequestMapping(value = "/publicidadexterior", method = RequestMethod.GET)
	public String publicidadExterna(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		//model.addAttribute("action", "prueba");
		storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));

		return getViewForPage(model);
	}

	@RequestMapping(value = "/publicidadexterior/detail", method = RequestMethod.GET)
	public String publicidadExternaDetail(final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request)
			throws CMSItemNotFoundException
	{

		//model.addAttribute("showDetail", true);
		model.addAttribute("action", request.getParameter("action"));
		System.out.println("action: " + request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));

		return getViewForPage(model);
	}

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}
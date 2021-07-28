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
package de.hybris.sdh.storefront.interceptors.beforeview;

import de.hybris.platform.acceleratorcms.data.CmsPageRequestContextData;
import de.hybris.platform.acceleratorcms.model.actions.AbstractCMSActionModel;
import de.hybris.platform.acceleratorcms.services.CMSPageContextService;
import de.hybris.platform.acceleratorservices.addonsupport.RequiredAddOnsNameProvider;
import de.hybris.platform.acceleratorservices.config.SiteConfigService;
import de.hybris.platform.acceleratorservices.data.RequestContextData;
import de.hybris.platform.acceleratorservices.util.SpringHelper;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.interceptors.BeforeViewHandler;
import de.hybris.platform.cms2.jalo.preview.PreviewData;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import de.hybris.platform.cms2.model.contents.contentslot.ContentSlotModel;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.cms2.model.pages.PageTemplateModel;
import de.hybris.platform.cms2.model.preview.CMSPreviewTicketModel;
import de.hybris.platform.cms2.model.preview.PreviewDataModel;
import de.hybris.platform.cms2.servicelayer.data.ContentSlotData;
import de.hybris.platform.cms2.servicelayer.data.RestrictionData;
import de.hybris.platform.cms2.servicelayer.services.CMSPageService;
import de.hybris.platform.cms2.servicelayer.services.CMSPreviewService;
import de.hybris.platform.cms2.servicelayer.services.CMSSiteService;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.jalo.c2l.LocalizableItem;
import de.hybris.platform.servicelayer.model.AbstractItemModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.store.services.BaseStoreService;
import de.hybris.sdh.core.model.SdhAccesoMenuContrib1Model;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.questions.data.SDHAgentData;
import de.hybris.sdh.facades.questions.data.SDHRolData;
import de.hybris.sdh.storefront.filters.cms.CMSSiteFilter;
import de.hybris.sdh.storefront.forms.UIMenuForm;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.ModelAndView;


/**
 * Filter to load the appropriate Cms page slots into the model
 */
public class CmsPageBeforeViewHandler implements BeforeViewHandler
{
	private static final Logger LOG = Logger.getLogger(CmsPageBeforeViewHandler.class);

	private static final String CSS_CODE_PREFIX = "page-";
	private static final String CSS_LABEL_PREFIX = "pageLabel-";
	private static final String CSS_TYPE_PREFIX = "pageType-";
	private static final String CSS_TEMPLATE_PREFIX = "template-";

	private static final String RECAPTCHA_SITE_KEY_PROPERTY = "recaptcha.publickey";

	@Resource(name = "cmsSiteService")
	private CMSSiteService cmsSiteService;

	@Resource(name = "cmsPageService")
	private CMSPageService cmsPageService;

	@Resource(name = "cmsPreviewService")
	private CMSPreviewService cmsPreviewService;

	@Resource(name = "sessionService")
	private SessionService sessionService;

	@Resource(name = "cmsPageContextService")
	private CMSPageContextService cmsPageContextService;

	@Resource(name = "requestContextRestrictionConverter")
	private Converter<RequestContextData, RestrictionData> requestContextRestrictionConverter;

	@Resource(name = "typeService")
	private TypeService typeService;

	@Resource(name = "reqAddOnsNameProvider")
	private RequiredAddOnsNameProvider requiredAddOnsNameProvider;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name = "baseStoreService")
	BaseStoreService baseStoreService;

	@Resource(name = "siteConfigService")
	SiteConfigService siteConfigService;

	@Resource(name="sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;

	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService defaultFlexibleSearchService;

	@Resource(name = "userService")
	private UserService userService;

	@Override
	public void beforeView(final HttpServletRequest request, final HttpServletResponse response, final ModelAndView modelAndView)
	{
		modelAndView.addObject("cmsSite", cmsSiteService.getCurrentSite());
		modelAndView.addObject("currentURL", request.getRequestURI());
		// Look for the page in the model
		final AbstractPageModel page = updateCmsPageInModelAndView(request, modelAndView);

		modelAndView.addObject("pageBodyCssClasses", buildCssClasses(page));
		if (page != null)
		{
			final List<String> dependantAddOns = requiredAddOnsNameProvider
					.getAddOns(request.getServletContext().getServletContextName());

			final Set<String> actionJsFiles = new HashSet();

			final Collection<ContentSlotData> contentSlotsForPage = cmsPageService.getContentSlotsForPage(page);
			for (final ContentSlotData contentSlotData : contentSlotsForPage)
			{
				final ContentSlotModel contentSlot = contentSlotData.getContentSlot();
				final List<AbstractCMSComponentModel> cmsComponents = contentSlot.getCmsComponents();
				addCmsComponentActions(actionJsFiles, cmsComponents, dependantAddOns);
			}
			modelAndView.addObject("cmsActionsJsFiles", actionJsFiles);
		}

		// Create the restriction data
		final RequestContextData requestContextData = SpringHelper.getSpringBean(request, "requestContextData",
				RequestContextData.class, true);
		final RestrictionData restrictionData = requestContextRestrictionConverter.convert(requestContextData);

		// Initialise CMS support
		final CmsPageRequestContextData cmsPageRequestContextData = cmsPageContextService.updateCmsPageContextForPage(request,
				page, restrictionData);
		modelAndView.addObject("cmsPageRequestContextData", cmsPageRequestContextData);

		sessionService.setAttribute(LocalizableItem.LANGUAGE_FALLBACK_ENABLED, Boolean.TRUE);
		sessionService.setAttribute(AbstractItemModel.LANGUAGE_FALLBACK_ENABLED_SERVICE_LAYER, Boolean.TRUE);

		final CustomerData customerData = customerFacade.getCurrentCustomer();

		modelAndView.addObject("docType", customerData.getDocumentType());
		modelAndView.addObject("docNumber", customerData.getDocumentNumber());

		if (!"anonymous".equalsIgnoreCase(customerData.getUid()))
		{

			for (final SDHRolData eachRolData : customerData.getRolList()) {
				if ("01".equals(eachRolData.getRol())) {
					modelAndView.addObject("hasCORol", true);
				} else if ("02".equals(eachRolData.getRol())) {
					modelAndView.addObject("hasAARol", true);
				}
				else if (eachRolData.getRol() != null && eachRolData.getRol().startsWith("03") && eachRolData.getRol().length() >= 3)
				{
					modelAndView.addObject("hasTARol_" + eachRolData.getRol().substring(3), true);
				} else if ("04".equals(eachRolData.getRol())) {
					modelAndView.addObject("hasARRol", true);
				} else if ("05".equals(eachRolData.getRol())) {
					modelAndView.addObject("hasRIRol", true);
				}
			}

			final UIMenuForm uiMenuForm = new UIMenuForm();

			final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

			uiMenuForm.fillForm(customerData, customerModel);
			uiMenuForm.setbNoFiltrarMenuContrib(determinarFiltroMenuContrib(customerData));
			modelAndView.addObject("uiMenuForm", uiMenuForm);
			if(sessionService.getAttribute("representado")!= null) {

				final String representado = sessionService.getAttribute("representado");

				final SDHValidaMailRolResponse representadoData = sdhCustomerFacade.getRepresentadoFromSAP(representado, "01,02");

				modelAndView.addObject("representado", representadoData);

				String aamenus = "";

				for (final SDHAgentData eachAgent : customerData.getAgentList())
				{
					if (representadoData.getInfoContrib().getNumBP().equalsIgnoreCase(eachAgent.getBp()) || StringUtils
							.leftPad(representadoData.getInfoContrib().getNumBP(), 10, "0").equalsIgnoreCase(eachAgent.getBp()))
					{
						if (eachAgent.getMenu() != null)
						{
							aamenus = eachAgent.getMenu();
						break;
						}
					}

				}


				modelAndView.addObject("aamenus",aamenus);

			}

		}

		if (request != null)
		{
			final boolean captchaEnabledForCurrentStore = isCaptchaEnabledForCurrentStore();
			request.setAttribute("captchaEnabledForCurrentStore", Boolean.valueOf(captchaEnabledForCurrentStore));
			if (captchaEnabledForCurrentStore)
			{
				request.setAttribute("recaptchaPublicKey", siteConfigService.getProperty(RECAPTCHA_SITE_KEY_PROPERTY));
			}
		}

	}

	/**
	 * @param customerData
	 * @return
	 */
	private Boolean determinarFiltroMenuContrib(final CustomerData customerData)
	{
		Boolean flagFiltro = null;
		if (customerData != null && customerData.getNumBP() != null)
		{
			final Map<String, String> tablaBPsValidos = new HashMap<String, String>();
			final String query2 =
					"SELECT {" + SdhAccesoMenuContrib1Model.PK + "}, " + "{" + SdhAccesoMenuContrib1Model.BP + "} " + "FROM {"
							+ SdhAccesoMenuContrib1Model._TYPECODE + "} " + "WHERE {" + SdhAccesoMenuContrib1Model.BP + "} = ?bp "
							+
							"AND {" + SdhAccesoMenuContrib1Model.ACTIVEFLAG + "} = 'true'";

			final Map<String, Object> params = new HashMap<String, Object>();
			params.put("bp", customerData.getNumBP());

			final FlexibleSearchQuery searchQuery2 = new FlexibleSearchQuery(query2, params);
			final SearchResult<SdhAccesoMenuContrib1Model> searchResult2 = defaultFlexibleSearchService.search(searchQuery2);
			final SdhAccesoMenuContrib1Model itemRead = null;
			final List<SdhAccesoMenuContrib1Model> resultado = searchResult2.getResult();

			for (final SdhAccesoMenuContrib1Model itemRead2 : resultado)
			{
				if (itemRead2 != null && customerData.getNumBP().equals(itemRead2.getBp()))
				{
					tablaBPsValidos.put(customerData.getNumBP(), "true");
				}
			}
			if (tablaBPsValidos.get(customerData.getNumBP()) != null)
			{
				flagFiltro = true;
			}
		}

		return flagFiltro;
	}

	protected boolean isCaptchaEnabledForCurrentStore()
	{
		final BaseStoreModel currentBaseStore = baseStoreService.getCurrentBaseStore();
		return currentBaseStore != null && Boolean.TRUE.equals(currentBaseStore.getCaptchaCheckEnabled());
	}

	protected String getNameOfComponentExtension(final AbstractCMSComponentModel component)
	{
		return typeService.getComposedTypeForCode(component.getItemtype()).getExtensionName();
	}

	protected void addCmsComponentActions(final Set<String> actonJsFiles, final List<AbstractCMSComponentModel> cmsComponents,
			final List<String> dependantAddOns)
	{
		for (final AbstractCMSComponentModel cmsComponent : cmsComponents)
		{
			final List<AbstractCMSActionModel> actions = cmsComponent.getActions();
			for (final AbstractCMSActionModel action : actions)
			{
				// exclude actions defined in addons
				final String extension = getNameOfComponentExtension(action);
				if (!dependantAddOns.contains(extension))
				{
					actonJsFiles.add(StringUtils.lowerCase(action.getItemtype()) + ".js");
				}
			}
		}
	}

	protected AbstractPageModel updateCmsPageInModelAndView(final HttpServletRequest request, final ModelAndView modelAndView)
	{
		// Look for the page in the model
		final AbstractPageModel requestedPage = (AbstractPageModel) modelAndView.getModel().get(
				AbstractPageController.CMS_PAGE_MODEL);
		if (requestedPage != null)
		{
			final AbstractPageModel previewPage = lookupPreviewPage(request);
			if (previewPage != null && !previewPage.equals(requestedPage))
			{
				// Have a preview page that overrides the current page

				// Check that the preview page is the same type as the expected page
				if (!requestedPage.getClass().isInstance(previewPage))
				{
					LOG.error("Preview page is of type [" + previewPage.getClass().getName() + "] expected page of type ["
							+ requestedPage.getClass().getName() + "]");
				}
				else
				{
					// Push the preview page into the model
					LOG.info("Replaced page [" + requestedPage + "] with preview page [" + previewPage + "]");
					modelAndView.addObject(AbstractPageController.CMS_PAGE_MODEL, previewPage);

					assignViewForPreviewPage(modelAndView, requestedPage, previewPage);

					return previewPage;
				}
			}
		}
		return requestedPage;
	}

	protected void assignViewForPreviewPage(final ModelAndView modelAndView, final AbstractPageModel requestedPage,
			final AbstractPageModel previewPage)
	{
		// Check to see if we are using the default view for the page
		if (modelAndView.getViewName() != null && modelAndView.getViewName().equals(getViewForPage(requestedPage)))
		{
			final String viewForPreviewPage = getViewForPage(previewPage);
			if (viewForPreviewPage != null && !viewForPreviewPage.equals(modelAndView.getViewName()))
			{
				// Change the view name
				LOG.info("Changing view from [" + modelAndView.getViewName() + "] to preview view [" + viewForPreviewPage + "]");
				modelAndView.setViewName(viewForPreviewPage);
			}
		}
	}

	protected String buildCssClasses(final AbstractPageModel page)
	{
		if (page == null)
		{
			return "";
		}

		final String regEx = "[^a-zA-Z0-9-]";
		final StringBuilder cssClasses = new StringBuilder();
		cssClasses.append(CSS_CODE_PREFIX).append(page.getUid().replaceAll(regEx, "-"));
		cssClasses.append(' ');
		cssClasses.append(CSS_TYPE_PREFIX).append(page.getTypeCode().replaceAll(regEx, "-"));
		cssClasses.append(' ');
		cssClasses.append(CSS_TEMPLATE_PREFIX).append(getViewForPage(page).replaceAll(regEx, "-"));
		cssClasses.append(' ');

		if (ContentPageModel.class.equals(page.getClass()))
		{
			final ContentPageModel contentPage = (ContentPageModel) page;
			if (contentPage.getLabel() != null)
			{
				cssClasses.append(CSS_LABEL_PREFIX).append(contentPage.getLabel().replaceAll(regEx, "-"));
			}
		}

		return cssClasses.toString();
	}

	/**
	 * Retrieves a preview ticket, if available and retrieves the preview page from the {@link PreviewData}
	 *
	 * @param request
	 * @return preview page
	 */
	protected AbstractPageModel lookupPreviewPage(final HttpServletRequest request)
	{
		final String previewTicketId = request.getParameter(CMSSiteFilter.PREVIEW_TICKET_ID_PARAM);
		if (previewTicketId != null && !previewTicketId.isEmpty())
		{
			final CMSPreviewTicketModel previewTicket = cmsPreviewService.getPreviewTicket(previewTicketId);
			if (previewTicket != null)
			{
				final PreviewDataModel previewData = previewTicket.getPreviewData();
				if (previewData != null)
				{
					return previewData.getPage();
				}
			}
		}
		return null;
	}

	/**
	 * Returns ths view name for the page by retrieving the frontendTemplateName from the masterTemplate of the page
	 *
	 * @param page
	 * @return view name or null, if the view name cannot retrieved from the masterTemplate
	 */
	protected String getViewForPage(final AbstractPageModel page)
	{
		if (page != null)
		{
			final PageTemplateModel masterTemplate = page.getMasterTemplate();
			if (masterTemplate != null)
			{
				final String targetPage = cmsPageService.getFrontendTemplateName(masterTemplate);
				if (targetPage != null && !targetPage.isEmpty())
				{
					return AbstractPageController.PAGE_ROOT + targetPage;
				}
			}
		}
		return null;
	}
}

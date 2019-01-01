/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 */

package de.hybris.platform.sdhpsaddon.controllers.pages;

import de.hybris.platform.acceleratorfacades.flow.impl.SessionOverrideCheckoutFlowFacade;
import de.hybris.platform.acceleratorservices.controllers.page.PageType;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.forms.GuestRegisterForm;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.enums.CustomerType;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.sdhpsaddon.controllers.imported.AcceleratorCheckoutController;
import de.hybris.platform.publicsectorfacades.bundle.selection.BundleSelectionFacade;
import de.hybris.platform.publicsectorfacades.order.PSCheckoutFacade;
import de.hybris.platform.publicsectorfacades.product.PSProductFacade;
import de.hybris.platform.publicsectorfacades.template.PSYFormTemplateFacade;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * CheckoutController.
 */
public class CheckoutController extends AcceleratorCheckoutController
{
	private static final Logger LOG = LoggerFactory.getLogger(CheckoutController.class);

	/**
	 * We use this suffix pattern because of an issue with Spring 3.1 where a Uri value is incorrectly extracted if it
	 * contains on or more '.' characters. Please see https://jira.springsource.org/browse/SPR-6164 for a discussion on
	 * the issue and future resolution.
	 */
	private static final String CHECKOUT_ORDER_CONFIRMATION_CMS_PAGE_LABEL = "orderConfirmation";
	private static final String CONTINUE_URL_KEY = "continueUrl";
	private static final String USER_TYPE = "userType";

	protected static final String ORDER_CODE_PATH_VARIABLE_PATTERN = "{orderCode:.*}";

	@Resource(name = "productFacade")
	private ProductFacade productFacade;

	@Resource(name = "bundleSelectionFacade")
	private BundleSelectionFacade bundleSelectionFacade;

	@Resource(name = "psYFormTemplateFacade")
	private PSYFormTemplateFacade psYFormTemplateFacade;

	@Resource(name = "psProductFacade")
	private PSProductFacade psProductFacade;

	@Resource(name = "psCheckoutFacade")
	private PSCheckoutFacade psCheckoutFacade;

	@RequestMapping(value = "/orderConfirmation/" + ORDER_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	@Override
	public String orderConfirmation(@PathVariable("orderCode") final String orderCode, final HttpServletRequest request,
			final Model model) throws CMSItemNotFoundException
	{
		SessionOverrideCheckoutFlowFacade.resetSessionOverrides();
		return processOrderCode(orderCode, model, request);
	}

	@Override
	protected String processOrderCode(final String orderCode, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		final OrderData orderDetails = psCheckoutFacade.getOrderDetailsForCode(orderCode);

		if (orderDetails.getEntries() != null && !orderDetails.getEntries().isEmpty())
		{
			for (final OrderEntryData entry : orderDetails.getEntries())
			{
				final String productCode = entry.getProduct().getCode();
				final ProductData product = productFacade.getProductForCodeAndOptions(productCode,
						Arrays.asList(ProductOption.BASIC, ProductOption.PRICE, ProductOption.CATEGORIES));
				entry.setProduct(product);
			}
		}

		model.addAttribute("orderCode", orderCode);
		model.addAttribute("orderData", orderDetails);
		model.addAttribute("allItems", orderDetails.getEntries());
		model.addAttribute("deliveryAddress", orderDetails.getDeliveryAddress());
		model.addAttribute("deliveryMode", orderDetails.getDeliveryMode());
		model.addAttribute("paymentInfo", orderDetails.getPaymentInfo());
		model.addAttribute("pageType", PageType.ORDERCONFIRMATION.name());
		storeServiceRelatedDataInModel(model, orderDetails);

		String emailId;
		if (orderDetails.isGuestCustomer() && !model.containsAttribute("guestRegisterForm"))
		{
			final GuestRegisterForm guestRegisterForm = new GuestRegisterForm();
			guestRegisterForm.setOrderCode(orderDetails.getGuid());
			emailId = StringUtils.substringAfter(orderDetails.getUser().getUid(), "|");
			guestRegisterForm.setUid(orderDetails.getUser().getUid());
			model.addAttribute(guestRegisterForm);
			model.addAttribute(USER_TYPE, CustomerType.GUEST);
		}
		else if (orderDetails.isUnidentifiedCustomer())
		{
			emailId = null;
			model.addAttribute("unidentified", Boolean.TRUE);
			model.addAttribute(USER_TYPE, CustomerType.UNIDENTIFIED);
		}
		else
		{
			emailId = orderDetails.getUser().getUid();
			model.addAttribute(USER_TYPE, CustomerType.REGISTERED);
		}
		model.addAttribute("email", emailId);

		final String continueUrl = (String) getSessionService().getAttribute(WebConstants.CONTINUE_URL);
		model.addAttribute(CONTINUE_URL_KEY, (continueUrl != null && !continueUrl.isEmpty()) ? continueUrl : ROOT);

		final AbstractPageModel cmsPage = getContentPageForLabelOrId(CHECKOUT_ORDER_CONFIRMATION_CMS_PAGE_LABEL);
		storeCmsPageInModel(model, cmsPage);
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CHECKOUT_ORDER_CONFIRMATION_CMS_PAGE_LABEL));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return ControllerConstants.Views.Pages.Checkout.CheckoutConfirmationPage;
	}

	protected void storeServiceRelatedDataInModel(final Model model, final AbstractOrderData orderData)
	{
		if (!CollectionUtils.isEmpty(orderData.getEntries()))
		{
			final ProductData productData = getPsProductFacade().getServiceProductForOrderCode(orderData.getCode());
			model.addAttribute("serviceProduct", productData);
			model.addAttribute("consentDeclarations", productData.getConsentDeclarations());
			model.addAttribute("embeddedFormHtmlsReview", getPsYFormTemplateFacade().getYFormHTMLForService(orderData));
			model.addAttribute("bundleInfo", getBundleSelectionFacade().getSelectedBundlesInformationForCart(orderData));
		}
	}

	@ExceptionHandler(UnknownIdentifierException.class)
	public String handleUnknownIdentifierException(final UnknownIdentifierException exception, final HttpServletRequest request)
	{
		request.setAttribute("message", exception.getMessage());
		LOG.warn(exception.getMessage());
		return FORWARD_PREFIX + "/404";
	}

	protected BundleSelectionFacade getBundleSelectionFacade()
	{
		return this.bundleSelectionFacade;
	}

	protected PSYFormTemplateFacade getPsYFormTemplateFacade()
	{
		return psYFormTemplateFacade;
	}

	protected PSProductFacade getPsProductFacade()
	{
		return psProductFacade;
	}
}

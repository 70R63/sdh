/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.publicsectoracceleratoraddon.controllers.pages;


import de.hybris.platform.acceleratorfacades.product.data.ReadOnlyOrderGridData;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;
import de.hybris.platform.billfacades.bill.PSDocumentGenerationFacade;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegionData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.imported.AcceleratorAccountPageController;
import de.hybris.platform.publicsectoracceleratoraddon.security.PSOpenRedirectValidator;
import de.hybris.platform.publicsectorfacades.order.PSCheckoutFacade;
import de.hybris.platform.publicsectorfacades.order.impl.DefaultPSOrderFacade;
import de.hybris.platform.relationshipfacades.permission.PSPermissionFacade;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.util.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Extended Controller for account pages
 */
@RequestMapping("/my-account")
public class AccountPageController extends AcceleratorAccountPageController
{
	private static final Logger LOG = LoggerFactory.getLogger(AccountPageController.class);
	private static final String ALL_ORDER_HISTORY_CMS_PAGE = "allOrders";
	private static final String IS_RELATIONSHIP_DATA = "isRelationshipData";
	private static final String CURRENT_USER_ID = "currentUserId";
	private static final String FAILED_TO_GET_APPLICATIONS = "Failed to get applications. ";

	@Resource(name = "psCheckoutFacade")
	private PSCheckoutFacade psCheckoutFacade;

	@Resource(name = "psRelationshipfacade")
	private PSRelationshipFacade psRelationshipFacade;

	@Resource(name = "psDocumentGenerationFacade")
	PSDocumentGenerationFacade pSDocumentGenerationFacade;

	@Resource(name = "psOrderFacade")
	private DefaultPSOrderFacade psOrderFacade;

	@Resource(name = "psPermissionFacade")
	private PSPermissionFacade psPermissionFacade;

	@RequestMapping(value = "/allApplications", method = RequestMethod.GET)
	@RequireHardLogIn
	public String displayAllOrders(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", required = false) final String sortCode, final Model model) throws CMSItemNotFoundException
	{
		// Handle paged search results
		createOrdersData(page, showMode, sortCode, model, Integer.MAX_VALUE);

		storeCmsPageInModel(model, getContentPageForLabelOrId(ALL_ORDER_HISTORY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ALL_ORDER_HISTORY_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_ORDER_HISTORY));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute(CURRENT_USER_ID, getUser().getUid());

		return getViewForPage(model);
	}

	@RequestMapping(value = "/relationship/applications", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@RequireHardLogIn
	public String displayAllRelationshipOrders(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", required = false) final String sortCode,
			@RequestParam(value = "customerId", required = true) final String customerId, final Model model)
			throws CMSItemNotFoundException
	{
		try
		{
			if (customerId != null && psRelationshipFacade.getCustomerForPK(customerId) != null
					&& psPermissionFacade.isPermitted(getCustomerFacade().getCurrentCustomerUid(),
							psRelationshipFacade.getCustomerForPK(customerId).getUid(), PS_SERVICE_PRODUCT_TYPECODE))
			{
				// Handle paged search results
				createRelationshipOrdersData(customerId, page, showMode, sortCode, model, Integer.MAX_VALUE);

				storeCmsPageInModel(model, getContentPageForLabelOrId(ALL_ORDER_HISTORY_CMS_PAGE));
				setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ALL_ORDER_HISTORY_CMS_PAGE));
				model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_ORDER_HISTORY));
				model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
				model.addAttribute(IS_RELATIONSHIP_DATA, Boolean.TRUE);
				model.addAttribute("userData", psRelationshipFacade.getCustomerForPK(customerId));
				return getViewForPage(model);
			}
			else
			{
				LOG.error(FAILED_TO_GET_APPLICATIONS + getCustomerFacade().getCurrentCustomerUid()
						+ " does not have applications permission for " + customerId);
			}
		}
		catch (final RelationshipDoesNotExistException e)
		{
			LOG.error(FAILED_TO_GET_APPLICATIONS + getCustomerFacade().getCurrentCustomerUid()
					+ " does not have bills permission for " + customerId, e);
			return REDIRECT_PREFIX + "/";
		}
		return REDIRECT_PREFIX + "/";
	}

	@RequestMapping(value = "/select-suggested-address", method = RequestMethod.POST)
	public String doSelectSuggestedAddress(final AddressForm addressForm, final RedirectAttributes redirectModel)
	{
		final Set<String> resolveCountryRegions = org.springframework.util.StringUtils
				.commaDelimitedListToSet(Config.getParameter("resolve.country.regions"));

		final AddressData selectedAddress = new AddressData();
		selectedAddress.setId(addressForm.getAddressId());
		populateAddressData(addressForm, selectedAddress);

		final CountryData countryData = i18NFacade.getCountryForIsocode(addressForm.getCountryIso());
		selectedAddress.setCountry(countryData);

		if (resolveCountryRegions.contains(countryData.getIsocode()) && addressForm.getRegionIso() != null
				&& !StringUtils.isEmpty(addressForm.getRegionIso()))
		{
			final RegionData regionData = getI18NFacade().getRegion(addressForm.getCountryIso(), addressForm.getRegionIso());
			selectedAddress.setRegion(regionData);
		}

		if (resolveCountryRegions.contains(countryData.getIsocode()) && addressForm.getRegionIso() != null
				&& !StringUtils.isEmpty(addressForm.getRegionIso()))
		{
			final RegionData regionData = getI18NFacade().getRegion(addressForm.getCountryIso(), addressForm.getRegionIso());
			selectedAddress.setRegion(regionData);
		}

		if (Boolean.TRUE.equals(addressForm.getEditAddress()))
		{
			selectedAddress.setDefaultAddress(
					Boolean.TRUE.equals(addressForm.getDefaultAddress()) || userFacade.getAddressBook().size() <= 1);
			userFacade.editAddress(selectedAddress);
		}
		else
		{
			selectedAddress
					.setDefaultAddress(Boolean.TRUE.equals(addressForm.getDefaultAddress()) || userFacade.isAddressBookEmpty());
			userFacade.addAddress(selectedAddress);
		}
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "account.confirmation.address.added");
		return REDIRECT_TO_ADDRESS_BOOK_PAGE;
	}

	@RequestMapping(value = "/remove-address/" + ADDRESS_CODE_PATH_VARIABLE_PATTERN, method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeAddress(@PathVariable("addressCode") final String addressCode, final RedirectAttributes redirectModel,
			final HttpServletRequest request)
	{
		final AddressData addressData = new AddressData();
		addressData.setId(addressCode);
		userFacade.removeAddress(addressData);

		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "account.confirmation.address.removed");
		String redirectUrl = "/";
		if (PSOpenRedirectValidator.isValidDomain(request))
		{
			redirectUrl = request.getHeader("referer");
		}
		return REDIRECT_PREFIX + redirectUrl;
	}

	@RequestMapping(value = "/set-default-address/" + ADDRESS_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	@RequireHardLogIn
	public String setDefaultAddress(@PathVariable("addressCode") final String addressCode, final RedirectAttributes redirectModel)
	{
		final AddressData addressData = new AddressData();
		addressData.setDefaultAddress(true);
		addressData.setVisibleInAddressBook(true);
		addressData.setId(addressCode);
		userFacade.setDefaultAddress(addressData);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
				"account.confirmation.default.address.changed");
		return REDIRECT_TO_ADDRESS_BOOK_PAGE;
	}

	@RequestMapping(value = "/payment-details", method = RequestMethod.GET)
	@RequireHardLogIn
	public String paymentDetails(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("customerData", customerFacade.getCurrentCustomer());
		model.addAttribute("paymentInfoData", userFacade.getCCPaymentInfos(true));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PAYMENT_DETAILS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs("text.account.paymentDetails"));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/set-default-payment-details", method = RequestMethod.POST)
	@RequireHardLogIn
	public String setDefaultPaymentDetails(@RequestParam final String paymentInfoId)
	{
		CCPaymentInfoData paymentInfoData = null;
		if (StringUtils.isNotBlank(paymentInfoId))
		{
			paymentInfoData = userFacade.getCCPaymentInfoForCode(paymentInfoId);
		}
		userFacade.setDefaultPaymentInfo(paymentInfoData);
		return REDIRECT_TO_PAYMENT_INFO_PAGE;
	}

	@RequestMapping(value = "/remove-payment-method", method = RequestMethod.POST)
	@RequireHardLogIn
	public String removePaymentMethod(@RequestParam(value = "paymentInfoId") final String paymentMethodId,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		userFacade.unlinkCCPaymentInfo(paymentMethodId);
		GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
				"text.account.profile.paymentCart.removed");
		return REDIRECT_TO_PAYMENT_INFO_PAGE;
	}

	@RequestMapping(value = "/application/" + ORDER_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	@RequireHardLogIn
	public String order(@PathVariable("orderCode") final String orderCode, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		OrderData orderDetails = null;
		try
		{
			orderDetails = psCheckoutFacade.getOrderDetailsForCode(orderCode);
			model.addAttribute("orderData", orderDetails);

			storeServiceRelatedDataInModel(model, orderDetails);

			if (!orderDetails.getUser().getUid().equals(getUser().getUid()))
			{
				model.addAttribute(IS_RELATIONSHIP_DATA, Boolean.TRUE);
			}
			else if (!StringUtils.isEmpty(orderDetails.getPlacedBy()))
			{
				model.addAttribute("placedByUser", psRelationshipFacade.getCustomerDataForUid(orderDetails.getPlacedBy()));
			}
			model.addAttribute(CURRENT_USER_ID, getUser().getUid());

			final List<Breadcrumb> breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs(null);
			breadcrumbs.add(new Breadcrumb("/my-account/applications",
					getMessageSource().getMessage(ACCOUNT_ORDER_HISTORY, null, getI18nService().getCurrentLocale()), null));
			breadcrumbs.add(new Breadcrumb("#", getMessageSource().getMessage("text.account.order.orderBreadcrumb", new Object[]
			{ orderDetails.getCode() }, "Order {0}", getI18nService().getCurrentLocale()), null));
			model.addAttribute(BREADCRUMBS_ATTR, breadcrumbs);
		}
		catch (final UnknownIdentifierException e)
		{
			LOG.warn("Attempted to load a order that does not exist or is not visible", e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "system.error.page.not.found", null);
			return REDIRECT_TO_ORDER_HISTORY_PAGE;
		}
		storeCmsPageInModel(model, getContentPageForLabelOrId(ORDER_DETAIL_CMS_PAGE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ORDER_DETAIL_CMS_PAGE));
		return getViewForPage(model);
	}

	@RequestMapping(value = "/order/" + ORDER_CODE_PATH_VARIABLE_PATTERN
			+ "/getReadOnlyProductVariantMatrix", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getProductVariantMatrixForResponsive(@PathVariable("orderCode") final String orderCode,
			@RequestParam("productCode") final String productCode, final Model model)
	{
		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode,
				Arrays.asList(ProductOption.BASIC, ProductOption.CATEGORIES));
		final String baseProductCode = productData.getBaseProduct();
		final OrderData orderData = orderFacade.getOrderDetailsForCodeWithoutUser(orderCode);
		final Optional<OrderEntryData> orderEntryDataOptional = orderData.getEntries().stream()
				.filter(orderEntryData -> orderEntryData.getProduct().getCode().equals(baseProductCode)).findFirst();
		final Map<String, ReadOnlyOrderGridData> readOnlyMultiDMap = orderGridFormFacade
				.getReadOnlyOrderGrid(orderEntryDataOptional.get().getEntries());
		model.addAttribute("readOnlyMultiDMap", readOnlyMultiDMap);

		return ControllerConstants.Views.Fragments.Checkout.ReadOnlyExpandedOrderForm;
	}

	@RequestMapping(value = "/loadRelationApplications", method = RequestMethod.GET)
	@RequireHardLogIn
	public String orders(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", required = false) final String sortCode,
			@RequestParam("customerId") final String customerId, final Model model) throws CMSItemNotFoundException
	{
		try
		{
			if (customerId != null && psRelationshipFacade.getCustomerForPK(customerId) != null
					&& psPermissionFacade.isPermitted(getCustomerFacade().getCurrentCustomerUid(),
							psRelationshipFacade.getCustomerForPK(customerId).getUid(), PS_SERVICE_PRODUCT_TYPECODE))
			{
				// Handle paged search results
				createRelationshipOrdersData(customerId, page, showMode, sortCode, model, maxDraftsToDisplay);
				createRelationshipDraftsData(customerId, model, maxDraftsToDisplay);
				model.addAttribute("userData", psRelationshipFacade.getCustomerForPK(customerId));
				model.addAttribute(IS_RELATIONSHIP_DATA, Boolean.TRUE);
				return ControllerConstants.Views.Fragments.Accounts.RelationshipApplicationsAjaxPage;
			}
			else
			{
				LOG.error(FAILED_TO_GET_APPLICATIONS + getCustomerFacade().getCurrentCustomerUid()
						+ " does not have applications permission for " + customerId);
			}
		}
		catch (final RelationshipDoesNotExistException e)
		{
			LOG.error(FAILED_TO_GET_APPLICATIONS + getCustomerFacade().getCurrentCustomerUid()
					+ " does not have bills permission for " + customerId, e);
		}
		return null;
	}

	/**
	 * Method to create relationship user's orders data
	 *
	 * @param page
	 * @param showMode
	 * @param sortCode
	 * @param model
	 * @param maxRows
	 */
	protected void createRelationshipOrdersData(final String customerId, final int page, final ShowMode showMode,
			final String sortCode, final Model model, final int maxRows)
	{
		// Handle paged search results
		final CustomerData customer = psRelationshipFacade.getCustomerForPK(customerId);
		final PageableData pageableData = createPageableData(page, maxRows, sortCode, showMode);
		final SearchPageData<OrderHistoryData> searchPageData = psOrderFacade.getPagedOrderHistoryForStatuses(customer.getUid(),
				pageableData);
		populateModel(model, searchPageData, showMode);
		if (searchPageData != null && searchPageData.getResults() != null && searchPageData.getPagination().getNumberOfPages() > 1)
		{
			model.addAttribute("showAllOrdersButton", Boolean.TRUE);
		}
		else
		{
			model.addAttribute("showAllOrdersButton", Boolean.FALSE);
		}
	}

	/**
	 * Method to create paged draft data
	 *
	 * @param model
	 * @param maxResults
	 */
	protected void createRelationshipDraftsData(final String customerId, final Model model, final int maxResults)
	{
		final CustomerData customer = psRelationshipFacade.getCustomerForPK(customerId);
		final PageableData pageableDataForCarts = new PageableData();
		pageableDataForCarts.setCurrentPage(0);
		pageableDataForCarts.setPageSize(maxResults);
		final List<OrderStatus> statuses = new ArrayList<>();
		final SearchPageData<CartData> savedCartData = psSaveCartFacade.getSavedCartsForGivenUser(pageableDataForCarts, statuses,
				customer.getUid());
		model.addAttribute("drafts", savedCartData.getResults());
		if (savedCartData.getResults() != null && savedCartData.getPagination().getNumberOfPages() > 1)
		{
			model.addAttribute("showAllDraftsButton", Boolean.TRUE);
		}
		else
		{
			model.addAttribute("showAllDraftsButton", Boolean.FALSE);
		}
	}
}

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
package de.hybris.platform.sdhpsaddon.controllers.imported;

import de.hybris.platform.acceleratorfacades.ordergridform.OrderGridFormFacade;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdateEmailForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdatePasswordForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdateProfileForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.AddressValidator;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.EmailValidator;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.PasswordValidator;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.ProfileValidator;
import de.hybris.platform.acceleratorstorefrontcommons.forms.verification.AddressVerificationResultHandler;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.address.AddressVerificationFacade;
import de.hybris.platform.commercefacades.address.data.AddressVerificationResult;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.i18n.I18NFacade;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.SaveCartFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.TitleData;
import de.hybris.platform.commercefacades.user.exceptions.PasswordMismatchException;
import de.hybris.platform.commerceservices.address.AddressVerificationDecision;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.publicsectorfacades.bundle.selection.BundleSelectionFacade;
import de.hybris.platform.publicsectorfacades.order.PSCartFacade;
import de.hybris.platform.publicsectorfacades.order.impl.DefaultPSSaveCartFacade;
import de.hybris.platform.publicsectorfacades.template.PSYFormTemplateFacade;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.sdhpsaddon.controllers.pages.AccountPageController;
import de.hybris.platform.sdhpsaddon.security.PSOpenRedirectValidator;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for account pages
 */
@Scope("tenant")
//@RequestMapping("/my-account")
public class AcceleratorAccountPageController extends AbstractSearchPageController
{
	protected static final Logger LOG = LoggerFactory.getLogger(AccountPageController.class);
	protected static final String ADDRESS_BOOK_PERMISSIBLE_AREA = "Address";
	protected static final String TEXT_ACCOUNT_ADDRESS_BOOK = "text.account.addressBook";
	protected static final String BREADCRUMBS_ATTR = "breadcrumbs";
	protected static final String IS_DEFAULT_ADDRESS_ATTR = "isDefaultAddress";
	protected static final String COUNTRY_DATA_ATTR = "countryData";
	protected static final String ADDRESS_BOOK_EMPTY_ATTR = "addressBookEmpty";
	protected static final String TITLE_DATA_ATTR = "titleData";
	protected static final String FORM_GLOBAL_ERROR = "form.global.error";
	protected static final String PROFILE_CURRENT_PASSWORD_INVALID = "profile.currentPassword.invalid"; // NOSONAR
	protected static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";
	protected static final String ADDRESS_DATA_ATTR = "addressData";
	protected static final String ALL_RELATIONSHIPS = "allRelationships";
	protected static final String ADDRESS_FORM_ATTR = "addressForm";
	protected static final String COUNTRY_ATTR = "country";
	protected static final String REGIONS_ATTR = "regions";
	protected static final String MY_ACCOUNT_ADDRESS_BOOK_URL = "/my-account/address-book";
	protected static final String ACCOUNT_ORDER_HISTORY = "text.account.applications";
	protected static final String PS_SERVICE_PRODUCT_TYPECODE = "PSServiceProduct";
	protected static final String BREADCRUMB_UPDATE_PASSWORD = "text.account.profile.updatePasswordForm";

	// Max number of drafts to display on order history page
	protected static int maxDraftsToDisplay = 3;

	// Internal Redirects
	protected static final String REDIRECT_TO_ADDRESS_BOOK_PAGE = REDIRECT_PREFIX + MY_ACCOUNT_ADDRESS_BOOK_URL;
	protected static final String REDIRECT_TO_PAYMENT_INFO_PAGE = REDIRECT_PREFIX + "/my-account/payment-details";
	protected static final String REDIRECT_TO_EDIT_ADDRESS_PAGE = REDIRECT_PREFIX + "/my-account/edit-address/";
	protected static final String REDIRECT_TO_MY_ACCOUNT = REDIRECT_PREFIX + "/my-account";
	protected static final String REDIRECT_TO_ORDER_HISTORY_PAGE = REDIRECT_PREFIX + "/my-account/applications";

	/**
	 * We use this suffix pattern because of an issue with Spring 3.1 where a Uri value is incorrectly extracted if it
	 * contains on or more '.' characters. Please see https://jira.springsource.org/browse/SPR-6164 for a discussion on
	 * the issue and future resolution.
	 */
	protected static final String ORDER_CODE_PATH_VARIABLE_PATTERN = "{orderCode:.*}";
	protected static final String ADDRESS_CODE_PATH_VARIABLE_PATTERN = "{addressCode:.*}";

	// CMS Pages
	protected static final String ACCOUNT_CMS_PAGE = "account";
	protected static final String PROFILE_CMS_PAGE = "profile";
	protected static final String UPDATE_PASSWORD_CMS_PAGE = "updatePassword"; // NOSONAR
	protected static final String UPDATE_PROFILE_CMS_PAGE = "update-profile";
	protected static final String UPDATE_EMAIL_CMS_PAGE = "update-email";
	protected static final String ADDRESS_BOOK_CMS_PAGE = "address-book";
	protected static final String ADD_EDIT_ADDRESS_CMS_PAGE = "add-edit-address";
	protected static final String PAYMENT_DETAILS_CMS_PAGE = "payment-details";
	protected static final String ORDER_HISTORY_CMS_PAGE = "orders";
	protected static final String ORDER_DETAIL_CMS_PAGE = "order";

	private static final String LAST_REFERER_SOURCE = "source";
	private static final String REDIRECT_URL = "redirectUrl";
	private static final String REQUEST_HEADER_REFERER = "referer";

	//Consent Management
	private static final String TEXT_ACCOUNT_CONSENT_MANAGEMENT = "text.account.consent.consentManagement";
	private static final String TEXT_ACCOUNT_CONSENT_GIVEN = "text.account.consent.given";
	private static final String TEXT_ACCOUNT_CONSENT_WITHDRAWN = "text.account.consent.withdrawn";
	private static final String TEXT_ACCOUNT_CONSENT_NOT_FOUND = "text.account.consent.notFound";
	private static final String TEXT_ACCOUNT_CONSENT_TEMPLATE_NOT_FOUND = "text.account.consent.template.notFound";
	private static final String CONSENT_MANAGEMENT_CMS_PAGE = "consents";
	private static final String REDIRECT_TO_CONSENT_MANAGEMENT = REDIRECT_PREFIX + "/my-account/consents";

	private static final String BREADCRUMB_ADD_EDIT_ADDRESS_PAGE = "text.account.addressBook.addEditAddress";
	//Close Account
	private static final String CLOSE_ACCOUNT_CMS_PAGE = "close-account";
	private static final String TEXT_ACCOUNT_CLOSE = "text.account.close";

	@Resource(name = "orderFacade")
	protected OrderFacade orderFacade;

	@Resource(name = "acceleratorCheckoutFacade")
	protected CheckoutFacade checkoutFacade;

	@Resource(name = "userFacade")
	protected UserFacade userFacade;

	@Resource(name = "customerFacade")
	protected CustomerFacade customerFacade;

	@Resource(name = "psMyAccountBreadcrumbBuilder")
	protected ResourceBreadcrumbBuilder accountBreadcrumbBuilder;


	@Resource(name = "passwordValidator")
	protected PasswordValidator passwordValidator;

	@Resource(name = "addressValidator")
	protected AddressValidator addressValidator;

	@Resource(name = "profileValidator")
	protected ProfileValidator profileValidator;

	@Resource(name = "emailValidator")
	protected EmailValidator emailValidator;

	@Resource(name = "i18NFacade")
	protected I18NFacade i18NFacade;

	@Resource(name = "addressVerificationFacade")
	protected AddressVerificationFacade addressVerificationFacade;

	@Resource(name = "addressVerificationResultHandler")
	protected AddressVerificationResultHandler addressVerificationResultHandler;

	@Resource(name = "productVariantFacade")
	protected ProductFacade productFacade;

	@Resource(name = "orderGridFormFacade")
	protected OrderGridFormFacade orderGridFormFacade;

	@Resource
	protected SaveCartFacade saveCartFacade;

	@Resource(name = "psCartFacade")
	protected PSCartFacade cartFacade;

	@Resource(name = "psSaveCartFacade")
	protected DefaultPSSaveCartFacade psSaveCartFacade;

	@Resource(name = "bundleSelectionFacade")
	protected BundleSelectionFacade bundleSelectionFacade;

	@Resource(name = "psYFormTemplateFacade")
	protected PSYFormTemplateFacade psYFormTemplateFacade;

	@Resource(name = "psRelationshipfacade")
	private PSRelationshipFacade psRelationshipFacade;

	@ModelAttribute("countries")
	public Collection<CountryData> getCountries()
	{
		return checkoutFacade.getDeliveryCountries();
	}

	@ModelAttribute("titles")
	public Collection<TitleData> getTitles()
	{
		return userFacade.getTitles();
	}

	@ModelAttribute("countryDataMap")
	public Map<String, CountryData> getCountryDataMap()
	{
		final Map<String, CountryData> countryDataMap = new HashMap<>();
		for (final CountryData countryData : getCountries())
		{
			countryDataMap.put(countryData.getIsocode(), countryData);
		}
		return countryDataMap;
	}

	@RequestMapping(value = "/addressform", method = RequestMethod.GET)
	public String getCountryAddressForm(@RequestParam("addressCode") final String addressCode,
			@RequestParam("countryIsoCode") final String countryIsoCode, final Model model,
			@RequestParam(value = "usePrimaryAddress", required = false) final boolean usePrimaryAddress,
			@RequestParam(value = "useDeliveryAddress", required = false) final boolean useDeliveryAddress)
	{
		model.addAttribute("supportedCountries", getCountries());

		if (countryIsoCode != null && !countryIsoCode.isEmpty())
		{
			model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(countryIsoCode));
			model.addAttribute(COUNTRY_ATTR, countryIsoCode);
		}

		final AddressForm addressForm = new AddressForm();
		model.addAttribute(ADDRESS_FORM_ATTR, addressForm);
		AddressData addressData = new AddressData();

		if (usePrimaryAddress)
		{
			addressData = userFacade.getDefaultAddress();

			model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(addressData.getCountry().getIsocode()));
			model.addAttribute(COUNTRY_ATTR, addressData.getCountry().getIsocode());
		}
		else if (useDeliveryAddress)
		{
			addressData = checkoutFacade.getDeliveryAddressForCode(addressCode);
		}
		else
		{
			for (final AddressData userAddressData : userFacade.getAddressBook())
			{
				if (userAddressData.getId() != null && userAddressData.getId().equals(addressCode) && countryIsoCode != null
						&& countryIsoCode.equals(userAddressData.getCountry().getIsocode()))
				{
					addressData = userAddressData;
					model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(countryIsoCode));
					model.addAttribute(COUNTRY_ATTR, countryIsoCode);
					break;
				}
			}
		}

		if (addressData.getCountry() != null)
		{
			model.addAttribute(ADDRESS_DATA_ATTR, addressData);
			setUpAddressForm(addressForm, addressData);
		}

		return ControllerConstants.Views.Fragments.Account.CountryAddressForm;
	}

	/**
	 * @param addressForm
	 * @param addressData
	 */
	private void setUpAddressForm(final AddressForm addressForm, final AddressData addressData)
	{
		addressForm.setAddressId(addressData.getId());
		addressForm.setTitleCode(addressData.getTitleCode());
		addressForm.setFirstName(addressData.getFirstName());
		addressForm.setLastName(addressData.getLastName());
		addressForm.setLine1(addressData.getLine1());
		addressForm.setLine2(addressData.getLine2());
		addressForm.setTownCity(addressData.getTown());
		addressForm.setPostcode(addressData.getPostalCode());
		addressForm.setCountryIso(addressData.getCountry().getIsocode());
		addressForm.setPhone(addressData.getPhone());
		if (addressData.getRegion() != null && !StringUtils.isEmpty(addressData.getRegion().getIsocode()))
		{
			addressForm.setRegionIso(addressData.getRegion().getIsocode());
		}
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	@RequireHardLogIn
	public String orders(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", required = false) final String sortCode, final Model model) throws CMSItemNotFoundException
	{
		// Handle paged search results
		createOrdersData(page, showMode, sortCode, model, maxDraftsToDisplay);
		storeCmsPageInModel(model, getContentPageForLabelOrId(ORDER_HISTORY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ORDER_HISTORY_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(ACCOUNT_ORDER_HISTORY));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		createDraftsData(model, maxDraftsToDisplay);
		model.addAttribute("currentUserId", getUser().getUid());

		final List<CustomerData> relations = psRelationshipFacade
				.getRelationshipUsersForUserAndPermissibleItemType(getUser().getUid(), PS_SERVICE_PRODUCT_TYPECODE);

		if (CollectionUtils.isNotEmpty(relations))
		{
			final List<CustomerData> allRelationshipsUsers = new ArrayList<>();

			for (final CustomerData currentRelationCustomer : relations)
			{
				allRelationshipsUsers.add(currentRelationCustomer);
			}
			model.addAttribute("allRelationshipsUsers", allRelationshipsUsers);
		}
		return getViewForPage(model);
	}

	/**
	 * Method to create orders data
	 *
	 * @param page
	 * @param showMode
	 * @param sortCode
	 * @param model
	 * @param maxRows
	 */
	protected void createOrdersData(final int page, final ShowMode showMode, final String sortCode, final Model model,
			final int maxRows)
	{
		// Handle paged search results
		final PageableData pageableData = createPageableData(page, maxRows, sortCode, showMode);
		final SearchPageData<OrderHistoryData> searchPageData = orderFacade.getPagedOrderHistoryForStatuses(pageableData);
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
	protected void createDraftsData(final Model model, final int maxResults)
	{
		final PageableData pageableDataForCarts = new PageableData();
		pageableDataForCarts.setCurrentPage(0);
		pageableDataForCarts.setPageSize(maxResults);
		final List<OrderStatus> statuses = new ArrayList<>();
		final SearchPageData<CartData> savedCartData = psSaveCartFacade.getSavedCartsForGivenUser(pageableDataForCarts, statuses,
				getUser().getUid());
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

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	@RequireHardLogIn
	public String profile(final Model model) throws CMSItemNotFoundException
	{
		final List<TitleData> titles = userFacade.getTitles();

		final CustomerData customerData = customerFacade.getCurrentCustomer();
		if (customerData.getTitleCode() != null)
		{
			model.addAttribute("title", findTitleForCode(titles, customerData.getTitleCode()));
		}

		model.addAttribute("customerData", customerData);

		storeCmsPageInModel(model, getContentPageForLabelOrId(PROFILE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PROFILE_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}

	protected TitleData findTitleForCode(final List<TitleData> titles, final String code)
	{
		if (code != null && !code.isEmpty() && titles != null && !titles.isEmpty())
		{
			for (final TitleData title : titles)
			{
				if (code.equals(title.getCode()))
				{
					return title;
				}
			}
		}
		return null;
	}

	@RequestMapping(value = "/update-email", method = RequestMethod.GET)
	@RequireHardLogIn
	public String editEmail(final Model model) throws CMSItemNotFoundException
	{
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final UpdateEmailForm updateEmailForm = new UpdateEmailForm();

		updateEmailForm.setEmail(customerData.getDisplayUid());

		model.addAttribute("updateEmailForm", updateEmailForm);
		storeCmsPageInModel(model, getContentPageForLabelOrId(UPDATE_EMAIL_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(UPDATE_EMAIL_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/update-email", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updateEmail(final UpdateEmailForm updateEmailForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		getEmailValidator().validate(updateEmailForm, bindingResult);
		String returnAction = REDIRECT_TO_MY_ACCOUNT;

		if (!bindingResult.hasErrors() && !updateEmailForm.getEmail().equals(updateEmailForm.getChkEmail()))
		{
			bindingResult.rejectValue("chkEmail", "validation.checkEmail.equals", new Object[] {}, "validation.checkEmail.equals");
		}

		if (bindingResult.hasErrors())
		{
			returnAction = setErrorMessagesAndCMSPage(model, UPDATE_EMAIL_CMS_PAGE);
		}
		else
		{
			try
			{
				customerFacade.changeUid(updateEmailForm.getEmail(), updateEmailForm.getPassword());
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
						"text.account.profile.confirmationUpdated", null);

				// Replace the spring security authentication with the new UID
				final String newUid = customerFacade.getCurrentCustomer().getUid().toLowerCase();
				final Authentication oldAuthentication = SecurityContextHolder.getContext().getAuthentication();
				final UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(newUid, null,
						oldAuthentication.getAuthorities());
				newAuthentication.setDetails(oldAuthentication.getDetails());
				SecurityContextHolder.getContext().setAuthentication(newAuthentication);
			}
			catch (final DuplicateUidException e)
			{
				bindingResult.rejectValue("email", "profile.email.unique");
				returnAction = setErrorMessagesAndCMSPage(model, UPDATE_EMAIL_CMS_PAGE);
			}
			catch (final PasswordMismatchException passwordMismatchException)
			{
				bindingResult.rejectValue("password", PROFILE_CURRENT_PASSWORD_INVALID);
				returnAction = setErrorMessagesAndCMSPage(model, UPDATE_EMAIL_CMS_PAGE);
			}
		}
		return returnAction;
	}

	protected String setErrorMessagesAndCMSPage(final Model model, final String cmsPageLabelOrId) throws CMSItemNotFoundException
	{
		GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPageLabelOrId));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPageLabelOrId));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		return getViewForPage(model);
	}

	@RequestMapping(value = "/update-profile", method = RequestMethod.GET)
	@RequireHardLogIn
	public String editProfile(final Model model) throws CMSItemNotFoundException
	{
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final UpdateProfileForm updateProfileForm = new UpdateProfileForm();

		updateProfileForm.setTitleCode(customerData.getTitleCode());
		updateProfileForm.setFirstName(customerData.getFirstName());
		updateProfileForm.setLastName(customerData.getLastName());

		storeCmsPageInModel(model, getContentPageForLabelOrId(UPDATE_PROFILE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(UPDATE_PROFILE_CMS_PAGE));

		model.addAttribute(TITLE_DATA_ATTR, userFacade.getTitles());
		model.addAttribute("updateProfileForm", updateProfileForm);
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/update-profile", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updateProfile(final UpdateProfileForm updateProfileForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		getProfileValidator().validate(updateProfileForm, bindingResult);

		String returnAction = REDIRECT_TO_MY_ACCOUNT;
		final CustomerData currentCustomerData = customerFacade.getCurrentCustomer();
		final CustomerData customerData = new CustomerData();
		customerData.setTitleCode(updateProfileForm.getTitleCode());
		customerData.setFirstName(updateProfileForm.getFirstName());
		customerData.setLastName(updateProfileForm.getLastName());
		customerData.setUid(currentCustomerData.getUid());
		customerData.setDisplayUid(currentCustomerData.getDisplayUid());

		model.addAttribute(TITLE_DATA_ATTR, userFacade.getTitles());

		storeCmsPageInModel(model, getContentPageForLabelOrId(UPDATE_PROFILE_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(UPDATE_PROFILE_CMS_PAGE));

		if (bindingResult.hasErrors())
		{
			returnAction = setErrorMessagesAndCMSPage(model, UPDATE_PROFILE_CMS_PAGE);
		}
		else
		{
			try
			{
				customerFacade.updateProfile(customerData);
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
						"text.account.profile.confirmationUpdated", null);
			}
			catch (final DuplicateUidException e)
			{
				bindingResult.rejectValue("email", "registration.error.account.exists.title");
				returnAction = setErrorMessagesAndCMSPage(model, UPDATE_PROFILE_CMS_PAGE);
			}
		}
		return returnAction;
	}

	@RequestMapping(value = "/update-password", method = RequestMethod.GET)
	@RequireHardLogIn
	public String updatePassword(final Model model) throws CMSItemNotFoundException
	{
		final UpdatePasswordForm updatePasswordForm = new UpdatePasswordForm();

		model.addAttribute("updatePasswordForm", updatePasswordForm);

		storeCmsPageInModel(model, getContentPageForLabelOrId(UPDATE_PASSWORD_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(UPDATE_PASSWORD_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMB_UPDATE_PASSWORD));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/update-password", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updatePassword(final UpdatePasswordForm updatePasswordForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		getPasswordValidator().validate(updatePasswordForm, bindingResult);
		if (!bindingResult.hasErrors())
		{
			if (updatePasswordForm.getNewPassword().equals(updatePasswordForm.getCheckNewPassword()))
			{
				try
				{
					customerFacade.changePassword(updatePasswordForm.getCurrentPassword(), updatePasswordForm.getNewPassword());
				}
				catch (final PasswordMismatchException localException)
				{
					bindingResult.rejectValue("currentPassword", PROFILE_CURRENT_PASSWORD_INVALID, new Object[] {},
							PROFILE_CURRENT_PASSWORD_INVALID);
				}
			}
			else
			{
				bindingResult.rejectValue("checkNewPassword", "validation.checkPwd.equals", new Object[] {},
						"validation.checkPwd.equals");
			}
		}

		if (bindingResult.hasErrors())
		{
			GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
			storeCmsPageInModel(model, getContentPageForLabelOrId(UPDATE_PASSWORD_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(UPDATE_PASSWORD_CMS_PAGE));

			model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMB_UPDATE_PASSWORD));
			return getViewForPage(model);
		}
		else
		{
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
					"text.account.confirmation.password.updated", null);
			return REDIRECT_TO_MY_ACCOUNT;
		}
	}

	@RequestMapping(value = "/address-book", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getAddressBook(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute(ADDRESS_DATA_ATTR, userFacade.getAddressBook());

		final List<CustomerData> relActiveUsers = psRelationshipFacade
				.getRelationshipUsersForUserAndPermissibleItemType(getUser().getUid(), ADDRESS_BOOK_PERMISSIBLE_AREA);

		model.addAttribute(ALL_RELATIONSHIPS, relActiveUsers);

		storeCmsPageInModel(model, getContentPageForLabelOrId(ADDRESS_BOOK_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADDRESS_BOOK_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_ADDRESS_BOOK));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/add-address", method = RequestMethod.GET)
	@RequireHardLogIn
	public String addAddress(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		model.addAttribute(COUNTRY_DATA_ATTR, checkoutFacade.getDeliveryCountries());
		model.addAttribute(TITLE_DATA_ATTR, userFacade.getTitles());
		final AddressForm addressForm = getPreparedAddressForm();
		model.addAttribute(ADDRESS_FORM_ATTR, addressForm);
		model.addAttribute(ADDRESS_BOOK_EMPTY_ATTR, Boolean.valueOf(userFacade.getAddressBook().isEmpty()));
		model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.FALSE);
		storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, breadcrumbsForAddEditAddress(request, ""));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		populateRedirectUrl(request, model);
		return getViewForPage(model);
	}

	protected AddressForm getPreparedAddressForm()
	{
		final CustomerData currentCustomerData = customerFacade.getCurrentCustomer();
		final AddressForm addressForm = new AddressForm();
		addressForm.setFirstName(currentCustomerData.getFirstName());
		addressForm.setLastName(currentCustomerData.getLastName());
		addressForm.setTitleCode(currentCustomerData.getTitleCode());
		return addressForm;
	}

	@RequestMapping(value = "/add-address", method = RequestMethod.POST)
	@RequireHardLogIn
	public String addAddress(final AddressForm addressForm, @RequestParam(value = "url") final String redirectURL,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		getAddressValidator().validate(addressForm, bindingResult);
		if (bindingResult.hasErrors())
		{
			GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
			storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
			setUpAddressFormAfterError(addressForm, model, request, redirectURL);
			return getViewForPage(model);
		}

		final AddressData newAddress = new AddressData();
		populateAddressData(addressForm, newAddress);

		newAddress.setCountry(getI18NFacade().getCountryForIsocode(addressForm.getCountryIso()));

		if (addressForm.getRegionIso() != null && !StringUtils.isEmpty(addressForm.getRegionIso()))
		{
			newAddress.setRegion(getI18NFacade().getRegion(addressForm.getCountryIso(), addressForm.getRegionIso()));
		}

		if (userFacade.getAddressBook().isEmpty())
		{
			newAddress.setDefaultAddress(true);
			newAddress.setVisibleInAddressBook(true);
		}
		else
		{
			newAddress.setDefaultAddress(addressForm.getDefaultAddress() != null && addressForm.getDefaultAddress().booleanValue());
		}

		final AddressVerificationResult<AddressVerificationDecision> verificationResult = getAddressVerificationFacade()
				.verifyAddressData(newAddress);
		final boolean addressRequiresReview = getAddressVerificationResultHandler().handleResult(verificationResult, newAddress,
				model, redirectModel, bindingResult, getAddressVerificationFacade().isCustomerAllowedToIgnoreAddressSuggestions(),
				"checkout.multi.address.added");

		model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(addressForm.getCountryIso()));
		model.addAttribute(COUNTRY_ATTR, addressForm.getCountryIso());
		model.addAttribute("edit", Boolean.TRUE);
		model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.valueOf(isDefaultAddress(addressForm.getAddressId())));

		if (addressRequiresReview)
		{
			storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
			return getViewForPage(model);
		}

		userFacade.addAddress(newAddress);

		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "account.confirmation.address.added",
				null);

		return REDIRECT_PREFIX + validateAndUpdateRedirectUrl(request, redirectURL);
	}

	/**
	 * @param addressForm
	 * @param newAddress
	 */
	protected void populateAddressData(final AddressForm addressForm, final AddressData newAddress)
	{
		newAddress.setTitleCode(addressForm.getTitleCode());
		newAddress.setFirstName(addressForm.getFirstName());
		newAddress.setLastName(addressForm.getLastName());
		newAddress.setLine1(addressForm.getLine1());
		newAddress.setLine2(addressForm.getLine2());
		newAddress.setTown(addressForm.getTownCity());
		newAddress.setPostalCode(addressForm.getPostcode());
		newAddress.setBillingAddress(false);
		newAddress.setShippingAddress(true);
		newAddress.setVisibleInAddressBook(true);
		newAddress.setPhone(addressForm.getPhone());
	}

	protected void setUpAddressFormAfterError(final AddressForm addressForm, final Model model, final HttpServletRequest request, final String navigatedFromURL)
	{
		model.addAttribute(COUNTRY_DATA_ATTR, checkoutFacade.getDeliveryCountries());
		model.addAttribute(TITLE_DATA_ATTR, userFacade.getTitles());
		model.addAttribute(ADDRESS_BOOK_EMPTY_ATTR, Boolean.valueOf(userFacade.getAddressBook().isEmpty()));
		model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.valueOf(isDefaultAddress(addressForm.getAddressId())));
		if (addressForm.getCountryIso() != null)
		{
			model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(addressForm.getCountryIso()));
			model.addAttribute(COUNTRY_ATTR, addressForm.getCountryIso());
		}
		if (PSOpenRedirectValidator.isValidUrl(request, navigatedFromURL))
		{
			model.addAttribute(BREADCRUMBS_ATTR, breadcrumbsForAddEditAddress(request, navigatedFromURL));
			model.addAttribute(LAST_REFERER_SOURCE, navigatedFromURL);
		}
	}

	@RequestMapping(value = "/edit-address/" + ADDRESS_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	@RequireHardLogIn
	public String editAddress(@PathVariable("addressCode") final String addressCode, final Model model,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		final AddressForm addressForm = new AddressForm();
		model.addAttribute(COUNTRY_DATA_ATTR, checkoutFacade.getDeliveryCountries());
		model.addAttribute(TITLE_DATA_ATTR, userFacade.getTitles());
		model.addAttribute(ADDRESS_FORM_ATTR, addressForm);
		final List<AddressData> addressBook = userFacade.getAddressBook();
		model.addAttribute(ADDRESS_BOOK_EMPTY_ATTR, Boolean.valueOf(CollectionUtils.isEmpty(addressBook)));

		for (final AddressData addressData : addressBook)
		{
			if (addressData.getId() != null && addressData.getId().equals(addressCode))
			{
				model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(addressData.getCountry().getIsocode()));
				model.addAttribute(COUNTRY_ATTR, addressData.getCountry().getIsocode());
				model.addAttribute(ADDRESS_DATA_ATTR, addressData);
				setUpAddressForm(addressForm, addressData);

				if (isDefaultAddress(addressData.getId()))
				{
					addressForm.setDefaultAddress(Boolean.TRUE);
					model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.TRUE);
				}
				else
				{
					addressForm.setDefaultAddress(Boolean.FALSE);
					model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.FALSE);
				}
				break;
			}
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, breadcrumbsForAddEditAddress(request, ""));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("edit", Boolean.TRUE);
		populateRedirectUrl(request, model);
		return getViewForPage(model);
	}

	/**
	 * Method checks if address is set as default
	 *
	 * @param addressId
	 *           - identifier for address to check
	 * @return true if address is default, false if address is not default
	 */
	protected boolean isDefaultAddress(final String addressId)
	{
		final AddressData defaultAddress = userFacade.getDefaultAddress();
		return defaultAddress != null && defaultAddress.getId() != null && defaultAddress.getId().equals(addressId);
	}

	@RequestMapping(value = "/edit-address/" + ADDRESS_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.POST)
	@RequireHardLogIn
	public String editAddress(final AddressForm addressForm, @RequestParam(value = "url") final String redirectURL,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		getAddressValidator().validate(addressForm, bindingResult);
		if (bindingResult.hasErrors())
		{
			GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
			storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
			setUpAddressFormAfterError(addressForm, model, request, redirectURL);
			return getViewForPage(model);
		}

		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		final AddressData newAddress = new AddressData();
		newAddress.setId(addressForm.getAddressId());
		populateAddressData(addressForm, newAddress);

		newAddress.setCountry(getI18NFacade().getCountryForIsocode(addressForm.getCountryIso()));

		if (addressForm.getRegionIso() != null && !StringUtils.isEmpty(addressForm.getRegionIso()))
		{
			newAddress.setRegion(getI18NFacade().getRegion(addressForm.getCountryIso(), addressForm.getRegionIso()));
		}

		if (Boolean.TRUE.equals(addressForm.getDefaultAddress()) || userFacade.getAddressBook().size() <= 1
				|| isDefaultAddress(addressForm.getAddressId()))
		{
			newAddress.setDefaultAddress(true);
			newAddress.setVisibleInAddressBook(true);
		}

		final AddressVerificationResult<AddressVerificationDecision> verificationResult = getAddressVerificationFacade()
				.verifyAddressData(newAddress);
		final boolean addressRequiresReview = getAddressVerificationResultHandler().handleResult(verificationResult, newAddress,
				model, redirectModel, bindingResult, getAddressVerificationFacade().isCustomerAllowedToIgnoreAddressSuggestions(),
				"checkout.multi.address.updated");

		model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(addressForm.getCountryIso()));
		model.addAttribute(COUNTRY_ATTR, addressForm.getCountryIso());
		model.addAttribute("edit", Boolean.TRUE);
		model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.valueOf(isDefaultAddress(addressForm.getAddressId())));

		if (addressRequiresReview)
		{
			storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
			return getViewForPage(model);
		}

		userFacade.editAddress(newAddress);

		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "account.confirmation.address.updated",
				null);

		return REDIRECT_PREFIX + validateAndUpdateRedirectUrl(request, redirectURL);
	}


	/**
	 * Identifies the page where the request for add/edit of an address has been made. This is identified either from
	 * "referer" in request header or navigatedFromURL. Breadcrumb objects created for the idenitifed page and returns the
	 * list of breadcrumbs.
	 *
	 * @param request
	 *           HttpServletRequest object to get the referer .
	 * @param navigatedFromURL
	 *           url of the page that add/edit request of an address has been made.
	 * @return List<Breadcrumb> list of breadcrumb objects applicable for the page.
	 */
	private List<Breadcrumb> breadcrumbsForAddEditAddress(final HttpServletRequest request, final String navigatedFromURL)
	{
		String navigatedFrom;
		List<Breadcrumb> breadcrumbs;
		// navigatedFromURL is either empty for add/edit GET requests.
		// When error occurs for add/edit POST requests, navigatedFromURL is the url of the page add/edit request received from.
		if (navigatedFromURL.isEmpty())
		{
			navigatedFrom = request.getHeader(REQUEST_HEADER_REFERER);
		}
		else
		{
			navigatedFrom = navigatedFromURL;
		}
		if (navigatedFrom != null && !navigatedFrom.endsWith(MY_ACCOUNT_ADDRESS_BOOK_URL))
		{
			breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMB_ADD_EDIT_ADDRESS_PAGE);
		}
		else
		{
			// Empty String parameter to breadcrumbBuilder, as we need Home, MyAccount as breadcrumbs
			breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs("");
			final Locale locale = getI18nService().getCurrentLocale();
			breadcrumbs.add(new Breadcrumb(MY_ACCOUNT_ADDRESS_BOOK_URL,
					getMessageSource().getMessage(TEXT_ACCOUNT_ADDRESS_BOOK, null, locale), null));
			breadcrumbs.add(new Breadcrumb("#",
					getMessageSource().getMessage(BREADCRUMB_ADD_EDIT_ADDRESS_PAGE, null, locale),
					null));
		}
		return breadcrumbs;
	}

	protected void storeServiceRelatedDataInModel(final Model model, final OrderData orderData)
	{
		if (!CollectionUtils.isEmpty(orderData.getEntries()))
		{
			model.addAttribute("embeddedFormHtmlsReview", getPsYFormTemplateFacade().getYFormHTMLForService(orderData));
			model.addAttribute("bundleInfo", getBundleSelectionFacade().getSelectedBundlesInformationForCart(orderData));
		}
	}

	@RequestMapping(value = "/consents", method = RequestMethod.GET)
	@RequireHardLogIn
	public String consentManagement(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("consentTemplateDataList", getConsentFacade().getConsentTemplatesWithConsents());
		storeCmsPageInModel(model, getContentPageForLabelOrId(CONSENT_MANAGEMENT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONSENT_MANAGEMENT_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_CONSENT_MANAGEMENT));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/consents/give/{consentTemplateId}/{version}", method = RequestMethod.POST)
	@RequireHardLogIn
	public String giveConsent(@PathVariable final String consentTemplateId, @PathVariable final Integer version,
			final RedirectAttributes redirectModel)
	{
		try
		{
			getConsentFacade().giveConsent(consentTemplateId, version);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, TEXT_ACCOUNT_CONSENT_GIVEN);
		}
		catch (final ModelNotFoundException e)
		{
			LOG.warn(String.format("ConsentTemplate with code [%s] and version [%s] was not found", consentTemplateId, version), e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER,
					TEXT_ACCOUNT_CONSENT_TEMPLATE_NOT_FOUND);
		}
		return REDIRECT_TO_CONSENT_MANAGEMENT;
	}

	@RequestMapping(value = "/consents/withdraw/{consentCode}", method = RequestMethod.POST)
	@RequireHardLogIn
	public String withdrawConsent(@PathVariable final String consentCode, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		try
		{
			getConsentFacade().withdrawConsent(consentCode);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, TEXT_ACCOUNT_CONSENT_WITHDRAWN);
		}
		catch (final ModelNotFoundException e)
		{
			LOG.warn(String.format("Consent with code [%s] was not found", consentCode), e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, TEXT_ACCOUNT_CONSENT_NOT_FOUND);
		}
		return REDIRECT_TO_CONSENT_MANAGEMENT;
	}

	@RequestMapping(value = "/close-account", method = RequestMethod.GET)
	@RequireHardLogIn
	public String showCloseAccountPage(final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(CLOSE_ACCOUNT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CLOSE_ACCOUNT_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_CLOSE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/close-account", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@RequireHardLogIn
	public void closeAccount(final HttpServletRequest request) throws CMSItemNotFoundException, ServletException
	{
		customerFacade.closeAccount();
		request.logout();
	}

	private void populateRedirectUrl(final HttpServletRequest request, final Model model)
	{
		final String refererURL = request.getHeader(REQUEST_HEADER_REFERER);
		final String contextPath = request.getContextPath();
		final String returnURL = StringUtils.substringAfter(refererURL, contextPath);
		if (StringUtils.isNotBlank(returnURL))
		{
			model.addAttribute(LAST_REFERER_SOURCE, returnURL);
		}
		model.addAttribute(REDIRECT_URL, refererURL);
	}

	private static String validateAndUpdateRedirectUrl(final HttpServletRequest request, final String redirectURL)
	{
		if (PSOpenRedirectValidator.isValidUrl(request, redirectURL))
		{
			return redirectURL;
		}
		else
		{
			return "/";
		}
	}

	protected PasswordValidator getPasswordValidator()
	{
		return passwordValidator;
	}

	protected AddressValidator getAddressValidator()
	{
		return addressValidator;
	}

	protected ProfileValidator getProfileValidator()
	{
		return profileValidator;
	}

	protected EmailValidator getEmailValidator()
	{
		return emailValidator;
	}

	protected I18NFacade getI18NFacade()
	{
		return i18NFacade;
	}

	protected AddressVerificationFacade getAddressVerificationFacade()
	{
		return addressVerificationFacade;
	}

	protected AddressVerificationResultHandler getAddressVerificationResultHandler()
	{
		return addressVerificationResultHandler;
	}

	protected PSCartFacade getCartFacade()
	{
		return cartFacade;
	}

	protected BundleSelectionFacade getBundleSelectionFacade()
	{
		return bundleSelectionFacade;
	}

	protected PSYFormTemplateFacade getPsYFormTemplateFacade()
	{
		return psYFormTemplateFacade;
	}

	protected ResourceBreadcrumbBuilder getAccountBreadcrumbBuilder()
	{
		return accountBreadcrumbBuilder;
	}
}

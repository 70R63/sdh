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
package de.hybris.platform.publicsectoracceleratoraddon.controllers;

import de.hybris.platform.publicsectorservices.model.PSAboutMeDashletComponentModel;
import de.hybris.platform.publicsectorservices.model.PSAddressBookDashletComponentModel;
import de.hybris.platform.publicsectorservices.model.PSApplicationsDashletComponentModel;
import de.hybris.platform.publicsectorservices.model.PSApplyByEmailComponentModel;
import de.hybris.platform.publicsectorservices.model.PSApplyByPhoneComponentModel;
import de.hybris.platform.publicsectorservices.model.PSApplyOnlineComponentModel;
import de.hybris.platform.publicsectorservices.model.PSBannerComponentModel;
import de.hybris.platform.publicsectorservices.model.PSBillsDashletComponentModel;
import de.hybris.platform.publicsectorservices.model.PSBreadcrumbComponentModel;
import de.hybris.platform.publicsectorservices.model.PSCMSLinkComponentModel;
import de.hybris.platform.publicsectorservices.model.PSDashboardComponentModel;
import de.hybris.platform.publicsectorservices.model.PSDocumentDashletComponentModel;
import de.hybris.platform.publicsectorservices.model.PSFeaturedLinksComponentModel;
import de.hybris.platform.publicsectorservices.model.PSFooterComponentModel;
import de.hybris.platform.publicsectorservices.model.PSHelpDeskComponentModel;
import de.hybris.platform.publicsectorservices.model.PSKeyFactsComponentModel;
import de.hybris.platform.publicsectorservices.model.PSNavigationComponentModel;
import de.hybris.platform.publicsectorservices.model.PSProductGridComponentModel;
import de.hybris.platform.publicsectorservices.model.PSProductRefinementComponentModel;
import de.hybris.platform.publicsectorservices.model.PSRelatedLinksComponentModel;
import de.hybris.platform.publicsectorservices.model.PSRelationshipsDashletComponentModel;
import de.hybris.platform.publicsectorservices.model.PSRetrieveADraftComponentModel;
import de.hybris.platform.publicsectorservices.model.PSSearchBoxComponentModel;
import de.hybris.platform.publicsectorservices.model.PSSearchResultsGridComponentModel;
import de.hybris.platform.publicsectorservices.model.PSShareThisPageComponentModel;



/**
 * The class of ControllerConstants.
 */
public interface ControllerConstants // NOSONAR;
{
	final String ADDON_PREFIX = "addon:/publicsectoracceleratoraddon/";

	/**
	 * Class with view name constants
	 */
	interface Views
	{
		interface Chat // NOSONAR;
		{
			String chatWindow = ADDON_PREFIX + "chat/chatWindow";// NOSONAR;
		}

		interface Cms // NOSONAR
		{
			String ComponentPrefix = "cms/"; // NOSONAR
		}

		interface Pages // NOSONAR
		{
			interface Account // NOSONAR
			{
				String AccountLoginPage = ADDON_PREFIX + "pages/account/accountLoginPage"; // NOSONAR
				String AccountNewCustomerLogin = ADDON_PREFIX + "pages/account/accountNewCustomerLogin"; // NOSONAR
				String AccountReturningCustomerLogin = ADDON_PREFIX + "pages/account/accountReturningCustomerLogin"; // NOSONAR
			}

			interface Checkout // NOSONAR
			{
				String CheckoutConfirmationPage = ADDON_PREFIX + "pages/checkout/checkoutConfirmationPage"; // NOSONAR
				String CheckoutLoginPage = ADDON_PREFIX + "pages/checkout/checkoutLoginPage"; // NOSONAR
				String CheckoutRegisterPage = "pages/checkout/checkoutRegisterPage"; // NOSONAR
				String RegisteredCheckoutLoginPage = ADDON_PREFIX + "pages/checkout/registeredCheckoutLoginPage"; // NOSONAR
			}

			interface MultiStepCheckout // NOSONAR
			{
				String GetFormPage = ADDON_PREFIX + "pages/checkout/multi/formPage"; // NOSONAR
				String GetMultiStepFormPage = ADDON_PREFIX + "pages/checkout/multi/multiStepFormPage"; // NOSONAR
				String AddEditDeliveryAddressPage = ADDON_PREFIX + "pages/checkout/multi/addEditDeliveryAddressPage"; // NOSONAR
				String ChooseDeliveryMethodPage = ADDON_PREFIX + "pages/checkout/multi/chooseDeliveryMethodPage"; // NOSONAR
				String ChoosePickupLocationPage = "pages/checkout/multi/choosePickupLocationPage"; // NOSONAR
				String AddPaymentMethodPage = ADDON_PREFIX + "pages/checkout/multi/addPaymentMethodPage"; // NOSONAR
				String CheckoutSummaryPage = ADDON_PREFIX + "pages/checkout/multi/checkoutSummaryPage"; // NOSONAR
				String HostedOrderPageErrorPage = "pages/checkout/multi/hostedOrderPageErrorPage"; // NOSONAR
				String HostedOrderPostPage = "pages/checkout/multi/hostedOrderPostPage"; // NOSONAR
				String SilentOrderPostPage = ADDON_PREFIX + "pages/checkout/multi/silentOrderPostPage"; // NOSONAR
				String GiftWrapPage = "pages/checkout/multi/giftWrapPage"; // NOSONAR
				String BundleSelectionPage = ADDON_PREFIX + "pages/checkout/multi/bundleSelectionPage"; // NOSONAR
				String SaveDraftConfirmationPage = ADDON_PREFIX + "pages/checkout/multi/saveDraftConfirmationPage"; // NOSONAR
			}

			interface Error // NOSONAR
			{
				String ErrorNotFoundPage = "pages/error/errorNotFoundPage"; // NOSONAR
			}

		}

		interface Fragments // NOSONAR
		{
			interface Checkout // NOSONAR
			{
				String TermsAndConditionsPopup = "fragments/checkout/termsAndConditionsPopup"; // NOSONAR
				String BillingAddressForm = ADDON_PREFIX + "fragments/checkout/billingAddressForm"; // NOSONAR
				String ReadOnlyExpandedOrderForm = "fragments/checkout/readOnlyExpandedOrderForm"; // NOSONAR
				String ChildBundleSelection = ADDON_PREFIX + "fragments/checkout/childBundleSelection"; // NOSONAR
				String ApplicationSummary = ADDON_PREFIX + "fragments/checkout/applicationSummary"; // NOSONAR
				String RelationshipDetails = ADDON_PREFIX + "fragments/checkout/relationship/activeRelationships"; // NOSONAR;
				String AddressBook = ADDON_PREFIX + "fragments/checkout/yforms/address/addressBook";// NOSONAR;
				String PrimaryAddress = ADDON_PREFIX + "fragments/checkout/yforms/address/primaryAddressForUser";// NOSONAR;
			}

			interface Account // NOSONAR
			{
				String CountryAddressForm = ADDON_PREFIX + "fragments/address/countryAddressForm"; // NOSONAR
				String CartLocked = ADDON_PREFIX + "fragments/account/cartLocked"; // NOSONAR;
			}

			interface Bills // NOSONAR
			{
				String RelationshipBillsAjaxPage = ADDON_PREFIX + "fragments/bills/relationshipBills"; // NOSONAR
			}

			interface Documents // NOSONAR
			{
				String RelationshipDocumentsAjaxPage = ADDON_PREFIX + "fragments/documents/relationshipDocuments"; // NOSONAR
			}

			interface Accounts // NOSONAR
			{
				String RelationshipApplicationsAjaxPage = ADDON_PREFIX + "fragments/account/relationshipApplications"; // NOSONAR
			}
		}
	}

	/**
	 * Class with action name constants
	 */
	interface Actions
	{
		interface Cms // NOSONAR
		{
			String _Prefix = "/view/"; // NOSONAR
			String _Suffix = "Controller"; // NOSONAR

			/**
			 * CMS components that have specific handlers
			 */
			String PSApplyByEmailComponent = _Prefix + PSApplyByEmailComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSApplyByPhoneComponent = _Prefix + PSApplyByPhoneComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSApplyOnlineComponent = _Prefix + PSApplyOnlineComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSRelatedLinksComponent = _Prefix + PSRelatedLinksComponentModel._TYPECODE + _Suffix;// NOSONAR
			String PSCMSLinkComponent = _Prefix + PSCMSLinkComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSKeyFactsComponent = _Prefix + PSKeyFactsComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSHelpDeskComponent = _Prefix + PSHelpDeskComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSShareThisPageComponent = _Prefix + PSShareThisPageComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSFeaturedLinksComponent = _Prefix + PSFeaturedLinksComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSFooterComponent = _Prefix + PSFooterComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSRetrieveADraftComponent = _Prefix + PSRetrieveADraftComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSProductGridComponent = _Prefix + PSProductGridComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSSearchResultsGridComponent = _Prefix + PSSearchResultsGridComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSSearchBoxComponent = _Prefix + PSSearchBoxComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSProductRefinementComponent = _Prefix + PSProductRefinementComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSBannerComponent = _Prefix + PSBannerComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSNavigationComponent = _Prefix + PSNavigationComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSBreadcrumbComponent = _Prefix + PSBreadcrumbComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSDashboardComponent = _Prefix + PSDashboardComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSDocumentDashletComponent = _Prefix + PSDocumentDashletComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSAboutMeDashletComponent = _Prefix + PSAboutMeDashletComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSBillsDashletComponent = _Prefix + PSBillsDashletComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSApplicationsDashletComponent = _Prefix + PSApplicationsDashletComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSAddressBookDashletComponent = _Prefix + PSAddressBookDashletComponentModel._TYPECODE + _Suffix; // NOSONAR
			String PSRelationshipsDashletComponent = _Prefix + PSRelationshipsDashletComponentModel._TYPECODE + _Suffix; // NOSONAR
		}
	}
}

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
package de.hybris.platform.billaddon.controllers;

/**
 * Controller Constants for Bills Controller.
 */
public interface ControllerConstants // NOSONAR
{
   final String ADDON_PREFIX = "addon:/billaddon/";

   interface Pages // NOSONAR
   {
      interface Bills // NOSONAR
      {
         String BillsPaymentSOPPage = ADDON_PREFIX + "pages/bills/billPaymentSOPPage"; // NOSONAR
         String BillsPaymentHOPPage = ADDON_PREFIX + "pages/bills/billPaymentHOPPage"; // NOSONAR
         String AddPaymentMethodPage = ADDON_PREFIX + "pages/bills/addPaymentMethodPage"; // NOSONAR;
         String BillsPaymentConfirmationPage = ADDON_PREFIX + "pages/bills/billConfirmationPage"; // NOSONAR
         String HostedOrderPostPage = ADDON_PREFIX + "pages/bills/hostedOrderPostPage"; // NOSONAR

      }
   }

   interface Views
   {
      interface Fragments // NOSONAR
      {
         String validatePartAmount = ADDON_PREFIX + "fragments/bills/validatePartAmount"; // NOSONAR
         String BillingAddressForm = ADDON_PREFIX + "fragments/bills/billingAddressForm"; // NOSONAR
         String RelationshipBills = ADDON_PREFIX + "fragments/bills/relationshipBills"; // NOSONAR
      }
   }
}

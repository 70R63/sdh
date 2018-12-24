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
package de.hybris.platform.billaddon.forms.validation;


import de.hybris.platform.acceleratorservices.util.CalendarHelper;
import de.hybris.platform.billaddon.forms.BillPaymentForm;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * BillPaymentValidator used for validating {@link BillPaymentForm}
 */
@Component("billPaymentValidator")
public class BillPaymentValidator implements Validator
{
   private static final String PAYMENT_START_DATE_INVALID = "payment.startDate.invalid";

   @Override
   public boolean supports(final Class<?> aClass)
   {
      return BillPaymentForm.class.equals(aClass);
   }

   @Override
   public void validate(final Object object, final Errors errors)
   {
      final BillPaymentForm form = (BillPaymentForm) object;

      if (!form.isUsePaymentInfo())
      {
         validateCCPaymentInfo(errors, form);
         validatePaymentAddress(errors, form);
      }
   }

   /**
    * @param errors
    * @param form
    */
   private void validateCCPaymentInfo(final Errors errors, final BillPaymentForm form)
   {
      final boolean isValidStartMonthYear = StringUtils.isNotBlank(form.getCard_startMonth())
            && StringUtils.isNotBlank(form.getCard_startYear());
      final boolean isValidExpirationMonthYear = StringUtils.isNotBlank(form.getCard_expirationMonth())
            && StringUtils.isNotBlank(form.getCard_expirationYear());
      if (isValidStartMonthYear && isValidExpirationMonthYear)
      {
         final Calendar start = Calendar.getInstance();
         start.set(Calendar.DAY_OF_MONTH, 0);
         start.set(Calendar.MONTH, Integer.parseInt(form.getCard_startMonth()) - 1);
         start.set(Calendar.YEAR, Integer.parseInt(form.getCard_startYear()) - 1);

         final Calendar expiration = Calendar.getInstance();
         expiration.set(Calendar.DAY_OF_MONTH, 0);
         expiration.set(Calendar.MONTH, Integer.parseInt(form.getCard_expirationMonth()) - 1);
         expiration.set(Calendar.YEAR, Integer.parseInt(form.getCard_expirationYear()) - 1);

         if (start.after(expiration))
         {
            errors.rejectValue("startMonth", PAYMENT_START_DATE_INVALID);
         }
      }

      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card_cardType", "payment.cardType.invalid");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card_accountNumber", "payment.cardNumber.invalid");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card_expirationMonth", "payment.expiryMonth.invalid");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card_expirationYear", "payment.expiryYear.invalid");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card_cvNumber", "payment.cardcvv.invalid");
      final Calendar startOfCurrentMonth = CalendarHelper.getCalendarResetTime();
      startOfCurrentMonth.set(Calendar.DAY_OF_MONTH, 1);

      final Calendar startOfNextMonth = CalendarHelper.getCalendarResetTime();
      startOfNextMonth.set(Calendar.DAY_OF_MONTH, 1);
      startOfNextMonth.add(Calendar.MONTH, 1);

      final Calendar start = CalendarHelper.parseDate(form.getCard_startMonth(), form.getCard_startYear());
      final Calendar expiration = CalendarHelper.parseDate(form.getCard_expirationMonth(), form.getCard_expirationYear());
      final boolean isValidStartDate = start != null && !start.before(startOfNextMonth);
      final boolean isValidEndDate = start != null && expiration != null && start.after(expiration);
      if (isValidStartDate || isValidEndDate)
      {
         errors.rejectValue("card_startMonth", PAYMENT_START_DATE_INVALID);
      }
      if (expiration != null && expiration.before(startOfCurrentMonth))
      {
         errors.rejectValue("card_expirationMonth", PAYMENT_START_DATE_INVALID);
      }
   }

   /**
    * @param errors
    * @param form
    */
   private void validatePaymentAddress(final Errors errors, final BillPaymentForm form)
   {
      if (StringUtils.isBlank(form.getBillTo_country()))
      {
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billTo_country", "address.country.invalid");
      }
      else
      {
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billTo_firstName", "address.firstName.invalid");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billTo_lastName", "address.lastName.invalid");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billTo_street1", "address.line1.invalid");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billTo_city", "address.city.invalid");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billTo_postalCode", "address.postcode.invalid");
         ValidationUtils.rejectIfEmpty(errors, "emailAddress", "address.emailAddress.invalid");
      }
   }
}

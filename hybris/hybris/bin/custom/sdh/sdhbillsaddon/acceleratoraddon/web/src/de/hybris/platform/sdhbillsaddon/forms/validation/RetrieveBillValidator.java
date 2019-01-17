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
package de.hybris.platform.sdhbillsaddon.forms.validation;


import de.hybris.platform.sdhbillsaddon.forms.RetrieveBillForm;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Validator for retrieving bills.
 */
@Component("retrieveBillValidator")
public class RetrieveBillValidator implements Validator
{
   private static final int MAX_FIELD_LENGTH = 255;
   private static final String FORM_BILLID = "billId";
   private static final String FORM_LASTNAME = "lastName";
   private static final String FORM_INVALID_BILLID = "form.invalid.billId";
   private static final String FORM_INVALID_BILLID_EXCEEDED = "form.invalid.billId.exceeded";
   private static final String FORM_INVALID_LASTNAME = "form.invalid.lastName";
   private static final String FORM_INVALID_LASTNAME_EXCEEDED = "form.invalid.lastName.exceeded";

   @Override
   public boolean supports(final Class<?> aClass)
   {
      return RetrieveBillForm.class.equals(aClass);
   }

   @Override
   public void validate(final Object object, final Errors errors)
   {
      final RetrieveBillForm form = (RetrieveBillForm) object;
      validateStandardFields(form, errors);
   }

   protected void validateStandardFields(final RetrieveBillForm retrieveBillForm, final Errors errors)
   {
      validateStringField(retrieveBillForm.getBillId(), RetriveBillField.BILLID, MAX_FIELD_LENGTH, errors);
      validateStringField(retrieveBillForm.getLastName(), RetriveBillField.LASTNAME, MAX_FIELD_LENGTH, errors);
   }

   protected static void validateStringField(final String retrieveBillField, final RetriveBillField fieldType,
         final int maxFieldLength, final Errors errors)
   {
      if (retrieveBillField == null || StringUtils.isEmpty(retrieveBillField))
      {
         errors.rejectValue(fieldType.getFieldKey(), fieldType.getErrorKey());
      }
      else if (StringUtils.length(retrieveBillField) > maxFieldLength)
      {
         if (FORM_BILLID.equalsIgnoreCase(fieldType.getFieldKey()))
         {
            errors.rejectValue(fieldType.getFieldKey(), FORM_INVALID_BILLID_EXCEEDED);
         }
         else if (FORM_LASTNAME.equalsIgnoreCase(fieldType.getFieldKey()))
         {
            errors.rejectValue(fieldType.getFieldKey(), FORM_INVALID_LASTNAME_EXCEEDED);
         }
      }
   }

   protected enum RetriveBillField
   {
      BILLID(FORM_BILLID, FORM_INVALID_BILLID), LASTNAME(FORM_LASTNAME, FORM_INVALID_LASTNAME);

      private final String fieldKey;
      private final String errorKey;

      private RetriveBillField(final String fieldKey, final String errorKey)
      {
         this.fieldKey = fieldKey;
         this.errorKey = errorKey;
      }

      public String getFieldKey()
      {
         return fieldKey;
      }

      public String getErrorKey()
      {
         return errorKey;
      }
   }
}

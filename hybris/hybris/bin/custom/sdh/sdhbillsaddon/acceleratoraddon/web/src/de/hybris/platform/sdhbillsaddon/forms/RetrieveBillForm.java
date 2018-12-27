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
package de.hybris.platform.sdhbillsaddon.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Retrieve Bill Form
 */
public class RetrieveBillForm
{
   @NotNull(message = "{general.required}")
   private String _billId;// NOSONAR
   @NotNull(message = "{general.required}")
   private String _lastName;// NOSONAR

   @NotNull(message = "{form.invalid.billId}")
   @Size(min = 1, max = 255, message = "{form.invalid.billId.exceeded}")
   public String getBillId()
   {
      return _billId;
   }

   public void setBillId(final String _billId) // NOSONAR
   {
      this._billId = _billId;
   }

   @NotNull(message = "{form.invalid.lastName}")
   @Size(min = 1, max = 255, message = "{form.invalid.lastName.exceeded}")
   public String getLastName()
   {
      return _lastName;
   }

   public void setLastName(final String _lastName) // NOSONAR
   {
      this._lastName = _lastName;
   }
}

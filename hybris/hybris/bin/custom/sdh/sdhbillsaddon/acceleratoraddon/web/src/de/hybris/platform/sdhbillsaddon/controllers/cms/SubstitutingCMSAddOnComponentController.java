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
 *
 *
 */
package de.hybris.platform.sdhbillsaddon.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.billservices.substitute.PSBillExtensionSubstitutionService;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;

import javax.annotation.Resource;


/**
 * Substituting CMS Addon Component Controller.
 *
 * @param <T>
 */
public abstract class SubstitutingCMSAddOnComponentController<T extends AbstractCMSComponentModel>
      extends AbstractCMSAddOnComponentController<T>
{
   @Resource(name = "psBillExtensionSubstitutionService")
   private PSBillExtensionSubstitutionService psBillExtensionSubstitutionService;

   @Override
   protected String getAddonUiExtensionName(final T component)
   {
      final String addonUiExtensionName = super.getAddonUiExtensionName(component);
      return psBillExtensionSubstitutionService.getSubstitutedExtension(addonUiExtensionName);
   }
}

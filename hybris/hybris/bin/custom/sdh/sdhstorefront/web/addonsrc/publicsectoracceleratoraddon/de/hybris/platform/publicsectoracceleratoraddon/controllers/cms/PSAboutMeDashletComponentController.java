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
package de.hybris.platform.publicsectoracceleratoraddon.controllers.cms;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorfacades.asset.PSAssetFacade;
import de.hybris.platform.publicsectorservices.model.PSAboutMeDashletComponentModel;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller for About Me Dashlet
 */

@Controller("PSAboutMeDashletComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSAboutMeDashletComponent)
public class PSAboutMeDashletComponentController extends SubstitutingCMSAddOnComponentController<PSAboutMeDashletComponentModel>
{
	private static final Logger LOG = LoggerFactory.getLogger(PSAboutMeDashletComponentController.class);

	@Resource(name = "customerFacade")
	protected CustomerFacade customerFacade;

	@Resource(name = "userFacade")
	protected UserFacade userFacade;

	@Resource(name = "psAssetFacade")
	protected PSAssetFacade psAssetFacade;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSAboutMeDashletComponentModel component)
	{
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		if (customerData != null)
		{
			model.addAttribute("customerData", customerData);
			model.addAttribute("paymentInfoData", userFacade.getCCPaymentInfos(true));
			model.addAttribute("assetsExist",
					Boolean.valueOf(CollectionUtils.isNotEmpty(psAssetFacade.getAssetsForUser(customerData.getUid()))));
		}
		else
		{
			LOG.error("No customer data available");
		}
	}
}
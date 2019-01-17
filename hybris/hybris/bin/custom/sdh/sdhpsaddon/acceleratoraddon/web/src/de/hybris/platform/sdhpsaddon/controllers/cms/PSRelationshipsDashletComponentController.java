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
package de.hybris.platform.sdhpsaddon.controllers.cms;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSRelationshipsDashletComponentModel;
import de.hybris.platform.relationship.data.PSRelationshipData;
import de.hybris.platform.relationshipfacades.relationship.impl.DefaultPSRelationshipFacade;
import de.hybris.platform.relationshipservices.enums.PSRelationshipStatus;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller for relationships dashlet
 */
@Controller("PSRelationshipsDashletComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSRelationshipsDashletComponent)
public class PSRelationshipsDashletComponentController
		extends SubstitutingCMSAddOnComponentController<PSRelationshipsDashletComponentModel>
{
	@Resource(name = "psRelationshipfacade")
	protected DefaultPSRelationshipFacade psRelationshipfacade;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model,
			final PSRelationshipsDashletComponentModel component)
	{
		final List<PSRelationshipData> pendingRequestList = psRelationshipfacade
				.getPendingRequests(customerFacade.getCurrentCustomerUid());
		calculatePendingRequestsCount(model, pendingRequestList);
		final Integer activeAndPendingRelationshipsCount = psRelationshipfacade
				.getUserActiveAndPendingRelationshipsCount(customerFacade.getCurrentCustomerUid());
		model.addAttribute("activeAndPendingRelationshipsCount", activeAndPendingRelationshipsCount);
		model.addAttribute("isSeeAllRelationhipsButtonVisible",
				setShowSeeAllRelationshipsButton(activeAndPendingRelationshipsCount));
	}

	/**
	 * Calculate Pending Request Count
	 *
	 * @param model
	 * @param pendingRequestList
	 *
	 */
	private void calculatePendingRequestsCount(final Model model, final List<PSRelationshipData> pendingRequestList)
	{
		int pendingRequestCount = 0;

		for (final PSRelationshipData pendingRequests : pendingRequestList)
		{
			if (pendingRequests.getStatus().equals(PSRelationshipStatus.PENDING)
					&& (customerFacade.getCurrentCustomerUid().equalsIgnoreCase(pendingRequests.getTargetEmail())
							|| (pendingRequests.getTargetUser() != null
									&& customerFacade.getCurrentCustomerUid().equalsIgnoreCase(pendingRequests.getTargetUser().getUid()))))
			{
				if (pendingRequests.isPendingGivenPermissionsToCurrentUser()
						|| pendingRequests.isPendingRequestedPermissionsFromCurrentUser())
				{
					pendingRequestCount = pendingRequests.isPendingGivenPermissionsToCurrentUser() ? pendingRequestCount + 1
							: pendingRequestCount;
					pendingRequestCount = pendingRequests.isPendingRequestedPermissionsFromCurrentUser() ? pendingRequestCount + 1
							: pendingRequestCount;
				}
				else
				{
					pendingRequestCount++;
				}
			}
			if (pendingRequests.getStatus().equals(PSRelationshipStatus.ACTIVE))
			{

				pendingRequestCount = pendingRequests.isPendingGivenPermissionsToCurrentUser() ? pendingRequestCount + 1
						: pendingRequestCount;
				pendingRequestCount = pendingRequests.isPendingRequestedPermissionsFromCurrentUser() ? pendingRequestCount + 1
						: pendingRequestCount;
			}
		}
		model.addAttribute("pendingRequestCount", Integer.valueOf(pendingRequestCount));
	}

	/**
	 * Sets see all relationships button visibility
	 *
	 * @param activeAndPendingRelationshipsCount
	 * @return Boolean
	 *
	 */

	private Boolean setShowSeeAllRelationshipsButton(final Integer activeAndPendingRelationshipsCount)
	{
		return activeAndPendingRelationshipsCount.intValue() > 0 ? Boolean.TRUE : Boolean.FALSE;
	}
}
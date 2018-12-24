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
package de.hybris.platform.relationshipaddon.controllers;

/**
 * RelationshipaddonControllerConstants
 */
public interface ControllerConstants // NOSONAR
{
	final String ADDON_PREFIX = "addon:/relationshipaddon/";

	interface Views
	{
		interface Pages // NOSONAR
		{
			interface Relationship// NOSONAR
			{
				String confirmationPage = ADDON_PREFIX + "pages/relationship/dummyPage"; // NOSONAR
				String RelationshipVisualViewDummyPage = ADDON_PREFIX + "pages/relationships/dummy_page3"; //NOSONAR
			}
		}

		interface Fragments // NOSONAR
		{
			interface Account // NOSONAR
			{
				String ViewEditPendingRequests = ADDON_PREFIX + "fragments/account/viewEditPendingRequests"; // NOSONAR
				String ViewRelationShipAddress = ADDON_PREFIX + "fragments/account/viewRelationshipAddress"; // NOSONAR
				String ViewCancelPendingPermissionRequestsConfirmation = ADDON_PREFIX // NOSONAR
						+ "fragments/account/viewCancelPendingPermissionRequestsConfirmation";
			}
		}
	}
}

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
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSAddressBookDashletComponentModel;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller for AddressBook Dashlet
 */
@Controller("PSAddressBookDashletComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSAddressBookDashletComponent)
public class PSAddressBookDashletComponentController
		extends SubstitutingCMSAddOnComponentController<PSAddressBookDashletComponentModel>
{
	private static final String MODEL_DEF_ADDRESS = "defaultAddress";
	private static final String MODEL_MORE_ADDRESSES = "userHasMoreAddresses";
	private static final String MODEL_RELATIONSHIPS_ADDRESSES = "relationshipsHaveAddresses";
	private static final int USER_MORE_ADDRESSES_PARAM = 1;

	@Resource(name = "userFacade")
	protected UserFacade userFacade;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "psRelationshipfacade")
	protected PSRelationshipFacade psRelationshipFacade;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model,
			final PSAddressBookDashletComponentModel component)
	{
		final List<AddressData> userAddresses = userFacade.getAddressBook();
		model.addAttribute(MODEL_DEF_ADDRESS, getDefaultAddress(userAddresses));
		model.addAttribute(MODEL_MORE_ADDRESSES, Boolean.valueOf(userHasMoreThanOneAddress(userAddresses)));
		model.addAttribute(MODEL_RELATIONSHIPS_ADDRESSES, Boolean.valueOf(CollectionUtils
				.isNotEmpty(psRelationshipFacade.getAddressesForUserRelationships(customerFacade.getCurrentCustomer().getUid()))));

	}

	/**
	 * Finds user's default address from all address user has saved.
	 *
	 * @param userAddresses
	 *           - All addresses user has saved.
	 * @return AddressData - Address marked as isDefaultAddress on AddressModel.
	 */
	private AddressData getDefaultAddress(final List<AddressData> userAddresses)
	{
		final AddressData defaultAddress = userAddresses.stream().filter(address -> address.isDefaultAddress()).findAny()
				.orElse(null);
		return defaultAddress;
	}

	/**
	 * Returns boolean that indicates if user has more than one saved address.
	 *
	 * @param userAddresses
	 *           - All addresses user has saved.
	 * @return boolean - true if user has more than one saved address, false if no addresses found or just one address.
	 */
	private boolean userHasMoreThanOneAddress(final List<AddressData> userAddresses)
	{
		return CollectionUtils.isNotEmpty(userAddresses) && userAddresses.size() > USER_MORE_ADDRESSES_PARAM;
	}

}
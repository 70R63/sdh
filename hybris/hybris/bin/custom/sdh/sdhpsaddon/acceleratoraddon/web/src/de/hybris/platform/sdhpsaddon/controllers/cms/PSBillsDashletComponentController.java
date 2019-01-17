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

import de.hybris.platform.billfacades.bill.PSBillPaymentFacade;
import de.hybris.platform.billfacades.bill.data.PSBillPaymentData;
import de.hybris.platform.billservices.enums.BillPaymentStatus;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorfacades.customer.PSCustomerFacade;
import de.hybris.platform.publicsectorservices.model.PSBillsDashletComponentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller for Bills Dashlet
 */
@Controller("PSBillsDashletComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSBillsDashletComponent)
public class PSBillsDashletComponentController extends SubstitutingCMSAddOnComponentController<PSBillsDashletComponentModel>
{
	private static final int FIRST_PAGE = 0;
	private static final int BILLS_MAX_COUNT = 3;
	private static final String SORT_QUERY_BY_BILL_DUE_DATE_AND_STATUS = "byDueDateAndStatus";

	@Resource(name = "psBillPaymentFacade")
	private PSBillPaymentFacade psBillPaymentFacade;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "psCustomerFacade")
	private PSCustomerFacade psCustomerFacade;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSBillsDashletComponentModel component)
	{
		//bills' status to be retrieved
		final List<BillPaymentStatus> statuses = new ArrayList<>();
		statuses.add(BillPaymentStatus.PAID);
		statuses.add(BillPaymentStatus.UNPAID);
		statuses.add(BillPaymentStatus.PARTPAID);

		//get customer's bill
		//this should bring the bills in the given status sorted by ASC by due date in 2 groups NOT PAID (unpaid/part-paid) and PAID
		final List<PSBillPaymentData> userBills = psBillPaymentFacade.getBillsByStatusList(customerFacade.getCurrentCustomer(), createPageableDataForBillsOverview(), statuses).getResults();
		//set retrieved user bills into the dashlet model attribute up to BILLS_MAX_COUNT
		model.addAttribute("bills", userBills.stream().limit(BILLS_MAX_COUNT).collect(Collectors.toList()));

		//set model attribute flag if bills are available
		final boolean userBillsAvailable = CollectionUtils.isNotEmpty(userBills);
		model.addAttribute("userBillsAvailable", Boolean.valueOf(userBillsAvailable));

		//get relationships' bill - sort order does not matter as it will not be displayed on dashlet
		final List<PSBillPaymentData> userRelationshipsBills = psCustomerFacade
				.getBillsForUserRelationshipsByStatus(customerFacade.getCurrentCustomer().getUid(), statuses);

		//set model attribute flag if relationships have bills
		final boolean isUserRelationshipsBillsAvailable = CollectionUtils.isNotEmpty(userRelationshipsBills);
		model.addAttribute("userRelationshipsBillsAvailable", Boolean.valueOf(isUserRelationshipsBillsAvailable));

		//set model attribute flag if relationships have bills NOT PAID
		model.addAttribute("userRelationshipsUnpaidBillsAvailable",
				Boolean.valueOf(isRelationshipsHaveNotPaidBills(userRelationshipsBills)));


		final boolean isSeeAllBillsButtonVisible = setSeeAllBillsButtonVisible(userBills, isUserRelationshipsBillsAvailable);
		model.addAttribute("isSeeAllBillsButtonVisible", Boolean.valueOf(isSeeAllBillsButtonVisible));
		model.addAttribute("showBillsDashlet",
				Boolean.valueOf(setShowBillsDashlet(userBillsAvailable, isSeeAllBillsButtonVisible)));
	}

	private static PageableData createPageableDataForBillsOverview()
	{
		final PageableData pageableData = new PageableData();
		pageableData.setCurrentPage(FIRST_PAGE);
		//set overview page size to MAX + 1 so we can control if see all bills button is displayed or not
		pageableData.setPageSize(BILLS_MAX_COUNT+1);
		pageableData.setSort(SORT_QUERY_BY_BILL_DUE_DATE_AND_STATUS);
		return pageableData;
	}

	private static boolean isRelationshipsHaveNotPaidBills(final List<PSBillPaymentData> bills)
	{
		return bills.stream()
				.anyMatch(billPaymentData -> BillPaymentStatus.UNPAID.equals(billPaymentData.getBillPaymentStatus())
						|| BillPaymentStatus.PARTPAID.equals(billPaymentData.getBillPaymentStatus()));
	}

	private static boolean setSeeAllBillsButtonVisible(final List<PSBillPaymentData> userAllBills,
			final boolean isUserRelationshipsBillsAvailable)
	{
		return userAllBills.size() > BILLS_MAX_COUNT || isUserRelationshipsBillsAvailable;
	}

	private static boolean setShowBillsDashlet(final boolean userBillsAvailable, final boolean isSeeAllBillsButtonVisible)
	{
		return userBillsAvailable || isSeeAllBillsButtonVisible;
	}
}
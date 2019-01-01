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
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorfacades.order.impl.DefaultPSSaveCartFacade;
import de.hybris.platform.publicsectorservices.model.PSApplicationsDashletComponentModel;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("PSApplicationsDashletComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSApplicationsDashletComponent)
public class PSApplicationsDashletComponentController<C extends PSApplicationsDashletComponentModel>
		extends SubstitutingCMSAddOnComponentController<C>
{
	private static final int MAX_RESULTS_DISPLAY = 1;
	private static final String NO_SORT_CODE = StringUtils.EMPTY;
	protected static final String PS_SERVICE_PRODUCT_TYPECODE = "PSServiceProduct";

	@Resource(name = "orderFacade")
	private OrderFacade orderFacade;

	@Resource(name = "psSaveCartFacade")
	private DefaultPSSaveCartFacade psSaveCartFacade;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "psRelationshipfacade")
	private PSRelationshipFacade psRelationshipFacade;

	/*
	 * Overridden to fetch user applications history and drafts, status indicating of applications/drafts availability.
	 *
	 * @see
	 * de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController#fillModel(javax.servlet.http.
	 * HttpServletRequest, org.springframework.ui.Model,
	 * de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel)
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final C component)
	{
		final SearchPageData<OrderHistoryData> orderHistoryData = fetchApplications(MAX_RESULTS_DISPLAY);
		model.addAttribute("applications", orderHistoryData.getResults());
		model.addAttribute("isUserApplicationsAvailable",
				Boolean.valueOf(CollectionUtils.isNotEmpty(orderHistoryData.getResults())));


		final CustomerData customer = customerFacade.getCurrentCustomer();
		final SearchPageData<CartData> savedCartData = fetchDrafts(MAX_RESULTS_DISPLAY, customer);
		model.addAttribute("drafts", savedCartData.getResults());
		model.addAttribute("isUserDraftsAvailable", Boolean.valueOf(CollectionUtils.isNotEmpty(savedCartData.getResults())));


		final Boolean relationshipsHaveApplications = Boolean
				.valueOf(CollectionUtils.isNotEmpty(psRelationshipFacade.getOrdersForUserRelationships(customer.getUid())));
		model.addAttribute("relationshipsHaveApplications", relationshipsHaveApplications);

		final Boolean relationshipsHaveDrafts = Boolean
				.valueOf(CollectionUtils.isNotEmpty(psRelationshipFacade.getDraftsForUserRelationships(customer.getUid())));
		model.addAttribute("relationshipsHaveDrafts", relationshipsHaveDrafts);

		final Boolean showApplicationAndRequestDashlet = setShowApplicationAndRequestDashlet(orderHistoryData, savedCartData,
				relationshipsHaveApplications, relationshipsHaveDrafts);
		model.addAttribute("showApplicationAndRequestDashlet", showApplicationAndRequestDashlet);

		final Boolean showSeeAllApplicationsAndRequestsButton = getShowSeeAllApplicationsAndRequestsFlag(savedCartData,
				relationshipsHaveDrafts, orderHistoryData, relationshipsHaveApplications);
		model.addAttribute("showSeeAllApplicationsAndRequestsButton", showSeeAllApplicationsAndRequestsButton);

	}

	/**
	 *
	 * fetches the flag to show See Applications & Requests Button
	 *
	 * @param savedCartData
	 * @param relationshipsHaveDrafts
	 * @param orderHistoryData
	 * @param relationshipsHaveApplications
	 *
	 * @return Boolean
	 */
	private Boolean getShowSeeAllApplicationsAndRequestsFlag(final SearchPageData<CartData> savedCartData,
			final Boolean relationshipsHaveDrafts, final SearchPageData<OrderHistoryData> orderHistoryData,
			final Boolean relationshipsHaveApplications)
	{
		final boolean allApplicationsFlag = CollectionUtils.isNotEmpty(orderHistoryData.getResults())
				&& orderHistoryData.getPagination().getNumberOfPages() > 1 || relationshipsHaveApplications.booleanValue();

		final boolean allDraftsFlag = CollectionUtils.isNotEmpty(savedCartData.getResults())
				&& savedCartData.getPagination().getNumberOfPages() > 1 || relationshipsHaveDrafts.booleanValue();

		return Boolean.valueOf(allApplicationsFlag || allDraftsFlag);
	}

	/**
	 *
	 * Creates pageable data and fetches order history. Default sorting mechanism is on the order applied date.
	 *
	 * @param maxResults
	 *           - Maximum number of results to be fetched
	 * @return SearchPageData<OrderHistoryData> - SearchPageData<OrderHistoryData>
	 */
	private SearchPageData<OrderHistoryData> fetchApplications(final int maxResults)
	{
		final PageableData pageableData = createPageableData(maxResults, NO_SORT_CODE);
		return orderFacade.getPagedOrderHistoryForStatuses(pageableData);
	}

	/**
	 *
	 * Creates pageable data, fetches saved carts for the current user. Default sorting mechanism is on the draft saved
	 * date.
	 *
	 * @param maxResults
	 *           - Maximum number of results to be fetched
	 * @param customer
	 * @return SearchPageData<OrderHistoryData> - SearchPageData<OrderHistoryData>
	 */
	private SearchPageData<CartData> fetchDrafts(final int maxResults, final CustomerData customer)
	{
		final PageableData pageableData = createPageableData(maxResults, NO_SORT_CODE);
		final List<OrderStatus> statuses = new ArrayList<>();
		return psSaveCartFacade.getSavedCartsForGivenUser(pageableData, statuses, customer.getUid());
	}

	/**
	 * Creates pageable data, sets the cuurentPage to 0, pageSize to number of results to be fetched and sortCode on
	 * which the result set needs to be sorted.
	 *
	 * @param pageResultsSize
	 *           - Number of results to be fetched.
	 * @param sortCode
	 *           - Code represents the sort mechanism to be applied on the result set.
	 * @return
	 */
	protected PageableData createPageableData(final int pageResultsSize, final String sortCode)
	{
		final PageableData pageableData = new PageableData();
		pageableData.setCurrentPage(0);
		pageableData.setPageSize(pageResultsSize);
		pageableData.setSort(sortCode);
		return pageableData;
	}

	/**
	 * Returns true if current user has applications/drafts, false otherwise.
	 *
	 * @param orderHistoryData
	 *           - User's order history.
	 * @param savedCartData
	 *           - User's saved drafts.
	 * @return true or false - true if current user has applications/drafts, false otherwise.
	 */
	private Boolean setShowApplicationAndRequestDashlet(final SearchPageData<OrderHistoryData> orderHistoryData,
			final SearchPageData<CartData> savedCartData, final Boolean relationshipsHaveApplications,
			final Boolean relationshipsHaveDrafts)
	{

		return Boolean.valueOf(
				CollectionUtils.isNotEmpty(orderHistoryData.getResults()) || CollectionUtils.isNotEmpty(savedCartData.getResults())
						|| relationshipsHaveApplications.booleanValue() || relationshipsHaveDrafts.booleanValue());
	}

}
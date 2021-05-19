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
package de.hybris.platform.sdhpsaddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractCheckoutController.SelectOption;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.billfacades.bill.PSBillPaymentFacade;
import de.hybris.platform.billfacades.bill.data.PSBillPaymentData;
import de.hybris.platform.billservices.enums.BillPaymentStatus;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.sdhpsaddon.security.PSOpenRedirectValidator;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Extended Controller for functionality related with bills in my Account
 */
//@RequestMapping("/my-account")
public class PSAccountRelationshipBillsController extends AbstractSearchPageController
{
	protected static final String BREADCRUMBS_ATTR = "breadcrumbs";
	protected static final String MAX_COUNT_PER_PAGE = "bills.perpage.maxresults.count";

	private static final int FIRST_PAGE = 0;
	private static final String PSBILLPAYMENT_TYPECODE = "PSBillPayment";
	private static final String SORT_CODE_BY_DUE_DATE_AND_STATUS = "byDueDateAndStatus";
	private static final String SHOW_ALL = "search.page.sort.showAll";
	private static final String SHOW_UNPAID = "search.page.sort.showUnpaid";
	private static final String SHOW_PAID = "search.page.sort.showPaid";
	private static final String ACCOUNT_MY_BILLS = "text.account.myBills";
	private static final String NO_OF_BILLS_PER_PAGE = "bills.overview.result.count";
	private static final String MY_ACCOUNT_SHOW_ALL_BILLS_RELATIONSHIP_PAGE = "all-relationship-bills";
	private static final String MY_ACCOUNT_SHOW_ALL_BILLS_PAGE = "all-bills";
	private static final String MY_BILLS_CMS_PAGE = "my-bills";
	private static final String LAST_REFERER_SOURCE = "source";
	private static final String BILL_STATUS_PAID = "Paid";
	private static final String BILL_STATUS_UNPAID = "Unpaid";
	private static final String BILL_STATUS_ALL = "All";
	private static final String USER_BILLS = "bills";

	@Resource(name = "psBillPaymentFacade")
	private PSBillPaymentFacade psBillPaymentFacade;

	@Resource(name = "psRelationshipfacade")
	private PSRelationshipFacade psRelationshipFacade;

	@Resource(name = "psMyAccountBreadcrumbBuilder")
	protected ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@RequestMapping(value = "/my-bills", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getMyBills(final Model model) throws CMSItemNotFoundException
	{
		//TODO revisar este metodo, se agregó un null al parametro nuevo billsAccessor
		final SearchPageData<PSBillPaymentData> bills = psBillPaymentFacade.getBillsByStatusList(getUser(),
				null, createPageableDataForBillsOverview(), null);
		model.addAttribute(USER_BILLS, bills);

		final List<CustomerData> relations = psRelationshipFacade
				.getRelationshipUsersForUserAndPermissibleItemType(getUser().getUid(), PSBILLPAYMENT_TYPECODE);

		if (CollectionUtils.isNotEmpty(relations))
		{
			model.addAttribute("allRelationships", relations);
		}
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_BILLS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_BILLS));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_BILLS_CMS_PAGE));
		return getViewForPage(model);
	}


	@RequestMapping(value = "/all-bills", method = RequestMethod.GET)
	@RequireHardLogIn
	public String displayAllBills(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "filterCode", required = false, defaultValue = "Unpaid") final String filterCode,
			final Model model, @RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		String returnURL = "";
		final String refererURL = request.getHeader("referer");
		final String contextPath = request.getContextPath();

		if (PSOpenRedirectValidator.isValidDomain(request))
		{
			returnURL = StringUtils.substringAfter(refererURL, contextPath);
			model.addAttribute(LAST_REFERER_SOURCE, returnURL);
		}
		// Handle paged search results
		final int maxResults = getSiteConfigService().getInt(MAX_COUNT_PER_PAGE, 10);
		createPageableDataForBills(page, filterCode, model, maxResults, showMode);

		final List<CustomerData> relations = psRelationshipFacade
				.getRelationshipUsersForUserAndPermissibleItemType(getUser().getUid(), PSBILLPAYMENT_TYPECODE);

		if (CollectionUtils.isNotEmpty(relations))
		{
			model.addAttribute("allRelationships", relations);
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_ACCOUNT_SHOW_ALL_BILLS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_ACCOUNT_SHOW_ALL_BILLS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_BILLS));
		if (StringUtils.isNotBlank(filterCode))
		{
			model.addAttribute("filterCode", filterCode);
		}
		return getViewForPage(model);
	}

	protected void createPageableDataForBills(final int page, final String filterCode, final Model model, final int maxResults,
			final ShowMode showMode)
	{
		final List<BillPaymentStatus> statuses = new ArrayList<>();
		final CustomerData customerData = getUser();
		final PageableData pageableData = new PageableData();
		pageableData.setCurrentPage(page);
		pageableData.setPageSize(maxResults);

		if (BILL_STATUS_PAID.equals(filterCode))
		{
			statuses.add(BillPaymentStatus.PAID);
		}
		else if (BILL_STATUS_UNPAID.equals(filterCode))
		{
			statuses.add(BillPaymentStatus.UNPAID);
			statuses.add(BillPaymentStatus.PARTPAID);
		}
		else if (BILL_STATUS_ALL.equals(filterCode))
		{
			statuses.add(BillPaymentStatus.PAID);
			statuses.add(BillPaymentStatus.UNPAID);
			statuses.add(BillPaymentStatus.PARTPAID);
		}
		//TODO revisar este metodo, se agregó un null al parametro nuevo billsAccessor
		final SearchPageData<PSBillPaymentData> searchPageData = psBillPaymentFacade.getBillsByStatusList(customerData,
				null, pageableData, statuses);
		populateModel(model, searchPageData, showMode);
		model.addAttribute(USER_BILLS, searchPageData.getResults());
		model.addAttribute("billPaymentByStatus", searchPageData);
	}

	private PageableData createPageableDataForBillsOverview()
	{
		final PageableData pageableData = new PageableData();
		pageableData.setCurrentPage(FIRST_PAGE);
		pageableData.setPageSize(getSiteConfigService().getInt(NO_OF_BILLS_PER_PAGE, 3));
		pageableData.setSort(SORT_CODE_BY_DUE_DATE_AND_STATUS);
		return pageableData;
	}

	@RequestMapping(value = "/bills/loadCustomerBills", method = RequestMethod.GET)
	public String getBillsForCustomer(@RequestParam("customerId") final String customerId, final Model model)
	{
		//TODO revisar este metodo, se agregó un null al parametro nuevo billsAccessor
		final SearchPageData<PSBillPaymentData> bills = psBillPaymentFacade.getBillsByStatusList(
				psBillPaymentFacade.getCustomerDataForUid(customerId), null, createPageableDataForBillsOverview(), null);
		model.addAttribute("results", bills);
		final CustomerData customer = psBillPaymentFacade.getCustomerDataForUid(customerId);

		model.addAttribute("customer", customer);
		model.addAttribute("isAccessible", Boolean.TRUE);
		return ControllerConstants.Views.Fragments.Bills.RelationshipBillsAjaxPage;
	}

	@RequestMapping(value = "/all-relationship-bills", method = RequestMethod.GET)
	@RequireHardLogIn
	public String displayAllBills(@RequestParam(value = "customerPK", required = false) final String customerPK,
			@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "filterCode", required = false, defaultValue = "All") final String filterCode, final Model model,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode) throws CMSItemNotFoundException
	{
		// Handle paged search results
		final int maxResults = getSiteConfigService().getInt(MAX_COUNT_PER_PAGE, 10);
		createPageableDataForBills(customerPK, page, filterCode, model, maxResults, showMode);

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_ACCOUNT_SHOW_ALL_BILLS_RELATIONSHIP_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_ACCOUNT_SHOW_ALL_BILLS_RELATIONSHIP_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_BILLS));
		model.addAttribute("filterCode", filterCode);
		return getViewForPage(model);
	}

	protected void createPageableDataForBills(final String customerPK, final int page, final String filterCode, final Model model,
			final int maxResults, final ShowMode showMode)
	{
		final PageableData pageableData = new PageableData();
		pageableData.setCurrentPage(page);
		pageableData.setPageSize(maxResults);
		final List<BillPaymentStatus> statuses = new ArrayList<>();

		CustomerData customerData = getUser();
		if (customerPK != null)
		{
			customerData = psRelationshipFacade.getCustomerForPK(customerPK);
		}
		model.addAttribute("billCustomer", customerData);

		if (BILL_STATUS_PAID.equals(filterCode))
		{
			statuses.add(BillPaymentStatus.PAID);
		}
		else if (BILL_STATUS_UNPAID.equals(filterCode))
		{
			statuses.add(BillPaymentStatus.UNPAID);
			statuses.add(BillPaymentStatus.PARTPAID);
		}
		else if (BILL_STATUS_ALL.equals(filterCode))
		{
			statuses.add(BillPaymentStatus.PAID);
			statuses.add(BillPaymentStatus.UNPAID);
			statuses.add(BillPaymentStatus.PARTPAID);
		}
		//TODO revisar este metodo, se agregó un null al parametro nuevo billsAccessor
		final SearchPageData<PSBillPaymentData> searchPageData = psBillPaymentFacade.getBillsByStatusList(customerData,
				null, pageableData, statuses);
		populateModel(model, searchPageData, showMode);
		model.addAttribute(USER_BILLS, searchPageData.getResults());
		model.addAttribute("billPaymentByStatus", searchPageData);
	}

	@ModelAttribute("statuses")
	public List<SelectOption> getStatus()
	{
		final List<SelectOption> statuses = new ArrayList<SelectOption>();

		statuses.add(new SelectOption("All", getMessageSource().getMessage(SHOW_ALL, null, getI18nService().getCurrentLocale())));
		statuses.add(new SelectOption(BILL_STATUS_UNPAID,
				getMessageSource().getMessage(SHOW_UNPAID, null, getI18nService().getCurrentLocale())));
		statuses.add(new SelectOption("Paid", getMessageSource().getMessage(SHOW_PAID, null, getI18nService().getCurrentLocale())));
		return statuses;
	}


	protected ResourceBreadcrumbBuilder getAccountBreadcrumbBuilder()
	{
		return accountBreadcrumbBuilder;
	}
}

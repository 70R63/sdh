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
package de.hybris.platform.billaddon.controllers.pages;

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
import de.hybris.platform.publicsectoracceleratoraddon.security.PSOpenRedirectValidator;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller to display Citizen and her relationship's bills.
 *
 * @deprecated Since HCEA Release 3.0 use PSAccountRelationshipBillsController
 *             for bills (/my-account/bills).
 */
@Deprecated
@Controller
@RequestMapping("/my-account/bills")
public class PSBillAccountPageController extends AbstractSearchPageController
{
	private static final String ACCOUNT_MY_BILLS = "text.account.myBills";
	private static final String MY_BILLS_CMS_PAGE = "my-bills";
	private static final String MY_ACCOUNT_SHOW_ALL_BILLS_PAGE = "all-bills";
	private static final String LAST_REFERER_SOURCE = "source";
	private static final int FIRST_PAGE = 0;
	private static final String NO_OF_BILLS_PER_PAGE = "bills.overview.result.count";
	private static final String SORT_CODE_BY_DUE_DATE_AND_STATUS = "byDueDateAndStatus";

	protected static final String BREADCRUMBS_ATTR = "breadcrumbs";
	protected static final String ACCOUNT_ORDER_HISTORY = "text.account.applications";
	protected static final String MAX_COUNT_PER_PAGE = "bills.perpage.maxresults.count";
	protected static final String SHOW_ALL = "search.page.sort.showAll";
	protected static final String SHOW_UNPAID = "search.page.sort.showUnpaid";
	protected static final String SHOW_PAID = "search.page.sort.showPaid";

	@Resource(name = "psMyAccountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "psBillPaymentFacade")
	private PSBillPaymentFacade psBillPaymentFacade;

	@RequestMapping(value = "/my-bills", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getMyBills(final Model model) throws CMSItemNotFoundException
	{
		final SearchPageData<PSBillPaymentData> bills = getPsBillPaymentFacade().getBillsByStatusList(getUser(),
				createPageableDataForBillsOverview(), null);
		model.addAttribute("bills", bills);

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_BILLS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_BILLS));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_BILLS_CMS_PAGE));
		return getViewForPage(model);
	}

	@RequestMapping(value = "/all-bills", method = RequestMethod.GET)
	@RequireHardLogIn
	public String displayAllBills(@RequestParam(value = "page", defaultValue = "0")
	final int page, @RequestParam(value = "filterCode", required = false, defaultValue = "Unpaid")
	final String filterCode, final Model model, @RequestParam(value = "show", defaultValue = "Page")
	final ShowMode showMode, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		String returnURL = "/";
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

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_ACCOUNT_SHOW_ALL_BILLS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_ACCOUNT_SHOW_ALL_BILLS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_BILLS));
		if (StringUtils.isNotBlank(filterCode))
		{
			model.addAttribute("filterCode", filterCode);
		}
		return getViewForPage(model);
	}

	@ModelAttribute("statuses")
	public List<SelectOption> getStatus()
	{
		final List<SelectOption> statuses = new ArrayList<SelectOption>();
		statuses.add(new SelectOption("All", getMessageSource().getMessage(SHOW_ALL, null, getI18nService().getCurrentLocale())));
		statuses.add(
				new SelectOption("Unpaid", getMessageSource().getMessage(SHOW_UNPAID, null, getI18nService().getCurrentLocale())));
		statuses.add(new SelectOption("Paid", getMessageSource().getMessage(SHOW_PAID, null, getI18nService().getCurrentLocale())));
		return statuses;
	}

	protected void createPageableDataForBills(final int page, final String filterCode, final Model model, final int maxResults,
			final ShowMode showMode)
	{
		final List<BillPaymentStatus> statuses = new ArrayList<>();
		final CustomerData customerData = getUser();
		final PageableData pageableData = new PageableData();
		pageableData.setCurrentPage(page);
		pageableData.setPageSize(maxResults);

		if ("Paid".equals(filterCode))
		{
			statuses.add(BillPaymentStatus.PAID);
		}
		else if ("Unpaid".equals(filterCode))
		{
			statuses.add(BillPaymentStatus.UNPAID);
			statuses.add(BillPaymentStatus.PARTPAID);
		}
		else if ("All".equals(filterCode))
		{
			statuses.add(BillPaymentStatus.PAID);
			statuses.add(BillPaymentStatus.UNPAID);
			statuses.add(BillPaymentStatus.PARTPAID);
		}
		final SearchPageData<PSBillPaymentData> searchPageData = psBillPaymentFacade.getBillsByStatusList(customerData,
				pageableData, statuses);
		populateModel(model, searchPageData, showMode);
		model.addAttribute("bills", searchPageData.getResults());
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

	protected PSBillPaymentFacade getPsBillPaymentFacade()
	{
		return psBillPaymentFacade;
	}

	protected ResourceBreadcrumbBuilder getAccountBreadcrumbBuilder()
	{
		return accountBreadcrumbBuilder;
	}
}

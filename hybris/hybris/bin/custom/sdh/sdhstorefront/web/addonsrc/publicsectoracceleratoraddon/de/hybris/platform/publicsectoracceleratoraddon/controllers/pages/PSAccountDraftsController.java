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
package de.hybris.platform.publicsectoracceleratoraddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectoracceleratoraddon.security.PSOpenRedirectValidator;
import de.hybris.platform.publicsectorfacades.order.PSCartFacade;
import de.hybris.platform.publicsectorfacades.order.PSOrderFacade;
import de.hybris.platform.publicsectorfacades.order.PSSaveCartFacade;
import de.hybris.platform.relationshipfacades.permission.PSPermissionFacade;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Extended Controller for functionality related with drafts in my account
 */
@RequestMapping("/my-account")
public class PSAccountDraftsController extends AbstractSearchPageController
{
	private static final Logger LOG = LoggerFactory.getLogger(PSAccountDraftsController.class);
	private static final String REDIRECT_MYACCOUNT_APPLICATIONS = "redirect:/myaccount/applications";
	private static final String DRAFTS_HISTORY_CMS_PAGE = "drafts";
	private static final String CURRENT_USER_ID = "currentUserId";
	private static final String DRAFT_CODE_PATH_VARIABLE_PATTERN = "{draftCode:.*}";
	private static final String IS_RELATIONSHIP_DATA = "isRelationshipData";
	private static final String SHOW_ALL_DRAFTS_BUTTON = "showAllDraftsButton";
	private static final String N0_DRAFTS_PERMISSION_FOR = "{} does not have drafts permission for {}";
	private static final String FAILED_TO_GET_DRAFTS = "Failed to get drafts.";
	private static final String FAILED_TO_DELETE_DRAFT = "Failed to delete draft {}.";

	protected static int maxDraftsToDisplay = 3;
	protected static final String ORDER_HISTORY_CMS_PAGE = "orders";
	protected static final String BREADCRUMBS_ATTR = "breadcrumbs";
	protected static final String ACCOUNT_ORDER_HISTORY = "text.account.applications";
	protected static final String PS_SERVICE_PRODUCT_TYPECODE = "PSServiceProduct";

	@Resource(name = "psRelationshipfacade")
	protected PSRelationshipFacade psRelationshipFacade;

	@Resource(name = "psSaveCartFacade")
	protected PSSaveCartFacade psSaveCartFacade;

	@Resource(name = "psCartFacade")
	protected PSCartFacade cartFacade;

	@Resource(name = "psOrderFacade")
	protected PSOrderFacade psOrderFacade;

	@Resource(name = "accountBreadcrumbBuilder")
	protected ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "orderFacade")
	protected OrderFacade orderFacade;

	@Resource(name = "psPermissionFacade")
	private PSPermissionFacade psPermissionFacade;

	@RequestMapping(value = "/drafts", method = RequestMethod.GET)
	@RequireHardLogIn
	public String drafts(final Model model) throws CMSItemNotFoundException
	{
		createDraftsData(model, Integer.MAX_VALUE);
		storeCmsPageInModel(model, getContentPageForLabelOrId(DRAFTS_HISTORY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DRAFTS_HISTORY_CMS_PAGE));
		model.addAttribute(CURRENT_USER_ID, getUser().getUid());
		return getViewForPage(model);
	}

	/**
	 * Method to create paged draft data
	 *
	 * @param model
	 * @param maxResults
	 */
	protected void createDraftsData(final Model model, final int maxResults)
	{
		final PageableData pageableDataForCarts = new PageableData();
		pageableDataForCarts.setCurrentPage(0);
		pageableDataForCarts.setPageSize(maxResults);
		final List<OrderStatus> statuses = new ArrayList<>();
		final SearchPageData<CartData> savedCartData = psSaveCartFacade.getSavedCartsForGivenUser(pageableDataForCarts, statuses,
				getUser().getUid());
		model.addAttribute(DRAFTS_HISTORY_CMS_PAGE, savedCartData.getResults());
		if (savedCartData.getResults() != null && savedCartData.getPagination().getNumberOfPages() > 1)
		{
			model.addAttribute(SHOW_ALL_DRAFTS_BUTTON, Boolean.TRUE);
		}
		else
		{
			model.addAttribute(SHOW_ALL_DRAFTS_BUTTON, Boolean.FALSE);
		}
	}

	@RequestMapping(value = "/relationship/drafts", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@RequireHardLogIn
	public String viewRelationshipAllDrafts(@RequestParam(value = "customerId", required = true) final String customerId,
			final Model model) throws CMSItemNotFoundException
	{
		try
		{
			if (customerId != null && psRelationshipFacade.getCustomerForPK(customerId) != null
					&& psPermissionFacade.isPermitted(getCustomerFacade().getCurrentCustomerUid(),
							psRelationshipFacade.getCustomerForPK(customerId).getUid(), PS_SERVICE_PRODUCT_TYPECODE))
			{
				createRelationshipDraftsData(customerId, model, Integer.MAX_VALUE);
				storeCmsPageInModel(model, getContentPageForLabelOrId(DRAFTS_HISTORY_CMS_PAGE));
				setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DRAFTS_HISTORY_CMS_PAGE));
				model.addAttribute(IS_RELATIONSHIP_DATA, Boolean.TRUE);
				model.addAttribute("userData", psRelationshipFacade.getCustomerForPK(customerId));
				return getViewForPage(model);
			}
			else
			{
				LOG.error(FAILED_TO_GET_DRAFTS + N0_DRAFTS_PERMISSION_FOR, getCustomerFacade().getCurrentCustomerUid(), customerId);
			}
		}
		catch (final RelationshipDoesNotExistException e)
		{
			LOG.error(FAILED_TO_GET_DRAFTS + N0_DRAFTS_PERMISSION_FOR, getCustomerFacade().getCurrentCustomerUid(), customerId, e);
			return REDIRECT_PREFIX + "/";
		}
		return REDIRECT_PREFIX + "/";
	}

	/**
	 * Method to create paged draft data
	 *
	 * @param model
	 * @param maxResults
	 */

	protected void createRelationshipDraftsData(final String customerId, final Model model, final int maxResults)
	{
		final CustomerData customer = psRelationshipFacade.getCustomerForPK(customerId);

		final PageableData pageableDataForCarts = new PageableData();
		pageableDataForCarts.setCurrentPage(0);
		pageableDataForCarts.setPageSize(maxResults);
		final List<OrderStatus> statuses = new ArrayList<>();
		final SearchPageData<CartData> savedCartData = psSaveCartFacade.getSavedCartsForGivenUser(pageableDataForCarts, statuses,
				customer.getUid());
		model.addAttribute("drafts", savedCartData.getResults());
		if (savedCartData.getResults() != null && savedCartData.getPagination().getNumberOfPages() > 1)
		{
			model.addAttribute(SHOW_ALL_DRAFTS_BUTTON, Boolean.TRUE);
		}
		else
		{
			model.addAttribute(SHOW_ALL_DRAFTS_BUTTON, Boolean.FALSE);
		}
	}

	@RequestMapping(value = "/removeDraft", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@RequireHardLogIn
	public String removeDraft(@RequestParam(value = "draftCode", required = true) final String draftCode,
			final RedirectAttributes redirectModel, final Model model) throws CMSItemNotFoundException
	{
		getCartFacade().removeCart(draftCode);
		return REDIRECT_MYACCOUNT_APPLICATIONS;
	}

	@RequestMapping(value = "/removeRelationshipDraft/" + DRAFT_CODE_PATH_VARIABLE_PATTERN, method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeRelationshipDraft(@PathVariable("draftCode") final String draftCode,
			@RequestParam(value = "customerId", required = true) final String customerId, final RedirectAttributes redirectModel,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		try
		{
			if (customerId != null && psRelationshipFacade.getCustomerForPK(customerId) != null
					&& psPermissionFacade.isPermitted(getCustomerFacade().getCurrentCustomerUid(),
							psRelationshipFacade.getCustomerForPK(customerId).getUid(), PS_SERVICE_PRODUCT_TYPECODE))
			{
				getCartFacade().removeCartForUser(psRelationshipFacade.getCustomerForPK(customerId).getUid(), draftCode);
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
						"account.confirmation.draft.removed");

				String redirectUrl = "/";
				if (PSOpenRedirectValidator.isValidDomain(request))
				{
					redirectUrl = request.getHeader("referer");
				}
				return REDIRECT_PREFIX + redirectUrl;
			}
			else
			{
				LOG.error(FAILED_TO_DELETE_DRAFT + N0_DRAFTS_PERMISSION_FOR, draftCode, getCustomerFacade().getCurrentCustomerUid(),
						customerId);
			}
		}
		catch (final RelationshipDoesNotExistException e)
		{
			LOG.error(FAILED_TO_DELETE_DRAFT + N0_DRAFTS_PERMISSION_FOR, draftCode, getCustomerFacade().getCurrentCustomerUid(),
					customerId, e);
			return REDIRECT_PREFIX + "/";
		}
		return REDIRECT_PREFIX + "/";
	}

	@RequestMapping(value = "/remove-draft/" + DRAFT_CODE_PATH_VARIABLE_PATTERN, method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeDraft(@PathVariable("draftCode") final String draftCode, final HttpServletRequest request,
			final RedirectAttributes redirectModel)
	{
		if (getCartFacade().isCartAssociatedWithCurrentUser(draftCode))
		{
			getCartFacade().removeCart(draftCode);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "account.confirmation.draft.removed");
		}
		else
		{
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
					"account.confirmation.draft.not.removed");
		}
		String redirectUrl = "/";
		if (PSOpenRedirectValidator.isValidDomain(request))
		{
			redirectUrl = request.getHeader("referer");
		}
		return REDIRECT_PREFIX + redirectUrl;
	}

	@RequestMapping(value = "/checkLockedCart", method = RequestMethod.GET)
	@RequireHardLogIn
	@ResponseBody
	public Boolean checkLockedCart(@RequestParam(value = "draftCode", required = true) final String draftCode)
	{
		boolean cartLocked = false;

		if (StringUtils.isNotBlank(draftCode))
		{
			cartLocked = cartFacade.isDraftLocked(draftCode);
		}
		return Boolean.valueOf(cartLocked);
	}

	@RequestMapping(value = "/displayLockedCartPopup", method = RequestMethod.POST)
	@RequireHardLogIn
	public String displayLockedCartPopup(@RequestParam(value = "draftCode", required = true) final String draftCode,
			final Model model)
	{
		if (StringUtils.isNotBlank(draftCode) && cartFacade.isDraftLocked(draftCode))
		{
			model.addAttribute("cartLocked", Boolean.TRUE);
			model.addAttribute("lockedRemainingTime", cartFacade.getDifferenceInMinutes(draftCode));
		}
		return ControllerConstants.Views.Fragments.Account.CartLocked;
	}

	protected PSCartFacade getCartFacade()
	{
		return cartFacade;
	}

	protected ResourceBreadcrumbBuilder getAccountBreadcrumbBuilder()
	{
		return accountBreadcrumbBuilder;
	}
}

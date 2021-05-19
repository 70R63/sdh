/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.sdhrelationshipsaddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.tags.Functions;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.relationship.data.PSPermissibleAreaData;
import de.hybris.platform.relationship.data.PSPermissionData;
import de.hybris.platform.relationship.data.PSRelationshipData;
import de.hybris.platform.relationshipservices.enums.PSPermissionStatus;
import de.hybris.platform.relationshipservices.enums.PSRelationshipStatus;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipAlreadyExistException;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;
import de.hybris.platform.sdhpsaddon.security.PSOpenRedirectValidator;
import de.hybris.platform.sdhrelationshipsaddon.controllers.ControllerConstants;
import de.hybris.platform.sdhrelationshipsaddon.forms.PermissionForm;
import de.hybris.platform.sdhrelationshipsaddon.forms.RelationshipForm;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for relationship pages for my account.
 */
@Controller
@RequireHardLogIn
@RequestMapping("/my-account")
public class PSRelationshipAccountPageController extends PSAbstractRelationshipAccountPageController
{
	private static final Logger LOG = LoggerFactory.getLogger(PSRelationshipAccountPageController.class);
	private static final String PERMISSIONS_ADD = "../permissions/add";

	private static final String REDIRECT_TO_ADD_PERMISSION = REDIRECT_PREFIX + PERMISSIONS_ADD;
	private static final String REDIRECT_TO_POA_RELATIONSHIP_CONFIRMATION = REDIRECT_PREFIX
			+ "/my-account/relationship/confirmation";
	private static final String REDIRECT_TO_POA_ADD_PERMISSION = REDIRECT_PREFIX + "/my-account/permissions/add";

	private static final String ACCEPT_PERMISSION = "ACCEPT";
	private static final String MANAGE_RELATIONSHIP_DETAILS_CMS_PAGE = "manage-details";
	private static final String NON_POA_RELATIONSHIP = "non-poa";
	private static final String POA_HOLDER_RELATIONSHIP = "poa-holder";
	private static final String POA_RECEIVER_RELATIONSHIP = "poa-receiver";
	private static final String RELATIONSHIP_TYPE = "relationshipType";
	private static final String LAST_REFERER_SOURCE = "source";
	private static final String MODEL_ATTR_BACK_BUTTON_URL = "backButtonUrl";
	private static final String PERMISSIBLE_ITEMS = "permissibleItems";
	private static final String IS_POA_CASE = "isPoaCase";
	private static final String USER_DONT_HAVE_ACCESS = "Given user dont have permission to acesss {}";

	protected static final String RELATIONSHIP_DATA = "relationshipData";
	protected static final String RELATIONSHIPS_ADDRESS_DATA_ATTR = "relationshipsAddressData";

	// CMS Pages
	protected static final String ADD_RELATIONSHIP_CMS_PAGE = "addRelationshipPage";
	protected static final String PENDING_REQUESTS_CMS_PAGE = "pending-requests";
	protected static final String MY_RELATIONSHIPS_CMS_PAGE = "my-relationships";
	protected static final String RELATIONSHIP_CONFIRMATION_PAGE = "relationship-confirmation";


	@RequestMapping(value = "/my-relationships", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getMyRelationships(final Model model) throws CMSItemNotFoundException
	{
		getSessionService().removeAttribute(SESSION_USER_IN_CONTEXT);

		final CustomerData currCustomer = getUser();
		final Map<String, String> allPendingRequestCountMap = new HashMap<>();

		final Map<String, List<PSRelationshipData>> currentUserRelationships = getPsRelationshipFacade()
				.getRelationForStatusByType(currCustomer.getUid(), null, allPendingRequestCountMap);

		if (currentUserRelationships != null)
		{
			final Map<CustomerData, Map<String, List<PSRelationshipData>>> userPOARelationships = new HashMap<>();

			final List<PSRelationshipData> currUserPOAHolderRelationships = currentUserRelationships.get(POA_HOLDER_RELATIONSHIP);
			if (CollectionUtils.isNotEmpty(currUserPOAHolderRelationships))
			{
				Map<String, List<PSRelationshipData>> currentPOAReceiverRelationships;
				CustomerData currentPOAUser;
				for (final PSRelationshipData currentPOARelationship : currUserPOAHolderRelationships)
				{
					currentPOAUser = currCustomer.getUid().equalsIgnoreCase(currentPOARelationship.getSourceUser().getUid())
							? currentPOARelationship.getTargetUser() : currentPOARelationship.getSourceUser();
					currentPOAReceiverRelationships = getPsRelationshipFacade().getRelationForStatusByType(currentPOAUser.getUid(),
							null, allPendingRequestCountMap);
					userPOARelationships.put(currentPOAUser, currentPOAReceiverRelationships);
				}
			}

			model.addAttribute("currUserRelationships", currentUserRelationships);
			model.addAttribute("userPOARelationships", userPOARelationships);
			model.addAttribute("allUserPendingRequestCount", allPendingRequestCountMap);
		}
		model.addAttribute("customer", currCustomer);
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_RELATIONSHIPS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(TEXT_ACCOUNT_MY_RELATIONSHIPS));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_RELATIONSHIPS_CMS_PAGE));
		return getViewForPage(model);
	}

	@RequestMapping(value = "/my-relationships/manage-details/" + RELATIONSHIP_ID_PATH_VARIABLE_PATTERN + "/"
			+ CUSTOMER_PK_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	@RequireHardLogIn
	public String getMyRelationshipDetails(@PathVariable final String relationId, final Model model,
			@PathVariable final String customerPK) throws CMSItemNotFoundException, RelationshipDoesNotExistException
	{
		CustomerData sourceUser = null;
		if (StringUtils.isNotBlank(customerPK))
		{
			sourceUser = getPsRelationshipFacade().getCustomerForPK(customerPK);
		}
		if (sourceUser != null && StringUtils.isNotBlank(relationId))
		{
			final PSRelationshipData relationshipData = getPsRelationshipFacade().getRelationForId(relationId);
			final String relationshipFor = sourceUser.getUid();

			model.addAttribute("sourceUser", sourceUser);
			model.addAttribute("isSourceUserLoggedIn", Boolean.valueOf(relationshipFor.equals(getUser().getUid())));

			String targetUID = "";
			CustomerData targetUser;
			if (relationshipData.getTargetUser() != null)
			{
				targetUser = relationshipData.getTargetUser().getUid().equals(relationshipFor) ? relationshipData.getSourceUser()
						: relationshipData.getTargetUser();

				final Boolean isSourcePoaHolder = relationshipData.getTargetUser().getUid().equals(relationshipFor)
						? relationshipData.getIsTargetPoaHolder() : relationshipData.getIsSourcePoaHolder();

				final Boolean isTargetPoaHolder = relationshipData.getTargetUser().getUid().equals(relationshipFor)
						? relationshipData.getIsSourcePoaHolder() : relationshipData.getIsTargetPoaHolder();

				targetUID = targetUser.getUid();
				model.addAttribute("targetUserPK", targetUser.getCustomerPK());
				model.addAttribute("targetUserName", targetUser.getName());
				model.addAttribute("targetUserEmail", targetUID);
				model.addAttribute("targetUserFirstName", targetUser.getFirstName());
				model.addAttribute("isSourcePoaHolder", isSourcePoaHolder);
				model.addAttribute("isTargetPoaHolder", isTargetPoaHolder);
				model.addAttribute("targetUserTitle", targetUser.getTitle());
				model.addAttribute("sourceUserTitle", sourceUser.getTitle());
				model.addAttribute("sourceUserFirstName", sourceUser.getFirstName());
			}
			else
			{
				final String targetUserName = relationshipData.getTitle() + " " + relationshipData.getFirstName() + " "
						+ relationshipData.getLastName();
				model.addAttribute("targetUserName", targetUserName);
				model.addAttribute("targetUserEmail", relationshipData.getTargetEmail());
				model.addAttribute("targetUserFirstName", relationshipData.getFirstName());
			}

			final List<PSPermissibleAreaData> allPermissibleItems = psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE,
					Boolean.TRUE);
			final List<PSPermissibleAreaData> permissibleItemsForNotVisibleByUser = psPermissionFacade
					.getPermissibleItemTypes(Boolean.FALSE, Boolean.TRUE);

			if (relationshipData.getStatus().equals(PSRelationshipStatus.ACTIVE)
					|| relationshipData.getStatus().equals(PSRelationshipStatus.PENDING))
			{
				final List<PSPermissionStatus> status = new ArrayList<>();
				status.add(PSPermissionStatus.ACTIVE);
				status.add(PSPermissionStatus.PENDING);

				final List<PSPermissionData> sourceUserPermissions = psPermissionFacade.getPermissionsForStatus(targetUID,
						sourceUser.getUid(), status);
				final List<PSPermissionData> targetUserPermissions = psPermissionFacade.getPermissionsForStatus(sourceUser.getUid(),
						targetUID, status);

				model.addAttribute("activePermissionsForSourceUser",
						getPermissionsForStatus(sourceUserPermissions, PSPermissionStatus.ACTIVE, null));
				model.addAttribute("pendingRequestedPermissionsForSourceUser",
						getPermissionsForStatus(sourceUserPermissions, PSPermissionStatus.PENDING, Boolean.TRUE));
				model.addAttribute("pendingNotRequestedPermissionsForSourceUser",
						getPermissionsForStatus(sourceUserPermissions, PSPermissionStatus.PENDING, Boolean.FALSE));
				model.addAttribute("inactivePermissionsForSourceUser",
						getInactivePermissibleItems(allPermissibleItems, sourceUserPermissions));
				model.addAttribute("activePermissionsForTargetUser",
						getPermissionsForStatus(targetUserPermissions, PSPermissionStatus.ACTIVE, null));
				model.addAttribute("pendingRequestedPermissionsForTargetUser",
						getPermissionsForStatus(targetUserPermissions, PSPermissionStatus.PENDING, Boolean.TRUE));
				model.addAttribute("pendingNotRequestedPermissionsForTargetUser",
						getPermissionsForStatus(targetUserPermissions, PSPermissionStatus.PENDING, Boolean.FALSE));
				model.addAttribute("inactivePermissionsForTargetUser",
						getInactivePermissibleItems(allPermissibleItems, targetUserPermissions));
			}
			model.addAttribute("permissibleItemsForNotVisibleByUser", permissibleItemsForNotVisibleByUser);
			model.addAttribute(PERMISSIBLE_ITEMS, allPermissibleItems);
			model.addAttribute(RELATIONSHIP_DATA, relationshipData);

			final Map<String, String> allPendingRequestCountMap = new HashMap<>();
			final Map<String, List<PSRelationshipData>> currentUserRelationships = getPsRelationshipFacade()
					.getRelationshipDataByType(sourceUser.getUid(),
							StringUtils.isNotEmpty(targetUID) ? targetUID : relationshipData.getTargetEmail(), allPendingRequestCountMap,
							relationshipData.getStatus());
			model.addAttribute("relationshipFor", getPsRelationshipFacade().getCustomerDataForUid(relationshipFor));

			PSRelationshipData relationship = null;

			if (!CollectionUtils.isEmpty(currentUserRelationships.get(NON_POA_RELATIONSHIP)))
			{
				model.addAttribute(RELATIONSHIP_TYPE, NON_POA_RELATIONSHIP);
				relationship = (PSRelationshipData) ((ArrayList) currentUserRelationships.get(NON_POA_RELATIONSHIP)).get(0);
			}
			else if (!CollectionUtils.isEmpty(currentUserRelationships.get(POA_HOLDER_RELATIONSHIP)))
			{
				model.addAttribute(RELATIONSHIP_TYPE, POA_HOLDER_RELATIONSHIP);
				relationship = (PSRelationshipData) ((ArrayList) currentUserRelationships.get(POA_HOLDER_RELATIONSHIP)).get(0);
			}
			else if (!CollectionUtils.isEmpty(currentUserRelationships.get(POA_RECEIVER_RELATIONSHIP)))
			{
				model.addAttribute(RELATIONSHIP_TYPE, POA_RECEIVER_RELATIONSHIP);
				relationship = (PSRelationshipData) ((ArrayList) currentUserRelationships.get(POA_RECEIVER_RELATIONSHIP)).get(0);
			}

			model.addAttribute("currUserRelationship", relationship);

			storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_RELATIONSHIP_DETAILS_CMS_PAGE));

			final List<Breadcrumb> breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs(null);
			breadcrumbs.add(new Breadcrumb(MY_ACCOUNT_MY_RELATIONS_URL,
					getMessageSource().getMessage(TEXT_ACCOUNT_MY_RELATIONSHIPS, null, getI18nService().getCurrentLocale()), null));
			breadcrumbs.add(new Breadcrumb("#",
					getMessageSource().getMessage(TEXT_ACCOUNT_MANAGE_RELATIONSHIP_DETAILS, null, getI18nService().getCurrentLocale()),
					null));
			model.addAttribute(BREADCRUMBS_ATTR, breadcrumbs);
			model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_RELATIONSHIP_DETAILS_CMS_PAGE));

			return getViewForPage(model);
		}
		else
		{
			return getMyRelationships(model);
		}
	}

	@RequestMapping(value = "/my-relationships/cancel-pending-relationship/"
			+ RELATIONSHIP_ID_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	@RequireHardLogIn
	public String cancelPendingRelationship(@PathVariable final String relationId, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException, RelationshipDoesNotExistException
	{
		if (relationId != null)
		{
			final PSRelationshipData relationshipData = getPsRelationshipFacade().getRelationForId(relationId);

			final String relationshipSourceUser = relationshipData.getSourceUser().getUid();

			if (relationshipData.getStatus().equals(PSRelationshipStatus.PENDING)
					&& getUser().getUid().equalsIgnoreCase(relationshipSourceUser) || checkPermission(relationshipSourceUser))
			{
				psRelationshipFacade.cancelPendingRelationship(relationId);

				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
						"message.cancel.pending.permissions", new Object[]
						{ relationshipData.getFirstName(), relationshipData.getLastName() });
			}
			else
			{
				LOG.error("Either {} relationship is not pending or Current user {} does not have access to cancel it", relationId,
						getUser().getUid());
				return FORWARD_TO_404_PAGE;
			}
		}
		return REDIRECT_PREFIX + MY_ACCOUNT_MY_RELATIONS_URL;
	}

	protected List<PSPermissionData> getPermissionsForStatus(final List<PSPermissionData> permissions,
			final PSPermissionStatus status, final Boolean isRequested)
	{
		if (CollectionUtils.isNotEmpty(permissions))
		{
			return permissions.stream()
					.filter(permission -> status.equals(permission.getStatus())
							&& (isRequested == null || isRequested.equals(permission.getIsRequested())))
					.collect(Collectors.toCollection(ArrayList::new));
		}
		return Collections.emptyList();
	}

	protected List<PSPermissibleAreaData> getInactivePermissibleItems(final List<PSPermissibleAreaData> permissibleItems,
			final List<PSPermissionData> permission)
	{
		final List<PSPermissibleAreaData> activePermissions = permission.stream().map(e -> e.getPermissibleAreaItem())
				.collect(Collectors.toList());
		final List<PSPermissibleAreaData> activeNonBasicPermissibleItem = permissibleItems.stream()
				.filter(e -> e.isActive()).filter(e -> StringUtils.isNotEmpty(e.getShareableType()))
				.collect(Collectors.toList());

		final List<PSPermissibleAreaData> nonAccessiblePermissions = new ArrayList<>();

		for (final PSPermissibleAreaData permissibleAreaData : activeNonBasicPermissibleItem)
		{
			boolean matchFound = false;
			for (final PSPermissibleAreaData activePermissibleAreaData : activePermissions)
			{

				if (activePermissibleAreaData.getShareableType().equalsIgnoreCase(permissibleAreaData.getShareableType()))
				{
					matchFound = true;
				}
			}
			if (!matchFound)
			{
				nonAccessiblePermissions.add(permissibleAreaData);
			}
		}
		return nonAccessiblePermissions;
	}

	/**
	 * Redirects to visual view page.
	 *
	 * @return String
	 */
	@RequestMapping(value = "/visualView", method = RequestMethod.GET)
	public String getVisualView()
	{
		return ControllerConstants.Views.Pages.Relationship.RelationshipVisualViewDummyPage;
	}

	/**
	 * Add relation page GET Request
	 *
	 * @param model
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/relationship/add", method = RequestMethod.GET)
	public String addRelationship(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		final RelationshipForm relationship = new RelationshipForm();
		model.addAttribute(RELATIONSHIP_FORM, relationship);

		populateBackButtonUrl(request, model);
		return addRelationshipPage(model);
	}

	/**
	 * Edit Relationship page GET Request
	 *
	 * @param model
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/relationship/edit", method = RequestMethod.GET)
	public String editRelationship(final Model model) throws CMSItemNotFoundException
	{
		final RelationshipForm relationship = (RelationshipForm) getSessionService().getAttribute(RELATIONSHIP_FORM);
		model.addAttribute(RELATIONSHIP_FORM, (relationship != null) ? relationship : new RelationshipForm());
		return addRelationshipPage(model);
	}

	/**
	 * add relationship page post request
	 *
	 * @param model
	 * @param relationshipForm
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param redirectModel
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/relationship/add", method = RequestMethod.POST)
	public String addRelationship(final Model model, final RelationshipForm relationshipForm, final BindingResult bindingResult,
			final HttpServletRequest request, final HttpServletResponse response, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		if (!StringUtils.equalsIgnoreCase(getUser().getUid(), relationshipForm.getEmailAddress()))
		{
			getRelationshipFormValidator().validate(relationshipForm, bindingResult);
			if (bindingResult.hasErrors())
			{
				GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
				model.addAttribute(RELATIONSHIP_FORM, relationshipForm);
				return addRelationshipPage(model);
			}

			try
			{
				return addRelationAndReturnView(relationshipForm, redirectModel);
			}
			catch (final RelationshipAlreadyExistException e)
			{
				LOG.warn("Relationship already exists for given user while adding relation {}", e);
				return relationshipAlreadyExists(relationshipForm, redirectModel);
			}
		}
		else
		{
			GlobalMessages.addErrorMessage(model, ERROR_RELATIONSHIP_SOURCE_TARGET_SAME_MESSAGE);
			model.addAttribute(RELATIONSHIP_FORM, relationshipForm);
			return addRelationshipPage(model);
		}
	}

	/**
	 * Confirmation page request mapping for adding relationship
	 *
	 * @param model
	 * @param relationId
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/relationship/confirmation/" + RELATIONSHIP_ID_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String getRelationshipConfirmationPage(@PathVariable final String relationId, final Model model)
			throws CMSItemNotFoundException
	{
		getSessionService().removeAttribute(RELATIONSHIP_FORM);
		if (StringUtils.isNotBlank(relationId))
		{
			try
			{
				final PSRelationshipData relationship = getPsRelationshipFacade().getRelationForId(relationId);
				return storeRelationshipDataAndReturnViewPage(model, relationship);
			}
			catch (final ModelNotFoundException e)
			{
				LOG.error("Relation model not found for given relation id {} {}", relationId, e);
			}
		}
		return FORWARD_TO_404_PAGE;
	}

	@RequestMapping(value = "/pending-requests", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getNotPOAPendingRequests(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		return getPendingRequests(null, model, request);
	}

	@RequestMapping(value = "/pending-requests/" + CUSTOMER_PK_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPendingRequests(final @PathVariable(value = "customerPK") String customerPK, final Model model,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		populateBackButtonUrl(request, model);

		String customerUid = null;
		if (StringUtils.isBlank(customerPK))
		{
			// Signed in user is accessing pending requests of himself. Remove session variable, don't need to check permission
			getSessionService().removeAttribute(SESSION_USER_IN_CONTEXT);
			customerUid = getUser().getUid();
			model.addAttribute(IS_POA_CASE, Boolean.FALSE);
		}
		else
		{
			if (StringUtils.isNotBlank(customerPK))
			{
				final CustomerData poaProvider = psRelationshipFacade.getCustomerForPK(customerPK);
				customerUid = poaProvider.getUid();
				getSessionService().setAttribute(SESSION_USER_IN_CONTEXT, customerUid);
				model.addAttribute(IS_POA_CASE, Boolean.TRUE);
				model.addAttribute("poaProvider", poaProvider);
			}
			// Signed in user is accessing pending requests of other person. Set session variable, need to check permission
			if (!checkPermission(customerUid))
			{
				LOG.warn(USER_DONT_HAVE_ACCESS, customerUid);
				return FORWARD_TO_404_PAGE;
			}
		}

		model.addAttribute("relations", getPsRelationshipFacade().getPendingRequests(customerUid));
		model.addAttribute(PERMISSIBLE_ITEMS, psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE, Boolean.TRUE));

		storeCmsPageInModel(model, getContentPageForLabelOrId(PENDING_REQUESTS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PENDING_REQUESTS_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs(null);
		breadcrumbs.add(new Breadcrumb(MY_ACCOUNT_MY_RELATIONS_URL,
				getMessageSource().getMessage(TEXT_ACCOUNT_MY_RELATIONSHIPS, null, getI18nService().getCurrentLocale()), null));
		breadcrumbs.add(new Breadcrumb("#",
				getMessageSource().getMessage(TEXT_ACCOUNT_MY_PENDING_REQUESTS, null, getI18nService().getCurrentLocale()), null));
		model.addAttribute(BREADCRUMBS_ATTR, breadcrumbs);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/update-pending-request", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updatePendingRequest(@RequestParam(value = "relationId") final String relationId,
			@RequestParam(value = "isGiven") final boolean isGiven, @RequestParam(value = "requestParam") final String requestParam,
			@RequestParam(value = "url") final String backButtonUrl, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		redirectAttributes.addFlashAttribute(MODEL_ATTR_BACK_BUTTON_URL, backButtonUrl);

		final String customerUid = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
		final CustomerData currentUser = getCurrentUser(customerUid);
		final boolean isPoaCase = !StringUtils.isBlank(customerUid);

		if (isPoaCase && !checkPermission(customerUid))
		{
			LOG.warn(USER_DONT_HAVE_ACCESS, customerUid);
			return REDIRECT_TO_404_PAGE;
		}

		if (StringUtils.isBlank(relationId))
		{
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"text.error.pending.request.permissions.message");
			return REDIRECT_TO_PENDING_REQUEST + (isPoaCase ? "/" + Functions.encodeUrl(currentUser.getCustomerPK()) : "");
		}

		final PSRelationshipData relationData = getPsRelationshipFacade().getRelationForId(relationId);
		final CustomerData targetUser = getUser();
		final CustomerData sourceUser = relationData.getSourceUser().getUid().equals(targetUser.getUid())
				? relationData.getTargetUser() : relationData.getSourceUser();

		final String userFirstName = sourceUser.getFirstName();

		updatePendingRequestAndAddMessage(relationId, isGiven, requestParam, redirectAttributes, currentUser, isPoaCase,
				userFirstName);
		return REDIRECT_TO_PENDING_REQUEST + (isPoaCase ? "/" + Functions.encodeUrl(currentUser.getCustomerPK()) : "");
	}

	/**
	 * @param relationId
	 * @param isGiven
	 * @param requestParam
	 * @param redirectAttributes
	 * @param currentUser
	 * @param isPoaCase
	 * @param userFirstName
	 */
	private void updatePendingRequestAndAddMessage(final String relationId, final boolean isGiven, final String requestParam,
			final RedirectAttributes redirectAttributes, final CustomerData currentUser, final boolean isPoaCase,
			final String userFirstName)
	{
		String messageKey;
		if (isGiven)
		{
			//TODO revisar este metodo, se agregó un null al parametro nuevo permissibleAreaType
			psPermissionFacade.updatePendingRequest(relationId, requestParam.equalsIgnoreCase(ACCEPT_PERMISSION),
					isGiven, null);
			if (!isPoaCase)
			{
				messageKey = requestParam.equalsIgnoreCase(ACCEPT_PERMISSION) ? "message.given.permissions.acceptance"
						: "message.given.permissions.rejection";
			}
			else
			{
				messageKey = requestParam.equalsIgnoreCase(ACCEPT_PERMISSION) ? "message.given.permissions.acceptance.poa"
						: "message.given.permissions.rejection.poa";
			}
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER, messageKey, new Object[]
			{ userFirstName, currentUser.getFirstName(), currentUser.getLastName() });
		}
		else
		{
			//TODO revisar este metodo, se agregó un null al parametro nuevo permissibleAreaType
			psPermissionFacade.updatePendingRequest(relationId, requestParam.equalsIgnoreCase(ACCEPT_PERMISSION), isGiven, null);
			if (!isPoaCase)
			{
				messageKey = requestParam.equalsIgnoreCase(ACCEPT_PERMISSION) ? "message.requested.permissions.acceptance"
						: "message.requested.permissions.rejection";
			}
			else
			{
				messageKey = requestParam.equalsIgnoreCase(ACCEPT_PERMISSION) ? "message.requested.permissions.acceptance.poa"
						: "message.requested.permissions.rejection.poa";
			}
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER, messageKey, new Object[]
			{ userFirstName, userFirstName, currentUser.getFirstName() });
		}
	}

	@RequestMapping(value = "/pending-request/edit/" + RELATIONSHIP_ID_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String editPendingRequest(@PathVariable final String relationId, @RequestParam(value = "isGiven") final boolean isGiven,
			final Model model)
	{
		if (StringUtils.isNotBlank(relationId))
		{
			final PSRelationshipData relationData = getPsRelationshipFacade().getRelationForId(relationId);

			final PermissionForm permissionForm = new PermissionForm();
			if (isGiven)
			{
				permissionForm.setPermissionType(GIVE_PERMISSION);
				permissionForm.setSourcePermissibleItemTypes(getPermissibleItemTypeCodesForPermission(
						getPendingPermissions(relationData.getGivenPermissionsToCurrentUser())));
			}
			else
			{
				permissionForm.setPermissionType(REQUEST_PERMISSION);
				permissionForm.setTargetPermissibleItemTypes(getPermissibleItemTypeCodesForPermission(
						getPendingPermissions(relationData.getRequestedPermissionsFromCurrentUser())));
			}

			model.addAttribute("relationData", relationData);
			model.addAttribute(PERMISSIBLE_ITEMS, psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE, Boolean.TRUE));
			final String customerUid = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
			model.addAttribute(IS_POA_CASE, Boolean.valueOf(!StringUtils.isBlank(customerUid)));
			model.addAttribute(PERMISSION_FORM_ATTR, permissionForm);

			return ControllerConstants.Views.Fragments.Account.ViewEditPendingRequests;
		}
		else
		{
			return FORWARD_TO_404_PAGE;
		}
	}

	@RequestMapping(value = "/pending-request/edit/" + RELATIONSHIP_ID_PATH_VARIABLE_PATTERN, method = RequestMethod.POST)
	@RequireHardLogIn
	public String editPendingRequest(@PathVariable final String relationId, final PermissionForm permissionForm,
			final BindingResult bindingResult, @RequestParam(value = "requestParam") final String requestParam,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		final String customerUid = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
		final CustomerData currentUser = getCurrentUser(customerUid);

		if (!StringUtils.isBlank(customerUid) && !checkPermission(customerUid))
		{
			// POA case
			LOG.warn(USER_DONT_HAVE_ACCESS, customerUid);
			return REDIRECT_TO_404_PAGE;
		}

		getPermissionFormValidator().validate(permissionForm, bindingResult);
		if (bindingResult.hasErrors())
		{
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, FORM_GLOBAL_ERROR);
			return REDIRECT_TO_PENDING_REQUEST
					+ (StringUtils.isNotBlank(customerUid) ? "/" + Functions.encodeUrl(currentUser.getCustomerPK()) : "");
		}
		editPendingPermissionsAndSetMessages(relationId, requestParam.equalsIgnoreCase(ACCEPT_PERMISSION), permissionForm,
				redirectAttributes, customerUid);
		return REDIRECT_TO_PENDING_REQUEST
				+ (StringUtils.isNotBlank(customerUid) ? "/" + Functions.encodeUrl(currentUser.getCustomerPK()) : "");
	}

	@RequestMapping(value = "/get-rel-address", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getRelationshipUserAddress(@RequestParam("id") final String customerId, final Model model)
			throws RelationshipDoesNotExistException
	{
		if (StringUtils.isNotBlank(customerId))
		{
			final CustomerData customer = psRelationshipFacade.getCustomerDataForUid(customerId);
			model.addAttribute("customer", customer);
			if (psPermissionFacade.isPermitted(getUser().getUid(), customerId, ADDRESS_BOOK_PERMISSIBLE_AREA))
			{
				model.addAttribute(RELATIONSHIPS_ADDRESS_DATA_ATTR,
						psRelationshipFacade.getRelationshipAddressBookByUser(customerId));
			}
			else
			{
				LOG.error("[{}] does not have privilege to access [{}]'s addressbook ", getUser().getUid(), customerId);
			}
			return ControllerConstants.Views.Fragments.Account.ViewRelationShipAddress;
		}
		else
		{
			return FORWARD_TO_404_PAGE;
		}
	}

	/**
	 * adds relationship if user does not else set it in session and returns the respective page
	 *
	 * @param relationshipForm
	 * @param redirectModel
	 * @return String
	 * @throws RelationshipAlreadyExistException
	 */
	private String addRelationAndReturnView(final RelationshipForm relationshipForm, final RedirectAttributes redirectModel)
			throws RelationshipAlreadyExistException
	{
		final String relationshipCustomerId = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
		final PSRelationshipData relationshipData = getPsRelationshipFacade().getActiveOrPendingRelation(
				(relationshipCustomerId != null) ? relationshipCustomerId : getUser().getUid(), relationshipForm.getEmailAddress());
		if (relationshipData != null)
		{
			return relationshipAlreadyExists(relationshipForm, redirectModel);
		}
		else if (getPsRelationshipFacade().isUserExists(relationshipForm.getEmailAddress()))
		{
			getSessionService().setAttribute(RELATIONSHIP_FORM, relationshipForm);
			return REDIRECT_TO_ADD_PERMISSION;
		}
		else
		{
			getPsRelationshipFacade().addRelationship((relationshipCustomerId != null) ? relationshipCustomerId : getUser().getUid(),
					relationshipForm.getEmailAddress(), null, null, relationshipForm.getTitle(), relationshipForm.getFirstName(),
					relationshipForm.getLastName());

			final PSRelationshipData relationship = getPsRelationshipFacade().getPendingRelation(
					(relationshipCustomerId != null) ? relationshipCustomerId : getUser().getUid(),
					relationshipForm.getEmailAddress());
			return REDIRECT_TO_RELATIONSHIP_CONFIRMATION + "/" + Functions.encodeUrl(relationship.getId());
		}
	}

	/**
	 * returns add relation page
	 *
	 * @param model
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	private String addRelationshipPage(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_RELATIONSHIP_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_RELATIONSHIP_CMS_PAGE));
		return getViewForPage(model);
	}

	/**
	 * stores relationship data in model and returns the view
	 *
	 * @param model
	 * @param relationship
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	private String storeRelationshipDataAndReturnViewPage(final Model model, final PSRelationshipData relationship)
			throws CMSItemNotFoundException
	{
		storeRelationshipDataInModel(model, relationship);
		storeCmsPageInModel(model, getContentPageForLabelOrId(RELATIONSHIP_CONFIRMATION_PAGE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RELATIONSHIP_CONFIRMATION_PAGE));
		return getViewForPage(model);
	}

	/**
	 * stores relationship data in model
	 *
	 * @param model
	 * @param relationship
	 */
	private void storeRelationshipDataInModel(final Model model, final PSRelationshipData relationship)
	{
		if (relationship != null)
		{
			model.addAttribute("relation", relationship);
			final boolean isTargetUserExists = relationship.getTargetUser() != null;
			model.addAttribute("isTargetUserExists", Boolean.valueOf(isTargetUserExists));
			model.addAttribute("activePermissibleItems", psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE, Boolean.TRUE));
			final String relationshipCustomerId = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
			String currentUser = getUser().getUid();
			if (relationshipCustomerId != null)
			{
				currentUser = relationshipCustomerId;
				model.addAttribute(RELATIONSHIP_CUSTOMER, psRelationshipFacade.getCustomerDataForUid(relationshipCustomerId));
			}

			if (isTargetUserExists)
			{
				final String targetUser = StringUtils.equals(currentUser, relationship.getSourceUser().getUid())
						? relationship.getTargetUser().getUid() : relationship.getSourceUser().getUid();
				model.addAttribute("requestedPermissionForTargetUser",
						psPermissionFacade.getPermissionsForStatus(currentUser, targetUser, Arrays.asList(PSPermissionStatus.PENDING)));
				//TODO revisar este metodo, se agregó un null al parametro nuevo permissibleAreaCode
				model.addAttribute("givenPermissionToTargetUser", psPermissionFacade.getGivenOrRequestedPermissionsForTargetUser(
						currentUser, targetUser, null, Arrays.asList(PSPermissionStatus.PENDING), false));
			}
		}
	}

	@RequestMapping(value = "/relationship/poa/add", method = RequestMethod.GET)
	@RequireHardLogIn
	public String addRelationshipForRelation(
			@RequestParam(value = "relationCustomerPK", required = true) final String relationCustomerPK, final Model model)
			throws CMSItemNotFoundException, RelationshipDoesNotExistException
	{
		if (relationCustomerPK == null)
		{
			LOG.info("Tried accessing the URL without mandatory params relationCustomerPK");
			return FORWARD_TO_404_PAGE;
		}

		final RelationshipForm relationship = new RelationshipForm();
		model.addAttribute(RELATIONSHIP_FORM, relationship);

		final CustomerData relationShipCustomer = psRelationshipFacade.getCustomerForPK(relationCustomerPK);
		String relationCustomerId = null;
		if (relationShipCustomer != null)
		{
			relationCustomerId = relationShipCustomer.getUid();
			getSessionService().setAttribute(SESSION_USER_IN_CONTEXT, relationCustomerId);
		}

		if (!checkPermission(relationCustomerId))
		{
			LOG.info("User " + getUser().getUid() + " does not have permissions/poa on " + relationCustomerId);
			return FORWARD_TO_404_PAGE;
		}

		if (StringUtils.isNotBlank(relationCustomerId))
		{
			model.addAttribute(RELATIONSHIP_CUSTOMER, psRelationshipFacade.getCustomerDataForUid(relationCustomerId));
		}
		return addRelationshipPage(model);
	}

	@RequestMapping(value = "/relationship/poa/add", method = RequestMethod.POST)
	@RequireHardLogIn
	public String addRelationshipPoa(final Model model, final RelationshipForm relationshipForm, final BindingResult bindingResult,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final String relationCustomerId = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
		if (relationCustomerId == null)
		{
			LOG.info("Tried accessing the URL without mandatory params relationCustomerId");
			return FORWARD_TO_404_PAGE;
		}

		if (!StringUtils.equalsIgnoreCase(relationCustomerId, relationshipForm.getEmailAddress()))
		{
			getRelationshipFormValidator().validate(relationshipForm, bindingResult);
			if (bindingResult.hasErrors())
			{
				GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
				model.addAttribute(RELATIONSHIP_FORM, relationshipForm);
				return addRelationshipPage(model);
			}

			try
			{
				return addRelationAndReturnViewForPOA(relationshipForm, redirectModel);
			}
			catch (final RelationshipAlreadyExistException e)
			{
				LOG.warn("Relationship already exists for given user while adding relation " + e);
				return relationshipAlreadyExists(relationshipForm, redirectModel);
			}
		}
		else
		{
			GlobalMessages.addErrorMessage(model, ERROR_RELATIONSHIP_SOURCE_TARGET_SAME_MESSAGE);
			model.addAttribute(RELATIONSHIP_FORM, relationshipForm);
			model.addAttribute(RELATIONSHIP_CUSTOMER, psRelationshipFacade.getCustomerDataForUid(relationCustomerId));
			return addRelationshipPage(model);
		}
	}

	/**
	 * adds relationship if user does not else set it in session and returns the respective page
	 *
	 * @param relationshipForm
	 * @param redirectModel
	 * @return String
	 * @throws RelationshipAlreadyExistException
	 */
	private String addRelationAndReturnViewForPOA(final RelationshipForm relationshipForm, final RedirectAttributes redirectModel)
			throws RelationshipAlreadyExistException
	{
		final String relationshipCustomerId = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
		final PSRelationshipData relationshipData = getPsRelationshipFacade().getActiveOrPendingRelation(
				(relationshipCustomerId != null) ? relationshipCustomerId : getUser().getUid(), relationshipForm.getEmailAddress());
		if (relationshipData != null)
		{
			return relationshipAlreadyExists(relationshipForm, redirectModel);
		}
		else if (getPsRelationshipFacade().isUserExists(relationshipForm.getEmailAddress()))
		{
			getSessionService().setAttribute(RELATIONSHIP_FORM, relationshipForm);
			return REDIRECT_TO_POA_ADD_PERMISSION;
		}
		else
		{
			getPsRelationshipFacade().addRelationship((relationshipCustomerId != null) ? relationshipCustomerId : getUser().getUid(),
					relationshipForm.getEmailAddress(), null, null, relationshipForm.getTitle(), relationshipForm.getFirstName(),
					relationshipForm.getLastName());

			final PSRelationshipData relationship = getPsRelationshipFacade().getPendingRelation(
					(relationshipCustomerId != null) ? relationshipCustomerId : getUser().getUid(),
					relationshipForm.getEmailAddress());
			return REDIRECT_TO_POA_RELATIONSHIP_CONFIRMATION + "/" + Functions.encodeUrl(relationship.getId());
		}
	}

	private void populateBackButtonUrl(final HttpServletRequest request, final Model model)
	{
		final String contextPath = request.getContextPath();
		String backButtonUrl = "";
		final Map<String, Object> modelMap = model.asMap();
		if (null != modelMap)
		{
			backButtonUrl = modelMap.get(MODEL_ATTR_BACK_BUTTON_URL) != null ? modelMap.get(MODEL_ATTR_BACK_BUTTON_URL).toString()
					: StringUtils.EMPTY;
		}

		if (StringUtils.isNotEmpty(backButtonUrl))
		{
			if (PSOpenRedirectValidator.isValidUrl(request, backButtonUrl))
			{
				model.addAttribute(LAST_REFERER_SOURCE, StringUtils.substringAfter(backButtonUrl, contextPath));
			}
		}
		else
		{
			final String refererURL = request.getHeader("referer");
			if (PSOpenRedirectValidator.isValidDomain(request))
			{
				model.addAttribute(LAST_REFERER_SOURCE, StringUtils.substringAfter(refererURL, contextPath));
			}
		}
	}
}

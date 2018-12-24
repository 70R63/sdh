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
package de.hybris.platform.relationshipaddon.controllers.pages;

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
import de.hybris.platform.relationshipaddon.controllers.ControllerConstants;
import de.hybris.platform.relationshipaddon.forms.PermissionForm;
import de.hybris.platform.relationshipaddon.forms.RelationshipForm;
import de.hybris.platform.relationshipservices.enums.PSPermissionStatus;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipAlreadyExistException;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for permission pages for my account.
 */
@Controller
@RequireHardLogIn
@RequestMapping("/my-account")
public class PSPermissionAccountPageController extends PSAbstractRelationshipAccountPageController
{
	private static final String RELATIONSHIP_ADD = "../relationship/add";
	private static final String REDIRECT_TO_ADD_RELATIONSHIP = REDIRECT_PREFIX + RELATIONSHIP_ADD;
	private static final String PERMISSION_FORM = "permissionForm";
	protected static final String ADD_PERMISSION_CMS_PAGE = "addPermissionPage";
	protected static final String REQUEST_MORE_PERMISSIONS_CMS_PAGE = "requestMorePermissionsPage";
	protected static final String CHANGE_PERMISSIONS_CMS_PAGE = "changePermissionsPage";

	/**
	 * returns add permission page
	 *
	 * @param model
	 * @param request
	 * @param response
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/permissions/add", method = RequestMethod.GET)
	public String getAddPermissions(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws CMSItemNotFoundException
	{
		if (getSessionService().getAttribute(RELATIONSHIP_FORM) != null)
		{
			final RelationshipForm relationshipForm = getSessionService().getAttribute(RELATIONSHIP_FORM);
			model.addAttribute("targetUserFirstName", relationshipForm.getFirstName());
			model.addAttribute(PERMISSION_FORM, new PermissionForm());
			model.addAttribute("permissibleItemTypes", psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE, Boolean.TRUE));

			final String relationshipCustomerId = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
			if (relationshipCustomerId != null)
			{
				model.addAttribute(RELATIONSHIP_CUSTOMER, psRelationshipFacade.getCustomerDataForUid(relationshipCustomerId));
			}
			return setupPermissionPage(model);
		}
		else
		{
			return REDIRECT_TO_ADD_RELATIONSHIP;
		}
	}

	/**
	 * returns add permission page
	 *
	 * @param model
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	private String setupPermissionPage(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_PERMISSION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_PERMISSION_CMS_PAGE));
		return getViewForPage(model);
	}

	/**
	 * add permission page post request
	 *
	 * @param model
	 * @param permissionForm
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param redirectModel
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/permissions/add", method = RequestMethod.POST)
	public String addPermission(final Model model, final PermissionForm permissionForm, final BindingResult bindingResult,
			final HttpServletRequest request, final HttpServletResponse response, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		final String relationshipCustomerId = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
		final RelationshipForm relationshipForm = getSessionService().getAttribute(RELATIONSHIP_FORM);
		if (relationshipForm != null && permissionForm != null)
		{
			getPermissionFormValidator().validate(permissionForm, bindingResult);
			if (bindingResult.hasErrors())
			{
				GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
				model.addAttribute(PERMISSION_FORM, permissionForm);
				model.addAttribute("permissibleItemTypes", psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE, Boolean.TRUE));
				model.addAttribute("targetUserFirstName", relationshipForm.getFirstName());
				if (relationshipCustomerId != null)
				{
					model.addAttribute(RELATIONSHIP_CUSTOMER, psRelationshipFacade.getCustomerDataForUid(relationshipCustomerId));
				}
				return setupPermissionPage(model);
			}
			try
			{
				addRelationWithPermissionForPermissionType(permissionForm, relationshipForm);
				final PSRelationshipData relationship = getPsRelationshipFacade().getActiveOrPendingRelation(
						relationshipCustomerId != null ? relationshipCustomerId : getUser().getUid(),
						relationshipForm.getEmailAddress());
				return REDIRECT_TO_RELATIONSHIP_CONFIRMATION + "/" + Functions.encodeUrl(relationship.getId());
			}
			catch (final RelationshipAlreadyExistException e)
			{
				LOG.info("Relationship already exists for given user while adding permission " + e);
				return relationshipAlreadyExists(relationshipForm, redirectModel);
			}
		}
		else
		{
			return REDIRECT_TO_ADD_RELATIONSHIP;
		}
	}

	@RequestMapping(value = "/my-relationships/cancelPermissionRequests/confirmation", method = RequestMethod.GET)
	@RequireHardLogIn
	public String viewCancelPermissionRequestConfirmation(@RequestParam("relationId") final String relationId,
			@RequestParam("sourceUserPK") final String sourceUserPK, @RequestParam("targetUserPK") final String targetUserPK,
			@RequestParam("isGiven") final boolean isGiven, @RequestParam("isSourceUserLoggedIn") final boolean isSourceUserLoggedIn,
			final Model model)
	{
		if (StringUtils.isNotBlank(relationId))
		{
			model.addAttribute("relationId", relationId);
		}
		if (StringUtils.isNotBlank(sourceUserPK))
		{
			model.addAttribute("sourceUserPK", sourceUserPK);
		}
		if (StringUtils.isNotBlank(targetUserPK))
		{
			model.addAttribute("targetUserPK", targetUserPK);
		}
		model.addAttribute("isGiven", isGiven);
		model.addAttribute("isSourceUserLoggedIn", isSourceUserLoggedIn);
		model.addAttribute("permissibleItems", psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE, Boolean.TRUE));

		final CustomerData sourceUser = psRelationshipFacade.getCustomerForPK(sourceUserPK);
		final CustomerData targetUser = psRelationshipFacade.getCustomerForPK(targetUserPK);
		final List<PSPermissionData> permissions = psPermissionFacade.getGivenOrRequestedPermissionsForTargetUser(
				sourceUser.getUid(), targetUser.getUid(), Collections.singletonList(PSPermissionStatus.PENDING), isGiven);
		if (CollectionUtils.isNotEmpty(permissions))
		{
			model.addAttribute("sourceUserName", permissions.get(0).getSourceUser().getName());
			model.addAttribute("targetUserName", permissions.get(0).getTargetUser().getName());
			model.addAttribute("permissions", permissions);

			return ControllerConstants.Views.Fragments.Account.ViewCancelPendingPermissionRequestsConfirmation;
		}
		LOG.error("Permission request not found for source user [{}] and target user [{}]", sourceUserPK, targetUserPK);
		throw new UnknownIdentifierException("Permission request not found");
	}

	/**
	 * Cancel pending permission requests
	 *
	 * @param relationId
	 * @param sourceUserPK
	 * @param targetUserPK
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/my-relationships/cancelPermissionRequests", method = RequestMethod.GET)
	@RequireHardLogIn
	public String cancelPermissionRequests(@RequestParam("relationId") final String relationId,
			@RequestParam("sourceUserPK") final String sourceUserPK, @RequestParam("targetUserPK") final String targetUserPK,
			@RequestParam("isGiven") final boolean isGiven, @RequestParam("isSourceUserLoggedIn") final boolean isSourceUserLoggedIn,
			final RedirectAttributes redirectAttributes)
	{
		if (StringUtils.isNotBlank(sourceUserPK) && StringUtils.isNotBlank(targetUserPK))
		{
			final CustomerData sourceUser = psRelationshipFacade.getCustomerForPK(sourceUserPK);
			final CustomerData targetUser = psRelationshipFacade.getCustomerForPK(targetUserPK);
			final List<PSPermissionData> permissions = psPermissionFacade.getGivenOrRequestedPermissionsForTargetUser(
					sourceUser.getUid(), targetUser.getUid(), Collections.singletonList(PSPermissionStatus.PENDING), isGiven);

			if (CollectionUtils.isNotEmpty(permissions))
			{
				final String currentUserId = getUser().getUid();

				final String srcUserId = isGiven ? sourceUser.getUid() : targetUser.getUid();
				final String trgUserId = isGiven ? targetUser.getUid() : sourceUser.getUid();
				// If signed in user is not the one who started permission request/offer
				// need to check if signed in user has permission to cancel permission requests.
				if ((isGiven && !currentUserId.equals(srcUserId)) || (!isGiven && !currentUserId.equals(trgUserId)))
				{
					// Check if signed in user has enough permission to cancel permission requests
					final boolean isPermitted = permissions.stream().allMatch(permission -> {
						try
						{
							return psPermissionFacade.isPermitted(currentUserId, isGiven ? srcUserId : trgUserId,
									permission.getPermissibleAreaItem().getShareableType());
						}
						catch (final RelationshipDoesNotExistException e)
						{
							LOG.info("Relationship not found", e);
							return false;
						}
					});

					if (!isPermitted)
					{ // Signed in user doesn't have enough permission, forward to 404 page
						return FORWARD_TO_404_PAGE;
					}
				}
				psPermissionFacade
						.cancelPermissionRequest(permissions.stream().map(PSPermissionData::getId).collect(Collectors.toList()));

				String firstName;
				String lastName;
				String name;
				final PSPermissionData permissionRequest = permissions.get(0);
				String messageKey;

				// Prepare the message to display
				if (isGiven)
				{
					messageKey = isSourceUserLoggedIn ? "message.offered.permission.cancel" : "message.offered.permission.cancel.poa";
					name = permissionRequest.getSourceUser().getFirstName();
					firstName = permissionRequest.getTargetUser().getFirstName();
					lastName = permissionRequest.getTargetUser().getLastName();
				}
				else
				{
					messageKey = isSourceUserLoggedIn ? "message.requested.permission.cancel"
							: "message.requested.permission.cancel.poa";
					name = permissionRequest.getTargetUser().getFirstName();
					firstName = permissionRequest.getSourceUser().getFirstName();
					lastName = permissionRequest.getSourceUser().getLastName();
				}
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER, messageKey, new Object[]
				{ firstName, lastName, name });
			}
			else
			{
				LOG.error("Permission request not found for source user [{}] and target user [{}]", sourceUser.getUid(),
						targetUser.getUid());
				throw new UnknownIdentifierException("Permission request not found");
			}

			return REDIRECT_MY_RELATIONSHIPS_MANAGE_DETAILS + "/" + Functions.encodeUrl(relationId) + "/"
					+ Functions.encodeUrl(sourceUser.getCustomerPK());
		}

		LOG.error("Missing source user [{}] or target user [{}]", sourceUserPK, targetUserPK);
		throw new UnknownIdentifierException("Missing source user or target user");
	}


	/**
	 * returns add permission page
	 *
	 * @param model
	 * @param request
	 * @param response
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/permissions/requestMore/" + RELATIONSHIP_ID_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String getRequestMorePermissions(@PathVariable final String relationId, final Model model,
			final HttpServletRequest request, final HttpServletResponse response) throws CMSItemNotFoundException
	{
		final CustomerData currCustomer = getUser();
		if (StringUtils.isNotBlank(relationId) && currCustomer != null)
		{
			final PSRelationshipData relationshipData = getPsRelationshipFacade().getRelationForId(relationId);
			final String permissionSourceUserPK = !currCustomer.getCustomerPK()
					.equalsIgnoreCase(relationshipData.getSourceUser().getCustomerPK())
							? relationshipData.getSourceUser().getCustomerPK() : relationshipData.getTargetUser().getCustomerPK();

			final CustomerData permissionSourceUser = getPsRelationshipFacade().getCustomerForPK(permissionSourceUserPK);

			final List<PSPermissionStatus> statuses = new ArrayList<>();
			statuses.add(PSPermissionStatus.ACTIVE);
			statuses.add(PSPermissionStatus.PENDING);
			final List<PSPermissionData> allPermissionsOfRelationship = psPermissionFacade
					.getPermissionsForStatus(permissionSourceUser.getUid(), currCustomer.getUid(), statuses);
			final List<String> allPermissibleTypeCodesOfRelationship = getPermissibleItemTypeCodesForPermission(
					allPermissionsOfRelationship);
			final List<PSPermissionData> activePermissionDataList = psPermissionFacade.getPermissionsForStatus(
					permissionSourceUser.getUid(), currCustomer.getUid(), Arrays.asList(PSPermissionStatus.ACTIVE));
			final List<PSPermissibleAreaData> activePermissibleItemTypes = activePermissionDataList.stream()
					.map(e -> e.getPermissibleAreaItem()).collect(Collectors.toCollection(ArrayList::new));
			final List<PSPermissionData> pendingPermissions = psPermissionFacade.getPermissionsForStatus(
					permissionSourceUser.getUid(), currCustomer.getUid(), Arrays.asList(PSPermissionStatus.PENDING));

			if (CollectionUtils.isNotEmpty(pendingPermissions))
			{
				LOG.debug("Access to request more permissions page is not allowed for given relation id " + relationId
						+ " as it has pending permissions.");
				return FORWARD_TO_404_PAGE;
			}

			model.addAttribute("permissionSourceUser", permissionSourceUser);
			model.addAttribute(PERMISSION_FORM, new PermissionForm());
			model.addAttribute("activePermissibleTypes", activePermissibleItemTypes);

			final List<PSPermissibleAreaData> allPermissibleAreas = psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE,
					Boolean.TRUE);
			final List<PSPermissibleAreaData> availablePermissibleAreaSelections = new ArrayList<>();

			for (final PSPermissibleAreaData permissibleArea : allPermissibleAreas)
			{
				if (!allPermissibleTypeCodesOfRelationship.contains(permissibleArea.getShareableType()))
				{
					availablePermissibleAreaSelections.add(permissibleArea);
				}
			}
			model.addAttribute("availablePermissibleAreaTypes", availablePermissibleAreaSelections);
			model.addAttribute("customerPk", currCustomer.getCustomerPK());
			final List<Breadcrumb> breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs(null);
			breadcrumbs.add(new Breadcrumb(MY_ACCOUNT_MY_RELATIONS_URL,
					getMessageSource().getMessage(TEXT_ACCOUNT_MY_RELATIONSHIPS, null, getI18nService().getCurrentLocale()), null));
			breadcrumbs.add(new Breadcrumb(
					MY_RELATIONSHIPS_MANAGE_DETAILS_URL + "/" + relationId + "/" + currCustomer.getCustomerPK(),
					getMessageSource().getMessage(TEXT_ACCOUNT_MANAGE_RELATIONSHIP_DETAILS, null, getI18nService().getCurrentLocale()),
					null));
			breadcrumbs.add(new Breadcrumb("#",
					getMessageSource().getMessage(TEXT_ACCOUNT_REQUEST_MORE_PERMISSIONS, null, getI18nService().getCurrentLocale()),
					null));
			model.addAttribute(BREADCRUMBS_ATTR, breadcrumbs);
			return setupRequestMorePermissionPage(model);
		}
		else
		{
			return REDIRECT_TO_ADD_RELATIONSHIP;
		}
	}

	/**
	 * add permission page post request
	 *
	 * @param model
	 * @param permissionForm
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param redirectModel
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/permissions/requestMore/" + RELATIONSHIP_ID_PATH_VARIABLE_PATTERN, method = RequestMethod.POST)
	public String requestMorePermissions(@PathVariable final String relationId, final Model model,
			final PermissionForm permissionForm, final BindingResult bindingResult, final HttpServletRequest request,
			final HttpServletResponse response, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final CustomerData currCustomer = getUser();
		if (relationId != null && currCustomer != null)
		{
			if (CollectionUtils.isNotEmpty(permissionForm.getTargetPermissibleItemTypes()))
			{
				final PSRelationshipData relationshipData = getPsRelationshipFacade().getRelationForId(relationId);
				final String permissionSourceUserPK = !currCustomer.getCustomerPK()
						.equalsIgnoreCase(relationshipData.getSourceUser().getCustomerPK())
								? relationshipData.getSourceUser().getCustomerPK() : relationshipData.getTargetUser().getCustomerPK();
				final CustomerData permissionSourceUser = getPsRelationshipFacade().getCustomerForPK(permissionSourceUserPK);

				final List<PSPermissionData> permissionSourceUserData = psPermissionFacade
						.getPermissionsForStatus(currCustomer.getUid(), permissionSourceUser.getUid(), null);
				final List<String> sourceExistingTypeCodes = getPermissibleItemTypeCodesForPermission(permissionSourceUserData);
				final List<String> sourceTypeCodesToAdd = new ArrayList<>();
				for (final String targetPermissibleItemType : permissionForm.getTargetPermissibleItemTypes())
				{
					if (!sourceExistingTypeCodes.contains(targetPermissibleItemType))
					{
						sourceTypeCodesToAdd.add(targetPermissibleItemType);
					}
				}
				psPermissionFacade.requestMorePermission(permissionSourceUser.getUid(), currCustomer.getUid(),
						permissionForm.getTargetPermissibleItemTypes(), PSPermissionStatus.PENDING);

				final String userFirstName = relationshipData.getTargetUser().getUid().equals(currCustomer.getUid())
						? relationshipData.getSourceUser().getFirstName() : relationshipData.getTargetUser().getFirstName();

				final String messageKey = "message.requested.more.permissions.acceptance";
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, messageKey, new Object[]
				{ userFirstName, userFirstName });
			}
			return REDIRECT_MY_RELATIONSHIPS_MANAGE_DETAILS + "/" + Functions.encodeUrl(relationId) + "/"
					+ Functions.encodeUrl(currCustomer.getCustomerPK());
		}
		else
		{
			return REDIRECT_TO_ADD_RELATIONSHIP;
		}
	}

	@RequestMapping(value = "/permissions/change/" + RELATIONSHIP_ID_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String getChangePermissions(@PathVariable final String relationId, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final CustomerData currCustomer = getUser();
		if (StringUtils.isNotBlank(relationId) && currCustomer != null)
		{
			final PSRelationshipData relationshipData = getPsRelationshipFacade().getRelationForId(relationId);
			final String permissionTargetUserPk = !currCustomer.getCustomerPK()
					.equalsIgnoreCase(relationshipData.getSourceUser().getCustomerPK())
							? relationshipData.getSourceUser().getCustomerPK() : relationshipData.getTargetUser().getCustomerPK();
			final CustomerData permissionTargetUser = getPsRelationshipFacade().getCustomerForPK(permissionTargetUserPk);

			final List<PSPermissionData> pendingPermissions = psPermissionFacade.getPermissionsForStatus(currCustomer.getUid(),
					permissionTargetUser.getUid(), Arrays.asList(PSPermissionStatus.PENDING));

			if (CollectionUtils.isNotEmpty(pendingPermissions))
			{
				LOG.debug("Access to change permissions page is not allowed for given relation id " + relationId
						+ " as it has pending permissions.");
				return FORWARD_TO_404_PAGE;
			}

			final List<PSPermissionData> existingActivePermissions = psPermissionFacade.getPermissionsForStatus(
					currCustomer.getUid(), permissionTargetUser.getUid(), Arrays.asList(PSPermissionStatus.ACTIVE));

			final PermissionForm permissionForm = new PermissionForm();
			permissionForm.setSourcePermissibleItemTypes(getPermissibleItemTypeCodesForPermission(existingActivePermissions));

			final List<PSPermissibleAreaData> permissibleItems = psPermissionFacade.getPermissibleItemTypes(Boolean.TRUE,
					Boolean.TRUE);

			model.addAttribute("permissionTargetUser", permissionTargetUser);
			model.addAttribute("relationId", relationId);
			model.addAttribute(PERMISSION_FORM, permissionForm);
			model.addAttribute("permissibleItems", permissibleItems);
			model.addAttribute("customerPk", currCustomer.getCustomerPK());
			final List<Breadcrumb> breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs(null);
			breadcrumbs.add(new Breadcrumb(MY_ACCOUNT_MY_RELATIONS_URL,
					getMessageSource().getMessage(TEXT_ACCOUNT_MY_RELATIONSHIPS, null, getI18nService().getCurrentLocale()), null));
			breadcrumbs.add(new Breadcrumb(
					MY_RELATIONSHIPS_MANAGE_DETAILS_URL + "/" + relationId + "/" + currCustomer.getCustomerPK(),
					getMessageSource().getMessage(TEXT_ACCOUNT_MANAGE_RELATIONSHIP_DETAILS, null, getI18nService().getCurrentLocale()),
					null));
			breadcrumbs.add(new Breadcrumb("#",
					getMessageSource().getMessage(TEXT_ACCOUNT_CHANGE_PERMISSIONS, null, getI18nService().getCurrentLocale()), null));
			model.addAttribute(BREADCRUMBS_ATTR, breadcrumbs);
			return setupChangePermissionPage(model);
		}
		else
		{
			return REDIRECT_TO_ADD_RELATIONSHIP;
		}
	}

	/**
	 * add permission page post request
	 *
	 * @param model
	 * @param permissionForm
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param redirectModel
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/permissions/change/" + RELATIONSHIP_ID_PATH_VARIABLE_PATTERN, method = RequestMethod.POST)
	public String changePermissions(@PathVariable final String relationId, final Model model, final PermissionForm permissionForm,
			final BindingResult bindingResult, final HttpServletRequest request, final HttpServletResponse response,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final CustomerData currCustomer = getUser();
		if (relationId != null && currCustomer != null)
		{
			final PSRelationshipData relationshipData = getPsRelationshipFacade().getRelationForId(relationId);
			final String permissionTargetUserPk = !currCustomer.getCustomerPK()
					.equalsIgnoreCase(relationshipData.getSourceUser().getCustomerPK())
							? relationshipData.getSourceUser().getCustomerPK() : relationshipData.getTargetUser().getCustomerPK();
			final CustomerData permissionTargetUser = getPsRelationshipFacade().getCustomerForPK(permissionTargetUserPk);

			final String userFirstName = relationshipData.getTargetUser().getUid().equals(currCustomer.getUid())
					? relationshipData.getSourceUser().getFirstName() : relationshipData.getTargetUser().getFirstName();

			psPermissionFacade.changePermissions(currCustomer.getUid(), permissionTargetUser.getUid(),
					permissionForm.getSourcePermissibleItemTypes(), false);

			final String messageKey = "message.requested.change.permissions.acceptance";
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, messageKey, new Object[]
			{ userFirstName, userFirstName });

			return REDIRECT_MY_RELATIONSHIPS_MANAGE_DETAILS + "/" + Functions.encodeUrl(relationId) + "/"
					+ Functions.encodeUrl(currCustomer.getCustomerPK());
		}
		else
		{
			return REDIRECT_TO_ADD_RELATIONSHIP;
		}
	}

	/**
	 * returns request more permissions page
	 *
	 * @param model
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	private String setupRequestMorePermissionPage(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		storeCmsPageInModel(model, getContentPageForLabelOrId(REQUEST_MORE_PERMISSIONS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(REQUEST_MORE_PERMISSIONS_CMS_PAGE));
		return getViewForPage(model);
	}

	/**
	 * returns change permission page
	 *
	 * @param model
	 * @throws CMSItemNotFoundException
	 */
	private String setupChangePermissionPage(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		storeCmsPageInModel(model, getContentPageForLabelOrId(CHANGE_PERMISSIONS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CHANGE_PERMISSIONS_CMS_PAGE));
		return getViewForPage(model);
	}

	/**
	 * adds relations with permission for given permission item types
	 *
	 * @param permissionForm
	 * @param relationshipForm
	 * @throws RelationshipAlreadyExistException
	 */
	private void addRelationWithPermissionForPermissionType(final PermissionForm permissionForm,
			final RelationshipForm relationshipForm) throws RelationshipAlreadyExistException
	{
		final String relationshipCustomerId = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
		switch (permissionForm.getPermissionType())
		{
			case GIVE_PERMISSION:
				getPsRelationshipFacade().addRelationship(
						relationshipCustomerId != null ? relationshipCustomerId : getUser().getUid(),
						relationshipForm.getEmailAddress(), permissionForm.getSourcePermissibleItemTypes(), null,
						relationshipForm.getTitle(), relationshipForm.getFirstName(), relationshipForm.getLastName());
				break;
			case REQUEST_PERMISSION:
				getPsRelationshipFacade().addRelationship(
						relationshipCustomerId != null ? relationshipCustomerId : getUser().getUid(),
						relationshipForm.getEmailAddress(), null, permissionForm.getTargetPermissibleItemTypes(),
						relationshipForm.getTitle(), relationshipForm.getFirstName(), relationshipForm.getLastName());
				break;
			case GIVE_AND_REQUEST_PERMISSION:
				getPsRelationshipFacade().addRelationship(
						relationshipCustomerId != null ? relationshipCustomerId : getUser().getUid(),
						relationshipForm.getEmailAddress(), permissionForm.getSourcePermissibleItemTypes(),
						permissionForm.getTargetPermissibleItemTypes(), relationshipForm.getTitle(), relationshipForm.getFirstName(),
						relationshipForm.getLastName());
				break;
			default:
				break;
		}
	}

}
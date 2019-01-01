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
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractCheckoutController.SelectOption;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.tags.Functions;
import de.hybris.platform.addonsupport.controllers.page.AbstractAddOnPageController;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.i18n.I18NFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.TitleData;
import de.hybris.platform.relationship.data.PSPermissionData;
import de.hybris.platform.relationship.data.PSRelationshipData;
import de.hybris.platform.sdhrelationshipsaddon.forms.PermissionForm;
import de.hybris.platform.sdhrelationshipsaddon.forms.RelationshipForm;
import de.hybris.platform.sdhrelationshipsaddon.forms.validator.PermissionFormValidator;
import de.hybris.platform.sdhrelationshipsaddon.forms.validator.RelationshipFormValidator;
import de.hybris.platform.relationshipfacades.permission.PSPermissionFacade;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.relationshipservices.enums.PSPermissionStatus;
import de.hybris.platform.relationshipservices.enums.PSRelationshipStatus;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Abstract Controller for relationship pages for my account.
 */
@Controller
@RequireHardLogIn
@RequestMapping("/my-account")
public class PSAbstractRelationshipAccountPageController extends AbstractAddOnPageController
{
	protected static final Logger LOG = LoggerFactory.getLogger(PSAbstractRelationshipAccountPageController.class);
	protected static final String RELATIONSHIP_CUSTOMER = "relationshipCustomer";
	protected static final String SESSION_USER_IN_CONTEXT = "userInContext";
	protected static final String RELATIONSHIP_FORM = "relationshipForm";
	protected static final String PERMISSION_FORM_ATTR = "permissionForm";
	protected static final String FORM_GLOBAL_ERROR = "form.global.error";
	protected static final String RELATIONSHIPS_PERMISSIBLE_AREA = "relationships";
	protected static final String BREADCRUMBS_ATTR = "breadcrumbs";
	protected static final String ADDRESS_BOOK_PERMISSIBLE_AREA = "Address";
	protected static final String RELATIONSHIP_CONFIRMATION = "../relationship/confirmation";
	protected static final String REDIRECT_TO_RELATIONSHIP_CONFIRMATION = REDIRECT_PREFIX + RELATIONSHIP_CONFIRMATION;
	protected static final String MY_RELATIONSHIPS_MANAGE_DETAILS_URL = "/my-account/my-relationships/manage-details";
	protected static final String REDIRECT_MY_RELATIONSHIPS_MANAGE_DETAILS = REDIRECT_PREFIX + MY_RELATIONSHIPS_MANAGE_DETAILS_URL;
	protected static final String REDIRECT_TO_PENDING_REQUEST = REDIRECT_PREFIX + "/my-account/pending-requests";

	protected static final String FORWARD_TO_404_PAGE = FORWARD_PREFIX + "/404";
	protected static final String REDIRECT_TO_404_PAGE = REDIRECT_PREFIX + "/404";

	protected static final String MY_ACCOUNT_MY_RELATIONS_URL = "/my-account/my-relationships";

	protected static final String TEXT_ACCOUNT_MY_RELATIONSHIPS = "text.account.myRelationships";
	protected static final String TEXT_ACCOUNT_MY_PENDING_REQUESTS = "text.account.myPendingRequests";
	protected static final String TEXT_ACCOUNT_MANAGE_RELATIONSHIP_DETAILS = "text.manage.relationship.details";
	protected static final String TEXT_ACCOUNT_REQUEST_MORE_PERMISSIONS = "text.manage.details.more.permissions.request.button.accessibility";
	protected static final String TEXT_ACCOUNT_CHANGE_PERMISSIONS = "text.manage.details.change.permissions.relationships.button";
	protected static final String ERROR_RELATIONSHIP_EXISTS_MESSAGE = "error.relationship.exists";
	protected static final String ERROR_RELATIONSHIP_SOURCE_TARGET_SAME_MESSAGE = "error.relationship.source.target.same";

	protected static final String GIVE_AND_REQUEST_PERMISSION = "3";
	protected static final String REQUEST_PERMISSION = "2";
	protected static final String GIVE_PERMISSION = "1";

	protected static final String RELATIONSHIP_ID_PATH_VARIABLE_PATTERN = "{relationId:.*}";
	protected static final String CUSTOMER_PK_PATH_VARIABLE_PATTERN = "{customerPK:.*}";

	final String[] DISALLOWED_FIELDS = new String[] {};

	@InitBinder
	public void initBinder(final WebDataBinder binder)
	{
		binder.setDisallowedFields(DISALLOWED_FIELDS);
	}

	@Resource(name = "userFacade")
	protected UserFacade userFacade;

	@Resource(name = "relationshipFormValidator")
	protected RelationshipFormValidator relationshipValidator;

	@Resource(name = "permissionFormValidator")
	protected PermissionFormValidator permissionValidator;

	@Resource(name = "i18NFacade")
	protected I18NFacade i18NFacade;

	@Resource(name = "psMyAccountBreadcrumbBuilder")
	protected ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "psRelationshipfacade")
	protected PSRelationshipFacade psRelationshipFacade;

	@Resource(name = "psPermissionFacade")
	protected PSPermissionFacade psPermissionFacade;

	@Resource(name = "customerFacade")
	protected CustomerFacade customerFacade;

	/**
	 * check the condition for an existing relationship and redirect accordingly
	 *
	 * @param relationshipForm
	 * @param redirectModel
	 * @return String
	 */
	protected String relationshipAlreadyExists(final RelationshipForm relationshipForm, final RedirectAttributes redirectModel)
	{
		final String relationshipCustomerId = getSessionService().getAttribute(SESSION_USER_IN_CONTEXT);
		final PSRelationshipData relationshipData = getPsRelationshipFacade().getActiveOrPendingRelation(
				(relationshipCustomerId != null) ? relationshipCustomerId : getUser().getUid(), relationshipForm.getEmailAddress());
		final CustomerData currCustomer = getUser();

		if (relationshipData.getStatus().equals(PSRelationshipStatus.ACTIVE))
		{
			LOG.info("Relationship already active for given user");
			if (relationshipCustomerId != null)
			{
				final CustomerData relationshipCustomer = psRelationshipFacade.getCustomerDataForUid(relationshipCustomerId);

				final String userFirstName = relationshipData.getSourceUser().getUid().equals(relationshipCustomerId)
						? relationshipData.getTargetUser().getFirstName() : relationshipData.getSourceUser().getFirstName();

				final String userLastName = relationshipData.getSourceUser().getUid().equals(relationshipCustomerId)
						? relationshipData.getTargetUser().getLastName() : relationshipData.getSourceUser().getLastName();

				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
						"message.relationship.already.exists.for.poa", new Object[]
						{ relationshipCustomer.getFirstName() + " " + relationshipCustomer.getLastName(), userFirstName + " " + userLastName });

				return REDIRECT_MY_RELATIONSHIPS_MANAGE_DETAILS + "/" + Functions.encodeUrl(relationshipData.getId()) + "/"
						+ Functions.encodeUrl(relationshipCustomer.getCustomerPK());
			}
			else
			{
				final String userFirstName = relationshipData.getTargetUser().getUid().equals(currCustomer.getUid())
						? relationshipData.getSourceUser().getFirstName() : relationshipData.getTargetUser().getFirstName();

				final String userLastName = relationshipData.getTargetUser().getUid().equals(currCustomer.getUid())
						? relationshipData.getSourceUser().getLastName() : relationshipData.getTargetUser().getLastName();

				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
						"message.relationship.already.exists", new Object[]
						{ userFirstName, userLastName });
			}
			return REDIRECT_MY_RELATIONSHIPS_MANAGE_DETAILS + "/" + Functions.encodeUrl(relationshipData.getId()) + "/"
					+ Functions.encodeUrl(currCustomer.getCustomerPK());
		}
		else if ((relationshipData.getStatus().equals(PSRelationshipStatus.PENDING)) && (relationshipData.getSourceUser().getUid()
				.equals((relationshipCustomerId != null) ? relationshipCustomerId : currCustomer.getUid())))
		{
			LOG.info("Relationship already pending for source user");
			if (relationshipCustomerId != null)
			{
				final CustomerData relationshipCustomer = psRelationshipFacade.getCustomerDataForUid(relationshipCustomerId);

				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
						"message.pending.relationship.already.exists.for.poa", new Object[]
						{ relationshipCustomer.getFirstName() + " " + relationshipCustomer.getLastName(), relationshipData.getFirstName() + " " + relationshipData.getLastName() });

				return REDIRECT_MY_RELATIONSHIPS_MANAGE_DETAILS + "/" + Functions.encodeUrl(relationshipData.getId()) + "/"
						+ Functions.encodeUrl(relationshipCustomer.getCustomerPK());
			}
			else
			{
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
						"message.pending.relationship.already.exists", new Object[]
						{ relationshipData.getFirstName(), relationshipData.getLastName() });
			}
			return REDIRECT_MY_RELATIONSHIPS_MANAGE_DETAILS + "/" + Functions.encodeUrl(relationshipData.getId()) + "/"
					+ Functions.encodeUrl(currCustomer.getCustomerPK());
		}

		else if ((relationshipData.getStatus().equals(PSRelationshipStatus.PENDING)) && (relationshipData.getTargetUser().getUid()
				.equals((relationshipCustomerId != null) ? relationshipCustomerId : currCustomer.getUid())))
		{
			LOG.info("Relationship already pending for target user");
			if (relationshipCustomerId != null)
			{
				final CustomerData relationshipCustomer = psRelationshipFacade.getCustomerDataForUid(relationshipCustomerId);
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
						"message.pending.relationship.already.exists.for.poa", new Object[]
						{ relationshipCustomer.getFirstName() + " " + relationshipCustomer.getLastName(), relationshipData.getSourceUser().getFirstName() + " " + relationshipData.getSourceUser().getLastName() });

				return REDIRECT_TO_PENDING_REQUEST + ("/" + Functions.encodeUrl(relationshipCustomer.getCustomerPK()));
			}
			else
			{
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
						"message.pending.relationship.already.exists", new Object[]
						{ relationshipData.getSourceUser().getFirstName(), relationshipData.getSourceUser().getLastName() });
			}
			return REDIRECT_TO_PENDING_REQUEST;
		}
		return FORWARD_TO_404_PAGE;
	}

	@ModelAttribute("permissionTypes")
	public final List<SelectOption> getPermissionTypes()
	{
		final List<SelectOption> permissionTypes = new ArrayList<>();

		permissionTypes.add(new SelectOption(GIVE_PERMISSION, "permission.give"));
		permissionTypes.add(new SelectOption(REQUEST_PERMISSION, "permission.request"));
		permissionTypes.add(new SelectOption(GIVE_AND_REQUEST_PERMISSION, "permission.giveandrequest"));
		return permissionTypes;
	}

	@ModelAttribute("titles")
	public final Collection<TitleData> getTitles()
	{
		return getUserFacade().getTitles();
	}

	@ExceptionHandler(UnknownIdentifierException.class)
	public String handleUnknownIdentifierException(final UnknownIdentifierException exception, final HttpServletRequest request)
	{
		request.setAttribute("message", exception.getMessage());
		return REDIRECT_PREFIX + "/404";
	}

	@ExceptionHandler(ModelNotFoundException.class)
	public String handleModelNotFoundException(final ModelNotFoundException exception, final HttpServletRequest request)
	{
		request.setAttribute("message", exception.getMessage());
		return REDIRECT_PREFIX + "/404";
	}

	protected List<PSPermissionData> getPendingPermissions(final List<PSPermissionData> permissions)
	{
		if (CollectionUtils.isNotEmpty(permissions))
		{
			return permissions.stream().filter(permission -> PSPermissionStatus.PENDING.equals(permission.getStatus()))
					.collect(Collectors.toCollection(ArrayList::new));
		}
		return Collections.emptyList();
	}

	protected void editPendingPermissionsAndSetMessages(final String relationId, final boolean isAccepted,
			final PermissionForm permissionForm, final RedirectAttributes redirectAttributes, final String customerUid)
	{
		final PSRelationshipData relationData = getPsRelationshipFacade().getRelationForId(relationId);

		final CustomerData targetUser = getCurrentUser(customerUid);
		final boolean isPoaCase = StringUtils.isBlank(customerUid) ? false : true;
		final String userFirstName = relationData.getSourceUser().getUid().equals(targetUser.getUid())
				? relationData.getTargetUser().getFirstName() : relationData.getSourceUser().getFirstName();
		String messageKey;
		final List<String> selectedTypeCodes;
		List<String> rejectedTypeCodes;

		if (permissionForm.getPermissionType().equalsIgnoreCase(GIVE_PERMISSION))
		{
			selectedTypeCodes = permissionForm.getSourcePermissibleItemTypes();
			psPermissionFacade.updatePendingRequestForTypeCodes(relationId, isAccepted, true, isAccepted ? selectedTypeCodes : null,
					isAccepted ? null : selectedTypeCodes);
			if (!isPoaCase)
			{
				messageKey = isAccepted ? "message.given.permissions.acceptance" : "message.given.permissions.rejection";
			}
			else
			{
				messageKey = isAccepted ? "message.given.permissions.acceptance.poa" : "message.given.permissions.rejection.poa";
			}
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER, messageKey, new Object[]
			{ userFirstName, targetUser.getFirstName(), targetUser.getLastName() });

		}
		else if (permissionForm.getPermissionType().equalsIgnoreCase(REQUEST_PERMISSION))
		{
			selectedTypeCodes = permissionForm.getTargetPermissibleItemTypes();
			final List<PSPermissionData> pendingPermissions = getPendingPermissions(
					relationData.getRequestedPermissionsFromCurrentUser());
			final List<String> permissionTypeCodes = getPermissibleItemTypeCodesForPermission(pendingPermissions);
			if (isAccepted)
			{
				if (CollectionUtils.isNotEmpty(selectedTypeCodes))
				{
					permissionTypeCodes.removeAll(selectedTypeCodes);
				}
				rejectedTypeCodes = permissionTypeCodes;
			}
			else
			{
				rejectedTypeCodes = permissionTypeCodes;
			}

			psPermissionFacade.updatePendingRequestForTypeCodes(relationId, isAccepted, false, isAccepted ? selectedTypeCodes : null,
					rejectedTypeCodes);
			if (!isPoaCase)
			{
				messageKey = isAccepted ? "message.requested.permissions.acceptance" : "message.requested.permissions.rejection";
			}
			else
			{
				messageKey = isAccepted ? "message.requested.permissions.acceptance.poa"
						: "message.requested.permissions.rejection.poa";
			}
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER, messageKey, new Object[]
			{ userFirstName, userFirstName, targetUser.getFirstName() });
		}
	}

	protected List<String> getPermissibleItemTypeCodesForPermission(final List<PSPermissionData> permissionsData)
	{
		if (CollectionUtils.isNotEmpty(permissionsData))
		{
			return permissionsData.stream().map(e -> e.getPermissibleAreaItem().getShareableType())
					.collect(Collectors.toCollection(ArrayList::new));
		}
		return Collections.emptyList();
	}

	/**
	 * Return current user in operation. This may be signed in user or user the signed in user is having POA over
	 *
	 * @param customerUid
	 * @return CustomerData
	 */
	protected CustomerData getCurrentUser(final String customerUid)
	{
		if (StringUtils.isBlank(customerUid))
		{
			return getUser();
		}
		else
		{
			final CustomerData targetUser = psRelationshipFacade.getCustomerDataForUid(customerUid);
			if (targetUser == null)
			{
				throw new ModelNotFoundException("Customer with Uid = " + customerUid + " not found");
			}

			return targetUser;
		}
	}

	/**
	 * Check if current user has permission on customerUid's relationship
	 *
	 * @param customerUid
	 * @return true if user with customerUid has permission
	 */
	protected boolean checkPermission(final String customerUid)
	{
		try
		{
			return psPermissionFacade.isPermitted(getUser().getUid(), customerUid, RELATIONSHIPS_PERMISSIBLE_AREA);
		}
		catch (final RelationshipDoesNotExistException e)
		{
			LOG.warn("Relationship between source user [{}] and target user [{}] not found", getUser().getUid(), customerUid, e);
			return false;
		}
	}

	protected final UserFacade getUserFacade()
	{
		return userFacade;
	}

	protected final RelationshipFormValidator getRelationshipFormValidator()
	{
		return relationshipValidator;
	}

	protected final PermissionFormValidator getPermissionFormValidator()
	{
		return permissionValidator;
	}

	protected PSRelationshipFacade getPsRelationshipFacade()
	{
		return psRelationshipFacade;
	}

	protected ResourceBreadcrumbBuilder getAccountBreadcrumbBuilder()
	{
		return accountBreadcrumbBuilder;
	}
}

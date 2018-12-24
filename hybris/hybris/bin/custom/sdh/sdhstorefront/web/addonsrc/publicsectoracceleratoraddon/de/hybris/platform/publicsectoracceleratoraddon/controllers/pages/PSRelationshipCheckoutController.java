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
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.exception.PSInvalidSessionException;
import de.hybris.platform.publicsectoracceleratoraddon.security.PSOpenRedirectValidator;
import de.hybris.platform.publicsectorfacades.order.PSCartFacade;
import de.hybris.platform.publicsectorservices.model.PSServiceProductModel;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller for relation related functionalities
 */
@Controller
@RequestMapping("/checkout/multi/relations")
public class PSRelationshipCheckoutController extends AbstractPageController
{
	private static final String REDIRECT_CHECKOUT_MULTI = "redirect:/checkout/multi";
	private static final String INVALID_SESSION_EXCEPTION_MSG = "Session is invalid.";
	@Resource(name = "psRelationshipfacade")
	private PSRelationshipFacade psRelationshipFacade;

	@Resource(name = "checkoutFacade")
	private CheckoutFacade checkoutFacade;

	@Resource(name = "psCartFacade")
	private PSCartFacade psCartFacade;

	/**
	 * Returns relation for current user whoever has given service request access
	 *
	 * @param model
	 * @return String
	 * @throws RelationshipDoesNotExistException
	 */
	@RequestMapping(value = "/getRelations/serviceRequestAccess", method = RequestMethod.GET)
	public String getRelationsForCurrentUser(final Model model) throws RelationshipDoesNotExistException, PSInvalidSessionException
	{

		if (getUserFacade().isAnonymousUser())
		{
			throw new PSInvalidSessionException(INVALID_SESSION_EXCEPTION_MSG);
		}

		List<CustomerData> relations = psRelationshipFacade.getRelationshipUsersForUserAndPermissibleItemType(getUser().getUid(),
				PSServiceProductModel._TYPECODE);
		final CustomerData currentUserInContext = getCheckoutFacade().getCheckoutCart().getUserInContext();

		if (CollectionUtils.isNotEmpty(relations) && currentUserInContext != null)
		{
			relations = relations.stream().filter(e -> !e.getUid().equals(currentUserInContext.getUid()))
					.collect(Collectors.toList());
		}
		model.addAttribute("relations", relations);
		model.addAttribute("showCurrentUser", Boolean.FALSE);

		if (currentUserInContext != null && !getUser().getUid().equals(currentUserInContext.getUid()))
		{
			model.addAttribute("showCurrentUser", Boolean.TRUE);
			model.addAttribute("currentUser", getUser());
		}
		return ControllerConstants.Views.Fragments.Checkout.RelationshipDetails;
	}

	/**
	 * removes the current cart information and set the selected applicant as current user in context and redirects to
	 * initial page
	 *
	 * @param userId
	 * @param model
	 * @return String
	 * @throws RelationshipDoesNotExistException
	 * @throws CommerceCartModificationException
	 */
	@RequireHardLogIn
	@RequestMapping(value = "/chooseApplicant", method = RequestMethod.POST)
	public String chooseSelectedApplicant(@RequestParam(value = "userId", required = true) final String userId, final Model model,
			final HttpServletRequest request) throws RelationshipDoesNotExistException, CommerceCartModificationException
	{
		final String refererURL = request.getHeader("referer");
		final String contextPath = request.getContextPath();

		String redirectUrl = "/";
		if (PSOpenRedirectValidator.isValidDomain(request))
		{
			redirectUrl = REDIRECT_PREFIX + StringUtils.substringAfter(refererURL, contextPath);
		}
		getPSCartFacade().setDraftCartDetails(redirectUrl);
		getPSCartFacade().updateUserInCartWithContextUser();
		getPSCartFacade().rebuildSessionCartFromCurrentCart();
		getRelationshipFacade().updateCartUserInContext(userId);
		return REDIRECT_CHECKOUT_MULTI;
	}

	protected PSRelationshipFacade getRelationshipFacade()
	{
		return psRelationshipFacade;
	}

	protected CheckoutFacade getCheckoutFacade()
	{
		return checkoutFacade;
	}

	protected PSCartFacade getPSCartFacade()
	{
		return psCartFacade;
	}
}

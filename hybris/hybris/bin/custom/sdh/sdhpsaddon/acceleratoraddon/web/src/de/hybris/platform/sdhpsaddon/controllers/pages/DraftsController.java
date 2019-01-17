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

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.security.GUIDCookieStrategy;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commerceservices.order.CommerceCartRestorationException;
import de.hybris.platform.sdhpsaddon.forms.RetrieveDraftForm;
import de.hybris.platform.sdhpsaddon.forms.validation.RetrieveDraftValidator;
import de.hybris.platform.publicsectorfacades.order.PSCartFacade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Controller for draft
 */
@Controller
@RequestMapping(value = "/drafts")
public class DraftsController extends AbstractPageController
{
	private static final Logger LOG = LoggerFactory.getLogger(DraftsController.class);
	private static final String INVALID_EMAIL_DRAFT_NO_ERROR = "form.invalid.draft.email";
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String RETRIEVE_DRAFT_BREADCRUMB = "breadcrumb.retrieve.draft";
	private static final String RETRIEVE_DRAFTS_CMS_PAGE = "retrieve-draft";
	private static final String REDIRECT_TO_MY_ACCOUNT_DRAFTS_PAGE = REDIRECT_PREFIX + "/my-account/applications";
	private static final String REDIRECT_TO_CHECKOUT_PAGE = REDIRECT_PREFIX + "/checkout/multi";

	@Resource(name = "simpleBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder resourceBreadcrumbBuilder;

	@Resource(name = "userFacade")
	private UserFacade userFacade;

	@Resource(name = "retrieveDraftValidator")
	private RetrieveDraftValidator retriveDraftValidator;

	@Resource(name = "psCartFacade")
	private PSCartFacade psCartFacade;

	@Resource(name = "guidCookieStrategy")
	private GUIDCookieStrategy guidCookieStrategy;

	final String[] DISALLOWED_FIELDS = new String[] {};

	@InitBinder
	public void initBinder(final WebDataBinder binder)
	{
		binder.setDisallowedFields(DISALLOWED_FIELDS);
	}

	/**
	 * Retrieve draft page GET Request
	 *
	 * @param model
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/retrieve-draft", method = RequestMethod.GET)
	public String showRetrieveDraft(final Model model) throws CMSItemNotFoundException
	{
		if (userFacade.isAnonymousUser())
		{
			final RetrieveDraftForm retrieveForm = new RetrieveDraftForm();
			model.addAttribute("retrieveDraftForm", retrieveForm);
			return setUpCMSPageForRetrieveDraft(model);
		}
		return REDIRECT_TO_MY_ACCOUNT_DRAFTS_PAGE;
	}

	/**
	 * Retrieve draft page POST request
	 *
	 */
	@RequestMapping(value = "/retrieve-draft", method = RequestMethod.POST)
	public String retrieveDraft(final Model model, final RetrieveDraftForm retrieveForm, final BindingResult bindingResult,
			final HttpServletRequest request, final HttpServletResponse response) throws CMSItemNotFoundException
	{
		getRetriveDraftValidator().validate(retrieveForm, bindingResult);

		if (bindingResult.hasErrors())
		{
			GlobalMessages.addErrorMessage(model, INVALID_EMAIL_DRAFT_NO_ERROR);
			return setUpCMSPageForRetrieveDraft(model);
		}
		CartData cart = null;
		try
		{
			cart = getPsCartFacade().restoreCartForDraftNumberAndEmailAddress(retrieveForm.getDraftNumber(),
					retrieveForm.getEmail());
		}
		catch (final CommerceCartRestorationException e)
		{
			LOG.error(e.getMessage(), e);
		}

		if (cart != null)
		{
			getGuidCookieStrategy().setCookie(request, response);
			getSessionService().setAttribute(WebConstants.ANONYMOUS_CHECKOUT, Boolean.TRUE);

			if (cart.getReturnURL() != null)
			{
				getPsCartFacade().updateLastAccessTimeInCartForGuestUser(retrieveForm.getDraftNumber(), retrieveForm.getEmail());
				return cart.getReturnURL();
			}
			else
			{
				return REDIRECT_TO_CHECKOUT_PAGE;
			}
		}
		else
		{
			GlobalMessages.addErrorMessage(model, INVALID_EMAIL_DRAFT_NO_ERROR);
			return setUpCMSPageForRetrieveDraft(model);
		}
	}

	/**
	 * set's up the cms page and return the view
	 *
	 * @throws CMSItemNotFoundException
	 */
	protected String setUpCMSPageForRetrieveDraft(final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(RETRIEVE_DRAFTS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RETRIEVE_DRAFTS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, resourceBreadcrumbBuilder.getBreadcrumbs(RETRIEVE_DRAFT_BREADCRUMB));
		return getViewForPage(model);
	}

	@Override
	protected UserFacade getUserFacade()
	{
		return userFacade;
	}

	protected RetrieveDraftValidator getRetriveDraftValidator()
	{
		return retriveDraftValidator;
	}

	protected PSCartFacade getPsCartFacade()
	{
		return this.psCartFacade;
	}

	protected GUIDCookieStrategy getGuidCookieStrategy()
	{
		return guidCookieStrategy;
	}
}

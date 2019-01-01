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
package de.hybris.platform.sdhpsaddon.filters;

import de.hybris.platform.billfacades.bill.PSBillPaymentFacade;
import de.hybris.platform.billfacades.bill.data.PSBillPaymentData;
import de.hybris.platform.billservices.model.PSBillPaymentModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.relationshipfacades.permission.PSPermissionFacade;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.filter.OncePerRequestFilter;


/**
 * This filter performs a permission check on requested bill object or requested customer's bill type for current
 * customer before allowing the access. If no access user is sent to 404 page
 */
public class PSCheckBillPermissionsFilter extends OncePerRequestFilter
{

	private PSBillPaymentFacade psBillPaymentFacade;
	private ConfigurationService configurationService;
	private PSRelationshipFacade psRelationshipFacade;
	private PSPermissionFacade psPermissionFacade;
	private CustomerFacade customerFacade;
	private UserFacade userFacade;
	List<String> patternsList;

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException
	{
		// Temporary workaround - Skip filter if Anonymous user
		if (!getUserFacade().isAnonymousUser())
		{
			boolean patternMatch = false;
			for (final String patternString : patternsList)
			{
				final Pattern p = Pattern.compile(patternString);

				if (p.matcher(request.getRequestURL().toString()).matches())
				{
					patternMatch = true;
					break;
				}
			}
			if (patternMatch)
			{
				final String billCode = request.getParameter("billCode");
				final String customerId = request.getParameter("customerId");
				String otherUserId = null;
				if (billCode != null)
				{
					final PSBillPaymentData billPaymentData = psBillPaymentFacade.getBill(billCode);
					if (billPaymentData != null)
					{
						otherUserId = billPaymentData.getEmailOnRecord();
					}
				}
				else if (customerId != null)
				{
					otherUserId = customerId;
				}

				try
				{
					if (otherUserId != null && !otherUserId.equalsIgnoreCase(getCustomerFacade().getCurrentCustomerUid())
							&& !getPsPermissionFacade().isPermitted(getCustomerFacade().getCurrentCustomerUid(), otherUserId,
									PSBillPaymentModel._TYPECODE))
					{
						logger.error("PSCheckBillPermissionsFilter - NOT PErmitted");
						sendToHomepage(request, response);
					}
				}
				catch (final RelationshipDoesNotExistException e)
				{
					logger.warn("Failed to get bills. " + getCustomerFacade().getCurrentCustomerUid()
							+ " does not have bills permission for " + otherUserId, e);
					sendToHomepage(request, response);
				}
			}
		}
		filterChain.doFilter(request, response);
	}

	private void sendToHomepage(final HttpServletRequest request, final HttpServletResponse response) throws IOException
	{
		response.setStatus(404);
		final String contextPath = request.getContextPath();
		final String encodedRedirectUrl = response.encodeRedirectURL(contextPath + "/404");
		response.sendRedirect(encodedRedirectUrl);
	}

	protected PSBillPaymentFacade getPsBillPaymentFacade()
	{
		return psBillPaymentFacade;
	}

	@Required
	public void setPsBillPaymentFacade(final PSBillPaymentFacade psBillPaymentFacade)
	{
		this.psBillPaymentFacade = psBillPaymentFacade;
	}

	protected ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	@Required
	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	protected PSRelationshipFacade getPsRelationshipFacade()
	{
		return psRelationshipFacade;
	}

	@Required
	public void setPsRelationshipFacade(final PSRelationshipFacade psRelationshipFacade)
	{
		this.psRelationshipFacade = psRelationshipFacade;
	}

	protected CustomerFacade getCustomerFacade()
	{
		return customerFacade;
	}

	@Required
	public void setCustomerFacade(final CustomerFacade customerFacade)
	{
		this.customerFacade = customerFacade;
	}

	protected List<String> getPatternsList()
	{
		return patternsList;
	}

	@Required
	public void setPatternsList(final List<String> patternsList)
	{
		this.patternsList = patternsList;
	}

	protected UserFacade getUserFacade()
	{
		return userFacade;
	}

	@Required
	public void setUserFacade(final UserFacade userFacade)
	{
		this.userFacade = userFacade;
	}

	protected PSPermissionFacade getPsPermissionFacade()
	{
		return psPermissionFacade;
	}

	@Required
	public void setPsPermissionFacade(final PSPermissionFacade psPermissionFacade)
	{
		this.psPermissionFacade = psPermissionFacade;
	}
}

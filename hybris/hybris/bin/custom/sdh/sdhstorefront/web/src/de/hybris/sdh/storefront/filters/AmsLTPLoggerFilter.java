/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * 
 *  
 */
package de.hybris.sdh.storefront.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;


/**
 * A filter that logs each request.
 */
public class AmsLTPLoggerFilter extends GenericFilterBean
{
	private static final Logger LOG = Logger.getLogger(AmsLTPLoggerFilter.class.getName());

	private String executionThreshold;

	private UserService userService;
	
	@Override
	public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException
	{
		if (servletRequest instanceof HttpServletRequest)
		{
			final String requestDetails = buildRequestDetails((HttpServletRequest) servletRequest);

			ServletResponse response = servletResponse;
			if (response instanceof HttpServletResponse)
			{
				response = new ResponseWrapper((HttpServletResponse) response);
			}

			final long startTime = System.currentTimeMillis();
			try
			{
				filterChain.doFilter(servletRequest, response);
			}
			finally
			{
				final long endTime = System.currentTimeMillis();
				final long duration = endTime - startTime;
				final long durationSeconds = (endTime - startTime)/1000;
				if ((durationSeconds >= Integer.parseInt(getExecutionThreshold())) && print((HttpServletRequest)servletRequest)) {
					int status = 0;
					if (response instanceof ResponseWrapper)
					{
						status = ((ResponseWrapper) response).getStatus();
					}
	
					if (status != 0)
					{
						LOG.info(requestDetails + duration + " ms "+durationSeconds+" (s) (" + status + ") LTP executed by " + getUser());
					}
					else
					{
						LOG.info(requestDetails + duration + " ms  "+durationSeconds+" (s) LTP executed by " + getUser());
					}
				}
			}

			return;
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	protected String getUser() {
		UserModel currentUser = getUserService().getCurrentUser();
		if (currentUser == null || getUserService().isAnonymousUser(currentUser) ) {
			return "anonymous";
		}
		return currentUser.getUid();
	}
	protected String buildRequestDetails(final HttpServletRequest request)
	{
		String queryString = request.getQueryString();
		if (queryString == null)
		{
			queryString = "";
		}

		final String requestUri = request.getRequestURI();

		final String securePrefix = request.isSecure() ? "s" : " ";
		final String methodPrefix = request.getMethod().substring(0, 1);

		return securePrefix + methodPrefix + " [" + requestUri + "] [" + queryString + "] ";
	}

	protected static class ResponseWrapper extends HttpServletResponseWrapper
	{
		private int status;

		public ResponseWrapper(final HttpServletResponse response)
		{
			super(response);
		}

		@Override
		public void setStatus(final int status)
		{
			super.setStatus(status);
			this.status = status;
		}

		public int getStatus()
		{
			return status;
		}

		@Override
		public void sendError(final int status, final String msg) throws IOException
		{
			super.sendError(status, msg);
			this.status = status;
		}

		@Override
		public void sendError(final int status) throws IOException
		{
			super.sendError(status);
			this.status = status;
		}
	}
	private boolean print(final HttpServletRequest request) {
		String requestDetails = request.getRequestURI();
		
		if (requestDetails == null) return false;
		
		if (requestDetails.contains(".js]") || requestDetails.contains(".png]") ||  
			requestDetails.contains(".gif]") || requestDetails.contains(".dsp]") || requestDetails.contains("password")) {
			return false;
		}
		
		return true;
	}
	
	public String getExecutionThreshold() {
		return executionThreshold;
	}


	public void setExecutionThreshold(String executionThreshold) {
		this.executionThreshold = executionThreshold;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

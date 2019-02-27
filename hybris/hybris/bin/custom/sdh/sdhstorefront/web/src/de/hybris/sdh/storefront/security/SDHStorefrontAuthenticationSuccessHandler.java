/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.storefront.security;

import de.hybris.platform.acceleratorstorefrontcommons.security.StorefrontAuthenticationSuccessHandler;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.InfoContribResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;


/**
 * Success handler initializing user settings, restoring or merging the cart and ensuring the cart is handled correctly.
 * Cart restoration is stored in the session since the request coming in is that to j_spring_security_check and will be
 * redirected.
 */
public class SDHStorefrontAuthenticationSuccessHandler extends StorefrontAuthenticationSuccessHandler
{
	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "modelService")
	ModelService modelService;

	private static final Logger LOG = Logger.getLogger(SDHStorefrontAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
										final Authentication authentication) throws IOException, ServletException
	{
		super.onAuthenticationSuccess(request, response, authentication);


		final String uiud = authentication.getPrincipal().toString();

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final String numBP = customerModel.getNumBP();

		try
		{
			final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
			consultaContribuyenteBPRequest.setNumBP(numBP);
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();

			if (null != sdhConsultaContribuyenteBPResponse)
			{
				customerModel.setFirstName(sdhConsultaContribuyenteBPResponse.getInfoContrib().getPrimNom());
				customerModel.setMiddleName(sdhConsultaContribuyenteBPResponse.getInfoContrib().getSegNom());
				customerModel.setLastName(sdhConsultaContribuyenteBPResponse.getInfoContrib().getPrimApe());
				customerModel.setSecondLastName(sdhConsultaContribuyenteBPResponse.getInfoContrib().getSegApe());

				modelService.save(customerModel);

			}




		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP: " + e.getMessage());
		}
	}

}

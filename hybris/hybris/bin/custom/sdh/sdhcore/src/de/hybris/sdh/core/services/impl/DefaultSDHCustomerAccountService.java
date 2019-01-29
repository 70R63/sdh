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
package de.hybris.sdh.core.services.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;
import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService;
import de.hybris.platform.commerceservices.event.ForgottenPwdEvent;
import de.hybris.platform.commerceservices.security.SecureToken;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.sdh.core.event.SDHRegistrationEvent;
import de.hybris.sdh.core.exceptions.SameOldPasswordException;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.UpdateCustomerCommPrefsRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHUpdateCustomerCommPrefsService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.rpc.holders.StringHolder;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.Assert;

import de.hybirs.sdh.core.soap.ZWS_HYSEND_MAIL_INT;


/**
 * Default implementation of {@link CustomerAccountService}
 */
public class DefaultSDHCustomerAccountService extends DefaultCustomerAccountService implements SDHCustomerAccountService
{
	private static final Logger LOG = Logger.getLogger(DefaultSDHCustomerAccountService.class);

	@Resource(name = "sdhUpdateCommPrefsService")
	SDHUpdateCustomerCommPrefsService sdhUpdateCommPrefsService;


	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService flexibleSearchService;

	@Resource(name = "DefaultZWS_HYBSEND_MAIL_CORE")
	private ZWS_HYSEND_MAIL_INT crm_mail;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService#register(de.hybris.platform.core.
	 * model.user.CustomerModel, java.lang.String)
	 */
	@Override
	public void register(final CustomerModel customerModel, final String password) throws DuplicateUidException
	{
		validateParameterNotNullStandardMessage("customerModel", customerModel);
		final long timeStamp = getTokenValiditySeconds() > 0L ? new Date().getTime() : 0L;
		final SecureToken data = new SecureToken(customerModel.getUid(), timeStamp);
		final String token = getSecureTokenService().encryptData(data);
		customerModel.setToken(token);


		//update preference info in SAP
		final UpdateCustomerCommPrefsRequest updateCustomerCommPrefsRequest = new UpdateCustomerCommPrefsRequest();

		updateCustomerCommPrefsRequest.setNumBP(customerModel.getNumBP());
		updateCustomerCommPrefsRequest.setEmail(customerModel.getUid());
		updateCustomerCommPrefsRequest.setUseEmailForNotifications(customerModel.getUseEmailForNotifications());
		updateCustomerCommPrefsRequest
				.setUseInformationForInstitutionalPurposes(customerModel.getUseInformationForInstitutionalPurposes());

		final LocalDateTime now = LocalDateTime.now();

		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		final String formatDateTime = now.format(formatter);

		updateCustomerCommPrefsRequest.setAutoBuzonDate(formatDateTime);

		sdhUpdateCommPrefsService.updateCustomerCommPrefs(updateCustomerCommPrefsRequest);

		//update customer info in hybris

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());



		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			if ("nit".equalsIgnoreCase(customerModel.getDocumentType()) || "nite".equalsIgnoreCase(customerModel.getDocumentType()))
			{
				customerModel.setName(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG1());
			}
			else
			{
				customerModel.setName(sdhConsultaContribuyenteBPResponse.getInfoContrib().getPrimNom());
			}


			customerModel.setMiddleName(sdhConsultaContribuyenteBPResponse.getInfoContrib().getSegNom());
			customerModel.setSecondLastName(sdhConsultaContribuyenteBPResponse.getInfoContrib().getSegApe());

		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP: " + e.getMessage());
		}




		registerCustomer(customerModel, password);

		final SDHRegistrationEvent event = new SDHRegistrationEvent();

		event.setBaseStore(getBaseStoreService().getCurrentBaseStore());
		event.setSite(getBaseSiteService().getCurrentBaseSite());
		event.setCustomer(customerModel);
		event.setLanguage(getCommonI18NService().getCurrentLanguage());
		event.setCurrency(getCommonI18NService().getCurrentCurrency());
		event.setToken(token);

		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+- Token [" +token+"] -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		LOG.info("-+-+-+-+-+-+-+-+-+-+-+-+-+-+- Token [" +token+"] -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

		final StringHolder a = new StringHolder();
		final StringHolder b = new StringHolder();
		final String path = configurationService.getConfiguration().getString("website.sdh.https");
		final String hybrisURL = path+ "/es/login/pw/activateAccount?token=";
		final String encodedToken = this.getEncodedURL(token);


		crm_mail.send(customerModel.getUid(),
				"Para activar tu cuenta ingresa <A HREF='"+hybrisURL+encodedToken+"'>AQUÍ</A> <BR/>",
				"SDH Activar Cuenta - Hybris ",
				a,
				b);

		getEventService().publishEvent(event);
	}


	@Override
	protected void registerCustomer(final CustomerModel customerModel, final String password) throws DuplicateUidException
	{
		validateParameterNotNullStandardMessage("customerModel", customerModel);

		generateCustomerId(customerModel);
		if (password != null)
		{
			getUserService().setPassword(customerModel, password, getPasswordEncoding());
		}
		internalSaveCustomer(customerModel);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#activateAccount(java.lang.String)
	 */
	@Override
	public void activateAccount(final String token) throws TokenInvalidatedException
	{
		Assert.hasText(token, "The field [token] cannot be empty");

		final SecureToken data = getSecureTokenService().decryptData(token);
		if (getTokenValiditySeconds() > 0L)
		{
			final long delta = new Date().getTime() - data.getTimeStamp();
			if (delta / 1000 > getTokenValiditySeconds())
			{
				throw new TokenInvalidatedException();
			}
		}

		final CustomerModel customer = getUserService().getUserForUID(data.getData(), CustomerModel.class);
		if (customer == null)
		{
			throw new TokenInvalidatedException();
		}
		if (!token.equals(customer.getToken()))
		{
			throw new TokenInvalidatedException();
		}
		customer.setToken(null);
		customer.setLoginDisabled(false);
		getModelService().save(customer);


	}


	@Override
	public boolean isUserRegistered(final String documentNumber, final String documentType)
	{
		final String query = "SELECT {pk} FROM {Customer AS C } WHERE {documentType} = ?documentType AND {documentNumber} = ?documentNumber";

		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("documentType", documentType);
		queryParams.put("documentNumber", documentNumber);

		final SearchResult<CustomerModel> usersResults;

		usersResults = flexibleSearchService.search(query, queryParams);

		if (usersResults.getTotalCount() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}

	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService#forgottenPassword(de.hybris.
	 * platform.core.model.user.CustomerModel)
	 */
	@Override
	public void forgottenPassword(final CustomerModel customerModel)
	{
		validateParameterNotNullStandardMessage("customerModel", customerModel);
		final long timeStamp = getTokenValiditySeconds() > 0L ? new Date().getTime() : 0L;
		final SecureToken data = new SecureToken(customerModel.getUid(), timeStamp);
		final String token = getSecureTokenService().encryptData(data);
		customerModel.setToken(token);
		getModelService().save(customerModel);
		getEventService().publishEvent(initializeEvent(new ForgottenPwdEvent(token), customerModel));

		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+- SDH Token reset [" +token+"] -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		LOG.info("-+-+-+-+-+-+-+-+-+-+-+-+-+-+- SDH Token reset [" +token+"] -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

		final StringHolder a = new StringHolder();
		final StringHolder b = new StringHolder();
		final String path = configurationService.getConfiguration().getString("website.sdh.https");
		final String hybrisURL = path + "/es/login/pw/change?token=";
		final String encodedToken = this.getEncodedURL(token);


		crm_mail.send(customerModel.getUid(),
				"Para recuperar tu contraseña ingresa <A HREF='" + hybrisURL + encodedToken + "'>AQUÍ</A> <BR/>",
				"SDH Recuperar Cuenta - Hybris ", a, b);

	}

	private String getEncodedURL(final String token){
		String encodedURL = "";
		try {
			encodedURL = URLEncoder.encode(token , "UTF-8");
		}catch(final UnsupportedEncodingException e) {
			throw new AssertionError("UTF-8 not supported");
		}
		return encodedURL;
	}

	@Override
	public String generateCustomerSessionToken(final String bp) {
		final long timeStamp = getTokenValiditySeconds() > 0L ? new Date().getTime() : 0L;
		final SecureToken data = new SecureToken(bp, timeStamp);
		final String token = getSecureTokenService().encryptData(data);

		System.out.println("bp ---->:" + bp);

		return this.getEncodedURL(token);
		//return "";
	}

	@Override
	public boolean validateToken(final String token, final String uidUser) {

		final boolean isValidToken = false;

		try {
			final SecureToken data = getSecureTokenService().decryptData(token);
			if (getTokenValiditySeconds() > 0L)
			{
				final long delta = new Date().getTime() - data.getTimeStamp();
				if (delta / 1000 > getTokenValiditySeconds())
				{
					throw new TokenInvalidatedException();
				}
			}


			System.out.println("data.getData() ----->" + data.getData());
			System.out.println("uidUser ----->" + uidUser);

			if(!data.getData().equals(uidUser)) {
				throw new TokenInvalidatedException();
			}

			/*final CustomerModel customer = getUserService().getUserForUID(data.getData(), CustomerModel.class);
			if (customer == null)
			{
				throw new TokenInvalidatedException();
			}
			if (!token.equals(customer.getToken()))
			{
				throw new TokenInvalidatedException();
			}*/

		}catch(final TokenInvalidatedException e) {
			LOG.info(e.getStackTrace());
		}
		return true;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService#updatePassword(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void updatePassword(final String token, final String newPassword) throws TokenInvalidatedException
	{
		Assert.hasText(token, "The field [token] cannot be empty");
		Assert.hasText(newPassword, "The field [newPassword] cannot be empty");

		final SecureToken data = getSecureTokenService().decryptData(token);
		if (getTokenValiditySeconds() > 0L)
		{
			final long delta = new Date().getTime() - data.getTimeStamp();
			if (delta / 1000 > getTokenValiditySeconds())
			{
				throw new IllegalArgumentException("token expired");
			}
		}

		final CustomerModel customer = getUserService().getUserForUID(data.getData(), CustomerModel.class);
		if (customer == null)
		{
			throw new IllegalArgumentException("user for token not found");
		}



		if (!token.equals(customer.getToken()))
		{
			throw new TokenInvalidatedException();
		}



		validateParameterNotNullStandardMessage("customerModel", customer);
		if (getPasswordEncoderService().isValid(customer, newPassword))
		{
			throw new SameOldPasswordException(customer.getUid());
		}

		customer.setToken(null);
		customer.setLoginDisabled(false);
		getModelService().save(customer);

		getUserService().setPassword(data.getData(), newPassword, getPasswordEncoding());
	}





}


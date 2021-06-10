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
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.servicelayer.user.daos.UserGroupDao;
import de.hybris.sdh.core.event.SDHRegistrationEvent;
import de.hybris.sdh.core.exceptions.SameOldPasswordException;
import de.hybris.sdh.core.model.SDHAddressModel;
import de.hybris.sdh.core.model.SDHAgentModel;
import de.hybris.sdh.core.model.SDHExteriorPublicityTaxModel;
import de.hybris.sdh.core.model.SDHGasTaxModel;
import de.hybris.sdh.core.model.SDHICATaxModel;
import de.hybris.sdh.core.model.SDHPhoneModel;
import de.hybris.sdh.core.model.SDHContribTaxModel;
import de.hybris.sdh.core.model.SDHPredialTaxModel;
import de.hybris.sdh.core.model.SDHReteICATaxModel;
import de.hybris.sdh.core.model.SDHRolModel;
import de.hybris.sdh.core.model.SDHSocialNetworkModel;
import de.hybris.sdh.core.model.SDHUrbanDelineationsTaxModel;
import de.hybris.sdh.core.model.SDHVehiculosTaxModel;
import de.hybris.sdh.core.pojos.requests.ConsultaContribBPRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.SendEmailRequest;
import de.hybris.sdh.core.pojos.requests.UpdateCustomerCommPrefsRequest;
import de.hybris.sdh.core.pojos.requests.UpdateEmailRitRequest;
import de.hybris.sdh.core.pojos.responses.ContribAdicionales;
import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.ContribDireccion;
import de.hybris.sdh.core.pojos.responses.ContribRedSocial;
import de.hybris.sdh.core.pojos.responses.ContribTelefono;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoICA;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.ImpuestosResponse;
import de.hybris.sdh.core.pojos.responses.InfoContribResponse;
import de.hybris.sdh.core.pojos.responses.NombreRolResponse;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
//import de.hybris.sdh.core.services.;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHSendEmailService;
import de.hybris.sdh.core.services.SDHUpdateCustomerCommPrefsService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Resource;
import javax.xml.rpc.holders.StringHolder;

import org.apache.commons.lang3.StringUtils;
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

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "sdhSendEmailService")
	private SDHSendEmailService sdhSendEmailService;

	@Resource(name = "userGroupDao")
	private UserGroupDao userGroupDao;

	@Resource(name = "sdhConsultaImpuesto_simplificado")
	SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

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


		//		crm_mail.send(customerModel.getUid(),
		//				"Para activar tu cuenta ingresa <A HREF='"+hybrisURL+encodedToken+"'>AQUÍ</A> <BR/>",
		//				"SDH Activar Cuenta - Hybris ",
		//				a,
		//				b);

		final SendEmailRequest request = new SendEmailRequest();

		request.setEmail(customerModel.getUid());
		request.setSubject("SDH Activar Cuenta - Hybris ");
		request.setMessage("Para activar tu cuenta ingresa <A HREF='" + hybrisURL + encodedToken + "'>AQUÍ</A> <BR/>");

		sdhSendEmailService.sendEmail(request);

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


		//		crm_mail.send(customerModel.getUid(),
		//				"Para recuperar tu contraseña ingresa <A HREF='" + hybrisURL + encodedToken + "'>AQUÍ</A> <BR/>",
		//				"SDH Recuperar Cuenta - Hybris ", a, b);

		final SendEmailRequest request = new SendEmailRequest();

		request.setEmail(customerModel.getUid());
		request.setSubject("SDH Recuperar Cuenta - Hybris ");
		request.setMessage("Para recuperar tu contraseña ingresa <A HREF='" + hybrisURL + encodedToken + "'>AQUÍ</A> <BR/>");

		sdhSendEmailService.sendEmail(request);

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


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#updateMiRitInfo()
	 */
	@Override
	public void updateMiRitInfo()
	{

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		this.updateMiRitInfo_simplificado(customerModel, "01,02");

	}

	@Override
	public CustomerModel  updateMiRitInfo(final CustomerModel customerModel)
	{
		final String numBP = customerModel.getNumBP();

		try
		{
			final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
			consultaContribuyenteBPRequest.setNumBP(numBP);
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


			final String response = sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest);
			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					response,
					SDHValidaMailRolResponse.class);

			final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();

			if (null != infoContribuyente)
			{
				customerModel.setFirstName(infoContribuyente.getPrimNom());
				customerModel.setMiddleName(infoContribuyente.getSegNom());
				customerModel.setLastName(infoContribuyente.getPrimApe());
				customerModel.setSecondLastName(infoContribuyente.getSegApe());

				customerModel.setDocumentNumber(infoContribuyente.getNumDoc());
				customerModel.setDocumentType(infoContribuyente.getTipoDoc());
				//TODO: save document expedition date

				customerModel.setDocumentNumber(infoContribuyente.getNumDoc());


				final ContribAdicionales adicionales = infoContribuyente.getAdicionales();
				if (null != adicionales)
				{
					customerModel.setSdhType(adicionales.getTYPE());
					customerModel.setSdhTitle(adicionales.getTITLE());
					customerModel.setNameOrg1(adicionales.getNAME_ORG1());
					customerModel.setNameOrg2(adicionales.getNAME_ORG2());
					customerModel.setNameOrg3(adicionales.getNAME_ORG3());
					customerModel.setNameOrg4(adicionales.getNAME_ORG4());


					customerModel.setDigVer(adicionales.getDIGVERIF());
					customerModel.setLegalEntity(adicionales.getLEGAL_ENTY());
					customerModel.setLegalOrg(adicionales.getLEGALORG());
					customerModel.setUseEmailForNotifications(
							(1 == adicionales.getZZAUTOBUZONE()) ? Boolean.TRUE : Boolean.FALSE);
					customerModel.setUseInformationForInstitutionalPurposes(
							(1 == adicionales.getZZAUTOUSOINF()) ? Boolean.TRUE : Boolean.FALSE);
					//TODO: fecha de autorizacion de uso de buzon

				}

				//clean old addresses
				final List<SDHAddressModel> currentAddresses = customerModel.getAddressList();

				if (currentAddresses != null && !currentAddresses.isEmpty())
				{
					modelService.removeAll(currentAddresses);
				}

				final List<ContribDireccion> direcciones = infoContribuyente.getDireccion();

				if (direcciones != null && !direcciones.isEmpty())
				{

					final List<SDHAddressModel> newAddresses = new ArrayList<SDHAddressModel>();

					for (final ContribDireccion eachAddress : direcciones)
					{

						if (StringUtils.isBlank(eachAddress.getADR_KIND()))
						{
							continue;
						}

						final SDHAddressModel eachAddressModel = new SDHAddressModel();
						eachAddressModel.setAddKind(eachAddress.getADR_KIND());
						eachAddressModel.setStreet(eachAddress.getSTREET());
						eachAddressModel.setPostalCode(eachAddress.getPOST_CODE());
						eachAddressModel.setCity(eachAddress.getCITY1());
						eachAddressModel.setCountry(eachAddress.getCOUNTRY());
						eachAddressModel.setRegion(eachAddress.getREGION());

						newAddresses.add(eachAddressModel);

					}

					modelService.saveAll(newAddresses);

					customerModel.setAddressList(newAddresses);

				}
				else
				{
					customerModel.setAddressList(null);
				}






				//clean old social networks
				final List<SDHSocialNetworkModel> socialNetworks = customerModel.getNetworkList();

				if (socialNetworks != null && !socialNetworks.isEmpty())
				{
					modelService.removeAll(socialNetworks);
				}

				final List<ContribRedSocial> redsocial = infoContribuyente.getRedsocial();

				if (redsocial != null && !redsocial.isEmpty())
				{

					final List<SDHSocialNetworkModel> newSocialNetwork = new ArrayList<SDHSocialNetworkModel>();

					for (final ContribRedSocial eachSocialNetwork : redsocial)
					{
						if (StringUtils.isBlank(eachSocialNetwork.getRED_SOCIAL()))
						{
							continue;
						}

						final SDHSocialNetworkModel eachSocialNetworkModel = new SDHSocialNetworkModel();
						eachSocialNetworkModel.setSocialNetwork(eachSocialNetwork.getRED_SOCIAL());
						eachSocialNetworkModel.setUsername(eachSocialNetwork.getUSUARIORED());
						newSocialNetwork.add(eachSocialNetworkModel);

					}

					modelService.saveAll(newSocialNetwork);

					customerModel.setNetworkList(newSocialNetwork);
				}
				else
				{
					customerModel.setNetworkList(null);
				}

			}





			//clean old agents
			final List<SDHAgentModel> oldAgentModels = customerModel.getAgentList();

			if (oldAgentModels != null && !oldAgentModels.isEmpty())
			{
				modelService.removeAll(oldAgentModels);
			}

			final List<ContribAgente> agents = sdhConsultaContribuyenteBPResponse.getAgentes();

			if (agents != null && !agents.isEmpty())
			{

				final List<SDHAgentModel> newAgentModels = new ArrayList<SDHAgentModel>();

				for (final ContribAgente eachAgentResponse : agents)
				{
					if (StringUtils.isBlank(eachAgentResponse.getNumDoc()))
					{
						continue;
					}

					final SDHAgentModel eachNewAgentModel = new SDHAgentModel();

					eachNewAgentModel.setAgent(eachAgentResponse.getAgente());
					eachNewAgentModel.setDocumentNumber(eachAgentResponse.getNumDoc());
					eachNewAgentModel.setDocumentType(eachAgentResponse.getTipoDoc());
					eachNewAgentModel.setCompleteName(eachAgentResponse.getNomCompleto());
					eachNewAgentModel.setInternalFunction(eachAgentResponse.getFuncionInterl());
					eachNewAgentModel.setBp(eachAgentResponse.getBp());
					eachNewAgentModel.setMenu(eachAgentResponse.getMenu());

					newAgentModels.add(eachNewAgentModel);

				}

				modelService.saveAll(newAgentModels);

				customerModel.setAgentList(newAgentModels);
			}
			else
			{
				customerModel.setAgentList(null);
			}



			//clean old publicidad exterior taxes

			final List<SDHExteriorPublicityTaxModel> oldPETaxModels = customerModel.getExteriorPublicityTaxList();

			if (oldPETaxModels != null && !oldPETaxModels.isEmpty())
			{
				modelService.removeAll(oldPETaxModels);
			}

			final List<ImpuestoPublicidadExterior> publicidadExterior = sdhConsultaContribuyenteBPResponse.getPublicidadExt();

			if (publicidadExterior != null && !publicidadExterior.isEmpty())
			{

				final List<SDHExteriorPublicityTaxModel> newPETaxModels = new ArrayList<SDHExteriorPublicityTaxModel>();

				for (final ImpuestoPublicidadExterior eachPETax : publicidadExterior)
				{
					if (StringUtils.isBlank(eachPETax.getNumResolu()))
					{
						continue;
					}

					final SDHExteriorPublicityTaxModel eachNewPETaxModel = new SDHExteriorPublicityTaxModel();
					eachNewPETaxModel.setResolutionNumber(eachPETax.getNumResolu());
					eachNewPETaxModel.setFenceType(eachPETax.getTipoValla());
					eachNewPETaxModel.setObjectNumber(eachPETax.getNumObjeto());
					eachNewPETaxModel.setAnoGravable(eachPETax.getAnoGravable());

					newPETaxModels.add(eachNewPETaxModel);

				}

				modelService.saveAll(newPETaxModels);

				customerModel.setExteriorPublicityTaxList(newPETaxModels);
			}
			else
			{
				customerModel.setExteriorPublicityTaxList(null);
			}


			//clean old gas taxes

			final List<SDHGasTaxModel> oldGasTaxModels = customerModel.getGasTaxList();

			if (oldGasTaxModels != null && !oldGasTaxModels.isEmpty())
			{
				modelService.removeAll(oldGasTaxModels);
			}

			final List<ImpuestoGasolina> gasolina = sdhConsultaContribuyenteBPResponse.getGasolina();

			if (gasolina != null && !gasolina.isEmpty())
			{

				final List<SDHGasTaxModel> newGasTaxModels = new ArrayList<SDHGasTaxModel>();

				for (final ImpuestoGasolina eachGasolinaTax : gasolina)
				{
					if (StringUtils.isBlank(eachGasolinaTax.getNumDoc()))
					{
						continue;
					}

					final SDHGasTaxModel eachGasolinaModel = new SDHGasTaxModel();
					eachGasolinaModel.setDocumentNumber(eachGasolinaTax.getNumDoc());
					eachGasolinaModel.setDocumentType(eachGasolinaTax.getTipoDoc());
					eachGasolinaModel.setObjectNumber(eachGasolinaTax.getNumObjeto());


					newGasTaxModels.add(eachGasolinaModel);

				}

				modelService.saveAll(newGasTaxModels);

				customerModel.setGasTaxList(newGasTaxModels);
			}
			else
			{
				customerModel.setGasTaxList(null);
			}


			//clean old rols
			final List<SDHRolModel> rols = customerModel.getRolList();

			if (rols != null && !rols.isEmpty())
			{
				modelService.removeAll(rols);
			}

			final List<NombreRolResponse> roles = sdhConsultaContribuyenteBPResponse.getRoles();

			if (roles != null && !roles.isEmpty())
			{
				final List<SDHRolModel> newRolesModel = new ArrayList<SDHRolModel>();

				for (final NombreRolResponse eachRolResponse : roles)
				{
					if (StringUtils.isBlank(eachRolResponse.getNombreRol()))
					{
						continue;
					}

					final SDHRolModel eachRolModel = new SDHRolModel();
					eachRolModel.setRol(eachRolResponse.getNombreRol());
					newRolesModel.add(eachRolModel);

				}

				modelService.saveAll(newRolesModel);

				customerModel.setRolList(newRolesModel);
			}
			else
			{
				customerModel.setRolList(null);
			}


			//clean old vehiculos taxes

			final List<SDHVehiculosTaxModel> oldVETaxModels = customerModel.getVehiculosTaxList();

			if (oldVETaxModels != null && !oldVETaxModels.isEmpty())
			{
				modelService.removeAll(oldVETaxModels);
			}

			final List<ImpuestoVehiculos> vehiculos = sdhConsultaContribuyenteBPResponse.getVehicular();

			if (vehiculos != null && !vehiculos.isEmpty())
			{

				final List<SDHVehiculosTaxModel> newVETaxModels = new ArrayList<SDHVehiculosTaxModel>();

				for (final ImpuestoVehiculos eachVETax : vehiculos)
				{
					if (StringUtils.isBlank(eachVETax.getPlaca()))
					{
						continue;
					}

					final SDHVehiculosTaxModel eachNewVETaxModel = new SDHVehiculosTaxModel();
					eachNewVETaxModel.setPlaca(eachVETax.getPlaca());
					eachNewVETaxModel.setMarca(eachVETax.getMarca());
					eachNewVETaxModel.setLinea(eachVETax.getLinea());
					eachNewVETaxModel.setModelo(eachVETax.getModelo());
					eachNewVETaxModel.setClase(eachVETax.getClase());
					eachNewVETaxModel.setCarroceria(eachVETax.getCarroceria());
					eachNewVETaxModel.setNumPuertas(eachVETax.getNumPuertas());
					eachNewVETaxModel.setBlindado(eachVETax.getBlindado());
					eachNewVETaxModel.setCilindraje(eachVETax.getCilindraje());
					eachNewVETaxModel.setNumObjeto(eachVETax.getNumObjeto());

					newVETaxModels.add(eachNewVETaxModel);

				}

				modelService.saveAll(newVETaxModels);

				customerModel.setVehiculosTaxList(newVETaxModels);
			}
			else
			{
				customerModel.setVehiculosTaxList(null);
			}



			//clean old predial taxes

			final List<SDHPredialTaxModel> oldPredialTaxModels = customerModel.getPredialTaxList();

			if (oldPredialTaxModels != null && !oldPredialTaxModels.isEmpty())
			{
				modelService.removeAll(oldPredialTaxModels);
			}

			final List<PredialResponse> predial = sdhConsultaContribuyenteBPResponse.getPredial();

			if (predial != null && !predial.isEmpty())
			{

				final List<SDHPredialTaxModel> newPredialTaxModels = new ArrayList<SDHPredialTaxModel>();

				for (final PredialResponse eachPredialTax : predial)
				{
					if (StringUtils.isBlank(eachPredialTax.getCHIP()) && StringUtils.isBlank(eachPredialTax.getMatrInmobiliaria()))
					{
						continue;
					}

					final SDHPredialTaxModel eachNewPredialTaxModel = new SDHPredialTaxModel();
					eachNewPredialTaxModel.setCHIP(eachPredialTax.getCHIP());
					eachNewPredialTaxModel.setMatrInmobiliaria(eachPredialTax.getMatrInmobiliaria());
					eachNewPredialTaxModel.setDireccionPredio(eachPredialTax.getDireccionPredio());
					eachNewPredialTaxModel.setContratoArrenda(eachPredialTax.getContratoArrenda());
					eachNewPredialTaxModel.setAnioGravable(eachPredialTax.getAnioGravable());
					eachNewPredialTaxModel.setNumObjeto(eachPredialTax.getNumObjeto());

					newPredialTaxModels.add(eachNewPredialTaxModel);

				}

				modelService.saveAll(newPredialTaxModels);

				customerModel.setPredialTaxList(newPredialTaxModels);
			}
			else
			{
				customerModel.setPredialTaxList(null);
			}



			//clean old urban delineations exterior taxes

			final List<SDHUrbanDelineationsTaxModel> oldUrbanDelineationsTaxModels = customerModel.getUrbanDelineationsTaxList();

			if (oldUrbanDelineationsTaxModels != null && !oldUrbanDelineationsTaxModels.isEmpty())
			{
				modelService.removeAll(oldUrbanDelineationsTaxModels);
			}

			final List<ImpuestoDelineacionUrbana> delineacionUrbana = sdhConsultaContribuyenteBPResponse.getDelineacion();

			if (delineacionUrbana != null && !delineacionUrbana.isEmpty())
			{

				final List<SDHUrbanDelineationsTaxModel> newUrbanDelineationsTaxModels = new ArrayList<SDHUrbanDelineationsTaxModel>();

				for (final ImpuestoDelineacionUrbana eachUrbanDelineationsTax : delineacionUrbana)
				{
					if (StringUtils.isBlank(eachUrbanDelineationsTax.getCdu()))
					{
						continue;
					}

					final SDHUrbanDelineationsTaxModel eachNewUrbanDelineationsTaxModel = new SDHUrbanDelineationsTaxModel();
					eachNewUrbanDelineationsTaxModel.setObjectNumber(eachUrbanDelineationsTax.getNumObjeto());
					eachNewUrbanDelineationsTaxModel.setCdu(eachUrbanDelineationsTax.getCdu());
					eachNewUrbanDelineationsTaxModel.setLicenConst(eachUrbanDelineationsTax.getLicenConst());
					eachNewUrbanDelineationsTaxModel.setExpDate(eachUrbanDelineationsTax.getFechaExp());

					newUrbanDelineationsTaxModels.add(eachNewUrbanDelineationsTaxModel);
				}

				modelService.saveAll(newUrbanDelineationsTaxModels);

				customerModel.setUrbanDelineationsTaxList(newUrbanDelineationsTaxModels);
			}
			else
			{
				customerModel.setUrbanDelineationsTaxList(null);
			}


			//clean old ICA exterior taxes


			final SDHICATaxModel oldIcaTaxModel = customerModel.getIcaTaxList();

			if (oldIcaTaxModel != null)
			{
				modelService.removeAll(oldIcaTaxModel);
			}

			final ImpuestoICA ica = sdhConsultaContribuyenteBPResponse.getIca();

			if (ica != null)
			{
				final SDHICATaxModel newIcaTaxModel = new SDHICATaxModel();

				if (!StringUtils.isBlank(ica.getNumObjeto()))
				{
					newIcaTaxModel.setObjectNumber(ica.getNumObjeto());
				}

				modelService.saveAll(newIcaTaxModel);

				customerModel.setIcaTaxList(newIcaTaxModel);

			}
			else
			{
				customerModel.setIcaTaxList(null);
			}


			// clean previous reteICA
			if (customerModel.getReteIcaTax() != null)
			{
				final SDHReteICATaxModel reteICAModel = customerModel.getReteIcaTax();
				modelService.remove(reteICAModel);
			}

			if (sdhConsultaContribuyenteBPResponse.getReteIca() != null)
			{
				final SDHReteICATaxModel newReteICAModel = new SDHReteICATaxModel();
				newReteICAModel.setObjectNumber(sdhConsultaContribuyenteBPResponse.getReteIca().getNumObjeto());
				newReteICAModel.setConsecutive(sdhConsultaContribuyenteBPResponse.getReteIca().getConsecutive());
				newReteICAModel.setNumID(sdhConsultaContribuyenteBPResponse.getReteIca().getNumID());


				modelService.save(newReteICAModel);

				customerModel.setReteIcaTax(newReteICAModel);

			}
			else
			{
				customerModel.setReteIcaTax(null);
			}



			modelService.save(customerModel);

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP: " + e.getMessage());
		}

		return customerModel;
	}


	public CustomerModel updateMiRitInfo_simplificado(final CustomerModel customerModel, String indicador)
	{
		final String numBP = customerModel.getNumBP();
		String indicadorBasica = "01";
		String indicadorRolesYAgentes = "02";

		final ConsultaContribBPRequest consultaContribBPRequest = new ConsultaContribBPRequest();
		consultaContribBPRequest.setNumBP(numBP);
		consultaContribBPRequest.setIndicador(indicador);

		final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = sdhConsultaContribuyenteBPService
				.consultaContribuyenteBP_simplificado(consultaContribBPRequest);

		if (indicador != null && indicador.contains(indicadorBasica))
		{
		grabarInfoContrib(customerModel, sdhConsultaContribuyenteBPResponse);
		grabarImpuestos(customerModel, sdhConsultaContribuyenteBPResponse);
		}
		if (indicador != null && indicador.contains(indicadorRolesYAgentes))
		{
			grabarRoles(customerModel, sdhConsultaContribuyenteBPResponse);
			grabarAgentes(customerModel, sdhConsultaContribuyenteBPResponse);
		}

		modelService.save(customerModel);


		//			response = response.replace("\"infoContrib\":[", "\"infoContrib\": ");
		//			response = response.replace("}],\"roles\":[", "},\"roles\":[");

		return customerModel;
	}


	public CustomerModel updateImpuestoVehicular_simplificado(final CustomerModel customerModel, List<ImpuestoVehiculos> vehiculos)
	{

		final List<SDHVehiculosTaxModel> oldVETaxModels = customerModel.getVehiculosTaxList();

		if (oldVETaxModels != null && !oldVETaxModels.isEmpty())
		{
			modelService.removeAll(oldVETaxModels);
		}

		List<SDHVehiculosTaxModel> newVETaxModels = null;
		if (vehiculos != null && !vehiculos.isEmpty())
		{
			newVETaxModels = new ArrayList<SDHVehiculosTaxModel>();
			for (final ImpuestoVehiculos eachVETax : vehiculos)
			{
				if (StringUtils.isBlank(eachVETax.getPlaca()))
				{
					continue;
				}
				final SDHVehiculosTaxModel eachNewVETaxModel = new SDHVehiculosTaxModel();
				eachNewVETaxModel.setPlaca(eachVETax.getPlaca());
				eachNewVETaxModel.setMarca(eachVETax.getMarca());
				eachNewVETaxModel.setLinea(eachVETax.getLinea());
				eachNewVETaxModel.setModelo(eachVETax.getModelo());
				eachNewVETaxModel.setClase(eachVETax.getClase());
				eachNewVETaxModel.setCarroceria(eachVETax.getCarroceria());
				eachNewVETaxModel.setNumPuertas(eachVETax.getNumPuertas());
				eachNewVETaxModel.setBlindado(eachVETax.getBlindado());
				eachNewVETaxModel.setCilindraje(eachVETax.getCilindraje());
				eachNewVETaxModel.setNumObjeto(eachVETax.getNumObjeto());

				newVETaxModels.add(eachNewVETaxModel);

			}
			modelService.saveAll(newVETaxModels);
		}
		customerModel.setVehiculosTaxList(newVETaxModels);
		modelService.save(customerModel);


		return customerModel;
	}



	/**
	 * @param customerModel
	 * @param sdhConsultaContribuyenteBPResponse
	 */
	private void grabarImpuestos(final CustomerModel customerModel,
			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		//establecer informacion correspondiente a impuestos:
		final List<SDHContribTaxModel> oldContribTaxModels = customerModel.getContribTaxList();

		if (oldContribTaxModels != null && !oldContribTaxModels.isEmpty())
		{
			modelService.removeAll(oldContribTaxModels);
		}

		final List<ImpuestosResponse> impuestosContrib = sdhConsultaContribuyenteBPResponse.getImpuestos();
		if (impuestosContrib != null && !impuestosContrib.isEmpty())
		{

			final List<SDHContribTaxModel> newContribTaxModels = new ArrayList<SDHContribTaxModel>();

			for (final ImpuestosResponse eachImpuestosContrib : impuestosContrib)
			{
				if (StringUtils.isBlank(eachImpuestosContrib.getClaseObjeto()))
				{
					continue;
				}

				final SDHContribTaxModel eachNewContribTaxModel = new SDHContribTaxModel();
				eachNewContribTaxModel.setClaseObjeto(eachImpuestosContrib.getClaseObjeto());
				eachNewContribTaxModel.setCantObjetos(eachImpuestosContrib.getCantObjetos());
				//					eachNewContribTaxModel.setLinea(eachContribTax.getDescripcion());

				newContribTaxModels.add(eachNewContribTaxModel);

			}

			modelService.saveAll(newContribTaxModels);

			customerModel.setContribTaxList(newContribTaxModels);
		}
		else
		{
			customerModel.setContribTaxList(null);
		}

	}


	/**
	 * @param customerModel
	 * @param sdhConsultaContribuyenteBPResponse
	 */
	private void grabarRoles(final CustomerModel customerModel, final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		//clean old rols
		final List<SDHRolModel> rols = customerModel.getRolList();

		if (rols != null && !rols.isEmpty())
		{
			modelService.removeAll(rols);
		}

		final List<NombreRolResponse> roles = sdhConsultaContribuyenteBPResponse.getRoles();

		if (roles != null && !roles.isEmpty())
		{
			final List<SDHRolModel> newRolesModel = new ArrayList<SDHRolModel>();

			for (final NombreRolResponse eachRolResponse : roles)
			{
				if (StringUtils.isBlank(eachRolResponse.getNombreRol()))
				{
					continue;
				}

				final SDHRolModel eachRolModel = new SDHRolModel();
				eachRolModel.setRol(eachRolResponse.getNombreRol());
				newRolesModel.add(eachRolModel);

			}

			modelService.saveAll(newRolesModel);

			customerModel.setRolList(newRolesModel);
		}
		else
		{
			customerModel.setRolList(null);
		}

	}


	/**
	 * @param customerModel
	 * @param sdhConsultaContribuyenteBPResponse
	 */
	private void grabarAgentes(final CustomerModel customerModel,
			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		//clean old agents
		final List<SDHAgentModel> oldAgentModels = customerModel.getAgentList();

		if (oldAgentModels != null && !oldAgentModels.isEmpty())
		{
			modelService.removeAll(oldAgentModels);
		}

		final List<ContribAgente> agents = sdhConsultaContribuyenteBPResponse.getAgentes();

		if (agents != null && !agents.isEmpty())
		{

			final List<SDHAgentModel> newAgentModels = new ArrayList<SDHAgentModel>();

			for (final ContribAgente eachAgentResponse : agents)
			{
				if (StringUtils.isBlank(eachAgentResponse.getNumDoc()))
				{
					continue;
				}

				final SDHAgentModel eachNewAgentModel = new SDHAgentModel();

				eachNewAgentModel.setAgent(eachAgentResponse.getAgente());
				eachNewAgentModel.setDocumentNumber(eachAgentResponse.getNumDoc());
				eachNewAgentModel.setDocumentType(eachAgentResponse.getTipoDoc());
				eachNewAgentModel.setCompleteName(eachAgentResponse.getNomCompleto());
				eachNewAgentModel.setInternalFunction(eachAgentResponse.getFuncionInterl());
				eachNewAgentModel.setBp(eachAgentResponse.getBp());
				eachNewAgentModel.setMenu(eachAgentResponse.getMenu());

				newAgentModels.add(eachNewAgentModel);

			}

			modelService.saveAll(newAgentModels);

			customerModel.setAgentList(newAgentModels);
		}
		else
		{
			customerModel.setAgentList(null);
		}

	}


	/**
	 * @param customerModel
	 * @param sdhConsultaContribuyenteBPResponse
	 */
	private void grabarInfoContrib(final CustomerModel customerModel,
			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{

		final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();
		if (null != infoContribuyente)
		{
			customerModel.setFirstName(infoContribuyente.getPrimNom());
			customerModel.setMiddleName(infoContribuyente.getSegNom());
			customerModel.setLastName(infoContribuyente.getPrimApe());
			customerModel.setSecondLastName(infoContribuyente.getSegApe());

			customerModel.setDocumentNumber(infoContribuyente.getNumDoc());
			customerModel.setDocumentType(infoContribuyente.getTipoDoc());
			//TODO: save document expedition date

			customerModel.setDocumentNumber(infoContribuyente.getNumDoc());


			final ContribAdicionales adicionales = infoContribuyente.getAdicionales();
			if (null != adicionales)
			{
				customerModel.setSdhType(adicionales.getTYPE());
				customerModel.setSdhTitle(adicionales.getTITLE());
				customerModel.setNameOrg1(adicionales.getNAME_ORG1());
				customerModel.setNameOrg2(adicionales.getNAME_ORG2());
				customerModel.setNameOrg3(adicionales.getNAME_ORG3());
				customerModel.setNameOrg4(adicionales.getNAME_ORG4());


				customerModel.setDigVer(adicionales.getDIGVERIF());
				customerModel.setLegalEntity(adicionales.getLEGAL_ENTY());
				customerModel.setLegalOrg(adicionales.getLEGALORG());
				customerModel.setUseEmailForNotifications((1 == adicionales.getZZAUTOBUZONE()) ? Boolean.TRUE : Boolean.FALSE);
				customerModel
						.setUseInformationForInstitutionalPurposes((1 == adicionales.getZZAUTOUSOINF()) ? Boolean.TRUE : Boolean.FALSE);
				//TODO: fecha de autorizacion de uso de buzon

			}

			//clean old addresses
			final List<SDHAddressModel> currentAddresses = customerModel.getAddressList();

			if (currentAddresses != null && !currentAddresses.isEmpty())
			{
				modelService.removeAll(currentAddresses);
			}

			final List<ContribDireccion> direcciones = infoContribuyente.getDireccion();

			if (direcciones != null && !direcciones.isEmpty())
			{

				final List<SDHAddressModel> newAddresses = new ArrayList<SDHAddressModel>();

				for (final ContribDireccion eachAddress : direcciones)
				{

					if (StringUtils.isBlank(eachAddress.getADR_KIND()))
					{
						continue;
					}

					final SDHAddressModel eachAddressModel = new SDHAddressModel();
					eachAddressModel.setAddKind(eachAddress.getADR_KIND());
					eachAddressModel.setStreet(eachAddress.getSTREET());
					eachAddressModel.setPostalCode(eachAddress.getPOST_CODE());
					eachAddressModel.setCity(eachAddress.getCITY1());
					eachAddressModel.setCountry(eachAddress.getCOUNTRY());
					eachAddressModel.setRegion(eachAddress.getREGION());

					newAddresses.add(eachAddressModel);

				}

				modelService.saveAll(newAddresses);

				customerModel.setAddressList(newAddresses);

			}
			else
			{
				customerModel.setAddressList(null);
			}


			//clean old social networks
			final List<SDHSocialNetworkModel> socialNetworks = customerModel.getNetworkList();

			if (socialNetworks != null && !socialNetworks.isEmpty())
			{
				modelService.removeAll(socialNetworks);
			}

			final List<ContribRedSocial> redsocial = infoContribuyente.getRedsocial();

			if (redsocial != null && !redsocial.isEmpty())
			{

				final List<SDHSocialNetworkModel> newSocialNetwork = new ArrayList<SDHSocialNetworkModel>();

				for (final ContribRedSocial eachSocialNetwork : redsocial)
				{
					if (StringUtils.isBlank(eachSocialNetwork.getRED_SOCIAL()))
					{
						continue;
					}

					final SDHSocialNetworkModel eachSocialNetworkModel = new SDHSocialNetworkModel();
					eachSocialNetworkModel.setSocialNetwork(eachSocialNetwork.getRED_SOCIAL());
					eachSocialNetworkModel.setUsername(eachSocialNetwork.getUSUARIORED());
					newSocialNetwork.add(eachSocialNetworkModel);

				}

				modelService.saveAll(newSocialNetwork);

				customerModel.setNetworkList(newSocialNetwork);
			}
			else
			{
				customerModel.setNetworkList(null);
			}

		}

	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#updateEmailRit(de.hybris.sdh.core.pojos.requests.
	 * UpdateEmailRitRequest)
	 */
	@Override
	public String updateEmailRit(final UpdateEmailRitRequest request)
	{

		return null;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.services.SDHCustomerAccountService#updateAutorizacionesRit(de.hybris.sdh.core.pojos.responses.
	 * SDHValidaMailRolResponse)
	 */
	@Override
	public String updateAutorizacionesRit(final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();

		if (null != infoContribuyente && null != infoContribuyente.getAdicionales())
		{
			final ContribAdicionales adicionales = infoContribuyente.getAdicionales();
				customerModel
					.setUseEmailForNotifications((1 == adicionales.getZZAUTOBUZONE()) ? Boolean.TRUE : Boolean.FALSE);
				customerModel.setUseInformationForInstitutionalPurposes(
					(1 == adicionales.getZZAUTOUSOINF()) ? Boolean.TRUE : Boolean.FALSE);
				//TODO: fecha de autorizacion de uso de buzon

		}
		else
		{
			customerModel.setUseEmailForNotifications(Boolean.FALSE);
			customerModel.setUseInformationForInstitutionalPurposes(Boolean.FALSE);

		}


		modelService.save(customerModel);

		return null;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.services.SDHCustomerAccountService#updateRedesSocialesRit(de.hybris.sdh.core.pojos.responses.
	 * SDHValidaMailRolResponse)
	 */
	@Override
	public String updateRedesSocialesRit(final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		//clean old social networks
		final List<SDHSocialNetworkModel> socialNetworks = customerModel.getNetworkList();

		if (socialNetworks != null && !socialNetworks.isEmpty())
		{
			modelService.removeAll(socialNetworks);
		}
		final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();


		if (infoContribuyente != null && infoContribuyente.getRedsocial() != null && !infoContribuyente.getRedsocial().isEmpty())
		{
			final List<ContribRedSocial> redsocial = infoContribuyente.getRedsocial();

			final List<SDHSocialNetworkModel> newSocialNetwork = new ArrayList<SDHSocialNetworkModel>();

			for (final ContribRedSocial eachSocialNetwork : redsocial)
			{
				if (StringUtils.isBlank(eachSocialNetwork.getRED_SOCIAL()))
				{
					continue;
				}

				final SDHSocialNetworkModel eachSocialNetworkModel = new SDHSocialNetworkModel();
				eachSocialNetworkModel.setSocialNetwork(eachSocialNetwork.getRED_SOCIAL());
				eachSocialNetworkModel.setUsername(eachSocialNetwork.getUSUARIORED());
				newSocialNetwork.add(eachSocialNetworkModel);

			}

			modelService.saveAll(newSocialNetwork);

			customerModel.setNetworkList(newSocialNetwork);
		}
		else
		{
			customerModel.setNetworkList(null);
		}

		modelService.save(customerModel);

		return null;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#updateTelefonoRit(de.hybris.sdh.core.pojos.responses.
	 * SDHValidaMailRolResponse)
	 */
	@Override
	public String updateTelefonoRit(final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		//clean old phone numbers
		final List<SDHPhoneModel> phoneNumbers = customerModel.getPhoneList();

		if (phoneNumbers != null && !phoneNumbers.isEmpty())
		{
			modelService.removeAll(phoneNumbers);
		}

		final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();

		if (null != infoContribuyente && infoContribuyente.getTelefono() != null && !infoContribuyente.getTelefono().isEmpty())
		{
			final List<ContribTelefono> phones = infoContribuyente.getTelefono();

			final List<SDHPhoneModel> newPhones = new ArrayList<SDHPhoneModel>();

			for (final ContribTelefono eachPhone : phones)
			{
				if (StringUtils.isBlank(eachPhone.getTEL_TIPO()))
				{
					continue;
				}

				final SDHPhoneModel eachPhoneModel = new SDHPhoneModel();
				eachPhoneModel.setPhoneKind(eachPhone.getTEL_TIPO());
				eachPhoneModel.setPhoneNumber(eachPhone.getTEL_NUMBER());
				eachPhoneModel.setExtension(eachPhone.getTEL_EXTENS());

				newPhones.add(eachPhoneModel);

			}

			modelService.saveAll(newPhones);

			customerModel.setPhoneList(newPhones);

		}
		else
		{
			customerModel.setPhoneList(null);
		}

		modelService.save(customerModel);

		return null;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#updateAddressRit(de.hybris.sdh.core.pojos.responses.
	 * SDHValidaMailRolResponse)
	 */
	@Override
	public String updateAddressRit(final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();

		//clean old addresses
		final List<SDHAddressModel> currentAddresses = customerModel.getAddressList();

		if (currentAddresses != null && !currentAddresses.isEmpty())
		{
			modelService.removeAll(currentAddresses);
		}



		if (null != infoContribuyente && infoContribuyente.getDireccion() != null && !infoContribuyente.getDireccion().isEmpty())
		{
			final List<ContribDireccion> direcciones = infoContribuyente.getDireccion();

			final List<SDHAddressModel> newAddresses = new ArrayList<SDHAddressModel>();

			for (final ContribDireccion eachAddress : direcciones)
			{

				if (StringUtils.isBlank(eachAddress.getADR_KIND()))
				{
					continue;
				}

				final SDHAddressModel eachAddressModel = new SDHAddressModel();
				eachAddressModel.setAddKind(eachAddress.getADR_KIND());
				eachAddressModel.setStreet(eachAddress.getSTREET());
				eachAddressModel.setPostalCode(eachAddress.getPOST_CODE());
				eachAddressModel.setCity(eachAddress.getCITY1());
				eachAddressModel.setCountry(eachAddress.getCOUNTRY());
				eachAddressModel.setRegion(eachAddress.getREGION());

				newAddresses.add(eachAddressModel);

			}

			modelService.saveAll(newAddresses);

			customerModel.setAddressList(newAddresses);

		}
		else
		{
			customerModel.setAddressList(null);
		}
		modelService.save(customerModel);

		return null;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#updateNameRit(de.hybris.sdh.core.pojos.responses.
	 * SDHValidaMailRolResponse)
	 */
	@Override
	public String updateNameRit(final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();

		if (null != infoContribuyente)
		{
			customerModel.setFirstName(infoContribuyente.getPrimNom());
			customerModel.setMiddleName(infoContribuyente.getSegNom());
			customerModel.setLastName(infoContribuyente.getPrimApe());
			customerModel.setSecondLastName(infoContribuyente.getSegApe());

		}
		modelService.save(customerModel);

		return null;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#updateRols(de.hybris.sdh.core.pojos.responses.
	 * SDHValidaMailRolResponse)
	 */
	@Override
	public String updateRols(final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final String numBP = customerModel.getNumBP();

		//clean old rols
		final List<SDHRolModel> rols = customerModel.getRolList();

		if (rols != null && !rols.isEmpty())
		{
			modelService.removeAll(rols);
		}

		final List<NombreRolResponse> roles = sdhConsultaContribuyenteBPResponse.getRoles();

		if (roles != null && !roles.isEmpty())
		{
			final List<SDHRolModel> newRolesModel = new ArrayList<SDHRolModel>();

			for (final NombreRolResponse eachRolResponse : roles)
			{
				if (StringUtils.isBlank(eachRolResponse.getNombreRol()))
				{
					continue;
				}

				final SDHRolModel eachRolModel = new SDHRolModel();
				eachRolModel.setRol(eachRolResponse.getNombreRol());
				newRolesModel.add(eachRolModel);

			}

			modelService.saveAll(newRolesModel);

			customerModel.setRolList(newRolesModel);
		}
		else
		{
			customerModel.setRolList(null);
		}

		modelService.save(customerModel);

		return null;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#updateBasicData(de.hybris.sdh.core.pojos.responses.
	 * SDHValidaMailRolResponse)
	 */
	@Override
	public String updateBasicData(final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final String numBP = customerModel.getNumBP();

		final InfoContribResponse infoContribuyente = sdhConsultaContribuyenteBPResponse.getInfoContrib();

		if (null != infoContribuyente)
		{
			customerModel.setFirstName(infoContribuyente.getPrimNom());
			customerModel.setMiddleName(infoContribuyente.getSegNom());
			customerModel.setLastName(infoContribuyente.getPrimApe());
			customerModel.setSecondLastName(infoContribuyente.getSegApe());

			customerModel.setDocumentNumber(infoContribuyente.getNumDoc());
			customerModel.setDocumentType(infoContribuyente.getTipoDoc());
			//TODO: save document expedition date

			customerModel.setDocumentNumber(infoContribuyente.getNumDoc());


			final ContribAdicionales adicionales = infoContribuyente.getAdicionales();
			if (null != adicionales)
			{
				customerModel.setSdhType(adicionales.getTYPE());
				customerModel.setSdhTitle(adicionales.getTITLE());
				customerModel.setNameOrg1(adicionales.getNAME_ORG1());
				customerModel.setNameOrg2(adicionales.getNAME_ORG2());
				customerModel.setNameOrg3(adicionales.getNAME_ORG3());
				customerModel.setNameOrg4(adicionales.getNAME_ORG4());


				customerModel.setDigVer(adicionales.getDIGVERIF());
				customerModel.setLegalEntity(adicionales.getLEGAL_ENTY());
				customerModel.setLegalOrg(adicionales.getLEGALORG());
				customerModel
						.setUseEmailForNotifications((1 == adicionales.getZZAUTOBUZONE()) ? Boolean.TRUE : Boolean.FALSE);
				customerModel.setUseInformationForInstitutionalPurposes(
						(1 == adicionales.getZZAUTOUSOINF()) ? Boolean.TRUE : Boolean.FALSE);
				//TODO: fecha de autorizacion de uso de buzon

			}
		}

		modelService.save(customerModel);

		return null;
	}


	@Override
	public void setAutorityOnSession(final String role)
	{

		final UserModel userModel = userService.getCurrentUser();
		final Set<PrincipalGroupModel> currentPricipals = userModel.getGroups();
		final Set<PrincipalGroupModel> newPricipals = new HashSet<PrincipalGroupModel>();


		for (final PrincipalGroupModel eachPrincipal : currentPricipals)
		{
			newPricipals.add(eachPrincipal);
		}

		newPricipals.add(userService.getUserGroupForUID(role));
		userModel.setGroups(newPricipals);

		modelService.save(userModel);



	}


	@Override
	public void cleanSessionAutorities()
	{
		final UserModel userModel = userService.getCurrentUser();
		final Set<PrincipalGroupModel> currentPricipals = userModel.getGroups();
		final Set<PrincipalGroupModel> newPricipals = new HashSet<PrincipalGroupModel>();

		for (final PrincipalGroupModel eachPrincipal : currentPricipals)
		{
			if (!eachPrincipal.getUid().contains("sdh"))
			{
				newPricipals.add(eachPrincipal);
			}
		}

		userModel.setGroups(newPricipals);

		modelService.save(userModel);

	}

	@Override
	public void updateCustomerTaxRestrictions() {
		LOG.info("Updating SDH Customer Tax Menu Restrictions");
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPRespons = null;
		final String response = null;

		//		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		//		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());
		//		final ObjectMapper mapper = new ObjectMapper();
		//		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//		response = sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest);
		//		try {
		//			if(Objects.nonNull(response)){
		//				sdhConsultaContribuyenteBPRespons = mapper.readValue(response, SDHValidaMailRolResponse.class);
		//			}
		//		} catch (final IOException e) {
		//			e.printStackTrace();
		//		}
		sdhConsultaContribuyenteBPRespons = sdhConsultaContribuyenteBPService.mapearInfo(customerModel);

		final Set<PrincipalGroupModel> groupList = customerModel.getGroups();
		final Set<PrincipalGroupModel> newGroupList = new HashSet<>();
		for(final PrincipalGroupModel group : groupList){
			final String groupUid = group.getUid();
			if(!groupUid.contains("UsrTaxGrp")){
				newGroupList.add(group);
			}
		}

		if(Objects.nonNull(sdhConsultaContribuyenteBPRespons)){
			for (final ImpuestosResponse elementoImpuestosResponse : sdhConsultaContribuyenteBPRespons.getImpuestos())
			{
				if (elementoImpuestosResponse != null)
				{
					switch (elementoImpuestosResponse.getClaseObjeto())
					{
						case "01":
							addUsrGrpModelToList("predialUsrTaxGrp", newGroupList);
							break;
						case "02":
							addUsrGrpModelToList("vehicularUsrTaxGrp", newGroupList);
							break;
						case "03":
							addUsrGrpModelToList("ICAUsrTaxGrp", newGroupList);
							break;
						case "04":
							addUsrGrpModelToList("reteICAUsrTaxGrp", newGroupList);
							break;
						case "05":
							addUsrGrpModelToList("gasolinaUsrTaxGrp", newGroupList);
							break;
						case "06":
							addUsrGrpModelToList("delineacionUsrTaxGrp", newGroupList);
							break;
						case "07":
							addUsrGrpModelToList("publicidadExtUsrTaxGrp", newGroupList);
							break;

						default:
							break;
					}
				}
			}

			//			if(Objects.nonNull(sdhConsultaContribuyenteBPRespons.getGasolina())){
			//				addUsrGrpModelToList("gasolinaUsrTaxGrp" , newGroupList);
			//            }
			//            if(Objects.nonNull(sdhConsultaContribuyenteBPRespons.getPublicidadExt())){
			//				addUsrGrpModelToList("publicidadExtUsrTaxGrp" , newGroupList);
			//            }
			//            if(Objects.nonNull(sdhConsultaContribuyenteBPRespons.getDelineacion())){
			//				addUsrGrpModelToList("delineacionUsrTaxGrp" , newGroupList);
			//            }
			//            if(Objects.nonNull(sdhConsultaContribuyenteBPRespons.getIca())){
			//				addUsrGrpModelToList("ICAUsrTaxGrp" , newGroupList);
			//            }
			//            if(Objects.nonNull(sdhConsultaContribuyenteBPRespons.getReteIca())){
			//				addUsrGrpModelToList("reteICAUsrTaxGrp" , newGroupList);
			//            }
			//            if(Objects.nonNull(sdhConsultaContribuyenteBPRespons.getVehicular())){
			//				addUsrGrpModelToList("vehicularUsrTaxGrp" , newGroupList);
			//            }
			//			if(Objects.nonNull(sdhConsultaContribuyenteBPRespons.getPredial())){
			//				addUsrGrpModelToList("predialUsrTaxGrp" , newGroupList);
			//			}
		}

		customerModel.setGroups(newGroupList);
		modelService.saveAll(customerModel);
	}




	private void addUsrGrpModelToList(final String UserGroupUid, final Set<PrincipalGroupModel> newGroupList){
		UserGroupModel usrGrpModel = null;
		usrGrpModel = userGroupDao.findUserGroupByUid(UserGroupUid);
		if(Objects.nonNull(usrGrpModel)){
			LOG.info("Added user tax group restriction: " + usrGrpModel.getUid());
			newGroupList.add(usrGrpModel);
		}
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCustomerAccountService#isUserRegisteredByNumBP(java.lang.String)
	 */
	@Override
	public boolean isUserRegisteredByNumBP(final String numBP)
	{
		boolean resultValidation = false;
		final String query = "SELECT {pk} FROM {Customer AS C } WHERE {numBP} = ?numBP";

		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("numBP", numBP);

		final SearchResult<CustomerModel> usersResults;

		usersResults = flexibleSearchService.search(query, queryParams);

		if (usersResults.getTotalCount() > 0)
		{
			resultValidation = true;
		}

		return resultValidation;
	}


}


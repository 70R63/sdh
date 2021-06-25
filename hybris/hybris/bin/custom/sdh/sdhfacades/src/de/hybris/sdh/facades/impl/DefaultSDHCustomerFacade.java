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
package de.hybris.sdh.facades.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.ImpPredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHImpPredialService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.questions.data.SDHAgentData;
import de.hybris.sdh.facades.questions.data.SDHRolData;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


/**
 * Default implementation for the {@link CustomerFacade}.
 */
public class DefaultSDHCustomerFacade extends DefaultCustomerFacade implements SDHCustomerFacade
{
	private static final Logger LOG = Logger.getLogger(DefaultSDHCustomerFacade.class);

	@Resource(name = "sdhCustomerAccountService")
	private SDHCustomerAccountService sdhCustomerAccountService;

	@Resource(name="flexibleSearchService")
	private FlexibleSearchService flexibleSearchService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhImpPredialServiceImpl")
	SDHImpPredialService sdhImpPredialServiceImpl;

	@Override
	public void register(final RegisterData registerData) throws DuplicateUidException
	{
		validateParameterNotNullStandardMessage("registerData", registerData);
		//		Assert.hasText(registerData.getFirstName(), "The field [FirstName] cannot be empty");
		//		Assert.hasText(registerData.getLastName(), "The field [LastName] cannot be empty");
		Assert.hasText(registerData.getLogin(), "The field [Login] cannot be empty");

		final CustomerModel newCustomer = getModelService().create(CustomerModel.class);
		newCustomer.setName(registerData.getLogin());

		//		if (StringUtils.isNotBlank(registerData.getFirstName()) && StringUtils.isNotBlank(registerData.getLastName()))
		//		{
		//			newCustomer.setName(getCustomerNameStrategy().getName(registerData.getFirstName(), registerData.getLastName()));
		//		}
		final TitleModel title = getUserService().getTitleForCode(registerData.getTitleCode());
		newCustomer.setTitle(title);
		setUidForRegister(registerData, newCustomer);
		newCustomer.setLoginDisabled(true);
		newCustomer.setUseEmailForNotifications(registerData.getUseEmailForNotifications());
		newCustomer.setNumBP(registerData.getNumBP());
		newCustomer.setUseInformationForInstitutionalPurposes(registerData.getUseInformationForInstitutionalPurposes());
		newCustomer.setSessionLanguage(getCommonI18NService().getCurrentLanguage());
		newCustomer.setSessionCurrency(getCommonI18NService().getCurrentCurrency());
		newCustomer.setDocumentNumber(registerData.getDocumentNumber());
		newCustomer.setDocumentType(registerData.getDocumentType());
		getCustomerAccountService().register(newCustomer, registerData.getPassword());
	}





	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.facades.SDHCustomerFacade#activateAccount(java.lang.String)
	 */
	@Override
	public void activateAccount(final String token) throws TokenInvalidatedException
	{
		sdhCustomerAccountService.activateAccount(token);

	}





	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.facades.SDHCustomerFacade#isUserRegistered(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isUserRegistered(final String documentNumber, final String documentType)
	{
		return sdhCustomerAccountService.isUserRegistered(documentNumber, documentType);
	}





	@Override
	public void updateMiRitInfo()
	{
		sdhCustomerAccountService.updateMiRitInfo();
	}


	@Override
	public boolean isValidRoleForCurrentCustomer(final String role)
	{
		if (StringUtils.isBlank(role))
		{
			return false;
		}

		final CustomerData customerData = getCurrentCustomer();

		if (customerData.getRolList() == null || customerData.getRolList().isEmpty())
		{
			return false;
		}

		for (final SDHRolData eachRole : customerData.getRolList())
		{
			if (eachRole.getRol() != null && role != null && role.length() >= 4
					&& eachRole.getRol().startsWith(role.trim().substring(4)))
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public CustomerData getRepresentado(String numBP) {

		CustomerModel representadoModel = this.getCustomerFor(numBP);

		if(representadoModel == null)
			return null;

		return getCustomerConverter().convert(sdhCustomerAccountService.updateMiRitInfo(representadoModel));
	}

	protected CustomerModel getCustomerFor (String numBP)
	{
		try {
			String query = "SELECT {pk} FROM {Customer} Where {numBP}='" + numBP + "'";

			CustomerModel customerModel = flexibleSearchService.searchUnique(new FlexibleSearchQuery(query));

			return customerModel;
		}catch (Exception ex)
		{
			LOG.error("Customer not found for: "+numBP);
			return null;
		}
	}

	@Override
	public SDHValidaMailRolResponse getRepresentadoFromSAP(String numBP) {
		ImpPredialResponse impPredialResponse = null;

		try
		{

			final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			consultaContribuyenteBPRequest.setNumBP(numBP);

			SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = new SDHValidaMailRolResponse();
			impPredialResponse = mapper.readValue(sdhImpPredialServiceImpl.getImpuesto(numBP), ImpPredialResponse.class);
			sdhConsultaContribuyenteBPResponse.setPredial(impPredialResponse.getPredial());

			return sdhConsultaContribuyenteBPResponse;
		}
		catch (final Exception e)
		{
			LOG.error("there was an error while parsing update rit reponse: " + e.getMessage());
		}
		return null;

	}

	@Override
	public CustomerData getRepresentadoDataFromSAP(String numBP) {
		try
		{

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = this.getRepresentadoFromSAP(numBP);

			CustomerData customerData = new CustomerData();

			customerData.setNumBP(sdhConsultaContribuyenteBPResponse.getInfoContrib().getNumBP());
			customerData.setDocumentNumber(sdhConsultaContribuyenteBPResponse.getInfoContrib().getNumDoc());
			customerData.setDocumentType(sdhConsultaContribuyenteBPResponse.getInfoContrib().getTipoDoc());


			if (sdhConsultaContribuyenteBPResponse.getAgentes() != null)
			{
				List<SDHAgentData> list = new ArrayList<SDHAgentData>();

				for(ContribAgente eachAgent : sdhConsultaContribuyenteBPResponse.getAgentes())
				{
					SDHAgentData eachAgentData = new SDHAgentData();

					eachAgentData.setBp(eachAgent.getBp());
					eachAgentData.setInternalFunction(eachAgent.getFuncionInterl());
					eachAgentData.setDocumentType(eachAgent.getTipoDoc());
					eachAgentData.setDocumentNumber(eachAgent.getNumDoc());
					eachAgentData.setCompleteName(eachAgent.getNomCompleto());
					eachAgentData.setAgent(eachAgent.getAgente());

					list.add(eachAgentData);

				}

				customerData.setAgentList(list);
			}

			final StringBuilder nameBuilder = new StringBuilder();

			customerData.setCompleteName(sdhConsultaContribuyenteBPResponse.getCompleteName());

			return customerData;
		}
		catch (final Exception e)
		{
			LOG.error("there was an error while parsing update rit reponse: " + e.getMessage());
		}
		return null;
	}

	@Override
	public void updateCustomerTaxRestrictions() {
		sdhCustomerAccountService.updateCustomerTaxRestrictions();
	}
}

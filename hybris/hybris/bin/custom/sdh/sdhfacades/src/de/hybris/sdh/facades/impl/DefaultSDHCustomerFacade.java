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
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.questions.data.SDHRolData;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;


/**
 * Default implementation for the {@link CustomerFacade}.
 */
public class DefaultSDHCustomerFacade extends DefaultCustomerFacade implements SDHCustomerFacade
{
	private static final Logger LOG = Logger.getLogger(DefaultSDHCustomerFacade.class);

	@Resource(name = "sdhCustomerAccountService")
	private SDHCustomerAccountService sdhCustomerAccountService;


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
			if (role.contains(eachRole.getRol()))
			{
				return true;
			}
		}

		return false;
	}


}

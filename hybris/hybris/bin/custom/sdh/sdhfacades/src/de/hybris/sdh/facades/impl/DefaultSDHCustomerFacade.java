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
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribBPRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ContribAdicionales;
import de.hybris.sdh.core.pojos.responses.ImpPredialResponse;
import de.hybris.sdh.core.pojos.responses.InfoContribResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHImpPredialService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.questions.data.SDHRolData;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


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

	@Resource(name = "sessionService")
	SessionService sessionService;

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
	public CustomerData getRepresentado(final String numBP) {

		final CustomerModel representadoModel = this.getCustomerFor(numBP);

		if(representadoModel == null)
		{
			return null;
		}

		return getCustomerConverter().convert(sdhCustomerAccountService.updateMiRitInfo(representadoModel));
	}

	public CustomerModel getCustomerFor(final String numBP)
	{
		try {
			final String query = "SELECT {pk} FROM {Customer} Where {numBP}='" + numBP + "'";

			final CustomerModel customerModel = flexibleSearchService.searchUnique(new FlexibleSearchQuery(query));

			return customerModel;
		}catch (final Exception ex)
		{
			LOG.error("Customer not found for: "+numBP);
			return null;
		}
	}


	@Override
	public SDHValidaMailRolResponse getRepresentadoFromSAP(final String numBP) {
		final String indicadorDefault = "01";
		return getRepresentadoFromSAP(numBP, indicadorDefault);

	}


	public SDHValidaMailRolResponse getRepresentadoFromSAP(final String numBP, final String indicador)
	{
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;

		try
		{

			final ConsultaContribBPRequest consultaContribBPRequest = new ConsultaContribBPRequest();

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			consultaContribBPRequest.setNumBP(numBP);
			consultaContribBPRequest.setIndicador(indicador);

			sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP_simplificado_string(consultaContribBPRequest),
					SDHValidaMailRolResponse.class);
		}
		catch (final Exception e)
		{
			LOG.error("there was an error while parsing validaContrib reponse: " + e.getMessage());
		}
		return sdhConsultaContribuyenteBPResponse;

	}


	@Override
	public SDHValidaMailRolResponse getRepresentadoFromSAP_impuestos(final String numBP, final List<String> impuestos)
	{
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;

		if (impuestos != null && !impuestos.isEmpty())
		{
			try
			{
				final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				consultaContribuyenteBPRequest.setNumBP(numBP);

				sdhConsultaContribuyenteBPResponse = new SDHValidaMailRolResponse();

				for (final String claveImpuesto : impuestos)
				{
					switch (claveImpuesto)
					{
						case "01":
							final ImpPredialResponse impPredialResponse = mapper.readValue(sdhImpPredialServiceImpl.getImpuesto(numBP),
									ImpPredialResponse.class);
							sdhConsultaContribuyenteBPResponse.setPredial(impPredialResponse.getPredial());
							break;

						default:
							break;
					}
				}

			}
			catch (final Exception e)
			{
				LOG.error("there was an error while parsing ingreso/<impuestos> reponse: " + e.getMessage());
			}

		}

		return sdhConsultaContribuyenteBPResponse;
	}

	@Override
	public CustomerData getRepresentadoDataFromSAP(final String numBP) {
		final CustomerData customerData = getRepresentadoDataFromSAP(numBP, "01");

		return customerData;
	}

	@Override
	public CustomerData getRepresentadoDataFromSAP(final String numBP, final String indicador)
	{
		CustomerData customerData = null;

		final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = this.getRepresentadoFromSAP(numBP, indicador);

		customerData = sdhCustomerAccountService.mapearInfo_CustomerData(sdhConsultaContribuyenteBPResponse);


		return customerData;
	}


	@Override
	public CustomerData getRepresentadoDataFromSession()
	{
		CustomerData customerData = null;

		final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = sessionService.getCurrentSession()
				.getAttribute("representadoData");

		customerData = sdhCustomerAccountService.mapearInfo_CustomerData(sdhConsultaContribuyenteBPResponse);


		return customerData;
	}




	@Override
	public void updateCustomerTaxRestrictions() {
		sdhCustomerAccountService.updateCustomerTaxRestrictions();
	}


	@Override
	public SDHValidaMailRolResponse getRepresentado_gas_show(final String numBP)
	{
		SDHValidaMailRolResponse detalleContribuyente = null;
		InfoContribResponse infoContrib = null;
		ContribAdicionales contribAdicionales = null;

		final CustomerModel representadoModel = getCustomerFor(numBP);
		if (representadoModel != null)
		{
			detalleContribuyente = new SDHValidaMailRolResponse();
			infoContrib = new InfoContribResponse();
			contribAdicionales = new ContribAdicionales();

			infoContrib.setTipoDoc(representadoModel.getDocumentType());
			infoContrib.setNumDoc(representadoModel.getDocumentNumber());

			contribAdicionales.setNAME_ORG1(representadoModel.getNameOrg1());
			infoContrib.setAdicionales(contribAdicionales);
			detalleContribuyente.setInfoContrib(infoContrib);
		}


		return detalleContribuyente;
	}
}

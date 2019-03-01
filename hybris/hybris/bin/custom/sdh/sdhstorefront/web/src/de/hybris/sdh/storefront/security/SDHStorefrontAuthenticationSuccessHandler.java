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
import de.hybris.sdh.core.model.SDHAddressModel;
import de.hybris.sdh.core.model.SDHAgentModel;
import de.hybris.sdh.core.model.SDHExteriorPublicityTaxModel;
import de.hybris.sdh.core.model.SDHGasTaxModel;
import de.hybris.sdh.core.model.SDHPhoneModel;
import de.hybris.sdh.core.model.SDHRolModel;
import de.hybris.sdh.core.model.SDHSocialNetworkModel;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ContribAdicionales;
import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.ContribDireccion;
import de.hybris.sdh.core.pojos.responses.ContribRedSocial;
import de.hybris.sdh.core.pojos.responses.ContribTelefono;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.InfoContribResponse;
import de.hybris.sdh.core.pojos.responses.NombreRolResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
							Boolean.TRUE.equals(adicionales.getZZAUTOBUZONE()) ? Boolean.TRUE : Boolean.FALSE);
					customerModel.setUseInformationForInstitutionalPurposes(
							Boolean.TRUE.equals(adicionales.getZZAUTOUSOINF()) ? Boolean.TRUE : Boolean.FALSE);
					//TODO: fecha de autorizacion de uso de buzon

				}

				//clean old addresses
				final List<SDHAddressModel> currentAddresses = customerModel.getAddressList();

				if (currentAddresses != null && !currentAddresses.isEmpty())
				{
					modelService.remove(currentAddresses);
				}

				final List<ContribDireccion> direcciones = infoContribuyente.getDireccion();

				if (direcciones != null && !direcciones.isEmpty())
				{

					final List<SDHAddressModel> newAddresses = new ArrayList<SDHAddressModel>();

					for (final ContribDireccion eachAddress : direcciones)
					{

						final SDHAddressModel eachAddressModel = new SDHAddressModel();
						eachAddressModel.setAddKind(eachAddress.getADR_KIND());
						eachAddressModel.setStreet(eachAddress.getSTREET());
						eachAddressModel.setPostalCode(eachAddress.getPOST_CODE());
						eachAddressModel.setCity(eachAddress.getCITY1());
						eachAddressModel.setCountry(eachAddress.getCOUNTRY());
						eachAddressModel.setRegion(eachAddress.getREGION());

						newAddresses.add(eachAddressModel);

					}

					modelService.save(newAddresses);

					customerModel.setAddressList(newAddresses);

				}
				else
				{
					customerModel.setAddressList(null);
				}



				//clean old phone numbers
				final List<SDHPhoneModel> phoneNumbers = customerModel.getPhoneList();

				if (phoneNumbers != null && !phoneNumbers.isEmpty())
				{
					modelService.remove(phoneNumbers);
				}

				final List<ContribTelefono> phones = infoContribuyente.getTelefono();

				if (phones != null && !phones.isEmpty())
				{

					final List<SDHPhoneModel> newPhones = new ArrayList<SDHPhoneModel>();

					for (final ContribTelefono eachPhone : phones)
					{

						final SDHPhoneModel eachPhoneModel = new SDHPhoneModel();
						eachPhoneModel.setPhoneKind(eachPhone.getTEL_TIPO());
						eachPhoneModel.setPhoneNumber(eachPhone.getTEL_NUMBER());
						eachPhoneModel.setExtension(eachPhone.getTEL_EXTENS());

						newPhones.add(eachPhoneModel);

					}

					modelService.save(newPhones);

					customerModel.setPhoneList(newPhones);

				}
				else
				{
					customerModel.setPhoneList(null);
				}


				//clean old social networks
				final List<SDHSocialNetworkModel> socialNetworks = customerModel.getNetworkList();

				if (socialNetworks != null && !socialNetworks.isEmpty())
				{
					modelService.remove(socialNetworks);
				}

				final List<ContribRedSocial> redsocial = infoContribuyente.getRedsocial();

				if (redsocial != null && !redsocial.isEmpty())
				{

					final List<SDHSocialNetworkModel> newSocialNetwork = new ArrayList<SDHSocialNetworkModel>();

					for (final ContribRedSocial eachSocialNetwork : redsocial)
					{

						final SDHSocialNetworkModel eachSocialNetworkModel = new SDHSocialNetworkModel();

						newSocialNetwork.add(eachSocialNetworkModel);

					}

					modelService.save(newSocialNetwork);

					customerModel.setNetworkList(newSocialNetwork);
				}
				else
				{
					customerModel.setNetworkList(null);
				}

			}

			//clean old rols
			final List<SDHRolModel> rols = customerModel.getRolList();

			if (rols != null && !rols.isEmpty())
			{
				modelService.remove(rols);
			}

			final List<NombreRolResponse> roles = sdhConsultaContribuyenteBPResponse.getRoles();

			if (roles != null && !roles.isEmpty())
			{

				final List<SDHRolModel> newRolesModel = new ArrayList<SDHRolModel>();

				for (final NombreRolResponse eachRolResponse : roles)
				{

					final SDHRolModel eachRolModel = new SDHRolModel();
					eachRolModel.setRol(eachRolResponse.getNombreRol());
					newRolesModel.add(eachRolModel);

				}

				modelService.save(newRolesModel);

				customerModel.setRolList(newRolesModel);
			}
			else
			{
				customerModel.setRolList(null);
			}



			//clean old agents
			final List<SDHAgentModel> oldAgentModels = customerModel.getAgentList();

			if (oldAgentModels != null && !oldAgentModels.isEmpty())
			{
				modelService.remove(oldAgentModels);
			}

			final List<ContribAgente> agents = sdhConsultaContribuyenteBPResponse.getAgentes();

			if (agents != null && !agents.isEmpty())
			{

				final List<SDHAgentModel> newAgentModels = new ArrayList<SDHAgentModel>();

				for (final ContribAgente eachAgentResponse : agents)
				{

					final SDHAgentModel eachNewAgentModel = new SDHAgentModel();

					eachNewAgentModel.setAgent(eachAgentResponse.getAgente());
					eachNewAgentModel.setDocumentNumber(eachAgentResponse.getNumDoc());
					eachNewAgentModel.setDocumentType(eachAgentResponse.getTipoDoc());
					eachNewAgentModel.setCompleteName(eachAgentResponse.getNomCompleto());
					eachNewAgentModel.setInternalFunction(eachAgentResponse.getFuncionInterl());


					newAgentModels.add(eachNewAgentModel);

				}

				modelService.save(newAgentModels);

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
				modelService.remove(oldPETaxModels);
			}

			final List<ImpuestoPublicidadExterior> publicidadExterior = sdhConsultaContribuyenteBPResponse.getPublicidadExt();

			if (publicidadExterior != null && !publicidadExterior.isEmpty())
			{

				final List<SDHExteriorPublicityTaxModel> newPETaxModels = new ArrayList<SDHExteriorPublicityTaxModel>();

				for (final ImpuestoPublicidadExterior eachPETax : publicidadExterior)
				{

					final SDHExteriorPublicityTaxModel eachNewPETaxModel = new SDHExteriorPublicityTaxModel();
					eachNewPETaxModel.setResolutionNumber(eachPETax.getNumResolu());
					eachNewPETaxModel.setFenceType(eachPETax.getTipoValla());
					eachNewPETaxModel.setObjectNumber(eachPETax.getNumObjeto());


					newPETaxModels.add(eachNewPETaxModel);

				}

				modelService.save(newPETaxModels);

				customerModel.setExteriorPublicityTaxList(newPETaxModels);
			}
			else
			{
				customerModel.setExteriorPublicityTaxList(null);
			}


			//clean old gas taxes

			final List<SDHGasTaxModel> oldGasTaxModels = customerModel.getGasTaxList();

			if (oldPETaxModels != null && !oldPETaxModels.isEmpty())
			{
				modelService.remove(oldPETaxModels);
			}

			final List<ImpuestoGasolina> gasolina = sdhConsultaContribuyenteBPResponse.getGasolina();

			if (gasolina != null && !gasolina.isEmpty())
			{

				final List<SDHGasTaxModel> newGasTaxModels = new ArrayList<SDHGasTaxModel>();

				for (final ImpuestoGasolina eachGasolinaTax : gasolina)
				{

					final SDHGasTaxModel eachGasolinaModel = new SDHGasTaxModel();
					eachGasolinaModel.setDocumentNumber(eachGasolinaTax.getNumDoc());
					eachGasolinaModel.setDocumentType(eachGasolinaTax.getTipoDoc());
					//					eachGasolinaModel.setObjectNumber(value);


					newGasTaxModels.add(eachGasolinaModel);

				}

				modelService.save(newGasTaxModels);

				customerModel.setGasTaxList(newGasTaxModels);
			}
			else
			{
				customerModel.setGasTaxList(null);
			}


			modelService.save(customerModel);

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP: " + e.getMessage());
		}
	}

}

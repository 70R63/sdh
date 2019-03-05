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
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;
import de.hybris.platform.commerceservices.event.ChangeUIDEvent;
import de.hybris.platform.commerceservices.i18n.CommerceCommonI18NService;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.PasswordEncoderService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.store.services.BaseStoreService;
import de.hybris.sdh.core.pojos.requests.CertifNombRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.UpdateAddressRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateAutorizacionesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateEmailRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateNameRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRedesSocialesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateTelefonoRitRequest;
import de.hybris.sdh.core.pojos.responses.CertifNombResponse;
import de.hybris.sdh.core.pojos.responses.ContribDireccion;
import de.hybris.sdh.core.pojos.responses.ContribRedSocial;
import de.hybris.sdh.core.pojos.responses.ContribTelefono;
import de.hybris.sdh.core.pojos.responses.NombreRolResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.pojos.responses.UpdateRitErrorResponse;
import de.hybris.sdh.core.pojos.responses.UpdateRitResponse;
import de.hybris.sdh.core.pojos.responses.ValidEmailResponse;
import de.hybris.sdh.core.pojos.responses.ValidPasswordResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.facades.SDHCertifNombFacade;
import de.hybris.sdh.facades.SDHUpdateRitFacade;
import de.hybris.sdh.storefront.forms.CertifNombForm;
import de.hybris.sdh.storefront.forms.MiRitForm;
<<<<<<< HEAD
=======
import de.hybris.sdh.storefront.forms.UIMenuForm;
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
import de.hybris.sdh.storefront.forms.UpdateAddressRitForm;
import de.hybris.sdh.storefront.forms.UpdateAutorizacionesRitForm;
import de.hybris.sdh.storefront.forms.UpdateEmailRitForm;
import de.hybris.sdh.storefront.forms.UpdatePasswordRitForm;
import de.hybris.sdh.storefront.forms.UpdateRedesSocialesRitForm;
import de.hybris.sdh.storefront.forms.UpdateRitForm;
import de.hybris.sdh.storefront.forms.UpdateTelefonoRitForm;
import de.hybris.sdh.storefront.forms.ValidEmailForm;
import de.hybris.sdh.storefront.forms.ValidPasswordForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/contribuyentes/mirit")
public class MiRitPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(MiRitPageController.class);

	private static final String Mi_RIT_CMS_PAGE = "MiRitPage";

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String BREADCRUMBS_VALUE = "breadcrumb.certificacion";


	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhCertifNombFacade")
	private SDHCertifNombFacade sdhCertifNombFacade;

	@Resource(name = "sdhUpdateRitFacade")
	SDHUpdateRitFacade sdhUpdateRitFacade;

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@ModelAttribute("socialNetworks")
	public List<String> getSocialNetworks()
	{
		final List<String> socialNetworks = Arrays.asList("FACEBOOK", "INSTAGRAM", "LINKEDIN", "SKYPE", "TWITTER", "WHATSAPP",
				"YOUTUBE");

		return socialNetworks;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showView(final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

		final UIMenuForm uiMenuForm = new UIMenuForm();

		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			final MiRitForm miRitForm = new MiRitForm();

			uiMenuForm.fillForm(sdhConsultaContribuyenteBPResponse);
			model.addAttribute("uiMenuForm", uiMenuForm);

			if ("nit".equalsIgnoreCase(customerModel.getDocumentType()) || "nite".equalsIgnoreCase(customerModel.getDocumentType()))
			{
				model.addAttribute("PJUR", true);
				miRitForm.setNombreRazonSocial1(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG1());
				miRitForm.setNombreRazonSocial2(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG2());
				miRitForm.setNombreRazonSocial3(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG3());
				miRitForm.setNombreRazonSocial4(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNAME_ORG4());

				miRitForm.setFormaJuridica(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getLEGAL_ENTY());
				miRitForm.setNumeroMatriculaMercantil(
						sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZNOMATRICUL());

				final String feachLiq = sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getLIQUIDATIONDATE();
				if (StringUtils.isNotBlank(feachLiq) && !"00000000".equals(feachLiq))
				{
					//					final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
					//
					//					final LocalDate localDate = LocalDate.parse(feachLiq, formatter);
					//
					//					final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					//
					//					miRitForm.setFechaLiquidacion(localDate.format(formatter2));

					miRitForm.setFechaLiquidacion(feachLiq);
				}

				miRitForm.setTipoRetenedor(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getLEGALORG());

			}
			else
			{
				miRitForm.setPrimNom(sdhConsultaContribuyenteBPResponse.getInfoContrib().getPrimNom());
			}

			miRitForm.setDigVer(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getDIGVERIF());
			miRitForm.setTipoDoc(sdhConsultaContribuyenteBPResponse.getInfoContrib().getTipoDoc());

			miRitForm.setEmail(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getSMTP_ADDR());

			miRitForm.setPrimApe(sdhConsultaContribuyenteBPResponse.getInfoContrib().getPrimApe());
			miRitForm.setSegNom(sdhConsultaContribuyenteBPResponse.getInfoContrib().getSegNom());
			miRitForm.setSegApe(sdhConsultaContribuyenteBPResponse.getInfoContrib().getSegApe());

			final String feachExp = sdhConsultaContribuyenteBPResponse.getInfoContrib().getFchExp();
			if (StringUtils.isNotBlank(feachExp) && !"00000000".equals(feachExp))
			{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(feachExp, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				miRitForm.setFchExp(localDate.format(formatter2));
			}


			miRitForm.setNumDoc(sdhConsultaContribuyenteBPResponse.getInfoContrib().getNumDoc());

			if (StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getTITLE()))
			{
				miRitForm.setTratamiento(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getTITLE());
			}
			if (StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getTYPE()))
			{
				miRitForm.setClaseIC(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getTYPE());
			}
			if (0 != sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getXSEXU())
			{
				miRitForm.setSexo(
						String.valueOf(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getXSEXU()));
			}

			if (StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNATIO()))
			{
				miRitForm.setNacionalidad(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getNATIO());
			}

			miRitForm.setFechaNacimiento(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getBIRTHDT());

			miRitForm.setLugarNacimiento(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getBIRTHPL());

			if (StringUtils.isNotBlank(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getCNDSC()))
			{
				miRitForm.setPaisOrigen(sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getCNDSC());
			}

			if (sdhConsultaContribuyenteBPResponse.getRoles() != null && !sdhConsultaContribuyenteBPResponse.getRoles().isEmpty())
			{

				for (final NombreRolResponse eachRolResponse : sdhConsultaContribuyenteBPResponse.getRoles())
				{
					if ("01".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasCORol(Boolean.TRUE);
					}
					else if ("02".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasAARol(Boolean.TRUE);
					}
					else if ("03".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasTARol(Boolean.TRUE);
					}
					else if ("04".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasARRol(Boolean.TRUE);
					}
					else if ("05".equals(eachRolResponse.getNombreRol()))
					{
						miRitForm.setHasRIRol(Boolean.TRUE);
					}
				}
			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOUSOINF() == 1)
			{
				miRitForm.setUseInformationForInstitutionalPurposes(Boolean.TRUE);
			}
			else if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOUSOINF() == 2)
			{
				miRitForm.setUseInformationForInstitutionalPurposes(Boolean.FALSE);
			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOBUZONE() == 1)
			{
				miRitForm.setUseEmailForNotifications(Boolean.TRUE);
			}
			else if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getAdicionales().getZZAUTOBUZONE() == 2)
			{
				miRitForm.setUseEmailForNotifications(Boolean.FALSE);
			}


			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getDireccion() != null
					&& !sdhConsultaContribuyenteBPResponse.getInfoContrib().getDireccion().isEmpty())
			{

				for (final ContribDireccion eachDireccion : sdhConsultaContribuyenteBPResponse.getInfoContrib().getDireccion())
				{

					if ("01".equalsIgnoreCase(eachDireccion.getADR_KIND()))
					{

						miRitForm.setDireccionContacto(eachDireccion);

					}
					if ("02".equalsIgnoreCase(eachDireccion.getADR_KIND()))
					{

						miRitForm.setDireccionNotificacion(eachDireccion);

					}


				}

			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono() != null
					&& !sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono().isEmpty())
			{

				for (final ContribTelefono eachTelefono : sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono())
				{
					if (StringUtils.isNotBlank(eachTelefono.getTEL_NUMBER()))
					{
						miRitForm.setTelefonoPricipal(eachTelefono.getTEL_NUMBER());
						miRitForm.setExtensionTelefono(eachTelefono.getTEL_EXTENS());
						break;
					}
				}

			}


			if (sdhConsultaContribuyenteBPResponse.getGasolina() != null
					&& !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
			{
				miRitForm.setGasolina(sdhConsultaContribuyenteBPResponse.getGasolina().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumDoc())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getPublicidadExt() != null
					&& !sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				miRitForm.setPublicidadExt(sdhConsultaContribuyenteBPResponse.getPublicidadExt().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumResolu())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getRedsocial() != null
					&& !sdhConsultaContribuyenteBPResponse.getInfoContrib().getRedsocial().isEmpty())
			{
				miRitForm.setRedsocial(sdhConsultaContribuyenteBPResponse.getInfoContrib().getRedsocial().stream()
						.filter(eachNet -> StringUtils.isNotBlank(eachNet.getRED_SOCIAL())).collect(Collectors.toList()));
			}

			if (sdhConsultaContribuyenteBPResponse.getAgentes() != null
					&& !sdhConsultaContribuyenteBPResponse.getAgentes().isEmpty())
			{
				miRitForm.setRepresentantes(sdhConsultaContribuyenteBPResponse.getAgentes().stream().filter(
						eachAgente -> StringUtils.isNotBlank(eachAgente.getTipoDoc()) && "X".equalsIgnoreCase(eachAgente.getAgente()))
						.collect(Collectors.toList()));

				miRitForm.setRepresentados(sdhConsultaContribuyenteBPResponse.getAgentes().stream().filter(
						eachAgente -> StringUtils.isNotBlank(eachAgente.getTipoDoc()) && StringUtils.isBlank(eachAgente.getAgente()))
						.collect(Collectors.toList()));
			}


			model.addAttribute("miRitForm", miRitForm);

		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}



		storeCmsPageInModel(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(Mi_RIT_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(BREADCRUMBS_VALUE));



		return getViewForPage(model);
	}

	@RequestMapping(value = "/certifNomb", method = RequestMethod.POST)
	@ResponseBody
	public CertifNombResponse certifNomb(final CertifNombForm certifNombForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final CertifNombRequest request = new CertifNombRequest();

		request.setNumBP(customerModel.getNumBP());
		request.setApellido1(certifNombForm.getApellido1());
		request.setApellido2(certifNombForm.getApellido2());
		request.setName1(certifNombForm.getName1());
		request.setName2(certifNombForm.getName2());


		return sdhCertifNombFacade.certifNomb(request);
	}

	@RequestMapping(value = "/updateNombre", method = RequestMethod.POST)
	@ResponseBody
	public UpdateRitResponse updateNombre(final CertifNombForm certifNombForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final CertifNombRequest request = new CertifNombRequest();

		request.setNumBP(customerModel.getNumBP());
		request.setApellido1(certifNombForm.getApellido1());
		request.setApellido2(certifNombForm.getApellido2());
		request.setName1(certifNombForm.getName1());
		request.setName2(certifNombForm.getName2());

		UpdateRitResponse response = new UpdateRitResponse();

		response.setRitUpdated(false);

		final CertifNombResponse certifNombResponse = sdhCertifNombFacade.certifNomb(request);

		if (certifNombResponse != null && Boolean.TRUE.equals(certifNombResponse.getSuccess()))
		{
			final UpdateNameRitRequest updateNameRequest = new UpdateNameRitRequest();

			updateNameRequest.setNumBP(customerModel.getNumBP());
			updateNameRequest.setPrimApe(certifNombForm.getApellido1());
			updateNameRequest.setSegApe(certifNombForm.getApellido2());
			updateNameRequest.setPrimNom(certifNombForm.getName1());
			updateNameRequest.setSegNom(certifNombForm.getName2());

			response = sdhUpdateRitFacade.updateNameRit(updateNameRequest);
			response.setRitUpdated(true);

		}


		return response;
	}


	@RequestMapping(value = "/updateEmail", method = RequestMethod.POST)
	@ResponseBody
	public UpdateRitResponse updateEmail(final UpdateEmailRitForm updateEmailForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		String email = customerModel.getUid();

		UpdateRitResponse response = new UpdateRitResponse();

		if (StringUtils.isNotBlank(updateEmailForm.getEmail())
				&& StringUtils.isNotBlank(updateEmailForm.getConfirmNewEmailAddress())
				&& StringUtils.isNotBlank(updateEmailForm.getNewEmailAddress()))
		{
			final String newUidLower = updateEmailForm.getNewEmailAddress().toLowerCase();

			customerModel.setOriginalUid(newUidLower);
			customerModel.setUid(newUidLower);
			modelService.save(customerModel);

			eventService.publishEvent(initializeEvent(new ChangeUIDEvent(), customerModel));


			// Replace the spring security authentication with the new UID
			final String newUid = customerFacade.getCurrentCustomer().getUid().toLowerCase();
			final Authentication oldAuthentication = SecurityContextHolder.getContext().getAuthentication();
			final UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(newUid, null,
					oldAuthentication.getAuthorities());
			newAuthentication.setDetails(oldAuthentication.getDetails());
			SecurityContextHolder.getContext().setAuthentication(newAuthentication);

			email = newUidLower;

			final UpdateEmailRitRequest request = new UpdateEmailRitRequest();

			request.setEmail(email);request.setNumBP(customerModel.getNumBP());

			response = sdhUpdateRitFacade.updateEmailRit(request);
		}


		return response;
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	public UpdateRitResponse updatePassword(final UpdatePasswordRitForm updatePasswordRitForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final String email = customerModel.getUid();

		final UpdateRitResponse response = new UpdateRitResponse();

		if (StringUtils.isNotBlank(updatePasswordRitForm.getPassoword())
				&& StringUtils.isNotBlank(updatePasswordRitForm.getConfirmNewPassword())
				&& StringUtils.isNotBlank(updatePasswordRitForm.getNewPassword()))
		{
			customerFacade.changePassword(updatePasswordRitForm.getPassoword(), updatePasswordRitForm.getNewPassword());

			response.setRitUpdated(true);
		}


		return response;
	}

	@RequestMapping(value = "/updateAutorizaciones", method = RequestMethod.POST)
	@ResponseBody
	public UpdateRitResponse updateAutorizaciones(final UpdateAutorizacionesRitForm updateAutorizacionesRitForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final UpdateAutorizacionesRitRequest request = new UpdateAutorizacionesRitRequest();

		request.setNumBP(customerModel.getNumBP());
		request.setUseEmailForNotifications(updateAutorizacionesRitForm.getUsoBuzon());
		request.setUseInformationForInstitutionalPurposes(updateAutorizacionesRitForm.getAutoUsoInfo());

		if (Boolean.TRUE.equals(updateAutorizacionesRitForm.getUsoBuzon()))
		{
			final LocalDateTime now = LocalDateTime.now();

			final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

			final String formatDateTime = now.format(formatter);

			request.setAutoBuzonDate(formatDateTime);
		}
		else
		{
			request.setAutoBuzonDate("0");
		}

		final UpdateRitResponse udpateRitResponse = sdhUpdateRitFacade.updateAutorizacionesRit(request);

		return udpateRitResponse;
	}


	@RequestMapping(value = "/updateRedesSociales", method = RequestMethod.POST)
	@ResponseBody
	public UpdateRitResponse updateRedesSociales(final UpdateRedesSocialesRitForm updateRedesSocialesRitForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final UpdateRedesSocialesRitRequest request = new UpdateRedesSocialesRitRequest();

		UpdateRitResponse udpateRitResponse = new UpdateRitResponse();

		if (StringUtils.isNotBlank(updateRedesSocialesRitForm.getRedsocial()))
		{

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			try
			{
				final List<ContribRedSocial> redesSociales = Arrays
						.asList(mapper.readValue(updateRedesSocialesRitForm.getRedsocial(), ContribRedSocial[].class));

				request.setRedsocial(redesSociales);
				request.setNumBP(customerModel.getNumBP());

				udpateRitResponse = sdhUpdateRitFacade.updateRedesSocialesRit(request);
			}
			catch (final Exception e)
			{
				// XXX Auto-generated catch block
				LOG.error("there was an error while parsing redsocial JSON");
				udpateRitResponse.setRitUpdated(false);
			}
		}



		return udpateRitResponse;
	}

	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	@ResponseBody
	public UpdateRitResponse updateAdddress(final UpdateAddressRitForm updateAddressRitForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final UpdateAddressRitRequest request = new UpdateAddressRitRequest();

		UpdateRitResponse udpateRitResponse = new UpdateRitResponse();

		if (StringUtils.isNotBlank(updateAddressRitForm.getAddress()))
		{
			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final ContribDireccion direccion = mapper.readValue(updateAddressRitForm.getAddress(),
						ContribDireccion.class);

				request.setNumBP(customerModel.getNumBP());
				request.setDireccion(direccion);

				udpateRitResponse = sdhUpdateRitFacade.updateAddressRit(request);

			}
			catch (final Exception e)
			{
				LOG.error("there was an error while parsing redsocial JSON");
			}
		}



		return udpateRitResponse;
	}


	@RequestMapping(value = "/updateTelefono", method = RequestMethod.POST)
	@ResponseBody
	public UpdateRitResponse updateTelefono(final UpdateTelefonoRitForm updateTelefonoRitForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final UpdateTelefonoRitRequest request = new UpdateTelefonoRitRequest();
		request.setNumBP(customerModel.getNumBP());
		request.setExtension(updateTelefonoRitForm.getExtension());
		request.setTelfonoPrincipal(updateTelefonoRitForm.getTelfonoPrincipal());

		UpdateRitResponse udpateRitResponse = new UpdateRitResponse();

		udpateRitResponse = sdhUpdateRitFacade.updateTelefonoRit(request);



		return udpateRitResponse;
	}


	@Resource(name = "passwordEncoderService")
	private PasswordEncoderService passwordEncoderService;


	@RequestMapping(value = "/validCurrentPassword", method = RequestMethod.POST)
	@ResponseBody
	public ValidPasswordResponse validCurrentPassword(final ValidPasswordForm validPasswordForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final boolean isValid = passwordEncoderService.isValid(customerModel, validPasswordForm.getPassoword());

		final ValidPasswordResponse response = new ValidPasswordResponse();

		response.setIsValidPassword(isValid);

		return response;
	}

	@RequestMapping(value = "/validNewEmail", method = RequestMethod.POST)
	@ResponseBody
	public ValidEmailResponse validNewEmail(final ValidEmailForm validEmailForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ValidEmailResponse response = new ValidEmailResponse();

		try
		{
			userService.getUserForUID(validEmailForm.getMail());

			response.setIsValidEmail(false);

		}
		catch (final UnknownIdentifierException ex)
		{
			response.setIsValidEmail(true);
		}


		return response;
	}


	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "eventService")
	private EventService eventService;




	@RequestMapping(value = "/updateRit", method = RequestMethod.POST)
	@ResponseBody
	public UpdateRitResponse updateRit(final UpdateRitForm updateRitForm)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();


		final UpdateRitRequest request = new UpdateRitRequest();

		request.setNumBP(customerModel.getNumBP());
		request.setPrimNom(updateRitForm.getPrimNom());
		request.setSegNom(updateRitForm.getSegNom());
		request.setPrimApe(updateRitForm.getPrimApe());
		request.setSegApe(updateRitForm.getSegApe());
		request.setUseEmailForNotifications(updateRitForm.getUsoBuzon());
		request.setUseInformationForInstitutionalPurposes(updateRitForm.getAutoUsoInfo());

		if (StringUtils.isNotBlank(updateRitForm.getDireccionContacto()))
		{
			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final ContribDireccion direccionContacto = mapper.readValue(updateRitForm.getDireccionContacto(),
						ContribDireccion.class);

				request.setDireccionContacto(direccionContacto);

			}
			catch (final Exception e)
			{
				// XXX Auto-generated catch block
				LOG.error("there was an error while parsing redsocial JSON" + e.getMessage());
			}
		}

		if (StringUtils.isNotBlank(updateRitForm.getDireccionNoficacion()))
		{
			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final ContribDireccion direccionNoficacion = mapper.readValue(updateRitForm.getDireccionNoficacion(),
						ContribDireccion.class);

				request.setDireccionNoficacion(direccionNoficacion);

			}
			catch (final Exception e)
			{
				LOG.error("there was an error while parsing redsocial JSON");
			}
		}
		//TODO:verificar llenado de telefono
		request.setTelfonoPrincipal(updateRitForm.getTelfonoPrincipal());
		request.setExtension(updateRitForm.getExtension());

		if (Boolean.TRUE.equals(updateRitForm.getUsoBuzon()))
		{
			final LocalDateTime now = LocalDateTime.now();

			final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

			final String formatDateTime = now.format(formatter);

			request.setAutoBuzonDate(formatDateTime);
		}

		if (StringUtils.isNotBlank(updateRitForm.getRedsocial()))
		{

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			try
			{
				final List<ContribRedSocial> redesSociales = Arrays
						.asList(mapper.readValue(updateRitForm.getRedsocial(), ContribRedSocial[].class));

				request.setRedsocial(redesSociales);
			}
			catch (final Exception e)
			{
				// XXX Auto-generated catch block
				LOG.error("there was an error while parsing redsocial JSON");
			}


		}

		request.setUpdateName(Boolean.FALSE);

		final CertifNombRequest certifNomRequest = new CertifNombRequest();

		certifNomRequest.setNumBP(customerModel.getNumBP());
		certifNomRequest.setApellido1(updateRitForm.getPrimApe());
		certifNomRequest.setApellido2(updateRitForm.getSegApe());
		certifNomRequest.setName1(updateRitForm.getPrimNom());
		certifNomRequest.setName2(updateRitForm.getSegNom());

		boolean nameUpdated = false;

		if (Boolean.TRUE.equals(updateRitForm.getRequestUpdateName()))
		{

   		final CertifNombResponse certifNombResponse = sdhCertifNombFacade.certifNomb(certifNomRequest);

   		if (certifNombResponse != null && Boolean.TRUE.equals(certifNombResponse.getSuccess()))
   		{
   			request.setUpdateName(Boolean.TRUE);
   			nameUpdated = true;
   		}
		}

		final UpdateRitResponse udpateRitResponse = sdhUpdateRitFacade.updateRit(request);

		if (Boolean.TRUE.equals(updateRitForm.getRequestUpdateName()) && nameUpdated == false)
		{
			List<UpdateRitErrorResponse> errorsList = udpateRitResponse.getErrores();
			if (errorsList == null)
			{
				errorsList = new ArrayList<UpdateRitErrorResponse>();
			}

			errorsList.add(new UpdateRitErrorResponse("x",
					"El nombre no ha sido actualizado ya que no cumple con el porcentaje mínimo de similitud"));

			udpateRitResponse.setErrores(errorsList);
		}

		return udpateRitResponse;
	}

	@Resource(name = "commerceCommonI18NService")
	private CommerceCommonI18NService commerceCommonI18NService;

	@Resource(name = "baseStoreService")
	private BaseStoreService baseStoreService;

	protected AbstractCommerceUserEvent initializeEvent(final AbstractCommerceUserEvent event, final CustomerModel customerModel)
	{
		event.setBaseStore(baseStoreService.getCurrentBaseStore());
		event.setSite(getBaseSiteService().getCurrentBaseSite());
		event.setCustomer(customerModel);
		event.setLanguage(commerceCommonI18NService.getCurrentLanguage());
		event.setCurrency(commerceCommonI18NService.getCurrentCurrency());
		return event;
	}



	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}
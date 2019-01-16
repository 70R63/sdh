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

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ContribDireccion;
import de.hybris.sdh.core.pojos.responses.ContribTelefono;
import de.hybris.sdh.core.pojos.responses.NombreRolResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.forms.MiRitForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@RequestMapping(method = RequestMethod.GET)
	public String showView(final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();

		consultaContribuyenteBPRequest.setNumBP(customerModel.getNumBP());

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			final MiRitForm miRitForm = new MiRitForm();

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
			miRitForm.setTipoDoc(sdhConsultaContribuyenteBPResponse.getInfoContrib().getTipoDoc());

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

						miRitForm.setDireccionContacto(eachDireccion.getSTREET());

					}
					if ("02".equalsIgnoreCase(eachDireccion.getADR_KIND()))
					{

						miRitForm.setDireccionNotificacion(eachDireccion.getSTREET());

					}


				}

			}

			if (sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono() != null
					&& !sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono().isEmpty())
			{

				for (final ContribTelefono eachTelefono : sdhConsultaContribuyenteBPResponse.getInfoContrib().getTelefono())
				{

					if ("1".equalsIgnoreCase(eachTelefono.getTEL_TIPO()))
					{

						miRitForm.setTelefonoFijo(eachTelefono.getTEL_NUMBER());
						miRitForm.setExtensionTelefono(eachTelefono.getTEL_EXTENS());

					}
					else
					{

						miRitForm.setTelefonoCelular(eachTelefono.getTEL_NUMBER());

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
					&& !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
			{
				miRitForm.setPublicidadExt(sdhConsultaContribuyenteBPResponse.getPublicidadExt().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumResolu())).collect(Collectors.toList()));
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

		return getViewForPage(model);
	}



	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}
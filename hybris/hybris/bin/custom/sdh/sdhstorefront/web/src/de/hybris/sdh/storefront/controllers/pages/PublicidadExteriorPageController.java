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
import de.hybris.sdh.core.pojos.requests.DetallePublicidadRequest;
import de.hybris.sdh.core.pojos.responses.DetallePubli;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCalPublicidadService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetallePublicidadService;
import de.hybris.sdh.storefront.forms.PublicidadForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for home page 2
 */
@Controller
@RequestMapping("/contribuyentes/publicidadexterior")
public class PublicidadExteriorPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(PublicidadExteriorPageController.class);


	private static final String PUBLICIDAD_EXTERIOR_CMS_PAGE = "PublicidadExteriorPage";
	private static final String REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/publicidadexterior/declaracion";
	private static final String REDIRECT_TO_DETALLE_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes2/publicidadexterior/detalle";



	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "sdhDetallePublicidadService")
	SDHDetallePublicidadService sdhDetallePublicidadService;

	@Resource(name = "sdhCalPublicidadService")
	SDHCalPublicidadService sdhCalPublicidadService;


	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	//CMS PAGES
	private static final String DECLARACION_PUBLICIDAD_CMS_PAGE = "DeclaraPublicidadPage";


	@RequestMapping(method = RequestMethod.GET)
	public String showView(final Model model) throws CMSItemNotFoundException
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		final PublicidadForm publicidadForm = new PublicidadForm();
		final String numBP = customerModel.getNumBP(); //Pendiente descomentar para que se tome el BP que se logeo

		consultaContribuyenteBPRequest.setNumBP(numBP);
		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = mapper.readValue(
					sdhConsultaContribuyenteBPService.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

			if (sdhConsultaContribuyenteBPResponse.getPublicidadExt() != null
					&& !sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				publicidadForm.setPublicidadExt(sdhConsultaContribuyenteBPResponse.getPublicidadExt().stream()
						.filter(eachTax -> StringUtils.isNotBlank(eachTax.getNumResolu())).collect(Collectors.toList()));


				model.addAttribute("publicidadForm", publicidadForm);
			}
			else
			{
				GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			}

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
			GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));

		return getViewForPage(model);
	}


	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

	//Se anexa el mapeo de la pagina publicidadexterior
	//GRD
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	@ResponseBody
	public PublicidadForm publicidadExternaDetail(@ModelAttribute("publicidadInfo")
	final PublicidadForm publicidadInfo, final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final PublicidadForm publicidadForm = new PublicidadForm();

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final DetallePublicidadRequest detallePublicidadRequest = new DetallePublicidadRequest();
		final String numBP = customerModel.getNumBP();

		detallePublicidadRequest.setNumBP(numBP);
		detallePublicidadRequest.setNumResolu(publicidadInfo.getNumResolu());
		detallePublicidadRequest.setAnoGravable(publicidadInfo.getAnoGravable());

		try
			{
			final String tipovalla = publicidadInfo.getTipoValla();

			//final PublicidadForm publicidadForm = new PublicidadForm();
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final DetallePublicidadResponse detallePublicidadResponse = mapper.readValue(
					sdhDetallePublicidadService.detallePublicidad(detallePublicidadRequest), DetallePublicidadResponse.class);

			//final PublicidadForm publicidadForm = new PublicidadForm();

			//publicidadForm.setTipoElemento(detallePublicidadResponse.getTipoElemento());

			//Datos Basicos

			final String fechResolu = detallePublicidadResponse.getFechResolu();
			if (StringUtils.isNotBlank(fechResolu) && !"00000000".equals(fechResolu))
			{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(fechResolu, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				publicidadForm.setFechResolu(localDate.format(formatter2));
			}


			final String fechNotif = detallePublicidadResponse.getFechNotif();
			if (StringUtils.isNotBlank(fechNotif) && !"00000000".equals(fechNotif))
				{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(fechNotif, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				publicidadForm.setFechNotif(localDate.format(formatter2));
			}

			final String vigenDesde = detallePublicidadResponse.getVigenDesde();
			if (StringUtils.isNotBlank(vigenDesde) && !"00000000".equals(vigenDesde))
			{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(vigenDesde, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				publicidadForm.setVigenDesde(localDate.format(formatter2));
			}
			publicidadForm.setVigenHasta(detallePublicidadResponse.getVigenHasta());
			final String vigenHasta = detallePublicidadResponse.getVigenDesde();
			if (StringUtils.isNotBlank(vigenHasta) && !"00000000".equals(vigenHasta))
			{
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

				final LocalDate localDate = LocalDate.parse(vigenHasta, formatter);

				final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				publicidadForm.setVigenHasta(localDate.format(formatter2));
			}




			if (detallePublicidadResponse.getDetalle() != null && !detallePublicidadResponse.getDetalle().isEmpty())
			{

				for (final DetallePubli eachDetalle : detallePublicidadResponse.getDetalle())
					{

					if ("VALLA VEHICULOS".equalsIgnoreCase(tipovalla) || "VALLA VEHíCULOS".equalsIgnoreCase(tipovalla))
						{

						publicidadForm.setModelo(eachDetalle.getModelo());
						publicidadForm.setPlaca(eachDetalle.getPlaca());
						publicidadForm.setNumLicenciaTrans(eachDetalle.getNumLicenciaTrans());

						if ("01".equals(eachDetalle.getTipoServicio()))
						{
							publicidadForm.setTipoServicio("Publico");
						}
						else if ("02".equals(eachDetalle.getTipoServicio()))
						{
							publicidadForm.setTipoServicio("Particular");
						}
						else if ("03".equals(eachDetalle.getTipoServicio()))
						{
							publicidadForm.setTipoServicio("Publico colectivo");
						}
						else if ("04".equals(eachDetalle.getTipoServicio()))
						{
							publicidadForm.setTipoServicio("Publico individual");
						}
						else
						{
							publicidadForm.setTipoServicio("-");
						}

						//publicidadForm.setTipoPublici(eachDetalle.getTipoPublici());
						if ("01".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Politica");
						}
						else if ("02".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Comercial");
						}
						else if ("03".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Institucional");
						}
						else
						{
							publicidadForm.setTipoPublici("-");
						}

						if ("01".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Vehiculo");
						}
						else if ("02".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Taxi");
						}
						else if ("03".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Disel");
						}
						else if ("04".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Bus");
						}
						else if ("05".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Buseta");
						}
						else if ("06".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Colectivo Disel");
						}
						else if ("07".equals(eachDetalle.getTipoElemento()))
						{
							publicidadForm.setTipoElemento("Hibrido");
						}
						else
						{
							publicidadForm.setTipoElemento("-");
						}

						if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Oriente-Occidente");
						}
						else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Occidente-Oriente");
						}
						else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Norte-Sur");
						}
						else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Sur-Norte");
						}
						if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Derecha");
						}
						if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Izquierda");
						}
						if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Ambos sentidos");
						}
						else
						{
							publicidadForm.setOrientacion("-");
						}


						}
					else if ("Valla Tubular de Obra".equalsIgnoreCase(tipovalla))
						{


						publicidadForm.setDireccion(eachDetalle.getDireccion());
						publicidadForm.setLocalidad(eachDetalle.getLocalidad());
						publicidadForm.setCodPostal(eachDetalle.getCodPostal());
						publicidadForm.setChip(eachDetalle.getChip());
						publicidadForm.setMatricula(eachDetalle.getMatricula());


						if ("01".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Registro Nuevo");
						}
						else if ("02".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Actualizacion");
						}
						else if ("03".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Prorroga");
						}
						else if ("04".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Traslado");
						}
						else
						{
							publicidadForm.setTipoSolicitud(" ");
						}


						if ("01".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Edificio Privado");
						}
						else if ("02".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Lote Privado");
						}
						else if ("03".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Espacio Público");
						}
						else
						{
							publicidadForm.setUbicacion("-");
						}

						if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Oriente-Occidente");
						}
						else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Occidente-Oriente");
						}
						else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Norte-Sur");
						}
						else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Sur-Norte");
						}
						if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Derecha");
						}
						if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Izquierda");
						}
						if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Ambos sentidos");
						}
						else
						{
							publicidadForm.setOrientacion("-");
						}
						publicidadForm.setLicenciaUrb(eachDetalle.getLicenciaUrb());
						publicidadForm.setContratoObra(eachDetalle.getContratoObra());
						publicidadForm.setLicenciaConstruc(eachDetalle.getLicenciaConstruc());
						publicidadForm.setVigLicenConstruc(eachDetalle.getVigLicenConstruc());
						publicidadForm.setAreaTotal(eachDetalle.getAreaTotal());
						publicidadForm.setPeriodicidad(eachDetalle.getPeriodicidad());
						publicidadForm.setNumCaras(eachDetalle.getNumCaras());


					}
					else if ("Valla de Obra Convencional".equalsIgnoreCase(tipovalla))
					{

						publicidadForm.setAreaTotal(eachDetalle.getAreaTotal());
						publicidadForm.setDireccion(eachDetalle.getDireccion());//repetido
						publicidadForm.setLocalidad(eachDetalle.getLocalidad());//repetido
						publicidadForm.setCodPostal(eachDetalle.getCodPostal());//repetido
						publicidadForm.setChip(eachDetalle.getChip());//repetido
						publicidadForm.setMatricula(eachDetalle.getMatricula());//repetido
						publicidadForm.setAreaElemento(eachDetalle.getAreaElemento());

						if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Oriente-Occidente");
						}
						else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Occidente-Oriente");
						}
						else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Norte-Sur");
						}
						else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Sur-Norte");
						}
						if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Derecha");
						}
						if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Izquierda");
						}
						if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Ambos sentidos");
						}
						else
						{
							publicidadForm.setOrientacion("-");
						}

						publicidadForm.setAvisoLumino(eachDetalle.getAvisoLumino());
						publicidadForm.setUbicacion(eachDetalle.getUbicacion());
						publicidadForm.setTipoPublici(eachDetalle.getTipoPublici());

						if ("01".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Registro Nuevo");
						}
						else if ("02".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Actualizacion");
						}
						else if ("03".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Prorroga");
						}
						else if ("04".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Traslado");
						}
						else
						{
							publicidadForm.setTipoSolicitud(" ");
						}

					}
					else if ("Valla Tubular Comercial".equalsIgnoreCase(tipovalla))
					{


						publicidadForm.setDireccion(eachDetalle.getDireccion());
						publicidadForm.setLocalidad(eachDetalle.getLocalidad());
						publicidadForm.setCodPostal(eachDetalle.getCodPostal());
						publicidadForm.setChip(eachDetalle.getChip());
						publicidadForm.setMatricula(eachDetalle.getMatricula());
						publicidadForm.setAreaElemento(eachDetalle.getAreaElemento());

						if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Oriente-Occidente");
						}
						else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Occidente-Oriente");
						}
						else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Norte-Sur");
						}
						else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Sur-Norte");
						}
						if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Derecha");
						}
						if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Izquierda");
						}
						if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Ambos sentidos");
						}
						else
						{
							publicidadForm.setOrientacion("-");
						}

						if ("01".equals(eachDetalle.getAvisoLumino()))
						{
							publicidadForm.setAvisoLumino("Si");
						}
						else if ("02".equals(eachDetalle.getAvisoLumino()))
						{
							publicidadForm.setAvisoLumino("No");
						}
						else
						{
							publicidadForm.setAvisoLumino("-");
						}


						if ("01".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Registro Nuevo");
						}
						else if ("02".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Actualizacion");
						}
						else if ("03".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Prorroga");
						}
						else if ("04".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Traslado");
						}
						else
						{
							publicidadForm.setTipoSolicitud("-");
						}


						if ("01".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Primer piso");
						}
						else if ("02".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Parqueadero");
						}
						else if ("03".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Antepecho del segundo piso");
						}
						else if ("04".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Canopy porte superior del edificio (de 5 más pisos)");
						}
						else
						{
							publicidadForm.setUbicacion("-");
						}

					}
					else if ("Pantalla LED".equalsIgnoreCase(tipovalla))
					{
						publicidadForm.setDireccion(eachDetalle.getDireccion());
						publicidadForm.setLocalidad(eachDetalle.getLocalidad());
						publicidadForm.setCodPostal(eachDetalle.getCodPostal());
						publicidadForm.setChip(eachDetalle.getChip());
						publicidadForm.setAreaTotal(eachDetalle.getAreaTotal());
						publicidadForm.setMatricula(eachDetalle.getMatricula());

						if ("01".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Edificio privado");
						}
						else if ("02".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Lote privado");
						}
						else if ("03".equals(eachDetalle.getUbicacion()))
						{
							publicidadForm.setUbicacion("Espacio público");
						}
						else
						{
							publicidadForm.setUbicacion("-");
						}

						if ("01".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Comercial");
						}
						else if ("02".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Institucional");
						}
						else if ("03".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Cultural");
						}
						else if ("04".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Política");
						}
						else if ("05".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Deportiva");
						}
						else if ("06".equals(eachDetalle.getTipoPublici()))
						{
							publicidadForm.setTipoPublici("Otra");
						}
						else
						{
							publicidadForm.setTipoPublici(" ");
						}

						if ("01".equals(eachDetalle.getOrientacion()) || "1".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Oriente-Occidente");
						}
						else if ("02".equals(eachDetalle.getOrientacion()) || "2".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Occidente-Oriente");
						}
						else if ("03".equals(eachDetalle.getOrientacion()) || "3".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Norte-Sur");
						}
						else if ("04".equals(eachDetalle.getOrientacion()) || "4".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Sur-Norte");
						}
						if ("05".equals(eachDetalle.getOrientacion()) || "5".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Derecha");
						}
						if ("06".equals(eachDetalle.getOrientacion()) || "6".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Izquierda");
						}
						if ("07".equals(eachDetalle.getOrientacion()) || "7".equals(eachDetalle.getOrientacion()))
						{
							publicidadForm.setOrientacion("Ambos sentidos");
						}
						else
						{
							publicidadForm.setOrientacion("-");
						}

						if ("01".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Registro Nuevo");
						}
						else if ("02".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Actualizacion");
						}
						else if ("03".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Prorroga");
						}
						else if ("04".equals(detallePublicidadResponse.getTipoSolicitud()))
						{
							publicidadForm.setTipoSolicitud("Traslado");
						}
						else
						{
							publicidadForm.setTipoSolicitud("-");
						}


					}
					else
					{
						System.out.println("------------Algo salio mal con el mapeo------------------");
					}
					break;
				}

			}

				model.addAttribute("publicidadForm", publicidadForm);


			}
		catch (final Exception e)
			{
			// XXX Auto-generated catch block
			LOG.error("error getting customer info from SAP for rit page: " + e.getMessage());
				GlobalMessages.addErrorMessage(model, "mirit.error.getInfo");
			}

		//model.addAttribute("showDetail", true);
		//	model.addAttribute("action", request.getParameter("action"));
		//System.out.println("action: " + request.getParameter("action"));
		storeCmsPageInModel(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(PUBLICIDAD_EXTERIOR_CMS_PAGE));
		//		return REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE;
		return publicidadForm;
		}

}
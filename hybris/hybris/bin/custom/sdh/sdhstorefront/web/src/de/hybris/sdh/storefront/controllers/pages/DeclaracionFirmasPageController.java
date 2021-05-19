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

import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.customBreadcrumbs.ResourceBreadcrumbBuilder;
import de.hybris.sdh.core.pojos.requests.*;
import de.hybris.sdh.core.pojos.responses.*;
import de.hybris.sdh.core.services.*;
import de.hybris.sdh.facades.SDHCalculaPublicidad2Facade;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.SDHEnviaFirmasFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.forms.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import Decoder.BASE64Decoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Controller for home page 2
 */
@Controller
@RequestMapping("/contribuyentes/declaracion")
public class DeclaracionFirmasPageController extends SDHAbstractPageController {

	private static final Logger LOG = Logger.getLogger(PublicidadExteriorPageController.class);


	private static final String PUBLICIDAD_EXTERIOR_CMS_PAGE = "PublicidadExteriorPage";
	private static final String REDIRECT_TO_DECLARACIONES_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/publicidadexterior/declaracion";
	private static final String REDIRECT_TO_DETALLE_PUBLICIDAD_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes2/publicidadexterior/detalle";
	private static final String DECLARACIONES_PAGAR_CMS_PAGE = "preparacion-PagarPSE";
	private static final String REDIRECT_TO_DECLARACIONES_PAGAR_PAGE = REDIRECT_PREFIX + "/impuestos/preparacion-PagarPSE";

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	@Resource(name = "customBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhDetallePublicidadService")
	SDHDetallePublicidadService sdhDetallePublicidadService;

	@Resource(name = "sdhCalPublicidadService")
	SDHCalPublicidadService sdhCalPublicidadService;

	@Resource(name = "sdhGeneraDeclaracionService")
	SDHGeneraDeclaracionService sdhGeneraDeclaracionService;

	@Resource(name = "mediaService")
	private MediaService mediaService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Resource(name = "customerFacade")
	CustomerFacade customerFacade;

	@Resource(name="sdhEnviaFirmasFacade")
    SDHEnviaFirmasFacade sdhEnviaFirmasFacade;

	@Resource(name="sdhCalculaPublicidad2Facade")
	SDHCalculaPublicidad2Facade sdhCalculaPublicidad2Facade;

	@Resource(name="sdhCustomerFacade")
	SDHCustomerFacade sdhCustomerFacade;


	private static final String ERROR_CMS_PAGE = "notFound";
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile.declarapublicidad";



	//CMS PAGES
	private static final String DECLARACION_PUBLICIDAD_CMS_PAGE = "DeclaraPublicidadPage";


	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}



	@RequestMapping(value="/firmar",method=RequestMethod.POST)
    @ResponseBody
    public EnviaFirmasResponse enviaFirmas(Model model, @RequestBody final EnviaFirmasForm dataForm, final HttpServletResponse response, final HttpServletRequest request)
    {
        EnviaFirmasRequest enviaFirmasRequest = new EnviaFirmasRequest();

        enviaFirmasRequest.setNumForm(dataForm.getNumForm());


        if(CollectionUtils.isNotEmpty(dataForm.getFirmantes()))
		{
			List<FirmanteRequest> firmantesList = new ArrayList<FirmanteRequest>();
			for(FirmantesForm eachFirmante : dataForm.getFirmantes())
			{
				FirmanteRequest firmante = new FirmanteRequest();

				firmante.setConfirmacion(eachFirmante.getConfirmacion());
				firmante.setFirmante(eachFirmante.getFirmante());
				firmante.setNumIdentif(eachFirmante.getNumIdentif());
				firmante.setTipoIdent(eachFirmante.getTipoIdent());


				firmantesList.add(firmante);
			}
			enviaFirmasRequest.setTablFirmante(firmantesList);
		}

        return sdhEnviaFirmasFacade.enviaFirmas(enviaFirmasRequest);
    }



}

package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.FileConciliaRequest;
import de.hybris.sdh.core.pojos.responses.FileConciliaResponse;
import de.hybris.sdh.core.services.SDHGestionBancaria;
import de.hybris.sdh.storefront.controllers.pages.forms.ImportConciliacionForm;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gestionBancaria")
public class GestionBancariaController extends AbstractPageController {
    private static final Logger LOG = Logger.getLogger(GestionBancariaController.class);
    private static final String CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE = "gestionBancariaPage";
    private static final String BREADCRUMBS_ATTR = "breadcrumbs";

    @Resource(name = "accountBreadcrumbBuilder")
    private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

    @Resource(name = "sdhGestionBancaria")
    private SDHGestionBancaria sdhGestionBancaria;

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;


    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    @RequireHardLogIn
    public String uploadFileGet(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException {
        storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE));
        return getViewForPage(model);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @RequireHardLogIn
    public String pagoEnLineaForm(@ModelAttribute("importConciliacionForm") final ImportConciliacionForm importConciliacionForm,
			final RedirectAttributes redirectAttributes, final Model model) throws IOException
    {

		final String approvedFilesFolder = configurationService.getConfiguration()
				.getString("gestion.bancaria.certificados.aprobados.path");
		final String approvedAresFilesFolder = configurationService.getConfiguration()
				.getString("gestion.bancaria.certificados.ArchBancos_Ares.path");

		final String extension_origen = ".zip.p7z";
		final String extension_destino = ".txt";

        redirectAttributes.addFlashAttribute("importConciliacionForm", importConciliacionForm);


		if (!importConciliacionForm.getConciliacionFile().getOriginalFilename().contains(extension_origen))
		{
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"conciliaciones.upload.messages.error.extension", new Object[]
					{ importConciliacionForm.getConciliacionFile().getOriginalFilename(), extension_origen });

		}
		else
		{

			LOG.info("File-reading");
			LOG.info("getConciliacionFile:" + importConciliacionForm.getConciliacionFile());
			LOG.info("getTipoArchivo" + importConciliacionForm.getTipoArchivo());



			final String pathFiles = configurationService.getConfiguration()
					.getString("gestion.bancaria.certificados.aprobados.path");
			final FileConciliaRequest fileConciliaRequest = new FileConciliaRequest(importConciliacionForm.getEntidadBancaria(),
					importConciliacionForm.getTipoArchivo(),
					importConciliacionForm.getConciliacionFile().getOriginalFilename().replaceAll(extension_origen, extension_destino),
					"1", pathFiles);

			final FileConciliaResponse fileConciliaResponse1 = sdhGestionBancaria.fileConcilia(fileConciliaRequest);

			if (Objects.nonNull(fileConciliaResponse1))
			{
				if (fileConciliaResponse1.getIdEnvio().equals("000"))
				{
					final String verifiedOk = sdhGestionBancaria
							.validade7ZipCertificates(importConciliacionForm.getConciliacionFile());
					LOG.info("verifiedOk Result: " + verifiedOk);
					if (verifiedOk == null)
					{
						fileConciliaRequest.setFlag("0");
						final FileConciliaResponse fileConciliaResponse2 = sdhGestionBancaria.fileConcilia(fileConciliaRequest);
						GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
								"conciliaciones.upload.messages.ws.fileConcilia.success", new Object[]
								{ fileConciliaResponse2.getMsjResp() + "Id de Envio = " + fileConciliaResponse2.getIdEnvio() });
					}
					else
					{
						GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
								"conciliaciones.upload.messages.error.firma", new Object[]
								{ importConciliacionForm.getConciliacionFile().getOriginalFilename(), verifiedOk });
					}

				}
				else
				{
					GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
							"conciliaciones.upload.messages.ws.fileConcilia.error", new Object[]
							{ fileConciliaResponse1.getMsjResp() });
				}
			}
			else
			{
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
						"conciliaciones.upload.messages.ws.fileConcilia.error.servicio", new Object[]
						{ " " });
			}
		}

		final Boolean bProcesado = true;
		model.addAttribute("procesado", bProcesado);


        return "redirect:/autorizados/entidades/reportarinfo";
    }
}

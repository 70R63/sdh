package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.pojos.requests.FileConciliaRequest;
import de.hybris.sdh.core.pojos.responses.FileConciliaResponse;
import de.hybris.sdh.core.services.SDHGestionBancaria;
import de.hybris.sdh.core.services.SDHValidateBankFiles;
import de.hybris.sdh.storefront.controllers.pages.forms.ImportConciliacionForm;
import de.hybris.sdh.storefront.controllers.pages.forms.ImportGestionBancariaForm;
import de.hybris.sdh.storefront.forms.PSEPaymentForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

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
                                  final RedirectAttributes redirectAttributes ) throws IOException
    {

        redirectAttributes.addFlashAttribute("importConciliacionForm", importConciliacionForm);

        LOG.info("File-reading");
        LOG.info("getConciliacionFile:" + importConciliacionForm.getConciliacionFile());
        LOG.info("getTipoArchivo" + importConciliacionForm.getTipoArchivo());

        final String pathFiles = configurationService.getConfiguration().getString("gestion.bancaria.certificados.aprobados.path");
        FileConciliaRequest fileConciliaRequest = new FileConciliaRequest(
                importConciliacionForm.getEntidadBancaria(),
                importConciliacionForm.getTipoArchivo(),
                importConciliacionForm.getConciliacionFile().getOriginalFilename().replaceAll(".zip.p7z",".txt"),
                "1",
                pathFiles);

        FileConciliaResponse fileConciliaResponse1 = sdhGestionBancaria.fileConcilia(fileConciliaRequest);

        if(Objects.nonNull(fileConciliaResponse1)){
            if(fileConciliaResponse1.getIdEnvio().equals("000")){
                boolean verifiedOk = sdhGestionBancaria.validade7ZipCertificates(importConciliacionForm.getConciliacionFile());
                LOG.info("verifiedOk Result: " + verifiedOk);
                if(verifiedOk){
                    fileConciliaRequest.setFlag("0");
                    FileConciliaResponse fileConciliaResponse2 = sdhGestionBancaria.fileConcilia(fileConciliaRequest);
                    GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                            "conciliaciones.upload.messages.ws.fileConcilia.success", new Object[]
                                    { fileConciliaResponse2.getMsjResp() });
                }else{
                    GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
                            "conciliaciones.upload.messages.error", new Object[]
                                    { importConciliacionForm.getConciliacionFile().getOriginalFilename() });
                }
            }else{
                GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
                        "conciliaciones.upload.messages.ws.fileConcilia.error", new Object[]
                                { fileConciliaResponse1.getMsjResp() });
            }
        }



        return "redirect:/autorizados/entidades/reportarinfo";
    }
}

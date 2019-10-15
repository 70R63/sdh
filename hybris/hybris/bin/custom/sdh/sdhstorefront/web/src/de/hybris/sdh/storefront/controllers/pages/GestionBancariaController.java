package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.storefront.forms.PSEPaymentForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

@Controller
@RequestMapping("/gestionBancaria")
public class GestionBancariaController extends AbstractPageController {
    private static final Logger LOG = Logger.getLogger(GestionBancariaController.class);
    private static final String CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE = "gestionBancariaFileUploadPage";
    private static final String BREADCRUMBS_ATTR = "breadcrumbs";

    @Resource(name = "accountBreadcrumbBuilder")
    private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    @RequireHardLogIn
    public String uploadFileGet(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException {
        storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE));
        model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs("Subir Archivo"));
        model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

        model.addAttribute("psePaymentForm", new PSEPaymentForm());
        return getViewForPage(model);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @RequireHardLogIn
    public String pagoEnLineaForm(final Model model, final PSEPaymentForm psePaymentForm) throws CMSItemNotFoundException
    {

        storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE));
        model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(CMS_SITE_PAGE_GESTION_BANCARIA_UPLFILE));
        model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

        model.addAttribute("psePaymentForm", psePaymentForm);
        return getViewForPage(model);
    }


}

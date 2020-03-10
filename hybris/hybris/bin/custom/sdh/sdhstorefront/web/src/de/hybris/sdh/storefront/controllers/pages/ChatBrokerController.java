package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@RequestMapping("/chat")
public class ChatBrokerController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(ChatBrokerController.class);

    private static final String CMS_SITE_PAGE_CHAT = "chatPage";
    private static final String TEXT_CHAT= "Chat Broker";
    private static final String BREADCRUMBS_ATTR = "breadcrumbs";

    @Resource(name = "accountBreadcrumbBuilder")
    private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customer(final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
    {
        storeCmsPageInModel(model, getContentPageForLabelOrId(CMS_SITE_PAGE_CHAT));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CMS_SITE_PAGE_CHAT));
        model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_CHAT));
        model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
        return getViewForPage(model);
    }

}

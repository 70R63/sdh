package de.hybris.sdh.storefront.controllers.rest;


import de.hybris.sdh.facades.SDHFAQsFacade;
import de.hybris.sdh.facades.faqs.data.SDHFaqData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/faqs")
public class SdhFAQsController {

    @Resource(name = "sdhFAQsFacade")
    SDHFAQsFacade sdhFAQsFacade;

    @RequestMapping("/getByCategory")
    public List<SDHFaqData> getFaqs(@RequestParam(value="code",
            defaultValue="") final String code){
        List<SDHFaqData> faqsData = sdhFAQsFacade.getAllFaqsByCategoryCode(code);
        return faqsData;
    }

    @RequestMapping("/getByKeyWord")
    public List<SDHFaqData> getByKeyWord(@RequestParam(value="keyWord", defaultValue="") final String keyWord){
        return sdhFAQsFacade.getAllFaqsByKeyWord(keyWord);
    }
}

package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.sdh.core.enums.SdhPaymentMethodTypeEnum;
import de.hybris.sdh.core.enums.SdhTaxTypesEnum;
import de.hybris.sdh.facades.online.payment.data.OnlinePaymentSelectInputBoxData;
import de.hybris.sdh.facades.online.payment.impl.DefaultSDHOnlinePaymentProviderMatcherFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/onlinePaymentMatcher")
public class SdhOnlinePaymentMatcherController {

    @Resource(name = "sdhOnlinePaymentProviderMatcherFacade")
    DefaultSDHOnlinePaymentProviderMatcherFacade sdhOnlinePaymentProviderMatcherFacade;


    @RequestMapping("/getBanks")
    public List<OnlinePaymentSelectInputBoxData> getBanks(@RequestParam(value="tax", defaultValue="") String tax,
                                                          @RequestParam(value="paymentMethod", defaultValue="") String paymentMethod) {
       return sdhOnlinePaymentProviderMatcherFacade.
               getBankList( SdhTaxTypesEnum.valueOf(tax),
                            SdhPaymentMethodTypeEnum.valueOf(paymentMethod));

    }
}

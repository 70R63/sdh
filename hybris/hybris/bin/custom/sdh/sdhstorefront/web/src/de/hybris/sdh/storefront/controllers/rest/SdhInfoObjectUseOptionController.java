package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.sdh.facades.online.payment.data.OnlinePaymentSelectInputBoxData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/infoObject")
public class SdhInfoObjectUseOptionController {



    @RequestMapping("/getUseOption")
	public Map<String, String> getBanks() {
		return null;
    }



}

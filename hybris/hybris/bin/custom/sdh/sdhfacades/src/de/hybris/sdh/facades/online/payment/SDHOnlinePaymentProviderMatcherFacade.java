package de.hybris.sdh.facades.online.payment;

import de.hybris.sdh.core.enums.SdhOnlinePaymentProviderEnum;
import de.hybris.sdh.core.enums.SdhPaymentMethodTypeEnum;
import de.hybris.sdh.core.enums.SdhTaxTypesEnum;
import de.hybris.sdh.facades.online.payment.data.OnlinePaymentSelectInputBoxData;

import java.util.List;

public interface SDHOnlinePaymentProviderMatcherFacade {
    SdhTaxTypesEnum getTaxByCode(String taxCode);
    List<OnlinePaymentSelectInputBoxData> getPaymentMethodList(SdhTaxTypesEnum taxType);
    List<OnlinePaymentSelectInputBoxData> getBankList(String taxCode, String paymentMethodCode);
    SdhOnlinePaymentProviderEnum getOnlinePaymentProvider(String taxCode, String paymentMethodCode, String bankCode);
}

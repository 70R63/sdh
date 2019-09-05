package de.hybris.sdh.core.services.impl;

import de.hybris.sdh.core.dao.impl.DefaultSDHPaymentProvTypeDao;
import de.hybris.sdh.core.enums.SdhOnlinePaymentProviderEnum;
import de.hybris.sdh.core.model.SDHPaymentProvTypeModel;
import de.hybris.sdh.core.services.SDHPaymentProvTypeService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class DefaultSDHPaymentProvTypeService implements SDHPaymentProvTypeService {

    @Resource(name = "sdhPaymentProvTypeDao")
    private DefaultSDHPaymentProvTypeDao sdhPaymentProvTypeDao;

    Map<String, Object> parameters;

    @Override
    public SDHPaymentProvTypeModel findUniqueByPaymentProvTypeCode(SdhOnlinePaymentProviderEnum paymentProvTypeCode) {
        parameters = new HashMap<String, Object>();
        parameters.put(SDHPaymentProvTypeModel.SDHPAYMENTPROVTYPE,paymentProvTypeCode);
        return sdhPaymentProvTypeDao.find(parameters).stream().findFirst().get();
    }
}

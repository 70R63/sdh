package de.hybris.sdh.core.services.impl;

import de.hybris.sdh.core.dao.impl.DefaultSDHPaymentMethodDao;
import de.hybris.sdh.core.enums.SdhPaymentMethodTypeEnum;
import de.hybris.sdh.core.model.SDHPaymentMethodModel;
import de.hybris.sdh.core.services.SDHPaymentMethodService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class DefaultSDHPaymentMethodService implements SDHPaymentMethodService {

    @Resource(name = "sdhPaymentMethodDao")
    private DefaultSDHPaymentMethodDao sdhPaymentMethodDao;

    Map<String, Object> parameters;

    @Override
    public SDHPaymentMethodModel findUniqueByPaymentMethodCodeString(String paymentMethodCode) {
        parameters = new HashMap<String, Object>();
        parameters.put(SDHPaymentMethodModel.CODE,paymentMethodCode);
        return sdhPaymentMethodDao.find(parameters).stream().findFirst().get();
    }

    @Override
    public SDHPaymentMethodModel findUniqueByPaymentMethodCode(SdhPaymentMethodTypeEnum paymentMethodCode) {
        parameters = new HashMap<String, Object>();
        parameters.put(SDHPaymentMethodModel.SDHPAYMENTMETHOD,paymentMethodCode);
        return sdhPaymentMethodDao.find(parameters).stream().findFirst().get();
    }
}

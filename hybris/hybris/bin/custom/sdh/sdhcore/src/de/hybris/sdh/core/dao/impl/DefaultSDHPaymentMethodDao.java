package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.model.SDHPaymentMethodModel;

public class DefaultSDHPaymentMethodDao extends DefaultGenericDao<SDHPaymentMethodModel> {

    public DefaultSDHPaymentMethodDao(String typecode) {
        super(typecode);
    }
}

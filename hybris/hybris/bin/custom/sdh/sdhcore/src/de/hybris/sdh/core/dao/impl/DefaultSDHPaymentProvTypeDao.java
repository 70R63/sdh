package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.model.SDHPaymentProvTypeModel;

public class DefaultSDHPaymentProvTypeDao extends DefaultGenericDao<SDHPaymentProvTypeModel> {
    public DefaultSDHPaymentProvTypeDao(String typecode) {
        super(typecode);
    }
}

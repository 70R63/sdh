package de.hybris.sdh.core.dao.impl;


import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.model.SDHTaxTypeModel;

public class DefaultSDHTaxTypeDao extends DefaultGenericDao<SDHTaxTypeModel> {

    public DefaultSDHTaxTypeDao(String typecode) {
        super(typecode);
    }

}

package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.dao.SdhFAQsDao;
import de.hybris.sdh.core.model.SdhFAQsCategoryModel;
import de.hybris.sdh.core.model.SdhFAQsModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultSdhFAQsDao extends DefaultGenericDao<SdhFAQsModel> implements SdhFAQsDao {

    public DefaultSdhFAQsDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<SdhFAQsModel> getAllByCategory(SdhFAQsCategoryModel categoryModel) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(SdhFAQsModel.CATEGORY,categoryModel);
        return super.find(parameters);
    }
}

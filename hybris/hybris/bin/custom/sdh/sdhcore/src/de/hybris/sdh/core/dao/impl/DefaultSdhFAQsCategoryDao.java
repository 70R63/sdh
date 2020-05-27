package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.dao.SdhFAQsCategoryDao;
import de.hybris.sdh.core.model.SdhFAQsCategoryModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultSdhFAQsCategoryDao extends DefaultGenericDao<SdhFAQsCategoryModel> implements SdhFAQsCategoryDao {

    public DefaultSdhFAQsCategoryDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<SdhFAQsCategoryModel> getAll() {
        return super.find();
    }

    @Override
    public SdhFAQsCategoryModel getByCode(String code) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(SdhFAQsCategoryModel.CODE,code);
        List<SdhFAQsCategoryModel> faqsCategories = super.find(parameters);
        return faqsCategories.size() <= 0 ? null :  faqsCategories.stream().findFirst().get();
    }
}

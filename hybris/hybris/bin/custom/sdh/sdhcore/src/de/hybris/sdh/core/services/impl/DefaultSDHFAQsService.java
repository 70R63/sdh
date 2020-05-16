package de.hybris.sdh.core.services.impl;

import de.hybris.sdh.core.dao.SdhFAQsCategoryDao;
import de.hybris.sdh.core.dao.SdhFAQsDao;
import de.hybris.sdh.core.model.SdhFAQsCategoryModel;
import de.hybris.sdh.core.model.SdhFAQsModel;
import de.hybris.sdh.core.services.SDHFAQsService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultSDHFAQsService implements SDHFAQsService {

    private SdhFAQsDao sdhFAQsDao;
    private SdhFAQsCategoryDao sdhFAQsCategoryDao;

    @Override
    public List<SdhFAQsCategoryModel> getAllCategories() {
        return getSdhFAQsCategoryDao().getAll();
    }

    @Override
    public SdhFAQsCategoryModel getCategoryByCode(String catecoryCode) {
        return getSdhFAQsCategoryDao().getByCode(catecoryCode);
    }

    @Override
    public List<SdhFAQsModel> getFAQsByCategory(SdhFAQsCategoryModel categoryModel) {
        return getSdhFAQsDao().getAllByCategory(categoryModel);
    }

    public SdhFAQsDao getSdhFAQsDao() {
        return sdhFAQsDao;
    }

    @Required
    public void setSdhFAQsDao(SdhFAQsDao sdhFAQsDao) {
        this.sdhFAQsDao = sdhFAQsDao;
    }

    public SdhFAQsCategoryDao getSdhFAQsCategoryDao() {
        return sdhFAQsCategoryDao;
    }

    @Required
    public void setSdhFAQsCategoryDao(SdhFAQsCategoryDao sdhFAQsCategoryDao) {
        this.sdhFAQsCategoryDao = sdhFAQsCategoryDao;
    }
}

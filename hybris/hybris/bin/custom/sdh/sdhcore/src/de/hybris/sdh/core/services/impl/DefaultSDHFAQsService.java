package de.hybris.sdh.core.services.impl;

import de.hybris.sdh.core.dao.SdhFAQsCategoryDao;
import de.hybris.sdh.core.dao.SdhFAQsDao;
import de.hybris.sdh.core.model.SdhFAQsCategoryModel;
import de.hybris.sdh.core.model.SdhFAQsModel;
import de.hybris.sdh.core.services.SDHFAQsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class DefaultSDHFAQsService implements SDHFAQsService {

    private SdhFAQsDao sdhFAQsDao;
    private SdhFAQsCategoryDao sdhFAQsCategoryDao;

    @Override
    public List<SdhFAQsCategoryModel> getAllCategories() {
        return getSdhFAQsCategoryDao().getAll();
    }

    @Override
    public SdhFAQsCategoryModel getCategoryByCode(final String catecoryCode) {
        return getSdhFAQsCategoryDao().getByCode(catecoryCode);
    }

    @Override
    public List<SdhFAQsModel> getFAQsByCategory(final SdhFAQsCategoryModel categoryModel) {
        return getSdhFAQsDao().getAllByCategory(categoryModel);
    }

    @Override
    public List<SdhFAQsModel> getFAQsByKeyWord(final String keyWord) {
        return getSdhFAQsDao().getAllByKeyWord(keyWord);
    }

    public SdhFAQsDao getSdhFAQsDao() {
        return sdhFAQsDao;
    }

    @Required
    public void setSdhFAQsDao(final SdhFAQsDao sdhFAQsDao) {
        this.sdhFAQsDao = sdhFAQsDao;
    }

    public SdhFAQsCategoryDao getSdhFAQsCategoryDao() {
        return sdhFAQsCategoryDao;
    }

    @Required
    public void setSdhFAQsCategoryDao(final SdhFAQsCategoryDao sdhFAQsCategoryDao) {
        this.sdhFAQsCategoryDao = sdhFAQsCategoryDao;
    }

	 @Override
	 public List<SdhFAQsModel> getFAQsByCode(final String code)
	 {
		 return getSdhFAQsDao().getAllByCode(code);
	 }
}

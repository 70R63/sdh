package de.hybris.sdh.core.services;

import de.hybris.sdh.core.model.SdhFAQsCategoryModel;
import de.hybris.sdh.core.model.SdhFAQsModel;

import java.util.List;

public interface SDHFAQsService {
    List<SdhFAQsCategoryModel> getAllCategories();
    SdhFAQsCategoryModel getCategoryByCode(String catecoryCode);
    List<SdhFAQsModel> getFAQsByCategory(SdhFAQsCategoryModel categoryModel);
    List<SdhFAQsModel> getFAQsByKeyWord(String keyWord);
}
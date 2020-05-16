package de.hybris.sdh.core.dao;

import de.hybris.sdh.core.model.SdhFAQsCategoryModel;
import de.hybris.sdh.core.model.SdhFAQsModel;

import java.util.List;

public interface SdhFAQsDao {
    List<SdhFAQsModel> getAllByCategory(SdhFAQsCategoryModel categoryModel);
}

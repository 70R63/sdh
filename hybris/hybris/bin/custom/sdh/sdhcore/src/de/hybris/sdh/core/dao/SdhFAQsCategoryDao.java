package de.hybris.sdh.core.dao;

import de.hybris.sdh.core.model.SdhFAQsCategoryModel;

import java.util.List;

public interface SdhFAQsCategoryDao {
    List<SdhFAQsCategoryModel> getAll();
    SdhFAQsCategoryModel getByCode(String code);
}

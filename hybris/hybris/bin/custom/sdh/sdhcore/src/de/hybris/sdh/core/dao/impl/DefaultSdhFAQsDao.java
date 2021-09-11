package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.dao.SdhFAQsDao;
import de.hybris.sdh.core.model.SdhFAQsCategoryModel;
import de.hybris.sdh.core.model.SdhFAQsModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultSdhFAQsDao extends DefaultGenericDao<SdhFAQsModel> implements SdhFAQsDao {

    public DefaultSdhFAQsDao(final String typecode) {
        super(typecode);
    }

    @Override
    public List<SdhFAQsModel> getAllByCategory(final SdhFAQsCategoryModel categoryModel) {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(SdhFAQsModel.CATEGORY,categoryModel);
        return super.find(parameters);
    }

    @Override
    public List<SdhFAQsModel> getAllByKeyWord(final String keyWord) {
        return super.find().stream().filter( sdhFAQsModel ->
                sdhFAQsModel.getCategory().getDescription().contains(keyWord) ||
                        sdhFAQsModel.getQuestion().contains(keyWord) ||
                            sdhFAQsModel.getAnswer().contains(keyWord)).collect(Collectors.toList());
    }

	 @Override
	 public List<SdhFAQsModel> getAllByCode(final String code)
	 {
		 final Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put(SdhFAQsModel.CODE, code);
		 return super.find(parameters);
	 }
}

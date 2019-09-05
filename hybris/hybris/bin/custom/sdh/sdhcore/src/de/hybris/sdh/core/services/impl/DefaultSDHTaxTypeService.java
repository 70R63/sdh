package de.hybris.sdh.core.services.impl;

import de.hybris.sdh.core.dao.impl.DefaultSDHTaxTypeDao;
import de.hybris.sdh.core.enums.SdhTaxTypesEnum;
import de.hybris.sdh.core.model.SDHTaxTypeModel;
import de.hybris.sdh.core.services.SDHTaxTypeService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class DefaultSDHTaxTypeService implements SDHTaxTypeService {

    @Resource(name = "sdhTaxTypeDao")
    private DefaultSDHTaxTypeDao sdhTaxTypeDao;

    Map<String, Object> parameters;

    @Override
    public SDHTaxTypeModel findUniqueByTaxCode(String taxCode) {
        parameters = new HashMap<String, Object>();
        parameters.put(SDHTaxTypeModel.CODE,taxCode);
        return sdhTaxTypeDao.find(parameters).stream().findFirst().get();
    }

    @Override
    public SDHTaxTypeModel findUniqueByTaxByType(SdhTaxTypesEnum taxType) {
        parameters = new HashMap<String, Object>();
        parameters.put(SDHTaxTypeModel.SDHTAXTYPE,taxType);
        return sdhTaxTypeDao.find(parameters).stream().findFirst().get();
    }
}

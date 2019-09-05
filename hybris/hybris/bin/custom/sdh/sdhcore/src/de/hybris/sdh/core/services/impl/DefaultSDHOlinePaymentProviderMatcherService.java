package de.hybris.sdh.core.services.impl;

import de.hybris.sdh.core.dao.impl.DefaultOlnPymntPvdMatcherDao;
import de.hybris.sdh.core.model.OlnPymntPvdMatcherModel;
import de.hybris.sdh.core.model.PseBankListCatalogModel;
import de.hybris.sdh.core.model.SDHPaymentMethodModel;
import de.hybris.sdh.core.model.SDHTaxTypeModel;
import de.hybris.sdh.core.services.SDHOlinePaymentProviderMatcherService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultSDHOlinePaymentProviderMatcherService implements SDHOlinePaymentProviderMatcherService {
    private static final Logger LOG = Logger.getLogger(DefaultSDHOlinePaymentProviderMatcherService.class);

    @Resource(name = "sdhOlinePaymentProviderMatcherDao")
    private DefaultOlnPymntPvdMatcherDao sdhOlinePaymentProviderMatcherDao;

    Map<String, Object> parameters;

    @Override
    public List<OlnPymntPvdMatcherModel> findByTaxType(SDHTaxTypeModel taxType) {
        parameters = new HashMap<String, Object>();
        parameters.put(OlnPymntPvdMatcherModel.TAXTYPE,taxType);
        LOG.info("FindByTaxType Parameter: " + parameters);
        return sdhOlinePaymentProviderMatcherDao.find(parameters);
    }

    @Override
    public List<OlnPymntPvdMatcherModel> findByTaxTypeAndPaymentMethod(SDHTaxTypeModel taxType, SDHPaymentMethodModel paymentMethod) {
        parameters = new HashMap<String, Object>();
        parameters.put(OlnPymntPvdMatcherModel.TAXTYPE,taxType);
        parameters.put(OlnPymntPvdMatcherModel.PAYMENTMETHOD,paymentMethod);
        LOG.info("FindByTaxTypeAndPaymentMethod Parameter: " + parameters);
        return sdhOlinePaymentProviderMatcherDao.find(parameters);
    }

    @Override
    public List<OlnPymntPvdMatcherModel> findByTaxTypeAndPaymentMethodAndBank(SDHTaxTypeModel taxType, SDHPaymentMethodModel paymentMethod, PseBankListCatalogModel bank) {
        parameters = new HashMap<String, Object>();
        parameters.put(OlnPymntPvdMatcherModel.TAXTYPE,taxType);
        parameters.put(OlnPymntPvdMatcherModel.PAYMENTMETHOD,paymentMethod);
        parameters.put(OlnPymntPvdMatcherModel.BANK,bank);
        LOG.info("FindByTaxTypeAndPaymentMethodAndBank Parameter: " + parameters);
        return sdhOlinePaymentProviderMatcherDao.find(parameters);
    }
}

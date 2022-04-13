package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.dao.SdhCustomerDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

public class DefaultSdhCustomerDao extends DefaultGenericDao<CustomerModel> implements SdhCustomerDao {

    private static final Logger LOG = Logger.getLogger(DefaultSdhCustomerDao.class);
    private Map<String, Object> parameters;

    public DefaultSdhCustomerDao(final String typecode) { super(typecode); }

    @Override
    public Optional<CustomerModel> findByBp(final String bp) {
        parameters = new HashMap<String, Object>();
        parameters.put(CustomerModel.NUMBP, bp);
        LOG.info("FindCustomerByBp Parameter: " + parameters);
        return super.find(parameters).stream().findFirst();
    }

    @Override
    public Optional<CustomerModel> findByUid(final String uid) {
        parameters = new HashMap<String, Object>();
        parameters.put(CustomerModel.UID, uid);
        LOG.info("FindCustomerByUid Parameter: " + parameters);
        return super.find(parameters).stream().findFirst();
    }

	 @Override
	 public Optional<CustomerModel> findByDocTypeNumDoc(final String docType, final String numDoc)
	 {
		 parameters = new HashMap<String, Object>();
		 parameters.put(CustomerModel.DOCUMENTTYPE, docType);
		 parameters.put(CustomerModel.DOCUMENTNUMBER, numDoc);
		 LOG.info("FindCustomerByUid Parameter: " + parameters);
		 return super.find(parameters).stream().findFirst();
	 }
}

package de.hybris.sdh.core.dao;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Optional;

public interface SdhCustomerDao {
    Optional<CustomerModel> findByBp(String bp);
}

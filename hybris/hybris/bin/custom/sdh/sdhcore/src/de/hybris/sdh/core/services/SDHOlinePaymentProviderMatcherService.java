/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.enums.SdhOnlinePaymentProviderEnum;
import de.hybris.sdh.core.model.*;

import java.util.List;


/**
 * @author hybris
 *
 */
public interface SDHOlinePaymentProviderMatcherService
{
    List<OlnPymntPvdMatcherModel> findByTaxType(SDHTaxTypeModel taxType);
    List<OlnPymntPvdMatcherModel> findByTaxTypeAndPaymentMethod(SDHTaxTypeModel taxType,SDHPaymentMethodModel paymentMethod);
    List<OlnPymntPvdMatcherModel> findByTaxTypeAndPaymentMethodAndBank(SDHTaxTypeModel taxType,SDHPaymentMethodModel paymentMethod,PseBankListCatalogModel bank);
}

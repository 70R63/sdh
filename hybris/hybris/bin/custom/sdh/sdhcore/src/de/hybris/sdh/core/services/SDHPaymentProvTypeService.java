/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.enums.SdhOnlinePaymentProviderEnum;
import de.hybris.sdh.core.model.SDHPaymentProvTypeModel;


/**
 * @author hybris
 *
 */
public interface SDHPaymentProvTypeService
{
    SDHPaymentProvTypeModel findUniqueByPaymentProvTypeCode(SdhOnlinePaymentProviderEnum paymentProvTypeCode);
}

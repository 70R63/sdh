/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.enums.SdhPaymentMethodTypeEnum;
import de.hybris.sdh.core.model.SDHPaymentMethodModel;

/**
 * @author hybris
 *
 */
public interface SDHPaymentMethodService
{
    public SDHPaymentMethodModel findUniqueByPaymentMethodCodeString(String paymentMethodCode)   ;
    SDHPaymentMethodModel findUniqueByPaymentMethodCode(SdhPaymentMethodTypeEnum paymentMethodCode);
}

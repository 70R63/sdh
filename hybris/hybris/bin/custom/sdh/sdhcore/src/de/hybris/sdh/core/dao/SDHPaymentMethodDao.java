/**
 *
 */
package de.hybris.sdh.core.dao;

import de.hybris.sdh.core.model.SDHPaymentMethodModel;


/**
 * @author Praxis
 *
 */
public interface SDHPaymentMethodDao
{
	public SDHPaymentMethodModel getBySDHPaymentMethodCode(final String sdhPaymentMethodCode);
}

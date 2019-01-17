/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;


/**
 * @author hybris
 *
 */
public interface SDHCustomerAccountService
{
	void activateAccount(final String token) throws TokenInvalidatedException;

	boolean isUserRegistered(String documentNumber, String documentType);
}

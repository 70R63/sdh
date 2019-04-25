/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;


/**
 * @author hybris
 *
 */
public interface SDHCustomerFacade
{
	void activateAccount(final String token) throws TokenInvalidatedException;

	boolean isUserRegistered(String documentNumber, String documentType);

	void updateMiRitInfo();

	boolean isValidRoleForCurrentCustomer(String role);

}

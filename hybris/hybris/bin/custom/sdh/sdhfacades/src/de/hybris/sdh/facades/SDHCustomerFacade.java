/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;


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

	CustomerData getRepresentado(String numBP);

	SDHValidaMailRolResponse getRepresentadoFromSAP(String numBP);

	CustomerData getRepresentadoDataFromSAP(String numBP);

	void updateCustomerTaxRestrictions();

}

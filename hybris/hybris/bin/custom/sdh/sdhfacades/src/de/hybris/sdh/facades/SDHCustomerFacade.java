/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;


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

	CustomerModel getCustomerFor(String numBP);

	SDHValidaMailRolResponse getRepresentadoFromSAP(String numBP);

	SDHValidaMailRolResponse getRepresentadoFromSAP(String numBP, String indicador);

	SDHValidaMailRolResponse getRepresentadoFromSAP_impuestos(String numBP, List<String> impuestos);

	CustomerData getRepresentadoDataFromSAP(String numBP);

	CustomerData getRepresentadoDataFromSAP(String numBP, String indicador);

	CustomerData getRepresentadoDataFromSession();

	void updateCustomerTaxRestrictions();

	SDHValidaMailRolResponse getRepresentado_gas_show(String numBP);

}

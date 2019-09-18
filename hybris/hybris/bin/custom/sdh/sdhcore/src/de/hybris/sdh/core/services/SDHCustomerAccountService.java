/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.sdh.core.pojos.requests.UpdateEmailRitRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;


/**
 * @author hybris
 *
 */
public interface SDHCustomerAccountService
{
	void activateAccount(final String token) throws TokenInvalidatedException;
	boolean isUserRegistered(String documentNumber, String documentType);
	String generateCustomerSessionToken(String bp);
	boolean validateToken(String token, String uidUser);

	String updateEmailRit(UpdateEmailRitRequest request);

	String updateAutorizacionesRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateRedesSocialesRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateTelefonoRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateAddressRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateNameRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateRols(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateBasicData(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	void updateMiRitInfo();

	CustomerModel updateMiRitInfo(CustomerModel customerModel);

	void setAutorityOnSession(String role);

	void cleanSessionAutorities();

	void updateCustomerTaxRestrictions();
}

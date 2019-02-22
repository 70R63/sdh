/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.UpdateAddressRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateAutorizacionesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateEmailRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateNameRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRedesSocialesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateTelefonoRitRequest;

/**
 * @author hybris
 *
 */
public interface SDHUpdateRitService
{
	String updateRit(UpdateRitRequest request);

	String updateEmailRit(UpdateEmailRitRequest request);

	String updateAutorizacionesRit(UpdateAutorizacionesRitRequest request);

	String updateRedesSocialesRit(UpdateRedesSocialesRitRequest request);

	String updateTelefonoRit(UpdateTelefonoRitRequest request);

	String updateAddressRit(UpdateAddressRitRequest request);

	String updateNameRit(UpdateNameRitRequest request);
}

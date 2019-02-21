/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.UpdateAutorizacionesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateEmailRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRedesSocialesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRitRequest;

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
}

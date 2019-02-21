/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.UpdateAutorizacionesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateEmailRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRedesSocialesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRitRequest;
import de.hybris.sdh.core.pojos.responses.UpdateRitResponse;

/**
 * @author hybris
 *
 */
public interface SDHUpdateRitFacade
{
	UpdateRitResponse updateRit(UpdateRitRequest request);

	UpdateRitResponse updateEmailRit(UpdateEmailRitRequest request);

	UpdateRitResponse updateAutorizacionesRit(UpdateAutorizacionesRitRequest request);

	UpdateRitResponse updateRedesSocialesRit(UpdateRedesSocialesRitRequest request);
}

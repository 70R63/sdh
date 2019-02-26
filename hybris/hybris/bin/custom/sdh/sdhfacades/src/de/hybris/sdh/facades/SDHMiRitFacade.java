/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.UpdateRitRequest;
import de.hybris.sdh.core.pojos.responses.UpdateRitResponse;

/**
 * @author hybris
 *
 */
public interface SDHMiRitFacade
{
	UpdateRitResponse updateRit(UpdateRitRequest request);
}

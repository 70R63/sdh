/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.ConsultarBPRequest;
import de.hybris.sdh.core.pojos.responses.ConsultarBPResponse;


/**
 * @author hybris
 *
 */
public interface SDHValidaContribuyenteFacade
{
	boolean existeContribuyente(ConsultarBPRequest request);

	ConsultarBPResponse existeContribuyente_object(final ConsultarBPRequest request);
}

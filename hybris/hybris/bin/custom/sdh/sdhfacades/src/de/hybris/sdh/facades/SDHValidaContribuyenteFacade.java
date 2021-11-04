/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.ConsultarBPRequest;


/**
 * @author hybris
 *
 */
public interface SDHValidaContribuyenteFacade
{
	boolean existeContribuyente(ConsultarBPRequest request);
}

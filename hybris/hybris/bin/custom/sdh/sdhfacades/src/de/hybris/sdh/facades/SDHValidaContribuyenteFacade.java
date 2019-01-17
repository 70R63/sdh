/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;


/**
 * @author hybris
 *
 */
public interface SDHValidaContribuyenteFacade
{
	boolean existeContribuyente(ValidaContribuyenteRequest request);
}

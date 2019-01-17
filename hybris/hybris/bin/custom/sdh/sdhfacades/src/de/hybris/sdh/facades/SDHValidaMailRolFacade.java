/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.ValidaMailRolRequest;


/**
 * @author hybris
 *
 */
public interface SDHValidaMailRolFacade
{
	boolean validaEmail(ValidaMailRolRequest request);
}

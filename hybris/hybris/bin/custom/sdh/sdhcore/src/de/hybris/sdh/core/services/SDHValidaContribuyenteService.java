/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

/**
 * @author hybris
 *
 */
public interface SDHValidaContribuyenteService
{
	String validaContribuyente(ValidaContribuyenteRequest request);

	SDHValidaMailRolResponse validaContribuyente(String stringBp);
}

/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;


/**
 * @author hybris
 *
 */
public interface SDHValidaContribuyenteService
{
	String validaContribuyente(ValidaContribuyenteRequest request);

	SDHValidaMailRolResponse validaContribuyente(String stringBp);

	List<ImpuestoPublicidadExterior> getpublicidadExtListByBpAndYear(String stringBp, String stringYear);
}

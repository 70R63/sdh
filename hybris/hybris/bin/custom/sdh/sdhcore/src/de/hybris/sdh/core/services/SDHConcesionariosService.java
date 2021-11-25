/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ConcesionariosRequest;
import de.hybris.sdh.core.pojos.responses.ConcesionariosResponse;


/**
 * @author Maria Luisa
 *
 */
public interface SDHConcesionariosService
{
	String concesionarios(ConcesionariosRequest request);

	ConcesionariosResponse concesionario(ConcesionariosRequest request);
}

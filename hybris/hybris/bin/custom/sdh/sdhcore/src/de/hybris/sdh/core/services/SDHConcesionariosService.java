/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ConcesionariosRequest;


/**
 * @author Maria Luisa
 *
 */
public interface SDHConcesionariosService
{
	String concesionarios(ConcesionariosRequest request);

	//ConcesionariosResponse concesionario(ConcesionariosRequest request);
}

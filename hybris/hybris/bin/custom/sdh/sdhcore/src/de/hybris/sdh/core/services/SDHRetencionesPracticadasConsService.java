/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.RetencionesPracticadasConsRequest;
import de.hybris.sdh.core.pojos.requests.RetencionesPracticadasReporteRequest;


/**
 * @author Maria Torres
 *
 */
public interface SDHRetencionesPracticadasConsService
{
	String retencionesPracticadasRequest(RetencionesPracticadasConsRequest request);

	String retencionesPracticadasReporteRequest(RetencionesPracticadasReporteRequest request);
}

/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.LogReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaAvisoArchivoRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaRequest;


/**
 * @author hybris
 *
 */
public interface SDHReteIcaService
{
	String reteICA(ReteIcaRequest request);

	String calculo(CalculoReteIcaRequest request);

	String logReteICA(LogReteIcaRequest request);

	Boolean avisoArchivo(ReteIcaAvisoArchivoRequest request);
}

/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;


/**
 * @author Consultor
 *
 */
public interface SDHICAInfObjetoService
{
	String consultaICAInfObjeto(ICAInfObjetoRequest request);

	//
	ICAInfObjetoResponse consultaICAInfObjetoReturningObject(ICAInfObjetoRequest requestObject);

}

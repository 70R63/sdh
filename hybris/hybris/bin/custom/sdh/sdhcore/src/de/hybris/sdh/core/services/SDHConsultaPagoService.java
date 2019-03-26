/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ConsultaPagoRequest;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoDeclaraciones;

import java.util.List;


/**
 * @author Consultor
 *
 */
public interface SDHConsultaPagoService
{
	String consultaPago(ConsultaPagoRequest request);

	List<ConsultaPagoDeclaraciones> consultaPago(String numBP, String numObjeto, String clavePeriodo);
}

/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;

import java.util.List;

/**
 * @author hybris
 *
 */
public interface SDHConsultaImpuesto_simplificado
{

	List<ImpuestoVehiculos> consulta_impVehicular(ConsultaContribuyenteBPRequest request);

	String consulta_impVehicular_string(ConsultaContribuyenteBPRequest request);

	/**
	 * @param request
	 * @return
	 */
	String consulta_impGasolina_string(ConsultaContribuyenteBPRequest request);
}

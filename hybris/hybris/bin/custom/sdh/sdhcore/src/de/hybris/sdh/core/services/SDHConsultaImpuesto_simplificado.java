/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;

import java.util.List;

/**
 * @author hybris
 *
 */
public interface SDHConsultaImpuesto_simplificado
{

	//Predial
	List<PredialResponse> consulta_impPredial(ConsultaContribuyenteBPRequest request);

	String consulta_impPredial_string(ConsultaContribuyenteBPRequest request);


	//Vehicular
	List<ImpuestoVehiculos> consulta_impVehicular(ConsultaContribuyenteBPRequest request);

	String consulta_impVehicular_string(ConsultaContribuyenteBPRequest request);


	//ICA
	List<ImpuestoVehiculos> consulta_impICA(ConsultaContribuyenteBPRequest request);

	String consulta_impICA_string(ConsultaContribuyenteBPRequest request);


	//Gasolina
	List<ImpuestoGasolina> consulta_impGasolina(ConsultaContribuyenteBPRequest request);

	String consulta_impGasolina_string(ConsultaContribuyenteBPRequest request);


	//Delineacion
	List<ImpuestoDelineacionUrbana> consulta_impDelineacion(ConsultaContribuyenteBPRequest request);

	String consulta_impDelineacion_string(ConsultaContribuyenteBPRequest request);


	//Publicidad
	List<ImpuestoPublicidadExterior> consulta_impPublicidad(ConsultaContribuyenteBPRequest request);

	String consulta_impPublicidad_string(ConsultaContribuyenteBPRequest request);







}

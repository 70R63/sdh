/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.pojos.requests.ConsultaContribPredialRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoICA;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;
import java.util.Map;

/**
 * @author hybris
 *
 */
public interface SDHConsultaImpuesto_simplificado
{
	public static final String predial = "0001";
	public static final String vehiculos = "0002";
	public static final String ica = "0003";
	public static final String reteica = "0004";
	public static final String gasolina = "0005";
	public static final String delineacion = "0006";
	public static final String publicidad = "0007";

	//Predial
	List<PredialResponse> consulta_impPredial(ConsultaContribuyenteBPRequest request);

	String consulta_impPredial_string(ConsultaContribuyenteBPRequest request);

	List<PredialResponse> consulta_impPredial2(ConsultaContribPredialRequest request);

	String consulta_impPredial2_string(ConsultaContribPredialRequest request);



	//Vehicular
	List<ImpuestoVehiculos> consulta_impVehicular(ConsultaContribuyenteBPRequest request);

	String consulta_impVehicular_string(ConsultaContribuyenteBPRequest request);


	//ICA
	ImpuestoICA consulta_impICA(ConsultaContribuyenteBPRequest request);

	String consulta_impICA_string(ConsultaContribuyenteBPRequest request);


	//Gasolina
	List<ImpuestoGasolina> consulta_impGasolina(ConsultaContribuyenteBPRequest request);

	String consulta_impGasolina_string(ConsultaContribuyenteBPRequest request);


	//Delineacion
	List<ImpuestoDelineacionUrbana> consulta_impDelineacion(ConsultaContribuyenteBPRequest request);

	SDHValidaMailRolResponse consulta_impDelineacion_valCont(ConsultaContribuyenteBPRequest request);
	String consulta_impDelineacion_string(ConsultaContribuyenteBPRequest request);


	//Publicidad
	List<ImpuestoPublicidadExterior> consulta_impPublicidad(ConsultaContribuyenteBPRequest request);

	String consulta_impPublicidad_string(ConsultaContribuyenteBPRequest request);

	Map<String, String> obtenerListaImpuestosActivos();





}

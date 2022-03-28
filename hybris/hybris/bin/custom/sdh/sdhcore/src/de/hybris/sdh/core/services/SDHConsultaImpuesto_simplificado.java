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
import de.hybris.sdh.core.pojos.responses.ReteICA;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;
import java.util.Map;

/**
 * @author hybris
 *
 */
public interface SDHConsultaImpuesto_simplificado
{
	public static final String PREDIAL = "0001";
	public static final String VEHICULOS = "0002";
	public static final String ICA = "0003";
	public static final String RETEICA = "0004";
	public static final String GASOLINA = "0005";
	public static final String DELINEACION = "0006";
	public static final String PUBLICIDAD = "0007";

	public static final String AMBITO_CONSULTAS = "consultas";
	public static final String AMBITO_IMPUESTOS = "impuestos";
	public static final String AMBITO_CONSULTASAR = "consultasAR";
	public static final String AMBITO_FACTURACION = "facturacion";
	public static final String AMBITO_PRESENTARDECLARACION = "presentarDeclaracion";
	public static final String AMBITO_MIRIT = "mirit";
	public static final String AMBITO_FIRMASAGENTE = "firmasAgente";
	public static final String AMBITO_FIRMASCONTRIBUYENTE = "firmasContribuyente";

	//Predial
	List<PredialResponse> consulta_impPredial(ConsultaContribuyenteBPRequest request);

	String consulta_impPredial_string(Object request);

	List<PredialResponse> consulta_impPredial2(ConsultaContribPredialRequest request);


	//Vehicular
	List<ImpuestoVehiculos> consulta_impVehicular(ConsultaContribuyenteBPRequest request);

	String consulta_impVehicular_string(Object request);

	List<ImpuestoVehiculos> consulta_impVehicular2(ConsultaContribPredialRequest request);


	//ICA
	ImpuestoICA consulta_impICA(ConsultaContribuyenteBPRequest request);

	String consulta_impICA_string(ConsultaContribuyenteBPRequest request);
	

    //reteICA
    ReteICA consulta_impReteICA(ConsultaContribuyenteBPRequest request);

    String consulta_impReteICA_string(ConsultaContribuyenteBPRequest request);



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


	//Manejo de impuestos activos
	Map<String, String> obtenerListaImpuestosActivos(String ambito);

	boolean esImpuestoActivo(Map<String, String> impuestosActivos, String claveImpuesto);



}

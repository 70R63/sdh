/**
 *
 */
package de.hybris.sdh.core.services;

import java.util.Map;


/**
 * @author hybris
 *
 */
public interface SDHConfigCatalogos
{

	public static final String facturacion_anioBase = "configCatalogos.anioBase.facturacion";
	public static final String facturacion_cantidadAnios = "configCatalogos.cantidadAnios.facturacion";
	public static final String facturacion_cantidadAniosCorrimiento = "configCatalogos.cantidadAniosCorrimiento.facturacion";
	public static final String facturacion_valSeleccionar = "configCatalogos.valSeleccionar.facturacion";

	public static final String sobretasagasolina_anioBase = "configCatalogos.anioBase.sobretasagasolina";
	public static final String sobretasagasolina_cantidadAnios = "configCatalogos.cantidadAnios.sobretasagasolina";
	public static final String sobretasagasolina_cantidadAniosCorrimiento = "configCatalogos.cantidadAniosCorrimiento.sobretasagasolina";
	public static final String sobretasagasolina_valSeleccionar = "configCatalogos.valSeleccionar.sobretasagasolina";


	Map<String, String> obtenerListaAnioGravable_generica(final int anioBase, final int cantidadAnios, String valSeleccionar);

	Map<String, String> obtenerListaAnioGravable_facturacion();

	Map<String, String> obtenerListaAnioGravable_sobretasagasolina();

}

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

	public static final String facturacion_anioBase = "configCatalogos.facturacion_anioBase";
	public static final String facturacion_cantidadAnios = "configCatalogos.facturacion_cantidadAnios";
	public static final String facturacion_cantidadAniosCorrimiento = "configCatalogos.facturacion_cantidadAniosCorrimiento";
	public static final String facturacion_valSeleccionar = "configCatalogos.facturacion_valSeleccionar";

	public static final String sobretasagasolina_anioBase = "configCatalogos.sobretasagasolina_anioBase";
	public static final String sobretasagasolina_cantidadAnios = "configCatalogos.sobretasagasolina_cantidadAnios";
	public static final String sobretasagasolina_cantidadAniosCorrimiento = "configCatalogos.sobretasagasolina_cantidadAniosCorrimiento";
	public static final String sobretasagasolina_valSeleccionar = "configCatalogos.sobretasagasolina_valSeleccionar";


	Map<String, String> obtenerListaAnioGravable_generica(final int anioBase, final int cantidadAnios, String valSeleccionar);

	Map<String, String> obtenerListaAnioGravable_facturacion();

	Map<String, String> obtenerListaAnioGravable_sobretasagasolina();

}

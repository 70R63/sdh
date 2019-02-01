/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.sdh.storefront.forms.PublicidadExteriorCatalogos;

import java.util.HashMap;
import java.util.Map;


/**
 * @author usuario
 *
 */
//dev-federico crear clase con el metodo
public class PublicidadExteriorServicios
{

	public PublicidadExteriorCatalogos prepararCatalogos()
	{
		final PublicidadExteriorCatalogos catalogos = new PublicidadExteriorCatalogos();

		catalogos.setOpcionesUso(prepararOpcionesUso());
		catalogos.setLuginst(prepararLugarInstalacion());
		catalogos.setBasegrav(prepararBaseGravable());
		catalogos.setOrientacionValla(prepararOrientacionValla());


		return catalogos;
	}

	/**
	 * @return
	 */
	private Map<String, String> prepararOrientacionValla()
	{
		final Map<String, String> elementos = new HashMap<String, String>();

		elementos.put("00", "Oriente/Occidente");
		elementos.put("01", "Occidente/Oriente");
		elementos.put("02", "Norte/Sur");
		elementos.put("03", "Sur/Norte");
		elementos.put("04", "Derecha");
		elementos.put("05", "Izquierda");
		elementos.put("06", "Ambos sentidos");

		return elementos;
	}

	/**
	 * @return
	 */
	private Map<String, String> prepararBaseGravable()
	{

		final Map<String, String> elementos = new HashMap<String, String>();

		elementos.put("01", "Vallas de más de 8 m2 hasta 24 m2");
		elementos.put("02", "Vallas de más de 24 m2");
		elementos.put("03", "Vallas de propiedad de contructuras de más de 8 m2");
		elementos.put("03", "Valla en vehículos automotores de más de 8 m2");

		return elementos;
	}

	/**
	 * @return
	 */
	private Map<String, String> prepararLugarInstalacion()
	{
		final Map<String, String> elementos = new HashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "Predio");
		elementos.put("02", "Vehículo");

		return elementos;
	}

	/**
	 * @return
	 */
	private Map<String, String> prepararOpcionesUso()
	{

		final Map<String, String> elementos = new HashMap<String, String>();

		elementos.put("00", "Seleccionar");
		elementos.put("01", "Declaración");
		elementos.put("02", "Corrección");

		return elementos;
	}


}

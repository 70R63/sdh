/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.util.Config;
import de.hybris.sdh.core.services.SDHConfigCatalogos;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


/**
 * @author hybris
 *
 */
public class DefaultSDHConfigCatalogos implements SDHConfigCatalogos
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHConfigCatalogos.class);


	@Override
	public Map<String, String> obtenerListaAnioGravable_generica(final int anioBase, final int cantidadAnios,
			final String valSeleccionar)
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();

		elementos.put(valSeleccionar, "SELECCIONAR");
		for (int i = 0; i < cantidadAnios; i++)
		{
			elementos.put(Integer.toString(anioBase - i), Integer.toString(anioBase - i));
		}

		return elementos;
	}


	private Map<String, String> obtenerListaAnioGravable(final String config_anioBase, final String config_cantidadAnios,
			final String config_cantidadAniosCorrimiento, final String config_valSeleccionar)
	{
		Map<String, String> elementos = null;
		int anioBase = 0;
		int cantidadAnios = 0;
		int cantidadAniosCorrimiento = 0;
		String valSeleccionar = "";


		final String anioBase_str = Config.getParameter(config_anioBase);
		final String cantidadAniosCorrimiento_str = Config.getParameter(config_cantidadAniosCorrimiento);

		try {
			cantidadAnios = Integer.parseInt(Config.getParameter(config_cantidadAnios));
			valSeleccionar = Config.getParameter(config_valSeleccionar);

			if (StringUtils.isNotEmpty(anioBase_str))
			{
				anioBase = Integer.parseInt(anioBase_str);
			}
			else
			{
				final LocalDate current_date = LocalDate.now();
				anioBase = current_date.getYear();
			}

			if (StringUtils.isNotEmpty(cantidadAniosCorrimiento_str))
			{
				cantidadAniosCorrimiento = Integer.parseInt(cantidadAniosCorrimiento_str);
			}

		}catch (final NumberFormatException e) {
			LOG.error("Error al determinar valores para el catalogo de años gravables");
		}


		if(anioBase > 0 && cantidadAnios > 0) {
			elementos = obtenerListaAnioGravable_generica(anioBase, cantidadAnios, valSeleccionar);
		}


		return elementos;
	}


	@Override
	public Map<String, String> obtenerListaAnioGravable_facturacion()
	{
		return obtenerListaAnioGravable(facturacion_anioBase, facturacion_cantidadAnios, facturacion_cantidadAniosCorrimiento,
				facturacion_valSeleccionar);
	}


	@Override
	public Map<String, String> obtenerListaAnioGravable_sobretasagasolina()
	{
		return obtenerListaAnioGravable(sobretasagasolina_anioBase, sobretasagasolina_cantidadAnios,
				sobretasagasolina_cantidadAniosCorrimiento, sobretasagasolina_valSeleccionar);
	}


}

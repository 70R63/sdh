/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ConsultaGasolinaRequest;


/**
 * @author hybris
 *
 */
public interface SDHDetalleGasolina
{
	String consultaWS(ConsultaGasolinaRequest request, String confUrl, String confUser, String confPassword,
			String wsNombre, String wsRequestMethod);
}

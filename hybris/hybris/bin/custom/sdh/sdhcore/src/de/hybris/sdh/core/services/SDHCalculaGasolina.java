/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.CalculaGasolinaRequest;


/**
 * @author hybris
 *
 */
public interface SDHCalculaGasolina
{
	String consultaWS(CalculaGasolinaRequest request, String confUrl, String confUser, String confPassword,
			String wsNombre, String wsRequestMethod);
}

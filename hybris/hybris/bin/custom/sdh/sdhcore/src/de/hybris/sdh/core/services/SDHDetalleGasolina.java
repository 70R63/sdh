/**
 *
 */
package de.hybris.sdh.core.services;

/**
 * @author hybris
 *
 */
public interface SDHDetalleGasolina
{
	String consultaWS(Object request, String confUrl, String confUser, String confPassword,
			String wsNombre, String wsRequestMethod);
}

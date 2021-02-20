/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.PseNotificacionDePagoRequest;

/**
 * @author edson.roa
 *
 */
public interface SDHNotificacionPagoService
{
	public void realizarNotificacion(PseNotificacionDePagoRequest pseNotificacionDePagoRequest);

	public void notifyAllTransactionWithStatusOkAndNotNotifiedBefore();

	public void notifyTransactionWithStatusOkAndNotNotified(String numeroDeReferencia);
}

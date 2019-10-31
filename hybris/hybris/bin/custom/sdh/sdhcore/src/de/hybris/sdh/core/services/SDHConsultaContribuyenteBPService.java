/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;

/**
 * @author hybris
 *
 */
public interface SDHConsultaContribuyenteBPService
{
	String consultaContribuyenteBP(ConsultaContribuyenteBPRequest request);
	String getEntidadBancaria(String bp);
}

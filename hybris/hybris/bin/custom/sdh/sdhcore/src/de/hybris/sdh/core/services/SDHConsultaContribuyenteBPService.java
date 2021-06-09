/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

/**
 * @author hybris
 *
 */
public interface SDHConsultaContribuyenteBPService
{
	String consultaContribuyenteBP(ConsultaContribuyenteBPRequest request);

	SDHValidaMailRolResponse consultaContribuyenteBP_simplificado(ConsultaContribuyenteBPRequest request);

	String consultaContribuyenteBP_simplificado_string(ConsultaContribuyenteBPRequest request);

	SDHValidaMailRolResponse mapearInfo(CustomerModel customerModel);
	String getEntidadBancaria(String bp);
}

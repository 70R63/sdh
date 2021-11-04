/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ConsultarBPRequest;
import de.hybris.sdh.core.pojos.requests.SdhValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbanaWithRadicados;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.RadicaDelinResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;


/**
 * @author hybris
 *
 */
public interface SDHValidaContribuyenteService
{
	String validaContribuyente(ValidaContribuyenteRequest request);

	String consultarBP(ConsultarBPRequest request);

	SDHValidaMailRolResponse validaContribuyente (SdhValidaContribuyenteRequest request) throws Exception;

	SDHValidaMailRolResponse validaContribuyente(String stringBp);

	List<ImpuestoPublicidadExterior> getpublicidadExtListByBpAndYear(String stringBp, String stringYear);

	List<ImpuestoDelineacionUrbana> getDelineacionListByBpAndYear(String stringBp, String stringYear);

	List<ImpuestoDelineacionUrbanaWithRadicados> getDelineacionListByBpAndYearWithRadicados(String stringBp, String stringYear);

	RadicaDelinResponse getRadicadosDelineacion(String numBp, String cdu);
}

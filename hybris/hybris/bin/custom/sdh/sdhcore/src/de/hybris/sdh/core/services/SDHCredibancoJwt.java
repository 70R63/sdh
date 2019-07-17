/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.credibanco.InititalizeTransactionRequest;
import de.hybris.sdh.core.credibanco.InititalizeTransactionResponse;

import java.util.Date;


/**
 * @author edson.roa
 *
 */
public interface SDHCredibancoJwt
{
	public String getTransactionToken(InititalizeTransactionRequest request, String iss, Date iat, String sub);

	public InititalizeTransactionResponse inititalizeTransaction(InititalizeTransactionRequest request);
}

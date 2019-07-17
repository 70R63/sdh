/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.credibanco.InititalizeTransactionRequest;
import de.hybris.sdh.core.credibanco.InititalizeTransactionResponse;

import java.io.IOException;


/**
 * @author edson.roa
 *
 */
public interface SDHCredibancoJwt
{
	public String getTransactionToken(InititalizeTransactionRequest request, String iss, String iat, String sub)
			throws IOException;
	public InititalizeTransactionResponse inititalizeTransaction(InititalizeTransactionRequest request);
}

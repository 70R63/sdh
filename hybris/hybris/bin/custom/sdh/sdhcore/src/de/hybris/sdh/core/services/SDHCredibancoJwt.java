/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.credibanco.InititalizeTransactionRequest;
import de.hybris.sdh.core.credibanco.InititalizeTransactionResponse;
import de.hybris.sdh.core.credibanco.ResultTransactionRequest;
import de.hybris.sdh.core.credibanco.ResultTransactionResponse;

import java.util.Date;


/**
 * @author edson.roa
 *
 */
public interface SDHCredibancoJwt
{
	public String getTransactionToken(Object request, String iss, Date iat, String sub);

	public InititalizeTransactionResponse inititalizeTransaction(InititalizeTransactionRequest request);

	public ResultTransactionResponse resultTransaction(ResultTransactionRequest request);
}

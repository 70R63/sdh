/**
 *
 */
package de.hybris.sdh.core.dao;

import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.sdh.core.model.PseTransactionsLogModel;


/**
 * @author edson.roa
 *
 */
public interface PseTransactionsLogDao
{

	public SearchResult<PseTransactionsLogModel> getAllOutstandingTransactions(String transactionState);

	public PseTransactionsLogModel getTransaction(String numeroDeReferencia);

	public SearchResult<PseTransactionsLogModel> getAllTransactionsNotNotifiedPaymentAndStatusOk(String transactionStateStatus,
			String notificacionRecaudoStatus);
}

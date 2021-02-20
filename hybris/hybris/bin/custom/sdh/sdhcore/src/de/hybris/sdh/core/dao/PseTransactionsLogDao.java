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

	public String getTransactionState(String impuesto, String anogravable, String periodo, String tipoDeIdentificacion,
			String noIdentificacion);

	public SearchResult<PseTransactionsLogModel> getAllTransactionsNotNotifiedPaymentAndStatusOk(String transactionStateStatus,
			String notificacionRecaudoStatus);

	public SearchResult<PseTransactionsLogModel> getAllCredibancoTransactionsNotNotifiedPaymentAndStatusAproved(
			String transactionStateStatus, String notificacionRecaudoStatus);


	public SearchResult<PseTransactionsLogModel> getTransactionsNotNotifiedPaymentAndStatusOk(String numeroDeReferencia,
			String transactionStateStatus,
			String notificacionRecaudoStatus);

	public SearchResult<PseTransactionsLogModel> getCredibancoTransactionsNotNotifiedPaymentAndStatusAproved(
			String numeroDeReferencia, String transactionStateStatus, String notificacionRecaudoStatus);



	public String getNusSequence();

	public SearchResult<PseTransactionsLogModel> getAllOutstandingCredibancoTransactions(String transactionState);

}

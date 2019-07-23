/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.credibanco.InititalizeTransactionResponse;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;


/**
 * @author edson.roa
 *
 */
public interface SDHPseTransactionsLogService
{

	public void newLogTransactionEntry(ConstantConnectionData constantConnectionData,
			CreateTransactionPaymentResponseInformationType transactionPaymentResponse, String numeroDeReferencia,
			String tipoDeImpuesto, String impuesto, String anoGravable, String CHIP, String periodo, String CUD,
			String noIdentificacion, String DV, String tipoDeIdentificacion, String fechaLimiteDePago, String pagoAdicional,
			String banco, String valorAPagar, String isoCurrency, String tipoDeTarjeta, String objPago);

	public void newCredibancoLogTransactionEntry(InititalizeTransactionResponse transactionPaymentResponse,
			String numeroDeReferencia, String tipoDeImpuesto, String impuesto, String anoGravable, String CHIP, String periodo,
			String CUD, String noIdentificacion, String DV, String tipoDeIdentificacion, String fechaLimiteDePago,
			String pagoAdicional, String banco, String valorAPagar, String isoCurrency, String tipoDeTarjeta, String objPago);

	public String updateTransaction(final String numeroDeReferencia);

	public void updateAllTransactions(final String transactionState);



}

/**
 *
 */
package de.hybris.sdh.core.services.impl;


import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.model.PseTransactionsLogModel;
import de.hybris.sdh.core.services.SDHPseTransactionsLogService;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;

import javax.annotation.Resource;

import org.apache.log4j.Logger;



/**
 * @author edson.roa
 *
 */
public class DefaultSDHPseTransactionsLogService implements SDHPseTransactionsLogService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHPseTransactionsLogService.class);

	@Resource(name = "modelService")
	private ModelService modelService;

	@Override
	public void newLogTransactionEntry(final ConstantConnectionData constantConnectionData,
			final CreateTransactionPaymentResponseInformationType transactionPaymentResponse, final String numeroDeReferencia,
			final String tipoDeImpuesto, final String impuesto, final String anoGravable, final String CHIP, final String periodo,
			final String CUD, final String noIdentificacion, final String DV, final String tipoDeIdentificacion,
			final String fechaLimiteDePago, final String pagoAdicional, final String banco, final String valorAPagar,
			final String isoCurrency, final String tipoDeTarjeta)
	{
		final PseTransactionsLogModel transactionLogModel = new PseTransactionsLogModel();
		final String transactionPaymentResponsePrint = null;

		// ConstantConnectionDat
		transactionLogModel.setEntityCode(constantConnectionData.getPpeCode());

		// PSEPaymentForm
		transactionLogModel.setNumeroDeReferencia(numeroDeReferencia);
		transactionLogModel.setTipoDeImpuesto(tipoDeImpuesto);
		transactionLogModel.setImpuesto(impuesto);
		transactionLogModel.setAnoGravable(anoGravable);
		transactionLogModel.setCHIP(CHIP);
		transactionLogModel.setPeriodo(periodo);
		transactionLogModel.setCUD(CUD);
		transactionLogModel.setTipoDeIdentificacion(noIdentificacion);
		transactionLogModel.setNoIdentificacion(DV);
		transactionLogModel.setDV(tipoDeIdentificacion);
		transactionLogModel.setFechaLimiteDePago(fechaLimiteDePago);
		transactionLogModel.setPagoAdicional(pagoAdicional);
		transactionLogModel.setBanco(banco);
		transactionLogModel.setValorAPagar(valorAPagar);
		transactionLogModel.setIsoCurrency(isoCurrency);
		transactionLogModel.setTipoDeTarjeta(tipoDeTarjeta);

		// CreateTransactionPaymentResponseInformationType
		if (transactionPaymentResponse != null)
		{
			transactionLogModel.setTrazabilityCode(transactionPaymentResponse.getTrazabilityCode());
			transactionLogModel.setReturnCode(transactionPaymentResponse.getReturnCode().getValue());
			transactionLogModel.setBankUrl(transactionPaymentResponse.getBankurl());
			transactionLogModel.setTransactionCycle(transactionPaymentResponse.getTransactionCycle());

			LOG.info("New newLogTransactionEntry - transactionPaymentResponse[" + transactionPaymentResponse.getTrazabilityCode()
					+ " , " + transactionPaymentResponse.getReturnCode().getValue() + " , " + transactionPaymentResponse.getBankurl()
					+ " , " + transactionPaymentResponse.getTransactionCycle() + "]");
		}


		// GetTransactionInformationResponseBodyType transactionLogModel.setSoliciteDate("");
		transactionLogModel.setBankProcessDate("");
		transactionLogModel.setTransactionState("");

		LOG.info("New newLogTransactionEntry:[" + constantConnectionData.getPpeCode() + " , " + numeroDeReferencia + " , "
				+ tipoDeImpuesto + " , " + impuesto + " , " + anoGravable + " , " + CHIP + " , " + periodo + " , " + CUD + " , "
				+ tipoDeIdentificacion + " , " + noIdentificacion + " , " + DV + " , " + fechaLimiteDePago + " , " + pagoAdicional
				+ " , " + banco + " , " + valorAPagar + " , " + isoCurrency + " , " + tipoDeTarjeta + "]");

		modelService.saveAll(transactionLogModel);
	}


}

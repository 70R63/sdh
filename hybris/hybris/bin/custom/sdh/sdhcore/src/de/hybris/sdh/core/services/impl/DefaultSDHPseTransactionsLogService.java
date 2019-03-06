/**
 *
 */
package de.hybris.sdh.core.services.impl;


import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.dao.PseTransactionsLogDao;
import de.hybris.sdh.core.model.PseTransactionsLogModel;
import de.hybris.sdh.core.services.SDHPseTransactionsLogService;
import de.hybris.sdh.core.soap.pse.PseServices;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;

import java.util.List;

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

	@Resource(name = "defaultPseServices")
	private PseServices pseServices;

	@Resource(name = "pseTransactionsLogDao")
	private PseTransactionsLogDao pseTransactionsLogDao;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

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


	@Override
	public String updateTransaction(final String numeroDeReferencia)
	{
		final PseTransactionsLogModel pseTransactionsLogModel = pseTransactionsLogDao.getTransaction(numeroDeReferencia);
		String trazabilityCode = null;
		String transactionState = null;


		if (pseTransactionsLogModel != null)
		{
			trazabilityCode = pseTransactionsLogModel.getTrazabilityCode();

			final GetTransactionInformationBodyType getTransactionInformationBodyType = new GetTransactionInformationBodyType();
			getTransactionInformationBodyType.setTrazabilityCode(trazabilityCode);

			final GetTransactionInformationResponseBodyType response = pseServices.getTransactionInformation(
					this.getConstantConnectionData(), this.getMessageHeader(), getTransactionInformationBodyType);

			/*
			 * if (response != null) { pseTransactionsLogModel.setSoliciteDate(response.getSoliciteDate().toString());
			 * pseTransactionsLogModel.setBankProcessDate(response.getBankProcessDate().toString());
			 * pseTransactionsLogModel.setTransactionState(response.getTransactionState().getValue()); transactionState =
			 * response.getTransactionState().getValue();
			 *
			 * LOG.info("Updated PseTransactionsLogModel [" + numeroDeReferencia + "," +
			 * response.getSoliciteDate().toString() + ", " + response.getBankProcessDate().toString() + ", " +
			 * response.getTransactionState().getValue() + "]");
			 *
			 * modelService.saveAll(pseTransactionsLogModel); }else { LOG.info("Error con la comunicacion de PSE"); }
			 */
			transactionState = this.updateResponse(pseTransactionsLogModel, response);
		}
		else
		{
			LOG.info("La transaccion con numero de referencia [" + numeroDeReferencia + "] no existe");
		}

		return transactionState;
	}


	@Override
	public void updateAllTransactions(final String transactionState)
	{
		final List<PseTransactionsLogModel> transactions = pseTransactionsLogDao.getAllOutstandingTransactions(transactionState)
				.getResult();
		String trazabilityCode = null;


		for (final PseTransactionsLogModel pseTransactionsLogModel : transactions)
		{
			trazabilityCode = pseTransactionsLogModel.getTrazabilityCode();

			final GetTransactionInformationBodyType getTransactionInformationBodyType = new GetTransactionInformationBodyType();
			getTransactionInformationBodyType.setTrazabilityCode(trazabilityCode);

			final GetTransactionInformationResponseBodyType response = pseServices.getTransactionInformation(
					this.getConstantConnectionData(), this.getMessageHeader(), getTransactionInformationBodyType);

			this.updateResponse(pseTransactionsLogModel, response);
		}

	}

	private MessageHeader getMessageHeader()
	{
		final MessageHeader messageHeader = new MessageHeader();
		messageHeader.setTo(configurationService.getConfiguration().getString("sdh.pse.messageHeader.to"));
		messageHeader.setFrom(configurationService.getConfiguration().getString("sdh.pse.messageHeader.from"));
		messageHeader
				.setRepresentingParty(configurationService.getConfiguration().getString("sdh.pse.messageHeader.representingParty"));
		return messageHeader;
	}

	private ConstantConnectionData getConstantConnectionData()
	{
		final ConstantConnectionData constantConnectionData = new ConstantConnectionData();
		constantConnectionData.setPseurl(configurationService.getConfiguration().getString("sdh.pse.pseURL"));
		constantConnectionData.setPpeCode(configurationService.getConfiguration().getString("sdh.pse.ppeCode"));
		return constantConnectionData;
	}

	private String updateResponse(final PseTransactionsLogModel pseTransactionsLogModel,
			final GetTransactionInformationResponseBodyType response)
	{
		String transactionState = null;
		if (response != null)
		{
			pseTransactionsLogModel.setSoliciteDate(response.getSoliciteDate().toString());
			pseTransactionsLogModel.setBankProcessDate(response.getBankProcessDate().toString());
			pseTransactionsLogModel.setTransactionState(response.getTransactionState().getValue());

			transactionState = response.getTransactionState().getValue();

			LOG.info("Updated PseTransactionsLogModel [" + pseTransactionsLogModel.getNumeroDeReferencia() + ","
					+ response.getSoliciteDate().toString() + ", " + response.getBankProcessDate().toString() + ", "
					+ response.getTransactionState().getValue() + "]");

			modelService.saveAll(pseTransactionsLogModel);
		}
		else
		{
			LOG.info("Error con la comunicacion de PSE");
		}
		return transactionState;
	}
}

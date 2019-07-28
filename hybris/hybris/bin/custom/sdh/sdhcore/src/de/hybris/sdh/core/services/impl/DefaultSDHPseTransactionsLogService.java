/**
 *
 */
package de.hybris.sdh.core.services.impl;


import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.credibanco.InititalizeTransactionResponse;
import de.hybris.sdh.core.dao.PseTransactionsLogDao;
import de.hybris.sdh.core.model.PseTransactionsLogModel;
import de.hybris.sdh.core.services.SDHPseTransactionsLogService;
import de.hybris.sdh.core.soap.pse.PseServices;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			final String isoCurrency, final String tipoDeTarjeta, final String objPago)
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
		transactionLogModel.setObjPago(objPago);
		//transactionLogModel.setNotificacionDeRecaudo("NO");

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


	/*
	 * (non-Javadoc)
	 * @see de.hybris.sdh.core.services.SDHPseTransactionsLogService#updateTransaction(java.lang.String)
	 * ACH Update Transaction
	 */
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

			transactionState = this.updateResponse(pseTransactionsLogModel, response);
		}
		else
		{
			LOG.info("La transaccion con numero de referencia PSE[" + numeroDeReferencia + "] no existe");
		}

		return transactionState;
	}


	/*
	 * (non-Javadoc)
	 * @see de.hybris.sdh.core.services.SDHPseTransactionsLogService#updateAllTransactions(java.lang.String)
	 * ACH Update All Trandactions
	 */
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

			//ACH Updating Transactions
			final GetTransactionInformationResponseBodyType response = pseServices.getTransactionInformation(
					this.getConstantConnectionData(), this.getMessageHeader(), getTransactionInformationBodyType);

			this.updateResponse(pseTransactionsLogModel, response);

			LOG.info("Actualizando Informacion PSE Transaction[" + pseTransactionsLogModel.getNumeroDeReferencia() + " - "
					+ pseTransactionsLogModel.getTransactionState() + "] ");
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
		final DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String transactionState = null;
		if (response != null)
		{

			pseTransactionsLogModel.setSoliciteDate(dateTimeFormat.format(response.getSoliciteDate()));
			pseTransactionsLogModel.setBankProcessDate(dateTimeFormat.format(response.getBankProcessDate()));
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


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHPseTransactionsLogService#newCredibancoLogTransactionEntry(de.hybris.sdh.core.
	 * credibanco.InititalizeTransactionResponse, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void newCredibancoLogTransactionEntry(final InititalizeTransactionResponse transactionPaymentResponse,
			final String numeroDeReferencia, final String tipoDeImpuesto, final String impuesto, final String anoGravable,
			final String CHIP, final String periodo, final String CUD, final String noIdentificacion, final String DV,
			final String tipoDeIdentificacion, final String fechaLimiteDePago, final String pagoAdicional, final String banco,
			final String valorAPagar, final String isoCurrency, final String tipoDeTarjeta, final String objPago)
	{
		final PseTransactionsLogModel transactionLogModel = new PseTransactionsLogModel();
		final String transactionPaymentResponsePrint = null;
		final SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yy");
		final SimpleDateFormat timeFmt = new SimpleDateFormat("hh:mm:ss");
		final Date dateTimeTransaction = new Date();

		// ConstantConnectionDat
		transactionLogModel.setEntityCode("CREDIBANCO_TRANSACTION");

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
		transactionLogModel.setObjPago(objPago);

		// CreateTransactionPaymentResponseInformationType
		if (transactionPaymentResponse != null)
		{
			transactionLogModel.setTrazabilityCode(transactionPaymentResponse.getInternalCode());
			transactionLogModel.setReturnCode(transactionPaymentResponse.getReturnCode());
			transactionLogModel.setBankUrl(transactionPaymentResponse.getPaymentRoute());
			transactionLogModel.setTransactionCycle("Description: " + transactionPaymentResponse.getDescription());
			transactionLogModel.setTransactionState(transactionPaymentResponse.getDescription());
			//transactionLogModel.setNotificacionDeRecaudo("NO");

			LOG.info(
					"NewCredibancoLogTransactionEntry - transactionPaymentResponse[" + transactionPaymentResponse.getInternalCode()
							+ " , " + transactionPaymentResponse.getReturnCode() + " , " + transactionPaymentResponse.getReturnCode()
							+ " , " + transactionPaymentResponse.getInternalCode() + "]");
		}

		// GetTransactionInformationResponseBodyType transactionLogModel.setSoliciteDate("");
		transactionLogModel.setBankProcessDate(dateFmt.format(dateTimeTransaction));
		transactionLogModel.setTransactionState(timeFmt.format(dateTimeTransaction));

		LOG.info("NewCredibancoLogTransactionEntry:[" + transactionLogModel.getEntityCode() + " , " + numeroDeReferencia + " , "
				+ tipoDeImpuesto + " , " + impuesto + " , " + anoGravable + " , " + CHIP + " , " + periodo + " , " + CUD + " , "
				+ tipoDeIdentificacion + " , " + noIdentificacion + " , " + DV + " , " + fechaLimiteDePago + " , " + pagoAdicional
				+ " , " + banco + " , " + valorAPagar + " , " + isoCurrency + " , " + tipoDeTarjeta + "]");

		modelService.saveAll(transactionLogModel);

	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHPseTransactionsLogService#updateCredibancoTransaction(java.lang.String)
	 */
	@Override
	public String updateCredibancoTransaction(final String numeroDeReferencia)
	{
		// XXX Auto-generated method stub
		return null;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHPseTransactionsLogService#updateAllCredibancoTransactions(java.lang.String)
	 */
	@Override
	public void updateAllCredibancoTransactions(final String transactionState)
	{
		// XXX Auto-generated method stub

	}
}

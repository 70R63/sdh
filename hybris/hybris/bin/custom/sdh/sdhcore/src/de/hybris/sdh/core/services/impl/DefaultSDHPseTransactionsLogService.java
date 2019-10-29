/**
 *
 */
package de.hybris.sdh.core.services.impl;


import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.credibanco.InititalizeTransactionResponse;
import de.hybris.sdh.core.credibanco.ResultTransactionRequest;
import de.hybris.sdh.core.credibanco.ResultTransactionResponse;
import de.hybris.sdh.core.dao.PseTransactionsLogDao;
import de.hybris.sdh.core.model.PseTransactionsLogModel;
import de.hybris.sdh.core.services.SDHCredibancoJwt;
import de.hybris.sdh.core.services.SDHPseTransactionsLogService;
import de.hybris.sdh.core.soap.pse.PseServices;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseFieldType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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

	@Resource(name = "sdhCredibancoJwt")
	SDHCredibancoJwt sdhCredibancoJwt;

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

		LOG.info("New newLogTransactionEntry:[ PpeCode=" + constantConnectionData.getPpeCode() + " , NumeroDeReferencia="
				+ numeroDeReferencia + " , TipoDeImpuesto=" + tipoDeImpuesto + " , Impuesto=" + impuesto + " , AnioGravable="
				+ anoGravable + " , CHIP=" + CHIP + " , Periodo=" + periodo + " , CUD=" + CUD + " , TipoDeIdentificacion="
				+ tipoDeIdentificacion + " , NoIdentificacion=" + noIdentificacion + " , DV=" + DV + " , FechaLimiteDePago="
				+ fechaLimiteDePago + " , PagoAdicional=" + pagoAdicional + " , Banco=" + banco + " , ValorAPagar=" + valorAPagar
				+ " , IsoCurrency=" + isoCurrency + " , TipoDeTarjeta=" + tipoDeTarjeta + "]");

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

		//LOG.error("trazabilityCode: " + numeroDeReferencia);
		if (pseTransactionsLogModel != null)
		{
			trazabilityCode = pseTransactionsLogModel.getTrazabilityCode();

			//LOG.error("trazabilityCode: " + trazabilityCode);
			final GetTransactionInformationBodyType getTransactionInformationBodyType = new GetTransactionInformationBodyType();
			getTransactionInformationBodyType.setTrazabilityCode(trazabilityCode);

			final GetTransactionInformationResponseBodyType response = pseServices.getTransactionInformation(
					this.getConstantConnectionData(), this.getMessageHeader(), getTransactionInformationBodyType);

			final GetTransactionInformationDetailedBodyType getTransactionInformationDetailedBodyType = new GetTransactionInformationDetailedBodyType();
			getTransactionInformationDetailedBodyType.setTrazabilityCode(trazabilityCode);

			final GetTransactionInformationDetailedResponseBodyType response1 = pseServices.getTransactionInformationDetailed(
					this.getConstantConnectionData(), this.getMessageHeader(), getTransactionInformationDetailedBodyType);



			LOG.info("----- Response Data GetTransactionInformationBodyType -------");
			LOG.info(response);
            LOG.info("----- Response Data GetTransactionInformationBodyType -------");

			LOG.info("----- Response Data GetTransactionInformationDetailedResponseBodyType -------");
			LOG.info(response1);
			LOG.info("----- Response Data GetTransactionInformationDetailedResponseBodyType -------");

			transactionState = this.updateResponse(pseTransactionsLogModel, response, response1);
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

			final GetTransactionInformationResponseBodyType response = pseServices.getTransactionInformation(
					this.getConstantConnectionData(), this.getMessageHeader(), getTransactionInformationBodyType);



			final GetTransactionInformationDetailedBodyType getTransactionInformationDetailedBodyType = new GetTransactionInformationDetailedBodyType();
			getTransactionInformationDetailedBodyType.setTrazabilityCode(trazabilityCode);

			final GetTransactionInformationDetailedResponseBodyType response1 = pseServices.getTransactionInformationDetailed(
					this.getConstantConnectionData(), this.getMessageHeader(), getTransactionInformationDetailedBodyType);

			this.updateResponse(pseTransactionsLogModel, response, response1);

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
			final GetTransactionInformationResponseBodyType response,
			final GetTransactionInformationDetailedResponseBodyType responseDetailed)
	{
		final DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		final HashMap<String, String> map = this.transactionInformationDetailedResponseToHash(responseDetailed);

		String transactionState = null;
		if (response != null)
		{
			pseTransactionsLogModel.setSoliciteDate(dateTimeFormat.format(response.getSoliciteDate()));
			try
			{
				pseTransactionsLogModel.setBankProcessDate(dateTimeFormat.format(map.get("bankProcessDate")));
			}
			catch (final Exception e)
			{
				pseTransactionsLogModel.setBankProcessDate(map.get("bankProcessDate"));
			}			pseTransactionsLogModel.setTransactionState(response.getTransactionState().getValue());
			//pseTransactionsLogModel.setPaymentOrigin(map.get("bankProcessDate"));
			//pseTransactionsLogModel.setPaymentMode(map.get("bankProcessDate"));

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
		final SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
		final Date dateTimeTransaction = new Date();

		// ConstantConnectionDat
		transactionLogModel.setEntityCode(ControllerPseConstants.CREDIBANCO_IDENTIFIER_TRANSACTION);

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

		transactionLogModel.setBankProcessDate(dateFmt.format(dateTimeTransaction));
		transactionLogModel.setSoliciteDate(dateFmt.format(dateTimeTransaction));

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
		final PseTransactionsLogModel pseTransactionsLogModel = pseTransactionsLogDao.getTransaction(numeroDeReferencia);
		String transactionState = null;

		if (Objects.nonNull(pseTransactionsLogModel))
		{
			final ResultTransactionResponse response = sdhCredibancoJwt
					.resultTransaction(new ResultTransactionRequest(numeroDeReferencia));
			if (Objects.nonNull(response))
			{
				pseTransactionsLogModel.setCreResponseStatus(response.getStatus());
				pseTransactionsLogModel.setCreApprovalNumber(response.getApprovalNumber());
				pseTransactionsLogModel.setCrePaymentMethod(response.getPaymentMethod());
				pseTransactionsLogModel.setBankProcessDate(response.getTransactionDate() + " " + response.getTransactionHour());
				pseTransactionsLogModel.setTransactionState(response.getDescription());
				transactionState = response.getStatus();

				modelService.saveAll(pseTransactionsLogModel);

				LOG.info("UpdateCredibancoTransaction:[ numeroReferencia(NUS)=" + pseTransactionsLogModel.getNumeroDeReferencia() + "]");
                LOG.info(response);
			}
			else
			{
				LOG.info("La transaccion con numero de referencia Credibanco[" + numeroDeReferencia + "] no pudo ser actualizada");
			}
		}
		else
		{
			LOG.info("La transaccion con numero de referencia Credibanco[" + numeroDeReferencia + "] no existe");
		}

		return transactionState;
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

	private HashMap<String, String> transactionInformationDetailedResponseToHash(final GetTransactionInformationDetailedResponseBodyType transactionInformationDetailed){
		final HashMap<String, String> map = new HashMap<>();

		LOG.info("-------- TransactionInformationDetailedResponseToHash -------");
		if(Objects.nonNull(transactionInformationDetailed)){
			LOG.info("Return Code: " + transactionInformationDetailed.getReturnCode());
			final Stream<GetTransactionInformationDetailedResponseFieldType> stream = Arrays.stream(transactionInformationDetailed.getField());
			stream.forEach(data -> map.put(data.getName(),data.getValue()));
		}
		LOG.info(map);
		LOG.info("-------- TransactionInformationDetailedResponseToHash -------");

		return map;
	}
}

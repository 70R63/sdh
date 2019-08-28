/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.dao.PseTransactionsLogDao;
import de.hybris.sdh.core.model.PseTransactionsLogModel;
import de.hybris.sdh.core.pojos.requests.PseNotificacionDePagoRequest;
import de.hybris.sdh.core.services.SDHNotificacionPagoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;


/**
 * @author edson.roa
 *
 */
public class DefaultSDHNotificacionPagoService implements SDHNotificacionPagoService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHNotificacionPagoService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "pseTransactionsLogDao")
	private PseTransactionsLogDao pseTransactionsLogDao;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Override
	public void realizarNotificacion(final PseNotificacionDePagoRequest pseNotificacionDePagoRequest)
	{
		final String usuario = configurationService.getConfiguration().getString("sdh.pse.notifPago.user");
		final String password = configurationService.getConfiguration().getString("sdh.pse.notifPago.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.pse.notifPago.urlhttp");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<PseNotificacionDePagoRequest> request = new HttpEntity<>(pseNotificacionDePagoRequest);

		final Object object = restTemplate.postForObject(urlService, request, Object.class);


		LOG.info("--------------- Notificacion De Pago Realizada EXITOSAMENTE IdReferencia[" + pseNotificacionDePagoRequest.getRefPago() + "]---------");
		LOG.info(pseNotificacionDePagoRequest);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHNotificacionPagoService#notifyAllTransactionWithStatusOkAndNotNotifiedBefore()
	 */
	@Override
	public void notifyAllTransactionWithStatusOkAndNotNotifiedBefore()
	{
		final List<PseTransactionsLogModel> transactions = new ArrayList<PseTransactionsLogModel>();
		final List<PseTransactionsLogModel> psetransactions = pseTransactionsLogDao
				.getAllTransactionsNotNotifiedPaymentAndStatusOk(ControllerPseConstants.PSE_ACH_RESPONSE_TRANSACTION_OK,
						ControllerPseConstants.ONLINE_PAYMENT_NOT_NOTIFIED_TRANSACTION).getResult();

		final List<PseTransactionsLogModel> credibancoTransactions = pseTransactionsLogDao
				.getAllCredibancoTransactionsNotNotifiedPaymentAndStatusAproved(ControllerPseConstants.CREDIBANCO_RESPONSE_APROBADA,
						ControllerPseConstants.ONLINE_PAYMENT_NOT_NOTIFIED_TRANSACTION).getResult();

		PseNotificacionDePagoRequest pseNotificacionDePagoRequest;
		transactions.addAll(psetransactions);
		transactions.addAll(credibancoTransactions);

		for (final PseTransactionsLogModel transaction : transactions)
		{
			final String bankProcessDate = transaction.getBankProcessDate();
			String fechaRecaudo = "";
			String horaRecaudo = "";

			if (bankProcessDate != null)
			{
				if (bankProcessDate.split(" ").length == 2)
				{
					fechaRecaudo = bankProcessDate.split(" ")[0];
					horaRecaudo = bankProcessDate.split(" ")[1];
				}
			}

			pseNotificacionDePagoRequest = new PseNotificacionDePagoRequest();
			pseNotificacionDePagoRequest.setIdBancos(getBankId(transaction.getTipoDeImpuesto()));
			pseNotificacionDePagoRequest.setModalidad(transaction.getTipoDeTarjeta());
			pseNotificacionDePagoRequest.setProcPago(ControllerPseConstants.PSE_PROC_PAGO.get(transaction.getTipoDeTarjeta()));
			pseNotificacionDePagoRequest.setFchRecaudo(fechaRecaudo);
			pseNotificacionDePagoRequest.setHorRecaudo(horaRecaudo);
			pseNotificacionDePagoRequest.setCodImpuesto(getImpuestoId(transaction.getTipoDeImpuesto()));
			pseNotificacionDePagoRequest.setRefPago(transaction.getNumeroDeReferencia());
			pseNotificacionDePagoRequest.setVlrRecuado(transaction.getValorAPagar());
			
			pseNotificacionDePagoRequest.setNumOperacion("9999999");
			pseNotificacionDePagoRequest.setObjPago(transaction.getObjPago());

			
			if(transaction.getEntityCode().equals(ControllerPseConstants.CREDIBANCO_IDENTIFIER_TRANSACTION)) { //Credibanco transaction
				pseNotificacionDePagoRequest.setMedioPago(ControllerPseConstants.CREDIBANCO_NOTIFICACION_DE_PAGO_MEDIO_PAGO.get(transaction.getCrePaymentMethod()));
			}else { //ACH PSE Transaction
				pseNotificacionDePagoRequest.setMedioPago(ControllerPseConstants.NOTIFICACION_DE_PAGO_MEDIO_PAGO.get(transaction.getTipoDeTarjeta()));
			}
			
			this.realizarNotificacion(pseNotificacionDePagoRequest);

			transaction.setNotificacionDeRecaudo("SI");
			modelService.saveAll(transaction);
		}

	}

	private PseNotificacionDePagoRequest validateTransaction(final PseNotificacionDePagoRequest pseNotificacionDePagoRequest) {
		final PseNotificacionDePagoRequest newPseNotificacionDePagoRequest = pseNotificacionDePagoRequest;
		final ControllerPseConstants cont = new ControllerPseConstants();

		if (pseNotificacionDePagoRequest.getCodImpuesto().equals(cont.getGASOLINA())){
			newPseNotificacionDePagoRequest.setIdBancos("01"); //01 Banco de Bogotá
		}else if (pseNotificacionDePagoRequest.getCodImpuesto().equals(cont.getPUBLICIDAD())){
			newPseNotificacionDePagoRequest.setIdBancos("51"); //51 Banco Davivienda.
		}

		return newPseNotificacionDePagoRequest;
	}

	private String getBankId(final String tipoDeImpuesto)
	{
		/*
		 * switch (tipoDeImpuesto) { case ControllerPseConstants.DELINEACION: return tipoDeImpuesto.substring(2, 4); case
		 * ControllerPseConstants.RETENCIONDU: return tipoDeImpuesto.substring(2, 4); default: return
		 * Objects.nonNull(tipoDeImpuesto) ? tipoDeImpuesto.substring(0, 2) : null;
		 *
		 * }
		 */
		return Objects.nonNull(tipoDeImpuesto) ? tipoDeImpuesto.substring(0, 2) : null;
	}

	private String getImpuestoId(final String tipoDeImpuesto)
	{
		/*
		 * switch (tipoDeImpuesto) { case ControllerPseConstants.DELINEACION: return tipoDeImpuesto.substring(0, 2); case
		 * ControllerPseConstants.RETENCIONDU: return tipoDeImpuesto.substring(0, 2); default: return
		 * Objects.nonNull(tipoDeImpuesto) ? tipoDeImpuesto.substring(2, 4) : null; }
		 */

		return Objects.nonNull(tipoDeImpuesto) ? tipoDeImpuesto.substring(2, 4) : null;
	}


}

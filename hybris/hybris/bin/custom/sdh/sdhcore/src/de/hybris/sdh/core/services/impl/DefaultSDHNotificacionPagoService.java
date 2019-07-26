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

import java.util.List;

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

		LOG.info(pseNotificacionDePagoRequest);
		LOG.info("--------------- Notificacion de pago realizada idReferencia["+pseNotificacionDePagoRequest.getRefPago()+"]---------");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHNotificacionPagoService#notifyAllTransactionWithStatusOkAndNotNotifiedBefore()
	 */
	@Override
	public void notifyAllTransactionWithStatusOkAndNotNotifiedBefore()
	{
		final List<PseTransactionsLogModel> transactions = pseTransactionsLogDao
				.getAllTransactionsNotNotifiedPaymentAndStatusOk("OK", "NO").getResult();

		PseNotificacionDePagoRequest pseNotificacionDePagoRequest;

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
			pseNotificacionDePagoRequest.setIdBancos(transaction.getTipoDeImpuesto().substring(0, 2));
			pseNotificacionDePagoRequest.setModalidad(transaction.getTipoDeTarjeta());
			pseNotificacionDePagoRequest.setProcPago(ControllerPseConstants.PSE_PROC_PAGO.get(transaction.getTipoDeTarjeta()));
			pseNotificacionDePagoRequest.setFchRecaudo(fechaRecaudo);
			pseNotificacionDePagoRequest.setHorRecaudo(horaRecaudo);
			pseNotificacionDePagoRequest.setCodImpuesto(transaction.getTipoDeImpuesto()); // 08 Gasolina
			//pseNotificacionDePagoRequest.setTipoHorario("0");
			pseNotificacionDePagoRequest.setRefPago(transaction.getNumeroDeReferencia());
			pseNotificacionDePagoRequest.setVlrRecuado(transaction.getValorAPagar());
			pseNotificacionDePagoRequest.setMedioPago(transaction.getTipoDeTarjeta());
			pseNotificacionDePagoRequest.setNumOperacion("9999999");
			pseNotificacionDePagoRequest.setObjPago(transaction.getObjPago());


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



}

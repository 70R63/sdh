/**
 *
 */
package de.hybris.sdh.core.services.impl;

/**
 * @author Consultor
 *
 */


import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConsultaPagoRequest;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoDeclaraciones;
import de.hybris.sdh.core.pojos.responses.ConsultaPagoResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaPagoService;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Consultor
 *
 */

public class DefaultSDHConsultaPagoService implements SDHConsultaPagoService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHConsultaContribuyenteBPService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhValidaContribuyenteService")
	private SDHValidaContribuyenteService sdhValidaContribuyenteService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.services.SDHCertificaRITService#consultaCertificacionRIT(de.hybris.sdh.core.pojos.requests.
	 * CertificaRITRequest)
	 */
	@Override
	public String consultaPago(final ConsultaPagoRequest request)
	{

		final String urlString = configurationService.getConfiguration().getString("sdh.consulPagos.url");
		final String user = configurationService.getConfiguration().getString("sdh.consulPagos.user");
		final String password = configurationService.getConfiguration().getString("sdh.consulPagos.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while validating contribuyente: Empty credentials");
		}

		try
		{
			final URL url = new URL(urlString);

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			final String authString = user + ":" + password;
			final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
			conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info("connection to: " + conn.toString());

			final String requestJson = request.toString();
			LOG.info("request: " + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}


			final String result = builder.toString();
			LOG.info("response: " + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error validating a contribuyente: " + e.getMessage());
		}



		// XXX Auto-generated method stub
		return null;

	}


	@Override
	public List<ConsultaPagoDeclaraciones> consultaPago(final String numBP, final String numObjeto, final String clavePeriodo)
	{
		final ObjectMapper mapper = new ObjectMapper();
		final List<ConsultaPagoDeclaraciones>  finalDeclaraciones = new ArrayList<ConsultaPagoDeclaraciones>();

		final ConsultaPagoRequest consltaPagoRequest = new ConsultaPagoRequest();
		consltaPagoRequest.setNumBP(numBP);
		consltaPagoRequest.setNumObjeto(numObjeto);


		SDHValidaMailRolResponse contribuyenteResponse = null;
		contribuyenteResponse = sdhValidaContribuyenteService.validaContribuyente(numBP);


		ConsultaPagoResponse consultaPagoResponse = null;
		try
		{
			consultaPagoResponse = mapper.readValue(this.consultaPago(consltaPagoRequest), ConsultaPagoResponse.class);
			if(consultaPagoResponse != null) {
				if(consultaPagoResponse.getDeclaraciones() != null) {
					for(final ConsultaPagoDeclaraciones declaracion : consultaPagoResponse.getDeclaraciones()) {
						if(declaracion.getClavePeriodo() != null) {
							if(declaracion.getClavePeriodo().equals(clavePeriodo)) {
								if (contribuyenteResponse != null){
									final List<ImpuestoPublicidadExterior> publicidadExtList = contribuyenteResponse.getPublicidadExt();
									if (publicidadExtList != null){
										for (final ImpuestoPublicidadExterior publicidadExt : publicidadExtList){
											if(publicidadExt.getNumObjeto().equals(declaracion.getNumObjeto())) {
												declaracion.setNumResolu(publicidadExt.getNumResolu());
												declaracion.setTipoValla(publicidadExt.getTipoValla());
												finalDeclaraciones.add(declaracion);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		return finalDeclaraciones;
	}


	@Override
	public List<ConsultaPagoDeclaraciones> consultaPagoDelineacion(final String numBP, final String numObjeto,
			final String clavePeriodo)
	{
		return null;
	}


}

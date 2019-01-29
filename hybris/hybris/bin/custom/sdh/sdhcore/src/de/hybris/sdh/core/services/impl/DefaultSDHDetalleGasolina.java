/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConsultaGasolinaRequest;
import de.hybris.sdh.core.services.SDHDetalleGasolina;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


/**
 * @author hybris
 *
 */
public class DefaultSDHDetalleGasolina implements SDHDetalleGasolina
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHDetalleGasolina.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	@Override
	public String consultaWS(final ConsultaGasolinaRequest request, final String confUrl, final String confUser,
			final String confPassword, final String wsNombre, final String wsRequestMethod)
	{
		final String urlString = configurationService.getConfiguration().getString(confUrl);//"sdh.detalleGasolina.url");
		final String user = configurationService.getConfiguration().getString(confUser);//"sdh.detalleGasolina.user");
		final String password = configurationService.getConfiguration().getString(confPassword);//"sdh.detalleGasolina.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error al preparar autenticacion de WebService: " + wsNombre);
		}

		try
		{
			final URL url = new URL(urlString);

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(wsRequestMethod);

			final String authString = user + ":" + password;
			final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
			conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			//			LOG.info("conectando a: " + conn.toString());

			final String requestJson = request.toString();
			//			LOG.info("request: " + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException("Error : HTTP error code : " + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}
			final String result = builder.toString();
			//			LOG.info("response: " + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("Error al procesar la respuesta de WS: " + wsNombre + " Detalle:" + e.getMessage());
		}

		// XXX Auto-generated method stub
		return null;
	}

}

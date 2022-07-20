/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.RetencionesPracticadasConsRequest;
import de.hybris.sdh.core.pojos.requests.RetencionesPracticadasReporteRequest;
import de.hybris.sdh.core.services.SDHRetencionesPracticadasConsService;

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
public class DefaultSDHRetencionesPracticadasConsService implements SDHRetencionesPracticadasConsService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHRetencionesPracticadasConsService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService#consultaContribuyenteBP(de.hybris.sdh.core.pojos.
	 * requests.ConsultaContribuyenteBPRequest)
	 */
	@Override
	public String retencionesPracticadasRequest(final RetencionesPracticadasConsRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.retenciones.practicadas.url");
		final String user = configurationService.getConfiguration().getString("sdh.retenciones.practicadas.user");
		final String password = configurationService.getConfiguration().getString("sdh.retenciones.practicadas.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Empty credentials");
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


			String result = builder.toString();
			result = result.replaceAll("\"Errores\":\\{([\"])(.*)(\"\\})", "\"Errores\":[{\"$2\"}]");

			LOG.info("response: " + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error validating a retenciones practicadas: " + e.getMessage());
		}



		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public String retencionesPracticadasReporteRequest(final RetencionesPracticadasReporteRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.retenciones.practicadas.reporte.url");
		final String user = configurationService.getConfiguration().getString("sdh.retenciones.practicadas.reporte.user");
		final String password = configurationService.getConfiguration().getString("sdh.retenciones.practicadas.reporte.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Empty credentials");
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

			String result = builder.toString();
			result = result.replaceAll("\"Errores\":\\{([\"])(.*)(\"\\})", "\"Errores\":[{\"$2\"}]");
			//			LOG.info("response: " + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error validating a retenciones practicadas reporte: " + e.getMessage());
		}



		// XXX Auto-generated method stub
		return null;
	}

}

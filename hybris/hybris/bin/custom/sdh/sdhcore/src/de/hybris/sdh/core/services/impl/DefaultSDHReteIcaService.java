/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.LogReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaAvisoArchivoRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.ReteicaObligacionesRequest;
import de.hybris.sdh.core.services.SDHReteIcaService;

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
public class DefaultSDHReteIcaService implements SDHReteIcaService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHReteIcaService.class);
	private static final String ATHORIZATION = "Authorization";
	private static final String BASIC = "Basic " ;
	private static final String APPLICATION_JSON = "application/json1";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String CONNECTION_TO = "connection to: ";
	private static final String REQUEST = "request: " ;
	private static final String FAILED_HTTP= "Failed : HTTP error code : ";
	private static final String RESPONSES = "response: ";

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Override
	public String reteICA(final ReteIcaRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.reteica.url");
		final String user = configurationService.getConfiguration().getString("sdh.reteica.user");
		final String password = configurationService.getConfiguration().getString("sdh.reteica.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while consulting ReteICA : Empty credentials");
		}

		try
		{
			final URL url = new URL(urlString);

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			final String authString = user + ":" + password;
			final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
			conn.setRequestProperty(ATHORIZATION, BASIC + authStringEnc);
			conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info(CONNECTION_TO + conn.toString());

			final String requestJson = request.toString();
			LOG.info(REQUEST + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException(FAILED_HTTP + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}

			final String result = builder.toString();
			LOG.info(RESPONSES + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error consulting ReteICA : " + e.getMessage());
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.services.SDHReteIcaService#calculo(de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest)
	 */
	@Override
	public String calculo(final CalculoReteIcaRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.reteica.calculo.url");
		final String user = configurationService.getConfiguration().getString("sdh.reteica.calculo.user");
		final String password = configurationService.getConfiguration().getString("sdh.reteica.calculo.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while calculating ReteICA : Empty credentials");
		}

		try
		{
			final URL url = new URL(urlString);

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			final String authString = user + ":" + password;
			final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
			conn.setRequestProperty(ATHORIZATION, BASIC + authStringEnc);
			conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info(CONNECTION_TO + conn.toString());

			final String requestJson = request.toString();
			LOG.info(REQUEST + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException(FAILED_HTTP + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}

			final String result = builder.toString();
			LOG.info(RESPONSES + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error calculating ReteICA : " + e.getMessage());
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHReteIcaService#logReteICA(de.hybris.sdh.core.pojos.requests.LogReteIcaRequest)
	 */
	@Override
	public String logReteICA(final LogReteIcaRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.reteica.log.url");
		final String user = configurationService.getConfiguration().getString("sdh.reteica.log.user");
		final String password = configurationService.getConfiguration().getString("sdh.reteica.log.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while getting LogReteICA : Empty credentials");
		}

		try
		{
			final URL url = new URL(urlString);

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			final String authString = user + ":" + password;
			final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
			conn.setRequestProperty(ATHORIZATION, BASIC + authStringEnc);
			conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info(CONNECTION_TO + conn.toString());

			final String requestJson = request.toString();
			LOG.info(REQUEST + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException(FAILED_HTTP + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}

			final String result = builder.toString();
			LOG.info(RESPONSES + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error getting log of ReteICA : " + e.getMessage());
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHReteIcaService#avisoArchivo(de.hybris.sdh.core.pojos.requests.
	 * ReteIcaAvisoArchivoRequest)
	 */
	@Override
	public Boolean avisoArchivo(final ReteIcaAvisoArchivoRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.reteica.aviso.url");
		final String user = configurationService.getConfiguration().getString("sdh.reteica.aviso.user");
		final String password = configurationService.getConfiguration().getString("sdh.reteica.aviso.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while getting LogReteICA : Empty credentials");
		}

		try
		{
			final URL url = new URL(urlString);

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			final String authString = user + ":" + password;
			final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
			conn.setRequestProperty(ATHORIZATION, BASIC + authStringEnc);
			conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info(CONNECTION_TO + conn.toString());

			final String requestJson = request.toString();
			LOG.info(REQUEST + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_ACCEPTED)
			{
				throw new RuntimeException(FAILED_HTTP + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}

			final String result = builder.toString();
			LOG.info(RESPONSES + result);

			return Boolean.TRUE;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error getting log of ReteICA : " + e.getMessage());
		}

		return Boolean.FALSE;
	}

	@Override
	public String reteIcaObligaciones(final ReteicaObligacionesRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.reteIca.obliPendientes.url");
		final String user = configurationService.getConfiguration().getString("sdh.reteIca.obliPendientes.user");
		final String password = configurationService.getConfiguration().getString("sdh.reteIca.obliPendientes.password");

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
			conn.setRequestProperty(ATHORIZATION, BASIC + authStringEnc);
			conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info(CONNECTION_TO + conn.toString());

			final String requestJson = request.toString();
			LOG.info(REQUEST + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException(FAILED_HTTP + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}


			final String result = builder.toString();
			LOG.info(RESPONSES + result);

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
	public String reteICaCorto(final ConsultaContribuyenteBPRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.reteicaSimpli.url");
		final String user = configurationService.getConfiguration().getString("sdh.reteicaSimpli.user");
		final String password = configurationService.getConfiguration().getString("sdh.reteicaSimpli.password");

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
			conn.setRequestProperty(ATHORIZATION, BASIC + authStringEnc);
			conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info(CONNECTION_TO + conn.toString());

			final String requestJson = request.toString();
			LOG.info(REQUEST + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException(FAILED_HTTP + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}


			final String result = builder.toString();
			LOG.info(RESPONSES + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error validating a contribuyente: " + e.getMessage());
		}
		// XXX Auto-generated method stub
		return null;
	}

}

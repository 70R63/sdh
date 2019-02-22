/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.UpdateAddressRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateAutorizacionesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateEmailRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateNameRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRedesSocialesRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateRitRequest;
import de.hybris.sdh.core.pojos.requests.UpdateTelefonoRitRequest;
import de.hybris.sdh.core.services.SDHUpdateRitService;

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
public class DefaultSDHUpdateRitService implements SDHUpdateRitService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHUpdateRitService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Override
	public String updateRit(final UpdateRitRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.password");


		try
		{
			if (StringUtils.isAnyBlank(urlString, user, password))
			{
				throw new RuntimeException("Error while validating contribuyente: Empty credentials");
			}

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



		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHUpdateRitService#updateEmailRit(de.hybris.sdh.core.pojos.requests.
	 * UpdateEmailRitRequest)
	 */
	@Override
	public String updateEmailRit(final UpdateEmailRitRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.password");


		try
		{
			if (StringUtils.isAnyBlank(urlString, user, password))
			{
				throw new RuntimeException("Error while updating email: Empty credentials");
			}

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
			LOG.error("There was an error updating email contribuyente: " + e.getMessage());
		}



		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHUpdateRitService#updateAutorizacionesRit(de.hybris.sdh.core.pojos.requests.
	 * UpdateAutorizacionesRitRequest)
	 */
	@Override
	public String updateAutorizacionesRit(final UpdateAutorizacionesRitRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.password");


		try
		{
			if (StringUtils.isAnyBlank(urlString, user, password))
			{
				throw new RuntimeException("Error while updating autorizacions for contribuyente: Empty credentials");
			}

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
			LOG.error("There was an error updating autorizaciones a contribuyente: " + e.getMessage());
		}



		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHUpdateRitService#updateRedesSocialesRit(de.hybris.sdh.core.pojos.requests.
	 * UpdateRedesSocialesRitRequest)
	 */
	@Override
	public String updateRedesSocialesRit(final UpdateRedesSocialesRitRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.password");


		try
		{
			if (StringUtils.isAnyBlank(urlString, user, password))
			{
				throw new RuntimeException("Error while updating redes sociales for contribuyente: Empty credentials");
			}

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
			LOG.error("There was an error updating redes sociales a contribuyente: " + e.getMessage());
		}



		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHUpdateRitService#updateTelefonoRit(de.hybris.sdh.core.pojos.requests.
	 * UpdateTelefonoRitRequest)
	 */
	@Override
	public String updateTelefonoRit(final UpdateTelefonoRitRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.password");


		try
		{
			if (StringUtils.isAnyBlank(urlString, user, password))
			{
				throw new RuntimeException("Error while validating updating telefono contribuyente: Empty credentials");
			}

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
			LOG.error("There was an error updating telefono contribuyente: " + e.getMessage());
		}



		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHUpdateRitService#updateAddressRit(de.hybris.sdh.core.pojos.requests.
	 * UpdateAddressRitRequest)
	 */
	@Override
	public String updateAddressRit(final UpdateAddressRitRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.password");


		try
		{
			if (StringUtils.isAnyBlank(urlString, user, password))
			{
				throw new RuntimeException("Error while  updating address contribuyente: Empty credentials");
			}

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
			LOG.error("There was an error updating address contribuyente: " + e.getMessage());
		}



		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.sdh.core.services.SDHUpdateRitService#updateNameRit(de.hybris.sdh.core.pojos.requests.
	 * UpdateNameRitRequest)
	 */
	@Override
	public String updateNameRit(final UpdateNameRitRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.creamodcontribuyente.password");


		try
		{
			if (StringUtils.isAnyBlank(urlString, user, password))
			{
				throw new RuntimeException("Error while  updating name contribuyente: Empty credentials");
			}

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
			LOG.error("There was an error updating name contribuyente: " + e.getMessage());
		}



		return null;
	}



}

/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConcesionariosRequest;
import de.hybris.sdh.core.pojos.responses.ConcesionariosResponse;
import de.hybris.sdh.core.services.SDHConcesionariosService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Maria Torres
 *
 */
public class DefaultSDHConcesionariosImpService implements SDHConcesionariosService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHConcesionariosImpService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Override
	public String concesionarios(final ConcesionariosRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.concesionarios.url");
		final String user = configurationService.getConfiguration().getString("sdh.concesionarios.user");
		final String password = configurationService.getConfiguration().getString("sdh.concesionarios.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while validating data: Empty credentials");
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
			LOG.error("There was an error while consumes the service: " + e.getMessage());
		}

		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public ConcesionariosResponse concesionario(final ConcesionariosRequest requests)
	{
		final String urlService = configurationService.getConfiguration().getString("sdh.concesionarios.url");
		final String usuario = configurationService.getConfiguration().getString("sdh.concesionarios.user");
		final String password = configurationService.getConfiguration().getString("sdh.concesionarios.password");

		final ConcesionariosRequest concesionariosRequest = new ConcesionariosRequest();
		concesionariosRequest.setaUGUST(requests.getaUGUST());
		concesionariosRequest.setbUDAT(requests.getbUDAT());
		concesionariosRequest.seteRNAM(requests.geteRNAM());

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));

		final HttpEntity<ConcesionariosRequest> request = new HttpEntity<>(concesionariosRequest);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String response = null;
		ConcesionariosResponse wsResponse = null;
		LOG.info("connection to: " + urlService);

		LOG.info("Request: " + request);
		try
		{
			response = restTemplate.postForObject(urlService, request, String.class);
			LOG.info("Response: " + response);
			if (response != null)
			{
				wsResponse = mapper.readValue(response, ConcesionariosResponse.class);
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al llamar al WS: " + urlService);
		}

		return wsResponse;
	}



}

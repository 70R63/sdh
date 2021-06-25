package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;


public class DefaultSDHConsultaImpuesto_simplificado implements SDHConsultaImpuesto_simplificado
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHConsultaImpuesto_simplificado.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
	public List<ImpuestoVehiculos> consulta_impVehicular(final ConsultaContribuyenteBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<ImpuestoVehiculos> impuestosVehiculos = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impVehicular_string(wsRequest), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosVehiculos = wsResponse.getVehicular();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Vehicular");
		}


		return impuestosVehiculos;
	}



	public String consulta_impVehicular_string(final ConsultaContribuyenteBPRequest wsRequest)
	{
		final String usuario = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.user");
		final String password = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.password");
		final String urlService = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.url");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(wsRequest);

		LOG.info(wsRequest);
		final String wsResponse = restTemplate.postForObject(urlService, request, String.class);
		LOG.info(wsResponse);


		return wsResponse;
	}


	@Override
	public String consulta_impGasolina_string(final ConsultaContribuyenteBPRequest request)
	{

		final String urlString = configurationService.getConfiguration().getString("sdh.gasolinaSimpli.url");
		final String user = configurationService.getConfiguration().getString("sdh.gasolinaSimpli.user");
		final String password = configurationService.getConfiguration().getString("sdh.gasolinaSimpli.password");

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
	public List<ImpuestoDelineacionUrbana> consulta_impDelineacion(final ConsultaContribuyenteBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<ImpuestoDelineacionUrbana> impuestosDelineacion = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impDelineacion_string(wsRequest), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosDelineacion = wsResponse.getDelineacion();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Delineacion");
		}


		return impuestosDelineacion;
	}



	public String consulta_impDelineacion_string(final ConsultaContribuyenteBPRequest wsRequest)
	{
		final String usuario = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impDelineacion.user");
		final String password = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impDelineacion.password");
		final String urlService = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impDelineacion.url");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(wsRequest);

		LOG.info(wsRequest);
		final String wsResponse = restTemplate.postForObject(urlService, request, String.class);
		LOG.info(wsResponse);


		return wsResponse;
	}

}

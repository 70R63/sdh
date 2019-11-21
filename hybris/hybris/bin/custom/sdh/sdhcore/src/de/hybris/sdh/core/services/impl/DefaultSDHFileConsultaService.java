package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.FileConsultaRequest;
import de.hybris.sdh.core.pojos.responses.FileConsultaResponse;
import de.hybris.sdh.core.services.SDHFileConsultaService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class DefaultSDHFileConsultaService implements SDHFileConsultaService {

    private static final Logger LOG = Logger.getLogger(DefaultSDHFileConsultaService.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
	public FileConsultaResponse consultar(final FileConsultaRequest fileConsultaRequest) {
        final RestTemplate restTemplate = new RestTemplate();
		((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000 * 20);
        final String  urlService = configurationService.getConfiguration().getString("gestion.bancaria.ws.consultas.url");
        final String  usuario = configurationService.getConfiguration().getString("gestion.bancaria.ws.consultas.user");
        final String  password = configurationService.getConfiguration().getString("gestion.bancaria.ws.consultas.password");

        final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        final Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        headers.setAll(map);


        final Map req_payload = new HashMap();
        req_payload.put("CODBK",	 	fileConsultaRequest.getCODBK());
        req_payload.put("idEnvio", 		fileConsultaRequest.getIdEnvio());
        req_payload.put("tipoFile", 	fileConsultaRequest.getTipoFile());
        req_payload.put("nroSecuencia", fileConsultaRequest.getNroSecuencia());
        req_payload.put("estado", 		fileConsultaRequest.getEstado());
        req_payload.put("fchEnvio", 	fileConsultaRequest.getFchEnvio());

        final HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		String jsonString = restTemplate.postForObject(urlService, request, String.class);
		if (jsonString.indexOf("\"resultado\":{") >= 0)
		{
			jsonString = jsonString.replaceAll("\"resultado\":\\{([\"])(.*)(\"\\})", "\"resultado\":[{\"$2\"}]");
		}

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		FileConsultaResponse response = null;
		try
		{
			response = mapper.readValue(jsonString, FileConsultaResponse.class);
		}
		catch (final Exception e)
		{
		}


		return response;
    }
}

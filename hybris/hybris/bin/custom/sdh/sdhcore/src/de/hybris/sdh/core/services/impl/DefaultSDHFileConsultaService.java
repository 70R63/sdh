package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.FileConsultaRequest;
import de.hybris.sdh.core.pojos.responses.FileConsultaResponse;
import de.hybris.sdh.core.services.SDHFileConsultaService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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
		final ResponseEntity<FileConsultaResponse> response = restTemplate.postForEntity(urlService, request,
				FileConsultaResponse.class);

		return response.getBody();
    }
}

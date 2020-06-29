package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.TercerosAutRequest;
import de.hybris.sdh.core.pojos.responses.TercerosAutResponse;
import de.hybris.sdh.core.services.SDHTercerosAutService;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class DefaultSDHTercerosAutService implements SDHTercerosAutService {
    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public TercerosAutResponse getTercerosAut(final TercerosAutRequest requestObject) throws Exception {
		final String usuario = configurationService.getConfiguration().getString("sdh.tercerosAut.user");
		final String password = configurationService.getConfiguration().getString("sdh.tercerosAut.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.tercerosAut.url");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<TercerosAutRequest> request = new HttpEntity<>(requestObject);

		System.out.println("Request para trm/tercerosAut/: " + requestObject);
		final String jsonString = restTemplate.postForObject(urlService, request, String.class);
		System.out.println("Response para trm/tercerosAut/: " + jsonString);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TercerosAutResponse response = null;
		try
		{
			response = mapper.readValue(jsonString, TercerosAutResponse.class);
		}
		catch (final Exception e)
		{
		}

		return response;
    }
}

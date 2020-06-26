package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.AgentesAutBpRequest;
import de.hybris.sdh.core.pojos.requests.AgentesAutImpuestoRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.ListCalidadRequest;
import de.hybris.sdh.core.pojos.responses.AgentesAutBpResponse;
import de.hybris.sdh.core.pojos.responses.AgentesAutImpuestoResponse;
import de.hybris.sdh.core.pojos.responses.ListDocumentoResponse;
import de.hybris.sdh.core.pojos.responses.QuestionForRegistrationResponse;
import de.hybris.sdh.core.services.SDHAgentesAutBPService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class DefaultSDHAgentesAutBPService implements SDHAgentesAutBPService {

    private static final Logger LOG = Logger.getLogger(DefaultSDHGetQuestionsForRegistration.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public AgentesAutBpResponse getAgentesAutBp(AgentesAutBpRequest agentesAutBpRequest) {
        final String usuario = configurationService.getConfiguration().getString("sdh.agentesAutBP.user");
        final String password = configurationService.getConfiguration().getString("sdh.agentesAutBP.password");
        final String urlService = configurationService.getConfiguration().getString("sdh.agentesAutBP.url");

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
        final HttpEntity<AgentesAutBpRequest> request = new HttpEntity<>(agentesAutBpRequest);
        return restTemplate.postForObject(urlService, request, AgentesAutBpResponse.class);
    }

    @Override
    public ListDocumentoResponse getCalidades(ListCalidadRequest listCalidadRequest) {
        final String usuario = configurationService.getConfiguration().getString("sdh.agentesAutBP.calidades.user");
        final String password = configurationService.getConfiguration().getString("sdh.agentesAutBP.calidades.password");
        final String urlService = configurationService.getConfiguration().getString("sdh.agentesAutBP.calidades.url");

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
        final HttpEntity<ListCalidadRequest> request = new HttpEntity<>(listCalidadRequest);
        return restTemplate.postForObject(urlService, request, ListDocumentoResponse.class);
    }

    @Override
    public AgentesAutImpuestoResponse createCase(AgentesAutImpuestoRequest agentesAutImpuestoRequest) {
        final String usuario = configurationService.getConfiguration().getString("sdh.agentesAutBP.createCase.user");
        final String password = configurationService.getConfiguration().getString("sdh.agentesAutBP.createCase.password");
        final String urlService = configurationService.getConfiguration().getString("sdh.agentesAutBP.createCase.url");

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
        final HttpEntity<AgentesAutImpuestoRequest> request = new HttpEntity<>(agentesAutImpuestoRequest);
        return restTemplate.postForObject(urlService, request, AgentesAutImpuestoResponse.class);
    }


}

package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterRequest;
import de.hybris.sdh.core.pojos.responses.PaymentServiceRegisterResponse;
import de.hybris.sdh.core.pojos.responses.QuestionForRegistrationResponse;
import de.hybris.sdh.core.services.SdhPaymentService;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class DefaultSdhPaymentService implements SdhPaymentService {

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public PaymentServiceRegisterResponse register(PaymentServiceRegisterRequest paymentServiceRegisterRequest) {
        final String urlService = configurationService.getConfiguration().getString("sdh.payment.service.register.url");
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<PaymentServiceRegisterRequest> request = new HttpEntity<>(paymentServiceRegisterRequest);
        return restTemplate.postForObject(urlService, request, PaymentServiceRegisterResponse.class);
    }
}
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterRequest;
import de.hybris.sdh.core.pojos.responses.PaymentServiceRegisterResponse;
import de.hybris.sdh.core.services.SdhPaymentService;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class DefaultSdhPaymentService implements SdhPaymentService {

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public PaymentServiceRegisterResponse register(PaymentServiceRegisterRequest paymentServiceRegisterRequest)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        final String urlService = configurationService.getConfiguration().getString("sdh.payment.service.register.url");
        final RestTemplate restTemplate = new RestTemplate(getRequestFactory());

        final HttpEntity<PaymentServiceRegisterRequest> request = new HttpEntity<>(paymentServiceRegisterRequest);
        return restTemplate.postForObject(urlService, request, PaymentServiceRegisterResponse.class);
    }

    private HttpComponentsClientHttpRequestFactory getRequestFactory() throws KeyStoreException,
            NoSuchAlgorithmException, KeyManagementException {

        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        return requestFactory;
    }
}
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.TrmReportesPDFRequest;
import de.hybris.sdh.core.pojos.responses.TrmPdfResponse;
import de.hybris.sdh.core.services.SDHTrmReportesPDF;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class DefaultSDHTrmReportesPDF implements SDHTrmReportesPDF {

    private static final Logger LOG = Logger.getLogger(DefaultSDHTrmReportesPDF.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public TrmPdfResponse getPDF(TrmReportesPDFRequest requestObject) {
        final String usuario = configurationService.getConfiguration().getString("sdh.trm.pdf..user");
        final String password = configurationService.getConfiguration().getString("sdh.trm.pdf..password");
        final String urlService = configurationService.getConfiguration().getString("sdh.trm.pdf.url");
        final HttpEntity<TrmReportesPDFRequest> request = new HttpEntity<>(requestObject);
        final RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
        return restTemplate.postForObject(urlService, request, TrmPdfResponse.class);
    }
}

package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.pojos.requests.CalcPublicidad2Request;
import de.hybris.sdh.core.pojos.responses.CalcPublicidad2Response;
import de.hybris.sdh.core.services.SDHCalPublicidad2Service;
import de.hybris.sdh.facades.SDHCalculaPublicidad2Facade;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class DefaultSDHCalculaPublicidad2Facade implements SDHCalculaPublicidad2Facade {

    private static final Logger LOG = Logger.getLogger(DefaultSDHCalculaPublicidad2Facade.class);

    @Resource(name="sdhCalPublicidad2Service")
    SDHCalPublicidad2Service sdhCalculaPublicidad2Service;

    @Override
    public CalcPublicidad2Response calcula(final CalcPublicidad2Request request) {

        String response = sdhCalculaPublicidad2Service.calcPublicidad(request);
		response = response.replace("\"},\"\"]}", "\"}]}");

        if (StringUtils.isNotBlank(response)) {
            try {
            LOG.info(response);
                final ObjectMapper mapper = new ObjectMapper();
                mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                final CalcPublicidad2Response calcPublicidad2Response = mapper.readValue(response, CalcPublicidad2Response.class);
                return calcPublicidad2Response;

            } catch (final Exception e) {
                // XXX Auto-generated catch block
                LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
                return null;

            }
        } else {
            // XXX Auto-generated catch block
            LOG.error("Empty Respnse from servive calula publicidad 2");
            return null;
        }
    }
}

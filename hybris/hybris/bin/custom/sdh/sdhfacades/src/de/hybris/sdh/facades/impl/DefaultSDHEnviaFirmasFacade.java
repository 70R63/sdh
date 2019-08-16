package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.pojos.requests.EnviaFirmasRequest;
import de.hybris.sdh.core.pojos.responses.ConsulFirmasResponse;
import de.hybris.sdh.core.pojos.responses.EnviaFirmasResponse;
import de.hybris.sdh.core.services.SDHEnviaFirmasService;
import de.hybris.sdh.core.services.impl.DefaultSDHConsultaFirmasService;
import de.hybris.sdh.facades.SDHEnviaFirmasFacade;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.annotation.Resource;

public class DefaultSDHEnviaFirmasFacade implements SDHEnviaFirmasFacade {

    private static final Logger LOG = Logger.getLogger(DefaultSDHEnviaFirmasFacade.class);

    @Resource(name="sdhEnviaFirmasService")
    SDHEnviaFirmasService sdhEnviaFirmasService;

    @Override
    public EnviaFirmasResponse enviaFirmas(EnviaFirmasRequest request) {

        String response = sdhEnviaFirmasService.enviaFirmas(request);

        if(StringUtils.isNotBlank(response))
        {
            try
            {
                final ObjectMapper mapper = new ObjectMapper();
                mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                final EnviaFirmasResponse enviaFirmasResponse = mapper.readValue(response, EnviaFirmasResponse.class);

                return enviaFirmasResponse;

            }
            catch (final Exception e)
            {

                LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());

                return null;
            }
        }

        return null;
    }
}

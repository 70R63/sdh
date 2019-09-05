package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.pojos.requests.CalcGasolina2Request;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.services.SDHCalGasolina2Service;
import de.hybris.sdh.facades.SDHCalculaGasolina2Facade;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.annotation.Resource;

public class DefaultSDHCalculaGasolina2Facade implements SDHCalculaGasolina2Facade {

    private static final Logger LOG = Logger.getLogger(DefaultSDHCalculaGasolina2Facade.class);

    @Resource(name="sdhCalGasolina2Service")
    SDHCalGasolina2Service sdhCalculaGasolina2Service;
    
    @Override
    public CalcGasolina2Response calcula(CalcGasolina2Request request) {
        String response = sdhCalculaGasolina2Service.calcGasolina2(request);

        if (StringUtils.isNotBlank(response)) {
            try {
                LOG.info(response);
                response = response.replace(",\"\"","");
                final ObjectMapper mapper = new ObjectMapper();
                mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                final CalcGasolina2Response calcGasolina2Response = mapper.readValue(response, CalcGasolina2Response.class);
                return calcGasolina2Response;

            } catch (final Exception e) {
                // XXX Auto-generated catch block
                LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
                return null;

            }
        } else {
            // XXX Auto-generated catch block
            LOG.error("Empty Respnse from servive calula Gasolina 2");
            return null;
        }
    }
}

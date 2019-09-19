package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.pojos.requests.CalcICA2Request;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.pojos.responses.ICACalculoImpResponse;
import de.hybris.sdh.core.services.SDHCalICA2Service;
import de.hybris.sdh.core.services.impl.DefaultSDHCalcICA2Service;
import de.hybris.sdh.facades.SDHCalculaICA2Facade;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.annotation.Resource;

public class DefaultSDHCalculaICA2Facade implements SDHCalculaICA2Facade {

    private static final Logger LOG = Logger.getLogger(DefaultSDHCalculaICA2Facade.class);

    @Resource(name="sdhCalculaICA2Service")
    SDHCalICA2Service sdhCalculaICA2Service;

    @Override
    public ICACalculoImpResponse calcula(CalcICA2Request request) {
        String response = sdhCalculaICA2Service.calcICA2(request);

        if (StringUtils.isNotBlank(response)) {
            try {
                LOG.info(response);

                final ObjectMapper mapper = new ObjectMapper();
                mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                final ICACalculoImpResponse icaCalculoImpResponse = mapper.readValue(response, ICACalculoImpResponse.class);
                return icaCalculoImpResponse;

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

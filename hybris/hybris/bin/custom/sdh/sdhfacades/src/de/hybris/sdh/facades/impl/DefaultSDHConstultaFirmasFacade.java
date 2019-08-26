package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.pojos.requests.ConsulFirmasRequest;
import de.hybris.sdh.core.pojos.responses.CertifNombResponse;
import de.hybris.sdh.core.pojos.responses.ConsulFirmasDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.ConsulFirmasResponse;
import de.hybris.sdh.core.services.SDHConsulFirmasService;
import de.hybris.sdh.core.services.impl.DefaultSDHConsultaFirmasService;
import de.hybris.sdh.facades.SDHConsultaFirmasFacade;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class DefaultSDHConstultaFirmasFacade implements SDHConsultaFirmasFacade {

    private static final Logger LOG = Logger.getLogger(DefaultSDHConsultaFirmasService.class);

    @Resource(name="sdhConsulFirmasService")
    SDHConsulFirmasService sdhConsulFirmasService;

    @Override
    public ConsulFirmasResponse getDeclaraciones(ConsulFirmasRequest request) {

        String response = sdhConsulFirmasService.getDeclaraciones(request);

        if(StringUtils.isNotBlank(response))
        {
            try
            {

                final ObjectMapper mapper = new ObjectMapper();
                mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                final ConsulFirmasResponse consulFirmasResponse = mapper.readValue(response, ConsulFirmasResponse.class);

                if(consulFirmasResponse != null && CollectionUtils.isNotEmpty(consulFirmasResponse.getDeclaraciones()))
                {

                    List<ConsulFirmasDeclaracionesResponse> filteredDeclas = new ArrayList<ConsulFirmasDeclaracionesResponse>();

                    for(ConsulFirmasDeclaracionesResponse eachDecla : consulFirmasResponse.getDeclaraciones())
                    {

                        if(StringUtils.isNotBlank(eachDecla.getIdDeclaracion()))
                        {
                            filteredDeclas.add(eachDecla);
                        }

                    }

                    consulFirmasResponse.setDeclaraciones(filteredDeclas);
                }

                return consulFirmasResponse;

            }
            catch (final Exception e)
            {
                // XXX Auto-generated catch block
                LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());

                return null;

            }
        }

        return null;
    }
}

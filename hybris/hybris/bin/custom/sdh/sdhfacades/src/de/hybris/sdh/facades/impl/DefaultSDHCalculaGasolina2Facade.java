package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.pojos.requests.CalcGasolina2Request;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.services.SDHCalGasolina2Service;
import de.hybris.sdh.facades.SDHCalculaGasolina2Facade;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class DefaultSDHCalculaGasolina2Facade implements SDHCalculaGasolina2Facade {

    private static final Logger LOG = Logger.getLogger(DefaultSDHCalculaGasolina2Facade.class);

    @Resource(name="sdhCalGasolina2Service")
    SDHCalGasolina2Service sdhCalculaGasolina2Service;

    @Override
    public CalcGasolina2Response calcula(final CalcGasolina2Request request) {
        String response = sdhCalculaGasolina2Service.calcGasolina2(request);

        if (StringUtils.isNotBlank(response)) {
            try {
                LOG.info(response);
                response = response.replace(",\"\"","");
				response = response.replace("\"Clase_prod\":", "\"claseProd\":");
				response = response.replace("\"Galones_gra\":", "\"galonesGra\":");
				response = response.replace("\"Precio_ref\":", "\"precioRef\":");
				response = response.replace("\"Alcohol_carbu\":", "\"alcoholCarbu\":");
				response = response.replace("\"Base_gravable\":", "\"baseGravable\":");
				response = response.replace("\"Vlr_sobretasa\":", "\"vlrSobretasa\":");
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

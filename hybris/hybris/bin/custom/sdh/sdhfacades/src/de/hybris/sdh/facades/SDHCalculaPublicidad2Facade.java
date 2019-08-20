package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.CalcPublicidad2Request;
import de.hybris.sdh.core.pojos.responses.CalcPublicidad2Response;

public interface SDHCalculaPublicidad2Facade {

    CalcPublicidad2Response calcula (CalcPublicidad2Request request);

}

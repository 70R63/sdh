package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.CalcGasolina2Request;
import de.hybris.sdh.core.pojos.requests.CalcPublicidad2Request;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.pojos.responses.CalcPublicidad2Response;

public interface SDHCalculaGasolina2Facade {

    CalcGasolina2Response calcula(CalcGasolina2Request request);

}

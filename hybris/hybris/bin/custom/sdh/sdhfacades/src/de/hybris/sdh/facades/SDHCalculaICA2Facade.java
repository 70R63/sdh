package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.CalcGasolina2Request;
import de.hybris.sdh.core.pojos.requests.CalcICA2Request;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.pojos.responses.ICACalculoImpResponse;

public interface SDHCalculaICA2Facade {

    ICACalculoImpResponse calcula(CalcICA2Request request);

}

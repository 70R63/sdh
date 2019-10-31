package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.CalcICA2Request;
import de.hybris.sdh.core.pojos.responses.CalcICA2Response;

public interface SDHCalculaICA2Facade {

	CalcICA2Response calcula(CalcICA2Request request);

}

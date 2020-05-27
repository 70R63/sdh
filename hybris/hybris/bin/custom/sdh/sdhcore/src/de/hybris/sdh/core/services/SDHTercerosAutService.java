package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.TercerosAutRequest;
import de.hybris.sdh.core.pojos.responses.TercerosAutResponse;

public interface SDHTercerosAutService {
    TercerosAutResponse getTercerosAut(TercerosAutRequest request) throws Exception;
}

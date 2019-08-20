package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.EnviaFirmasRequest;
import de.hybris.sdh.core.pojos.responses.EnviaFirmasResponse;

public interface SDHEnviaFirmasFacade {
    EnviaFirmasResponse enviaFirmas(EnviaFirmasRequest request);
}

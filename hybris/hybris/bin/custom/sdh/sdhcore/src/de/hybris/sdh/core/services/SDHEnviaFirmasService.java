package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ConsulFirmasRequest;
import de.hybris.sdh.core.pojos.requests.EnviaFirmasRequest;

public interface SDHEnviaFirmasService {

    String enviaFirmas(EnviaFirmasRequest request);

}

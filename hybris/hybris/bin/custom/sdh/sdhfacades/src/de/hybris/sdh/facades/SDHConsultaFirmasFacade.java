package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.ConsulFirmasRequest;
import de.hybris.sdh.core.pojos.responses.ConsulFirmasDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.ConsulFirmasResponse;

import java.util.List;

public interface SDHConsultaFirmasFacade {
    ConsulFirmasResponse getDeclaraciones(ConsulFirmasRequest request);
}

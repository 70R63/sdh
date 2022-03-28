package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.ConsulFirmasRequest;
import de.hybris.sdh.core.pojos.responses.ConsulFirmasResponse;

import java.util.Map;


public interface SDHConsultaFirmasFacade {
    ConsulFirmasResponse getDeclaraciones(ConsulFirmasRequest request);

	 void filtrarFirmas(ConsulFirmasResponse declaraciones, Map<String, String> impuestosActivos);
}

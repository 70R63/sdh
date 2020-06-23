package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.AgentesAutBpRequest;
import de.hybris.sdh.core.pojos.requests.AgentesAutImpuestoRequest;
import de.hybris.sdh.core.pojos.requests.ListCalidadRequest;
import de.hybris.sdh.core.pojos.responses.AgentesAutBpResponse;
import de.hybris.sdh.core.pojos.responses.AgentesAutImpuestoResponse;
import de.hybris.sdh.core.pojos.responses.ListDocumentoResponse;

public interface SDHAgentesAutBPService {
    AgentesAutBpResponse getAgentesAutBp(AgentesAutBpRequest agentesAutBpRequest);
    ListDocumentoResponse getCalidades(ListCalidadRequest listCalidadRequest);
    AgentesAutImpuestoResponse createCase(AgentesAutImpuestoRequest agentesAutImpuestoRequest);
}

package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.sdh.core.pojos.requests.AgentesAutBpRequest;
import de.hybris.sdh.core.pojos.requests.AgentesAutImpuestoRequest;
import de.hybris.sdh.core.pojos.requests.AutorizacionRequest;
import de.hybris.sdh.core.pojos.requests.CalidadRequest;
import de.hybris.sdh.core.pojos.requests.ImpuestoRequest;
import de.hybris.sdh.core.pojos.requests.ListCalidadRequest;
import de.hybris.sdh.core.pojos.responses.AgentesAutBpResponse;
import de.hybris.sdh.core.pojos.responses.AgentesAutImpuestoResponse;
import de.hybris.sdh.core.pojos.responses.DocumentoResponse;
import de.hybris.sdh.core.pojos.responses.ListDocumentoResponse;
import de.hybris.sdh.core.services.SDHAgentesAutBPService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agentesAut")
public class AgentesAutController {

    private static final Logger LOG = Logger.getLogger(AgentesAutController.class);

    @Resource(name = "sdhAgentesAutBPService")
    SDHAgentesAutBPService sdhAgentesAutBPService;

    @RequestMapping("/getBp")
    public AgentesAutBpResponse getBp(@RequestParam(value="tipoId", defaultValue="") final String tipoId,
                                      @RequestParam(value="numId", defaultValue="") final String numId,
                                      @RequestParam(value="fechaExp", defaultValue="") final String fechaExp){

		AgentesAutBpResponse response = null;

        final AgentesAutBpRequest request = new AgentesAutBpRequest(tipoId,numId,fechaExp);

		System.out.println("Request de /crm/agentesAutBP: " + request);
		response = sdhAgentesAutBPService.getAgentesAutBp(request);
		System.out.println("Response de /crm/agentesAutBP: " + response);

		return response;
    }

    @RequestMapping("/createAgente")
    public AgentesAutImpuestoResponse createAgente(@RequestParam(value="calidades", defaultValue="") final String calidades,
                                              @RequestParam(value="impuestos", defaultValue="") final String impuestos,
                                              @RequestParam(value="autorizaciones", defaultValue="") final String autorizaciones){
        LOG.info("calidades: "+calidades);
        LOG.info("impuestos: "+impuestos);
        LOG.info("autorizaciones: "+autorizaciones);
        List<String> list;

        //Creating Calidades List
        final List<CalidadRequest> calidadesList = new ArrayList<>();
        list = Arrays.asList(calidades.split(" "));
        list.forEach(calidad ->{ calidadesList.add(new CalidadRequest(calidad)); });

        //Getting Documents List
        final ListCalidadRequest calidadRequest = new ListCalidadRequest();
        calidadRequest.setCalidades(calidadesList);
        final ListDocumentoResponse documentosResponse = sdhAgentesAutBPService.getCalidades(calidadRequest);

        //Creating Impuestos List
        final List<ImpuestoRequest> impuestosList = new ArrayList<>();
        list = Arrays.asList(impuestos.split(" "));
        list.forEach(impuesto ->{ impuestosList.add(new ImpuestoRequest(impuesto)); });

        //Creating Autorizaciones List
        final List<AutorizacionRequest> autorizacionesList = new ArrayList<>();
        list = Arrays.asList(autorizaciones.split(" "));
        list.forEach(autorizacion ->{ autorizacionesList.add(new AutorizacionRequest(autorizacion)); });

        final AgentesAutImpuestoRequest agentesAutImpuestoRequest = new AgentesAutImpuestoRequest();
        agentesAutImpuestoRequest.setDocumentosAdjuntos(Objects.nonNull(documentosResponse) ?
                documentosResponse.getDocumentos() : new ArrayList<DocumentoResponse>());
        agentesAutImpuestoRequest.setImpuestos(impuestosList);
        agentesAutImpuestoRequest.setCalidades(calidadesList);
        agentesAutImpuestoRequest.setAutorizaciones(autorizacionesList);

        return sdhAgentesAutBPService.createCase(agentesAutImpuestoRequest);
    }

}

package de.hybris.sdh.storefront.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.hybris.sdh.core.pojos.requests.*;
import de.hybris.sdh.core.pojos.responses.AgentesAutBpResponse;
import de.hybris.sdh.core.pojos.responses.AgentesAutImpuestoResponse;
import de.hybris.sdh.core.pojos.responses.DocumentoResponse;
import de.hybris.sdh.core.pojos.responses.ListDocumentoResponse;
import de.hybris.sdh.core.services.SDHAgentesAutBPService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

        AgentesAutBpRequest request = new AgentesAutBpRequest(tipoId,numId,fechaExp);
        return sdhAgentesAutBPService.getAgentesAutBp(request);
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
        List<CalidadRequest> calidadesList = new ArrayList<>();
        list = Arrays.asList(calidades.split(" "));
        list.forEach(calidad ->{ calidadesList.add(new CalidadRequest(calidad)); });

        //Getting Documents List
        ListCalidadRequest calidadRequest = new ListCalidadRequest();
        calidadRequest.setCalidades(calidadesList);
        ListDocumentoResponse documentosResponse = sdhAgentesAutBPService.getCalidades(calidadRequest);

        //Creating Impuestos List
        List<ImpuestoRequest> impuestosList = new ArrayList<>();
        list = Arrays.asList(impuestos.split(" "));
        list.forEach(impuesto ->{ impuestosList.add(new ImpuestoRequest(impuesto)); });

        //Creating Autorizaciones List
        List<AutorizacionRequest> autorizacionesList = new ArrayList<>();
        list = Arrays.asList(autorizaciones.split(" "));
        list.forEach(autorizacion ->{ autorizacionesList.add(new AutorizacionRequest(autorizacion)); });

        AgentesAutImpuestoRequest agentesAutImpuestoRequest = new AgentesAutImpuestoRequest();
        agentesAutImpuestoRequest.setDocumentosAdjuntos(Objects.nonNull(documentosResponse) ?
                documentosResponse.getDocumentos() : new ArrayList<DocumentoResponse>());
        agentesAutImpuestoRequest.setImpuestos(impuestosList);
        agentesAutImpuestoRequest.setCalidades(calidadesList);
        agentesAutImpuestoRequest.setAutorizaciones(autorizacionesList);

        return sdhAgentesAutBPService.createCase(agentesAutImpuestoRequest);
    }

}

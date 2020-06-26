package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.DocumentoResponse;

import java.util.List;

public class AgentesAutImpuestoRequest {
    private List<CalidadRequest> calidades;
    private List<ImpuestoRequest> impuestos;
    private List<AutorizacionRequest> autorizaciones;
    private List<DocumentoResponse> documentosAdjuntos;

    public List<CalidadRequest> getCalidades() {
        return calidades;
    }

    public void setCalidades(List<CalidadRequest> calidades) {
        this.calidades = calidades;
    }

    public List<ImpuestoRequest> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<ImpuestoRequest> impuestos) {
        this.impuestos = impuestos;
    }

    public List<AutorizacionRequest> getAutorizaciones() {
        return autorizaciones;
    }

    public void setAutorizaciones(List<AutorizacionRequest> autorizaciones) {
        this.autorizaciones = autorizaciones;
    }

    public List<DocumentoResponse> getDocumentosAdjuntos() {
        return documentosAdjuntos;
    }

    public void setDocumentosAdjuntos(List<DocumentoResponse> documentosAdjuntos) {
        this.documentosAdjuntos = documentosAdjuntos;
    }
}

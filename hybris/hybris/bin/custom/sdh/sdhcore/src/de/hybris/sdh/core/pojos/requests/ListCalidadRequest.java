package de.hybris.sdh.core.pojos.requests;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class ListCalidadRequest {
    private List<CalidadRequest> Calidades;

    public List<CalidadRequest> getCalidades() {
        return Calidades;
    }

    @JsonProperty("Calidades")
    public void setCalidades(List<CalidadRequest> calidades) {
        Calidades = calidades;
    }
}

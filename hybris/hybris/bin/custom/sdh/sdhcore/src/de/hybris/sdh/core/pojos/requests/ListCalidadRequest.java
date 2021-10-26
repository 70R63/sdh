package de.hybris.sdh.core.pojos.requests;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;


public class ListCalidadRequest {
    private List<CalidadRequest> Calidades;

    public List<CalidadRequest> getCalidades() {
        return Calidades;
    }

	 @JsonSetter("Calidades")
    public void setCalidades(final List<CalidadRequest> calidades) {
        Calidades = calidades;
    }
}

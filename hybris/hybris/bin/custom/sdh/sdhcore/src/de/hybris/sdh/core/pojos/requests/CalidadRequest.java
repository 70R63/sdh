package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CalidadRequest {

    private String IdCalidad;

    public CalidadRequest(String idCalidad) {
        IdCalidad = idCalidad;
    }


    public String getIdCalidad() {
        return IdCalidad;
    }

    @JsonProperty("IdCalidad")
    public void setIdCalidad(String idCalidad) {
        IdCalidad = idCalidad;
    }

    @Override
    public String toString() {
        return "CalidadRequest{" +
                "IdCalidad='" + IdCalidad + '\'' +
                '}';
    }
}

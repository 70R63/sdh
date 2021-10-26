package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonSetter;

public class CalidadRequest {

    private String IdCalidad;

    public CalidadRequest(final String idCalidad) {
        IdCalidad = idCalidad;
    }


    public String getIdCalidad() {
        return IdCalidad;
    }

	 @JsonSetter("IdCalidad")
    public void setIdCalidad(final String idCalidad) {
        IdCalidad = idCalidad;
    }

    @Override
    public String toString() {
        return "CalidadRequest{" +
                "IdCalidad='" + IdCalidad + '\'' +
                '}';
    }
}

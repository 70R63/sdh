package de.hybris.sdh.core.pojos.responses;

import java.util.List;

public class ConsulFirmasResponse {

    List<ConsulFirmasDeclaracionesResponse> declaraciones;

    public List<ConsulFirmasDeclaracionesResponse> getDeclaraciones() {
        return declaraciones;
    }

    public void setDeclaraciones(List<ConsulFirmasDeclaracionesResponse> declaraciones) {
        this.declaraciones = declaraciones;
    }
}

package de.hybris.sdh.core.pojos.requests;

public class AutorizacionRequest {
    private String idAutorizacion;


    public AutorizacionRequest(String idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public String getIdAutorizacion() {
        return idAutorizacion;
    }

    public void setIdAutorizacion(String idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }
}

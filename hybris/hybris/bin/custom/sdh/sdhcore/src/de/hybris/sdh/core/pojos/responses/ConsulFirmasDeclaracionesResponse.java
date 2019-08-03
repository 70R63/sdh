package de.hybris.sdh.core.pojos.responses;

public class ConsulFirmasDeclaracionesResponse {

    String idDeclaracion;
    String impuesto;
    String anioGravable;
    String periodo;

    public String getIdDeclaracion() {
        return idDeclaracion;
    }

    public void setIdDeclaracion(String idDeclaracion) {
        this.idDeclaracion = idDeclaracion;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getAnioGravable() {
        return anioGravable;
    }

    public void setAnioGravable(String anioGravable) {
        this.anioGravable = anioGravable;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}

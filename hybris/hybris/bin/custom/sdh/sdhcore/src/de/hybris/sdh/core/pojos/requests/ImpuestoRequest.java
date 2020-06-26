package de.hybris.sdh.core.pojos.requests;

public class ImpuestoRequest {
    private String idImpuesto;

    public ImpuestoRequest(String idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(String idImpuesto) {
        this.idImpuesto = idImpuesto;
    }
}

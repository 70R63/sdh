package de.hybris.sdh.core.pojos.responses;

public class AgentesAutBpResponse {
    private String tipoId;
    private String numDoc;
    private String nomAgen;
    private String tipoPers;


    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getNomAgen() {
        return nomAgen;
    }

    public void setNomAgen(String nomAgen) {
        this.nomAgen = nomAgen;
    }

    public String getTipoPers() {
        return tipoPers;
    }

    public void setTipoPers(String tipoPers) {
        this.tipoPers = tipoPers;
    }

    @Override
    public String toString() {
        return "AgentesAutBpRequest{" +
                "tipoId='" + tipoId + '\'' +
                ", numDoc='" + numDoc + '\'' +
                ", nomAgen='" + nomAgen + '\'' +
                ", tipoPers='" + tipoPers + '\'' +
                '}';
    }
}

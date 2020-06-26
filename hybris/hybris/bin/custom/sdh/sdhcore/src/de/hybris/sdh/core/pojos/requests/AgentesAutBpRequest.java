package de.hybris.sdh.core.pojos.requests;

public class AgentesAutBpRequest {
    private String tipoId;
    private String numId;
    private String fechaExp;

    public AgentesAutBpRequest(String tipoId, String numId, String fechaExp) {
        this.tipoId = tipoId;
        this.numId = numId;
        this.fechaExp = fechaExp;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    @Override
    public String toString() {
        return "AgentesAutBpRequest{" +
                "tipoId='" + tipoId + '\'' +
                ", numId='" + numId + '\'' +
                ", fechaExp='" + fechaExp + '\'' +
                '}';
    }
}

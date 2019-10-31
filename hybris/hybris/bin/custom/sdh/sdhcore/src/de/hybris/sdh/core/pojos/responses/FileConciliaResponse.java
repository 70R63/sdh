package de.hybris.sdh.core.pojos.responses;

public class FileConciliaResponse {
    private String idEnvio;
    private String numIntento;
    private String msjResp;

    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getNumIntento() {
        return numIntento;
    }

    public void setNumIntento(String numIntento) {
        this.numIntento = numIntento;
    }

    public String getMsjResp() {
        return msjResp;
    }

    public void setMsjResp(String msjResp) {
        this.msjResp = msjResp;
    }

    @Override
    public String toString() {
        return "FileConciliaResponse{" +
                "idEnvio='" + idEnvio + '\'' +
                ", numIntento='" + numIntento + '\'' +
                ", msjResp='" + msjResp + '\'' +
                '}';
    }
}

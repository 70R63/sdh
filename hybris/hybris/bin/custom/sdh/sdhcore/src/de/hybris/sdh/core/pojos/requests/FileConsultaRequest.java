package de.hybris.sdh.core.pojos.requests;

public class FileConsultaRequest {
    private String CODBK;
    private String idEnvio;
    private String tipoFile;
    private String nroSecuencia;
    private String estado;
    private String fchEnvio;

    public FileConsultaRequest() {
    }

    public FileConsultaRequest(String CODBK, String idEnvio, String tipoFile, String nroSecuencia, String estado, String fchEnvio) {
        this.CODBK = CODBK;
        this.idEnvio = idEnvio;
        this.tipoFile = tipoFile;
        this.nroSecuencia = nroSecuencia;
        this.estado = estado;
        this.fchEnvio = fchEnvio;
    }

    public String getCODBK() {
        return CODBK;
    }

    public void setCODBK(String CODBK) {
        this.CODBK = CODBK;
    }

    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getTipoFile() {
        return tipoFile;
    }

    public void setTipoFile(String tipoFile) {
        this.tipoFile = tipoFile;
    }

    public String getNroSecuencia() {
        return nroSecuencia;
    }

    public void setNroSecuencia(String nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFchEnvio() {
        return fchEnvio;
    }

    public void setFchEnvio(String fchEnvio) {
        this.fchEnvio = fchEnvio;
    }

    @Override
    public String toString() {
        return "FileConsultaRequest{" +
                "CODBK='" + CODBK + '\'' +
                ", idEnvio='" + idEnvio + '\'' +
                ", tipoFile='" + tipoFile + '\'' +
                ", nroSecuencia='" + nroSecuencia + '\'' +
                ", estado='" + estado + '\'' +
                ", fchEnvio='" + fchEnvio + '\'' +
                '}';
    }
}

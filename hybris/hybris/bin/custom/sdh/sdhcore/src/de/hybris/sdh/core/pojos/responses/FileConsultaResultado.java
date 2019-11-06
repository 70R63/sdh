package de.hybris.sdh.core.pojos.responses;

public class FileConsultaResultado {
    private String idEnvio;
    private String tipoFile;
    private String nroSecuencia;
    private String estado;
    private String fchEnvio;
    private String stringFile;

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

    public String getStringFile() {
        return stringFile;
    }

    public void setStringFile(String stringFile) {
        this.stringFile = stringFile;
    }

    @Override
    public String toString() {
        return "FileConsultaResultado{" +
                "idEnvio='" + idEnvio + '\'' +
                ", tipoFile='" + tipoFile + '\'' +
                ", nroSecuencia='" + nroSecuencia + '\'' +
                ", estado='" + estado + '\'' +
                ", fchEnvio='" + fchEnvio + '\'' +
                ", stringFile='" + stringFile + '\'' +
                '}';
    }
}

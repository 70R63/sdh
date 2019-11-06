package de.hybris.sdh.core.form;

public class FileConsultaForm {
    private String idenvio;
    private String nosecuencia;
    private String tiparchivo;
    private String tipresultado;
    private String fecenvio;
    private String fecnoti;

    public String getIdenvio() {
        return idenvio;
    }

    public void setIdenvio(String idenvio) {
        this.idenvio = idenvio;
    }

    public String getNosecuencia() {
        return nosecuencia;
    }

    public void setNosecuencia(String nosecuencia) {
        this.nosecuencia = nosecuencia;
    }

    public String getTiparchivo() {
        return tiparchivo;
    }

    public void setTiparchivo(String tiparchivo) {
        this.tiparchivo = tiparchivo;
    }

    public String getTipresultado() {
        return tipresultado;
    }

    public void setTipresultado(String tipresultado) {
        this.tipresultado = tipresultado;
    }

    public String getFecenvio() {
        return fecenvio;
    }

    public void setFecenvio(String fecenvio) {
        this.fecenvio = fecenvio;
    }

    public String getFecnoti() {
        return fecnoti;
    }

    public void setFecnoti(String fecnoti) {
        this.fecnoti = fecnoti;
    }

    @Override
    public String toString() {
        return "FileConsultaForm{" +
                "idenvio='" + idenvio + '\'' +
                ", nosecuencia='" + nosecuencia + '\'' +
                ", tiparchivo='" + tiparchivo + '\'' +
                ", tipresultado='" + tipresultado + '\'' +
                ", fecenvio='" + fecenvio + '\'' +
                ", fecnoti='" + fecnoti + '\'' +
                '}';
    }
}

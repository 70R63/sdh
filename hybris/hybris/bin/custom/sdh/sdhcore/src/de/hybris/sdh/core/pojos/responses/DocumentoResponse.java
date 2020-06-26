package de.hybris.sdh.core.pojos.responses;
import com.fasterxml.jackson.annotation.JsonSetter;

public class DocumentoResponse {
    private String DEPENDENCIA;
    private String DEPENDENCIA_T;
    private String SERIE;
    private String SERIE_T;
    private String SUBSERIE;
    private String SUBSERIE_T;
    private String TIPO_DOCUMEN;
    private String TIPO_DOCUMEN_T;
    private String OBLIGATORIO;


    public String getDEPENDENCIA() {
        return DEPENDENCIA;
    }

    @JsonSetter("DEPENDENCIA")
    public void setDEPENDENCIA(String DEPENDENCIA) {
        this.DEPENDENCIA = DEPENDENCIA;
    }

    public String getDEPENDENCIA_T() {
        return DEPENDENCIA_T;
    }

    @JsonSetter("DEPENDENCIA_T")
    public void setDEPENDENCIA_T(String DEPENDENCIA_T) {
        this.DEPENDENCIA_T = DEPENDENCIA_T;
    }

    public String getSERIE() {
        return SERIE;
    }

    @JsonSetter("SERIE")
    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }

    public String getSERIE_T() {
        return SERIE_T;
    }

    @JsonSetter("SERIE_T")
    public void setSERIE_T(String SERIE_T) {
        this.SERIE_T = SERIE_T;
    }

    public String getSUBSERIE() {
        return SUBSERIE;
    }

    @JsonSetter("SUBSERIE")
    public void setSUBSERIE(String SUBSERIE) {
        this.SUBSERIE = SUBSERIE;
    }

    public String getSUBSERIE_T() {
        return SUBSERIE_T;
    }

    @JsonSetter("SUBSERIE_T")
    public void setSUBSERIE_T(String SUBSERIE_T) {
        this.SUBSERIE_T = SUBSERIE_T;
    }

    public String getTIPO_DOCUMEN() {
        return TIPO_DOCUMEN;
    }

    @JsonSetter("TIPO_DOCUMEN")
    public void setTIPO_DOCUMEN(String TIPO_DOCUMEN) {
        this.TIPO_DOCUMEN = TIPO_DOCUMEN;
    }

    public String getTIPO_DOCUMEN_T() {
        return TIPO_DOCUMEN_T;
    }

    @JsonSetter("TIPO_DOCUMEN_T")
    public void setTIPO_DOCUMEN_T(String TIPO_DOCUMEN_T) {
        this.TIPO_DOCUMEN_T = TIPO_DOCUMEN_T;
    }

    public String getOBLIGATORIO() {
        return OBLIGATORIO;
    }

    @JsonSetter("OBLIGATORIO")
    public void setOBLIGATORIO(String OBLIGATORIO) {
        this.OBLIGATORIO = OBLIGATORIO;
    }

    @Override
    public String toString() {
        return "DocumentoResponse{" +
                "DEPENDENCIA='" + DEPENDENCIA + '\'' +
                ", DEPENDENCIA_T='" + DEPENDENCIA_T + '\'' +
                ", SERIE='" + SERIE + '\'' +
                ", SERIE_T='" + SERIE_T + '\'' +
                ", SUBSERIE='" + SUBSERIE + '\'' +
                ", SUBSERIE_T='" + SUBSERIE_T + '\'' +
                ", TIPO_DOCUMEN='" + TIPO_DOCUMEN + '\'' +
                ", TIPO_DOCUMEN_T='" + TIPO_DOCUMEN_T + '\'' +
                ", OBLIGATORIO='" + OBLIGATORIO + '\'' +
                '}';
    }
}

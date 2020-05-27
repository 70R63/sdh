package de.hybris.sdh.core.pojos.requests;

import org.codehaus.jackson.annotate.JsonProperty;

public class TercerosAutRequest {
    private String TIPO_DOCUMENTO;
    private String IMPUESTO;
    private String NUMERO_DOCUMENTO;
    private String NUMERO_OBJETO;

    public TercerosAutRequest(String TIPO_DOCUMENTO, String IMPUESTO, String NUMERO_DOCUMENTO, String NUMERO_OBJETO) {
        this.TIPO_DOCUMENTO = TIPO_DOCUMENTO;
        this.IMPUESTO = IMPUESTO;
        this.NUMERO_DOCUMENTO = NUMERO_DOCUMENTO;
        this.NUMERO_OBJETO = NUMERO_OBJETO;
    }

    public String getTIPO_DOCUMENTO() {
        return TIPO_DOCUMENTO;
    }

    @JsonProperty("TIPO_DOCUMENTO")
    public void setTIPO_DOCUMENTO(String TIPO_DOCUMENTO) {
        this.TIPO_DOCUMENTO = TIPO_DOCUMENTO;
    }

    public String getIMPUESTO() {
        return IMPUESTO;
    }

    @JsonProperty("IMPUESTO")
    public void setIMPUESTO(String IMPUESTO) {
        this.IMPUESTO = IMPUESTO;
    }

    public String getNUMERO_DOCUMENTO() {
        return NUMERO_DOCUMENTO;
    }

    @JsonProperty("NUMERO_DOCUMENTO")
    public void setNUMERO_DOCUMENTO(String NUMERO_DOCUMENTO) {
        this.NUMERO_DOCUMENTO = NUMERO_DOCUMENTO;
    }

    public String getNUMERO_OBJETO() {
        return NUMERO_OBJETO;
    }

    @JsonProperty("NUMERO_OBJETO")
    public void setNUMERO_OBJETO(String NUMERO_OBJETO) {
        this.NUMERO_OBJETO = NUMERO_OBJETO;
    }

    @Override
    public String toString() {
        return "TercerosAutRequest{" +
                "TIPO_DOCUMENTO='" + TIPO_DOCUMENTO + '\'' +
                ", IMPUESTO='" + IMPUESTO + '\'' +
                ", NUMERO_DOCUMENTO='" + NUMERO_DOCUMENTO + '\'' +
                ", NUMERO_OBJETO='" + NUMERO_OBJETO + '\'' +
                '}';
    }
}

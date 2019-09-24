package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;

public class FirmanteResponse {

    private String tipoIdent;
    private String numIdent;
    private String nombre;
    private String tarjetaProd;


    public String getTipoIdent() {
        return tipoIdent;
    }

    @JsonProperty("Tipo_ident")
    public void setTipoIdent(String tipoIdent) {
        this.tipoIdent = tipoIdent;
    }

    public String getNumIdent() {
        return numIdent;
    }

    @JsonProperty("Num_identif")
    public void setNumIdent(String numIdent) {
        this.numIdent = numIdent;
    }

    public String getNombre() {
        return nombre;
    }

    @JsonProperty("Nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTarjetaProd() {
        return tarjetaProd;
    }

    @JsonProperty("Tarjeta_prof")
    public void setTarjetaProd(String tarjetaProd) {
        this.tarjetaProd = tarjetaProd;
    }
}

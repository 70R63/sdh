package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;

public class FirmanteResponse {

    private String Tipo_ident;
    private String Num_identif;
    private String Nombre;

    public String getTipo_ident() {
        return Tipo_ident;
    }
    @JsonProperty("Tipo_ident")
    public void setTipo_ident(String tipo_ident) {
        Tipo_ident = tipo_ident;
    }

    public String getNum_identif() {
        return Num_identif;
    }
    @JsonProperty("Num_identif")
    public void setNum_identif(String num_identif) {
        Num_identif = num_identif;
    }

    public String getNombre() {
        return Nombre;
    }
    @JsonProperty("Nombre")
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}

package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;

public class PredialResponse {
    private String CHIP;
    private String matrInmobiliaria;
    private String direccionPredio;
    private String contratoArrenda;
    private String anioGravable;
    private String numObjeto;

    public String getCHIP() {
        return CHIP;
    }

    @JsonProperty("CHIP")
    public void setCHIP(String CHIP) {
        this.CHIP = CHIP;
    }

    public String getMatrInmobiliaria() {
        return matrInmobiliaria;
    }

    public void setMatrInmobiliaria(String matrInmobiliaria) {
        this.matrInmobiliaria = matrInmobiliaria;
    }

    public String getDireccionPredio() {
        return direccionPredio;
    }

    public void setDireccionPredio(String direccionPredio) {
        this.direccionPredio = direccionPredio;
    }

    public String getContratoArrenda() {
        return contratoArrenda;
    }

    public void setContratoArrenda(String contratoArrenda) {
        this.contratoArrenda = contratoArrenda;
    }

    public String getAnioGravable() {
        return anioGravable;
    }

    public void setAnioGravable(String anioGravable) {
        this.anioGravable = anioGravable;
    }

    public String getNumObjeto() {
        return numObjeto;
    }

    public void setNumObjeto(String numObjeto) {
        this.numObjeto = numObjeto;
    }

    @Override
    public String toString() {
        return "PredialResponse{" +
                "CHIP='" + CHIP + '\'' +
                ", matrInmobiliaria='" + matrInmobiliaria + '\'' +
                ", direccionPredio='" + direccionPredio + '\'' +
                ", contratoArrenda='" + contratoArrenda + '\'' +
                ", anioGravable='" + anioGravable + '\'' +
                ", numObjeto='" + numObjeto + '\'' +
                '}';
    }
}

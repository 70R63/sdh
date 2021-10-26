package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;

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

	 @JsonSetter("CHIP")
    public void setCHIP(final String CHIP) {
        this.CHIP = CHIP;
    }

    public String getMatrInmobiliaria() {
        return matrInmobiliaria;
    }

    public void setMatrInmobiliaria(final String matrInmobiliaria) {
        this.matrInmobiliaria = matrInmobiliaria;
    }

    public String getDireccionPredio() {
        return direccionPredio;
    }

    public void setDireccionPredio(final String direccionPredio) {
        this.direccionPredio = direccionPredio;
    }

    public String getContratoArrenda() {
        return contratoArrenda;
    }

    public void setContratoArrenda(final String contratoArrenda) {
        this.contratoArrenda = contratoArrenda;
    }

    public String getAnioGravable() {
        return anioGravable;
    }

    public void setAnioGravable(final String anioGravable) {
        this.anioGravable = anioGravable;
    }

    public String getNumObjeto() {
        return numObjeto;
    }

    public void setNumObjeto(final String numObjeto) {
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

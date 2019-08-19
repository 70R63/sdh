package de.hybris.sdh.core.pojos.requests;

public class Firmante {

    private String tipoIdent;
    private String numIdentif;
    private String firmante;
    private String confirmacion;

    public String getTipoIdent() {
        return tipoIdent;
    }

    public void setTipoIdent(String tipoIdent) {
        this.tipoIdent = tipoIdent;
    }

    public String getNumIdentif() {
        return numIdentif;
    }

    public void setNumIdentif(String numIdentif) {
        this.numIdentif = numIdentif;
    }

    public String getFirmante() {
        return firmante;
    }

    public void setFirmante(String firmante) {
        this.firmante = firmante;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }
}

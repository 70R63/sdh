package de.hybris.sdh.storefront.controllers.rest.entity;

public class PseTransactionInformationRequestEntity {
    private String bankCode;
    private String tipoDeImpuesto;
    private String numeroDeReferencia;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getTipoDeImpuesto() {
        return tipoDeImpuesto;
    }

    public void setTipoDeImpuesto(String tipoDeImpuesto) {
        this.tipoDeImpuesto = tipoDeImpuesto;
    }

    public String getNumeroDeReferencia() {
        return numeroDeReferencia;
    }

    public void setNumeroDeReferencia(String numeroDeReferencia) {
        this.numeroDeReferencia = numeroDeReferencia;
    }
}

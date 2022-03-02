package de.hybris.sdh.storefront.controllers.rest.entity;

public class GetTransactionInformationEntity {
    private PseTransactionInformationRequestEntity transactionInfRequestEntity;
    private String trazabilityCode;

    public PseTransactionInformationRequestEntity getTransactionInfRequestEntity() {
        return transactionInfRequestEntity;
    }

    public void setTransactionInfRequestEntity(PseTransactionInformationRequestEntity transactionInfRequestEntity) {
        this.transactionInfRequestEntity = transactionInfRequestEntity;
    }

    public String getTrazabilityCode() {
        return trazabilityCode;
    }

    public void setTrazabilityCode(String trazabilityCode) {
        this.trazabilityCode = trazabilityCode;
    }
}

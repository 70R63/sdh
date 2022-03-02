package de.hybris.sdh.storefront.controllers.rest.entity;

import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType;

public class CreateTransactionPaymentRequestEntity {
    private PseTransactionInformationRequestEntity transactionInfRequestEntity;
    private CreateTransactionPaymentInformationType transactionPaymentInf;

    public PseTransactionInformationRequestEntity getTransactionInfRequestEntity() {
        return transactionInfRequestEntity;
    }

    public void setTransactionInfRequestEntity(PseTransactionInformationRequestEntity transactionInfRequestEntity) {
        this.transactionInfRequestEntity = transactionInfRequestEntity;
    }

    public CreateTransactionPaymentInformationType getTransactionPaymentInf() {
        return transactionPaymentInf;
    }

    public void setTransactionPaymentInf(CreateTransactionPaymentInformationType transactionPaymentInf) {
        this.transactionPaymentInf = transactionPaymentInf;
    }
}

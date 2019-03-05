/**
 * MainServicesSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse;

public interface MainServicesSoap extends java.rmi.Remote {

    /**
     * Return the bank list for this entity
     */
    public de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType[] getBankList(de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType getBankListInformation) throws java.rmi.RemoteException;

    /**
     * Creates the transaction
     */
    public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType createTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType createTransactionPaymentInformation) throws java.rmi.RemoteException;

    /**
     * Confirm the transaction
     */
    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType confirmTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType confirmTransactionPaymentInformation) throws java.rmi.RemoteException;

    /**
     * Return the transaction information
     */
    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType getTransactionInformation(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType getTransactionInformationBody) throws java.rmi.RemoteException;

    /**
     * Finish the transaction
     */
    public de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformation) throws java.rmi.RemoteException;

    /**
     * Get the conciliation files for entity or bank
     */
    public void getConciliationFile(de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileInformationType getConciliationFileInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseFileTypeArrayHolder files, de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException;

    /**
     * Get the ACH files
     */
    public void getFilesACH(de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHInformationType getFilesACHInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseFileTypeArrayHolder files, de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException;

    /**
     * Creates the transaction using multiples credits
     */
    public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType createTransactionPaymentMultiCredit(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationMultiCreditType createTransactionPaymentInformationMultiCredit) throws java.rmi.RemoteException;

    /**
     * Return the detailed transaction information
     */
    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType getTransactionInformationDetailed(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType getTransactionInformationDetailedBody) throws java.rmi.RemoteException;

    /**
     * Finish the transaction with a commerce authorization code
     */
    public de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType finalizeTransactionPaymentWithAuthorizationCode(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeInformationType finalizeTransactionPaymentWithAuthorizationCodeInformation) throws java.rmi.RemoteException;
}

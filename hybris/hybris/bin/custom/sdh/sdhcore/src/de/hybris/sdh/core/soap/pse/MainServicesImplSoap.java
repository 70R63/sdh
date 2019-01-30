/**
 * MainServicesImplSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse;

public interface MainServicesImplSoap extends java.rmi.Remote {
    public de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType[] getBankList(de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType getBankListInformation) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType createTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType createTransactionPaymentInformation) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType confirmTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType confirmTransactionPaymentInformation) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType getTransactionInformation(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType getTransactionInformationBody) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformation) throws java.rmi.RemoteException;
    public void getConciliationFile(de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileInformationType getConciliationFileInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseFileTypeArrayHolder files, de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException;
    public void getFilesACH(de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHInformationType getFilesACHInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseFileTypeArrayHolder files, de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType createTransactionPaymentMultiCredit(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationMultiCreditType createTransactionPaymentInformationMultiCredit) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType getTransactionInformationDetailed(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType getTransactionInformationDetailedBody) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType finalizeTransactionPaymentWithAuthorizationCode(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeInformationType finalizeTransactionPaymentWithAuthorizationCodeInformation) throws java.rmi.RemoteException;
    public void getTransactionTotals(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsInformationType getTransactionTotalsInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseTotalTypeArrayHolder totals, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException;
    public void getTransactionStatistics(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsInformationType getTransactionStatisticsInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseStatisticTypeArrayHolder statistics, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType authorizeTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentInformationType authorizeTransactionPaymentInformation) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType confirmTransactionPaymentFD(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDInformationType confirmTransactionPaymentFDInformation) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType confirmTransactionPayment2(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2InformationType confirmTransactionPayment2Information) throws java.rmi.RemoteException;
    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType confirmTransactionPaymentFD2(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2InformationType confirmTransactionPaymentFD2Information) throws java.rmi.RemoteException;
}

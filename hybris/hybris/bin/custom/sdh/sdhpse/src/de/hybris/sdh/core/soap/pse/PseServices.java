package de.hybris.sdh.core.soap.pse;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;

public interface PseServices {
	public GetBankListResponseInformationType[] getBankList(
			ConstantConnectionData constantConnectionData,
			MessageHeader messageHeader) 
					throws MalformedURLException, ServiceException, RemoteException;
	
	public CreateTransactionPaymentResponseInformationType createTransactionPayment(
			ConstantConnectionData constantConnectionData,
			MessageHeader messageHeader, 
			CreateTransactionPaymentInformationType createTransactionPaymentInformationType) 
					throws MalformedURLException, ServiceException, RemoteException;
	
	public ConfirmTransactionPaymentResponseInformationType confirmTransactionPayment(
			ConstantConnectionData constantConnectionData,
			MessageHeader messageHeader, 
			ConfirmTransactionPaymentInformationType confirmTransactionPaymentInformationType) 
					throws MalformedURLException, ServiceException, RemoteException;
	
	public GetTransactionInformationResponseBodyType getTransactionInformation(
			ConstantConnectionData constantConnectionData,
			MessageHeader messageHeader,
			GetTransactionInformationBodyType getTransactionInformationBodyType) 
					throws MalformedURLException, ServiceException, RemoteException;
	
	public FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(
			ConstantConnectionData constantConnectionData,
			MessageHeader messageHeader,
			FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformationType)
					throws MalformedURLException, ServiceException, RemoteException;
}

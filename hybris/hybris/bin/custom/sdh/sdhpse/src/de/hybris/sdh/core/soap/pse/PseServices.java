package de.hybris.sdh.core.soap.pse;

<<<<<<< HEAD
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

=======
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
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

<<<<<<< HEAD
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
=======

public interface PseServices
{
	public GetBankListResponseInformationType[] getBankList(ConstantConnectionData constantConnectionData,
			MessageHeader messageHeader);

	public CreateTransactionPaymentResponseInformationType createTransactionPayment(ConstantConnectionData constantConnectionData,
			MessageHeader messageHeader, CreateTransactionPaymentInformationType createTransactionPaymentInformationType);

	public ConfirmTransactionPaymentResponseInformationType confirmTransactionPayment(
			ConstantConnectionData constantConnectionData, MessageHeader messageHeader,
			ConfirmTransactionPaymentInformationType confirmTransactionPaymentInformationType);

	public GetTransactionInformationResponseBodyType getTransactionInformation(ConstantConnectionData constantConnectionData,
			MessageHeader messageHeader, GetTransactionInformationBodyType getTransactionInformationBodyType);

	public FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(
			ConstantConnectionData constantConnectionData, MessageHeader messageHeader,
			FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformationType);
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
}

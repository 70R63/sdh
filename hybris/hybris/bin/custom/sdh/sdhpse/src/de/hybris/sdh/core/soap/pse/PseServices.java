package de.hybris.sdh.core.soap.pse;

import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.*;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;


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

	public GetTransactionInformationDetailedResponseBodyType getTransactionInformationDetailed(ConstantConnectionData constantConnectionData,
																					   MessageHeader messageHeader,
																					   GetTransactionInformationDetailedBodyType getTransactionInformationDetailedBodyType);

	public FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(
			ConstantConnectionData constantConnectionData, MessageHeader messageHeader,
			FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformationType);
}

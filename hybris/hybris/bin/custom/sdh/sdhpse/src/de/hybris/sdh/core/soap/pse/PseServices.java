package de.hybris.sdh.core.soap.pse;

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
}

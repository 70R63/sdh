package de.hybris.sdh.core.soap.pse.impl;

import de.hybris.sdh.core.soap.pse.MainServices;
import de.hybris.sdh.core.soap.pse.PseServices;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentTransactionStateCodeList;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.UserTypeListType;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:pseConnection.properties")
public class DefaultPseServices implements PseServices {

	@Resource(name="mainServicesLocator")
	private MainServices mainServices;

	private ConstantConnectionData constantConnectionDataInt;

	public GetBankListResponseInformationType[] getBankList(
			final ConstantConnectionData constantConnectionData,
			final MessageHeader messageHeader)
			throws MalformedURLException, ServiceException, RemoteException{

			constantConnectionDataInt = constantConnectionData;
			final MainServicesSoapStub cli = getMainServices();
			cli.setMessageHeader(messageHeader);

			final GetbankListInformationType gbl_request=new GetbankListInformationType();
			gbl_request.setEntityCode(constantConnectionDataInt.getPpeCode());

			System.out.println("----------- Input Parameters GetBankList   WS ----------");
			System.out.println(constantConnectionData);
			System.out.println(messageHeader);
			System.out.println("----------- Input Parameters GetBankList   WS  ----------");

			return cli.getBankList(gbl_request);
	}

	public CreateTransactionPaymentResponseInformationType createTransactionPayment(
			final ConstantConnectionData constantConnectionData,
			final MessageHeader messageHeader,
			final CreateTransactionPaymentInformationType createTransactionPaymentInformationType)
					throws MalformedURLException, ServiceException, RemoteException {

			constantConnectionDataInt = constantConnectionData;
			final Date date = Calendar.getInstance().getTime();
			final MainServicesSoapStub cli = getMainServices();
			cli.setMessageHeader(messageHeader);

			createTransactionPaymentInformationType.setEntityCode(constantConnectionDataInt.getPpeCode());
			createTransactionPaymentInformationType.setFinancialInstitutionCode(constantConnectionDataInt.getBankCode());
			createTransactionPaymentInformationType.setServiceCode(constantConnectionDataInt.getServiceCode());			;
			createTransactionPaymentInformationType.setSoliciteDate(date);
			createTransactionPaymentInformationType.setUserType(UserTypeListType._value1);

			System.out.println("----------- Input Parameters CreateTransactionPayment   WS ----------");
			System.out.println(constantConnectionData);
			System.out.println(messageHeader);
			System.out.println(createTransactionPaymentInformationType);
			System.out.println("----------- Input Parameters CreateTransactionPayment   WS  ----------");

			return cli.createTransactionPayment(createTransactionPaymentInformationType);
	}

	public ConfirmTransactionPaymentResponseInformationType confirmTransactionPayment(
			final ConstantConnectionData constantConnectionData,
			final MessageHeader messageHeader,
			final ConfirmTransactionPaymentInformationType confirmTransactionPaymentInformationType)
			throws MalformedURLException, ServiceException, RemoteException {

			constantConnectionDataInt = constantConnectionData;
			final Date date = Calendar.getInstance().getTime();
			final MainServicesSoapStub cli = getMainServices();
			cli.setMessageHeader(messageHeader);

			confirmTransactionPaymentInformationType.setEntityCode(constantConnectionDataInt.getPpeCode());
			confirmTransactionPaymentInformationType.setAuthorizationId(constantConnectionDataInt.getAuthCode());
			confirmTransactionPaymentInformationType.setFinancialInstitutionCode(constantConnectionDataInt.getBankCode());
			confirmTransactionPaymentInformationType.setBankProcessDate(date);
			confirmTransactionPaymentInformationType.setSoliciteDate(date);
			confirmTransactionPaymentInformationType.setTransactionState(ConfirmTransactionPaymentTransactionStateCodeList.OK);


			System.out.println("----------- Input Parameters ConfirmTransactionPayment   WS ----------");
			System.out.println(constantConnectionData);
			System.out.println(messageHeader);
			System.out.println(confirmTransactionPaymentInformationType);
			System.out.println("----------- Input Parameters CconfirmTransactionPayment   WS  ----------");

			return cli.confirmTransactionPayment(confirmTransactionPaymentInformationType);
	}

	public GetTransactionInformationResponseBodyType getTransactionInformation(
			final ConstantConnectionData constantConnectionData,
			final MessageHeader messageHeader,
			final GetTransactionInformationBodyType getTransactionInformationBodyType)
			throws MalformedURLException, ServiceException, RemoteException {

			constantConnectionDataInt = constantConnectionData;
			final MainServicesSoapStub cli = getMainServices();
			cli.setMessageHeader( messageHeader );

			getTransactionInformationBodyType.setEntityCode(constantConnectionDataInt.getPpeCode());

			System.out.println("----------- Input Parameters GetTransactionInformation   WS ----------");
			System.out.println(constantConnectionData);
			System.out.println(messageHeader);
			System.out.println(getTransactionInformationBodyType);
			System.out.println("----------- Input Parameters GetTransactionInformation   WS  ----------");

		return cli.getTransactionInformation(getTransactionInformationBodyType);
	}

	public FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(
			final ConstantConnectionData constantConnectionData, final MessageHeader messageHeader,
			final FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformationType)
			throws MalformedURLException, ServiceException, RemoteException {

			constantConnectionDataInt = constantConnectionData;
			final MainServicesSoapStub cli = getMainServices();
			cli.setMessageHeader(messageHeader);

			finalizeTransactionPaymentInformationType.setEntityCode(constantConnectionDataInt.getPpeCode());

			System.out.println("----------- Input Parameters FinalizeTransactionPayment   WS ----------");
			System.out.println(constantConnectionData);
			System.out.println(messageHeader);
			System.out.println(finalizeTransactionPaymentInformationType);
			System.out.println("----------- Input Parameters FinalizeTransactionPayment   WS  ----------");

			return cli.finalizeTransactionPayment(finalizeTransactionPaymentInformationType);
	}



	private MainServicesSoapStub getMainServices() throws MalformedURLException, ServiceException {
		return (MainServicesSoapStub) mainServices.getMainServicesSoap(new URL(constantConnectionDataInt.getPseurl()));
	}


}

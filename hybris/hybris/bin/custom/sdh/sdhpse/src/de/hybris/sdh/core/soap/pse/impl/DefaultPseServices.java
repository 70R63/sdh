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

<<<<<<< HEAD
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:pseConnection.properties")
public class DefaultPseServices implements PseServices {

	@Resource(name="mainServicesLocator")
=======
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;


@Configuration
//@PropertySource("classpath:pseConnection.properties")
public class DefaultPseServices implements PseServices
{

	@Resource(name = "mainServicesLocator")
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
	private MainServices mainServices;

	private ConstantConnectionData constantConnectionDataInt;

<<<<<<< HEAD
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
=======
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(DefaultPseServices.class);

	public GetBankListResponseInformationType[] getBankList(final ConstantConnectionData constantConnectionData,
			final MessageHeader messageHeader)
	{

		constantConnectionDataInt = constantConnectionData;
		MainServicesSoapStub cli = null;
		GetBankListResponseInformationType[] result = null;

		try
		{
			cli = getMainServices();
			cli.setMessageHeader(messageHeader);

			final GetbankListInformationType gbl_request = new GetbankListInformationType();
			gbl_request.setEntityCode(constantConnectionDataInt.getPpeCode());

			result = cli.getBankList(gbl_request);
		}
		catch (MalformedURLException | ServiceException | RemoteException e)
		{
			this.printExceptionMessage(e);
		}


		LOG.info("----------- Input Parameters GetBankList   WS ----------");
		LOG.info(constantConnectionData);
		LOG.info(messageHeader);
		LOG.info("----------- Input Parameters GetBankList   WS  ----------");

		return result;
	}

	public CreateTransactionPaymentResponseInformationType createTransactionPayment(
			final ConstantConnectionData constantConnectionData, final MessageHeader messageHeader,
			final CreateTransactionPaymentInformationType createTransactionPaymentInformationType)
	{

		constantConnectionDataInt = constantConnectionData;
		final Date date = Calendar.getInstance().getTime();
		MainServicesSoapStub cli = null;
		CreateTransactionPaymentResponseInformationType result = null;

		try
		{
			cli = getMainServices();
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
			cli.setMessageHeader(messageHeader);

			createTransactionPaymentInformationType.setEntityCode(constantConnectionDataInt.getPpeCode());
			createTransactionPaymentInformationType.setFinancialInstitutionCode(constantConnectionDataInt.getBankCode());
<<<<<<< HEAD
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
=======
			createTransactionPaymentInformationType.setServiceCode(constantConnectionDataInt.getServiceCode());
			createTransactionPaymentInformationType.setEntityurl(constantConnectionDataInt.getEntityUrl());
			createTransactionPaymentInformationType.setSoliciteDate(date);
			createTransactionPaymentInformationType.setUserType(UserTypeListType._value1);

			result = cli.createTransactionPayment(createTransactionPaymentInformationType);
		}
		catch (MalformedURLException | ServiceException | RemoteException e)
		{
			this.printExceptionMessage(e);
		}

		LOG.info("----------- Input Parameters CreateTransactionPayment   WS ----------");
		LOG.info(constantConnectionData);
		LOG.info(messageHeader);
		LOG.info(createTransactionPaymentInformationType);
		LOG.info("----------- Input Parameters CreateTransactionPayment   WS  ----------");

		return result;
	}

	public ConfirmTransactionPaymentResponseInformationType confirmTransactionPayment(
			final ConstantConnectionData constantConnectionData, final MessageHeader messageHeader,
			final ConfirmTransactionPaymentInformationType confirmTransactionPaymentInformationType)
	{

		constantConnectionDataInt = constantConnectionData;
		final Date date = Calendar.getInstance().getTime();
		MainServicesSoapStub cli = null;
		ConfirmTransactionPaymentResponseInformationType result = null;

		try
		{
			cli = getMainServices();
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
			cli.setMessageHeader(messageHeader);

			confirmTransactionPaymentInformationType.setEntityCode(constantConnectionDataInt.getPpeCode());
			confirmTransactionPaymentInformationType.setAuthorizationId(constantConnectionDataInt.getAuthCode());
			confirmTransactionPaymentInformationType.setFinancialInstitutionCode(constantConnectionDataInt.getBankCode());
			confirmTransactionPaymentInformationType.setBankProcessDate(date);
			confirmTransactionPaymentInformationType.setSoliciteDate(date);
			confirmTransactionPaymentInformationType.setTransactionState(ConfirmTransactionPaymentTransactionStateCodeList.OK);

<<<<<<< HEAD

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
=======
			result = cli.confirmTransactionPayment(confirmTransactionPaymentInformationType);
		}
		catch (MalformedURLException | ServiceException | RemoteException e)
		{
			this.printExceptionMessage(e);
		}

		LOG.info("----------- Input Parameters ConfirmTransactionPayment   WS ----------");
		LOG.info(constantConnectionData);
		LOG.info(messageHeader);
		LOG.info(confirmTransactionPaymentInformationType);
		LOG.info("----------- Input Parameters CconfirmTransactionPayment   WS  ----------");

		return result;
	}

	public GetTransactionInformationResponseBodyType getTransactionInformation(final ConstantConnectionData constantConnectionData,
			final MessageHeader messageHeader, final GetTransactionInformationBodyType getTransactionInformationBodyType)
	{

		constantConnectionDataInt = constantConnectionData;
		MainServicesSoapStub cli = null;
		GetTransactionInformationResponseBodyType result = null;

		try
		{
			cli = getMainServices();
			cli.setMessageHeader(messageHeader);

			getTransactionInformationBodyType.setEntityCode(constantConnectionDataInt.getPpeCode());
			result = cli.getTransactionInformation(getTransactionInformationBodyType);
		}
		catch (MalformedURLException | ServiceException | RemoteException e)
		{
			this.printExceptionMessage(e);
		}

		LOG.info("----------- Input Parameters GetTransactionInformation   WS ----------");
		LOG.info(constantConnectionData);
		LOG.info(messageHeader);
		LOG.info(getTransactionInformationBodyType);
		LOG.info("----------- Input Parameters GetTransactionInformation   WS  ----------");

		return result;
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
	}

	public FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(
			final ConstantConnectionData constantConnectionData, final MessageHeader messageHeader,
			final FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformationType)
<<<<<<< HEAD
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

=======
	{

		constantConnectionDataInt = constantConnectionData;
		MainServicesSoapStub cli = null;
		FinalizeTransactionPaymentResponseInformationType result = null;

		try
		{
			cli = getMainServices();
			cli.setMessageHeader(messageHeader);

			finalizeTransactionPaymentInformationType.setEntityCode(constantConnectionDataInt.getPpeCode());
			result = cli.finalizeTransactionPayment(finalizeTransactionPaymentInformationType);
		}
		catch (MalformedURLException | ServiceException | RemoteException e)
		{
			this.printExceptionMessage(e);
		}

		LOG.info("----------- Input Parameters FinalizeTransactionPayment   WS ----------");
		LOG.info(constantConnectionData);
		LOG.info(messageHeader);
		LOG.info(finalizeTransactionPaymentInformationType);
		LOG.info("----------- Input Parameters FinalizeTransactionPayment   WS  ----------");

		return result;
	}

	private MainServicesSoapStub getMainServices() throws MalformedURLException, ServiceException
	{
		return (MainServicesSoapStub) mainServices.getMainServicesSoap(new URL(constantConnectionDataInt.getPseurl()));
	}

	private void printExceptionMessage(final Exception e)
	{
		LOG.info("----------- Log Exception WS ----------");
		LOG.info(e.getMessage());
		LOG.info("----------- Log Exception WS ----------");
	}

>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73

}

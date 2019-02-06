/**
 *
 */
package de.hybris.sdh.core.soap.pse.impl;

import de.hybris.sdh.core.soap.pse.MainServicesImplSoap;
import de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2InformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2InformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationMultiCreditType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseFileTypeArrayHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseReturnCodeListHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseFileTypeArrayHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseReturnCodeListHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseReturnCodeListHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseStatisticTypeArrayHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseReturnCodeListHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseTotalTypeArrayHolder;

import java.rmi.RemoteException;

/**
 * @author Consultor
 *
 */
public class MainServicesImplSoapProxy implements MainServicesImplSoap
{
	
	private String _endpoint = null;
	  private de.hybris.sdh.core.soap.pse.MainServicesImplSoap mainServicesImplSoap = null;
	  
	  public MainServicesImplSoapProxy() {
	    _initMainServicesImplSoapProxy();
	  }
	  
	  public MainServicesImplSoapProxy(String endpoint) {
	    _endpoint = endpoint;
	    _initMainServicesImplSoapProxy();
	  }
	  
	  private void _initMainServicesImplSoapProxy() {
	    try {
	      mainServicesImplSoap = (new MainServicesImplLocator()).getMainServicesImplSoap();
	      if (mainServicesImplSoap != null) {
	        if (_endpoint != null)
	          ((javax.xml.rpc.Stub)mainServicesImplSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	        else
	          _endpoint = (String)((javax.xml.rpc.Stub)mainServicesImplSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	      
	    }
	    catch (javax.xml.rpc.ServiceException serviceException) {}
	  }
	  
	  public String getEndpoint() {
	    return _endpoint;
	  }
	  
	  public void setEndpoint(String endpoint) {
	    _endpoint = endpoint;
	    if (mainServicesImplSoap != null)
	      ((javax.xml.rpc.Stub)mainServicesImplSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	    
	  }
	  
	  public de.hybris.sdh.core.soap.pse.MainServicesImplSoap getMainServicesImplSoap() {
	    if (mainServicesImplSoap == null)
	      _initMainServicesImplSoapProxy();
	    return mainServicesImplSoap;
	  }

	  @Override
	  public de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType[] getBankList(de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType getBankListInformation) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.getBankList(getBankListInformation);
		  }
	  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType createTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType createTransactionPaymentInformation) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.createTransactionPayment(createTransactionPaymentInformation);
		  }
		
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType confirmTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType confirmTransactionPaymentInformation) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.confirmTransactionPayment(confirmTransactionPaymentInformation);
		  }
	  
	  @Override  
		  public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType getTransactionInformation(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType getTransactionInformationBody) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.getTransactionInformation(getTransactionInformationBody);
		  }
		  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformation) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.finalizeTransactionPayment(finalizeTransactionPaymentInformation);
		  }
		  
	  @Override
		  public void getConciliationFile(de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileInformationType getConciliationFileInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseFileTypeArrayHolder files, de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    mainServicesImplSoap.getConciliationFile(getConciliationFileInformation, files, returnCode);
		  }
		  
	  @Override
		  public void getFilesACH(de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHInformationType getFilesACHInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseFileTypeArrayHolder files, de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    mainServicesImplSoap.getFilesACH(getFilesACHInformation, files, returnCode);
		  }
		  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType createTransactionPaymentMultiCredit(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationMultiCreditType createTransactionPaymentInformationMultiCredit) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.createTransactionPaymentMultiCredit(createTransactionPaymentInformationMultiCredit);
		  }
		  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType getTransactionInformationDetailed(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType getTransactionInformationDetailedBody) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.getTransactionInformationDetailed(getTransactionInformationDetailedBody);
		  }
		  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType finalizeTransactionPaymentWithAuthorizationCode(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeInformationType finalizeTransactionPaymentWithAuthorizationCodeInformation) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.finalizeTransactionPaymentWithAuthorizationCode(finalizeTransactionPaymentWithAuthorizationCodeInformation);
		  }
		  
	  @Override
		  public void getTransactionTotals(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsInformationType getTransactionTotalsInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseTotalTypeArrayHolder totals, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    mainServicesImplSoap.getTransactionTotals(getTransactionTotalsInformation, totals, returnCode);
		  }
		  
	  @Override
		  public void getTransactionStatistics(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsInformationType getTransactionStatisticsInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseStatisticTypeArrayHolder statistics, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    mainServicesImplSoap.getTransactionStatistics(getTransactionStatisticsInformation, statistics, returnCode);
		  }
		  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType authorizeTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentInformationType authorizeTransactionPaymentInformation) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.authorizeTransactionPayment(authorizeTransactionPaymentInformation);
		  }
		  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType confirmTransactionPaymentFD(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDInformationType confirmTransactionPaymentFDInformation) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.confirmTransactionPaymentFD(confirmTransactionPaymentFDInformation);
		  }
		  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType confirmTransactionPayment2(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2InformationType confirmTransactionPayment2Information) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.confirmTransactionPayment2(confirmTransactionPayment2Information);
		  }
		  
	  @Override
		  public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType confirmTransactionPaymentFD2(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2InformationType confirmTransactionPaymentFD2Information) throws java.rmi.RemoteException{
		    if (mainServicesImplSoap == null)
		      _initMainServicesImplSoapProxy();
		    return mainServicesImplSoap.confirmTransactionPaymentFD2(confirmTransactionPaymentFD2Information);
		  }

}

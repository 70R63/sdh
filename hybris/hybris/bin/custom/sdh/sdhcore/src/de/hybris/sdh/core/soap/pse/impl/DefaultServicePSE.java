/**
 *
 */
package de.hybris.sdh.core.soap.pse.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.soap.impl.ZWS_HYSEND_MAIL_ServiceLocator;
import de.hybris.sdh.core.soap.pse.MainServicesImpl;
import de.hybris.sdh.core.soap.pse.ServicePSE;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

/**
 * @author Consultor
 *
 */
public class DefaultServicePSE implements ServicePSE
{
	@Resource(name = "DefaultMainServicesImplLocator")
	MainServicesImpl defaultMainServicesImplLocator;
	
	@Resource(name = "configurationService")
	private ConfigurationService configurationService;
	
	private String PSEURL;
	private String PPE_CODE;
	private String BANK_CODE;
	private String SERVICE_CODE;
	private String AUTH_CODE;
	private String CREDIT_SERVICE_CODE;
	private String CREDIT_COMPANY_CODE;
	private String COMPANY_AUTH_CODE;
	
	

	@Override
	public GetBankListResponseInformationType[] getBankList(String from, String to, String representingParty)
	{
				
		try
		{
			final MainServicesImplSoapStub cli = (MainServicesImplSoapStub) defaultMainServicesImplLocator.getMainServicesImplSoap(new URL(this.getPSEURL()));
			
			MessageHeader header = new MessageHeader();
			header.setTo(to);
			header.setFrom(from);
			header.setRepresentingParty(representingParty);
			cli.setMessageHeader(header);

			GetbankListInformationType gbl_request = new GetbankListInformationType();
			gbl_request.setEntityCode(this.getPPE_CODE());

			
			return cli.getBankList(gbl_request);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (ServiceException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * @return the pSEURL
	 */
	public String getPSEURL()
	{
		return configurationService.getConfiguration().getString("sdh.pse.pseURL");
	}



	/**
	 * @return the pPE_CODE
	 */
	public String getPPE_CODE()
	{
		return configurationService.getConfiguration().getString("sdh.pse.ppeCode");
	}



	/**
	 * @return the bANK_CODE
	 */
	public String getBANK_CODE()
	{
		return configurationService.getConfiguration().getString("sdh.pse.bankCode");
	}



	/**
	 * @return the sERVICE_CODE
	 */
	public String getSERVICE_CODE()
	{
		return configurationService.getConfiguration().getString("sdh.pse.serviceCode");
	}



	/**
	 * @return the aUTH_CODE
	 */
	public String getAUTH_CODE()
	{
		return configurationService.getConfiguration().getString("sdh.pse.authCode");
	}



	/**
	 * @return the cREDIT_SERVICE_CODE
	 */
	public String getCREDIT_SERVICE_CODE()
	{
		return configurationService.getConfiguration().getString("sdh.pse.creditServiceCode");
	}



	/**
	 * @return the cREDIT_COMPANY_CODE
	 */
	public String getCREDIT_COMPANY_CODE()
	{
		return configurationService.getConfiguration().getString("sdh.pse.creditCompanyCode");
	}



	/**
	 * @return the cOMPANY_AUTH_CODE
	 */
	public String getCOMPANY_AUTH_CODE()
	{
		return configurationService.getConfiguration().getString("sdh.pse.companyAuthCode");
	}
	
	

}

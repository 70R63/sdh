/**
 *
 */
package de.hybris.sdh.core.soap.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.holders.StringHolder;

import de.hybirs.sdh.core.soap.ZWS_HYSEND_MAIL_INT;
import de.hybirs.sdh.core.soap.ZWS_HYSEND_MAIL_PortType;

/**
 * @author Consultor
 *
 */
public class DefaultZWS_HYBSEND_MAIL_INT implements ZWS_HYSEND_MAIL_INT
{

	@Resource(name = "ZWS_HYSEND_MAIL_locator")
	ZWS_HYSEND_MAIL_ServiceLocator locator;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Override
	public void send(final String PiEmail, final String PiMessage, final String PiSubject, final StringHolder EpCode,
			final StringHolder EpMessage)
	{
		try
		{
			//final ZWS_HYSEND_MAIL_ServiceLocator locator = new ZWS_HYSEND_MAIL_ServiceLocator();
			final ZWS_HYSEND_MAIL_PortType proxy = locator.getZWS_HYSEND_MAIL();
			final ZWS_HYSEND_MAIL_BindingStub proxyParam = (ZWS_HYSEND_MAIL_BindingStub) proxy;

			proxyParam.setUsername(configurationService.getConfiguration().getString("sdh.soapcrmsendemail.user"));
			proxyParam.setPassword(configurationService.getConfiguration().getString("sdh.soapcrmsendemail.password"));
			proxyParam.setTimeout(10000);

			proxy.zcrmfHysendMail(PiEmail, PiMessage, PiSubject, EpCode, EpMessage);

			System.out.println(EpCode.value);
			System.out.println(EpMessage.value);

		}
		catch (final ServiceException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (final RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

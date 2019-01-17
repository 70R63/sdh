/**
 *
 */
package de.hybris.sdh.facades;

import javax.xml.rpc.holders.StringHolder;
/**
 * @author Consultor
 *
 */
public interface ZWS_HYSEND_MAIL_INT
{
	void send(String PiEmail, String PiMessage, String PiSubject, StringHolder EpCode, StringHolder EpMessage);
}

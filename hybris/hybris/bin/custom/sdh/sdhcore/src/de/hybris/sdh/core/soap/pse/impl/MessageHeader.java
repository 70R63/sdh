/**
 * 
 */
package de.hybris.sdh.core.soap.pse.impl;

import java.util.Iterator;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.message.MessageElement;
import org.apache.axis.message.SOAPHeaderElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
/**
 * @author Consultor
 *
 */
public class MessageHeader
{
	private final static String NAME = "messageHeader";
	private final static String NAMESPACE = "http://www.uc-council.org/smp/schemas/eanucc";
	
	private String _to;
	private String _from;
	private String _representingParty;
	
	public SOAPHeaderElement toSOAPHeaderElement()
	{
		
		try {
			QName name = new QName("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			Document doc = factory.newDocumentBuilder().newDocument();
			Element token = doc.createElementNS(name.getNamespaceURI(), name.getLocalPart());
			
			Element to = doc.createElementNS(name.getNamespaceURI(),"to");
			Element togln = doc.createElementNS(name.getNamespaceURI(),"gln");
			Text toglnv = doc.createTextNode("");
			toglnv.setNodeValue( _to );
			togln.appendChild(toglnv);
			to.appendChild(togln);
			token.appendChild(to);
			
			Element from = doc.createElementNS(name.getNamespaceURI(),"from");
			Element fromln = doc.createElementNS(name.getNamespaceURI(),"gln");
			Text fromlnv = doc.createTextNode("");
			fromlnv.setNodeValue( _from );
			fromln.appendChild(fromlnv);
			from.appendChild(fromln);
			token.appendChild(from);
			
			Element representingParty = doc.createElementNS(name.getNamespaceURI(),"representingParty");
			Element representingPartyln = doc.createElementNS(name.getNamespaceURI(),"gln");
			Text representingPartylnv = doc.createTextNode("");
			representingPartylnv.setNodeValue( _representingParty );
			representingPartyln.appendChild(representingPartylnv);
			representingParty.appendChild(representingPartyln);
			token.appendChild(representingParty);
			
			return new SOAPHeaderElement(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public void fromSOAPHeaderElement( SOAPHeaderElement header )
	{
		try
		{
			Iterator it = header.getChildElements();
			MessageElement resp_to = (MessageElement)it.next();
			MessageElement resp_from = (MessageElement)it.next();
			MessageElement resp_party = (MessageElement)it.next();
			
			_to = ((MessageElement)resp_to.getChildElements().next()).getValue();
			_from = ((MessageElement)resp_from.getChildElements().next()).getValue();
			_representingParty = ((MessageElement)resp_party.getChildElements().next()).getValue();
		}
		catch(Exception e)
		{
		}
	}
	
	public String getTo()
	{
		return _to;
	}
	public void setTo(String to)
	{
		_to = to;
	}
	public String getFrom()
	{
		return _from;
	}
	public void setFrom(String from)
	{
		_from = from;
	}
	public String getRepresentingParty()
	{
		return _representingParty;
	}
	public void setRepresentingParty(String representingParty)
	{
		_representingParty = representingParty;
	}
}

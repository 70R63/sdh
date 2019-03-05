/*
 * Created on Aug 14, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package de.hybris.sdh.core.soap.pse.impl;

import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axis.message.MessageElement;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.xml.utils.QName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * @author mauroa
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MessageHeader
{
	private final static String NAME = "messageHeader";
	private final static String NAMESPACE = "http://www.uc-council.org/smp/schemas/eanucc";
<<<<<<< HEAD
	
	private String _to;
	private String _from;
	private String _representingParty;
	
=======

	private String _to;
	private String _from;
	private String _representingParty;

>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
	public SOAPHeaderElement toSOAPHeaderElement()
	{
		try
		{
<<<<<<< HEAD
			QName name = new QName("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			Document doc = factory.newDocumentBuilder().newDocument();
			Element token = doc.createElementNS(name.getNamespaceURI(), name.getLocalPart());
				
			Element to = doc.createElementNS(name.getNamespaceURI(),"to");
			Element togln = doc.createElementNS(name.getNamespaceURI(),"gln");
			Text toglnv = doc.createTextNode("");
=======
			final QName name = new QName("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			final Document doc = factory.newDocumentBuilder().newDocument();
			final Element token = doc.createElementNS(name.getNamespaceURI(), name.getLocalPart());

			final Element to = doc.createElementNS(name.getNamespaceURI(),"to");
			final Element togln = doc.createElementNS(name.getNamespaceURI(),"gln");
			final Text toglnv = doc.createTextNode("");
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
			toglnv.setNodeValue( _to );
			togln.appendChild(toglnv);
			to.appendChild(togln);
			token.appendChild(to);
<<<<<<< HEAD
	
			Element from = doc.createElementNS(name.getNamespaceURI(),"from");
			Element fromln = doc.createElementNS(name.getNamespaceURI(),"gln");
			Text fromlnv = doc.createTextNode("");
=======

			final Element from = doc.createElementNS(name.getNamespaceURI(),"from");
			final Element fromln = doc.createElementNS(name.getNamespaceURI(),"gln");
			final Text fromlnv = doc.createTextNode("");
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
			fromlnv.setNodeValue( _from );
			fromln.appendChild(fromlnv);
			from.appendChild(fromln);
			token.appendChild(from);
<<<<<<< HEAD
	
			Element representingParty = doc.createElementNS(name.getNamespaceURI(),"representingParty");
			Element representingPartyln = doc.createElementNS(name.getNamespaceURI(),"gln");
			Text representingPartylnv = doc.createTextNode("");
=======

			final Element representingParty = doc.createElementNS(name.getNamespaceURI(),"representingParty");
			final Element representingPartyln = doc.createElementNS(name.getNamespaceURI(),"gln");
			final Text representingPartylnv = doc.createTextNode("");
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
			representingPartylnv.setNodeValue( _representingParty );
			representingPartyln.appendChild(representingPartylnv);
			representingParty.appendChild(representingPartyln);
			token.appendChild(representingParty);
<<<<<<< HEAD
			
			return new SOAPHeaderElement(token);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
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
			
=======

			return new SOAPHeaderElement(token);
		}
		catch(final Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void fromSOAPHeaderElement( final SOAPHeaderElement header )
	{
		try
		{
			final Iterator it = header.getChildElements();
			final MessageElement resp_to = (MessageElement)it.next();
			final MessageElement resp_from = (MessageElement)it.next();
			final MessageElement resp_party = (MessageElement)it.next();

>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
			_to = ((MessageElement)resp_to.getChildElements().next()).getValue();
			_from = ((MessageElement)resp_from.getChildElements().next()).getValue();
			_representingParty = ((MessageElement)resp_party.getChildElements().next()).getValue();
		}
<<<<<<< HEAD
		catch(Exception e)
		{
		}
	}
	
=======
		catch(final Exception e)
		{
		}
	}

>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
	public String getTo()
	{
		return _to;
	}
<<<<<<< HEAD
	public void setTo(String to)
=======
	public void setTo(final String to)
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
	{
		_to = to;
	}
	public String getFrom()
	{
		return _from;
	}
<<<<<<< HEAD
	public void setFrom(String from)
=======
	public void setFrom(final String from)
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
	{
		_from = from;
	}
	public String getRepresentingParty()
	{
		return _representingParty;
	}
<<<<<<< HEAD
	public void setRepresentingParty(String representingParty)
=======
	public void setRepresentingParty(final String representingParty)
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
	{
		_representingParty = representingParty;
	}

	@Override
	public String toString() {
		return "MessageHeader [to=" + _to + ", from=" + _from + ", representingParty=" + _representingParty + "]";
	}
<<<<<<< HEAD
	
	
	
=======



>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
}

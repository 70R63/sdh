/**
 * ZWS_HYSEND_MAIL_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.facades;

public interface ZWS_HYSEND_MAIL_PortType extends java.rmi.Remote {
    public void zcrmfHysendMail(java.lang.String piEmail, java.lang.String piMessage, java.lang.String piSubject, javax.xml.rpc.holders.StringHolder epCode, javax.xml.rpc.holders.StringHolder epMessage) throws java.rmi.RemoteException;
}

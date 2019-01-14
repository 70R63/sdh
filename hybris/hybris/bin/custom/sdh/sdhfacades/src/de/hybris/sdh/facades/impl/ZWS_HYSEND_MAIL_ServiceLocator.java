/**
 * ZWS_HYSEND_MAIL_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.facades.impl;

public class ZWS_HYSEND_MAIL_ServiceLocator extends org.apache.axis.client.Service implements de.hybris.sdh.facades.ZWS_HYSEND_MAIL_Service {

    public ZWS_HYSEND_MAIL_ServiceLocator() {
    }


    public ZWS_HYSEND_MAIL_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ZWS_HYSEND_MAIL_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ZWS_HYSEND_MAIL
    private java.lang.String ZWS_HYSEND_MAIL_address = "http://SDHCICRMDEV.shd.gov.co:8000/sap/bc/srt/rfc/sap/zws_hysend_mail/100/zws_hysend_mail/zws_hysend_mail";

    public java.lang.String getZWS_HYSEND_MAILAddress() {
        return ZWS_HYSEND_MAIL_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ZWS_HYSEND_MAILWSDDServiceName = "ZWS_HYSEND_MAIL";

    public java.lang.String getZWS_HYSEND_MAILWSDDServiceName() {
        return ZWS_HYSEND_MAILWSDDServiceName;
    }

    public void setZWS_HYSEND_MAILWSDDServiceName(java.lang.String name) {
        ZWS_HYSEND_MAILWSDDServiceName = name;
    }

    public de.hybris.sdh.facades.ZWS_HYSEND_MAIL_PortType getZWS_HYSEND_MAIL() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ZWS_HYSEND_MAIL_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getZWS_HYSEND_MAIL(endpoint);
    }

    public de.hybris.sdh.facades.ZWS_HYSEND_MAIL_PortType getZWS_HYSEND_MAIL(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ZWS_HYSEND_MAIL_BindingStub _stub = new ZWS_HYSEND_MAIL_BindingStub(portAddress, this);
            _stub.setPortName(getZWS_HYSEND_MAILWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setZWS_HYSEND_MAILEndpointAddress(java.lang.String address) {
        ZWS_HYSEND_MAIL_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (de.hybris.sdh.facades.ZWS_HYSEND_MAIL_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ZWS_HYSEND_MAIL_BindingStub _stub = new ZWS_HYSEND_MAIL_BindingStub(new java.net.URL(ZWS_HYSEND_MAIL_address), this);
                _stub.setPortName(getZWS_HYSEND_MAILWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ZWS_HYSEND_MAIL".equals(inputPortName)) {
            return getZWS_HYSEND_MAIL();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZWS_HYSEND_MAIL");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZWS_HYSEND_MAIL"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ZWS_HYSEND_MAIL".equals(portName)) {
            setZWS_HYSEND_MAILEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

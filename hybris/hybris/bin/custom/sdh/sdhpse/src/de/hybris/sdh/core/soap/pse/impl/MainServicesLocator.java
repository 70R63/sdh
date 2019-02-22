/**
 * MainServicesLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.impl;

public class MainServicesLocator extends org.apache.axis.client.Service implements de.hybris.sdh.core.soap.pse.MainServices {

    public MainServicesLocator() {
    }


    public MainServicesLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MainServicesLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MainServicesSoap
    private java.lang.String MainServicesSoap_address = "http://localhost/PSEWebServices/MainServices.asmx";

    public java.lang.String getMainServicesSoapAddress() {
        return MainServicesSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MainServicesSoapWSDDServiceName = "MainServicesSoap";

    public java.lang.String getMainServicesSoapWSDDServiceName() {
        return MainServicesSoapWSDDServiceName;
    }

    public void setMainServicesSoapWSDDServiceName(java.lang.String name) {
        MainServicesSoapWSDDServiceName = name;
    }

    public de.hybris.sdh.core.soap.pse.MainServicesSoap getMainServicesSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MainServicesSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMainServicesSoap(endpoint);
    }

    public de.hybris.sdh.core.soap.pse.MainServicesSoap getMainServicesSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            de.hybris.sdh.core.soap.pse.impl.MainServicesSoapStub _stub = new de.hybris.sdh.core.soap.pse.impl.MainServicesSoapStub(portAddress, this);
            _stub.setPortName(getMainServicesSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMainServicesSoapEndpointAddress(java.lang.String address) {
        MainServicesSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (de.hybris.sdh.core.soap.pse.MainServicesSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                de.hybris.sdh.core.soap.pse.impl.MainServicesSoapStub _stub = new de.hybris.sdh.core.soap.pse.impl.MainServicesSoapStub(new java.net.URL(MainServicesSoap_address), this);
                _stub.setPortName(getMainServicesSoapWSDDServiceName());
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
        if ("MainServicesSoap".equals(inputPortName)) {
            return getMainServicesSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://vesta.com.br/pse/MainServices", "MainServices");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://vesta.com.br/pse/MainServices", "MainServicesSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MainServicesSoap".equals(portName)) {
            setMainServicesSoapEndpointAddress(address);
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

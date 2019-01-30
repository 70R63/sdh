/**
 *
 */
package de.hybris.sdh.core.soap.pse.impl;

import de.hybris.sdh.core.soap.pse.MainServicesImpl;
import de.hybris.sdh.core.soap.pse.MainServicesImplSoap;

import java.net.URL;

import javax.xml.rpc.ServiceException;

public class MainServicesImplLocator extends org.apache.axis.client.Service implements MainServicesImpl
{

   public MainServicesImplLocator() {
   }


   public MainServicesImplLocator(org.apache.axis.EngineConfiguration config) {
       super(config);
   }

   public MainServicesImplLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
       super(wsdlLoc, sName);
   }

   // Use to get a proxy class for MainServicesImplSoap
   private java.lang.String MainServicesImplSoap_address = "http://200.1.124.119/PSEWebServices3/MainServices.asmx";

   @Override
   public java.lang.String getMainServicesImplSoapAddress() {
       return MainServicesImplSoap_address;
   }

   // The WSDD service name defaults to the port name.
   private java.lang.String MainServicesImplSoapWSDDServiceName = "MainServicesImplSoap";

   public java.lang.String getMainServicesImplSoapWSDDServiceName() {
       return MainServicesImplSoapWSDDServiceName;
   }

   public void setMainServicesImplSoapWSDDServiceName(java.lang.String name) {
       MainServicesImplSoapWSDDServiceName = name;
   }

   @Override
   public de.hybris.sdh.core.soap.pse.MainServicesImplSoap getMainServicesImplSoap() throws javax.xml.rpc.ServiceException {
      java.net.URL endpoint;
       try {
           endpoint = new java.net.URL(MainServicesImplSoap_address);
       }
       catch (java.net.MalformedURLException e) {
           throw new javax.xml.rpc.ServiceException(e);
       }
       return getMainServicesImplSoap(endpoint);
   }

   @Override
   public de.hybris.sdh.core.soap.pse.MainServicesImplSoap getMainServicesImplSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
       try {
           MainServicesImplSoapStub _stub = new MainServicesImplSoapStub(portAddress, this);
           _stub.setPortName(getMainServicesImplSoapWSDDServiceName());
           return _stub;
       }
       catch (org.apache.axis.AxisFault e) {
           return null;
       }
   }

   public void setMainServicesImplSoapEndpointAddress(java.lang.String address) {
       MainServicesImplSoap_address = address;
   }

   /**
    * For the given interface, get the stub implementation.
    * If this service has no port for the given interface,
    * then ServiceException is thrown.
    */
   public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
       try {
           if (de.hybris.sdh.core.soap.pse.MainServicesImplSoap.class.isAssignableFrom(serviceEndpointInterface)) {
               MainServicesImplSoapStub _stub = new MainServicesImplSoapStub(new java.net.URL(MainServicesImplSoap_address), this);
               _stub.setPortName(getMainServicesImplSoapWSDDServiceName());
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
       if ("MainServicesImplSoap".equals(inputPortName)) {
           return getMainServicesImplSoap();
       }
       else  {
           java.rmi.Remote _stub = getPort(serviceEndpointInterface);
           ((org.apache.axis.client.Stub) _stub).setPortName(portName);
           return _stub;
       }
   }

   public javax.xml.namespace.QName getServiceName() {
       return new javax.xml.namespace.QName("http://vesta.com.br/pse/MainServices", "MainServicesImpl");
   }

   private java.util.HashSet ports = null;

   public java.util.Iterator getPorts() {
       if (ports == null) {
           ports = new java.util.HashSet();
           ports.add(new javax.xml.namespace.QName("http://vesta.com.br/pse/MainServices", "MainServicesImplSoap"));
       }
       return ports.iterator();
   }

   /**
   * Set the endpoint address for the specified port name.
   */
   public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
       
if ("MainServicesImplSoap".equals(portName)) {
           setMainServicesImplSoapEndpointAddress(address);
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
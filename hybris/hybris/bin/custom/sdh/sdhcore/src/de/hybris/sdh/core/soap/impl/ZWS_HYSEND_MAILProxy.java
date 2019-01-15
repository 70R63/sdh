package de.hybris.sdh.core.soap.impl;

public class ZWS_HYSEND_MAILProxy implements de.hybirs.sdh.core.soap.ZWS_HYSEND_MAIL_PortType {
  private String _endpoint = null;
  private de.hybirs.sdh.core.soap.ZWS_HYSEND_MAIL_PortType zWS_HYSEND_MAIL_PortType = null;
  
  public ZWS_HYSEND_MAILProxy() {
    _initZWS_HYSEND_MAILProxy();
  }
  
  public ZWS_HYSEND_MAILProxy(String endpoint) {
    _endpoint = endpoint;
    _initZWS_HYSEND_MAILProxy();
  }
  
  private void _initZWS_HYSEND_MAILProxy() {
    try {
      zWS_HYSEND_MAIL_PortType = (new ZWS_HYSEND_MAIL_ServiceLocator()).getZWS_HYSEND_MAIL();
      if (zWS_HYSEND_MAIL_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)zWS_HYSEND_MAIL_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)zWS_HYSEND_MAIL_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (zWS_HYSEND_MAIL_PortType != null)
      ((javax.xml.rpc.Stub)zWS_HYSEND_MAIL_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public de.hybirs.sdh.core.soap.ZWS_HYSEND_MAIL_PortType getZWS_HYSEND_MAIL_PortType() {
    if (zWS_HYSEND_MAIL_PortType == null)
      _initZWS_HYSEND_MAILProxy();
    return zWS_HYSEND_MAIL_PortType;
  }
  
  public void zcrmfHysendMail(java.lang.String piEmail, java.lang.String piMessage, java.lang.String piSubject, javax.xml.rpc.holders.StringHolder epCode, javax.xml.rpc.holders.StringHolder epMessage) throws java.rmi.RemoteException{
    if (zWS_HYSEND_MAIL_PortType == null)
      _initZWS_HYSEND_MAILProxy();
    zWS_HYSEND_MAIL_PortType.zcrmfHysendMail(piEmail, piMessage, piSubject, epCode, epMessage);
  }
  
  
}
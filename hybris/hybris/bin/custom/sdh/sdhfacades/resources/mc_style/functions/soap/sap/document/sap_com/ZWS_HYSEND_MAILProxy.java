package mc_style.functions.soap.sap.document.sap_com;

public class ZWS_HYSEND_MAILProxy implements mc_style.functions.soap.sap.document.sap_com.ZWS_HYSEND_MAIL_PortType {
  private String _endpoint = null;
  private mc_style.functions.soap.sap.document.sap_com.ZWS_HYSEND_MAIL_PortType zWS_HYSEND_MAIL_PortType = null;
  
  public ZWS_HYSEND_MAILProxy() {
    _initZWS_HYSEND_MAILProxy();
  }
  
  public ZWS_HYSEND_MAILProxy(String endpoint) {
    _endpoint = endpoint;
    _initZWS_HYSEND_MAILProxy();
  }
  
  private void _initZWS_HYSEND_MAILProxy() {
    try {
      zWS_HYSEND_MAIL_PortType = (new mc_style.functions.soap.sap.document.sap_com.ZWS_HYSEND_MAIL_ServiceLocator()).getZWS_HYSEND_MAIL();
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
  
  public mc_style.functions.soap.sap.document.sap_com.ZWS_HYSEND_MAIL_PortType getZWS_HYSEND_MAIL_PortType() {
    if (zWS_HYSEND_MAIL_PortType == null)
      _initZWS_HYSEND_MAILProxy();
    return zWS_HYSEND_MAIL_PortType;
  }
  
  
}
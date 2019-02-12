/**
 * AuthorizeTransactionPaymentResponseReturnCodeList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class AuthorizeTransactionPaymentResponseReturnCodeList implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AuthorizeTransactionPaymentResponseReturnCodeList(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _SUCCESS = "SUCCESS";
    public static final java.lang.String _FAIL_ACCESSDENIED = "FAIL_ACCESSDENIED";
    public static final java.lang.String _FAIL_NOTCONFIGURED = "FAIL_NOTCONFIGURED";
    public static final java.lang.String _FAIL_INVALIDDATETIME = "FAIL_INVALIDDATETIME";
    public static final java.lang.String _FAIL_INVALIDTRAZABILITYCODE = "FAIL_INVALIDTRAZABILITYCODE";
    public static final java.lang.String _FAIL_INVALIDSTATE = "FAIL_INVALIDSTATE";
    public static final java.lang.String _FAIL_INVALIDTICKETID = "FAIL_INVALIDTICKETID";
    public static final java.lang.String _FAIL_INVALIDAMOUNT = "FAIL_INVALIDAMOUNT";
    public static final java.lang.String _FAIL_INVALIDERRORCODE = "FAIL_INVALIDERRORCODE";
    public static final java.lang.String _FAIL_INVALIDSERVICECODE = "FAIL_INVALIDSERVICECODE";
    public static final java.lang.String _FAIL_INVALIDAUTHORIZATIONCODEEF = "FAIL_INVALIDAUTHORIZATIONCODEEF";
    public static final java.lang.String _FAIL_CANNOTCONTACTDIAN = "FAIL_CANNOTCONTACTDIAN";
    public static final java.lang.String _FAIL_INVALIDSTATEINDIAN = "FAIL_INVALIDSTATEINDIAN";
    public static final AuthorizeTransactionPaymentResponseReturnCodeList SUCCESS = new AuthorizeTransactionPaymentResponseReturnCodeList(_SUCCESS);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_ACCESSDENIED = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_ACCESSDENIED);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_NOTCONFIGURED = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_NOTCONFIGURED);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDDATETIME = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDDATETIME);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDTRAZABILITYCODE = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDTRAZABILITYCODE);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDSTATE = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDSTATE);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDTICKETID = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDTICKETID);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDAMOUNT = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDAMOUNT);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDERRORCODE = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDERRORCODE);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDSERVICECODE = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDSERVICECODE);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDAUTHORIZATIONCODEEF = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDAUTHORIZATIONCODEEF);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_CANNOTCONTACTDIAN = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_CANNOTCONTACTDIAN);
    public static final AuthorizeTransactionPaymentResponseReturnCodeList FAIL_INVALIDSTATEINDIAN = new AuthorizeTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDSTATEINDIAN);
    public java.lang.String getValue() { return _value_;}
    public static AuthorizeTransactionPaymentResponseReturnCodeList fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AuthorizeTransactionPaymentResponseReturnCodeList enumeration = (AuthorizeTransactionPaymentResponseReturnCodeList)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AuthorizeTransactionPaymentResponseReturnCodeList fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AuthorizeTransactionPaymentResponseReturnCodeList.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPaymentResponseReturnCodeList"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

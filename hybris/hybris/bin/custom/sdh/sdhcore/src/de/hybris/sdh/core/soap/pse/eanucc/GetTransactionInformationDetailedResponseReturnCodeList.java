/**
 * GetTransactionInformationDetailedResponseReturnCodeList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class GetTransactionInformationDetailedResponseReturnCodeList implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected GetTransactionInformationDetailedResponseReturnCodeList(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _SUCCESS = "SUCCESS";
    public static final java.lang.String _FAIL_INVALIDTRAZABILITYCODE = "FAIL_INVALIDTRAZABILITYCODE";
    public static final java.lang.String _FAIL_ACCESSDENIED = "FAIL_ACCESSDENIED";
    public static final java.lang.String _FAIL_TIMEOUT = "FAIL_TIMEOUT";
    public static final GetTransactionInformationDetailedResponseReturnCodeList SUCCESS = new GetTransactionInformationDetailedResponseReturnCodeList(_SUCCESS);
    public static final GetTransactionInformationDetailedResponseReturnCodeList FAIL_INVALIDTRAZABILITYCODE = new GetTransactionInformationDetailedResponseReturnCodeList(_FAIL_INVALIDTRAZABILITYCODE);
    public static final GetTransactionInformationDetailedResponseReturnCodeList FAIL_ACCESSDENIED = new GetTransactionInformationDetailedResponseReturnCodeList(_FAIL_ACCESSDENIED);
    public static final GetTransactionInformationDetailedResponseReturnCodeList FAIL_TIMEOUT = new GetTransactionInformationDetailedResponseReturnCodeList(_FAIL_TIMEOUT);
    public java.lang.String getValue() { return _value_;}
    public static GetTransactionInformationDetailedResponseReturnCodeList fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        GetTransactionInformationDetailedResponseReturnCodeList enumeration = (GetTransactionInformationDetailedResponseReturnCodeList)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static GetTransactionInformationDetailedResponseReturnCodeList fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(GetTransactionInformationDetailedResponseReturnCodeList.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseReturnCodeList"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

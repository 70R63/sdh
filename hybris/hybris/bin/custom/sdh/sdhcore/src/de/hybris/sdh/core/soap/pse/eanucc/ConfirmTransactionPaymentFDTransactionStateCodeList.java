/**
 * ConfirmTransactionPaymentFDTransactionStateCodeList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class ConfirmTransactionPaymentFDTransactionStateCodeList implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ConfirmTransactionPaymentFDTransactionStateCodeList(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _OK = "OK";
    public static final java.lang.String _NOT_AUTHORIZED = "NOT_AUTHORIZED";
    public static final java.lang.String _PENDING = "PENDING";
    public static final java.lang.String _FAILED = "FAILED";
    public static final ConfirmTransactionPaymentFDTransactionStateCodeList OK = new ConfirmTransactionPaymentFDTransactionStateCodeList(_OK);
    public static final ConfirmTransactionPaymentFDTransactionStateCodeList NOT_AUTHORIZED = new ConfirmTransactionPaymentFDTransactionStateCodeList(_NOT_AUTHORIZED);
    public static final ConfirmTransactionPaymentFDTransactionStateCodeList PENDING = new ConfirmTransactionPaymentFDTransactionStateCodeList(_PENDING);
    public static final ConfirmTransactionPaymentFDTransactionStateCodeList FAILED = new ConfirmTransactionPaymentFDTransactionStateCodeList(_FAILED);
    public java.lang.String getValue() { return _value_;}
    public static ConfirmTransactionPaymentFDTransactionStateCodeList fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ConfirmTransactionPaymentFDTransactionStateCodeList enumeration = (ConfirmTransactionPaymentFDTransactionStateCodeList)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ConfirmTransactionPaymentFDTransactionStateCodeList fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ConfirmTransactionPaymentFDTransactionStateCodeList.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDTransactionStateCodeList"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

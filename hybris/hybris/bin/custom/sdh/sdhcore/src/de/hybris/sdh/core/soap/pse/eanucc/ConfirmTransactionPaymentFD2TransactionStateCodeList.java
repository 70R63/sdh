/**
 * ConfirmTransactionPaymentFD2TransactionStateCodeList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class ConfirmTransactionPaymentFD2TransactionStateCodeList implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ConfirmTransactionPaymentFD2TransactionStateCodeList(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _OK = "OK";
    public static final java.lang.String _NOT_AUTHORIZED = "NOT_AUTHORIZED";
    public static final java.lang.String _PENDING = "PENDING";
    public static final java.lang.String _FAILED = "FAILED";
    public static final ConfirmTransactionPaymentFD2TransactionStateCodeList OK = new ConfirmTransactionPaymentFD2TransactionStateCodeList(_OK);
    public static final ConfirmTransactionPaymentFD2TransactionStateCodeList NOT_AUTHORIZED = new ConfirmTransactionPaymentFD2TransactionStateCodeList(_NOT_AUTHORIZED);
    public static final ConfirmTransactionPaymentFD2TransactionStateCodeList PENDING = new ConfirmTransactionPaymentFD2TransactionStateCodeList(_PENDING);
    public static final ConfirmTransactionPaymentFD2TransactionStateCodeList FAILED = new ConfirmTransactionPaymentFD2TransactionStateCodeList(_FAILED);
    public java.lang.String getValue() { return _value_;}
    public static ConfirmTransactionPaymentFD2TransactionStateCodeList fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ConfirmTransactionPaymentFD2TransactionStateCodeList enumeration = (ConfirmTransactionPaymentFD2TransactionStateCodeList)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ConfirmTransactionPaymentFD2TransactionStateCodeList fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ConfirmTransactionPaymentFD2TransactionStateCodeList.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2TransactionStateCodeList"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

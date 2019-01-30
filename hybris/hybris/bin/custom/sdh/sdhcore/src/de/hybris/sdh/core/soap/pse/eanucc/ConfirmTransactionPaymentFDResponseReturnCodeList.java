/**
 * ConfirmTransactionPaymentFDResponseReturnCodeList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class ConfirmTransactionPaymentFDResponseReturnCodeList implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ConfirmTransactionPaymentFDResponseReturnCodeList(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _SUCCESS = "SUCCESS";
    public static final java.lang.String _FAIL_INVALIDTRAZABILITYCODE = "FAIL_INVALIDTRAZABILITYCODE";
    public static final java.lang.String _FAIL_ACCESSDENIED = "FAIL_ACCESSDENIED";
    public static final java.lang.String _FAIL_INVALIDSTATE = "FAIL_INVALIDSTATE";
    public static final java.lang.String _FAIL_INVALIDBANKPROCESSINGDATE = "FAIL_INVALIDBANKPROCESSINGDATE";
    public static final java.lang.String _FAIL_INVALIDAUTHORIZEDAMOUNT = "FAIL_INVALIDAUTHORIZEDAMOUNT";
    public static final java.lang.String _FAIL_INCONSISTENTDATA = "FAIL_INCONSISTENTDATA";
    public static final java.lang.String _FAIL_TIMEOUT = "FAIL_TIMEOUT";
    public static final java.lang.String _FAIL_INVALIDVATVALUE = "FAIL_INVALIDVATVALUE";
    public static final java.lang.String _FAIL_INVALIDTICKETID = "FAIL_INVALIDTICKETID";
    public static final java.lang.String _FAIL_INVALIDSOLICITEDATE = "FAIL_INVALIDSOLICITEDATE";
    public static final java.lang.String _FAIL_INVALIDAUTHORIZATIONID = "FAIL_INVALIDAUTHORIZATIONID";
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList SUCCESS = new ConfirmTransactionPaymentFDResponseReturnCodeList(_SUCCESS);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INVALIDTRAZABILITYCODE = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INVALIDTRAZABILITYCODE);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_ACCESSDENIED = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_ACCESSDENIED);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INVALIDSTATE = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INVALIDSTATE);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INVALIDBANKPROCESSINGDATE = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INVALIDBANKPROCESSINGDATE);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INVALIDAUTHORIZEDAMOUNT = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INVALIDAUTHORIZEDAMOUNT);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INCONSISTENTDATA = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INCONSISTENTDATA);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_TIMEOUT = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_TIMEOUT);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INVALIDVATVALUE = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INVALIDVATVALUE);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INVALIDTICKETID = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INVALIDTICKETID);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INVALIDSOLICITEDATE = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INVALIDSOLICITEDATE);
    public static final ConfirmTransactionPaymentFDResponseReturnCodeList FAIL_INVALIDAUTHORIZATIONID = new ConfirmTransactionPaymentFDResponseReturnCodeList(_FAIL_INVALIDAUTHORIZATIONID);
    public java.lang.String getValue() { return _value_;}
    public static ConfirmTransactionPaymentFDResponseReturnCodeList fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ConfirmTransactionPaymentFDResponseReturnCodeList enumeration = (ConfirmTransactionPaymentFDResponseReturnCodeList)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ConfirmTransactionPaymentFDResponseReturnCodeList fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ConfirmTransactionPaymentFDResponseReturnCodeList.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDResponseReturnCodeList"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

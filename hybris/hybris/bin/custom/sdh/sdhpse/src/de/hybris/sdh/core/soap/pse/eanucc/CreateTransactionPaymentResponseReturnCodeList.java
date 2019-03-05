/**
 * CreateTransactionPaymentResponseReturnCodeList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class CreateTransactionPaymentResponseReturnCodeList implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CreateTransactionPaymentResponseReturnCodeList(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _SUCCESS = "SUCCESS";
    public static final java.lang.String _FAIL_ENTITYNOTEXISTSORDISABLED = "FAIL_ENTITYNOTEXISTSORDISABLED";
    public static final java.lang.String _FAIL_BANKNOTEXISTSORDISABLED = "FAIL_BANKNOTEXISTSORDISABLED";
    public static final java.lang.String _FAIL_SERVICENOTEXISTS = "FAIL_SERVICENOTEXISTS";
    public static final java.lang.String _FAIL_INVALIDAMOUNT = "FAIL_INVALIDAMOUNT";
    public static final java.lang.String _FAIL_INVALIDSOLICITDATE = "FAIL_INVALIDSOLICITDATE";
    public static final java.lang.String _FAIL_BANKUNREACHEABLE = "FAIL_BANKUNREACHEABLE";
    public static final java.lang.String _FAIL_NOTCONFIRMEDBYBANK = "FAIL_NOTCONFIRMEDBYBANK";
    public static final java.lang.String _FAIL_CANNOTGETCURRENTCYCLE = "FAIL_CANNOTGETCURRENTCYCLE";
    public static final java.lang.String _FAIL_ACCESSDENIED = "FAIL_ACCESSDENIED";
    public static final java.lang.String _FAIL_TIMEOUT = "FAIL_TIMEOUT";
    public static final java.lang.String _FAIL_DESCRIPTIONNOTFOUND = "FAIL_DESCRIPTIONNOTFOUND";
    public static final java.lang.String _FAIL_EXCEEDEDLIMIT = "FAIL_EXCEEDEDLIMIT";
    public static final java.lang.String _FAIL_TRANSACTIONNOTALLOWED = "FAIL_TRANSACTIONNOTALLOWED";
    public static final CreateTransactionPaymentResponseReturnCodeList SUCCESS = new CreateTransactionPaymentResponseReturnCodeList(_SUCCESS);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_ENTITYNOTEXISTSORDISABLED = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_ENTITYNOTEXISTSORDISABLED);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_BANKNOTEXISTSORDISABLED = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_BANKNOTEXISTSORDISABLED);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_SERVICENOTEXISTS = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_SERVICENOTEXISTS);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_INVALIDAMOUNT = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDAMOUNT);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_INVALIDSOLICITDATE = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_INVALIDSOLICITDATE);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_BANKUNREACHEABLE = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_BANKUNREACHEABLE);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_NOTCONFIRMEDBYBANK = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_NOTCONFIRMEDBYBANK);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_CANNOTGETCURRENTCYCLE = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_CANNOTGETCURRENTCYCLE);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_ACCESSDENIED = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_ACCESSDENIED);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_TIMEOUT = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_TIMEOUT);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_DESCRIPTIONNOTFOUND = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_DESCRIPTIONNOTFOUND);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_EXCEEDEDLIMIT = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_EXCEEDEDLIMIT);
    public static final CreateTransactionPaymentResponseReturnCodeList FAIL_TRANSACTIONNOTALLOWED = new CreateTransactionPaymentResponseReturnCodeList(_FAIL_TRANSACTIONNOTALLOWED);
    public java.lang.String getValue() { return _value_;}
    public static CreateTransactionPaymentResponseReturnCodeList fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CreateTransactionPaymentResponseReturnCodeList enumeration = (CreateTransactionPaymentResponseReturnCodeList)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CreateTransactionPaymentResponseReturnCodeList fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CreateTransactionPaymentResponseReturnCodeList.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentResponseReturnCodeList"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

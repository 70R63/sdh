/**
 * CreateTransactionPaymentMultiCreditResponseReturnCodeList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class CreateTransactionPaymentMultiCreditResponseReturnCodeList implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CreateTransactionPaymentMultiCreditResponseReturnCodeList(java.lang.String value) {
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
    public static final java.lang.String _FAIL_ERRORINCREDITS = "FAIL_ERRORINCREDITS";
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList SUCCESS = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_SUCCESS);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_ENTITYNOTEXISTSORDISABLED = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_ENTITYNOTEXISTSORDISABLED);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_BANKNOTEXISTSORDISABLED = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_BANKNOTEXISTSORDISABLED);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_SERVICENOTEXISTS = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_SERVICENOTEXISTS);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_INVALIDAMOUNT = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_INVALIDAMOUNT);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_INVALIDSOLICITDATE = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_INVALIDSOLICITDATE);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_BANKUNREACHEABLE = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_BANKUNREACHEABLE);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_NOTCONFIRMEDBYBANK = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_NOTCONFIRMEDBYBANK);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_CANNOTGETCURRENTCYCLE = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_CANNOTGETCURRENTCYCLE);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_ACCESSDENIED = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_ACCESSDENIED);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_TIMEOUT = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_TIMEOUT);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_DESCRIPTIONNOTFOUND = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_DESCRIPTIONNOTFOUND);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_EXCEEDEDLIMIT = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_EXCEEDEDLIMIT);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_TRANSACTIONNOTALLOWED = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_TRANSACTIONNOTALLOWED);
    public static final CreateTransactionPaymentMultiCreditResponseReturnCodeList FAIL_ERRORINCREDITS = new CreateTransactionPaymentMultiCreditResponseReturnCodeList(_FAIL_ERRORINCREDITS);
    public java.lang.String getValue() { return _value_;}
    public static CreateTransactionPaymentMultiCreditResponseReturnCodeList fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CreateTransactionPaymentMultiCreditResponseReturnCodeList enumeration = (CreateTransactionPaymentMultiCreditResponseReturnCodeList)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CreateTransactionPaymentMultiCreditResponseReturnCodeList fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CreateTransactionPaymentMultiCreditResponseReturnCodeList.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentMultiCreditResponseReturnCodeList"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

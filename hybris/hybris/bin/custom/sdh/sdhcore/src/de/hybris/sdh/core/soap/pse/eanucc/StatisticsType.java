/**
 * StatisticsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class StatisticsType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected StatisticsType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _WebServiceCallsNumber = "WebServiceCallsNumber";
    public static final java.lang.String _WebServiceCallsAverageDuration = "WebServiceCallsAverageDuration";
    public static final java.lang.String _TransactionsSolvedByMonitor = "TransactionsSolvedByMonitor";
    public static final java.lang.String _TransactionsSolvedByConfirmTransactionPayment = "TransactionsSolvedByConfirmTransactionPayment";
    public static final java.lang.String _SequentialFailuresInInitBankPayment = "SequentialFailuresInInitBankPayment";
    public static final java.lang.String _TransactionsNotAuthorizedByCause = "TransactionsNotAuthorizedByCause";
    public static final StatisticsType WebServiceCallsNumber = new StatisticsType(_WebServiceCallsNumber);
    public static final StatisticsType WebServiceCallsAverageDuration = new StatisticsType(_WebServiceCallsAverageDuration);
    public static final StatisticsType TransactionsSolvedByMonitor = new StatisticsType(_TransactionsSolvedByMonitor);
    public static final StatisticsType TransactionsSolvedByConfirmTransactionPayment = new StatisticsType(_TransactionsSolvedByConfirmTransactionPayment);
    public static final StatisticsType SequentialFailuresInInitBankPayment = new StatisticsType(_SequentialFailuresInInitBankPayment);
    public static final StatisticsType TransactionsNotAuthorizedByCause = new StatisticsType(_TransactionsNotAuthorizedByCause);
    public java.lang.String getValue() { return _value_;}
    public static StatisticsType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        StatisticsType enumeration = (StatisticsType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static StatisticsType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(StatisticsType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "statisticsType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

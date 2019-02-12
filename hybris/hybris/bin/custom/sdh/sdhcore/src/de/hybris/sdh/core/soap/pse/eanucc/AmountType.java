/**
 * AmountType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class AmountType  implements java.io.Serializable, org.apache.axis.encoding.SimpleType {
    private java.math.BigDecimal _value;

    private java.lang.String currencyISOcode;  // attribute

    public AmountType() {
    }

    // Simple Types must have a String constructor
    public AmountType(java.math.BigDecimal _value) {
        this._value = _value;
    }
    public AmountType(java.lang.String _value) {
        this._value = new java.math.BigDecimal(_value);
    }

    // Simple Types must have a toString for serializing the value
    public java.lang.String toString() {
        return _value == null ? null : _value.toString();
    }


    /**
     * Gets the _value value for this AmountType.
     * 
     * @return _value
     */
    public java.math.BigDecimal get_value() {
        return _value;
    }


    /**
     * Sets the _value value for this AmountType.
     * 
     * @param _value
     */
    public void set_value(java.math.BigDecimal _value) {
        this._value = _value;
    }


    /**
     * Gets the currencyISOcode value for this AmountType.
     * 
     * @return currencyISOcode
     */
    public java.lang.String getCurrencyISOcode() {
        return currencyISOcode;
    }


    /**
     * Sets the currencyISOcode value for this AmountType.
     * 
     * @param currencyISOcode
     */
    public void setCurrencyISOcode(java.lang.String currencyISOcode) {
        this.currencyISOcode = currencyISOcode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AmountType)) return false;
        AmountType other = (AmountType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._value==null && other.get_value()==null) || 
             (this._value!=null &&
              this._value.equals(other.get_value()))) &&
            ((this.currencyISOcode==null && other.getCurrencyISOcode()==null) || 
             (this.currencyISOcode!=null &&
              this.currencyISOcode.equals(other.getCurrencyISOcode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (get_value() != null) {
            _hashCode += get_value().hashCode();
        }
        if (getCurrencyISOcode() != null) {
            _hashCode += getCurrencyISOcode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AmountType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "AmountType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currencyISOcode");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "currencyISOcode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "_value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.SimpleSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.SimpleDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

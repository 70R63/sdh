/**
 * GetTransactionTotalsResponseTotalType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class GetTransactionTotalsResponseTotalType  implements java.io.Serializable {
    private de.hybris.sdh.core.soap.pse.eanucc.TotalTypeList type;

    private int quantity;

    private de.hybris.sdh.core.soap.pse.eanucc.AmountType amount;

    public GetTransactionTotalsResponseTotalType() {
    }

    public GetTransactionTotalsResponseTotalType(
           de.hybris.sdh.core.soap.pse.eanucc.TotalTypeList type,
           int quantity,
           de.hybris.sdh.core.soap.pse.eanucc.AmountType amount) {
           this.type = type;
           this.quantity = quantity;
           this.amount = amount;
    }


    /**
     * Gets the type value for this GetTransactionTotalsResponseTotalType.
     * 
     * @return type
     */
    public de.hybris.sdh.core.soap.pse.eanucc.TotalTypeList getType() {
        return type;
    }


    /**
     * Sets the type value for this GetTransactionTotalsResponseTotalType.
     * 
     * @param type
     */
    public void setType(de.hybris.sdh.core.soap.pse.eanucc.TotalTypeList type) {
        this.type = type;
    }


    /**
     * Gets the quantity value for this GetTransactionTotalsResponseTotalType.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this GetTransactionTotalsResponseTotalType.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the amount value for this GetTransactionTotalsResponseTotalType.
     * 
     * @return amount
     */
    public de.hybris.sdh.core.soap.pse.eanucc.AmountType getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this GetTransactionTotalsResponseTotalType.
     * 
     * @param amount
     */
    public void setAmount(de.hybris.sdh.core.soap.pse.eanucc.AmountType amount) {
        this.amount = amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTransactionTotalsResponseTotalType)) return false;
        GetTransactionTotalsResponseTotalType other = (GetTransactionTotalsResponseTotalType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            this.quantity == other.getQuantity() &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount())));
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        _hashCode += getQuantity();
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTransactionTotalsResponseTotalType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotalsResponseTotalType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "TotalTypeList"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "quantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "AmountType"));
        elemField.setMinOccurs(0);
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
          new  org.apache.axis.encoding.ser.BeanSerializer(
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
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

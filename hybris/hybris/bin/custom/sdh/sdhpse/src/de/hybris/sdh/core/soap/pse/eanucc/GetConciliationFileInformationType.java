/**
 * GetConciliationFileInformationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class GetConciliationFileInformationType  implements java.io.Serializable {
    private java.lang.String entityOrBankCode;

    private java.util.Date date;

    private java.lang.String cycle;

    public GetConciliationFileInformationType() {
    }

    public GetConciliationFileInformationType(
           java.lang.String entityOrBankCode,
           java.util.Date date,
           java.lang.String cycle) {
           this.entityOrBankCode = entityOrBankCode;
           this.date = date;
           this.cycle = cycle;
    }


    /**
     * Gets the entityOrBankCode value for this GetConciliationFileInformationType.
     * 
     * @return entityOrBankCode
     */
    public java.lang.String getEntityOrBankCode() {
        return entityOrBankCode;
    }


    /**
     * Sets the entityOrBankCode value for this GetConciliationFileInformationType.
     * 
     * @param entityOrBankCode
     */
    public void setEntityOrBankCode(java.lang.String entityOrBankCode) {
        this.entityOrBankCode = entityOrBankCode;
    }


    /**
     * Gets the date value for this GetConciliationFileInformationType.
     * 
     * @return date
     */
    public java.util.Date getDate() {
        return date;
    }


    /**
     * Sets the date value for this GetConciliationFileInformationType.
     * 
     * @param date
     */
    public void setDate(java.util.Date date) {
        this.date = date;
    }


    /**
     * Gets the cycle value for this GetConciliationFileInformationType.
     * 
     * @return cycle
     */
    public java.lang.String getCycle() {
        return cycle;
    }


    /**
     * Sets the cycle value for this GetConciliationFileInformationType.
     * 
     * @param cycle
     */
    public void setCycle(java.lang.String cycle) {
        this.cycle = cycle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetConciliationFileInformationType)) return false;
        GetConciliationFileInformationType other = (GetConciliationFileInformationType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entityOrBankCode==null && other.getEntityOrBankCode()==null) || 
             (this.entityOrBankCode!=null &&
              this.entityOrBankCode.equals(other.getEntityOrBankCode()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.cycle==null && other.getCycle()==null) || 
             (this.cycle!=null &&
              this.cycle.equals(other.getCycle())));
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
        if (getEntityOrBankCode() != null) {
            _hashCode += getEntityOrBankCode().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getCycle() != null) {
            _hashCode += getCycle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetConciliationFileInformationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileInformationType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entityOrBankCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "entityOrBankCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cycle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "cycle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

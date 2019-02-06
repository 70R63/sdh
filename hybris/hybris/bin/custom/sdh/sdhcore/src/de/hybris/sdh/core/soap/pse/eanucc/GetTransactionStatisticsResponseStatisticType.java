/**
 * GetTransactionStatisticsResponseStatisticType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class GetTransactionStatisticsResponseStatisticType  implements java.io.Serializable {
    private java.lang.String label;

    private java.math.BigDecimal successCount;

    private java.math.BigDecimal errorCount;

    public GetTransactionStatisticsResponseStatisticType() {
    }

    public GetTransactionStatisticsResponseStatisticType(
           java.lang.String label,
           java.math.BigDecimal successCount,
           java.math.BigDecimal errorCount) {
           this.label = label;
           this.successCount = successCount;
           this.errorCount = errorCount;
    }


    /**
     * Gets the label value for this GetTransactionStatisticsResponseStatisticType.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this GetTransactionStatisticsResponseStatisticType.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the successCount value for this GetTransactionStatisticsResponseStatisticType.
     * 
     * @return successCount
     */
    public java.math.BigDecimal getSuccessCount() {
        return successCount;
    }


    /**
     * Sets the successCount value for this GetTransactionStatisticsResponseStatisticType.
     * 
     * @param successCount
     */
    public void setSuccessCount(java.math.BigDecimal successCount) {
        this.successCount = successCount;
    }


    /**
     * Gets the errorCount value for this GetTransactionStatisticsResponseStatisticType.
     * 
     * @return errorCount
     */
    public java.math.BigDecimal getErrorCount() {
        return errorCount;
    }


    /**
     * Sets the errorCount value for this GetTransactionStatisticsResponseStatisticType.
     * 
     * @param errorCount
     */
    public void setErrorCount(java.math.BigDecimal errorCount) {
        this.errorCount = errorCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTransactionStatisticsResponseStatisticType)) return false;
        GetTransactionStatisticsResponseStatisticType other = (GetTransactionStatisticsResponseStatisticType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.successCount==null && other.getSuccessCount()==null) || 
             (this.successCount!=null &&
              this.successCount.equals(other.getSuccessCount()))) &&
            ((this.errorCount==null && other.getErrorCount()==null) || 
             (this.errorCount!=null &&
              this.errorCount.equals(other.getErrorCount())));
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
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getSuccessCount() != null) {
            _hashCode += getSuccessCount().hashCode();
        }
        if (getErrorCount() != null) {
            _hashCode += getErrorCount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTransactionStatisticsResponseStatisticType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsResponseStatisticType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("successCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "successCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "errorCount"));
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

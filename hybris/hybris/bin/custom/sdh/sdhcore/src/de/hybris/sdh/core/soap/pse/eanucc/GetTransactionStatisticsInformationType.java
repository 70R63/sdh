/**
 * GetTransactionStatisticsInformationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class GetTransactionStatisticsInformationType  implements java.io.Serializable {
    private java.lang.String bankCode;

    private de.hybris.sdh.core.soap.pse.eanucc.StatisticsType type;

    private de.hybris.sdh.core.soap.pse.eanucc.StatisticsPeriodType periodType;

    private java.util.Calendar startDate;

    private java.util.Calendar endDate;

    private java.lang.String parameter;

    public GetTransactionStatisticsInformationType() {
    }

    public GetTransactionStatisticsInformationType(
           java.lang.String bankCode,
           de.hybris.sdh.core.soap.pse.eanucc.StatisticsType type,
           de.hybris.sdh.core.soap.pse.eanucc.StatisticsPeriodType periodType,
           java.util.Calendar startDate,
           java.util.Calendar endDate,
           java.lang.String parameter) {
           this.bankCode = bankCode;
           this.type = type;
           this.periodType = periodType;
           this.startDate = startDate;
           this.endDate = endDate;
           this.parameter = parameter;
    }


    /**
     * Gets the bankCode value for this GetTransactionStatisticsInformationType.
     * 
     * @return bankCode
     */
    public java.lang.String getBankCode() {
        return bankCode;
    }


    /**
     * Sets the bankCode value for this GetTransactionStatisticsInformationType.
     * 
     * @param bankCode
     */
    public void setBankCode(java.lang.String bankCode) {
        this.bankCode = bankCode;
    }


    /**
     * Gets the type value for this GetTransactionStatisticsInformationType.
     * 
     * @return type
     */
    public de.hybris.sdh.core.soap.pse.eanucc.StatisticsType getType() {
        return type;
    }


    /**
     * Sets the type value for this GetTransactionStatisticsInformationType.
     * 
     * @param type
     */
    public void setType(de.hybris.sdh.core.soap.pse.eanucc.StatisticsType type) {
        this.type = type;
    }


    /**
     * Gets the periodType value for this GetTransactionStatisticsInformationType.
     * 
     * @return periodType
     */
    public de.hybris.sdh.core.soap.pse.eanucc.StatisticsPeriodType getPeriodType() {
        return periodType;
    }


    /**
     * Sets the periodType value for this GetTransactionStatisticsInformationType.
     * 
     * @param periodType
     */
    public void setPeriodType(de.hybris.sdh.core.soap.pse.eanucc.StatisticsPeriodType periodType) {
        this.periodType = periodType;
    }


    /**
     * Gets the startDate value for this GetTransactionStatisticsInformationType.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this GetTransactionStatisticsInformationType.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the endDate value for this GetTransactionStatisticsInformationType.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this GetTransactionStatisticsInformationType.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the parameter value for this GetTransactionStatisticsInformationType.
     * 
     * @return parameter
     */
    public java.lang.String getParameter() {
        return parameter;
    }


    /**
     * Sets the parameter value for this GetTransactionStatisticsInformationType.
     * 
     * @param parameter
     */
    public void setParameter(java.lang.String parameter) {
        this.parameter = parameter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTransactionStatisticsInformationType)) return false;
        GetTransactionStatisticsInformationType other = (GetTransactionStatisticsInformationType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bankCode==null && other.getBankCode()==null) || 
             (this.bankCode!=null &&
              this.bankCode.equals(other.getBankCode()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.periodType==null && other.getPeriodType()==null) || 
             (this.periodType!=null &&
              this.periodType.equals(other.getPeriodType()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.parameter==null && other.getParameter()==null) || 
             (this.parameter!=null &&
              this.parameter.equals(other.getParameter())));
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
        if (getBankCode() != null) {
            _hashCode += getBankCode().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getPeriodType() != null) {
            _hashCode += getPeriodType().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getParameter() != null) {
            _hashCode += getParameter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTransactionStatisticsInformationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsInformationType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "bankCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "statisticsType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "periodType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "statisticsPeriodType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "parameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
